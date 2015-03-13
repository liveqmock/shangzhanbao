package com.mini.front.pageManage.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.pageManage.service.IPageManageService;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.product.service.IProductService;
import com.mini.shoppingCart.service.IShoppingCartServices;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.service.ITempManageService;
import com.sys.user.service.IUserService;

@Component("pageManageFacade")
public class PageManageFacade extends FrmFacade {

    @Resource(name = "pageManageService")
    private IPageManageService pageManageService;

    // 模板管理服务接口 容器注入
    @Resource(name = "tempManageService")
    private ITempManageService tempManageService;
    // 购物车服务接口 容器注入
    @Resource(name = "shoppingCartServices")
    private IShoppingCartServices shoppingCartServices;
    // 用户信息服务接口  容器注入
    @Resource(name = "userSysService")
    private IUserService userService;
    
    // 系统服务 service接口
    @Resource(name = "productService")
    private IProductService productService;

    /**
     * 用户：查找改用的所有配置
     * 
     * @author 郭井超
     * @param pageRoll
     * @param pageData
     * @return
     */
    public List<PageData> getAllPageData(PageRoll pageRoll, PageData pageData) {
        return pageManageService.getAllPageData(pageRoll, pageData);
    }

    /**
     * 用户：用户删除page
     * 
     * @author 郭井超
     * @param pageData
     */
    public void deletePageDataById(PageData pageData) {
        pageManageService.deletePageDataById(pageData);
    }

    /**
     * 用户： 设置域名
     * 
     * @author 郭井超
     * @param pageData
     */

    public void updatePageInfoExtraData(PageInfoExtraData pageInfoExtraData, PageData pageData) {
        pageManageService.updatePageInfoExtraData(pageInfoExtraData, pageData);
    }

    /**
     * 用户： 是否有 升级发布权限
     * 
     * @author 郭井超
     * @param userId
     */
    public int getPrivilegeData(String userId) {
        return pageManageService.getPrivilegeData(userId);
    }

    /**
     * 用户： 执行升级操作
     * 
     * @author 郭井超
     * @param pageData
     */
    public PageData doPrivilegeData(PageData pagaData) {
        return pageManageService.doPrivilegeData(pagaData);
    }

    /**
     * 用户： 发布服务
     * 
     * @author 郭井超
     * @param pagaData
     */
    public String updatePageData(PageData pagaData) {
        return pageManageService.updatePageData(pagaData);
    }

    /**
     * 用户： 查找独立域名 ---判断是否存在
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    public String getPageInfoExtraData(PageData pageData) {
        return pageManageService.getPageInfoExtraData(pageData);
    }

    public String getPageInfoExtraDatas(PageData pageData) {
        return pageManageService.getPageInfoExtraDatas(pageData);
    }

    /**
     * 
     * 用户：if独立域名不存在 执行添加
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    public void addPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        pageManageService.addPageInfoExtraData(pageInfoExtraData);
    }

    /**
     * 
     * 用户： 查找用户有多少可用权限
     * 
     * @author 郭井超
     * @param userId
     * @return
     */
    public int getUserPrivateNumber(String userId) {
        return pageManageService.getUserPrivateNumber(userId);
    }

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void addPageData(PageData pageData) {
        pageManageService.addPageData(pageData);
    }

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void editPageData(PageData pageData) {
        pageManageService.editPageData(pageData);

    }

    /**
     * 代理
     * 
     * @param pageDate
     */
    public PageData findPageDataById(PageData pageData) {
        return pageManageService.findPageDataById(pageData);
    }

    public TemplateData searchTempById(String id) {

        return tempManageService.getTemplateData(id);
    }

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
    public String addShopCartNoPrice(PageProductData data) {
        return shoppingCartServices.addShopCartNoPrice(data);
    }

    /**
     * 获取禁用page个数
     * 
     * @author hy
     * @param userId
     * @return
     */
    public int getAllDisablePage(String userId) {
        return pageManageService.getAllDisablePage(userId);
    }

    /**
     * 
     * 所有需要查看未付款服务的方法<br>
     * 
     * @author fengxin <br>
     *         2014-4-28
     * @update
     * @param String Pageid
     * @return List<ProductData>
     */
    public List<ProductData> findNoPayProductData(String pageid) {
        return pageManageService.findNoPayProductData(pageid);
    }

    /**
     * 
     * 根据微站的id查看微站所使用的模板的主缩略图<br>
     * 
     * @author 文东 <br>
     *         2014年6月25日
     * @update
     * @param pageId 微站的id
     * @return 微站所使用的模板的主缩略图
     * @exception/throws
     * @see PageManageFacade#getTempPicByPageId(String)
     * @since
     */
    public TemplateThumbnailData getTempPicByPageId(String pageId) {

        return pageManageService.getTempPicByPageId(pageId);
    }

    /**
     * 
     * 根据pageid查询page实体，二维码是否存在，不存在就生成<br>
     * 
     * @author 侯杨 <br>
     *         2014-7-15
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public PageData getPageZing(PageData pageData) {
        return pageManageService.getPageZing(pageData);
    }

    /**
     * 
     * 修改page<br>
     * 
     * @author 侯杨 <br>
     *         2014-7-15
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void updatePage(PageData data) {
        pageManageService.updatePage(data);
    }

    /**
     * 
     * 查询改页面所属用户是否拥有收款账号<br>
     * 
     * @author 文东<br>
     *         2014年9月11日
     * @update
     * @param userId 用户id
     * @param pageId 页面id
     * @return 返回String类型的变量 返回 1－拥有收款账号 0－未拥有支付宝账号
     * @exception/throws
     * @see PageManageFacade#isExitReceivableAccount();
     * @since vmaque1.5
     */
    public String isExitReceivableAccount(String userId,String pageId) {
        List<ProductData> productDatas = productService.getProductByPageId(pageId);
        // 循环遍历page所拥有的服务 查看是否具有购买服务
        for (int i = 0; i < productDatas.size(); i++) {
            if(productDatas.get(i).getType().equals("6")){
                // 查询用户是否拥有收款账号
                String isExitReceivableAccount = userService.isExitReceivableAccount(userId);
                return isExitReceivableAccount;
            }
        }
        return "1";
    }
     /**
      * 
      *在购买的时候  创建的css文件<br>
      * @author 侯杨 <br> 
      *         2014-9-23
      * @update 
      * @param  data         page信息实体
      *         cssFilePath  css文件路径
      *         cssPath      html页面css引入文件路径
      * @see PageManageFacade#createGoodsCss
      * @since vmaque1.6
      */
      public String createGoodsCss(PageData data,String cssFilePath,String cssPath){
          return pageManageService.createGoodsCss(data, cssFilePath, cssPath);
      }
      /**
       * 
       *page 另存<br>
       * 
       * @author 侯杨 <br> 
       *        2014-10-20
       * @update 
       * @param data  page实体
       * @return  pagedata page实体
       * @see   PageManageFacade#copyPage(PageData)
       * @since vmaque1.7
       */
     public PageData copyPage(PageData data) {
         return pageManageService.copyPage(data);
     }
}
