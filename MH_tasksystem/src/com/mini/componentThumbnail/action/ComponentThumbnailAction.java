package com.mini.componentThumbnail.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ResultPath;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.componentThumbnail.facade.ComponentThumbnailFacade;
import com.util.ImgJimiUtil;

/**
 * 
 * 〈组件缩略图action层〉<br> 
 * 〈功能详细描述〉
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ResultPath("/")
public class ComponentThumbnailAction extends FrmAction {

	@Resource(name = "componentThumbnailFacade")
	private ComponentThumbnailFacade componentThumbnailFacade;
	
	// 封装上传文件域的属性
	private File uploadImg;
	// 封装上传文件类型的属性
	private String uploadImgContentType;
	// 封装上传文件名的属性
	private String uploadImgFileName;

	/**
	 * 
	 *〈添加组件缩略图信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-24
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addComponentThumbnail() {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        
        FileOutputStream fos1 = null;
        FileInputStream fis1 = null;
        String filePath = ServletActionContext.getServletContext().getRealPath("/file");
        try {
            String filename = getUploadImgFileName();
            String fileType = filename.substring(filename.lastIndexOf("."),filename.length());//获取文件后缀名
            String newFileName = System.currentTimeMillis()+fileType;
            fos = new FileOutputStream(filePath + File.separator + newFileName);
            // 建立文件上传流
            fis = new FileInputStream(getUploadImg());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            
            
            double daxiao= Double.parseDouble( String.format("%.1f",uploadImg.length()/1024.0));  //获取上传图片大小
           /* double scale=daxiao/400*10;*/
                String path=filePath + File.separator + newFileName;
                if(daxiao>=400){  //图片大小超过500kb开始转换格式 压缩
                String FileName =Long.toString(System.currentTimeMillis()); 
                File file=ImgJimiUtil.imgJimi(path,FileName, 30);   
                //写入压缩后的图片
                fos1 = new FileOutputStream(filePath + File.separator + file.getName());
                if(file!=null){
                    fis1 = new FileInputStream(file);
                    byte[] buffer1 = new byte[1024];
                    int len1 = 0;
                    while ((len1 = fis1.read(buffer1)) > 0) {
                        fos1.write(buffer1, 0, len1);
                    }
                }
                //如果图片大于500kb  页面写入压缩后的图片
                response.getWriter().write("file/"+file.getName());
            }else{
                //写入上传的图片
                response.getWriter().write("file/"+newFileName);
            }
           
            //componentThumbnailData.setComponentid(request.getParameter("componentid"));
            //componentThumbnailFacade.addThumbnail(componentThumbnailData, uploadImg);//调用添加组件缩略图方法添加图片到数据库
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        } finally {
            close(fos, fis);
            close(fos1, fis1);
        }

    }
	
	/**
	 * 
	 *〈关闭文件流〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-24
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	public File getUploadImg() {
		return uploadImg;
	}

	public void setUploadImg(File uploadImg) {
		this.uploadImg = uploadImg;
	}

	public String getUploadImgContentType() {
		return uploadImgContentType;
	}

	public void setUploadImgContentType(String uploadImgContentType) {
		this.uploadImgContentType = uploadImgContentType;
	}

	public String getUploadImgFileName() {
		return uploadImgFileName;
	}

	public void setUploadImgFileName(String uploadImgFileName) {
		this.uploadImgFileName = uploadImgFileName;
	}

}
