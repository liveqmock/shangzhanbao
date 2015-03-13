package com.sys.userrole.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * @author 大勇
 * 订单实体类
 */
@Entity
@Table(name = "CTN_AUTHORITY")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class AuthorityData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	
	/**
	 * 权限名称
	 */
	@Column(name="name")
	private String name;
	

	@Column(name="url")
	private String url;
	
	
	/**
	 * 类型
	 * <br>
	 * 0-查询；1-增加；2-删除；3-修改
	 */
	@Column(name="type")
	private Integer type;
	
	/**
	 * 创建时间
	 */
	@Column(name="createTime")
	private Date createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
