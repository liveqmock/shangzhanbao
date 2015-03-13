package com.mini.componentThumbnail.data;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.component.data.ComponentData;

/**
 * 
 * 〈组件缩略图标〉<br> 
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "MINI_COMPONENT_THUMBNAIL")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ComponentThumbnailData extends FrmData {

	private static final long serialVersionUID = 8858547688774597038L;
	
	/**
	 * 图片名称
	 */
	@Column(name="NAME")
	private String name;
	
	/**
	 * 缩略图类型:PC、pad、phone
	 */
	@Column(name="TYPE")
	private String type;
	
	/**
	 * 缩略图实体
	 */
	@Column(name="CONTENT")
	private Blob content;
	
	/**
	 * 缩略图描述
	 */
	@Column(name="MEMO")
	private String memo;
	
	/**
	 * 组件外键
	 */
	@Column(name="COMPONENTID")
	private String componentid;
	
	private ComponentData componentData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

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
	
}
