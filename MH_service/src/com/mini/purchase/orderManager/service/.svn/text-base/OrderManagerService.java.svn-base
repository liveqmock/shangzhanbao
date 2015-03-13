package com.mini.purchase.orderManager.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.business.IPageInfoExtraBusiness;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.pageManage.business.IPageManageBusiness;
import com.mini.purchase.commodityConfig.business.ICommodityConfigBusiness;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.customerInfo.business.ICustomerInfoBusiness;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.goods.business.IGoodsInfoBusiness;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.orderManager.business.IOrderGoodsinfoBusiness;
import com.mini.purchase.orderManager.business.IOrderManagerBusiness;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.mini.purchase.pagegoodsinfo.business.IPageGoodsInfoBusiness;
import com.sys.user.data.UserData;

/**
 * 
 * 消费者订单信息<br> 
 *
 * @author 冯鑫
 * @see OrderManagerService
 * @since vmaque1.5
 */
@Component("orderManagerService")
public class OrderManagerService extends FrmService implements IOrderManagerService {
    
    @Resource(name = "orderManagerBusiness")
    private IOrderManagerBusiness orderManagerBusiness;
    /**
     * 规格信息持久化层注入
     */
    @Resource(name="commodityConfigBusiness")
     private ICommodityConfigBusiness  commodityConfigBusiness;
    /**
     * 商品信息business层接口 容器注入
     */
    @Resource(name="goodsInfoBusiness")
    private IGoodsInfoBusiness goodsInfoBusiness;
    /**
     * page管理business
     */
    @Resource(name = "pageManageBusiness")
    private IPageManageBusiness pageManageBusiness;
    /**
     * 消费者信息Bussiness
     */
    @Resource(name = "customerInfoBusiness")
    private ICustomerInfoBusiness customerInfoBusiness;
    /**
     * page商品信息business层注入
     */
    @Resource(name="pageGoodsInfoBusiness")
     public IPageGoodsInfoBusiness pageGoodsInfoBusiness;
    /**
     * 域名管理business
     */
    @Resource(name="pageInfoExtraBusiness")
    private IPageInfoExtraBusiness pageInfoExtraBusiness;
    
