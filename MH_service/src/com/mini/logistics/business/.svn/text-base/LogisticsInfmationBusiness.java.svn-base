package com.mini.logistics.business;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.logistics.data.LogisticsInfmationData;
import com.mini.logistics.persistence.ILogisticsInfmationPersistence;

/**
 * 
 * 物流信息操作Business层
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("logisticsInfmationBusiness")
public class LogisticsInfmationBusiness extends FrmBusiness implements ILogisticsInfmationBusiness {
 
    @Resource(name="logisticsInfmationPersistence")
    private ILogisticsInfmationPersistence logisticsInfmationPersistence;
    
    /**
     * 
     * 添加物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   LogisticsInfmationBusiness#addLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void addLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData){
        logisticsInfmationPersistence.add(logisticsInfmationData);
    }
    
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
    public void updateLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData){
        logisticsInfmationPersistence.update(logisticsInfmationData);
    }
 
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
    public LogisticsInfmationData getLogisticsInfmationDataByOrderIdAndTime(String orderId, Date time){
        return logisticsInfmationPersistence.getLogisticsInfmationDataByOrderIdAndTime(orderId, time);
    }
    
    
    /**
     * 
     * 根据订单id查询物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param orderId     订单id
     * @return  List<LogisticsInfmationData>  物流信息集合
     * @see   LogisticsInfmationBusiness#getLogisticsInfmationDataByOrderId(String)
     * @since vmaque 2.3
     */
    public List<LogisticsInfmationData> getLogisticsInfmationDataByOrderId(String orderId){
        return logisticsInfmationPersistence.getLogisticsInfmationDataByOrderId(orderId);
    }
    
}
