package com.mini.front.analysis.facade;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageHelpData;
import com.mini.page.service.IAccesstatisticsService;
/**
 * 数据分析Facade
 * 
 * @author 林海鹏
 * @see AccesstatisticsFacade
 * @since
 */
@Component("accesstatisticsFacade")
public class AccesstatisticsFacade extends FrmFacade{
	@Resource(name="accesstatisticsService")
	private IAccesstatisticsService accesstatisticsService;
	
	public void setAccesstatisticsService(IAccesstatisticsService accesstatisticsService) {
		this.accesstatisticsService = accesstatisticsService;
	}

	public void addAccesstatisticsData(AccesstatisticsData data) {
		accesstatisticsService.addAccesstatisticsData(data);
	}

	public void deleteAccesstatisticsData(String[] ids) {
		accesstatisticsService.deleteAccesstatisticsData(ids);
	}

	public void editAccesstatisticsData(AccesstatisticsData data) {
		accesstatisticsService.editAccesstatisticsData(data);
	}

	public Map<String,Object> getAccesstatisticsData(JSONObject json) {
		return accesstatisticsService.getAccesstatisticsData(json);
	}
	public Map<String,Object> getCountByIpType(JSONObject json) {
		return accesstatisticsService.getCountByIpType(json);
	}
	public String getViewCount(JSONObject json) {
		return accesstatisticsService.getViewCount(json);
	}
	public String getVisitCount(JSONObject json) {
		return accesstatisticsService.getVisitCount(json);
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
        return accesstatisticsService.getAllPageCount(pageRoll, pageHelpData,sort);
    }
}
