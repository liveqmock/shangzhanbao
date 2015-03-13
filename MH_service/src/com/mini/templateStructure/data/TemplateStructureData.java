package com.mini.templateStructure.data;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.tempmanage.data.TemplateData;
import com.sys.user.data.UserData;


@Entity
@Table(name="MINI_TEMPLATE_STRUCTURE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class TemplateStructureData extends FrmData {

	private static final long serialVersionUID = 8081926121004008569L;

	@Column(name="TYPE")
	private String type;
	
	@Column(name="CODE")
	private Clob code;
	
	@Column(name="PATH")
	private String path;
	
	@Column(name="TEMPLATEID")
	private String templateid;
	
	private TemplateData templateData;
	
	@Column(name="USERID")
	private String userid;

	private UserData userdata;
	
	@Column(name="CREATEDATE")
	private Date createdate;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Clob getCode() {
		return code;
	}

	public void setCode(Clob code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	@Transient
	public TemplateData getTemplateData() {
		return templateData;
	}

	public void setTemplateData(TemplateData templateData) {
		this.templateData = templateData;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Transient
	public UserData getUserdata() {
		return userdata;
	}

	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
