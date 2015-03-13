package com.mini.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class AlipayService {

	 
    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    /**
     * 支付宝提供给商户的服务接入网关URL(手机端)
     */
    private static final String ALIPAY_PHONE_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";
    /**
     * 构造即时到帐接口(购买服务)
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String create_direct_pay_by_server(Map<String, String> sParaTemp) {

        //增加基本配置
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("return_url", AlipayConfig.return_url_server);
        sParaTemp.put("notify_url", AlipayConfig.notify_url_server);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);

        String strButtonName = "确认";

        return AlipaySubmit.buildForm(sParaTemp, ALIPAY_GATEWAY_NEW, "POST", strButtonName);
    }
    /**
     * 构造即时到帐接口(购买接口)
     * @param sParaTemp 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String create_direct_pay_by_user(Map<String, String> sParaTemp) {

    	//增加基本配置
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("return_url", AlipayConfig.return_url);
        sParaTemp.put("notify_url", AlipayConfig.notify_url);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);

        String strButtonName = "确认";

        return AlipaySubmit.buildForm(sParaTemp, ALIPAY_GATEWAY_NEW, "POST", strButtonName);
    }
    /**
     * 
     * 手机端构造参数 请求获取token<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-21
     * @update 
     * @param 
     * @return  token
     * @since vmaque1.5
     */
    public static String create_direct_token_by_user(Map<String, String> sParaTemp) {
        //请求业务参数详细
        String req_dataToken = "<direct_trade_create_req><notify_url>" + AlipayConfig.notify_url 
                + "</notify_url><call_back_url>" + AlipayConfig.return_url 
                + "</call_back_url><seller_account_name>" + AlipayConfig.seller_email 
                + "</seller_account_name><out_trade_no>" + sParaTemp.get("out_trade_no") 
                + "</out_trade_no><subject>" + sParaTemp.get("subject") 
                + "</subject><total_fee>" + sParaTemp.get("price") 
                + "</total_fee><merchant_url>"
                + "</merchant_url></direct_trade_create_req>";
        Map<String, String> sParaTempToken = new HashMap<String, String>();
        sParaTempToken.put("service", "alipay.wap.trade.create.direct");
        /*sParaTempToken.put("body","您在微麻雀网站上的订单");*/
        sParaTempToken.put("body",sParaTemp.get("body"));
        sParaTempToken.put("partner", AlipayConfig.partner);
        sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
        sParaTempToken.put("sec_id", AlipayConfig.sign_type);
        sParaTempToken.put("format", AlipayConfig.format);
        sParaTempToken.put("v", AlipayConfig.v);
        sParaTempToken.put("req_id", AlipayConfig.req_id);
        sParaTempToken.put("req_data", req_dataToken.toString());
        //建立请求
        String sHtmlTextToken="";
        String request_token="";
        Object s[] = sParaTempToken.keySet().toArray();
        for(int i = 0; i < sParaTempToken.size(); i++) {
            System.out.println(sParaTempToken.get(s[i]));
        }
        try {
            sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_PHONE_GATEWAY_NEW,"", "",sParaTempToken);
            //URLDECODE返回的信息
            sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayConfig.input_charset);
            //获取token
            request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //业务详细
        String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
        //把请求参数打包成数组
        Map<String, String> sParaTemp_sure = new HashMap<String, String>();
        sParaTemp_sure.put("service", "alipay.wap.auth.authAndExecute");
        sParaTemp_sure.put("partner", AlipayConfig.partner);
        sParaTemp_sure.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp_sure.put("sec_id", AlipayConfig.sign_type);
        sParaTemp_sure.put("format", AlipayConfig.format);
        sParaTemp_sure.put("v", AlipayConfig.v);
        sParaTemp_sure.put("req_data", req_data);
        String strButtonName = "确认";
        return AlipaySubmit.buildForm(sParaTemp_sure, ALIPAY_PHONE_GATEWAY_NEW, "get", strButtonName);
    }
    /**
     * 
     * 手机微信端构造参数 请求获取token<br>
     * 
     * @author 侯杨<br> 
     *         2014-12-08
     * @update 
     * @param 
     * @return  token
     * @since vmaque2.0
     */
    public static String create_direct_token_by_userWeixin(Map<String, String> sParaTemp) {
        //请求业务参数详细
        String req_dataToken = "<direct_trade_create_req><notify_url>" + AlipayConfig.notify_orderurl 
                + "</notify_url><call_back_url>" + AlipayConfig.return_orderurl 
                + "</call_back_url><seller_account_name>" + AlipayConfig.seller_email 
                + "</seller_account_name><out_trade_no>" + sParaTemp.get("out_trade_no") 
                + "</out_trade_no><subject>" + sParaTemp.get("subject") 
                + "</subject><total_fee>" + sParaTemp.get("price") 
                + "</total_fee><merchant_url>"
                + "</merchant_url></direct_trade_create_req>";
        Map<String, String> sParaTempToken = new HashMap<String, String>();
        sParaTempToken.put("service", "alipay.wap.trade.create.direct");
        /*sParaTempToken.put("body","您在微麻雀网站上的订单");*/
        sParaTempToken.put("body",sParaTemp.get("body"));
        sParaTempToken.put("partner", AlipayConfig.partner);
        sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
        sParaTempToken.put("sec_id", AlipayConfig.sign_type);
        sParaTempToken.put("format", AlipayConfig.format);
        sParaTempToken.put("v", AlipayConfig.v);
        sParaTempToken.put("req_id", AlipayConfig.req_id);
        sParaTempToken.put("req_data", req_dataToken.toString());
        //建立请求
        String sHtmlTextToken="";
        String request_token="";
        Object s[] = sParaTempToken.keySet().toArray();
        for(int i = 0; i < sParaTempToken.size(); i++) {
            System.out.println(sParaTempToken.get(s[i]));
        }
        try {
            sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_PHONE_GATEWAY_NEW,"", "",sParaTempToken);
            //URLDECODE返回的信息
            sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayConfig.input_charset);
            //获取token
            request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //业务详细
        String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
        //把请求参数打包成数组
        Map<String, String> sParaTemp_sure = new HashMap<String, String>();
        sParaTemp_sure.put("service", "alipay.wap.auth.authAndExecute");
        sParaTemp_sure.put("partner", AlipayConfig.partner);
        sParaTemp_sure.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp_sure.put("sec_id", AlipayConfig.sign_type);
        sParaTemp_sure.put("format", AlipayConfig.format);
        sParaTemp_sure.put("v", AlipayConfig.v);
        sParaTemp_sure.put("req_data", req_data);
        String strButtonName = "确认";
        return AlipaySubmit.buildForm(sParaTemp_sure, ALIPAY_PHONE_GATEWAY_NEW, "get", strButtonName);
    }
    /**
     * 用于防钓鱼，调用接口query_timestamp来获取时间戳的处理函数
     * 注意：远程解析XML出错，与服务器是否支持SSL等配置有关
     * @return 时间戳字符串
     * @throws IOException
     * @throws DocumentException
     * @throws MalformedURLException
     */
    public static String query_timestamp() throws MalformedURLException,
                                                        DocumentException, IOException {

        //构造访问query_timestamp接口的URL串
        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + AlipayConfig.partner;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            // 截取部分不需要解析的信息
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
                // 判断是否有成功标示
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }

}
