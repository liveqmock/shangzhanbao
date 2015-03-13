package com.mini.product.business;

import java.io.File;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;

/**
 * 〈服务 接口〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IProductBusiness extends IBusiness {
    /**
     * @author 侯杨 date 2014-03-06 后台服务管理，分页查询所有
     * @param pageRoll 分页
     * @param productData 条件查询
     * @return
     */
    public List<ProductData> getAll(PageRoll pageRoll, ProductData productData,Integer sort);

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理增加服务
     * @param productData
     */
    public void addProduct(ProductData productData, File fileMain);

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理删除服务
     * @param productData
     */
    public void deleteProduct(String id);

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理修改服务
     * @param productData
     */
    public void updateProductState(ProductData productData);

    /**
     * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
     * 
     * @author 侯杨
     * @date 2014-03-06
     * @return
     */
    public ProductData getAllProductName(String productName);

    /**
     * 根据id查询服务详情
     * 
     * @author 侯杨
     * @date 2014-03-06
     * @param id
     * @return
     */
    public ProductData getProductData(String id);

    /**
     * 根据用户id查询出数据，然后查询出page，在查询出服务
     * 
     * @param userId
     * @return
     */
    public List<PageProductData> getAll(String userId);

    /**
     * 停用page所使用的服务
     * 
     * @author 侯杨
     * @date 2013-03-08
     * @param pageProductData
     */
    public void stopPageProduct(PageProductData pageProductData);


    /**
     * 处理cookie
     * 
     * @param object
     * @return
     */
    public List<PageData> getProductDataByCookie(String json);

    /**
     * @author 侯杨
     * @date 2014-3-12 后台服务管理 关闭服务或者启用服务
     * @param productData
     */
    public void updateProduct(ProductData productData);

    /**
     * 更新服务 更新page电话号码
     * 
     * @author 侯杨
     * @date 2014-03-13
     * @param productData
     * @param pageId
     */
    public String updateProductPagePhone(PageProductData pageProductData, String pageId, String phone);


    /**
     * 修改page电话号码
     * 
     * @author 左香勇
     * @date 2014-04-30
     * @param productData
     * @param pageId
     */
    public void editProductPagePhone(PageProductData pageProductData, String pageId, String oldPhone, String phone);
    
    /**
     * 更新服务，启动 上传文件
     * 
     * @author 侯杨
     * @date 2014-03-13
     * @param pageProductData
     */
    public String updateProductPageFile(PageProductData pageProductData);

    /**
     * 
     * 查询所有可用服务<br>
     * 
     * @author 文东 <br>
     *         2014-3-14
     * @update
     * @param productData
     * @return List<ProductData>
     * @exception/throws
     * @see IProductBusiness
     * @since
     */
    public List<ProductData> getAllProduct(ProductData productData);

    /**
     * 
     *获取购物车中没有域名的服务<br>
     * 
     * @author 文东 <br> 
     *		   2014-4-3
     * @update 
     * @param decode String类型的json字符串
     * @return List<ProductData> 服务集合
     * @exception/throws 
     * @see   IProductBusiness#getProductNoDomain(String)
     * @since
     */
    public List<List<ProductData>> getProductNoDomain(String decode);

    /**
     * 
     *获取购物车中没有Page的服务<br>
     * 
     * @author 文东 <br> 
     *         2014-4-3
     * @update 
     * @param decode String类型的json字符串
     * @return List<ProductData> 服务集合
     * @exception/throws 
     * @see   IProductBusiness#getProductNoPage(String)
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
    
    //根据特殊标识查询出发布权限的服务信息
	public ProductData findBySign(int i);

	
	//检查productid的来源，并返回product对象
	public List<ProductData> checkProduct(String[] productid);
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
    
    /**
	 * 服务管理，启用在线客服这款服务，部署talk99
	 * @author 侯杨
	 * @date 2014-04-17
	 * @param contenu
	 * @param data
	 * @return
	 */
	public String  updatePageProductTak(String contenu,PageProductData data);

	/**
	 * 根据pageid和userid查询shoppingcart里面的所有该page的服务的集合
	 * @param id
	 * @param userid
	 * @return
	 */
	public List<ProductData> getShopProductByPageId(String id, String userid);

	 /**
     * 
     * 根据PageId查询Page所拥有的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-24
     * @update
     * @param pageId
     * @return List<ProductData> 服务集合
     * @exception/throws
     * @see IProductBusiness#getProductByPageId(String)
     * @since
     */
    public List<ProductData> getProductByPageId(String pageId);
    
    /**
     * 根据pageid查询page所拥有的域名
     * @author 侯杨
     * @date 2014-04-30
     * @param pageId
     * @return
     */
    public PageInfoExtraData getPageDomain(String pageId);
    /**
     * 修改在线客服的预览效果
     * @author 冯鑫
     * @date 2014-06-12
     * @param pageID
     * @return
     */
    public void editOnLineProduct(PageData pageData) ;
    /**
     * 
     *根据productData  实体查询服务详情<br>
     * 
     * @author li <br> 
     *         2014-7-14
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public  ProductData getPrdouct(ProductData productData);

    /**
     * 
     * 根据用户id分页查询服务<br>
     * 
     * @author 文东 <br> 
     *         2014年9月15日
     * @update 
     * @param userId 用户id
     * @param pageRoll 分页对象
     * @return List<PageProductData> 服务对象集合
     * @exception/throws 
     * @see   IProductBusiness#getAllProductPageRoll(String, PageRoll)
     * @since vmaque1.5
     */
    public List<PageProductData> getAllProductPageRoll(String userId, PageRoll pageRoll);
}
