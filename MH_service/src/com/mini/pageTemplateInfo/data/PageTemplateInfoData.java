package com.mini.pageTemplateInfo.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.component.data.ComponentData;
import com.mini.tempmanage.data.TemplateData;


/**
 * 
 * 〈Page内容表,主要存储卖点、详情〉<br> 
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "MINI_PAGE_TEMPLATE_INFO")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PageTemplateInfoData extends FrmData {

	private static final long serialVersionUID = -5636516605328036713L;

	//组件类型：导航、友情链接、卖点等组件
	@Column(name="COMPONENTID")
	private String componentid;
	
	private ComponentData componentData;
	
	//内容名称 
	@Column(name="NAME")
	private String name;
	
	// 存储模板内容
	@Column(name="CONTENT")
	private String content;
	
	//排序，用于同类组件排序
	@Column(name="TAXIS")
	private Integer taxis;
	
	//模板信息id
	@Column(name="PAGETEMPLATEID")
	private String pageTemplateid;
	
	//使用模板信息
	private TemplateData templateData;

	public String getComponentid() {
		return componentid;
	}

	public void setComponentid(String componentid) {
		this.componentid = componentid;
	}

	@Transient
	public ComponentData getComponentData() {
		return componentData;
	}

	public void setComponentData(ComponentData componentData) {
		this.componentData = componentData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTaxis() {
		return taxis;
	}

	public void setTaxis(Integer taxis) {
		this.taxis = taxis;
	}
	
	public String getPageTemplateid() {
		return pageTemplateid;
	}

	public void setPageTemplateid(String pageTemplateid) {
		this.pageTemplateid = pageTemplateid;
	}

	@Transient
	public TemplateData getTemplateData() {
		return templateData;
	}

	public void setTemplateData(TemplateData templateData) {
		this.templateData = templateData;
	}

	
}
