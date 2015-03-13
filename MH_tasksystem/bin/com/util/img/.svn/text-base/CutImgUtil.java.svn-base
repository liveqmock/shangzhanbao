package com.util.img;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

/**
 * 
 * 裁剪图片公共方法
 *
 * @author 左香勇
 * @since vmaque1.7
 */
public class CutImgUtil {

    /**
     * 对图片裁剪，并把裁剪完新图片保存 。
     * 
     * @param srcpath 源图片路径
     * @throws IOException
     */
    public static void cut(String srcpath, double x, double y, double w, double h) throws IOException {
        FileInputStream is = null;
        ImageInputStream iis = null;
        try {
            // 获取文件的后缀名
            String postFix = getPostfix(srcpath);
            
            Image img = Toolkit.getDefaultToolkit().getImage(srcpath);
            BufferedImage biimg = toBufferedImage(img);
            ImageIO.write(biimg, postFix, new File(srcpath));
            
            // 读取图片文件
            is = new FileInputStream(srcpath);

            Iterator<ImageReader> it = getImageReadersByFormatName(postFix.equals("jpg") ? 0 : 1);
            ImageReader reader = it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(is);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rect = new Rectangle((int) x, (int) y, (int) w, (int) h);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);

            // 保存新图片
            ImageIO.write(bi, postFix, new File(srcpath));
        } finally {
            if (is != null)
                is.close();
            if (iis != null)
                iis.close();
        }
    }

    /**
     * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
     * 
     * @param postFix 文件的后缀名
     * @return
     */
    public static Iterator<ImageReader> getImageReadersByFormatName(int postFix) {
        switch (postFix) {
            case 0:
                return ImageIO.getImageReadersByFormatName("jpg");
            case 1:
                return ImageIO.getImageReadersByFormatName("png");
            default:
                return ImageIO.getImageReadersByFormatName("jpg");
        }
    }


    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
         }
     
        // This code ensures that all the pixels in the image are loaded
         image = new ImageIcon(image).getImage();
     
        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        //boolean hasAlpha = hasAlpha(image);
     
        // Create a buffered image with a format that's compatible with the screen
         BufferedImage bimage = null;
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
           /* if (hasAlpha) {
                 transparency = Transparency.BITMASK;
             }*/
     
            // Create the buffered image
             GraphicsDevice gs = ge.getDefaultScreenDevice();
             GraphicsConfiguration gc = gs.getDefaultConfiguration();
             bimage = gc.createCompatibleImage(
                 image.getWidth(null), image.getHeight(null), transparency);
         } catch (HeadlessException e) {
            // The system does not have a screen
         }
     
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            //int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
            /*if (hasAlpha) {
                 type = BufferedImage.TYPE_INT_ARGB;
             }*/
             bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
         }
     
        // Copy image to buffered image
         Graphics g = bimage.createGraphics();
     
        // Paint the image onto the buffered image
         g.drawImage(image, 0, 0, null);
         g.dispose();
     
        return bimage;
     }

    
    
    /**
     * 获取图片宽度
     * 
     * @param file 图片文件
     * @return 宽度
     */
    public static int getImgWidth(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int ret = -1;
        try {
            is = new FileInputStream(file);
            src = javax.imageio.ImageIO.read(is);
            ret = src.getWidth(null); // 得到源图宽
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 获取图片高度
     * 
     * @param file 图片文件
     * @return 高度
     */
    public static int getImgHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int ret = -1;
        try {
            is = new FileInputStream(file);
            src = javax.imageio.ImageIO.read(is);
            ret = src.getHeight(null); // 得到源图高
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 获取inputFilePath的后缀名，如："e:/test.pptx"的后缀名为："pptx"<br>
     * 
     * @param inputFilePath
     * @return
     */
    public static String getPostfix(String inputFilePath) {
        return inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1).toLowerCase();
    }
}
