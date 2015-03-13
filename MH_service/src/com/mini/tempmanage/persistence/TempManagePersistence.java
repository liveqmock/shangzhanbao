package com.mini.tempmanage.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.data.PageTemplateData;
import com.mini.page.persistence.IPageTemplatePersistence;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.data.UserOwnTempData;

/**
 * 模板管理持久化层接口实现类
 * 
 * @author 文东
 * @see TempManagePersistence
 * @since
 */
@Component("tempManagePersistence")
public class TempManagePersistence extends BasePersistence<TemplateData> implements ITempManagePersistence {
    // page使用模板持久化层接口 容器注入
    @Resource(name = "pageTemplatePersistence")
    private IPageTemplatePersistence pageTemplatePersistence;

    @Override
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId) {
        // 用来存储查询到的用户所拥有的模板集合
        List<TemplateData> templateDatas = new ArrayList<TemplateData>();
        // 参数存放
        List<Object> objects = new ArrayList<Object>();
        // hql查询语句
        StringBuffer hql = new StringBuffer(
                "select * from (select mubanpage.price,mubanpage.name,mubanpage.content"
                        + ",mubanpage.expiretime,mubanpage.owntime,mubanpage.id,mubanpage.imgpath,d.domain,mubanpage.page_id,mubanpage.pageName,mubanpage.pageStatus "
                        + "from (select gs.price,gs.name,gs.content,gs.templateid,"
                        + "gs.expiretime,gs.owntime,gs.id,gs.imgpath,gs.page_id,ge.name as pageName,ge.status as pageStatus from (select muban.price,muban.name,muban.content,muban.templateid,"
                        + "muban.expiretime,muban.owntime,muban.id,muban.imgpath,c.page_id from (select b.content,b.templateid,"
                        + "usertemp.name,usertemp.price,usertemp.expiretime,usertemp.owntime,usertemp.id,usertemp.imgpath "
                        + "from (select a.id,a.name,a.imgpath,e.tempid, e.expiretime,e.owntime, a.price from mini_userowntemp e "
                        + "left join mini_template a on e.tempid = a.id where e.userid = ?) usertemp "
                        + "inner join mini_template_thumbnail b on usertemp.tempid = b.templateid where b.type = 'main') "
                        + "muban left join mini_page_template c on muban.templateid = c.template_id) gs,mini_page ge where ge.id = gs.page_id and ge.isdelete=1 and ge.user_id=?) mubanpage left join mini_page_info_extra d "
                        + "on mubanpage.page_id = d.page_id and d.status='OPEN') mjk where 1=1");
        objects.add(userId);
        objects.add(userId);
        if (templateData != null) {
            // 查询已经过期的模板
            if(templateData.getEsc()!=null && !"".equals(templateData.getEsc()) && "limit".equals(templateData.getEsc())){
                hql.append("and mjk.expiretime < sysdate and mjk.expiretime is not null");
            }
            // 查询可用模板
            if(templateData.getEsc()==null || "".equals(templateData.getEsc())){
                hql.append("and mjk.expiretime >= sysdate or mjk.expiretime is null");
            }
        }
        hql.append(" order by mjk.owntime desc");
        pageRoll.setSearchSQL(hql.toString());
        pageRoll.setCountSQL("select count(*) from (" + hql.toString() + ")");
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.search(pageRoll, objects);
        for (int i = 0; i < rsList.size(); i++) {
            // 实例化一个新的模板 并给对象赋值
            TemplateData data = new TemplateData();
            UserOwnTempData userOwnTempData = new UserOwnTempData();
            PageHelpData helpData=new PageHelpData();
            data.setOwnTempData(userOwnTempData);
            Date date = rsList.get(i).getDate("EXPIRETIME");
            data.setPrice(rsList.get(i).getString("PRICE"));
            data.setName(rsList.get(i).getString("NAME"));
            data.setId(rsList.get(i).getString("ID"));
            data.setDomain(rsList.get(i).getString("DOMAIN"));
            data.setOwnTime(rsList.get(i).getDate("OWNTIME"));
            data.setExpireTime(rsList.get(i).getDate("EXPIRETIME"));
            data.setImgpath(rsList.get(i).getString("IMGPATH"));
            data.setPageId(rsList.get(i).getString("PAGE_ID"));
            helpData.setPageName(rsList.get(i).getString("PAGENAME"));
            helpData.setPageState(rsList.get(i).getString("PAGESTATUS"));
            data.setPageHelpData(helpData);
            Long ms = null;
            try {
                // 将时间转换成毫秒数
                ms = this.formatTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            data.getOwnTempData().setExpireTimeMs(ms);
            templateDatas.add(data);
        }
        return templateDatas;
    }

    /**
     * 
     * 获取毫秒数<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param date 时间
     * @return millionSeconds 毫秒数
     * @exception/throws ParseException 强制转换异常
     * @see TempManagePersistence#formatTime(Date)
     * @since
     */
    private Long formatTime(Date date) throws ParseException {
        long millionSeconds = 0;
        if (date != null) {
            String dateStr = new SimpleDateFormat("yyyyMMddhhmmss").format(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
            millionSeconds = sdf.parse(dateStr).getTime();// 毫秒
        }
        return millionSeconds;
    }

    @Override
    public List<TemplateData> searchRecommend(String userId) {
        // 用来存储查询到的用户所拥有的模板集合
        List<TemplateData> recommendTemplates = new ArrayList<TemplateData>();
        // hql查询语句
        String hql = "from TemplateData te where te.id not in (select te.id from UserOwnTempData tp,TemplateData te where tp.tempId=te.id and tp.userId = ?) and te.status='OPEN' and te.isDelete=1 order by te.uploadingName desc";
        // 定义参数集合
        List<Object> objects = new ArrayList<Object>();
        objects.add(userId);
        recommendTemplates = this.search(hql, objects);
        // 推荐4个最新模板
        if (recommendTemplates.size() > 4) {
            recommendTemplates.clear();
            for (int i = 0; i < recommendTemplates.size(); i++) {
                TemplateData templateData = new TemplateData();
                recommendTemplates.add(templateData);
            }
        }
        return recommendTemplates;
    }

    @Override
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData) {
        // 用来存储查询到的所有模板集合
        List<TemplateData> templateDatas = new ArrayList<TemplateData>();
        // 存放查询参数的List集合
        List<Object> objects = new ArrayList<Object>();
        // 定义hql查询所有模板
        StringBuffer hqlTemp = new StringBuffer(
                "from TemplateData t,TemplateThumbnailData th where t.id=th.templateId and t.isDelete = 1 and th.type='main'");
        if (templateData != null) {
            // 模板状态
            if (!"".equals(templateData.getStatus()) && templateData.getStatus() != null) {
                hqlTemp.append("  and t.status=?");
                objects.add(templateData.getStatus());
            }
            if ("new".equals(templateData.getEsc())) {
                hqlTemp.append(" order by t.createTime desc");
            }
            if ("all".equals(templateData.getEsc())) {
                hqlTemp.append(" order by t.createTime asc");
            }
            // 模板编号
            if (!"".equals(templateData.getSn()) && templateData.getSn() != null) {
                hqlTemp.append("  and t.sn like ?");
                objects.add("%" + templateData.getSn() + "%");
            }
            // 上传人
            if (!"".equals(templateData.getUploadingName()) && templateData.getUploadingName() != null) {
                hqlTemp.append("  and t.uploadingName like ?");
                objects.add("%" + templateData.getUploadingName() + "%");
            }
            // 上传开始时间 用openTime代替
            if (templateData.getOpenTime() != null) {
                hqlTemp.append("  and t.uploadingTime >=?");
                objects.add(templateData.getOpenTime());
            }
            // 上传结束时间 用closeTime代替
            if (templateData.getCloseTime() != null) {
                hqlTemp.append("  and t.uploadingTime <=?");
                objects.add(templateData.getCloseTime());
            }
            if (templateData.getUploadingTime() != null) {
                hqlTemp.append(" and order by t.uploadingTime desc");
            }
           
        }

        // 定义统计查询所有模板的hql语句
        String countHqlTemp = "select count(*) " + hqlTemp.toString();
        // 给分页参数赋值
        pageRoll.setCountSQL(countHqlTemp);
        pageRoll.setSearchSQL(hqlTemp.toString());
        List<Object[]> list = search(pageRoll, objects).getList();
        List<PageTemplateData> pageTemplateDatas = null; // 帮组实体集合
        List<PageData> pageList = new ArrayList<PageData>(); // page实体集合
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        for (int i = 0; i < list.size(); i++) {
            PageHelpData pageHelpData = new PageHelpData();
            // 获取模板PC图片
            TemplateThumbnailData thumbnailData = (TemplateThumbnailData) list.get(i)[1];
            // 获取模板
            TemplateData data = (TemplateData) list.get(i)[0];
            data.setThumbnailData(thumbnailData);
            if (data.getId() != null && !"".equals(data.getId())) {
                String hql = "from PageTemplateData pt where pt.templateId = ?"; // 根据模板主键查询
                pageTemplateDatas = pageTemplatePersistence.search(hql, new Object[] { data.getId() });
            }
            /* 创建page总数 */
            String sqlCount = "select count(*) sums  from mini_page_template p,mini_page page  where p.page_id=page.id and p.template_id= ? and page.isdelete= 1 ";

            List<ETIPResultSet> resultSet = dao.queryForList(sqlCount.toString(), new Object[] { data.getId() });
            if (resultSet != null && resultSet.size() > 0) {
                for (int j = 0; j < resultSet.size(); j++) {
                    ETIPResultSet rs = resultSet.get(j);
                    pageHelpData.setTempPagecount(rs.getInt("SUMS"));
                }
            }
            /* 正在使用page总数 */
            String sql_openCount = "select count(*) sums  from mini_page_template p,mini_page page  where p.page_id=page.id and p.template_id= ? and page.isdelete= 1 and page.status = 1";

            List<ETIPResultSet> resultSetOpen = dao.queryForList(sql_openCount.toString(),
                    new Object[] { data.getId() });
            if (resultSetOpen != null && resultSetOpen.size() > 0) {
                for (int z = 0; z < resultSetOpen.size(); z++) {
                    ETIPResultSet rs = resultSetOpen.get(z);
                    pageHelpData.setTempPageOpenCount(rs.getInt("SUMS"));
                }
            }
            data.setPageTemplateDatas(pageTemplateDatas);
            data.setPageDatas(pageList);
            data.setPageHelpData(pageHelpData);
            templateDatas.add(data);
        }
        return templateDatas;
    }

    @Override
    public List<TemplateData> searchSn(String tempSn) {
        // 定义查询hql语句
        String hql = "from TemplateData where isDelete=1 and sn=?";
        // 根据模板编码查询模板
        List<TemplateData> datas = search(hql, new Object[] { tempSn });
        return datas;
    }

    @Override
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData) {
        List<Object> objects = new ArrayList<Object>();// 定义一个Object类型的数据用以存放参数
        // 定义查询sql语句
        String sql = "select a.* from mini_template a,"
                + "(select m.id from mini_template m left join mini_page_template pt on m.id = pt.template_id group by m.id order by count(m.id) desc) x "
                + "where a.id=x.id and a.isdelete = 1 and a.status='OPEN'";
        pageRoll.setSearchSQL(sql);
        pageRoll.setCountSQL("select count(*) from (" + sql + ")");
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> resultSet = jdbcDao.search(pageRoll, objects);
        // 定义模板对象集合
        List<TemplateData> templateDatas = new ArrayList<TemplateData>();
        // 循环取出查询的结果 并添加到模板集合中
        for (int i = 0; i < resultSet.size(); i++) {
            // 实例化一个新的模板 并给对象赋值
            TemplateData data = new TemplateData();
            data.setId(resultSet.get(i).getString("ID"));
            data.setCatalog(resultSet.get(i).getString("CATALOG"));
            data.setCloseTime(resultSet.get(i).getDate("CLOSETIME"));
            data.setCreateTime(resultSet.get(i).getDate("CREATETIME"));
            data.setCreator(resultSet.get(i).getString("CREATOR"));
            data.setMemo(resultSet.get(i).getString("MEMO"));
            data.setName(resultSet.get(i).getString("NAME"));
            data.setOpenTime(resultSet.get(i).getDate("OPENTIME"));
            data.setSn(resultSet.get(i).getString("SN"));
            data.setStatus(resultSet.get(i).getString("STATUS"));
            templateDatas.add(data);
        }
        return templateDatas;
    }

    @Override
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData, String Type, int sort) {
        StringBuffer sqlStr = new StringBuffer(
                "select tem.*,coalesce(sumCount.pcount,0) as pcount,coalesce(sumOpenCount.Openpcount,0) as Openpcount  from mini_template tem"
                        + " left join("
                        + "select p.template_id as temId, count(p.page_id) as pcount"
                        + " from mini_page_template p,mini_page page  where p.page_id=page.id  and page.isdelete= 1  group by p.template_id)  sumCount"
                        + "  on "
                        + "sumCount.temId = tem.id"
                        + " left join("
                        + "select p.template_id as temId, count(p.page_id) as Openpcount"
                        + " from mini_page_template p,mini_page page  where p.page_id=page.id  and page.isdelete= 1 and page.status='1' group by p.template_id)  sumOpenCount"
                        + "  on " + "sumOpenCount.temId = tem.id" + " where   tem.isdelete=1");

        List<Object> objects = new ArrayList<Object>();

        if (templateData != null) {
            // 模板状态 开启
            if ("2".equals(templateData.getStatus())) {
                sqlStr.append("  and tem.status like '%OPEN%'");

            }
            // 模板状态 关闭
            if ("3".equals(templateData.getStatus())) {
                sqlStr.append("  and tem.status like '%CLOSED%'");

            }
            // 模板编号
            if (!"".equals(templateData.getSn()) && templateData.getSn() != null) {
                sqlStr.append("  and tem.sn like ?");
                objects.add("%" + templateData.getSn() + "%");
            }
            // 上传人
            if (!"".equals(templateData.getUploadingName()) && templateData.getUploadingName() != null) {
                sqlStr.append("  and tem.uploadingName like ?");
                objects.add("%" + templateData.getUploadingName() + "%");
            }
            // 上传开始时间 用openTime代替
            if (templateData.getOpenTime() != null) {
                sqlStr.append("  and tem.uploadingTime >=?");
                objects.add(templateData.getOpenTime());
            }
            // 上传结束时间 用closeTime代替
            if (templateData.getCloseTime() != null) {
                sqlStr.append("  and tem.uploadingTime <=?");
                objects.add(templateData.getCloseTime());
            }
        }
        if (Type != null && !"".equals(Type)) {
            if (Type.equals("pcount")) {
                sqlStr.append("order by pcount ");
            }
            if (Type.equals("Openpcount")) {
                sqlStr.append("order by Openpcount ");
            }
            if (Type.equals("uploadingtime")) {
                sqlStr.append("order by tem.uploadingtime ");
            }
            if(sort==0){
                sqlStr.append("desc");
            }
        }
        /*
         * sqlStr.append (" order by page.create_time"); //按创建时间排序
         */JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询

        pageRoll.setSearchSQL(sqlStr.toString());
        pageRoll.setCountSQL("select count(*) from (" + sqlStr + ")");
        List<ETIPResultSet> resultSet = dao.search(pageRoll, objects);// 分页查询
        List<TemplateHelpData> tem = new ArrayList<TemplateHelpData>();

        if (resultSet != null && resultSet.size() > 0) {
            for (int i = 0; i < resultSet.size(); i++) {
                ETIPResultSet rs = resultSet.get(i);
                TemplateHelpData data = new TemplateHelpData();
                data.setId(rs.getString("ID"));
                data.setSn(rs.getString("SN"));
                data.setName(rs.getString("NAME"));
                data.setStatus(rs.getString("STATUS"));
                data.setUploadingName(rs.getString("UPLOADINGNAME"));
                data.setUploadingTime(rs.getDate("UPLOADINGTIME"));
                data.setSumTemp(rs.getInt("PCOUNT"));
                data.setSumOpenTemp(rs.getInt("OPENPCOUNT"));
                tem.add(data);
            }
        }
        return tem;
    }

    @Override
    public List<TemplateData> searchTemplateData(JSONObject json) {
        StringBuffer querySQL = new StringBuffer(" From TemplateData bd where 1=1");
        querySQL.append(this.getInquiresTheConditions(json));
        return search(querySQL.toString());
    }

    /**
     * 自主拼接条件
     * 
     * @param json
     * @return
     */
    private String getInquiresTheConditions(JSONObject json) {
        StringBuffer whereSQL = new StringBuffer();
        if (json != null && !json.isNullObject()) {
            if (null != json.get("id")) {
                String id = json.getString("id");
                if (id != null && !"".equals(id))
                    whereSQL.append(" AND bd.id = '").append(id).append("'");
            }
        }
        return whereSQL.toString();
    }
}
