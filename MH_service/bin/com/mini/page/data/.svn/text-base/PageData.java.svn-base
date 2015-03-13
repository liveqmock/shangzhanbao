package com.mini.page.data;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.order.data.OrderProductData;
import com.mini.privilege.data.PrivilegeData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.sys.user.data.UserData;

/**
 * 〈个人Page表〉 〈功能详细描述〉
 * 
 * @author [作者]（林海鹏）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_PAGE")
public class PageData extends FrmData {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * Page状态。包括：0:暂存、1 已发布、2 :禁用 3、编辑中  4 被禁用后，启用成功的状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 禁用时间
     */
    private Date disableTime;
    /**
     * page名称
     */
    private String name;
    /**
     * 禁用类型
     * */
    private int disabledType;
    /**
     * 禁用备注
     */
    private String disabledReason;
    /**
     * 创建类型 0 前台 1后台
     */
    private Integer createType;

    /**
     * 删除标志 0 删  ;     1 
     */
    private int isDelete;

    /**
     * 状态：0-赠送；1-付费;
     */
    private String state;

    /**
     * 赠送权限截至时间;
     */
    private Date endTime;

    // page 内容
    private Clob content;

    /**
     * @Transient字段
     */
    private String ymId;
    /**
     * @Transient字段
     * 购物车存在未结算的服务1表示存在
     */
    private String hasShop;
    /**
     * @Transient字段
     * 存在未付款的订单1表示存在
     */
    private String hasOrder;
   
    // Page缩略图
    private String pageImg;
    //此page是否有未付款服务标示
    private String noPayForState;
    
    //未读留言数量
    private Integer messageBoardNum;
    
    //page的二维码
    private String zing;

    private List<PageInfoExtraData> pageInfoExtraData;
    private PageInfoExtraData pageInfoExtra = new PageInfoExtraData();
    private UserData userData; // 用户实体
    private List<PrivilegeData> privilegeDatas; // 权限集合
    private AccesstatisticsData accesstatisticsData;// 统计浏览量实体对象
    private List<PageProductData> pageProductDatas; // page使用服务
    private String lp;//是否是续费操作
    
    private List<ProductData> listProduct = new ArrayList<ProductData>();// Page所拥有的服务集合  非数据库字段
    
    private ShoppingCartData shoppingCartData=new ShoppingCartData();  //购物车信息
    
    private String ownCredible;// 是否拥有可信网站服务  1表示拥有 0表示未拥有  非数据库字段
    
    private String owmIndependentDomain; // 是否拥有独立域名 1表示拥有 0表示未拥有  非数据库字段
    
    private String owmOnlineService; // 是否拥有在线客服服务 1表示拥有 0表示未拥有 非数据库字段
    
    
    private String pricreCredible;  //可信网站服务  1  已收费   0 没收费 非数据库字段
    private String pricreService;  //  在线客服服务1  已收费 0  没收费 非数据库字段
    
    
    private String pageStatusCredible;   //可信网站服务状态   1开通  0未开通 
    private String pageStatusService;   //在线客服服务状态   1开通  0未开通 
    
    
    private List<ShoppingCartData> shopDatas;//购物车数据集合（冗余字段，用来传递未结算的服务）
    private List<OrderProductData> orderProductDatas;//订单数据集合（冗余字段，用来传递未付款的服务）
    
    private Integer notProcessOrderNum;// 该页面未处理的消费者订单数量
    
    private String  compCon;  //主键帮组字段
    
    
    @Transient
    public Integer getNotProcessOrderNum() {
        return notProcessOrderNum;
    }

    public void setNotProcessOrderNum(Integer notProcessOrderNum) {
        this.notProcessOrderNum = notProcessOrderNum;
    }

    @Transient
    public List<ShoppingCartData> getShopDatas() {
		return shopDatas;
	}

	public void setShopDatas(List<ShoppingCartData> shopDatas) {
		this.shopDatas = shopDatas;
	}

	@Transient
	public List<OrderProductData> getOrderProductDatas() {
		return orderProductDatas;
	}

	public void setOrderProductDatas(List<OrderProductData> orderProductDatas) {
		this.orderProductDatas = orderProductDatas;
	}

	@Transient
    public String getOwnCredible() {
        return ownCredible;
    }

    public void setOwnCredible(String ownCredible) {
        this.ownCredible = ownCredible;
    }

    @Transient
    public String getOwmIndependentDomain() {
        return owmIndependentDomain;
    }

    public void setOwmIndependentDomain(String owmIndependentDomain) {
        this.owmIndependentDomain = owmIndependentDomain;
    }

    @Transient
    public String getOwmOnlineService() {
        return owmOnlineService;
    }

    public void setOwmOnlineService(String owmOnlineService) {
        this.owmOnlineService = owmOnlineService;
    }

    @Transient
    public List<ProductData> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductData> listProduct) {
        this.listProduct = listProduct;
    }
    
    @Transient
    public String getYmId() {
        return ymId;
    }

    public void setYmId(String ymId) {
        this.ymId = ymId;
    }

    @Transient
    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "ENDTIME")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Transient
    public AccesstatisticsData getAccesstatisticsData() {
        return accesstatisticsData;
    }

    public void setAccesstatisticsData(AccesstatisticsData accesstatisticsData) {
        this.accesstatisticsData = accesstatisticsData;
    }

    /**
     * page使用模板信息表
     * */
    private PageTemplateData pageTemplateData;

    @Column(name = "user_id", length = 36)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "status", length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "disable_time")
    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ISDELETE")
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Transient
    public List<PageInfoExtraData> getPageInfoExtraData() {
        return pageInfoExtraData;
    }

    public void setPageInfoExtraData(List<PageInfoExtraData> pageInfoExtraData) {
        this.pageInfoExtraData = pageInfoExtraData;
    }

    @Transient
    public PageInfoExtraData getPageInfoExtra() {
        return pageInfoExtra;
    }

    public void setPageInfoExtra(PageInfoExtraData pageInfoExtra) {
        this.pageInfoExtra = pageInfoExtra;
    }

    @Column(name = "DISABLEDTYPE")
    public int getDisabledType() {
        return disabledType;
    }

    public void setDisabledType(int disabledType) {
        this.disabledType = disabledType;
    }

    @Column(name = "DISABLEDREASON")
    public String getDisabledReason() {
        return disabledReason;
    }

    public void setDisabledReason(String disabledReason) {
        this.disabledReason = disabledReason;
    }

    private TemplateData templateData;// 模版对象
    private List<PageServiceData> pageServiceDataList;// 使用该配置所有服务集
    private TemplateThumbnailData templateThumbnailData;

    @Transient
    public TemplateThumbnailData getTemplateThumbnailData() {
        return templateThumbnailData;
    }

    public void setTemplateThumbnailData(TemplateThumbnailData templateThumbnailData) {
        this.templateThumbnailData = templateThumbnailData;
    }

    @Transient
    public TemplateData getTemplateData() {
        return templateData;
    }

    public void setTemplateData(TemplateData templateData) {
        this.templateData = templateData;
    }

    @Transient
    public List<PageServiceData> getPageServiceDataList() {
        return pageServiceDataList;
    }

    public void setPageServiceDataList(List<PageServiceData> pageServiceDataList) {
        this.pageServiceDataList = pageServiceDataList;
    }

    @Column(name = "CREATE_TYPE")
    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    @Transient
    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Transient
    public PageTemplateData getPageTemplateData() {
        return pageTemplateData;
    }

    public void setPageTemplateData(PageTemplateData pageTemplateData) {
        this.pageTemplateData = pageTemplateData;
    }

    private int use;

    @Transient
    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }

    @Transient
    public List<PrivilegeData> getPrivilegeDatas() {
        return privilegeDatas;
    }

    public void setPrivilegeDatas(List<PrivilegeData> privilegeDatas) {
        this.privilegeDatas = privilegeDatas;
    }

    @Column(name = "CONTENT")
    public Clob getContent() {
        return content;
    }

    public void setContent(Clob content) {
        this.content = content;
    }

    @Column(name = "PUBLISH_TIME")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }


    @Column(name="PAGEIMG")
    public String getPageImg() {
		return pageImg;
	}

	public void setPageImg(String pageImg) {
		this.pageImg = pageImg;
	}

	private Integer stepNum;

    @Transient
    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    @Transient
    public List<PageProductData> getPageProductDatas() {
        return pageProductDatas;
    }

    public void setPageProductDatas(List<PageProductData> pageProductDatas) {
        this.pageProductDatas = pageProductDatas;
    }
    @Transient
	public ShoppingCartData getShoppingCartData() {
		return shoppingCartData;
	}

	public void setShoppingCartData(ShoppingCartData shoppingCartData) {
		this.shoppingCartData = shoppingCartData;
	}
	@Transient
    public String getNoPayForState() {
        return noPayForState;
    }

    public void setNoPayForState(String noPayForState) {
        this.noPayForState = noPayForState;
    }
    @Transient
	public String getPricreCredible() {
		return pricreCredible;
	}

	public void setPricreCredible(String pricreCredible) {
		this.pricreCredible = pricreCredible;
	}
	@Transient
	public String getPricreService() {
		return pricreService;
	}

	public void setPricreService(String pricreService) {
		this.pricreService = pricreService;
	}

	@Transient
	public String getPageStatusCredible() {
		return pageStatusCredible;
	}

	public void setPageStatusCredible(String pageStatusCredible) {
		this.pageStatusCredible = pageStatusCredible;
	}
	@Transient
	public String getPageStatusService() {
		return pageStatusService;
	}

	public void setPageStatusService(String pageStatusService) {
		this.pageStatusService = pageStatusService;
	}

	@Transient
	public String getHasShop() {
		return hasShop;
	}

	public void setHasShop(String hasShop) {
		this.hasShop = hasShop;
	}

	@Transient
	public String getHasOrder() {
		return hasOrder;
	}

	public void setHasOrder(String hasOrder) {
		this.hasOrder = hasOrder;
	}

	@Transient
    public Integer getMessageBoardNum() {
        return messageBoardNum;
    }

    public void setMessageBoardNum(Integer messageBoardNum) {
        this.messageBoardNum = messageBoardNum;
    }
    @Column(name="ZING")
    public String getZing() {
        return zing;
    }

    public void setZing(String zing) {
        this.zing = zing;
    }
    @Transient
    public String getCompCon() {
        return compCon;
    }

    public void setCompCon(String compCon) {
        this.compCon = compCon;
    }
    
  

	

}
