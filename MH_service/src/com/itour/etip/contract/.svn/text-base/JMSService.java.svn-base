package com.itour.etip.contract;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.jms.JMSMessage;
import com.itour.etip.pub.kit.jms.JMSUtil;
import com.itour.etip.pub.kit.log.LogUtil;
import com.itour.etip.pub.kit.net.FtpUtil;
import com.itour.etip.pub.kit.tool.HTML2TiffSnapshot;

/**
 * 对外发布特定消息的服务接口
 * 
 */
@WebService(endpointInterface = "com.itour.etip.contract.IJMSService")
public class JMSService implements IJMSService {

	/**
	 * 使用消息对象作为参数发送消息。
	 * 
	 * @param jms
	 *            消息实体,包含destination,content两个属性
	 */
	public void sendQueueMessageOne(@WebParam(name = "jms")
	JMSMessage jms) {
		JMSUtil.send(jms);
	}

	/**
	 * 根据队列名称，队列内容发送消息
	 * 
	 * @param queueName
	 *            队列名称
	 * @param content
	 *            消息内容，Map
	 */
	public void sendQueueMessageTwo(@WebParam(name = "queueName")
	String queueName, @WebParam(name = "content")
	Map<String, String> content) {
		JMSMessage jms = new JMSMessage();
		jms.setDestination(queueName);
		jms.setMessageContent(content);
		JMSUtil.send(jms);
	}

	/**
	 * 根据队列名称，队列内容发送消息
	 * 
	 * @param queueName
	 *            队列名称
	 * @param content
	 *            消息内容，String
	 */
	public void sendQueueMessage(@WebParam(name = "queueName")
	String queueName, @WebParam(name = "content")
	String content) {
		JMSMessage jms = new JMSMessage();
		jms.setDestination(queueName);
		jms.setMessageContent(content);
		JMSUtil.send(jms);
	}

