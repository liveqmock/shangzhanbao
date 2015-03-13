package com.mini.logistics.persistence;

import java.util.Date;
import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.logistics.data.LogisticsInfmationData;

/**
 * 
 * 物流信息操作Persistence层接口
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILogisticsInfmationPersistence extends IBasePersistence<LogisticsInfmationData> {
    
    /**
     * 
     * 添加物流信息
     * 
     * @author 左香勇 <br> 
     *		   2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   ILogisticsInfmationPersistence#addLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void addLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData);
    
    /**
     * 
     * 根据订单id和物流时间查询物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param orderId     订单id
     * @return  List<LogisticsInfmationData>  物流信息集合
     * @see   ILogisticsInfmationPersistence#getLogisticsInfmationDataByOrderIdAndTime(String)
     * @since vmaque 2.3
     */
    public LogisticsInfmationData getLogisticsInfmationDataByOrderIdAndTime(String orderId, Date time);
    
    /**
     * 
     * 根据订单id查询物流信息
     * 
     * @author 左香勇 <br> 
     *		   2014-11-19
     * @update 
     * @param orderId     订单id
     * @return  List<LogisticsInfmationData>  物流信息集合
     * @see   ILogisticsInfmationPersistence#getLogisticsInfmationDataByOrderId(String)
     * @since vmaque 2.3
     */
    public List<LogisticsInfmationData> getLogisticsInfmationDataByOrderId(String orderId);
}
