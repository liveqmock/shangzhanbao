package com.itour.etip.scheduler;

import java.util.Map;

import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.log.LogUtil;

/**
 * 系统级的定时任务
 * 
 * @author lishan
 * 
 */
public class SystemManageService {
	/**
	 * 清理系统中的垃圾数据，包括下列数据，要求这些sql从配置文件data.xml中获取，而不是固定的 1.主表数据，但是没有主键
	 * 2.子表数据，但是没有外键，此处需要
	 */
	private void clearNurseService() {
		Map sqlMap = CacheUtil.dataCache.getDataMap("clearNurseSql");
		if (sqlMap == null) {
			LogUtil.warn("CONSOLE", "在data.xml中没有配置clearNurseSql");
			return;
		}
		// 取得sql语句执行工具
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao) com.itour.etip.pub.frame.SpringContextHelper
				.getBean("jdbc");

		// 以下执行sqlMap中的sql语句，出现错误则记录错误日志
		Object[] sqls = sqlMap.values().toArray();
		for (Object sqlObj : sqls) {
			String sql = (String) sqlObj;
			if (sql == null || sql.trim().length() == 0) {
				LogUtil.warn("CONSOLE", "在clearNurseSql发现未配置sql");
				continue;
			}
			// 以下执行sql，清除数据,当前sql语句错误不影响其他sql语句执行
			try {
				dao.executeSQL(sql);
			} catch (Exception ex) {
				LogUtil.error("CONSOLE", "执行sql错误:" + sql);
			}

		}
	}
}
