/**
 * com.gomai.common.action
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-11-13 LC
 *
 * Copyright (c) 2012, gomai
 */

package com.mini.util.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import com.common.util.UploadPath;

/**
 * 
 * @author LC
 * @version
 * @Date 2012-11-13 上午11:49:40
 */

public class DownImgAction extends CommonAction{

	
	/**
	 * 根据路径读取图片
	 * @throws IOException
	 * @return void
	 * @2012-11-15 上午9:18:53
	 */
	public void uploadImg()  {
		String path = request.getQueryString();
		BufferedInputStream in = null;
		OutputStream out = null;
		String[] str = path.split("/");
		String basepath = UploadPath.getPath(str[0]);
		
	
		path = path.replace(str[0], basepath);
		try {
			try {
				in = new BufferedInputStream(new FileInputStream(path));
			}catch (FileNotFoundException e) {
				in = new BufferedInputStream(new FileInputStream(basepath+"error.jpg"));
			}
			out = response.getOutputStream();
			byte[] buf = new byte[2048];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}				
			
		}catch (IOException e) {
//			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e2) {
			}
		}
	}
	
	public void index(){
		uploadImg();
	}

}
