package com.mini.shoppingCart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.business.IShoppingCartBusiness;
import com.mini.shoppingCart.data.ShoppingCartData;
/**
 * 〈购物车Service  实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("shoppingCartServices")
public class ShoppingCartServices extends FrmService implements IShoppingCartServices{
	@Resource(name="shoppingCartBusiness")
	private IShoppingCartBusiness shoppingCartBusiness;   
	/**
	 * 购物车数据添加
	 * @author hy
	 * @date 2014-4-08
	 * @param date
	 */
	@Override
	public String addShoppingCartData(ShoppingCartData data,String name) {
		return shoppingCartBusiness.addShoppingCartData(data,name);
	}
	/**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-4-9
     * @update 
     * @param String pageID,String noPayProductId
     */
    public void editNoPayProductState(String pageID,String noPayProductId){
        shoppingCartBusiness.editNoPayProductState(pageID, noPayProductId);
    }
	
	/**
	 * 根据用户id 查询   当前用户的购物车信息
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */
	@Override
	public List<PageData> getAll(String userId) {
		
		
		return shoppingCartBusiness.getAll(userId);
	}
	
	
	/**
	 * 根据用户id 查询   当前用户的购物车数量
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */
	@Override
	public int getCount(String userId){
		return shoppingCartBusiness.getCount(userId);
	}
	/**
	 * 删除数据  假删
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */
	@Override
	public  String  updateShoppingCartData(ShoppingCartData date){
		return shoppingCartBusiness.updateShoppingCartData(date);
	}
	
	
	/**
	 * 购买发布权限  添加数据 如果存在就修改
	 * @author hy
	 * @date 2014-04-09
	 * @param date
	 * @return
	 */
	@Override
	public  List<ProductData> updateSaveShoppingCartData(String userId,String sign){
		return shoppingCartBusiness.updateSaveShoppingCartData(userId, sign);
	}
	
	
	/**
	 * 根据用户id  查询出  官方发布权限这条数据
	 * @param userId
	 * @return
	 */
	public List<ProductData> getShoppingCartDataP(String userId){
		return shoppingCartBusiness.getShoppingCartDataP(userId);
	}
	
	/**
	 * 查出当前用户所以服务
	 * @author hy
	 * @date 2014-04-10
	 * @param userId
	 * @return
	 */
	public List<ProductData> getShoppingCartData(String userId){
		return shoppingCartBusiness.getShoppingCartData(userId);
	}

	/**
	 * 添加  不要价格的购物车信息
	 * @param pricr
	 * @param pageId
	 * @param productId
	 * @param userId
	 * @param productName
	 * @return
	 */
	public String addShopCartNoPrice(PageProductData data){
		 return shoppingCartBusiness.addShopCartNoPrice(data);
		
	}
	
	
	/**
	 * 根据用户id 查询   购物车信息
	 * @author hy
	 * @date 2014-4-12
	 * @param userId
	 * @return
	 */

	public List<ShoppingCartData> getshopp(String userId){
		 return shoppingCartBusiness.getshopp(userId);
	}
	
	
	public IShoppingCartBusiness getShoppingCartBusiness() {
		return shoppingCartBusiness;
	}
	public void setShoppingCartBusiness(IShoppingCartBusiness shoppingCartBusiness) {
		this.shoppingCartBusiness = shoppingCartBusiness;
	}
	
	
}
