package com.mini.product.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;



import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.product.business.IProductBusiness;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
/**
 *〈服务 Service实现类〉
 *〈功能详细描述〉
 * @author     [作者]（hy）
 * @see        [相关类/方法]（可选）
 * @since      [产品/模块版本] （可选）
 */
@Component("productService")
public class ProductService extends FrmService implements IProductService{
	@Resource(name="productBusiness")
	private IProductBusiness productBusiness;
	@SuppressWarnings("static-access")
	/**
	 * @author 侯杨
	 * date 2014-03-06
	 * 后台服务管理，分页查询所有
	 * @param pageRoll  分页
	 * @param productData  条件查询
	 * @return
	 */
	@Override
	public List<ProductData> getAll(PageRoll pageRoll, ProductData productData,Integer sort) {
		 pageRoll = pageRoll.set(Page.SIZE_10, pageRoll);
		return productBusiness.getAll(pageRoll, productData,sort);
	}
	/**
	 * @author 侯杨
	 * date 2014-03-06
	 * 后台服务管理增加服务
	 * @param productData
	 */
	@Override
	public void addProduct(ProductData productData,File fileMain) {
		productBusiness.addProduct(productData,fileMain);
	}
	/**
	 * @author 侯杨
	 * date 2014-03-06
	 * 后台服务管理删除服务
	 * @param productData
	 */
	@Override
	public void deleteProduct(String id[]) {
		if(id.length>0){
			for (int i = 0; i < id.length; i++) {
				productBusiness.deleteProduct(id[i]);
			}
		}
		
	}
	/**
	 * @author 侯杨
	 * date 2014-03-06
	 * 后台服务管理修改服务
	 * @param productData
	 */
	@Override
	public void updateProduct(ProductData productData) {
	productBusiness.updateProduct(productData);	
	}
	/**
	 * 查找所有产品名称 -- 在添加或者修改的时候服务名称不能相同
	 * 
	 * @author hy
	 * @date 2014-03-06
	 * @return
	 */
	public ProductData getAllProductName(String productName) {
		return productBusiness.getAllProductName(productName);
	}
	/**
	 * 根据id查询服务详情
	 * @author hy
	 * @date 2014-03-06
	 * @param id
	 * @return
	 */
	public  ProductData getProductData(String id){
		return productBusiness.getProductData(id);
	}
	/**
	 * 根据用户id查询出数据，然后查询出page，在查询出服务
	 * @param userId
	 * @return
	 */
	public  List<PageProductData> getAll(String userId){
		if(userId!="" && !"".equals(userId)){   //用户id 不为空  ，就查询出来，反之返回一个空
			return productBusiness.getAll(userId);
		}else{
			return  null;
		}
	}
	

	/**
	 * 停用page所使用的服务
	 * @author hy
	 * @date 2013-03-08
	 * @param pageProductData
	 * @param id
	 */

	public void stopPageProduct(PageProductData pageProductData){
		productBusiness.stopPageProduct(pageProductData);
	}
	/**
	 * 处理cookie   读取cookie数据中的id 获取在数据库中对应的集合
	 * @param object
	 * @return
	 */
	@Override
	public List<PageData> getProductDataByCookie(String json) {
		return productBusiness.getProductDataByCookie(json);
	}
	/**
	 * @author hy
	 * @date 2014-3-12
	 * 后台服务管理 关闭服务
	 * @param productData
	 */
	public void updateProductState(ProductData productData){
		productBusiness.updateProductState(productData);
	}
	/**
	 * 更新服务  更新page电话号码
	 * @author hy
	 * @date 2014-03-13
	 * @param productData
	 * @param pageId
	 */
		public String updateProductPagePhone(PageProductData pageProductData,String pageId,String phone){
			return	productBusiness.updateProductPagePhone(pageProductData, pageId, phone);
		}

	    /**
	     * 修改page电话号码
	     * 
	     * @author 左香勇
	     * @date 2014-04-30
	     * @param productData
	     * @param pageId
	     */
	    public void editProductPagePhone(PageProductData pageProductData, String pageId, String oldPhone, String phone){
	    	productBusiness.editProductPagePhone(pageProductData, pageId, oldPhone, phone);
	    }
		/**
		 * 更新服务，启动  上传文件  
		 * @author 侯杨
		 * @date 2014-03-13
		 * @param pageProductData
		 */
		public String updateProductPageFile(PageProductData pageProductData){
			return	productBusiness.updateProductPageFile(pageProductData);
			}
        @Override
        public List<ProductData> getAllProduct(ProductData productData) {
            return productBusiness.getAllProduct(productData);
        }
        @Override
        public List<List<ProductData>> getProductNoDomain(String decode) {
            return productBusiness.getProductNoDomain(decode);
        }
        @Override
        public List<List<ProductData>> getProductNoPage(String decode) {
            return productBusiness.getProductNoPage(decode);
        }
        /**
         * 根据自定义条件返回对象集合
         * @author 林海鹏
         * @date 2014-03-06
         * @param id
         * @return
         */
        @Override
        public List<ProductData> getProductDataByJson(JSONObject object) {
            return productBusiness.getProductDataByJson(object);
        }
        
        //根据特殊标识查询出发布权限的服务信息
		@Override
		public ProductData findBySign(int i) {
			return productBusiness.findBySign(i);
		}
		
		//检查productid的来源，并返回product对象
		@Override
		public List<ProductData> checkProduct(String[] productid) {
			return productBusiness.checkProduct( productid);
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
	        return productBusiness.getProductDataByIdStr(str);
	    }
	    /** 服务管理，启用在线客服这款服务，部署talk99
		 * @author hy
		 * @date 2014-04-17
		 * @param contenu
		 * @param data
		 * @return
		 */
	   @Override
		public String  updatePageProductTak(String contenu,PageProductData data){
		   return productBusiness.updatePageProductTak(contenu, data);
	   }
	   
		/**
		 * 根据pageid和userid查询shoppingcart里面的所有该page的服务的集合
		 * @param id
		 * @param userid
		 * @return
		 */
		@Override
		public List<ProductData> getShopProductByPageId(String id, String userid) {
			return productBusiness.getShopProductByPageId( id,  userid);
		}
		
		
        @Override
        public List<ProductData> getProductByPageId(String pageId) {
            return productBusiness.getProductByPageId(pageId);
        }
        /**
         * 根据pageid查询page所拥有的域名
         * @author 侯杨
         * @date 2014-04-30
         * @param pageId
         * @return
         */
        public PageInfoExtraData getPageDomain(String pageId){
        	  return productBusiness.getPageDomain(pageId);
        }
        /**
         * 修改在线客服的预览效果
         * @author 冯鑫
         * @date 2014-06-12
         * @param pageID
         * @return
         */
        public void editOnLineProduct(PageData pageData) {
            // TODO Auto-generated method stub
            productBusiness.editOnLineProduct(pageData);
            
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
        @Override
        public  ProductData getPrdouct(ProductData productData){
            return productBusiness.getPrdouct(productData);
        }
        @Override
        public List<PageProductData> getAllProductPageRoll(String userId, PageRoll pageRoll) {
            pageRoll = pageRoll.set(Page.SIZE_10, pageRoll); 
            return productBusiness.getAllProductPageRoll(userId,pageRoll);
        }
  }
