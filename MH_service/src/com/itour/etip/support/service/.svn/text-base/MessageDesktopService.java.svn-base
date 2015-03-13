package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.security.GrantedAuthority;

import com.itour.etip.contract.IJMSService;
import com.itour.etip.contract.JMSService;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.jms.JMSDeskTop;
import com.itour.etip.pub.kit.jms.JMSUtil;
import com.itour.etip.support.persistence.IMessageDesktopPersistence;

public class MessageDesktopService implements IMessageDesktopService {
	private IMessageDesktopPersistence messageDesktopPersistence;

	public IMessageDesktopPersistence getMessageDesktopPersistence() {
		return messageDesktopPersistence;
	}

	public void setMessageDesktopPersistence(
			IMessageDesktopPersistence messageDesktopPersistence) {
		this.messageDesktopPersistence = messageDesktopPersistence;
	}

	/**
	 * 发送消息
	 */
	public void sendMsg(JSONObject jsonData) {
		int msgChannel = jsonData.getInt("msgChannel");
		String target = jsonData.getString("target");
		String msgType = jsonData.getString("msgType");
		String title = jsonData.getString("title");
		String content = jsonData.getString("content");
		String order = jsonData.getString("order");
		String senderID = jsonData.getString("senderID");
		// 桌面消息
		switch (msgChannel) {
		case 1:// desktop
			// 2:直接发送到人
			// true:先测试同步发送，然后再测试异步发送
			if (order != null && order.trim().length() != 0) {
				title = title + ",关联订单号:" + order;
				content = content + ",关联订单号:" + order;
			}
			// 根据target工号查询receiverID(etipUserID)
			String sql = "select id from etipuser where usertype=3 and memberid in (select id from etipoperator where groupuserid in (select id from groupuser where workerno='"
					+ target + "'))";
			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> rv = jdbc.queryForList(sql, null);
			if (rv.size() == 0) {
				throw new ETIPException(
						"SendMsgErrorBecauseBecauseOfNoWorkerNO");
			}
			if (rv.size() > 1) {
				throw new ETIPException(
						"SendMsgErrorBecauseBecauseOfMoreThanOneWorkerNO");
			}
			// 以下发送信息
			String receiverID = rv.get(0).getString("ID");
			JMSUtil.sendDesktopDirectly(senderID,receiverID, title, content,true);
			break;
		case 2:// mobile，发送短信
			JMSUtil.sendSMSDirectly(target, content,true);
			break;
		case 3:// email，发送邮件
			JMSUtil.sendEmailDirectly(target, content,true);
			break;
		}
	}

	// parameters);

	/**
	 * 日志信息查询
	 * 
	 * @param String,limit,query
	 * @return PageModel
	 */
	public List<JMSDeskTop> query(PageRoll pageRoll, JSONObject condition,
			FrmUser user) {
		GrantedAuthority[] auths = user.getAuthorities();
		String roles = "";
		for (GrantedAuthority auth : auths) {
			roles += ",'" + auth.getAuthority().toString() + "'";
		}
		if (roles.length() > 0) {
			roles = roles.substring(1);
		} else
			roles = "''";
		roles = "(" + roles + ")";
		String userId = user.etipUserID;
		String receiverTypeCon = " where (jms.receiverType='ALL' or (jms.receiverType='ROLES' and jms.recipients in "
				+ roles
				+ ") or (jms.receiverType='USERS' and jms.recipients = '"
				+ userId + "'))";
		String hql = "from JMSDeskTop jms " + receiverTypeCon
				+ " order by jms.desktopTime desc";

		pageRoll.setSearchSQL(hql);
		pageRoll.setCountSQL("select count(*) " + hql);
		List<JMSDeskTop> search = messageDesktopPersistence.search(pageRoll);

		return search;
	}

	/**
	 * 日志信息浏览
	 * 
	 * @param id
	 * @return JMSDesktop
	 * 
	 */
	public JMSDeskTop select(String id) {
		// return messageDesktopPersistence.select(id);
		return null;
	}

	/**
	 * 日志信息清除
	 * 
	 * @param id
	 * @return boolean
	 * 
	 */
	public void delete(String[] id) {
		messageDesktopPersistence.delete(id);
	}

}
