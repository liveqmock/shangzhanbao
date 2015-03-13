package com.mini.pageComponent.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;


/**
 * 
 * 〈Page组件关联表〉<br> 
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "MINI_PAGE_COMPONENT")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PageComponentData extends FrmData {

	private static final long serialVersionUID = -5506309025685627723L;

	@Column(name="PAGEID")
	private String pageid;//pageID
	
	@Column(name="COMPONENTID")
	private String componentid;//组件ID
	
	@Column(name="TAXIS")
	private Integer taxis;//组件排列顺序

	public String getPageid() {
		return pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public String getComponentid() {
		return componentid;
	}

	public void setComponentid(String componentid) {
		this.componentid = componentid;
	}

	public Integer getTaxis() {
		return taxis;
	}

	public void setTaxis(Integer taxis) {
		this.taxis = taxis;
	}
	
}
