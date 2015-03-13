package com.mini.componentClass.data;

import java.util.Date;

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
import com.mini.component.data.ComponentData;

/**
 * 〈组件表样式实体〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @date 2014-08-14
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_COMPONENT_CLASS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ComponentClassData extends FrmData{

    /**
     */
    private static final long serialVersionUID = -1887937825553543110L;
    
    /**
     * 样式名称
     */
    @Column(name="CLASSNAME")
    private String className;
    /**
     * 电脑样式内容
     */
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "PCCLASSCON", columnDefinition = "CLOB")
    private String pcclassCon;
    /**
     * 样式风格
     */
    @Column(name="CLASSTYPE")
    private String classType;
    /**
     * 平板样式内容
     */
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "IPADCLASSCON", columnDefinition = "CLOB")
    private String ipadClassCon;
    /**
     * 手机样式内容
     */
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "PHONECLASSCON", columnDefinition = "CLOB")
    private String phoneClassCon;
     /**
      * 数据删除
      */
    @Column(name="ISDELETE")
    private Integer isDelete;
     /**
      * 创建时间
      */
    @Column(name="CREATETIME")
    private Date createTime;
    /**
     * 图片路径
     */
    @Column(name="IMGPATH")
    private String imgPath;
   
    private ComponentData componentData;  //组件实体
    
    /**
     * 组件外键
     */
    @Column(name="COMPONENTID")
    private String componentid;
    
  //class帮组字段
    private String classHelp;
    
    //用于页面修改标识
    private String Ident;


    
    /***********************************************************************/
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
    
    
    public String getPcclassCon() {
        return pcclassCon;
    }

    public void setPcclassCon(String pcclassCon) {
        this.pcclassCon = pcclassCon;
    }

    public String getIpadClassCon() {
        return ipadClassCon;
    }

    public void setIpadClassCon(String ipadClassCon) {
        this.ipadClassCon = ipadClassCon;
    }

    public String getPhoneClassCon() {
        return phoneClassCon;
    }

    public void setPhoneClassCon(String phoneClassCon) {
        this.phoneClassCon = phoneClassCon;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Transient
    public ComponentData getComponentData() {
        return componentData;
    }

    public void setComponentData(ComponentData componentData) {
        this.componentData = componentData;
    }
    
    public String getComponentid() {
        return componentid;
    }

    public void setComponentid(String componentid) {
        this.componentid = componentid;
    }

    @Transient
    public String getClassHelp() {
        return classHelp;
    }

    public void setClassHelp(String classHelp) {
        this.classHelp = classHelp;
    }
    @Transient
    public String getIdent() {
        return Ident;
    }

    public void setIdent(String ident) {
        Ident = ident;
    }
    
    
}
