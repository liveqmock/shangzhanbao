package com.mini.domain.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;

/**
 * 域名管理持久化层接口实现类
 * 
 * @author 林海鹏
 * @see PageInfoExtraPersistence
 * @since
 */
@SuppressWarnings("unchecked")
@Repository("pageInfoExtraPersistence")
public class PageInfoExtraPersistence extends BasePersistence<PageInfoExtraData> implements IPageInfoExtraPersistence {
    /**
     * 新增
     */
    @Override
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        // 若Id 已经存在 则执行更新操作 若 Id不存在则执行添加操作
        if (pageInfoExtraData.getId() == "" || pageInfoExtraData.getId() == null) {
       	
            add(pageInfoExtraData);
        } else {
            update(pageInfoExtraData);
        }
    }

    /**
     * 删除
     */
    @Override
    public void deletePageInfoExtra(String[] ids) {
        delete(ids);
    }

    /**
     * 修改
     */
    @Override
    public void editPageInfoExtra(PageInfoExtraData data) {
        update(data);
    }

    /**
     * 分页
     */
    @Override
    public List<PageInfoExtraData> getAllPageInfoExtraInfo(final PageRoll pageRoll, final JSONObject json) {
        String sql = (" from PageData a ,PageInfoExtraData b  where a.id = b.pageId");
        List<Object> objectlist = new ArrayList<Object>();
        StringBuffer sb = new StringBuffer();
        if (null != json && !json.isNullObject()) {
            if (null != json.get("userId")) {
                String userId = json.getString("userId");
                if (!"".equals(userId) && null != userId) {
                    sb.append(" and AND a.user_id  = ? ");
                    objectlist.add("%" + userId + "%");
                }
            }
        }
        pageRoll.setCountSQL("select count(*) " + sql + sb.toString());
        pageRoll.setSearchSQL(sql + sb.toString());
        List<Object[]> list = search(pageRoll, objectlist).getList();
        List<PageInfoExtraData> pageInfoExtraDataList = new ArrayList<PageInfoExtraData>();
        for (int i = 0; i < list.size(); i++) {
            PageInfoExtraData data = (PageInfoExtraData) list.get(i)[0];
            pageInfoExtraDataList.add(data);
        }
        return pageInfoExtraDataList;
    }

    /**
     * 模糊查询
     */
    @Override
    public List<PageInfoExtraData> getPageInfoExtraData(JSONObject json) {
        StringBuffer querySQL = new StringBuffer("FROM PageInfoExtraData o WHERE 1=1");
        querySQL.append(this.getInquiresTheConditions(json));// 调用与拼接条件
        return search(querySQL.toString());
    }

    /**
     * 
     * 〈自主拼接查询条件〉<br>
     * 
     * @author linhp <br>
     *         2014-2-17
     * @update
     * @param [obj] [json串]
     * @return [返回拼接完的SQl语句]
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    private String getInquiresTheConditions(JSONObject obj) {
        StringBuffer whereSQL = new StringBuffer();
        if (obj != null && !obj.isNullObject()) {
            if (null != obj.get("id")) {//主键
                String id = obj.getString("id");
                if (null != id && !"".equals(id)) {
                    whereSQL.append(" AND o.id = '").append(id).append("'");
                }
            }
            if (null != obj.get("domain")) {//域名
                String domain = obj.getString("domain");
                if (null != domain && !"".equals(domain)) {
                    whereSQL.append(" AND o.domain = '").append(domain).append("'");
                }
            }
            if (null != obj.get("pageid")) {//pageid
            	String pageid = obj.getString("pageid");
            	if (null != pageid && !"".equals(pageid)) {
            		whereSQL.append(" AND o.page_id = '").append(pageid).append("'");
            	}
            }
            if (null != obj.get("status")) {//域名状态，即是否启用
            	String status = obj.getString("status");
            	if (null != status && !"".equals(status)) {
            		whereSQL.append(" AND o.status = '").append(status).append("'");
            	}
            }
        }
        return whereSQL.toString();
    }

    @Override
    public PageInfoExtraData searchByPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        // 定义HQL查询语句
        String hql = "from PageInfoExtraData where 1=1 and pageId = ?  and type = ?";
        // 获取查询结果
        List<PageInfoExtraData> datas = this.search(hql, new Object[] { pageInfoExtraData.getPageId(),
                pageInfoExtraData.getType() });
        // 若查询得到的List集合有值 则返回第一个对象
        if (datas.size() > 0) {
            return datas.get(0);
        } else {
            return null;
        }
    }
    /**
     * 连表查询page名称，域名
     * 
     */
	@Override
	public Map<String, String> getPageInfoExtra(JSONObject json) {
		Map<String,String> map = new HashMap<String, String>();
		StringBuffer querySQL = new StringBuffer("select bd.name,o.domain from mini_page bd, mini_page_info_extra o where  bd.id = o.page_id ");
		querySQL.append(this.getInquiresTheConditions(json));
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list = dao.queryForList(querySQL.toString(), null);
		for (int i = 0; i < list.size(); i++) {
			map.put("name", list.get(i).getString("NAME"));
			map.put("domain", list.get(i).getString("DOMAIN"));
		}
		return map;
	}
	
	/**
     * 
     * 根据用户id查询page域名信息
     * 
     * @author 左香勇
     *         2014年11月28日
     * @update 
     * @param userId     登录用户id
     * @return  已发布的page域名信息
     * @see   PageInfoExtraPersistence#getPageInfoExtraDatasByUserId(String)
     * @since vmaque 2.0
     */
    public List<PageInfoExtraData> getPageInfoExtraDatasByUserId(String userId){
        String sql = "select t.* from mini_page_info_extra t,mini_page m where t.page_id = m.id and m.user_id=? and m.status=1 and m.isdelete=1 order by m.publish_time desc";
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        
        List<ETIPResultSet> list = dao.queryForList(sql, new Object[]{userId});
        
        List<PageInfoExtraData> returnList = new ArrayList<PageInfoExtraData>();
        
        for (int i = 0; i < list.size(); i++) {
            PageInfoExtraData data = new PageInfoExtraData();

            data.setId(list.get(i).getString("ID"));
            data.setCompany(list.get(i).getString("COMPANY"));
            data.setType(list.get(i).getString("TYPE"));
            data.setStatus(list.get(i).getString("STATUS"));
            data.setDomain(list.get(i).getString("DOMAIN"));
            data.setPageId(list.get(i).getString("PAGE_ID"));
            data.setBindingTime(list.get(i).getDate("BINDINGTIME"));
            
            returnList.add(data);
        }
        return returnList;
        
    }
}
