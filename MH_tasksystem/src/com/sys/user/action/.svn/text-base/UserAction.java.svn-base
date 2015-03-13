package com.sys.user.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import com.common.util.PasswordUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.account.data.AccountNumberData;
import com.mini.front.account.facade.AccountNumberFacade;
import com.sys.org.data.OrgData;
import com.sys.role.data.RoleData;
import com.sys.role.facade.RoleFacade;
import com.sys.user.data.UserData;
import com.sys.user.facade.UserFacade;
import com.sys.userrole.data.UserRoleCtnData;
import com.sys.userrole.facade.UserRoleFacade;
import com.util.GressionUtil;
import com.util.HttpWebUtil;
import com.util.mail.MailUtil;

@ResultPath("/")
@Results({
        // 跳转到用户列表页面
        @Result(name = "toUserList", location = "/view/pages/sys/user/ctn/userList.jsp"),
        // 跳转到增加页面
        @Result(name = "addUsers", location = "/view/pages/sys/user/ctn/userAdd.jsp"),
        // 跳转到修改页面
        @Result(name = "editUsers", type = "redirectAction", location = "user/key/userEdit.jsp"),
        // 跳转到详情页面
        @Result(name = "viewInfos", location = "view/pages/mini/front/usermanage/UserCenter_Ledger.jsp"),
        // 删除成功后跳转到列表页面
        @Result(name = "toGetUsersInfo", type = "redirectAction", location = "user/key/getUsersInfo"),
        // 注销成功后跳转到列表页面
        @Result(name = "updateUserState", type = "redirectAction", location = "user/key/getUsersInfo"),
        // 注册成功后跳转到注册成功页面
        @Result(name = "regSucessful", location = "/register_success.jsp"),
        // 跳转到重置密码页面
        @Result(name = "toresetpassWord", location = "/view/pages/sys/user/resetpassword/userResetPassword.jsp"),
        // 跳转到重置密码过期页面
        @Result(name = "notpassword", location = "/view/pages/sys/user/resetpassword/userReseterror.jsp"),
        // 跳转到重置密码成功
        @Result(name = "resetsuccess", location = "/view/pages/sys/user/resetpassword/resetsuccess.jsp"),
        // 跳转到修改登陆账号页面
        @Result(name = "toEditLoginAccount", location = "/view/pages/mini/front/purchase/sysUser/editLoginAccount.jsp"),
        // 跳转到修改登陆密码页面
        @Result(name = "toEditPwd", location = "/view/pages/mini/front/purchase/sysUser/editPwd.jsp"),
        // 跳转到修改收款账号页面
        @Result(name = "toEditReceivableAccount", location = "/view/pages/mini/front/purchase/sysUser/editReceivableAccount.jsp"),
        @Result(name = "sucPwd", location = "/have_mail.jsp")

}

)
/**
 * 用户管理
 * @author jmj
 */
@Component("userAction")
public class UserAction extends FrmAction {
    /*****************************************************/
    @Resource(name = "userFacade")
    private UserFacade userFacade;
    @Resource(name = "roleFacade")
    private RoleFacade roleFacade;
    @Resource(name = "userRoleFacade")
    private UserRoleFacade userRoleFacade;
    @Resource(name="accountNumberFacade")
    private AccountNumberFacade accountNumberFacade;
    /*****************************************************/
    private UserData userData = new UserData();
    private List<RoleData> roleList; // 权限(角色)列表
    private List<OrgData> orgList; // 机构信息列表
    private PageRoll pageRoll = new PageRoll();
    private String[] userRoleS;// 角色数组

    /****************************************************/
    /**
     * 查询权限(角色)信息、机构信息，进入新增用户界面
     */
    public String intoAddUserPages() {
        roleList = roleFacade.queryAllRole();// 权限信息
        return "addUsers";
    }

