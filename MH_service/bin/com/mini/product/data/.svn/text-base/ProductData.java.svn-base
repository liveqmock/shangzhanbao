package com.mini.product.data;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.shoppingCart.data.ShoppingCartData;

/**
 * 〈服务表〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_PRODUCT")
public class ProductData extends FrmData {
    private static final long serialVersionUID = 1L;
    private String name; // 服务名称1
    private String code; // 服务编码
    private Date createTime; // 创建时间2
    private Date overTime; // 到期时间
    private String pageId; // page的id
    private Double price; // 服务价格3
    private String serviceId; // 所使用的服务唯一标识
    private String status; // 服务使用状态：WAIT=待开通，OPEN=已开通,CLOSED=已关闭
    private String type; // 服务类型 
    private Integer yearNum; // 年限5
    private String sign; // 官方发布权限服务独有字段  当此字段为1时表示未官方发布权限
    private String productConfig; // 服务规格
    private Blob img; // 服务图标
    private String image; // 用于页面服务图标显示
    private Integer goodNum = 0; // 购买数量，，非数据库字段
    private String pageName; // page名称，，非数据库字段
    private String domain; // page域名，，非数据库字段
    private String pagestatus; // page状态
    
    private String isPay;// 是否付款 非数据库字段 1表示未付款 未拥有 0表示已付款 或者以拥有
    private ShoppingCartData shoppingCartData;  
    
    private String  ctnProductStatus;  //ctn服务状态

    /**
     * 标记
     */
    private Integer remark;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "CREATETIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "OVERTIME")
    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    @Column(name = "PAGE_ID")
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "SERVICE_ID")
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "YEARNUM")
    public Integer getYearNum() {
        return yearNum;
    }

    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
    }

    @Column(name = "IMG")
    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    @Column(name = "SIGN")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Column(name = "PRODUCTCONFIG")
    public String getProductConfig() {
        return productConfig;
    }

    public void setProductConfig(String productConfig) {
        this.productConfig = productConfig;
    }
    
    @Transient
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Transient
    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    @Transient
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Transient
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Transient
    public String getPagestatus() {
        return pagestatus;
    }

    public void setPagestatus(String pagestatus) {
        this.pagestatus = pagestatus;
    }

    @Transient
    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }
    @Transient
	public ShoppingCartData getShoppingCartData() {
		return shoppingCartData;
	}
	  
	public void setShoppingCartData(ShoppingCartData shoppingCartData) {
		this.shoppingCartData = shoppingCartData;
	}

	@Transient
    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }
    @Transient
	public String getCtnProductStatus() {
		return ctnProductStatus;
	}

	public void setCtnProductStatus(String ctnProductStatus) {
		this.ctnProductStatus = ctnProductStatus;
	}
  
    
    
}
