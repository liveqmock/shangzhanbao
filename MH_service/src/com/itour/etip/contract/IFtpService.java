package com.itour.etip.contract;

import java.io.Serializable;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.kit.exception.ETIPException;

/**
 * 网络通信服务工具
 * 
 * @author lishan
 */
@WebService
public interface IFtpService {
	/**
	 * 当文件已经保存在调用者磁盘上时使用此方法，url为绝对路径.全部采用二进制方式传送文件
	 * 
	 * @param url：文件绝对路径
	 * @return 返回ftp上的路径
	 * @throws ETIPException
	 */
	public String uploadFile(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "url")
	String url, @WebParam(name = "rootPath")
	String rootPath);

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
	public void getFile(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "url")
	String url, @WebParam(name = "outFileName")
	String outFileName);

	/**
	 * 删除指定目录下的文件
	 * 
	 * @param fileName
	 *            完整文件名，包含目录。如：/images/2009/05/20/20090620121212123.jpg
	 * @throws ETIPException
	 */
	public void deleteFile(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "fileName")
	String fileName);

	/**
	 * 进入给定目录，如果不存在则创建
	 * 
	 * @param path
	 *            如果目录不存在则自动建
	 * @throws ETIPException
	 */
	public void cdMkDir(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "path")
	String path);

	/**
	 * ftp cd 命令
	 * 
	 * @param path
	 *            跳转的目录名
	 * @throws ETIPException
	 */
	public void cd(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "path")
	String path);

	/**
	 * 在ftp服务器上新建目录
	 * 
	 * @param path
	 *            需要建的目录名
	 * @return
	 * @throws ETIPException
	 */
	public boolean mkdir(@WebParam(name = "ftpID")
	String ftpID, @WebParam(name = "path")
	String path);

	/**
	 * 打开Ftp服务器
	 * 
	 * @param server
	 * @param port
	 * @param user
	 * @param password
	 * @return ftpID,因为需要发布为web服务器，支持多路调用，此处需要返回唯一id.
	 */
	public String openServer(@WebParam(name = "server")
	String server, @WebParam(name = "port")
	int port, @WebParam(name = "user")
	String user, @WebParam(name = "password")
	String password);

	/**
	 * 关闭Ftp服务器
	 * 
	 */
	public void closeServer(@WebParam(name = "ftpID")
	String ftpID);
	
	/**
	 * 向博客林写数据
	 * @param key 唯一键值
	 * @param obj 存入的数据
	 */
	public boolean saveToBerkeley(@WebParam(name = "key")Serializable key,@WebParam(name = "value")Serializable value);
	
	
	public boolean saveStringToBerkeley(String key,String value);
	
	public String getStringFromBerkeley(String key);
	
}
