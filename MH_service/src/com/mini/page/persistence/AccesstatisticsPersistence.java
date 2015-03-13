package com.mini.page.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.DateUtil;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageHelpData;

/**
 * 数据分析久化层接口实体类
 * 
 * @author     林海鹏
 * @see        AccesstatisticsPersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("accesstatisticsPersistence")
public class AccesstatisticsPersistence extends BasePersistence<AccesstatisticsData> implements
		IAccesstatisticsPersistence {

	@Override
	public void addAccesstatisticsData(AccesstatisticsData data) {
		add(data);
	}

	@Override
	public void deleteAccesstatisticsData(String[] ids) {
		delete(ids);
	}

	@Override
	public void editAccesstatisticsData(AccesstatisticsData data) {
		update(data);
	}
	/**
	 * 数据分析
	 */
	@Override
	public Map<String,Object> getAccesstatisticsData(JSONObject json) {
		Map<String, Object> daylist = null;
		StringBuffer querySQL = null;
		json.put("userid", FrmUser.getUser().etipUserID);
		if(json.get("sign").equals("hour")){
			 daylist =getDayHour(json.getString("endTime"));
			 querySQL =  new StringBuffer("select count(bd.id)ip,trunc(bd.accesstime,'hh24')accesstime FROM  mini_page cd,mini_accesstatistics bd   WHERE  bd.pageid = cd.id");
			 querySQL.append(this.getInquiresTheConditions(json)).append(" group by trunc(bd.accesstime,'hh24') order by trunc(bd.accesstime,'hh24') asc");//浏览量分组方式
			 JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
			 List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
			 for (int i = 0; i < list.size(); i++) {
				 String date= list.get(i).getString("ACCESSTIME");
				 date=date.substring(0, date.lastIndexOf("."));
				 /*date =DateUtil.dateToStr(DateUtil.strToDate(date, "yyyy-MM-dd hh:mm:ss"),"yyyy-MM-dd HH:mm:ss");*/
				 daylist.put(date, list.get(i).getString("IP"));
			 }
		}else if(json.get("sign").equals("threemouth")){
		    daylist =DateUtil.getAllMonthMap(json.getString("startTime").substring(0, 7),json.getString("endTime").substring(0, 7));
            querySQL =  new StringBuffer("select count(bd.id)ip,to_char(bd.accesstime,'yyyy-MM')accesstime FROM  mini_page cd,mini_accesstatistics bd   WHERE  bd.pageid = cd.id");
            querySQL.append(this.getInquiresTheConditions(json)).append(" group by to_char(bd.accesstime,'yyyy-MM') order by to_char(bd.accesstime,'yyyy-MM') asc");//浏览量分组方式
            JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
            List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
            for (int i = 0; i < list.size(); i++) {
                String date= list.get(i).getString("ACCESSTIME");
                /*date=date.substring(0, date.lastIndexOf("."));*/
                date =DateUtil.dateToStr(DateUtil.strToDate(date, "yyyy-MM"),"yyyy-MM");
                daylist.put(date, list.get(i).getString("IP"));
            }
		}else{
			 daylist =getTimeforChar(json.getString("startTime"), json.getString("endTime"));
			 querySQL =  new StringBuffer("select count(bd.id)ip,to_char(bd.accesstime,'yyyy-MM-dd')accesstime  FROM  mini_page cd,mini_accesstatistics bd   WHERE  bd.pageid = cd.id");
			 querySQL.append(this.getInquiresTheConditions(json)).append(" group by to_char(bd.accesstime,'yyyy-MM-dd') order by to_char(bd.accesstime,'yyyy-MM-dd') asc");//浏览量分组方式
			 JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
			 List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
			 for (int i = 0; i < list.size(); i++) {
				 String date= list.get(i).getString("ACCESSTIME");
				// date=date.substring(0, date.lastIndexOf("."));
				 date =DateUtil.dateToStr(DateUtil.strToDate(date, "yyyy-MM-dd"),"yyyy-MM-dd");
				 daylist.put(date, list.get(i).getString("IP"));
			 }
		}
       
        return daylist;
    }
	/**
	 * 自主拼接查询条件
	 * @param json
	 * @return
	 */
	private String getInquiresTheConditions(JSONObject obj) {
        StringBuffer whereSQL = new StringBuffer();
        if (obj != null && !obj.isNullObject()) {
            if(null != obj.get("id")){
                String id = obj.getString("id");
                if(null!=id && !"".equals(id)){
                    whereSQL.append(" AND bd.id = '").append(id).append("'");    
                }
            }
            if(null != obj.get("startTime")){
            	String startTime = obj.getString("startTime");
            	if(null!=startTime && !"".equals(startTime)){
            		whereSQL.append(" AND bd.accessTime > to_date('"+startTime+" 23:59:59','yyyy-MM-dd HH24:MI:SS')");    
            	}
            }
            if(null != obj.get("endTime")){
            	String endTime = obj.getString("endTime");
            	if(null!=endTime && !"".equals(endTime)){
            	        whereSQL.append(" AND bd.accessTime < to_date('").append(endTime).append(" 23:59:59").append("','yyyy-MM-dd HH24:MI:SS')");
            	}
            }
            if(null != obj.get("userid")){
            	String userid = obj.getString("userid");
            	if(null!=userid && !"".equals(userid)){
            		whereSQL.append(" AND cd.user_id = '").append(userid).append("'");    
            	}
            }
            if(null != obj.get("pageId")){
                String pageId = obj.getString("pageId");
                if(null!=pageId && !"".equals(pageId)&&!"null".equals(pageId)){
                    whereSQL.append(" AND cd.id = '").append(pageId).append("'");    
                } 
            }
        }
        return whereSQL.toString();
    }
	/**
	 * 按设备分析
	 */
	@Override
	public Map<String,Object> getCountByIpType(JSONObject json) {
		json.put("userid", FrmUser.getUser().etipUserID);
		StringBuffer querySQL = new StringBuffer("select nvl(count(1),0)num,bd.iptype,bd.accesstime from MINI_ACCESSTATISTICS bd ,MINI_PAGE cd where 1=1 and bd.pageid = cd.id ");
        querySQL.append(this.getInquiresTheConditions(json)).append(" group by bd.accesstime , bd.iptype");//调用与拼接条件
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
        Map<String,Object> map = new HashMap<String, Object>();
        List<Integer> padlist = new ArrayList<Integer>();
        List<Integer> phonelist = new ArrayList<Integer>();
        List<Integer> pclist = new ArrayList<Integer>();
        
		String startTime = DateUtil.getSpecifiedDay(DateUtil.currentDate(), "yyyy-MM-dd", -2);
		String endTime = DateUtil.getSpecifiedDay(DateUtil.currentDate(), "yyyy-MM-dd", -1);
		
		int num = 0;
        if(null!=list && list.size()>0){
        	for (int i = 0; i < list.size(); i++) {
        		String date= list.get(i).getString("ACCESSTIME");
        		date=date.substring(0, date.lastIndexOf("."));
        		date =DateUtil.dateToStr(DateUtil.strToDate(date, "yyyy-MM-dd"),"yyyy-MM-dd");
        		if(startTime.equals(date)){
        			if(list.get(i).getString("IPTYPE").equals("pad")){
        				 num += list.get(i).getInt("NUM");
            			padlist.add(num);
            		}
            		if(list.get(i).getString("IPTYPE").equals("phone")){
            			phonelist.add(list.get(i).getInt("NUM"));
            		}
            		if(list.get(i).getString("IPTYPE").equals("pc")){
            			pclist.add(list.get(i).getInt("NUM"));
            		}
        		}
        		if(endTime.equals(date)){
        			if(list.get(i).getString("IPTYPE").equals("pad")){
            			padlist.add(list.get(i).getInt("NUM"));
            		}
            		if(list.get(i).getString("IPTYPE").equals("phone")){
            			phonelist.add(list.get(i).getInt("NUM"));
            		}
            		if(list.get(i).getString("IPTYPE").equals("pc")){
            			pclist.add(list.get(i).getInt("NUM"));
            		}
        		}
//        		[{NUM=2, IPTYPE=pad}, {NUM=2, IPTYPE=phone}][{NUM=2, IPTYPE=pad}, {NUM=1, IPTYPE=pc}]
        	}
        	map.put("padlist", padlist);
        	map.put("phonelist", phonelist);
        	map.put("pclist", pclist);
        }
        return map;
	}
	/**
	 * 浏览数12
	 */
	@Override
	public String getViewCount(JSONObject json) {
		json.put("userid", FrmUser.getUser().etipUserID);
		StringBuffer querySQL = new StringBuffer(" select nvl(sum(b.accessip),0) ip from ( select count(bd.accessip)accessip from MINI_ACCESSTATISTICS bd ,MINI_PAGE cd where 1=1 and bd.pageid = cd.id ");
        querySQL.append(this.getInquiresTheConditions(json)).append(" group by bd.accessip ) b");//调用与拼接条件
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
	    List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
	    String count = "";
	    if(null!=list && list.size()>0){
	    	count=list.get(0).getString("IP");
	    }
		return count;
	}
	/**
	 * 访客数
	 * @param json
	 * @return
	 */
	@Override
	public String getVisitCount(JSONObject json) {
		json.put("userid", FrmUser.getUser().etipUserID);
		StringBuffer querySQL = new StringBuffer("select nvl(count(b.accessip),0)ip from ( select count(bd.accessip)accessip from MINI_ACCESSTATISTICS bd ,MINI_PAGE cd where 1=1 and bd.pageid = cd.id");
		querySQL.append(this.getInquiresTheConditions(json)).append(" group by bd.accessip ) b");//调用与拼接条件
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
		String count = "";
		if(null!=list && list.size()>0){
			count=list.get(0).getString("IP");
		}
		return count;
	}
	
	
	
	/**
	 * 获取char图日期
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private static Map<String,Object> getTimeforChar(String startTime,String endTime) {
		int byear = Integer.valueOf(startTime.substring(0, startTime.indexOf("-")));
		int bmouth = Integer.valueOf(startTime.substring(startTime.indexOf("-")+1, startTime.lastIndexOf("-")));
		int bday = Integer.valueOf(startTime.substring(startTime.lastIndexOf("-")+1, startTime.length()));
		
		int tyear = Integer.valueOf(endTime.substring(0, endTime.indexOf("-")));
		int tmouth = Integer.valueOf(endTime.substring(endTime.indexOf("-")+1, endTime.lastIndexOf("-")));
		int tday = Integer.valueOf(endTime.substring(endTime.lastIndexOf("-")+1, endTime.length()));
		
		Calendar c_begin = new GregorianCalendar();
	     Calendar c_end = new GregorianCalendar();
	     c_begin.set(byear, bmouth-1, bday); //Calendar的月从0-11  所以2月 是1
	     c_end.set(tyear,tmouth-1,tday); //Calendar的月从0-11 所以3月 是2
	     int count = 1;
	     c_end.add(Calendar.DAY_OF_YEAR, 1);  //结束日期下滚一天是为了包含最后一天
	     Map<String,Object> map = new HashMap<String, Object>();
	     while(c_begin.before(c_end)){
	    	 map.put(new java.sql.Date(c_begin.getTime().getTime()).toString(), 0);
	      if(c_begin.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
	          count++;
	      }
	      c_begin.add(Calendar.DAY_OF_YEAR, 1);
	     }
		return map;
	}
	
	private static Map<String,Object> getDayHour(String currenttime){
		Map<String,Object> map =new HashMap<String, Object>();
		for (int i = 0; i < 24; i++) {
			String str = currenttime+" "+(i+1)+":00:00";
			map.put(str,0);
		}
		return map;
	}
	 /**
     * 
     *统计page访问量  后台<br>
     * 
     * @author 侯杨 <br> 
     *         2014-6-27
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public List<AccesstatisticsData> getAllPageCount(PageRoll pageRoll, PageHelpData pageHelpData,Integer sort){
        StringBuffer buffer=new StringBuffer("select count(ac.pageid) pageCount,ac.pageid  pageid from mini_accesstatistics ac,mini_page page,mini_page_info_extra pi");
        buffer.append(" where page.id=ac.pageid and pi.page_id=page.id");
      //定义根据条件查询  集合
        List<Object> objects=new ArrayList<Object>();
        //page名字
        if(pageHelpData.getPageName()!=null && !"".equals( pageHelpData.getPageName())){
            buffer.append(" and page.name like ? ");
            objects.add("%"+pageHelpData.getPageName()+"%");
        }
        //page域名
        if(pageHelpData.getPageDomain()!=null && !"".equals(pageHelpData.getPageDomain())){
            buffer.append(" and pi.domain like  ? ");
            objects.add("%"+pageHelpData.getPageDomain()+"%");
        }
        String pageState = pageHelpData.getPageState();
        /* 查询条件 */

        /* 验证page状态 */
        if(pageState!=null && !"".equals(pageState)){
            if (("0").equals(pageState)) {// 暂存
                buffer.append(" and page.status like '0'  ");
            }
            if (("1").equals(pageState)) {// 已发布
                buffer.append(" and page.status like '1' ");
            }
            if (("2").equals(pageState)) {// 禁用
                buffer.append(" and page.status like '2' ");
            }
            if (("3").equals(pageState)) {// 编辑中
                buffer.append(" and page.status like '3' ");
            }
            if (("4").equals(pageState)) {// 被禁用后，启用成功的状态
                buffer.append(" and page.status like '4' ");
            }
        }
        if (pageHelpData.getPageType() != null && !"".equals(pageHelpData.getPageType())) { // page域名类型
            buffer.append(" and pi.type = ?");
            objects.add(pageHelpData.getPageType());
        }
     // 创建时间
        if (pageHelpData.getCreateStartTime() != null) { 
            buffer.append(" and page.create_time >= ?");
            objects.add(pageHelpData.getCreateStartTime());
        }
        if (pageHelpData.getCreateEndTime() != null) {
            buffer.append(" and page.create_time <= ?");
            objects.add(pageHelpData.getCreateEndTime());
        }
        // 发布时间
        if (pageHelpData.getStartTime() != null) {
            buffer.append(" and page.publish_time >= ?");
            objects.add(pageHelpData.getStartTime());
        }
        if (pageHelpData.getEndTime() != null) {
            buffer.append("  and page.publish_time <= ?");
            objects.add(pageHelpData.getEndTime());
        }
        //按pageid分组
        buffer.append(" group by ac.pageid  ");
        //统计的page访问量排序
        buffer.append(" order by cast(pageCount as int) ");
        if(sort==0){
            buffer.append(" desc");
        }else{
            buffer.append(" asc");
        }
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询

        //分页查询
        pageRoll.setCountSQL("select count(*) from (" + buffer.toString() + ")");
        pageRoll.setSearchSQL(buffer.toString());
        List<ETIPResultSet> resultSet = dao.search(pageRoll, objects);// 分页查询
        List<AccesstatisticsData> list=new ArrayList<AccesstatisticsData>();    //page访问量集合
        if (resultSet != null && resultSet.size() > 0) {
            for (int i = 0; i < resultSet.size(); i++) {
                AccesstatisticsData data=new AccesstatisticsData();  //page访问量实体
                ETIPResultSet rs = resultSet.get(i);
                data.setPageId(rs.getString("PAGEID"));  //pageid
                data.setlLL(rs.getInt("PAGECOUNT"));  //page访问量
                list.add(data);
            }
       }
        return list;
        
    }
	
	
}
