package com.mini.order.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.order.data.OrderData;
/**
 * 订单管理久化层接口
 * 
 * @author     林海鹏
 * @see        IOrderPersistence
 * @since      
 */
public interface IOrderPersistence extends IBasePersistence<OrderData> {

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
     * 根据条件获取对象信息
     */
    public List<OrderData> getOrderDataByJson(JSONObject json);
    /**
     * 
     * 根据用户id查询此用户的所有购买的服务id
     * 
     * @author 冯鑫 <br> 
     *         2014-4-2
     * @update 
     * @param String userId
     * @return  List<String>
     */
    public String  queryProductIdByUserId(String userId);
}
