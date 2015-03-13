package com.mini.order.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
/**
 * 订单管理久化层接口实现类
 * 
 * @author     林海鹏
 * @see        IOrderPersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("orderPersistence")
public class OrderPersistence extends BasePersistence<OrderData> implements IOrderPersistence{

	@Override
	public void addOrder(OrderData OrderData) {
		add(OrderData);
	}

	@Override
	public void deleteOrder(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			String ordersql = "delete from MINI_ORDER where id = '"+ids[i]+"'";
			String sql = "delete from MINI_ORDER_PRODUCT where orderid = '"+ids[i]+"'";
			executeSQL(sql);
			executeSQL(ordersql);
		}
	}

	@Override
	public void editOrder(OrderData orderData) {
		//修改当前付款时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		java.util.Date date=new java.util.Date();       //获取当前时间
		String str=sdf.format(date);    //转化为string类型的
		String sql = "update MINI_ORDER set state = '"+orderData.getState()+"',payTime=to_date('"+str+"','yyyy-mm-dd hh24:mi:ss')  where id = '"+orderData.getId()+"'";
		executeSQL(sql);
	}

    /****
     * 运营人员后台根据查询条件和状态分页查询所有的订单
     * @author dlm
     */
	@Override
	public List<OrderData> getAllOrderData(PageRoll pageRoll, OrderData orderData) {
		
		//定义查询语句
		StringBuffer hql = new StringBuffer(" from OrderData o where 1=1 ");
		
		/*根据搜索条件拼接查询条件star*/
		List<Object> objList = new ArrayList<Object>();
		//根据状态来判断
		if(orderData.getState()!=null){
			hql.append(" and o.state = ?");
			objList.add(orderData.getState());
		}
		//根据订单编号查询
		if(orderData.getCode()!=null && !"".equals(orderData.getCode())){
			hql.append(" and o.code like ?");
			objList.add("%"+orderData.getCode()+"%");
		}
		//订单创建的起始时间
		if(orderData.getCreateTime()!=null){
			hql.append(" and o.createTime >=?");
			objList.add(orderData.getCreateTime());
		}
		//订单创建的查询的截止时间（这里用modifytime字段来帮组传值）
		if(orderData.getModifyTime()!=null){
			hql.append(" and o.createTime <=?");
			objList.add(orderData.getModifyTime());
		}
		/*根据搜索条件拼接查询条件end*/
		
		
		hql.append(" order by o.createTime desc");
			
		//分页属性
		pageRoll.setSearchSQL(hql.toString());
		pageRoll.setCountSQL("select count(*) " + hql.toString());

		//返回查询出来的集合
		return this.search(pageRoll,objList).getList();
	}

	@Override
	public List<OrderData> getOrderData(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("select cd.id as cid,cd.pageid, bd.id, cd.productid,  bd.code,  bd.pageproductid,  bd.state,  cd.productname,  cd.productconfigname,  cd.unitprice,  cd.amount,  bd.price from MINI_ORDER bd, MINI_ORDER_PRODUCT cd,ctn_sysuser a  where bd.id = cd.orderid and bd.sysuserid = a.id");
        querySQL.append(this.getInquiresTheConditions(json));//调用与拼接条件
        StringBuffer ordrSQL = new StringBuffer("select bd.id,bd.code from MINI_ORDER bd,ctn_sysuser a where bd.sysuserid = a.id");
        ordrSQL.append(this.getInquiresTheConditions(json));//调用与拼接条件
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> orders = dao.queryForList(ordrSQL.toString(), null);//订单表查询集合
        
        List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);//连表查询集合
        List<OrderData> orderlist = new ArrayList<OrderData>();
        for (int j = 0; j < orders.size(); j++) {//格式化数据 格式化成一个List中带有一个订单对象和一个 OrderProductData对象形成的集合
        	OrderData orderData = new OrderData();
        	List<OrderProductData> orderProductList = new ArrayList<OrderProductData>();
        	for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getString("ID").equals(orders.get(j).getString("ID"))){
					orderData.setId(list.get(i).getString("ID"));
					orderData.setCode(list.get(i).getString("CODE"));
		        	orderData.setPrice(list.get(i).getDouble("PRICE"));
		        	orderData.setState(list.get(i).getInt("STATE"));
		        	orderData.setPageProductId(list.get(i).getString("PAGEPRODUCTID"));
	        		OrderProductData orderProductData = new OrderProductData();
	        		orderProductData.setId(list.get(i).getString("CID"));
	        		orderProductData.setProductName(list.get(i).getString("PRODUCTNAME"));
	            	orderProductData.setAmount(list.get(i).getInt("AMOUNT"));
	            	orderProductData.setProductConfigName(list.get(i).getString("PRODUCTCONFIGNAME"));
	            	orderProductData.setUnitPrice(list.get(i).getDouble("UNITPRICE"));
	            	orderProductData.setProductId(list.get(i).getString("PRODUCTID"));
	            	orderProductData.setPageId(list.get(i).getString("PAGEID"));
	            	orderProductData.setOrderId(orders.get(j).getString("ID"));
	            	orderProductList.add(orderProductData);
	            	orderData.setOrderProductDatas(orderProductList); 
	        	}
			}
        	if (orderData.getOrderProductDatas()!=null) {
        		orderlist.add(orderData);
			}
		}
		return orderlist;
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
            if(null != obj.get("startTime")){
            	String startTime = obj.getString("startTime");
            	if(null!=startTime && !"".equals(startTime)){
            		whereSQL.append(" AND bd.accessTime >= to_date('"+startTime+"','yyyy-MM-dd')");    
            	}
            }
            if(null != obj.get("endTime")){
            	String endTime = obj.getString("endTime");
            	if(null!=endTime && !"".equals(endTime)){
            		whereSQL.append(" AND bd.accessTime < to_date('").append(endTime).append("','yyyy-MM-dd')");    
            	}
            }
            if(null != obj.get("userid")){
            	String userid = obj.getString("userid");
            	if(null!=userid && !"".equals(userid)){
            		whereSQL.append(" AND bd.sysuserid = '").append(FrmUser.getUser().etipUserID).append("'");    
            	}
            }
            
        }
        return whereSQL.toString();
    }

	@Override
	public List<OrderData> getOrderDataByJson(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("from OrderData bd  where 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}
	/**
	 * 
	 * 根据用户id查询此用户的所有购买的服务id
	 * 
	 * @author 冯鑫 <br> 
	 *		   2014-4-2
	 * @update 
	 * @param String userId
	 * @return  List<String>
	 */
	public String  queryProductIdByUserId(String userId){
	    String sql = new String("select p.productid as productid,p.orderid  from MINI_ORDER_PRODUCT p where p.orderid in (select o.ID from MINI_ORDER o where o.SYSUSERID='"+userId+"')");
	    JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> orders = dao.queryForList(sql, null);
        if(orders.size()>0){
            return JSONArray.fromObject(orders).toString();
        }else{
            return "";
        }
	}
	

}
