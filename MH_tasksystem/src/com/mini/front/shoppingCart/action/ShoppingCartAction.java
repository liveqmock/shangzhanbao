package com.mini.front.shoppingCart.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.mini.back.product.facade.ProductFacade;
import com.mini.front.shoppingCart.facade.ShoppingCartFacade;
import com.mini.page.data.PageData;
import com.mini.product.data.ProductData;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.util.HttpWebUtil;
import com.util.ReadDomain;

@Results({ @Result(name = "topShopCart", location = "/view/pages/mini/front/order/topshoppingCart.jsp"), // 头部购车页面
        @Result(name = "toOrderConfig", location = "/view/pages/mini/front/order/orderConfirm.jsp"), // 头部购车页面
        @Result(name = "shopping", location = "view/pages/mini/front/order/shoppingCart.jsp") // 购买官方发布权限页面
})
public class ShoppingCartAction extends FrmAction {
    @Resource(name = "shoppingCartFacade")
    private ShoppingCartFacade shoppingCartFacade;
    // 服务facade 接口
    @Resource(name = "productFacade")
    private ProductFacade productFacade;
    
    private ShoppingCartData shoppingCartData; // 购物车实体
    private ProductData productData=new ProductData();   //服务实体
    private List<PageData> list = new ArrayList<PageData>();
    private String noPayPageId;
    private String noPayProductID;
    List<ProductData> productList = new ArrayList<ProductData>();// 购物车的集合

    private String pageId;
    private String productName; // 服务名称
    public static final String fileName = "domain.properties";
    public static final String PATH = ResouceUtil.getProperty(fileName, "path");// 读取文件中的路径

    /***************************************************************
     * 方法 *************************************************************** /
     * 
     * /** 购物车数据添加
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param date
     */

    public void addShoppingCartData() {
        String userId = getFrmUser().etipUserID;
        shoppingCartData.setIsDelete(1);
        shoppingCartData.setUserId(userId);
        json = shoppingCartFacade.addShoppingCartData(shoppingCartData, productName);

    }

    /**
     * 根据用户id 查询 当前用户的购物车信息
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param
     * @return
     */

