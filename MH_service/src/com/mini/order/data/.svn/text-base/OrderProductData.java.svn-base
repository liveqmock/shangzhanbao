package com.mini.order.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;

/**
 * @author 林海鹏
 * 订单产品实体类
 */
@Entity
@Table(name = "MINI_ORDER_PRODUCT")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class OrderProductData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	/**
	 * 数量
	 */
	private Integer amount;
	/**
	 * 订单主键
	 */
	private String orderId;
	/**
	 * 订单里产品的配置项主键
	 */
	private String productConfigId;
	/**
	 * 产品主键
	 */
	private String productId;
	/**
	 * 状态
	 * <item code="0" name="未开通" />
			<item code="1" name="已开通" />
	 */
	private Integer state;
	/**
	 * 服务所在page的id
	 */
	private String pageId;
	/**
	 * 订单生成时产品的名称
	 */
	private String productName;
	/**
	 * 产品在订单里的价格
	 */
	private Double unitPrice;
	/**
	 * 订单生成时的配置项名称
	 */
	private String productConfigName;
	/**
	 * 购买年限，到期年限
	 */
	private Integer yearLimit;
	/**
	 * 原因字段
	 */
	private String reason;
	/**
	 * 上传路径(服务商)
	 */
	private String signPath;
	/**
	 * 上传文件名(服务商)
	 */
	private String signName;
	/**
	 * 根据到期年限得到到期时间
	 */
	private Date overTime;
	/**
	 * 签发标识时间
	 */
	private Date signTime;
	/**
	 * 是否展示
	 */
	private Integer isShow;
	
	/**
	 * 非数据库字段
	 */
	private OrderData orderData;
	
	@Transient
	public OrderData getOrderData() {
		return orderData;
	}
	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}
	
	@Column(name="AMOUNT")
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Column(name="PRODUCTCONFIGID")
	public String getProductConfigId() {
		return productConfigId;
	}
	public void setProductConfigId(String productConfigId) {
		this.productConfigId = productConfigId;
	}
	@Column(name="STATE")
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Column(name="PRODUCTNAME")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name="UNITPRICE")
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name="PRODUCTCONFIGNAME")
	public String getProductConfigName() {
		return productConfigName;
	}
	public void setProductConfigName(String productConfigName) {
		this.productConfigName = productConfigName;
	}
	@Column(name="YEARLIMIT")
	public Integer getYearLimit() {
		return yearLimit;
	}
	public void setYearLimit(Integer yearLimit) {
		this.yearLimit = yearLimit;
	}
	@Column(name="REASON")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(name="SIGNPATH")
	public String getSignPath() {
		return signPath;
	}
	public void setSignPath(String signPath) {
		this.signPath = signPath;
	}
	@Column(name="SIGNNAME")
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	@Column(name="OVERTIME")
	public Date getOverTime() {
		return overTime;
	}
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	@Column(name="SIGNTIME")
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	@Column(name="ISSHOW")
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	@Column(name="ORDERID")
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name="PRODUCTID")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Column(name="PAGEID")
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
}
