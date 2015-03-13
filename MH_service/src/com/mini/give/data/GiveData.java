package com.mini.give.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
@Entity
@Table(name = "MINI_GIVE")
public class GiveData extends FrmData{
	private static final long serialVersionUID = 1L;
	/**
	 * 赠送：是否是赠送 1：是  2：不是
	 */
	private String give;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 查询条件
	 */
	private String condition;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 创建者
	 */
	private String creatorName;
	/**
	 * 创建者
	 */
	private String creatorId;
	/**
	 * 赠送给用户的数量
	 */
	private  int giveNum;
	
	@Column(name="GIVE",length=36)
	public String getGive() {
		return give;
	}
	public void setGive(String give) {
		this.give = give;
	}
	
	@Column(name="MESSAGE",length=36)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column(name="CONDITION")
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Column(name="CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="CREATORNAME")
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	@Column(name="USERID")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="CREATORID")
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	@Column(name="GIVENUM")
	public int getGiveNum() {
		return giveNum;
	}
	public void setGiveNum(int giveNum) {
		this.giveNum = giveNum;
	}
	


	private String totalNum;//赠送总数
	private String userNum;//客户数

	@Transient
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	@Transient
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	
}
