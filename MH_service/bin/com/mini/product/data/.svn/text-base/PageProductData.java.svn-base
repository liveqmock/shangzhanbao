package com.mini.product.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageData;

/**
 * page使用服务表 侯杨
 * 
 * @see PageProductData
 * @since
 */
@Entity
@Table(name = "MINI_PAGEPRODUCT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PageProductData extends FrmData {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    @Column(name = "ISRZ")
    private Integer isrz; // 是否认证 1：是 0：否
    @Column(name = "PRODUCTID")
    private String productId; // 服务id等
    @Column(name = "PAGEID")
    private String pageId; // 所使用的page页ID
    private Integer yeraNum; // 年限
    @Column(name = "ISDELETE")
    private Integer isdelete; // 是否停用 0 假删 1正常
    @Column(name = "CREATETIME")
    private Date createTime; // 期限开始时间
    @Column(name = "EXPIRETIME")
    private Date expireTime; // 期限结束时间
    @Column(name = "STOPTYPE")
    private Integer stopType; // 禁用类型
    @Column(name = "STOPDESC")
    private String stopDesc; // 禁用备注
    @Column(name = "STOPTIME")
    private Date stopTime; // 禁用时间
    @Column(name = "PRODUCTNAME")
    private String productName; // 服务名称
    // 修改人文东 添加一个表示 当status   
    @Column(name = "STATUS")
    private Integer status; // 是否停用 0 停用 1启用 2 待开通   为空时 表示该服务未付款       为3时表示 已开通
    // 上传文件地址
    @Column(name = "SIGNPATH")
    private String signPath;
    // 上传文件文件名
    @Column(name = "SIGNNAME")
    private String signName;
    // 上传文件时间
    @Column(name = "SIGNTIME")
    private Date signTime;
    // Page服务的内容 也可以使服务脚本代码的内容
    @Column(name = "productContent")
    private String productContent;
    private Integer decide; // 用于判断是否过期 非数据库字段
    private Integer count; // 统计服务个数 非数据库字段
    private PageData pageData = new PageData(); // page实体 非数据库字段
    private ProductData productData = new ProductData(); // 服务实体 非数据库字段
    private String noPayState;// 标示 page够没的此款服务时否已经付款 1：没有付款，0：已经付款
    private String productPrice; // 非数据库字段 代表每个服务的价格
    private String userId;// 非数据库字段 用户Id
    private String type;// 服务类型

    @Transient
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIsrz() {
        return isrz;
    }

    public void setIsrz(Integer isrz) {
        this.isrz = isrz;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @Column(name = "YEARNUM")
    public Integer getYeraNum() {
        return yeraNum;
    }

    public void setYeraNum(Integer yeraNum) {
        this.yeraNum = yeraNum;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStopType() {
        return stopType;
    }

    public void setStopType(Integer stopType) {
        this.stopType = stopType;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getSignPath() {
        return signPath;
    }

    public void setSignPath(String signPath) {
        this.signPath = signPath;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Transient
    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    @Transient
    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    @Transient
    public Integer getDecide() {
        return decide;
    }

    public void setDecide(Integer decide) {
        this.decide = decide;
    }

    @Transient
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Transient
    public String getNoPayState() {
        return noPayState;
    }

    public void setNoPayState(String noPayState) {
        this.noPayState = noPayState;
    }
    @Transient
    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    @Transient
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
