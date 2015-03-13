package com.itour.etip.pub.kit.jms;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.Session;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.drools.DroolsUtil;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.log.LogUtil;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;

/**
 * <p>
 * Title: 发送Queue消息
 * </p>
 * <p>
 * 发送消息的功能类。
 * </p>
 * <p>
 * Copyright: Copyright (C), 2009-2010, eTIP
 * </p>
 * 
 * @Author zoumingming
 * @Version 1.0
 * @Date 2009-06-10
 */
public class JMSUtil {

	/**
	 * 发送消息对象。
	 * 
	 * @param queueName
	 *            队列名称
	 * @param content
	 *            消息内容
	 */
	public static void send(String queueName, Map content) {
		JMSMessage jms = new JMSMessage();
		jms.setDestination(queueName);
		jms.setMessageContent(content);
		send(jms);
	}

	/**
	 * 发送Queue消息
	 * 
	 * @param msg
	 *            消息对象，要求是JMSMessage类型。
	 * 
	 */
	public static void send(JMSMessage msg) {
		try {
			/*
			 * 检查消息配置是否关闭，如果关闭，那么不发送消息。
			 */
			String jmsContection = CacheUtil.paraCache
					.getParaValue("JMSConnect");
			if (!(jmsContection.equals("true"))) {
				LogUtil
						.warn("CONSOLE",
								"para.xml 中 JMSConnection 设置为关闭，不能发送消息");
				return;
			}

			ConnectionFactory connectionFactory = null;
			QueueConnection connection = null;
			Session session = null;
			MessageProducer producer = null;
			Message message = null;
			try {
				/** 建立消息服务器连接 */
				connectionFactory = new ConnectionFactory();
				String jmsServer = CacheUtil.paraCache
						.getParaValue("JMSServer");
				String jmsUser = CacheUtil.paraCache.getParaValue("JMSUser");
				String jmsPassword = CacheUtil.paraCache
						.getParaValue("JMSPassword");

				connectionFactory.setProperty("imqAddressList", jmsServer);
				connectionFactory.setProperty(
						ConnectionConfiguration.imqDefaultUsername, jmsUser);
				connectionFactory
						.setProperty(
								ConnectionConfiguration.imqDefaultPassword,
								jmsPassword);
				connection = connectionFactory.createQueueConnection();
				session = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);

				JMSMessage jmsMsg = (JMSMessage) msg;
				Object content = jmsMsg.getMessageContent();
				String queueName = jmsMsg.getDestination();
				Destination destination = null;
				try {
					destination = new Queue(queueName);
				} catch (Throwable throwable) {
					LogUtil.error("CONSOLE", "sendJMSError:"
							+ throwable.toString());
					return;
				}
				producer = session.createProducer(destination);
				connection.start();
				// 字符串类型内容
				if (content instanceof String) {
					message = session.createTextMessage(msg.toString());
				}
				// hash表型内容
				else if (content instanceof HashMap) {
					HashMap contentMap = (HashMap) content;
					MapMessage mm = session.createMapMessage();
					Iterator it = contentMap.keySet().iterator();
					boolean isDifficulty = false;
					while (it.hasNext()) {
						String name = it.next().toString();
						Object o = contentMap.get(name);
						if (o != null && !(o instanceof String)) {
							isDifficulty = true;
							break;
						}
						if (o == null) {
							mm.setString(name, "");
						} else {
							mm.setString(name, o.toString());
						}
					}
					if (isDifficulty) {
						message = session
								.createObjectMessage((Serializable) content);
					} else {
						message = mm;
					}
				}
				// 其它类型内容
				else {
					message = session
							.createObjectMessage((Serializable) content);
				}
				producer.send(message);

			}
			// JMS链接例外，记录例外日志，并抛出错误信息
			catch (JMSException ex) {
				LogUtil.error("CONSOLE", ex.toString());
				ex.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		} catch (Throwable ex1) {
			LogUtil.error("CONSOLE", "sendJMSError:" + ex1.toString());
		}
	}

