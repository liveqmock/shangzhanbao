package com.mini.account.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 
 * 收款账号信息实体<br> 
 *
 * @author 左香勇
 */
@Entity
@Table(name = "MINI_ACCOUNTNUMBER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountNumberData extends FrmData {
   
    private static final long serialVersionUID = 3482844951553939933L;
    
    /**
     * 登录账户id
     */
    @Column(name="USERID")
    private String userId;
    
    /**
     * 账号类型 0 - 支付宝  1 - 微信
     */
    @Column(name="ACCOUNTTYPE")
    private Integer accountType;
    
    /**
     * 收款账号
     */
    @Column(name="RECEIVABLEACCOUNT")
    private String receivableAccount;
    
    /**
     * 创建时间
     */
    @Column(name="CREATETIME")
    private Date createTime;
    
    /**
     * 最后修改时间
     */
    @Column(name="EDITTIME")
    private Date editTime;
    
    /**
     * 最后修改时间
     */
    @Column(name="ISDELETE")
    private Integer isdelete;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getReceivableAccount() {
        return receivableAccount;
    }

    public void setReceivableAccount(String receivableAccount) {
        this.receivableAccount = receivableAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
    
}
