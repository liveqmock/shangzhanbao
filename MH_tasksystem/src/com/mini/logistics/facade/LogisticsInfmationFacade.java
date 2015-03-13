package com.mini.logistics.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.logistics.data.LogisticsInfmationData;
import com.mini.logistics.service.ILogisticsInfmationService;

/**
 * 
 * 物流信息操作Facade层
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("logisticsInfmationFacade")
public class LogisticsInfmationFacade extends FrmFacade {
   
    @Resource(name="logisticsInfmationService")
    private ILogisticsInfmationService logisticsInfmationService;
    
    /**
     * 
     * 添加物流信息
     * 
     * @author 左香勇 <br> 
     *         2014-11-19
     * @update 
     * @param logisticsInfmationData    物流信息实体对象
     * 
     * @see   LogisticsInfmationFacade#addLogisticsInfmationData(LogisticsInfmationData);
     * @since vmaque 2.3
     */
    public void addLogisticsInfmationData(LogisticsInfmationData logisticsInfmationData){
        logisticsInfmationService.addOrUpdateLogisticsInfmationData(logisticsInfmationData);
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
     * @see   LogisticsInfmationFacade#getLogisticsInfmationDataByOrderId(String)
     * @since vmaque 2.3
     */
    public List<LogisticsInfmationData> getLogisticsInfmationDataByOrderId(String orderId){
        return logisticsInfmationService.getLogisticsInfmationDataByOrderId(orderId);
    }
}
