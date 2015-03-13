package com.sys.role.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;
import com.sys.resources.data.RoleResData;
import com.sys.role.data.RoleData;
import com.sys.role.facade.RoleFacade;
import com.sys.userrole.data.AuthorityData;
@ResultPath("/")
@Results( {
		
		//跳转到角色信息列表页面
		@Result(name="toRoleList",location="/view/pages/sys/role/ctn/roleList.jsp"),
		//跳转到角色修改页面
		@Result( name = "editPage", location = "/view/pages/sys/role/ctn/roleEdit.jsp"),
		//删除成功并跳转到查询列表方法
		@Result(name="deleteSuccess",type="redirectAction",location="role/key/queryAllRolesInfo"),
		//查看角色详细信息
		@Result( name = "viewRoleInfo", location = "/view/pages/sys/role/ctn/roleView.jsp"),
		//查看角色详细信息
		@Result( name = "getAuthorityList", location = "/view/pages/sys/role/ctn/authorityList.jsp"),
		//增加角色信息页面
		@Result( name = "addRole", location = "/view/pages/sys/role/ctn/roleAdd.jsp")
		
	})
/**
 * 角色管理操作action层
 * @author jmj	
 */
@Component("roleAction")	
public class RoleAction extends FrmAction {
	/****************************************************/
	@Resource(name="roleFacade")
	private RoleFacade roleFacade;
	/****************************************************/
	private RoleData roleData=new RoleData();
	private PageRoll pageRoll=new PageRoll();
	private AuthorityData authorityData = new AuthorityData();
	private List<ResourceData> parentResourceList = new ArrayList<ResourceData>();
	private List<ResourceData> sonResourceList = new ArrayList<ResourceData>();
	private List<RoleResData> roleResDatasList = new ArrayList<RoleResData>();
	/****************************************************/
	
	/**
	 * 跳转到增加角色页面
	 * 2013-10-11 上午11:46:23
	 * @author jmj
	 */
	public String intoAddRole(){
		//查询资源信息
		parentResourceList = roleFacade.getResource("parent");
		sonResourceList = roleFacade.getResource("son");
		return "addRole";
	}
	
