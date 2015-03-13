package com.mini.give.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.mini.give.data.UserInfoData;

/**
 * 发布权限管理服务接口
 * 
 * @author 林海鹏
 * @see IUserInfoDataService
 * @since
 */
public interface IUserInfoDataService extends IService {
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
    public List<UserInfoData> getUserInfo(JSONObject json);

    /**
     * 子查询更新语句,在确认赠送，与暂存赠送的位置 调用
     */
    public void updateUserInfo(JSONObject json);

    /**
     * 
     * 根据条件查询用户所拥有的权限信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param userInfoData 用户权限信息 存放条件查询的参数
     * @return List<UserInfoData> 根据条件查询得到权限信息对象的集合
     * @exception/throws
     * @see IUserInfoDataService#getUserInfoData(UserInfoData)
     * @since
     */
    public List<UserInfoData> getUserInfoData(UserInfoData userInfoData);

    /**
     * 
     * 更新用户拥有的权限信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param userInfoData 用户所拥有的权限信息对象
     * @return void
     * @exception/throws
     * @see IUserInfoDataService#updateUserInfo(UserInfoData)
     * @since
     */
    public void updateUserInfo(UserInfoData userInfoData);
}
