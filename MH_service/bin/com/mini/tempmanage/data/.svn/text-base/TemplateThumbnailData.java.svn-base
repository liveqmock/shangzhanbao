package com.mini.tempmanage.data;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;

/**
 * 模板缩略图实体对象
 * 
 * @author 文东
 * @see TemplateThumbnailData
 * @since
 */
@Entity
@Table(name = "MINI_TEMPLATE_THUMBNAIL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateThumbnailData extends FrmData {

    /**
     */
    private static final long serialVersionUID = 1L;

    // 图片名称
    @Column(name = "NAME")
    private String name;

    // 缩略图类型 PC、PAD、PHONE、MAIN
    @Column(name = "TYPE")
    private String type;

    // 缩略图实体
    @Column(name = "CONTENT")
    private Blob content;

    // 缩略图描述
    @Column(name = "MEMO")
    private String memo;

    // 模板外键
    @Column(name = "TEMPLATEID")
    private String templateId;

    // 图片地址  非数据库字段
    private String path;
    
    /**
     * 获取图片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 给图片名称赋值
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取缩略图类型
     */
    public String getType() {
        return type;
    }

    /**
     * 给缩略图类型赋值 PC、PAD、PHONE、MAIN
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取缩略图实体
     */
    public Blob getContent() {
        return content;
    }

    /**
     * 给缩略图实体赋值
     */
    public void setContent(Blob content) {
        this.content = content;
    }

    /**
     * 获取缩略图描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 给缩略图描述赋值
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取模板外键
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 给模板外键赋值
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Transient
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
    
}
