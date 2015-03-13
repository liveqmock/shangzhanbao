package com.itour.etip.support.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

@Entity()
@Table(name = "MemberContactStatistic")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MemberContactStatisticData extends FrmData{

	/*		用户唯一标识		*/
	private String userBaseID;
	/*		用户etipUserID	*/
	private String etipUserID;
	/*			用户首次登陆系统时间  		*/
	private java.util.Date firstLoginDate;
	/*			用户最后登录系统时间		*/
	private java.util.Date lastLoginDate;
	/*			用户首次来电时间			*/
	private java.util.Date firstCallDate;
	/*			用户最后来电时间			*/
	private java.util.Date lastCallDate;
	/*	 用户web登录次数	 */
	private int loginTimes;
	/*	  用户来电次数 	*/
	private int callTimes;
	/*		用户订单总数   	*/
	private int orderNumber;
	/*		用户退单总数		*/
	private int lostOrderNumber;
	/*		用户订单总金额		*/
	private double orderAmount;
	/*		用户丢单总金额		*/
	private double lostOrderAmount;
	/*		角色级别			*/
	private Integer rank;
	/*		信用等级			*/
	private Integer creditLevel;
	
	/*		现在居住地		*/
	private String address;
	
	@Column(length = 256, name = "ADDRESS", nullable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 3, name = "CALLTIMES", nullable = true)
	public int getCallTimes() {
		return callTimes;
	}

	public void setCallTimes(int callTimes) {
		this.callTimes = callTimes;
	}
	
	@Column(length = 32, name = "ETIPUSERID", nullable = true)
	public String getEtipUserID() {
		return etipUserID;
	}

	public void setEtipUserID(String etipUserID) {
		this.etipUserID = etipUserID;
	}
	@Column(name = "FIRSTCALLDATE", nullable = true)
	public java.util.Date getFirstCallDate() {
		return firstCallDate;
	}

	public void setFirstCallDate(java.util.Date firstCallDate) {
		this.firstCallDate = firstCallDate;
	}
	@Column(name = "FIRSTLOGINDATE", nullable = true)
	public java.util.Date getFirstLoginDate() {
		return firstLoginDate;
	}

	public void setFirstLoginDate(java.util.Date firstLoginDate) {
		this.firstLoginDate = firstLoginDate;
	}
	@Column(name = "LASTCALLDATE", nullable = true)
	public java.util.Date getLastCallDate() {
		return lastCallDate;
	}

	public void setLastCallDate(java.util.Date lastCallDate) {
		this.lastCallDate = lastCallDate;
	}
	@Column(name = "LASTLOGINDATE", nullable = true)
	public java.util.Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(java.util.Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	@Column(length = 3, name = "LOGINTIMES", nullable = true)
	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	@Column(precision=10,scale=4,name = "LOSTORDERAMOUNT",nullable = true)
	public double getLostOrderAmount() {
		return lostOrderAmount;
	}

	public void setLostOrderAmount(double lostOrderAmount) {
		this.lostOrderAmount = lostOrderAmount;
	}
	@Column(length = 3, name = "LOSTORDERNUMBER", nullable = true)
	public int getLostOrderNumber() {
		return lostOrderNumber;
	}

	public void setLostOrderNumber(int lostOrderNumber) {
		this.lostOrderNumber = lostOrderNumber;
	}
	@Column(precision=10,scale=4,name = "ORDERAMOUNT",nullable = true)
	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Column(length = 3, name = "ORDERNUMBER", nullable = true)
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Column(length = 32, name = "USERBASEID", nullable = true)
	public String getUserBaseID() {
		return userBaseID;
	}

	public void setUserBaseID(String userBaseID) {
		this.userBaseID = userBaseID;
	}
	@Column(length = 3,name = "RANK",nullable = true)
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	@Column(length = 3,name = "CREDITLEVEL",nullable = true)
	public Integer getCreditLevel() {
		return creditLevel;
	}

	public void setCreditLevel(Integer creditLevel) {
		this.creditLevel = creditLevel;
	}
}
