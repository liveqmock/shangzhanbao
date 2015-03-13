package com.mini.front.order.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.order.data.AttenInfoData;
import com.mini.order.data.InvoiceData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.order.service.IOrderservice;

/**
 * 订单管理facade层
 * 
 * @author 林海鹏
 * @see OrderFacade
 * @since
 * 
 */
@Component("orderFacade")
public class OrderFacade extends FrmFacade {
    @Resource(name = "orderservice")
    private IOrderservice orderservice;

    public void setOrderservice(IOrderservice orderservice) {
        this.orderservice = orderservice;
    }

    public void addOrder(OrderData OrderData) {
        orderservice.addOrder(OrderData);
    }

    public void deleteOrder(String[] ids) {
        orderservice.deleteOrder(ids);
    }

    public void editOrder(OrderData OrderData) {
        orderservice.editOrder(OrderData);
    }

    public List<OrderData> getAllOrderData(PageRoll pageRoll, OrderData orderData) {
        return orderservice.getAllOrderData(pageRoll, orderData);
    }

    public List<OrderData> getOrderData(JSONObject json) {
        return orderservice.getOrderData(json);
    }

    /**
     * 在支付订单的时候，如果是,更新或者增加
     * 
     * @author HY
     * @date 2014-3-24
     * @param data
     * @param userId
     * 
     */

    public void updateOrderUserInfo(String userId, String orderId) {
        orderservice.updateOrderUserInfo(userId, orderId);
    }

    /**
     * 
     * 根据用户id查询此用户的所有购买的服务id
     * 
     * @author 冯鑫 <br>
     *         2014-4-2
     * @update
     * @param String userId
     * @return List<String>
     */
    public String queryProductIdByUserId(String userId) {
        return orderservice.queryProductIdByUserId(userId);
    }

    // 修改用户的权限信息，根据用户id和购买发布权限的数量去更新用户的权限信息
    public void updateUserInfo(String userid, Integer amount) {
        orderservice.updateUserInfo(userid, amount);

    }

    // 修改购物车对象的数据为假删，根据用户id和服务id去删除属于这个用户的发布权限的服务
    public void updateShoppingCart(String userid, String id) {
        orderservice.updateShoppingCart(userid, id);

    }

    // 修改购物车对象的数据为假删,根据用户的id和page的id
    public void updateShoppingCartbypage(String userid, String pageid) {
        orderservice.updateShoppingCartbypage(userid, pageid);
    }

    /**
     * 
     * 根据参数条件查询订单集合<br>
     * 
     * @author 文东 <br>
     *         2014-4-14
     * @update
     * @param orderData 订单对象 存放条件查询的参数集合
     * @return List<OrderData> 订单对象集合
     * @exception/throws
     * @see OrderFacade#getOrderData(OrderData);
     * @since
     */
    public List<OrderData> getOrderData(OrderData orderData) {
        return orderservice.getOrderData(orderData);
    }

    /**
     * 
     * 根据用户ID查询订单以及订单所包含的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-15
     * @update 侯杨
     * @param orderData  订单实体
     *        pageRoll  分页参数
     * @return List<OrderData> 订单集合 内存有订单所拥有的服务集合
     * @exception/throws
     * @see OrderFacade#getOrderAndOrderProduct(String)
     * @since
     */
    public List<OrderData> getOrderAndOrderProduct(PageRoll pageRoll,OrderData orderData) {
        return orderservice.getOrderAndOrderProduct(pageRoll,orderData);
    }

    /**
     * 根据订单id查询订单对象
     * 
     * @param orderId
     * @return
     */
    public OrderData retrieve(String orderId) {
        return orderservice.retrieve(orderId);
    }

    /**
     * 
     * 删除MINI_ORDER,同时删除MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update
     */
    public void deleteOrderByID(String orderIds[]) {
        orderservice.deleteOrderByID(orderIds);
    }

    /**
     * 
     * 删除已经完成订单，物理删除，包括订单表以及订单服务中间表<br>
     * 
     * @author 冯鑫 <br>
     *         2014-5-6
     * @update
     * @param OrderData orderData
     */
    public void deleteOnlyOrderByID(OrderData orderData) {
        orderservice.deleteOnlyOrderByID(orderData);
    }

    /**
     * 前端用户查询订单详情，和后台调用一个方法
     * 
     * @param id
     * @return
     */
    public OrderData findOrderView(String id) {
        return orderservice.findAllOrderDatebyOrderId(id);
    }

    /**
     * 根据服务id和pageid 查询出订单id，查出订单是否存在（page编辑页面 服务）
     * 
     * @author 侯杨
     * @date 2014-05-07
     * @param data
     * @return
     */
    public String getOrderState(OrderProductData data) {
        return orderservice.getOrderState(data);
    }

    /**
     * 
     * 添加订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param attenInfoData
     * @return String 返回添加后的id
     * @exception/throws
     * @see OrderFacade#ajaxAddOrderAtten(AttenInfoData)
     * @since
     */
    public String ajaxAddOrderAtten(AttenInfoData attenInfoData) {
        return orderservice.addOrUpdateOrderAtten(attenInfoData);
    }

    /**
     * 
     * 根据当前登陆的用户信息查询该用户拥有的订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param userid 用户id
     * @return List<AttenInfoData> 订单联系人信息集合
     * @exception/throws
     * @see OrderFacade#searchAllByUserId(String)
     * @since
     */
    public List<AttenInfoData> searchAllByUserId(String userid) {
        return orderservice.searchAllByUserId(userid);
    }

    /**
     * 
     * 根据ID删除订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param id 订单联系人信息id
     * @return List<AttenInfoData> 订单联系人信息集合
     * @exception/throws
     * @see OrderFacade#delAttenOnfo(String)(String)
     * @since
     */
    public void delAttenOnfo(String id) {
        orderservice.delAttenOnfo(id);
    }

    /**
     * 根据 用户id查询发票信息 取最近的一条数据
     * 
     * @author 侯杨
     * @date 2014-05-15
     * @param userId
     * @return
     */
    public InvoiceData getInvoiceDataByUserId(String userId) {
        return orderservice.getInvoiceDataByUserId(userId);
    }
}
