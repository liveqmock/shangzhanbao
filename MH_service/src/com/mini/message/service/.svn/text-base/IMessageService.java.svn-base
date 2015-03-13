package com.mini.message.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.message.data.MessageData;
/**
 * 〈留言 service 接口类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface IMessageService extends IService{
	/**
	 * 分页查询  所有
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param pageRoll
	 * @param messageData
	 * @return
	 */
	public List<MessageData>  getAll(PageRoll pageRoll,MessageData messageData);
	/**
	 * 增加留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String saveMessageData(MessageData messageData);
	/**
	 * 修改留言
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String updateMessageData(MessageData messageData);
	/**
	 * 删除留言  假删
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public String deleteMessageData(MessageData messageData);
	
	/**
	 * 查看留言详情
	 * @author 侯杨
	 * @date 2014-5-12
	 * @param messageData
	 * @return
	 */
	public MessageData getMessageData(MessageData messageData);

}
