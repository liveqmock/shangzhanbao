package com.mini.front.product.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.FileUpload;
import com.common.util.ResouceUtil;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.front.businessUser.facade.BusinessUserFacade;
import com.mini.front.order.facade.PageProductFacade;
import com.mini.front.pageManage.facade.PageManageFacade;
import com.mini.front.product.facade.ProductManageFacade;
import com.mini.order.data.OrderProductData;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.util.OutImgBlob;
import com.util.ReadDomain;

@ResultPath("/")
@Results({
        @Result(name = "getAllProductList", location = "/view/pages/mini/front/product/userCenter_service.jsp"),// 查询所有
        @Result(name = "openFile", location = "product_manage/key/getAllProduct", type = "redirectAction"),
        @Result(name = "tophoneDetail", location = "/view/pages/mini/page/service/phone/phoneDetail.jsp"),
        @Result(name = "toserviceDetail", location = "/view/pages/mini/page/service/onlineService/onlineService.jsp"),
        @Result(name = "toonline", location = "/view/pages/mini/page/service/onlineConsult.jsp") })
public class ProductManageAction extends FrmAction {

    @Resource(name = "productManageFacade")
    private ProductManageFacade productManageFacade;
    @Resource(name = "businessUserFacade")
    private BusinessUserFacade businessUserFacade; // 实名认证注入
    @Resource(name = "pageProductFacade")
    private PageProductFacade pageProductFacade;// page服务关联表
    @Resource(name = "pageManageFacade")
    private PageManageFacade pageManageFacade;

    private List<PageProductData> list = new ArrayList<PageProductData>(); // page使用服务集合
    private PageProductData pageProductData = new PageProductData(); // page使用服务实体
    private BusinessUserData businessUserData = new BusinessUserData(); // 实名认证信息实体
    private PageInfoExtraData pageInfoExtraData = new PageInfoExtraData(); // 域名实体

    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> stopType = CacheUtil.getInstance().getCacheMap("stopType"); // 停用用类型

    // 分页所需要的对象
    private PageRoll pageRoll = new PageRoll();
    private String pageId; // pageid
    private String phone; // 电话号码
    private File imgFile;// 获取上传文件
    private String imgFileFileName;// 获取上传文件名称
    private String imgFileContentType;// 获取上传文件类型
    private String contenu; // 部署talk99 上传待代码内容

    public static final String fileName = "domain.properties";
    public static final String PATH = ResouceUtil.getProperty(fileName, "path");// 读取文件中的路径

