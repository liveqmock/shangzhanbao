package com.itour.etip.common.util;

import com.itour.etip.contract.IFtpService;
import com.itour.etip.pub.frame.SpringContextHelper;

public class FileIOUtil {

	public static boolean saveStringToBerkeley(String key, String value) {
		IFtpService service = (IFtpService) SpringContextHelper.getBean("BerkeleyServiceClient");
		boolean rv = false;
		try {
			rv = service.saveStringToBerkeley(key, value);
		} catch (Throwable ex) {
			//ex.printStackTrace();
			System.out.println("执行Berkley错误!");
		}
		return rv;
	}

	public static String getStringFromBerkeley(String key) {
		IFtpService service = (IFtpService) SpringContextHelper.getBean("BerkeleyServiceClient");
		return service.getStringFromBerkeley(key);
	}

}
