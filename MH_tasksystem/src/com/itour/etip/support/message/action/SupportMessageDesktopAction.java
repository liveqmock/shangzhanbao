package com.itour.etip.support.message.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cas.LoginSuccessListener;
import com.itour.etip.pub.kit.jms.JMSDeskTop;
import com.itour.etip.support.message.facade.SupportMessageDesktopFacade;

public class SupportMessageDesktopAction extends FrmAction {

	private SupportMessageDesktopFacade supportMessageDesktopFacade;

	public SupportMessageDesktopFacade getSupportMessageDesktopFacade() {
		return supportMessageDesktopFacade;
	}

	public void setSupportMessageDesktopFacade(
			SupportMessageDesktopFacade supportMessageDesktopFacade) {
		this.supportMessageDesktopFacade = supportMessageDesktopFacade;
	}

	/**
	 * 分页查询最新消息，查询当前会员的最新10条消息，支持分页查询。
	 */
	public String query() {
		JSONObject jsonObj = (JSONObject) getJson();
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.parseInt(request.getParameter("start")));
		pageRoll.setPageSize(Integer.parseInt(request.getParameter("limit")));
		List<JMSDeskTop> list = new ArrayList<JMSDeskTop>();
		list = supportMessageDesktopFacade.query(pageRoll, jsonObj, FrmUser
				.getUser());
		String rvJson = this.getListJsonStr(pageRoll, list);
		setJson(rvJson);
		return null;
	}

	/**
	 * 发送消息
	 * 
	 * @return
	 */
	public String sendMsg() {
		JSONObject jsonData = (JSONObject) getJson();
		FrmUser user = FrmUser.getUser();
		jsonData.put("senderID", user.etipUserID);
		jsonData.put("senderMobile", user.etipUserMobile);
		jsonData.put("senderEmail", user.etipUserEmail);
		jsonData.put("senderName", user.chinseName);
		// var myJsonData =
		// "{'msgChannel':'3','target':'"+email.getValue()+"','msgType':'"+msgType.getValue()+"','title':'"+title.getValue()+"','content':'"+content.getValue()+"'}"
		supportMessageDesktopFacade.sendMsg(jsonData);
		// setJson(rvJson);
		return null;
	}

	public String select() {
		JSONObject jsonObject = (JSONObject) getJson();
		String id = (String) jsonObject.get("id");
		String json = supportMessageDesktopFacade.select(id);
		setJson(json);
		return null;
	}

	public String delete() {
		JSONArray jsonArray = (JSONArray) getJson();
		Object[] objs = jsonArray.toArray();
		String[] ids = new String[objs.length];
		int i = 0;
		for (Object obj : objs) {
			ids[i++] = obj.toString();
		}
		supportMessageDesktopFacade.delete(ids);
		setJson("{success:true}");
		return null;
	}

}
