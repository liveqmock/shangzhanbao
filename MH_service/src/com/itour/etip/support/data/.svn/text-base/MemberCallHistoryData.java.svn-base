/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;


@Entity()
@Table(name = "MemberCallHistory")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MemberCallHistoryData extends FrmData{

	/**
	 * 来电号码
	 */
	private String inCallNO;

	/**
	 * 来电人员名称
	 */
	private String custName;

	/**
	 * 绑定电话号码
	 */
	private String bandingCall;

	/**
	 * 用户唯一标识
	 */
	private String userID;

	/**
	 * 来电时间
	 */
	private java.util.Date inCallDate;

	/**
	 * 来电受理人员
	 */
	private String bizHandler;

	/**
	 * 来电受理人员ID
	 */
	private String bizHandlerID;

	/**
	 * 来电业务
	 */
	private String bizName;

	/**
	 * 来电受理时产生订单
	 */
	private String orderID;

	/**
	 * 订单简要名称
	 */
	private String orderName;

	/**
	 * 订单产生时间
	 */
	private java.util.Date orderCreateDate;

	/**
	 * 订单最后处理时间
	 */
	private java.util.Date orderLastUpt;

	/**
	 * 订单状态
	 */
	private int orderStatus;

	/**
	 * 来电业务摘要
	 */
	private String bizSummery;

	/**
	 * 受理人员备注
	 */
	private String handlerMemo;
	

	/**
	 *获得来电号码
	 */
	@Column(length = 12,name = "INCALLNO",nullable = false)
	public String getInCallNO(){
		return inCallNO;
}

	/**
	 *设置来电号码
	 */
	public void setInCallNO(String inCallNO) {
		this.inCallNO = inCallNO;
}


	/**
	 *获得来电人员名称
	 */
	@Column(length = 64,name = "CUSTNAME",nullable = false)
	public String getCustName(){
		return custName;
}

	/**
	 *设置来电人员名称
	 */
	public void setCustName(String custName) {
		this.custName = custName;
}


	/**
	 *获得绑定电话号码
	 */
	@Column(length = 12,name = "BANDINGCALL",nullable = false)
	public String getBandingCall(){
		return bandingCall;
}

	/**
	 *设置绑定电话号码
	 */
	public void setBandingCall(String bandingCall) {
		this.bandingCall = bandingCall;
}


	/**
	 *获得用户唯一标识
	 */
	@Column(length = 32,name = "USERID",nullable = true)
	public String getUserID(){
		return userID;
}

	/**
	 *设置用户唯一标识
	 */
	public void setUserID(String userID) {
		this.userID = userID;
}


	/**
	 *获得来电时间
	 */
	@Column(name = "INCALLDATE",nullable = true)
	public java.util.Date getInCallDate(){
		return inCallDate;
}

	/**
	 *设置来电时间
	 */
	public void setInCallDate(java.util.Date inCallDate) {
		this.inCallDate = inCallDate;
}


	/**
	 *获得来电受理人员
	 */
	@Column(length = 32,name = "BIZHANDLER",nullable = true)
	public String getBizHandler(){
		return bizHandler;
}

	/**
	 *设置来电受理人员
	 */
	public void setBizHandler(String bizHandler) {
		this.bizHandler = bizHandler;
}


	/**
	 *获得来电受理人员ID
	 */
	@Column(length = 32,name = "BIZHANDLERID",nullable = true)
	public String getBizHandlerID(){
		return bizHandlerID;
}

	/**
	 *设置来电受理人员ID
	 */
	public void setBizHandlerID(String bizHandlerID) {
		this.bizHandlerID = bizHandlerID;
}


	/**
	 *获得来电业务
	 */
	@Column(length = 32,name = "BIZNAME",nullable = true)
	public String getBizName(){
		return bizName;
}

	/**
	 *设置来电业务
	 */
	public void setBizName(String bizName) {
		this.bizName = bizName;
}


	/**
	 *获得来电受理时产生订单
	 */
	@Column(length = 32,name = "ORDERID",nullable = true)
	public String getOrderID(){
		return orderID;
}

	/**
	 *设置来电受理时产生订单
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
}


	/**
	 *获得订单简要名称
	 */
	@Column(length = 64,name = "ORDERNAME",nullable = true)
	public String getOrderName(){
		return orderName;
}

	/**
	 *设置订单简要名称
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
}


	/**
	 *获得订单产生时间
	 */
	@Column(name = "ORDERCREATEDATE",nullable = true)
	public java.util.Date getOrderCreateDate(){
		return orderCreateDate;
}

	/**
	 *设置订单产生时间
	 */
	public void setOrderCreateDate(java.util.Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
}


	/**
	 *获得订单最后处理时间
	 */
	@Column(name = "ORDERLASTUPT",nullable = true)
	public java.util.Date getOrderLastUpt(){
		return orderLastUpt;
}

	/**
	 *设置订单最后处理时间
	 */
	public void setOrderLastUpt(java.util.Date orderLastUpt) {
		this.orderLastUpt = orderLastUpt;
}


	/**
	 *获得订单状态
	 */
	@Column(length = 3,name = "ORDERSTATUS",nullable = true)
	public int getOrderStatus(){
		return orderStatus;
}

	/**
	 *设置订单状态
	 */
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
}


	/**
	 *获得来电业务摘要
	 */
	@Column(length = 4000,name = "BIZSUMMERY",nullable = true)
	public String getBizSummery(){
		return bizSummery;
}

	/**
	 *设置来电业务摘要
	 */
	public void setBizSummery(String bizSummery) {
		this.bizSummery = bizSummery;
}


	/**
	 *获得受理人员备注
	 */
	@Column(length = 4000,name = "HANDLERMEMO",nullable = true)
	public String getHandlerMemo(){
		return handlerMemo;
}

	/**
	 *设置受理人员备注
	 */
	public void setHandlerMemo(String handlerMemo) {
		this.handlerMemo = handlerMemo;
}



}
