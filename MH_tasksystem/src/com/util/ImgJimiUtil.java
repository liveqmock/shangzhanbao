package com.util;

import java.awt.image.ImageProducer;
import java.io.File;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiWriter;
import com.sun.jimi.core.options.JPGOptions;

public class ImgJimiUtil {

    public ImgJimiUtil() {
    };

    public static File convertToJPG(String sSourceImage, String sDestImage, double nQuality) {
        if (sSourceImage == null || sSourceImage.trim().equals("")) {
            System.out.println(" @> JimiImage.convertToJPG() : 要转换的源图像文件路径不能为空！");
            return null;
        }

        if (sDestImage == null || sDestImage.trim().equals("")) {
            sDestImage = sSourceImage.substring(0, sSourceImage.lastIndexOf(".")) + ".jpg";
        } else if (!sDestImage.endsWith(".jpg")) {
            sDestImage += ".jpg";
        }

        // ----------------------------------------------------------------------

        // 检查源图像文件
        File tSourceImageFile = new File(sSourceImage);
        if (!tSourceImageFile.exists()) {
            System.out.println(" @> JimiImage.convertToJPG() : 要转换的源图像文件路径不存在！");
            return null;
        } else if (!tSourceImageFile.canRead()) {
            System.out.println(" @> JimiImage.convertToJPG() : 要转换的源图像文件路径不可读！");
            return null;
        } else if (!tSourceImageFile.isFile()) {
            System.out.println(" @> JimiImage.convertToJPG() : 要转换的源图像路径不是一个有效的文件名！");
            return null;
        }
        tSourceImageFile = null;

        // ----------------------------------------------------------------------

        try {
            // long lRunStartTime = System.currentTimeMillis();
            JPGOptions tJPGOptions = new JPGOptions();
            if (nQuality < 0 || nQuality > 100) {
                tJPGOptions.setQuality(75);
            } else {
                tJPGOptions.setQuality((int) nQuality);
            }
            ImageProducer tImageProducer = Jimi.getImageProducer(sSourceImage);
            JimiWriter tJimiWriter = Jimi.createJimiWriter(sDestImage);
            tJimiWriter.setSource(tImageProducer);
            tJimiWriter.setOptions(tJPGOptions);
            tJimiWriter.putImage(sDestImage);
            tImageProducer = null;
            tJimiWriter = null;
            tJPGOptions = null;
        } catch (JimiException je) {
            System.out.println(" @> JimiImage.convertToJPG() : 转换图像格式发生异常！");
            je.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        File tDestImageFile = new File(sDestImage);
        return tDestImageFile;
    }

    public static File imgJimi(String sSourceImage, String sDestImage, double nQuality) {
        return ImgJimiUtil.convertToJPG(sSourceImage, sDestImage, nQuality);
    }
}
