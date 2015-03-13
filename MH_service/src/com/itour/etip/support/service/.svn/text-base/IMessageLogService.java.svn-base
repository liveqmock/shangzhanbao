package com.itour.etip.support.service;

import java.util.List;

import javax.jws.WebMethod;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.JMSLog;

public interface IMessageLogService {
	@WebMethod
	/**
	 * 日志信息查询
	 * 
	 * @param String,limit,query
	 * @return PageModel
	 * 
	 */
	public List<JMSLog> getLogs(PageRoll pageRoll,JSONObject condition);

	/**
	 * 日志信息浏览
	 * 
	 * @param id
	 * @return JMSLog
	 * 
	 */
	public JMSLog select(String id);

	/**
	 * 日志信息清除
	 * 
	 * @param id
	 * @return boolean
	 * 
	 */
	public void delete(String[] id);

}
