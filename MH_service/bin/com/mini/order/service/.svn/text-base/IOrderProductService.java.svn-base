package com.mini.order.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.mini.order.data.OrderProductData;

public interface IOrderProductService extends IService{
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
	 * 根据主键查询订单服务中间表信息
	 * @param id
	 * @return
	 */
	OrderProductData retrieve(String id);

}
