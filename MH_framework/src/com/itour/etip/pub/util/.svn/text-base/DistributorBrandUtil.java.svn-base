package com.itour.etip.pub.util;

import java.util.ArrayList;
import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

public class DistributorBrandUtil {

	/**
	 * 返回当前品牌父品牌名+当前品牌名
	 * @param brandCode
	 * @return
	 */
	public static String getParentBrandNameAndcurrentlyBrandName(String brandCode){
		if(brandCode == null || brandCode.isEmpty()){
			return null;
		}
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList("select name,code from distributorbrand where brandcode='"+brandCode+"'", null);
		if(rs.size() == 0){
			return null;
		}
		String code = rs.get(0).getString("CODE");
		if(code.length() == 3){
			return rs.get(0).getString("NAME");
		}else if(code.length() > 3){
			code = code.substring(0,3);
		}
		String name = rs.get(0).getString("NAME");
		
		rs = jdbc.queryForList("select name from distributorbrand where code='" + code + "'", null);
		
		name = rs.get(0).getString("NAME") + "-" + name;
		return name;
	}
	
	/**
	 * 返回当前品牌名
	 * @param brandCode
	 * @return
	 */
	public static String getBrandName(String brandCode){
		if(brandCode == null || brandCode.isEmpty()){
			return null;
		}
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList("select name from distributorbrand where brandcode='"+brandCode+"'", null);
		if(rs.size() == 0){
			return null;
		}
		return rs.get(0).getString("NAME");
	}
	/**
	 * 返回当前品牌顶层父品牌名下所有子品牌的brandCode
	 * @param brandCode
	 * @return
	 */
	public static List<String> getTopAllSonBrandCode(String brandCode){
		if(brandCode == null || brandCode.isEmpty()){
			return null;
		}
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList("select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"')", null);
		if(rs.size() == 0){
			return null;
		}
		List<String> brandCodes = new ArrayList<String>();
		for(ETIPResultSet item : rs){
			brandCodes.add(item.getString("BRANDCODE"));
		}
		return brandCodes;
	}
	/**
	 * 返回当前品牌brandCode+当前所有子品牌brandCode
	 * @param brandCode
	 * @return
	 */
	public static List<String> getSonBrandCode(String brandCode){
		if(brandCode == null || brandCode.isEmpty()){
			return null;
		}
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList("select code from distributorbrand where brandcode='"+brandCode+"'", null);
		if(rs.size() == 0){
			return null;
		}
		String code = rs.get(0).getString("CODE");
//		if(code.length() > 3){
//			code = code.substring(0, code.length() - 3);
//		}
		rs = jdbc.queryForList("select brandCode from distributorbrand where code like '" + code + "%'", null);
		List<String> brandCodes = new ArrayList<String>();
		for(ETIPResultSet item : rs){
			brandCodes.add(item.getString("BRANDCODE"));
		}
		return brandCodes;
	}
}
