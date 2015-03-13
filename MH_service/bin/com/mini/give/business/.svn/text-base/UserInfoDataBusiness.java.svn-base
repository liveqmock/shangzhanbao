package com.mini.give.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.give.data.UserInfoData;
import com.mini.give.persistence.IUserInfoDataPersistence;
/**
 * 发布权限管理业务接口实现类
 * 
 * @author 林海鹏
 * @see UserInfoDataBusiness
 * @since
 */
@Component("userInfoDataBusiness")
public class UserInfoDataBusiness extends FrmBusiness implements IUserInfoDataBusiness {
	@Resource(name="userInfoDataPersistence")
	IUserInfoDataPersistence userInfoDataPersistence;
	
	public void setUserInfoDataPersistence(
			IUserInfoDataPersistence userInfoDataPersistence) {
		this.userInfoDataPersistence = userInfoDataPersistence;
	}

	@Override
	public void addUserInfo(UserInfoData data) {
		// TODO Auto-generated method stub
		userInfoDataPersistence.add(data);
	}

	@Override
	public void deleteUserInfo(String[] ids) {
		// TODO Auto-generated method stub
		userInfoDataPersistence.delete(ids);
	}

	@Override
	public void editUserInfo(UserInfoData data) {
		// TODO Auto-generated method stub
		userInfoDataPersistence.editUserInfo(data);
	}

	@Override
	public List<UserInfoData> getUserInfoData(JSONObject json) {
		// TODO Auto-generated method stub
		return userInfoDataPersistence.getUserInfoData(json);
	}


	@Override
	public List<UserInfoData> getUserInfo(JSONObject json) {
		// TODO Auto-generated method stub
		return userInfoDataPersistence.getUserInfo(json);
	}

	@Override
	public void updateUserInfo(JSONObject json) {
		// TODO Auto-generated method stub
		userInfoDataPersistence.updateUserInfo(json);
	}

    @Override
    public List<UserInfoData> getUserInfoData(UserInfoData userInfoData) {
        return userInfoDataPersistence.getUserInfoData(userInfoData);
    }

    @Override
    public void updateUserInfo(UserInfoData userInfoData) {
        userInfoDataPersistence.updateUserInfo(userInfoData);
        
    }

}
