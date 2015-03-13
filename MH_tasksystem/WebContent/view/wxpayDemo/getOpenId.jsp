<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.mini.util.wxpay.tenpay.utils.CommonUtil"%>
<%@page import="com.common.util.ResouceUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String code = request.getParameter("code");
    String state = request.getParameter("state");
    System.out.println("code="+code);
    System.out.println("state="+state);
	String APPID = ResouceUtil.getProperty("wxPay.properties", "appid");
	String APPSECRET = ResouceUtil.getProperty("wxPay.properties", "appsecret");
    String openId = "";
    if (code == "" || code == null) {
        response.sendRedirect(state+"&openId="+openId);
    } else {
        String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret=" + APPSECRET
                + "&code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
        try {
            openId = jsonObject.getString("openid");
        } catch (Exception e) {
            response.sendRedirect(state+"&openId="+openId);
        }
    }
    System.out.println("openId="+openId);
    response.sendRedirect(state+"&openId="+openId);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>