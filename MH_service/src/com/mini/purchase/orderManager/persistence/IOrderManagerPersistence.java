package com.mini.purchase.orderManager.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.sys.user.data.UserData;
/**
 * 
 * 消费者订单信息<br> 
 *
 * @author 冯鑫
 * @see IOrderManagerPersistence
 * @since vmaque1.5
 */
public interface IOrderManagerPersistence extends IBasePersistence<ConSumerOrderData> {
    
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
     * 根据pageId查询未处理的消费者订单<br>
     * 
     * @author 文东 <br> 
     *         2014年9月11日
     * @update 
     * @param id 微页面表数据id
     * @return  {@link Integer} 返回未处理的消费者订单数量
     * @exception/throws
     * @see   IOrderManagerPersistence#serachNotProcessOrderNum(String)
     * @since vmaque 1.5
     */
    public Integer serachNotProcessOrderNum(String id);

  
    
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
     *         2014年12月8日
     * @update 
     * @param state    订单状态
     *        pageRoll 分页查询对象
     *        
     * @return  String 符合查询条件商品订单信息json字符串
     * @see   IOrderManagerPersistence#queryGoodsOrder(PageRoll, int, String)
     * @since vmaque2.0
     */
    public String queryGoodsOrder(PageRoll pageRoll, int state, String openId);
    
    /**
     * 
     * 根据订单id查询订单信息
     * 
     * @author 左香勇 <br> 
     *		   2014年12月10日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   IOrderManagerPersistence#queryConSumerOrderDataById(String)
     * @since vmaque2.0
     */
    public ConSumerOrderData queryConSumerOrderDataById(String id);
    
}
