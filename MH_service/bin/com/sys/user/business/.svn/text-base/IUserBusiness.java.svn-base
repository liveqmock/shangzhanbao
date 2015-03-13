package com.sys.user.business;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.user.data.UserData;

/********************************************************
 Copyright (C), 2009-2011, GoMai.
 File name:    IUserBusiness.java
 Author: CuiYunYan LiuLei     Version:  1.0.0  Date: 2011-6-17
 ***********************************************************/
/**
 * 管理员配置管理操作business层接口
 * 
 * @author jmj
 */
public interface IUserBusiness extends IBusiness {
    /**
     * 新增用户
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:37:55
     * @param user
     */
    public void addUser(UserData user);

    /**
     * 删除用户
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:02
     * @param id
     */
    public void delete(String id);

    /**
     * 编辑用户信息
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:10
     * @param user
     */
    public void editUser(UserData user, String id, String name, String email);

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
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:17
     * @param pageRoll
     * @param userData
     * @return
     */
    public List<UserData> getAllUserInfo(PageRoll pageRoll, UserData userData);

    /**
     * 查询用户信息
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:23
     * @param obj
     * @return
     */
    public List<UserData> getAllUserInfo(JSONObject obj);

    /**
     * 根据权限 查询用户名称和ID
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:30
     * @param roleID
     * @return
     */
    public List<UserData> getUserIDAndName(String roleID);

    /**
     * 查询小组的成员 by 小组id
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:39
     * @param teamID
     * @return
     */
    public List<UserData> getTeamMember(String teamID);

    /**
     * 登陆验证
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:46
     * @param account
     * @param password
     * @param type
     * @return
     */
    public String checkLogin(String account, String password);

    /**
     * 获取密码
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:38:54
     * @param account
     * @return
     */
    public String getPassWordByUserID(String account);

    /**
     * 修改密码
     * 
     * @author：guojingchao
     * @update： 2014-2-24
     * @param userData
     */
    String editPassWord(UserData userData);

    /**
     * 重置密码
     * 
     * @param id
     * @param newpwd
     */
    public void resetPassword(String id, String newpwd);

    /**
     * 修改密码
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:39:01
     * @param account
     * @param newpass
     */
    public void updatePassword(String account, String newpass);

    /**
     * 获取人员权限，不包括他们 所有共有的权限 ADMIN
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:39:08
     * @param userID
     * @return
     */
    public String getUserRole(String userID);

    /**
     * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:39:18
     * @param userID
     * @return
     */
    public String getUserRoleName(String userID);

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
    public void updateUserState(String userId, int userState);

    /**
     * 
     * 注册用户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-27
     * @update
     * @param userData 用户对象
     * @return void
     * @exception/throws
     * @see IUserBusiness#register(UserData)
     * @since
     */
    public void register(UserData userData);

    /**
     * 
     * 检查用户名是否存在<br>
     * 
     * @author 文东 <br>
     *         2014-3-1
     * @update
     * @param userData 用户对象
     * @return UserData
     * @exception/throws
     * @see IUserBusiness#checkUser(UserData)
     * @since
     */
    public UserData checkUser(UserData userData);

    /**
     * 
     * 通过sql增加user对象 切保持用户id和ctn用户id一直
     * 
     * @author 冯鑫 2014-4-1
     * @update
     * @param JSONObject obj
     * @return void
     */
    public void addUserBySQL(JSONObject obj);

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
    public void updateUserData(UserData userData);

    /**
     * 
     * 修改用户收款账号<br>
     * 
     * @author 文东<br>
     *         2014年9月10日
     * @update
     * @param userData 用户的收款账号信息
     * @return 无返回值
     * @exception/throws {@link SQLException} 数据库异常
     * @see IUserBusiness#editReceivableAccount(UserData)
     * @since vmaque 1.5
     */
    public void editReceivableAccount(UserData userData) throws SQLException;

    /**
     * 
     * 根据用户id查询用户是否具有收款账号<br>
     * 
     * @author 文东 <br> 
     *		   2014年9月11日
     * @update 
     * @param userId 用户id
     * @return 返回String类型的变量 返回 1－拥有收款账号 0－未拥有支付宝账号
     * @exception/throws 
     * @see   IUserBusiness#isExitReceivableAccount(String)
     * @since vmaque 1.5
     */
    public String isExitReceivableAccount(String userId);

    /**
     * 
     * 根据用户id获取用户信息<br>
     * 
     * @author 文东<br> 
     *         2014年9月13日
     * @update 
     * @param userId 用户id
     * @return {@link UserData} 用户信息
     * @exception/throws
     * @see    IUserBusiness#searchUserInfoById(String)
     * @since vmaque1..5
     */
    public UserData searchUserInfoById(String userId);
    
    /**
     * 
     * 使用md5加密检查用户是否匹配<br>
     * 
     * @author 文东 <br> 
     *		   2014年11月28日
     * @update 
     * @param loginAccount 用户账号
     * @param passWord 用户密码
     * @return   0.用户名或密码不正确，1.登陆通过，2.无该用户，5.异常
     * @exception/throws 
     * @see   IUserBusiness#checkLoginUserMD5(String, String)
     * @since 
     */
    public String checkLoginUserMD5(String loginAccount, String passWord);

}
