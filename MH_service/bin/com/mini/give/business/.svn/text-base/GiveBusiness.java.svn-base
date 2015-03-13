package com.mini.give.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
import com.mini.give.persistence.IGivePersistence;
/**
 * 赠送权限业务接口实现类
 * 
 * @author 林海鹏
 * @see GiveBusiness
 * @since
 */
@Component("giveBusiness")
public class GiveBusiness extends FrmBusiness implements
		IGiveBusiness {
	@Resource(name="givePersistence")
	private IGivePersistence givePersistence;

	public void setGivePersistence(IGivePersistence givePersistence) {
		this.givePersistence = givePersistence;
	}

	@Override
	public void addPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		givePersistence.add(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		givePersistence.deletePrivilege(ids);
	}

	@Override
	public void editPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		givePersistence.editPrivilege(data);
	}

	@Override
	public List<GiveData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		// TODO Auto-generated method stub
		return givePersistence.getAllPrivilegeInfo(pageRoll, json);
	}

	@Override
	public List<GiveData> getPrivilegeData(JSONObject json) {
		// TODO Auto-generated method stub
		return givePersistence.getPrivilegeData(json);
	}

	@Override
	public void delectGive(JSONObject json) {
		// TODO Auto-generated method stub
		givePersistence.delectGive(json);
	}

	@Override
	public List<GiveUserInfoData> getUserInfo(PageRoll pageRoll,GiveTimeData giveTimeData, GiveUserInfoData giveUserInfoData) {
		// TODO Auto-generated method stub
		return givePersistence.getUserInfo(pageRoll,giveTimeData,giveUserInfoData);
	}
}
