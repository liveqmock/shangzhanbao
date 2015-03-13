package com.mini.purchase.orderManager.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageData;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
/**
 * 
 * 消费者订单信息表<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Entity
@Table(name = "MINI_CONSUMERORDER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ConSumerOrderData extends FrmData{

    /**
     */
    private static final long serialVersionUID = -2255830690048702489L;
    /**
     * 交易类型  0 － 支付宝交易  1 － 微信交易
     */
    private Integer payType;
    /**
     * 订单金额
     */
    private Double price;
    /**
     * 订单状态 0 － 未付款  1 － 待发货（已付款）2-待转账（已发货） 3- 已完成 4-已关闭
     */
    private Integer state;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 订单交易支付时间
     */
    private Date payTime;
    /**
     * 订单交易结束时间
     */
    private Date overTime;
    /**
     * pageid
     */
    private String pageId;
    /**
     * 消费者信息id
     */
    private String conSumerUserId;
    /**
     * 物流公司
     */
    private String logisticsCompany;
    /**
     * 物流单号
     */
    private String logisticsNumber;
    /**
     * 发货时间
     */
    private Date deliverTime;
    /**
     * 转账金额
     */
    private Double transferPrice;
    /**
     * 转账人
     */
    private String transferPeople;
    /**
     * 转账时间
     */
    private Date transferTime;
    /**
     * 订单是否删除  0 － 已删除  1 － 未删除
     */
    private Integer isDelete;
    /**
     * 微信账户唯一id
     */
    @Column(name="WEIXINOPENID")
    private String weixinOpenId;
    
    private ConSumerUserData conSumerUserData;
    
    private PageData pageData;
    /**
     * 非数据库字段   商品名称
     */
    private String goodsName;
    @Column(name="PAYTYPE")
    public Integer getPayType() {
        return payType;
    }
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    @Column(name="PRICE")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name="STATE")
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    @Column(name="ORDERCODE")
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Column(name="CREATETIME")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name="PAYTIME")
    public Date getPayTime() {
        return payTime;
    }
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    @Column(name="OVERTIME")
    public Date getOverTime() {
        return overTime;
    }
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }
    @Column(name="PAGEID")
    public String getPageId() {
        return pageId;
    }
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    @Column(name="CONSUMERUSERID")
    public String getConSumerUserId() {
        return conSumerUserId;
    }
    public void setConSumerUserId(String conSumerUserId) {
        this.conSumerUserId = conSumerUserId;
    }
    @Column(name="LOGISTICSCOMPANY")
    public String getLogisticsCompany() {
        return logisticsCompany;
    }
    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }
    @Column(name="LOGISTICSNUMBER")
    public String getLogisticsNumber() {
        return logisticsNumber;
    }
    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }
    @Column(name="DELIVERTIME")
    public Date getDeliverTime() {
        return deliverTime;
    }
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }
    @Column(name="TRANSFERPRICE")
    public Double getTransferPrice() {
        return transferPrice;
    }
    public void setTransferPrice(Double transferPrice) {
        this.transferPrice = transferPrice;
    }
    @Column(name="TRANSFERPEOPLE")
    public String getTransferPeople() {
        return transferPeople;
    }
    public void setTransferPeople(String transferPeople) {
        this.transferPeople = transferPeople;
    }
    @Column(name="TRANSFERTIME")
    public Date getTransferTime() {
        return transferTime;
    }
    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }
    @Column(name="ISDELETE")
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @Transient
    public ConSumerUserData getConSumerUserData() {
        return conSumerUserData;
    }
    public void setConSumerUserData(ConSumerUserData conSumerUserData) {
        this.conSumerUserData = conSumerUserData;
    }
    @Transient
    public PageData getPageData() {
        return pageData;
    }
    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }
    public String getWeixinOpenId() {
        return weixinOpenId;
    }


    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }
    @Transient
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    
}
