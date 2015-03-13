package com.itour.etip.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;

public class CleanMemberUtil {
	private static ApplicationContext ctx;
	private static JdbcDao dao;
	@BeforeClass
	public static void prepareTestData() throws Exception {		
		try{
			if(ctx == null) {
				ctx = new FileSystemXmlApplicationContext(
						new String[]{"WebContent/WEB-INF/configuration/spring/applicationContext-datasource.xml",
							"WebContent/WEB-INF/configuration/spring/applicationContext-connect.xml"
						});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dao = (JdbcDao) ctx.getBean("jdbc");
		//初始化数据
	}
	
	/**
	 * 在类级别上的tearDown方法，在测试用例执行后仅执行一次，用于销毁、
	 * 恢复测试环境。
	 *
	 */
	@AfterClass
	public static void clearUpTestData() {
		System.out.println("=========删除成功=======");
	}
	
	@Test
	public void clean(){
		List<String> id = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append("select id from groupbase where chinesename in ('测试合作伙伴08','测试合作伙伴02','测试合作伙伴09', 'hezuo01'," +
				"'hezuo03','hezuo02','测试合作伙伴03','上海测试02','刘春','中青','联通','李东','到底到底','纵横云南','佛山','禅城','惠希峰1'," +
				"'王中俊','闫盟','测试账号1','祖母的厨房','四川分公司','绅士咖啡','168','绿岛西餐酒廊','test','通汇','的士','物业公司A'," +
				"'派卡合作g公司','ds','出租车公司g','辉记','广州','盛荣','大荣','外滩新城','星美影院','溏心','香。圣伽瑜伽','诗丽堂1'," +
				"'自由空间','K歌迷','jkzt','AMD','CCTV','诗丽堂','百货大楼','中影院','ADDM','K哥王','中山街','江南影院','全套服务桑拿'," +
				"'全套按摩','金阳光','解百商场','玖玖鸭','杜莹','熊丹','金焕娜','商旅通','新鹭洲','张甲','电信派卡','贵州测试','高琴'," +
				"'田亮','西安')");
		List<ETIPResultSet> rs = dao.queryForList(sb.toString(), null);
		if(rs.size() == 0){
			return;
		}else{
			for(ETIPResultSet item : rs){
				id.add(item.getString("ID"));
			}
		}
		Object[] objs = id.toArray();
		String[] ids = new String[objs.length];
		int i = 0;
		for(Object item : objs){
			ids[i++] = item.toString();
		}
		clean(ids,2);
	}
	
	private void clean(String[] baseIds, int userType){
		switch (userType) {
		case 1:
			cleanUser(baseIds);
			break;
		case 2:
		//	cleanGroup(baseIds);
		}
	}
	
	/**
	 * 清理个体会员数据
	 * @param userBaseIds
	 */
	private void cleanUser(String[] userBaseIds){
		int i = 0;
		for(String userBaseId : userBaseIds){
			String etipUserId;
			String userBaseExtId;
			String[] userBizRoleIds;
//			String[] userRoleCardIds;
//			String[] userpaymentIds;
			String[] userCustomerIds;
//			String[] userPreferredHotelIds;
//			String[] userVoucherAddressIds;
//			String[] userPreferenceIds;
//			String[] userCertificateIds;
//			String[] userContactWayIds;
//			String[] userRelationIds;
//			String[] userGroupIds;
//			String[] userPictureIds;
			Map<String,String> map = getEtipUserId(userBaseId);
			if(map == null){
				continue;
			}
			etipUserId = map.get("etipUserId");
			userBaseExtId = map.get("userBaseExtId");
			userBizRoleIds = getUserBizRoleId(userBaseId);
//			Map<String,String[]> maps = getuserPreferenceId(userBaseId);
//			userPreferenceIds = maps.get("userPreferenceIds");
//			userCertificateIds = maps.get("userCertificateIds");
//			userContactWayIds = maps.get("userContactWayIds");
//			userRelationIds = maps.get("userRelationIds");
//			userGroupIds = maps.get("userGroupIds");
//			userPictureIds = maps.get("userPictureIds");
			Map<String,String[]> maps = getCardIdAndPaymentWayId(userBizRoleIds);
//			userRoleCardIds = maps.get("userRoleCardIds");
//			userpaymentIds = maps.get("userpaymentIds");
			userCustomerIds = maps.get("userCustomerIds");
//			userPreferredHotelIds = maps.get("userPreferredHotelIds");
//			userVoucherAddressIds = maps.get("userVoucherAddressIds");
			
			List<String> deleteSqls = new ArrayList<String>();
			if(!etipUserId.equals("")){
				deleteSqls.add("delete from etipaccount where etipuserid='" + etipUserId + "'");
				deleteSqls.add("delete from etipcertificate where etipuserid='" + etipUserId + "'");
			}
			deleteSqls.add("delete from userpreference where userbaseid='" + userBaseId + "'");
//			if(userPreferenceIds != null){
//				for(String item : userPreferenceIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userpreference where id='" + item + "'");
//					}
//				}
//			}
			deleteSqls.add("delete from usercertificate where userbaseid='" + userBaseId + "'");
//			if(userCertificateIds != null){
//				for(String item : userCertificateIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from usercertificate where id='" + item + "'");
//					}
//				}
//			}
			deleteSqls.add("delete from usercontactway where userbaseid='" + userBaseId + "'");
//			if(userContactWayIds != null){
//				for(String item : userContactWayIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from usercontactway where id='" + item + "'");
//					}
//				}
//			}
			deleteSqls.add("delete from userrelation where owneruserid='" + userBaseId + "'");
//			if(userRelationIds != null){
//				for(String item : userRelationIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userrelation where id='" + item + "'");
//					}
//				}
//			}
			deleteSqls.add("delete from usergroup where USERID='" + userBaseId + "'");
//			if(userGroupIds != null){
//				for(String item : userGroupIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from usergroup where id='" + item + "'");
//					}
//				}
//			}
			deleteSqls.add("delete from userpicture where userbaseid='" + userBaseId + "'");
//			if(userPictureIds != null){
//				for(String item : userPictureIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userpicture where id='" + item + "'");
//					}
//				}
//			}
//			if(userPreferredHotelIds != null){
//				for(String item : userPreferredHotelIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userpreferredhotel where id='" + item + "'");
//					}
//				}
//			}
//			if(userVoucherAddressIds != null){
//				for(String item : userVoucherAddressIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from uservoucheraddress where id='" + item + "'");
//					}
//				}
//			}
			if(userCustomerIds != null){
				for(String item : userCustomerIds){
					if(!item.equals("")){
						deleteSqls.add("delete from userpreferredhotel where consumerid='" + item + "'");
						deleteSqls.add("delete from uservoucheraddress where consumerid='" + item + "'");
						deleteSqls.add("delete from usercustomer where id='" + item + "'");
					}
				}
			}
//			if(userpaymentIds != null){
//				for(String item : userpaymentIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userpaymentway where id='" + item + "'");
//					}
//				}
//			}
//			if(userRoleCardIds != null){
//				for(String item : userRoleCardIds){
//					if(!item.equals("")){
//						deleteSqls.add("delete from userrolecard where id='" + item + "'");
//					}
//				}
//			}
			if(userBizRoleIds != null){
				for(String item : userBizRoleIds){
					if(!item.equals("")){
						deleteSqls.add("delete from userpaymentway where roleid='" + item + "'");
						deleteSqls.add("delete from userrolecard where bizroleid='" + item + "'");
						deleteSqls.add("delete from userbizrole where id='" + item + "'");
					}
				}
			}
			if(userBaseId != null && !userBaseId.equals("")){
				deleteSqls.add("delete from userbase where id='" + userBaseId + "'");
			}
			if(userBaseExtId != null && !userBaseExtId.equals("")){
				deleteSqls.add("delete from userbaseext where id='" + userBaseExtId + "'");
			}
			if(!etipUserId.equals("")){
				deleteSqls.add("delete from  where id='" + etipUserId + "'");
			}
			try {
				for(String item : deleteSqls){
					System.err.println(item);
					dao.executeSQL(item);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(++i % 200 == 0){
				System.err.println(i);
			}
		}
	}
	
	/**
	 * 根据userBaseId找到EtipUserId,UserBaseExtId
	 * @param userBaseId
	 */
	private Map<String,String> getEtipUserId(String userBaseId){
		String etipUserId;
		String userBaseExtId;
		String sql = "select ETIPUSERID,USERID from userbase where id='" + userBaseId + "'";
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if(rs.size() == 0){
			return null;
		}
		etipUserId = rs.get(0).getString("ETIPUSERID");
		userBaseExtId = rs.get(0).getString("USERID");
		Map<String,String> map = new HashMap<String,String>();
		if(etipUserId != null && !etipUserId.equals("")){
			map.put("etipUserId", etipUserId);
		}
		if(userBaseExtId != null && !userBaseExtId.equals("")){
			map.put("userBaseExtId", userBaseExtId);
		}
		return map;
	}
	
	/**
	 * 获得爱好，联系方式，图片，组织，证书，联系人的id
	 * @param userBaseId
	 * @return
	 */
	private Map<String,String[]> getuserPreferenceId(String userBaseId){
		Map<String,String[]> map = new HashMap<String,String[]>();
		List<String> userPreferenceIds = new ArrayList<String>();
		List<String> userCertificateIds = new ArrayList<String>();
		List<String> userContactWayIds = new ArrayList<String>();
		List<String> userRelationIds = new ArrayList<String>();
		List<String> userGroupIds = new ArrayList<String>();
		List<String> userPictureIds = new ArrayList<String>();
		String sql = "select id from userpreference where USERBASEID='" + userBaseId + "'";
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userPreferenceIds.add(item.getString("ID"));
		}
		sql = "select id from usercertificate where USERBASEID='" + userBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userCertificateIds.add(item.getString("ID"));
		}
		sql = "select id from usercontactway where USERBASEID='" + userBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userContactWayIds.add(item.getString("ID"));
		}
		sql = "select id from userrelation where OWNERUSERID='" + userBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userRelationIds.add(item.getString("ID"));
		}
		sql = "select id from usergroup where USERID='" + userBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userGroupIds.add(item.getString("ID"));
		}
		sql = "select id from userpicture where USERBASEID='" + userBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			userPictureIds.add(item.getString("ID"));
		}
		if(userPreferenceIds.size() != 0){
			map.put("userPreferenceIds", getListForStrings(userPreferenceIds));
		}
		if(userCertificateIds.size() != 0){
			map.put("userCertificateIds", getListForStrings(userCertificateIds));
		}
		if(userContactWayIds.size() != 0){
			map.put("userContactWayIds", getListForStrings(userContactWayIds));
		}
		if(userRelationIds.size() != 0){
			map.put("userRelationIds", getListForStrings(userRelationIds));
		}
		if(userGroupIds.size() != 0){
			map.put("userGroupIds", getListForStrings(userGroupIds));
		}
		if(userPictureIds.size() != 0){
			map.put("userPictureIds", getListForStrings(userPictureIds));
		}
		
		return map;
	}
	
	/**
	 * 取得userBizRole的id，有可能是数组
	 * @param userBaseId
	 * @return
	 */
	private String[] getUserBizRoleId(String userBaseId){
		String sql = "select id from userbizrole where USERBASEID='" + userBaseId + "'";
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if(rs.size() == 0){
			return null;
		}
		String[] userBizRoleIds = new String[rs.size()];
		int i = 0;
		for(ETIPResultSet item : rs){
			userBizRoleIds[i++] = item.getString("ID");
		}
		return userBizRoleIds;
	}
	
	/**
	 * 取得会员卡，支付方式，配送地址，常住酒店，个体消费者的id
	 * @param userBizRoleIds
	 * @return
	 */
	private Map<String,String[]> getCardIdAndPaymentWayId(String[] userBizRoleIds){
		if(userBizRoleIds.length == 0){
			return null;
		}
		Map<String,String[]> map = new HashMap<String,String[]>();
//		List<String> cardIds = new ArrayList<String>();
//		List<String> paymentIds = new ArrayList<String>();
		List<String> userCustomerIds = new ArrayList<String>();
//		List<String> userPreferredHotelIds = new ArrayList<String>();
//		List<String> userVoucherAddressIds = new ArrayList<String>();
		for(String userBizRoleId : userBizRoleIds){
//			String sql = "select id from userrolecard where BIZROLEID='" + userBizRoleId + "'";
//			List<ETIPResultSet> rs = dao.queryForList(sql, null);
//			for(ETIPResultSet item : rs){
//				cardIds.add(item.getString("ID"));
//			}
//			sql = "select id from userpaymentway where ROLEID='" + userBizRoleId + "'";
//			rs = dao.queryForList(sql, null);
//			for(ETIPResultSet item : rs){
//				paymentIds.add(item.getString("ID"));
//			}
			String sql = "select id from usercustomer where ROLEID='" + userBizRoleId + "'";
			List<ETIPResultSet> rs = dao.queryForList(sql, null);
			for(ETIPResultSet item : rs){
				userCustomerIds.add(item.getString("ID"));
			}
//			for(String userCustomerId : userCustomerIds){
//				sql = "select id from uservoucheraddress where CONSUMERID='" + userCustomerId + "'";
//				rs = dao.queryForList(sql, null);
//				for(ETIPResultSet item : rs){
//					userVoucherAddressIds.add(item.getString("ID"));
//				}
//				sql = "select id from userpreferredhotel where CONSUMERID='" + userCustomerId + "'";
//				rs = dao.queryForList(sql, null);
//				for(ETIPResultSet item : rs){
//					userPreferredHotelIds.add(item.getString("ID"));
//				}
//			}
		}
//		if(cardIds.size() != 0){
//			map.put("userRoleCardIds", getListForStrings(cardIds));
//		}
//		if(paymentIds.size() != 0){
//			map.put("userpaymentIds", getListForStrings(paymentIds));
//		}
		if(userCustomerIds.size() != 0){
			map.put("userCustomerIds", getListForStrings(userCustomerIds));
		}
//		if(userPreferredHotelIds.size() != 0){
//			map.put("userPreferredHotelIds", getListForStrings(userPreferredHotelIds));
//		}
//		if(userVoucherAddressIds.size() != 0){
//			map.put("userVoucherAddressIds", getListForStrings(userVoucherAddressIds));
//		}
		
		return map;
	}
	
	private Map<String,String[]> getGroupOther(String groupBaseId){
		Map<String,String[]> map = new HashMap<String,String[]>();
		List<String> subGroupIds = new ArrayList<String>();
		List<String> groupCertificateIds = new ArrayList<String>();
		List<String> groupContactWayIds = new ArrayList<String>();
		List<String> groupUserIds = new ArrayList<String>();
		List<String> groupPictureIds = new ArrayList<String>();
		List<String> etipOperatorIds = new ArrayList<String>();
		List<String> groupUserEtipUserIds = new ArrayList<String>();
		String sql = "select id from subGroup where MYGROUPID='" + groupBaseId + "' or parentgroupid='" + groupBaseId + "'";
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			subGroupIds.add(item.getString("ID"));
		}
		sql = "select id from groupcertificate where GROUPID='" + groupBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			groupCertificateIds.add(item.getString("ID"));
		}
		sql = "select id from groupcontactway where GROUPID='" + groupBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			groupContactWayIds.add(item.getString("ID"));
		}
		sql = "select id from groupuser where OWNERGROUPID='" + groupBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			groupUserIds.add(item.getString("ID"));
			sql = "select id from etipoperator where GROUPUSERID='" + item.getString("ID") + "'";
			List<ETIPResultSet> ers = dao.queryForList(sql, null);
			for(ETIPResultSet item1 : ers){
				etipOperatorIds.add(item1.getString("ID"));
				sql = "select id from etipuser where MEMBERID='" + item1.getString("ID") + "'";
				List<ETIPResultSet> ers1 = dao.queryForList(sql, null);
				for(ETIPResultSet item11 : ers1){
					groupUserEtipUserIds.add(item11.getString("ID"));
				}
			}
		}
		sql = "select id from grouppicture where GROUPID='" + groupBaseId + "'";
		rs = dao.queryForList(sql, null);
		for(ETIPResultSet item : rs){
			groupPictureIds.add(item.getString("ID"));
		}
		
		if(subGroupIds.size() != 0){
			map.put("subGroupIds", getListForStrings(subGroupIds));
		}
		if(groupCertificateIds.size() != 0){
			map.put("groupCertificateIds", getListForStrings(groupCertificateIds));
		}
		if(groupContactWayIds.size() != 0){
			map.put("groupContactWayIds", getListForStrings(groupContactWayIds));
		}
		if(groupUserIds.size() != 0){
			map.put("groupUserIds", getListForStrings(groupUserIds));
		}
		if(groupPictureIds.size() != 0){
			map.put("groupPictureIds", getListForStrings(groupPictureIds));
		}
		if(etipOperatorIds.size() != 0){
			map.put("etipOperatorIds", getListForStrings(etipOperatorIds));
		}
		if(groupUserEtipUserIds.size() != 0){
			map.put("groupUserEtipUserIds", getListForStrings(groupUserEtipUserIds));
		}
		return map;
	}
	
	/**
	 * 把存放字符串的List转换为字符串数组
	 * @param list
	 * @return
	 */
	private String[] getListForStrings(List<String> list){
		Object[] objs = list.toArray();
		String[] ids = new String[objs.length];
		int i = 0;
		for(Object obj : objs){
			ids[i++] = obj.toString();
		}
		return ids;
	}
}
