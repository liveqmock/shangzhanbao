package com.mini.clientManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.clientManage.business.IClientManageBusiness;
import com.sys.user.data.UserData;

/**
 * 客户管理服务接口实现类
 * 
 * @author 文东
 * @see ClientManageService
 * @since
 */
@Component("clientManageService")
public class ClientManageService extends FrmService implements IClientManageService {

    // 客户信息管理业务接口 容器注入
    @Resource(name = "clientManageBusiness")
    private IClientManageBusiness clientManageBusiness;

    @Override
    public void addClient(UserData userData) {
        clientManageBusiness.addClient(userData);
    }

    @Override
    public List<UserData> searchAllClient(PageRoll pageRoll, UserData userData,String type,Integer sort) {
        // 设置每页显示数量
        pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
        // 查询所有客户信息
        List<UserData> userDatas = clientManageBusiness.searchAllClient(pageRoll, userData,type, sort);
        return userDatas;
    }

    @Override
    public void ajaxDelClient(String[] clientIds) {
        // 删除客户信息
        clientManageBusiness.delClient(clientIds);
    }

    @Override
    public UserData searchClient(UserData userData) {
        // 查询客户信息
        UserData data = clientManageBusiness.searchClient(userData);
        return data;
    }

    @Override
    public void editClient(UserData userData) {
        // 修改客户信息
        clientManageBusiness.editClient(userData);
    }
    /**
     * 
     * 根据用户id查询用户对象实体<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-23
     * @update 
     * @param UserData userData
     * @return  UserData
     */
    public UserData findUserDataById(UserData userData){
        return clientManageBusiness.findUserDataById(userData);
    }

}
