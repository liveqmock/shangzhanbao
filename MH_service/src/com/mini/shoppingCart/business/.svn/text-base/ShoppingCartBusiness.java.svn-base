package com.mini.shoppingCart.business;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.CTNProductUtil;
import com.common.util.DateUtil;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.give.data.GiveData;
import com.mini.page.data.PageData;
import com.mini.product.data.PageProductData;
import com.mini.product.data.ProductData;
import com.mini.product.persistence.IPageProductPersistence;
import com.mini.product.persistence.IProductPersistence;
import com.mini.shoppingCart.data.ShoppingCartData;
import com.mini.shoppingCart.persistence.IShoppingCartPersistence;

/**
 * 〈购物车Business 实现类〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("shoppingCartBusiness")
public class ShoppingCartBusiness extends FrmBusiness implements IShoppingCartBusiness {
    @Resource(name = "shoppingCartPersistence")
    private IShoppingCartPersistence shoppingCartPersistence;
    @Resource(name = "productPersistence")
    private IProductPersistence productPersistence;

    @Resource(name = "pageProductPersistence")
    private IPageProductPersistence pageProductPersistence;

    /**
     * 购物车数据添加
     * 
     * @update 文东 当需要收费的服务加入购物车是。
     *          这款服务应该加入到pageproduct中间表中、
     *          且初始化的isdelete应该为1、status字段应该为空表示该服务处于未付款状态
     *          
     * @author 侯杨
     * @date 2014-4-08
     * @param date
     */
    @Override
    public String addShoppingCartData(ShoppingCartData data, String name) {
        String mes = "0";
        try {
            // 根据pageid查询数据
            String hql = "from ShoppingCartData s where s.pageId = '" + data.getPageId() + "' and s.productId = '"
                    + data.getProductId() + "' ";
            List<ShoppingCartData> list = shoppingCartPersistence.search(hql);
            if (list.size() == 0) { // 如果购物车中存在，不做任何操作，不存在 添加
                shoppingCartPersistence.add(data);
            }
            // 根据pageid查询数据
            String hqlp = "from PageProductData s where s.pageId = '" + data.getPageId() + "' and s.productId = '"
                    + data.getProductId() + "' ";
            List<PageProductData> listp = pageProductPersistence.search(hqlp);
            if (listp.size() == 0) { // 如果服务中间表中存在，不做任何操作，不存在添加
                // 添加pageproduct中间表数据
                PageProductData pageProductData = new PageProductData();
                pageProductData.setPageId(data.getPageId().trim());
                pageProductData.setProductId(data.getProductId().trim());
                pageProductData.setYeraNum(1);
                // 修改  文东
                pageProductData.setIsdelete(1);
                pageProductData.setCreateTime(new Date());
                pageProductData.setProductName(name);
                pageProductPersistence.add(pageProductData);
            }

            mes = "1";
        } catch (Exception e) {
            mes = "0";
        }
        return mes;
    }

    /**
     * 根据用户id 查询 当前用户的购物车信息
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param userId
     * @return
     */
    @Override
    public List<PageData> getAll(String userId) {

        return productPersistence.getShoppingCartData(userId);
    }

    /**
     * 根据用户id 查询 当前用户的购物车数量
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param userId
     * @return
     */
    @Override
    public int getCount(String userId) {
        
        /**
         * 修改人：文东
         * 修改日期: 2014/12/17
         * 修改原因: 优化查询
         */
        // 定义统计查询用户购物车的商品数量        
        String sql = "select COUNT(*) as num from MINI_SHOPPINGCART t,MINI_PAGE p where t.userId = ? and t.isDelete = 1 and t.price is null and p.id=t.pageid and p.isDelete = 1";
        // 查询购物车中是否存在发布权限
        String sql2 = "select COUNT(*) as num from MINI_SHOPPINGCART t where t.userId = ? and t.isDelete =1 and t.pageId is null";
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> resultSet = dao.queryForList(sql, new Object[] { userId });
        List<ETIPResultSet> resultSet2 = dao.queryForList(sql2, new Object[] { userId });
        int num2 = resultSet2.get(0).getInt("NUM");
        int num = resultSet.get(0).getInt("NUM")+num2;
        return num;
//        String hql = "from ShoppingCartData t,PageData page "
//                + " where t.userId = ? and t.isDelete = 1 and t.price is  null and"
//                + "  page.id=t.pageId and page.isDelete =1  ";
//
//        /* 如果 用户id 不为空 查询出数据 */
//        if (userId != null && !"".equals(userId)) {
//            list = shoppingCartPersistence.search(hql, new Object[] { userId });
//        }
//        String hql1 = "from ShoppingCartData t  where t.userId = '" + userId
//                + "' and t.isDelete = 1 and t.pageId is null ";
//        List<ShoppingCartData> list1 = shoppingCartPersistence.search(hql1); // 查询出购物车 pageid为空的数据
//        if (list.size() > 0 && list != null) {
//            if (list1.size() > 0 && list1 != null) {
//
//                return list.size() + 1;
//            } else {
//                return list.size();
//            }
//        } else if (list1.size() > 0 && list1 != null) {
//            return list1.size();
//        } else {
//            return 0;
//        }
    }

    /**
     * 删除数据 真删
     * 
     * @author 侯杨
     * @date 2014-4-08
     * @param userId
     * @return
     */
    @Override
    public String updateShoppingCartData(ShoppingCartData date) {
        String mes = "0";
        try {
            JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
            ShoppingCartData cartData = null;
            if (date != null) {
                // 当pageid为空时 更新为官方发布权限那条数据
                if (date.getPageId() != null && !"".equals(date.getPageId())) {
                    // 根据 pageid 服务id查询出数据
                    String hql = "from ShoppingCartData s where s.pageId = '" + date.getPageId()
                            + "' and s.productId = '" + date.getProductId() + "' ";
                    List<ShoppingCartData> list = shoppingCartPersistence.search(hql);
                    cartData = list.get(0);
                    String deleteSql = "delete MINI_PAGEPRODUCT t  where t.pageid='" + date.getPageId()
                            + "'  and t.productid='" + date.getProductId() + "'";
                    dao.executeSQL(deleteSql);
                } else {
                    // 根据 pageid 服务id查询出数据
                    String hql = "from ShoppingCartData s where  s.productId = '" + date.getProductId() + "' ";
                    List<ShoppingCartData> list = shoppingCartPersistence.search(hql);
                    cartData = list.get(0);
                }
            }
            String sql = "delete MINI_SHOPPINGCART t  where t.id= '" + cartData.getId() + "'"; // 根据购物车信息id来修改
                                                                                                               // 操作删除
            dao.executeSQL(sql);
            mes = "1";
        } catch (Exception e) {
            mes = "0";
        }
        return mes;

    }

    /**
     * 
     * 发布page时 如果有未付款的服务，则处理此服务未正常状态<br>
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param String pageID,String noPayProductId
     */
    public void editNoPayProductState(String pageID, String noPayProductId) {
        shoppingCartPersistence.editNoPayProductState(pageID, noPayProductId);
    }

    /**
     * 购买发布权限 添加数据 如果存在就修改
     * 
     * @author 侯杨
     * @date 2014-04-09
     * @param date
     * @return
     */
    @Override
    public List<ProductData> updateSaveShoppingCartData(String userId, String sign) {

        List<ProductData> lists = new ArrayList<ProductData>();
        ProductData productData = new ProductData(); // 服务实体
        ShoppingCartData shoppingCartData = null; // 购物车实体

        // 判断是否是从官方发布权限进来的数据
        if (sign.equals("2")) {
            String p_hql = "from ProductData p where p.sign=1"; // 如果是 查询出 官方发布权限 这款服务
            productData = productPersistence.search(p_hql).get(0);
        }
        // 当 不为空时 先执行查询操作
        if (userId != null && !"".equals(userId) && productData != null && !"".equals(productData)) {
            String hql = "from ShoppingCartData s where s.userId = '" + userId + "' and s.productId = '"
                    + productData.getId() + "' ";
            List<ShoppingCartData> list = shoppingCartPersistence.search(hql);
            // 如果数据 存在 执行更新操作
            if (list != null && list.size() > 0) {

                shoppingCartData = list.get(0);
                if (shoppingCartData.getIsDelete() == 1) { // 如果存在切 isdelete为1 就查询数据
                    productData.setShoppingCartData(shoppingCartData);
                    lists.add(productData);
                } else { // 如果存在isdelete为0 就更新数据 且查询出来
                    JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
                    String sql = "update MINI_SHOPPINGCART t set t.IsDelete=1 where t.id= '" + shoppingCartData.getId()
                            + "'"; // 根据购物车信息id来修改 操作删除
                    dao.executeSQL(sql);
                    productData.setShoppingCartData(shoppingCartData);
                    lists.add(productData);
                }
            } else { // 如果数据不存在 执行 添加操作
                ShoppingCartData da = new ShoppingCartData();
                da.setIsDelete(1);
                da.setProductId(productData.getId());
                da.setNum(1);
                da.setUserId(userId);
                shoppingCartPersistence.add(da);
                shoppingCartData = shoppingCartPersistence.retrieve(da.getId());
                productData.setShoppingCartData(shoppingCartData);
                lists.add(productData);
            }
        }

        return lists;
    }

    /**
     * 根据用户id 查询出 官方发布权限这条数据
     * 
     * @param userId
     * @return
     */
    public List<ProductData> getShoppingCartDataP(String userId) {
        List<ProductData> lists = new ArrayList<ProductData>();
        ShoppingCartData shoppingCartData = null;
        ProductData productData = null;
        // 当 不为空时 先执行查询操作
        if (userId != null && !"".equals(userId)) {
            String hql = "from ShoppingCartData t  where t.userId = '" + userId
                    + "' and t.isDelete = 1 and t.pageId is null ";
            List<ShoppingCartData> list = shoppingCartPersistence.search(hql); // 查询出购物车 pageid为空的数据
            if (list != null && list.size() > 0) {
                shoppingCartData = list.get(0);
            }
            if (shoppingCartData != null) {
                productData = productPersistence.retrieve(shoppingCartData.getProductId()); // 根据购物车信息的服务id 查询出服务实体
            }

            if (productData != null) {
                productData.setShoppingCartData(shoppingCartData);
                lists.add(productData);

            }
        }
        return lists;
    }

    /**
     * 根据用户id 查询出 所有数据
     * 
     * @param userId
     * @return
     */
    public List<ProductData> getShoppingCartData(String userId) {
        List<ProductData> lists = new ArrayList<ProductData>();

        ProductData productData = null;
        // 当 不为空时 先执行查询操作
        if (userId != null && !"".equals(userId)) {
            String hql = "from ShoppingCartData t  where t.userId = '" + userId + "' and t.isDelete = 1";
            List<ShoppingCartData> list = shoppingCartPersistence.search(hql); // 查询出购物车 pageid为空的数据
            if (list != null && list.size() > 0) {
                StringBuffer strbuf = new StringBuffer();
                strbuf.append("[");
                for (int i = 0; i < list.size(); i++) {
                    ShoppingCartData shoppingCartData = list.get(i);
                    String productId = shoppingCartData.getProductId();
                    productData = productPersistence.retrieve(productId); // 根据购物车信息的服务id 查询出服务实体

                    // 如果服务是null 就说明服务在minipage 没有此服务。拼接服务id
                    if (productData == null) {
                        if (list.size() == i + 1) {
                            strbuf.append("{productId:\"" + productId + "\"}");
                        } else {
                            strbuf.append("{productId:\"" + productId + "\"},");
                        }

                    } else {
                        productData.setShoppingCartData(shoppingCartData);
                        lists.add(productData);

                    }
                }
                strbuf.append("]");
                // 根据接口去ctn查询minipage不存在的服务
                List<ProductData> productData2 = null;
                if (!strbuf.toString().equals("[]")) {
                    try {
                        productData2 = CTNProductUtil.getCtnJSON(strbuf.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // list集合不为空 把服务实体set到 集合中
                if (productData2 != null && productData2.size() > 0) {
                    for (int i = 0; i < productData2.size(); i++) {
                        lists.add(productData2.get(i));
                    }
                }

            }

        }

        return lists;
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
        String mes = "0";
        try {
            // 根据pageid查询数据
            String hql = "from PageProductData s where s.pageId = '" + data.getPageId() + "' and s.productId = '" + data.getProductId()
                    + "' ";
            List<PageProductData> list = pageProductPersistence.search(hql);
            if (list.size() == 0) { // 如果服务中间表中存在，不做任何操作,不存在添加
                data.setYeraNum(1);
                data.setIsdelete(1);
                data.setStatus(1);
                data.setCreateTime(new Date());
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
                    data.setExpireTime(format.parse(endtime));// 截至时间;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pageProductPersistence.add(data);
            } else {
                /*
                 * 修改人：文东 
                 * 修改内容：修改由于部分数据没有传递到后台导致数据更新后数据丢失得问题。
                 *          免费服务在更新数据时只需要更新服务内容  
                 * 修改时间：2014／07/30 21:44
                 */
                list.get(0).setProductContent(data.getProductContent());
            	pageProductPersistence.update(list.get(0));
            }
            mes = "1";
        } catch (Exception e) {
            mes = "0";
        }
        return mes;
    }

    /**
     * 根据用户id 查询 购物车信息
     * 
     * @author 侯杨
     * @date 2014-4-12
     * @param userId
     * @return
     */

    public List<ShoppingCartData> getshopp(String userId) {
        List<ShoppingCartData> listt = new ArrayList<ShoppingCartData>();
        String sql = "select t.productId pid from MINI_SHOPPINGCART t,MINI_PAGE page "
                + " where t.userId = ? and t.isDelete = 1 and t.price is  null and"
                + "  page.id=t.pageId and page.isDelete =1  ";
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");

        /* 如果 用户id 不为空 查询出数据 */
        if (userId != null && !"".equals(userId)) {
            List<ETIPResultSet> list = dao.queryForList(sql, new Object[] { userId });
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ShoppingCartData cartData = new ShoppingCartData();
                    cartData.setProductId(list.get(i).getString("PID"));
                    listt.add(cartData);
                }
            }
        }
        return listt;
    }

    @Override
    public void delShopCart(ShoppingCartData cartData) {
        //定义条件查询的语句
        StringBuffer hql = new StringBuffer("from ShoppingCartData where 1=1 and isDelete = 1");
        //定义条件查询参数
        List<Object> objects = new ArrayList<Object>();
        // 拼接条件查询参数
        if(cartData.getPageId()!=null && !cartData.getPageId().equals("")){
            hql.append(" and pageId = ?");
            objects.add(cartData.getPageId());
        }
        if(cartData.getProductId()!=null && !cartData.getProductId().equals("")){
            hql.append(" and productId = ?");
            objects.add(cartData.getProductId());
        }
        if(cartData.getUserId()!=null && !cartData.getUserId().equals("")){
            hql.append(" and userId = ?");
            objects.add(cartData.getUserId());
        }
        // 获取查询结果
        List<ShoppingCartData> cartDatas = shoppingCartPersistence.search(hql.toString(), objects);
        for (int i = 0; i < cartDatas.size(); i++) {
            shoppingCartPersistence.delete(cartDatas.get(i));
        }
    }

}
