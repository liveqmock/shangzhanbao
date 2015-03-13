package com.mini.domain.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageTemplateData;

/**
 *〈Page信息表〉
 *〈功能详细描述〉
 * @author     [作者]（林海鹏）
 * @see        [相关类/方法]
 * @since      [产品/模块版本] 
 */
@Entity
@Table(name = "MINI_PAGE_INFO_EXTRA")
public class PageInfoExtraData extends FrmData{
    private static final long serialVersionUID = 1L;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 域名
     */
    private String domain;
    /**
     * 域名类型：独立域名 1、二级域名2
     */
    private String type;
    /**
     * 域名状态：OPEN=启用、CLOASED=禁用
     */
    private String status;
    /**
     * 用户页面外键
     */
    private String pageId;
    /**
     * 域名绑定时间
     */
    private Date bindingTime;
    
    /**
     * 用户设置二级域名帮助字段
     */
    private String help;
    
    @Transient
    public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	/**
     * page使用模板信息表
     * */
    private PageTemplateData pageTemplateData;
    @Column(name="COMPANY",length=500)
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name="domain",length=500)
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    @Column(name="type",length=500)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="status",length=50)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="page_id",length=50)
    public String getPageId() {
        return pageId;
    }
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    @Column(name="BINDINGTIME")
	public Date getBindingTime() {
		return bindingTime;
	}
	public void setBindingTime(Date bindingTime) {
		this.bindingTime = bindingTime;
	}
	@Transient
	public PageTemplateData getPageTemplateData() {
		return pageTemplateData;
	}
	public void setPageTemplateData(PageTemplateData pageTemplateData) {
		this.pageTemplateData = pageTemplateData;
	}
    
}
