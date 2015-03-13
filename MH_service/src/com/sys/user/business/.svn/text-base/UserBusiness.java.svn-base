package com.sys.user.business;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.*;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.sys.role.persistence.IRolePersistence;
import com.sys.user.data.UserData;
import com.sys.user.persistence.IUserPersistence;
import com.sys.userrole.data.UserRoleCtnData;
import com.sys.userrole.persistence.IUserRolePersistence;

/********************************************************
 * Copyright (C), 2009-2011, GoMai. File name: UserBusiness.java 
 * Author: CuiYunYan LiuLei Version: 1.0.0 Date: 2011-6-17
 ***********************************************************/
/**
 * 管理员配置管理操作business层实现类
 * 
 * @author jmj
 */
@Component("userBusiness")
public class UserBusiness extends FrmBusiness implements IUserBusiness, Serializable {
    private static final long serialVersionUID = 664737998850797161L;
    @Resource(name = "userPersistence")
    private IUserPersistence userPersistence;
    @Resource(name = "userRoleCtnPersistence")
    private IUserRolePersistence userRolePersistence;
    @Resource(name = "rolePersistence")
    private IRolePersistence rolePersistence;

    /**
     * 添加用户信息
     */
    public void addUser(UserData userData) {
        userData.setUserType(1);
        userData.setAddType(2);
        userData.setUserState(1);
        
        /*******************添加明文密码；左香勇 2014-4-29 ******************************/
        userData.setPasswordtext(userData.getPassWord());
        /******************************************************************************/
        
        userData.setPassWord(PasswordUtil.encodePassword(userData.getPassWord()));
        // 将当前时间设置为产品的创建时间
        userData.setCreateTime(new Date());
        
        userPersistence.addUser(userData);
    }

    /**
     * 删除用户信息
     */
    public void delete(String id) {
        userPersistence.delete(id);
    }

