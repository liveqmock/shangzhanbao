package com.mini.tempmanage.persistence;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.tempmanage.data.UserOwnTempData;

public interface IUserOwnTempPersistence extends IBasePersistence<UserOwnTempData> {

	
	public UserOwnTempData getUserOwnTempDataByUserIdOrTempId(String userid,String tempid);
	
}
