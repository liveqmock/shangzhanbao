package com.mini.pageManage.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.common.util.DateUtil;
import com.common.util.ReadWriteFile;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.give.data.UserInfoData;
import com.mini.give.persistence.IUserInfoDataPersistence;
import com.mini.order.business.IOrderBusiness;
import com.mini.order.data.OrderProductData;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageServiceData;
import com.mini.page.data.PageTemplateData;
import com.mini.page.persistence.IAccesstatisticsPersistence;
import com.mini.page.persistence.IPageTemplatePersistence;
import com.mini.pageManage.persistence.IPageManagePersistence;
import com.mini.pageManage.persistence.IPageServicePersistence;
import com.mini.pageMessageboard.business.IPageMessageboardBusiness;
import com.mini.pageMessageboard.data.PageMessageboardData;
import com.mini.pageMessageboard.persistence.IPageMessageboardPersistence;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.product.persistence.IPageProductPersistence;
import com.mini.product.persistence.IProductPersistence;
import com.mini.purchase.orderManager.persistence.IOrderManagerPersistence;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;
import com.mini.purchase.pagegoodsinfo.persistence.IPageGoodsInfoPersistence;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.data.UserOwnTempData;
import com.mini.tempmanage.persistence.ITempManagePersistence;
import com.mini.tempmanage.persistence.ITemplateThumbnailPersistence;
import com.mini.tempmanage.persistence.IUserOwnTempPersistence;

@Component("pageManageBusiness")
public class PageManageBusiness extends FrmBusiness implements IPageManageBusiness {

    @Resource(name = "pageManagePersistence")
    private IPageManagePersistence pageManagePersistence;// page

    @Resource(name = "pageServicePersistence")
    private IPageServicePersistence pageServicePersistence; // 服务
    @Resource(name = "shoppingCartPersistence")
    private IShoppingCartPersistence shoppingCartPersistence; // 购物车

    @Resource(name = "tempManagePersistence")
    private ITempManagePersistence tempManagePersistence;// 模版

    @Resource(name = "pageInfoExtraPersistence")
    private IPageInfoExtraPersistence pageInfoExtraPersistence; // 域名

    @Resource(name = "accesstatisticsPersistence")
    private IAccesstatisticsPersistence accesstatisticsPersistence;// 数据统计接口;
    @Resource(name = "userInfoDataPersistence")
    private IUserInfoDataPersistence userInfoDataPersistence;// 用户升级，续费，发布的 权限
    @Resource(name = "templateThumbnailPersistence")
    private ITemplateThumbnailPersistence templateThumbnailPersistence;// 模版图片;
    @Resource(name = "pageTemplatePersistence")
    private IPageTemplatePersistence pageTemplatePersistence;// 模板page关联
    @Resource(name = "userOwnTempPersistence")
    private IUserOwnTempPersistence userOwnTempPersistence;// 用户模板关联
    @Resource(name = "pageProductPersistence")
    private IPageProductPersistence pageProductPersistence; // page服务中间表
    @Resource(name = "productPersistence")
    private IProductPersistence productPersistence; // 服务
    @Resource(name = "orderBusiness")
    private IOrderBusiness orderBusiness; // 订单
    @Resource(name = "pageMessageboardBusiness")
    private IPageMessageboardBusiness pageMessageboardBusiness;// page留言信息表

    // 消费者订单信息persistence接口 容器注入
    @Resource(name = "orderManagerPersistence")
    private IOrderManagerPersistence orderManagerPersistence;
    /**
     * page商品信息持久化层注入
     */
    @Resource(name="pageGoodsInfoPersistence")
     public IPageGoodsInfoPersistence pageGoodsInfoPersistence;
    
    @Resource(name = "pageMessageboardPersistence")
    private IPageMessageboardPersistence pageMessageboardPersistence;

