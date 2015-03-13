package com.mini.foreign.goodsOrder.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.PageRoll;
import com.mini.purchase.orderManager.service.IOrderManagerService;

@Component("goodsOrderFacade")
public class GoodsOrderFacade {
    
    @Resource(name="orderManagerService")
    private IOrderManagerService orderManagerService;
    
    /**
     * 
     * 根据订单id删除订单信息<br>
     * 
     * @author 左香勇 <br> 
     *		   2015年1月22日
     * @param orderid     订单id
     * @see   GoodsOrderFacade#deleteGoodsOrder(String)
     * @since vmaque2.0
     */
    public void deleteGoodsOrder(String orderid){
        
    }
    
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
     * @see   GoodsOrderFacade#queryGoodsOrder(PageRoll, int, String)
     * @since vmaque2.0
     */
    public String queryGoodsOrder(PageRoll pageRoll, int state, String openId){
        return orderManagerService.queryGoodsOrder(pageRoll, state, openId);
    }
    
}
