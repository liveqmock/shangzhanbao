package com.mini.front.order.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.FileUpload;
import com.common.util.OrderCodeSetter;
import com.common.util.UploadPath;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.back.give.facade.UserInfoDataFacade;
import com.mini.back.product.facade.ProductFacade;
import com.mini.front.businessUser.facade.BusinessUserFacade;
import com.mini.front.order.facade.OrderFacade;
import com.mini.front.order.facade.OrderProductFacade;
import com.mini.front.order.facade.PageProductFacade;
import com.mini.give.data.UserInfoData;
import com.mini.order.data.AttenInfoData;
import com.mini.order.data.InvoiceData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.util.Escape;
import com.util.ReadDomain;
import com.util.mail.MailUtil;

/**
 * 订单管理控制层管理类
 * 
 * @author linhp
 * 
 */
@ResultPath("/")
@Results({ @Result(name = "orderList", location = "view/pages/mini/front/order/UserCenter_order.jsp"),
        @Result(name = "orderConfirm", location = "view/pages/mini/front/order/orderConfirm.jsp"),
        // 订单详情
        @Result(name = "orderView", location = "view/pages/mini/front/order/orderView.jsp"),
        // 订单提交中间页面
        @Result(name = "redirectToPay", location = "view/pages/mini/front/alipay/redirectToPay.jsp") })
public class OrderAction extends FrmAction {
    @Resource(name = "orderFacade")
    private OrderFacade orderFacade;// 订单表Facade类

    @Resource(name = "orderProductFacade")
    private OrderProductFacade orderProductFacade;// 订单产品中间表Facade类

    @Resource(name = "pageProductFacade")
    private PageProductFacade pageProductFacade;// page服务中间表Facade类

    @Resource(name = "productFacade")
    private ProductFacade productFacade;// product服务表Facade类

    @Resource(name = "userInfoDataFacade")
    private UserInfoDataFacade userInfoDataFacade;// 用户所拥有的官方发布权限 容器注入

    @Resource(name = "businessUserFacade")
    private BusinessUserFacade businessUserFacade; // 实名认证注入

    private UserInfoData userInfoData = new UserInfoData();// 用户所拥有的官方发布权限对象

    private OrderData orderData = new OrderData();// 订单实体对象
    private BusinessUserData businessUserData = new BusinessUserData(); // 实名认证信息实体

    List<OrderData> orderList = new ArrayList<OrderData>();// 订单实体对象集合

    private OrderProductData orderProductData = new OrderProductData();

    private List<ProductData> productDatas = new ArrayList<ProductData>();// 产品服务集合

    private InvoiceData invoiceData = new InvoiceData(); // 发票实体
    private PageRoll pageRoll = new PageRoll();   //分页对象

    // 订单服务中间表对象 集合
    private List<OrderProductData> orderProductDatas = new ArrayList<OrderProductData>();
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> orderproductstate = CacheUtil.getInstance().getCacheMap("orderproductstate"); // 订单与服务中间表状态
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> orderstate = CacheUtil.getInstance().getCacheMap("OrderState"); // 订单状态
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> InvoiceType = CacheUtil.getInstance().getCacheMap("InvoiceType"); // 发票内容
    private File blImgFile;// 获取营业执照电子版文件
    private String blImgFileFileName;// 获取上传营业执照电子版文件名称
    private String blImgFileContentType;// 获取上传营业执照电子版文件类型

    private String order_state_1;// 标示订单list中有未付款的订单
    private String order_state_2;// 标示订单list中有已 付款的订单
    private String order_state_3;// 标示订单list中有已完成的订单

    private File ymsqsImgFile;// 获取域名授权书图片文件
    private String ymsqsImgFileFileName;// 获取域名授权书图片文件名称
    private String ymsqsImgContentType;// 获取域名授权书图片文件类型

    private String orderIds[]; // 订单数组

    private AttenInfoData attenInfoData = new AttenInfoData();// 订单联系人信息

    private List<AttenInfoData> attenInfoDatas = new ArrayList<AttenInfoData>();// 订单联系人信息集合

    /********************************************************************************************************************************************************************************************************/

