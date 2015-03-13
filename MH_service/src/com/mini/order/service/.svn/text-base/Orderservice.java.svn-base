package com.mini.order.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.order.business.IOrderBusiness;
import com.mini.order.business.IOrderProductBusiness;
import com.mini.order.data.AttenInfoData;
import com.mini.order.data.InvoiceData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;

/**
 * 订单管理服务接口实现类
 * 
 * @author 林海鹏
 * @see IOrderservice
 * @since
 */
@Component("orderservice")
public class Orderservice extends FrmService implements IOrderservice {
    @Resource(name = "orderBusiness")
    private IOrderBusiness orderBusiness;

    // 订单所拥有的服务业务接口 容器注入
    @Resource(name = "orderProductBusiness")
    private IOrderProductBusiness orderProductBusiness;

    public void setOrderBusiness(IOrderBusiness orderBusiness) {
        this.orderBusiness = orderBusiness;
    }

    @Override
    public void addOrder(OrderData OrderData) {
        orderBusiness.addOrder(OrderData);
    }

    @Override
    public void deleteOrder(String[] ids) {
        orderBusiness.deleteOrder(ids);
    }

    @Override
    public void editOrder(OrderData OrderData) {
        orderBusiness.editOrder(OrderData);
    }

    /****
     * 运营人员后台根据查询条件和状态分页查询所有的订单
     * 
     * @author dlm
     */
    @Override
    public List<OrderData> getAllOrderData(PageRoll pageRoll, OrderData orderData) {
        pageRoll = PageRoll.set(10, pageRoll);
        return orderBusiness.getAllOrderData(pageRoll, orderData);
    }

    @Override
    public List<OrderData> getOrderData(JSONObject json) {
        return orderBusiness.getOrderData(json);
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
    @Override
    public void updateOrderUserInfo(String userId, String orderId) {
        orderBusiness.updateOrderUserInfo(userId, orderId);
    }

    /*
     * (non-Javadoc)
     * @see com.mini.order.service.IOrderservice#queryProductIdByUserId(java.lang.String)
     */
    @Override
    public String queryProductIdByUserId(String userId) {
        return orderBusiness.queryProductIdByUserId(userId);
    }

    // 修改用户的权限信息，根据用户id和购买发布权限的数量去更新用户的权限信息
    @Override
    public void updateUserInfo(String userid, Integer amount) {
        orderBusiness.updateUserInfo(userid, amount);

    }

    // 修改购物车对象的数据为假删，根据用户id和服务id去删除属于这个用户的发布权限的服务
    @Override
    public void updateShoppingCart(String userid, String id) {
        orderBusiness.updateShoppingCart(userid, id);

    }

    // 修改购物车对象的数据为假删,根据用户的id和page的id
    @Override
    public void updateShoppingCartbypage(String userid, String pageid) {
        orderBusiness.updateShoppingCartbypage(userid, pageid);
    }

    @Override
    public List<OrderData> getOrderData(OrderData orderData) {
        return orderBusiness.getOrderData(orderData);
    }

    @SuppressWarnings("static-access")
    @Override
    public List<OrderData> getOrderAndOrderProduct(PageRoll pageRoll,OrderData orderData) {
        pageRoll = pageRoll.set(Page.SIZE_10, pageRoll);
        // 获取查询得到的订单集合
        return  orderBusiness.getOrderDataList(pageRoll,orderData);
    }

    /****
     * 根据订单服务中间表id和状态值来该变订单的状态（未开通改为已开通）
     * 
     * @author dlm
     */
    @Override
    public void updateOpState(OrderProductData orderProductData) {
        orderBusiness.updateOpState(orderProductData);
    }

    /****
     * 根据订单id和状态值来该变订单的状态（线下付款变为已付款）
     * 
     * @author dlm
     */
    @Override
    public void updateOrderState(OrderData orderData) {
        orderBusiness.updateOrderState(orderData);
    }

    /**
     * 根据订单id查询订单对象
     * 
     * @param orderId
     * @return
     */
    @Override
    public OrderData retrieve(String orderId) {
        return orderBusiness.retrieve(orderId);
    }

    /**
     * 
     * 更具订单id和用户id查询订单的详细信息 包括实名认证信息和发票信息<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-22
     * @update
     * @param orderId 订单id 必须不为空 userId 当前登录用户id 必须不为空
     * @return OrderData
     */
    public OrderData findAllOrderDatebyOrderId(String orderId) {
        return orderBusiness.findAllOrderDatebyOrderId(orderId);
    }

    /**
     * 
     * 删除MINI_ORDER,同时删除MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update 侯杨
     */
    public void deleteOrderByID(String orderIds[]) {
        // 如果订单id数组不为空，就循环删除订单数据
        if (orderIds != null) {
            for (int i = 0; i < orderIds.length; i++) {
                orderBusiness.deleteOrderByID(orderIds[i]);
            }
        }
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
        orderBusiness.deleteOnlyOrderByID(orderData);
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
        return orderBusiness.getOrderState(data);
    }

    @Override
    public String addOrUpdateOrderAtten(AttenInfoData attenInfoData) {
        return orderBusiness.addOrUpdateOrderAtten(attenInfoData);
    }

    @Override
    public List<AttenInfoData> searchAllByUserId(String userid) {

        return orderBusiness.searchAllByUserId(userid);
    }

    @Override
    public void delAttenOnfo(String id) {
        orderBusiness.delAttenInfo(id);

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
        return orderBusiness.getInvoiceDataByUserId(userId);
    }
}
