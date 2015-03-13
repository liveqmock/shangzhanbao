package com.mini.order.business;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.order.persistence.IOrderProductPersistence;

/**
 * 订单产品中间表 业务接口实现类
 * 
 * @author 林海鹏
 * @see OrderProductBusiness
 * @since
 */
@Component("orderProductBusiness")
public class OrderProductBusiness extends FrmBusiness implements IOrderProductBusiness {
    @Resource(name = "orderProductPersistence")
    private IOrderProductPersistence orderProductPersistence;

    public void setOrderProductPersistence(IOrderProductPersistence orderProductPersistence) {
        this.orderProductPersistence = orderProductPersistence;
    }

    @Override
    public void addOrderProduct(OrderProductData orderProductData) {
        // TODO Auto-generated method stub
        orderProductPersistence.add(orderProductData);
    }

    @Override
    public void deleteOrderProduct(String[] ids) {
        // TODO Auto-generated method stub
        orderProductPersistence.delete(ids);
    }

    @Override
    public void editOrderProduct(OrderProductData orderProductData) {
        // TODO Auto-generated method stub
        orderProductPersistence.editOrderProduct(orderProductData);
    }

    @Override
    public List<OrderProductData> getOrderProduct(JSONObject json) {
        // TODO Auto-generated method stub
        return orderProductPersistence.getOrderProduct(json);
    }

    @Override
    public List<OrderProductData> getOrderProductList(OrderData orderData) {
       return orderProductPersistence.getOrderProductList(orderData);
       
    }

	/**
	 * 根据主键查询订单服务中间表信息
	 * @param id
	 * @return
	 */
	@Override
	public OrderProductData retrieve(String id) {
		return orderProductPersistence.retrieve(id);
	}

}