    /**
     * 修改用户信息
     */
    public void editUser(UserData user, String id, String name, String email) {
        user.setModifyTime(new Date());
        // user.setPassWord(PasswordUtil.encodePassword(user.getPassWord()));
        user = userPersistence.retrieve(id);
        user.setUserName(name);
        user.setLoginMail(email);
        userPersistence.editUser(user);
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
    public UserData getUserDataByPageId(String pageid){
        return userPersistence.getUserDataByPageId(pageid);
    }
    
    /**
     * 重置密码
     * @param id
     * @param newpwd
     */
    public void resetPassword(String id, String newpwd){
    	UserData data  = userPersistence.retrieve(id);
    	
    	data.setModifyTime(new Date());
    	data.setPassWord(PasswordUtil.encodePassword(newpwd));
    	data.setPasswordtext(newpwd);
    	
    	userPersistence.editUser(data);
    }
    
    /**
     * 查询用户信息(分页显示)
     */
    public List<UserData> getAllUserInfo(PageRoll pageRoll, UserData userData) {
        userData.setUserType(1);
        List<UserData> userDatas = userPersistence.getAllUserInfo(pageRoll, userData);
        for (int i = 0; i < userDatas.size(); i++) {
            List<UserRoleCtnData> userRoleDatas = userRolePersistence.getUserRolesByUserId(userDatas.get(i).getId());
            for (int j = 0; j < userRoleDatas.size(); j++) {
                userRoleDatas.get(j).setRoleData(rolePersistence.retrieve(userRoleDatas.get(j).getRoleId()));
            }
            userDatas.get(i).setRolelist(userRoleDatas);
        }
        return userDatas;
    }

    /**
     * 查询用户信息
     */
    public List<UserData> getAllUserInfo(JSONObject obj) {
        return userPersistence.getAllUserInfo(obj);
    }

    /**
     * 根据权限 查询用户名称和ID
     */
    public List<UserData> getUserIDAndName(String roleID) {
        return userPersistence.getUserIDAndName(roleID);
    }

    /**
     * 根据用户名获取密码
     */
    public String getPassWordByUserID(String account) {
        return userPersistence.getPassWordByUserID(account);
    }

    /**
     * 用户登录验证
     */
    public String checkLogin(String account, String password) {
        return userPersistence.checkLogin(account, password);
    }

    @Override
    public String editPassWord(UserData userData) {
        if (userData.getId() != null && !userData.getId().equals("")) {// 若用户ID不为空，则查询出该ID用户的信息
            UserData data = userPersistence.retrieve(userData.getId());
            String passWord = userData.getUserName();
            String passWord2 = Encrypt.getMD5Str(passWord, null);
            if (passWord2 != null && !passWord2.equals("")) {// 若 加密后的密码不为空，则跟原密码进行判断
                if (data.getPassWord().equals(passWord2)) {// 若用户输入的旧密码正确，则将改为新密码
                    /*******************添加明文密码；左香勇 2014-4-29 ******************************/
                   // data.setPasswordtext(userData.getPassWord());
                    /************************************************/
                    String newPassWOrd = Encrypt.getMD5Str(userData.getPassWord(), null);
                    data.setPassWord(newPassWOrd);// 将新密码加密
                    userPersistence.update(data);
                    return "success";// 修改成功
                }
                return "fail";// 因用户输入的旧密码不正确返回失败
            }
        }
        return "unknowe";// 返回未知异常

    }

    /** 修改密码 */
    public void updatePassword(String account, String newpass) {
        userPersistence.updatePassword(account, newpass);
    }

    /**
     * 获取人员权限，不包括他们 所有共有的权限 ADMIN
     */
    public String getUserRole(String userID) {
        return userPersistence.getUserRole(userID);
    }

    /**
     * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
     */
    public String getUserRoleName(String userID) {
        return userPersistence.getUserRoleName(userID);
    }

    /**
     * 查询小组的成员 by 小组id
     **/
    public List<UserData> getTeamMember(String teamID) {
        return userPersistence.getTeamMember(teamID);
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
        UserData userData = null; // 定义一个用户实体类
        /* 如果用户id不是为空，就查询出数据，并修改状态 */
        if (userId != null && !" ".equals(userId)) {
            userData = userPersistence.retrieve(userId);
        }
        userData.setUserState(userState);
        userPersistence.update(userData);

    }

    @Override
    public void register(UserData userData) {
        userData.setCreateTime(new Date());
        /*******************添加明文密码；左香勇 2014-4-29 ******************************/
        userData.setPasswordtext(userData.getPassWord());
        /************************************************/
        
        // 将用户填写的密码加密
        String passWord = Encrypt.getMD5Str(userData.getPassWord(), null);
        userData.setPassWord(passWord);
        userPersistence.add(userData);
    }
    
    
    @Override
    public UserData checkUser(UserData userData) {
        // 定义查询hql语句
        String hql = " from UserData where loginMail=?";
        // 获取查询结果
        List<UserData> userDatas = userPersistence.search(hql, new Object[]{userData.getLoginMail()});
        if(userDatas.size()>0){
            return userDatas.get(0);
        }
        return null;
    }
    @Override
    public void addUserBySQL(JSONObject obj) {
        String sql="insert into CTN_SYSUSER (id, loginmail, loginmoble, username, password, usertype, userstate, addtype, createtime, modifytime, version, remark)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        Object[] objects =new Object[]{obj.getString("id"),obj.getString("loginMail"),
                obj.getString("loginMoble"),obj.getString("userName"),obj.getString("passWord"),2,obj.getInt("userState"),obj.getInt("addType"),DateUtil.strToDate(obj.getString("createTime"), "yyyy-MM-dd"),DateUtil.strToDate(obj.getString("modifyTime"), "yyyy-MM-dd"),obj.getInt("version"),""};
        jdbcDao.executeSQL(sql, objects);
        
    }
    /**
     * 
     *  修改用户信息<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-22
     * @update 
     * @param UserData userData
     * @return  void
     */
    public void updateUserData(UserData userData){
        userPersistence.update(userData);
    }

    @Override
    public void editReceivableAccount(UserData userData) throws SQLException {
        // 获取用户信息
        UserData data = userPersistence.retrieve(userData.getId());
        // 更新用户账号
        data.setReceivableAccount(userData.getReceivableAccount());
        data.setAccountType(userData.getAccountType());
        userPersistence.update(data);
    }

    @Override
    public String isExitReceivableAccount(String userId) {
        // 获取用户信息
        UserData userData = userPersistence.retrieve(userId);
        if(userData.getReceivableAccount() !=null && userData.getReceivableAccount() != ""){
            return "1";
        }else{
            return "0";
        }
    }

    @Override
    public UserData searchUserInfoById(String userId) {
        
        return userPersistence.retrieve(userId);
    }

    @Override
    public String checkLoginUserMD5(String loginAccount, String passWord) {
        return userPersistence.checkLoginUserMD5(loginAccount, passWord);
    }

   
}