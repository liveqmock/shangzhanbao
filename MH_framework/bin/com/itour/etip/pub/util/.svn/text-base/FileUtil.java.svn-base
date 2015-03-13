package com.itour.etip.pub.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: FileUtil.java
 * @Package utils.file
 * @Description:通用读写文件工具类
 * @author 左香勇
 * @date 2014-6-9 9:42
 */
public class FileUtil {

	/**
	 * 判断文件是否存在
	 */
	public static boolean fexists(String path, String fileName) {
		// 判断c:/test/ 是否是/结尾
		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}
		File file = new File(path + fileName);

		return file.exists();

	}

	/**
	 * 判断文件是否存在
	 */
	public static String FileDir(String path, String fileName) {
		// 判断c:/test/ 是否是/结尾
		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}

		return path + fileName;

	}

	/**
	 * 读取指定文件内容 path:文件名（目录加文件名） 返回字符串
	 */
	public static String readFile(String path) {
		File filename = new File(path);
		String read;
		FileReader fileread;
		BufferedReader bufread = null;
		String readStr = "";
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {// 判断是否为空
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// System.out.println("未找到文件" + filename);
		} finally {
			try {
				bufread.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return readStr;
	}
	/**
	 * 读取指定文件内容 path:文件名（目录加文件名） 返回字符串  设置编码
	 * @param path
	 * @return
	 */
	public static String readFileByCode(String path) {
		File filename = new File(path);
		String read;
		FileInputStream fs;
		BufferedReader bufread = null;
		String readStr = "";
		try {
			fs = new FileInputStream(filename);
			bufread = new BufferedReader(new InputStreamReader(fs, "UTF-8"));
			while ((read = bufread.readLine()) != null) {// 判断是否为空
			readStr = readStr + read + "\r\n";
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bufread.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return readStr;
	}

	/**
	 * 读取指定文件内容 path:文件名（目录加文件名） 返回集合
	 */
	public static List<String> readFileTolist(String path) {
		File filename = new File(path);
		String read;
		FileReader fileread;
		BufferedReader bufread = null;
		List<String> list = new ArrayList<String>();
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {// 判断是否为空
					list.add(read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// System.out.println("未找到文件" + filename);
		} finally {
			try {
				bufread.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * 读取指定文件内容 path:文件 返回集合
	 */
	public static List<String> readFileTolist(File filename) {
		String read;
		FileReader fileread;
		BufferedReader bufread = null;
		List<String> list = new ArrayList<String>();
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {// 判断是否为空
					list.add(read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bufread.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// System.out.println("未找到文件" + filename);
		}

		return list;
	}

	/**
	 * 追加内容到文件末尾 path:指定文件路径 newStr:要追加的内容
	 */
	public static void writeFile(String path, String newStr) {
		FileOutputStream fileoutput = null;
		OutputStreamWriter output = null;
		BufferedWriter out = null;
		try {
			fileoutput = new FileOutputStream(path, true);
			output = new OutputStreamWriter(fileoutput);
			out = new BufferedWriter(output);
			if (System.getProperty("os.name").equals("Linux")) {// 判断系统是Linux还是windows
				out.write("\n" + newStr);
			} else {
				out.write("\r\n" + newStr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				output.close();
				fileoutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取指定文件夹下的所有文件（不包括子文件夹中的文件）
	 */
	public static List<File> getFileList(String path) {
		List<File> fileInfo = new ArrayList<File>();
		File root = new File(path);
		File[] files = root.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && pathname.isHidden()) { // 去掉隐藏文件夹
					return false;
				}

				if (pathname.isFile() && pathname.isHidden()) {// 去掉隐藏文件
					return false;
				}
				return true;
			}
		});

		for (File file : files) {// 逐个遍历文件
			if (!file.isDirectory()) { // 判断是否是文件夹
				fileInfo.add(file); // 如果不是文件夹，则添加入文件列表
			}
		}

		return fileInfo;
	}

	/**
	 * 获取指定文件夹下的所有文件和文件夹
	 * 
	 * @param path
	 * @return
	 */
	public static List<File> getFileList2(String path) {
		List<File> fileInfo = new ArrayList<File>();
		File root = new File(path);
		File[] files = root.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && pathname.isHidden()) { // 去掉隐藏文件夹
					return false;
				}

				if (pathname.isFile() && pathname.isHidden()) {// 去掉隐藏文件
					return false;
				}
				return true;
			}
		});

		for (File file : files) {// 逐个遍历文件
			fileInfo.add(file); // 添加入文件列表
		}

		return fileInfo;
	}

	/**
	 * 获取指定文件夹下的所有文件（包括子文件夹中的文件）
	 */
	public static List<File> getFileAllList(String path) {
		List<File> fileInfo = new ArrayList<File>();
		File root = new File(path);
		File[] files = root.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				if (pathname.isDirectory() && pathname.isHidden()) { // 去掉隐藏文件夹
					return false;
				}

				if (pathname.isFile() && pathname.isHidden()) {// 去掉隐藏文件
					return false;
				}
				return true;
			}
		});

		for (File file : files) {// 逐个遍历文件
			if (file.isDirectory()) { // 如果是文件夹，则进一步遍历，属于递归算法
				List<File> ff = getFileAllList(file.getPath());
				fileInfo.addAll(ff);
			} else {
				fileInfo.add(file); // 如果不是文件夹，则添加入文件列表
			}
		}

		return fileInfo;
	}
	
	/**
	 * 获取指定文件夹下的所有文件（包括子文件夹中的文件）
	 */
	public static List<File> getFileAllList(String path,FileFilter fileFilter) {
		List<File> fileInfo = new ArrayList<File>();
		File root = new File(path);
		File[] files = root.listFiles(fileFilter);
		for (File file : files) {// 逐个遍历文件
			if (file.isDirectory()) { // 如果是文件夹，则进一步遍历，属于递归算法
				List<File> ff = getFileAllList(file.getPath());
				fileInfo.addAll(ff);
			} else {
				fileInfo.add(file); // 如果不是文件夹，则添加入文件列表
			}
		}
		List<File> reMoveList = new ArrayList<File>();
		if(fileInfo!=null)for(File f : fileInfo){
			boolean isAccept = fileFilter.accept(f);
			if(!isAccept)
				reMoveList.add(f);
		}
		if(reMoveList.size()>0)
			fileInfo.removeAll(reMoveList);
		return fileInfo;
	}
	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return boolean
	 */
	public static void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		} catch (Error e) {
			// System.out.println("新建目录操作出错 ");
			e.printStackTrace();
		}
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @return boolean
	 */
	public static void newFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();
			myFile.close();
		} catch (Exception e) {
			// System.out.println("新建文件操作出错 ");
			e.printStackTrace();
		}

	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();
		} catch (Exception e) {
			// System.out.println("删除文件操作出错 ");
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹
	 * 
	 * @param filePathAndName
	 *            String 文件夹路径及名称 如c:/fqf
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			// System.out.println("删除文件夹操作出错 ");
			e.printStackTrace();

		}

	}
	/**
	* @Title: deleteFile 
	* @Description: 批量删除指定文件
	* @param @param filePath    设定文件 
	* @return void    返回类型 
	* @throws
	 */
    static public void deleteFile(String[] filePath)
    {
    	if(filePath!=null){
    		for(String fp : filePath){
    			delFile(fp);
    		}
    	}
    }
    /**
    * @Title: deleteFile 
    * @Description: 批量删除指定文件
    * @param @param files    设定文件 
    * @return void    返回类型 
    * @throws
     */
    static public void deleteFile(List<File> files){
    	if(files!=null){
    		for(File f : files){
    			f.delete();
    		}
    	}
    }
	/**
	 * 删除文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 */
	public static void delAllFile(String path) {
		if (path == null) {
			return;
		}
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + File.separator + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + File.separator + tempList[i]);// 再删除空文件夹
			}
		}
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath, String newPath) {
		InputStream inStream = null;
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				fs.flush();
				fs.close();
				inStream.close();
			}
		} catch (Exception e) {
			// System.out.println("复制单个文件操作出错 ");
			e.printStackTrace();

		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ File.separator + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + File.separator + file[i], newPath
							+ File.separator + file[i]);
				}
			}
		} catch (Exception e) {
			// System.out.println("复制整个文件夹内容操作出错 ");
			e.printStackTrace();

		}

	}
	
	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动文件夹到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf
	 * @param newPath
	 *            String 如：d:/fqf
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

	/**
	 * 
	 * @Title: chekPath
	 * @Description: TODO(判断路径是否以斜杠结尾，如果不是则添加，是则直接返回)
	 * @param path
	 * @return 设定文件
	 * @return String 返回类型
	 * @author JJL
	 * @throws
	 */
	public static String chekPath(String path) {
		if (!path.endsWith(File.separatorChar + "")) {
			path += File.separatorChar + "";
		}
		return path;
	}
	/**
	* @Title: catPath 
	* @Description: 将两个路径拼接在一起
	* @param @param rootPath
	* @param @param subPath
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String catPath(String rootPath,String subPath){
		if(rootPath!=null && subPath!=null){
			if(subPath.startsWith(File.separatorChar + ""))
				subPath = subPath.substring(0,subPath.length());
			return chekPath(rootPath)+subPath;
		}
		return "";
	}

	/**
	 * 
	 */

	public static boolean dirExists(String dir) {
		boolean flag = false;
		File file = new File(dir);
		if (!file.exists()) {
			flag = file.mkdirs();
		}
		return flag;
	}
	
	/**
	* @Title: makeDir 
	* @Description: 创建文件夹目录   add by 胡俊岩
	* @param @param path
	* @param @param forFile  true 时，dir 是一文件名
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	static public final boolean makeDir(String path,boolean forFile)
	{
		return makeDir(new File(path),forFile);
	}
	/**
	* @Title: makeDir 
	* @Description: 创建文件夹目录   add by 胡俊岩
	* @param @param f
	* @param @param forFile
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	static public final boolean makeDir(File f,boolean forFile)
	{
       if( !forFile )
       {
           if( f.exists() )
           {
               return f.isDirectory();
           }
           return f.mkdirs();
       }
       return makeDir( f.getParentFile(),false );
	}
	/**
	 * 
	 * @Title: Sort
	 * @Description: TODO(对数组进行循环移位比较，冒泡排序)
	 * @param @param arr
	 * @param @return 设定文件
	 * @return String 最大的字符串
	 * @author JJL
	 * @throws
	 */
	public static String Sort(String[] arr) {
		String s1, s2;
		int flag, y;

		for (int x = 0; x < arr.length; x++) {
			// 得出需要比较大小排序的字符串数量
			y = arr.length;
			for (int i = 0; i < y - 1; i++) {
				s1 = arr[i];
				s2 = arr[i + 1];
				// 比较字符串大小
				flag = s1.compareToIgnoreCase(s2);
				if (flag >= 0) {
					arr[i] = s2;
					arr[i + 1] = s1;
				}
			}
			y = y - 1;
		}
		return arr[(arr.length - 1)];
	}

	/**
	 * 返回指定扩展名的文件列表，以;隔开，如.jpg;.gif
	 * 
	 * @param ext
	 *            以;隔开的文件扩展名字符串 如.jpg;.gif
	 * @return
	 */
	public static FilenameFilter getFileExtensionFilterByExpStr(String exp) {
		final String[] expArr = exp.split(";");
		return new FilenameFilter() {
			public boolean accept(File file, String name) {
				boolean flag = false;
				for (int i = 0; i < expArr.length; i++) {
					if (name.endsWith(expArr[i]))
						flag = true;
				}
				return flag;
			}
		};
	}

	/**
	 * 分隔符替换 window下测试通过
	 * 
	 * @param path
	 * @return
	 */
	public static String separatorReplace(String path) {
		return path.replace("\\", "/");
	}

	/**
	 * 创建文件夹，如果文件夹存在则不进行创建。
	 * 
	 * @param path
	 * @throws Exception
	 */
	public static void createFolder(String path) {
		path = separatorReplace(path);
		File folder = new File(path);
		if (folder.isDirectory()) {
			return;
		}
		folder.mkdirs();
	}

/**
 * 新建文件
 * 
 * @param filePathAndName
 *            String 文件路径及名称 如c:/fqf.txt
 * @param fileContent
 *            String 文件内容
 * @return boolean
 */
public static void createFile(String filePathAndName, String fileContent) {

	try {
		String filePath = filePathAndName;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		/*if (!myFilePath.exists()) {*/
			myFilePath.createNewFile();
		/*}*/
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		String strContent = fileContent;
		myFile.println(strContent);
		resultFile.close();
		myFile.close();
	} catch (Exception e) {
		// System.out.println("新建文件操作出错 ");
		e.printStackTrace();
	}

}

}