    public String getAll() {
        String sign = request.getParameter("sign");// 从购物车进来是1，从购买发布权限进来是2
        String userId = getFrmUser().etipUserID;
        // 在创建Page时购买的服务
        List<PageData> productOwnDomain = new ArrayList<PageData>();
        List<ProductData> datas = shoppingCartFacade.getShoppingCartData(userId);
        productOwnDomain = shoppingCartFacade.getAll(userId);
        productList = shoppingCartFacade.getShoppingCartDataP(userId);
        for (int i = 0; i < productOwnDomain.size(); i++) {
            if (productOwnDomain.get(i).getPageInfoExtra() != null) {
                productOwnDomain.get(i).getPageInfoExtra()
                        .setDomain(PATH + productOwnDomain.get(i).getPageInfoExtra().getDomain());
            }
            if (null != productOwnDomain.get(i).getListProduct()) {
                for (int j = 0; j < productOwnDomain.get(i).getListProduct().size(); j++) {
                    StringBuffer str = new StringBuffer();
                    str.append("[{productId:\"" + productOwnDomain.get(i).getListProduct().get(j).getId() + "\"}]");
                    try {
                        String str1 = null;
                        str1 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + str.toString());
                        productOwnDomain.set(i, resolveCtnp(productOwnDomain.get(i), j, str1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        if (datas != null && datas.size() > 0) {
            for (int j = 0; j < datas.size(); j++) {
                StringBuffer str = new StringBuffer();
                str.append("[{productId:\"" + datas.get(j).getId() + "\"}]");
                try {
                    String str1 = null;
                    str1 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + str.toString());
                    datas.set(j, resolveCtmPro(datas.get(j), str1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String path = ReadDomain.readProperties();// 读取域名
        request.setAttribute("productOwnDomain", productOwnDomain);
        request.setAttribute("path", path);
        request.setAttribute("sign", sign);
        request.setAttribute("datas", datas);
        return "topShopCart";
    }

    /**
     * 根据用户id 查询 当前用户的购物车数量
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param 
     * @return
     */
    public void getCount() {
        String userId = getFrmUser().etipUserID;
        json = shoppingCartFacade.getCount(userId) + "";
    }

    /**
     * 删除数据 假删
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param 
     * @return
     */
    public void updateShoppingCartData() {
        json = shoppingCartFacade.updateShoppingCartData(shoppingCartData);
    }

    /**
     * 购买发布权限 添加数据 如果存在就修改
     * 
     * @author 侯杨
     * @date 2014-04-09
     * @param 
     * @return
     */

    public String updateSaveShoppingCartData() {
        String userId = getFrmUser().etipUserID;
        String sign = "2";
        productList = shoppingCartFacade.updateSaveShoppingCartData(userId, sign);
        // 在创建Page时购买的服务
        List<PageData> productOwnDomain = new ArrayList<PageData>();

        List<ProductData> datas = shoppingCartFacade.getShoppingCartData(userId);
        productOwnDomain = shoppingCartFacade.getAll(userId);

        for (int i = 0; i < productOwnDomain.size(); i++) {
            if (productOwnDomain.get(i).getPageInfoExtra() != null) {
                productOwnDomain.get(i).getPageInfoExtra()
                        .setDomain(PATH + productOwnDomain.get(i).getPageInfoExtra().getDomain());
            }
            if (null != productOwnDomain.get(i).getListProduct()) {
                for (int j = 0; j < productOwnDomain.get(i).getListProduct().size(); j++) {
                    StringBuffer str = new StringBuffer();
                    str.append("[{productId:\"" + productOwnDomain.get(i).getListProduct().get(j).getId() + "\"}]");
                    try {
                        String str1 = null;
                        str1 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + str.toString());
                        productOwnDomain.set(i, resolveCtnp(productOwnDomain.get(i), j, str1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        if (datas != null && datas.size() > 0) {
            for (int j = 0; j < datas.size(); j++) {
                StringBuffer str = new StringBuffer();
                str.append("[{productId:\"" + datas.get(j).getId() + "\"}]");
                try {
                    String str1 = null;
                    str1 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + str.toString());
                    datas.set(j, resolveCtmPro(datas.get(j), str1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String path = ReadDomain.readProperties();// 读取域名
        request.setAttribute("productOwnDomain", productOwnDomain);
        request.setAttribute("datas", datas);
        request.setAttribute("path", path);
        request.setAttribute("sign", sign);
        return "shopping";
    }

    private ProductData resolveCtmPro(ProductData data, String str1) {
        if (null != str1 && !"".equals(str1)) {
            if (!"0".equals(str1)) {
                JSONArray jsonArr = JSONArray.fromObject(str1);
                for (int k = 0; k < jsonArr.size(); k++) {
                    if (null != jsonArr.getJSONObject(k)) {
                        data.setName(jsonArr.getJSONObject(k).getString("productName"));
                        data.setPrice(Double.valueOf(jsonArr.getJSONObject(k).getJSONObject("productConfigData")
                                .getString("configPrice")));
                        data.setStatus(jsonArr.getJSONObject(k).getString("productstate"));
                        JSONObject pobj = (JSONObject) jsonArr.getJSONObject(k).get("productConfigData");
                        data.setProductConfig(pobj.getString("configName"));

                    }
                }
            }
        }
        return data;
    }

    private PageData resolveCtnp(PageData pageData, int j, String str1) {
        if (null != str1 && !"".equals(str1)) {

            if (!"0".equals(str1)) {
                JSONArray jsonArr = JSONArray.fromObject(str1);
                for (int k = 0; k < jsonArr.size(); k++) {
                    if (null != jsonArr.getJSONObject(k)) {
                        pageData.getListProduct().get(j).setName(jsonArr.getJSONObject(k).getString("productName"));
                        pageData.getListProduct().get(j).setStatus(jsonArr.getJSONObject(k).getString("productstate"));
                        pageData.getListProduct()
                                .get(j)
                                .setProductConfig(
                                        jsonArr.getJSONObject(k).getJSONObject("productConfigData")
                                                .getString("configName"));
                        pageData.getListProduct()
                                .get(j)
                                .setPrice(
                                        Double.valueOf(jsonArr.getJSONObject(k).getJSONObject("productConfigData")
                                                .getString("configPrice")));

                    }
                }
            }
        }
        return pageData;
    }

    /**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * noPayProductID为空的时：是在用户点击结算 但没有付款成功的时候 用户再次进入购物车 要显示没有付款成功的商品
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update 冯鑫
     * @param String pageID,String noPayProductId
     */
//    public void editNoPayProductState() {
//        shoppingCartFacade.editNoPayProductState(noPayPageId, noPayProductID);
//    }

    /**
     * 
     * 点击去支付，跳转到订单的确认页面<br>
     * 
     * @author dlm <br>
     *         2014-4-9
     */
    public String toOrderConfig() {
        return "toOrderConfig";
    }
    
    
    /**
     * 
     *page管理中在线客服详情页面，的去购买按钮功能<br>
     * 
     * @author 侯杨 <br> 
     *		   2014-7-14
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void addShoppingCartDataPageProductView() {
        String userId = getFrmUser().etipUserID;   //获取用户id
        shoppingCartData.setIsDelete(1);
        shoppingCartData.setUserId(userId);   //用户id
        productData.setName("在线咨询");
        productData=productFacade.getPrdouct(productData);  //查询服务详情
        if(productData!=null){
        shoppingCartData.setProductId(productData.getId());  //服务id
        json = shoppingCartFacade.addShoppingCartData(shoppingCartData, productData.getName());
         }else{
             json="0";
         }

    }

    /********************************************************************************************* get/set 方法 ************************************************************************************************************************************************/

    public ShoppingCartData getShoppingCartData() {
        return shoppingCartData;
    }

    public void setShoppingCartData(ShoppingCartData shoppingCartData) {
        this.shoppingCartData = shoppingCartData;
    }

    public List<PageData> getList() {
        return list;
    }

    public void setList(List<PageData> list) {
        this.list = list;
    }

    public List<ProductData> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductData> productList) {
        this.productList = productList;
    }

    public String getNoPayPageId() {
        return noPayPageId;
    }

    public void setNoPayPageId(String noPayPageId) {
        this.noPayPageId = noPayPageId;
    }

    public String getNoPayProductID() {
        return noPayProductID;
    }

    public void setNoPayProductID(String noPayProductID) {
        this.noPayProductID = noPayProductID;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

      
}