	/**
	 * 查询权限，进入修改权限(角色)页面
	 */
	public String intoRoleEditPage(){
		String roleID = request.getParameter("id");
		//查询该角色的资源
		List<RoleResData> roleResList = roleFacade.getRoleResById(roleID);
		//查询所有资源信息
		parentResourceList = roleFacade.getResource("parent");
		sonResourceList = roleFacade.getResource("son");
		
		String json = "{\"roleid\":\""+ roleID +"\"}";
		List<RoleData> list = roleFacade.queryAllRole(JSONObject.fromObject(json));
		if(list.size() > 0)
			roleData = list.get(0);
		request.setAttribute("roleResList",roleResList);
		return "editPage";
	}
	/**
	 * 查询角色信息并分页显示
	 * @author：jmj
	 * @update：
	 * 2013-8-15 上午09:32:12
	 * @return
	 */
	public String queryAllRolesInfo(){
		
		List<RoleData> rolelist = roleFacade.queryAllRole(pageRoll,roleData);
		request.setAttribute("rolelist",rolelist);
		return "toRoleList";
	}
	/**
	 * 删除权限(角色)
	 * @author：
	 * @update：jmj  
	 * 2013-8-15 上午10:11:17
	 * @throws Exception
	 */
	public String deleteRole() throws Exception{
		String id = request.getParameter("id");
		String ids[]=id.split(",");
		for (int i = 0; i < ids.length; i++) {
			roleFacade.deleteRole(ids[i]);
		}
		return "deleteSuccess";
	}
	/**
	 * 保存修改角色信息
	 * @author：
	 * @update：jmj
	 * 2013-8-15 上午10:03:41
	 * @throws Exception
	 */
	public void updateRole() throws Exception{
		//删除原角色的角色权限信息
		roleFacade.deleteRoleResByRoleId(roleData.getId());
		//遍历资源信息
		for (int i = 0; i < roleResDatasList.size(); i++) {
			RoleResData roleResData = roleResDatasList.get(i);
			roleResData.setRoleId(roleData.getId());
			roleFacade.addRoleRes(roleResData);//增加新的角色权限信息
		}
		if(roleData != null){
			roleFacade.updateRole(roleData);
			json=roleData.getId();
		}else{
			json="1";
		}
	}
	/**
	 * 查看角色详细信息
	 */
	public String viewRoleInfo(){
		String id = request.getParameter("id");
		//查询该角色的资源
		List<RoleResData> oneRoleResList = roleFacade.getRoleResById(id);
		//查询所有资源
		Map<String,String> map = roleFacade.getResoureMap();
		String json = "{\"roleid\":\""+ id +"\"}";
		List<RoleData> list = roleFacade.queryAllRole(JSONObject.fromObject(json));
		if(list.size() > 0)
			roleData = list.get(0);
		request.setAttribute("oneRoleResList", oneRoleResList);
		request.setAttribute("map",map);
		return "viewRoleInfo";
	}
	/**
	 * 新增角色信息
	 * @author：
	 * @update：jmj
	 * 2013-8-15 上午11:14:04
	 * @throws Exception
	 */
	public void saveRole() throws Exception{
		
		if(roleData != null){
			roleData.setCreator(FrmUser.getUser().userBaseID);
			roleData.setCreatedate(new Date());
			roleFacade.saveRole(roleData);
			
			//遍历资源信息
			for (int i = 0; i < roleResDatasList.size(); i++) {
				RoleResData roleResData = roleResDatasList.get(i);
				roleResData.setRoleId(roleData.getId());
				roleFacade.addRoleRes(roleResData);
			}
			
			json=roleData.getId();
		}else{
			json="0";
		}
	}
	/**
	 * 权限未配置人员信息
	 */
	public void getUnauthorizedUser() throws Exception{
		String roleID = request.getParameter("roleID");//权限ID
		List<String> list = roleFacade.getAuthorizedUser(false, roleID);
		response.getWriter().write(getUserAndIDJSON(list));
	}
	/*
	 * 拼接用户ID，用户姓名 JSON串
	 */
	private String getUserAndIDJSON(List<String> list){
		StringBuffer json = new StringBuffer("{\"userInfo\":[");
		String[] temp;
		for(int i=0,size=list.size(); i<size; i++){
			temp = list.get(i).split(",");
			json.append("{\"id\":\"").append(temp[0]).append("\",\"name\":\"").append(temp[1]).append("\"}");
			json.append(i<size-1?",":"");
		}
		json.append("]}");
		return json.toString();
	}
	/**
	 * 权限已配置人员信息
	 */
	public void getAuthorizedUser() throws Exception{
		String roleID = request.getParameter("roleID");//权限ID
		List<String> list = roleFacade.getAuthorizedUser(true, roleID);
		response.getWriter().write(getUserAndIDJSON(list));
	}
	/**
	 * 检查角色名称是否重复
	 * @author：jmj
	 * @update：
	 * 2013-8-21 下午04:09:24
	 * @throws IOException
	 */
	public void ajaxCheckRoleName() throws IOException{
		String json = request.getParameter("json");
		JSONObject obj = JSONObject.fromObject(json);
		List<RoleData> list = roleFacade.queryAllRole(obj);
		response.getWriter().print(list.size());
	}
	
	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 * @return
	 */
	public String getAuthorityList(){
		List<AuthorityData> authorityDatas = roleFacade.getAuthorityList(pageRoll,authorityData);
		request.setAttribute("authorityDatas", authorityDatas);
		return "getAuthorityList";
	}
	
	/**
	 * @author 何大勇
	 * @date 2013-9-23
	 * @update
	 */
	public void ajaxAddAuthority(){
		roleFacade.addAuthority(authorityData);
	}
	
	
	
	
	
	
	
	
	/************************************************************/
	public PageRoll getPageRoll() {
		return pageRoll;
	}

	public void setPageRoll(PageRoll pageRoll) {
		this.pageRoll = pageRoll;
	}

	public void setRoleData(RoleData roleData) {
		this.roleData = roleData;
	}

	public RoleData getRoleData() {
		return roleData;
	}
	public AuthorityData getAuthorityData() {
		return authorityData;
	}
	public void setAuthorityData(AuthorityData authorityData) {
		this.authorityData = authorityData;
	}

	public List<ResourceData> getParentResourceList() {
		return parentResourceList;
	}

	public void setParentResourceList(List<ResourceData> parentResourceList) {
		this.parentResourceList = parentResourceList;
	}

	public List<ResourceData> getSonResourceList() {
		return sonResourceList;
	}

	public void setSonResourceList(List<ResourceData> sonResourceList) {
		this.sonResourceList = sonResourceList;
	}

	public List<RoleResData> getRoleResDatasList() {
		return roleResDatasList;
	}

	public void setRoleResDatasList(List<RoleResData> roleResDatasList) {
		this.roleResDatasList = roleResDatasList;
	}
	
}
