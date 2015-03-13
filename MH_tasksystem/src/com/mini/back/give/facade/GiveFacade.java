package com.mini.back.give.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
import com.mini.give.service.IGiveService;
/**
 * 赠送权限facade层
 * 
 * @author 林海鹏
 * @see GiveFacade
 * @since
 * 
 */
@Component("giveFacade")
public class GiveFacade extends FrmFacade{
	@Resource(name="giveService")
	private IGiveService giveService;

	
	public void setGiveService(IGiveService giveService) {
		this.giveService = giveService;
	}


	public void addPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		giveService.addPrivilege(data);
	}

	
	public void deletePrivilege(String[] ids) {
		// TODO Auto-generated method stub
		giveService.deletePrivilege(ids);
	}

	
	public void editPrivilege(GiveData data) {
		// TODO Auto-generated method stub
		giveService.editPrivilege(data);
	}

	
	public List<GiveData> getAllPrivilegeInfo(PageRoll pageRoll,
			JSONObject json) {
		// TODO Auto-generated method stub
		return giveService.getAllPrivilegeInfo(pageRoll, json);
	}

	
	public List<GiveData> getPrivilegeData(JSONObject json) {
		// TODO Auto-generated method stub
		return giveService.getPrivilegeData(json);
	}
	public void delectGive(JSONObject json) {
		// TODO Auto-generated method stub
		 giveService.delectGive(json);
	}
	public List<GiveUserInfoData> getUserInfo(PageRoll pageRoll,GiveTimeData giveTimeData, GiveUserInfoData giveUserInfoData) {
		// TODO Auto-generated method stub
		return giveService.getUserInfo(pageRoll,giveTimeData,giveUserInfoData);
	}
}