    /**
     * 购买发布权限，跳转到订单确认页面
     */
    public String topayqx() {
        // 获取当前用户的id
        String userid = getFrmUser().etipUserID;
        String amount = request.getParameter("amount");// 获取页面传来的数量
        ProductData qxData = productFacade.findBySign(1);// 根据特殊标识查询出发布权限的服务信息,没做空处理，数据库必须要有一款sign=1的服务
        if (amount != null) {
            qxData.setGoodNum(Integer.parseInt(amount));// 购买的数量（非数据库字段）
        }
        // 获取发票信息
        invoiceData = orderFacade.getInvoiceDataByUserId(userid);
        /**
         * 修改人；文东 修改时间：2014/05/15 修改内容 在进入订单页面前查询出该用户的所有联系人信息
         */
        attenInfoDatas = orderFacade.searchAllByUserId(userid);
        productDatas.add(qxData);
        request.setAttribute("amount", amount);
        request.setAttribute("paySign", 0);// 页面显示的标识0为发布权限结算
        request.setAttribute("InvoiceType", InvoiceType);// 发票内容
        
        return "orderConfirm";
    }

    /**
     * 购买发布权限,生成订单
     */
    public String saveOrderqx() {

        Date date = new Date();

        // 获取当前用户的id
        String userid = getFrmUser().etipUserID;
        // String userName = getFrmUser().chinseName;
        String amount = request.getParameter("amount");
        // 如果获取不到权限的数量则给1
        if ("".equals(amount) || amount == null) {
            amount = "1";
        }

        // 查询发布权限的对象
        ProductData qxData = productFacade.findBySign(1);// 根据特殊标识查询出发布权限的服务信息,没做空处理，数据库必须要有一款sign=1的服务

        // 首先加入到订单对象
        orderData.setCode(OrderCodeSetter.getCode());// 订单编号根据订单的生成规则来生成
        orderData.setCreateTime(date);// 创建时间
        orderData.setModifyTime(date);// 修改时间
        orderData.setSysUserId(userid);// 加入用户id
        // orderData.setUserName(userName);// 加入用户名
        if (orderData.getPayType() != null && orderData.getPayType() == 0) {// 如果付款方式为线下付款
            orderData.setState(1);// 付款状态为线下付款
        }
        orderData.setPrice(qxData.getPrice() * Integer.parseInt(amount));// 订单的价格

        /**
         * 修改人：文东 时间：2014/05/14 修改内容：给发票信息的用户id赋值
         */
        if (orderData.getInvoiceData() != null) {
            orderData.getInvoiceData().setUserId(userid);// 若该订单有发票信息则给该发票信息的用户id赋值
        }

        // 保存订单对象到数据库
        orderFacade.addOrder(orderData);

        // 加入数据到订单服务中间表对象，数量在页面获取的
        orderProductData.setOrderId(orderData.getId());// 订单id
        orderProductData.setProductId(qxData.getId());// 服务id
        orderProductData.setProductName(qxData.getName());// 服务名称
        orderProductData.setUnitPrice(qxData.getPrice() * Integer.parseInt(amount));// 服务在订单里面的价格
        orderProductData.setProductConfigName(qxData.getProductConfig());// 服务配置名称
        orderProductData.setYearLimit(1);// 发布权限为一年
        orderProductData.setAmount(Integer.parseInt(amount));// 数量
        // orderProductData.setState(0);// 中间表状态，未开通，付款以后变为已开通
        orderProductFacade.addOrderProduct(orderProductData);

        // 修改购物车对象的数据为假删，根据用户id和服务id去删除属于这个用户的发布权限的服务
        orderFacade.updateShoppingCart(userid, qxData.getId());

        request.setAttribute("type", orderData.getPayType());// 付款方式传递给页面来判断跳转的页面
        request.setAttribute("code", orderData.getCode());// 订单编号
        request.setAttribute("orderId", orderData.getId());// 订单id
        request.setAttribute("price", orderData.getPrice());// 订单价格


        /**
         * 修改人：左香勇 修改时间：2014-06-17 修改内容 添加发送邮件功能
         */
        if (orderData.getPayType() != null && orderData.getPayType() == 0) {// 如果付款方式为线下付款
           Map<String, String> contentMap = new HashMap<String, String>();

           contentMap.put("userName", orderData.getUserName());
           contentMap.put("order", orderData.getCode());
           contentMap.put("url", "/order/key/findOrderView?orderData.id="+orderData.getId());
           
           sendMail(orderData.getUserMail(), contentMap, 8);
        } else if (orderData.getPayType() == 1) { //付款方式为线上付款
            Map<String, String> contentMap = new HashMap<String, String>();

            contentMap.put("userName", orderData.getUserName());
            contentMap.put("order", orderData.getCode());
            contentMap.put("url", "/order/key/findOrderView?orderData.id="+orderData.getId());
            
            sendMail(orderData.getUserMail(), contentMap, 5);
        }
        
        return "redirectToPay";

    }

