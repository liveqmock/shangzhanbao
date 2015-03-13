package com.mini.back.clientManage.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.clientManage.facade.ClientManageFacade;
import com.mini.util.SendMail;
import com.sys.user.data.UserData;
import com.util.GressionUtil;
import com.util.mail.MailUtil;

/**
 * 客户管理action
 * 
 * @author 文东
 * @see ClientManageAction
 * @since
 * 
 */
@Results(value = { @Result(name = "list", location = "view/pages/mini/back/clientmanage/showAllClient.jsp"),
        @Result(name = "view", location = "view/pages/mini/back/clientmanage/clientView.jsp") })
public class ClientManageAction extends FrmAction {

    @Resource(name = "clientManageFacade")
    private ClientManageFacade clientManageFacade;

    // 分页参数对象
    private PageRoll pageRoll = new PageRoll();

    // 用户实体对象 与jsp页面交互
    private UserData userData = new UserData();

    // 用户实体对象集合 与jsp页面交互
    private List<UserData> userDatas = new ArrayList<UserData>();
    private String type;
    private String createTimecheckNum;
    private String pageCountcheckNum;
    private String publistCountcheckNum;

    /********************************************************************************************************************************************/

    /**
     * 
     * ajax 添加客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-14
     * @update
     * @param
     * @return void 无返回值
     * @exception/throws Exception 保存数据时出现的异常
     * @see ClientManageAction#ajaxAddClient()
     * @since
     */
    public void ajaxAddClient() {
        // 获取是否让客户自己设置密码
        String setPwd = request.getParameter("setPwd");

        // 定义保存的初始状态为失败
        String status = "fail";
        // 若在保存过程当中没有异常则返回success 表示成功。反之返回fail 表示失败
        try {
            clientManageFacade.ajaxAddClient(userData);

            // 发送邮件
            if (setPwd != null && "true".equals(setPwd)) {
                resetPasswordMail(userData.getId(), userData.getLoginMail());
            } else {
                // 获取当前时间
                long date = new Date().getTime();

                // 组装重置密码地址参数
                String resetUrl = "userid=" + userData.getId() + "&date=" + date;

                // 使用移位加密访问地址参数
                String url = GressionUtil.getString(resetUrl, 5);

                // 调用发送邮件的方法
                Map<String, String> contentMap = new HashMap<String, String>();
                contentMap.put("userName", userData.getUserName());
                contentMap.put("user", userData.getLoginMail());
                contentMap.put("passWord", userData.getPasswordtext());
                contentMap.put("url", url);

                // 调用发送邮件的方法
                new MailUtil(userData.getLoginMail(), contentMap, 3).run();
            }

            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            json = status;
        }
    }

    /**
     * 重置密码，发送邮件
     * 
     * @author 左香勇
     * @update
     */
    public void resetPasswordMail(String userid, String toAddress) {

        // 获取当前时间
        long date = new Date().getTime();

        // 组装重置密码地址参数
        String resetUrl = "userid=" + userid + "&date=" + date;

        // 使用移位加密访问地址参数
        String url = GressionUtil.getString(resetUrl, 5);

        // 调用发送邮件的方法
        Map<String, String> contentMap = new HashMap<String, String>();
        contentMap.put("userName", toAddress);
        contentMap.put("user", toAddress);
        contentMap.put("url", url);

        // 调用发送邮件的方法
        new MailUtil(toAddress, contentMap, 4).run();
    }

    /**
     * 
     * 部分功能下重置密码功能<br>
     * 1：发送成功 0：发送失败 2：此用户啊未用邮箱号注册
     * 
     * @author 冯鑫 <br>
     *         2014-5-23
     * @update
     */
    public void clientManageResertPassword() {
        UserData user = clientManageFacade.findUserDataById(userData);
        // 获取当前时间
        long date = new Date().getTime();

        // 组装重置密码地址参数
        String resetUrl = "userid=" + user.getId() + "&date=" + date;

        // 使用移位加密访问地址参数
        String url = GressionUtil.getString(resetUrl, 5);
        SendMail.checkEmail(user.getLoginMail());
        // 调用发送邮件的方法
        try {
            Map<String, String> contentMap = new HashMap<String, String>();
            contentMap.put("userName", user.getLoginMail());
            contentMap.put("url", url);

            // 调用发送邮件的方法
            new MailUtil(user.getLoginMail(), contentMap, 2).run();
            json = "1";
        } catch (Exception e) {
            e.printStackTrace();
            json = "0";
        }
    }

