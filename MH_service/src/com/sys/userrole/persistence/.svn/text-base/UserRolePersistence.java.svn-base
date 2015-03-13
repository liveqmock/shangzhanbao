package com.sys.userrole.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.BasePersistence;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 操作用户与权限关联关系
 * @author LiuLei
 */
@Component("userRoleCtnPersistence")
public class UserRolePersistence extends BasePersistence<UserRoleCtnData> implements
		IUserRolePersistence {

	/**
	 * 添加用户And权限关联
	 * @author jmj
	 */
	public void addUserRole(UserRoleCtnData data){
		this.add(data);
	}
	
	/**
	 * 删除用户——角色关联
	 * @author：jmj
	 * 2013-8-20 下午05:52:52
	 */
	public void deleteUserRole(String roleId, String userId){
		StringBuffer sql = new StringBuffer();
		//不删除ADMIN管理员权限
		sql.append("DELETE FROM TB_SYS_USERROLE USERROLE WHERE USERROLE.USER_ID IN(")
			.append("SELECT U.ID FROM CTN_SYSUSER U WHERE U.USERNAME != LOWER('ADMIN'))");
		if(roleId != null){
			sql.append(" AND ROLE_ID = '").append(roleId).append("'");
		}
		if(userId != null){
			sql.append(" AND USER_ID = '").append(userId).append("'");
		}
		executeSQL(sql.toString());
	}
	
	/**
	 * 查询角色基本信息ID
	 * @update: jmj 
	 * sql语句查询改为hql语句查询
	 * 添加非空判断
	 */
	@SuppressWarnings("unchecked")
	public List<String> getUserRoleList(JSONObject jsonObj){
		List<String> list=new ArrayList<String>();
		StringBuffer querySQL = new StringBuffer();
		querySQL.append("from UserRoleCtnData t where 1=1 ");
		querySQL.append(getInquiresTheConditions(jsonObj));
		List<UserRoleCtnData> userrolelist=search(querySQL.toString());
		if(userrolelist.size()>0){
			for (int i = 0; i < userrolelist.size(); i++) {
				UserRoleCtnData data=userrolelist.get(i);
				if(data!=null){
					list.add(data.getRoleId());
				}
			}
		}
		return list;
	}
	
	/**
	 * 角色查询条件拼接
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:52:52
	 * @param obj
	 * @return
	 */
	private String getInquiresTheConditions(JSONObject obj){
		StringBuffer whereSQL = new StringBuffer();
		if (obj != null && !obj.isNullObject()) {
			if(null != obj.get("userID")){
				String userID = obj.getString("userID");
				if(userID != null && !"".equals(userID))
					whereSQL.append(" and t.userId = '").append(userID).append("'");
			}
		}
		return whereSQL.toString();
	}
	/**
	 * 根据用户id查询角色信息
	 * @author：jmj
	 * @update：
	 * 2013-8-20 下午05:52:52
	 * @param obj
	 * @return
	 */
	public List<UserRoleCtnData> getUserRolesByUserId(String userId){
		String hql =  "from UserRoleCtnData where userId = ?";
		return search(hql, new Object[]{userId});
	}
}
