package com.mini.product.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.order.data.OrderProductData;
import com.mini.product.business.IPageProductBusiness;
import com.mini.product.data.PageProductData;
import com.mini.shoppingCart.business.IShoppingCartBusiness;
import com.mini.shoppingCart.data.ShoppingCartData;
/**
 * page服务中间表服务接口实现类
 * 
 * @author 林海鹏
 * @see PageProductService
 * @since
 */
@Component("pageProductService")
public class PageProductService extends FrmService implements
		IPageProductService {
	@Resource(name="pageProductBusiness")
	private IPageProductBusiness pageProductBusiness;
	
	@Resource(name = "shoppingCartBusiness")
	private IShoppingCartBusiness shoppingCartBusiness;
	
	public void setPageProductBusiness(IPageProductBusiness pageProductBusiness) {
		this.pageProductBusiness = pageProductBusiness;
	}

	@Override
	public void addPageProduct(PageProductData data) {
	    if(data.getProductPrice()==null || "".equals(data.getProductPrice())){// 表示免费服务 
	        shoppingCartBusiness.addShopCartNoPrice(data);
	    }else if(data.getProductPrice()!=null && !"".equals(data.getProductPrice())){// 表示付费服务
	        ShoppingCartData cartData = new ShoppingCartData();
	        cartData.setUserId(data.getUserId());// 用户ID
	        cartData.setIsDelete(1);// 数据有效 业务上存在
	        cartData.setPageId(data.getPageId());// pageId
	        cartData.setProductId(data.getProductId());// 服务Id
	        cartData.setNum(1);// 数量
	        shoppingCartBusiness.addShoppingCartData(cartData, data.getProductName());
	    }
	}

	@Override
	public void deletePageProduct(String[] ids) {
		pageProductBusiness.deletePageProduct(ids);
	}

	@Override
	public void editPageProduct(PageProductData data) {
		pageProductBusiness.editPageProduct(data);
	}

	@Override
	public List<PageProductData> getPageProductDataByJson(JSONObject object) {
		return pageProductBusiness.getPageProductDataByJson(object);
	}

	 /**
     * 根据Page服务中间表id查询实体信息
     * @param id
     * @return
     */
    public PageProductData getPageProductByid(String id){
    	return pageProductBusiness.getPageProductByid(id);
    }
	
    @Override
    public PageProductData getPageProductData(OrderProductData orderProductData) {
        return pageProductBusiness.getPageProductData(orderProductData);
    }

    @Override
    public void editOrAddByPageIdAndProductId(PageProductData pageProductData) {
        pageProductBusiness.editOrAddByPageIdAndProductId(pageProductData);
    }

    @Override
    public void delPageProduct(PageProductData pageProductData) {
        // 根据PageId和服务ID，用户ID删除购物车中的信息
        ShoppingCartData cartData = new ShoppingCartData();
        cartData.setUserId(pageProductData.getUserId());
        cartData.setPageId(pageProductData.getPageId());
        cartData.setProductId(pageProductData.getProductId());
        shoppingCartBusiness.delShopCart(cartData);
        // 删除Page服务中间表的信息
        pageProductBusiness.delPageProduct(pageProductData);
    }

    @Override
    public void editTel(PageProductData pageProductData) {
        pageProductBusiness.editTel(pageProductData);        
    }

}
