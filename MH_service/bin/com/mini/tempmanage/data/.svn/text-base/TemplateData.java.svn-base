package com.mini.tempmanage.data;

import java.sql.Clob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.data.PageTemplateData;

/**
 * 模板实体类
 * 
 * @author 文东
 * @see TemplateData
 * @since
 */
@Entity
@Table(name = "MINI_TEMPLATE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateData extends FrmData {

    /**
     */
    private static final long serialVersionUID = 1L;

    // 模板编号
    @Column(name = "SN")
    private String sn;

    // 模板分类：餐饮类、电子类、服装类、家居类等
    @Column(name = "CATALOG")
    private String catalog;

    // 模板名称
    @Column(name = "NAME")
    private String name;

    // 模板状态：OPEN=启用，CLOSED=停用 默认为OPEN
    @Column(name = "STATUS")
    private String status;

    // 模板介绍
    @Column(name = "MEMO")
    private String memo;

    // 模板价格
    @Column(name = "PRICE")
    private String price;

    // 模板创建时间
    @Column(name = "CREATETIME")
    private Date createTime;

    // 启用时间
    @Column(name = "OPENTIME")
    private Date openTime;

    // 禁用时间
    @Column(name = "CLOSETIME")
    private Date closeTime;

    // 创建人
    @Column(name = "CREATOR")
    private String creator;

    // 模板是否删除 0=删除 1=未删除
    @Column(name = "ISDELETE")
    private Integer isDelete;

    // 模板架构内容
    @Column(name = "CONTENT")
    private Clob content;
    
    // 主预览图片地址
    @Column(name = "IMGPATH")
    private String imgpath;
    
    /**
     * 上传人
     */
    private String uploadingName;
    /**
     * 上传时间
     */
    private Date uploadingTime;

    // 非数据库字段 表示用户所拥有的模板信息对象
    private UserOwnTempData ownTempData;

    // 模板缩略图集合 非数据库字段
    private List<TemplateThumbnailData> thumbnailDatas;

    // 模板缩略图 非数据库字段
    private TemplateThumbnailData thumbnailData;

    // 模板所使用的组件 非数据库字段
    private List<TemplateComponentData> templateComponentDatas;

    // 模板内容 非数据库字段
    private String stringContent;

    // 存放每个模板所对应的Page的域名  非数据库字段
    private String domain;
    
    // 用户拥有的模板的到期时间  非数据库字段
    private Date expireTime;
    
    // 用户拥有模板的时间  非数据库字段
    private Date ownTime;
    
    private List<PageTemplateData> pageTemplateDatas; // page集合

    private List<PageData> pageDatas;

    private PageHelpData pageHelpData;

    // 查询方式
    private String esc;

    // 电脑预览图
    private String computerImg;
    // 平板预览图
    private String fpdImg;
    // 手机预览图
    private String phoneImg;

    // 表示该模板被哪个PageId使用  非数据库字段 
    private String pageId;
    
    @Transient
    public String getComputerImg() {
        return computerImg;
    }

    public void setComputerImg(String computerImg) {
        this.computerImg = computerImg;
    }

    @Transient
    public String getFpdImg() {
        return fpdImg;
    }

    public void setFpdImg(String fpdImg) {
        this.fpdImg = fpdImg;
    }

    @Transient
    public String getPhoneImg() {
        return phoneImg;
    }

    public void setPhoneImg(String phoneImg) {
        this.phoneImg = phoneImg;
    }

    /**
     * 获取模板编号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 给模板编号赋值
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取模板分类：餐饮类、电子类、服装类、家居类等
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * 给模板分类赋值
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     * 获取模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 给模板名称赋值
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取模板状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 给模板状态赋值
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取模板介绍
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 给模板介绍赋值
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取模板价格
     */
    public String getPrice() {
        return price;
    }

    /**
     * 给模板价格赋值
     */

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取模板创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 给模板创建时间赋值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取模板启用时间
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 给模板启用时间赋值
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取模板禁用时间
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 给模板禁用时间赋值
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取模板创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 给模板创建人赋值
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取模板是否删除 0=删除 1=未删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 给模板是否删除赋值 0=删除 1=未删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取用户所拥有的模板信息对象
     */
    @Transient
    public UserOwnTempData getOwnTempData() {
        return ownTempData;
    }

    /**
     * 给用户所拥有的模板信息对象赋值
     */
    public void setOwnTempData(UserOwnTempData ownTempData) {
        this.ownTempData = ownTempData;
    }

    /**
     * 获取模板缩略图集合
     */
    @Transient
    public List<TemplateThumbnailData> getThumbnailDatas() {
        return thumbnailDatas;
    }

    /**
     * 给模板缩略图集合赋值
     */
    public void setThumbnailDatas(List<TemplateThumbnailData> thumbnailDatas) {
        this.thumbnailDatas = thumbnailDatas;
    }

    /**
     * 获取模板缩略图
     */
    @Transient
    public TemplateThumbnailData getThumbnailData() {
        return thumbnailData;
    }

    /**
     * 给模板缩略图赋值
     */
    public void setThumbnailData(TemplateThumbnailData thumbnailData) {
        this.thumbnailData = thumbnailData;
    }

    @Column(name = "UPLOADINGNAME")
    public String getUploadingName() {
        return uploadingName;
    }

    public void setUploadingName(String uploadingName) {
        this.uploadingName = uploadingName;
    }

    @Transient
    public List<PageTemplateData> getPageTemplateDatas() {
        return pageTemplateDatas;
    }

    public void setPageTemplateDatas(List<PageTemplateData> pageTemplateDatas) {
        this.pageTemplateDatas = pageTemplateDatas;
    }

    @Column(name = "UPLOADINGTIME")
    public Date getUploadingTime() {
        return uploadingTime;
    }

    @Transient
    public List<PageData> getPageDatas() {
        return pageDatas;
    }

    public void setUploadingTime(Date uploadingTime) {
        this.uploadingTime = uploadingTime;
    }

    public void setPageDatas(List<PageData> pageDatas) {
        this.pageDatas = pageDatas;
    }

    @Transient
    public PageHelpData getPageHelpData() {
        return pageHelpData;
    }

    public void setPageHelpData(PageHelpData pageHelpData) {
        this.pageHelpData = pageHelpData;
    }

    /**
     * 获取排序方式
     */
    @Transient
    public String getEsc() {
        return esc;
    }

    /**
     * 给排序方式赋值
     */
    public void setEsc(String esc) {
        this.esc = esc;
    }

    /**
     * 获取模板架构内容
     */
    public Clob getContent() {
        return content;
    }

    /**
     * 给模板架构内容赋值
     */
    public void setContent(Clob content) {
        this.content = content;
    }

    @Transient
    public List<TemplateComponentData> getTemplateComponentDatas() {
        return templateComponentDatas;
    }

    public void setTemplateComponentDatas(List<TemplateComponentData> templateComponentDatas) {
        this.templateComponentDatas = templateComponentDatas;
    }

    @Transient
    public String getStringContent() {
        return stringContent;
    }

    public void setStringContent(String stringContent) {
        this.stringContent = stringContent;
    }

    @Transient
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    @Transient
    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
    @Transient
    public Date getOwnTime() {
        return ownTime;
    }

    public void setOwnTime(Date ownTime) {
        this.ownTime = ownTime;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Transient
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    
    
}
