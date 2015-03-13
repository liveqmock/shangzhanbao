package com.itour.etip.pub.kit.format;

import java.text.DecimalFormat;

/**
 * 格式化数值
 * 
 * @author wangsw
 * @version 1.00
 * @date 2011-09-06
 */
public class DataFormatUtil {
	
	/**
	 * 以科学计算数法格式化double
	 * 强制保留3位小数，没有补0
	 */      
	private static DecimalFormat exFormat = new DecimalFormat("0.000E00");
	public static String toExponential1(Double number){
		if(number==null || number==0 ) return null;        
		return exFormat.format(number);
	}
	
	/**
	 * 强制double以小数显示，取消科学计算数法
	 * 小数点前10位，后3位
	 */
	private static DecimalFormat deFormat= new DecimalFormat("#########0.0##");
	public static String toDecimal(Double number){
		if(number==null || number==0 ) return null;
		return deFormat.format(number);
	}
	/**
	 * 强制double以小数显示，取消科学计算数法
	 * 小数点前10位，后2位
	 */
	private static DecimalFormat deFormat1= new DecimalFormat("#,###,###,##0.00");
	public static String toDecimalTwo(Double number){
		if(number==null || number==0 ) return "0.00";
		return deFormat1.format(number);
	}


}
