package com.itour.etip.support.generaldic.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;

import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.data.GeneralDicData;
import com.itour.etip.support.generaldic.facade.GeneralDicAdminFacade;

public class GeneralDicAdminAction extends FrmAction {
	private GeneralDicAdminFacade generalDicAdminFacade;

	public GeneralDicAdminFacade getGeneralDicAdminFacade() {
		return generalDicAdminFacade;
	}

	public void setGeneralDicAdminFacade(
			GeneralDicAdminFacade generalDicAdminFacade) {
		this.generalDicAdminFacade = generalDicAdminFacade;
	}

	/**
	 * 添加权限信息
	 * 
	 * @return
	
	 */
	public String addDic() {
		Object json = getJson();
		JSONObject jobj = (JSONObject) json;
		GeneralDicData sr = (GeneralDicData) jobj.toBean(jobj,
				GeneralDicData.class);
		GeneralDicData srs = generalDicAdminFacade.addService(sr);
		JSONObject obj = JSONObject.fromObject(srs);
		obj.put("uiProvider", "col");
		obj.put("leaf", "true");
		setJson("{success:true,data:" + obj.toString() + "}");
		return null;
	}

	/**
	 * 根据id取得权限信息
	 * 
	 * @return
	
	 */
	public String selectDic() {
		return null;

	}

	/**
	 * 修改权限信息
	 * 
	 * @return
	
	 */
	public String updateDic() {
		JSONObject jsonObj = (JSONObject) getJson();
		GeneralDicData sr = (GeneralDicData) jsonObj.toBean(jsonObj,
				GeneralDicData.class);
		GeneralDicData srd = generalDicAdminFacade.updateService(sr);
		JSONObject obj = JSONObject.fromObject(srd);
		obj.put("uiProvider", "col");
		obj.put("leaf", "true");
		setJson("{success:true,data:" + obj.toString() + "}");
		return null;
	}

	/**
	 * 删除权限信息
	 * 
	 * @return
	
	 */
	public String deleteDic() {
		JSONArray idListOBJ = (JSONArray) getJson();
		String[] serviceCodes = new String[idListOBJ.size()];
		for (int i = 0; i < idListOBJ.size(); i++) {
			serviceCodes[i] = idListOBJ.getString(i);
		}
		generalDicAdminFacade.deleteService(serviceCodes);
		setJson("{success:true}");
		return null;

	}

	public String getDicTree() {
		Object obj = getJson();
		JSONObject jobj = (JSONObject) obj;
		// 此处jobj==null时，需要特殊处理
		String id = request.getParameter("id");
		GeneralDicData srd = (GeneralDicData) JSONObject.toBean(jobj,
				GeneralDicData.class);
		List list = generalDicAdminFacade.getServiceTree(srd, id);
		JSONArray array = DateTool.getJSONArray(list, "yyyy-MM-dd");
		setJson(array.toString());
		return null;
	}
}
