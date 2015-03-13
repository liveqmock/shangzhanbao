package com.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.log.LogUtil;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.AccesstatisticsData;

/**
 * 数据分析 存数据帮组类
 * @author hy
 *@date 2014-3-25
 */
public class AccesstatisticsUtil {



	/**
	 * 通过拦截器 拦截访问的page页面  添加数据 到数据库
	 * @author hy
	 *@date 2014-3-25
	 * @param accessIp  访问ip
	 * @param accesstatisticsName  域名
	 * @param synchronize  异步
	 */
	public static void sendDBLog(String  accessIp,String accesstatisticsName,boolean synchronize) {
		// 创建数据对象
		AccesstatisticsData accesstatisticsData = new AccesstatisticsData();
		String pageId="";
		// 访问日期
		accesstatisticsData.setAccessTime(new Date());
		accesstatisticsData.setAccessIp(accessIp);
		accesstatisticsData.setAccesstatisticsName(accesstatisticsName);
		// 此处判断是同步还是异步，如果是同步，那么立即存储数据库，如果是异步，那么通过accesstatisticsDatas存储数据库
		if (synchronize == true) {
			HibernateDao hibernate = (HibernateDao) SpringContextHelper.getBean("hibernate");			
			/*通过域名查询出pageid 存入到数据库*/
			String hql=" from PageInfoExtraData p where  p.domain = '"+accesstatisticsName+"'  and p.status='OPEN' ";
			List<PageInfoExtraData> list = new ArrayList<PageInfoExtraData>();
			try {
				list =(List<PageInfoExtraData>) hibernate.search(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < list.size(); i++) {
			pageId=list.get(0).getPageId();  //获取到pageid
			}
			accesstatisticsData.setPageId(pageId);
			hibernate.save(accesstatisticsData);  //添加
		} else if (synchronize == false) {
			// 此处需要包装为服务。
			AccesstatisticsData accesstatisticsDatas = new AccesstatisticsData();
			LogUtil.info("eTIPJMS", accesstatisticsDatas);
		}
	}

	
	
}
