package com.itour.etip.contract;

import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.kit.jms.JMSMessage;

/**
 * 消息平台公共服务。
 * 
 * @author lishan
 */
@WebService
public interface IJMSService {

	/**
	 * 发送普通消息
	 * 
	 * @param jms
	 *            消息实体
	 */
	public void sendQueueMessageOne(JMSMessage jms);

	/**
	 * 消息对象
	 * 
	 * @param queueName
	 *            队列名称
	 * @param content
	 *            消息内容
	 */
	public void sendQueueMessageTwo(String queueName,
			Map<String, String> content);

	/**
	 * FtpUtil ftpC = new FtpUtil("10.124.7.25", 20009, "etipfaxclient",
	 * "etipfaxclient123", "/"); String fileName =
	 * ftpC.uploadeFaxFile("E:\\itour\\fax\\87013782.TIF"); Map<String, Object>
	 * faxContext = new HashMap<String, Object>(); faxContext.put("SysID",
	 * "1000"); faxContext.put("UuID", System.currentTimeMillis());
	 * faxContext.put("Document", fileName); faxContext.put("Fax_Type", "1");
	 * faxContext.put("Fax_No", "87013782"); faxContext.put("Agent_ID",
	 * "11500"); faxContext.put("Dept", "38114505");
	 * faxContext.put("Staff_Name", "you guess"); faxContext.put("Urgent", "0");
	 * faxContext.put("Remark", "etip test 测试");
	 * 
	 * @param contextMap
	 */
	public void sendFaxOne(Map<String, String> contextMap);

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
	public void sendFaxTwo(@WebParam(name = "faxID") String faxID,
			@WebParam(name = "fax") String fax,
			@WebParam(name = "style") String style,
			@WebParam(name = "Fax_Type") String Fax_Type,
			@WebParam(name = "Fax_No") String Fax_No,
			@WebParam(name = "Agent_ID") String Agent_ID,
			@WebParam(name = "Dept") String Dept,
			@WebParam(name = "Staff_Name") String Staff_Name,
			@WebParam(name = "Urgent") String Urgent,
			@WebParam(name = "Remark") String Remark,
			@WebParam(name = "Document") String Document,
			@WebParam(name = "SysID") String SysID,
			@WebParam(name = "UuID") String UuID,
			@WebParam(name = "FaxQueue") String FaxQueue);

	public void sendSMS(Map<String, String> contextMap);

	/**
	 * 发送邮件，参数是Map,要求提供下列数据项目 EmailContext 邮件内容，可以使用html标签 Subject 标题 EmailTo
	 * 收件人邮件地址 EmailFrom 发件人邮件地址,如果没有，那么从paraCache中取 UuID 保留 SysID 保留
	 * TibcoEmailQueue 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendMailOne(
			@WebParam(name = "contextMap") Map<String, String> contextMap);

	/**
	 * 发送邮件 EmailContext 邮件内容，可以使用html标签 Subject 标题 EmailTo 收件人邮件地址 EmailFrom
	 * 发件人邮件地址,如果没有，那么从paraCache中取 UuID 保留 SysID 保留 TibcoEmailQueue
	 * 邮件消息队列，如果未填写，那么从缓冲区配置中取值
	 */
	public void sendMailTwo(
			@WebParam(name = "EmailContext") String EmailContext,
			@WebParam(name = "Subject") String Subject,
			@WebParam(name = "EmailTo") String EmailTo,
			@WebParam(name = "EmailFrom") String EmailFrom,
			@WebParam(name = "UuID") String UuID,
			@WebParam(name = "SysID") String SysID,
			@WebParam(name = "TibcoEmailQueue") String TibcoEmailQueue);

	/**
	 * 记录数据库日志
	 * 
	 * @param etipUserID
	 *            用户编码
	 * @param level
	 *            日志等级 DEBUG,INFO,WARN,ERROR,FATAl
	 * @param type
	 *            日志类型，字符串，实施时最好统一规划。
	 * @param method
	 *            触发日志时调用的方法
	 * @param title
	 *            日志标题
	 * @param content
	 *            日志内容
	 * @param synchronize
	 *            同步日志，还是异步日志
	 * @param parameters
	 *            日志内容中的参数
	 */
	public void sendDBLog(@WebParam(name = "etipUserID") String etipUserID,
			@WebParam(name = "etipUserName") String etipUserName,
			@WebParam(name = "level") String level,
			@WebParam(name = "type") String type,
			@WebParam(name = "method") String method,
			@WebParam(name = "title") String title,
			@WebParam(name = "content") String content,
			@WebParam(name = "synchronize") boolean synchronize,
			@WebParam(name = "parameters") Map<String, String> parameters);

