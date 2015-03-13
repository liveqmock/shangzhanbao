package com.mini.order.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.order.business.IOrderProductBusiness;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
/**
 * 订单产品中间表 管理久化层接口
 * 
 * @author     林海鹏
 * @see        IOrderProductPersistence
 * @since      
 */
public interface IOrderProductPersistence  extends IBasePersistence<OrderProductData> {
	/**
	 * 新增
	 * @param orderProductData
	 */
	void addOrderProduct(OrderProductData orderProductData);
	/**
	 * 修改
	 * @param orderProductData
	 */
	void editOrderProduct(OrderProductData orderProductData);
	/**
	 * 删除
	 * @param ids
	 */
	void deleteOrderProduct(String[] ids);//删除订单
	
	 /**
     * 根据条件获取对象信息
     */
    public List<OrderProductData> getOrderProduct(JSONObject json);
    /**
     * 更新状态值
     */
    public void updateOrderProduct(OrderProductData orderProductData);
    /**
     * 
     * 根据订单id  查询订单服务集合<br>
     * 
     * @author 侯杨 <br>
     *         2014-4-15
     * @param orderData 订单对象 内存放条件查询的参数
     * @return List<OrderProductData> 订单所拥有的服务集合
     * @exception/throws
     * @see IOrderProductBusiness#getOrderProduct(OrderData)
     * @since
     */
    public List<OrderProductData> getOrderProductList(OrderData orderData);
}
