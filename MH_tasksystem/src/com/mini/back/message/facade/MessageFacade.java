package com.mini.back.message.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.data.MessageData;
import com.mini.message.service.IMessageService;
@Component("messageFacade")
public class MessageFacade extends FrmFacade{
	@Resource(name="messageService")
	private IMessageService messageService;  //留言
	/**
	 * 分页查询  所有
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param pageRoll
	 * @param messageData
	 * @return
	 */
	public List<MessageData>  getAll(PageRoll pageRoll,MessageData messageData){
		return messageService.getAll(pageRoll, messageData);
	}
	/**
	 * 增加留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String saveMessageData(MessageData messageData){
		return messageService.saveMessageData(messageData);
	}
	/**
	 * 修改留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String updateMessageData(MessageData messageData){
		return messageService.updateMessageData(messageData);
	}
	/**
	 * 删除留言  假删
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String deleteMessageData(MessageData messageData){
		return messageService.deleteMessageData(messageData);
	}
	
	/**
	 * 查看留言详情
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public MessageData getMessageData(MessageData messageData){
		return messageService.getMessageData(messageData);
	}


}
