package com.itour.etip.pub.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.itour.etip.pub.kit.cache.CacheUtil;

/**
 * MD5加密算法
 */
public class Md5Encrypt {
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param text
	 *            明文
	 * 
	 * @return 密文
	 */
	public static String md5(String text) {
		String md5 = CacheUtil.paraCache.getParaValue("passwordMD5");
		if(md5.equals("true")){
			MessageDigest msgDigest = null;
			try {
				msgDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalStateException(
						"System doesn't support MD5 algorithm.");
			}
			msgDigest.update(text.getBytes());
			byte[] bytes = msgDigest.digest();
			String md5Str = new String(encodeHex(bytes));
			return md5Str;
		}
		else{
			return text;
		}
		
	}

	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

}