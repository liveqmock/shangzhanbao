package com.mini.front.analysis.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.front.analysis.facade.AccesstatisticsFacade;
import com.mini.front.pageManage.facade.PageManageFacade;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.util.DateFormatUtil;
import com.util.ReadDomain;
/**
 * 数据分析
 * @author 林海鹏
 *
 */
@ResultPath("/")
@Results( {
            @Result(name = "dataAnalysis", location = "view/pages/mini/front/analysis/pageanalysis.jsp"),
            @Result(name="bindingDomain",location="page/key/getAllPageInfo",type="redirectAction"),
            @Result(name="pageAccList",location="view/pages/mini/back/pageAccCount/pageAccList.jsp")
        })
public class AccesstatisticsAction extends FrmAction{
	
	@Resource(name="accesstatisticsFacade")
	private AccesstatisticsFacade accesstatisticsFacade;//ip地址统计表Facade实现类
	@Resource(name = "pageManageFacade")
    private PageManageFacade pageManageFacade;
	private String pageDataId;
	private String pageDataName;
	List<AccesstatisticsData> list=new ArrayList<AccesstatisticsData>();    //page访问量集合
	private PageHelpData pageHelpData = new PageHelpData(); // page帮组实体类
	private PageRoll pageRoll = new PageRoll(); // 分页
	/**
	 * 仅仅是做跳转页面用
	 * @return
	 * @update 冯鑫
	 */
	public String JumpToJsp(){
	    //将传来的PageId于PageName存放到session中
	    request.getSession().setAttribute("AccesstatisticsPageId", pageDataId);
		request.setAttribute("menuNum", 1);
		PageData pageData= new PageData();
		pageData.setId(pageDataId);
		pageDataName = pageManageFacade.findPageDataById(pageData).getName();
		//页面上需要显示page名称 可能会出现乱码  做处理
       /* try {
            pageDataName = new String(pageDataName.getBytes("UTF-8")).toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
      
		return "dataAnalysis";
	}
	
	/**
	 * 计算数据分析数据(即对当前用户下所有的page进行，按周，按设备，按地域，按page 等的访问量进行数据分析)
	 * @throws IOException
	 */
	 public void dataAnalysis() throws IOException{
	     String flag = (String)request.getSession().getAttribute("flage");
	     String sessionPageId;
	     if(null==flag||"".equals(flag)){
	         sessionPageId = (String) request.getSession().getAttribute("AccesstatisticsPageId");
	        
	     }else{
	         sessionPageId=null;
	     }
	     //获取session中存放的PageId
	     //String sessionPageId = (String) request.getSession().getAttribute("AccesstatisticsPageId");
		 	String str = request.getParameter("str")==null?"":request.getParameter("str");
			//图表初始化查询获取，所有的图表数据
		 	String endTime = DateFormatUtil.currentDate();
			List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();	
			if(str.equals("threemouth")){//三个月数据趋势图
				String startTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -90);
				list.add(weekTrend(startTime,endTime, "threemouth",sessionPageId));
	            
	            //浏览数
	            Map<String, Object> viewNum = viewNum(startTime, endTime,sessionPageId);
	            list.add(viewNum);
			}else if(str.equals("onemouth")){//一个月数据趋势图
				String startTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -DateFormatUtil.getDayOfMonth(new Date()));
				list.add(weekTrend(startTime,endTime, "onemouth",sessionPageId));
	            
	            //浏览数
	            Map<String, Object> viewNum = viewNum(startTime, endTime, sessionPageId);
	            list.add(viewNum);
			}else if(str.equals("hour")){//按小时数据趋势图
				String startTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -1);
				list.add(weekTrend(startTime,endTime, "hour",sessionPageId));
	            
