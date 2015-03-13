package com.mini.front.pageManage.action;

import java.io.File;
import java.io.IOException;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Hibernate;

import com.common.util.ClobFile;
import com.common.util.DateUtil;
import com.common.util.ReadWriteFile;
import com.common.util.ResouceUtil;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.util.FileUtil;
import com.mini.account.data.AccountNumberData;
import com.mini.back.give.facade.UserInfoDataFacade;
import com.mini.back.product.facade.ProductFacade;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.front.account.facade.AccountNumberFacade;
import com.mini.front.domain.facade.PageFacade;
import com.mini.front.domain.facade.PageInfoExtraFacade;
import com.mini.front.order.facade.PageProductFacade;
import com.mini.front.pageManage.facade.PageManageFacade;
import com.mini.front.shoppingCart.facade.ShoppingCartFacade;
import com.mini.give.data.UserInfoData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageTemplateData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.commodityConfig.facade.CommodityConfigFacade;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.facade.GoodsInfoFacade;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;
import com.mini.purchase.pagegoodsinfo.facade.PageGoodsInfoFacade;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.util.ImageUtil;
import com.mini.util.OutClobFile;
import com.mini.util.OutImgBlob;
import com.sys.user.data.UserData;
import com.util.DateFormatUtil;
import com.util.HttpWebUtil;
import com.util.ReadDomain;

@ResultPath("/")
@Results({
        @Result(name = "toeditTop", location = "/view/pages/mini/page/edit/templateTop/template_top.jsp"),
        @Result(name = "topreviewLeft", location = "/view/pages/mini/page/preview/templateLeft/template_left.jsp"),
        @Result(name = "toedit", location = "/view/pages/mini/page/edit/editTemplate.jsp"),
        @Result(name = "toeditLeft", location = "/view/pages/mini/page/edit/templateLeft/template_left.jsp"),
        @Result(name = "toTemp", location = "/view/pages/mini/page/preview/previewTemplate.jsp"),
        @Result(name = "getAllPaga", location = "/view/pages/mini/front/pageManage/UserCenter_page.jsp"),
        @Result(name = "editPageState", location = "page_manage/key/getAllPaga", type = "redirectAction"),
        @Result(name = "editPageState2", location = "page_manage/key/getAllPaga", type = "redirectAction"),
        @Result(name = "notYuMing", location = "/view/pages/mini/front/domain/adddomain.jsp"),
        @Result(name = "yesYuMing", location = "/view/pages/mini/front/pageManage/publishSuccess.jsp"),
        @Result(name = "toCreatePageSell", location = "/view/pages/mini/page/createPage/sell/createPage_sell.jsp"),
        @Result(name = "toCreatePageDetail", location = "/view/pages/mini/page/createPage/detail/createPage_detail.jsp"),
        @Result(name = "tofb", location = "/view/pages/mini/front/domain/adddomain.jsp"),
        @Result(name = "tostep1", location = "/view/pages/mini/page/createPage/sell/left/createPage_sell_left1.jsp"),
        @Result(name = "tostep2", location = "/view/pages/mini/page/createPage/sell/left/createPage_sell_left2.jsp"),
        @Result(name = "tostep3", location = "/view/pages/mini/page/createPage/sell/left/createPage_sell_left3.jsp"),
        @Result(name = "tostepDerail", location = "/view/pages/mini/page/createPage/detail/left/createPage_detail_left.jsp"),
        @Result(name = "toylMain", location = "/view/pages/mini/page/temp/temp.jsp"),
        @Result(name = "bindingDomain", location = "page/key/getAllPageInfo", type = "redirectAction"),
        @Result(name = "baocun", location = "/view/pages/mini/page/edit/templateLeft/template_left.jsp"),
        @Result(name = "toeditservice", location = "/view/pages/mini/page/edit/templateLeft/template_left_service.jsp"),
        @Result(name = "top", location = "/view/pages/mini/front/TemplateM/TemplateTop/template1_top2.jsp"),
        @Result(name = "weixin", location = "/view/pages/mini/front/pageManage/weixin.jsp")        
})
public class PageManageAction extends FrmAction {

    /*
     * 注入 *********************************************************************** *******************
     */

    @Resource(name = "pageProductFacade")
    private PageProductFacade pageProductFacade;

    @Resource(name = "pageManageFacade")
    private PageManageFacade pageManageFacade;

    @Resource(name = "userInfoDataFacade")
    private UserInfoDataFacade userInfoDataFacade;

    // 服务facade 接口
    @Resource(name = "productFacade")
    private ProductFacade productFacade;

    // Page域名管理Facde 接口 容器注入
    @Resource(name = "pageInfoExtraFacade")
    private PageInfoExtraFacade pageInfoExtraFacade;

    @Resource(name = "pageFacade")
    private PageFacade pageFacade; // page表facade类

    @Resource(name = "shoppingCartFacade")
    private ShoppingCartFacade shoppingCartFacade; // 购物车
    @Resource(name="goodsInfoFacade")
    private GoodsInfoFacade goodsInfoFacade;
    @Resource(name="commodityConfigFacade")
    private CommodityConfigFacade commodityConfigFacade;
    @Resource(name="pageGoodsInfoFacade")
    private PageGoodsInfoFacade pageGoodsInfoFacade;
    @Resource(name="accountNumberFacade")
    private AccountNumberFacade accountNumberFacade;  //收款方式
  
    /*
     * 对象 *********************************************************************** *******************
     */

    private PageData pageData = new PageData();
    private PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
    private PageRoll pageRoll = new PageRoll();
    List<PageData> pageDataList = null;
    TemplateData templateData = new TemplateData();
    private ProductData productData = new ProductData(); // 服务实体
    private List<ProductData> productDatas = new ArrayList<ProductData>(); // 服务集合
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> disabledType = CacheUtil.getInstance().getCacheMap("disabledType"); // 禁用类型
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> pageStateType = CacheUtil.getInstance().getCacheMap("pageState"); //
    // 获取file文件
    private String realpath = ServletActionContext.getServletContext().getRealPath("/configure");
    // page访问路径
    private String pagePath;
    // 域名
    private PageInfoExtraData infoExtraData = new PageInfoExtraData();