    /*********************************************************************************************/
    /**
     * 根据用户id查询出数据，然后查询出page，在查询出服务
     * 
     * 
     * @update 修改人：文东 修改位置：77 行 修改内容：将之前的未分页查询，改成分页查询
     * @param userId
     * @return
     */
    public String getAllProduct() {
        String userId = getFrmUser().etipUserID;
        list = productManageFacade.getAll(userId, pageRoll);
        // 获取服务对象
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ProductData productData = list.get(i).getProductData();
                if (productData != null) {
                    // 图片保存的路径
                    String filePath = request.getRealPath("") + File.separator + "img" + File.separator + "product";
                    // 图片的名称
                    String filename = "main_" + productData.getId();
                    String myPath = "";
                    // 获取图片地址
                    try {
                        if (productData.getImg() != null) {
                            // 生成图片文件
                            OutImgBlob.outImg(productData.getImg(), filePath, filename);
                            // 获取图片地址
                            myPath = File.separator + "img" + File.separator + "product" + File.separator + filename
                                    + ".jpg";
                        }
                    } catch (Exception e) {
                        myPath = "\\img\\editor\\erro.jpg";
                    }
                    productData.setImage(myPath);
                }
            }
        }
        request.setAttribute("menuNum", 3);

        /********** 从配置文件里面获取停用理由拼接成下拉框传给页面 ************/
        StringBuffer buffer = new StringBuffer();
        buffer.append("<select style='width:150px;' name='pageProductData.stopType' id='stopType' onchange= 'bao(this.options[this.options.selectedIndex].value)'>");
        for (Entry<Integer, String> entry : stopType.entrySet()) {
            String op = "<option value='" + entry.getKey() + "'/>" + entry.getValue() + "</option>";
            buffer.append(op);
        }
        buffer.append("</select>");
        /********** 停用理由end **************/
        
        String path = ReadDomain.readProperties(); // 域名路径
        request.setAttribute("path", path);
        request.setAttribute("sel", buffer.toString());
        return "getAllProductList";
    }

    /**
     * 停用page所使用的服务
     * 
     * @author h
     * @date 2013-03-08
     * @param pageProductData
     * @param id
     */

    public void stopPageProduct() {
        pageProductData.setStatus(0);
        productManageFacade.stopPageProduct(pageProductData);
    }

    /**
     * 啟用page所使用的服务
     * 
     * @author h
     * @date 2013-03-08
     * @param pageProductData
     * @param id
     */

    public void openPageProduct() {
        pageProductData.setStatus(1);
        productManageFacade.stopPageProduct(pageProductData);
    }

    /**
     * 
     * 根据页面的服务id和pageid 查询出page服务中间表的id 在启用服务<br>
     * 
     * @author 侯杨 <br>
     *         2014-7-7
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void openPageProductmes() {
        OrderProductData orderProductData = new OrderProductData();
        orderProductData.setPageId(request.getParameter("pageid"));
        orderProductData.setProductId(request.getParameter("productid"));
        PageProductData data = pageProductFacade.getPageProductData(orderProductData);
        pageProductData.setId(data.getId());
        pageProductData.setStatus(1);
        productManageFacade.stopPageProduct(pageProductData);
    }

    /**
     * 更新服务 更新page电话号码
     * 
     * @author hy
     * @date 2014-03-13
     * @param productData
     * @param pageId
     */
    public void updateProductPagePhone() {
        pageId = request.getParameter("pageId");
        phone = request.getParameter("phone");
        json = productManageFacade.updateProductPagePhone(pageProductData, pageId, phone);
    }

    /**
     * 修改page电话号码
     * 
     * @author 左香勇
     * @date 2014-04-30
     * @param productData
     * @param pageId
     */
    public void editProductPagePhone() {

        pageId = request.getParameter("pageId");
        phone = request.getParameter("phone");
        String oldPhone = request.getParameter("oldPhone");
        productManageFacade.editProductPagePhone(pageProductData, pageId, oldPhone, phone);
    }

    /**
     * 更新服务，启动 上传文件
     * 
     * @author 侯杨
     * @date 2014-03-13
     * @param pageProductData
     */
    public String updateProductPageFile() {
        if (imgFileFileName != null && !"".equals(imgFileFileName)) {
            String imgFileNamePath = FileUpload.createFile(UploadPath.SIGN_PATH, "admin", imgFileFileName, imgFile);//
            pageProductData.setSignPath(imgFileNamePath); // 文件路径
            pageProductData.setSignName(imgFileFileName); // 文件名称
            pageProductData.setSignTime(new Date()); // 上传文件时间
            productManageFacade.updateProductPageFile(pageProductData);
        }
        return "openFile";

    }

    /**
     * 跳转到拨打销售电话详情页面
     * 
     * @author 左香勇
     * @date 2014-04-30
     * @param data
     * @return
     */
    public String tophoneDetail() {

        String id = request.getParameter("id");

        pageProductData = productManageFacade.getPageProductByid(id);
        request.setAttribute(
                "phoneNum",
                pageProductData.getProductContent() == null ? "未设置电话"
                        : "".equals(pageProductData.getProductContent()) ? "未设置电话" : pageProductData
                                .getProductContent());
        request.setAttribute("pageProductData", pageProductData);
        request.setAttribute("messtatus", pageProductData.getStatus()); // 留言状态
        String pageName = request.getParameter("pageName"); // page名称
        request.setAttribute("pageName", pageName);
        return "tophoneDetail";
    }

    /**
     * 跳转到在线客服详情页面
     * 
     * @author 左香勇
     * @date 2014-04-30
     * @param data
     * @return
     */
    public String toserviceDetail() {
        String hasShop = null;
        String hasOrder = null;
        String pageId = request.getParameter("pageId");

        PageData pageData = new PageData();
        pageData.setId(pageId);

        PageData paData = pageManageFacade.findPageDataById(pageData);

        request.setAttribute("pageName", paData.getName());

        if (request.getParameter("id") == null || "".equals(request.getParameter("id"))) {
            request.setAttribute("pageId", pageId);// pageId
            return "toonline";
        } else {
            pageProductData = productManageFacade.getPageProductByid(request.getParameter("id"));

            hasShop = request.getParameter("hasShop");
            hasOrder = request.getParameter("hasOrder");
            pageProductData.setProductPrice(hasShop); // 加入购物车未付款标识
            pageProductData.setNoPayState(hasOrder); // 加入购物车生成订单未付款标识
            request.setAttribute("pageProductData", pageProductData);
            return "toserviceDetail";
        }
    }

    /**
     * 服务管理，启用在线客服这款服务，部署talk99
     * 
     * @author hy
     * @date 2014-04-17
     * @param contenu
     * @param data
     * @return
     */

    public void updatePageProductTak() {
        json = productManageFacade.updatePageProductTak(contenu, pageProductData);
    }

    /**
     * 根据pageid查询page所拥有的域名
     * 
     * @author 侯杨
     * @date 2014-04-30
     * 
     * @return
     */
    public void getPageDomain() {
        String path = ReadDomain.readProperties(); // 域名路径
        pageInfoExtraData = productManageFacade.getPageDomain(pageId);
        String domain = pageInfoExtraData.getDomain(); // 域名
        if (domain == null) {
            json = "";
        } else if (pageInfoExtraData.getType().equals("1")) { // 如果是独立域名。json返回值就是域名，如果是二级域名，json返回值就是域名路径+域名
            json = domain;
        } else {
            json = path + domain;
        }
    }

    /*********************************************************************************************/

    public List<PageProductData> getList() {
        return list;
    }

    public void setList(List<PageProductData> list) {
        this.list = list;
    }

    public ProductManageFacade getProductManageFacade() {
        return productManageFacade;
    }

    public void setProductManageFacade(ProductManageFacade productManageFacade) {
        this.productManageFacade = productManageFacade;
    }

    public TreeMap<Integer, String> getStopType() {
        return stopType;
    }

    public void setStopType(TreeMap<Integer, String> stopType) {
        this.stopType = stopType;
    }

    public PageProductData getPageProductData() {
        return pageProductData;
    }

    public void setPageProductData(PageProductData pageProductData) {
        this.pageProductData = pageProductData;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgFileFileName() {
        return imgFileFileName;
    }

    public void setImgFileFileName(String imgFileFileName) {
        this.imgFileFileName = imgFileFileName;
    }

    public String getImgFileContentType() {
        return imgFileContentType;
    }

    public void setImgFileContentType(String imgFileContentType) {
        this.imgFileContentType = imgFileContentType;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public BusinessUserFacade getBusinessUserFacade() {
        return businessUserFacade;
    }

    public void setBusinessUserFacade(BusinessUserFacade businessUserFacade) {
        this.businessUserFacade = businessUserFacade;
    }

    public BusinessUserData getBusinessUserData() {
        return businessUserData;
    }

    public void setBusinessUserData(BusinessUserData businessUserData) {
        this.businessUserData = businessUserData;
    }

    public PageInfoExtraData getPageInfoExtraData() {
        return pageInfoExtraData;
    }

    public void setPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        this.pageInfoExtraData = pageInfoExtraData;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

}
