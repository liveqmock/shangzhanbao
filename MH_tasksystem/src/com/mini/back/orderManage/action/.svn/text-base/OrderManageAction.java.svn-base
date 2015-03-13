package com.mini.back.orderManage.action;

/***************************************
 * 运营人员后台的订单管理
 * @author 戴黎民
 * @date 2014-4-17
 ***************************************/
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.back.give.facade.UserInfoDataFacade;
import com.mini.back.orderManage.facade.OrderManageFacade;
import com.mini.back.product.facade.ProductFacade;
import com.mini.front.order.facade.OrderFacade;
import com.mini.front.order.facade.OrderProductFacade;
import com.mini.front.order.facade.PageProductFacade;
import com.mini.give.data.UserInfoData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.sys.user.data.UserData;
import com.sys.user.facade.UserFacade;
import com.util.mail.MailUtil;

@Results(value = { @Result(name = "getAllOrder", location = "view/pages/mini/back/orderManage/orderList.jsp"),
                   @Result(name = "orderDateInfo", location = "view/pages/mini/back/orderManage/orderServiceView.jsp")})
public class OrderManageAction extends FrmAction {

    /************** 注入 ***********************************************************************/

    @Resource(name = "orderManageFacade")
    private OrderManageFacade orderManageFacade;// 订单表Facade类
    @Resource(name = "productFacade")
    private ProductFacade productFacade;// 产品表Facade类
    @Resource(name = "userInfoDataFacade")
    private UserInfoDataFacade userInfoDataFacade;// 用户权限信息表Facade类
    @Resource(name = "pageProductFacade")
    private PageProductFacade pageProductFacade;// page服务中间表Facade类
    @Resource(name = "orderProductFacade")
    private OrderProductFacade orderProductFacade;// 订单服务中间表Facade类
    @Resource(name = "userFacade")
    private UserFacade userFacade;
    @Resource(name = "orderFacade")
    private OrderFacade orderFacade;
    /************** 属性 *********************************************************************/

    private PageRoll pageRoll = new PageRoll();// 分页参数
    private OrderData orderData = new OrderData();// 接受页面值的实体类
    private List<OrderData> orderDatas = new ArrayList<OrderData>();// 订单对象集合
    private OrderProductData orderProductData = new OrderProductData();// 订单对象集合
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> orderproductstate = CacheUtil.getInstance().getCacheMap("orderproductstate"); // 订单于服务中间表状态
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> orderstateType = CacheUtil.getInstance().getCacheMap("OrderState"); // 订单状态数据字典

    /************** 方法 ******************************************************************/

    /****
     * 根据状态分页查询所有订单
     * 
     * @author 戴黎明
     */
    public String getAllOrder() {

        orderDatas = orderManageFacade.getAllOrder(pageRoll, orderData);
        request.setAttribute("orderproductstate", orderproductstate);
        request.setAttribute("orderstateType", orderstateType);
        return "getAllOrder";

    }

    /****
     * 根据订单id和状态值来该变订单的状态（线下付款变为已付款）
     * 
     * @author 戴黎明
     */
    public void ajaxUpdateOrderState() {
    	orderData.setPayTime(new Date());
        orderManageFacade.ajaxUpdateOrderState(orderData);// 前台会传来订单id和状态只需要修改状态和时间即可
		/**
		 * 修改用户所拥有的官方发布权限
		 * 
		 * @update 文东
		 */
        orderData = orderManageFacade.findAllOrderDatebyOrderId(orderData.getId());//获取该订单的信息
        UserData userData  = userFacade.getAllUserInfo(JSONObject.fromObject("{userID:\"" + orderData.getSysUserId() + "\"}")).get(0);
        
        if(orderData!=null && orderData.getOrderProductDatas()!=null && orderData.getOrderProductDatas().size()>0){
        	
        	ProductData productData = productFacade.findBySign(1);// 根据特殊标识查询出发布权限的服务信息,没做空处理，数据库必须要有一款sign=1的服务,查询出官方发布权限的服务的id
        	
        	for(OrderProductData data:orderData.getOrderProductDatas()){//订单里面的所有服务
        		
        		if(productData.getId().equals(data.getProductId())){//对比 如果订单包含此发布权限的服务则更新或者添加用户的权限信息
        		    /**
        		     * 当用户购买发布权限后，要把此用户的Isprivilege字段改为1;
        		     */
        		    userData.setIsprivilege(1);
        		    userFacade.updateUserData(userData);
        		    
        		    
        			data.setState(1);//只要官方发布权限的订单变为已付款，那么官方发布权限就变为已开通
        			orderManageFacade.ajaxUpdateOpState(data);
        			
        			updateOrderOver(data.getOrderId());//判断订单是否是已完成，完成就变更订单状态
        			
        			
        			// 根据用户ID查找用户所拥有的官方发布权限
        			UserInfoData userInfoData = userInfoDataFacade.getUserInfoData(orderData.getSysUserId());
        			// 若该用户已经有购买的官方发布权限的数据则执行更新操作
        			if (userInfoData != null) {
        				// 在原拥有的官方发布权限的数量加上购买的数量
        				userInfoData.setPayPrivilege(userInfoData.getPayPrivilege()
        						+ data.getAmount());//当前循环的 包含权限的订单服务中间表的服务的数量
        				userInfoDataFacade.updateUserInfo(userInfoData);
        			} else {
        				userInfoData = new UserInfoData();//初始化用户的权限信息
        				userInfoData.setUserId(orderData.getSysUserId());
        				userInfoData.setPayPrivilege(data.getAmount());//当前循环的 包含权限的订单服务中间表的服务的数量
        				userInfoData.setTryPrivilege(0);
        				userInfoData.setAlreadyPayPrivilege(0);
        				userInfoData.setAlreadyTryPrivilege(0);
        				userInfoData.setAlreadyUpgrade(0);
        				userInfoData.setGiveNum(0);
        				userInfoData.setRenew(0);
        				userInfoData.setOverduePrivilege(0);
        				userInfoDataFacade.addUserInfo(userInfoData);
        			}
        		}else{
        			
        			data.setState(0);//付款以后就把服务的状态设置为0未开通
        			orderManageFacade.ajaxUpdateOpState(data);
        			
        			//根据pageid和服务id查询page服务中间表数据
        			PageProductData ppd = pageProductFacade.getPageProductData(data);
        			ppd.setStatus(2);//中间表状态设置为待开通2
        			pageProductFacade.editPageProduct(ppd);//修改状态
        			
        		}
        		
        	}
        }
        /**
         * 修改人 左香勇 修改时间 2014-6-18 修改内容 添加发送邮件功能
         */
        if(orderData != null){
            //判断邮箱是否合法
            if(null != orderData.getUserMail() && MailUtil.exactnessMail(orderData.getUserMail())){
                Map<String, String> contentMap = new HashMap<String, String>();
                if(null!=orderData.getUserName() && "".equals(orderData.getUserName())){
                    contentMap.put("userName", orderData.getUserName());
                }else{
                    contentMap.put("userName", orderData.getUserMail());
                }
                contentMap.put("order", orderData.getCode());
                contentMap.put("url", "/order/key/findOrderView?orderData.id="+orderData.getId());
                
                new MailUtil(orderData.getUserMail(), contentMap , 9).run();
            }
        }
        
    }

    
  //判断订单是否是已完成，完成就变更订单状态
    private void updateOrderOver(String orderId) {


    	//查询这个中间数据是属于哪个订单的
		OrderData orderData = orderManageFacade.findAllOrderDatebyOrderId(orderId);
		
		//根据订单查询订单下面所有的订单服务中间表数据
		if(orderData!=null && orderData.getOrderProductDatas()!= null && orderData.getOrderProductDatas().size()>0){
			boolean b = true;
			for(OrderProductData op:orderData.getOrderProductDatas()){
				if(op.getState()!=1){
					b=false;
				}
			}
			//如果所有的服务状态都变为已开通则订单状态变为已完成
			if(b){
				orderData.setState(3);
				orderManageFacade.ajaxUpdateOrderState(orderData);
			}
		}
		
		
	}

