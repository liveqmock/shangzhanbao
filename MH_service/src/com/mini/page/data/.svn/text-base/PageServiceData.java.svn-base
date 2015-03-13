package com.mini.page.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;




@Entity
@Table(name = "MINI_PAGE_SERVICE")
public class PageServiceData extends FrmData {

	private static final long serialVersionUID = 1L;
	
	/*
	 * 服务名称
	 */
	private String name;
	
	/*
	 * 服务类型
	 */
	private String type;
	
	/**
	 * 服务代码
	 */
	private String code;
	
	/*
	 * 所使用的服务唯一标识
	 */
	private String serviceId;
	
	/**
	 * 服务使用状态：WAIT=待开通，OPEN=已开通,CLOSED=已关闭
	 */
	private String status;
	
	/*
	 * 配置主键
	 */
	private String pageId;

    @Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	 @Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	 @Column(name="SERVICE_ID")
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	 @Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 @Column(name="PAGE_ID")
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
}