	/**
	 * 发送邮件，参数是Map,要求提供下列数据项目 EmailContext 邮件内容，可以使用html标签 Subject 标题 EmailTo
	 * 收件人邮件地址 EmailFrom 发件人邮件地址,如果没有，那么从paraCache中取 UuID 保留 SysID 保留
	 * TibcoEmailQueue 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendMailOne(@WebParam(name = "contextMap")
	Map<String, String> contextMap) {
		Map<String, Object> mailMsgContent = new HashMap<String, Object>();

		mailMsgContent.put("EmailContext", contextMap.get("EmailContext"));
		mailMsgContent.put("Subject", contextMap.get("Subject"));
		mailMsgContent.put("EmailTo", contextMap.get("EmailTo"));
		String EmailFrom = contextMap.get("EmailFrom");
		if (EmailFrom == null || EmailFrom.trim().length() == 0) {
			EmailFrom = CacheUtil.paraCache.getParaValue("EmailFrom");
		}
		mailMsgContent.put("EmailFrom", EmailFrom);
		mailMsgContent.put("UuID", contextMap.get("UuID"));
		mailMsgContent.put("SysID", contextMap.get("SysID"));
		String queueName = contextMap.get("TibcoEmailQueue");
		if (queueName == null || queueName.trim().length() == 0) {
			queueName = CacheUtil.paraCache.getParaValue("TibcoEmailQueue");
		}

		JMSMessage msg = new JMSMessage();
		msg.setDestination(queueName);
		msg.setMessageContent(mailMsgContent);
		JMSUtil.send(msg);

	}

	/**
	 * 发送邮件，参数是Map,要求提供下列数据项目 EmailContext 邮件内容，可以使用html标签 Subject 标题 EmailTo
	 * 收件人邮件地址 EmailFrom 发件人邮件地址 UuID 保留，暂时没有用，可以用来传递消息发送对象的id SysID
	 * 保留,暂时没有用，可以传递对象类型 TibcoEmailQueue 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendMailTwo(@WebParam(name = "EmailContext")
	String EmailContext, @WebParam(name = "Subject")
	String Subject, @WebParam(name = "EmailTo")
	String EmailTo, @WebParam(name = "EmailFrom")
	String EmailFrom, @WebParam(name = "UuID")
	String UuID, @WebParam(name = "SysID")
	String SysID, @WebParam(name = "TibcoEmailQueue")
	String TibcoEmailQueue) {
		Map<String, Object> mailMsgContent = new HashMap<String, Object>();

		mailMsgContent.put("EmailContext", EmailContext);
		mailMsgContent.put("Subject", Subject);
		mailMsgContent.put("EmailTo", EmailTo);
		if (EmailFrom == null || EmailFrom.trim().length() == 0) {
			EmailFrom = CacheUtil.paraCache.getParaValue("EmailFrom");
		}
		mailMsgContent.put("EmailFrom", EmailFrom);
		mailMsgContent.put("UuID", UuID);
		mailMsgContent.put("SysID", SysID);
		String queueName = TibcoEmailQueue;
		if (queueName == null || queueName.trim().length() == 0) {
			queueName = CacheUtil.paraCache.getParaValue("TibcoEmailQueue");
		}
		JMSMessage msg = new JMSMessage();
		msg.setDestination(queueName);
		msg.setMessageContent(mailMsgContent);
		JMSUtil.send(msg);
	}

	/**
	 * 发送短信接口，参数是内容Map PhoneNO 接受短信电话号码 MsgContent 短信内容 UuID 保留 SysID 保留
	 * TibcoSMSQueue 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendSMS(@WebParam(name = "contextMap")
	Map<String, String> contextMap) {
		Map<String, Object> mailMsgContent = new HashMap<String, Object>();
		mailMsgContent.put("PhoneNO", contextMap.get("PhoneNO"));
		mailMsgContent.put("MsgContent", contextMap.get("MsgContent"));
		mailMsgContent.put("UuID", contextMap.get("UuID"));
		mailMsgContent.put("SysID", contextMap.get("SysID"));

		String queueName = contextMap.get("TibcoSMSQueue");
		if (queueName == null || queueName.trim().length() == 0) {
			queueName = CacheUtil.paraCache.getParaValue("TibcoSMSQueue");
		}
		JMSMessage msg = new JMSMessage();
		msg.setDestination(queueName);
		msg.setMessageContent(mailMsgContent);
		JMSUtil.send(msg);
	}

	/**
	 * 发送短信接口，使用字符串作为参数 PhoneNO 接受短信电话号码 MsgContent 短信内容 UuID 保留 SysID 保留
	 * TibcoSMSQueue 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendSMS(@WebParam(name = "PhoneNO")
	String PhoneNO, @WebParam(name = "MsgContent")
	String MsgContent, @WebParam(name = "UuID")
	String UuID, @WebParam(name = "SysID")
	String SysID, @WebParam(name = "TibcoSMSQueue")
	String TibcoSMSQueue) {
		Map<String, Object> mailMsgContent = new HashMap<String, Object>();
		mailMsgContent.put("PhoneNO", PhoneNO);
		mailMsgContent.put("MsgContent", MsgContent);
		mailMsgContent.put("UuID", UuID);
		mailMsgContent.put("SysID", SysID);

		JMSMessage msg = new JMSMessage();
		String queueName = TibcoSMSQueue;
		if (queueName == null || queueName.trim().length() == 0) {
			queueName = CacheUtil.paraCache.getParaValue("TibcoSMSQueue");
		}

		msg.setDestination(queueName);
		msg.setMessageContent(mailMsgContent);

		JMSUtil.send(msg);
	}

	/**
	 * faxContext.put("SysID", SysID); faxContext.put("UuID", UuID);
	 * faxContext.put("Document", Document); faxContext.put("Fax_Type",
	 * Fax_Type); faxContext.put("Fax_No", Fax_No); faxContext.put("Agent_ID",
	 * Agent_ID); faxContext.put("Dept", Dept); faxContext.put("Staff_Name",
	 * Staff_Name); faxContext.put("Urgent", Urgent); faxContext.put("Remark",
	 * Remark); faxContext.put("FaxQueue",FaxQueue);
	 * 
	 * @param contextMap
	 */
	public void sendFaxOne(@WebParam(name = "contextMap")
	Map<String, String> contextMap) {

		// 获取传真内容
		String fax = contextMap.get("fax");
		String style = contextMap.get("style");
		String tifFileName = String.valueOf(new Date().getTime()) + ".tif";
		String filePath = HTML2TiffSnapshot.createTiff(fax, style, tifFileName);

		// ftp工具，上传ftp需要的tif文件，
		FtpUtil ftpC = new FtpUtil();

		String FtpIP = CacheUtil.paraCache.getParaValue("FtpIP");
		int FtpPort = Integer.parseInt(CacheUtil.paraCache.getParaValue("FtpPort"));
		String FtpUser = CacheUtil.paraCache.getParaValue("FtpUser");
		String FtpPassword = CacheUtil.paraCache.getParaValue("FtpPassword");
		ftpC.openServer(FtpIP, FtpPort, FtpUser, FtpPassword);
		String fileName = ftpC.uploadeFile(filePath, "/");
		ftpC.closeServer();

		// 通知esb进行处理
		String queueName = CacheUtil.paraCache.getParaValue("FaxQueue");// 队列名称
		contextMap.put("Document", fileName);
		// 存储操作历史
		try {
			byte[] byteSQLData = new byte[0];
			FileInputStream fis = new FileInputStream(filePath);
			byteSQLData = new byte[fis.available()];
			fis.read(byteSQLData, 0, byteSQLData.length);
			fis.close();
			// String faxID = contextMap.get("faxID");
			// IFtpService ftp = new FtpService();
			// ftp.saveToBerkeley(faxID, byteSQLData);
			// 上传成功后删除文件
			File fileToDelete = new File(filePath);
			fileToDelete.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.warn("CONSOLE", "CanNotSaveFaxFileToBerkeley");
		}

		// 发送传真消息
		JMSUtil.send(queueName, contextMap);

	}

