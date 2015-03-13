package com.mini.give.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
/**
 * 赠送权限服务接口
 * 
 * @author 林海鹏
 * @see IGiveService
 * @since
 */
public interface IGiveService extends IService{
	 /**
	    * 新增权限
	    */
	   public void addPrivilege(GiveData data);
	   /**
	    * 删除权限
	    */
	   public void deletePrivilege(String[] ids);
	   /**
	    * 编辑权限信息
	    */
	   public void editPrivilege(GiveData data);
	   /**
	    * 根据条件获取对象信息
	    */
	   public List<GiveData> getPrivilegeData(JSONObject json);
	   
	   /**
	    * 查询权限(分页显示)
	    */
	   public List<GiveData> getAllPrivilegeInfo(PageRoll pageRoll, JSONObject json);
	    /**
	     * 赠送目标客户(分页显示)
	     * 
	     */
	    public List<GiveUserInfoData> getUserInfo(PageRoll pageRoll,GiveTimeData giveTimeData, GiveUserInfoData giveUserInfoData) ;
	   /**
	    * 此方法仅用于赠送权限的删除
	    */
	   public void delectGive(JSONObject json);
}
