package com.mini.page.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;


@Entity
@Table(name = "MINI_ACCESSTATISTICS")
public class AccesstatisticsData extends FrmData {
	private static final long serialVersionUID = 1L;

	/**
	 * 客户端IP地址;
	 */
	@Column(name="ACCESSIP")
	private String  accessIp;  //1
	
	/**
	 * 客户端ip地域
	 */
	private String  ipAddress;
	
	/**
	 * 访问page地址的的ip类型
	 */
	 
	private String  ipType;
	
	/**
	 * page主键
	 */
	
	private String  pageId;
	
	/**
	 * 访问时间;
	 */
	
	private Date  accessTime;
	
	
	private  String accesstatisticsName;   //域名
	
	
	private PageData pageData=new PageData();  //page实体

	/**
	 * 访客数
	 * 无效数据库字段--------Transient;
	 */
	private Integer fKS;
	/**
	 * 浏览量
	 * 无效数据库字段--------Transient;
	 */
	private Integer lLL;
	
	@Transient
	public Integer getfKS() {
		return fKS;
	}

	public void setfKS(Integer fKS) {
		this.fKS = fKS;
	}
	@Transient
	public Integer getlLL() {
		return lLL;
	}

	public void setlLL(Integer lLL) {
		this.lLL = lLL;
	}

	public String getAccessIp() {
		return accessIp;
	}
	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}
	@Column(name="IPADRESS")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Column(name="IPTYPE")
	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	@Column(name="PAGEID")
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	@Column(name="ACCESSTIME")
	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	@Column(name="ACCESSTATISTICSNAME")
	public String getAccesstatisticsName() {
		return accesstatisticsName;
	}

	public void setAccesstatisticsName(String accesstatisticsName) {
		this.accesstatisticsName = accesstatisticsName;
	}
	@Transient
    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }
	
	
}
