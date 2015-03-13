package com.mini.helpManager.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
/**
 * 
 *  文章类别<br> 
 *
 * @author 冯鑫
 */
@Entity
@Table(name = "MINI_HELP_ARTICLE_CATE")
public class HelpArticleCateData extends FrmData {

    /**
     */
    private static final long serialVersionUID = 5349126989485934791L;
    /**
     * 文章类别名称
     */
    private String  helparticlecatename;
    /**
     * 文章类别状态  显示未显示
     */
    private Integer helparticlecatestate;
    /**
     * 文章类别删除状态
     */
    private Integer isdelete;
    /**
     * 文章类别排序
     */
    private Integer helparticlecatesort;
    /**
     * 当前文章类别下的文章对象
     */
    private List<HelpArticleData> list_helpArticle;
    
    @Column(name = "HELPARTICLECATENAME")
    public String getHelparticlecatename() {
        return helparticlecatename;
    }
    public void setHelparticlecatename(String helparticlecatename) {
        this.helparticlecatename = helparticlecatename;
    }
    @Column(name = "HELPARTICLECATESTATE")
    public Integer getHelparticlecatestate() {
        return helparticlecatestate;
    }
    public void setHelparticlecatestate(Integer helparticlecatestate) {
        this.helparticlecatestate = helparticlecatestate;
    }
    @Column(name = "ISDELETE")
    public Integer getIsdelete() {
        return isdelete;
    }
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
    @Column(name = "HELPARTICLECATESORT")
    public Integer getHelparticlecatesort() {
        return helparticlecatesort;
    }
    public void setHelparticlecatesort(Integer helparticlecatesort) {
        this.helparticlecatesort = helparticlecatesort;
    }
    @Transient
    public List<HelpArticleData> getList_helpArticle() {
        return list_helpArticle;
    }
    public void setList_helpArticle(List<HelpArticleData> list_helpArticle) {
        this.list_helpArticle = list_helpArticle;
    }
    
}
