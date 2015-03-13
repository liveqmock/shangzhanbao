package com.mini.order.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.BusinessUserData.data.BusinessUserData;
import com.mini.BusinessUserData.persistence.IBusinessUserPersistence;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.give.data.UserInfoData;
import com.mini.give.persistence.IUserInfoDataPersistence;
import com.mini.order.data.AttenInfoData;
import com.mini.order.data.InvoiceData;
import com.mini.order.data.OrderData;
import com.mini.order.data.OrderProductData;
import com.mini.order.persistence.IAttenInfoPersistence;
import com.mini.order.persistence.IInvoicePersistence;
import com.mini.order.persistence.IOrderPersistence;
import com.mini.order.persistence.IOrderProductPersistence;
import com.mini.page.data.PageData;
import com.mini.page.persistence.IPagePersistence;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.product.persistence.IPageProductPersistence;
import com.mini.product.persistence.IProductPersistence;

/**
 * 订单管理业务接口实现类
 * 
 * @author 林海鹏
 * @see OrderBusiness
 * @since
 */
@Component("orderBusiness")
public class OrderBusiness extends FrmBusiness implements IOrderBusiness {
    @Resource(name = "orderPersistence")
    private IOrderPersistence orderPersistence;
    @Resource(name = "businessUserPersistence")
    private IBusinessUserPersistence businessUserPersistence;

    @Resource(name = "pageProductPersistence")
    private IPageProductPersistence pageProductPersistence;
    @Resource(name = "productPersistence")
    private IProductPersistence productPersistence;
    @Resource(name = "userInfoDataPersistence")
    private IUserInfoDataPersistence userInfoDataPersistence;
    @Resource(name = "orderProductPersistence")
    private IOrderProductPersistence orderProductPersistence;
    @Resource(name = "invoicePersistence")
    private IInvoicePersistence invoicePersistence;
    @Resource(name = "atteninfoPersistence")
    private IAttenInfoPersistence atteninfoPersistence;
    @Resource(name = "pagePersistence")
    private IPagePersistence pagePersistence;
    @Resource(name = "pageInfoExtraPersistence")
    private IPageInfoExtraPersistence pageInfoExtraPersistence;
    /**
     * 生成订单，如果发票不为空 则添加发票
     */
    @Override
    public void addOrder(OrderData orderData) {
        if(orderData.getInvoiceData()!=null){//判断发票信息是否为空
        	InvoiceData data = orderData.getInvoiceData();
        	data.setCreateTime(new Date());
        	data.setInvoiceContent(0);//服务费：0
        	data.setCreateTime(new Date()); //创建时间
        	data.setUserId(orderData.getSysUserId());  //用户id
        	invoicePersistence.add(data);//添加发票数据到数据库
        	orderData.setInvoiceId(data.getId());//把发票信息的主键添加到订单表里面
        }
        orderPersistence.add(orderData);
    }

    @Override
    public void deleteOrder(String[] ids) {
        orderPersistence.deleteOrder(ids);
    }

    @Override
    public void editOrder(OrderData OrderData) {
        orderPersistence.editOrder(OrderData);
    }

    /****
     * 运营人员后台根据查询条件和状态分页查询所有的订单
     * @author dlm
     */
    @Override
    public List<OrderData> getAllOrderData(PageRoll pageRoll, OrderData orderData) {
    	
		List<OrderData> orderList = orderPersistence.getAllOrderData(pageRoll, orderData);
		for(OrderData data:orderList){//根据订单id来查询订单对应的中间表的数据集合
			List<OrderProductData> orderProductDatas = getOPsByOrderId(data.getId());
			data.setOrderProductDatas(orderProductDatas);
		}
		return orderList;
    }
    /****
     * 根据订单的id去查询该订单对应的订单服务中间表数据的集合
     * @author dlm
     */
    public List<OrderProductData> getOPsByOrderId(String orderid){
    	
    	String hql = "from OrderProductData op where op.orderId=?";//根据订单id来查询
    	return orderProductPersistence.search(hql, new Object[]{orderid});
    }

    @Override
    public List<OrderData> getOrderData(JSONObject json) {
        return orderPersistence.getOrderData(json);
    }

