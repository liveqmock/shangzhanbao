package com.mini.clientManage.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.user.data.UserData;

/**
 * 客户管理服务接口
 * 
 * @author 文东
 * @see IClientManageService
 * @since
 */
public interface IClientManageService extends IService {

    /**
     * 
     * 添加客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-14
     * @update
     * @param clientData 客户实体
     * @return void
     * @exception/throws
     * @see IClientManageService#addClient(userData)
     * @since
     */
    public void addClient(UserData userData);

    /**
     * 
     * 查询所有客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param pageRoll 分页参数
     * @param userData 客户实体对象 存放条件查询参数
     * @return List<UserData> 客户集合
     * @exception/throws
     * @see IClientManageService#searchAllClient(PageRoll, UserData)
     * @since
     */
    public List<UserData> searchAllClient(PageRoll pageRoll, UserData userData,String type,Integer sort);

    /**
     * 
     * 根据客户ID删除客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param clientIds 客户ID集合
     * @return
     * @exception/throws
     * @see IClientManageService#ajaxDelClient(String[])
     * @since
     */
    public void ajaxDelClient(String[] clientIds);

    /**
     * 
     * 根据条件查询客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param userData 存放条件查询参数
     * @return UserData 客户信息实体对象
     * @exception/throws
     * @see IClientManageService#searchClient(UserData)
     * @since
     */
    public UserData searchClient(UserData userData);

    /**
     * 
     * 修改客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-25
     * @update
     * @param userData 客户信息对象 存放修改参数
     * @return void
     * @exception/throws
     * @see IClientManageService#editClient(UserData)
     * @since
     */
    public void editClient(UserData userData);
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
    public UserData findUserDataById(UserData userData);
}