    private Map<String, String> maps = new HashMap<String, String>();

    private PageProductData pageProductData = new PageProductData(); // page服务中间表

    private List<PageProductData> pageProductDatas = new ArrayList<PageProductData>(); // Page服务中间表集合

    private UserData userData = new UserData();
    //商品信息实体对象
    private GoodsInfoData goodsInfoData=new GoodsInfoData();
    //商品信息规格实体对象
    private CommodityConfigData commodityConfigData=new CommodityConfigData();
    //page和商品信息实体对象
    private PageGoodsInfoData pageGoodsInfoData=new PageGoodsInfoData();
    //收款方式集合
    private List<AccountNumberData> accountNumberDatas=new ArrayList<AccountNumberData>();
    /*
     * 方法 *********************************************************************** *******************
     */

    public PageProductData getPageProductData() {
        return pageProductData;
    }

    public void setPageProductData(PageProductData pageProductData) {
        this.pageProductData = pageProductData;
    }

    /**
     * 用户： 查询所有page管理
     * 
     * @author 郭井超
     * @update dailimin
     * @return
     */
    public String getAllPaga() throws IOException {
        request.getSession().removeAttribute("flage");// AccesstatisticsAction.java类中需要处理的的全局变量
        String userId = getFrmUser().etipUserID;// 获取登陆用户id
        pageData.setUserId(userId);
        pageDataList = pageManageFacade.getAllPageData(pageRoll, pageData);
        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        request.setAttribute("menuNum", 1);
        request.setAttribute("pageDisNum", pageManageFacade.getAllDisablePage(userId));
        request.setAttribute("status", pageData.getStatus());
        return "getAllPaga";
    }

