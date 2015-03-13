/**
 * 文件服务器工具类。文件按类存放，比如web上传的动态图片（images），普通的文档（如doc、excel等）
 * images需要在web页面上显示，所以单独做为一类，ftp服务器需要与web服务器安装在同一台物理机器上
 * 注意：
 * 1、每个分类在ftp服务器上必须是根路径；
 * 2、上传的文件按照年、月、日自动建目录，文件名前面增加当前系统时间字符串"1242705577390_"
 *    例如：1242705577390_jetty.log
 * 3、uploadFile方法传回文件保存的url。
 * ==============================
 * 已经在iis、Serv-U（Window）、vsftp（linux）上进行过测试。
 */
package com.itour.etip.pub.kit.net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.ETIPException;

public class FtpUtil {

	/**
	 * ftp工具类，执行ftp操作
	 */
	private FtpClient ftpClient;

	public FtpUtil(){

	}
	
	/**
	 * 当文件已经保存在调用者磁盘上时使用此方法，url为绝对路径.全部采用二进制方式传送文件
	 * 
	 * @param url：文件绝对路径
	 * @return 返回ftp上的路径
	 * @throws ETIPException
	 */
	public String uploadeFile(String url, String rootPath) {
//		 检查文件服务器是否open
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		
		if(url==null||url.trim().length()==0){
			throw new ETIPError("FtpUploadFileUrlIsNotSet");
		}
		// 构造文件输入流
		url = url.replace('\\', '/');
		java.io.File file_in = new java.io.File(url);
		if (!file_in.exists() && file_in.length() == 0) {
			return null;
		}
		InputStream in;
		try {
			in = new FileInputStream(file_in);
		} catch (FileNotFoundException e) {
			throw new ETIPError("ftp_server_read_file_error", e);

		}
		// 构造文件名
		String fileName = url.substring(url.lastIndexOf("/") + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Calendar cal = Calendar.getInstance();
		Long time = System.currentTimeMillis();
		cal.setTimeInMillis(time);
		fileName = sdf.format(cal.getTime()) + "_" + fileName;
		return uploadFile(in, fileName, rootPath);

	}

	/**
	 * 给定输入流，直接保存到ftp服务器，全部采用二进制方式传送文件
	 * 
	 * @param in
	 *            要保存的文件的输入流
	 * @param fileName
	 *            要保存的文件名，不能为空，至少要给一个后缀名（例如.doc）
	 * @return
	 * @throws ETIPException
	 */
	public String uploadFile(InputStream in, String fileName, String rootPath) {

		// 检查文件服务器是否open
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		
		if(in==null){
			throw new ETIPError("FtpUploadFileInputStreamIsNull");
		}

		//
		if (rootPath != null && rootPath.length() > 1) {
			rootPath.replace('\\', '/');
			StringTokenizer s = new StringTokenizer(rootPath, "/");
			while (s.hasMoreElements()) {
				this.cdMkDir((String) s.nextElement());
			}
		}

		Calendar cal = Calendar.getInstance();
		Long time = System.currentTimeMillis();
		cal.setTimeInMillis(time);
		// 以下构造并近距上传路径
		TelnetOutputStream os = null;
		String year, month, day, hour;
		try {
			year = String.valueOf(cal.get(Calendar.YEAR));
			month = String.valueOf(cal.get(Calendar.MONTH) + 1);
			day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
			if (month.length() == 1) {
				month = "0" + month;
			}

			if (day.length() == 1) {
				day = "0" + day;
			}

			if (hour.length() == 1) {
				hour = "0" + hour;
			}
			this.cdMkDir(year);
			this.cdMkDir(month);
			this.cdMkDir(day);
			this.cdMkDir(hour);

			ftpClient.binary(); // 用2进制上传
			os = ftpClient.put(fileName);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = in.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (Exception e) {
			throw new ETIPError("ftp_upload_error", e);

		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (rootPath == null || rootPath.length() == 0
				|| rootPath.equalsIgnoreCase("/")) {
			return "\\" + year + "\\" + month + "\\" + day + "\\" + hour + "\\"
					+ fileName;
		} else {
			return "\\" + rootPath + "\\" + year + "\\" + month + "\\" + day
					+ "\\" + hour + "\\" + fileName;
		}
	}

	/**
	 * 给定ftp路径，输出给定文件。
	 * 
	 * @param url
	 * @param outFileName
	 *            需要取ftp服务器上读取的文件的文件名，包括路径名
	 *            例如：/2009/05/12/1242143343406_jetty.log
	 * @throws ETIPException
	 *             抛出code为"ftp_output_open_filestream_error"
	 *             或者"ftp_output_read_files_error"的异常
	 */
	public void getFile(String url, String outFileName) {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outFileName);
		} catch (FileNotFoundException e) {
			throw new ETIPError("ftp_output_open_filestream_error", e);

		}
		getFile(url, os);
	}

	/**
	 * 给定ftp路径，输出文件到已经打开的输出流中，并且关闭输出流
	 * 
	 * @param url
	 * @param os
	 *            用户指定的输出流，从ftp出文件直接放入输出流
	 * @throws ETIPException
	 */
	public void getFile(String url, OutputStream os) {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		InputStream in = null;
		try {
			in = ftpClient.get(url);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = in.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (IOException e) {
			// e.printStackTrace();
			throw new ETIPError("ftp_output_read_files_error", e);
			// throw ee;
		} finally {
			try {
				if (os != null)
					os.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 删除指定目录下的文件
	 * 
	 * @param fileName
	 *            完整文件名，包含目录。如：/images/2009/05/20/20090620121212123.jpg
	 * @throws ETIPException
	 */
	public void deleteFile(String fileName) {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		try {
			ftpClient.sendServer("dele /" + fileName + "\r\n");
		} catch (RuntimeException e) {
			throw new ETIPError("ftp_rm_file_error", e);
		}
	}

	/**
	 * 进入给定目录，如果不存在则创建
	 * 
	 * @param path
	 *            如果目录不存在则自动建
	 * @throws ETIPException
	 */
	public void cdMkDir(String path) {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		try {
			ftpClient.cd(path);
		} catch (Exception e) {
			if (e.getMessage().indexOf("No such file or directory") > 0
					|| e.getMessage().indexOf(" 550 ") > 0) {
				if (!this.Mkdir(path)) {
					throw new ETIPError("ftp_mkdir_error", e);
				}
				try {
					ftpClient.cd(path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * ftp cd 命令
	 * 
	 * @param path
	 *            跳转的目录名
	 * @throws ETIPException
	 */
	public void cd(String path) throws ETIPError {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		try {
			ftpClient.cd(path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ETIPError("ftp_cd_error", e);
		}
	}

	/**
	 * 在ftp服务器上新建目录
	 * 
	 * @param path
	 *            需要建的目录名
	 * @return
	 * @throws ETIPException
	 */
	public boolean Mkdir(String path) {
		if (!this.isOpen()) {
			throw new ETIPError("ftp_server_not_open");
		}
		try {
			ftpClient.sendServer("XMKD " + path + "\r\n");
			int reply = ftpClient.readServerResponse();
			if (reply > 199 && reply < 300) {
				System.out.println("ftp mkdir return code:" + reply);
				return true;
			}
		} catch (IOException e) {
			throw new ETIPError("ftp_mkdir_io_error", e);

		}
		return false;
	}

	
	public void openServer(String server, int port, String user, String password) {
		
		try {
			ftpClient = new FtpClient();
			ftpClient.openServer(server, port);
			ftpClient.login(user, password);
			
		} catch (IOException e) {
			// e.printStackTrace();
			throw new ETIPError("open_ftp_server_error", e);

		}
	}
	public void closeServer() {
		try {
			if (ftpClient != null) {
				ftpClient.closeServer();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	//判断当前ftp服务是否打开
	public boolean isOpen(){
		if(ftpClient==null) return false;
		if (!ftpClient.serverIsOpen()) return false;
		return true;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"com/itour/etip/pub/kit/net/test-applicationContext-ftp.xml");
			FtpUtil ftp = (FtpUtil) context.getBean("imageFtp");
			String fileUrl = ftp.uploadeFile("d:/jetty.log", "/");
			System.out.println("fileUrl:" + fileUrl);
			ftp.deleteFile(fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
