package com.mini.tempmanage.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 模板所使用的组件实体类
 * 
 * @author 文东
 * @see TemplateComponentData
 * @since
 */
@Entity
@Table(name = "MINI_TEMPLATE_COMPONENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateComponentData extends FrmData {

    /**
     */
    private static final long serialVersionUID = 1L;

    // 组件ID
    @Column(name="COMPONENTID")
    private String componentid;

    // 模板ID
    @Column(name="TEMPLATEID")
    private String templateid;

    // 模板排序
    @Column(name="TAXIS")
    private Integer taxis;

    /**
     * 获取组件ID
     */
    public String getComponentid() {
        return componentid;
    }

    /**
     * 给组件ID赋值
     */
    public void setComponentid(String componentid) {
        this.componentid = componentid;
    }

    /**
     * 获取模板ID
     */
    public String getTemplateid() {
        return templateid;
    }

    /**
     * 给模板ID赋值
     */
    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    /**
     * 获取组件排序
     */
    public Integer getTaxis() {
        return taxis;
    }

    /**
     * 给组件排序赋值
     */
    public void setTaxis(Integer taxis) {
        this.taxis = taxis;
    }

}
