package com.mini.shoppingCart.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.shoppingCart.data.ShoppingCartData;

/**
 * 〈购物车Persistence  实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("shoppingCartPersistence")
public class ShoppingCartPersistence extends BasePersistence<ShoppingCartData>  implements IShoppingCartPersistence {
    /**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * 当用户有未付款成功的订单时  再次进入购物车得显示未付款成功的商品
     * @author 冯鑫 <br> 
     *		   2014-4-9
     * @update fengixn
     *        2014-4-18
     * @param String pageID,String noPayProductId
     */
    public void editNoPayProductState(String pageID,String noPayProductId){
        StringBuffer str = new StringBuffer();
        str.append(" update MINI_SHOPPINGCART set ISDELETE=1 where 1=1");
        str.append(" and PAGEID='"+pageID+"'");
        if(null!=noPayProductId&&!"".equals(noPayProductId)){
            noPayProductId = noPayProductId.substring(1, noPayProductId.length()-1);
            String[] strid  = noPayProductId.split(",");
            if(strid.length>0){
                for (int i = 0; i < strid.length; i++) {
                    str.append(" and PRODUCTID='"+strid[i]+"'");
                }
            }
        }
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        dao.executeSQL(str.toString());
    }
    @Override
    public ShoppingCartData searchByPageIdAndProductId(String id, String string) {
        return null;
    }

    
    
    
    /**
     * 查看page在购物车是否有没有结算的服务，有的话返回购物车集合
     * dlm
     * @param pageid
     * @return
     */
    public List<ShoppingCartData> getShopCartsByPage(String pageid){
    	
    	String shopHql=" from ShoppingCartData sd where sd.pageId=? and sd.isDelete=1";
    	List<ShoppingCartData> list = search(shopHql, new Object[]{pageid});
    	return list;
    	
    }
    
    
}
