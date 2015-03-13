package com.sys.user.facade;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.util.mailSystem.MailSystem;
import com.sys.user.data.UserData;
import com.sys.user.persistence.IUserPersistence;
import com.sys.user.service.IUserService;

/**
 * 管理员配置facade层
 * 
 * @author jmj
 */
@Component("userFacade")
public class UserFacade extends FrmFacade {
    @Resource(name = "userSysService")
    private IUserService userService;

    @Resource(name = "userPersistence")
    private IUserPersistence userPersistence;

    /**
     * 新增用户
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:44:47
     * @param user
     */
    public void addUser(UserData user) {
        userService.addUser(user);
    }

    /**
     * 删除用户
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:44:53
     * @param id
     */
    public void delete(String id) {
        userService.delete(id);
    }

    /**
     * 编辑用户信息
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:02
     * @param user
     */
    public void editUser(UserData user, String id, String name, String email) {
        userService.editUser(user, id, name, email);
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
        return userService.getUserDataByPageId(pageid);
    }

    /**
     * 查询用户信息(分页显示)
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:08
     * @param pageRoll
     * @param userData
     * @return
     */
    public List<UserData> getAllUserInfo(PageRoll pageRoll, UserData userData) {
        return userService.getAllUserInfo(pageRoll, userData);
    }

    /**
     * 查询用户信息
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:15
     * @param obj
     * @return
     */
    public List<UserData> getAllUserInfo(JSONObject obj) {
        return userService.getAllUserInfo(obj);
    }

    /**
     * 根据权限 查询用户名称和ID
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:22
     * @param roleID
     * @return
     */
    public List<UserData> getUserIDAndNameByRole(String roleID) {
        return userService.getUserIDAndName(roleID);
    }

    /**
     * 查询小组的成员 by 小组id
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:30
     * @param teamID
     * @return
     */
    public List<UserData> getTeamMember(String teamID) {
        return userService.getTeamMember(teamID);
    }

    /**
     * 登陆验证
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:37
     * @param account
     * @param password
     * @param type
     * @return
     */
    public String checkLogin(String account, String password) {
        return userService.checkLogin(account, password);
    }

    /**
     * 获取用户密码
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:43
     * @param account
     * @return
     */
    public String getPassWordByUserID(String account) {
        return userService.getPassWordByUserID(account);
    }

    public String editPassWoid(UserData userData) {
        return userService.editPassWord(userData);
    }

    /**
     * 重置密码
     * 
     * @param id
     * @param newpwd
     */
    public void resetPassword(String id, String newpwd) {
        userService.resetPassword(id, newpwd);
    }

    /**
     * 获取人员权限，不包括他们 所有共有的权限 ADMIN
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:50
     * @param userID
     * @return
     */
    public String getUserRole(String userID) {
        return userService.getUserRole(userID);
    }

    /**
     * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:45:59
     * @param userID
     * @return
     */
    public String getUserRoleName(String userID) {
        return userService.getUserRoleName(userID);
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
        userService.updateUserState(userId, userState);
    }

    /**
     * 
     * 前台注册用户<br>
     * 
     * @author 文东 <br>
     *         2014-2-27
     * @update
     * @param userData 用户对象
     * @return
     * @exception/throws
     * @see UserFacade#register(UserData)
     * @since
     */
    public void register(UserData userData) {
        userService.register(userData);
    }

    /**
     * 
     * 检查用户名是否可用<br>
     * 
     * @author 文东 <br>
     *         2014-3-1
     * @update
     * @param userData 用户对象 存放查询参数
     * @return
     * @exception/throws
     * @see UserFacade#ajaxCheckUser(UserData)
     * @since
     */
    public UserData ajaxCheckUser(UserData userData) {
        // 根据用户名称查询用户
        return userService.checkUser(userData);
    }

    public void email(UserData data) {
        UserData userData = null;
        if (data.getId() != null && !"".equals(data.getId())) {
            userData = userPersistence.retrieve(data.getId());
        }
        try {
            MailSystem.sendInfoTiJiaoRenZhen(userData);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * 通过sql增加user对象 切保持用户id和ctn用户id一直
     * 
     * @author 冯鑫 2014-4-1
     * @update
     * @param JSONObject obj
     * @return void
     */
    public void addUserBySQL(JSONObject obj) {
        userService.addUserBySQL(obj);
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
        userService.updateUserData(userData);
    }

    /**
     * 
     * 修改用户的登陆账号<br>
     * 
     * @author 文东<br>
     *         2014年9月10日
     * @update
     * @param userData 用户对象，里面存放用户的密码和新账号
     * @param loginAccount 当前登陆用户的登陆账号
     * @return 是否更改成功 1 － 由于密码不匹配更改失败 2 － 更改成功 3 － 由于系统原因更改失败
     * @exception/throws
     * @see UserFacade#editLoginAccount(UserData, String)
     * @since vmaque1.5
     */
    public String editLoginAccount(UserData userData, String loginAccount) {
        return userService.editLoginAccount(userData, loginAccount);
    }

    /**
     * 
     * 修改用户收款账号<br>
     * 
     * @author 文东<br>
     *         2014年9月10日
     * @update
     * @param userData 用户的收款账号信息
     * @return String 类型的变量 1 － 修改成功 2 － 产生系统异常，修改失败
     * @exception/throws
     * @see UserFacade#editReceivableAccount(UserData)
     * @since vmaque1.5
     */
    public String editReceivableAccount(UserData userData) {
        return userService.editReceivableAccount(userData);
    }

    /**
     * 
     * 根据用户id获取用户信息<br>
     * 
     * @author 文东<br> 
     *		   2014年9月13日
     * @update 
     * @param userId 用户id
     * @return {@link UserData} 用户信息
     * @exception/throws 
     * @see  UserFacade#searchUserInfoById(String)
     * @since vmaque1.5
     */
    public UserData searchUserInfoById(String userId) {
        
        return userService.searchUserInfoById(userId);
    }
}
