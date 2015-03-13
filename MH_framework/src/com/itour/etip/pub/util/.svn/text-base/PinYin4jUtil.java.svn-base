package com.itour.etip.pub.util;

import java.io.InputStream;
import java.util.Properties;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.StringUtils;

import com.bjsasc.common.io.Resources;

public class PinYin4jUtil {
	/** 姓氏 **/
	private static Properties XINGS;
	static {
		XINGS = new Properties();
		try {
			InputStream is = Resources.getResourceAsStream("com/bjsasc/caac/util/xing.properties");
			XINGS.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将名字转为中文拼音
	 * 
	 * @param str
	 * @return
	 */
	public static String transferName2PinYin(String chinese) {
		if (chinese == null) {
			return null;
		}
		chinese = chinese.trim();
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不标声调
		format.setVCharType(HanyuPinyinVCharType.WITH_V);// u:的声母替换为v
		try {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < chinese.length(); i++) {
				char c = chinese.charAt(i);
				String[] array = null;

				if (i == 0 && XINGS.containsKey(String.valueOf(c))) {
					array = new String[] { XINGS.getProperty(String.valueOf(c)) };
				} else if (i == 1
						&& XINGS.containsKey(String.valueOf(chinese.charAt(0)) + String.valueOf(chinese.charAt(1)))) {
					String value = String.valueOf(chinese.charAt(0)) + String.valueOf(chinese.charAt(1));
					String x = XINGS.getProperty(value);
					sb = new StringBuilder();
					sb.append(x + " ");
					continue;
				} else {
					array = PinyinHelper.toHanyuPinyinStringArray(c, format);
				}
				if (array == null || array.length == 0) {
					sb.append(c);
					continue;
				}
				String s = array[0];// 不管多音字,只取第一个

				/** 首字空格 **/
				if (i == 0) {
					s = s.concat(" ");
				}

				sb.append(StringUtils.capitalize(s));
			}
			return sb.toString();
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/** 何卫国 **/
		/** 丁丹 **/
		/** 沈雪刚 **/
		/** 王大泉 **/
		String str = "何卫国";
		System.out.println(transferName2PinYin(str));

		str = " 12323232 a  ";
		System.out.println(transferName2PinYin(str));
	}

}
