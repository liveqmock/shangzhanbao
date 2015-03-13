package com.sys.resources.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * @author jmj
 * 权限实体类
 */
@Entity
@Table(name = "TB_SYS_RESOURCES")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ResourceData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536968155846331271L;
	
	/**
	 * 权限名称
	 */
	@Column(name="RESNAME")
	private String resName;//资源名称

	@Column(name="url")
	private String url;//资源路径
	
	@Column(name="PARENTID")
	private String parentId;//父资源id
	
	@Column(name="RESTYPE")
	private String resType;//资源类型
	
	@Column(name="MEMO")
	private String memo;//备注
	
	@Column(name="SORT")
	private Integer sort;//排序

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
