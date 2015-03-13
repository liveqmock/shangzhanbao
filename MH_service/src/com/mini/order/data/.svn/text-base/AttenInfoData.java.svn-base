package com.mini.order.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 订单联系人实体对象
 * 
 * @author 文东
 * @see AttenInfoData
 * @since
 */
@Entity
@Table(name="MINI_ATTENINFO")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class AttenInfoData extends FrmData{
    
    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Column(name="USERID")
    private String userId;
    
    /**
     * 联系人名称
     */
    @Column(name="ATTENNAME")
    private String attenName;
    
    /**
     * 联系人电话
     */
    @Column(name="ATTENTEL")
    private String attenTel;
    
    /**
     * 联系人邮箱
     */
    @Column(name="ATTENEMAIL")
    private String attenEmail;
    
    /**
     * 联系人创建时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAttenName() {
        return attenName;
    }

    public void setAttenName(String attenName) {
        this.attenName = attenName;
    }

    public String getAttenTel() {
        return attenTel;
    }

    public void setAttenTel(String attenTel) {
        this.attenTel = attenTel;
    }

    public String getAttenEmail() {
        return attenEmail;
    }

    public void setAttenEmail(String attenEmail) {
        this.attenEmail = attenEmail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    

    
}
