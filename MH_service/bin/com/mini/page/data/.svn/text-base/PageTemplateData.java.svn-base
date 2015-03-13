package com.mini.page.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.sys.user.data.UserData;

/**
 * 〈个人Page表〉 〈功能详细描述〉
 * 
 * @author [作者]（郭井超）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_PAGE_TEMPLATE")
public class PageTemplateData extends FrmData {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	/*
	 * 配置主键 
	 */
	private String pageId; 
	
	/*
	 * 模版主键
	 */
	private String templateId; 
	
	/*
	 * 模板使用状态：OPEN=启用，CLOSED=禁用
	 */
	private String status;  
	
	/*
	 * 有效期开始时间
	 */
	private Date startTime;  
	
	/*
	 * 有效期结束时间
	 */
	private Date endTime;
	
	/*
	 * 服版本id
	 */
	private String parentId;
	
	/*
	 * 版本号为1，发布一次版本号递增1
	 */
	private int tempVersion;
	
	/*
	 * 版本状态：OPEN=使用中，CLOSED=未使用。可直接切换启用历史版本.同时只能使用一个版本
	 */
	private String versionState;
	
	/*
	 * 指修版本创建对象，admin=管理员操作，member=用户自己操作
	 */
	private String versionOperat;
	
	/*
	 * 模板使用时间 
	 */
	private Date templateUseTime;
	 
	private TemplateData templateData;  //模板实体类
	
	private  List<PageData> pageDatas;  //page集合
	private UserData userData;  //用户实体
	
	private List<TemplateThumbnailData> templateThumbnailDatas;   //模板缩略图实体对象
	
	
	@Column(name="PAGE_ID")
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	  @Column(name="TEMPLATE_ID")
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	 
	 @Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 @Column(name="VALID_STIME")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	 @Column(name="VALID_ETIME")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	 @Column(name="PARENT_ID")
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	 @Column(name="TEMP_VERSION")
	public int getTempVersion() {
		return tempVersion;
	}
	public void setTempVersion(int tempVersion) {
		this.tempVersion = tempVersion;
	}
	
	 @Column(name="VERSION_STATUS")
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	 @Column(name="VERSION_OPERAT")
	public String getVersionOperat() {
		return versionOperat;
	}
	public void setVersionOperat(String versionOperat) {
		this.versionOperat = versionOperat;
	}
	 @Column(name="CREATE_TIME")
	public Date getTemplateUseTime() {
		return templateUseTime;
	}
	public void setTemplateUseTime(Date templateUseTime) {
		this.templateUseTime = templateUseTime;
	}
	@Transient
	public TemplateData getTemplateData() {
		return templateData;
	}
	public void setTemplateData(TemplateData templateData) {
		this.templateData = templateData;
	}
	@Transient
	public List<PageData> getPageDatas() {
		return pageDatas;
	}
	public void setPageDatas(List<PageData> pageDatas) {
		this.pageDatas = pageDatas;
	}
	@Transient
	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	@Transient
	public List<TemplateThumbnailData> getTemplateThumbnailDatas() {
		return templateThumbnailDatas;
	}
	public void setTemplateThumbnailDatas(
			List<TemplateThumbnailData> templateThumbnailDatas) {
		this.templateThumbnailDatas = templateThumbnailDatas;
	}
	
}
