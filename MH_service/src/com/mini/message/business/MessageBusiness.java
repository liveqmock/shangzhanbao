package com.mini.message.business;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.data.MessageData;
import com.mini.message.persistence.IMessagePersistence;
import com.sys.user.data.UserData;
import com.sys.user.persistence.IUserPersistence;

/**
 * 〈留言表 business 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("messageBusiness")
public class MessageBusiness extends FrmBusiness implements IMessageBusiness{
	@Resource(name="messagePersistence")
	private IMessagePersistence messagePersistence; //留言
	@Resource(name="userPersistence")
	private IUserPersistence userPersistence;   //用户
	/**
	 * 分页查询  所有
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param pageRoll
	 * @param messageData
	 * @return
	 */
	@Override
	public List<MessageData> getAll(PageRoll pageRoll, MessageData messageData) {
		List<MessageData> list=messagePersistence.getAll(pageRoll, messageData);
		//根据返回的集合，遍历查询用户实体
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getUserId()!=null && !"".equals(list.get(i).getUserId())){
				UserData userData=userPersistence.retrieve(list.get(i).getUserId());
				list.get(i).setUserData(userData);
			}
		}
		return list;
	}
	/**
	 * 增加留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	@Override
	public String saveMessageData(MessageData messageData) {
		String mes="0";
		try {
			messageData.setCreateTime(new Date());  //创建时间
			messageData.setStatus("1");  //未查看
			messageData.setIsdelete("1");  //正常数据
			messagePersistence.add(messageData);
			mes="1";
		} catch (Exception e) {
			mes="0";
		}
		return mes;
	}
	/**
	 * 修改留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	@Override
	public String updateMessageData(MessageData messageData) {
		String mes="0";
		try {
			messagePersistence.update(messageData);
			mes="1";
		} catch (Exception e) {
			mes="0";
		}
		return mes;
	}
	/**
	 * 删除留言  假删
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	@Override
	public String deleteMessageData(MessageData messageData) {
		String mes="0";
		try {
			messageData=messagePersistence.retrieve(messageData.getId());
			messageData.setIsdelete("0");  //假删除
			messagePersistence.update(messageData);
			mes="1";
		} catch (Exception e) {
			mes="0";
		}
		return mes;
	}
	/**
	 * 查看留言详情
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	@Override
	public MessageData getMessageData(MessageData messageData) {
		MessageData messageDatas=messagePersistence.retrieve(messageData.getId());
		//更具留言表中的用户id查询用户实体
		if(messageDatas.getUserId()!=null && !"".equals(messageDatas.getUserId())){
			UserData userData=userPersistence.retrieve(messageDatas.getUserId());
			messageDatas.setUserData(userData);
		}
		return	messageDatas;
 
	}
	

}
