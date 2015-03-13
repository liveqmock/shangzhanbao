package com.mini.shoppingCart.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.mini.page.data.PageData;
import com.mini.product.data.ProductData;

/**
 * 〈购物车〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_SHOPPINGCART")
public class ShoppingCartData extends FrmData{
	
	private String userId;  //用户id
	private String productId; //服务id
	private  String pageId;  //pageid
	private Integer isDelete;  //是否删除
	private Integer num;  //数量
	
	private String price;  //价格
	@Column(name="USERID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="PRODUCTID")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Column(name="PAGEID")
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
	@Column(name="ISDELETE")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name="NUM")
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name="PRICE")
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}


	private ProductData productData;  //服务实体
	private PageData pageData;  //page实体
	@Transient
	public ProductData getProductData() {
		return productData;
	}
	public void setProductData(ProductData productData) {
		this.productData = productData;
	}
	@Transient
	public PageData getPageData() {
		return pageData;
	}
	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
	

}
