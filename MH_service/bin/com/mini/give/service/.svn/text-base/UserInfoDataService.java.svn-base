package com.mini.give.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmService;
import com.mini.give.business.IUserInfoDataBusiness;
import com.mini.give.data.UserInfoData;

/**
 * 发布权限管理服务接口实现类
 * 
 * @author 林海鹏
 * @see UserInfoDataService
 * @since
 */
@Component("userInfoDataService")
public class UserInfoDataService extends FrmService implements IUserInfoDataService {

    @Resource(name = "userInfoDataBusiness")
    private IUserInfoDataBusiness userInfoDataBusiness;

    public void setUserInfoDataBusiness(IUserInfoDataBusiness userInfoDataBusiness) {
        this.userInfoDataBusiness = userInfoDataBusiness;
    }

    @Override
    public void addUserInfo(UserInfoData data) {
        userInfoDataBusiness.addUserInfo(data);
    }

    @Override
    public void deleteUserInfo(String[] ids) {
        userInfoDataBusiness.deleteUserInfo(ids);
    }

    @Override
    public void editUserInfo(UserInfoData data) {
        userInfoDataBusiness.editUserInfo(data);
    }

    @Override
    public List<UserInfoData> getUserInfoData(JSONObject json) {
        return userInfoDataBusiness.getUserInfoData(json);
    }

    @Override
    public List<UserInfoData> getUserInfo(JSONObject json) {
        return userInfoDataBusiness.getUserInfo(json);
    }

    @Override
    public void updateUserInfo(JSONObject json) {
        userInfoDataBusiness.updateUserInfo(json);
    }

    @Override
    public List<UserInfoData> getUserInfoData(UserInfoData userInfoData) {
        return userInfoDataBusiness.getUserInfoData(userInfoData);
    }

    @Override
    public void updateUserInfo(UserInfoData userInfoData) {
        userInfoDataBusiness.updateUserInfo(userInfoData);

    }

}
