package com.mini.tempmanage.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;

/**
 * 用户拥有的模板
 *
 * @author     文东
 * @see        UserOwnTempData
 * @since      
 */
@Entity
@Table(name = "MINI_USEROWNTEMP")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserOwnTempData extends FrmData{
   
    /**
     */
    private static final long serialVersionUID = 1L;

    // 用户ID
    @Column(name = "USERID")
    private String userId;
    
    // 模板ID
    @Column(name = "TEMPID")
    private String tempId;
    
    // 用户拥有模板的时间
    @Column(name = "OWNTIME")
    private Date ownTime;
    
    // 模板到期时间
    @Column(name = "EXPIRETIME")
    private Date expireTime;
    
    // 时间毫秒数  非数据库字段
    private Long expireTimeMs;
    

    /**
     * 获取用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 给用户ID赋值
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取模板ID
     */
    public String getTempId() {
        return tempId;
    }

    /**
     * 给模板ID赋值
     */
    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    /**
     * 获取用户拥有模板的时间
     */
    public Date getOwnTime() {
        return ownTime;
    }

    /**
     * 给用户拥有模板的时间赋值
     */
    public void setOwnTime(Date ownTime) {
        this.ownTime = ownTime;
    }

    /**
     * 获取用户拥有模板的到期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 给用户拥有模板的到期时间赋值
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Transient
    public Long getExpireTimeMs() {
        return expireTimeMs;
    }

    public void setExpireTimeMs(Long expireTimeMs) {
        this.expireTimeMs = expireTimeMs;
    }
  
}
