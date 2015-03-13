package com.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;


/**
 * 输出数据库中blob字段存储的图片
 * 
 * @author 文东
 * @see OutImgBlob
 * @since
 */
public class OutImgBlob{
    
    /**
     * 
     * 将数据库blob字段存储到本地服务器<br>
     * 
     * @author 文东 <br> 
     *		   2014-2-25
     * @update 
     * @param blob 图片
     * @param path 图片存储地址
     * @param fileName 图片名称
     * @return  图片存储的地址
     * @exception/throws 
     * @see   OutImgBlob#outImg(Blob, String, String)
     * @since 
     */
    public static void outImg(Blob blob, String path, String fileName) throws Exception {
            // 获取response和request对象
            if (blob != null) {
                // 实例化字节数组流，存储表中的照片字节
                InputStream inputStream = blob.getBinaryStream();
                // 将inputStream转换为图片流
                BufferedImage image = ImageIO.read(inputStream);
                // 获取服务器图片路径
                File file = new File(path);
                // 查看文件是否存在  若不存在则直接创建
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(path + File.separator + fileName + ".jpg");
                // 将图片以jpg的格式存储到地址文件中
                ImageIO.write(image, "JPG", file2);
                inputStream.close();
            }
    }

}
