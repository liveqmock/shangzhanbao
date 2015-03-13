package com.mini.order.data;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 发票实体类
 * @author jmj
 * 2013-9-2 上午09:37:28
 */
@Entity
@Table(name = "CTN_INVOICE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class InvoiceData extends FrmData{
	
	private static final long serialVersionUID = 2509525236456819322L;
	
	/**
	 * 发票内容
	 */
	@Column(name="INVOICECONTENT")
	private Integer invoiceContent;
	/**
	 * 发票台头
	 */
	@Column(name="INVOICETITLE")
	private String invoiceTitle;
	/**
	 * 收件人姓名
	 */
	@Column(name="ADDRESSEENAME")
	private String addresseeName;
	/**
	 * 邮寄地址
	 */
	@Column(name="ADDRESS")
	private String address;
	/**
	 * 收件人电话
	 */
	@Column(name="ADDRESSEEMOBLE")
	private String addresseeMoble;
	
	/**
	 * 用户ID
	 */
	
	private String userId;
	
	/**
	 * 发票创建时间
	 */
	
	private Date createTime;
	
	public Integer getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(Integer invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getAddresseeName() {
		return addresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddresseeMoble() {
		return addresseeMoble;
	}
	public void setAddresseeMoble(String addresseeMoble) {
		this.addresseeMoble = addresseeMoble;
	}
	@Column(name="USERID")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Column(name="CREATETIME")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	
}
