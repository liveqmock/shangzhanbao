/**
 * com.gomai.common.util
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-2-20 		何大勇
 *
 * Copyright (c) 2013, gomai.
*/

package com.common.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.struts2.ServletActionContext;


/**
 *
 * @author   何大勇
 * @version  
 * @Date	 2013-2-20 下午02:54:12
 */
public class UploadPath {
	public static final String fileName = "uploadpath.properties";
	public static final String REAL_PATH = ServletActionContext.getServletContext().getRealPath("/").replaceAll("\\"+File.separator, "/");
	public static final String IMG_TEMP = REAL_PATH + ResouceUtil.getProperty(fileName, "img_temp");
	public static final String EDITOR_TEMP = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_temp");
	public static final String EDITOR_PRODUCT = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_product");
	public static final String EDITOR_PACKAGE = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_package");
	public static final String EDITOR_PRODUCTAPPLY = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_productapply");
	public static final String EDITOR_FILE = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_file");
	public static final String PRODUCT_ACCESSORIES = REAL_PATH + ResouceUtil.getProperty(fileName, "product_accessories");
	public static final String PACKAGE_ACCESSORIES = REAL_PATH + ResouceUtil.getProperty(fileName, "package_accessories");
	public static final String USER_ACCESSORIES = REAL_PATH + ResouceUtil.getProperty(fileName, "user_accessories");
	public static final String MAIL_TEMPLATE = REAL_PATH + ResouceUtil.getProperty(fileName, "mail_template");
	public static final String EDITOR_LETTER = REAL_PATH + ResouceUtil.getProperty(fileName, "editor_letter");
	public static final String SIGN_PATH = REAL_PATH + ResouceUtil.getProperty(fileName, "sign_path");//服务上传的文件的路径
	public static final String IMG_CLASS = REAL_PATH+ResouceUtil.getProperty(fileName, "img_class");
	//	public static final String IMG_TEMP = ResouceUtil.getProperty(fileName, "img_temp");
//	public static final String IMG_PRODUCT = ResouceUtil.getProperty(fileName, "img_product");
//	public static final String EDITOR_TEMP = ResouceUtil.getProperty(fileName, "editor_temp");
//	public static final String EDITOR_PRODUCT = ResouceUtil.getProperty(fileName, "editor_product");
//	public static final String EDITOR_FILE = ResouceUtil.getProperty(fileName, "editor_file");
//	public static final String PRODUCT_ACCESSORIES = ResouceUtil.getProperty(fileName, "product_accessories");
//	public static final String MAIL_TEMPLATE = ResouceUtil.getProperty(fileName, "mail_template");
	public static final String GOODSINFO_PATH = REAL_PATH + ResouceUtil.getProperty(fileName, "goodsinfo_path");
	public static Map<String, String> map ;
	public static String getPath(String pathName){
		try {
			return map.get(pathName);
		} catch (Exception e) {
			map = new HashMap<String, String>();
			Properties properties = ResouceUtil.getProperties(fileName);
			Set<Entry<Object, Object>> entries = properties.entrySet();
			Iterator<Entry<Object, Object>> iterator = entries.iterator();
			while(iterator.hasNext()){
				try {
					Entry<Object, Object> entry = iterator.next();
					map.put(entry.getKey().toString(), REAL_PATH + entry.getValue().toString());
					map.put(REAL_PATH + entry.getValue().toString() ,entry.getKey().toString());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return map.get(pathName);
		}
	}
}

