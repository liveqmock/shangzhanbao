package com.itour.etip.support.roleregistry.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;

import com.itour.etip.support.data.RoleRegistryData;
import com.itour.etip.support.roleregistry.facade.RoleRegistryAdminFacade;


public class RoleRegistryAdminAction extends FrmAction{
	
	private RoleRegistryAdminFacade roleRegistryAdminFacade;

	public RoleRegistryAdminFacade getRoleRegistryAdminFacade() {
		return roleRegistryAdminFacade;
	}

	public void setRoleRegistryAdminFacade(
			RoleRegistryAdminFacade roleRegistryAdminFacade) {
		this.roleRegistryAdminFacade = roleRegistryAdminFacade;
	}

	
	/**
	 * 查询角色信息
	 * @return
	
	 */
	public String listRole(){
		
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setPageSize(Integer.valueOf(limit));
		Object obj = getJson();
		
		JSONObject jobj = (JSONObject)obj;
		
		RoleRegistryData rrd = (RoleRegistryData)JSONObject.toBean(jobj, RoleRegistryData.class);
		
		List list = roleRegistryAdminFacade.getRoleList(pageRoll, rrd);
	
		JSONArray jsonArray = JSONArray.fromObject(list);
		StringBuffer sb = new StringBuffer();
		sb.append("{'items':");
		sb.append(jsonArray.toString());
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");
		setJson(sb.toString());
		
		return null;
	}
	
	/**
	 * 查询系统已存在权限信息
	 * @return
	
	 */
	public String listSystemService(){
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		PageRoll pageRoll = new PageRoll();
		pageRoll.setStartRow(Integer.valueOf(start));
		pageRoll.setPageSize(Integer.valueOf(limit));
		Object obj = getJson();
		List list = roleRegistryAdminFacade.getSystemServiceList(pageRoll, null);
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		StringBuffer sb = new StringBuffer();
		sb.append("{'items':");
		sb.append(jsonArray.toString());
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");
		setJson(sb.toString());
		System.err.println(sb.toString());
		return null;
	
	}

 
	/**
	 * 添加角色信息
	 * @return
	
	 */
	public String addRole(){
		
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;		
		JSONObject obj1 = jsonObject.getJSONObject("formValue");		
		JSONArray jsonArray = (JSONArray)jsonObject.get("treeValue");		
		RoleRegistryData rr = (RoleRegistryData)JSONObject.toBean(obj1, RoleRegistryData.class);
		String[] serviceCode = new String[jsonArray.size()]; 
		for(int i=0;i<jsonArray.size();i++){
			serviceCode[i] = jsonArray.getString(i);
		}
		roleRegistryAdminFacade.addRole(rr,serviceCode);
		setJson("{success:true}");
		return null;
	}
	
	
	/**
	 * 根据id取得角色信息
	 * @return 
	
	 */
	public String getRole(){
		
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;
		String id = jsonObject.getString("id");
		Map map = roleRegistryAdminFacade.getRole(id);
		RoleRegistryData rrd = (RoleRegistryData)map.get("role");
		List list = (List)map.get("services");
		
		JSONObject jsonRole = JSONObject.fromObject(rrd);
		JSONArray services = JSONArray.fromObject(list);
		JSONObject jsonServices = new JSONObject();
		jsonServices.put("results", services.size());
		jsonServices.put("items", services);
		
		JSONObject jobj = new JSONObject();
		jobj.put("success", "true");
		jobj.put("formValue", jsonRole);
		jobj.put("gridValue", jsonServices);
		System.out.println("#####################################33");
		System.out.println(jobj.toString());
		setJson(jobj.toString());
		
//		List<ServiceRegistryData> sList = role.getServiceRegistry(); 		
//		JSONArray jsonServices = JSONArray.fromObject(sList);		
//		JSONObject jsonRole = JSONObject.fromObject(role);
		//System.out.println(jsonServices.size());
//		setJson("{success:true,formValue:"+jsonRole.toString()+",gridValue:{results:"+jsonServices.size()+",items:"+jsonServices.toString()+"}}");
		
		return null;
	}

	/**
	 * 修改角色信息
	 * @return 
	
	 */
	public String updateRole(){
		
		Object obj = getJson();
		JSONObject jsonObject = (JSONObject)obj;
		JSONObject obj1 = jsonObject.getJSONObject("formValue");
		JSONArray jsonArray = (JSONArray)jsonObject.get("treeValue");
		//System.out.println(obj1.toString());
		//System.out.println(jsonArray.toString());
		RoleRegistryData rr = (RoleRegistryData)JSONObject.toBean(obj1, RoleRegistryData.class);
		String[] serviceCode = new String[jsonArray.size()]; 
		for(int i=0;i<jsonArray.size();i++){
			serviceCode[i] = jsonArray.getString(i);
		}
		roleRegistryAdminFacade.updateRole(rr,serviceCode);
		setJson("{success:true}");
		return null;
	}
	
	
	
	/**
	 * 删除角色信息
	 * @return 
	
	 */
	public String deleteRole(){
		Object obj = getJson();		
		JSONArray array = (JSONArray)obj;	
		String[] ids = new String[array.size()];
		for(int i=0;i<ids.length;i++){
			ids[i] = array.getString(i);
		}
		roleRegistryAdminFacade.deleteRole(ids);
		setJson("{success:true}");
		return null;
	}
	

	
}