    /**
     * 
     * 修改客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-17
     * @update
     * @param
     * @return ajaxEditClient
     * @exception/throws
     * @see ClientManageAction#ajaxEditClient()
     * @since
     */
    public void ajaxEditClient() {
        // 定义保存的初始状态为失败
        String status = "fail";
        // 获取前台传来的登录邮箱，密码,id
        String id = request.getParameter("id");
        String loginMail = request.getParameter("loginmail");
        String password = request.getParameter("password");
        userData.setId(id);
        userData.setLoginMail(loginMail);
        userData.setPassWord(password);
        // 若在删除过程当中没有异常则返回success 表示成功。反之返回fail 表示失败
        try {
            clientManageFacade.ajaxEditClient(userData);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            json = status;
        }
    }

    /**
     * 
     * 后台查询所有客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param pageRoll 分页
     * @param userData 用户实体
     * @return list 所有客户页面
     * @exception/throws
     * @see ClientManageAction#searchAllClient()
     * @since
     */
    public String searchAllClient() {
        // 查询所有客户
        int sort = 0;
        if ("pcount".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortpc"));
            if(sort != 0) {
                request.setAttribute("sortpc", 0);
            }else{
                request.setAttribute("sortpc", 1);
            }
        }
        if ("scount".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortsc"));
            if(sort != 0) {
                request.setAttribute("sortsc", 0);
            }else{
                request.setAttribute("sortsc", 1);
            }
        }
        if ("createTime".equals(type)) {
            sort = Integer.parseInt(request.getParameter("sortTime"));
            if(sort != 0) {
                request.setAttribute("sortTime", 0);
            }else{
                request.setAttribute("sortTime", 1);
            }
        }
        userDatas = clientManageFacade.searchAllClient(pageRoll, userData, type,sort);
        return "list";
    }

    /**
     * 
     * ajax删除客户<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see ClientManageAction#ajaxDelClient()
     * @since
     */
    public void ajaxDelClient() {
        // 定义保存的初始状态为失败
        String status = "fail";
        // 获取客户ID集合
        String[] clientIds = request.getParameterValues("clientId");
        // 若在删除过程当中没有异常则返回success 表示成功。反之返回fail 表示失败
        try {
            clientManageFacade.ajaxDelClient(clientIds);
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            json = status;
        }
    }

    /**
     * 
     * 根据ID查询客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param userData 存放条件查询的参数
     * @return 详情页面
     * @exception/throws
     * @see ClientManageAction#searchClientById()
     * @since
     */
    public String searchClientById() {
        // 根据ID查看客户详情
        userData = clientManageFacade.searchClientById(userData);
        return "view";
    }

    /***************************************************************** get/set 方法 ***************************************************************************/

    public PageRoll getPageRoll() {
        return pageRoll;
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

    public List<UserData> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(List<UserData> userDatas) {
        this.userDatas = userDatas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTimecheckNum() {
        return createTimecheckNum;
    }

    public void setCreateTimecheckNum(String createTimecheckNum) {
        this.createTimecheckNum = createTimecheckNum;
    }

    public String getPageCountcheckNum() {
        return pageCountcheckNum;
    }

    public void setPageCountcheckNum(String pageCountcheckNum) {
        this.pageCountcheckNum = pageCountcheckNum;
    }

    public String getPublistCountcheckNum() {
        return publistCountcheckNum;
    }

    public void setPublistCountcheckNum(String publistCountcheckNum) {
        this.publistCountcheckNum = publistCountcheckNum;
    }

}
