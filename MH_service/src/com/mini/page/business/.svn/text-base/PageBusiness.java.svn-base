package com.mini.page.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.ReadDomain;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.order.business.IOrderBusiness;
import com.mini.order.data.OrderProductData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.data.PageTemplateData;
import com.mini.page.persistence.IPagePersistence;
import com.mini.page.persistence.IPageTemplatePersistence;
import com.mini.privilege.data.PrivilegeData;
import com.mini.privilege.persistence.PrivilegePersistence;
import com.mini.product.data.PageProductData;
import com.mini.product.persistence.IPageProductPersistence;
import com.mini.product.persistence.IProductPersistence;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.persistence.ITempManagePersistence;
import com.sys.user.data.UserData;
import com.sys.user.persistence.IUserPersistence;

/**
 * 后台page管理业务接口实现类
 * 
 * @author 林海鹏
 * @see IPageBusiness
 * @since
 */
@Component("pageBusiness")
public class PageBusiness extends FrmBusiness implements IPageBusiness {
    /* page个人表 */
    @Resource(name = "pagePersistence")
    private IPagePersistence pagePersistence;
    /* page扩张表 */
    @Resource(name = "pageInfoExtraPersistence")
    private IPageInfoExtraPersistence pageInfoExtraPersistence;
    /* page所使用模板 */
    @Resource(name = "pageTemplatePersistence")
    private IPageTemplatePersistence pageTemplatePersistence;
    /* 模板表 */
    @Resource(name = "tempManagePersistence")
    private ITempManagePersistence tempManagePersistence;
    /* 用户表 */
    @Resource(name = "userPersistence")
    private IUserPersistence userPersistence;
    /* 权限 */
    @Resource(name = "privilegePersistence")
    private PrivilegePersistence privilegePersistence;
    // 服务
    @Resource(name = "productPersistence")
    private IProductPersistence productPersistence;
    // 服务中间表
    @Resource(name = "pageProductPersistence")
    private IPageProductPersistence pageProductPersistence;

    @Resource(name = "shoppingCartPersistence")
    private IShoppingCartPersistence shoppingCartPersistence; // 购物车

    @Resource(name = "orderBusiness")
    private IOrderBusiness orderBusiness; // 订单
    
    public void setPagePersistence(IPagePersistence pagePersistence) {
        this.pagePersistence = pagePersistence;
    }

    /**
     * 新增Page
     */
    @Override
    public void addPage(PageData pageData) {
        pagePersistence.addPage(pageData);
    }

    /**
     * 删除Page
     */
    @Override
    public void deletePage(String[] ids) {
        pagePersistence.deletePage(ids);
    }

    /**
     * 编辑Page
     */
    @Override
    public void editPage(PageData orderData) {
        pagePersistence.editPage(orderData);
    }

    /**
     * 查询Page(分页显示) //连表分页查询 返回数组
     */
    @Override
    public List<Object[]> getAllPageInfo(PageRoll pageRoll, JSONObject json) {
        return pagePersistence.getAllPageInfo(pageRoll, json);
    }

    /**
     * 根据条件获取对象
     */
    @Override
    public List<PageData> getPageData(JSONObject json) {
        return pagePersistence.getPageData(json);
    }

