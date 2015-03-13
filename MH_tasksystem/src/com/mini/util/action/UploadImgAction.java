package com.mini.util.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ResultPath;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.util.ImageCompress;
import com.util.img.CutImgUtil;

/**
 * 
 * 上传图片操作action 主要用于图片上传操作
 * 
 * @author 左香勇
 * @since vmaque1.7
 * 
 */
@ResultPath("/")
public class UploadImgAction extends FrmAction {

    /************************ 上传相关属性 *********************************/
    // 封装上传文件域的属性
    private File uploadImg;
    // 封装上传文件类型的属性
    private String uploadImgContentType;
    // 封装上传文件名的属性
    private String uploadImgFileName;

    /************************ 截图相关属性 ********************************/
    // 封装截图距原图顶部属性
    private Integer top;
    // 封装截图距原图左侧属性
    private Integer left;
    // 封装截图长
    private Integer width;
    // 封装截图宽
    private Integer height;
    // 是否截图
    private boolean cut;

    /**
     * 
     * 上传图片方法
     * 
     * @author 左香勇 <br>
     *         2014-10-22
     * @update
     * @see UploadImgAction#uploadImage()
     * @since vmaque1.7
     */
    public void uploadImage() {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        FileOutputStream fos1 = null;
        FileInputStream fis1 = null;
        Calendar cal=Calendar.getInstance();//使用日历类
        int year=cal.get(Calendar.YEAR);//得到年
        int month=cal.get(Calendar.MONTH)+1;//得到月，因为从0开始的，所以要加1
        int day=cal.get(Calendar.DAY_OF_MONTH);//得到天
        String filePath = ServletActionContext.getServletContext().getRealPath("/uploadImg") + "/" + year + "/" + month + "/" + day + "/" ;
        boolean isdeleteImg = false;
        String deleteFileName = "";
        try {
            String filename = getUploadImgFileName();
            String fileType = filename.substring(filename.lastIndexOf("."), filename.length());// 获取文件后缀名
            if(fileType.toLowerCase().equals(".jpeg")){
                fileType = ".jpg";
            }
            String newFileName = System.currentTimeMillis() + fileType;
            deleteFileName = filePath + newFileName;
            
            File file = new File(filePath);
            //如果文件夹不存在则创建    
            if (!file.exists()  && !file .isDirectory()){
                file.mkdirs();
            } 
            
            fos = new FileOutputStream(filePath + "/" + newFileName);
            // 建立文件上传流
            fis = new FileInputStream(getUploadImg());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            //判断是否进行截图操作
            if(cut){
                CutImgUtil.cut(filePath+newFileName, top < 0 ? 0 : top, left < 0 ? 0 : left, width, height);
            }
            double daxiao = Double.parseDouble(String.format("%.1f", uploadImg.length() / 1024.0)); // 获取上传图片大小
            if (daxiao >= 1000) { // 图片大小超过400kb开始转换格式 压缩
                ImageCompress.imageCompress(filePath, newFileName, newFileName, 0.2f);
            } else if (daxiao >= 500 && daxiao < 1000){
                ImageCompress.imageCompress(filePath, newFileName, newFileName, 0.3f);
            } else if (daxiao >= 400 && daxiao < 500){
                ImageCompress.imageCompress(filePath, newFileName, newFileName, 0.4f);
            }
            // 写入上传的图片
            response.getWriter().write(  "/" + "uploadImg" + "/" + year + "/" + month + "/"  + day + "/" + newFileName);
        } catch (Exception e) {
            try {
                response.getWriter().write("1");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            close(fos, fis);
            close(fos1, fis1);
        }

        //删除原图片
        if(isdeleteImg){
            File oldfile = new File(deleteFileName);
            oldfile.delete();
        }
    }

    /**
     * 
     * 〈关闭文件流〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-10-22
     * @update
     * @see UploadImgAction#close()
     * @since vmaque1.7
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

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public boolean getCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }

}
