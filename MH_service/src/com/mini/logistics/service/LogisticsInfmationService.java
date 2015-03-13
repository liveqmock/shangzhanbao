package com.mini.logistics.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.itour.etip.pub.frame.FrmService;
import com.mini.logistics.business.ILogisticsInfmationBusiness;
import com.mini.logistics.data.LogisticsInfmationData;

/**
 * 
 * 物流信息操作Service层
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("logisticsInfmationService")
public class LogisticsInfmationService extends FrmService implements ILogisticsInfmationService {
   
    @Resource(name="logisticsInfmationBusiness")
    private ILogisticsInfmationBusiness logisticsInfmationBusiness;
    
    /**
     * 
     * 添加或修改物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   LogisticsInfmationService#addLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void addOrUpdateLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData){
        LogisticsInfmationData data = logisticsInfmationBusiness.getLogisticsInfmationDataByOrderIdAndTime(logisticsInfmationData.getConsumerOrderId(),logisticsInfmationData.getTime());
        if(data == null){
            logisticsInfmationData.setCreateTime(new Date());
            logisticsInfmationBusiness.addLogisticsInfmationData(logisticsInfmationData);
        } else {
            data.setContext(logisticsInfmationData.getContext());
            data.setTime(logisticsInfmationData.getTime());
            data.setUpdateTime(new Date());
            logisticsInfmationBusiness.updateLogisticsInfmationData(data);
        }
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
     * @see   LogisticsInfmationService#getLogisticsInfmationDataByOrderId(String)
     * @since vmaque 2.3
     */
    public List<LogisticsInfmationData> getLogisticsInfmationDataByOrderId(String orderId){
        return logisticsInfmationBusiness.getLogisticsInfmationDataByOrderId(orderId);
    }
}
