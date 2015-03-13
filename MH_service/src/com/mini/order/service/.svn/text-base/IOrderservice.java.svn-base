package com.mini.order.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.order.data.AttenInfoData;
import com.mini.order.data.InvoiceData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;

/**
 * 订单管理服务接口
 * 
 * @author 林海鹏
 * @see IOrderservice
 * @since
 */
public interface IOrderservice extends IService {

    /**
     * 新增
     */
    public void addOrder(OrderData OrderData);

    /**
     * 删除
     */
    public void deleteOrder(String[] ids);

    /**
     * 编辑信息
     */
    public void editOrder(OrderData OrderData);

    /**
     * 根据条件获取对象信息
     */
    public List<OrderData> getOrderData(JSONObject json);

    /**
     * 查询(分页显示)
     */
    public List<OrderData> getAllOrderData(PageRoll pageRoll, OrderData orderData);

    /**
     * 在支付订单的时候，如果是,更新或者增加
     * 
     * @author HY
     * @date 2014-3-24
     * @param data
     * @param userId
     * 
     */

    public void updateOrderUserInfo(String userId, String orderId);

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
    public String queryProductIdByUserId(String userId);

    // 修改用户的权限信息，根据用户id和购买发布权限的数量去更新用户的权限信息
    public void updateUserInfo(String userid, Integer amount);

    // 修改购物车对象的数据为假删，根据用户id和服务id去删除属于这个用户的发布权限的服务
    public void updateShoppingCart(String userid, String id);

    // 修改购物车对象的数据为假删,根据用户的id和page的id
    public void updateShoppingCartbypage(String userid, String pageid);

    /**
     * 
     * 根据条件查询订单<br>
     * 
     * @author 文东 <br>
     *         2014-4-14
     * @update
     * @param orderData 订单实体对象 内存放条件查询的参数
     * @return List<OrderData> 查询到的订单对象集合
     * @exception/throws
     * @see IOrderservice#getOrderData(OrderData)
     * @since
     */
    public List<OrderData> getOrderData(OrderData orderData);

    /**
     * 
     * 根据订单的某些条件查询出订单以及订单所拥有的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-15
     * @update 侯杨
     * @param orderData 订单对象 内存放条件查询的参数
     *        pageRoll 分页参数 
     * @return List<OrderData> 订单集合 内存放查询得到的结果 包含订单所拥有的服务集合
     * @exception/throws
     * @see IOrderservice#getOrderAndOrderProduct(OrderData)
     * @since
     */
    public List<OrderData> getOrderAndOrderProduct(PageRoll pageRoll,OrderData orderData);

    /****
     * 根据订单id和状态值来该变订单的状态（线下付款变为已付款）
     * 
     * @author dlm
     */
    public void updateOrderState(OrderData orderData);

    /****
     * 根据订单服务中间表id和状态值来该变订单的状态（未开通改为已开通）
     * 
     * @author dlm
     */
    public void updateOpState(OrderProductData orderProductData);

    /**
     * 根据订单id查询订单对象
     * 
     * @param orderId
     * @return
     */
    public OrderData retrieve(String orderId);

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
    public OrderData findAllOrderDatebyOrderId(String orderId);

    /**
     * 
     * 删除MINI_ORDER,同时删除MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update 侯杨
     */
    public void deleteOrderByID(String orderIds[]);

    /**
     * 
     * 删除已经完成订单，物理删除，包括订单表以及订单服务中间表<br>
     * 
     * @author 冯鑫 <br>
     *         2014-5-6
     * @update
     * @param OrderData orderData
     */
    public void deleteOnlyOrderByID(OrderData orderData);

    /**
     * 根据服务id和pageid 查询出订单id，查出订单是否存在（page编辑页面 服务）
     * 
     * @author 侯杨
     * @date 2014-05-07
     * @param data
     * @return
     */
    public String getOrderState(OrderProductData data);

    /**
     * 
     * 添加或修改订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param attenInfoData 订单信息
     * @return String 返回添加或修改成功后的id
     * @exception/throws
     * @see IOrderservice#addOrUpdateOrderAtten(AttenInfoData)
     * @since
     */
    public String addOrUpdateOrderAtten(AttenInfoData attenInfoData);

    /**
     * 
     * 根据用户id查询联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param userid 用户id
     * @return List<AttenInfoData>
     * @exception/throws
     * @see IOrderservice#searchAllByUserId(String)
     * @since
     */
    public List<AttenInfoData> searchAllByUserId(String userid);

    /**
     * 
     * 根据ID删除订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @param id 订单联系人信息id
     * @return void
     * @exception/throws
     * @see IOrderservice#delAttenOnfo(String)
     * @since
     */
    public void delAttenOnfo(String id);
    
    /**
     * 根据 用户id查询发票信息  取最近的一条数据
     * @author 侯杨
     * @date 2014-05-15
     * @param userId
     * @return
     */
    public InvoiceData getInvoiceDataByUserId(String userId);
    
}