    /**
     * 购买page服务,跳转到订单确认页面
     * 
     * @update 文东
     */
    public String topay() {

        // 获取当前用户的id
        String userid = getFrmUser().etipUserID;

        // 根据pageid和userid查询shoppingcart里面的所有该page的服务的集合然后跳转到订单页面
        productDatas = productFacade.getShopProductByPageId(orderProductData.getPageId(), userid);

        request.setAttribute("paySign", 1);// 页面显示的标识0为发布权限结算
        /**
         * 修改人；文东 修改时间：2014/05/14 修改内容 在进入订单页面前查询出该用户的所有联系人信息
         */
        attenInfoDatas = orderFacade.searchAllByUserId(userid);
        return "orderConfirm";

    }

    /**
     * 购买page服务，生成订单
     */
    public String saveOrder() {

        Date date = new Date();

        // 获取当前用户的id
        String userid = getFrmUser().etipUserID;
        // String userName = getFrmUser().chinseName;

        // 获取页面传来的pageid和服务的id数组
        String pageid = orderProductData.getPageId();
        String[] productids = request.getParameterValues("productIds");

        // 分解服务的id,既然存在购物车中，那么服务的id必不为空
        List<ProductData> productDatas = new ArrayList<ProductData>();
        double orderPrice = 0.0;// 用来存放订单的价格
        if (productids != null && productids.length!=0) {
            // 根据服务的id去查询这款服务的信息，判断是否是从ctn接口得来的服务，如果是则调用ctn的服务接口
            productDatas = checkProduct(productids);
            for (ProductData pdata : productDatas) {
                orderPrice += pdata.getPrice();
            }
        }

        // 首先加入订单对象
        orderData.setCode(OrderCodeSetter.getCode());// 订单编号根据订单的生成规则来生成
        orderData.setCreateTime(date);// 创建时间
        orderData.setModifyTime(date);// 修改时间
        orderData.setSysUserId(userid);// 加入用户id
        // orderData.setUserName(userName);// 加入用户名
        orderData.setPrice(orderPrice);// 订单的价格
        if (orderData.getPayType() != null && orderData.getPayType() == 0) {// 如果付款方式为线下付款
            orderData.setState(1);// 付款状态为线下付款
        }
        // 保存订单对象到数据库
        orderFacade.addOrder(orderData);

        // 加入数据到订单服务中间表对象，服务只能买一个所以数量为1
        for (ProductData data : productDatas) {
            orderProductData.setOrderId(orderData.getId());// 订单id
            orderProductData.setProductId(data.getId());// 服务id
            orderProductData.setProductName(data.getName());// 服务名称
            orderProductData.setUnitPrice(data.getPrice() * 1);// 服务在订单里面的价格
            orderProductData.setProductConfigId(data.getProductConfig());// 服务配置id
            orderProductData.setProductConfigName(data.getProductConfig());// 服务配置名称
            orderProductData.setYearLimit(1);// 发布年限
            orderProductData.setAmount(1);// 数量为1
            // orderProductData.setPageId(pageid);//所属页面的id页面传
            // orderProductData.setState(0);// 中间表状态，服务未开通0
            orderProductFacade.addOrderProduct(orderProductData);
        }

        // 修改购物车对象的数据为假删,根据用户的id和page的id
        orderFacade.updateShoppingCartbypage(userid, pageid);

        // /**
        // * 在用户已经购买的服务存入到Page所拥有的服务对象中
        // */
        // for (ProductData data : productDatas) {
        // OrderProductData ord = new OrderProductData();
        // ord.setPageId(pageid);
        // ord.setProductId(data.getId());
        // PageProductData pageProductData =
        // pageProductFacade.getPageProductData(ord);
        // if(pageProductData!=null){
        // pageProductData.setIsdelete(1);
        // pageProductFacade.editPageProduct(pageProductData);
        // }
        // }

        request.setAttribute("type", orderData.getPayType());// 付款方式传递给页面来判断跳转的页面
        request.setAttribute("code", orderData.getCode());// 订单编号
        request.setAttribute("orderId", orderData.getId());// 订单id
        request.setAttribute("price", orderData.getPrice());// 订单id

        /**
         * 修改人：左香勇 修改时间：2014-06-17 修改内容 添加发送邮件功能
         */
        if (orderData.getPayType() != null && orderData.getPayType() == 0) {// 如果付款方式为线下付款
           Map<String, String> contentMap = new HashMap<String, String>();

           contentMap.put("userName", orderData.getUserName());
           contentMap.put("order", orderData.getCode());
           contentMap.put("url", "/order/key/findOrderView?orderData.id="+orderData.getId());
           
           sendMail(orderData.getUserMail(), contentMap, 8);
        } else if (orderData.getPayType() == 1)  { //付款方式为线上付款
            Map<String, String> contentMap = new HashMap<String, String>();

            contentMap.put("userName", orderData.getUserName());
            contentMap.put("order", orderData.getCode());
            contentMap.put("url", "/order/key/findOrderView?orderData.id="+orderData.getId());
            
            sendMail(orderData.getUserMail(), contentMap, 5);
        }
        
        return "redirectToPay";

    }

