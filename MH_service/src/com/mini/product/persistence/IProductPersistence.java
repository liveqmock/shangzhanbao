package com.mini.product.persistence;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.page.data.PageData;
import com.mini.product.business.IProductBusiness;
import com.mini.product.data.ProductData;

/**
 * 〈服务 Persistence 接口〉 〈功能详细描述〉
 * 
 * @author [作者]（hy）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IProductPersistence extends IBasePersistence<ProductData> {
    /**
     * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
     * 
     * @author hy
     * @date 2014-03-06
     * @return
     */
    public List<ProductData> getAllProductName(String productName);

    /**
     * 处理cookie
     * 
     * @param object
     * @return
     */
    public List<PageData> getProductDataByCookie(String goods);

    /**
     * 
     *〈根据id查询实体信息〉<br>
     * 
     * @author wendong <br> 
     *		   2014-4-14
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public ProductData getProductDataByid(String id);
    
    /**
     * 
     * 获取购物车中没有域名的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-3
     * @update
     * @param decode String类型的json字符串
     * @return List<ProductData> 服务集合
     * @exception/throws
     * @see IProductBusiness#getProductNoDomain(String)
     * @since
     */
    public List<List<ProductData>> getProductNoDomain(String decode);

    /**
     * 
     * 获取购物车中没有Page的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-3
     * @update
     * @param decode String类型的json字符串
     * @return List<ProductData> 服务集合
     * @exception/throws
     * @see IProductBusiness#getProductNoPage(String)
     * @since
     */
    public List<List<ProductData>> getProductNoPage(String decode);

    /**
     * 根据自定义条件返回对象集合
     * 
     * @author 林海鹏
     * @date 2014-03-06
     * @param id
     * @return
     */
    public List<ProductData> getProductDataByJson(JSONObject object);
    /**
     * 购物车查询   跟用用户
     * @author hy
     * @date 2014-4-09
     * @param userId
     * @return
     */
    public List<PageData> getShoppingCartData(String userId);

    //根据特殊标识查询出发布权限的服务信息
	public ProductData findBySign(int i);
	/**
     * 
     *根据json串查询所有的Product
     * 
     * @author 冯鑫 <br> 
     *         2014-4-16
     * @update 
     * @param JSONObject json 中为多个id
     */
    public List<ProductData> getProductDataByIdStr(String str);
}
