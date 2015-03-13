package com.itour.etip.common.util;

import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.util.DistributorBrandUtil;

/**
 * 会员数据校验工具类，可以校验不同的内容，比如说：
 * 
 * @手机账号是否唯一
 * @邮件账号是否重复
 * @登录账号是否重复
 * @卡号是否重复
 * @UserBase中mobile是否重复 =================================
 * @author lishan
 * 
 */
public class AccountValidateTool {

	/**
	 * cc校验方法
	 * 检查组织会员的手机唯一性，从GroupBase中查找 因为组织会员手机号不作为登录账号，所以不再EtipAccount中查找
	 * @param mobel
	 * @return
	 */
	public static String checkOnly(String tableName, String fieldName,
			String fieldValue, String brandCode) {
		// 检查某个表中的值是否存在
		StringBuffer itour = new StringBuffer();
		List<String> brand1 = DistributorBrandUtil.getSonBrandCode("itour");
		for(String it : brand1){
			itour.append(",");
			itour.append(it);
		}
		itour.append(",");

		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		
		if(tableName.equalsIgnoreCase("EtipAccount") && itour.toString().indexOf("," + brandCode + ",") == -1){
			StringBuffer sb = new StringBuffer();
			sb.append("select id from userbase where (mobile='");
			sb.append(fieldValue);
			sb.append("' or email='");
			sb.append(fieldValue);
			sb.append("')");
			List<String> brandCodes = DistributorBrandUtil.getTopAllSonBrandCode(brandCode);
			if(brandCodes != null){
				sb.append(" and (1=2");
				for(String item : brandCodes){
					sb.append(" or brandCode='" + item + "'");
				}
				sb.append(")");
			}
			List<ETIPResultSet> rv = dao.queryForList(sb.toString(), null);
			if(rv.size() == 0){
				return "{success:true,rvsize:" + rv.size() + "}";
			}
			return "{success:true,rvsize:" + rv.size() + ",error:'被个体会员占用'}";
			
		}else{
			StringBuffer sql = new StringBuffer();
			sql.append("select " + fieldName);
			if(tableName.equalsIgnoreCase("EtipAccount")){
				sql.append(",etipuserid");
			}
			sql.append(" from " + tableName);
			sql.append(" where " + fieldName);
			sql.append(" ='" + fieldValue + "'");
	//		if (brandCode != null && !brandCode.equals("")) {
	//			sql.append(" and brandCode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
	//		}
			// 以下执行sql,检查是否有值
			List<ETIPResultSet> rv = dao.queryForList(sql.toString(), null);
			if(tableName.equalsIgnoreCase("EtipAccount") && rv.size() > 0){
				sql = new StringBuffer();
				sql.append("select usertype from etipuser where id='");
				sql.append(rv.get(0).getString("ETIPUSERID"));
				sql.append("'");
				rv = dao.queryForList(sql.toString(), null);
				if(rv.size() == 0){
					return "{success:true,rvsize:" + rv.size() + "}";
				}
				int type = rv.get(0).getInt("USERTYPE");
				if(type == 1){
					return "{success:true,rvsize:" + rv.size() + ",error:'被个体会员占用'}";
				}else if(type == 2){
					return "{success:true,rvsize:" + rv.size() + ",error:'被组织会员占用'}";
				}else if(type == 3){
					return "{success:true,rvsize:" + rv.size() + ",error:'被操作员占用'}";
				}else{
					return "{success:true,rvsize:" + rv.size() + "}";
				}
			}
			return "{success:true,rvsize:" + rv.size() + "}";
		}
	}

	/**
	 * 检查组织会员的手机唯一性，从GroupBase中查找 因为组织会员手机号不作为登录账号，所以不再EtipAccount中查找
	 * 
	 * @param mobel
	 * @return
	 */
	public static boolean checkGroupMobileCanBeUsed(String mobile,
			String etipUserID, String brandCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select id from groupbase where phone='" + mobile
				+ "'");
//		sb.append(" and brandcode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
		if (etipUserID != null) {
			sb.append(" and userid<>'" + etipUserID + "'");
		}

		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");

		String sql = sb.toString();
		List rv = jdbc.queryForList(sql, null);

