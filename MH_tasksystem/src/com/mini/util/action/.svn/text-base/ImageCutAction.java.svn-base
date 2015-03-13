package com.mini.util.action;

import java.awt.Graphics;
import java.awt.Rectangle;
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

import org.apache.struts2.ServletActionContext;

import com.itour.etip.pub.frame.FrmAction;

public class ImageCutAction extends FrmAction {

    public void creatImage() throws IOException {

        double x = Double.valueOf(request.getParameter("x1"));
        double y = Double.valueOf(request.getParameter("y1"));
        double w = Double.valueOf(request.getParameter("w"));
        double h = Double.valueOf(request.getParameter("h"));

        double level = Double.valueOf(request.getParameter("z").equals("") ? "1" : request.getParameter("z"));

        String path = request.getParameter("p");// 文件路径

        String filePath = ServletActionContext.getServletContext().getRealPath(path);
        cut(filePath, x < 0 ? 0 : x, y < 0 ? 0 : y, w, h, level);
    }

    /**
     * 对图片裁剪，并把裁剪完新图片保存 。
     * 
     * @param srcpath 源图片路径
     * @param subpath 剪切图片存放路径
     * @throws IOException
     */
    public void cut(String srcpath, double x, double y, double w, double h, double level) throws IOException {
        if (level != 1.0) {
            zoomInImage(srcpath, level);
        }
        FileInputStream is = null;
        ImageInputStream iis = null;
        try {
            // 读取图片文件
            is = new FileInputStream(srcpath);

            // 获取文件的后缀名
            String postFix = getPostfix(srcpath);
        
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
    public Iterator<ImageReader> getImageReadersByFormatName(int postFix) {
        switch (postFix) {
            case 0:
                return ImageIO.getImageReadersByFormatName("jpg");
            case 1:
                return ImageIO.getImageReadersByFormatName("png");
            default:
                return ImageIO.getImageReadersByFormatName("jpg");
        }
    }

    /**
     * 
     * 〈放大图片〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-7-31
     * @update
     * @return [返回类型说明]
     */
    public void zoomInImage(String srcpath, double level) throws IOException {
        File file = new File(srcpath);

        // 获取文件的后缀名
        String postFix = getPostfix(srcpath);

        BufferedImage bi = ImageIO.read(file);
        int width = (int) (bi.getWidth() * level);
        int height = (int) (bi.getHeight() * level);
        BufferedImage newBi = new BufferedImage(width, height, bi.getType());
        Graphics g = newBi.getGraphics();
        g.drawImage(bi, 0, 0, width, height, null);
        g.dispose();
        // 保存新图片
        ImageIO.write(newBi, postFix, file);

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
    public String getPostfix(String inputFilePath) {
        return inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1);
    }

}
