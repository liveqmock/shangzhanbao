package com.mini.purchase.orderManager.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.customerInfo.service.ICustomerInfoService;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.service.IOrderManagerService;
import com.mini.purchase.orderManager.service.OrderManagerService;
import com.sys.user.data.UserData;
/**
 * 
 * 消费者订单信息<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Component("orderManagerFacade")
public class OrderManagerFacade extends FrmFacade {
    /**
     * 消费者订单信息service层注入
     */
    @Resource(name="orderManagerService")
    private IOrderManagerService orderManagerService;
    /**
     * 消费者信息service层注入
     */
    @Resource(name="customerInfoService")
    private ICustomerInfoService customerInfoService;
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     * @return List<ConSumerOrderData> 符合查询条件商品订单信息集合
     * @since vmaque 1.5
     */
    public List<ConSumerOrderData> getConSumerOrderDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        return orderManagerService.getConSumerOrderDataList(pageRoll, conSumerOrderData);
    }
    /**
     * 
     * 创建订单和订单商品关联信息<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-11
     * @update 
     * @param commodityConfigData conSumerUserData goodsNum 用户选择购买数量
     * @return  Boolean
     * @exception/throws 
     * @see   OrderManagerService#createOrder
     * @since vmaque1.5
     */
    public ConSumerOrderData createOrder(CommodityConfigData commodityConfigData,ConSumerUserData conSumerUserData, String pageDomainName,String goodsNum){
        //生成消费者信息对象
        conSumerUserData = customerInfoService.createConSumerUserWithCreateOrder(conSumerUserData);
        //生成订单
        return orderManagerService.createOrder(commodityConfigData, conSumerUserData, pageDomainName,goodsNum);
    }
    
    /**
     * 
     * 修改订单信息
     * 
     * @author 左香勇 <br> 
     *         2014-9-12
     * @update 
     * @param [conSumerOrderData]     [修改的订单实体对象]
     * @since vmaque 1.5
     */
    public void updateConsumerOrder(ConSumerOrderData conSumerOrderData){
        orderManagerService.updateConsumerOrder(conSumerOrderData);
    }
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        return orderManagerService.getConSumerOrderGoodsInfoDataList(pageRoll, conSumerOrderData);
    }
    
    /**
     * 
     * 根据订单商品信息中间表Id查询的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-15
     * @update 
     * 
     * @param consumerOrderGoodsinfoDataId  订单商品信息中间表id
     *        
     * @return ConsumerOrderGoodsinfoData 订单商品信息中间实体
     * 
     * @since vmaque 1.5
     * 
     */
    public ConsumerOrderGoodsinfoData getConSumerOrderGoodsInfoDataById(String consumerOrderGoodsinfoDataId){
        return orderManagerService.getConSumerOrderGoodsInfoDataById(consumerOrderGoodsinfoDataId);
    }
    
    /**
     * 
     * 根据pageid订单状态统计订单数量
     * 
     * @author 左香勇 
     *         2014-9-12
     * @update 
     * @param [pageId]     [pageid]
     *        [state]   [订单状态]
     * @return  int 订单数量
     * @since vmaque 1.5
     */
    public int serachOrderNum(String pageId,int state){
        return orderManagerService.serachOrderNum(pageId,state);
    }
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-13
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        userData 用户信息
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataListBack(PageRoll pageRoll,ConSumerOrderData conSumerOrderData,UserData userData){
        return orderManagerService.getConSumerOrderGoodsInfoDataListBack(pageRoll, conSumerOrderData, userData);
    }

    /**
     * 
     * 支付成功 修改订单状态 且返回订单所对象的page<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-13
     * @update 
     * @param conSumerOrderData
     * @return  PageInfoExtraData
     * @exception/throws 
     * @see   OrderManagerFacade#paySuccessWithOrderChangeState
     * @since vmaque1.5
     */
    public PageInfoExtraData paySuccessWithOrderChangeState(ConSumerOrderData conSumerOrderData){
        return orderManagerService.paySuccessWithOrderChangeState(conSumerOrderData);
    }
    /**
     * 
     *根据微信ip查询消费者的地址 电话 名字等信息<br>
     * 
     * @author 侯杨 <br> 
     *         2014年11月24日
     * @update 
     * @param data  消费者实体
     * @return  消费者信息集合
     * @see   OrderManagerFacade#getConSumerUserDatasByOpenId(ConSumerUserData)
     * @since vmaque1.8
     */
    public List<ConSumerUserData> getConSumerUserDatasByOpenId(ConSumerUserData data) {
          return customerInfoService.getConSumerUserDatasByOpenId(data);  
    }
    /**
     * 
     *手机端，订单支付<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  data
     * @see   OrderManagerFacade#payConSumerOrderDataSuccessWeixin(ConSumerOrderData)
     * @since vmaque2.0
     */
    public ConSumerOrderData payConSumerOrderDataSuccessWeixin(ConSumerOrderData data){
      return orderManagerService.payConSumerOrderDataSuccessWeixin(data);
    }
    /**
     * 
     *手机端，订单取消<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  string
     * @see   OrderManagerFacade#OrderManagerService(ConSumerOrderData)
     * @since vmaque2.0
     */
    public String closedConSumerOrderDataWeixin(ConSumerOrderData data){
        return orderManagerService.closedConSumerOrderDataWeixin(data);  
    }
    /**
     * 
     * 根据订单查询出商品订单信息<br>
     * 
     * @author 侯杨<br> 
     *            2014年12月8日
     * @update 
     * @param conSumerOrderData
     * @return  ConsumerOrderGoodsinfoData
     * @see   OrderManagerFacade#findConSumerOrderGoodsInfoByOrderId
     * @since vmaque2.0
     */
    public ConsumerOrderGoodsinfoData findConSumerOrderGoodsInfoByOrderId(ConSumerOrderData conSumerOrderData){
        return orderManagerService.findConSumerOrderGoodsInfoByOrderId(conSumerOrderData);
    }
    
    /**
     * 
     * 根据订单id查询订单信息
     * 
     * @author 左香勇 <br> 
     *         2014年12月10日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   OrderManagerFacade#queryConSumerOrderDataById(String)
     * @since vmaque2.0
     */
    public ConSumerOrderData queryConSumerOrderDataById(String id){
        return orderManagerService.queryConSumerOrderDataById(id);
    }
}