		if (rv == null || rv.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 校验该中文名称是否与根织中文名称是否重复
	 * 
	 * @param chineseName
	 * @return true 不重复 false 重复
	 */
	public static boolean checkGroupChineseNameCanBeUsed(String chineseName,
			String groupBaseId, String brandCode) {
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		StringBuffer sql = new StringBuffer();
		sql.append("select chinesename from groupbase where chinesename ='");
		sql.append(chineseName);
		sql.append("' and id not in (select mygroupid from subgroup where parentgroupid is not null)");
//		sql.append(" and brandcode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
		if (groupBaseId != null && !groupBaseId.equals("")) {
			sql.append(" and id <> '" + groupBaseId + "'");
		}
		List<ETIPResultSet> result = jdbc.queryForList(sql.toString(), null);
		if (result.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 检查支付代码是否唯一，目前用不倒
	 * 
	 * @param bankCode
	 * @param paymentWayID
	 * @return false 不唯一 true 唯一
	 */
	private static boolean checkbankCodeCanBeUsed(String bankCode,
			String paymentWayID, String brandCode) {
		StringBuffer hql = new StringBuffer();
		hql.append("select id from UserPaymentWay where bankCode='");
		hql.append(bankCode);
		hql.append("'");
		if (paymentWayID.length() == 32) {
			hql.append(" and id<>'" + paymentWayID + "'");
		}
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List rv = jdbc.queryForList(hql.toString(), null);
		if (rv == null || rv.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检验操作员account(用户名，电话，邮箱)是否占用
	 * 
	 * @param account
	 *            用户名，电话，邮箱
	 * @param etipUserID
	 *            etipUser的id，可以为空 如果etipUserID不等于空，并且长度大于0，那么要加上这个条件
	 *            一般在修改的时候etipUserID会不等于空
	 * @return true 不重复 false 重复
	 */
	public static void checkOperatorAccountCanBeUsed(String account,
			String etipOperatorId, String brandCode) {

		StringBuffer sb = new StringBuffer();
		sb.append("select etipuserid from EtipAccount  where 1=1 and account='" + account + "'");
//		sb.append(" and brandcode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
		sb.append(" and etipuserid not in (select id from etipuser where memberid='" + etipOperatorId + "')");
		// 此处调用jdbc来完成
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rv = jdbc.queryForList(sb.toString(), null);

		if (rv != null && rv.size() != 0) {
			sb = new StringBuffer();
			sb.append("select usertype from etipuser where id='");
			sb.append(rv.get(0).getString("ETIPUSERID"));
			sb.append("'");
			rv = jdbc.queryForList(sb.toString(), null);
			if(rv.size() == 0){
				new ETIPException("UsedError");
			}
			int type = rv.get(0).getInt("USERTYPE");
			if(type == 1){
				new ETIPException("UserUsed");
			}else if(type == 2){
				new ETIPException("GroupUsed");
			}else if(type == 3){
				new ETIPException("OperatorUsed");
			}else{
				new ETIPException("UsedError");
			}
		}
	}

	/**
	 * 检验个体会员account(用户名，电话，邮箱)是否占用
	 * 
	 * @param account
	 *            用户名，电话，邮箱
	 * @param etipUserID
	 *            etipUser的id，可以为空 如果etipUserID不等于空，并且长度大于0，那么要加上这个条件
	 *            一般在修改的时候etipUserID会不等于空
	 * @return true 不重复 false 重复
	 */
	public static void checkAccountCanBeUsed(String account,
			String etipUserID, String brandCode) {

		StringBuffer sb = new StringBuffer();
		sb.append("select etipuserid from EtipAccount  where 1=1 and account='" + account + "'");
//		sb.append(" and brandcode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
		if (etipUserID != null && etipUserID.length() > 0) {
			sb.append(" and etipUserID<>'" + etipUserID + "'");
		}
		// 此处调用jdbc来完成
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rv = jdbc.queryForList(sb.toString(), null);

		if (rv != null && rv.size() != 0) {
			sb = new StringBuffer();
			sb.append("select usertype from etipuser where id='");
			sb.append(rv.get(0).getString("ETIPUSERID"));
			sb.append("'");
			rv = jdbc.queryForList(sb.toString(), null);
			if(rv.size() == 0){
				throw new ETIPException("UsedError");
			}
			int type = rv.get(0).getInt("USERTYPE");
			if(type == 1){
				throw new ETIPException("UserUsed");
			}else if(type == 2){
				throw new ETIPException("GroupUsed");
			}else if(type == 3){
				throw new ETIPException("OperatorUsed");
			}else{
				throw new ETIPException("UsedError");
			}
		}
	}

	/**
	 * 校验指定的账号类型是否存在
	 * 
	 * @param loginName
	 * @param etipUserID
	 * @return
	 */
//	public static boolean checkAccountExist(String account, String etipUserID,
//			Integer accountType, String brandCode) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select id from EtipAccount where 1=1 and brandcode in (select brandcode from distributorbrand where code like (select substr(code,0,3)||'%' from distributorbrand where brandcode='"+brandCode+"'))");
//		if (etipUserID != null && etipUserID.length() > 0) {
//			sb.append(" and etipUserID<>'" + etipUserID + "'");
//		}
//		sb.append(" and account='" + account + "'");
//		if (accountType != null && accountType <= 4 && accountType >= 1) {
//			sb.append(" and accountType=" + accountType);
//		}
//		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
//		List rv = jdbc.queryForList(sb.toString(), null);
//		if (rv == null || rv.size() == 0) {
//			return false;
//		} else {
//			return true;
//		}
//	}

	/**
	 * 判断会员账号里存不存在以该联系电话登陆的账号
	 * 
	 * @param Mobile
	 *            联系电话
	 * @return false为不存在，true为存在
	 */
	public static void checkLoginMobileCanBeUsed(String mobile, String brandCode) {
		AccountValidateTool.checkAccountCanBeUsed(mobile, null, brandCode);
	}

	/**
	 * 判断会员账号里存不存在以该邮箱登陆的账号
	 * 
	 * @param email
	 *            邮箱
	 * @return false为不存在，true为存在
	 */
	public static void checkLoginEmailCanBeUsed(String email, String brandCode) {
		AccountValidateTool.checkAccountCanBeUsed(email, null, brandCode);
	}

	/**
	 * 判断会员账号里存不存在以该邮箱登陆的账号
	 * 
	 * @param email
	 *            邮箱
	 * @return false为不存在，true为存在
	 */
	public static void checkLoginNameCanBeUsed(String loginName, String brandCode) {
		AccountValidateTool.checkAccountCanBeUsed(loginName, null, brandCode);
	}

}
