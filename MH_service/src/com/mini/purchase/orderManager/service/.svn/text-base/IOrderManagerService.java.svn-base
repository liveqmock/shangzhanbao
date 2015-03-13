package com.mini.purchase.orderManager.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.sys.user.data.UserData;

/**
 * 
 *  消费者订单信息<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see IOrderManagerService
 * @since vmaque1.5
 */
public interface IOrderManagerService extends IService {
    
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
    public List<ConSumerOrderData> getConSumerOrderDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData);
    
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
    public ConSumerOrderData createOrder(CommodityConfigData commodityConfigData,ConSumerUserData conSumerUserData,String pageDomainName,String goodsNum);
    
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
    public void updateConsumerOrder(ConSumerOrderData conSumerOrderData);
    
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
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData);
    
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
    public ConsumerOrderGoodsinfoData getConSumerOrderGoodsInfoDataById(String consumerOrderGoodsinfoDataId);
    
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
    public int serachOrderNum(String pageId,int state);
    
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
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataListBack(PageRoll pageRoll,ConSumerOrderData conSumerOrderData,UserData userData);

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
     * @see   IOrderManagerService#paySuccessWithOrderChangeState
     * @since vmaque1.5
     */
    public PageInfoExtraData paySuccessWithOrderChangeState(ConSumerOrderData conSumerOrderData);

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
    public List<ConsumerOrderGoodsinfoData> getAccountList(PageRoll pageRoll,Integer state);
    
    /**
     * 
     * 计算订单总金额
     * 
     * @author 左香勇 <br> 
     *         2014-9-25
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @return  double 订单总金额
     * @since vmaque2.0
     */
    public double getSumAccount();
    
    /**
     * 
     * 微信接口查询商品订单数据信息（只提供给微信使用）
     * 
     * @author 左香勇
     *		   2014年12月8日
     * @update 
     * @param state    订单状态
     *        pageRoll 分页查询对象
     *        
    * @return  String 符合查询条件商品订单信息json字符串
     * @see   IOrderManagerService#queryGoodsOrder(PageRoll, int, String)
     * @since vmaque2.0
     */
    public String queryGoodsOrder(PageRoll pageRoll, int state, String openId);
    
    /**
     * 
     *手机端，订单支付<br>
     * 
     * @author hy <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  data
     * @see   IOrderManagerService#payConSumerOrderDataSuccessWeixin(ConSumerOrderData)
     * @since vmaque2.0
     */
    public ConSumerOrderData payConSumerOrderDataSuccessWeixin(ConSumerOrderData data);
    /**
     * 
     *手机端，订单取消<br>
     * 
     * @author hy <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  string
     * @see   IOrderManagerService#closedConSumerOrderDataWeixin(ConSumerOrderData)
     * @since vmaque2.0
     */
    public String closedConSumerOrderDataWeixin(ConSumerOrderData data);
    /**
     * 
     * 根据订单查询出商品订单信息<br>
     * 
     * @author 侯杨<br> 
     *            2014年12月8日
     * @update 
     * @param conSumerOrderData
     * @return  ConsumerOrderGoodsinfoData
     * @see   IOrderManagerService#findConSumerOrderGoodsInfoByOrderId
     * @since vmaque2.0
     */
    public ConsumerOrderGoodsinfoData findConSumerOrderGoodsInfoByOrderId(ConSumerOrderData conSumerOrderData);
    
    /**
     * 
     * 根据订单id查询订单信息
     * 
     * @author 左香勇 <br> 
     *         2014年12月10日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   IOrderManagerService#queryConSumerOrderDataById(String)
     * @since vmaque2.0
     */
    public ConSumerOrderData queryConSumerOrderDataById(String id);
    
    /**
     * 
     * 根据订单id删除订单信息
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   IOrderManagerService#deleteGoodsOrder(String)
     * @since vmaque2.0
     */
    public void deleteGoodsOrder(String orderid) throws Exception;
    
}
