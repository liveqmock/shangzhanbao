package com.mini.message.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.business.IMessageBusiness;
import com.mini.message.data.MessageData;
/**
 * 〈留言表 service 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("messageService")
public class MessageService extends FrmService implements IMessageService{
	@Resource(name="messageBusiness")
	private IMessageBusiness messageBusiness;  //留言
	/**
	 * 分页查询  所有
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param pageRoll
	 * @param messageData
	 * @return
	 */
	public List<MessageData>  getAll(PageRoll pageRoll,MessageData messageData){
		pageRoll = PageRoll.set(10, pageRoll);
		return messageBusiness.getAll(pageRoll, messageData);
	}
	/**
	 * 增加留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String saveMessageData(MessageData messageData){
		return messageBusiness.saveMessageData(messageData);
	}
	/**
	 * 修改留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String updateMessageData(MessageData messageData){
		return messageBusiness.updateMessageData(messageData);
	}
	/**
	 * 删除留言  假删
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String deleteMessageData(MessageData messageData){
		return messageBusiness.deleteMessageData(messageData);
	}
	
	/**
	 * 查看留言详情
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public MessageData getMessageData(MessageData messageData){
		return messageBusiness.getMessageData(messageData);
	}

}
