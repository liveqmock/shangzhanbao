package com.mini.tempmanage.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 模板样式实体对象
 *
 * @author     文东
 * @see        TemplateStyle
 * @since      
 */
@Entity
@Table(name = "MINI_TEMPLATE_STYLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateStyle extends FrmData{
    
    /**
     */
    private static final long serialVersionUID = 1L;

    // 样式分类：PHONE=手机，PAD=平板，PC=电脑
    @Column(name="CATALOG")
    private String catalog;
    
    // 样式结构类型：STRUCTURE=结构样式、LAYOUT=布局样式
    @Column(name="TYPE")
    private String type;
    
    // css代码
    @Column(name="CODE")
    private String code;
    
    // css文件路径
    @Column(name="PATH")
    private String path;
    
    // 模板id
    @Column(name="TEMPLATE_ID")
    private String templateId;

    /**
     * 获取模板样式分类
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * 给模板样式分类赋值 PHONE=手机，PAD=平板，PC=电脑
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * 获取样式结构类型
     */
    public String getType() {
        return type;
    }

    /**
     * 给取样式结构类型赋值STRUCTURE=结构样式、LAYOUT=布局样式
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取模板css代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 给模板css代码赋值
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取CSS文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 给CSS文件路径赋值
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 给模板ID赋值
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
