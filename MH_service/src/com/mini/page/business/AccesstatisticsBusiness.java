package com.mini.page.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.page.data.AccesstatisticsData;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.page.persistence.IAccesstatisticsPersistence;
import com.mini.page.persistence.IPagePersistence;

/**
 * 数据分析业务接口实现类
 * 
 * @author 林海鹏
 * @see IAccesstatisticsBusiness
 * @since
 */
@Component("accesstatisticsBusiness")
public class AccesstatisticsBusiness extends FrmBusiness implements IAccesstatisticsBusiness{
	@Resource(name="accesstatisticsPersistence")
	private IAccesstatisticsPersistence accesstatisticsPersistence;
	
	 /* page个人表 */
    @Resource(name = "pagePersistence")
    private IPagePersistence pagePersistence;
    /* page扩张表 */
    @Resource(name = "pageInfoExtraPersistence")
    private IPageInfoExtraPersistence pageInfoExtraPersistence;
	
	
	public void setAccesstatisticsPersistence(
			IAccesstatisticsPersistence accesstatisticsPersistence) {
		this.accesstatisticsPersistence = accesstatisticsPersistence;
	}

	@Override
	public void addAccesstatisticsData(AccesstatisticsData data) {
		// TODO Auto-generated method stub
		accesstatisticsPersistence.add(data);
	}

	@Override
	public void deleteAccesstatisticsData(String[] ids) {
		// TODO Auto-generated method stub
		accesstatisticsPersistence.delete(ids);
	}

	@Override
	public void editAccesstatisticsData(AccesstatisticsData data) {
		// TODO Auto-generated method stub
		accesstatisticsPersistence.editAccesstatisticsData(data);
	}

	@Override
	public Map<String,Object> getAccesstatisticsData(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsPersistence.getAccesstatisticsData(json);
	}

	@Override
	public Map<String,Object> getCountByIpType(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsPersistence.getCountByIpType(json);
	}

	@Override
	public String getViewCount(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsPersistence.getViewCount(json);
	}

	@Override
	public String getVisitCount(JSONObject json) {
		// TODO Auto-generated method stub
		return accesstatisticsPersistence.getVisitCount(json);
	}
	 /**
     * 
     *统计page访问量  后台<br>
     * 
     * @author 侯杨 <br> 
     *         2014-6-27
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    @Override
    public List<AccesstatisticsData> getAllPageCount(PageRoll pageRoll, PageHelpData pageHelpData,Integer sort) {
        // TODO Auto-generated method stub
        List<AccesstatisticsData> list=accesstatisticsPersistence.getAllPageCount(pageRoll, pageHelpData,sort);
          if(list!=null && list.size()>0){
              for (int i = 0; i < list.size(); i++) {
                  PageData pageData = new  PageData(); // page实体
                  /* 查询page对象 */
                  if (list.get(i).getPageId() != null && !"".equals(list.get(i).getPageId())) {
                      pageData = pagePersistence.retrieve(list.get(i).getPageId());
                  }
                  /* 查询pageinfo扩张表 */
                  List<PageInfoExtraData> pageInfoExtraDatas = new ArrayList<PageInfoExtraData>();
                  String hql = "from PageInfoExtraData pi where pi.pageId = ? and pi.status='OPEN'";
                  if (list.get(i).getPageId() != null && !"".equals(list.get(i).getPageId())) {
                      pageInfoExtraDatas = pageInfoExtraPersistence.search(hql, new Object[] { list.get(i).getPageId() });
                  } 
                  //如果 域名集合不为空 ，page查询出来的域名赋给page实体中的域名实体
                  if(pageInfoExtraDatas!=null && pageInfoExtraDatas.size()>0){
                       if(pageData!=null){
                           pageData.setPageInfoExtra(pageInfoExtraDatas.get(0));
                       }
                  }
                  list.get(i).setPageData(pageData);
            }
         }
          
         return list;
    }

}