	/**
	 * 发送传真的接口，仅仅在纵横天地适用，需要依赖传真环境
	 * 
	 * @param Fax_Type
	 *            传真类型 1
	 * @param Fax_No
	 *            传真代号
	 * @param Agent_ID
	 *            代理号
	 * @param Dept
	 *            部门
	 * @param Staff_Name
	 *            员工名称
	 * @param Urgent
	 *            紧急程度 0
	 * @param Remark
	 *            备注
	 * @param Document
	 *            传真文件路径
	 * @param SysID
	 *            保留
	 * @param UuID
	 *            保留
	 */
	public void sendFaxTwo(@WebParam(name = "faxID")
	String faxID, @WebParam(name = "fax")
	String fax, @WebParam(name = "style")
	String style, @WebParam(name = "Fax_Type")
	String Fax_Type, @WebParam(name = "Fax_No")
	String Fax_No, @WebParam(name = "Agent_ID")
	String Agent_ID, @WebParam(name = "Dept")
	String Dept, @WebParam(name = "Staff_Name")
	String Staff_Name, @WebParam(name = "Urgent")
	String Urgent, @WebParam(name = "Remark")
	String Remark, @WebParam(name = "Document")
	String Document, @WebParam(name = "SysID")
	String SysID, @WebParam(name = "UuID")
	String UuID, @WebParam(name = "FaxQueue")
	String FaxQueue) {

		// 获取传真内容
		String tifFileName = String.valueOf(new Date().getTime()) + ".tif";
		String filePath = HTML2TiffSnapshot.createTiff(fax, style, tifFileName);
		// ftp工具，上传ftp需要的tif文件，
		FtpUtil ftpC = new FtpUtil();

		String FtpIP = CacheUtil.paraCache.getParaValue("FtpIP");
		int FtpPort = Integer.parseInt(CacheUtil.paraCache.getParaValue("FtpPort"));
		String FtpUser = CacheUtil.paraCache.getParaValue("FtpUser");
		String FtpPassword = CacheUtil.paraCache.getParaValue("FtpPassword");
		ftpC.openServer(FtpIP, FtpPort, FtpUser, FtpPassword);
		String fileName = ftpC.uploadeFile(filePath, "/");
		ftpC.closeServer();
		// 通知esb进行处理
		String queueName = CacheUtil.paraCache.getParaValue("FaxQueue");// 队列名称
		Map<String, Object> faxContext = new HashMap<String, Object>();
		faxContext.put("Document", fileName);
		faxContext.put("SysID", SysID);
		faxContext.put("UuID", UuID);
		faxContext.put("Document", Document);
		faxContext.put("Fax_Type", Fax_Type);
		faxContext.put("Fax_No", Fax_No);
		faxContext.put("Agent_ID", Agent_ID);
		faxContext.put("Dept", Dept);
		faxContext.put("Staff_Name", Staff_Name);
		faxContext.put("Urgent", Urgent);
		faxContext.put("Remark", Remark);

		// String queueName = FaxQueue;
		if (queueName == null || queueName.trim().length() == 0) {
			CacheUtil.paraCache.getParaValue("FaxQueue");
		}

		// 存储操作历史
		try {
			byte[] byteSQLData = new byte[0];
			FileInputStream fis = new FileInputStream(filePath);
			byteSQLData = new byte[fis.available()];
			fis.read(byteSQLData, 0, byteSQLData.length);
			fis.close();
			// String faxID = contextMap.get("faxID");
			IFtpService ftp = new FtpService();
			ftp.saveToBerkeley(faxID, byteSQLData);
		} catch (Exception ex) {
			LogUtil.warn("CONSOLE", "CanNotSaveFaxFileToBerkeley");
		}
		JMSMessage msg = new JMSMessage();
		msg.setDestination(queueName);
		msg.setMessageContent(faxContext);
		JMSUtil.send(msg);
	}

