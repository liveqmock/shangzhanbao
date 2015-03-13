package com.itour.etip.pub.kit.drools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.RuleBase;
import org.drools.agent.RuleAgent;
import org.drools.definition.type.FactType;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.log.LogUtil;
import com.itour.etip.pub.util.DistributorBrandUtil;

/********************************************************
Copyright (C), 2009-2010, gomai.
File name:    com/itour/etip/frame/DroolsUtil.java
Description:  规则引擎的调用接口
Author: txc      Version:  1.0.0  Date: 2009.4.8
***********************************************************/
public class DroolsUtil {


	private static Map ruleBaseCache = new HashMap();
	private static RuleBase getRuleBase(String propertyName){
		Object rv = ruleBaseCache.get(propertyName);
		if(rv==null){
			RuleAgent agent = RuleAgent.newRuleAgent(propertyName);// ruleagent.properties
			RuleBase rb = agent.getRuleBase();
			ruleBaseCache.put(propertyName, rb);
			return rb;
		}
		return (RuleBase)rv;
	}
	
	/**
	 * 执行规则引擎，运行规则引擎所需要的参数通过map传递进入，三个值：propertyName,factType,factValues.
	 * 
	 * @param Map
	 *            messageContent  规则传入参数直接放置到messageContent中
	 */
	public static void excuteDrools(Map messageContent) {
		String propertyName = (String) messageContent.get("propertyName");// 规则配置文件名称
		String factType = (String) messageContent.get("factType");// 事实类型
		//RuleBase被缓存，避免重复进行规则实例化。
		RuleBase rb = getRuleBase(propertyName);
		FactType appType = rb.getFactType(factType);// "Rules.RegisterAction"

		/*
		 * 获取规则应用程序实例，并且将参数设置到应用实例中。
		 */
		Object application = getApplication(appType, factType, messageContent);
		
		//执行规则错误，此处一定要进行规则恢复
		if(application==null){
			LogUtil.error("ETIPError", "规则"+factType+"没有正常执行，执行参数是："+messageContent.toString());
			return;
		}
		
		/*
		 * 执行规则引擎。
		 */
		rb.newStatelessSession().execute(new Object[] { application });
		// 运算完成后，需要根据factType,将结果保存到数据库中，由于业务不同，此处也需要不同的处理。
		processApplication(appType, factType, application, messageContent);
	}

	private static Object getApplication(FactType appType, String factType,
			Map factValues) {
		// 创建实例
		Object application = null;
		try {
			application = appType.newInstance();
		} catch (Exception ex) {
			// 此处如果不能构造出实例，那么需要记录错误日志
			ex.printStackTrace();
			return application;
		}
		// 根据objectName,objectId查询对象，并且给application赋值，此处比较复杂，就不统一处理。
		if (factType.equals("ScoreForOrders.GiveScoreAction")) {
			/* 订单类型 */
			String orderType = (String) factValues.get("orderType");
			/* 需要进行积分处理的有效金额 */
			String scoreSum = (String) factValues.get("scoreSum");
			/* 操作类型 */
			String operationType = (String) factValues.get("operationType");
			/* 订单下单渠道 */
			String orderChannel = (String) factValues.get("orderChannel");

			/* 处理预订人ID */
			String bookingPersonID = (String) factValues.get("bookingPersonID");
			if (bookingPersonID == null)
				bookingPersonID = "";
			bookingPersonID = bookingPersonID.replaceAll("-", "");
			/* 通过处理预订人ID获得预订人信息 */
			FrmUser bookingPerson = FrmUser.getUser(bookingPersonID);
			if (bookingPerson == null) {
				System.err.println("找不到预订人");
				return application;
			}

			// 从frmUser里面去得brandCode，判断如果属于纵横天地，那么执行送积分
			StringBuffer sb = new StringBuffer();
			List<String> brand = DistributorBrandUtil.getSonBrandCode("itour");
			for (String it : brand) {
				sb.append(",");
				sb.append(it);
			}
			sb.append(",");
			// 如果当前会有的brandCode不属于纵横天地及下级品牌，那么退出方法
			if (sb.toString().indexOf("," + bookingPerson.brandCode + ",") == -1) {
				System.err.println("不是纵横天地（包括子品牌）品牌");
				return application;
			}

			/* 会员级别 */
			String rankType = "";

			JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> rs = jdbc.queryForList(
					"select CodeType,areatype from cardnoscope where startcode<='"
							+ bookingPerson.etipUserCardNO + "' and endcode>='"
							+ bookingPerson.etipUserCardNO + "'", null);
			if (rs.size() > 0) {
				if (rs.get(0).getInt("AREATYPE") != 3) {
					rankType = "21";
				} else {
					rankType = rs.get(0).getString("CODETYPE");
				}
			} else {
				rankType = "21";
			}

			/* 产品类型 */
			// String productType = (String) factValues.get("productType");

			appType.set(application, "orderType", orderType);
			appType.set(application, "scoreSum", Double.valueOf(scoreSum));
			appType.set(application, "operationType", operationType);
			appType.set(application, "orderChannel", orderChannel);
			appType.set(application, "rankType", rankType);
			// appType.set(application, "productType", productType);
			factValues.put("bookingPerson_ScoreForOrders", bookingPerson);
		} else
		// 根据事实对象的不同，利用传入的参数，给事实实例赋值，此处比较复杂，就不统一处理。
		if (factType.equals("Rules.RegisterAction")) {
			/* 默认主动成为会员-1；被动成为会员-2 */
			appType.set(application, "isPassivity", (Integer) factValues
					.get("isPassivity"));
		}
		return application;
	}