    /**
     * 用户：查找改用的所有page
     * 
     * @author 郭井超
     * @param pageRoll
     * @param pageData
     * @update dalm 增加了查询pageDate的缩略图
     * @return
     */
    @Override
    public List<PageData> getAllPageData(PageRoll pageRoll, PageData pageData) {

        // 根据userid分页查询出该用户的page
        List<PageData> pageDatas = getPageDatasByUserId(pageRoll, pageData);

        // 循环page集合
        if (pageDatas != null && pageDatas.size() > 0) {
            for (int i = 0; i < pageDatas.size(); i++) {

                // 根据page查询该page所使用的模板
                pageDatas.get(i).setTemplateData(getTemplateDataByPage(pageDatas.get(i).getId()));
                // 根据pageid查询模板缩略图
                pageDatas.get(i).getTemplateData()
                        .setThumbnailDatas(getTemplateThumbnailDatas(pageDatas.get(i).getId()));

                // 根据page查询该page所购买的服务（不管付款没有）固定显示3个服务，可信网站，在线客服，独立域名
                pageDatas.get(i).setPageProductDatas(getPageProductsByPage(pageDatas.get(i).getId()));

                // 根据page查询page启用的域名
                pageDatas.get(i).setPageInfoExtra(getPageInfoExtraByPage(pageDatas.get(i).getId()));

                // page的访问流量
                pageDatas.get(i).setAccesstatisticsData(getAccesstatisticsDataByPageId(pageDatas.get(i).getId()));

                // 判断是否page是否过期;
                int use = pageDataIfUse(pageDatas.get(i));
                pageDatas.get(i).setUse(use);

                // 根据pageid得到购物车里面的数据
                List<ShoppingCartData> shoplist = shoppingCartPersistence.getShopCartsByPage(pageDatas.get(i).getId());
                if (shoplist != null && shoplist.size() > 0) {
                    pageDatas.get(i).setShopDatas(shoplist);// 未结算的服务集合
                    pageDatas.get(i).setHasShop("1");// 如果存在购物车的数据，表示未结算，则赋值为1
                }

                // 根据pageid得到未付款的订单
                List<OrderProductData> oplist = orderBusiness.getOrdersByPage(pageDatas.get(i).getId());
                if (oplist != null && oplist.size() > 0) {
                    pageDatas.get(i).setOrderProductDatas(oplist);// 未付款的服务集合
                    pageDatas.get(i).setHasOrder("1");// 如果存在未付款的订单，表示未付款，则赋值为1
                }

                // 根据pageid查询未查看的留言
                List<PageMessageboardData> pblist = pageMessageboardBusiness.getPageMessageboardBypageid(
                        pageDatas.get(i).getId(), 0);
                if (pblist != null && pblist.size() > 0) {
                    pageDatas.get(i).setMessageBoardNum(pblist.size());
                } else {
                    pageDatas.get(i).setMessageBoardNum(0);
                }

                // 根据pageId查询查询待处理的消费者订单数量
                Integer consumersOrderNum = orderManagerPersistence.serachNotProcessOrderNum(pageDatas.get(i).getId());
                pageDatas.get(i).setNotProcessOrderNum(consumersOrderNum);
            }
        }

        return pageDatas;

    }

    /**
     * 根据userid分页查询该用户所有的page（不带附加的属性，不适用于page管理）
     * 
     * @author dlm
     * @param pageRoll
     * @param userid
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PageData> getPageDatasByUserId(PageRoll pageRoll, PageData pageData) {

        StringBuffer hql = new StringBuffer(" from PageData p where p.userId=? and p.isDelete=1 ");

        if ("0".equals(pageData.getStatus())) {// 暂存
            hql.append(" and p.status='0' ");
        } else if ("1".equals(pageData.getStatus())) {// 已发布
            hql.append(" and p.status='1' ");
        } else if ("2".equals(pageData.getStatus())) {// 已禁用
            hql.append(" and p.status='2' ");
        }
        hql.append(" order by p.createTime desc ");
        StringBuffer countSql = new StringBuffer(" select count(*) " + hql.toString());
        pageRoll.setCountSQL(countSql.toString());
        pageRoll.setSearchSQL(hql.toString());

        List<PageData> list = pageManagePersistence.search(pageRoll, new Object[] { pageData.getUserId() }).getList();
        return list;

    }

    /**
     * 根据pageid查询page使用的模板
     * 
     * @param id
     * @return
     */
    public TemplateData getTemplateDataByPage(String pageid) {

        String ptHql = " from PageTemplateData pt where pt.pageId=? ";
        List<PageTemplateData> list = pageTemplatePersistence.search(ptHql, new Object[] { pageid });
        if (list != null && list.size() > 0) {
            TemplateData templateData = tempManagePersistence.retrieve(list.get(0).getTemplateId());// 查询模板对象
            templateData.setPageTemplateDatas(list);// 把中间表的对象集合插入到模板对象里面（根据pageid查询出来的集合，只有一条数据）
            return templateData;
        } else {
            return new TemplateData();
        }

    }

