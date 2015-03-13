package com.mini.page.persistence;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Repository;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageTemplateData;
import com.mini.tempmanage.data.TemplateData;

/**
 * 后台page管理久化层接口实现类
 * 
 * @author 林海鹏
 * @see PagePersistence
 * @since
 */
@SuppressWarnings("unchecked")
@Repository("pagePersistence")
public class PagePersistence extends BasePersistence<PageData> implements IPagePersistence {
    /**
     * 新增
     */
    @Override
    public void addPage(final PageData pageData) {
        // TODO Auto-generated method stub
        add(pageData);
    }

    /**
     * 删除
     */
    @Override
    public void deletePage(final String[] ids) {
        // TODO Auto-generated method stub
        delete(ids);
    }

    /**
     * 修改
     */
    @Override
    public void editPage(final PageData data) {
        // TODO Auto-generated method stub
        update(data);
    }

    @Override
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json) {
        StringBuffer countSQL = new StringBuffer("SELECT COUNT(o.id)FROM PageData o WHERE 1=1 and o.isDelete=1");
        StringBuffer querySQL = new StringBuffer(" from PageData o where 1=1 and o.isDelete=1");
        String whereSQL = getInquiresTheConditions(json);// 调用与拼接条件

        pageRoll.setCountSQL(countSQL.append(whereSQL).toString());
        pageRoll.setSearchSQL(querySQL.append(whereSQL).append(" ORDER BY o.id desc").toString());
        List<PageData> pageDataList = search(pageRoll);
        return pageDataList;
    }

    /**
     * 分页
     */
    @Override
    public List<Object[]> getAllPageInfo(final PageRoll pageRoll, JSONObject json) {
        String sql = (" from PageData a ,PageInfoExtraData b  where a.id = b.pageId and a.isDelete=1");
        List<Object> objectlist = new ArrayList<Object>();
        StringBuffer sb = new StringBuffer();
        String type = "";
        if (null != json && !json.isNullObject()) {
            if (null != json.get("type")) {
                type = json.getString("type");
                if (!"".equals(type) && null != type) {
                    sb.append(" and  b.type  = ? ");
                    objectlist.add(type);
                }
            }
            if (null != json.get("status")) {// 通过status筛选 为绑定独立域名的记录
                String status = json.getString("status");
                if (!"".equals(status) && null != status) {
                    sb.append(" and  b.status  = ? ");
                    objectlist.add(status);
                }
            }
            sb.append(" and  a.userId  = ? ");
            objectlist.add(FrmUser.getUser().etipUserID);
        }
        sb.append(" order by a.id asc");
        pageRoll.setCountSQL("select count(*) " + sql + sb.toString());
        pageRoll.setSearchSQL(sql + sb.toString());
        return search(pageRoll, objectlist).getList();
    }

    /**
     * PageData PageInfoExtraData连表查询 查询出当前用户下为二级域名 且没有绑定独立域名的记录
     */
    @Override
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json) {
        String sql = (" from PageData a ,PageInfoExtraData b,PageTemplateData t  where a.id = b.pageId and a.isDelete=1 and t.pageId=a.id");
        List<Object> objectlist = new ArrayList<Object>();
        StringBuffer sb = new StringBuffer();
        if (null != json && !json.isNullObject()) {
            if (null != json.get("type")) {// 通过type字段筛选 二级域名 的记录
                String type = json.getString("type");
                if (!"".equals(type) && null != type) {
                    sb.append(" and  b.type  = ? ");
                    objectlist.add(type);
                }
            }
            if (null != json.get("status")) {// 通过status筛选 为绑定独立域名的记录
                String status = json.getString("status");
                if (!"".equals(status) && null != status) {
                    sb.append(" and  b.status  = ? ");
                    objectlist.add(status);
                }
            }
            sb.append(" and  a.userId  = ? ");
            objectlist.add(FrmUser.getUser().etipUserID);
        }
        sb.append(" order by a.id asc");
        pageRoll.setCountSQL("select count(*) " + sql + sb.toString());
        pageRoll.setSearchSQL(sql + sb.toString());
        List<PageData> pageDataList = new ArrayList<PageData>();
        if (search(pageRoll, objectlist) != null) {
            List<Object[]> list = search(pageRoll, objectlist).getList();
            if (list.size() > 0 && null != list) {
                for (int i = 0; i < list.size(); i++) {
                    PageData data = (PageData) list.get(i)[0];
                    PageInfoExtraData pageInfoExtraData = (PageInfoExtraData) list.get(i)[1];
                    pageInfoExtraData.setDomain(pageInfoExtraData.getDomain());
                    data.setPageInfoExtra(pageInfoExtraData);
                    PageTemplateData pageTemplateData=(PageTemplateData)list.get(i)[2];
                    TemplateData templateData=new TemplateData();
                    templateData.setId(pageTemplateData.getTemplateId());
                    data.setTemplateData(templateData);
                    pageDataList.add(data);
                }
            }
        }
        return pageDataList;
    }

    /**
     * 模糊查询
     */
    @Override
    public List<PageData> getPageData(final JSONObject json) {
        StringBuffer querySQL = new StringBuffer("FROM PageData o WHERE 1=1 and o.isDelete=1");
        querySQL.append(this.getInquiresTheConditions(json));// 调用与拼接条件
        return search(querySQL.toString());
    }

    /**
     * 
     * 〈自主拼接查询条件〉<br>
     * 
     * @author linhp <br>
     *         2014-2-17
     * @update 冯鑫 查询page时候 没必要通过用户名过滤
     * @param [obj] [json串]
     * @return [返回拼接完的SQl语句]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    private String getInquiresTheConditions(JSONObject obj) {
        // TODO Auto-generated method stub
        StringBuffer whereSQL = new StringBuffer();
        if (obj != null && !obj.isNullObject()) {
            if (null != obj.get("id")) {
                String id = obj.getString("id");
                if (null != id && !"".equals(id)) {
                    whereSQL.append(" AND o.id = '").append(id).append("'");
                }
            }
        }
        //whereSQL.append(" AND o.userId = '").append(FrmUser.getUser().etipUserID).append("'");
        return whereSQL.toString();
    }

    /**
     * 
     * 根据pageid查询未付款的业务（暂时不使用）
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param JSONObject obj
     * @return List<ProductData>
     */
    public List<String> findNoPayProductDataByPage(String[] str) {
        StringBuffer strbur = new StringBuffer();
        strbur.append("select s.productid  from mini_shoppingcart s where s.isdelete=1 ");
        if(str.length>0){
            strbur.append(" and s.pageid in(");
            for (int i = 0; i < str.length; i++) {
                if(i+1==str.length){
                    strbur.append("'").append(str[i]).append("'");
                }else{
                    strbur.append("'").append(str[i]).append("',");
                }
            }
            strbur.append(")");
        }
        /*if (obj != null && !obj.isNullObject()) {
            if (null != obj.get("id")) {
                String id = obj.getString("id");
                if (null != id && !"".equals(id)) {
                    strbur.append("and s.pageid= '").append(id).append("'");
                }
            }
        }*/
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> list = dao.queryForList(strbur.toString(), null);
        // [{PRODUCTID=40289e3c436fcf270143702302d100f1}]
        if (list.size() > 0) {
            List<String> list_str = new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                list_str.add(list.get(i).getString("PRODUCTID"));
            }
            return list_str;
        } else {
            return new ArrayList<String>();
        }
    }

    /**
     * 
     * 根据pageid关联order表查询未付款业务（暂时不使用）
     * 
     * @author 冯鑫 <br>
     *         2014-4-9
     * @update
     * @param JSONObject obj
     * @return List<ProductData>
     */
    public List<String> findNoPayProductDataByOrderAndPage(String[] str) {
        StringBuffer strbur = new StringBuffer();
        strbur.append("select distinct t.productid from MINI_ORDER_PRODUCT t,MINI_ORDER o  WHERE t.orderid=o.id and o.state in(0,1) ");
       if(str.length>0){
           strbur.append(" and t.pageid in(");
           for (int i = 0; i < str.length; i++) {
               if(i+1==str.length){
                   strbur.append("'").append(str[i]).append("'");
               }else{
                   strbur.append("'").append(str[i]).append("',");
               }
           
           }
           strbur.append(")");
       }
       /* if (obj != null && !obj.isNullObject()) {
            if (null != obj.get("id")) {
                String id = obj.getString("id");
                if (null != id && !"".equals(id)) {
                    strbur.append("and t.pageid= '").append(id).append("'");
                    // strbur.append("and t.pageid= '8ae580f345453520014545517f7a0007'");
                }
            }
        }*/
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        List<ETIPResultSet> list = dao.queryForList(strbur.toString(), null);
        // [{PRODUCTID=40289e3c436fcf270143702302d100f1}]
        if (list.size() > 0) {
            List<String> list_str = new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                list_str.add(list.get(i).getString("PRODUCTID"));
            }
            return list_str;
        } else {
            return new ArrayList<String>();
        }
    }
    /**
     * 
     * 更具page主键和服务主键 查询 此page购买的此款服务时够已经付款<br>
     * 
     * @author Administrator <br> 
     *		   2014-4-24
     * @update 
     * @param String pageId page主键
     *          String productId 服务主键
     * @return  boolean  未付款 返回true  已经出款 返回false
     */
    public boolean findNoPayStateByPageIDAndProudctID(String pageId,String productId){
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        String orderStr = "select t.id from MINI_ORDER_PRODUCT t ,MINI_ORDER o where t.orderid=o.id and o.state in(0,1) " +
        		            "and t.pageid='"+pageId+"' and t.productid='"+productId+"'";
        String shoppingCarStr  = "select t.id from MINI_SHOPPINGCART t where t.isdelete=1 " +
        		                    "and t.pageid='"+pageId+"' and t.productid='"+productId+"'";
        List<ETIPResultSet> list = dao.queryForList(orderStr.toString(), null);
        if(list.size()>0){
            return true;
        }else{
            List<ETIPResultSet> list1 = dao.queryForList(shoppingCarStr.toString(), null);
            if(list1.size()>0){
                return true;
            }else{
                return false;
            }
        }
    } 

}