	            //浏览数
	            Map<String, Object> viewNum = viewNum(startTime, endTime,sessionPageId);
	            list.add(viewNum);
			}else{
				//一周数据趋势图  （浏览数）
				String startTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -6);
				list.add(weekTrend(startTime,endTime, "week",sessionPageId));
        		//浏览数
        		Map<String, Object> viewNum = viewNum(startTime, endTime, sessionPageId);
        		list.add(viewNum);
			}
		JSONArray jArray = JSONArray.fromObject(list);
		response.getWriter().print(jArray);
	 }


	 /**
	  * 昨日浏览数
	  * @param sttartTime
	  * @param endTime
	  * @return
	  */
	private Map<String, Object> viewNum(String sttartTime, String endTime,String pageId) {
	    String yesterdayjson;
	    String onlyyesterdayjson;
	    String onlyoneweekdayjson;
	    String onlyalldayjson;
	    if(null!=pageId&&!"".equals(pageId)){
	         yesterdayjson = "{\"startTime\":\""+sttartTime+"\",\"endTime\":\""+endTime+"\",\"pageId\":\""+pageId+"\"}";// 
	         onlyyesterdayjson = "{\"startTime\":\""+DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -1)+"\",\"endTime\":\""+endTime+"\",\"pageId\":\""+pageId+"\"}";
	         onlyoneweekdayjson = "{\"startTime\":\""+DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -6)+"\",\"endTime\":\""+endTime+"\",\"pageId\":\""+pageId+"\"}";//
	         onlyalldayjson = "{\"startTime\":\"\",\"endTime\":\""+endTime+"\",\"pageId\":\""+pageId+"\"}";//
	    }else{
	         yesterdayjson = "{\"startTime\":\""+sttartTime+"\",\"endTime\":\""+endTime+"\"}";// 
	         onlyyesterdayjson = "{\"startTime\":\""+DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -1)+"\",\"endTime\":\""+endTime+"\"}";
	         onlyoneweekdayjson = "{\"startTime\":\""+DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -6)+"\",\"endTime\":\""+endTime+"\"}";//
	         onlyalldayjson = "{\"startTime\":\"\",\"endTime\":\""+endTime+"\"}";//
	    }
		
		Map<String, Object> viewMap = new HashMap<String, Object>();
		String yesterdayviewNum =  accesstatisticsFacade.getViewCount(JSONObject.fromObject(yesterdayjson));//时间区间访客数
		String onlyyesterdayviewNum =  accesstatisticsFacade.getViewCount(JSONObject.fromObject(onlyyesterdayjson));//仅仅昨日日访客数
		String onlyoneweekdayviewNum =  accesstatisticsFacade.getViewCount(JSONObject.fromObject(onlyoneweekdayjson));//仅仅一周访客数
		String onlyallviewNum =  accesstatisticsFacade.getViewCount(JSONObject.fromObject(onlyalldayjson));//所有访客数
		//System.out.println("onlyyesterdayviewNum:"+onlyyesterdayviewNum+"|onlyoneweekdayviewNum:"+onlyoneweekdayviewNum+"|onlyallviewNum:"+onlyallviewNum);
		viewMap.put("yesterdayviewNum", yesterdayviewNum);
		viewMap.put("onlyyesterdayviewNum", onlyyesterdayviewNum);
		viewMap.put("onlyoneweekdayviewNum", onlyoneweekdayviewNum);
		viewMap.put("onlyallviewNum", onlyallviewNum);
		return viewMap;
	}
	 


	/**
	 * 一周数据趋势 (默认查询)一周
	 * @param endTime 
	 * @param sttartTime 
	 * @return
	 */
	private Map<String, Object> weekTrend(String startTime, String endTime,String sign,String pageId) {
		List<String> daylist = null;
		String time;
		Map<String, Object> weekmap = new HashMap<String, Object>();
		if(null!=pageId&&!"".equals(pageId)){
		    time = "{\"startTime\":\"" + startTime + "\",\"endTime\":\"" + endTime + "\",\"sign\":\"" + sign + "\",\"pageId\":\""+pageId+"\"}";// 1 代表要走一周的算法
		}else{
		    time = "{\"startTime\":\"" + startTime + "\",\"endTime\":\"" + endTime + "\",\"sign\":\"" + sign + "\"}";// 1 代表要走一周的算法
		}
		JSONObject object = JSONObject.fromObject(time);
		Map<String, Object> wmap = accesstatisticsFacade .getAccesstatisticsData(object);
		if(object.get("sign").equals("hour")){
			 daylist = DateFormatUtil.getdayHour(endTime);
		}else if(object.get("sign").equals("threemouth")){
		    daylist =DateFormatUtil.getAllMonths(startTime.substring(0, 7), endTime.substring(0, 7));
		}else{
			 daylist = DateFormatUtil.getTimeforChar(startTime, endTime);
		}
		Integer[] arr = new Integer[wmap.size()];
		for (int i = 0; i < wmap.size(); i++) {
			arr[i] = Integer.valueOf(wmap.get(daylist.get(i)).toString());
		}
		//
		Object[] str = daylist.toArray();
		weekmap.put("wmap", arr);
		weekmap.put("xName", str);
		weekmap.put("start", startTime);
		weekmap.put("end", endTime);
		weekmap.put("weektitle", startTime + "至" + endTime );
		weekmap.put("week", "次数");
		weekmap.put("weekview", "浏览量");
		return weekmap;
	}
	 	
	 /**
	  * 按设备分析   (默认查询)一天
	  * @param mapList
	  * @param beoreDay//前天
	  * @param yesterdayView//昨天
	  * @param todayView//今天
	  * @return
	  */
	private Map<String, Object> equipmentAnalysis(String startTime, String endTime) {
		if("".equals(startTime) || "".equals(endTime)){
			startTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -2);
			endTime = DateFormatUtil.getSpecifiedDay(DateFormatUtil.currentDate(), "yyyy-MM-dd", -1);
		}
		String todayJosn = "{\"startTime\":\""+startTime+"\",\"endTime\":\""+endTime+"\"}";//
		Map<String, Object> ymap =  accesstatisticsFacade.getCountByIpType(JSONObject.fromObject(todayJosn));
		ymap.put("equipment", "按设备分析");
		return ymap;
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
    public String getAllPageCount(){
        int sort = 0;
        String s=request.getParameter("count");
                if(s!=null && !"".equals(s)){
            sort = Integer.parseInt(s);
                }
            if(sort != 0) {
                request.setAttribute("count", 0);
            }else{
                request.setAttribute("count", 1);
            }
        list=accesstatisticsFacade.getAllPageCount(pageRoll, pageHelpData,sort);
        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        return "pageAccList";
    }
	 	
	
	public AccesstatisticsFacade getAccesstatisticsFacade() {
		return accesstatisticsFacade;
	}

	public void setAccesstatisticsFacade(AccesstatisticsFacade accesstatisticsFacade) {
		this.accesstatisticsFacade = accesstatisticsFacade;
	}

    public String getPageDataId() {
        return pageDataId;
    }

    public void setPageDataId(String pageDataId) {
        this.pageDataId = pageDataId;
    }

    public String getPageDataName() {
        return pageDataName;
    }

    public void setPageDataName(String pageDataName) {
        this.pageDataName = pageDataName;
    }

    public PageManageFacade getPageManageFacade() {
        return pageManageFacade;
    }

    public void setPageManageFacade(PageManageFacade pageManageFacade) {
        this.pageManageFacade = pageManageFacade;
    }

    public List<AccesstatisticsData> getList() {
        return list;
    }

    public void setList(List<AccesstatisticsData> list) {
        this.list = list;
    }

    public PageHelpData getPageHelpData() {
        return pageHelpData;
    }

    public void setPageHelpData(PageHelpData pageHelpData) {
        this.pageHelpData = pageHelpData;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }
	
}
