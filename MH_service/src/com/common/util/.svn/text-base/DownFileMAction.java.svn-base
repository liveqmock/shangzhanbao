/**
 * com.gomai.common.action
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-21 		何大勇
 *
 * Copyright (c) 2012, gomai.
*/
/**
 * com.gomai.common.action
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-21 何大勇
 *
 * Copyright (c) 2012, gomai
*/


package com.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmAction;

/**
 *
 * @author   何大勇
 * @version  
 * @Date	 2012-12-21 上午11:05:59
 */
@Component("downFileMAction")
public class DownFileMAction extends FrmAction {

	public void down() throws IOException  {
		String path = request.getQueryString();
		OutputStream out = null;
		String[] str = path.split("/");
		String basepath = UploadPath.getPath(str[0]);
		path = path.replace(str[0], basepath);
		path.replace("#", ".");
		String name = path.substring(path.lastIndexOf("/")+1);
		File file = new File(path);
		if(!file.exists())
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print("<script charset='utf-8'>alert('文件已删除！');" +
					"history.back(-1);" +
					"</script>");
			return;
		}
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
		BufferedInputStream bis = null;
		try {
			 bis = new BufferedInputStream(new FileInputStream(
					file));
		} catch (FileNotFoundException e) {
			return ;
		}
		BufferedOutputStream bos = new BufferedOutputStream(out);
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(name,"UTF-8"));
			byte[] input = new byte[1024];
			boolean eof = false;
			while (!eof) {
				int length = bis.read(input);
				if (length == -1) {
					eof = true;
				} else {
					bos.write(input, 0, length);
				}
			}
		} catch (Exception e) {

		} finally {
			try {
				bos.flush();
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public void index() throws IOException{
		down();
	}
}

