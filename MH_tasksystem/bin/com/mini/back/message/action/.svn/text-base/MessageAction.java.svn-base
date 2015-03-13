package com.mini.back.message.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.message.facade.MessageFacade;
import com.mini.message.data.MessageData;

/**
 * 〈留言表 action〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Results( {
	@Result(name = "messageList", location = "/view/pages/mini/back/message/MessageList.jsp"),
	@Result(name = "messageView", location = "/view/pages/mini/back/message/MessageView.jsp")
	})
public class MessageAction extends FrmAction{
  @Resource(name="messageFacade")
  private MessageFacade messageFacade;  //留言
  /************************************************************/
  private PageRoll pageRoll = new PageRoll();// 分页参数
  private MessageData messageData=new MessageData(); //留言实体
  private List<MessageData> list=new ArrayList<MessageData>();  //留言集合
	
	  /**
		 * 分页查询  所有
		 * @author 侯杨
		 * @date 2014-5-12
		 */
	  public String getAll(){
		  list=messageFacade.getAll(pageRoll, messageData);
		  return "messageList";
	  }
	  	/**
	 	 * 添加
	 	 * @author 侯杨
	 	 * @date 2014-5-12
	 	 */
	  public void addMessageData(){
		String userId=null;
		String username=null;
		try {
		    userId=getFrmUser().etipUserID;  //用户id
		    username=getFrmUser().etipUserLoginName;
		} catch (Exception e) {
		}
		finally{
			//登录后  用户id是不为空的，就为userid赋值，如果userid为空，就是没有用户登录
			  if(userId!=null && !"".equals(userId)){
				  messageData.setUserId(userId);
			  }
			  if(messageData.getUserName()==null && !"".equals(messageData.getUserName())){
			      messageData.setUserName(username);
			  }
			  json=messageFacade.saveMessageData(messageData);
		  }
	  }
	  /**
	   * 删除
	   * @author 侯杨
	   * @date 2014-5-12
	   */
	  public void deleteMessageData(){
		  json=messageFacade.deleteMessageData(messageData);
	  }
	  /**
	   * 查看详情
	   * @author 侯杨
	   * @date 2014-5-12
	   */
	  public String getMessageDate(){
		  messageData=messageFacade.getMessageData(messageData);  //查询详情
		  //查看详情以后就表示已查看
		  messageData.setExaminerTime(new Date());  //查看时间
		  messageData.setStatus("0");  //表示已查看
		  json=messageFacade.updateMessageData(messageData);
		  return "messageView";
	  }
	  /**
	   * 标记
	   * @author 侯杨
	   * @date 2014-5-13
	   */
	  public void signeMessage(){
		  StringBuffer  con=  new StringBuffer(messageData.getSigneContenu());   //获取页面得到标记内容
		  String newCon;   //拼接后的标记内容
		  messageData=messageFacade.getMessageData(messageData); //获取之前填写的标记内容
		  if(messageData.getSigneContenu()==null){   //如果之前的标记内容是  null。就不拼接，不是就拼接上
			  newCon=con.toString();
		  }else{
		   newCon=con.append(";"+messageData.getSigneContenu()).toString();
		  }
		  //获取标记内容的字节数
		  byte[] buff=newCon.getBytes();
		  int f=buff.length;
		  //标记内容字节数不能超过数据库字段,超过  就不做修改操作，返回0
		  if(f<4000){
			  messageData.setSigneContenu(newCon);
			  json=messageFacade.updateMessageData(messageData);
		  }else{
		  json="0";   
		  }
	  }
	  
  /**********************************************************/
  
  public MessageData getMessageData() {
		return messageData;
	}
	public void setMessageData(MessageData messageData) {
		this.messageData = messageData;
	}
	public List<MessageData> getList() {
		return list;
	}
	public void setList(List<MessageData> list) {
		this.list = list;
	}
	public PageRoll getPageRoll() {
		return pageRoll;
	}
	public void setPageRoll(PageRoll pageRoll) {
		this.pageRoll = pageRoll;
	}



}
