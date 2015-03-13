package com.mini.order.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.order.business.IOrderProductBusiness;
import com.mini.order.data.OrderProductData;
@Component("orderProductService")
public class OrderProductService  extends FrmService implements IOrderProductService{

	@Resource(name="orderProductBusiness")
	private IOrderProductBusiness orderProductBusiness;
	
	public void setOrderProductBusiness(IOrderProductBusiness orderProductBusiness) {
		this.orderProductBusiness = orderProductBusiness;
	}

	@Override
	public void addOrderProduct(OrderProductData orderProductData) {
		orderProductBusiness.addOrderProduct(orderProductData);
	}

	@Override
	public void deleteOrderProduct(String[] ids) {
		orderProductBusiness.deleteOrderProduct(ids);
	}

	@Override
	public void editOrderProduct(OrderProductData orderProductData) {
		orderProductBusiness.editOrderProduct(orderProductData);
	}

	@Override
	public List<OrderProductData> getOrderProduct(JSONObject json) {
		return orderProductBusiness.getOrderProduct(json);
	}

	/**
	 * 根据主键查询订单服务中间表信息
	 * @param id
	 * @return
	 */
	@Override
	public OrderProductData retrieve(String id) {
		return orderProductBusiness.retrieve(id);
	}

	

}
