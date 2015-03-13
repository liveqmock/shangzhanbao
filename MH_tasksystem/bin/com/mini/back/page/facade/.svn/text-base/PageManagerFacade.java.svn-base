package com.mini.back.page.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.service.IPageInfoExtraService;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;

import com.mini.page.service.IPageService;
import com.sys.user.data.UserData;
/**
 * 
 * 〈后台page管理〉<br> 
 * 〈功能详细描述〉
 * @author hy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("pageManagerFacade")
public class PageManagerFacade extends FrmFacade{
	@Resource(name="pageService")
	private IPageService pageService;
	@Resource(name="pageInfoExtraService")
	private  IPageInfoExtraService pageInfoExtraService;
	 /**
     * 后台查询  page管理  分页
     * @author hy
     * @date 2014-2-19
     * @param pageRoll
     * @param helpData
     * @return
     */
	
	public List<PageData> getAllPage(PageRoll pageRoll,PageHelpData helpData,Integer sort) {
		return pageService.getAllPage(pageRoll, helpData,sort);
	}
	 /**
     * 禁用  page  后台
     * @author hy
     * @date 2014-2-19
     * @param pageId page 的id
     * @param pageData 实体
     */
    public void  disabledPage(String id,PageData date){
    	pageService.disabledPage(id,date);
    }
    /**
     * 启用  page  后台
     * @author hy
     * @date 2014-2-20
     */
    public void  startPage(PageData pageData){
    	pageService.startPage(pageData);
    }
    /**
     * 后台  page管理 查询详情
     * @param pageId
     * @return
     */
    public PageData getPageId(String pageId){
    	return pageService.getPageId(pageId);
    }
    
    /**
     * 
     * 后台详情页面 解绑域名
     * @author hy
     * @date 2014 2-21
     * @param pageId
     * @param pageInfoId
     */
    public  void dahuaPageInfoExtraInfo(String pageId){
    	pageInfoExtraService.dahuaPageInfoExtraInfo(pageId);
    }
    /**
     * 绑定独立域名
     * @author 侯杨
     * @date 2014-2-21
     * @param pageId
     * @param domain
     */
    public String  boundPageInfoExtraInfo(String pageId,String domain){
    	return pageInfoExtraService.boundPageInfoExtraInfo(pageId, domain);
    }
    /**
     * 后台查询  page管理  分页
     * @author hy
     * @date 2014-2-19
     * @param pageRoll  分页
     * @param helpData  page实体类
     * @return
     */
    public List<PageData> getAllPageList(PageRoll pageRoll,PageHelpData helpData){
    	return pageService.getAllPageList(pageRoll, helpData);
    }
    /**
     * 后台查询  新增一条域名数据
     * @author hy
     * @date 2014-2-27
     * @param pageRoll  分页
     * @param helpData  page实体类
     * @return
     */
    
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        // TODO Auto-generated method stub
    	pageInfoExtraService.addPageInfoExtra(pageInfoExtraData);
    }
    /**
     * 
     * 管理员赠送page给用户<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-5-21
     * @update 
     * @param UserData userData,PageData pageData
     * @return  void
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void powerPageByUserID(UserData userData,PageData pageData){
        pageService.powerPageByUserID(userData, pageData);
    }
    
    /**
    * 删除多条page数据  假删
    * @author 侯杨
    *@date 2014-5-20
    * @param id
    * @return
    */
   public String deletePageData(String id[]){
    	return pageService.deletePageData(id);
    }
}
