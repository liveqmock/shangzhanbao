package com.mini.front.domain.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.page.service.IPageService;
/**
 * page后台管理Facade
 * 
 * @author 林海鹏
 * @see PageFacade
 * @since
 */
@Component("pageFacade")
public class PageFacade extends FrmFacade{
    @Resource(name="pageService")
    private IPageService pageService;
    
    public void setPageService(IPageService pageService) {
        this.pageService = pageService;
    }
    /**
     * 新增Page
     */
    public void addPage(PageData pageData) {
        pageService.addPage(pageData);
    }
    /**
     * 删除Page
     */
    public void deletePage(String[] ids) {
        pageService.deletePage(ids);
    }
    /**
     * 编辑Page
     */
    public void editPage(PageData pageData) {
        pageService.editPage(pageData);
    }
    /**
     * 查询Page(分页显示)//连表分页查询 返回数组
     */
    public List<Object[]> getAllPageInfo(PageRoll pageRoll, JSONObject json) {
        return pageService.getAllPageInfo(pageRoll, json);
    }
    /**
     * 单对象分页查询     返回集合
     */
    public List<PageData> getAllPages(PageRoll pageRoll, JSONObject json) {
        return pageService.getAllPages(pageRoll, json);
    }
    /**
     * 根据条件获取对象
     * @param json
     * @return
     */
    public List<PageData> getPageData(JSONObject json) {
        return pageService.getPageData(json);
    }
    /**
     * //连表分页查询 返回集合
     * @param pageRoll
     * @param json
     * @return
     */
    public List<PageData> getForpageRoll(PageRoll pageRoll, JSONObject json) {
        return pageService.getForpageRoll(pageRoll, json);
    }
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
    public List<String> findNoPayProductDataByPage(String[] str){
        return pageService.findNoPayProductDataByPage(str);
    }
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
    public List<String> findNoPayProductDataByOrderAndPage(String[] str){
        return pageService.findNoPayProductDataByOrderAndPage(str);
    }
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
    public boolean findNoPayStateByPageIDAndProudctID(String pageId,String productId){
        return pageService.findNoPayStateByPageIDAndProudctID(pageId, productId);
    }
    /**
     * 
     *查询page实体,用于初始化加载page页面  替换title  和查询pageid<br>
     * 
     * @author 侯杨 <br> 
     *         2014年12月22日
     * @update 
     * @param data  域名实体
     * @return  pagedata  page实体
     * @see   PageFacade#getPageDataByPageHtml(data)
     * @since vmaque 2.0
     */
    public PageData getPageDataByPageHtml(PageInfoExtraData data){
        return pageService.getPageDataByPageHtml(data);
    }
}
