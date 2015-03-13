package com.mini.back.clientManage.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.clientManage.service.IClientManageService;
import com.sys.user.data.UserData;

/**
 * 客户管理facade层
 * 
 * @author 文东
 * @see ClientManageFacade
 * @since
 * 
 */
@Component("clientManageFacade")
public class ClientManageFacade extends FrmFacade {

    // 客户管理服务接口 容器注入
    @Resource(name = "clientManageService")
    private IClientManageService clientManageService;

    /**
     * ajax添加客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-14
     * @update
     * @param clientData客户实体
     * @return void
     * @exception/throws
     * @see ClientManageFacade#ajaxAddClient()
     * @since
     */
    public void ajaxAddClient(UserData userData) {
        clientManageService.addClient(userData);
    }

    /**
     * 
     * 查询所有客户<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param pageRoll 分页参数
     * @param userData 用户实体对象 存放条件查询的参数
     * @return List<UserData> 查询到的客户集合
     * @exception/throws
     * @see ClientManageFacade#searchAllClient(PageRoll, UserData)
     * @since
     */
    public List<UserData> searchAllClient(PageRoll pageRoll, UserData userData,String type,Integer sort) {
        // 查询所有客户
        List<UserData> userDatas = clientManageService.searchAllClient(pageRoll, userData,type,sort);
        return userDatas;
    }

    /**
     * 
     * 删除客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param clientIds 客户ID集合
     * @return
     * @exception/throws
     * @see ClientManageFacade#ajaxDelClient(String[])
     * @since
     */
    public void ajaxDelClient(String[] clientIds) {
        clientManageService.ajaxDelClient(clientIds);
    }

    /**
     * 
     * 根据ID查询客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param userData 用户实体对象 存放条件查询的参数
     * @return UserData 客户详细信息
     * @exception/throws
     * @see ClientManageFacade#searchClientById(UserData)
     * @since
     */
    public UserData searchClientById(UserData userData) {
        UserData data = clientManageService.searchClient(userData);
        return data;
    }

    /**
     * 
     * 修改客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-25
     * @update
     * @param userData 客户实体对象  存放修改参数
     * @return
     * @exception/throws
     * @see ClientManageFacade#ajaxEditClient(UserData)
     * @since
     */
    public void ajaxEditClient(UserData userData) {
        // 修改客户信息
        clientManageService.editClient(userData);
    }
    /**
     * 
     * 根据用户id查询用户对象实体<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-5-23
     * @update 
     * @param UserData userData
     * @return  UserData
     */
    public UserData findUserDataById(UserData userData){
        return clientManageService.findUserDataById(userData);
    }
}
