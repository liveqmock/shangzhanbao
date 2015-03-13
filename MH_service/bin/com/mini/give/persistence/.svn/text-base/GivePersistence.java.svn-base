package com.mini.give.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.common.util.DateUtil;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
/**
 * 赠送权限久化层接口实现类
 * 
 * @author     林海鹏
 * @see        GivePersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("givePersistence")
public class GivePersistence extends BasePersistence<GiveData> implements IGivePersistence {

	@Override
	public void addPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		add(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		delete(ids);
	}

	@Override
	public void editPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		update(data);
	}

	@Override
	public List<GiveData> getAllPrivilegeInfo(PageRoll pageRoll,JSONObject json) {
		StringBuffer countSQL = new StringBuffer("select count(*) from (select bd.createtime, count(bd.userid)userNum, bd.condition ,bd.givenum,bd.creatorname,bd.give,bd.message,bd.creatorid from MINI_GIVE bd where 1=1");
		StringBuffer querySQL = new StringBuffer("select createtime,nvl(userNum,0)userNum,nvl(condition,0)condition,nvl(givenum,0)givenum,nvl((userNum*givenum),0)totalNum,  creatorname,give,message ,creatorid from (select bd.createtime, count(bd.userid)userNum, bd.condition ,bd.givenum,bd.creatorname,bd.give,bd.message,bd.creatorid from MINI_GIVE bd where 1=1");
		String whereSQL = getInquiresTheConditions(json);
		pageRoll.setCountSQL(countSQL.append(whereSQL).append(" group by bd.condition,bd.givenum,bd.createtime,bd.creatorname,bd.give,bd.message,bd.creatorid)").toString());
		pageRoll.setSearchSQL(querySQL.append(whereSQL).append(" group by bd.condition,bd.givenum,bd.createtime,bd.creatorname,bd.give,bd.message,bd.creatorid)order by createtime desc").toString());
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list =dao.search(pageRoll);
		List<GiveData> privilegeList = new ArrayList<GiveData>();
		for (int i = 0; i < list.size(); i++) {
			GiveData giveData = new GiveData();
			giveData.setCreateTime(list.get(i).getDate("CREATETIME"));
			giveData.setTotalNum(list.get(i).getString("TOTALNUM"));
			giveData.setUserNum(list.get(i).getString("USERNUM"));
			giveData.setCondition(list.get(i).getString("CONDITION"));
			giveData.setGiveNum(list.get(i).getInt("GIVENUM"));
			giveData.setCreatorName(list.get(i).getString("CREATORNAME"));
			giveData.setGive(list.get(i).getString("GIVE"));
			giveData.setMessage(list.get(i).getString("MESSAGE"));
			giveData.setCreatorId(list.get(i).getString("CREATORID"));
			privilegeList.add(giveData);
		}
		return privilegeList;
	
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
			if (null != json.get("give")) { //是否是赠送
				String id = json.getString("give");
				if (id != null && !"".equals(id))
					whereSQL.append(" AND bd.give = '").append(id).append("'");
			}
			if (null != json.get("condition")) { //条件
				String condition = json.getString("condition");
				if (condition != null && !"".equals(condition))
					whereSQL.append(" AND bd.condition = '").append(condition).append("'");
			}
			if (null != json.get("creatorId")) { //创建者id
				String creatorId = json.getString("creatorId");
				if (creatorId != null && !"".equals(creatorId))
					whereSQL.append(" AND bd.creatorId = '").append(creatorId).append("'");
			}
			if (null != json.get("createTime")) { //创建时间
				String createTime = json.getString("createTime");
				if (createTime != null && !"".equals(createTime))
					whereSQL.append(" AND bd.createTime = to_date('").append(createTime.substring(0, createTime.lastIndexOf("."))).append("','yyyy-mm-dd hh24:mi:ss')");
			}
		}
		
		return whereSQL.toString();
	}

	@Override
	public List<GiveData> getPrivilegeData(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("FROM GiveData bd WHERE 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
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

	@Override
	public void delectGive(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("  delete from MINI_GIVE bd where 1=1 ");
		querySQL.append(this.getInquiresTheConditions(json));
		executeSQL(querySQL.toString());
	}
	/**
	 * 赠送目标客户(分页显示)
	 */
	@Override
	public List<GiveUserInfoData> getUserInfo(PageRoll pageRoll,GiveTimeData giveTimeData, GiveUserInfoData giveUserInfoData) {
		String sql = "select a.id, a.loginmail, a.loginmoble,"+
                    "(select count(p.id) from mini_page p where p.user_id = a.id) as pageNum,"+
                    "(select count(p.id) from mini_page p where p.user_id = a.id and p.status = '1') as releaseNum,"+
                    "nvl((select ui.payprivilege from mini_user_info ui where ui.userid = a.id),0) as payprivilege,"+
                    "a.createtime from CTN_SYSUSER a where a.usertype = 2 and 1 = 1";
		StringBuffer whereSQL = new StringBuffer(sql);
		if (null!=giveUserInfoData) {
			if(null != giveUserInfoData.getDomain()&&!"".equals(giveUserInfoData.getDomain())){
				String domain = giveUserInfoData.getDomain();
				whereSQL.append(" and a.id in (select pa.user_id from mini_page pa where pa.id in (select pi.page_id  from mini_page_info_extra pi where pi.domain like '%").append(domain).append("%'))");
			}
			if (null != giveUserInfoData.getUsername()&&!"".equals(giveUserInfoData.getUsername())) { // 公司名称
                String username = giveUserInfoData.getUsername();
                whereSQL.append(" and a.id in (select pa.user_id from mini_page pa where pa.id in (select pi.page_id  from mini_page_info_extra pi where pi.company = '").append(username).append("'))");
            }
			if(null != giveUserInfoData.getSn()&&!"".equals(giveUserInfoData.getSn())){
                String sn = giveUserInfoData.getSn();
                whereSQL.append(" and a.id in (select pa1.user_id  from mini_page pa1 where pa1.id in (select pt.page_id from MINI_PAGE_TEMPLATE pt  where 1=1 ");
                whereSQL.append("and pt.template_id in (select t.id   from mini_template t where 1 = 1 and t.sn = '").append(sn).append("')").append("))");
            }
			if (null != giveUserInfoData.getLoginmail()&&!"".equals(giveUserInfoData.getLoginmail())) {//登入账户
				String loginmail = giveUserInfoData.getLoginmail();
				if (loginmail != null && !"".equals(loginmail))
					whereSQL.append(" AND a.loginmail like '%").append(loginmail).append("%'");
			}
			if (null != giveUserInfoData.getLoginmoble()&&!"".equals(giveUserInfoData.getLoginmoble())) { //手机
				String loginmoble = giveUserInfoData.getLoginmoble();
				if (loginmoble != null && !"".equals(loginmoble))
					whereSQL.append(" AND a.loginmoble = '").append(loginmoble).append("'");
			}
			if (null != giveUserInfoData.getQueryType()&&!"".equals(giveUserInfoData.getQueryType())) { // 公司名称
                String querytype = giveUserInfoData.getQueryType();
                if (querytype != null && !"".equals(querytype))
                    whereSQL.append(" order by ").append(querytype);
            }
			if(giveUserInfoData.getServices().size()>0){
			    String serviceID = giveUserInfoData.getServices().get(0);
			    if(null!=serviceID&&!"".equals(serviceID)){
			        whereSQL.append("and a.id in (select p.user_id from mini_page p where p.id in (select pro.pageid from mini_pageproduct pro where pro.productid='"+serviceID+"'))");
			    }
			}
			if(null!=giveUserInfoData.getIsprivilege()&&!"".equals(giveUserInfoData.getIsprivilege())){
			    whereSQL.append(" and a.isprivilege="+giveUserInfoData.getIsprivilege());
			}
		}
		if(null!=giveTimeData){
		    if (null != giveTimeData.getStarttime()&&!"".equals(giveTimeData.getStarttime())) { //创建时间  即 注册时间  时间段的查询
                String starttime = giveTimeData.getStarttime();
                whereSQL.append(" AND a.createTime > to_date('").append(starttime).append("','yyyy-mm-dd hh24:mi:ss')");
            }
            if (null != giveTimeData.getEndtime()&&!"".equals(giveTimeData.getEndtime())) { //创建时间  即注册时间  时间段的查询
                String endtime = giveTimeData.getEndtime();
                whereSQL.append(" AND a.createTime <= to_date('").append(endtime).append("','yyyy-mm-dd hh24:mi:ss')");
            }
            if(null != giveTimeData.getStartUseTime()&&!"".equals(giveTimeData.getStartUseTime())){
                String startUseTime = giveTimeData.getStartUseTime();
                whereSQL.append(" and a.id in (select pa1.user_id  from mini_page pa1 where pa1.id in (select pt.page_id from MINI_PAGE_TEMPLATE pt  where 1=1 ");
                whereSQL.append(" and pt.create_time > to_date('").append(startUseTime).append("','yyyy-mm-dd hh24:mi:ss')");
                whereSQL.append("))");
            }
            if(null != giveTimeData.getEndUseTime()&&!"".equals(giveTimeData.getEndUseTime())){
                String endUseTime = giveTimeData.getEndUseTime();
                whereSQL.append(" and a.id in (select pa1.user_id  from mini_page pa1 where pa1.id in (select pt.page_id from MINI_PAGE_TEMPLATE pt  where 1=1 ");
                whereSQL.append(" and pt.create_time <= to_date('").append(endUseTime).append("','yyyy-mm-dd hh24:mi:ss')");
                whereSQL.append("))");
            }
		}
			
		String countSQL = ("select count(1) from ("+whereSQL+")");
		pageRoll.setCountSQL(countSQL);
		pageRoll.setSearchSQL(whereSQL.toString());
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list =dao.search(pageRoll);
		List<GiveUserInfoData> giveUserInfoDataList = new ArrayList<GiveUserInfoData>();
		for (int i = 0; i < list.size(); i++) {
			GiveUserInfoData giveUserInfoData_1 = new GiveUserInfoData();
			giveUserInfoData_1.setId(list.get(i).getString("ID"));
			giveUserInfoData_1.setLoginmail(list.get(i).getString("LOGINMAIL"));//登入账户
			giveUserInfoData_1.setLoginmoble(list.get(i).getString("LOGINMOBLE"));//登入手机
			giveUserInfoData_1.setPageNum(list.get(i).getString("PAGENUM"));//拥有page数
			giveUserInfoData_1.setCreatetime(DateUtil.dateToStr(list.get(i).getDate("CREATETIME"), "yyyy-MM-dd hh:mm:ss"));//注册时间
			giveUserInfoData_1.setReleaseNum(list.get(i).getString("RELEASENUM"));//发布page数
			giveUserInfoData_1.setPayprivilege(list.get(i).getString("PAYPRIVILEGE"));//购买发布权限数
			giveUserInfoData_1.setDomain(list.get(i).getString("DOMAIN"));//域名
			giveUserInfoData_1.setUsername(list.get(i).getString("USERNAME"));//公司名称
			giveUserInfoData_1.setSn(list.get(i).getString("SN"));//模板编号
			giveUserInfoData_1.setName(list.get(i).getString("NAME"));//模板名称
			giveUserInfoData_1.setUseTime(list.get(i).getString("USETIME"));//模板创建时间
			giveUserInfoDataList.add(giveUserInfoData_1);
		}
		return giveUserInfoDataList;
	}

	
}
