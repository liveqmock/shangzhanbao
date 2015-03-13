package com.sys.org.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.sys.org.data.OrgData;
import com.sys.org.facade.OrgFacade;
import com.sys.role.data.RoleData;
import com.sys.role.facade.RoleFacade;

/**
 * 系统机构
 * @author LiuLei
 */
@ResultPath("/")
@Results({
	
	@Result(name="addOrgPage", location="/view/pages/sys/org/orgAdd.jsp"),
	@Result(name="editOrgPage", location="/view/pages/sys/org/orgEdit.jsp"),
	
	@Result(name="viewOrgInfo", location="/view/pages/sys/org/ctn/orgView.jsp")
	
})
@Component("orgAction")
public class OrgAction extends FrmAction {
	@Resource(name="orgFacade")
	private OrgFacade orgFacade;
	private OrgData orgData;
	@Resource(name="roleFacade")
	private RoleFacade roleFacade;
	private List<RoleData> roleList;	//权限列表
	

	
	
	
	/**
	 * 查看机构信息
	 */
	public void getOrgInfo() throws Exception{
		String orgID = request.getParameter("orgID");
		String json = "{\"orgID\":\""+ orgID +"\"}";
		List<OrgData> list = orgFacade.queryOrgList(JSONObject.fromObject(json));//机构信息
		if(list.size() > 0)
			response.getWriter().write(this.getChildOrgRoot(list));
	}
	
	/**
	 * 查询机构信息、权限信息，进入新增机构页面
	 */
	public String intoAddOrgPage(){
		String orgID = request.getParameter("orgID");
		String json = "{\"orgID\":\""+ orgID +"\"}";
		List<OrgData> list = orgFacade.queryOrgList(JSONObject.fromObject(json));//机构信息
		if(list.size() > 0)
			orgData = list.get(0);
		roleList = roleFacade.queryAllRole();
		return "addOrgPage";
	}
	
	/**
	 * 查询机构信息、权限信息，进入修改机构页面
	 */
	public String intoEditOrgPage(){
		String orgID = request.getParameter("orgID");
		String json = "{\"orgID\":\""+ orgID +"\"}";
		List<OrgData> list = orgFacade.queryOrgList(JSONObject.fromObject(json));//机构信息
		if(list.size() > 0)
			orgData = list.get(0);
		roleList = roleFacade.queryAllRole();
		return "editOrgPage";
	}
	
	/**
	 * 保存机构信息 
	 */
	public void saveOrgInfo() throws Exception{
		if(orgData != null){
			orgData.setCreator(FrmUser.getUser().userBaseID);
			orgData.setCreatetime(new Date());
			orgFacade.addOrg(orgData);
			String msg = "{\"id\":\""+ orgData.getId() +"\",\"msg\":\"添加成功!\"}";
			response.getWriter().write(msg);
		}else{
			String msg = "{\"id\":\"1\",\"msg\":\"添加失败!\"}";
			response.getWriter().write(msg);
		}
	}
	
	/**
	 * 修改机构信息
	 */
	public void updateOrgInfo() throws Exception{
		if(orgData != null){
			orgFacade.editOrg(orgData);
			String msg = "{\"id\":\""+ orgData.getId() +"\",\"msg\":\"修改成功!\"}";
			response.getWriter().write(msg);
		}else{
			String msg = "{\"id\":\"1\",\"msg\":\"修改失败!\"}";
			response.getWriter().write(msg);
		}
	}
	
	/**
	 * 删除机构
	 */
	public void deleteOrg() throws Exception{
		String orgID = request.getParameter("orgID");
		orgFacade.deleteOrg(orgID);
		response.getWriter().write("删除成功!");
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 获取机构树
	 */
	public void getOrgTree() throws Exception{
		List<OrgData> list = orgFacade.queryOrgList();
		String root = null;
		OrgData data = null;
		for(int i=0,size=list.size(); i<size; i++){
			data = list.get(i);
			String parentID = data.getParentid();
			if(parentID == null || "".equals(parentID)){
				root = getOrgInfoRoot(data.getId(), data.getOrgname_cn());
			}
		}
		response.getWriter().write(root);
	}
	/*
	 * 拼接--机构树--所需要的 JSON字符串 
	 */
	private String getOrgInfoRoot(String id, String orgName_cn){	
		StringBuffer rootJson = new StringBuffer("[");
		rootJson.append("{\"id\":\"").append(id).append("\",\"text\":\"")
			.append(orgName_cn).append("\",\"state\":\"closed\"}")
			.append("]");
		return rootJson.toString();
	}
	/**
	 * 查看机构信息
	 */
	public String viewOrgInfo(){
		String orgID = request.getParameter("orgID");
		String json = "{\"orgID\":\""+ orgID +"\"}";
		List<OrgData> list = orgFacade.queryOrgList(JSONObject.fromObject(json));//机构信息
		if(list.size() > 0)
			orgData = list.get(0);
		return "viewOrgInfo";
	}
	/**
	 * 查询 --子机构--
	 */
	public void getOrgChild() throws Exception{
		String orgID = request.getParameter("orgID");
		String json = "{\"parentID\":\""+ orgID +"\"}";
		List<OrgData> list = orgFacade.queryOrgList(JSONObject.fromObject(json));
		String root = getChildOrgRoot(list);
		response.getWriter().write(root);
	}
	/*
	 * 拼接--机构树(子机构)--所需要的 JSON字符串 	
	 */
	private String getChildOrgRoot(List<OrgData> list){	
		StringBuffer rootJson = new StringBuffer("[");
		OrgData data;
		String orgName_cn, id, json;
		for(int i=0,size=list.size(); i<size; i++){
			data = list.get(i);
			id = data.getId();	//机构ID 
			orgName_cn = data.getOrgnamedefault(); //getOrgname_cn(); 使用默认机构名称
			//查询当前机构 子机构
			json = "{\"parentID\":\""+ id +"\"}";
			List<OrgData> orgs = orgFacade.queryOrgList(JSONObject.fromObject(json));
			if(orgs.size() > 0){
				rootJson.append("{\"id\":\"").append(id).append("\",\"text\":\"")
				.append(orgName_cn).append("\",\"state\":\"closed\"},");
			}else{
				rootJson.append("{\"id\":\"").append(id).append("\",\"text\":\"")
				.append(orgName_cn).append("\"},");
			}
		}
		return rootJson.delete(rootJson.length()-1, rootJson.length()).append("]").toString();
	}

	
	
	
	
	
	

	public OrgData getOrgData() {
		return orgData;
	}

	public void setOrgData(OrgData orgData) {
		this.orgData = orgData;
	}

	public List<RoleData> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleData> roleList) {
		this.roleList = roleList;
	}
}
