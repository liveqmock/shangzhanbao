package com.gomai.cas.authentication.handler.support;

import org.jasig.cas.authentication.handler.PasswordEncoder;

import com.gomai.cas.authentication.util.PasswordUtil;
/**
 * 使用MD5加密
 * @author lihongchuan
 *
 */
public class MD5PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String s) {
		return PasswordUtil.encodePassword(s, "MD5");
	}
}
