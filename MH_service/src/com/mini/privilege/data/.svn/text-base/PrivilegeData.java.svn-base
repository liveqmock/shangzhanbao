package com.mini.privilege.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;
@Entity
@Table(name = "MINI_PRIVILEGE")
public class PrivilegeData extends FrmData{
	private static final long serialVersionUID = 1L;
	/**
	 * 类型 1：付费 2未付费
	 */
	private String type;
	/**
	 * 用户的id
	 */
	private String userId;
	/**
	 * b:绑定page  u：未绑定page
	 */
	private String state;
	/**
	 *  启用时间时间
	 */
	private Date enabletime;
	/**
	 *  截止时间
	 */
	private Date endtime;
	/**
	 * 升级：y 升级又续费 :ys     
	 */
	private String upgrade;
	/**
	 * 赠送：是否是赠送 1：是  2：不是
	 */
	private String give;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * pageid
	 */
	private String pageId;
	/**
	 * 查询条件
	 */
	private String condition;
	
	@Column(name="TYPE",length=36)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="USERID",length=36)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="STATE",length=36)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="ENDTIME")
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Column(name="UPGRADE",length=36)
	public String getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(String upgrade) {
		this.upgrade = upgrade;
	}
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
	@Column(name="PAGEID",length=36)
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	@Column(name="ENABLETIME")
	public Date getEnabletime() {
		return enabletime;
	}
	public void setEnabletime(Date enabletime) {
		this.enabletime = enabletime;
	}
	@Column(name="CONDITION")
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
