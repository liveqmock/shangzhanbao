package com.mini.page.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;

/**
 * 后台page管理久化层接口
 * 
 * @author     林海鹏
 * @see        IPagePersistence
 * @since      
 */

public interface IPagePersistence extends IBasePersistence<PageData>{
    /**
     * 新增Page
     */
    public void addPage(PageData pageData);
    /**
     * 删除Page
     */
    public void deletePage(String[] ids);
    /**
     * 编辑Page
     */
    public void editPage(PageData pageData);
    /**
     * 根据条件获取对象
     */
    public List<PageData> getPageData(JSONObject json);
    
    /**
     * 查询Page(分页显示)
     */
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json);//单对象分页查询     返回集合
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json);//连表分页查询 返回集合
    public List<Object[]> getAllPageInfo(PageRoll pageRoll, JSONObject json);//连表分页查询 返回数组
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
}
