package com.mini.give.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.give.business.IGiveBusiness;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
/**
 * 赠送权限服务接口实现类
 * 
 * @author 林海鹏
 * @see GiveService
 * @since
 */
@Component("giveService")
public class GiveService extends FrmService implements IGiveService {
	@Resource(name="giveBusiness")
	private IGiveBusiness giveBusiness;

	public void setGiveBusiness(IGiveBusiness giveBusiness) {
		this.giveBusiness = giveBusiness;
	}

	@Override
	public void addPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		giveBusiness.addPrivilege(data);
	}

	@Override
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		giveBusiness.deletePrivilege(ids);
	}

	@Override
	public void editPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		giveBusiness.editPrivilege(data);
	}

	@Override
	public List<GiveData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		pageRoll=PageRoll.set(Page.SIZE_5, pageRoll);
		return giveBusiness.getAllPrivilegeInfo(pageRoll, json);
	}

	@Override
	public List<GiveData> getPrivilegeData(JSONObject json) {
		// TODO Auto-generated method stub
		return giveBusiness.getPrivilegeData(json);
	}

	@Override
	public void delectGive(JSONObject json) {
		// TODO Auto-generated method stub
		giveBusiness.delectGive(json);
	}

	@Override
	public List<GiveUserInfoData> getUserInfo(PageRoll pageRoll,GiveTimeData giveTimeData, GiveUserInfoData giveUserInfoData) {
		pageRoll=PageRoll.set(Page.SIZE_5, pageRoll);
		return giveBusiness.getUserInfo(pageRoll,giveTimeData,giveUserInfoData);
	}
}
