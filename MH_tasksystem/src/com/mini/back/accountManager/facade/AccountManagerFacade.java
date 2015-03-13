package com.mini.back.accountManager.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.service.IOrderManagerService;

/**
 * 
 * 后台计费管理facade层
 *
 * @author 左香勇
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Component("accountManagerFacade")
public class AccountManagerFacade extends FrmFacade {
  
    @Resource(name="orderManagerService")
    private IOrderManagerService orderManagerService;
    
    /**
     * 
     * 根据处理状态查询计费信息
     * 
     * @author 左香勇 
     *         2014-9-25
     * @update 
     * 
     * @param state     处理状态
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 计费信息
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getAccountList(PageRoll pageRoll,Integer state){
        return orderManagerService.getAccountList(pageRoll, state);
    }
    
    /**
     * 
     * 修改订单信息
     * 
     * @author 左香勇 <br> 
     *         2014-9-25
     * @update 
     * @param [conSumerOrderData]     [修改的订单实体对象]
     * @since vmaque 1.5
     */
    public void updateConsumerOrder(ConSumerOrderData conSumerOrderData){
        orderManagerService.updateConsumerOrder(conSumerOrderData);
    }
    
    /**
     * 
     * 计算订单总金额
     * 
     * @author 左香勇 <br> 
     *		   2014-9-25
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @return  double 订单总金额
     * @since vmaque2.0
     */
    public double getSumAccount(){
        return orderManagerService.getSumAccount();
    }
    
}
