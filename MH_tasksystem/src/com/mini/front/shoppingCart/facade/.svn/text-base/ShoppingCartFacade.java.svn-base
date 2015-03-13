package com.mini.front.shoppingCart.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.page.data.PageData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.service.IShoppingCartServices;
@Component("shoppingCartFacade")
public class ShoppingCartFacade extends FrmFacade{
	@Resource(name="shoppingCartServices")
	private IShoppingCartServices shoppingCartServices;   
	/**
	 * 购物车数据添加
	 * @author hy
	 * @date 2014-4-08
	 * @param date
	 */
	
	public String addShoppingCartData(ShoppingCartData data,String name) {
	return	shoppingCartServices.addShoppingCartData(data,name);
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
        shoppingCartServices.editNoPayProductState(pageID, noPayProductId);
    }

	/**
	 * 根据用户id 查询   当前用户的购物车信息
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */
	public List<PageData> getAll(String userId) {		
		return shoppingCartServices.getAll(userId);
	}
	/**
	 * 根据用户id 查询   当前用户的购物车数量
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */
	
	public int getCount(String userId){
		return shoppingCartServices.getCount(userId);
	}
	/**
	 * 删除数据  假删
	 * @author hy
	 * @date 2014-4-08
	 * @param userId
	 * @return
	 */

	public  String  updateShoppingCartData(ShoppingCartData date){
		return shoppingCartServices.updateShoppingCartData(date);
	}
	/**
	 * 购买发布权限  添加数据 如果存在就修改
	 * @author hy
	 * @date 2014-04-09
	 * @param date
	 * @return
	 */
	
	public  List<ProductData> updateSaveShoppingCartData(String userId,String sign){
		return shoppingCartServices.updateSaveShoppingCartData(userId, sign);
	}
	
	/**
	 * 根据用户id  查询出  官方发布权限这条数据
	 * @param userId
	 * @return
	 */
	public List<ProductData> getShoppingCartDataP(String userId){
		return shoppingCartServices.getShoppingCartDataP(userId);
	}
	/**
	 * 查出当前用户所以服务
	 * @author hy
	 * @date 2014-04-10
	 * @param userId
	 * @return
	 */
	public List<ProductData> getShoppingCartData(String userId){
		return shoppingCartServices.getShoppingCartData(userId);
	}
	/**
	 * 根据用户id 查询   购物车信息
	 * @author hy
	 * @date 2014-4-12
	 * @param userId
	 * @return
	 */

	public List<ShoppingCartData> getshopp(String userId){
		return shoppingCartServices.getshopp(userId);
	}
}
