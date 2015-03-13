package com.sys.user.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 用户实体类
 */
@Entity
@Table(name = "CTN_SYSUSER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserData extends FrmData {

    private static final long serialVersionUID = 2509525236456819322L;
    /**
     * 登录邮箱
     */
    @Column(name = "LOGINMAIL")
    private String loginMail;
    /**
     * 登陆手机号码
     */
    @Column(name = "LOGINMOBLE")
    private String loginMoble;
    /**
     * 用户名称（公司名称）
     */
    @Column(name = "USERNAME")
    private String userName;
    /**
     * 登陆密码
     */
    @Column(name = "PASSWORD")
    private String passWord;
    /**
     * 用户类型 {1:运营商用户}、{2:企业用户}
     */
    @Column(name = "USERTYPE")
    private Integer userType;
    /**
     * 用户状态{1:启动}、{2:注销}
     */
    @Column(name = "USERSTATE")
    private Integer userState;
    /**
     * 添加的方式{1:注册}、{2:后台添加}
     */
    @Column(name = "ADDTYPE")
    private Integer addType;
    /**
     * 生成时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;
    /**
     * 修改时间
     */
    @Column(name = "MODIFYTIME")
    private Date modifyTime;
    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    @Column(name = "PASSWORDTEXT")
    private String passwordtext;
    /**
     * 是够购买发布权限
     */
    @Column(name = "ISPRIVILEGE")
    private Integer isprivilege;
    /**
     * 用户角色中间表list集合对象
     */
    private List<UserRoleCtnData> rolelist;
    /**
     * 角色id
     */
    private String roleid;

    /**
     * 字段描述：收款账号
     * 数据库字段：RECEIVABLEACCOUNT
     * 字段类型： VARCHAR2(200)
     * 可空：是
     */
    @Column(name = "RECEIVABLEACCOUNT" , length = 200 , nullable = true)
    private String receivableAccount;

    /**
     * 字段描述：账号类型 0 － 支付宝  1 － 微信
     * 数据库字段：ACCOUNTTYPE
     * 字段类型：NUMBER(2)
     * 可空：是
     */
    @Column(name = "accountType" , length = 2 , nullable = true)
    private Integer accountType;

    // 用户拥有Page数量 非数据库字段
    private String pageNum;

    // 用户拥有发布的Page数量 非数据库字段
    private String pubPageNum;

    // 用户拥有发布权限数量 非数据库字段
    private Integer buyPubNum;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Transient
    public List<UserRoleCtnData> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<UserRoleCtnData> rolelist) {
        this.rolelist = rolelist;
    }

    public String getLoginMail() {
        return loginMail;
    }

    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail;
    }

    public String getLoginMoble() {
        return loginMoble;
    }

    public void setLoginMoble(String loginMoble) {
        this.loginMoble = loginMoble;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPasswordtext() {
        return passwordtext;
    }

    public void setPasswordtext(String passwordtext) {
        this.passwordtext = passwordtext;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Transient
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Transient
    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    @Transient
    public String getPubPageNum() {
        return pubPageNum;
    }

    public void setPubPageNum(String pubPageNum) {
        this.pubPageNum = pubPageNum;
    }

    @Transient
    public Integer getBuyPubNum() {
        return buyPubNum;
    }

    public void setBuyPubNum(Integer buyPubNum) {
        this.buyPubNum = buyPubNum;
    }

    public Integer getIsprivilege() {
        return isprivilege;
    }

    public void setIsprivilege(Integer isprivilege) {
        this.isprivilege = isprivilege;
    }
    /**
     *  获取收款账号<br>
     */
    public String getReceivableAccount() {
        return receivableAccount;
    }
    
    /**
     * 
     *  给收款账号赋值<br>
     *  @param receivableAccount 收款账号 String 类型
     */
    public void setReceivableAccount(String receivableAccount) {
        this.receivableAccount = receivableAccount;
    }

    /**
     * 
     * 获取收款账号类型  0 － 支付宝  1 － 微信<br>
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 
     * 给收款账号类型赋值  0 － 支付宝  1 － 微信<br>
     * @param accountType 收款账号类型 Integer类型
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

}