	/**
	 * 记录数据库日志
	 * 
	 * @param etipUserID
	 *            用户编码
	 * @param etipUserName
	 * 			     用户姓名
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
	public static void sendDBLog(String etipUserID,String etipUserName, String level, String type,
			String method, String title, String content, boolean synchronize,
			Map parameters) {
		// 创建消息对象
		JMSLog jmsLog = new JMSLog();
		// 发送日期，自动生成时间，日志类别为INFO
		jmsLog.setTime(new java.util.Date());
		// 如果没有设置level,那么设置默认值。
		if (level == null || level.trim().length() == 0)
			level = JMSLog.LEVEL_INFO;
		// 级别设置错误，抛出错误
		if (!JMSLog.checkLevel(level)) {
			throw new ETIPError("UnsupportJMSLogLevel");
		}
		jmsLog.setLoglevel(level);
		// 日志分类，实施时最好统一规划
		if (type == null || type.trim().length() == 0) {
			type = "未设置日志类型";
		}
		jmsLog.setType(type);
		// 触发日志的方法
		if (method == null || method.trim().length() == 0) {
			type = "未知方法";
		}
		jmsLog.setMethod(method);

		// 记录日志时，当前的操作者，如果未设置值，那么从Session中取值。
		if (etipUserID == null || etipUserID.trim().length() == 0) {
			etipUserID = FrmUser.getUser().etipUserID;
			etipUserName = FrmUser.getUser().chinseName;
		}
		// 如果etipUserID==null,说明当前系统未登录
		jmsLog.setUserid(etipUserID);
		jmsLog.setValueToCreatorName(etipUserName);
		jmsLog.setValueToUpdatorName(etipUserName);
		// 检查日志标题，如果发现未设置，那么以当前日期作为日志标题
		if (title == null || title.trim().length() == 0) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			title = formatter.format(new Date());
		}
		jmsLog.setTitle(title);

		// 如果没有设置日志内容，那么检查是否有参数，那么将参数转换为内容，如果没有参数，那么日志内容和title相同
		StringBuffer messageContent = new StringBuffer();
		if (content == null) {
			// 取得每个参数值显示
			if (parameters != null) {
				Object[] keys = parameters.keySet().toArray();
				for (Object key : keys) {
					messageContent.append("[");
					messageContent.append(key);
					messageContent.append(":");
					messageContent.append(parameters.get(key));
					messageContent.append("]");
				}
			} else {
				messageContent.append(title);
			}
			//
		} else {
			if (parameters != null) {
				Object[] keys = parameters.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					Object value = parameters.get(keys[i]);
					String indexStr = "[" + keys[i] + "]";
					int index = content.indexOf(indexStr);
					while (index != -1) {
						content = content.substring(0, index) + value
								+ content.substring(index + indexStr.length());
						index = content.indexOf(indexStr);
					}
				}
			}
			messageContent.append(content);
		}
		content = messageContent.toString();
		// 根据data.xml得到的日志表的content字段的长度 根据长度限制进行截取
		Integer contentLength = Integer.valueOf((String)CacheUtil.dataCache.getDataMap("logcontentLength").get("length"));
		if(content.length()>contentLength){
		    content = content.substring(0, contentLength);
		}
		jmsLog.setContent(content);
		// 此处判断是同步还是异步，如果是同步，那么立即存储数据库，如果是异步，那么通过jms存储数据库
		if (synchronize == true) {
			HibernateDao hibernate = (HibernateDao) SpringContextHelper
					.getBean("hibernate");
			hibernate.save(jmsLog);
		} else if (synchronize == false) {
			// 此处需要包装为服务。
			JMSMessage jms = new JMSMessage();
			String queueName = CacheUtil.paraCache.getParaValue("DBLogQueue");
			jms.setDestination(queueName);
			jms.setMessageContent(jmsLog);
			LogUtil.info("eTIPJMS", jms);
		}
	}

	/**
	 * 发送桌面消息
	 * 
	 * @param senderID
	 *            发送者ID
	 * @param receiverID
	 *            接受者ID
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param synchronize
	 *            是否同步发送
	 */
	public static void sendDesktopDirectly(String senderID, String receiverID,
			String title, String content, boolean synchronize) {
		JMSDeskTop msg = new JMSDeskTop();
		msg.setDesktopTime(new java.util.Date());
		msg.setSender(senderID);
		msg.setSendChannel("DesktopMsg");
		// 检查日志标题，如果发现未设置，那么以当前日期作为日志标题
		if (title == null || title.trim().length() == 0) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			title = formatter.format(new Date());
		}
		msg.setTitle(title);
		msg.setContent(content);
		msg.setReceiverType("USERS");

