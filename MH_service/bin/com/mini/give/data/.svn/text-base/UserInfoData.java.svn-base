package com.mini.give.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;

@Entity
@Table(name = "MINI_USER_INFO")
public class UserInfoData extends FrmData{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 用户权限
	 */
	private String userId;
	/**
	 * 试用期权限数总量
	 */
	private Integer tryPrivilege;
	/**
	 * 付费的权限数量
	 */
	private Integer payPrivilege;
	/**
	 * 已使用的试用期权限
	 */
	private Integer alreadyTryPrivilege;
	/**
	 * 已使用的付费权限
	 */
	private Integer alreadyPayPrivilege;
	/**
	 * 已过期的使用权限数量
	 */
	private Integer overduePrivilege;
	/**
	 * 已升级的试用权限数量
	 */
	private Integer alreadyUpgrade;
	/**
	 * 续费数
	 */
	private Integer renew;
	/**
	 * 赠送数
	 */
	private Integer giveNum;
	/**
	 * 暂存权限总数
	 */
	private Integer tempPrivilege;
	
	@Column(name="USERID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="TRYPRIVILEGE")
	public Integer getTryPrivilege() {
		return tryPrivilege;
	}
	public void setTryPrivilege(Integer tryPrivilege) {
		this.tryPrivilege = tryPrivilege;
	}
	@Column(name="PAYPRIVILEGE")
	public Integer getPayPrivilege() {
		return payPrivilege;
	}
	public void setPayPrivilege(Integer payPrivilege) {
		this.payPrivilege = payPrivilege;
	}
	@Column(name="ALREADYTRYPRIVILEGE")
	public Integer getAlreadyTryPrivilege() {
		return alreadyTryPrivilege;
	}
	
	public void setAlreadyTryPrivilege(Integer alreadyTryPrivilege) {
		this.alreadyTryPrivilege = alreadyTryPrivilege;
	}
	@Column(name="ALREADYPAYPRIVILEGE")
	public Integer getAlreadyPayPrivilege() {
		return alreadyPayPrivilege;
	}
	public void setAlreadyPayPrivilege(Integer alreadyPayPrivilege) {
		this.alreadyPayPrivilege = alreadyPayPrivilege;
	}
	@Column(name="OVERDUEPRIVILEGE")
	public Integer getOverduePrivilege() {
		return overduePrivilege;
	}
	public void setOverduePrivilege(Integer overduePrivilege) {
		this.overduePrivilege = overduePrivilege;
	}
	@Column(name="ALREADYUPGRADE")
	public Integer getAlreadyUpgrade() {
		return alreadyUpgrade;
	}
	public void setAlreadyUpgrade(Integer alreadyUpgrade) {
		this.alreadyUpgrade = alreadyUpgrade;
	}
	@Column(name="RENEW")
	public Integer getRenew() {
		return renew;
	}
	public void setRenew(Integer renew) {
		this.renew = renew;
	}
	@Column(name="GIVENUM")
	public Integer getGiveNum() {
		return giveNum;
	}
	public void setGiveNum(Integer giveNum) {
		this.giveNum = giveNum;
	}
	
	/**
	 * 试用到期数
	 */
	private Integer expiretry;
	/**
	 * 付费权限总数
	 */
	private Integer payment;
	@Transient
	public Integer getExpiretry() {
		return expiretry;
	}
	public void setExpiretry(Integer expiretry) {
		this.expiretry = expiretry;
	}
	@Transient
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	@Column(name="TEMPPRIVILEGE")
    public Integer getTempPrivilege() {
        return tempPrivilege;
    }
    public void setTempPrivilege(Integer tempPrivilege) {
        this.tempPrivilege = tempPrivilege;
    }
	
	
}
