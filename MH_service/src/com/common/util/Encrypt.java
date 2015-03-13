/**
 * com.itour.etip.pub.frame
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2012-12-26 		何大勇
 *
 * Copyright (c) 2012, gomai.
*/

package com.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.itour.etip.pub.kit.exception.ETIPException;

/**
 * 加密算法，源码来自网络
 * @author   何大勇
 * @version  
 * @date	 2012-12-26 上午10:00:14
 */
public class Encrypt {

	   
	   /** 
	    * md5加密(ITS) 
	    * @param str 
	    * @param charSet 
	    * @return 
	    */  
	   public synchronized static final String getMD5Str(String str,String charSet) { //md5加密  
	    MessageDigest messageDigest = null;    
	    try {    
	        messageDigest = MessageDigest.getInstance("MD5");    
	        messageDigest.reset();   
	        if(charSet==null){  
	            messageDigest.update(str.getBytes());  
	        }else{  
	            messageDigest.update(str.getBytes(charSet));    
	        }             
	    } catch (NoSuchAlgorithmException e) {    
	    	throw new ETIPException("md5 error!", "MD5加密算法错误！");
	    } catch (UnsupportedEncodingException e) {    
	    	throw new ETIPException("md5 error!", "MD5加密算法错误！");
	    }    
	      
	    byte[] byteArray = messageDigest.digest();    
	    StringBuffer md5StrBuff = new StringBuffer();    
	    for (int i = 0; i < byteArray.length; i++) {                
	        if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)    
	            md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));    
	        else    
	            md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));    
	    }    
	    return md5StrBuff.toString();    
	}  
	   
	   
	   private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";    
	   /** 
	    * 获取任意位的随机字符串(0-9 a-z A-Z) 
	    * @param size 位数 
	    * @return 
	    */  
	   public static final String getRandomNum(int size){  
	    StringBuffer sb = new StringBuffer();    
	    Random random = new Random();  
	    for (int i = 0; i < size; i++) {    
	        sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));    
	    }  
	    return sb.toString();  
	   } 
}

