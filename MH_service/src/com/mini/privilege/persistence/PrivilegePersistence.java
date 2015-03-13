package com.mini.privilege.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.privilege.data.PrivilegeData;
@SuppressWarnings("unchecked")
@Component("privilegePersistence")
public class PrivilegePersistence extends BasePersistence<PrivilegeData> implements IPrivilegePersistence {

	@Override
	public void addPrivilege(PrivilegeData data) {
		addPrivilege(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		deletePrivilege(ids);
	}

	@Override
	public void editPrivilege(PrivilegeData data) {
		editPrivilege(data);
	}

	@Override
	public List<PrivilegeData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		StringBuffer countSQL = new StringBuffer("SELECT COUNT(bd.id)FROM PrivilegeData bd WHERE 1=1");
		StringBuffer querySQL = new StringBuffer(" FROM PrivilegeData bd WHERE 1=1");
		String whereSQL = getInquiresTheConditions(json);
		pageRoll.setCountSQL(countSQL.append(whereSQL).toString());
		pageRoll.setSearchSQL(querySQL.append(whereSQL).append(" ORDER BY bd.id").toString());
		List<PrivilegeData> list = search(pageRoll);
		return list;
	
	}
	/**
	 * 根据要查询的内容添加查询条件
	 * @param json
	 * @return
	 */
	private String getInquiresTheConditions(JSONObject json) {
		StringBuffer whereSQL = new StringBuffer();
		if (json != null && !json.isNullObject()) {
			if (null != json.get("id")) {
				String id = json.getString("id");
				if (id != null && !"".equals(id))
					whereSQL.append(" AND bd.id = '").append(id).append("'");
			}
			if (null != json.get("type")) {//类型 1：付费 2未付费
				String type = json.getString("type");
				if (type != null && !"".equals(type))
					whereSQL.append(" AND bd.type = '").append(type).append("'");
			}
			if (null != json.get("STATE")) {//b:绑定page  u：未绑定page
				String state = json.getString("STATE");
				if (state != null && !"".equals(state))
					whereSQL.append(" AND bd.state = '").append(state).append("'");
			}
			if (null != json.get("starttime")) {//开始时间
				String starttime = json.getString("starttime");
				if (starttime != null && !"".equals(starttime))
					whereSQL.append(" AND bd.endtime >= to_date('").append(starttime).append("','yyyy-mm-dd')");
			}
			if (null != json.get("endtime")) {//结束时间
				String endtime = json.getString("endtime");
				if (endtime != null && !"".equals(endtime))
					whereSQL.append(" AND bd.endtime <= to_date('").append(endtime).append("','yyyy-mm-dd')");
			}
			if(null != json.get("unexpired")){
				String unexpired = json.getString("unexpired");//未过期标识
				if (unexpired != null && !"".equals(unexpired)){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String endtime=getSpecifiedDay(df.format(new Date()), "yyyy-MM-dd", -1);//权限是当天注册，第二天开始算起，所以判断未过期  数据库时间大于当前时间减一天
				whereSQL.append(" AND bd.endtime >= to_date('").append(endtime).append("','yyyy-mm-dd')");
				}
			}
			if (null != json.get("upgrade")) {//升级
				String upgrade = json.getString("upgrade");
				if (upgrade != null && !"".equals(upgrade))
					whereSQL.append(" AND bd.upgrade = '").append(upgrade).append("'");
			}
			if (null != json.get("give")) {//是否是赠送
				String give = json.getString("give");
				if (give != null && !"".equals(give))
					whereSQL.append(" AND bd.give = '").append(give).append("'");
			}
			if (null != json.get("upgrade1")) {//升级且又续费
				String upgrade1 = json.getString("upgrade1");
				if (upgrade1 != null && !"".equals(upgrade1))
					whereSQL.append(" AND bd.upgrade = '").append(upgrade1).append("'");
			}
			
		}
		return whereSQL.toString();
	}

	@Override
	public List<PrivilegeData> getPrivilegeData(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("FROM PrivilegeData bd WHERE 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}

	@Override
	public String statisticsPrivilege(JSONObject json) {
		String count = "";
		StringBuffer querySQL = new StringBuffer("select count(bd.id) FROM PrivilegeData bd WHERE 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		List<?> list = search(querySQL.toString());
		if(null!=list && list.size()>0){
			count= list.get(0).toString();
		}
		return count;
	}

	
	/**
	 * 获得指定日期的n天前或后
	 * 
	 * num为正时：num天后 num为负时：num天前
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDay(String specifiedDay,
			String dateFormat, int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat(dateFormat).format(c.getTime());
		return dayAfter;
	}
	
}
