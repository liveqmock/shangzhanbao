package com.mini.pageMessageboard.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageData;

/**
 * 
 * page留言信息表
 * 
 * @author 左香勇
 *
 */
@Entity
@Table(name = "MINI_PAGE_MESSAGEBOARD")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PageMessageboardData extends FrmData {

	private static final long serialVersionUID = 87947559452477987L;

	@Column(name="PAGEID")
	private String pageid;//page主键
	
	@Column(name="NAME")
	private String name;//姓名
	
	@Column(name="EMAIL")
	private String email;//电子邮箱
	
	@Column(name="DEMAND")
	private String demand;//详细需求
	
	@Column(name="ISREAD")
	private Integer isread;//是否阅读
	
	@Column(name="CREATETIME")
	private Date createtime;//创建时间

	private PageData pageData;

	public String getPageid() {
		return pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public Integer getIsread() {
		return isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Transient
	public PageData getPageData() {
		return pageData;
	}

	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
	
	
}
