package com.mini.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.ResouceUtil;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.2
 *日期：2011-03-17
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
	
 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	private static final String fileName = "zhifubao.properties";
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = ResouceUtil.getProperty(fileName, "partner");
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	public static String key = ResouceUtil.getProperty(fileName, "key");
	
	// 签约支付宝账号或卖家收款支付宝帐户
	public static String seller_email = ResouceUtil.getProperty(fileName, "seller_email");
	
	// 支付宝服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	// 必须保证其地址能够在互联网中访问的到
	public static String notify_url = ResouceUtil.getProperty(fileName, "notify_url");
	
	public static String notify_url_server = ResouceUtil.getProperty(fileName, "notify_url_server");
	
	// 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	// 域名不能写成http://localhost/create_direct_pay_by_user_jsp_utf8/return_url.jsp ，否则会导致return_url执行无效
	public static String return_url = ResouceUtil.getProperty(fileName, "return_url");
	
	public static String return_url_server= ResouceUtil.getProperty(fileName, "return_url_server");
	
	
	// 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数  订单列表的跳转
    // 域名不能写成http://localhost/create_direct_pay_by_user_jsp_utf8/return_url.jsp ，否则会导致return_url执行无效
    public static String notify_orderurl = ResouceUtil.getProperty(fileName, "notify_orderurl");
    
    public static String return_orderurl= ResouceUtil.getProperty(fileName, "return_orderurl");
	
	//手机端 操作中断返回地址
	public static String merchant_url = ResouceUtil.getProperty(fileName, "merchant_url");

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志路径
	public static String log_path = "D:\\alipay_log_" + System.currentTimeMillis()+".txt";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 商户的私钥
    // 如果签名方式设置为“0001”时，请设置该参数
    public static String private_key = "";

    // 支付宝的公钥
    // 如果签名方式设置为“0001”时，请设置该参数
    public static String ali_public_key = "";

	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	//访问模式,根据自己的服务器是否支持ssl访问，若支持请选择https；若不支持请选择http
	public static String transport = "http";
	
	//请求号(手机端)
    public static String req_id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    
    //返回格式 必填，不需要修改（手机端）
    public static String format = "xml";
    
    //返回格式 必填，不需要修改（手机端）
    public static String v = "2.0";
    

}
