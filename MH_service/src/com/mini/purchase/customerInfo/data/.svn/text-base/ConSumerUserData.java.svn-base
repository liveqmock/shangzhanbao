package com.mini.purchase.customerInfo.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
/**
 * 
 * 消费者信息表<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Entity
@Table(name = "MINI_CONSUMERUSER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ConSumerUserData extends FrmData {

    private static final long serialVersionUID = -4968697319142685114L;
    /**
     * 用户手机号码
     */
    private String userMobile;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户收货地址
     */
    private String userAddress;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 0 已删除  1  未删除
     */
    private Integer isDelete;
    /**
     * 微信账户唯一id
     */
    private String weixinOpenId;
    
    /**
     * 红包id
     */
    private String redPackageId;
    /**
     * 领红包id
     */
    private String cId;
    /**
     * 抢红包id
     */
    private String sId;
    
    private Integer payType;  //支付方式类型  用于传参
    
    @Column(name="USERMOBILE")
    public String getUserMobile() {
        return userMobile;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    @Column(name="USERNAME")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name="USERADDRESS")
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    @Column(name="CREATETIME")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name="ISDELETE")
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @Column(name="WEIXINOPENID")
    public String getWeixinOpenId() {
        return weixinOpenId;
    }
    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }  
    
    /**
     * 
     *获取红包id的值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @return  String
     */
    @Transient
    public String getRedPackageId() {
        return redPackageId;
    }
    /**
     * 
     *为红包id赋值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @param redPackageId
     */
    public void setRedPackageId(String redPackageId) {
        this.redPackageId = redPackageId;
    }
    /**
     * 
     *获取领红包id的值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @return  String
     */
    @Transient
    public String getcId() {
        return cId;
    }
    /**
     * 
     *为领红包id赋值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @param cid
     */
    public void setcId(String cId) {
        this.cId = cId;
    }
    /**
     * 
     *获取抢红包id的值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @return  String
     */
    @Transient
    public String getsId() {
        return sId;
    }
    /**
     * 
     *为抢红包id赋值<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月18日
     * @param sId
     */
    public void setsId(String sId) {
        this.sId = sId;
    }
    @Transient
    public Integer getPayType() {
        return payType;
    }
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
}
