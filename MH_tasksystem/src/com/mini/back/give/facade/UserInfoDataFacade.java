package com.mini.back.give.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.give.data.UserInfoData;
import com.mini.give.service.IUserInfoDataService;

/**
 * 发布权限管理管理facade层
 * 
 * @author 林海鹏
 * @see UserInfoDataFacade
 * @since
 * 
 */
@Component("userInfoDataFacade")
public class UserInfoDataFacade extends FrmFacade {
    @Resource(name = "userInfoDataService")
    private IUserInfoDataService userInfoDataService;

    public void setUserInfoDataService(IUserInfoDataService userInfoDataService) {
        this.userInfoDataService = userInfoDataService;
    }

    public void addUserInfo(UserInfoData data) {
        // TODO Auto-generated method stub
        userInfoDataService.addUserInfo(data);
    }

    public void deleteUserInfo(String[] ids) {
        // TODO Auto-generated method stub
        userInfoDataService.deleteUserInfo(ids);
    }

    public void editUserInfo(UserInfoData data) {
        // TODO Auto-generated method stub
        userInfoDataService.editUserInfo(data);
    }

    public List<UserInfoData> getUserInfoData(JSONObject json) {
        // TODO Auto-generated method stub
        return userInfoDataService.getUserInfoData(json);
    }

    public List<UserInfoData> getUserInfo(JSONObject json) {
        // TODO Auto-generated method stub
        return userInfoDataService.getUserInfo(json);
    }

    public void updateUserInfo(JSONObject json) {
        // TODO Auto-generated method stub
        userInfoDataService.updateUserInfo(json);
    }

    /**
     * 
     * 根据用户ID查询用户所拥有的权限信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param etipUserID 当前登录用户的ID
     * @return 查询的到的权限信息
     * @exception/throws
     * @see UserInfoDataFacade#getUserInfoData(String)
     * @since
     */
    public UserInfoData getUserInfoData(String etipUserID) {
        UserInfoData userInfoData = new UserInfoData();
        userInfoData.setUserId(etipUserID);
        List<UserInfoData> infoDatas = userInfoDataService.getUserInfoData(userInfoData);
        if(infoDatas.size() > 0){
            return infoDatas.get(0);
        }
        return null;
    }

    /**
     * 
     * 更新用户所拥有的权限信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-13
     * @update
     * @param userInfoData 需要更新的用户权限信息
     * @return void
     * @exception/throws
     * @see UserInfoDataFacade#updateUserInfo(UserInfoData)
     * @since
     */
    public void updateUserInfo(UserInfoData userInfoData) {
        userInfoDataService.updateUserInfo(userInfoData);
    }
}
