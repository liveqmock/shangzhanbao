/**
 * com.gomai.person.train.main
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-3-8 		csh
 *
 * Copyright (c) 2013, gomai.
*/

package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 函数调用定时器
 * <p>用于定期执行指定函数，用于检测在线用户状态</p>
 * @author   csh
 * @version  
 * @Date	 2013-3-8 上午11:20:57
 */
public class OrderCodeSetterListener implements ServletContextListener {
	
	
	/**
	 * 定时器
	 */
	private Timer timer = null;
	/**
	 * 记录调用次数
	 */
	/*private static int count = 0;*/

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.itour.etip.pub.frame.OrderCodeSetterListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// 关闭定时器
		timer.cancel();
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.itour.etip.pub.frame.OrderCodeSetterListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(true);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			//加上一毫秒，保证超过零点时间
			date = new Date(simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime()+1);
		} catch (ParseException e) {
		}
		timer.scheduleAtFixedRate(new CheckCodeTask(),date,1000*60*60*24);
	}
}

