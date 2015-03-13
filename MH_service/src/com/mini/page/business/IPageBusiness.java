package com.mini.page.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;

/**
 * 后台page管理业务接口
 * 
 * @author 林海鹏
 * @see IPageBusiness
 * @since
 */

public interface IPageBusiness extends IBusiness{

    /**
     * 新增Page信息
     */
    public void addPage(PageData pageData);
    /**
     * 删除Page信息
     */
    public void deletePage(String[] ids);
    /**
     * 编辑Page信息信息
     */
    public void editPage(PageData pageData);
    /**
     * 根据条件获取对象信息
     */
    public List<PageData> getPageData(JSONObject json);
    
    /**
     * 查询Page信息(分页显示)
     */
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json);//单对象分页查询     返回集合
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json);
    public List<Object[]> getAllPageInfo(PageRoll pageRoll, JSONObject json);
    /**
     * 后台查询  page管理  分页
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll  分页
     * @param helpData  page实体类
     * @return
     */
    public List<PageData> getAllPage(PageRoll pageRoll,PageHelpData helpData,Integer sort);
    /**
     * 禁用 page
     * @author 侯杨
     * @date 2014-2-19
     * @param pageId page 的id
     * @param state 状态
     */
    public void  disabledPage(String id,PageData date);
    /**
     * 启用  page  后台
     * @author 侯杨
     * @date 2014-2-20
     */
    public void  startPageState(PageData date);
    /**
     * 后台  page管理 查询详情
     * @param pageId
     * @return
     */
    public PageData getPageId(String pageId);
    /**
     * 后台查询  page管理  分页
     * @author 侯杨
     * @date 2014-2-19
     * @param pageRoll  分页
     * @param helpData  page实体类
     * @return
     */
    public List<PageData> getAllPageList(PageRoll pageRoll,PageHelpData helpData);
    /**
     * 
     *根据pageid查询未付款的业务
     * 
     * @author 冯鑫 <br> 
     *         2014-4-9
     * @update 
     * @param JSONObject obj
     * @return  List<ProductData>
     */
    public List<String> findNoPayProductDataByPage(String[] str);
    /**
     * 
     *根据pageid关联order表查询未付款业务
     * 
     * @author 冯鑫 <br> 
     *         2014-4-9
     * @update 
     * @param JSONObject obj
     * @return  List<ProductData>
     */
    public List<String> findNoPayProductDataByOrderAndPage(String[] str);
    /**
     * 
     * 更具page主键和服务主键 查询 此page购买的此款服务时够已经付款<br>
     * 
     * @author Administrator <br> 
     *         2014-4-24
     * @update 
     * @param String pageId page主键
     *          String productId 服务主键
     * @return  boolean  未付款 返回true  已经出款 返回false
     */
    public boolean findNoPayStateByPageIDAndProudctID(String pageId,String productId);
    /**
     * 删除多条page数据  假删
     * @author 侯杨
     *@date 2014-5-20
     * @param id
     * @return
     */
    public String deletePageData(String id);
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
    public PageData getPageDateById(String id);
}
