package com.sys.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.user.business.IUserBusiness;
import com.sys.user.data.UserData;

/********************************************************
 * Copyright (C), 2009-2011, GoMai. File name: UserService.java
 * Author: CuiYunYan LiuLei Version: 1.0.0 Date: 2011-6-17
 ***********************************************************/
/**
 * 管理员配置管理操作Service层实现类
 * 
 * @author jmj
 */
@Component("userSysService")
public class UserService extends FrmService implements IUserService {
    @Resource(name = "userBusiness")
    private IUserBusiness userBusiness;

    /**
     * 新增用户
     */
    public void addUser(UserData userData) {
        userBusiness.addUser(userData);
    }

    /**
     * 删除用户
     */
    public void delete(String id) {
        userBusiness.delete(id);
    }

    /**
     * 编辑用户信息
     */
    public void editUser(UserData user, String id, String name, String email) {
        userBusiness.editUser(user, id, name, email);
    }

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
    public UserData getUserDataByPageId(String pageid) {
        return userBusiness.getUserDataByPageId(pageid);
    }

    /**
     * 查询用户信息(分页显示)
     */
    public List<UserData> getAllUserInfo(PageRoll pageRoll, UserData userData) {
        pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
        return userBusiness.getAllUserInfo(pageRoll, userData);
    }

    /**
     * 查询用户信息
     */
    public List<UserData> getAllUserInfo(JSONObject obj) {
        return userBusiness.getAllUserInfo(obj);
    }

    /**
     * 根据权限 查询用户名称和ID
     */
    public List<UserData> getUserIDAndName(String roleID) {
        return userBusiness.getUserIDAndName(roleID);
    }

    /**
     * 查询小组的成员 by 小组id
     * */
    public List<UserData> getTeamMember(String teamID) {
        return userBusiness.getTeamMember(teamID);
    }

    /**
     * 登陆验证
     * */
    public String checkLogin(String account, String password) {
        return userBusiness.checkLogin(account, password);
    }

    /**
     * 获取密码
     */
    public String getPassWordByUserID(String account) {
        return userBusiness.getPassWordByUserID(account);
    }

    @Override
    public String editPassWord(UserData userData) {
        return userBusiness.editPassWord(userData);

    }

    /**
     * 修改密码
     */
    public void updatePassword(String account, String newpass) {
        userBusiness.updatePassword(account, newpass);
    }

    /**
     * 重置密码
     * 
     * @param id
     * @param newpwd
     */
    public void resetPassword(String id, String newpwd) {
        userBusiness.resetPassword(id, newpwd);
    }

    /**
     * 获取人员权限，不包括他们 所有共有的权限 ADMIN
     */
    public String getUserRole(String userID) {
        return userBusiness.getUserRole(userID);
    }

    /**
     * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
     */
    public String getUserRoleName(String userID) {
        return userBusiness.getUserRoleName(userID);
    }

    /**
     * 
     * 修改管理员状态 （启动或者注销）<br>
     * 
     * @author hy <br>
     *         2014-2-17
     * @update
     * @param [userId] [更具id查询数据],[userState] [修改数据]
     * @return [void]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void updateUserState(String userId, int userState) {
        userBusiness.updateUserState(userId, userState);
    }

    @Override
    public void register(UserData userData) {
        userBusiness.register(userData);
    }

    @Override
    public UserData checkUser(UserData userData) {
        return userBusiness.checkUser(userData);
    }

    @Override
    public void addUserBySQL(JSONObject obj) {
        userBusiness.addUserBySQL(obj);

    }

    /**
     * 
     * 修改用户信息<br>
     * 
     * @author 冯鑫 <br>
     *         2014-5-22
     * @update
     * @param UserData userData
     * @return void
     */
    public void updateUserData(UserData userData) {
        userBusiness.updateUserData(userData);
    }

    @Override
    public String editLoginAccount(UserData userData, String loginAccount) {
        // 查看用户输入的密码是否与该账号匹配
        String isOk = userBusiness.checkLoginUserMD5(loginAccount, userData.getPassWord());
        if (isOk == "1") {
            // 若用户输入的密码验证通过，则执行修改登陆账号的操作
            // 1:根据用户名和密码查出之前的账号信息
            UserData userData2 = new UserData();
            userData2.setLoginMail(loginAccount);
            UserData data = userBusiness.checkUser(userData2);
            // 2: 更新账号
            data.setLoginMail(userData.getLoginMail());
            userBusiness.updateUserData(data);
            return "2";// 修改成功
        } else if (isOk == "5") {
            return "3";// 由于系统原因修改失败
        } else {
            return "1";// 由于密码不匹配修改失败
        }
    }

    @Override
    public String editReceivableAccount(UserData userData) {
        try {
            userBusiness.editReceivableAccount(userData);
            return "1";
        } catch (SQLException e) {
            return "2";
        }
    }

    @Override
    public String isExitReceivableAccount(String userId) {
        return userBusiness.isExitReceivableAccount(userId);
    }

    @Override
    public UserData searchUserInfoById(String userId) {
        
        return userBusiness.searchUserInfoById(userId);
    }

}