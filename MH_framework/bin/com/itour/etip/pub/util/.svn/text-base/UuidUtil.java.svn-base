package com.itour.etip.pub.util;

import java.util.UUID;

public class UuidUtil {
	
	/**
	 * 获得36位的uuid
	 * 如xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
	 * @return
	 */
	public static String getUUIDfor36(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	/**
	 * 获得32位的uuid
	 * 如xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 * @return
	 */
	public static String getUUIDfor32(){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
	
	/**
	 * 把传进来的32位uuid转换为36位的uuid
	 * 如果不是32位，那么直接返回
	 * 注意：
	 * 		这里只是把32位的uuid加上横线
	 * 		xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
	 * @param uuid
	 * @return
	 */
	public static String formatUUID32to36(String uuid){
		if(uuid == null && uuid.length() != 32){
			return uuid;
		}
		StringBuffer id = new StringBuffer();
		id.append(uuid.substring(0, 8));
		id.append("-");
		id.append(uuid.substring(8,12));
		id.append("-");
		id.append(uuid.substring(12, 16));
		id.append("-");
		id.append(uuid.substring(16, 20));
		id.append("-");
		id.append(uuid.substring(20, uuid.length()));
		
		return id.toString();
	}
	
	/**
	 * 把36位的uuid转换为32位的
	 * 注意
	 * 		这里只是把36位的uuid的横线去掉
	 * 		xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 * @param uuid
	 * @return
	 */
	public static String formatUUID36to32(String uuid){
		if(uuid == null){
			return uuid;
		}
		return uuid.replace("-", "");
	}
}