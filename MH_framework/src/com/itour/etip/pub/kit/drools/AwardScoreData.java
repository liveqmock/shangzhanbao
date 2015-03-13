package com.itour.etip.pub.kit.drools;

import javax.persistence.Column;

import com.itour.etip.pub.frame.FrmData;

public class AwardScoreData extends FrmData {
	
	public static final int STATUS_UNEFFECTIVE = 1;// 未生效
	public static final int STATUS_EFFECTIVE = 2;// 已生效
	public static final int STATUS_FREEZEN = 3;// 已冻结
	public static final int STATUS_EXPIRED = 4;// 已过期
	public static final int STATUS_PAYED = 5;// 已支付
	public static final int STATUS_EXCHANGE = 6;// 已兑换礼品
	public static final int STATUS_CONTRIBUTED = 7;// 已捐赠
	public static final int STATUS_COMBINEOUT = 8;// 已合并出去
	public static final int STATUS_SENDRETURN = 9;// 赠送退回
	public static final int STATUS_BUYRETURN = 10;// 购买退回
	public static final int STATUS_BUYUPDATE = 11;// 购买修改冲销
	public static final int STATUS_SENDUPDATE = 12;// 赠送修改冲销
	public static final int STATUS_ADDUPDATE = 13;// 加分修改冲销
	public static final int STATUS_MINUPDATE = 14;// 减分修改冲销
	
	public static final int RECORD_AWARD=1;//	奖赏
	public static final int RECORD_BUG=2;//购买
	public static final int RECORD_BUYUPDATE=3;//购买修改
	public static final int RECORD_EXChANGEIN=4;//交换进来
	public static final int RECORD_EXCHANGEOUT=5;//交换出去
	public static final int RECORD_COMBINEOUT=6;//积分合并出
	public static final int RECORD_COMBINEIN=7;//积分合并入
	public static final int RECORD_SEND=8;//赠送
	public static final int RECORD_SENDUPATE=9;//赠送修改
	public static final int RECORD_EXPIRED=10;//积分失效
	public static final int RECORD_CONTRIBUTED=11;//积分捐赠
	public static final int RECORD_EXCHANGE=12;//积分兑换
	public static final int RECORD_OTHER=13;//其他类型
	public static final int RECORD_PUNISH=14;//积分处罚
	public static final int RECORD_PAY=15;//积分支付
	public static final int RECORD_SUBSTITUTE=16;//积分冲销
	public static final int RECORD_IMPORT=17;//导入数据

	/**
	 * 用户ID
	 */
	private String userBase1ID;

	/**
	 * 用户角色ID
	 */
	private String userBizRole1ID;

	/**
	 * 会员卡1类型 1.本卡 2.联名卡 3.银行联名卡
	 */
	private Integer card1Type;

	/**
	 * 会员卡1卡号
	 */
	private String card1NO;

	/**
	 * 操作人员
	 */
	private String operator;

	/**
	 * 对应规则ID
	 */
	private String ruleID;

	/**
	 * 对应积分
	 */
	private Integer score;

	/**
	 * 奖赏事件类型 对于奖赏积分，此处填写对应事件类型
	 */
	private Integer awardEventType;

	/**
	 * 事件描述
	 */
	private String eventMemo;

	
	/**
	 * 订单类型
	 */
	private int orderType;
	/**
	 * 关联订单ID
	 */
	private String orderID;
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getAwardEventType() {
		return awardEventType;
	}

	public void setAwardEventType(Integer awardEventType) {
		this.awardEventType = awardEventType;
	}

	public String getCard1NO() {
		return card1NO;
	}

	public void setCard1NO(String card1NO) {
		this.card1NO = card1NO;
	}

	public Integer getCard1Type() {
		return card1Type;
	}

	public void setCard1Type(Integer card1Type) {
		this.card1Type = card1Type;
	}

	public String getEventMemo() {
		return eventMemo;
	}

	public void setEventMemo(String eventMemo) {
		this.eventMemo = eventMemo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRuleID() {
		return ruleID;
	}

	public void setRuleID(String ruleID) {
		this.ruleID = ruleID;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getUserBase1ID() {
		return userBase1ID;
	}

	public void setUserBase1ID(String userBase1ID) {
		this.userBase1ID = userBase1ID;
	}

	public String getUserBizRole1ID() {
		return userBizRole1ID;
	}

	public void setUserBizRole1ID(String userBizRole1ID) {
		this.userBizRole1ID = userBizRole1ID;
	}
	
	/**
	 * 获得当前关联订单ID
	 * 
	 * @return
	 */
	@Column(length = 32, name = "ORDERTYPE", nullable = true)
	public int getOrderType() {
		return orderType;
	}

	/**
	 * 设置当前关联订单ID
	 * 
	 * @param orderID
	 */
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

}