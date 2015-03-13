package com.mini.util;


import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 只发送邮件，不发送符件
 * @author   何大勇
 * @version  
 * @date 2013-3-22
 */
public class SendMail {
	private static String pwd = "ctngomai123";
	private static String host = "smtp.126.com";
	private static String user = "ctnService@126.com";
	private static String from = "ctnService@126.com";

	public static boolean send(String to,String subject,String cont) throws AddressException, MessagingException {
		boolean onOk = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(false);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		Multipart multipart = new MimeMultipart();
		BodyPart contentPart = new MimeBodyPart();
		contentPart.setText("很抱歉！您的客户端不支持HTML格式邮件，请使用网页邮箱打开邮件。谢谢！\n\r ctn");
		contentPart.setContent(cont,"text/html;charset=utf-8");
		multipart.addBodyPart(contentPart);
		message.setContent(multipart);
		message.saveChanges();
		message.setSentDate(new Date());
		Transport transport = session.getTransport("smtp");
		transport.connect(host, user, pwd);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		onOk = true;
		return onOk;
	}
	/**
	 * 
	 * 校验邮箱地址是否为正确的<br>
	 * 
	 * @author 冯鑫 <br> 
	 *		   2014-5-23
	 * @update 
	 * @param email
	 * @return  true 正确 false 错误
	 */
	public static boolean checkEmail(String email){
	    boolean str = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(email).find();
	    return str;
	}
}
/*

 
*/