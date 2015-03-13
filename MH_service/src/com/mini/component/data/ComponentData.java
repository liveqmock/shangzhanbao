package com.mini.component.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.itour.etip.pub.frame.FrmData;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.componentThumbnail.data.ComponentThumbnailData;
import com.mini.pageComponent.data.PageComponentData;
import com.mini.tempmanage.data.TemplateComponentData;

/**
 * 〈组件表实体〉 〈功能详细描述〉
 * 
 * @author [作者]（左香勇）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_COMPONENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ComponentData extends FrmData {

	private static final long serialVersionUID = -2268505095947074830L;

	/**
	 * 组件编号
	 */
	@Column(name = "SN")
	private String sn;

	/**
	 * 组件类型
	 */
	@Column(name = "TYPE")
	private String type;

	/**
	 * 组件名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 组件价格
	 */
	@Column(name = "PRICE")
	private Double price;

	/**
	 * 组件ftl代码
	 */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "CODE", columnDefinition = "CLOB")
	private String code;

	/**
	 * 组件ftl代码路径
	 */
	@Column(name = "PATH")
	private String path;

	/**
	 * 是否允许该组件在模板中重复出现
	 */
	@Column(name = "MULTABLE")
	private String multable;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATETIME")
	private Date createTime;

	/**
	 * 修改时间
	 */
	@Column(name = "MODIFYTIME")
	private Date modifyTime;

	/**
	 * 创建人
	 */
	@Column(name = "CREATOR")
	private String creator;

	/**
	 * 修改人名称
	 */
	@Column(name = "MODIFYNAME")
	private String modifyName;

	/**
	 * 是否修改背景（0修改，1不修改）
	 */
	@Column(name = "UPLOADBGIMG")
	private Integer uploadbgimg;

	/**
	 * 是否添加超链接
	 */
	@Column(name = "ADDLINK")
	private Integer addLink;
	
	/**
	 * 修改page的html
	 */
	@Column(name = "EDITCODE")
	private String editcode;
	
    /**
     *  组件所指向的CSS ID属性值
     */
    @Column(name = "CSSID")
    private String cssId;
    
    /**
     * 组件所具有的css风格
     */
    @Column(name = "CSSTYPE")
    private String cssType;
    
    // 组件所拥有的锚点ID
    @Column(name = "NAVID")
    private String navId;
    
    //20140606之后用新的组件  此字段区分新旧组件
    @Column(name = "ISNEWOROLD")
    private Integer isNewOrOld;

    
    private String editcon;  //修改page类型后的内容
	// 模板所使用的组件信息
	private TemplateComponentData templateComponentData;
	
	//page所使用的组件信息
	private PageComponentData pageComponentData;

	// 组件缩略图 非数据库字典
	private ComponentThumbnailData thumbnailData;

	// 组件缩略图图片地址 非数据库字段
	private String pcJpgPath;
	
	// 组件页面html代码 非数据库字段
	private String clob;
	
	// 步骤html代码 非数据库字段
	private String stepCode;
	
	// 组件修改html代码 非数据库字段
	private String editCode;
  @Transient
	private List<ComponentClassData> classDatas=new ArrayList<ComponentClassData>();
      @Transient
    private List<String> classNameList=new ArrayList<String>();
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMultable() {
		return multable;
	}

	public void setMultable(String multable) {
		this.multable = multable;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}
	
	public Integer getUploadbgimg() {
		return uploadbgimg;
	}

	public void setUploadbgimg(Integer uploadbgimg) {
		this.uploadbgimg = uploadbgimg;
	}

	public Integer getAddLink() {
        return addLink;
    }

    public void setAddLink(Integer addLink) {
        this.addLink = addLink;
    }

    public String getEditcode() {
		return editcode;
	}

	public void setEditcode(String editcode) {
		this.editcode = editcode;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifyName() {
		return modifyName;
	}

	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}

	@Transient
	public TemplateComponentData getTemplateComponentData() {
		return templateComponentData;
	}

	public void setTemplateComponentData(
			TemplateComponentData templateComponentData) {
		this.templateComponentData = templateComponentData;
	}

	@Transient
	public PageComponentData getPageComponentData() {
		return pageComponentData;
	}

	public void setPageComponentData(PageComponentData pageComponentData) {
		this.pageComponentData = pageComponentData;
	}

	@Transient
	public ComponentThumbnailData getThumbnailData() {
		return thumbnailData;
	}

	public void setThumbnailData(ComponentThumbnailData thumbnailData) {
		this.thumbnailData = thumbnailData;
	}

	@Transient
	public String getPcJpgPath() {
		return pcJpgPath;
	}

	public void setPcJpgPath(String pcJpgPath) {
		this.pcJpgPath = pcJpgPath;
	}

	@Transient
    public String getClob() {
        return clob;
    }

    public void setClob(String clob) {
        this.clob = clob;
    }

    @Transient
    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    @Transient
    public String getEditCode() {
        return editCode;
    }

    public void setEditCode(String editCode) {
        this.editCode = editCode;
    }

    public String getCssId() {
        return cssId;
    }

    public void setCssId(String cssId) {
        this.cssId = cssId;
    }

    public String getNavId() {
        return navId;
    }

    public void setNavId(String navId) {
        this.navId = navId;
    }

    public String getCssType() {
        return cssType;
    }

    public void setCssType(String cssType) {
        this.cssType = cssType;
    }
    @Transient
	public String getEditcon() {
		return editcon;
	}

	public void setEditcon(String editcon) {
		this.editcon = editcon;
	}

    public Integer getIsNewOrOld() {
        return isNewOrOld;
    }

    public void setIsNewOrOld(Integer isNewOrOld) {
        this.isNewOrOld = isNewOrOld;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Transient
    public List<ComponentClassData> getClassDatas() {
        return classDatas;
    }

    public void setClassDatas(List<ComponentClassData> classDatas) {
        this.classDatas = classDatas;
    }
    @Transient
    public List<String> getClassNameList() {
        return classNameList;
    }

    public void setClassNameList(List<String> classNameList) {
        this.classNameList = classNameList;
    }
    
}
