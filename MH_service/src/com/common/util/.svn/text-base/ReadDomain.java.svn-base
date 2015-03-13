package com.common.util;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.common.util.ResouceUtil;

public class ReadDomain {
    
    public static final String fileName = "domain.properties";
    public static final String REAL_PATH = ServletActionContext.getServletContext().getRealPath("/").replaceAll("\\"+File.separator, "/");
    public static final String PATH = ResouceUtil.getProperty(fileName, "path");
    public static final String CODEIMGPATH = ResouceUtil.getProperty(fileName, "codeImgPath");
    /**
     * 读取配置文件
     * @return
     */
    public static  String readProperties() {
		String path = PATH;
		return  path;   
	}
    
    /**
     * 读取二维码地址
     * @return
     */
    public static  String readCodeImgPath() {
        String path = CODEIMGPATH;
        return  path;   
    }
}