    /**
     * 在支付订单的时候，如果是,更新或者增加
     * 
     * @author HY
     * @date 2014-3-24
     * @param data
     * @param userId
     * 
     */
    @Override
    public void updateOrderUserInfo(String userId, String orderId) {

        OrderData orderData = null; // 订单实体
        List<PageProductData> pageProductDatas = null; // page服务中间表集合
        ProductData productData = null; // 服务实体
        UserInfoData userInfo = null; // 用户信息实体
        List<UserInfoData> infoDatas = null; // 用户信息集合
        List<OrderProductData> orderProductDatas = null; // 订单服务中间表
        Integer num = 0; // 数量
        // 如果userid不为空 查询出订单实体
        if (orderId != null && !"".equals(orderId)) {
            orderData = orderPersistence.retrieve(orderId);
        }
        /* 如果订单实体不为空查询出page服务中间表 */
        if (orderData != null) {
            String hql = "from PageProductData p where p.id = ?";
            pageProductDatas = pageProductPersistence.search(hql, new Object[] { orderData.getPageProductId() });
            /* 查询订单服务集合 为了取出数量 */
            String opHql = "from OrderProductData op where op.orderId = ?";
            orderProductDatas = orderProductPersistence.search(opHql, new Object[] { orderId });
            if (pageProductDatas != null && pageProductDatas.size() > 0) {
                for (int i = 0; i < pageProductDatas.size(); i++) {
                    // 如果服务id不为空 查询出服务
                    if (pageProductDatas.get(i).getProductId() != null
                            && !"".equals(pageProductDatas.get(i).getProductId())) {
                        productData = productPersistence.retrieve(pageProductDatas.get(i).getProductId());
                        /* 如果查询出来的服务 名称是 “官方发布权限” 且sign是1 就执行以下操作 */
                        if ("官方发布权限".equals(productData.getName()) && "1".equals(productData.getSign())) {

                            if (userId != null && !"".equals(userId)) {
                                String userHql = "from UserInfoData us where us.userId = ?";
                                infoDatas = userInfoDataPersistence.search(userHql, new Object[] { userId });
                                // 如果他们的id 相等 取出数量
                                for (int j = 0; j < orderProductDatas.size(); j++) {
                                    if (orderProductDatas.get(i).getProductId().equals(productData.getId())) {
                                        num = orderProductDatas.get(i).getAmount();
                                    }
                                }
                                // 数据不存在 增加
                                if (infoDatas.size() == 0) {
                                    UserInfoData userInfoData = new UserInfoData();
                                    userInfoData.setUserId(userId); // userId
                                    userInfoData.setPayPrivilege(num); // 付费的权限数量

                                    // 赋初值
                                    userInfoData.setAlreadyPayPrivilege(0); // 已使用的付费权限
                                    userInfoData.setAlreadyTryPrivilege(0);
                                    userInfoData.setAlreadyUpgrade(0);
                                    userInfoData.setGiveNum(0);
                                    userInfoData.setOverduePrivilege(0);
                                    userInfoData.setRenew(0);
                                    userInfoData.setTryPrivilege(0);
                                    userInfoDataPersistence.add(userInfoData);
                                } else if (infoDatas != null && infoDatas.size() > 0) { // 存在 修改
                                    userInfo = infoDatas.get(0);

                                    JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
                                    String sql = "update mini_user_info us set us.payprivilege=us.payprivilege+" + num
                                            + "" + " " + "where us.id = '" + userInfo.getId() + "' ";
                                    dao.executeSQL(sql);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    @Override
    public String queryProductIdByUserId(String userId) {
        return orderPersistence.queryProductIdByUserId(userId);
    }

    // 修改用户的权限信息，根据用户id和购买发布权限的数量去更新用户的权限信息
    @Override
    public void updateUserInfo(String userid, Integer amount) {
        String sql = "update mini_user_info t set t.PAYPRIVILEGE=(t.PAYPRIVILEGE+" + amount + ") where t.userid='"
                + userid + "'";
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        jdbcDao.executeSQL(sql);

    }

    // 修改购物车对象的数据为假删，根据用户id和服务id去删除属于这个用户的发布权限的服务
    @Override
    public void updateShoppingCart(String userid, String id) {
        String sql = "update MINI_SHOPPINGCART t set t.ISDELETE=0 where t.USERID='" + userid + "' and t.PRODUCTID='"
                + id + "'";
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        jdbcDao.executeSQL(sql);
    }

    // 修改购物车对象的数据为假删,根据用户的id和page的id
    @Override
    public void updateShoppingCartbypage(String userid, String pageid) {
        String sql = "update MINI_SHOPPINGCART t set t.ISDELETE=0 where t.USERID='" + userid + "' and t.pageid='"
                + pageid + "'";
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        jdbcDao.executeSQL(sql);
    }

    @Override
    public List<OrderData> getOrderData(OrderData orderData) {
        // 订单集合
        List<OrderData> orderDatas = new ArrayList<OrderData>();
        // 定义hql查询语句
        StringBuffer hql = new StringBuffer("from OrderData od where 1=1");
        // 定义参数集合
        List<Object> objects = new ArrayList<Object>();
        if (orderData != null && orderData.getSysUserId() != null && !"".equals(orderData.getSysUserId())) {
            hql.append(" and od.sysUserId = ?");
            objects.add(orderData.getSysUserId());
        }
        if (orderData!=null && !"".equals(orderData.getId())&&null!=orderData.getId()) {
            hql.append(" and od.id = ?");
            objects.add(orderData.getId());
        }
        orderDatas = orderPersistence.search(hql.toString(), objects);
        return orderDatas;
    }
    /**
     * 
     * 更具订单id和用户id查询订单的详细信息 包括实名认证信息和发票信息<br>
     * 
     * @author 冯鑫 <br> 
     *        2014-4-22
     * @update 侯杨
     * @param orderId 订单id 必须不为空
     *        userId  当前登录用户id 必须不为空
     * @return  OrderData
     */
   public OrderData findAllOrderDatebyOrderId(String orderId){
	   OrderData orderData = orderPersistence.retrieve(orderId);//订单的信息
	   BusinessUserData bUserData = getBuserByOrderId(orderId);//根据订单id查询认证信息
	   List<OrderProductData> orderProductDatas = getOPsByOrderId(orderId);//根据订单id查询订单服务中间表信息
	   //不是官方发布权限
       if(orderProductDatas.get(0).getPageId()!=null && !"".equals(orderProductDatas.get(0).getPageId())){
           //查询page表
           PageData pageData=pagePersistence.retrieve(orderProductDatas.get(0).getPageId());
           //查询page域名信息
           PageInfoExtraData pageInfoExtraData=new PageInfoExtraData();
           pageInfoExtraData.setType("2");
           pageInfoExtraData.setPageId(pageData.getId());
           pageInfoExtraData=pageInfoExtraPersistence.searchByPageInfoExtraData(pageInfoExtraData);
           pageData.setPageInfoExtra(pageInfoExtraData);
           orderData.setPageData(pageData);
       }
	   orderData.setBusinessUserData(bUserData);
	   orderData.setOrderProductDatas(orderProductDatas);
	   if(null!=orderData && orderData.getInvoiceId()!=null && !"".equals(orderData.getInvoiceId())){
		   InvoiceData invoiceData = invoicePersistence.retrieve(orderData.getInvoiceId());
		   orderData.setInvoiceData(invoiceData);
	   }
       return orderData;
    }
   
   
    
	/**
	 * 根据订单id查询认证信息
	 * @param orderId
	 * @return
	 */
	private BusinessUserData getBuserByOrderId(String orderId) {
		String busHql = " from BusinessUserData b where b.orderId=? and b.isDelete=1";
		List<BusinessUserData> businessUserDatas = businessUserPersistence.search(busHql, new Object[]{orderId});
		if(businessUserDatas!=null && businessUserDatas.size()>0){
			return businessUserDatas.get(0);
		}else{
			return null;
		}
	}

	/****
	 * 根据订单服务中间表id和状态值来该变订单的状态（未开通改为已开通）
	 * @author dlm
	 */
	@Override
	public void updateOpState(OrderProductData orderProductData) {

		orderProductPersistence.updateOrderProduct(orderProductData);//更新状态值
		
	}

	
	/****
	 * 根据订单id和状态值来该变订单的状态（线下付款变为已付款）
	 * @author dlm
	 */
	@Override
	public void updateOrderState(OrderData orderData) {
		orderPersistence.editOrder(orderData);//更新状态值
		
	}

	
	/**
	 * 根据订单id查询订单对象
	 * @param orderId
	 * @return
	 */
	@Override
	public OrderData retrieve(String orderId) {
		if(!"".equals(orderId) && orderId!=null){//id为空就返回空
			return orderPersistence.retrieve(orderId);
		}else{
			return null;
		}
	}
	/**
     * 
     * 删除MINI_ORDER,同时删除MINI_PAGEPRODUCT,MINI_ORDER_PRODUCT
     * 
     * @author 冯鑫 <br> 
     *         2014-4-23
     * @update 
     */
	public void deleteOrderByID(String orderId){
        StringBuffer pageIdStr = new StringBuffer("select pro.pageid from MINI_ORDER_PRODUCT pro where 1=1 ");
        pageIdStr.append("and pro.orderid='"+orderId+"'");
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        List<ETIPResultSet> resultSet = dao.queryForList(pageIdStr.toString(), null);
        StringBuffer deletePageProdudct = new StringBuffer("delete from MINI_PAGEPRODUCT pp where 1=1 ");
        deletePageProdudct.append(" and pp.pageid in (");
        for (int i = 0; i < resultSet.size(); i++) {
            deletePageProdudct.append("'"+resultSet.get(i).getString("PAGEID").concat("',"));
            if(i+1==resultSet.size()){
                deletePageProdudct.append("'"+resultSet.get(i).getString("PAGEID").concat("')"));
            }
        }
        dao.executeSQL(deletePageProdudct.toString());
        StringBuffer deleteOrder = new StringBuffer("delete from MINI_ORDER_PRODUCT p where p.orderid='"+orderId+"'");
        dao.executeSQL(deleteOrder.toString());
        StringBuffer deleteOrderProduct = new StringBuffer(" DELETE FROM MINI_ORDER o  WHERE o.id = '"+orderId+"' ");
        dao.executeSQL(deleteOrderProduct.toString());
    }

	
    /**
     * 查看page在订单里面的订单里面所有未付款的订单的中间表的集合（0,1）
     * dlm
     * @param pageid
     * @return
     */
    public List<OrderProductData> getOrdersByPage(String pageid){
    	
    	String ordproHql = " from OrderProductData op where op.pageId=? ";//先查询中间表
    	List<OrderProductData> oplist1 = new ArrayList<OrderProductData>();
    	List<OrderProductData> oplist = orderProductPersistence.search(ordproHql, new Object[]{pageid});
    	if(oplist!=null && oplist.size()>0){
    		for(OrderProductData data:oplist){//根据中间表查询订单表
    			String orderHql = " from OrderData o WHERE o.id=? and o.state in(0,1) ";
    			List<OrderData> olist = orderPersistence.search(orderHql, new Object[]{data.getOrderId()});
    			if(olist!=null && olist.size()>0){
    				oplist1.add(data);
    			}
    		}
    	}
    	return oplist1;
    	
    }
    /**
     * 
     *删除已经完成订单，物理删除，包括订单表以及订单服务中间表<br>
     * 
     * @author 冯鑫 <br> 
     *          2014-5-6
     * @update 
     * @param OrderData orderData
     */
    public void deleteOnlyOrderByID(OrderData orderData){
        orderPersistence.deleteOrder(new String[]{orderData.getId()});
    }
    /**
     * 根据服务id和pageid  查询出订单id，查出订单是否存在（page编辑页面  服务）
     * @author 侯杨
     * @date 2014-05-07
     * @param data
     * @return
     */
    public String getOrderState(OrderProductData data){
    	//根据服务id 和pageid 查询订单服务中间表
    	String msg="0";
    	String hql="from OrderProductData op where op.pageId=? and op.productId= ?";
    	OrderProductData orderProductData=null;
    	List<OrderProductData> list=new  ArrayList<OrderProductData>();
    	if(data!=null){
    		list=orderProductPersistence.search(hql, new Object[]{data.getPageId(),data.getProductId()});
    		if(list.size()>0){
    			orderProductData=list.get(0);
    		}
    	}
    	//如果查询的出来的订单服务中间表不为空，查询出订单信息，是否存在
    	OrderData orderData=null;
    	if(orderProductData!=null){
    		orderData=orderPersistence.retrieve(orderProductData.getOrderId());
    	}
    	//如果订单状态不存在，返回1，不然返回0
    	if(orderData==null){
    		msg="1";
    		
    	}else if(orderData.getState()==3){   //如果订单状态已付款且开通
    		msg="2";
    	}else{
    		msg="0";
    	}
    	return msg;
    }

    @Override
    public String addOrUpdateOrderAtten(AttenInfoData attenInfoData) {
        // 若需要持久化的订单联系人信息对象id为空 则执行添加操作 反正执行更新操作
        if(attenInfoData.getId()==null || "".equals(attenInfoData.getId())){
            attenInfoData.setCreateTime(new Date());
            atteninfoPersistence.add(attenInfoData);
        }else{
            attenInfoData.setCreateTime(new Date());
            atteninfoPersistence.update(attenInfoData);
        }
        return attenInfoData.getId();
    }

    @Override
    public List<AttenInfoData> searchAllByUserId(String userid) {
        AttenInfoData attenInfoData = new AttenInfoData();
        attenInfoData.setUserId(userid);
        return atteninfoPersistence.searchByAttenInfo(attenInfoData);
    }

    @Override
    public void delAttenInfo(String id) {
        AttenInfoData infoData = new AttenInfoData();
        infoData=atteninfoPersistence.retrieve(id);
        atteninfoPersistence.delete(infoData);
    }
    /**
     * 根据 用户id查询发票信息  取最近的一条数据
     * @author 侯杨
     * @date 2014-05-15
     * @param userId
     * @return
     */
    public InvoiceData getInvoiceDataByUserId(String userId){
    	String hql="from InvoiceData inv where inv.userId =?  order by inv.createTime desc ";
    	InvoiceData invoiceData=null;  //发票实体
    	//如果用户id 不为空查询出数据
    	if(userId!=null && !"".equals(userId)){
    		List<InvoiceData> list=invoicePersistence.search(hql, new Object[]{userId});
    		//如果集合size大于0,就取出发票信息第一条数据
    		if(list.size()>0){
    			invoiceData=list.get(0);
    		}
    	}
    	return invoiceData;
    }
 @SuppressWarnings("unchecked")
public List<OrderData> getOrderDataList(PageRoll pageRoll,OrderData orderData){
     // 定义条件查询的HQL语句
     StringBuffer hql = new StringBuffer("from OrderData od where 1=1 ");
     List<Object> objectlist = new ArrayList<Object>();
     StringBuffer sb = new StringBuffer();
     //用户查询
     if(orderData.getSysUserId()!=null && !"".equals(orderData.getSysUserId())){
         sb.append(" and od.sysUserId = ?");
         objectlist.add(orderData.getSysUserId());
     }
     //状态查询
     if(orderData.getState()!=null ){
         sb.append(" and od.state = ?");
         objectlist.add(orderData.getState());
     }else{
         //默认查询  未付款的订单
         sb.append(" and (od.state = 0 or  od.state =1 )");
     }
     
     sb.append(" order by od.createTime");
     pageRoll.setCountSQL("select count(*) " + hql + sb.toString());
     pageRoll.setSearchSQL(hql + sb.toString());
     List<OrderData> list = orderProductPersistence.search(pageRoll, objectlist).getList();
     List<OrderData> orderdList=new ArrayList<OrderData>();
     if(list.size()>0){
         for (int i = 0; i < list.size(); i++) {
             OrderData data=new OrderData();
             data=list.get(i);  //订单实体
             //查询订单服务集合
             if(data.getId()!=null && !"".equals(data.getId())){
                 List<OrderProductData> orderProductDatas=new ArrayList<OrderProductData>();
                 orderProductDatas=orderProductPersistence.getOrderProductList(data);
                 data.setOrderProductDatas(orderProductDatas);
                 data.setProductNum(orderProductDatas.size());
                 }
             orderdList.add(data);
         }
     }
     return orderdList;
 }
}
