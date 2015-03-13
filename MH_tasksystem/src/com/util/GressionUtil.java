package com.util;

/**
 * 移位加密字母
 * @author 
 *
 */
public class GressionUtil {

	private static final char C1 = 'a';
	private static final char C2 = 'z';
	private static final char C3 = 'A';
	private static final char C4 = 'Z';

	public static String getString(String str, int key) {
		key %= 26;
		if (key == 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] >= C3 && chars[i] <= C4) {
				chars[i] += key;
				if (chars[i] > C4) {
					chars[i] = (char) (chars[i] - C4 + C3 - 1);
				} else if (chars[i] < C3) {
					chars[i] = (char) (C4 - (C3 - chars[i]) + 1);
				}
			} else if (chars[i] >= C1 && chars[i] <= C2) {
				chars[i] += key;
				if (chars[i] > C2) {
					chars[i] = (char) (chars[i] - C2 + C1 - 1);
				} else if (chars[i] < C1) {
					chars[i] = (char) (C2 - (C1 - chars[i]) + 1);
				}
			}
		}
		return new String(chars);
	}

}
