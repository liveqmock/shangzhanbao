package com.mini.back.product.facade;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;
import com.mini.product.data.ProductData;
import com.mini.product.service.IProductService;

@Component("productFacade")
public class ProductFacade extends FrmFacade {
    // 服务service 接口
    @Resource(name = "productService")
    private IProductService productService;

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理，分页查询所有
     * @param pageRoll 分页
     * @param productData 条件查询
     * @return
     */
    public List<ProductData> getAll(PageRoll pageRoll, ProductData productData,Integer sort) {
        // TODO Auto-generated method stub
        return productService.getAll(pageRoll, productData,sort);
    }

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理增加服务
     * @param productData
     */

    public void addProduct(ProductData productData, File fileMain) {
        // TODO Auto-generated method stub
        productService.addProduct(productData, fileMain);
    }

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理删除服务
     * @param productData
     */
    public void deleteProduct(String ids[]) {
        // TODO Auto-generated method stub
        productService.deleteProduct(ids);
    }

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理修改服务
     * @param productData
     */
    public void updateProduct(ProductData productData) {
        // TODO Auto-generated method stub
        productService.updateProduct(productData);
    }

    /**
     * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
     * 
     * @author hy
     * @date 2014-03-06
     * @return
     */
    public ProductData getAllProductName(String productName) {
        return productService.getAllProductName(productName);
    }

    /**
     * 根据id查询服务详情
     * 
     * @author hy
     * @date 2014-03-06
     * @param id
     * @return
     */
    public ProductData getProductData(String id) {
        return productService.getProductData(id);
    }


    /**
     * 处理cookie 读取cookie数据中的id 获取在数据库中对应的集合
     * 
     * @param object
     * @return
     */
    public List<PageData> getProductDataByCookie(String object) {
        return productService.getProductDataByCookie(object);
    }

    /**
     * @author hy
     * @date 2014-3-12 后台服务管理 关闭服务或者启用服务
     * @param productData
     */
    public void updateProductState(ProductData productData) {
        productService.updateProductState(productData);
    }

    /**
     * 
     * 查询所有可用服务<br>
     * 
     * @author 文东 <br>
     *         2014-3-14
     * @update
     * @param productData 查询条件
     * @return List<ProductData> 服务集合
     * @exception/throws
     * @see ProductFacade#getAllProduct(ProductData)
     * @since [起始版本]
     */
    public List<ProductData> getAllProduct(ProductData productData) {
        return productService.getAllProduct(productData);
    }

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
     * @see ProductFacade#getProductNoDomain(String)
     * @since
     */
    public List<List<ProductData>> getProductNoDomain(String decode) {
        return productService.getProductNoDomain(decode);
    }

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
     * @see ProductFacade#getProductNoPage(String)
     * @since
     */
    public List<List<ProductData>> getProductNoPage(String decode) {
        return productService.getProductNoPage(decode);
    }
    
    /**
     * 根据自定义条件返回对象集合
     * 
     * @author 林海鹏
     * @date 2014-03-06
     * @param id
     * @return
     */
    public List<ProductData> getProductDataByJson(JSONObject object) {
        // TODO Auto-generated method stub
        return productService.getProductDataByJson(object);
    }

    
  //根据特殊标识查询出发布权限的服务信息
	public ProductData findBySign(int i) {
		return productService.findBySign(i);
	}

	//检查productid的来源，并返回product对象
	public List<ProductData> checkProduct(String[] productid) {
		return productService.checkProduct(productid);
	}
	 /**
     * 
     *根据json串查询所有的Product
     * 
     * @author 冯鑫 <br> 
     *         2014-4-16
     * @update 
     * @param JSONObject json 中为多个id
     */
    public List<ProductData> getProductDataByIdStr(String str){
        return productService.getProductDataByIdStr(str);
    }

	/**
	 * 根据pageid和userid查询shoppingcart里面的所有该page的服务的集合
	 * @param id
	 * @param userid
	 * @return
	 */
	public List<ProductData> getShopProductByPageId(String id, String userid) {
		return productService.getShopProductByPageId(id, userid);
	}
	
	/**
	 * 
	 * 根据PageId 查询出Page所拥有的服务<br>
	 * 
	 * @author 文东 <br> 
	 *		   2014-4-24
	 * @update 
	 * @param pageId
	 * @return  List<ProductData>
	 * @exception/throws 
	 * @see   ProductFacade#getProductByPageId(String)
	 * @since 
	 */
    public List<ProductData> getProductByPageId(String pageId) {

        return productService.getProductByPageId(pageId);
    }
    
    /**
     * 修改在线客服的预览效果
     * @author 冯鑫
     * @date 2014-06-12
     * @param pageID
     * @return
     */
    public void editOnLineProduct(PageData pageData) {
        productService.editOnLineProduct(pageData);
    }
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
    public  ProductData getPrdouct(ProductData productData){
        return productService.getPrdouct(productData);
    }
}
