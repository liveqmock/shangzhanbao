package com.mini.shoppingCart.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.shoppingCart.data.ShoppingCartData;
/**
 * 〈购物车Persistence  接口〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface IShoppingCartPersistence  extends IBasePersistence<ShoppingCartData>{

    /**
     * 
     *〈一句话功能简述〉<br>
     * 
     * @author wendong <br> 
     *		   2014-4-10
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public ShoppingCartData searchByPageIdAndProductId(String id, String string);
	
    /**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-4-9
     * @update 
     * @param String pageID,String noPayProductId
     */
    public void editNoPayProductState(String pageID,String noPayProductId);
    
    /**
     * 查看page在购物车是否有没有结算的服务，有的话返回购物车集合
     * dlm
     * @param pageid
     * @return
     */
    public List<ShoppingCartData> getShopCartsByPage(String pageid);
}
