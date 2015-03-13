package com.mini.logistics.business;

import java.util.Date;
import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.logistics.data.LogisticsInfmationData;

/**
 * 
 * 物流信息操作Business层接口
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILogisticsInfmationBusiness extends IBusiness {
 
    /**
     * 
     * 添加物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   ILogisticsInfmationBusiness#addLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void addLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData);
    
    /**
     * 
     * 修改物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   ILogisticsInfmationBusiness#updateLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void updateLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData);
 
    /**
     * 
     * 根据订单id和物流时间查询物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param orderId     订单id
     * @return  List<LogisticsInfmationData>  物流信息集合
     * @see   ILogisticsInfmationBusiness#getLogisticsInfmationDataByOrderIdAndTime(String)
     * @since vmaque 2.3
     */
    public LogisticsInfmationData getLogisticsInfmationDataByOrderIdAndTime(String orderId, Date time);
    
    /**
     * 
     * 根据订单id查询物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param orderId     订单id
     * @return  List<LogisticsInfmationData>  物流信息集合
     * @see   ILogisticsInfmationBusiness#getLogisticsInfmationDataByOrderId(String)
     * @since vmaque 2.3
     */
    public List<LogisticsInfmationData> getLogisticsInfmationDataByOrderId(String orderId);
}