    /**
     * 新增用户信息
     * 
     * @author：
     * @update：jmj-用户角色增加改为增加对象 2013-8-14 下午05:51:26
     * @throws IOException
     */
    public void addUsers() throws IOException {

        String type = request.getParameter("type");

        if (userData != null) {
            userFacade.addUser(userData);// 用户添加
            // 添加用户——权限关联
            UserRoleCtnData data = null;
            if (userRoleS != null) {
                for (int i = 0, len = userRoleS.length; i < len; i++) {
                    data = new UserRoleCtnData();
                    data.setRoleId(userRoleS[i]);
                    data.setUserId(userData.getId());
                    userRoleFacade.addUserRole(data);
                }
            }
            if (type.equals("add")) {
                json = userData.getId();
            } else {
                json = "1";
            }
        } else {
            json = "0";
        }
    }

    /**
     * 查询用户信息，进入修改用户界面
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:46:36
     * @return
     */
    public String intoEditUserPages() {
        String userID = request.getParameter("userid");// 用户ID
        request.setAttribute("userid", userID);
        String json = "{\"userID\":\"" + userID + "\"}";
        List<UserData> list = userFacade.getAllUserInfo(JSONObject.fromObject(json));
        if (list.size() > 0)
            userData = list.get(0);
        roleList = roleFacade.queryAllRole();// 权限信息
        List<String> userrolelist = userRoleFacade.getUserRoleList(JSONObject.fromObject(json));
        request.setAttribute("userRoleList", userrolelist);// 查询用户权限
        return "editUsers";
    }

    /**
     * 修改密码
     * 
     * @author guojingchao
     * @return
     */
    public void ajaxEditPassWord() {
        String id = getFrmUser().etipUserID;// 获取当前登录的用户ID
        userData.setId(id);
        /* sysUserData中 userName属性存放的是用户输入的旧密码,passWord存放的用户输入的新密码 */
        String var = request.getParameter("variCode");// 获取用户填写的验证码
        String variCode = (String) sessionMap.get("RANDOMVALIDATECODEKEY");
        if (var != null) {// 若用户填写的验证码不为空
            if (!variCode.equalsIgnoreCase(var)) {
                json = "-1";
                return;
            }
        }
        json = userFacade.editPassWoid(userData);
    }

    /**
     * 重置密码，发送邮件
     * 
     * @author 左香勇
     * @update
     */
    public void resetPasswordMail() {

        // 获取用户主键id
        String userid = request.getParameter("userid");
        // 获取要发送到的邮箱地址
        String toAddress = request.getParameter("toAddress");
        // 获取当前时间
        long date = new Date().getTime();

        // 组装重置密码地址参数
        String resetUrl = "userid=" + userid + "&date=" + date;

        // 使用移位加密访问地址参数
        String url = GressionUtil.getString(resetUrl, 5);

        Map<String, String> contentMap = new HashMap<String, String>();
        contentMap.put("userName", toAddress);
        contentMap.put("url", url);

        // 调用发送邮件的方法
        new MailUtil(toAddress, contentMap, 2).run();
    }

    /**
     * 跳转到重置密码页面
     * 
     * @author 左香勇
     * @update
     */
    public String toresetPassword() {

        // 获取用户主键id
        String userid = request.getParameter("zxjwni");
        // 解密用户主键
        userid = GressionUtil.getString(userid, -5);
        // 获取发送邮件时间时间
        long dateMail = Long.parseLong(request.getParameter("ifyj"));

        // 获取当前时间
        long date = new Date().getTime();

        // 获取时间差
        long diff = date - dateMail;

        // 判断邮件是否过期
        if (diff > 60 * 60 * 1000) {

            return "notpassword";

        } else {

            request.setAttribute("userid", userid);
            return "toresetpassWord";

        }
    }

    /**
     * 重置密码
     * 
     * @author 左香勇
     * @update
     */
    public String resetPassword() {
        // 获取重置的密码
        String newPwd = request.getParameter("pwd");
        // 获取用户id
        String userid = request.getParameter("userid");

        userFacade.resetPassword(userid, newPwd);

        userData = userFacade.getAllUserInfo(JSONObject.fromObject("{\"userID\":\"" + userid + "\"}")).get(0);

        userData.setPassWord(newPwd);
        return "resetsuccess";
    }

