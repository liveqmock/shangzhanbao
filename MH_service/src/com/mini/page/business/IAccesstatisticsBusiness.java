package com.mini.page.business;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.data.MessageData;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageHelpData;
/**
 * 数据分析业务接口
 * 
 * @author 林海鹏
 * @see IAccesstatisticsBusiness
 * @since
 */
public interface IAccesstatisticsBusiness extends IBusiness {

    /**
     * 新增
     */
    public void addAccesstatisticsData(AccesstatisticsData data);
    /**
     * 删除
     */
    public void deleteAccesstatisticsData(String[] ids);
    /**
     * 编辑
     */
    public void editAccesstatisticsData(AccesstatisticsData data);
    /**
     * 根据条件获取对象
     */
    public Map<String,Object> getAccesstatisticsData(JSONObject json);
    /**
     * 根据设备类型来统计
     * @param json
     * @return
     */
    public Map<String,Object> getCountByIpType(JSONObject json);
    /**
     * 计算浏览数专用方法
     * @param json
     * @return
     */
    public String getViewCount(JSONObject json);
    /**
     * 计算访客数专用方法
     * @param json
     * @return
     */
    public String getVisitCount(JSONObject json);
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
    public List<AccesstatisticsData> getAllPageCount(PageRoll pageRoll, PageHelpData pageHelpData,Integer sort);
}
