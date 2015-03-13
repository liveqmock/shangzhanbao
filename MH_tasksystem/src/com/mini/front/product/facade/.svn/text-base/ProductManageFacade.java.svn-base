package com.mini.front.product.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.product.data.PageProductData;
import com.mini.product.service.IPageProductService;
import com.mini.product.service.IProductService;

@Component("productManageFacade")
public class ProductManageFacade extends FrmFacade {
    // 服务service 接口
    @Resource(name = "productService")
    private IProductService productService;
    
    @Resource(name="pageProductService")
    private IPageProductService pageProductService;

    /**
     * 根据用户id查询出数据，然后查询出page，在查询出服务
     * 
     * @update 修改人：文东
     *         修改内容：改成分页查询
     * 
     * @param userId 用户id
     * @param pageRoll 分页对象
     * @return
     */
    public List<PageProductData> getAll(String userId,PageRoll pageRoll) {
        return productService.getAllProductPageRoll(userId,pageRoll);
    }

    public PageProductData getPageProductByid(String id){
    	return pageProductService.getPageProductByid(id);
    }
    
    /**
     * 停用page所使用的服务
     * 
     * @author hy
     * @date 2013-03-08
     * @param pageProductData
     * @param id
     */

    public void stopPageProduct(PageProductData pageProductData) {
        productService.stopPageProduct(pageProductData);
    }

    /**
     * 更新服务 更新page电话号码
     * 
     * @author hy
     * @date 2014-03-13
     * @param productData
     * @param pageId
     */
    public String updateProductPagePhone(PageProductData pageProductData, String pageId, String phone) {
        return productService.updateProductPagePhone(pageProductData, pageId, phone);
        
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
    	productService.editProductPagePhone(pageProductData, pageId, oldPhone, phone);
    }
    
    /**
     * 更新服务，启动 上传文件
     * 
     * @author 侯杨
     * @date 2014-03-13
     * @param pageProductData
     */
    public String updateProductPageFile(PageProductData pageProductData) {
       return productService.updateProductPageFile(pageProductData);
    }
    
    /** 服务管理，启用在线客服这款服务，部署talk99
 		 * @author hy
 		 * @date 2014-04-17
 		 * @param contenu
 		 * @param data
 		 * @return
 		 */
 	  
 		public String  updatePageProductTak(String contenu,PageProductData data){
 		   return productService.updatePageProductTak(contenu, data);
 	   }
 		
 		/**
         * 根据pageid查询page所拥有的域名
         * @author 侯杨
         * @date 2014-04-30
         * @param pageId
         * @return
         */
        public PageInfoExtraData getPageDomain(String pageId){
        	  return productService.getPageDomain(pageId);
        }

}
