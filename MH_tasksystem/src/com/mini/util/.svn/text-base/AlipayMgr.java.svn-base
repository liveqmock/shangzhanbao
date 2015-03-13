package com.mini.util;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

/**    
 * 支付宝付款通知接口.    
 *     
 * @author stephen    
 * @version 1.0.0    
 */
public final class AlipayMgr {
    /**
     * 
     * 购买商品  支付宝异步通知<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-24
     * @update 
     * @param httpRequest
     * @return  String
     * @see   
     * @since vmaque1.5
     */
    public static String toReturn(HttpServletRequest httpRequest){
        System.out.println("-----------------------支付宝 购买商品异步请求开始--------------------------");
        Enumeration parameterNames = null;
        String parameterName = null;
        String parameterValue = null;
        Map<String, String> map = new HashMap<String, String>();
        parameterNames = httpRequest.getParameterNames();
        System.out.println("支付宝发来的请求参数如下parameterNames："+parameterNames);
        while (parameterNames.hasMoreElements()) {//循环收取支付宝发来的所有参数信息      
            parameterName = (String) parameterNames.nextElement();      
            parameterValue = httpRequest.getParameter(parameterName);      
            if(parameterValue==null) parameterValue="";      
            map.put(parameterName, parameterValue);
        }
        System.out.println("支付宝发来的交易状态trade_status："+map.get("trade_status"));
        System.out.println("支付宝发来的交易状态orderId："+httpRequest.getParameter("out_trade_no"));
        if("TRADE_SUCCESS".equals(map.get("trade_status"))|| "TRADE_FINISHED".equals(map.get("trade_status"))){
            String orderId = httpRequest.getParameter("out_trade_no");//订单号   
            String sql = "UPDATE MINI_CONSUMERORDER SET STATE=1 and PAYTIME=SYSDATE  WHERE ORDERCODE='"+orderId+"'";
            JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
            jdbcDao.executeSQL(sql);
            System.out.println("-----------------------支付宝异步请求结束 状态success--------------------------");
            return "success";
        }else{
            System.out.println("-----------------------支付宝异步请求结束 状态fail--------------------------");
            return "fail";
        }
        
    }
    /**
     * 
     * 购买服务 支付宝异步通知<br>
     * 
     * @author 冯鑫<br> 
     *         2014-9-24
     * @update 
     * @param httpRequest
     * @return  String
     * @see   
     * @since vmaque1.5
     */
    public static String toReturnServer(HttpServletRequest httpRequest){
        System.out.println("-----------------------支付宝异步 购买服务  请求开始--------------------------");
        Enumeration parameterNames = null;
        String parameterName = null;
        String parameterValue = null;
        Map<String, String> map = new HashMap<String, String>();
        parameterNames = httpRequest.getParameterNames();
        System.out.println("支付宝发来的请求参数如下parameterNames："+parameterNames);
        while (parameterNames.hasMoreElements()) {//循环收取支付宝发来的所有参数信息      
            parameterName = (String) parameterNames.nextElement();      
            parameterValue = httpRequest.getParameter(parameterName);      
            if(parameterValue==null) parameterValue="";      
            map.put(parameterName, parameterValue);
        }
        System.out.println("支付宝发来的交易状态trade_status："+map.get("trade_status"));
        System.out.println("支付宝发来的交易状态orderId："+httpRequest.getParameter("out_trade_no"));
        if("TRADE_SUCCESS".equals(map.get("trade_status"))|| "TRADE_FINISHED".equals(map.get("trade_status"))){
            String orderId = httpRequest.getParameter("out_trade_no");//订单号   
            String sql = "UPDATE MINI_ORDER SET STATE=2 WHERE CODE='"+orderId+"'";
            JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
            jdbcDao.executeSQL(sql);
            System.out.println("-----------------------支付宝异步请求结束 状态success--------------------------");
            return "success";
        }else{
            System.out.println("-----------------------支付宝异步请求结束 状态fail--------------------------");
            return "fail";
        }
        
    }
	public static String insert(HttpServletRequest httpRequest) {
		//定义变量和进行必要的初始化工作
		Enumeration parameterNames = null;
		String parameterName = null;
		String parameterValue = null;
		int count =0;
		Vector[] params = null;
		Map<String, String> map = new HashMap<String, String>();
		Vector vParameterName = new Vector();
		Vector vParameterValue = new Vector();
        try {      
            String orderId = httpRequest.getParameter("out_trade_no");//订单号      
            if(orderId==null||"".equals(orderId)) orderId="-1";      
            parameterNames = httpRequest.getParameterNames();      
            boolean isPrint = false;      
            while (parameterNames.hasMoreElements()) {//循环收取支付宝发来的所有参数信息      
                parameterName = (String) parameterNames.nextElement();      
                parameterValue = httpRequest.getParameter(parameterName);      
                if(parameterValue==null) parameterValue="";      
                vParameterName.add(parameterName);      
                vParameterValue.add(parameterValue);
                map.put(parameterName, parameterValue);
                count++;      
            }      
            //这里添加对收到信息的处理:一般是将这些信息存入数据库,然后对客户的订单进行处理.      
            if("TRADE_SUCCESS".equals(map.get("trade_status")) || "TRADE_FINISHED".equals(map.get("trade_status"))){
    		}
            return null;      
        } catch (Exception e) {      
            return e.toString();      
        } finally {      
            //      
        }      
    }      
     
}  