    /**
     * 编辑中的发布按钮
     */
    public void editTofb() {
        try {
            Map<String, String> map = pageInfoExtraFacade.getPageInfoExtra(JSONObject.fromObject("{'pageid':'"
                    + pageData.getId() + "','status':'OPEN'}"));
            JSONObject json = JSONObject.fromObject(map);
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 点击发布按钮重新生成html
     */
    public void createPageHtml() {
        // 修改page
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        //pageData.setCreateTime(new Date());
        // pageManageFacade.editPageData(pageData);
        // list_Pro中是所有此page未付款的服务
        List<ProductData> list_Pro = findNoPayProductData(pageData.getId());
        // 如果此page有未付款的服务
        if (list_Pro.size() > 0) {
            PageData data = pageManageFacade.findPageDataById(pageData);
            if (!"1".equals(data.getStatus())) {
                pageData.setStatus("0");
            }
            pageManageFacade.editPageData(pageData);
            // productdata对象内部有日期类型 和大字段类型 json转换的时候报错 fengxin
            for (int i = 0; i < list_Pro.size(); i++) {
                list_Pro.get(i).setCreateTime(null);
                list_Pro.get(i).setOverTime(null);
                list_Pro.get(i).setImg(null);
            }
            json = JSONArray.fromObject(list_Pro).toString();
        } else {
            pageData.setStatus("1");
            if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
                pageData.setContent(Hibernate.createClob(request.getParameter("content")));
            }
            pageData.setPublishTime(new Date());
            // 设置发布权限试用期限 冯鑫
            pageData.setEndTime(DateFormatUtil.aFewDaysAfter(new Date(),
                    Integer.parseInt(ReadWriteFile.readTxtFile(ServletActionContext.getServletContext().getRealPath(
                            "/file")
                            + "/file.txt"))));
            pageManageFacade.editPageData(pageData);
            // 重新生成页面
            String pagePath = "/pagehtml";
            String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);

            // 获取二级域名
            String link = request.getParameter("pageLink");
            // 获取名称
            String ll[] = link.split("/");
            // pageData = pageManageFacade.findPageDataById(pageData);
            pageData = pageManageFacade.findPageDataById(pageData);
            try {
                OutClobFile.generaFile(pageData.getContent(), realpath, ll[ll.length - 1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            json = "";
        }
        // 如果购买了在线客服这个服务，会有预览想过 调用此方法 去掉预览效果。
        productFacade.editOnLineProduct(pageData);
    }

    /**
     * 用户：删除page
     * 
     * @author 郭井超 左香勇 2014-6-9 添加删除对应文件方法
     * @update 冯鑫 2014-9-25  增加删除创建完成的page  已经删除此page的域名
     * @return
     */
    public void deletePageDateById() {
        pageManageFacade.deletePageDataById(pageData);
        pageInfoExtraData.setPageId(pageData.getId());
        pageInfoExtraData = pageInfoExtraFacade.searchByPageId(pageInfoExtraData);
        //删除此page所对应的文件
        FileUtil.delFile(request.getRealPath("") + File.separator + "pagehtml" + File.separator +pageInfoExtraData.getDomain());
        //删除page
        pageInfoExtraFacade.deletePageInfoExtra(new String[]{pageInfoExtraData.getId()});
        // 删除对应文件 
        String filePath = request.getRealPath("") + File.separator + "temp";
        String fileName = "newTemp_" + pageData.getId() + ".html";
        FileUtil.delFile(filePath + File.separator + fileName);

        json = 1;
    }

    /**
     * 用户： 设置
     * 
     * @author 郭井超
     * @param userId
     */
    public void updatePageInfoExtraData() {
        String help = request.getParameter("helpYm");// 设置域名辅助字段
        pageInfoExtraData.setHelp(help);
        pageManageFacade.updatePageInfoExtraData(pageInfoExtraData, pageData);
    }

    /**
     * 用户： 是否有 升级发布权限
     * 
     * @author 郭井超
     * @param userId
     */
    public void getPrivilegeData() {
        String userId = getFrmUser().etipUserID;
        int state = pageManageFacade.getPrivilegeData(userId);
        json = String.valueOf(state);
    }

    /**
     * 用户： 是否有 升级发布权限
     * 
     * @author 郭井超 update 侯杨
     * @param userId
     */

    public void doPrivilegeData() {
        String userId = getFrmUser().etipUserID;
        pageData.setUserId(userId);
        PageData data = pageManageFacade.doPrivilegeData(pageData);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String beginTime = sdf.format(data.getPublishTime()); // 权限开始时间转化为string类型的
        String endTime = sdf.format(data.getEndTime()); // 权限截止时间转化为string类型的
        json = beginTime + "-" + endTime;
    }

    /**
     * 用户： 发布page
     * 
     * @author 郭井超
     * @update 冯鑫
     * @param pagaData
     */
    public String updatePageData() throws IOException {
        pageData = pageManageFacade.findPageDataById(pageData);
        PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
        PageInfoExtraData pageInfoExtraData1 = new PageInfoExtraData();
        pageInfoExtraData1.setPageId(pageData.getId());
        pageInfoExtraData = pageInfoExtraFacade.searchByPageId(pageInfoExtraData1);
        if (pageInfoExtraData != null) {
            request.setAttribute("pageDataName", pageData.getName());
            request.setAttribute(
                    "pageDatadomain",
                    pageInfoExtraData.getDomain().substring(pageInfoExtraData.getDomain().lastIndexOf("/") + 1,
                            pageInfoExtraData.getDomain().lastIndexOf(".")));
        } else {
            request.setAttribute("pageDataName", pageData.getName());
        }
        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        request.setAttribute("pageid", pageData.getId());

        List<ProductData> list_Pro = new ArrayList<ProductData>();// 未付款服务对象list
        // list_Pro中是所有此page未付款的服务
        list_Pro = findNoPayProductData(pageData.getId());
        if (list_Pro.size() > 0) {
            request.setAttribute("noPayState", "1");
            request.setAttribute("noPayProductList", list_Pro);
        } else {
            request.setAttribute("noPayState", "0");
        }
        return "notYuMing";

    }

    /**
     * 检查独立域名是否存在
     */
    public void ckeckPageInfoExtraData() {
        String type = pageManageFacade.getPageInfoExtraData(pageData);
        json = type;
    }

    /**
     * 检查域名是否存在
     */
    public void ckeckPageInfoExtraDatas() {
        String type = pageManageFacade.getPageInfoExtraDatas(pageData);
        json = type;
    }

    /**
     * 
     * 用户：if独立域名不存在 执行添加
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    public void addPageInfoExtraData() {
        pageInfoExtraData.setPageId(pageData.getId());
        String str = pageInfoExtraData.getDomain(); // 域名
        String domain = null;
        // 如果独立域名不是以http://开头的,就把http://拼接上
        if (str.startsWith("http://")) {
            domain = str;
        } else {
            domain = "http://" + str;
        }
        pageInfoExtraData.setDomain(domain);
        pageManageFacade.addPageInfoExtraData(pageInfoExtraData);
        json = "1";// 表示成功
    }

    /**
     * 
     * 〈跳转到创建page编辑卖点页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update 文东 2014-3-7 查询到模板内容 生成jsp 文件
     * @param
     * @return 返回创建page页面
     * @exception/throws
     * @see PageManageAction#toCreatePage()
     * @since
     */
    public String toCreatePage() throws Exception {
        // 获取模板Id
        String id = request.getParameter("id");
        // 根据模板id查询模板
        templateData = pageManageFacade.searchTempById(id);
        // 文件路径
        String filePath = "";
        // 文件名称
        String fileName = "";
       
        String jspPath = "";
        
        //第几步
        if(null!=request.getParameter("step") && !"".equals(request.getParameter("step"))){//不是第一步
            request.setAttribute("step",request.getParameter("step"));
            request.setAttribute("pageid", request.getParameter("pageid"));
            PageData p = new PageData();
            p.setId(request.getParameter("pageid"));
            pageData = pageManageFacade.findPageDataById(p);
            Clob clob = pageData.getContent();
            filePath = request.getRealPath("") + "/temp/pagetemp/";
            fileName = "pageModel_" + pageData.getId() + ".html";
            OutClobFile.generaFile(clob, filePath, fileName);
            jspPath = "/temp/pagetemp/" + fileName;
        }else{
            request.setAttribute("step","1"); 
            if (templateData != null) {
                Clob clob = templateData.getContent();
                filePath = request.getRealPath("") + "/temp/pagetemp";
                fileName = "pageModel_" + templateData.getId() + ".jsp";
                OutClobFile.generaFile(clob, filePath, fileName);
            }
            // 获取生成jsp文件的地址
            jspPath = "/temp/pagetemp/" + fileName;
        }
       
        request.setAttribute("url", jspPath);
        request.setAttribute("templateid", id);
        return "toCreatePageSell";
    }

    /**
     * 
     * 〈跳转到创建page完善细节页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update 文东 2014/03/16
     * @param
     * @return 返回创建page页面
     * @exception/throws
     * @see PageManageAction#toCreatePage()
     * @since
     */
    public String toCreatePageDetail() throws Exception {
        // 存储
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);

        // 查找
        String id = pageData.getId();
        PageData data = new PageData();
        data.setId(id);
        PageData tempdata = pageManageFacade.findPageDataById(data);
        if (tempdata != null) {
            Clob clob = tempdata.getContent();
            String filePath = request.getRealPath("");
            String fileName = "/temp/newTemp_" + tempdata.getId() + ".html";
            OutClobFile.generaFile(clob, filePath, fileName);

            request.setAttribute("url", fileName);
            request.setAttribute("pageid", pageData.getId());
            request.setAttribute("templateid", request.getParameter("templateid"));
        }

        return "toCreatePageDetail";
    }

    /**
     * 〈添加信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-28 冯鑫 2014-06-16
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void addPageData() {
        if (pageData.getContent() == null) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        // 获取用户id userData为后台管理员替用户创建page 用户id存储在userData中，
        if (null != userData) {
            if (null != userData.getId() && !"".equals(userData.getId())) {
                pageData.setUserId(userData.getId());
            } else {
                pageData.setUserId(getFrmUser().etipUserID);
            }
        } else {
            pageData.setUserId(getFrmUser().etipUserID);
        }
        PageTemplateData data = new PageTemplateData();
        data.setTemplateId(request.getParameter("templateid"));
        pageData.setPageTemplateData(data);
        pageData.setCreateTime(new Date());
        pageData.setState("0");
        // 添加page信息
        pageManageFacade.addPageData(pageData);
        json=pageData.getId();
    }

    /**
     * 预览page信息 〈一句话功能简述〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String getTemplateYulan() throws Exception {
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        String id = "";
        if (!"".equals(pageData.getId()) && pageData.getId() != null) {
            pageData.setCreateTime(new Date());
            pageManageFacade.editPageData(pageData);
            id = pageData.getId();
        } else {
            id = request.getParameter("id");
        }
        request.setAttribute("pageid", id);
        request.setAttribute("pageName", request.getParameter("pageName"));
        request.setAttribute("pageLink", request.getParameter("pageLink"));
        request.setAttribute("status", pageData.getStatus());
        request.setAttribute("content", pageData.getContent());
        return "toTemp";
    }

    /**
     * 
     * 〈跳转到创建左侧页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String tostepLeft1() {
        request.setAttribute("templateid", request.getParameter("templateid"));
        return "tostep1";
    }

    /**
     * 
     * 〈跳转到创建左侧页面第二步〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String tostepLeft2() {
        request.setAttribute("templateid", request.getParameter("templateid"));
        request.setAttribute("pageid", request.getParameter("pageid"));
        return "tostep2";
    }
    
    /**
     * 
     * 〈跳转到创建左侧页面第三步〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String tostepLeft3() {
        request.setAttribute("templateid", request.getParameter("templateid"));
        request.setAttribute("pageid", request.getParameter("pageid"));
        PageTemplateData data = new PageTemplateData();
        data.setTemplateId(request.getParameter("templateid"));
        pageData.setPageTemplateData(data);

        request.setAttribute("pageid", request.getParameter("pageid"));
        request.setAttribute("templateid", request.getParameter("templateid"));
        productDatas = productFacade.getAll(pageRoll, productData,0);
        productDatas = productFacade.getAllProduct(productData);
        String str = "";
        try {
            str = HttpWebUtil.getCTNJsonData("wsGetAllProduct");
        } catch (IOException e) {
            e.printStackTrace();
        }
        productDatas = this.resolveCtnProduct(str);

        return "tostep3";
    }
    
    /**
     * 
     * 〈跳转到完善细节左侧界面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-3-12
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String tostepDetailLeft() {
        request.setAttribute("templateid", request.getParameter("templateid"));
        request.setAttribute("pageid", request.getParameter("pageid"));
        request.setAttribute("stepNum", 1);
        return "tostepDerail";
    }

    /**
     * 
     * 〈跳转到预览左侧页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String topreviewLeft() {
        request.setAttribute("pageid", request.getParameter("id"));
        request.setAttribute("pageName", request.getParameter("pageName"));
        request.setAttribute("pageLink", request.getParameter("pageLink"));
        request.setAttribute("status", pageData.getStatus());
        /********************************* 冯鑫begin **************************************/
        pagePath = ResouceUtil.getProperty("domain.properties", "path");
        /********************************* 冯鑫end ****************************************/
        return "topreviewLeft";
    }

    /**
     * 
     * 〈跳转到修改页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update 文东 2014/4/27 <br>
     *         修改侯杨添加免费服务到Page服务中间表
     * @return toedit struts2返回修改页面
     * @exception/throws
     * @see PageManageAction#toedit();
     * @since
     */
    public String toedit() {
        String thistype = request.getParameter("thistype");// 控制创建page和修改page时页面的部分元素的显示和不显示
        request.setAttribute("pageid", request.getParameter("id"));
        request.setAttribute("pageName", request.getParameter("pageName"));
        request.setAttribute("pageLink", request.getParameter("pageLink"));
        request.setAttribute("status", pageData.getStatus());
        request.setAttribute("thistype", thistype);
        return "toedit";
    }

    /**
     * 
     * 〈跳转到修改左侧页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String toeditLeft() {
        request.setAttribute("pageid", request.getParameter("id"));
        return "toeditLeft";
    }

    /**
     * 
     * 〈跳转到修改左侧页面〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update 冯鑫 2014/4/29 增加page访问路径变量的实例化
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String toeditTop() {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("pageName", request.getParameter("pageName"));
        request.setAttribute("pageLink", request.getParameter("pageLink"));
        request.setAttribute("status", pageData.getStatus());
        /********************************* 冯鑫begin **************************************/
        pagePath = ResouceUtil.getProperty("domain.properties", "path");
        /********************************* 冯鑫end ****************************************/

        String thistype = request.getParameter("thistype");
        request.setAttribute("thistype", thistype);
        return "toeditTop";
    }

