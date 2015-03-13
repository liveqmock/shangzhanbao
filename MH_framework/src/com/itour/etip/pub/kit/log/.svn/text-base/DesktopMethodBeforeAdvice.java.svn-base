package com.itour.etip.pub.kit.log;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.itour.etip.pub.frame.SpringContextHelper;

/**
 * <p>
 * Title: 桌面消息刷新切面
 * </p>
 * <p>
 * 在方法调用整个过程中，用于控制桌面消息的取值来源：DB、ehcache。
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-04-29
 */
public class DesktopMethodBeforeAdvice implements MethodInterceptor {

	/**
	 * 在方法调用整个过程中。
	 * 
	 * @param MethodInvocation
	 *            调用信息
	 * @return Object 方法返回值
	 * @throws Throwable
	 *             抛出例外时，将中止本操作.
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		int argsCount = args.length;
		CacheManager manager = (CacheManager) SpringContextHelper
				.getBean("cacheManager");
		Cache cache = manager.getCache("desktop");
		String oldtime = null;
		Object rval = null;
		if (cache == null) {
			// 获取客户端当前消息更新时间

			if (argsCount > 0) {
				oldtime = args[0].toString().replaceAll("-", "").replaceAll(
						":", "").replaceAll(" ", "");
			}
			rval = invocation.proceed();
			return rval;
		}
		// 获取客户端当前消息更新时间

		if (argsCount > 0) {
			oldtime = args[0].toString().replaceAll("-", "")
					.replaceAll(":", "").replaceAll(" ", "");
		}
		if (oldtime.equals("1")) {
			rval = invocation.proceed();
			return rval;
		}
		// 获取cache中Lisener到jms发送来的新消息
		String newtime = null;
		Element element = cache.get("newtime");
		if (element == null) {
			return null;
		}

		newtime = element.getValue().toString();
		try {
			long newLong = Long.parseLong(newtime.substring(0, 14));
			long oldLong = Long.parseLong(oldtime.substring(0, 14));
			long balance = newLong - oldLong;
			if (balance > 0) {
				// 内存中已缓存的Element数量
				// long memoryStoreSize=cache.getMemoryStoreSize();
				// 磁盘中已缓存的Element数量
				// long diskStoreSize=cache.getDiskStoreSize();
				// 模拟当前用户是admin
				// String role="admin";
				// 遍历cache的算法（待优化）
				// List<String> keys = cache.getKeys();
				// for (String key : keys) {
				// System.out.println(key + "," + cache.get(key));
				// }
				// 根据角色和用户id将符合条件的消息返回给action（待解决）
				rval = invocation.proceed();
			}
		} catch (Exception e) {
			rval = invocation.proceed();
		}

		return rval;
	}

}
