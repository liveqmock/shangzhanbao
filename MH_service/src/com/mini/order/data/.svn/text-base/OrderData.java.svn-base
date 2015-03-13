package com.mini.order.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.page.data.PageData;

/**
 * @author 林海鹏
 * 订单实体类
 */
@Entity
@Table(name = "MINI_ORDER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class OrderData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	
	/**
	 * 订单用户的主键
	 */
	@Column(name="sysUserId")
	private String sysUserId;
	

	/**
	 * 订单编号
	 * 生成规则：
	 */
	@Column(name="code")
	private String code;
	
	
	/**
	 * 付款类型
	 * <br>
	 * 0-线下付款；1-支付宝；2-网银；
	 */
	@Column(name="payType")
	private Integer payType;
	
	/**
	 * 创建时间
	 */
	@Column(name="createTime")
	private Date createTime;
	
	
	/**
	 * 修改时间
	 */
	@Column(name="modifyTime")
	private Date modifyTime;
	
	
	/**
	 * 付款时间
	 */
	@Column(name="payTime")
	private Date payTime;
	
	
	/**
	 * 付款时间
	 */
	@Column(name="overTime")
	private Date overTime;
	
	
	/**
	 * 价格
	 */
	@Column(name="price")
	private Double price;
	
	
	/**
	 * 是否需要发票：0-需要；1-不需要
	 * @update
	 */
	@Column(name="needInvoice")
	private Integer needInvoice;
	
	
	
	@Column(name="remark")
	private String remark;
	
	/**
	 * @author
	 * 0-未付款   1-线下付款 2-已付款            3-已完成      4-已关闭   5-已删除
	 */
	@Column(name="state")
	private Integer state;
	/**
	 *  用户名称
	 * 
	 */
	@Column(name="USERNAME")
	private String userName;
	/**
	 * 用户手机
	 * 
	 */
	@Column(name="USERMOBILE")
	private String userMobile;
	/**
	 * 用户邮箱
	 */
	@Column(name="USERMAIL")
	private String userMail;
	/**
	 * 发票表外键
	 */
	@Column(name="INVOICEID")
	private String invoiceId;
	/**
	 * 是否分配：0-未分配；1-已分配；
	 */
	@Column(name="ALLOCATED")
	private Integer allocated;
	
	@Column(name="responser")
	private String responser;
	/**
	 * 产品服务表的外键
	 */
	@Column(name="PAGEPRODUCTID")
	private String pageProductId;
	
	
	
	/**
	 * 非数据库字段
	 */
	private List<OrderProductData> orderProductDatas;
	//订单所对应的实名认证信息
	private BusinessUserData businessUserData;
	
	/**
	 * 非数据库字段，订单所对应的发票信息
	 */
	private InvoiceData invoiceData;
	/**
	 * 非数据库字段,page实体
	 */
	private PageData pageData=new PageData();
	
	private  int productNum;   //用于页面布局

	@Transient
	public List<OrderProductData> getOrderProductDatas() {
		return orderProductDatas;
	}


	public void setOrderProductDatas(List<OrderProductData> orderProductDatas) {
		this.orderProductDatas = orderProductDatas;
	}


	public String getSysUserId() {
		return sysUserId;
	}


	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getPayType() {
		return payType;
	}


	public void setPayType(Integer payType) {
		this.payType = payType;
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


	public Date getPayTime() {
		return payTime;
	}


	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}


	public Date getOverTime() {
		return overTime;
	}


	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getNeedInvoice() {
		return needInvoice;
	}


	public void setNeedInvoice(Integer needInvoice) {
		this.needInvoice = needInvoice;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserMobile() {
		return userMobile;
	}


	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	public Integer getAllocated() {
		return allocated;
	}


	public void setAllocated(Integer allocated) {
		this.allocated = allocated;
	}


	public String getResponser() {
		return responser;
	}


	public void setResponser(String responser) {
		this.responser = responser;
	}


	public String getPageProductId() {
		return pageProductId;
	}


	public void setPageProductId(String pageProductId) {
		this.pageProductId = pageProductId;
	}

	@Transient
    public BusinessUserData getBusinessUserData() {
        return businessUserData;
    }


    public void setBusinessUserData(BusinessUserData businessUserData) {
        this.businessUserData = businessUserData;
    }

    @Transient
    public InvoiceData getInvoiceData() {
        return invoiceData;
    }


    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    @Transient
	public int getProductNum() {
		return productNum;
	}


	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	@Transient
    public PageData getPageData() {
        return pageData;
    }


    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }


  
	
}
