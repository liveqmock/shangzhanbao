package com.mini.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itour.etip.pub.frame.PageRoll;

public class CtnUtil {  
	/**
	 * 把长整型金额转换为3位一个逗号的字符串
	 * 
	 * @param money
	 *            金额
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:11:13
	 * @author He Dayong
	 */
	public static String formatMoney(long money) {
		String formatted = "";
		String moneyStr = money + "";
		if (moneyStr.length() <= 3) {
			return moneyStr;
		}
		do {
			formatted = formatted + moneyStr.substring(0, 3);
			formatted = formatted + ",";
			moneyStr = moneyStr.substring(3, moneyStr.length());
			// 循环截取字符串
		} while (moneyStr.length() > 3);
		formatted = formatted + moneyStr;
		return formatted;
	}

	/**
	 * 设置翻页参数
	 * 
	 * @param size
	 *            每页大小
	 * @param pageRoll
	 *            翻页参数
	 * @return PageRoll
	 * @throws
	 * @修改时间： 2012-6-20 下午02:13:03
	 * @author He Dayong
	 */
	public static PageRoll setPageRoll(int size, PageRoll pageRoll) {
		if (pageRoll == null) {
			pageRoll = new PageRoll();
			pageRoll.setCurrentPage(0);
		}
		if (size != 0)
			pageRoll.setPageSize(size);
		pageRoll.setStartRow(size * pageRoll.getCurrentPage());
		return pageRoll;
	}


	/**
	 * 处理时间只显示日期
	 * 
	 * @param date
	 *            传入的时间
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:14:25
	 * @author He Dayong
	 */
	public static String showDateOnly(Date date) {
		if (date == null)
			return "";
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * 处理时间只显示时间
	 * 
	 * @param date
	 *            传入的时间
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:14:25
	 * @author He Dayong
	 */
	public static String showTimeOnly(Date date) {
		if (date == null)
			return "";
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

	/**
	 * 处理时间，显示日期和时间
	 * 
	 * @param date
	 *            传入的具体时间
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:14:51
	 * @author He Dayong
	 */
	public static String showDateTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 页面跳转，用于不同ACTION带参跳转
	 * 
	 * @param response
	 *            当前的服务器回应
	 * @param url
	 *            目标地址 void
	 * @throws
	 * @修改时间： 2012-6-20 下午02:15:21
	 * @author He Dayong
	 */
	public static void dispatcher(HttpServletResponse response, String url) {
		try {
			response.getWriter().print(
					"<script>window.location.href='" + url + "'</script>");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("输入输出异常！");
		}
	}

	/**
	 * 字符串长度处理，默认16位，超出就换成...
	 * 
	 * @param str
	 *            传入的字符串
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:16:03
	 * @author He Dayong
	 */
	public static String StrCut(String str) {
		if (str == null)
			return "";
		if (str.length() <= 16) {
			return str;
		}
		return str.substring(0, 15) + "...";
	}

	/**
	 * 字符串长度处理函数，传入字符串本身和需要显示的长度，超出的换成...
	 * 
	 * @param length
	 *            需要显示的长度
	 * @param str
	 *            传入的字符串
	 * @return String
	 * @throws
	 * @修改时间： 2012-6-20 下午02:16:32
	 * @author He Dayong
	 */
	public static String StrCut(int length, String str) {
		if (str == null)
			return "";
		if (str.equals("null"))
			return "";
		if (str.length() <= length) {
			return str;
		}
		return str.substring(0, length-1) + "...";
	}


	/**
	 * 把字符串转为Date
	 * 
	 * @param date
	 * @return Date
	 * @throws
	 * @2012-8-15 上午09:09:47
	 * @author 何大勇
	 * @throws ParseException
	 */
	public static Date parseDate(String date) {
		try {
			if (date.length() > 10)
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			else
				return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 判断JSP页面的下拉框是否选中
	 * 
	 * @param request
	 * @param key
	 * @param value
	 * @return String
	 * @throws
	 * @2012-8-20 上午09:51:42
	 * @author 何大勇
	 */
	public static String getSelectToJsp(HttpServletRequest request, String key,
			String value) {
		if (request == null || request.getParameter(key) == null || key == null
				|| "".equals(key)) {
			return "";
		}
		if (request.getParameter(key) != null) {
			if (request.getParameter(key).equals(value))
				return "selected=\"selected\"";
		}
		return "";
	}

	/**
	 * 从request取关键字的值
	 * 
	 * @param request
	 * @param key
	 * @return String
	 * @throws
	 * @2012-8-23 下午01:09:22
	 * @author 何大勇
	 */
	public static String getTextToJsp(HttpServletRequest request, String key) {
		if (request.getParameter(key) == null)
			return "";
		else
			return request.getParameter(key);
	}

	/**
	 * 从数字判断状态集(用于状态字段为int的时候，查询多个状态的选择情况)
	 * 
	 * @return String
	 * @throws
	 * @2012-8-24 上午11:37:27
	 * @author 何大勇
	 */
	public static String getStateSetByNumber(int number) {
		if (number < 1) {
			return "";
		}
		String result = "";
		for (int i = 1; number > 0; i++) {
			int a = (int) Math.pow(2, i);
			if (a * 2 > number) {
				result += (i - 1) + ",";
				number -= a;
				i = 0;
			}
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * 用数组拼接成字符串，通常用作多状态组合查询
	 * 
	 * @param strs
	 * @return String
	 * @throws
	 * @2012-8-28 下午02:09:38
	 * @author 何大勇
	 */
	public static String linkString(String[] strs) {
		String str = "";
		if (strs == null)
			return "";
		for (int i = 0; i < strs.length; i++) {
			str += strs[i] + ',';
		}
		if (str.length() > 0)
			str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	 * 四舍五入，只对小数生效
	 * 
	 * @param number
	 *            数字
	 * @param length
	 *            保留的位数
	 * @return float
	 * @throws
	 * @2012-8-31 下午04:54:21
	 * @author 何大勇
	 */
	public static String round(String number, int length) {
		length = number.indexOf(".") + length;
		if (length < 1 || length > number.length()) {
			return 0 + "";
		}
		char[] num = number.toCharArray();
		if (num.length <= length + 1) {
			return number;
		}
		String n = number.substring(0, length);
		int lastNum = Integer.parseInt(num[length] + "");
		if (Integer.parseInt(num[length + 1] + "") > 4) {
			lastNum++;
		}
		n += lastNum;
		return n;
	}

	public static String round(float number, int length) {
		if (number == 0) {
			return 0 + "";
		}
		String str = number + "";
		str = round(str, length);
		if (str.endsWith(".0")) {
			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	public static String round(double number, int length) {
		StringBuffer formatStr = new StringBuffer("#.");
		for (int i = 0; i < length; i++) {
			formatStr.append("#");
		}
		java.text.DecimalFormat df = new java.text.DecimalFormat(formatStr
				.toString());
		df.setMaximumFractionDigits(length);
		df.setMinimumFractionDigits(length);
		return df.format(number);
	}

}
