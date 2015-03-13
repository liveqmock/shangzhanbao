package com.itour.etip.pub.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 大数据计算
 * 
 * @author xueting
 * 
 */
public class DataComputeUtil {
	/**
	 * 加
	 * 
	 * @return
	 */
	public String add(BigDecimal big1, BigDecimal big2) {
		return big1.add(big2).toString();
	}

	/**
	 * 减
	 * 
	 * @return
	 */
	public String subtract(BigDecimal big1, BigDecimal big2) {
		return big1.subtract(big2).toString();
	}

	/**
	 * 乘
	 * 
	 * @return
	 */
	public String multiply(BigDecimal big1, BigDecimal big2) {
		return big1.multiply(big2).toString();
	}

	/**
	 * 除
	 * 
	 * @return
	 */
	public String divide(BigDecimal big1, BigDecimal big2) {
		return big1.divide(big2).toString();
	}
	
	/**
	 * 加
	 * double有科学计数法的
	 * @return
	 */
	public double addToDouble(BigDecimal big1, BigDecimal big2) {
		return big1.add(big2).doubleValue();
	}
	
	/**
	 * 减
	 * double有科学计数法的
	 * @return
	 */
	public double subtractToDouble(BigDecimal big1, BigDecimal big2) {
		return big1.subtract(big2).doubleValue();
	}
	
	/**
	 * 乘
	 * double有科学计数法的
	 * @return
	 */
	public double multiplyToDouble(BigDecimal b1, BigDecimal b2) {
		return b1.multiply(b2).doubleValue();
	}
	
	/**
	 * 除
	 * double有科学计数法的
	 * @return
	 */
	public double divideToDouble(BigDecimal big1, BigDecimal big2) {
		return big1.divide(big2).doubleValue();
	}

	/**
	 * 数据加密
	 * 
	 * @return
	 */
	public double dataEncrypt(double temp) {
		BigDecimal big1 = new BigDecimal(temp);
		return big1.doubleValue();
	}

	/**
	 * 将科学计数法转为普通数字
	 * @return
	 */
	public String dataUnEncrypt(double tempD2) {
//		DecimalFormat format = (DecimalFormat) NumberFormat.getPercentInstance();
		DecimalFormat format = new DecimalFormat();
		format.applyPattern("#####0.00");
		String temp = format.format(tempD2);
		return temp;
	}
	
	
	public static void main2(String[] args){
		DataComputeUtil dataComputeUtil = new DataComputeUtil();
		String str = dataComputeUtil.dataUnEncrypt(123456789987654321.123456789);
		System.out.println(str);
	}
	
	/**
	 * 四舍五入
	 * @param v
	 * @param num
	 * @return
	 */
	public String doubleOutPut(double v, Integer num) {
		if (v == Double.valueOf(v).intValue())
			return Double.valueOf(v).intValue() + "";
		else {
			// 下面的舍入模式是 ROUND_HALF_UP
			BigDecimal b = new BigDecimal(Double.toString(v));
			return b.setScale(num, BigDecimal.ROUND_HALF_UP).toString();
		}
	}
	/**
	 * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {
		return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public static double round(double v, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, round_mode).doubleValue();
	}
	
	/**
	 * 返回当前日期的星期
	 * @return
	 */
	public String getWeekDayString(){
	    String weekString = "";
	    final String dayNames[] = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	    Calendar calendar = Calendar.getInstance();
	    Date date = new Date();
	    calendar.setTime(date);
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    weekString = dayNames[dayOfWeek - 1];
	    return weekString;
    }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataComputeUtil dataComputeUtil = new DataComputeUtil();
		System.out.println("周几:" + dataComputeUtil.getWeekDayString());
		//四舍五入
		System.out.println("四舍五入 = " + dataComputeUtil.doubleOutPut(12.345, 2));
		System.out.println("提供精确的小数位四舍五入 = " + dataComputeUtil.round(12.335,2));
		
		//去掉科学计数法
		System.out.println("将科学计数法转为普通数字= " + dataComputeUtil.dataUnEncrypt(1.01E7));
		System.out.println("转为科学计数法= " + dataComputeUtil.dataEncrypt(10100000.00));
		
		BigDecimal big1 = new BigDecimal("1000000000000.2312");
		BigDecimal big2 = new BigDecimal("1000000000000.2312");
		
		//直接返回字符串的加减乘除(计算结果比较准确) 返回String类型
		System.out.println("加= " + dataComputeUtil.add(big1, big2));
		System.out.println("减= " + dataComputeUtil.subtract(big1, big2));
		System.out.println("乘= " + dataComputeUtil.multiply(big1, big2));
		System.out.println("除= " + dataComputeUtil.divide(big1, big2));
		
		double v1 = 1000000000000.2312;
		double v2 = 1000000000000.2312;
		
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		//去掉科学计数法的 的加减乘除 返回的是double类型
		System.out.println("转加 = " + dataComputeUtil.dataUnEncrypt(dataComputeUtil.addToDouble(b1, b2)));
		System.out.println("转减 = " + dataComputeUtil.dataUnEncrypt(dataComputeUtil.subtractToDouble(b1, b2)));
		System.out.println("转乘 = " + dataComputeUtil.dataUnEncrypt(dataComputeUtil.multiplyToDouble(b1, b2)));
		System.out.println("转除 = " + dataComputeUtil.dataUnEncrypt(dataComputeUtil.divideToDouble(b1, b2)));
	}
}
