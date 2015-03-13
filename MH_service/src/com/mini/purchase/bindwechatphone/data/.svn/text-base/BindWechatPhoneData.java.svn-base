package com.mini.purchase.bindwechatphone.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 微信和电话号码绑定的中间表
 * @author  侯杨
 * @see     BindWechatPhoneData
 * @since   vmaque2.0
 */
@Entity
@Table(name = "MINI_BINDWECHATPHONE")
public class BindWechatPhoneData extends FrmData{

    /**
     */
    private static final long serialVersionUID = 1L;
    /**
     * 微信 openid
     */
    @Column(name="OPENID")
    private String openId;
    /**
     * 电话号码
     */
    @Column(name="PHONE")
    private String phone;
    /**
     *绑定时间
     */
    @Column(name="BINDTIME")
    private Date bindTime;
    /**
     * 绑定姓名
     */
    @Column(name="NAME")
    private String name;
    
    
    /**
     * 获取openid
     * @return  string
     * @see     BindWechatPhoneData#getOpenId()
     */
    public String getOpenId() {
        return openId;
    }
    /**
     * 为openid赋值
     * @param openid
     * @see     BindWechatPhoneData#setOpenId(String)
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    /**
     * 获取电话号码
     * @return  string
     * @see     BindWechatPhoneData#getPhone()
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 为电话号码赋值
     * @param phone
     * @see   BindWechatPhoneData#setPhone(String)
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * 获取绑定时间
     * @return  date
     * @see     BindWechatPhoneData#getBindTime()
     */
    public Date getBindTime() {
        return bindTime;
    }
    /**
     * 为绑定时间赋值
     * @param bindTime
     * @see   BindWechatPhoneData#setBindTime(Date)
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }
    /**
     * 获取姓名
     * @return  String
     * @see     BindWechatPhoneData#getName()
     */
    public String getName() {
        return name;
    }
    /**
     * 为绑定姓名赋值
     * @param name
     * @see   BindWechatPhoneData#setName(String)
     */
    public void setName(String name) {
        this.name = name;
    }
    
   
}
