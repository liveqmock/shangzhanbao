package com.itour.etip.contract;

import java.util.Map;

public class JmsTemple {
	
	
	/**给候选会员发送邮件的模板
	 * @param userBaseTemp
	 * @return
	 */
	public String sendEmail(String email){
		StringBuffer content = new StringBuffer();
		content.append("\r\t");
		content.append("\r\t");
		content.append("这封信是由 itour.cn 发送的。");
		content.append("\r\t");
		content.append("\r\t");
		content.append("由此可得优惠券");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("此致");
		content.append("\r\t");
		content.append("\r\t");
		content.append("纵横天地");
		content.append("http://www.itour.cn");
		return content.toString();
		
	}
	
	/**
	 * 注册模版
	 * @param contextMap
	 * @return
	 */
	public static Map<String,String> register(Map<String,String> contextMap){
		StringBuffer content = new StringBuffer();
		content.append("\r\t");
		content.append(contextMap.get("userName")).append(",");
		content.append("\r\t");
		content.append("这封信是由 itour.cn 发送的。");
		content.append("\r\t");
		content.append("\r\t");
		content.append("您收到这封邮件，是因为在我们网站的新用户注册，或用户修改 Email 使用");
		content.append("了您的地址。如果您并没有访问过我们的论坛，或没有进行上述操作，请忽");
		content.append("略这封邮件。您不需要退订或进行其他进一步的操作。");
		content.append("\r\t");
		content.append("\r\t");
		content.append("请保管好您的用户名和登陆口令。");
		content.append("\r\t");
		content.append("登陆方式：\r\t");
		if(contextMap.get("card") != null && ((String)contextMap.get("card")).length() > 0){
			content.append("\t\t会员卡：").append(contextMap.get("card"));
			content.append("\r\t");
		}
		if(contextMap.get("userName") != null && ((String)contextMap.get("userName")).length() > 0){
			content.append("\t\t用户名：").append(contextMap.get("userName"));
			content.append("\r\t");
		}
		content.append("\t\t手机：").append(contextMap.get("moble"));
		content.append("\r\t");
		content.append("\t\t邮箱：").append(contextMap.get("email"));
		content.append("\r\t");
		content.append("登陆口令：").append(contextMap.get("password"));
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\r\t");
		content.append("此致");
		content.append("\r\t");
		content.append("\r\t");
		content.append("纵横天地");
		content.append("http://www.itour.cn");
		contextMap.put("EmailContext", content.toString());
		return contextMap;
	}
	
	
	/**
	 * 找回密码模版
	 * @param contextMap
	 * @return
	 */
	public static Map<String,String> resetPassword(Map<String,String> contextMap){
		StringBuffer content = new StringBuffer();
		
		content.append("\t亲爱的用户" + contextMap.get("account") + "：");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\t您好！");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\t您在itour提交找回密码请求");
		content.append("\r\t");
		content.append("\t您的最新密码是：" + contextMap.get("certValue"));
		content.append("\r\t");
		content.append("\t请您保管好您的新密码，并及时删除该邮件");
		content.append("\r\t");
		content.append("\r\t");
		content.append("\t感谢您使用itour!");
		contextMap.put("EmailContext", content.toString());
		return contextMap;
	}
	
}