	/****
     * 根据订单id服务id和状态值来改变订单和服务中间表的状态（未开通改为已开通）
     * 
     * @author 戴黎明
     */
    public void ajaxUpdateOpState() {

        orderManageFacade.ajaxUpdateOpState(orderProductData);// 前台会传来订单服务中间表id和状态只需要修改状态和时间即可
        
        orderProductData = orderProductFacade.retrieve(orderProductData.getId());//根据主键查询订单服务中间表信息
        //根据pageid和服务id查询page服务中间表数据
		PageProductData ppd = pageProductFacade.getPageProductData(orderProductData);
		ppd.setStatus(3);//中间表状态设置为已开通3
		pageProductFacade.editPageProduct(ppd);//修改状态
		updateOrderOver(orderProductData.getOrderId());
		
		orderData = orderFacade.retrieve(orderProductData.getOrderId());
		
		/**
		 * 修改人 左香勇 修改时间 2014-6-18 修改内容 添加发送邮件功能
		 */
		//判断邮箱是否合法
		if(null != orderData.getUserMail() && MailUtil.exactnessMail(orderData.getUserMail())){
    		Map<String, String> contentMap = new HashMap<String, String>();
    		if(null!=orderData.getUserName() && "".equals(orderData.getUserName())){
    		    contentMap.put("userName", orderData.getUserName());
    		}else{
    		    contentMap.put("userName", orderData.getUserMail());
    		}
    		contentMap.put("serve", orderProductData.getProductName());
    		
    		new MailUtil(orderData.getUserMail(), contentMap , 7).run();
		}
    }
    /**
     * 
     * 更具订单id和用户id查询订单的详细信息 包括实名认证信息和发票信息<br>
     * 
     * @author 冯鑫 <br> 
     *        2014-4-22
     * @update 
     * @param orderId 订单id 必须不为空
     *        userId  当前登录用户id 必须不为空
     * @return  OrderData
     */
   public String findAllOrderDatebyOrderId(){
	   orderData = orderManageFacade.findAllOrderDatebyOrderId(orderData.getId());//为了防止和getAll的方法参数混乱，参数名要变更
       return "orderDateInfo";
   }

    /************* get&set ***********************************************************************/

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }

    public List<OrderData> getOrderDatas() {
        return orderDatas;
    }

    public void setOrderDatas(List<OrderData> orderDatas) {
        this.orderDatas = orderDatas;
    }

    public OrderProductData getOrderProductData() {
        return orderProductData;
    }

    public void setOrderProductData(OrderProductData orderProductData) {
        this.orderProductData = orderProductData;
    }

    public TreeMap<Integer, String> getOrderproductstate() {
        return orderproductstate;
    }

    public void setOrderproductstate(TreeMap<Integer, String> orderproductstate) {
        this.orderproductstate = orderproductstate;
    }

    public TreeMap<Integer, String> getOrderstateType() {
        return orderstateType;
    }

    public void setOrderstateType(TreeMap<Integer, String> orderstateType) {
        this.orderstateType = orderstateType;
    }
    

    
}