	/**
	 * 发送桌面消息，支持群发
	 */
	public void saveMultiDesktopMsg(String sender, String title, String content, String handerType, String receivers,
			boolean synchronize, Map<String, String> parameters) {

		JMSUtil.saveDesktopMsg(sender, title, content, handerType, receivers, synchronize, parameters);

	}

	/**
	 * 发送日志消息
	 */
	public void sendDBLog(String etipUserID,String etipUserName, String level, String type, String method, String title, String content,
			boolean synchronize, Map<String, String> parameters) {

		JMSUtil.sendDBLog(etipUserID,etipUserName, level, type, method, title, content, synchronize, parameters);

	}

	/**
	 * 发送邮件消息，支持群发
	 */
	public void sendMultiEmail(String sender, String content, String handerType, String receivers, boolean synchronize,
			Map<String, String> parameters) {

		JMSUtil.sendEmail(sender, content, handerType, receivers, synchronize, parameters);
	}

	/**
	 * 发送短信消息，支持群发
	 */
	public void sendMultiSMS(String sender, String content, String handerType, String receivers, boolean synchronize,
			Map<String, String> parameters) {
		JMSUtil.sendSMS(sender, content, handerType, receivers, synchronize, parameters);

	}

	/**
	 * 发送注册邮件服务
	 */
	public void sendRegisterMail(Map<String, String> contentMap) {
		Map msg = JmsTemple.register(contentMap);
		IJMSService jmsService = new JMSService();
		jmsService.sendMailOne(msg);
	}

