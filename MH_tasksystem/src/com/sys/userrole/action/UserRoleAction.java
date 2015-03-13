package com.sys.userrole.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmAction;
import com.sys.userrole.data.UserRoleCtnData;
import com.sys.userrole.facade.UserRoleFacade;

/**
 * 操作用户与权限关联关系action层
 * @author LiuLei
 */
@Component("userRoleAction")
public class UserRoleAction extends FrmAction {
	@Resource(name="userRoleFacade")
	private UserRoleFacade userRoleFacade;

	/**
	 * 保存新增配置的权限人员 
	 * @author：
	 * @update：jmj
	 * 2013-8-15 下午12:48:41
	 * @throws IOException
	 */
	public void saveAuthorizeUser() throws IOException{
		String roleID = request.getParameter("roleID");//权限ID
		String id = request.getParameter("ids");	//用户ID
		String[] ids = id.split(",");
		userRoleFacade.deleteAllByRole(roleID);	//删除角色_用户关联
		UserRoleCtnData data=null;
		for(int i=0,len=ids.length; i<len; i++){
			if(ids[i] != null && !"".equals(ids[i])){
				data=new UserRoleCtnData();
				data.setUserId(ids[i]);
				data.setRoleId(roleID);
				userRoleFacade.addUserRole(data);
			}
			else
				break;
		}
		json="0";
	}

}
