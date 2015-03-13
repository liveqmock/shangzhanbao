package com.sys.user.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.PasswordUtil;
import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.sys.user.data.UserData;

/********************************************************
 Copyright (C), 2009-2011, GoMai.
 File name:    UserPersistence.java
 Author: CuiYunYan LiuLei  Version:  1.0.0  Date: 2011-6-17
 ***********************************************************/
/**
 * 管理员配置管理操作persistence层
 * 
 * @author jmj
 */
@Component("userPersistence")
public class UserPersistence extends BasePersistence<UserData> implements IUserPersistence, Serializable {

    /**
     */
    private static final long serialVersionUID = -7948279734682792319L;

    /**
     * 添加用户信息
     */
    public void addUser(UserData user) {
        add(user);
    }

    /**
     * 删除用户信息
     */
    public void delete(String id) {
        // 删除用户-权限关联表
        StringBuffer delU_RSQL = new StringBuffer("DELETE TB_SYS_USERROLE WHERE USER_ID = '").append(id).append("'");
        // 删除用户表
        StringBuffer delSQL = new StringBuffer("UPDATE CTN_SYSUSER U SET U.USERSTATE=2 WHERE ID = '").append(id)
                .append("'");
        executeSQL(delU_RSQL.toString());
        executeSQL(delSQL.toString());
    }

