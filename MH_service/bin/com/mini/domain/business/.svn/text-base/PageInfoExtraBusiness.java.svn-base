package com.mini.domain.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.persistence.IPageInfoExtraPersistence;
import com.mini.page.data.PageData;
import com.mini.pageManage.persistence.IPageManagePersistence;

/**
 * 域名管理业务接口实现类
 * 
 * @author 林海鹏
 * @see PageInfoExtraBusiness
 * @since
 */
@Component("pageInfoExtraBusiness")
public class PageInfoExtraBusiness extends FrmBusiness implements IPageInfoExtraBusiness {
    @Resource(name = "pageInfoExtraPersistence")
    private IPageInfoExtraPersistence pageInfoExtraPersistence;
    @Resource(name = "pageManagePersistence")
    private IPageManagePersistence pageManagePersistence;// page

    public void setPagePersistence(IPageInfoExtraPersistence pageInfoExtraPersistence) {
        this.pageInfoExtraPersistence = pageInfoExtraPersistence;
    }

    /**
     * 新增Page信息
     */
    @Override
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        pageInfoExtraPersistence.addPageInfoExtra(pageInfoExtraData);
    }

    /**
     * 删除Page信息
     */
    @Override
    public void deletePageInfoExtra(String[] ids) {
        pageInfoExtraPersistence.deletePageInfoExtra(ids);
    }

    /**
     * 编辑Page信息信息
     */
    @Override
    public void editPageInfoExtra(PageInfoExtraData orderData) {
        pageInfoExtraPersistence.editPageInfoExtra(orderData);
    }

    /**
     * 根据条件获取对象信息
     */
    @Override
    public List<PageInfoExtraData> getAllPageInfoExtraInfo(PageRoll pageRoll, JSONObject json) {
        return pageInfoExtraPersistence.getAllPageInfoExtraInfo(pageRoll, json);
    }

    /**
     * 查询Page信息(分页显示)
     */
    @Override
    public List<PageInfoExtraData> getPageInfoExtraData(JSONObject json) {
        return pageInfoExtraPersistence.getPageInfoExtraData(json);
    }

    /**
     * 
     * 解绑域名
     * 
     * @author hy
     * @date 2014 2-21
     * @param pageId
     * @param pageInfoId
     */
    public void dahuaPageInfoExtraInfo(String pageId) {
        PageInfoExtraData infoExtraData = null; // page扩展实体
        PageInfoExtraData data = null;
        String hql = "from PageInfoExtraData pa where  pa.pageId = ?"; // 根据page扩张实体的iD和page个人实体的id查询
        List<PageInfoExtraData> datas = pageInfoExtraPersistence.search(hql, new Object[] { pageId });
        if (datas.size() > 0 && datas != null) {
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).getType().equals("1")) { // 如果查询出来是独立域名，赋给一个实体
                    infoExtraData = datas.get(i);
                }
                if (datas.get(i).getType().equals("2")) { // 如果查询出来是二级域名，赋给一个实体
                    data = datas.get(i);
                }
            }

        }
        infoExtraData.setStatus("CLOASED"); // 改变状态 为关闭 解绑独立域名
        infoExtraData.setBindingTime(new Date()); // 解绑时间
        pageInfoExtraPersistence.update(infoExtraData);

        data.setStatus("OPEN"); // 二级域名 为打开状态
        pageInfoExtraPersistence.update(data);
    }

    /**
     * 绑定独立域名
     * 
     * @author 侯杨
     * @date 2014-2-21
     * @param pageId
     * @param domain
     * @update 冯鑫  20140429
     *         绑定独立域名的时候 设置域名的 Company字段
     */
    public String  boundPageInfoExtraInfo(String pageId, String domain) {
    	
    	//page的二级域名存在，且page的状态为发布状态才能绑定
    	String hql1 = " from  PageInfoExtraData a,PageData page where a.type='2'  and  a.pageId=? and page.id=a.pageId and page.status='1'";
       List<PageInfoExtraData> list=pageInfoExtraPersistence.search(hql1, new Object[]{pageId});
       if(list.size()>0){
    	   /******************************************冯鑫begin***************************************************/
           PageData pageData =pageManagePersistence.retrieve(pageId);
           /******************************************冯鑫end***************************************************/
           PageInfoExtraData infoExtraData = null; // page扩展实体
           PageInfoExtraData data = null;
           String hql = "from PageInfoExtraData pa where  pa.pageId = ?"; // 根据page扩张实体的iD和page个人实体的id查询
           List<PageInfoExtraData> datas = pageInfoExtraPersistence.search(hql, new Object[] { pageId });
           /* 如果数据库有两条数据 就都更新 */
           if (datas.size() == 2 && datas != null) {
               for (int i = 0; i < datas.size(); i++) {
                   if (datas.get(i).getType().equals("1")) { // 如果查询出来是独立域名，赋给一个实体
                       infoExtraData = datas.get(i);
                   }
                   if (datas.get(i).getType().equals("2")) { // 如果查询出来是二级域名，赋给一个实体
                       data = datas.get(i);
                   }
               }
               /******************************************冯鑫begin***************************************************/
               infoExtraData.setCompany(pageData.getName());
               /******************************************冯鑫end***************************************************/
               infoExtraData.setStatus("OPEN"); // 改变状态 为打开 绑定独立域名
               infoExtraData.setDomain(domain); // 绑定独立域名名称
               infoExtraData.setBindingTime(new Date()); // 绑订时间
               pageInfoExtraPersistence.update(infoExtraData);

               data.setStatus("CLOASED"); // 二级域名 关闭状态
               pageInfoExtraPersistence.update(data);
           }
           /* 如果数据库只有一条数据 并且是二级域名。那就增加一条新的数据 type为独立的域名的数据 并且修改另一条数据 */
           if (datas.size() == 1 && datas != null) {
               for (int i = 0; i < datas.size(); i++) {
                   if (datas.get(i).getType().equals("2")) { // 如果查询出来是二级域名，赋给一个实体
                       infoExtraData = new PageInfoExtraData();
                       /******************************************冯鑫begin***************************************************/
                       infoExtraData.setCompany(pageData.getName());
                       /******************************************冯鑫end***************************************************/
                       infoExtraData.setDomain(domain);
                       infoExtraData.setPageId(pageId);
                       infoExtraData.setType("1");
                       infoExtraData.setStatus("OPEN");
                       infoExtraData.setBindingTime(new Date()); // 绑订时间
                       pageInfoExtraPersistence.add(infoExtraData);
                       data = datas.get(i);
                       data.setStatus("CLOASED"); // 二级域名 关闭状态
                       pageInfoExtraPersistence.update(data);
                   }
               }
           }
           return "1";
       }else{
    	   return "2";   //要先发布page才能绑定独立域名
       }
       
    }

    @Override
    public PageInfoExtraData searchByPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        // 查询2级域名
        pageInfoExtraData.setType("2");
        return pageInfoExtraPersistence.searchByPageInfoExtraData(pageInfoExtraData);
    }

	@Override
	public Map<String, String> getPageInfoExtra(JSONObject json) {
		// TODO Auto-generated method stub
		return pageInfoExtraPersistence.getPageInfoExtra(json);
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
     * @see   IPageInfoExtraBusiness#getPageInfoExtraDatasByUserId(String)
     * @since vmaque 2.0
     */
    public List<PageInfoExtraData> getPageInfoExtraDatasByUserId(String userId){
        return pageInfoExtraPersistence.getPageInfoExtraDatasByUserId(userId);
    }
    /**
     * 
     *根据域名查询pageid<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月22日
     * @update 
     * @param data  域名实体
     * @return  list  域名集合
     * @see   PageInfoExtraBusiness#getPageInfoExtraDatasByName(PageInfoExtraData)
     * @since vmaque 2.0
     */
    @Override
    public List<PageInfoExtraData> getPageInfoExtraDatasByName(PageInfoExtraData data){
        String hql="from PageInfoExtraData p where p.status='OPEN' and p.domain= ?";
        return pageInfoExtraPersistence.search(hql, new Object[]{data.getDomain()});
    }
	
}