    /**
     * 编辑用户信息
     * 
     * @author：
     * @update：jmj -用户角色增加改为增加对象 2013-8-14 下午05:43:36
     * @throws Exception
     */
    public void editUsers() throws Exception {
        String newPwd = request.getParameter("newPwd");// 获取新密码
        String name = request.getParameter("userName"); // 获取修改的名称
        String emal = request.getParameter("loginMail"); // 获取修改的登录账号
        String id = request.getParameter("id");
        if (userData != null) {
            String[] roles = request.getParameterValues("userRoleS");
            if (newPwd != null && !"".equals(newPwd)) {
                userData.setPassWord(PasswordUtil.encodePassword(newPwd));
            }
            userFacade.editUser(userData, id, name, emal);

            // 删除中间表用户角色信息
            String userID = userData.getId(); // 用户ID
            userRoleFacade.deleteAllByUser(userID);
            // 添加用户——权限关联
            UserRoleCtnData data = null;
            if (roles != null) {
                for (int i = 0, len = roles.length; i < len; i++) {
                    data = new UserRoleCtnData();
                    data.setUserId(userID);
                    data.setRoleId(roles[i]);
                    userRoleFacade.addUserRole(data);
                }
            }
            json = userData.getId();
        } else {
            json = "1";
        }
    }

    /**
     * 获取用户信息
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:46:45
     * @return
     * @throws Exception
     */
    public String getUserInfos() throws Exception {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            id = getFrmUser().etipUserID;
        }
        String json = "{\"userID\":\"" + id + "\"}";
        List<UserData> list = userFacade.getAllUserInfo(JSONObject.fromObject(json));
        if (list.size() > 0){
            userData = list.get(0);
        }
        roleList = roleFacade.queryAllRole(JSONObject.fromObject(json));// 用户权限(角色)
        request.setAttribute("menuNum", 7);
        @SuppressWarnings("unchecked")
        TreeMap<Integer, String> paraMap = CacheUtil.getInstance().getCacheMap("helpArticleState");

        request.getSession().setAttribute("helpArticleState", paraMap);

        @SuppressWarnings("rawtypes")
        Iterator it = paraMap.entrySet().iterator();
        StringBuffer sbf = new StringBuffer("[");
        while (it.hasNext()) {    
            @SuppressWarnings("rawtypes")
            Map.Entry pairs = (Map.Entry)it.next();
            sbf.append("{\"key\":\"");
            sbf.append(pairs.getKey());
            sbf.append("\",\"value\":\"");
            sbf.append(pairs.getValue());
            sbf.append("\"}");
            if(it.hasNext()){
                sbf.append(",");
            }
        }  
        
        sbf.append("]");
        request.setAttribute("helpArticleCate", sbf.toString());
        
        //根据用户id查询收款账号信息
        List<AccountNumberData> AccountNumberDataList =  accountNumberFacade.queryAccountNumberDataByuserId(id);
        request.setAttribute("accountNumberDataList", AccountNumberDataList);
        
