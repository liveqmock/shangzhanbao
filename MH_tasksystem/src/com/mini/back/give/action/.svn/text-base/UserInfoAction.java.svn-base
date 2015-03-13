package com.mini.back.give.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.give.data.UserInfoData;
import com.mini.give.persistence.IUserInfoDataPersistence;

@ResultPath("/")
@Results({
	@Result(name="statistics",location="/view/pages/mini/back/give/countPrivilege.jsp")
})
public class UserInfoAction extends FrmAction{
	@Resource(name="userInfoDataPersistence")
	private IUserInfoDataPersistence userInfoDataPersistence;
	List<UserInfoData> userInfoList;
	
	/**
	 * 统计发布权限管理的各种权限值	
	 * @return
	 */
	public String statistics() {
		String starttime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		// 当时间未从前台传递过来的时候，，即属于没有带条件的 默认查询
		if (null == starttime || null == endTime || "null".equals(starttime)
				|| "null".equals(endTime)) {
			starttime = "";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			endTime = df.format(new Date());
		}									//等待表确认后台，，在执行修改
		String json = null;
		JSONObject jObject = JSONObject.fromObject(json);
		userInfoList = userInfoDataPersistence.getUserInfoData(jObject);
		return "statistics";
	}
	
	

	public List<UserInfoData> getUserInfoList() {
		return userInfoList;
	}


	public void setUserInfoList(List<UserInfoData> userInfoList) {
		this.userInfoList = userInfoList;
	}


	public IUserInfoDataPersistence getUserInfoDataPersistence() {
		return userInfoDataPersistence;
	}

	public void setUserInfoDataPersistence(
			IUserInfoDataPersistence userInfoDataPersistence) {
		this.userInfoDataPersistence = userInfoDataPersistence;
	}
}