    @Resource(name="orderGoodsinfoBusiness")
    private IOrderGoodsinfoBusiness orderGoodsinfoBusiness;
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     * @return List<ConSumerOrderData> 符合查询条件商品订单信息集合
     * @since vmaque 1.5
     */
    public List<ConSumerOrderData> getConSumerOrderDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        pageRoll = PageRoll.set(10, pageRoll);
        return orderManagerBusiness.getConSumerOrderDataList(pageRoll, conSumerOrderData);
    }
    /**
     * 
     * 创建订单和订单商品关联信息<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-11
     * @update 
     * @param commodityConfigData conSumerUserData goodsNum 用户选择购买数量
     * @return  Boolean
     * @exception/throws 
     * @see   OrderManagerService#createOrder
     * @since vmaque1.5
     */
    public ConSumerOrderData createOrder(CommodityConfigData commodityConfigData, ConSumerUserData conSumerUserData,String pageDomainName,String goodsNum){
        //用户所购买的商品信息对象
        GoodsInfoData goodsInfoData = goodsInfoBusiness.getGoodsInfoData(commodityConfigData.getGoodsInfoData());
        //用户所购买商品所对应的pageid
        PageInfoExtraData pageInfoExtraData =pageInfoExtraBusiness.getPageInfoExtraData(JSONObject.fromObject("{ \"domain\":\"" + pageDomainName + "\"}")).get(0);
        //所创建订单对象
        ConSumerOrderData conSumerOrderData = new ConSumerOrderData();
           //为订单微信账号唯一id赋值
         if(conSumerUserData.getWeixinOpenId()!=null && !"".equals(conSumerUserData.getWeixinOpenId())){
             conSumerOrderData.setWeixinOpenId(conSumerUserData.getWeixinOpenId());
         }
         if(conSumerUserData.getPayType()!=null && !"".equals(conSumerUserData.getPayType())){
             //订单支付类型
             conSumerOrderData.setPayType(conSumerUserData.getPayType());
         }
        //订单价格为商品规格价格
        conSumerOrderData.setPrice(commodityConfigData.getConfigPrice());
        //订单设置为未付款
        conSumerOrderData.setState(0);
        //订单编号
        conSumerOrderData.setOrderCode(String.valueOf(new Date().getTime()));
        //订单创建时间
        conSumerOrderData.setCreateTime(new Date());
        //订单支付时间  未设置
        conSumerOrderData.setPayTime(null);
        //订单交易结束时间  未设置
        conSumerOrderData.setOverTime(null);
        //消费者信息id
        conSumerOrderData.setConSumerUserId(conSumerUserData.getId());
        conSumerOrderData.setIsDelete(1);
        conSumerOrderData.setPageId(pageInfoExtraData.getPageId());
        //生成订单
        orderManagerBusiness.addOrder(conSumerOrderData);
        //订单商品关联信息对象
        ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = new ConsumerOrderGoodsinfoData();
        //设置订单id
        consumerOrderGoodsinfoData.setConsumerOrderId(conSumerOrderData.getId());
        consumerOrderGoodsinfoData.setGoodsNum(1);
        //设置规格id
        consumerOrderGoodsinfoData.setCommodityConfigId(commodityConfigData.getId());
        //设置商品id
        consumerOrderGoodsinfoData.setGoodsInfId(goodsInfoData.getId());
        consumerOrderGoodsinfoData.setIsdelete(1);
        consumerOrderGoodsinfoData.setGoodsNum(Integer.parseInt(goodsNum));
        //保存订单商品关联信息对象
        orderManagerBusiness.addOrderGoodsinfo(consumerOrderGoodsinfoData);
        return conSumerOrderData;
    }
    
    /**
     * 
     * 修改订单信息
     * 
     * @author 左香勇 <br> 
     *         2014-9-12
     * @update 
     * @param [conSumerOrderData]     [修改的订单实体对象]
     * @since vmaque 1.5
     */
    public void updateConsumerOrder(ConSumerOrderData conSumerOrderData){
        
        ConSumerOrderData data = orderManagerBusiness.getConSumerOrderDataById(conSumerOrderData.getId());
        if(conSumerOrderData.getLogisticsCompany()!=null && !"".equals(conSumerOrderData.getLogisticsCompany())){
            data.setLogisticsCompany(conSumerOrderData.getLogisticsCompany());
        }
        if(conSumerOrderData.getLogisticsNumber()!=null && !"".equals(conSumerOrderData.getLogisticsNumber())){
            data.setLogisticsNumber(conSumerOrderData.getLogisticsNumber());
        }
        if(conSumerOrderData.getTransferPeople()!=null && !"".equals(conSumerOrderData.getTransferPeople())){
            data.setTransferPeople(conSumerOrderData.getTransferPeople());
        }
        if(conSumerOrderData.getTransferTime()!=null){
            data.setTransferTime(conSumerOrderData.getTransferTime());
        }
        if(conSumerOrderData.getTransferPrice()!=null){
            data.setTransferPrice(data.getPrice()*(1-conSumerOrderData.getTransferPrice()/100));
        }
        if(conSumerOrderData.getDeliverTime()!=null || data.getDeliverTime() ==null){
            data.setDeliverTime(new Date());
        }
        data.setState(conSumerOrderData.getState());
        
        orderManagerBusiness.updateConsumerOrder(data);
    }
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        pageRoll = PageRoll.set(10, pageRoll);
        return orderManagerBusiness.getConSumerOrderGoodsInfoDataList(pageRoll, conSumerOrderData);
    }
    
    /**
     * 
     * 根据订单商品信息中间表Id查询的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-15
     * @update 
     * 
     * @param consumerOrderGoodsinfoDataId  订单商品信息中间表id
     *        
     * @return ConsumerOrderGoodsinfoData 订单商品信息中间实体
     * 
     * @since vmaque 1.5
     * 
     */
    public ConsumerOrderGoodsinfoData getConSumerOrderGoodsInfoDataById(String consumerOrderGoodsinfoDataId){
        return orderManagerBusiness.getConSumerOrderGoodsInfoDataById(consumerOrderGoodsinfoDataId);
    }
    
    /**
     * 
     * 根据pageid订单状态统计订单数量
     * 
     * @author 左香勇 
     *         2014-9-12
     * @update 
     * @param [pageId]     [pageid]
     *        [state]   [订单状态]
     * @return  int 订单数量
     * @since vmaque 1.5
     */
    public int serachOrderNum(String pageId,int state){
        return orderManagerBusiness.serachOrderNum(pageId,state);
    }
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-13
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        userData 用户信息
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataListBack(PageRoll pageRoll,ConSumerOrderData conSumerOrderData,UserData userData){
        pageRoll = PageRoll.set(10, pageRoll);
        return orderManagerBusiness.getConSumerOrderGoodsInfoDataListBack(pageRoll, conSumerOrderData, userData);
    }

    /**
     * 
     * 支付成功 修改订单状态 且返回订单所对象的page<br>
     * 
     * @author 冯鑫<br> 
     *		   2014-9-13
     * @update 
     * @param conSumerOrderData
     * @return  PageInfoExtraData
     * @exception/throws 
     * @see   OrderManagerService#paySuccessWithOrderChangeState
     * @since vmaque1.5
     */
    public PageInfoExtraData paySuccessWithOrderChangeState(ConSumerOrderData conSumerOrderData){
        Integer state=conSumerOrderData.getState();
        conSumerOrderData = orderManagerBusiness.findConSumerOrderDatabyCode(conSumerOrderData);
        //设置订单为已经付款
        conSumerOrderData.setState(state);
        conSumerOrderData.setPayTime(new Date());
        orderManagerBusiness.updateConsumerOrder(conSumerOrderData);
        //返回客户购买的page域名对象
        PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
        pageInfoExtraData.setPageId(conSumerOrderData.getPageId());
        return  pageInfoExtraBusiness.searchByPageInfoExtraData(pageInfoExtraData);
    }
    
    /**
     * 
     * 根据处理状态查询计费信息
     * 
     * @author 左香勇 
     *         2014-9-25
     * @update 
     * 
     * @param state     处理状态
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 计费信息
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getAccountList(PageRoll pageRoll,Integer state){
        pageRoll = PageRoll.set(10, pageRoll);
        return orderManagerBusiness.getAccountList(pageRoll, state);
    }
    
    /**
     * 
     * 计算订单总金额
     * 
     * @author 左香勇 <br> 
     *         2014-9-25
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @return  double 订单总金额
     * @since vmaque2.0
     */
    public double getSumAccount(){
        return orderManagerBusiness.getSumAccount();
    }
    
    /**
     * 
     * 微信接口查询商品订单数据信息（只提供给微信使用）
     * 
     * @author 左香勇
     *         2014年12月8日
     * @update 
     * @param state    订单状态
     *        pageRoll 分页查询对象
     *        
     * @return  String 符合查询条件商品订单信息json字符串
     * @see   OrderManagerService#queryGoodsOrder(PageRoll, int, String)
     * @since vmaque2.0
     */
    public String queryGoodsOrder(PageRoll pageRoll, int state, String openId){
        return orderManagerBusiness.queryGoodsOrder(pageRoll, state, openId);
    }
    /**
     * 
     *手机端，订单支付<br>
     * 
     * @author hy <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  data
     * @see   OrderManagerService#payConSumerOrderDataSuccessWeixin(ConSumerOrderData)
     * @since vmaque2.0
     */
    @Override
    public ConSumerOrderData payConSumerOrderDataSuccessWeixin(ConSumerOrderData data){
        ConSumerOrderData conSumerOrderData=orderManagerBusiness.findConSumerOrderDatabyCode(data);
        if(conSumerOrderData!=null && !"".equals(conSumerOrderData)){
            conSumerOrderData.setState(1); //已付款
            conSumerOrderData.setPayTime(new Date());
            orderManagerBusiness.updateConsumerOrder(conSumerOrderData);
        }
        return conSumerOrderData;
    }
    /**
     * 
     *手机端，订单取消<br>
     * 
     * @author hy <br> 
     *         2014年12月8日
     * @update 
     * @param ConSumerOrderData 消费者订单
     * @return  string
     * @see   OrderManagerService#closedConSumerOrderDataWeixin(ConSumerOrderData)
     * @since vmaque2.0
     */
    @Override
    public String closedConSumerOrderDataWeixin(ConSumerOrderData data){
        String msg="success";
        ConSumerOrderData conSumerOrderData=orderManagerBusiness.findConSumerOrderDatabyCode(data);
        if(conSumerOrderData!=null && !"".equals(conSumerOrderData)){
            conSumerOrderData.setState(4); //已关闭
            orderManagerBusiness.updateConsumerOrder(conSumerOrderData);
            msg="success";
        }else{
            msg="error";
        }
        return msg;  
    }
    /**
     * 
     * 根据订单查询出商品订单信息<br>
     * 
     * @author 侯杨<br> 
     *            2014年12月8日
     * @update 
     * @param conSumerOrderData
     * @return  ConsumerOrderGoodsinfoData
     * @see   IOrderManagerService#findConSumerOrderGoodsInfoByOrderId
     * @since vmaque2.0
     */
    @Override
    public ConsumerOrderGoodsinfoData findConSumerOrderGoodsInfoByOrderId(ConSumerOrderData conSumerOrderData){
        //根据订单编号 查询订单信息
        ConSumerOrderData data=orderManagerBusiness.findConSumerOrderDatabyCode(conSumerOrderData);
        //根据订单id 查询订单和商品中间表信息
        ConsumerOrderGoodsinfoData  data1=  orderManagerBusiness.findConSumerOrderGoodsInfoByOrderId(data);
        data1.setConSumerOrderData(data);
        return data1;
        
    }
    
    /**
     * 
     * 根据订单id查询订单信息
     * 
     * @author 左香勇 <br> 
     *         2014年12月10日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   OrderManagerService#queryConSumerOrderDataById(String)
     * @since vmaque2.0
     */
    public ConSumerOrderData queryConSumerOrderDataById(String id){
        return orderManagerBusiness.queryConSumerOrderDataById(id);
    }
    
    /**
     * 
     * 根据订单id删除订单信息
     * 
     * @author 左香勇 <br> 
     *         2015年1月22日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   OrderManagerService#deleteGoodsOrder(String)
     * @since vmaque2.0
     */
    public void deleteGoodsOrder(String orderid) throws Exception{
        //删除订单表
        ConSumerOrderData data = orderManagerBusiness.queryConSumerOrderDataById(orderid);
        data.setIsDelete(0);
        orderManagerBusiness.updateConsumerOrder(data);
        
        //删除订单中间表
        ConsumerOrderGoodsinfoData goodsData = orderGoodsinfoBusiness.queryConsumerOrderGoodsinfoDataByOrderid(orderid);
        
        goodsData.setIsdelete(0);
        
        orderGoodsinfoBusiness.updateConsumerOrderGoodsinfoData(goodsData);
        
    }
}