		// 异步消息。
		JMSMessage jms = new JMSMessage();
		// jms.setMessageType(JMSMessage.MESSAGETYPE_DESKTOPMSG);
		String queueName = CacheUtil.paraCache.getParaValue("DesktopMsgQueue");
		jms.setDestination(queueName);
		jms.setMessageContent(msg);
		msg.setRecipients(receiverID);
		if (synchronize == true) {
			HibernateDao hibernate = (HibernateDao) SpringContextHelper
					.getBean("hibernate");
			hibernate.save(msg);
		} else if (synchronize == false) {
			LogUtil.info("eTIPJMS", jms);
		}
	}

	/**
	 * 发送桌面消息
	 * 
	 * @param user
	 * @param registry
	 * @param invocation
	 * @param synchronize
	 * @param parameters
	 */
	public static void saveDesktopMsg(String sender, String title,
			String content, String handerType, String receivers,
			boolean synchronize, Map parameters) {
		JMSDeskTop msg = new JMSDeskTop();
		msg.setDesktopTime(new java.util.Date());
		if (sender == null || sender.trim().length() == 0) {
			sender = FrmUser.getUser().etipUserID;
		}
		msg.setSender(sender);

		msg.setSendChannel("DesktopMsg");

		// 检查日志标题，如果发现未设置，那么以当前日期作为日志标题
		if (title == null || title.trim().length() == 0) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			title = formatter.format(new Date());
		}
		msg.setTitle(title);

		// 如果没有设置日志内容，那么检查是否有参数，那么将参数转换为内容，如果没有参数，那么日志内容和title相同
		StringBuffer messageContent = new StringBuffer();
		if (content == null) {
			// 取得每个参数值显示
			if (parameters == null) {
				Object[] keys = parameters.keySet().toArray();
				for (Object key : keys) {
					messageContent.append("[");
					messageContent.append(key);
					messageContent.append(":");
					messageContent.append(parameters.get(key));
					messageContent.append("]");
				}
			} else {
				messageContent.append(title);
			}
			//
		} else {
			if (parameters != null) {
				Object[] keys = parameters.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					Object value = parameters.get(keys[i]);
					String indexStr = "[" + keys[i] + "]";
					int index = content.indexOf(indexStr);
					while (index != -1) {
						content = content.substring(0, index) + value
								+ content.substring(index + indexStr.length());
						index = content.indexOf(indexStr);
					}
				}
			}
			messageContent.append(content);
		}
		content = messageContent.toString();

		msg.setContent(content);

		// 此处更加recievers反转知道receiverType.
		if (handerType == null) {
			return;// 此处不发送消息
		}

		handerType = handerType.trim();
		// 发送给所有人的桌面消息
		if (handerType.startsWith("0")) {
			msg.setReceiverType("ALL");
			if (synchronize == true) {
				HibernateDao hibernate = (HibernateDao) SpringContextHelper
						.getBean("hibernate");
				hibernate.save(msg);
			} else if (synchronize == false) {
				JMSMessage jms = new JMSMessage();
				// jms.setMessageType(JMSMessage.MESSAGETYPE_DESKTOPMSG);
				String queueName = CacheUtil.paraCache
						.getParaValue("DesktopMsgQueue");
				jms.setDestination(queueName);
				jms.setMessageContent(msg);
				LogUtil.info("eTIPJMS", jms);
			}
			// 发送指定角色的桌面消息
		} else if (handerType.startsWith("1")) {
			String roles = receivers;
			if (roles == null || roles.trim().length() == 0) {
				return;
			}
			java.util.StringTokenizer tokens = new java.util.StringTokenizer(
					roles, ",");
			msg.setReceiverType("ROLES");
			// 异步消息。
			JMSMessage jms = new JMSMessage();
			// jms.setMessageType(JMSMessage.MESSAGETYPE_DESKTOPMSG);
			String queueName = CacheUtil.paraCache
					.getParaValue("DesktopMsgQueue");
			jms.setDestination(queueName);
			jms.setMessageContent(msg);

			while (tokens.hasMoreTokens()) {
				String role = tokens.nextToken();
				msg.setRecipients(role);
				if (synchronize == true) {
					HibernateDao hibernate = (HibernateDao) SpringContextHelper
							.getBean("hibernate");
					hibernate.save(msg);
				} else if (synchronize == false) {

					LogUtil.info("eTIPJMS", jms);
				}
			}
			// 发送给指定用户的桌面消息
		} else if (handerType.startsWith("2")) {
			String users = receivers;
			if (users == null || users.trim().length() == 0) {
				return;
			}
			msg.setReceiverType("USERS");
			java.util.StringTokenizer tokens = new java.util.StringTokenizer(
					users, ",");
			// 异步消息。
			JMSMessage jms = new JMSMessage();
			// jms.setMessageType(JMSMessage.MESSAGETYPE_DESKTOPMSG);
			String queueName = CacheUtil.paraCache
					.getParaValue("DesktopMsgQueue");
			jms.setDestination(queueName);
			jms.setMessageContent(msg);
			while (tokens.hasMoreTokens()) {
				String role = tokens.nextToken();
				msg.setRecipients(role);
				if (synchronize == true) {
					HibernateDao hibernate = (HibernateDao) SpringContextHelper
							.getBean("hibernate");
					hibernate.save(msg);
				} else if (synchronize == false) {
					LogUtil.info("eTIPJMS", jms);
				}
			}
		}

	}

	/**
	 * 发送短信,根据不同发送类型，发送短信，此处需要找到对应每个事件对应的手机号码。
	 */
	public static void sendSMS(String sender, String content,
			String handerType, String receivers, boolean synchronize,
			Map parameters) {
		/*
		 * 以下需要获取满足条件的所有用户的手机号码。
		 * 
		 */
		Map<String, String> sms = new HashMap<String, String>();
		sms.put("UuID", "");
		sms.put("SysID", "");
		// 短信内容

		// 如果没有设置日志内容，那么检查是否有参数，那么将参数转换为内容，如果没有参数，那么日志内容和title相同
		StringBuffer messageContent = new StringBuffer();
		if (content == null) {
			// 取得每个参数值显示
			if (parameters == null) {
				Object[] keys = parameters.keySet().toArray();
				for (Object key : keys) {
					messageContent.append("[");
					messageContent.append(key);
					messageContent.append(":");
					messageContent.append(parameters.get(key));
					messageContent.append("]");
				}
			}
			//
		} else {
			if (parameters != null) {
				Object[] keys = parameters.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					Object value = parameters.get(keys[i]);
					String indexStr = "[" + keys[i] + "]";
					int index = content.indexOf(indexStr);
					while (index != -1) {
						content = content.substring(0, index) + value
								+ content.substring(index + indexStr.length());
						index = content.indexOf(indexStr);
					}
				}
			}
			messageContent.append(content);
		}

		sms.put("MsgContent", messageContent.toString());
		// 此处搜索所有的sms手机号码，从系统中查询，这是一件可怕的事情。
		JMSMessage jms = new JMSMessage();
		jms.setMessageContent(sms);
		// 此处更加recievers反转知道receiverType.
		if (handerType == null) {
			return;// 此处不发送消息
		}
		handerType = handerType.trim();

		if (handerType.startsWith("0")) {

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");
			String sql = "select distinct mobile from groupuser a,etipoperator b where a.ownergroupid='"
					+ hostGroupBaseID
					+ "' and b.status=1 and b.groupuserid=a.id ";
			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String mobileNO = mobile.getString("MOBILE");
				if (mobileNO == null)
					continue;
				mobileNO = mobileNO.trim();
				if (mobileNO.length() == 0)
					continue;
				sms.put("PhoneNO", mobileNO);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoSMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(jms.MESSAGETYPE_TIBCOSMS);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("SMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_SMS);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		} else if (handerType.startsWith("1")) {
			// 此处需要按照角色搜索手机号码。

			String roles = receivers;// 此处role是名称，而不是id.
			if (roles == null)
				return;
			roles = roles.trim();
			if (roles.length() == 0)
				return;
			String rolesStr = "";
			StringTokenizer tokens = new StringTokenizer(roles, ",");
			while (tokens.hasMoreTokens()) {
				rolesStr = rolesStr + ",'" + tokens.nextToken() + "'";
			}
			if (rolesStr.length() > 0) {
				rolesStr = rolesStr.substring(1);
			} else {
				return;
			}

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");

			String sql = "select  distinct d.mobile from etipuserrole a,roleregistry b,etipoperator c,groupuser d  where b.roleclass=1 and b.rolename in ("
					+ rolesStr
					+ ") and a.roleid=b.id and a.etipoperatorid=c.id and c.status=1 and c.groupuserid=d.id and d.ownergroupid='"
					+ hostGroupBaseID + "'";
			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String mobileNO = mobile.getString("MOBILE");
				if (mobileNO == null)
					continue;
				mobileNO = mobileNO.trim();
				if (mobileNO.length() == 0)
					continue;
				sms.put("PhoneNO", mobileNO);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoSMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(jms.MESSAGETYPE_TIBCOSMS);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("SMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_SMS);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		} else if (handerType.startsWith("2")) {

			String users = receivers;// 此处role是名称，而不是id.
			if (users == null)
				return;
			users = users.trim();
			if (users.length() == 0)
				return;
			String usersStr = "";
			StringTokenizer tokens = new StringTokenizer(users, ",");
			while (tokens.hasMoreTokens()) {
				usersStr = usersStr + ",'" + tokens.nextToken() + "'";
			}
			if (usersStr.length() > 0) {
				usersStr = usersStr.substring(1);
			} else {
				return;
			}

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");
			// 搜索userStr的手机号码，从GroupUser中搜索。
			String sql = "select distinct a.mobile from groupuser a,etipoperator b where a.ownergroupid='"
					+ hostGroupBaseID
					+ "' and a.id=b.groupuserid and b.status=1 and b.id in ("
					+ usersStr + ")";

			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String mobileNO = mobile.getString("MOBILE");
				if (mobileNO == null)
					continue;
				mobileNO = mobileNO.trim();
				if (mobileNO.length() == 0)
					continue;
				sms.put("PhoneNO", mobileNO);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoSMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(jms.MESSAGETYPE_TIBCOSMS);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("SMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_SMS);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		}
	}

	/**
	 * 直接发送短信
	 */
	public static void sendSMSDirectly(String receiverMobile, String content,
			boolean synchronize) {

		Map<String, String> sms = new HashMap<String, String>();
		sms.put("UuID", "");
		sms.put("SysID", "");
		sms.put("MsgContent", content);
		sms.put("PhoneNO", receiverMobile);
		JMSMessage jms = new JMSMessage();
		jms.setMessageContent(sms);
		if (synchronize == true) {
			String queueName = CacheUtil.paraCache
					.getParaValue("TibcoSMSQueue");
			jms.setDestination(queueName);
			JMSUtil.send(jms);
		} else if (synchronize == false) {
			String queueName = CacheUtil.paraCache.getParaValue("SMSQueue");
			jms.setDestination(queueName);
			LogUtil.info("eTIPJMS", jms);
		}
	}

	/**
	 * 发送邮件,与发送短信类似，不过似是发送渠道不同。 Map<String, String> mail = new HashMap<String,
	 * String>(); mail.put("EmailContext", "欢迎注册itour会员, 请记住用户名密码");
	 * mail.put("Subject", "欢迎注册itour会员"); mail.put("EmailTo",
	 * "noah_ls@sina.com"); mail.put("EmailFrom", "etip@itour.cn");
	 * mail.put("UuID", ""); mail.put("SysID", "");
	 */
	public static void sendEmail(String sender, String content,
			String handerType, String receivers, boolean synchronize,
			Map parameters) {
		/*
		 * 以下需要获取满足条件的所有用户的手机号码。
		 * 
		 */
		Map<String, String> mail = new HashMap<String, String>();
		mail.put("Subject", "etip提醒");
		mail.put("EmailFrom", "etip@itour.cn");
		mail.put("UuID", "");
		mail.put("SysID", "");

		// 短信内容

		// 如果没有设置日志内容，那么检查是否有参数，那么将参数转换为内容，如果没有参数，那么日志内容和title相同
		StringBuffer messageContent = new StringBuffer();
		if (content == null) {
			// 取得每个参数值显示
			if (parameters == null) {
				Object[] keys = parameters.keySet().toArray();
				for (Object key : keys) {
					messageContent.append("[");
					messageContent.append(key);
					messageContent.append(":");
					messageContent.append(parameters.get(key));
					messageContent.append("]");
				}
			}
			//
		} else {
			if (parameters != null) {
				Object[] keys = parameters.keySet().toArray();
				for (int i = 0; i < keys.length; i++) {
					Object value = parameters.get(keys[i]);
					String indexStr = "[" + keys[i] + "]";
					int index = content.indexOf(indexStr);
					while (index != -1) {
						content = content.substring(0, index) + value
								+ content.substring(index + indexStr.length());
						index = content.indexOf(indexStr);
					}
				}
			}
			messageContent.append(content);
		}
		mail.put("EmailContext", messageContent.toString());

		// 此处搜索所有的sms手机号码，从系统中查询，这是一件可怕的事情。
		JMSMessage jms = new JMSMessage();
		jms.setMessageContent(mail);

		// 此处更加recievers反转知道receiverType.
		if (handerType == null) {
			return;// 此处不发送消息
		}
		handerType = handerType.trim();

		if (handerType.startsWith("0")) {

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");

			String sql = "select distinct email from groupuser a,etipoperator b where a.ownergroupid='"
					+ hostGroupBaseID
					+ "' and b.status=1 and b.groupuserid=a.id ";
			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String emailCode = mobile.getString("EMAIL");
				if (emailCode == null)
					continue;
				emailCode = emailCode.trim();
				if (emailCode.length() == 0)
					continue;
				mail.put("EmailTo", emailCode);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoEmailQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(jms.MESSAGETYPE_TIBCOMAIL);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("MailQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_MAIL);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		} else if (handerType.startsWith("1")) {
			// 此处需要按照角色搜索手机号码。
			String roles = receivers;// 此处role是名称，而不是id.
			if (roles == null)
				return;
			roles = roles.trim();
			if (roles.length() == 0)
				return;
			String rolesStr = "";
			StringTokenizer tokens = new StringTokenizer(roles, ",");
			while (tokens.hasMoreTokens()) {
				rolesStr = rolesStr + ",'" + tokens.nextToken() + "'";
			}
			if (rolesStr.length() > 0) {
				rolesStr = rolesStr.substring(1);
			} else {
				return;
			}

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");

			String sql = "select  distinct d.email from etipuserrole a,roleregistry b,etipoperator c,groupuser d  where b.roleclass=1 and b.rolename in ("
					+ rolesStr
					+ ") and a.roleid=b.id and a.etipoperatorid=c.id and c.status=1 and c.groupuserid=d.id and d.ownergroupid='"
					+ hostGroupBaseID + "'";
			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String emailCode = mobile.getString("EMAIL");
				if (emailCode == null)
					continue;
				emailCode = emailCode.trim();
				if (emailCode.length() == 0)
					continue;
				mail.put("EmailTo", emailCode);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoSMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_TIBCOSMS);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("SMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_SMS);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		} else if (handerType.startsWith("2")) {
			String users = receivers;// 此处role是名称，而不是id.
			if (users == null)
				return;
			users = users.trim();
			if (users.length() == 0)
				return;
			String usersStr = "";
			StringTokenizer tokens = new StringTokenizer(users, ",");
			while (tokens.hasMoreTokens()) {
				usersStr = usersStr + ",'" + tokens.nextToken() + "'";
			}
			if (usersStr.length() > 0) {
				usersStr = usersStr.substring(1);
			} else {
				return;
			}

			// 此处搜索所有有效用户的手机号码，然后发送，最好不这样，此处仅限于纵横天地组织成员
			String hostGroupBaseID = CacheUtil.paraCache
					.getParaValue("HostGroupBaseID");
			// 搜索userStr的手机号码，从GroupUser中搜索。
			String sql = "select distinct a.mobile from groupuser a,etipoperator b where a.ownergroupid='"
					+ hostGroupBaseID
					+ "' and a.id=b.groupuserid and b.status=1 and b.id in ("
					+ usersStr + ")";

			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> mobiles = jdbc.queryForList(sql, null);

			for (ETIPResultSet mobile : mobiles) {
				String emailCode = mobile.getString("EMAIL");
				if (emailCode == null)
					continue;
				emailCode = emailCode.trim();
				if (emailCode.length() == 0)
					continue;
				mail.put("EmailTo", emailCode);
				if (synchronize == true) {
					String queueName = CacheUtil.paraCache
							.getParaValue("TibcoSMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_TIBCOSMS);
					JMSUtil.send(jms);
				} else if (synchronize == false) {
					String queueName = CacheUtil.paraCache
							.getParaValue("SMSQueue");
					jms.setDestination(queueName);
					// jms.setMessageType(JMSMessage.MESSAGETYPE_SMS);
					LogUtil.info("eTIPJMS", jms);
				}
			}
		}
	}

	/**
	 * 直接发送电子邮件
	 */
	public static void sendEmailDirectly(String receiverEmail, String content,
			boolean synchronize) {
		/*
		 * 以下需要获取满足条件的所有用户的手机号码。
		 * 
		 */
		Map<String, String> mail = new HashMap<String, String>();
		mail.put("Subject", "etip提醒");
		mail.put("EmailFrom", "etip@itour.cn");
		mail.put("UuID", "");
		mail.put("SysID", "");
		mail.put("EmailContext", "content");
		mail.put("EmailTo", receiverEmail);

		// 此处搜索所有的sms手机号码，从系统中查询，这是一件可怕的事情。
		JMSMessage jms = new JMSMessage();
		jms.setMessageContent(mail);
		if (synchronize == true) {
			String queueName = CacheUtil.paraCache
					.getParaValue("TibcoSMSQueue");
			jms.setDestination(queueName);
			JMSUtil.send(jms);
		} else if (synchronize == false) {
			String queueName = CacheUtil.paraCache.getParaValue("SMSQueue");
			jms.setDestination(queueName);
			LogUtil.info("eTIPJMS", jms);
		}

	}

	/**
	 * 此处比较特殊，用于业务规则处理，而不是通常意义的发送消息。
	 * 
	 * @param user
	 *            当前登录用户。
	 * @param registry
	 *            消息注册表
	 * @param invocation
	 *            当前调用的方法
	 * @param synchronize
	 *            true：同步；false:异步
	 */
	public static void sendToDrools(String propertyName, String factType,
			boolean synchronize, Map factValues) {
		if (propertyName == null || propertyName.trim().length() == 0)
			return;
		if (factType == null || factType.trim().length() == 0)
			return;
		if (factValues == null)
			return;

		/*
		 * 以下创建消息内容
		 */
		factValues.put("propertyName", propertyName);
		factValues.put("factType", factType);
		// 同步调用，那么直接执行规则
		if (synchronize == true) {
			DroolsUtil.excuteDrools(factValues);
		} else if (synchronize == false) {// 异步调用
			JMSMessage jms = new JMSMessage();
			String queueName = CacheUtil.paraCache.getParaValue("DroolsQueue");
			jms.setDestination(queueName);
			jms.setMessageContent(factValues);
			JMSUtil.send(jms);
		}
	}

	/**
	 * 此处比较特殊，用于自定义业务规则处理，而不是通常意义的发送消息。 如果是业务规则引擎，需要做些
	 * 
	 * @param user
	 * @param registry
	 * @param invocation
	 * @param synchronize
	 */
	public static void sendToEtipRules(FrmUser user, String receivers,
			boolean synchronize, Object parameters) {
		Map<String, Object> contentMap = new HashMap<String, Object>();
		// 按照顺序取值
		if (receivers == null) {
			// return;
			receivers = "Award001";
		}
		receivers = receivers.trim();
		if (receivers.length() == 0) {
			// return;
			receivers = "Award001";
		}

		// 同步调用
		if (synchronize == true) {
			DroolsUtil.excuteDrools(contentMap);
		} else if (synchronize == false) {// 异步调用
			JMSMessage jms = new JMSMessage();
			String queueName = CacheUtil.paraCache.getParaValue("DroolsQueue");
			jms.setDestination(queueName);
			// jms.setMessageType(JMSMessage.MESSAGETYPE_DROOLS);
			jms.setMessageContent(contentMap);
			LogUtil.info("eTIPJMS", jms);
		}

	}
}
