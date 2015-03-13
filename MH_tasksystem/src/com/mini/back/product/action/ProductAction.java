package com.mini.back.product.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.Json;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.product.facade.ProductFacade;
import com.mini.product.data.ProductData;

@ResultPath("/")
@Results({ @Result(name = "getAllProduct", location = "/view/pages/mini/back/product/productList.jsp"), // 查询所有
        @Result(name = "addProductFinish", location = "product/key/getAllProduct?productData.status=1", type = "redirectAction"), // 添加
        @Result(name = "productView", location = "/view/pages/mini/back/product/productEdit.jsp") // 详情
})
public class ProductAction extends FrmAction {

    // 服务facade 接口
    @Resource(name = "productFacade")
    private ProductFacade productFacade;
    private ProductData productData = new ProductData(); // 服务实体
    private List<ProductData> list = new ArrayList<ProductData>(); // 服务集合
    private PageRoll pageRoll = new PageRoll(); // 分页
    private String ids[]; // id 数组

    // 主预览图
    private File fileMain;
    private String fileMainFileName;

    /*********************************************************************************/
    
    /**
     * 
     * 查询所有可用服务<br>
     * 
     * @author 文东 <br> 
     *		   2014-3-14
     * @update 
     * @param 
     * @return  步骤3的页面
     * @exception/throws 
     * @see  ProductAction#searchProduct()
     * @since 
     */
    public String searchProduct(){
        list = productFacade.getAll(pageRoll, productData,0);
        return "step3";
    }
    
    /**
     * @author 侯杨 date 2014-03-06 后台服务管理，分页查询所有
     * @return
     */
    public String getAllProduct() {
        int sort = 0;
        String s=request.getParameter("sortTime");
                if(s!=null && !"".equals(s)){
            sort = Integer.parseInt(s);
                }
            if(sort != 0) {
                request.setAttribute("sortTime", 0);
            }else{
                request.setAttribute("sortTime", 1);
            }
        list = productFacade.getAll(pageRoll, productData,sort);
        return "getAllProduct";
    }

    /**
     * 根据从页面获取来的产品名称来判断数据库中是否已经存在该产品名称
     * 
     * @author 侯杨
     * @date 2014-03-06
     */
    public void ajaxGetAllProductName() {
        productData = productFacade.getAllProductName(productData.getName());
        json = Json.beanToJson(productData);
    }

    /**
     * 添加服务
     * 
     * @author 侯杨
     * @date 2014-03-06
     */
    public String addProductFinish() {

        productData.setCreateTime(new Date());
        productFacade.addProduct(productData, fileMain);
        return "addProductFinish";
    }

    /**
     * 根据id查询服务详情
     * 
     * @author hy
     * @date 2014-03-06
     * @param id
     * @return
     */
    public String getProductDataView() {
        productData = productFacade.getProductData(productData.getId());
        return "productView";
    }

    /**
     * 修改服务
     * 
     * @author 侯杨
     * @date 2014-03-06
     */
    public String updateProductFinish() {

        productFacade.updateProduct(productData);
        return "addProductFinish";
    }

    /**
     * @author 侯杨 date 2014-03-06 后台服务管理删除服务
     * @param productData
     */

    public void deleteProduct() {
        productFacade.deleteProduct(ids);

    }

    /**
     * @author 侯杨
     * @date 2014-3-12 后台服务管理 关闭服务
     * @param productData
     */
    public void closedProduct() {
        productData.setStatus("CLOSED");
        productFacade.updateProductState(productData);
    }
    
    /**
     * @author 侯杨
     * @date 2014-5-21 后台服务管理 启用服务
     * @param productData
     */
    public void openProduct() {
       productData.setStatus("OPEN");
       productFacade.updateProductState(productData);
    }


    /***********************************************************************************/

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public List<ProductData> getList() {
        return list;
    }

    public void setList(List<ProductData> list) {
        this.list = list;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public File getFileMain() {
        return fileMain;
    }

    public void setFileMain(File fileMain) {
        this.fileMain = fileMain;
    }

    public String getFileMainFileName() {
        return fileMainFileName;
    }

    public void setFileMainFileName(String fileMainFileName) {
        this.fileMainFileName = fileMainFileName;
    }

}
