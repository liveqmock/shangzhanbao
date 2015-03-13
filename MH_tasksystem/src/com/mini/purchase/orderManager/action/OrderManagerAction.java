package com.mini.purchase.orderManager.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.account.data.AccountNumberData;
import com.mini.back.orderManage.action.OrderManageAction;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.front.account.facade.AccountNumberFacade;
import com.mini.front.domain.facade.PageInfoExtraFacade;
import com.mini.front.pageManage.facade.PageManageFacade;
import com.mini.page.data.PageData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.facade.GoodsInfoFacade;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.orderManager.facade.OrderManagerFacade;
import com.mini.util.AlipayConfig;
import com.mini.util.AlipayService;
import com.sys.user.data.UserData;
import com.util.ReadDomain;

/**
 * 
 * 消费者订单信息<br>
 * 
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@ResultPath("/")
@Results({

        @Result(name = "toconSumerOrderManager", location = "/view/pages/mini/front/purchase/orderManager/orderManager.jsp"),
        @Result(name = "toPayJsp", location = "/view/pages/mini/front/purchase/toPayGoods.jsp"),
        @Result(name = "tobackOrderManager", location = "/view/pages/mini/back/purchase/orderManager/backorderManager.jsp"),
        @Result(name = "tobackOrderManagerInfo", location = "/view/pages/mini/back/purchase/orderManager/oderManagerInfo.jsp"),
        @Result(name = "closedOrder", location = "/view/pages/mini/front/purchase/orderManager/closedOrder.jsp"),
        @Result(name = "payForSuccess_order", location = "/view/pages/mini/front/purchase/payForSuccess_order.jsp") }
        )
public class OrderManagerAction extends FrmAction {

    @Resource(name = "orderManagerFacade")
    private OrderManagerFacade orderManagerFacade;

    @Resource(name = "pageManageFacade")
    private PageManageFacade pageManageFacade;

    @Resource(name = "pageInfoExtraFacade")
    private PageInfoExtraFacade pageInfoExtraFacade;

    /**
     * 商品信息Facade
     */
    @Resource(name = "goodsInfoFacade")
    private GoodsInfoFacade goodsInfoFacade;
    @Resource(name="accountNumberFacade")
    private AccountNumberFacade accountNumberFacade;
    private ConSumerOrderData conSumerOrderData = new ConSumerOrderData();
    List<AccountNumberData> accountNumberDatas=new ArrayList<AccountNumberData>();  //支付类型集合
    /**
     * 商品规格实体对象
     */
    private CommodityConfigData commodityConfigData = new CommodityConfigData();
    /**
     * 消费者信息对象
     */
    private ConSumerUserData conSumerUserData = new ConSumerUserData();

    private List<ConSumerOrderData> list_conSumerOrder = new ArrayList<ConSumerOrderData>();

    private PageRoll pageRoll = new PageRoll();
    /**
     * 用户所点击购买页面的域名
     */
    private String pageDomainName;
    /**
     * 用户页面所选择购买数量
     */
    private String goodsNum;
    /**
     * 判断是手机端支付还是pc端支付
     */
    private String pcFlag;

    private Map<String, String> orderMap = new HashMap<String, String>();

    /**
     * 
     * 生成订单，跳转到支付宝支付页面<br>
     * 
     * @author 冯鑫<br>
     *         2014-9-12
     * @throws IOException
     * @update 侯杨
     * @see OrderManagerAction#toPayOrder
     * @since vmaque1.5
     */
    public String toPayOrder() throws IOException {
        String price=request.getParameter("price");
        String paytype=request.getParameter("paytype"); //支付方式
        //商品总价赋值
        conSumerUserData.setPayType(Integer.parseInt(paytype));
        commodityConfigData.setConfigPrice(Double.parseDouble(price));
        conSumerOrderData = orderManagerFacade.createOrder(commodityConfigData, conSumerUserData, pageDomainName,
                goodsNum);
        GoodsInfoData goodsInfoData = new GoodsInfoData();
        goodsInfoData.setId(commodityConfigData.getGoodsInfoData().getId());
        goodsInfoData = goodsInfoFacade.getGoodsInfoData(goodsInfoData);
        String alipayForm;
       
        conSumerOrderData.setPrice(Double.parseDouble(price));
        if(price.equals("0")){
            request.setAttribute("ordercode", conSumerOrderData.getOrderCode());
            if(conSumerUserData.getRedPackageId()!=null && !"".equals(conSumerUserData.getRedPackageId())){
                request.setAttribute("redpackageId", conSumerUserData.getRedPackageId());
                request.setAttribute("cId", conSumerUserData.getcId());
                request.setAttribute("sId", conSumerUserData.getsId());
            }
            return "payForSuccess_order";
        }
        // 如果为1 则是pc支付
        if ("1".equals(pcFlag)) {
            alipayForm = this.getAlipayForm(conSumerOrderData, goodsInfoData);// 支付的表单getAlipayForm_Phone
        } else {
            alipayForm = this.getAlipayForm_Phone(conSumerOrderData, goodsInfoData);
        }
        request.setAttribute("alipayForm", alipayForm);
        return "toPayJsp";
    }

    /**
     * 
     * 创建支付宝提交Form PC端<br>
     * 
     * @author 冯鑫<br>
     *         2014-9-12
     * @update
     * @param ConSumerOrderData conSumerOrderData
     * @return String
     * @see OrderManagerAction#getAlipayForm
     * @since vmaque1.5
     */
    private String getAlipayForm(ConSumerOrderData conSumerOrderData, GoodsInfoData goodsInfoData) {
        HashMap<String, String> hm = new HashMap<String, String>();
        if(goodsInfoData.getGoodsDes()!=null && !"".equals(goodsInfoData.getGoodsDes())){
            hm.put("body", goodsInfoData.getGoodsDes().trim());// 填写在跳到支付宝页面上显示的付款内容信息
        }
        hm.put("subject", goodsInfoData.getGoodsName());// 填写在跳到支付宝页面上显示的付款标题信息  
        hm.put("out_trade_no", conSumerOrderData.getOrderCode());// 外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用. 
        hm.put("agent", AlipayConfig.partner);// partnerId(合作伙伴ID)
        hm.put("payment_type", "1");// 支付类型 1=商品购买,2=服务购买,... 
        hm.put("price", String.valueOf(conSumerOrderData.getPrice()));// 订单金额信息    
       /*hm.put("price","0.01");//订单金额信息  */
        hm.put("quantity", "1");// 订单商品数量,一般都是写1,它是按照整个订单包来计算 
        hm.put("extra_common_param",conSumerUserData.getRedPackageId()+"_"+conSumerUserData.getcId()+"_"+conSumerUserData.getsId());// 红包使用自定义参数
        return AlipayService.create_direct_pay_by_user(hm);// securityCode(安全码)
    }

    /**
     * 
     * 支付宝提交Form 手机端<br>
     * 
     * @author 冯鑫<br>
     *         2014-9-21
     * @update
     * @param
     * @return
     * @exception/throws
     * @see OrderManagerAction#getAlipayForm
     * @since vmaque1.5
     */
    private String getAlipayForm_Phone(ConSumerOrderData conSumerOrderData, GoodsInfoData goodsInfoData) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("body", goodsInfoData.getGoodsDes());// 填写在跳到支付宝页面上显示的付款内容信息  
        hm.put("subject", goodsInfoData.getGoodsName());// 填写在跳到支付宝页面上显示的付款标题信息  
        hm.put("out_trade_no", conSumerOrderData.getOrderCode());// 外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用. 
        hm.put("agent", AlipayConfig.partner);// partnerId(合作伙伴ID)
        hm.put("payment_type", "1");// 支付类型 1=商品购买,2=服务购买,... 
        hm.put("price", String.valueOf(conSumerOrderData.getPrice()));// 订单金额信息   
       /* hm.put("price","0.01");//订单金额信息    */
        hm.put("quantity", "1");// 订单商品数量,一般都是写1,它是按照整个订单包来计算 
        hm.put("extra_common_param",conSumerUserData.getRedPackageId()+"_"+conSumerUserData.getcId()+"_"+conSumerUserData.getsId());// 红包使用自定义参数
        return AlipayService.create_direct_token_by_user(hm);// securityCode(安全码)
    }

    /**
     * 
     * 支付成功 修改订单状态 且返回订单所对象的page<br>
     * 
     * @author 冯鑫<br>
     *         2014-9-13
     * @update
     * @param
     * @return
     * @exception/throws
     * @see OrderManagerAction#paySuccessWithOrderChangeState
     * @since vmaque2.0
     */
    public void paySuccessWithOrderChangeState() {
        String fileName = "domain.properties";
        String path = ResouceUtil.getProperty(fileName, "path");// 读取红包系统的路径
        PageInfoExtraData pageInfoExtraData = orderManagerFacade.paySuccessWithOrderChangeState(conSumerOrderData);
        json = path + pageInfoExtraData.getDomain();
    }

    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 2014-9-9
     * @update
     * 
     * @return String 返回跳转到指定页面的字符串
     * 
     * @since vmaque 1.5
     */
    public String toconSumerOrderManager() {

        String pageId = request.getParameter("pageid");// pageid
        String state = request.getParameter("state");

        PageData pageData = new PageData();
        pageData.setId(pageId);

        PageData paData = pageManageFacade.findPageDataById(pageData);

        PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();

        pageInfoExtraData.setPageId(pageId);

        PageInfoExtraData piData = pageInfoExtraFacade.searchByPageId(pageInfoExtraData);

        conSumerOrderData.setPageId(pageId);
        if (state != null && !"".equals(state)) {
            conSumerOrderData.setState(Integer.parseInt(state));
        }

        // 查询订单分页信息
        List<ConsumerOrderGoodsinfoData> list = orderManagerFacade.getConSumerOrderGoodsInfoDataList(pageRoll,
                conSumerOrderData);

        // 查询各订单统计信息,并存储到map中
        Map<String, Integer> orderNumMap = new HashMap<String, Integer>();

        orderNumMap.put("type0", orderManagerFacade.serachOrderNum(pageId, 0));
        orderNumMap.put("type1", orderManagerFacade.serachOrderNum(pageId, 1));
        orderNumMap.put("type2", orderManagerFacade.serachOrderNum(pageId, 2));
        // 把查询到的订单传到前台
        request.setAttribute("orderNumMap", orderNumMap);
        // 把查询的分页订单集合传到前台
        request.setAttribute("listOrderManager", list);
        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        // 把page访问路径传到前台
        if(piData!=null && !"".equals(piData)){
            if( piData.getDomain()!=null && !"".equals( piData.getDomain())){
                this.request.setAttribute("pageUrl", piData.getDomain());
            }
        }
        // 把page名称传到前台
        if(paData.getName()!=null && !"".equals(paData.getName())){
            this.request.setAttribute("pageName", paData.getName());
        }
        // 把pageid传到前台
        request.setAttribute("pageid", pageId);
        // 把当前订单状态传到前台
        request.setAttribute("state", state);

        return "toconSumerOrderManager";
    }

    /**
     * 
     * 跳转到后台微站订单统计管理
     * 
     * @author 左香勇 <br>
     *         2014-9-13
     * @update
     * @return String 返回跳转到指定页面的字符串
     * @since vmaque 1.5
     */
    public String tobackOrderManager() {

        UserData userData = new UserData();

        String loginAccount = request.getParameter("loginAccount");
        String state = request.getParameter("state");// 订单状态

        if (loginAccount != null && !loginAccount.equals("")) {
            userData.setLoginMail(loginAccount);
            userData.setLoginMoble(loginAccount);
        }
        if (state != null && !"".equals(state)) {
            conSumerOrderData.setState(Integer.parseInt(state));
        }

        List<ConsumerOrderGoodsinfoData> listOrder = orderManagerFacade.getConSumerOrderGoodsInfoDataListBack(pageRoll,
                conSumerOrderData, userData);

        request.setAttribute("listOrder", listOrder);

        request.setAttribute("conSumerOrderData", conSumerOrderData);

        request.setAttribute("userData", userData);

        request.setAttribute("state", state);

        return "tobackOrderManager";

    }

    /**
     * 
     * 跳转到后台用户订单显示详情页面，并准备所需数据
     * 
     * @author 左香勇 <br>
     *         2014-9-15
     * @update
     * 
     * @return String 返回跳转到指定页面的字符串
     * 
     * @since vmaque 1.5
     */
    public String tobackOrderManagerInfo() {

        String id = request.getParameter("id");

        ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = orderManagerFacade
                .getConSumerOrderGoodsInfoDataById(id);

        String path = ReadDomain.readProperties();
        request.setAttribute("path", path);
        request.setAttribute("cogData", consumerOrderGoodsinfoData);

        return "tobackOrderManagerInfo";
    }

    /**
     * 
     * 确定发货流程
     * 
     * @author 左香勇 <br>
     *         2014-9-12
     * @update
     * @since vmaque 1.5
     */
    public void updateConsumerOrder() {
        conSumerOrderData.setState(2);// 已发货

        conSumerOrderData.setLogisticsCompany(URLDecoder.decode(conSumerOrderData.getLogisticsCompany()));
        orderManagerFacade.updateConsumerOrder(conSumerOrderData);
    }

    /**
     * 
     * 根据微信ip查询消费者的地址 电话 名字等信息<br>
     * 
     * @author 侯杨 <br>
     *         2014年11月24日
     * @update
     * @throws IOException
     * @see OrderManagerAction#payfor_orderGood()
     * @since vmaque2.0
     */
    public void payfor_orderGood() throws IOException {
        // 声明消费者集合
        List<ConSumerUserData> conSumerUserDatas = new ArrayList<ConSumerUserData>();
        conSumerUserDatas = orderManagerFacade.getConSumerUserDatasByOpenId(conSumerUserData);
        if (conSumerUserDatas.size() > 0) {
            JSONArray data = JSONArray.fromObject(conSumerUserDatas);
            response.getWriter().print(data);
        } else {
            response.getWriter().print("1");
        }
    }

    /**
     * 
     * 支付宝提交 微信接口<br>
     * 
     * @author 侯杨<br>
     *         2014-9-21
     * @update
     * @param
     * @return
     * @exception/throws
     * @see OrderManagerAction#getAlipayForm
     * @since vmaque1.5
     */
    private String getAlipayForm_PhoneWeixin(ConSumerOrderData conSumerOrderData, GoodsInfoData goodsInfoData) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("body", goodsInfoData.getGoodsDes());// 填写在跳到支付宝页面上显示的付款内容信息  
        hm.put("subject", goodsInfoData.getGoodsName());// 填写在跳到支付宝页面上显示的付款标题信息  
        hm.put("out_trade_no", conSumerOrderData.getOrderCode());// 外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用. 
        hm.put("agent", AlipayConfig.partner);// partnerId(合作伙伴ID)
        hm.put("payment_type", "1");// 支付类型 1=商品购买,2=服务购买,... 
        hm.put("price", String.valueOf(conSumerOrderData.getPrice()));// 订单金额信息   
        hm.put("quantity", "1");// 订单商品数量,一般都是写1,它是按照整个订单包来计算 
        return AlipayService.create_direct_token_by_userWeixin(hm);// securityCode(安全码)
    }

    /**
     * 
     * 对订单进行付款或者取消订单操作<br>
     * 
     * @author 侯杨 <br>
     *         2014年12月08日
     * @update
     * @throws IOException
     * @see OrderManagerAction#payOrclosed_weixin()
     * @since vmaque2.0
     */
    public String payOrclosed_weixin() throws IOException {
        // 操作码 1为付款 2 为取消订单
        String alipayForm;
        String op = request.getParameter("op");
        // 微信id
        String openid = request.getParameter("openid");
        // 订单编号
        String code = request.getParameter("code");
        String callback = request.getParameter("jsoncallback");
        if(op==null || "".equals(op) || code == null || "".equals(code)){
           String returnJsonStr = callback+"({\"SUCCESS\": false, \"MESSAGE\": \"获取数据失败\"})";
           request.setAttribute("result", returnJsonStr);
           return "closedOrder";
        }
        conSumerOrderData.setOrderCode(code);
        if (op.equals("1")) {
            ConsumerOrderGoodsinfoData orderGoodsinfoData = orderManagerFacade.findConSumerOrderGoodsInfoByOrderId(conSumerOrderData);
            GoodsInfoData goodsInfoData = new GoodsInfoData();
            goodsInfoData.setId(orderGoodsinfoData.getGoodsInfId());
            // 查询商品信息
            GoodsInfoData infoData = goodsInfoFacade.getGoodsInfoData(goodsInfoData);
            conSumerOrderData.setPrice(orderGoodsinfoData.getConSumerOrderData().getPrice());
            alipayForm = this.getAlipayForm_PhoneWeixin(conSumerOrderData, infoData);
        } else {
            // 取消订单
            alipayForm = orderManagerFacade.closedConSumerOrderDataWeixin(conSumerOrderData);
        }
        if ("success".equals(alipayForm)) {
            String returnJsonStr = callback+"({\"SUCCESS\": true})";
            request.setAttribute("result", returnJsonStr);
            return "closedOrder";
        } else if ("erro".equals(alipayForm)) {
            String returnJsonStr = callback+"({\"SUCCESS\": false})";
            request.setAttribute("result", returnJsonStr);
            return "closedOrder";
        } else {
            request.setAttribute("alipayForm", alipayForm);
            return "toPayJsp";
        }
    }

    /**
     * 
     * 付款成功<br>
     * 
     * @author 侯杨 <br>
     *         2014年12月08日
     * @update
     * @throws IOException
     * @see OrderManagerAction#paySuccess_weixin()
     * @since vmaque2.0
     */
    public void paySuccess_weixin() {
        orderManagerFacade.payConSumerOrderDataSuccessWeixin(conSumerOrderData);
    }

    /**
     * 
     *根据用户id查询此用户的支付方式<br>
     * 
     * @author 侯杨 <br> 
     *          2015年1月8日
     * @update 
     * @return  void
     * @throws IOException 
     * @see   OrderManageAction#selectaccountNumber()
     * @since vmaque2.0
     */
    public void selectaccountNumber() throws IOException{
        String userId=request.getParameter("userId");
        accountNumberDatas=accountNumberFacade.queryAccountNumberDataByuserId(userId);
        if(accountNumberDatas.size()>0){
            JSONArray data = JSONArray.fromObject(accountNumberDatas);
                response.getWriter().print(data);
        }else{
            response.getWriter().print("1");
        }
    }
    
    /**
     * 
     * 生成订单，跳转到微信支付<br>
     * 
     * @author 侯杨<br>
     *         2015-01-13
     * @throws IOException
     * @update 
     * @see OrderManagerAction#toweixinPayOrder
     * @since vmaque2.0
     */
    public void toweixinPayOrder() throws IOException {
        String price=request.getParameter("price");
        String paytype=request.getParameter("paytype"); //支付方式
        //商品总价赋值
        conSumerUserData.setPayType(Integer.parseInt(paytype));
        commodityConfigData.setConfigPrice(Double.parseDouble(price));
        conSumerOrderData = orderManagerFacade.createOrder(commodityConfigData, conSumerUserData, pageDomainName,
                goodsNum);
        GoodsInfoData goodsInfoData = new GoodsInfoData();
        goodsInfoData.setId(commodityConfigData.getGoodsInfoData().getId());
        goodsInfoData = goodsInfoFacade.getGoodsInfoData(goodsInfoData);
       
        conSumerOrderData.setPrice(Double.parseDouble(price));
        conSumerOrderData.setGoodsName(goodsInfoData.getGoodsName());
        if(conSumerOrderData!=null){
            conSumerOrderData.setConSumerUserData(conSumerUserData);
            JSONObject object = JSONObject.fromObject(conSumerOrderData);
                response.getWriter().print(object);
        }else{
            response.getWriter().print("1");
        }
    }
    
    /**
     * 
     *微信支付 价格为0时 支付跳转页面<br>
     * 
     * @author 侯杨 <br> 
     *		   2015年1月15日
     * @return  string
     * @exception/throws [异常类型] [异常说明]
     * @see   OrderManagerAction#topayForSuccess_order()
     * @since vmaque2.0
     */
    public String topayForSuccess_order(){
        request.setAttribute("redpackageId", request.getParameter("redPackageId"));
        request.setAttribute("cId", request.getParameter("cId"));
        request.setAttribute("sId", request.getParameter("sId"));
        request.setAttribute("ordercode", conSumerOrderData.getOrderCode());
        return "payForSuccess_order";
    }
    
    public ConSumerOrderData getConSumerOrderData() {
        return conSumerOrderData;
    }

    public void setConSumerOrderData(ConSumerOrderData conSumerOrderData) {
        this.conSumerOrderData = conSumerOrderData;
    }

    public ConSumerUserData getConSumerUserData() {
        return conSumerUserData;
    }

    public void setConSumerUserData(ConSumerUserData conSumerUserData) {
        this.conSumerUserData = conSumerUserData;
    }

    public CommodityConfigData getCommodityConfigData() {
        return commodityConfigData;
    }

    public void setCommodityConfigData(CommodityConfigData commodityConfigData) {
        this.commodityConfigData = commodityConfigData;
    }

    public List<ConSumerOrderData> getList_conSumerOrder() {
        return list_conSumerOrder;
    }

    public void setList_conSumerOrder(List<ConSumerOrderData> list_conSumerOrder) {
        this.list_conSumerOrder = list_conSumerOrder;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public String getPageDomainName() {
        return pageDomainName;
    }

    public void setPageDomainName(String pageDomainName) {
        this.pageDomainName = pageDomainName;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getPcFlag() {
        return pcFlag;
    }

    public void setPcFlag(String pcFlag) {
        this.pcFlag = pcFlag;
    }

    public Map<String, String> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, String> orderMap) {
        this.orderMap = orderMap;
    }

}
