package com.mini.order.persistence;


import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
/**
 * 订单产品中间表 管理久化层接口实现类
 * 
 * @author     林海鹏
 * @see        OrderProductPersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("orderProductPersistence")
public class OrderProductPersistence extends BasePersistence<OrderProductData> implements
IOrderProductPersistence {

	@Override
	public void addOrderProduct(OrderProductData orderProductData) {
		add(orderProductData);
	}

	@Override
	public void deleteOrderProduct(String[] ids) {
		delete(ids);
		
	}

	@Override
	public void editOrderProduct(OrderProductData orderProductData) {
		update(orderProductData);
	}
	/**
	 * 更新状态值
	 */
	@Override
	public void updateOrderProduct(OrderProductData orderProductData) {
		String sql = "update MINI_ORDER_PRODUCT set state = '"+orderProductData.getState()+"'  where id = '"+orderProductData.getId()+"'";
		executeSQL(sql);
	}

	@Override
	public List<OrderProductData> getOrderProduct(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("from OrderProductData bd  where 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}

	private String getInquiresTheConditions(JSONObject obj) {
        StringBuffer whereSQL = new StringBuffer();
        if (obj != null && !obj.isNullObject()) {
            if(null != obj.get("id")){
                String id = obj.getString("id");
                if(null!=id && !"".equals(id)){
                    whereSQL.append(" AND bd.id = '").append(id).append("'");    
                }
            }
            if(null != obj.get("orderId")){//订单id
            	String orderId = obj.getString("orderId");
            	if(null!=orderId && !"".equals(orderId)){
            		whereSQL.append(" AND bd.orderId = '").append(orderId).append("'");    
            	}
            }
        }
        return whereSQL.toString();
    }


	@Override
	public List<OrderProductData> getOrderProductList(OrderData orderData) {
	    // 定义条件查询的HQL语句
	    String hql = "from OrderProductData o where o.orderId = ?";
	    return search(hql, new Object[]{orderData.getId()});
	    
	}
}