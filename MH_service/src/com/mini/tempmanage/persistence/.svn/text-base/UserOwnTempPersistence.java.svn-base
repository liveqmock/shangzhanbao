package com.mini.tempmanage.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.tempmanage.data.UserOwnTempData;


@SuppressWarnings("unchecked")
@Component("userOwnTempPersistence")
public class UserOwnTempPersistence extends BasePersistence<UserOwnTempData> implements
		IUserOwnTempPersistence {
	
	/**
	 * 根据用户id和模板id查询信息
	 */
	public UserOwnTempData getUserOwnTempDataByUserIdOrTempId(String userid,String tempid){
		
		StringBuffer sbf = new StringBuffer("FROM com.mini.tempmanage.data.UserOwnTempData WHERE 1=1 ");
		if(null!=userid && !"".equals(userid)){
			sbf.append("AND userId='").append(userid).append("'");
		}
		if(null!=tempid && !"".equals(tempid)){
			sbf.append(" AND tempId = '").append(tempid).append("'");
		}
		List<UserOwnTempData> list = search(sbf.toString());
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
}
