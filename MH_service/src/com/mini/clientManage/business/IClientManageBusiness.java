package com.mini.clientManage.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.user.data.UserData;

/**
 * 客户管理业务接口
 * 
 * @author 文东
 * @see IClientManageBusiness
 * @since
 */
public interface IClientManageBusiness extends IBusiness {

    /**
     * 
     * 添加客户<br>
     * 
     * @author 文东 <br>
     *         2014-2-14
     * @update
     * @param clientData 客户对象
     * @return void
     * @exception/throws
     * @see IClientManageBusiness#addClient(userData)
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
     * @param userData 用户对象 存放条件查询的参数
     * @return List<UserData> 用户对象集合
     * @exception/throws
     * @see IClientManageBusiness#searchAllClient(PageRoll, UserData)
     * @since
     */
    public List<UserData> searchAllClient(PageRoll pageRoll, UserData userData,String type,Integer sort);

    /**
     * 
     * 删除客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param clientIds 客户ID集合
     * @return void
     * @exception/throws
     * @see IClientManageBusiness#delClient(String[])
     * @since
     */
    public void delClient(String[] clientIds);

    /**
     * 
     * 根据条件查询客户信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-24
     * @update
     * @param userData 存放条件查询的参数
     * @return UserData 客户信息对象
     * @exception/throws
     * @see IClientManageBusiness#searchClient(UserData)
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
     * @param userData 客户实体对象 存放修改信息参数
     * @return void
     * @exception/throws
     * @see IClientManageBusiness#editClient(UserData)
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