	/**
	 * 发送重置密码服务
	 */
	public void sendResetPasswordMail(Map<String, String> contentMap) {
		Map msg = JmsTemple.resetPassword(contentMap);
		IJMSService jmsService = new JMSService();
		jmsService.sendMailOne(msg);
	}

	/**
	 * 普通赠送积分的队列 并通过drools规则引擎运算积分并保存积分记录，无返回值
	 * 
	 * @param propertyName
	 *            规则名称
	 * @param factType
	 *            事实类型
	 */
	public void sendDroolsScoreMessage(String propertyName, String factType, Map<String, String> parameters) {
		/*
		 * 以下创建消息内容
		 */
		Map<String, Object> contentMap = new HashMap();
		contentMap.put("propertyName", propertyName);
		contentMap.put("factType", factType);
		contentMap.put("parameters", parameters);
		String queueName = CacheUtil.paraCache.getParaValue("DroolsQueue");

		JMSMessage jms = new JMSMessage();
		jms.setDestination(queueName);
		jms.setMessageContent(contentMap);
		JMSUtil.send(jms);

	}

	/**
	 * 根据订单结算记录产生积分。
	 * 
	 * @param orderNumber:订单编号
	 * @param
	 *            orderType:订单类型-"01"代表国内机票产品;"02"代表国际机票产品;"03"代表国内酒店产品;"04"代表国际酒店产品;...以后扩展不同的订单类型
	 * @param bookingPersonID:预订人ID
	 * @param scoreSum:需要进行积分处理的有效金额（可以为负数）
	 * @param orderDate:订单创建时间要求格式（yyyy-mm-dd
	 *            hh:mm:ss）
	 * @param operatorNumber:操作人员工号（结算记录产生的操作员工号）
	 * @param
	 *            operationType:操作类型-"01"代表机票出票;"02"代表机票废票;"03"代表机票退票;"04"代表对冲(+/-)...以后扩展不同的操作类型
	 * @param
	 *            orderChannel:订单下单渠道-"01"代表网站下单;"02"代表cc下单;"03"代表自助终端机下单;...以后扩展不同的订单下单渠道
	 * @return boolean true-成功 false-失败
	 * 
	 */
	public boolean giveScore(@WebParam(name = "orderNumber")
	String orderNumber, @WebParam(name = "orderType")
	String orderType, @WebParam(name = "bookingPersonID")
	String bookingPersonID, @WebParam(name = "scoreSum")
	String scoreSum, @WebParam(name = "orderDate")
	String orderDate, @WebParam(name = "operatorNumber")
	String operatorNumber, @WebParam(name = "operationType")
	String operationType, @WebParam(name = "orderChannel")
	String orderChannel) {
		try {
			System.out.println("=giveScore start=");
			/* 构造Drools队列的机票送积分消息 开始 */
			Map<String, String> contentMap = new HashMap<String, String>();
			/* drools的配置文件名 */
			contentMap.put("propertyName", CacheUtil.paraCache.getParaValue("propertiesFile"));
			/* drools规则名称 */
			contentMap.put("factType", CacheUtil.paraCache.getParaValue("ScoreForOrders_factType"));
			/* 通过webservice传递过来的参数 */
			contentMap.put("orderNumber", orderNumber);
			contentMap.put("orderType", orderType);
			contentMap.put("bookingPersonID", bookingPersonID);
			contentMap.put("scoreSum", scoreSum);
			contentMap.put("orderDate", orderDate);
			contentMap.put("operatorNumber", operatorNumber);
			contentMap.put("operationType", operationType);
			contentMap.put("orderChannel", orderChannel);

			/* 发送机票送积分消息 开始 */
			String queueName = CacheUtil.paraCache.getParaValue("ScoreForAirOrdersQueue");

			JMSMessage jms = new JMSMessage();
			jms.setDestination(queueName);
			jms.setMessageContent(contentMap);
			JMSUtil.send(jms);

			/* 发送机票送积分消息 结束 */
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}