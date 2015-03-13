package com.itour.etip.common.util;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.elong.wsclient.NorthBoundAPIServiceStub;
import com.elong.wsclient.NorthBoundAPIServiceStub.Login;
import com.elong.wsclient.NorthBoundAPIServiceStub.LoginRequest;
import com.elong.wsclient.NorthBoundAPIServiceStub.LoginResponse;
import com.elong.wsclient.NorthBoundAPIServiceStub.LoginResponseE;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;

public class CommonUtil {
	static HibernateDao hd = (HibernateDao) SpringContextHelper
			.getBean("hibernate");

	/**
	 * 取供应商名称
	 * 
	 * @param providerId
	 *            供应商编号
	 * @return
	 */
	public static String getNameByProviderId(String providerId) {
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String sql = "select chineseName n from groupbase where id='"
				+ providerId + "'";
		List<ETIPResultSet> uList = dao.queryForList(sql, null);
		String name = "未知供应商";
		if (uList != null && uList.size() > 0) {
			name = uList.get(0).getString("N");
		}
		return name;
	}

	/**
	 * 取供应商对应酒店的编号和名称
	 * 
	 * @param hotelID
	 *            itour的酒店编号
	 * @param hotelID
	 *            supplier 供应商id
	 * @param condiction
	 *            其它条件
	 * @return map
	 */
	public static Map<String, String> getProviderHotelNameById(String hotelID,
			String supplier, String condiction) {
		if (condiction == null) {
			condiction = "";
		}
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String sql = "select providerCode,providerHotelName from HOTELMAPPING where hotelID='"
				+ hotelID + "' and providerid='" + supplier + "' " + condiction;
		List<ETIPResultSet> uList = dao.queryForList(sql, null);
		Map<String, String> map = new HashMap<String, String>();
		if (uList != null && uList.size() > 0) {
			String providerCode = uList.get(0).getString("PROVIDERCODE");
			String providerHotelName = uList.get(0).getString(
					"PROVIDERHOTELNAME");
			map.put("providerCode", providerCode);
			map.put("providerHotelName", providerHotelName);
		}
		return map;
	}

	/***
	 * 获取映射表的本地酒店编号
	 * 
	 * @param providerHotelId
	 *            供应商酒店编码
	 * @param providerid
	 *            供应商编号
	 * @param condiction
	 *            其他条件
	 * @return
	 */
	public static Map<String, String> getLocalHotelIdByProviderHotelId(
			String providerHotelId, String providerid, String condiction) {
		if (condiction == null) {
			condiction = "";
		}
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String sql = "select hotelID from HOTELMAPPING where providerCode='"
				+ providerHotelId + "' and providerid='" + providerid + "' "
				+ condiction;
		List<ETIPResultSet> uList = dao.queryForList(sql, null);
		Map<String, String> map = new HashMap<String, String>();
		if (uList != null && uList.size() > 0) {
			String hotelID = uList.get(0).getString("HOTELID");
			map.put("hotelID", hotelID);
		}
		return map;
	}

	/**
	 * 取供应商对应房型编号和名称
	 * 
	 * @param roomID
	 *            itour的房型编号
	 * @return map 封装对象
	 */
	public static Map<String, String> getProviderRoomNameById(String roomID,
			String supplier, String condiction) {
		if (condiction == null) {
			condiction = "";
		}
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String sql = "select providerCode,providerRoomName from HOTELROOMINFOMAPPING where roomID='"
				+ roomID + "' and providerid='" + supplier + "' " + condiction;
		List<ETIPResultSet> uList = dao.queryForList(sql, null);
		Map<String, String> map = new HashMap<String, String>();
		if (uList != null && uList.size() > 0) {
			String providerCode = uList.get(0).getString("PROVIDERCODE");
			String providerRoomName = uList.get(0)
					.getString("PROVIDERROOMNAME");
			map.put("providerCode", providerCode);
			map.put("providerRoomName", providerRoomName);
		}
		return map;
	}

	public static String isExistLocalRoomByRoomName(String roomName,
			String hotelId) {
		JdbcDao jd = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String hql = "select id from HotelRoomInfo where roomName='" + roomName
				+ "' and hotelbaseinfoid='" + hotelId + "'";
		List<ETIPResultSet> queryForList = jd.queryForList(hql, null);
		for (ETIPResultSet resultSet : queryForList) {
			return resultSet.getString("ID");
		}
		return null;
	}


	public static LoginResponse elongLogin(
			NorthBoundAPIServiceStub northBoundAPIServiceStub)
			throws RemoteException {
		String elongLoginUserName = CacheUtil.paraCache
				.getParaValue("ELong_OfficeID");
		String elongLoginPassword = CacheUtil.paraCache
				.getParaValue("ELong_Password");
		Login login = new Login();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserName(elongLoginUserName);
		loginRequest.setPassword(elongLoginPassword);
		login.setLoginRequest(loginRequest);
		LoginResponseE loginResponseE = northBoundAPIServiceStub.Login(login);
		LoginResponse loginResponse = loginResponseE.getLoginResult();
		return loginResponse;
	}



}
