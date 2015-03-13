package com.itour.etip.support.service;

import java.util.List;

import javax.jws.WebMethod;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSDeskTop;

public interface IMessageDesktopService {
	@WebMethod
	/**
	 * 日志信息查询
	 * 
	 * @param String,limit,query
	 * @return PageModel
	 * 
	 */
	public List<JMSDeskTop> query(PageRoll pageRoll, JSONObject jsonObject,FrmUser user);
	
	public void sendMsg(JSONObject jsonData);

	/**
	 * 日志信息浏览
	 * 
	 * @param id
	 * @return JMSDesktop
	 * 
	 */
	public JMSDeskTop select(String id);

	/**
	 * 日志信息清除
	 * 
	 * @param id
	 * @return boolean
	 * 
	 */
	public void delete(String[] id);

}
