package com.mini.give.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.give.data.UserInfoData;
/**
 * 发布权管理久化层接口
 * 
 * @author     林海鹏
 * @see        IUserInfoDataPersistence
 * @since      
 */
public interface IUserInfoDataPersistence extends IBasePersistence<UserInfoData> {
	 /**
     * 新增用户信息
     */
    public void addUserInfo(UserInfoData data);
    /**
     * 删除用户信息
     */
    public void deleteUserInfo(String[] ids);
    /**
     * 编辑用户信息
     */
    public void editUserInfo(UserInfoData data);
    /**
     * 根据条件获取对象信息
     */
    public List<UserInfoData> getUserInfoData(JSONObject json);
    /**
     * 根据条件查询对象
     */
    public  List<UserInfoData> getUserInfo(JSONObject json);
    /**
     * 子查询更新语句,在确认赠送，与暂存赠送的位置 调用
     */
    public  void updateUserInfo(JSONObject json);
    /**
     * 
     * 根据条件查询,获取用户所拥有的权限信息集合<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param userInfoData 用户所拥有的权限信息对象 存放查询条件
     * @return List<UserInfoData> 返回得到的查询结果
     * @exception/throws
     * @see IUserInfoDataPersistence#getUserInfoData(UserInfoData)
     * @since
     */
    public List<UserInfoData> getUserInfoData(UserInfoData userInfoData);
    
    /**
     * 
     * 根据用户所拥有的权限信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param userInfoData 用户权限信息
     * @return void
     * @exception/throws
     * @see IUserInfoDataPersistence#updateUserInfo(UserInfoData)
     * @since [起始版本]
     */
    public void updateUserInfo(UserInfoData userInfoData);
   
}