        return "viewInfos";
    }

    /**
     * 验证账户是否已存在
     * 
     * @author：jmj
     * @update： 2013-8-20 下午05:46:53
     * @throws Exception
     */
    public void checkAccount() throws Exception {
        String json = request.getParameter("json");
        JSONObject obj = JSONObject.fromObject(json);
        List<UserData> list = userFacade.getAllUserInfo(obj);
        response.getWriter().print(list.size());
    }

    /**
     * 用户配置管理：分页显示用户信息
     * 
     * @author：jmj
     * @update： 2013-8-14 上午09:17:31
     * @return
     */
    public String getUsersInfo() {
        List<UserData> userlist = userFacade.getAllUserInfo(pageRoll, userData);// 查询用户信息
        roleList = roleFacade.queryAllRole();// 权限信息
        request.setAttribute("userlist", userlist);
        return "toUserList";
    }

    /**
     * 删除用户信息
     * 
     * @author：jmj
     * @update： 2013-8-14 下午12:35:41
     * @return
     */
    public String deleteUserById() {
        String id = request.getParameter("userid");
        userFacade.delete(id);
        return "toGetUsersInfo";
    }

    /**
     * 
     * 〈注销用户〉<br>
     * 
     * @author hy <br>
     *         2014-2-17
     * @return [String]
     */
    public String updateUserState() {
        userFacade.updateUserState(userData.getId(), 2);
        return "updateUserState";
    }

    /**
     * 
     * 〈启动用户〉<br>
     * 
     * @author hy <br>
     *         2014-2-17
     * @return [String]
     */
    public String updateUserStateStart() {
        userFacade.updateUserState(userData.getId(), 1);
        return "updateUserState";
    }

    /**
     * 
     * 前台用户注册<br>
     * 
     * @author 文东 <br>
     *         2014-2-27 左香勇 2014-6-12 添加注册成功发送邮件功能
     * @update
     * @param
     * @return
     * @exception/throws
     * @see UserAction#register()
     * @since
     */
    public void register() {
        // 获取服务器的验证码
        String vericode = (String) sessionMap.get("RANDOMVALIDATECODEKEY");
        // 获取客户端传递的验证码
        String pCode = request.getParameter("varicode");
        if (vericode != null && pCode != null
                && (vericode.toLowerCase().equals(pCode.toLowerCase()) || "gomai".equals(pCode.toLowerCase()))) {
            userFacade.register(userData);
            /** 添加发送邮件功能 **/
            // 判断用户是否有邮箱
            if (null != userData.getLoginMail() && MailUtil.exactnessMail(userData.getLoginMail())) {
                // 发送邮件功能
                Map<String, String> contentMap = new HashMap<String, String>();
                if (null != userData.getUserName() && "".equals(userData.getUserName())) {
                    contentMap.put("userName", userData.getUserName());
                } else {
                    contentMap.put("userName", userData.getLoginMail());
                }
                // 调用发送邮件的方法
                new MailUtil(userData.getLoginMail(), contentMap, 1).run();
                json = "0";
            }
            /** 添加发送邮件功能结束 **/

            // try {
            // JsonConfig jsonConfig = JsonUtil.configJson("yyyy-MM-dd");
            // String url = URLEncoder.encode(
            // JSONObject.fromObject(userData, jsonConfig).toString(),
            // "UTF-8");
            // // 调用ctn接口 同步注册
            // registerflag = HttpWebUtil
            // .getCTNJsonData("wsCTNSynUserRegister?userJSON=" + url);
            // if (null != registerflag && !"".equals(registerflag)) {
            // if ("1".equals(registerflag)) {
            // json = "0";
            // } else {
            // json = "2";
            // }
            // }
            //
            // } catch (Exception e) {
            // json = "2";
            // e.printStackTrace();
            // }
            json = "0";
        } else {
            json = "1";
        }
    }

    /**
     * 
     * 〈快速注册用户方法〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-6-12
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void register2() {
        // String registerflag = null;
        userFacade.register(userData);

        /** 添加发送邮件功能 **/
        // 判断用户是否有邮箱
        if (null != userData.getLoginMail() && MailUtil.exactnessMail(userData.getLoginMail())) {
            // 发送邮件功能
            Map<String, String> contentMap = new HashMap<String, String>();
            if (null != userData.getUserName() && "".equals(userData.getUserName())) {
                contentMap.put("userName", userData.getUserName());
            } else {
                contentMap.put("userName", userData.getLoginMail());
            }
            // 调用发送邮件的方法
            new MailUtil(userData.getLoginMail(), contentMap, 1).run();
            json = "0";

        }
        /** 添加发送邮件功能结束 **/

        // try {
        // JsonConfig jsonConfig = JsonUtil.configJson("yyyy-MM-dd");
        // String url = URLEncoder.encode(
        // JSONObject.fromObject(userData, jsonConfig).toString(),
        // "UTF-8");
        // // 调用ctn接口 同步注册
        // registerflag = HttpWebUtil
        // .getCTNJsonData("wsCTNSynUserRegister?userJSON=" + url);
        // if (null != registerflag && !"".equals(registerflag)) {
        // if ("1".equals(registerflag)) {
        // json = "0";
        // } else {
        // json = "2";
        // }
        // }
        //
        // } catch (Exception e) {
        // json = "2";
        // e.printStackTrace();
        // }
        json = "0";
    }

    /**
     * 
     * 检查注册的用户名是否可用<br>
     * 
     * @author 文东 <br>
     *         2014-3-1
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see UserAction#ajaxCheckUser()
     * @since
     */
    public void ajaxCheckUser() {
        try {
            // 注册邮箱是否已经被占用标志
            String registerflag = null;
            registerflag = HttpWebUtil.getCTNJsonData("wsCheckUserAccount?loginMail=" + userData.getLoginMail());
            /*
             * registerflag = HttpWebUtil.GetWebContent(ResouceUtil.getProperty("domain.properties" , "ctnPath") +
             * "wsCheckUserAccount?loginMail=" + userData.getLoginMail(), "utf-8", 3000);
             */
            userData = userFacade.ajaxCheckUser(userData);
            // 如果ctn接口返回数据 没有返回数据 0：没有被占用 1：已经被占用
            if (registerflag != null && !"".equals(registerflag)) {
                /*
                 * registerflag = registerflag.replace("&lt;", "<"); registerflag =
                 * registerflag.substring(registerflag.indexOf("<return>") + 8, registerflag.indexOf("</return>"));
                 */
                if ("0".equals(registerflag) && userData == null) {
                    json = "0";
                } else {
                    json = "1";
                }
            } else {
                if (userData == null) {
                    json = "0";
                } else {
                    json = "1";
                }
            }
            /*
             * userData = userFacade.ajaxCheckUser(userData); if(userData==null){ registerflag =
             * registerflag.replace("&lt;", "<"); registerflag = registerflag.substring(registerflag.indexOf("<return>"
             * )+8,registerflag.indexOf("</return>")); json = "0"; }else{ //用户存在 json = "1"; }
             */
        } catch (IOException e) {
            json = "1";
            e.printStackTrace();
        }

    }

    /**
     * 
     * 跳转到注册成功的页面获取登陆的信息<br>
     * 
     * @author 文东 <br>
     *         2014-3-31
     * @update
     * @param
     * @return
     * @exception/throws
     * @see UserAction#regSucessful()
     * @since
     */
    public String regSucessful() {
        request.setAttribute("frmUser", getFrmUser());
        return "regSucessful";
    }

    public void email() {
        userFacade.email(userData);
    }

    /**
     * 
     * 检查用户，返回id<br>
     * 
     * @author 侯杨 <br>
     *         2014-6-18
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void checkUserId() {
        userData = userFacade.ajaxCheckUser(userData);
        if (userData != null) {
            json = userData.getId();
        } else {
            json = "1";
        }
    }

    /**
     * 
     * 找回密码发邮件跳转页面<br>
     * 
     * @author 侯杨<br>
     *         2014-6-18
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String topFindPwdSu() {
        request.setAttribute("userLogName", userData.getLoginMail());
        return "sucPwd";
    }

    /**
     * 
     * 跳转到修改登陆账号页面<br>
     * 将登陆账号传给修改页面
     * 
     * @author 文东 <br>
     *         2014年9月9日
     * @update
     * @param
     * @return String 类型的变量 用于struts2 接受返回值跳转页面
     * @exception/throws
     * @see UserAction#toEditLoginAccount()
     * @since vmaque1.5
     */
    public String toEditLoginAccount() {
        // 获取当前用户的登陆账号。并通过request传给前台
        request.setAttribute("userLogAccount", getFrmUser().etipUserEmail);
        // 控制左侧菜单样式 为7 时表示 用户选择的是账号管理
        request.setAttribute("menuNum", 7);
        return "toEditLoginAccount";
    }

    /**
     * 
     * 修改用户的登陆账号<br>
     * 
     * 
     * @author 文东 <br>
     *         2014年9月10日
     * @update
     * @param
     * @return isOk 返回给前台ajax，做业务逻辑处理
     * @exception/throws
     * @see UserAction#editLoginAccount()
     * @since vmaque1.5
     */
    public void ajaxEditLoginAccount() {
        // 获取当前登陆用户的登陆账号
        String loginAccount = getFrmUser().etipUserEmail;
        String isOk = userFacade.editLoginAccount(userData, loginAccount);
        json = isOk;
    }

    /**
     * 
     * 跳转到修改密码页面<br>
     * 
     * @author 文东<br>
     *         2014年9月10日
     * @update
     * @param
     * @return 返回String 类型的变量用于struts2接收后跳转页面
     * @exception/throws
     * @see UserAction#toEditPwd()
     * @since vmaque1.5
     */
    public String toEditPwd() {
        // 控制左侧菜单样式 为7 时表示 用户选择的是账号管理
        request.setAttribute("menuNum", 7);
        return "toEditPwd";
    }

    /**
     * 
     * 跳转到修改收款账号页面<br>
     * 
     * @author 文东<br>
     *         2014年9月10日
     * @update
     * @param
     * @return 返回String 类型的变量用于struts2接收后跳转页面
     * @exception/throws
     * @see UserAction#toEditReceivableAccount()
     * @since vmaque1.5
     */
    public String toEditReceivableAccount() {
        // 获取当前登陆账号id
        String userId = getFrmUser().etipUserID;
        // 获取用户收款信息
        userData = userFacade.searchUserInfoById(userId);
        // 控制左侧菜单样式 为7 时表示 用户选择的是账号管理
        request.setAttribute("menuNum", 7);
        return "toEditReceivableAccount";
    }

    /**
     * 
     * ajax的方式修改用户收款账号<br>
     * 
     * @author 文东 <br>
     *         2014年9月10日
     * @update
     * @param
     * @return json 将是否修改成功的信息已json的方式传到前台
     * @exception/throws
     * @see UserAction#ajaxEditReceivableAccount()
     * @since vmaque1.5
     */
    public void ajaxEditReceivableAccount() {
        // 获取当前登陆用户的id
        String userId = getFrmUser().etipUserID;
        userData.setId(userId);
        userData.setAccountType(0);
        // 修改收款账号
        String isOk = userFacade.editReceivableAccount(userData);
        json = isOk;
    }
    /**
     * 
     *创建page过程中   选择购买服务  查询收款账号信息<br>
     * 
     * @author 侯杨 <br> 
     *		   2014-11-5
     * @param [参数1]     [参数1说明]
     * @return  json  1:没有查询到   ；账号信息
     * @see  UserAction#ajaxgetUserreceivableAccount()
     * @since vmaque1.7
     */
    public void ajaxgetUserreceivableAccount(){
        // 获取当前登陆账号id
        String userId = getFrmUser().etipUserID;
        // 获取用户收款信息
        userData = userFacade.searchUserInfoById(userId);
          if(userData.getReceivableAccount()!="" && !"".equals(userData.getReceivableAccount())){
              json=userData.getReceivableAccount();
          }else{
              json="1";
          }
    }
    

    /*************************************************************/

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public String[] getUserRoleS() {
        return userRoleS;
    }

    public void setUserRoleS(String[] userRoleS) {
        this.userRoleS = userRoleS;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<RoleData> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleData> roleList) {
        this.roleList = roleList;
    }

    public List<OrgData> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrgData> orgList) {
        this.orgList = orgList;
    }
}