    /**
     * 根据page查询该page所购买的服务，返回中间表集合
     * 
     * @param id
     * @return
     */
    public List<PageProductData> getPageProductsByPage(String pageid) {

        String ppHql = " from PageProductData pp where pp.pageId=? and pp.isdelete=1";
        List<PageProductData> list = pageProductPersistence.search(ppHql, new Object[] { pageid });
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {// 循环list集合查询属于该page的服务的对象，然后把服务对象放到中间表的对象里
                ProductData productData = productPersistence.retrieve(list.get(i).getProductId());
                list.get(i).setProductData(productData);
            }
        }
        return list;

    }

    /**
     * 
     * 根据pageid查询所使用的模板，然后根据模板id查询模板缩略图
     * 
     * @author 侯杨 <br>
     *         2014-6-16
     * @update
     * @param [参数1] [参数1说明]
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public List<TemplateThumbnailData> getTemplateThumbnailDatas(String pageId) {
        TemplateData templateData = null;
        if (pageId != null && !"".equals(pageId)) {
            templateData = getTemplateDataByPage(pageId);
        }
        String hql = "from TemplateThumbnailData te where te.templateId =?";
        List<TemplateThumbnailData> list = null;
        if (templateData != null && !"".equals("templateData")) {
            list = templateThumbnailPersistence.search(hql, new Object[] { templateData.getId() });
        }
        return list;
    }

    /**
     * 得到page的域名信息
     * 
     * @param pageid
     * @return
     */
    public PageInfoExtraData getPageInfoExtraByPage(String pageid) {

        String peHql = " from PageInfoExtraData pe where pe.pageId=? and pe.status='OPEN'";
        List<PageInfoExtraData> list = pageInfoExtraPersistence.search(peHql, new Object[] { pageid });
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return new PageInfoExtraData();// 如果page没有对应的page信息 则返回一个空的信息对象
        }

    }

    /**
     * 得到page的二级域名信息
     * 
     * @param pageid
     * @return
     */
    public String getDomainByPage(String pageid) {

        String peHql = " from PageInfoExtraData pe where pe.pageId=? and pe.type=2";
        List<PageInfoExtraData> list = pageInfoExtraPersistence.search(peHql, new Object[] { pageid });
        if (list != null && list.size() > 0) {
            return list.get(0).getDomain();
        } else {
            return "";// 如果page没有对应的page信息 则返回一个空的信息对象
        }

    }

    /**
     * 暂时没有使用（dlm）
     * 
     * @param id
     * @return
     */
    public TemplateThumbnailData getTemplateThumbnailDataById(String id) {
        TemplateThumbnailData templateThumbnailData = new TemplateThumbnailData();
        String sql = " from TemplateThumbnailData a where a.templateId=? and a.type = 'main'";
        List<Object> objects = new ArrayList<Object>();
        objects.add(id);
        List<TemplateThumbnailData> list = templateThumbnailPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            templateThumbnailData = list.get(0);
        }
        return templateThumbnailData;
    }

    /**
     * 判断page是否是 试用 正常
     * 
     * @param pageData
     * @return
     */
    public int pageDataIfUse(PageData pageData) {

        Date currTime = new Date();// 当前系统时间;
        Date endTime = pageData.getEndTime();// 赠送权限到期时间;
        if (endTime != null) {
            long currTimelong = currTime.getTime();
            long endTimeelong = endTime.getTime();
            if (currTimelong > endTimeelong) {
                return 0;// 过期了
            } else {
                return 1;// 正常
            }
        } else {
            return 2;// 截至时间null
        }

    }

    /**
     * 查询使用该page 所有域名
     * 
     * @author guojingchao
     * @param pageId
     * @return
     */
    public List<PageInfoExtraData> getPageInfoExtraData(String pageId) {
        StringBuffer searchHql = new StringBuffer(" from PageInfoExtraData p where 1 = 1");
        searchHql.append(" and p.pageId=?");
        List<Object> objects = new ArrayList<Object>();
        objects.add(pageId);
        return pageInfoExtraPersistence.search(searchHql.toString(), objects);
    }

    /**
     * 用户： 该配置的访问数、访问量、平均访问停留时间、动态转换率
     * 
     * @author 郭井超
     * @updata dlm 注释了访客数 更改了 浏览量的查询，是查询所有 不用查询时间段
     * @param pageId
     * @return
     */
    @Override
    public AccesstatisticsData getAccesstatisticsDataByPageId(String pageId) {
        AccesstatisticsData accesstatisticsData = new AccesstatisticsData();
        /** 查询浏览量 */
        String startTime = DateUtil.getSpecifiedDay(DateUtil.currentDate(), "yyyy-MM-dd", -6);
        String hql = " from  AccesstatisticsData a where a.pageId = ? and a.accessTime > to_date('" + startTime
                + " 23:59:59','yyyy-MM-dd HH24:MI:SS')" + " and a.accessTime<= to_date('" + DateUtil.currentDate()
                + " 23:59:59','yyyy-mm-dd HH24:MI:SS')";
        List<AccesstatisticsData> list = accesstatisticsPersistence.search(hql, new Object[] { pageId });
        int lLL = 0;
        if (list != null && list.size() > 0) {
            lLL = list.size();// 浏览量
        }
        accesstatisticsData.setlLL(lLL);

        // /** 查询访客数 */
        // String sql = " select count(*),t.accessip from mini_accesstatistics t where t.pageid=? group by t.accessip ";
        // JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        // List<ETIPResultSet> resultSet = dao.queryForList(sql, new Object[] { pageId });
        // int fKS = 0;
        // if (resultSet != null && resultSet.size() > 0) {
        // fKS = resultSet.size();
        // accesstatisticsData.setfKS(fKS);
        // } else {
        // accesstatisticsData.setfKS(fKS);
        // }
        return accesstatisticsData;
    }

    /**
     * 查询使用该page的所有服务
     * 
     * @author guojingchao
     * @param pageId
     * @return
     */
    public List<PageServiceData> getPageServiceDataByPageId(String pageId) {
        StringBuffer searchHql = new StringBuffer(" from PageServiceData p where 1 = 1");
        searchHql.append(" and p.pageId=?");
        List<Object> objects = new ArrayList<Object>();
        objects.add(pageId);
        return pageServicePersistence.search(searchHql.toString(), objects);
    }

    /**
     * 用户：用户删除page
     * 
     * @author 郭井超 update 侯杨
     * @param pageData
     */
    @Override
    public void deletePageDataById(PageData pageData) {

        PageData data = null;
        if (pageData.getId() != null && !"".equals(pageData.getId())) {
            data = pageManagePersistence.retrieve(pageData.getId());
        }
        data.setIsDelete(0);
        pageManagePersistence.update(data);
    }

    /**
     * 用户：设置域名
     * 
     * @param pageInfoExtraData
     */
    @Override
    public void updatePageInfoExtraData(PageInfoExtraData pageInfoExtraData, PageData pageData) {
        /* 修改配置名称 */
        pageData.setId(pageInfoExtraData.getPageId());
        pageManagePersistence.updateWithOutNullProp(pageData);
    }

    /**
     * 用户：判断用户是否有升级权限;
     * 
     * @author 郭井超
     * @param userId
     */
    @Override
    public int getPrivilegeData(String userId) {
        String sql = " from UserInfoData a where userId=? ";
        List<Object> objects = new ArrayList<Object>();
        objects.add(userId);
        List<UserInfoData> list = userInfoDataPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            UserInfoData userInfoData = list.get(0);
            if (userInfoData.getAlreadyPayPrivilege() < (userInfoData.getPayPrivilege()+userInfoData.getGiveNum())) {
                return 1;// 有权限,可以升级;
            } else if (userInfoData.getAlreadyPayPrivilege() > (userInfoData.getPayPrivilege()+userInfoData.getGiveNum())) {
                return 0;// 没有权限,需要购买;
            }
        }
        return 0;// 没有权限,需要购买;
    }

    /**
     * 用户： 执行升级操作
     * 
     * @author 郭井超
     * @param pageData
     * @update dlm 修改内容：修改了部分错误的算法和状态
     */
    @Override
    public PageData doPrivilegeData(PageData pagaData) {

        /* 根据用户Id查找权限数量 -- */
        String sql = " from UserInfoData a where a.userId=? ";
        List<Object> objects = new ArrayList<Object>();
        objects.add(pagaData.getUserId());// 需要变换
        List<UserInfoData> list = userInfoDataPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            UserInfoData userInfoData = list.get(0);
            int alreadyPayPrivilege = userInfoData.getAlreadyPayPrivilege();// 获得已经使用的付费权限数;
            int num = alreadyPayPrivilege + 1; // 因为是升级操作, 所以使用的付费权限数量要加一,
            int renNew = userInfoData.getRenew();// 续费数量
            if ("1".equals(pagaData.getLp())) {// 表示是续费操作;
                userInfoData.setRenew(renNew + 1);
            }
            userInfoData.setAlreadyPayPrivilege(num); // 已使用的付费权限
            if (userInfoData.getAlreadyTryPrivilege() > 0) {
                userInfoData.setAlreadyTryPrivilege(userInfoData.getAlreadyTryPrivilege() - 1); // 已使用的试用期权限
            }
            userInfoDataPersistence.updateWithOutNullProp(userInfoData);
        }

        /* 执行page升级操作; */
        PageData page = pageManagePersistence.retrieve(pagaData.getId());
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        int year = Integer.valueOf(dff.format(new Date()).substring(0, 4));
        int day;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {// 计算当前系统时间是闰年还是平年
            day = 366;
        } else {
            day = 365;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String endtime = DateUtil.getSpecifiedDay(dff.format(new Date()), "yyyy-MM-dd", day);// 赠送的权限时间为一年

        try {
            page.setEndTime(format.parse(endtime));// 截至时间;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        page.setState("1");// 表示该配置已经升级权限;
        pageManagePersistence.updateWithOutNullProp(page);
        return page;
    }

    /**
     * 
     * 用户： 查找用户有多少可用权限
     * 
     * @author 郭井超
     * @param userId
     * @return
     */
    @Override
    public int getUserPrivateNumber(String userId) {
        String sql = " from com.mini.give.data.UserInfoData a where a.userId=? ";
        List<Object> objects = new ArrayList<Object>();
        objects.add(userId);
        List<UserInfoData> list = userInfoDataPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            UserInfoData userInfoData = list.get(0);
            int payPrivilege = userInfoData.getPayPrivilege();// 获得用户付费权限数;
            int alreadyPayPrivilege = userInfoData.getAlreadyPayPrivilege();// 获得用户已经使用的付费权限数;
            int giveNum = userInfoData.getGiveNum();// 获取用户的赠送权限数
            int num = payPrivilege + giveNum - alreadyPayPrivilege;// 算出用还剩下多少个权限数量;

            if (num > 0) {
                return num;
            } else {
                return 0;
            }
        }
        return 0;
    }

    /**
     * 用户： 发布前 判断域名是否存在
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    @Override
    public String getPageInfoExtraDatas(PageData pageData) {

        String sql = " from  PageInfoExtraData a where a.pageId=?";
        List<Object> objects = new ArrayList<Object>();
        objects.add(pageData.getId());//
        List<PageInfoExtraData> list = pageInfoExtraPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            return "y";// 有域名
        }
        return "n";// 域名
    }

    /**
     * 用户： 发布page update 侯杨
     * 
     * @author 郭井超
     * @param pageData
     */
    @Override
    public String updatePageData(PageData pagaData) {
        /* 执行操作page发布. */
        pagaData.setStatus("1"); // 发布
        pagaData.setState("0"); // 当前为赠送权限
        pagaData.setPublishTime(new Date());
        String realpath = ServletActionContext.getServletContext().getRealPath("/configure"); // 获取赠送权限天数路径
        String date = ""; // 获取免费赠送天数
        try {
            date = ReadWriteFile.readTxtFile(realpath + "/file.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
        // 修改权限截止时间
        int day = 0;
        if (date != "" && !"".equals(date)) {
            day = Integer.parseInt(date); // 天数
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String endtime = DateUtil.getSpecifiedDay(dff.format(new Date()), "yyyy-MM-dd", day);// 赠送的权限时间

        try {
            pagaData.setEndTime(format.parse(endtime));// 截至时间;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pageManagePersistence.updateWithOutNullProp(pagaData);

        String state = getPageInfoExtraDatas(pagaData);
        if (state.equals("n")) {
            return "0";
        } else {

            PageInfoExtraData pageInfoExtraData = pageInfoExtraPersistence.retrieve(pagaData.getYmId());
            pageInfoExtraData.setStatus("OPEN");

            pageInfoExtraPersistence.updateWithOutNullProp(pageInfoExtraData);

            String sql = " from  PageInfoExtraData a where  a.pageId=? and a.id !=? ";
            List<Object> objects = new ArrayList<Object>();
            objects.add(pageInfoExtraData.getPageId());
            objects.add(pagaData.getYmId());
            List<PageInfoExtraData> list = pageInfoExtraPersistence.search(sql, objects);
            if (list != null && list.size() > 0) {
                list.get(0).setStatus("CLOASED");
                pageInfoExtraPersistence.updateWithOutNullProp(list.get(0));
            }
            return "1";
        }
    }

    /**
     * 用户： 查找独立域名 ---判断是否存在
     * 
     * @author 郭井超 update 侯杨 //page的二级域名存在，切page的状态为发布状态才能绑定 冯鑫 无论page是否有域名，只要page未发布，返回3
     * @param pageData
     * @return
     */
    @Override
    public String getPageInfoExtraData(PageData pageData) {
        pageData = pageManagePersistence.retrieve(pageData.getId());
        if ("".equals(pageData.getStatus()) || pageData.getStatus() == null || !"1".equals(pageData.getStatus())) {
            return "3";
        }
        String hql = " from  PageInfoExtraData a where a.type='2' and  a.pageId=?";
        List<Object> object = new ArrayList<Object>();
        object.add(pageData.getId());//
        List<PageInfoExtraData> lists = pageInfoExtraPersistence.search(hql, object);
        if (lists != null && lists.size() > 0) {
        } else {
            return "1";// 二级域名不存在--不能绑定独立域名
        }

        // page的二级域名存在，切page的状态为发布状态才能绑定
        String hql1 = " from  PageInfoExtraData a,PageData page where a.type='2'  and  a.pageId=? and page.id=a.pageId and page.status='1'";
        List<PageInfoExtraData> datas = pageInfoExtraPersistence.search(hql1, new Object[] { pageData.getId() });
        if (datas.size() > 0) {
        } else {
            return "2";
        }

        String sql = " from  PageInfoExtraData a where a.type='1' and  a.status='OPEN' and  a.pageId=?";
        List<Object> objects = new ArrayList<Object>();
        objects.add(pageData.getId());//
        List<PageInfoExtraData> list = pageInfoExtraPersistence.search(sql, objects);
        if (list != null && list.size() > 0) {
            return list.get(0).getDomain();// 有绑定独立域名
        } else {
            return "0";// 域名
        }

    }

    /**
     * 
     * 用户：if独立域名不存在 执行添加
     * 
     * @author 郭井超
     * @param pageData
     * @return
     */
    @Override
    public void addPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {

        String hql = " from  PageInfoExtraData a where a.type='1' and  a.status='CLOASED' and a.pageId=?  ";
        List<Object> objs = new ArrayList<Object>();
        objs.add(pageInfoExtraData.getPageId());
        List<PageInfoExtraData> yuMingList = pageInfoExtraPersistence.search(hql, objs);
        if (yuMingList != null && yuMingList.size() > 0) {

            yuMingList.get(0).setStatus("OPEN");
            yuMingList.get(0).setDomain(pageInfoExtraData.getDomain());
            pageInfoExtraPersistence.updateWithOutNullProp(yuMingList.get(0));

            String sql = " from  PageInfoExtraData a where  a.pageId=? and a.id !=? ";
            List<Object> objects = new ArrayList<Object>();
            objects.add(pageInfoExtraData.getPageId());
            objects.add(yuMingList.get(0).getId());
            List<PageInfoExtraData> list = pageInfoExtraPersistence.search(sql, objects);
            if (list != null && list.size() > 0) {
                list.get(0).setStatus("CLOASED");
                pageInfoExtraPersistence.updateWithOutNullProp(list.get(0));
            }
        } else {

            // 添加独立域名
            pageInfoExtraData.setType("1");// 表是独立域名
            pageInfoExtraData.setStatus("OPEN"); // 域名已经打开
            pageInfoExtraPersistence.add(pageInfoExtraData);

            // 如果有二级域名将其关闭
            String sql = " from  PageInfoExtraData a where  a.pageId=? and a.id !=? ";
            List<Object> objects = new ArrayList<Object>();
            objects.add(pageInfoExtraData.getPageId());
            objects.add(pageInfoExtraData.getId());
            List<PageInfoExtraData> list = pageInfoExtraPersistence.search(sql, objects);
            if (list != null && list.size() > 0) {
                list.get(0).setStatus("CLOASED");
                pageInfoExtraPersistence.updateWithOutNullProp(list.get(0));
            }
        }

    }

    @Override
    public void addPageData(PageData pageData) {
        // 添加page表
        Date date = new Date();
        pageData.setIsDelete(1);
        pageData.setCreateTime(date);
        pageManagePersistence.add(pageData);

        // 添加的page信息id
        String pageid = pageData.getId();
        // 所使用的模板的id
        String tempid = pageData.getPageTemplateData().getTemplateId();

        // 添加page模板关联表信息
        PageTemplateData data = new PageTemplateData();
        data.setPageId(pageid);
        data.setTemplateId(tempid);
        data.setEndTime(date);
        data.setStatus("OPEN");
        pageTemplatePersistence.add(data);

        // 判断用户是否拥有该模板
        TemplateData templateData = null;
        UserOwnTempData uData = userOwnTempPersistence.getUserOwnTempDataByUserIdOrTempId(pageData.getUserId(), tempid);
        List<TemplateData> list = tempManagePersistence.searchTemplateData(JSONObject.fromObject("{'id':'" + tempid
                + "'}"));
        if (null != list && list.size() > 0) {
            templateData = list.get(0);
        }

        // 判断用户模板是否存在,不存在则添加
        if (uData == null) {
            if (null == templateData.getPrice() || "".equals(templateData.getPrice())
                    || "0".equals(templateData.getPrice())) {
                // 添加模板用户管理表
                UserOwnTempData userOwnTempData = new UserOwnTempData();
                userOwnTempData.setTempId(tempid);
                userOwnTempData.setOwnTime(date);
                userOwnTempData.setUserId(pageData.getUserId());
                try {
                    userOwnTempPersistence.add(userOwnTempData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void editPageData(PageData pageData) {
        PageData data = pageManagePersistence.retrieve(pageData.getId());
        if (pageData.getStatus() != null && !"".equals(pageData.getStatus())) {
            data.setStatus(pageData.getStatus());
        }
        if (pageData.getContent() != null) {
            data.setContent(pageData.getContent());
        }
        if(pageData.getPageImg() != null && !"".equals(pageData.getPageImg())){
            data.setPageImg(pageData.getPageImg());
        }
        pageManagePersistence.update(data);
    }

    @Override
    public PageData findPageDataById(PageData pageData) {
        System.out.println(pageData.getId());
        return pageManagePersistence.retrieve(pageData.getId());
    }

    /**
     * 获取禁用page个数
     * 
     * @author hy
     * @param userId
     * @return
     */
    @Override
    public int getAllDisablePage(String userId) {
        List<PageData> list = new ArrayList<PageData>();
        if (userId != null && !"".equals(userId)) {
            String hql = "from PageData  a where  a.isDelete=1 and a.userId='" + userId + "' and a.status='2' ";
            list = pageManagePersistence.search(hql);
        }
        return list.size();
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
        List<ProductData> list_Pro = new ArrayList<ProductData>();
        ProductData pro = new ProductData();
        // 根据pageid得到购物车里面的数据
        List<ShoppingCartData> shoplist = shoppingCartPersistence.getShopCartsByPage(pageid);
        List<OrderProductData> oplist = orderBusiness.getOrdersByPage(pageid);
        if (shoplist.size() > 0) {
            for (int i = 0; i < shoplist.size(); i++) {
                pro = productPersistence.getProductDataByid(shoplist.get(i).getProductId());
                list_Pro.add(pro);
            }
        }
        if (oplist.size() > 0) {
            for (int i = 0; i < oplist.size(); i++) {
                pro = productPersistence.getProductDataByid(oplist.get(i).getProductId());
                list_Pro.add(pro);
            }
        }
        return list_Pro;
    }

    @Override
    public TemplateThumbnailData getTempPicByPageId(String pageId) {
        // 定义查询微站所使用的模板的id的hql语句
        StringBuffer searchTempHql = new StringBuffer("from PageTemplateData where 1=1 and pageId = ?");
        // 获取微站所使用的模板
        List<PageTemplateData> pageTemplateDatas = pageTemplatePersistence.search(searchTempHql.toString(),
                new Object[] { pageId });
        // 定义模板缩略图对象
        TemplateThumbnailData templateThumbnailData = new TemplateThumbnailData();
        // 定义查询模板主缩略图的的hql语句
        if (pageTemplateDatas.size() > 0) {
            StringBuffer hql = new StringBuffer("from TemplateThumbnailData where 1=1 and type='main' and templateId=?");
            // 获取模板主缩略图
            List<TemplateThumbnailData> thumbnailDatas = templateThumbnailPersistence.search(hql.toString(),
                    new Object[] { pageTemplateDatas.get(0).getTemplateId() });
            if (thumbnailDatas.size() > 0) {
                templateThumbnailData = thumbnailDatas.get(0);
            }
        }
        return templateThumbnailData;
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
        try {
            PageData data = null;
            if (pageData.getId() != null && !"".equals(pageData.getId())) {
                data = pageManagePersistence.retrieve(pageData.getId());
            }
            if (data != null) {
                // 查询page域名信息
                PageInfoExtraData pageInfoExtraData = getPageInfoExtraByPage(pageData.getId());
                if (pageInfoExtraData != null) {
                    data.setPageInfoExtra(pageInfoExtraData);
                }

            }
            return data;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
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
        pageManagePersistence.update(data);
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
     * @see PageManageBusiness#createGoodsCss
     * @since vmaque1.6
     */
     public void createGoodsCss(PageData data,String cssFilePath,String cssPath){
         pageManagePersistence.update(data); // 更新page表
     }
     /**
      * 
      *copy page所使用模板信息<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param pageId   page要copy的pageid
      *        newPagId copy后的pageid
      * @return  void
      * @see   PageManageBusiness#copyPageTempLate(String, String)
      * @since vmaque1.7
      */
     
     public void copyPageTempLate(String pageId,String newPagId){
         //根据pageid  查询出page所使用的模板
         TemplateData templateData= getTemplateDataByPage(pageId);
         PageTemplateData data2=templateData.getPageTemplateDatas().get(0);
         //如果数据存在  取出来  然后增加一条新的数据
         if(templateData!=null){
             //page所使用的模板
             PageTemplateData pageTemplateData=new PageTemplateData();
             pageTemplateData.setPageId(newPagId);  //pageid
             pageTemplateData.setTemplateId(templateData.getId());  //模板id
             pageTemplateData.setStatus(data2.getStatus());  //状态
             pageTemplateData.setStartTime(data2.getStartTime());  //有效期时间
             pageTemplateData.setEndTime(data2.getEndTime());  //接受时间
             pageTemplateData.setParentId(data2.getParentId()); //服版本id
             pageTemplateData.setTempVersion(data2.getTempVersion());  //版本号为1，发布一次版本号递增1
             pageTemplateData.setVersionState(data2.getVersionState()); //版本状态：OPEN=使用中，CLOSED=未使用。可直接切换启用历史版本.同时只能使用一个版本
             pageTemplateData.setVersionOperat(data2.getVersionOperat());  //指修版本创建对象，admin=管理员操作，member=用户自己操作
             pageTemplateData.setTemplateUseTime(data2.getTemplateUseTime());  //模板使用时间
             //执行添加
             pageTemplatePersistence.add(pageTemplateData);
         }
     }
     
     /**
      * 
      *copy page服务中间表信息<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param pageId   page要copy的pageid
      *        newPagId copy后的pageid
      * @return  void
      * @see   PageManageBusiness#copyPageProductData(String, String)
      * @since vmaque1.7
      */
     
     public void copyPageProductData(String pageId,String newPagId){
         //根据pageid 查询page所拥有的服务
         List<PageProductData> pageProductDatas= getPageProductsByPage(pageId);
             //当集合不为空时
           if(pageProductDatas.size()>0 && pageProductDatas!=null){
               for (int i = 0; i <pageProductDatas.size(); i++) {
                   ProductData productData=new ProductData();  //声明服务对象
                   productData=pageProductDatas.get(i).getProductData();
                   //声明page所使用服务对象
                   PageProductData data3=new PageProductData();
                   data3.setIsrz(pageProductDatas.get(i).getIsrz());  //是否认证
                   data3.setProductId(pageProductDatas.get(i).getProductId());  //服务id
                   data3.setPageId(newPagId);  //pageid
                   data3.setProductName(pageProductDatas.get(i).getProductName());//服务名称
                   data3.setYeraNum(pageProductDatas.get(i).getYeraNum());  //年限
                   data3.setIsdelete(pageProductDatas.get(i).getIsdelete());  //数据是否正常
                   data3.setCreateTime(pageProductDatas.get(i).getCreateTime());  //期限开始时间
                   data3.setExpireTime(pageProductDatas.get(i).getExpireTime());  //期限截止时间
                   data3.setStopTime(pageProductDatas.get(i).getStopTime());      //禁用时间
                   data3.setStopType(pageProductDatas.get(i).getStopType());      //禁用类型
                   data3.setStopDesc(pageProductDatas.get(i).getStopDesc());      //禁用原因
                   data3.setSignPath(pageProductDatas.get(i).getSignPath());      //上传路径
                   data3.setSignName(pageProductDatas.get(i).getSignName());      //上传文件名
                   data3.setSignTime(pageProductDatas.get(i).getSignTime());      //上传时间
                   data3.setProductContent(pageProductDatas.get(i).getProductContent()); //Page服务的内容 也可以使服务脚本代码的内容
                  //当服务为付费服务 那么这条数据状态为空，表示未付款
                    if(productData.getPrice()!=null && !"".equals(productData.getPrice())){
                       if(productData.getPrice()>0){
                       }else{
                           data3.setStatus(pageProductDatas.get(i).getStatus());
                       }
                  }else{
                      data3.setStatus(pageProductDatas.get(i).getStatus());
                  }
                   //增加
                   pageProductPersistence.add(data3);
              }
             
           }
     }
     /**
      * 
      *copy page商品信息中间表信息<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param pageId   page要copy的pageid
      *        newPagId copy后的pageid
      * @return  void
      * @see   PageManageBusiness#PageGoodsInfoData(String, String)
      * @since vmaque1.7
      */
     
     public void copyPageGoodsInfoData(String pageId,String newPagId){
         //根据pageid  查询page商品信息中间表
         List<PageGoodsInfoData> list=null;
         if(pageId!=null && !"".equals(pageId)){
             String hql="from PageGoodsInfoData p where p.pageId = ?";
             list=pageGoodsInfoPersistence.search(hql, new Object[]{pageId});
         }
         if(list!=null && list.size()>0){
             for (int i = 0; i < list.size(); i++) {
                 //声明对象
                PageGoodsInfoData goodsInfoData=new PageGoodsInfoData();
                goodsInfoData.setPageId(newPagId);  //pageid
                goodsInfoData.setGoodsInfoId(list.get(i).getGoodsInfoId());  //商品信息id
                //执行增加
                pageGoodsInfoPersistence.add(goodsInfoData);
                
            }
         }
     }
     /**
      * 
      *copy page留言表信息<br>
      * 
      * @author 侯杨 <br> 
      *        2014-10-20
      * @update 
      * @param pageId   page要copy的pageid
      *        newPagId copy后的pageid
      * @return  void
      * @see   PageManageBusiness#copyPageMessageboardData(String, String)
      * @since vmaque1.7
      */
     
     public void copyPageMessageboardData(String pageId,String newPagId){
               //根据pageid 查询page留言表
         PageMessageboardData messageboardData=pageMessageboardPersistence.getPageMessageboardByid(pageId);
         //如果存在
          if(messageboardData!=null && !"".equals(messageboardData)){
              //声明对象
              PageMessageboardData data4=new PageMessageboardData();
              data4.setPageid(newPagId);  //pageid
              data4.setName(messageboardData.getName());  //留言人
              data4.setEmail(messageboardData.getEmail());  //电子邮箱
              data4.setDemand(messageboardData.getDemand());  //详细需求
              data4.setIsread(messageboardData.getIsread());  //是否阅读
              data4.setCreatetime(messageboardData.getCreatetime());  //留言时间
              //执行添加
              pageMessageboardPersistence.addPageMessageboard(data4);
          }
     }
     /**
      * 
      *page 另存<br>
      * 
      * @author 侯杨 <br> 
      *		   2014-10-20
      * @update 
      * @param data   page实体
      * @return  pagedata page实体
      * @see   PageManageBusiness#copyPage(PageData)
      * @since vmaque1.7
      */
     public PageData copyPage(PageData data){
         PageData pageData=new PageData();
         if(data.getId()!=null && !"".equals(data)){
             data=pageManagePersistence.retrieve(data.getId());
             pageData.setUserId(data.getUserId());  //用户id
             pageData.setStatus("0");  //page状态
             pageData.setCreateTime(data.getCreateTime());  //创建时间
             pageData.setPublishTime(data.getPublishTime());  //发布时间
             pageData.setDisableTime(data.getDisableTime()); //禁用时间
             pageData.setName(data.getName());  //page名称
             pageData.setDisabledType(data.getDisabledType()); //page禁用类型
             pageData.setDisabledReason(data.getDisabledReason());//page禁用原因
             pageData.setCreateType(data.getCreateType()); //page创建类型
             pageData.setIsDelete(data.getIsDelete());  //数据是否存在
             pageData.setState(data.getState());  //付费 还是赠送状态
             pageData.setEndTime(data.getEndTime());  //权限赠送截止时间
             pageData.setContent(data.getContent());  //page内容
             pageData.setPageImg(data.getPageImg());  //page略缩图
             pageData.setZing(data.getZing());   //page二维码
             //执行添加
             pageManagePersistence.add(pageData);
             //copypage使用模板信息
             copyPageTempLate(data.getId(), pageData.getId());
             //copypage使用服务信息
             copyPageProductData(data.getId(), pageData.getId());
             //copypage商品信息
             copyPageGoodsInfoData(data.getId(), pageData.getId());
         }
          return pageData;
     }
}
