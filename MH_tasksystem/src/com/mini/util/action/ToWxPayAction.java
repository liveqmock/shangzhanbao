 package com.mini.util.action;


import java.util.SortedMap;
import java.util.TreeMap;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.util.wxpay.tenpay.utils.GetWxOrderno;
import com.mini.util.wxpay.tenpay.utils.RequestHandler;
import com.mini.util.wxpay.tenpay.utils.Sha1Util;
import com.mini.util.wxpay.tenpay.utils.TenpayUtil;

public class ToWxPayAction extends FrmAction{
    
    // 微信公众平台id
    private static final String APPID = ResouceUtil.getProperty("wxPay.properties", "appid");
    // 微信公众平台密钥
    private static final String APPSECRET = ResouceUtil.getProperty("wxPay.properties", "appsecret");
    // 微信商户号
    private static final String PARTNER = ResouceUtil.getProperty("wxPay.properties", "partner");
    // 微信商户号密钥
    private static final String PARTNERKEY = ResouceUtil.getProperty("wxPay.properties", "partnerkey");
    // 微信商户号密钥
    private static final String NOTIFY_URL = ResouceUtil.getProperty("wxPay.properties", "notify_url");
    // 商站包系统域名
    private static final String DOMAIN = ResouceUtil.getProperty("domain.properties", "pageTmp");
    /**
     * 微信支付接口
     *〈功能详细描述〉
     * @author    文东
     * @param describe 商品描述信息
     * @param openId 微信openid
     * @param userId 购买商品的用户id
     * @param orderNo 订单编号
     * @see        ToWxPayAction#wxPay()
     * @since      vmaque2.4
     */
    public void wxPay(){
        // 微信预知付订单请求地址
        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        // 获取商品描述
        // 获取用户id
        //String userId = "402885f149d1087d0149d109a5180001";
        String describe = request.getParameter("describe");
        String openId = request.getParameter("openId");
        String userId = request.getParameter("userId");
        String orderNo = request.getParameter("orderNo");
        String money = request.getParameter("money");
        //金额转化为分为单位
        float sessionmoney = Float.parseFloat(money);
        String finalmoney = String.valueOf((int)(sessionmoney*100));
        //获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
        String currTime = TenpayUtil.getCurrTime();
        //8位日期
        String strTime = currTime.substring(8, currTime.length());
        //四位随机数
        String strRandom = TenpayUtil.buildRandom(4) + "";
        //10位序列号,可以自行调整。
        String strReq = strTime + strRandom;
        //商户号
        String mch_id = PARTNER;
        //随机数 
        String nonce_str = strReq;
        //商品描述
        String body = describe;
        //String body = "美食";
        //附加数据
        String attach = userId;
        //商户订单号
        String out_trade_no = orderNo;
        //总金额以分为单位，不带小数点
        int intMoney = Integer.parseInt(finalmoney);
        //订单生成的机器IP
        String spbill_create_ip = request.getRemoteAddr();
        //这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
        String notify_url =NOTIFY_URL;
        //请求方式
        String trade_type = "JSAPI";
        String openid = openId;
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", APPID);  
        packageParams.put("mch_id", mch_id);  
        packageParams.put("nonce_str", nonce_str);  
        packageParams.put("body", body);  
        packageParams.put("attach", attach);  
        packageParams.put("out_trade_no", out_trade_no);  
        //这里写的金额为1 分到时修改
        //packageParams.put("total_fee", "1");  
        packageParams.put("total_fee", String.valueOf(intMoney));  
        packageParams.put("spbill_create_ip", spbill_create_ip);  
        packageParams.put("notify_url", notify_url);  
        packageParams.put("trade_type", trade_type);  
        packageParams.put("openid", openid);  
        RequestHandler reqHandler = new RequestHandler(request, response);
        reqHandler.init(APPID, APPSECRET, PARTNERKEY);
        String sign = reqHandler.createSign(packageParams);
                String xml="<xml>"+
                        "<appid>"+APPID+"</appid>"+
                        "<mch_id>"+mch_id+"</mch_id>"+
                        "<nonce_str>"+nonce_str+"</nonce_str>"+
                        "<sign>"+sign+"</sign>"+
                        "<body><![CDATA["+body+"]]></body>"+
                        "<attach>"+attach+"</attach>"+
                        "<out_trade_no>"+out_trade_no+"</out_trade_no>"+
                        //金额，这里写的1 分到时修改
                        //"<total_fee>"+1+"</total_fee>"+
                        "<total_fee>"+finalmoney+"</total_fee>"+
                        "<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
                        "<notify_url>"+notify_url+"</notify_url>"+
                        "<trade_type>"+trade_type+"</trade_type>"+
                        "<openid>"+openid+"</openid>"+
                        "</xml>";
                System.out.println(xml);
                String allParameters = "";
                try {
                    allParameters =  reqHandler.genPackage(packageParams);
                } catch (Exception e) {
                    json = "";
                    return;
                }
                String prepay_id="";
                try {
                    prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
                    if(prepay_id.equals("")){
                        json = "";
                        return;
                    }
                } catch (Exception e1) {
                    json = "";
                    return;
                }
                SortedMap<String, String> finalpackage = new TreeMap<String, String>();
                String appid2 = APPID;
                String timestamp = Sha1Util.getTimeStamp();
                String nonceStr2 = nonce_str;
                String prepay_id2 = "prepay_id="+prepay_id;
                String packages = prepay_id2;
                finalpackage.put("appId", appid2);  
                finalpackage.put("timeStamp", timestamp);  
                finalpackage.put("nonceStr", nonceStr2);  
                finalpackage.put("package", packages);  
                finalpackage.put("signType", "MD5");
                String finalsign = reqHandler.createSign(finalpackage);
                System.out.println("pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign);
                String returnJsonStr = "{\"appid\": \""+appid2+"\", \"timeStamp\": \""+timestamp+"\", \"nonceStr\": \""+nonceStr2+"\", \"package_\": \""+packages+"\", \"sign\": \""+finalsign+"\"}";
                json = returnJsonStr;
            }
}
