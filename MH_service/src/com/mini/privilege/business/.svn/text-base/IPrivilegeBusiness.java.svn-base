package com.mini.privilege.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.privilege.data.PrivilegeData;

public interface IPrivilegeBusiness extends IBusiness{
	 /**
    * 新增权限
    */
   public void addPrivilege(PrivilegeData data);
   /**
    * 删除权限
    */
   public void deletePrivilege(String[] ids);
   /**
    * 编辑权限信息
    */
   public void editPrivilege(PrivilegeData data);
   /**
    * 根据条件获取对象信息
    */
   public List<PrivilegeData> getPrivilegeData(JSONObject json);
   
   /**
    * 查询权限(分页显示)
    */
   public List<PrivilegeData> getAllPrivilegeInfo(PageRoll pageRoll, JSONObject json);
   
   /**
    * 统计各种权限数量
    */
   public String statisticsPrivilege(JSONObject json);
}