	/**
	 * 发送桌面消息
	 * 
	 * @param sender
	 *            发送者
	 * @param title
	 *            消息标题
	 * @param content
	 *            内容主体
	 * @param handerType
	 *            处理类型
	 * @param receivers
	 *            接受者
	 * @param synchronize
	 *            同步还是异步
	 * @param parameters
	 *            消息参数
	 */
	public void saveMultiDesktopMsg(@WebParam(name = "sender") String sender,
			@WebParam(name = "title") String title,
			@WebParam(name = "content") String content,
			@WebParam(name = "handerType") String handerType,
			@WebParam(name = "receivers") String receivers,
			@WebParam(name = "synchronize") boolean synchronize,
			@WebParam(name = "parameters") Map<String, String> parameters);

	/**
	 * 发送短信,根据不同发送类型，发送短信，此处需要找到对应每个事件对应的手机号码。
	 */
	public void sendMultiSMS(@WebParam(name = "sender") String sender,
			@WebParam(name = "content") String content,
			@WebParam(name = "handerType") String handerType,
			@WebParam(name = "receivers") String receivers,
			@WebParam(name = "synchronize") boolean synchronize,
			@WebParam(name = "parameters") Map<String, String> parameters);

	/**
	 * 发送邮件,与发送短信类似，不过似是发送渠道不同。 Map<String, String> mail = new HashMap<String,
	 * String>(); mail.put("EmailContext", "欢迎注册itour会员, 请记住用户名密码");
	 * mail.put("Subject", "欢迎注册itour会员"); mail.put("EmailTo",
	 * "noah_ls@sina.com"); mail.put("EmailFrom", "etip@itour.cn");
	 * mail.put("UuID", ""); mail.put("SysID", "");
	 */
	public void sendMultiEmail(@WebParam(name = "sender") String sender,
			@WebParam(name = "content") String content,
			@WebParam(name = "handerType") String handerType,
			@WebParam(name = "receivers") String receivers,
			@WebParam(name = "synchronize") boolean synchronize,
			@WebParam(name = "parameters") Map<String, String> parameters);

	/**
	 * 发送注册邮件服务
	 */
	public void sendRegisterMail(Map<String, String> contentMap);

	/**
	 * 发送重置密码服务
	 */
	public void sendResetPasswordMail(Map<String, String> contentMap);

	/**
	 * 普通赠送积分的队列 并通过drools规则引擎运算积分并保存积分记录，无返回值
	 * 
	 * @param propertyName
	 *            规则名称
	 * @param factType
	 *            事实类型
	 */
	public void sendDroolsScoreMessage(String propertyName, String factType,
			Map<String, String> parameters);

	/**
	 * 根据订单结算记录产生积分。
	 * 
	 * @param orderNumber
	 *            :订单编号
	 * @param 
	 *        orderType:订单类型-"01"代表国内机票产品;"02"代表国际机票产品;"03"代表国内酒店产品;"04"代表国际酒店产品;
	 *        ...以后扩展不同的订单类型
	 * @param bookingPersonID
	 *            :预订人ID
	 * @param scoreSum
	 *            :需要进行积分处理的有效金额（可以为负数）
	 * @param orderDate
	 *            :订单创建时间要求格式（yyyy-mm-dd hh:mm:ss）
	 * @param operatorNumber
	 *            :操作人员工号（结算记录产生的操作员工号）
	 * @param 
	 *        operationType:操作类型-"01"代表机票出票;"02"代表机票废票;"03"代表机票退票;"04"代表对冲(+/-)...
	 *        以后扩展不同的操作类型
	 * @param 
	 *        orderChannel:订单下单渠道-"01"代表网站下单;"02"代表cc下单;"03"代表自助终端机下单;...以后扩展不同的订单下单渠道
	 * @return boolean true-成功 false-失败
	 * 
	 */
	public boolean giveScore(
			@WebParam(name = "orderNumber") String orderNumber,
			@WebParam(name = "orderType") String orderType,
			@WebParam(name = "bookingPersonID") String bookingPersonID,
			@WebParam(name = "scoreSum") String scoreSum,
			@WebParam(name = "orderDate") String orderDate,
			@WebParam(name = "operatorNumber") String operatorNumber,
			@WebParam(name = "operationType") String operationType,
			@WebParam(name = "orderChannel") String orderChannel);

}
