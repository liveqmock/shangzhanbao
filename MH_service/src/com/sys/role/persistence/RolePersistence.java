package com.sys.role.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.sys.role.data.RoleData;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    RolePersistence.java
Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
***********************************************************/
/**
 * 角色管理操作persistence层
 * @author jmj
 */
@Component("rolePersistence")
public class RolePersistence extends BasePersistence<RoleData> implements
		IRolePersistence {
	
	/**
	 * 查询权限(角色)信息(分页显示)
	 */
	@SuppressWarnings("unchecked")
	public List<RoleData> queryAllRole(PageRoll pageRoll,RoleData roleData) {
		List<RoleData> list=null;
		List<Object> objects = new ArrayList<Object>();
		StringBuffer searchSQL = new StringBuffer("FROM RoleData d WHERE 1=1");
		searchSQL.append(" and d.status=?");
		objects.add("NORMAL");
		if(roleData!=null){
			if(roleData.getRolename()!=null&&!"".equals(roleData.getRolename())){
				searchSQL.append(" and d.rolename like ?");
				objects.add("%"+roleData.getRolename()+"%");
			}
		}
		searchSQL.append("  order by createdate desc");
		String countSQL = "SELECT COUNT(*)"+searchSQL;
		if(pageRoll!=null){
			pageRoll.setCountSQL(countSQL);
			pageRoll.setSearchSQL(searchSQL.toString());
			list=search(pageRoll,objects).getList();
		}else{
			list=search(searchSQL.toString());
		}
		return list;
	}
	
	/**
	 * 查询权限(角色)信息
	 */
	public List<RoleData> queryAllRole(JSONObject jsonObj){
		StringBuffer searchSQL = new StringBuffer("FROM RoleData r WHERE 1=1 ");
		return search(searchSQL.append(getInquiresTheConditions(jsonObj)).toString());
	}
	
	/*
	 * 角色信息查询条件
	 */
	private String getInquiresTheConditions(JSONObject obj){
		StringBuffer whereSQL = new StringBuffer();
		if (obj != null && !obj.isNullObject()) {
			if(null != obj.get("userID")){//用户ID
				String userID = obj.getString("userID");
				if(userID != null && !"".equals(userID))
					whereSQL.append(" AND id in (SELECT new UserRoleCtnData(roleId) FROM UserRoleCtnData WHERE userId = '")
						.append(userID).append("')");
			}
			if(null != obj.get("roleid")){//用于根据角色id查询信息
				String roleid = obj.getString("roleid");
				if(roleid != null && !"".equals(roleid))
					whereSQL.append(" AND id = '").append(roleid).append("'");
			}
			if(null != obj.get("id")){//用于修改时查询角色是否已存在
				String roleID = obj.getString("id");
				if(roleID != null && !"".equals(roleID))
					whereSQL.append(" AND id != '").append(roleID).append("'");
			}
			if(null != obj.get("rolename")){//用于查询角色是否已存在
				String rolename = obj.getString("rolename");
				if(rolename != null && !"".equals(rolename))
					whereSQL.append(" AND  rolename= '").append(rolename).append("'");
			}
		}
		whereSQL.append(" AND status = 'NORMAL'");
		return whereSQL.toString();
	}
	
	/**
	 * @update jmj
	 * 删除权限(角色)信息
	 */
	public void deleteRole(String id) {
		StringBuffer delsql=new StringBuffer("UPDATE TB_SYS_ROLE U SET U.STATUS='DELETED' WHERE ID = '").append(id).append("'");
		executeSQL(delsql.toString());
	}
	
	/**
	 * 更新权限(角色)信息
	 */
	public void updateRole(RoleData data) {
		update(data);
	}
	
	/**
	 * 新增权限(角色)信息
	 */
	public void saveRole(RoleData data){
		add(data);
	}
	
	/**
	 * 权限配置人员信息
	 * @update:jmj
	 * @flag true 为已配置的人员,  false为未配置的人员
	 * @param roleID 权限ID
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAuthorizedUser(boolean flag, String roleID){
		List<String> list=new ArrayList<String>();
		StringBuffer querySQL = new StringBuffer("");
		querySQL.append("SELECT U.ID || ',' || U.USERNAME as idname FROM CTN_SYSUSER U WHERE U.USERNAME != LOWER('ADMIN')");
		if(roleID!=null){
			if(flag){
				querySQL.append(" AND U.ID IN(");
			}else{
				querySQL.append(" AND U.ID NOT IN(");
			}
			querySQL.append("SELECT USERROLE.USER_ID FROM TB_SYS_USERROLE USERROLE WHERE USERROLE.ROLE_ID = '")
			.append(roleID).append("')");
		}
		querySQL.append(" ORDER BY U.USERNAME").toString();
		
		JdbcDao dao = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> resultSet = dao.queryForList(querySQL.toString(), null);
		if(resultSet!=null && resultSet.size()!=0){
			for (int i = 0; i < resultSet.size(); i++) {
				ETIPResultSet user = resultSet.get(i);
				String idname=(String)user.get("IDNAME");
				if(idname!=null)
				list.add(idname);
			}
		}
		return list;
	}
	/**
	 * 角色统计
	 * @update:郭井超
	 * @date 2013-09-22
	 */
	@Override
	public int count() {
		String sql = "select count(*) RNUM from tb_sys_role t where t.status='NORMAL'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		
		ETIPResultSet rNumSet = list.get(0);
		int rNum = rNumSet.getInt("RNUM");
		return rNum;	
	}
}
