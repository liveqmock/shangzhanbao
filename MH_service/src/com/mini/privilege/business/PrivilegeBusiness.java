package com.mini.privilege.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.privilege.data.PrivilegeData;
import com.mini.privilege.persistence.IPrivilegePersistence;
@Component("privilegeBusiness")
public class PrivilegeBusiness extends FrmBusiness implements
		IPrivilegeBusiness {
	@Resource(name="privilegePersistence")
	private IPrivilegePersistence privilegePersistence;
	
	public void setPrivilegePersistence(IPrivilegePersistence privilegePersistence) {
		this.privilegePersistence = privilegePersistence;
	}

	@Override
	public void addPrivilege(PrivilegeData data) {
		// TODO Auto-generated method stub
		privilegePersistence.add(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		privilegePersistence.deletePrivilege(ids);
	}

	@Override
	public void editPrivilege(PrivilegeData data) {
		// TODO Auto-generated method stub
		privilegePersistence.editPrivilege(data);
	}

	@Override
	public List<PrivilegeData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		// TODO Auto-generated method stub
		return privilegePersistence.getAllPrivilegeInfo(pageRoll, json);
	}

	@Override
	public List<PrivilegeData> getPrivilegeData(JSONObject json) {
		// TODO Auto-generated method stub
		return privilegePersistence.getPrivilegeData(json);
	}

	@Override
	public String statisticsPrivilege(JSONObject json) {
		// TODO Auto-generated method stub
		return privilegePersistence.statisticsPrivilege(json);
	}

}