    /**
     * 修改用户信息
     */
    public void editUser(UserData user) {
        updateWithOutNullProp(user);
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

        StringBuffer sql = new StringBuffer(
                "from UserData us where 1=1 and us.id = (select userId from PageData where id='");
        sql.append(pageid).append("')");

        List<UserData> list = search(sql.toString());
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 查询用户信息(分页显示)
     */
    @SuppressWarnings("unchecked")
    public List<UserData> getAllUserInfo(PageRoll pageRoll, UserData userData) {
        List<UserData> list = null;
        List<Object> objects = new ArrayList<Object>();
        StringBuffer querySQL = new StringBuffer("from UserData us where 1=1 and us.userType=1");
        /*
         * querySQL.append(" and us.userState=?"); objects.add(1);
         */
        if (userData != null) {
            if (userData.getUserName() != null && !"".equals(userData.getUserName())) {
                querySQL.append(" and us.userName like ?");
                objects.add("%" + userData.getUserName() + "%");
            }
            if (userData.getLoginMoble() != null && !"".equals(userData.getLoginMoble())) {
                querySQL.append(" and us.loginMoble like ?");
                objects.add("%" + userData.getLoginMoble() + "%");
            }
            if (userData.getLoginMail() != null && !"".equals(userData.getLoginMail())) {
                querySQL.append(" and us.loginMail like ?");
                objects.add("%" + userData.getLoginMail() + "%");
            }
            if (userData.getRoleid() != null && !"".equals(userData.getRoleid())) {
                querySQL.append(" and us.id in(select ur.userId from UserRoleCtnData ur where ur.roleId =?)");
                objects.add(userData.getRoleid());
            }
        }
        querySQL.append("  order by  createTime desc");

        String countSQL = "select count(us.id)" + querySQL;

        if (pageRoll != null) {
            pageRoll.setCountSQL(countSQL);
            pageRoll.setSearchSQL(querySQL.toString());
            list = search(pageRoll, objects).getList();
        } else {
            list = search(querySQL.toString());
        }
        return list;
    }

    /**
     * 查询用户信息R
     */
    public List<UserData> getAllUserInfo(JSONObject obj) {
        StringBuffer querySQL = new StringBuffer("FROM UserData us WHERE 1=1");
        querySQL.append(this.getInquiresTheConditions(obj));
        return search(querySQL.toString());
    }

    /*
     * 用户信息查询条件
     */
    private String getInquiresTheConditions(JSONObject obj) {
        StringBuffer whereSQL = new StringBuffer();
        // 请自行添加查询条件
        if (obj != null && !obj.isNullObject()) {
            if (null != obj.get("userID")) {// 用于根据用户id查询用户信息
                String userID = obj.getString("userID");
                if (userID != null && !"".equals(userID))
                    whereSQL.append(" AND us.id = '").append(userID).append("'");
            }
            if (null != obj.get("id")) {// 用于修改用户信息时查询该用户是否已存在
                String id = obj.getString("id");
                if (id != null && !"".equals(id))
                    whereSQL.append(" AND us.id != '").append(id).append("'");
            }
            /* if(null != obj.get("mail")&&null != obj.get("mobile")){ */
            if (null != obj.get("mail")) {// 用户查询该用户是否已存在
                String mail = obj.getString("mail");
                if (mail != null && !"".equals(mail))
                    whereSQL.append(" AND (us.loginMail = '").append(mail).append("'");
                /*
                 * String mobile = obj.getString("mobile");//用户查询该用户是否已存在 if(mobile != null && !"".equals(mobile))
                 * whereSQL.append(" OR us.loginMoble = '").append(mobile).append("')");
                 */
            }
            whereSQL.append(" AND us.userType=2 )");
        }
        return whereSQL.toString();
    }

    /**
     * 根据权限 查询用户名称和ID
     */
    public List<UserData> getUserIDAndName(String roleID) {
        StringBuffer hql = new StringBuffer("SELECT new UserData(id,name) FROM UserData")
                .append(" WHERE ID IN(SELECT userId FROM UserRoleCtnData WHERE roleId = '").append(roleID).append("')");
        return search(hql.toString());
    }

    /**
     * 根据用户名获取密码
     */
    public String getPassWordByUserID(String account) {
        String password = "";
        String sql = " select password from CTN_SYSUSER where USERNAME='" + account + "'";
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> resultSet = dao.queryForList(sql, null);
        if (resultSet != null && resultSet.size() != 0) {
            ETIPResultSet pass = resultSet.get(0);
            password = (String) pass.get("PASSWORD");
        }
        return password;
    }

    /**
     * 用户登录验证
     * 
     * @param accout
     * @param password
     * @return 0.用户名或密码不正确，1.登陆通过，2.无该用户，5.异常
     */
    public String checkLogin(String account, String password) {
        String resultCode = "0";// 用户名或者密码不正确
        try {
            // 根据用户帐号获取用户密码
            String sql = " select password from ctn_sysuser where (loginmail = ? or loginmoble = ?) and userstate <> 2";
            JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
            List<ETIPResultSet> resultSet = dao.queryForList(sql, new Object[] { account, account });
            if (resultSet != null && resultSet.size() != 0) {
                ETIPResultSet pass = resultSet.get(0);
                String oldPass = (String) pass.get("PASSWORD");
                if (oldPass != null && oldPass.equals(password)) {
                    resultCode = "1";// 登陆通过
                }
            } else {
                resultCode = "2";
            }
        } catch (Exception e) {
            resultCode = "5";// 系统异常
        }
        return resultCode;
    }

    /** 修改密码 */
    public void updatePassword(String account, String newpass) {
        StringBuffer sql = new StringBuffer("update ctn_sysuser set password='").append(newpass);
        sql.append("' where USERNAME = '").append(account).append("'");
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        dao.executeSQL(sql.toString());
    }

    /**
     * 获取人员权限，不包括他们 所有共有的权限 ADMIN
     */
    @SuppressWarnings("unchecked")
    public String getUserRole(String userID) {
        StringBuffer querySQL = new StringBuffer();
        querySQL.append("SELECT ROLE_ID FROM TB_SYS_USERROLE WHERE USER_ID = '").append(userID)
                .append("' AND ROLE_ID <> (SELECT ROLE_ID FROM TB_SYS_USERROLE")
                .append(" LEFT JOIN ctn_sysuser ON Tctn_sysuser.ID = TB_SYS_USERROLE.USER_ID")
                .append(" WHERE ctn_sysuser.USERNAME = 'admin')");
        List<String> list = searchBySQL(querySQL.toString());
        if (list.size() > 0)
            return list.get(0);
        return "";
    }

    /**
     * 获取人员权限名称(角色名称)，不包括他们 所有共有的权限 ADMIN
     */
    @SuppressWarnings("unchecked")
    public String getUserRoleName(String userID) {
        StringBuffer querySQL = new StringBuffer();
        querySQL.append("SELECT R.ROLENAME FROM TB_SYS_USERROLE USERROLE, TB_SYS_ROLE R WHERE USERROLE.USER_ID = '")
                .append(userID).append("' AND USERROLE.ROLE_ID <> (SELECT ROLE_ID FROM TB_SYS_USERROLE")
                .append(" LEFT JOIN ctn_sysuser ON ctn_sysuser.ID = TB_SYS_USERROLE.USER_ID")
                .append(" WHERE ctn_sysuser.USERNAME = 'admin') AND USERROLE.ROLE_ID = R.ID");
        List<String> list = searchBySQL(querySQL.toString());
        if (list.size() > 0)
            return list.get(0);
        return "";
    }

    /**
     * 查询小组的成员 by 小组id
     **/
    public List<UserData> getTeamMember(String teamID) {
        StringBuffer hql = new StringBuffer("SELECT new UserData(id,name) FROM UserData where 1 = 1 ");
        hql.append(" and id in(SELECT userID FROM TeamUserData where teamID = '").append(teamID).append("') ");
        return search(hql.toString());
    }

    @Override
    public String checkLoginUserMD5(String loginAccount, String passWord) {
        String resultCode = "0";// 用户名或者密码不正确
        try {
            // 根据用户帐号获取用户密码
            String sql = " select password from ctn_sysuser where (loginmail = ? or loginmoble = ?) and userstate <> 2";
            JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
            List<ETIPResultSet> resultSet = dao.queryForList(sql, new Object[] { loginAccount, loginAccount });
            if (resultSet != null && resultSet.size() != 0) {
                ETIPResultSet pass = resultSet.get(0);
                String oldPass = (String) pass.get("PASSWORD");
                if (oldPass != null && oldPass.equals(PasswordUtil.encodePassword(passWord))) {
                    resultCode = "1";// 登陆通过
                }
            } else {
                resultCode = "2";
            }
        } catch (Exception e) {
            resultCode = "5";// 系统异常
        }
        return resultCode;
    }

}
