package com.mini.page.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.business.IAccesstatisticsBusiness;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageHelpData;
/**
 * 数据分析服务接口实现类
 * 
 * @author 林海鹏
 * @see AccesstatisticsService
 * @since
 */
@Component("accesstatisticsService")
public class AccesstatisticsService extends FrmService implements IAccesstatisticsService{
	@Resource(name="accesstatisticsBusiness")
	private IAccesstatisticsBusiness accesstatisticsBusiness;
	
	public void setAccesstatisticsBusiness(
			IAccesstatisticsBusiness accesstatisticsBusiness) {
		this.accesstatisticsBusiness = accesstatisticsBusiness;
	}

	@Override
	public void addAccesstatisticsData(AccesstatisticsData data) {
		// TODO Auto-generated method stub
		accesstatisticsBusiness.addAccesstatisticsData(data);
	}

	@Override
	public void deleteAccesstatisticsData(String[] ids) {
		// TODO Auto-generated method stub
		accesstatisticsBusiness.deleteAccesstatisticsData(ids);
	}

	@Override
	public void editAccesstatisticsData(AccesstatisticsData data) {
		// TODO Auto-generated method stub
		accesstatisticsBusiness.editAccesstatisticsData(data);
	}

	@Override
	public Map<String,Object> getAccesstatisticsData(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsBusiness.getAccesstatisticsData(json);
	}

	@Override
	public Map<String,Object> getCountByIpType(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsBusiness.getCountByIpType(json);
	}

	@Override
	public String getViewCount(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsBusiness.getViewCount(json);
	}

	@Override
	public String getVisitCount(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsBusiness.getVisitCount(json);
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
    @Override
    public List<AccesstatisticsData> getAllPageCount(PageRoll pageRoll, PageHelpData pageHelpData,Integer sort) {
        pageRoll = PageRoll.set(10, pageRoll);
        List<AccesstatisticsData> list=accesstatisticsBusiness.getAllPageCount(pageRoll, pageHelpData,sort);
        return list;
    }
}
