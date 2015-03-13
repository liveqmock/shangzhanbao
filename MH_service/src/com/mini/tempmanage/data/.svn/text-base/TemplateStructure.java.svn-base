package com.mini.tempmanage.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 模板架构实体对象<br>
 * 用于存储模板框架代码包括：顶部、底部代码等。中间body部分由组件组成
 * 
 * @author 文东
 * @see TemplateStructure
 * @since
 */
@Entity
@Table(name = "MINI_TEMPLATE_STRUCTURE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateStructure extends FrmData {

    /**
     */
    private static final long serialVersionUID = 1L;

    // 模板结构代码类型：STRUCT=结构代码、BODY=主体代码（主要用于前期无组件状态
    @Column(name="TYPE")
    private String type;

    // 顶部、底部代码片段
    @Column(name="CODE")
    private String code;

    // 顶部、底部代码ftl路径
    @Column(name="PATH")
    private String path;

    // 所属模板ID
    @Column(name="TEMPLATE_ID")
    private String templateId;

    /**
     * 获取模板结构代码类型
     */
    public String getType() {
        return type;
    }

    /**
     * 给模板结构代码类型赋值
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取顶部、底部代码片段
     */
    public String getCode() {
        return code;
    }

    /**
     * 给顶部、底部代码片段赋值
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取顶部、底部代码片段存储地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 给顶部、底部代码片段存储地址赋值
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取所属模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 给所属模板ID赋值
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

}