    /**
     * 连表分页查询 返回集合
     */
    @Override
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json) {
        return pagePersistence.getForpageRoll(pageRoll, json);
    }

    /**
     * 单对象分页查询 返回集合
     */
    @Override
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json) {
        return pagePersistence.getAllPages(pageRoll, json);
    }

    /**
     * 后台查询 page管理 分页
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll
     * @param helpData PageData
     * @return
     */
    @Override
    public List<PageData> getAllPage(PageRoll pageRoll, PageHelpData helpData,Integer sort) {
        StringBuffer sqlStr = new StringBuffer("  select a.id pageid,a.name pagename,a.disabledtype distype,"
                + "a.disabledreason disre,a.status status,a.create_time ctime,users.loginmail mail,"
                + "coalesce(b.domain, '') as domain,"
                + "coalesce(b.pstatus, '') as pgstate,"
                + "coalesce(b.ptype, '') as ptype"
                + " from mini_page a"
                + " left join (select domain as domain, "
                + // page域名
                "p.type as ptype,"
                + // 域名类型
                "p.status pstatus ,"
                + // 域名状态
                "page_id, "
                + // pageId
                "company as company"
                + // page域名公司名称
                " from mini_page_info_extra p  WHERE p.status='OPEN') b on a.id = b.page_id"
                + " left join ctn_sysuser users on a.user_id=users.id"
                + " where 1=1 and a.isDelete=1 and a.create_time is not null ");
        List<Object> objects = new ArrayList<Object>();
        String pageState = helpData.getPageState();
        /* 查询条件 */

        /* 验证page状态 */
         if(pageState!=null && !"".equals(pageState)){
            if (("0").equals(pageState)) {// 暂存
                sqlStr.append(" and a.status like '0'  ");
            }
            if (("1").equals(pageState)) {// 已发布
                sqlStr.append(" and a.status like '1' ");
            }
            if (("2").equals(pageState)) {// 禁用
                sqlStr.append(" and a.status like '2' ");
            }
            if (("3").equals(pageState)) {// 编辑中
                sqlStr.append(" and a.status like '3' ");
            }
            if (("4").equals(pageState)) {// 被禁用后，启用成功的状态
                sqlStr.append(" and a.status like '4' ");
            }
         }
         
        if (helpData.getPageDomain() != null && !"".equals(helpData.getPageDomain())) { // page域名
            String strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
                    + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
                    + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
                    + "|" // 允许IP和DOMAIN（域名） 
                    + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                    + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                    + "[a-z]{2,6})" // first level domain- .com or .museum  
                    + "(:[0-9]{1,4})?" // 端口- :80  
                    + "((/?)|" // a slash isn't required if there is no file name  
                    + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
            Pattern patt = Pattern.compile(strRegex,Pattern.CASE_INSENSITIVE ); 
            Matcher matcher = patt.matcher(helpData.getPageDomain());
            boolean isMatch = matcher.matches();
            if(isMatch==true){
                String path =ReadDomain.readProperties();
                System.out.println(helpData.getPageDomain().lastIndexOf('/')+1);
                String path1=helpData.getPageDomain().substring(0,helpData.getPageDomain().lastIndexOf('/')+1);
                if(path1.equals(path)){
                    String domain=helpData.getPageDomain().substring(helpData.getPageDomain().lastIndexOf('/')+1);
                    sqlStr.append(" and b.domain like ?");
                    objects.add("%" + domain + "%");
                }else{
                    sqlStr.append(" and b.domain like ?");
                    objects.add("%" + helpData.getPageDomain() + "%");
                }
            }else{
                sqlStr.append(" and b.domain like ?");
                objects.add("%" + helpData.getPageDomain() + "%");
            }
            
        }
        
        
        
        if (helpData.getPageName() != null && !"".equals(helpData.getPageName())) { // page名称
            sqlStr.append(" and a.name like ?");
            objects.add("%" + helpData.getPageName() + "%");
        }
        if (helpData.getCompany() != null && !"".equals(helpData.getCompany())) { // 公司名称
            sqlStr.append(" and b.company like ?");
            objects.add("%" + helpData.getCompany() + "%");
        }
        if (helpData.getPageType() != null && !"".equals(helpData.getPageType())) { // page域名类型
            sqlStr.append(" and b.ptype = ?");
            objects.add(helpData.getPageType());
        }
        if (helpData.getLoginMail() != null && !"".equals(helpData.getLoginMail())) { // 登录账号
            sqlStr.append(" and users.loginmail like ?");
            objects.add("%" + helpData.getLoginMail() + "%");

        }
        if (helpData.getCreateStartTime() != null) { // 创建时间
            sqlStr.append("and a.create_time >= ?");
            objects.add(helpData.getCreateStartTime());
        }
        if (helpData.getCreateEndTime() != null) {
            sqlStr.append("and a.create_time <= ?");
            objects.add(helpData.getCreateEndTime());
        }
        if (helpData.getStartTime() != null) { // 发布时间
            sqlStr.append(" and a.publish_time >= ?");
            objects.add(helpData.getStartTime());
        }
        if (helpData.getEndTime() != null) {
            sqlStr.append("  and a.publish_time <= ?");
            objects.add(helpData.getEndTime());
        }

        sqlStr.append(" order by a.create_time "); // 按创建时间排序
          if(sort==0){
              sqlStr.append(" desc");
          }else{
              sqlStr.append(" asc");
          }
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询

        pageRoll.setSearchSQL(sqlStr.toString());
        pageRoll.setCountSQL("select count(*) from (" + sqlStr + ")");
        List<ETIPResultSet> resultSet = dao.search(pageRoll, objects);// 分页查询
        List<PageData> helpDatas = new ArrayList<PageData>();

        if (resultSet != null && resultSet.size() > 0) {
            for (int i = 0; i < resultSet.size(); i++) {
                List<PageInfoExtraData> pageInfoExtraDatas = new ArrayList<PageInfoExtraData>();
                ETIPResultSet rs = resultSet.get(i);
                PageData data = new PageData();
                PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
                UserData userData = new UserData();
                data.setId(rs.getString("PAGEID")); // page id
                data.setName(rs.getString("PAGENAME")); // page名称
                data.setStatus(rs.getString("ST"));

                data.setStatus(rs.getString("STATUS")); // page 状态
                data.setCreateTime(rs.getDate("CTIME")); // page 创建时间
                userData.setLoginMail(rs.getString("MAIL")); // 用户名
                data.setDisabledType(rs.getInt("DIStype"));
                data.setDisabledReason(rs.getString("DISRES"));
                pageInfoExtraData.setDomain(rs.getString("DOMAIN")); // page域名
                pageInfoExtraData.setType(rs.getString("PYTYPE"));
                pageInfoExtraData.setStatus(rs.getString("PGSTATE"));
                /*
                 * pageInfoExtraDatas.add(pageInfoExtraData); data.setPageInfoExtraData(pageInfoExtraDatas);
                 */
                data.setPageInfoExtra(pageInfoExtraData); // page域名实体
                data.setUserData(userData);
                helpDatas.add(data);
            }
        }
        List<PageData> list = new ArrayList<PageData>(); // 集合返回集合
        for (int j = 0; j < helpDatas.size(); j++) {
            PageData pageData = new PageData();
            pageData = helpDatas.get(j); // 为新的page实体赋值
            // 根据pageid得到购物车里面的数据
            List<ShoppingCartData> shoplist = shoppingCartPersistence.getShopCartsByPage(pageData.getId());
            if (shoplist != null && shoplist.size() > 0) {
                pageData.setShopDatas(shoplist);// 未结算的服务集合
                pageData.setHasShop("1");// 如果存在购物车的数据，表示未结算，则赋值为1
            }
            // 根据pageid得到未付款的订单
            List<OrderProductData> oplist = orderBusiness.getOrdersByPage(pageData.getId());
            if (oplist != null && oplist.size() > 0) {
                pageData.setOrderProductDatas(oplist);// 未付款的服务集合
                pageData.setHasOrder("1");// 如果存在未付款的订单，表示未付款，则赋值为1
            }
            list.add(pageData);
        }

        return list;
    }

    /**
     * 禁用 page
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageId page 的id
     * @param PageData 实体
     */
    public void disabledPage(String id, PageData date) {
        PageData pageData = null;
        if (id != null && !"".equals(id)) { // 如果id不是空的 查询出数据
            pageData = pagePersistence.retrieve(id);

        }
        pageData.setDisableTime(new Date()); // 禁用时间
        pageData.setStatus(date.getStatus());
        pageData.setDisabledType(date.getDisabledType());
        pageData.setDisabledReason(date.getDisabledReason());
        pagePersistence.update(pageData);
    }

    /**
     * 
     * 启用 page 后台
     * 
     * @author 侯杨
     * @date 2014-2-20
     */
    public void startPageState(PageData date) {
        PageData pageData = null;
        if (date.getId() != null && !"".equals(date.getId())) { // 如果id不是空的 查询出数据
            pageData = pagePersistence.retrieve(date.getId());

        }
        pageData.setStatus("4");  //被禁用后，启用成功的状态
        pageData.setPublishTime(new Date());
        pagePersistence.update(pageData);
    }

    /**
     * 侯杨 后台 page管理 查询详情
     * 
     * @param pageId
     * @return
     */
    public PageData getPageId(String pageId) {
        PageData pageData = null; // page实体
        PageTemplateData pageTemplateData = null; // page使用模板实体
        TemplateData templateData = null; // 模板实体
        UserData userData = null;
        List<PrivilegeData> privilegeDatas = null; // 权限集合
        List<PageProductData> pageProductDatas = new ArrayList<PageProductData>(); // page服务集合
        /* 查询page对象 */
        if (pageId != null && !"".equals(pageId)) {
            pageData = pagePersistence.retrieve(pageId);
        }
        /* 查询 page使用模板表 */
        String p_t_hql = "from PageTemplateData pt where pt.pageId = ?";
        List<PageTemplateData> pageTemplateDatas = pageTemplatePersistence.search(p_t_hql, new Object[] { pageId });
        if (pageId != null && !"".equals(pageId)) {
            if (pageTemplateDatas != null && pageTemplateDatas.size() > 0) {
                for (int i = 0; i < pageTemplateDatas.size(); i++) {
                    pageTemplateData = pageTemplateDatas.get(0);
                }
            } else {
                pageTemplateData = new PageTemplateData();
            }
        }
        /* 查询pageinfo扩张表 */
        List<PageInfoExtraData> pageInfoExtraDatas = null;
        String hql = "from PageInfoExtraData pi where pi.pageId = ?";
        if (pageId != null && !"".equals(pageId)) {
            pageInfoExtraDatas = pageInfoExtraPersistence.search(hql, new Object[] { pageId });
        } else {
            pageInfoExtraDatas = new ArrayList<PageInfoExtraData>();
        }
        /* 查询模板表 */
        if (pageTemplateData.getTemplateId() != null && !"".equals(pageTemplateData.getTemplateId())) {
            templateData = tempManagePersistence.retrieve(pageTemplateData.getTemplateId());
        } else {
            templateData = new TemplateData();
        }
        /* 查询用户表 */
        if (pageData.getUserId() != null && !"".equals(pageData.getUserId())) {
            userData = userPersistence.retrieve(pageData.getUserId());
        }
        /* 查询page使用权限表 */
        /* page使用服务中间表 */
        if (pageData.getId() != null && !"".equals(pageData.getId())) {
            String pr_hql = "from PrivilegeData pr where pr.pageId = ?";
            privilegeDatas = privilegePersistence.search(pr_hql, new Object[] { pageData.getId() });
            String pagePhql = "from  PageProductData pa where pa.pageId= ?";
            pageProductDatas = pageProductPersistence.search(pagePhql, new Object[] { pageData.getId() });
        }

        pageTemplateData.setTemplateData(templateData); // 把查询出来的模板实体赋值到pageTemplateData实体类中
        pageData.setPageTemplateData(pageTemplateData); // 把查询出来的page使用模板表表赋值到page实体类中
        pageData.setUserData(userData); // 把查询出来的用户实体赋值到page实体类中

        if (pageInfoExtraDatas != null && pageInfoExtraDatas.size() > 0) {
            pageData.setPageInfoExtraData(pageInfoExtraDatas); // 把查询出来的page扩展表赋值到page实体类中
        }
        if (privilegeDatas != null && privilegeDatas.size() > 0) {
            pageData.setPrivilegeDatas(privilegeDatas); // 把查询出来的privilegeData集合赋值到page实体类中
        }
        if (pageProductDatas != null && pageProductDatas.size() > 0) {
            pageData.setPageProductDatas(pageProductDatas); // 把查询出来的page服务集合集合赋值到page实体类中
        }
        return pageData;
    }

    /**
     * 后台查询 page管理 分页
     * 
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll 分页
     * @param helpData page实体类
     * @return
     */
    public List<PageData> getAllPageList(PageRoll pageRoll, PageHelpData helpData) {
        List<PageData> list = new ArrayList<PageData>(); // page集合
        UserData userData = null; // 用户对象
        List<PageInfoExtraData> pageInfoExtraDatas = new ArrayList<PageInfoExtraData>(); // 域名集合
        /* 查询page */
        StringBuffer sqlStr = new StringBuffer("from PageData page where page.isDelete=1 ");
        List<Object> objects = new ArrayList<Object>();

        sqlStr.append(" order by page.createTime"); // 按创建时间排序
        // 定义统计查询所有模板的hql语句
        String countHqlpage = "select count(*) " + sqlStr.toString();
        // 给分页参数赋值
        pageRoll.setCountSQL(countHqlpage);
        pageRoll.setSearchSQL(sqlStr.toString());
        List<PageData> lists = pagePersistence.search(pageRoll, objects).getList();
        for (int i = 0; i < lists.size(); i++) {
            PageData data = lists.get(i);
            /* 如果用户的userId不为空，就查询出user对象 */
            if (data.getUserId() != null && !"".equals(data.getUserId())) {
                userData = userPersistence.retrieve(data.getUserId());
            } else {
                userData = new UserData();
            }
            /* 如果pageid 不为空 查询出域名集合 */
            if (data.getUserId() != null && !"".equals(data.getUserId())) {
                String pageInfoHql = "from PageInfoExtraData pf where pf.pageId = ?";
                pageInfoExtraDatas = pageInfoExtraPersistence.search(pageInfoHql, new Object[] { data.getId() });
            }
            data.setUserData(userData);
            data.setPageInfoExtraData(pageInfoExtraDatas);
            list.add(data);
        }

        return list;
    }

    @Override
    public List<String> findNoPayProductDataByPage(String[] str) {
        return pagePersistence.findNoPayProductDataByPage(str);
    }

    @Override
    public List<String> findNoPayProductDataByOrderAndPage(String[] str) {
        return pagePersistence.findNoPayProductDataByOrderAndPage(str);
    }

    /**
     * 
     * 更具page主键和服务主键 查询 此page购买的此款服务时够已经付款<br>
     * 
     * @author Administrator <br>
     *         2014-4-24
     * @update
     * @param String pageId page主键 String productId 服务主键
     * @return boolean 未付款 返回true 已经出款 返回false
     */
    public boolean findNoPayStateByPageIDAndProudctID(String pageId, String productId) {
        return pagePersistence.findNoPayStateByPageIDAndProudctID(pageId, productId);
    }

    /**
     * 删除多条page数据 假删
     * 
     * @author 侯杨
     * @date 2014-5-20
     * @param id
     * @return
     */
    public String deletePageData(String id) {
        String mes = "0";
        try {
            PageData data = null; // page实体
            // 如果id不为空，查询出page实体
            if (id != null && !"".equals(id)) {
                data = pagePersistence.retrieve(id);
            }
            data.setIsDelete(0); // 假删
            pagePersistence.update(data); // 修改page信息
            mes = "1";
        } catch (Exception e) {
            mes = "0";
        }
        return mes;
    }
    /**
     * 
     *查询page实体<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月22日
     * @update 
     * @param id  pageId
     * @return  pagedata  page实体
     * @see   IPageBusiness#getPageDateById(data)
     * @since vmaque 2.0
     */

    @Override
    public PageData getPageDateById(String  id) {
         return pagePersistence.retrieve(id);
    }
}
