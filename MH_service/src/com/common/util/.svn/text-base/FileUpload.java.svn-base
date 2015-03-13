package com.common.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传工具类
 * @author   LC
 * @version  
 * @Date	 2012 2012-11-13 下午2:34:49
 */
public class FileUpload {
	private static final int BUFFER_SIZE = 1 * 1024;
	
	/**
	 * 从源路径将文件复制到本地路径
	 * @param src  源径路
	 * @param dst  本地路径
	 * @throws Exception
	 * @return void
	 * @2012-11-13 下午2:35:40
	 */
	public static void copy(File src, File dst) throws Exception {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				File folder = new File(dst.getParent());
				if(!folder.exists()){
					folder.mkdirs();
				}
				dst.createNewFile();
				in = new BufferedInputStream(new FileInputStream(src));
				byte[] by = new byte[1024];
				out = new BufferedOutputStream(new FileOutputStream(dst));
				while (in.read(by) != -1) {
					out.write(by);
				}
				out.flush();
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String createFilename(String filename) {
		int length = filename.lastIndexOf(".");
		filename = new Date().getTime() + filename.substring(length);
		return filename;
	}
	
	/**
	 * 创建文件
	 * @param basepath 根路径
	 * @param key 关键文件夹，如企业ID
	 * @param fileName struts接受到的文件名
	 * @param src struts接受到的文件 若此字段为空，表示是为本编辑器，则把fileName 换成编辑器内容
	 * @return
	 * 		String
	 * @throws 
	 * @2013-2-22 上午10:12:06
	 */
	public static String createFile(String basepath, String key,String fileName, File src){
		String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String path = basepath + date + "/" + key + "/";
		File folder = new File(path);
		if(!folder.exists()){
			folder.mkdirs();
		}
		
		String realFileName = "";
		if(src!=null){
			realFileName = createFilename(fileName);
		}else{
			realFileName = new Date().getTime() + ".txt";
		}
		
		try {
			File target = new File(path+realFileName);
			target.createNewFile();
			if(src!=null){
				copy(src, target);
			}else{//文本编辑器
				//编辑器上传的文件在临时文件夹里，移动到内容文件夹
				String[] imgs = fileName.split("<img");
				for(int i=1;i<imgs.length;i++){
					String imgPath = imgs[i].substring(imgs[i].indexOf("src=\"")+5,imgs[i].indexOf("\"", imgs[i].indexOf("src=\"")+5));
					
					if(imgPath.indexOf("editor_temp/")==-1){
						continue;
					}
					
					imgPath = imgPath.substring(imgPath.indexOf("editor_temp/")).replaceAll("editor_temp/", UploadPath.EDITOR_TEMP);
					File img = new File(imgPath);
					File newImg = new File(basepath+date + "/" + key + "/" + imgPath.substring(imgPath.lastIndexOf("/")+1));
					newImg.createNewFile();
					copy(img, newImg);
					img.delete();
					fileName = fileName.replace("editor_temp",UploadPath.getPath(basepath));
				}
				writeStrToFile(target, fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date + "/" + key + "/" + realFileName;
	}

	public static void writeStrToFile(File file ,String string)
	{
		FileOutputStream fileOutputStream=null;
		OutputStreamWriter osw = null;
		try {
			fileOutputStream=new FileOutputStream(file,false);//覆盖
			osw = new OutputStreamWriter(fileOutputStream, "utf-8"); 
//			byte[] bs=string.getBytes();
			try {
				osw.write(string); 
		        osw.flush(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			}catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally{
			try {
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static String readFile(String path){
		StringBuffer buffer=new StringBuffer();
		File file=new File(path);
		if(!file.exists()){
			return "";
		}
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try{
			fis=new FileInputStream(file);
			isr=new InputStreamReader(fis, "utf-8");
			 br=new BufferedReader(isr);
			String html;
			while((html=br.readLine())!=null){
				buffer.append(html);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}
	
	public static byte[] createByte(File src) throws IOException {
		FileInputStream fo = new FileInputStream(src);
		ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
		byte[] b = new byte[BUFFER_SIZE];
		int n;
		try {
			while ((n = fo.read(b)) != -1) {
				out.write(b, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fo.close();
			out.close();
		}
		return out.toByteArray();
	}

	/**
	 * 获取图片的宽高
	 * @param imgurl
	 * @return int[]
	 * @2012-11-13 下午2:38:55
	 */
	@SuppressWarnings("unused")
	public static int[] returnImgWH(String imgurl) {
		File file = new File(imgurl);
		int[] wight = new int[2];
		if (file.exists()) {
			boolean imgwrong = false;
			BufferedImage bi = null;
			try {
				// 读取图片
				bi = javax.imageio.ImageIO.read(file);
				try {
					// 判断文件图片是否能正常显示,有些图片编码不正确
					int i = bi.getType();
					imgwrong = true;
				} catch (Exception e) {
					imgwrong = false;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (imgwrong) {
				wight[0] = bi.getWidth(); // 获得 宽度
				wight[1] = bi.getHeight(); // 获得 高度
			} else {
				wight = null;
			}
		} else {
			return null;
		}
		return wight;
	}
	
	/** 
     * 删除文件 
     *  
     * @param filePathAndName 
     *            文本文件完整绝对路径及文件名 
     * @return Boolean 成功删除返回true遭遇异常返回false 
     */  
    public static boolean delFile(String filePathAndName) {  
        boolean bea = false;  
        try {  
            String filePath = filePathAndName;  
            File myDelFile = new File(filePath);  
            if (myDelFile.exists()) {  
                myDelFile.delete();  
                bea = true;  
            } else {  
                bea = false;  
            }  
        } catch (Exception e) {  
        }  
        return bea;  
    }  
  
    /** 
     * 删除文件 
     *  
     * @param folderPath 
     *            文件夹完整绝对路径 
     * @return 
     */  
    public static void delFolder(String folderPath) {  
        try {  
            delAllFile(folderPath); // 删除完里面所有内容  
            String filePath = folderPath;  
            filePath = filePath.toString();  
            java.io.File myFilePath = new java.io.File(filePath);  
            myFilePath.delete(); // 删除空文件夹  
        } catch (Exception e) {  
        }  
    }
    
    /** 
     * 删除指定文件夹下所有文件 
     *  
     * @param path 
     *            文件夹完整绝对路径 
     * @return 
     * @return 
     */  
    public static boolean delAllFile(String path) {  
        boolean bea = false;  
        File file = new File(path);  
        if (!file.exists()) {  
            return bea;  
        }  
        if (!file.isDirectory()) {  
            return bea;  
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
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件  
                delFolder(path + "/" + tempList[i]);// 再删除空文件  
                bea = true;  
            }  
        }  
        return bea;  
    }
}
