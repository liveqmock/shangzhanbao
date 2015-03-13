package com.mini.util.action;

import java.io.IOException;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
/**********************************************
 * 支付使用的action
 * @author dlm
 * @date 2014-4-22
 ***********************************************/
import com.itour.etip.pub.frame.FrmAction;
import com.mini.front.order.facade.OrderFacade;
import com.mini.order.data.OrderData;
import com.mini.util.AlipayConfig;
import com.mini.util.AlipayService;
/**
 * 支付所使用的action
 * 
 * @author dlm
 * 
 */
@ResultPath("/")
@Results({  @Result(name = "offlinePay", location = "view/pages/mini/front/alipay/offlineIntroduce.jsp") ,
	 		@Result(name = "alipayForm", location = "view/pages/mini/front/alipay/toAlipay.jsp") 
			})
public class AlipayAction extends FrmAction {

	
	@Resource(name = "orderFacade")
	private OrderFacade orderFacade;// 订单表Facade类
	
	
	/**
	 * 跳转到线下付款的页面
	 * @return
	 */
	public String offlinePay(){
		String price = request.getParameter("price");
		String code = request.getParameter("code");
		String orderId = request.getParameter("orderId");
		request.setAttribute("code", code);
		request.setAttribute("price", price);
		request.setAttribute("orderId", orderId);
		return "offlinePay";
	}
	
	
	/**
	 * 根据订单编号检查是否支付成功
	 * @return
	 */
	public String checkSuccess(){
		return null;
	}
	
 	/**
 	 * 跳转到是否立即支付页面，生成支付宝付款的form表单
 	 * @return
 	 */
 	public String toAlipay(){
 		
 		String alipayForm = "";//支付的表单
 		String code = request.getParameter("code");//订单编号
 		String orderId =request.getParameter("orderId");//订单id
 		OrderData data = orderFacade.retrieve(orderId);//根据订单id查询订单对象
 		if(data!=null){
			alipayForm = this.getAlipayForm(data);
		}
 		request.setAttribute("alipayForm", alipayForm);
 		request.setAttribute("code", code);
 		request.setAttribute("price", data.getPrice());
 		request.setAttribute("orderId", orderId);
 		
 		return "alipayForm";
 		
 		
 	}
 	
 	
 	/*
	 * 支付宝接口，这里得出的String 是支付宝接口的form提交表单，字符串返回给页面然后页面直接提交
	 */
	private String getAlipayForm(OrderData orderData) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("body","您在商站宝上的订单");//填写在跳到支付宝页面上显示的付款内容信息  
		hm.put("out_trade_no",orderData.getCode());//外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用. 
		hm.put("agent",AlipayConfig.partner);//partnerId(合作伙伴ID)
		hm.put("payment_type","2");//支付类型 1=商品购买,2=服务购买,... 
 		hm.put("price",String.valueOf(orderData.getPrice()));//订单金额信息    
//		hm.put("price","0.01");//订单金额信息    
		hm.put("quantity","1");//订单商品数量,一般都是写1,它是按照整个订单包来计算 
		hm.put("subject","商站宝的订单");//填写在跳到支付宝页面上显示的付款标题信息  
		return AlipayService.create_direct_pay_by_server(hm);//securityCode(安全码)
	}
 	
 	
	public void ajaxGetAlipayForm(){
		String alipayForm = "";
		String orderId = request.getParameter("orderId");
		if(orderId!=null && !"".equals(orderId)){
			OrderData data = orderFacade.retrieve(orderId);//根据订单id查询订单对象
			if(data!=null){
				alipayForm = this.getAlipayForm(data);
			}
		}
		try {
			response.getWriter().write(alipayForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
