package com.mini.util.mailSystem;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.common.util.FileUpload;
import com.common.util.ResouceUtil;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.Json;
import com.mini.util.SendMail;
import com.sys.user.data.UserData;

/**
 * 邮件系统的公共类
 * @author wy
 * 2013年9月10日9:44:24
 */
public class MailSystem {
	
	
	public static final String fileName = "sendMail.properties";
	public static final String PWD = ResouceUtil.getProperty(fileName, "pwd");
	public static final String HOST = ResouceUtil.getProperty(fileName, "host");
	public static final String FROM = ResouceUtil.getProperty(fileName, "from");
	public static final String AUTHENTICATION_INFORMATION = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"authentication_information.txt");
	public static final String SERVICEASKREFUSE_INFORMATION = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"serviseask_refuse.txt"); //读取拒绝服务商后发送的邮件的模板
	public static final String SERVICEASKSUCCESS_INFORMATION = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"serviseask_success.txt"); //读取通过服务商申请后发送的邮件的模板
	public static final String CHANGE_PASSWORD = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"change_password.txt");
	public static final String REGISTRATION_NUMBER = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"registration_number.txt");
	public static final String ORDER_CREATED_INFO = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+ "order_created_info.txt");//订单生成成功
	public static final String REGISTRATION_TITLE = ResouceUtil.getProperty(fileName, "registrationTitle");//邮件注册新用户主题
	public static final String SEND_INFORMATION = FileUpload.readFile(UploadPath.MAIL_TEMPLATE+"send_information.txt");
	public static final String SAVE_INFORMATION = ResouceUtil.getProperty(fileName, "saveInformation");//邮件发送未填写完主题
	public static final String SERVICEASKREFUSE_TITLE = ResouceUtil.getProperty(fileName, "serviseAskRufuseTitle");//服务商拒绝主题
	public static final String SERVICEASKSUCCESS_TITLE = ResouceUtil.getProperty(fileName, "serviseAskSuccessTitle");//服务商申请通过主题
	public static final String ORDER_CREATED = ResouceUtil.getProperty(fileName, "order_created");//订单生成主题主题
	public static final String PRODUCT_TURN_ON_TITLE = ResouceUtil.getProperty(fileName, "product_turn_on_title");//订单生成主题主题
	
	
	
	
	/**
	 * 从传过来的对象中取值
	 * @author wy
	 * 2013年9月10日13:47:40
	 * @param object
	 * @param field
	 * @return
	 */
	
	public static final String getValueFromObj(Object object, String field){
		String value = "";
		String[] fields = null;
		if(field.indexOf(".")==-1){
			fields = new String[]{field};
		}else{
			fields = field.split("\\.");
		}
		PropertyDescriptor[] props = null;   
		try {   
			props = Introspector.getBeanInfo(object.getClass(), Object.class)   
					.getPropertyDescriptors();   
		} catch (IntrospectionException e) {   
		}
		if (fields.length>0) {
			for (int j = 0; j < props.length; j++) {
				if(props[j].getName().equals(fields[0])){
					Object object2 = null;
					try {
						object2 = props[j].getReadMethod().invoke(object);
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
					} catch (InvocationTargetException e) {
					}
					if(fields.length>1){
						//递归查询对象属性
						object2 = getValueFromObj(object2,field.substring(fields[0].length()+1, field.length()));
					}
					if(object2==null){
						return "";
					}
					String str = Json.getJsonValue(object2);
					value = str.substring(1,str.length()-1);
					return value;
				}
			}
		}
		
		
		return value;
	}
	
	/**
	 * @author侯杨
	 * @data 2014-03-12
	 * 重置密码
	 * @param SysUserData
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static final void sendInfoTiJiaoRenZhen(UserData data2) throws AddressException, MessagingException{
		 StringBuffer mailContent = new StringBuffer();
		 StringBuffer title = new StringBuffer();
		 
		 title.append("您的实名网站认证信息已提交成功");
		 mailContent.append("<table   border='0' cellspacing='0' cellpadding='0' align='left'>")
         .append("<tr>")
              .append("<td  style='font-size:14px; color:#444; line-height:30px;'>")
                  .append("感谢您选购可信网站—实名网站认证服务：<br><br>")
                  .append("您已成功提交网站认证所需信息，我们会尽快对您提交的信息进行审核。审核结果会通过您预留的<font color='red'>邮箱、手机</font>通知您。您也可通过点击以下链接查看信息审核进度。：<br/><br/>")
                  .append("<a href=\"http://192.168.30.188:9999/order_manage/key/getOrderInfo\" target=_blank >信息审核进度查询</a><br/><br/>")
              .append("</td>")
         .append("</tr>")
       
         .append("<tr>")
               .append("<td style='font-size:14px; color:#444; line-height:30px;'>")
                   .append("若有疑问欢迎拨打客服支持电话400-666-3999")
               .append("</td>") 
         .append("</tr>")
         
         .append("<tr>")
              .append("<td  style='font-size:14px; color:#444; line-height:30px;'>")
                 .append("<div style='width:100%; float:left; height:4px; overflow:hidden; background:#ccc; margin:30px 0;'>")
                 .append("</div>")
              .append("</td>")
         .append("</tr>")
         .append("<tr>")
              .append("<td>")
                 .append("<font style='font-size:28px; color:#06b374; font-weight:bold;'>")
                    .append("可信网站——")
                 .append("</font>")
                 .append("<font style='font-size:18px; color:#06b374;font-weight:bold;'>")
                    .append("您的诚信需要有人证明。")
                 .append("</font>")
              .append("</td>")
         .append("</tr>")
     .append("</table>");
		 
		 
		 String to = data2.getLoginMail();
		 SendMail.send(to, title.toString(), mailContent.toString());
	}
	
	
}