    // 检查productid的来源，并返回product对象
    private List<ProductData> checkProduct(String[] productid) {
        return productFacade.checkProduct(productid);
    }

    /**
     * 购物车的全部结算功能（暂时改变状态）
     */
    public void topayAll() {

//        Date date = new Date();
//
//        // 获取当前用户的id
//        String userid = getFrmUser().etipUserID;
//
//        // 查询发布权限的对象
//        ProductData qxData = productFacade.findBySign(1);// 根据特殊标识查询出发布权限的服务信息,没做空处理，数据库必须要有一款sign=1的服务

//        // 根据当前用户的id去查询在购物车里面的所有的服务
//
//        // 加入订单对象
//        // 保存订单对象到数据库
//        // 加入数据到订单服务中间表，获取发布权限的数量加入对象，获取其他服务数量为1
//        // 修改用户的权限信息
//        // 修改购物车对象的数据为假删
    }

    /**
     * 在确认支付（付款成功的时候）对中间表进行更新
     */
    public String payForOrder() {
        /**
         * 等待支付成功的接口,,在接口返回成功的时候，才能真正执行下面的的代码
         */
        String userId = getFrmUser().etipUserID;
        String idValue = request.getParameter("ids");// 订单的id
        String[] ids = idValue.split(",");
        for (int i = 0; i < orderProductDatas.size(); i++) {
            PageProductData pageProductData = new PageProductData();
            pageProductData = pageProductFacade.getPageProductData(orderProductDatas.get(i));// 获取中间表
            if (pageProductData != null && !pageProductData.getId().equals("")) {
                pageProductData.setCreateTime(new Date());
                pageProductData.setIsdelete(2);// 未开通
                pageProductFacade.editPageProduct(pageProductData);
                System.out.println("在确认支付（付款成功的时候）对中间表进行更新");
            }
        }
        for (int i = 0; i < ids.length; i++) {
            String orderjson = "{'id':'" + ids[i] + "'}";
            List<OrderData> orderList = orderFacade.getOrderData(JSONObject.fromObject(orderjson));
            if (null != orderList && orderList.size() > 0) {
                // 更新 userinfo实体
                orderFacade.updateOrderUserInfo(userId, ids[i]);
                OrderData orderData = orderList.get(0);
                orderData.setState(2);// 设置成已付款
                orderFacade.editOrder(orderData);
            }
        }
        try {
            response.getWriter().print("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "orderList";
    }

    /**
     * 根据系统当前登录的用户查询所有订单
     * 
     * @update 冯鑫 20140430 增加标示来标示此list中是否有各种状态的订单
     * @return
     */
    public String orderList() {
        // 获取系统当前登录用户的ID
        String id = getFrmUser().getEtipUserID();
        orderData.setSysUserId(id);
        
        // 获取订单已经订单所包含的服务
        orderList = orderFacade.getOrderAndOrderProduct(pageRoll, orderData);
        if(orderData.getState()==null){
            orderData.setState(1);
        }
        request.setAttribute("orderList", orderList);
        request.setAttribute("orderstate", orderData.getState());
        request.setAttribute("menuNum", 5);
        return "orderList";
    }

    /**
     * 删除订单下的小商品
     * 
     * @throws IOException
     */
    public void deleteProduct() throws IOException {
        String orderid = request.getParameter("orderid");// 订单的id
        String[] orderId = { orderid };// 订单的id数组
        String[] ids = { request.getParameter("id") };// 中间表的id
        if (null != ids && ids.length > 0) {
            orderProductFacade.deleteOrderProduct(ids);// 删除订单下的小商品
            List<OrderProductData> list = orderProductFacade.getOrderProduct(JSONObject.fromObject("{'orderId':'"
                    + orderid + "'}"));// 验证小商品是否被删空
            if (list.size() == 0) {
                orderFacade.deleteOrder(orderId);// 是的话就把主表订单删除
            }
            response.getWriter().print("success");
        }
    }

    /**
     * 删除订单
     * 
     * @throws IOException
     */
    public void deleteOrder() throws IOException {
        String id = request.getParameter("ids");
        String[] ids = id.split(",");
        if (null != ids && ids.length > 0) {
            orderFacade.deleteOrder(ids);
            response.getWriter().print("success");
        }
    }

    /**
     * 
     * 删除MINI_ORDER,同时删除MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update 侯杨 <br>
     *         传的参数改变了 传递订单id的数组
     */
    public void deleteOrderByID() {
        orderFacade.deleteOrderByID(orderIds);
    }

    /**
     * 
     * 删除已经完成订单 物理删除 包括订单表 已经订单服务中间表
     * 
     * @author 冯鑫 <br>
     *         2014-4-23
     * @update 冯鑫 2014-5-6
     */
    public void deleteOnlyOrderByID() {
        /*
         * orderData = orderFacade.getOrderData(orderData).get(0); orderData.setState(5);// 设置订单状态为已经删除
         * orderFacade.editOrder(orderData);
         */
        /******************************* 冯鑫begin ***************************************/
        orderFacade.deleteOnlyOrderByID(orderData);
        /******************************* 冯鑫end ***************************************/
    }

    /**
     * 填写实名认证信息
     * 
     * @author 侯杨
     * @date 2014-04-22
     * @param businessUserData
     */
    public void addbusinessUserData() {
        String userId = getFrmUser().etipUserID; // 用户id
        // 实名认证信息 添加信息
        if (ymsqsImgFileFileName != null && !"".equals(ymsqsImgFileFileName)) {
            String ymsqsRathPath = FileUpload.createFile(UploadPath.SIGN_PATH, "admin", ymsqsImgFileFileName,
                    ymsqsImgFile);// 域名授权书图片路径
            businessUserData.setYmsqsRath(ymsqsRathPath);
        }
        String blImgPath = FileUpload.createFile(UploadPath.SIGN_PATH, "admin", blImgFileFileName, blImgFile);// 营业执照电子版路径
        businessUserData.setBlImg(blImgPath);
        businessUserData.setSysUserId(userId);
        businessUserFacade.addBusinessUserData(businessUserData);

    }

    /**
     * 前台用户查看订单详情
     * 
     * @return
     */
    public String findOrderView() {
        request.setAttribute("orderstate", orderstate);
        orderData = orderFacade.findOrderView(orderData.getId());// 为了防止和getAll的方法参数混乱，参数名要变更
        String path = ReadDomain.readProperties(); // 域名路径
        request.setAttribute("path", path);
        return "orderView";

    }

    /**
     * 根据服务id和pageid 查询出订单id，查出订单是否存在（page编辑页面 服务）
     * 
     * @author 侯杨
     * @date 2014-05-07
     * @param data
     * @return
     */
    public void getOrderState() {
        json = orderFacade.getOrderState(orderProductData);
    }

    /**
     * 
     * 保存订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月14日
     * @update
     * @return void
     * @throws UnsupportedEncodingException 
     * @exception/throws
     * @see OrderAction#ajaxAddOrderAtten()
     * @since
     */
    public void ajaxAddOrderAtten() throws UnsupportedEncodingException {
        // 获取用户id
        String userId = getFrmUser().etipUserID;
        String startId = attenInfoData.getId();
        attenInfoData.setUserId(userId);
        attenInfoData.setAttenName(Escape.unescape(attenInfoData.getAttenName()));
        String id = orderFacade.ajaxAddOrderAtten(attenInfoData);
        if (startId != null && startId.equals(id)) {
            json = "1";
        } else {
            json = id;
        }

    }

    /**
     * 
     * 根据删除订单联系人信息<br>
     * 
     * @author 文东 <br>
     *         2014年5月15日
     * @update
     * @param
     * @return void
     * @exception/throws
     * @see OrderAction#ajaxDelAttenInfo()
     * @since
     */
    public void ajaxDelAttenInfo() {
        // 获取订单联系人信息id
        String id = attenInfoData.getId();
        if (id != null && !"".equals(id)) {
            orderFacade.delAttenOnfo(id);
        }

    }

    /**
     * 
     * 〈调用发送邮件的方法〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-6-17
     * @update
     * @param [toAddress] [收件人地址] [contentMap] [邮件内容的给参数] [type] [邮件类型]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    private void sendMail(String toAddress, Map<String, String> contentMap, int type) {
        MailUtil mailutil = new MailUtil(toAddress, contentMap, type);
        mailutil.run();
    }

    /***********************************************************************************************************************************************************************************************************/

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public void setOrderFacade(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    public OrderProductFacade getOrderProductFacade() {
        return orderProductFacade;
    }

    public void setOrderProductFacade(OrderProductFacade orderProductFacade) {
        this.orderProductFacade = orderProductFacade;
    }

    public List<OrderData> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderData> orderList) {
        this.orderList = orderList;
    }

    public PageProductFacade getPageProductFacade() {
        return pageProductFacade;
    }

    public void setPageProductFacade(PageProductFacade pageProductFacade) {
        this.pageProductFacade = pageProductFacade;
    }

    public List<OrderProductData> getOrderProductDatas() {
        return orderProductDatas;
    }

    public void setOrderProductDatas(List<OrderProductData> orderProductDatas) {
        this.orderProductDatas = orderProductDatas;
    }

    public UserInfoData getUserInfoData() {
        return userInfoData;
    }

    public void setUserInfoData(UserInfoData userInfoData) {
        this.userInfoData = userInfoData;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }

    public OrderProductData getOrderProductData() {
        return orderProductData;
    }

    public void setOrderProductData(OrderProductData orderProductData) {
        this.orderProductData = orderProductData;
    }

    public List<ProductData> getProductDatas() {
        return productDatas;
    }

    public void setProductDatas(List<ProductData> productDatas) {
        this.productDatas = productDatas;
    }

    public File getBlImgFile() {
        return blImgFile;
    }

    public void setBlImgFile(File blImgFile) {
        this.blImgFile = blImgFile;
    }

    public String getBlImgFileFileName() {
        return blImgFileFileName;
    }

    public void setBlImgFileFileName(String blImgFileFileName) {
        this.blImgFileFileName = blImgFileFileName;
    }

    public String getBlImgFileContentType() {
        return blImgFileContentType;
    }

    public void setBlImgFileContentType(String blImgFileContentType) {
        this.blImgFileContentType = blImgFileContentType;
    }

    public File getYmsqsImgFile() {
        return ymsqsImgFile;
    }

    public void setYmsqsImgFile(File ymsqsImgFile) {
        this.ymsqsImgFile = ymsqsImgFile;
    }

    public String getYmsqsImgFileFileName() {
        return ymsqsImgFileFileName;
    }

    public void setYmsqsImgFileFileName(String ymsqsImgFileFileName) {
        this.ymsqsImgFileFileName = ymsqsImgFileFileName;
    }

    public String getYmsqsImgContentType() {
        return ymsqsImgContentType;
    }

    public void setYmsqsImgContentType(String ymsqsImgContentType) {
        this.ymsqsImgContentType = ymsqsImgContentType;
    }

    public BusinessUserData getBusinessUserData() {
        return businessUserData;
    }

    public void setBusinessUserData(BusinessUserData businessUserData) {
        this.businessUserData = businessUserData;
    }

    public TreeMap<Integer, String> getOrderproductstate() {
        return orderproductstate;
    }

    public void setOrderproductstate(TreeMap<Integer, String> orderproductstate) {
        this.orderproductstate = orderproductstate;
    }

    public TreeMap<Integer, String> getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(TreeMap<Integer, String> orderstate) {
        this.orderstate = orderstate;
    }

    public String[] getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String[] orderIds) {
        this.orderIds = orderIds;
    }

    public String getOrder_state_1() {
        return order_state_1;
    }

    public void setOrder_state_1(String order_state_1) {
        this.order_state_1 = order_state_1;
    }

    public String getOrder_state_2() {
        return order_state_2;
    }

    public void setOrder_state_2(String order_state_2) {
        this.order_state_2 = order_state_2;
    }

    public String getOrder_state_3() {
        return order_state_3;
    }

    public void setOrder_state_3(String order_state_3) {
        this.order_state_3 = order_state_3;
    }

    public AttenInfoData getAttenInfoData() {
        return attenInfoData;
    }

    public void setAttenInfoData(AttenInfoData attenInfoData) {
        this.attenInfoData = attenInfoData;
    }

    public List<AttenInfoData> getAttenInfoDatas() {
        return attenInfoDatas;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public TreeMap<Integer, String> getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(TreeMap<Integer, String> invoiceType) {
        InvoiceType = invoiceType;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll=pageRoll;
    }

}
