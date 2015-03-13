package com.mini.privilege.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.privilege.business.IPrivilegeBusiness;
import com.mini.privilege.data.PrivilegeData;
@Component("privilegeService")
public class PrivilegeService extends FrmService implements IPrivilegeService {
	@Resource(name="privilegeBusiness")
	private IPrivilegeBusiness privilegeBusiness;

	public void setPrivilegeBusiness(IPrivilegeBusiness privilegeBusiness) {
		this.privilegeBusiness = privilegeBusiness;
	}

	@Override
	public void addPrivilege(PrivilegeData data) {
		// TODO Auto-generated method stub
		privilegeBusiness.addPrivilege(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		privilegeBusiness.deletePrivilege(ids);
	}

	@Override
	public void editPrivilege(PrivilegeData data) {
		// TODO Auto-generated method stub
		privilegeBusiness.editPrivilege(data);
	}

	@Override
	public List<PrivilegeData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		// TODO Auto-generated method stub
		return privilegeBusiness.getAllPrivilegeInfo(pageRoll, json);
	}

	@Override
	public List<PrivilegeData> getPrivilegeData(JSONObject json) {
		// TODO Auto-generated method stub
		return privilegeBusiness.getPrivilegeData(json);
	}

	@Override
	public String statisticsPrivilege(JSONObject json) {
		// TODO Auto-generated method stub
		return privilegeBusiness.statisticsPrivilege(json);
	}

}
