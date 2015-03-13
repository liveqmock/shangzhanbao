package com.mini.shoppingCart.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.data.ShoppingCartData;

/**
 * 〈购物车Business 接口类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface IShoppingCartBusiness extends IBusiness {
    /**
     * 购物车数据添加
     * 
     * @author hy
     * @date 2014-4-08
     * @param date
     */
    public String addShoppingCartData(ShoppingCartData date, String name);

    /**
     * 根据用户id 查询 当前用户的购物车信息
     * 
     * @author hy
     * @date 2014-4-08
     * @param userId
     * @return
     */
    public List<PageData> getAll(String userId);

    /**
     * 根据用户id 查询 当前用户的购物车数量
     * 
     * @author hy
     * @date 2014-4-08
     * @param userId
     * @return
     */
    public int getCount(String userId);

    /**
     * 删除数据 假删
     * 
     * @author hy
     * @date 2014-4-08
     * @param userId
     * @return
     */
    public String updateShoppingCartData(ShoppingCartData date);

    /**
     * 购买发布权限 添加数据 如果存在就修改
     * 
     * @author hy
     * @date 2014-04-09
     * @param date
     * @return
     */
    public List<ProductData> updateSaveShoppingCartData(String userId, String sign);

    /**
     * 根据用户id 查询出 官方发布权限这条数据
     * 
     * @param userId
     * @return
     */
    public List<ProductData> getShoppingCartDataP(String userId);

    /**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param String pageID,String noPayProductId
     */
    public void editNoPayProductState(String pageID, String noPayProductId);

    /**
     * 查出当前用户所以服务
     * 
     * @author hy
     * @date 2014-04-10
     * @param userId
     * @return
     */
    public List<ProductData> getShoppingCartData(String userId);

    /**
     * 添加 不要价格的购物车信息
     * 
     * @param pricr
     * @param pageId
     * @param productId
     * @param userId
     * @param productName
     * @return
     */
    public String addShopCartNoPrice(PageProductData data);

    /**
     * 根据用户id 查询 购物车信息
     * 
     * @author hy
     * @date 2014-4-12
     * @param userId
     * @return
     */

    public List<ShoppingCartData> getshopp(String userId);

    /**
     * 
     * 根据查询得到的结果删除购物车中的信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @param cartData 存放查询参数
     * @return void
     * @exception/throws
     * @see IShoppingCartBusiness#delShopCart(ShoppingCartData)
     * @since
     */
    public void delShopCart(ShoppingCartData cartData);
}