	private static void processApplication(FactType appType, String factType,
			Object application, Map factValues) {
		

		if (factType.equals("ScoreForOrders.GiveScoreAction")) {
			try {
				System.out.println("processApplication start");
				// 此处取得计算的积分值，添加到会员卡积分中
				IAwardScoreService service = (IAwardScoreService) SpringContextHelper.getBean("memberCardScoreService");
				System.out.println("IAwardScoreService实例=" + service);
				FrmUser bookingPerson = (FrmUser) factValues.get("bookingPerson_ScoreForOrders");
				System.out.println("预订人=" + bookingPerson);
				if (bookingPerson == null) {
					System.err.println("frmUser没有取到信息");
					return;
				}
				/* 获得其他信息 */
				/* 订单编号 */
				String orderNumber = (String) factValues.get("orderNumber");

				/* 操作人员工号 */
				String operatorNumber = (String) factValues
						.get("operatorNumber");
				/* 根据工号获得当前员工的ETIPUSERID */
				String operatorSql = "select id from etipuser where usertype=3 and memberid in (select etipoperator_id from groupuser where workerno='"
						+ operatorNumber + "')";
				JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
				List<ETIPResultSet> etipidRS = dao.queryForList(operatorSql,
						null);
				String etipid = "";
				if (etipidRS != null && etipidRS.size() > 0) {
					etipid = etipidRS.get(0).getString("ID");
				} else {
					etipid = "";
				}

				// 以下生成积分基础数据
				AwardScoreData data = new AwardScoreData();
				data.setOrderID(orderNumber);
				data.setUserBase1ID(bookingPerson.userBaseID);
				data.setUserBizRole1ID(bookingPerson.userBizRoleID);
				data.setCard1Type(1);// 默认为本卡类型
				data.setCard1NO(bookingPerson.etipUserCardNO);
				data.setOperator(etipid);
				data.setRuleID(factType);// 此处存规则及事实名称
				String scoreValue = appType.get(application, "awardScore").toString();
				System.out.println("DroolsUtil---scoreValue=" + scoreValue);
				data.setScore((int) Math.floor(Double.parseDouble(scoreValue)));
				data.setAwardEventType(1);
				data.setEventMemo("订单奖励积分");
				service.awardScore(data);
				System.out.println("processApplication end");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (factType.equals("Rules.RegisterAction")) {
			try {
				// 此处取得计算的积分值，添加到会员卡积分中
				IAwardScoreService service = (IAwardScoreService) SpringContextHelper
						.getBean("memberCardScoreService");
				// 以下生成积分基础数据
				AwardScoreData data = new AwardScoreData();
				// FrmUser user = (FrmUser)factValues.get("user");
				data.setUserBase1ID((String) factValues.get("userBaseID"));
				data.setUserBizRole1ID((String) factValues.get("userBizRoleID"));
				data.setCard1NO((String) factValues.get("etipUserCardNO"));
				data.setOperator((String) factValues.get("etipUserID"));
				/* 以下代码用于查询会员卡类型 */
				String sql = "select cardsign from userRoleCard where bizRoleID='"
						+ data.getUserBizRole1ID()
						+ "' and hostCardNO='"
						+ data.getCard1NO() + "'";
				JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
				List<ETIPResultSet> rv = dao.queryForList(sql, null);
				if (rv == null || "".equals(rv)) {
					data.setCard1Type(0);
				} else {
					data.setCard1Type(rv.get(0).getInt("CARDSIGN"));// 默认为本卡类型,此处有错误，需要根据cardNO查询
				}
				data.setRuleID(factType);// 此处存规则及事实名称
				String scoreValue = appType.get(application, "awardScore")
						.toString();
				data.setScore(Integer.parseInt(scoreValue));
				data.setAwardEventType(1);
				data.setEventMemo("注册会员奖赏积分");
				service.awardScore(data);
				LogUtil.info("CONSOLE", "注册奖赏积分成功！");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