    /**
     * 
     * 〈发布数据〉<br>
     * 
     * @author lenovo <br>
     *         2014-3-1
     * @update 文东 在跳转到发布页面时查询到该Page发布域名的ID 然后将域名传到前端页面
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String tofb() throws IOException {
        List<ProductData> list_Pro = new ArrayList<ProductData>();// 未付款服务对象list
        String text = ReadWriteFile.readTxtFile(realpath + "/file.txt");
        String endTime = DateUtil.getSpecifiedDay(DateUtil.dateToStr(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd",
                Integer.parseInt(text));
        Date date = DateUtil.strToDate(endTime, "yyyy-MM-dd");
        pageData.setEndTime(date);
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        if (!"3".equals(pageData.getStatus()) && !"2".equals(pageData.getStatus())) {
            pageData.setPublishTime(new Date());
            String fileName = "/temp/newTemp_" + pageData.getId() + ".html";
            String imgPath = ImageUtil.createImg(ResouceUtil.getProperty("domain.properties", "pageTmp") + fileName
                    + "?abc=" + System.currentTimeMillis(),
                    UploadPath.REAL_PATH + ResouceUtil.getProperty("domain.properties", "realName"), pageData.getId()
                            + ".jpg");
            if (imgPath != null && !"".equals(imgPath)) {
                pageData.setPageImg(ResouceUtil.getProperty("domain.properties", "realName") + imgPath);
            }
        }
        pageManageFacade.editPageData(pageData);
        String path = ReadDomain.readProperties();
        // 根据PageId查询域名查询域名对象
        pageInfoExtraData.setPageId(pageData.getId());
        pageInfoExtraData = pageInfoExtraFacade.searchByPageId(pageInfoExtraData);
        // 若该Page跟域名绑定了。则将域名信息的ID传到前台
        if (pageInfoExtraData != null) {
            request.setAttribute("id", pageInfoExtraData.getId());
        } else {
            request.setAttribute("id", "");
        }
        // list_Pro中是所有此page未付款的服务
        list_Pro = findNoPayProductData(pageData.getId());
        if (list_Pro.size() > 0) {
            request.setAttribute("noPayState", "1");
            request.setAttribute("noPayProductList", list_Pro);
        } else {
            request.setAttribute("noPayState", "0");
        }
        request.setAttribute("path", path);
        request.setAttribute("pageid", pageData.getId());
        return "tofb";
    }

    /**
     * 
     * 〈暂存方法〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-3-15
     *         冯鑫 2014-6-30
     *         如果购买了在线客服这个服务，会有预览想过 调用此方法 去掉预览效果。
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void zancun() {
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        if (!"1".equals(pageData.getStatus())) {
            pageData.setStatus("0");
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
        // 如果购买了在线客服这个服务，会有预览想过 调用此方法 去掉预览效果。
        productFacade.editOnLineProduct(pageData);
    }

    /**
     * 
     * 〈保存方法〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-3-15
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String baocun() {
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
        request.setAttribute("pageid", pageData.getId());
        return "baocun";
    }

    /**
     * 
     * 〈根据id获取page信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-25
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String getPageDataById() throws Exception {
        String id = request.getParameter("id");
        PageData data = new PageData();
        data.setId(id);
        PageData tempdata = pageManageFacade.findPageDataById(data);
        if (tempdata != null) {
            Clob clob = tempdata.getContent();
            String main=ClobFile.clobToString(clob);
            //进入编辑状态 把  规格添加按钮显示出来
            main=main.replace(
                    "<a href=\"###\" id=\"edtit\" onclick=\"edit()\" style=\"display: none;\">编辑</a>",
                    "<a href=\"###\" id=\"edtit\" onclick=\"edit()\" >编辑</a>");
           String filePath = request.getRealPath("");
            String fileName = "/temp/newTemp_" + tempdata.getId() + ".html";
            File file = new File(filePath + fileName);
            file.delete();
            OutClobFile.generaFile(main, filePath, fileName);
            request.setAttribute("url", fileName + "?abc=" + System.currentTimeMillis());
            String imgPath = ImageUtil.createImg(ResouceUtil.getProperty("domain.properties", "pageTmp") + fileName
                    + "?abc=" + System.currentTimeMillis(),
                    UploadPath.REAL_PATH + ResouceUtil.getProperty("domain.properties", "realName"), id + ".jpg");
            if (!"".equals(imgPath) && imgPath != null) {
                tempdata.setPageImg(ResouceUtil.getProperty("domain.properties", "realName") + imgPath);
                pageManageFacade.editPageData(tempdata);
            }
        }

        return "toylMain";
    }

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void editPageData() {
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
        
        json = pageData.getId();
        
    }

    /**
     * 跳转到修改服务页面
     * 
     * @param pageDate
     */
    public String toeditService() {
        // 获取PageId
        String pageId = request.getParameter("pageid");
        // 根据PageId 获取该PageId所拥有的服务 无论未付款还是已付款
        List<ProductData> list = new ArrayList<ProductData>();
        list = productFacade.getProductByPageId(pageId);
        productDatas = productFacade.getAllProduct(productData);
        // 判断这款服务是否被Page所拥有 传到修改页面，方便识别
        for (int i = 0; i < productDatas.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (productDatas.get(i).getId().equals(list.get(j).getId())) {
                    productDatas.get(i).setIsPay("0");
                }
            }
        }
        String str = "";
        try {
            str = HttpWebUtil.getCTNJsonData("wsGetAllProduct");
        } catch (IOException e) {
            e.printStackTrace();
        }
        productDatas = this.resolveCtnProduct(str);
        request.setAttribute("id", pageId);
        return "toeditservice";
    }

    /**
     * 代理
     * 
     * @param pageDate
     */
    public void findPageDataById() {
        pageManageFacade.findPageDataById(pageData);
    }

    /**
     * 
     * 用户：查找用户有多少个可以使用的权限
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    public void getUserPrivateNumber() {
        String userId = getFrmUser().etipUserID;
        int num = pageManageFacade.getUserPrivateNumber(userId);
        json = String.valueOf(num);
    }

    /**
     * 
     * page管理页面 查询page是否有未付款服务，返回json数据<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update
     */
    public void findNoPayProduct() {
        /**
         * 开始查询此page未付款的服务
         */
        /*
         * List<String> list_Strings = new ArrayList<String>(); String[] str = { pageData.getId() }; // 此page未付款服务的id
         * String list_Strings = pageFacade.findNoPayProductDataByPage(str); List<ProductData> list_Pro = new
         * ArrayList<ProductData>();// 购物车中未付款服务对象list try { if (list_Strings.size() > 0) {// 如果购物车中有未付款的服务 list_Pro =
         * this.getCtnProduct(list_Strings); } else { list_Strings = pageFacade.findNoPayProductDataByOrderAndPage(str);
         * if (list_Strings.size() > 0) { list_Pro = this.getCtnProduct(list_Strings); } } } catch (Exception e) {
         * e.printStackTrace(); }
         */
        List<ProductData> list_Pro = findNoPayProductData(pageData.getId());
        // 如果此page有未付款的服务
        if (list_Pro.size() > 0) {
            // productdata对象内部有日期类型 和大字段类型 json转换的时候报错 fengxin
            for (int i = 0; i < list_Pro.size(); i++) {
                list_Pro.get(i).setCreateTime(null);
                list_Pro.get(i).setOverTime(null);
                list_Pro.get(i).setImg(null);
            }
            json = JSONArray.fromObject(list_Pro).toString();
        } else {
            pageData = pageManageFacade.findPageDataById(pageData);
            pageData.setState("0");
            pageData.setStatus("1");
            pageData.setCreateTime(new Date());
            pageManageFacade.editPageData(pageData);
            json = "";
        }
    }

    /**
     * 
     * 将登陆的用户信息传递给模板商店页面<br>
     * 用来判断用户是否登陆 若已经登陆则显示退出按钮
     * 
     * @author 文东 <br>
     *         2014-3-31
     * @update
     * @param
     * @return
     * @exception/throws
     * @see PageManageAction#top()
     * @since
     */
    @SuppressWarnings("finally")
    public String top() {
        // 将用户信息传到前端 由于框架本身获取getFrmUser时若没登陆则会出现异常。在这里抓取异常后忽略
        try {
            request.setAttribute("frmUser", getFrmUser());
        } catch (Exception e) {
            // 抓取到异常后不做任何操作
        } finally {
            return "top";
        }
    }

    public String editPageState() {
        PageData data = pageManageFacade.findPageDataById(pageData);
        if (!"1".equals(data.getStatus())) {
            data.setStatus("0");
        } else {
            data.setStatus("1");
        }
        pageFacade.editPage(data);
        return "editPageState";
    }

    /**
     * 
     * page管理中 发布page 此时page页面已经生成 只需要改变page状态<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-24
     * @update dlm 修改内容：用户点击发布的时候用户的试用期权限总数加1 已使用的试用期权限数量加1
     */
    public String publicPageState() {
        pageData = pageFacade.getPageData(JSONObject.fromObject("{id:\"" + pageData.getId() + "\"}")).get(0);
        pageData.setStatus("1");
        pageData.setState("0");
        pageData.setPublishTime(new Date());
        // 设置发布权限试用期限 冯鑫
        pageData.setEndTime(DateFormatUtil.aFewDaysAfter(
                new Date(),
                Integer.parseInt(ReadWriteFile.readTxtFile(ServletActionContext.getServletContext()
                        .getRealPath("/file") + "/file.txt"))));
        pageFacade.editPage(pageData);
        // 如果购买了在线客服服务 此服务有预览效果，在发布的时候去掉此效果。
        productFacade.editOnLineProduct(pageData);

        /*** dlm update 修改用户权限表 ****/
        String userid = getFrmUser().etipUserID;

        // 根据userid获取当前用户的权限对象
        UserInfoData userInfoData = userInfoDataFacade.getUserInfoData(userid);

        // 若该用户已经有购买的官方发布权限的数据则执行更新操作
        if (userInfoData != null) {
            // 在原拥有的官方发布权限的数量加上购买的数量
            userInfoData.setTryPrivilege(userInfoData.getTryPrivilege() + 1);// 试用权限总数+1
            userInfoData.setAlreadyTryPrivilege(userInfoData.getAlreadyTryPrivilege() + 1);// 试用权限总数+1
            userInfoDataFacade.updateUserInfo(userInfoData);
        } else {
            userInfoData = new UserInfoData();// 初始化用户的权限信息
            userInfoData.setUserId(getFrmUser().getEtipUserID());
            userInfoData.setPayPrivilege(0);// 付费权限总数
            userInfoData.setTryPrivilege(1);// 此时试用权限总数+1
            userInfoData.setAlreadyPayPrivilege(0);
            userInfoData.setAlreadyTryPrivilege(0);// 此时已使用的试用权限总数+1
            userInfoData.setAlreadyUpgrade(0);
            userInfoData.setGiveNum(0);
            userInfoData.setRenew(0);
            userInfoData.setOverduePrivilege(0);
            userInfoDataFacade.addUserInfo(userInfoData);
        }

        /********* end *******************/
        return "editPageState2";
    }

    /**
     * 
     * 根据条件查询获取ctn的服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-15
     * @update
     * @param strings String类型的List集合 内存放的服务ID
     * @return List<ProductData> ctn的服务集合 用minipage的对象接收
     * @throws IOException
     * @exception/throws
     * @see PageManageAction#getCtnProduct(List);
     * @since
     */
    @SuppressWarnings("unused")
    private List<ProductData> getCtnProduct(List<String> strings) throws IOException {
        List<ProductData> datas = new ArrayList<ProductData>();
        if (strings.size() > 0) {
            StringBuffer strbuf = new StringBuffer();
            strbuf.append("[");
            for (int i = 0; i < strings.size(); i++) {
                if (strings.size() == i + 1) {
                    strbuf.append("{productId:\"" + strings.get(i) + "\"}");
                } else {
                    strbuf.append("{productId:\"" + strings.get(i) + "\"},");
                }

            }
            strbuf.append("]");
            datas = productFacade.getProductDataByIdStr(strbuf.toString());
            String str1 = null;
            str1 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + strbuf.toString());
            if (null != str1 && !"".equals(str1)) {
                if (!"0".equals(str1)) {
                    JSONArray jsonArr = JSONArray.fromObject(str1);
                    for (int k = 0; k < jsonArr.size(); k++) {
                        if (null != jsonArr.getJSONObject(k)) {
                            ProductData ctnProductData = new ProductData();
                            ctnProductData.setId(jsonArr.getJSONObject(k).getString("id"));
                            ctnProductData.setName(jsonArr.getJSONObject(k).getString("productName"));
                            ctnProductData.setProductConfig(jsonArr.getJSONObject(k).getJSONObject("productConfigData")
                                    .getString("configName"));
                            ctnProductData.setPrice(Double.valueOf(jsonArr.getJSONObject(k)
                                    .getJSONObject("productConfigData").getString("configPrice")));
                            datas.add(ctnProductData);
                        }
                    }
                }
            }
        }
        return datas;
    }

    /**
     * 
     * 解析json格式的字符串获取ctn的服务信息<br>
     * 
     * @author 文东 <br>
     *         2014-4-15
     * @update
     * @param json json格式的字符串
     * @return List<ProductData> 服务集合
     * @exception/throws
     * @see PageManageAction#resolveCtnProduct(String)
     * @since
     */
    private List<ProductData> resolveCtnProduct(String json) {
        if (json != null && !"".equals(json)) {
            JSONArray jsonarray = JSONArray.fromObject(json);
            for (int i = 0; i < jsonarray.size(); i++) {
                ProductData productData = new ProductData();
                JSONObject jobj = (JSONObject) jsonarray.get(i);
                if (null != jobj.getString("price") && !"".equals(jobj.getString("price"))) {
                    productData.setPrice(Double.valueOf(jobj.getString("price")));
                }
                productData.setName(jobj.getString("productName"));
                productData.setId(jobj.getString("id"));
                productData.setSign("2");
                productDatas.add(productData);
            }
        }
        return productDatas;
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
        return pageManageFacade.findNoPayProductData(pageid);
    }

    /**
     * 
     * ajax为Page添加服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @return void 无返回值
     * @exception/throws
     * @see PageManageAction#ajaxAddProduct()
     * @since
     */
    public void ajaxAddProduct() {
        pageProductData.setUserId(getFrmUser().etipUserID);// 获取用户ID
        pageProductFacade.addPageProduct(pageProductData);// 添加服务
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
    }

    /**
     * 
     * ajax为Page删除服务<br>
     * 
     * @author 文东 <br>
     *         2014-4-28
     * @update
     * @return void 无返回值
     * @exception/throws
     * @see PageManageAction#ajaxDelProduct()
     * @since
     */
    public void ajaxDelProduct() {
        pageProductData.setUserId(getFrmUser().etipUserID);// 获取用户ID
        pageProductFacade.delPageProduct(pageProductData);// 删除Page服务
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
    }

    /**
     * 
     * ajax方式修改Page页面的电话号码<br>
     * 
     * @author 文东 <br>
     *         2014-4-29
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see PageManageAction#ajaxEditTel()
     * @since
     */
    public void ajaxEditTel() {
        pageProductFacade.editTel(pageProductData);
        if (null != request.getParameter("content") && !"".equals(request.getParameter("content"))) {
            pageData.setContent(Hibernate.createClob(request.getParameter("content")));
        }
        pageData.setCreateTime(new Date());
        pageManageFacade.editPageData(pageData);
    }

    /**
     * 
     * 编辑已经发布的page 如果有未付款的服务，则状态不做任何处理<br>
     * 
     * @author 冯鑫 <br>
     *         2014-5-5
     * @update
     */
    public void zanCunChangeSate() {
        PageData data = pageManageFacade.findPageDataById(pageData);
        if (!"1".equals(data.getStatus())) {
            pageData.setStatus("0");
        }
        pageManageFacade.editPageData(pageData);
    }

    public void ajaxFindPageDataById() {
        pageData = pageManageFacade.findPageDataById(pageData);
        json = pageData.getStatus();
    }

    /**
     * 
     * ajax根据pageId查询page所用的模板的主预览图片<br>
     * 并将图片生成文件，图片地址传到前台显示
     * 
     * @author 文东 <br>
     *         2014年6月25日
     * @update
     * @return void
     * @exception/throws io异常
     * @see PageManageAction#ajaxSearchPicByPageId()
     * @since
     */
    public void ajaxSearchPicByPageId() {
        // 获取pageId
        String pageId = request.getParameter("pageId");
        // 获取page所用的模板的主预览图片
        TemplateThumbnailData thumbnailData = pageManageFacade.getTempPicByPageId(pageId);
        // 将获取到的图片blob生成图片
        // 图片保存的路径
        String filePath = request.getRealPath("") + "/img/pagePic";
        // 图片的名称
        String filename = "main_" + thumbnailData.getId();
        String myPath = "";
        // 获取图片地址
        try {
            // 生成图片文件
            OutImgBlob.outImg(thumbnailData.getContent(), filePath, filename);
            // 获取图片地址
            myPath = "/img/pagePic/" + filename + ".jpg";

        } catch (Exception e) {
            myPath = "\\img\\editor\\erro.jpg";
        }
        // 将图片路径传到前台
        json = myPath;
    }

    
     /**
      * 
      *page分享功能<br>
      * 
      * @author 侯杨 <br> 
      *		   2014-7-15
      * @update 
      * @param [参数1]     [参数1说明]
      * @return  [返回类型说明]
      * @exception/throws [异常类型] [异常说明]
      * @see   [类、类#方法、类#成员]
      * @since [起始版本]
      */
    public void sharePage(){
        String pathurl = ReadDomain.readProperties();
        PageData data=pageManageFacade.getPageZing(pageData);
     
        //小图路径
        String zingpathmin="/img/zing/min_"+ data.getId() + "zing"+".gif";
        //生成二维码 大图
        String myPath =  request.getRealPath("") +  "/img/zing/" + data.getId() + "zing"+".gif";
        //生成二维码 小图
        String myPathmin =  request.getRealPath("") + "/img/zing/min_"+data.getId() + "zing"+".gif";
        //存入数据库的路径
       String zingpath="/img/zing/" + data.getId() + "zing"+".gif";
      
       String url= com.mini.util.ZingUtil.zing(data, pathurl, myPath, 300, 300);  //生成大图
       url=com.mini.util.ZingUtil.zing(data, pathurl, myPathmin, 100, 100);  //生成小图
         if(url!="0"&& !"0".equals(url)){
            data.setZing(zingpath);  //二维码路径
            pageManageFacade.updatePage(data);
            json= data.getZing()+"&"+ReadDomain.CODEIMGPATH+zingpathmin;  //返回二维码路径
         }else{
             json="0";
         }
    }
    /**
     * 
     *去微信分享页面<br>
     * 
     * @author li <br> 
     *		   2014-7-15
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String toWeixin(){
        request.setAttribute("ImgUrl", request.getParameter("ImgUrl"));
        request.setAttribute("domain", request.getParameter("domain"));
        request.setAttribute("pageName", request.getParameter("pageName"));
        return "weixin";
    }
    
    /**
     * 
     * ajax查询用户是否具有收款账号<br>
     * 
     * @author 文东<br> 
     *		   2014年9月11日
     * @update 侯杨
     * @param 
     * @return  void 
     * @exception/throws 
     * @see  PageManageAction#ajaxisExitReceivableAccount()
     * @since vmaque1.5
     */
    public void ajaxisExitReceivableAccount(){
        // 获取当前登录用户的id
        String userId = getFrmUser().etipUserID;
        // 查询改页面所属的用户是否具有收款账号
      accountNumberDatas=accountNumberFacade.queryAccountNumberDataByuserId(userId);
        if(accountNumberDatas.size()>0){
            json = "existence";
        }else{
            json = "1";
        }
    }
    
    /**
     * 
     *在购买主键的时候 根据pageid 查询page信息  写入购买的css文件<br>
     * @author 侯杨 <br> 
     *         2014-9-23
     * @update 
     * @see PageManageAction#createGoodsCss()
     * @since vmaque1.6
     */
     public void addGoodsInfoCss(){
         //css文件路径
         String cssFilePath =  request.getRealPath("/") + "/view/css/mini/css/goodsInfo.css";
         //html页面css引入文件路径
         String cssPath="/view/css/mini/css/goodsInfo.css";
         json=pageManageFacade.createGoodsCss(pageData, cssFilePath, cssPath);
         
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
      * @see   PageManageAction#copyPage()
      * @since vmaque1.7
      */
    public void copyPage() {
        pageData=pageManageFacade.copyPage(pageData);
        if(pageData.getId()!=null && !"".equals(pageData.getId())){
            json="1";
        }else{
            json="0";
        }
    }


    /**************************************************红包系统调用方法************************************************/
    
    /**
     * 
     * 根据用户id查询发布的page域名信息
     * 
     * @author 左香勇 <br> 
     *		   2014年11月28日
     * @see   PageManageAction#getPageListByUserId()
     * @since vmaque2.0
     */
    public void getPageListByUserId(){
        if(pageData != null && pageData.getUserId() != null && !"".equals(pageData.getUserId())) {
            List<PageInfoExtraData> list = pageInfoExtraFacade.getPageInfoExtraDatasByUserId(pageData.getUserId());
            StringBuffer sbfJson=new StringBuffer("[");
            for(int i=0;i<list.size();i++){
                sbfJson.append("{");
                sbfJson.append("\"domain\":\"");
                sbfJson.append(list.get(i).getDomain());
                sbfJson.append("\",\"pageId\":\"");
                sbfJson.append(list.get(i).getPageId());
                sbfJson.append("\"}");
                if(i<list.size()-1){
                    sbfJson.append(",");
                }
            }
            sbfJson.append("]");
            json=sbfJson.toString();
        } else {
            json="[]";
        }
    }
    /************************************************************************************************************/
    
    public void goumaiProduct(){
        String msg="0";
     // 根据PageId 获取该PageId所拥有的服务 无论未付款还是已付款
        List<ProductData> list = new ArrayList<ProductData>();
        list = productFacade.getProductByPageId(pageData.getId());
         if(list.size()>0){
              for (int i = 0; i < list.size(); i++) {
                  if(list.get(i).getType().equals("6")){
                      msg="1";
                      break;
                  }
                  msg="0";
            }
         }
         json=msg;
    }

    /*
     * get/set方法 **************************************************************** **************************
     */
    
    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public List<PageData> getPageDataList() {
        return pageDataList;
    }

    public void setPageDataList(List<PageData> pageDataList) {
        this.pageDataList = pageDataList;
    }

    public PageInfoExtraData getPageInfoExtraData() {
        return pageInfoExtraData;
    }

    public void setPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        this.pageInfoExtraData = pageInfoExtraData;
    }

    public TreeMap<Integer, String> getDisabledType() {
        return disabledType;
    }

    public void setDisabledType(TreeMap<Integer, String> disabledType) {
        this.disabledType = disabledType;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public List<ProductData> getProductDatas() {
        return productDatas;
    }

    public void setProductDatas(List<ProductData> productDatas) {
        this.productDatas = productDatas;
    }

    public PageInfoExtraData getInfoExtraData() {
        return infoExtraData;
    }

    public void setInfoExtraData(PageInfoExtraData infoExtraData) {
        this.infoExtraData = infoExtraData;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public TreeMap<Integer, String> getPageStateType() {
        return pageStateType;
    }

    public void setPageStateType(TreeMap<Integer, String> pageStateType) {
        this.pageStateType = pageStateType;
    }

    public List<PageProductData> getPageProductDatas() {
        return pageProductDatas;
    }

    public void setPageProductDatas(List<PageProductData> pageProductDatas) {
        this.pageProductDatas = pageProductDatas;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public GoodsInfoData getGoodsInfoData() {
        return goodsInfoData;
    }

    public void setGoodsInfoData(GoodsInfoData goodsInfoData) {
        this.goodsInfoData = goodsInfoData;
    }

    public CommodityConfigData getCommodityConfigData() {
        return commodityConfigData;
    }

    public void setCommodityConfigData(CommodityConfigData commodityConfigData) {
        this.commodityConfigData = commodityConfigData;
    }

    public PageGoodsInfoData getPageGoodsInfoData() {
        return pageGoodsInfoData;
    }

    public void setPageGoodsInfoData(PageGoodsInfoData pageGoodsInfoData) {
        this.pageGoodsInfoData = pageGoodsInfoData;
    }

    public List<AccountNumberData> getAccountNumberDatas() {
        return accountNumberDatas;
    }

    public void setAccountNumberDatas(List<AccountNumberData> accountNumberDatas) {
        this.accountNumberDatas=accountNumberDatas;
    }

    /*
     * ******************************************************************************************
     */
    
}
