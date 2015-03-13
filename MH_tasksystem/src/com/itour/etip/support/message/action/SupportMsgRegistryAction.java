package com.itour.etip.support.message.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.EtipMsgRegistry;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.message.facade.SupportMsgRegistryFacade;

public class SupportMsgRegistryAction extends FrmAction {

	private SupportMsgRegistryFacade supportMsgRegistryFacade;

	/**
	 * 查询用户基础信息的Action方法，带分页功能
	 * 
	 * @return
	 */
	public String getList() {
		JSONObject jsonObj = (JSONObject) getJson();

		PageRoll pageRoll = new PageRoll();
		pageRoll.setPageSize(Integer.parseInt((String) request
				.getParameter("limit")));
		pageRoll.setStartRow(Integer.parseInt((String) request
				.getParameter("start")));

		List<EtipMsgRegistry> list = supportMsgRegistryFacade.listUser(
				pageRoll, jsonObj);
		String rvJson = this.getListJsonStr(pageRoll, list);
		setJson(rvJson);
		return null;
	}

	/**
	 * 添加个人基础信息
	 * 
	 * @return
	 */
	public String addUser() {
		JSONObject jsonObj = (JSONObject) getJson();
		JSONObject tmpObject = removeJSONObjectNull(jsonObj,
				EtipMsgRegistry.class);
		String[] dateFormats = new String[] { "yyyy-MM-dd" };
		// JSONUtils.getMorpherRegistry().registerMorpher(new
		// DateMorpher(dateFormats));
		EtipMsgRegistry userTemp = (EtipMsgRegistry) JSONObject.toBean(
				tmpObject, EtipMsgRegistry.class);
		if (("1").equals(jsonObj.getString("synchronize"))) {
			userTemp.setSynchronize(true);
		} else {
			userTemp.setSynchronize(false);
		}
		supportMsgRegistryFacade.addUser(userTemp);
		String data = DateTool.getJSONString(userTemp, "yyyy-MM-dd");
		setJson("{success:true,data: " + data + " }");
		return null;
	}

	/**
	 * 删除个人基础信息，可以批量删除
	 * 
	 * @return
	 */
	public String deleteUser() {
		JSONArray idsArray = (JSONArray) getJson();
		Object[] objs = idsArray.toArray();
		String[] strArr = new String[objs.length];
		for (int i = 0; i < objs.length; i++) {
			strArr[i] = (String) objs[i];
		}
		supportMsgRegistryFacade.deleteUser(strArr);
		setJson("{success:true}");
		return null;
	}

	/**
	 * 根据id取得个体基础信息
	 * 
	 * @return
	 */
	/*
	 * public String selectOne(){ JSONObject idOBJ = (JSONObject)getJson();
	 * UserBaseTempData userBaseTemp =
	 * userBaseAdminFacade.selectUserBaseTemp(idOBJ.getString("id"));
	 * this.setJson(DateTool.getJSONString(userBaseTemp, "yyyy-MM-dd")); return
	 * null;
	 * 
	 * }
	 *//**
	 * 修改个体基础信息
	 * 
	 * @return
	 */
	public String updateUser() {
		JSONObject jsonObj = (JSONObject) getJson();
		JSONObject tmpObject = removeJSONObjectNull(jsonObj,
				EtipMsgRegistry.class);
		String[] dateFormats = new String[] { "yyyy-MM-dd" };
		// JSONUtils.getMorpherRegistry().registerMorpher(new
		// DateMorpher(dateFormats));
		EtipMsgRegistry userTemp = (EtipMsgRegistry) JSONObject.toBean(
				tmpObject, EtipMsgRegistry.class);
		if (("1").equals(jsonObj.getString("synchronize"))) {
			userTemp.setSynchronize(true);
		} else {
			userTemp.setSynchronize(false);
		}
		supportMsgRegistryFacade.updateUser(userTemp);
		String data = DateTool.getJSONString(userTemp, "yyyy-MM-dd");
		setJson("{success:true,data: " + data + " }");
		return null;
	}

	public SupportMsgRegistryFacade getSupportMsgRegistryFacade() {
		return supportMsgRegistryFacade;
	}

	public void setSupportMsgRegistryFacade(
			SupportMsgRegistryFacade supportMsgRegistryFacade) {
		this.supportMsgRegistryFacade = supportMsgRegistryFacade;
	}
}
