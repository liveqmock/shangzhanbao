package com.sys.user.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.user.data.UserData;
/********************************************************
Copyright (C), 2009-2011, GoMai.
File name:    IUserPersistence.java
Author: CuiYunYan  Version:  1.0.0  Date: 2011-6-17
***********************************************************/
/**
 * 管理员配置管理操作persistence层接口
 * @author jmj
 */
public interface IUserPersistence extends IBasePersistence<UserData> {
	/**
	 * 新增用户
	 */
	public void addUser(UserData user);
	
	/**
	 * 删除用户
	 */
	public void delete(String id);
	
	/**
	 * 编辑用户信息
	 */
	public void editUser(UserData user);

	 /**
     * 
     * 〈根据pageid 查询用户信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-6-18
     * @update
     * @param [pageid] [pageid]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public UserData getUserDataByPageId(String pageid);
    
	/**
	 * 查询用户信息(分页显示)
	 * @author：
	 * @update：jmj
	 * 2013-8-16 下午01:25:45
	 * @param pageRoll
	 * @return
	 */
	public List<UserData> getAllUserInfo(PageRoll pageRoll,UserData userData);

	/**
	 * 查询用户信息
	 */
	public List<UserData> getAllUserInfo(JSONObject obj);
	
	/**
	 * 根据权限 查询用户名称和ID
	 */
	public List<UserData> getUserIDAndName(String roleID);
	
	/**
	 * 查询小组的成员 by 小组id
	 * */
	public  List<UserData> getTeamMember(String teamID);
	
	/**
	 * 登陆验证
	 * */
	public String checkLogin(String account, String password);

	/**
	 * 获取密码
	 * */
	public String getPassWordByUserID(String account);
	
	/**
	 * 修改密码
	 * */
	public void updatePassword(String account,String newpass);

	/**
	 * 获取人员权限，不包括他们 所有共有的权限 ADMIN
	 */
	public String getUserRole(String userID);

	/**
	 * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
	 */
	public String getUserRoleName(String userID);

	
	/**
     * 
     * 使用md5加密检查用户是否匹配<br>
     * 
     * @author 文东 <br> 
     *         2014年11月28日
     * @update 
     * @param loginAccount 用户账号
     * @param passWord 用户密码
     * @return   0.用户名或密码不正确，1.登陆通过，2.无该用户，5.异常
     * @exception/throws 
     * @see  IUserPersistence#checkLoginUserMD5(String, String)
     * @since 
     */
    public String checkLoginUserMD5(String loginAccount, String passWord);
	
}
