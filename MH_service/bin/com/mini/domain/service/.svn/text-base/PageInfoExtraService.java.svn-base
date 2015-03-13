package com.mini.domain.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.business.IPageInfoExtraBusiness;
import com.mini.domain.data.PageInfoExtraData;
/**
 * 域名管理服务接口实现类
 * 
 * @author 林海鹏
 * @see PageInfoExtraService
 * @since
 */
@Component("pageInfoExtraService")
public class PageInfoExtraService extends FrmService implements IPageInfoExtraService {
    @Resource(name="pageInfoExtraBusiness")
    private IPageInfoExtraBusiness pageInfoExtraBusiness;
    public void setPageBusiness(IPageInfoExtraBusiness pageInfoExtraBusiness) {
        this.pageInfoExtraBusiness = pageInfoExtraBusiness;
    }
    /**
     * 新增Page信息
     */
    @Override
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        pageInfoExtraBusiness.addPageInfoExtra(pageInfoExtraData);
    }
    /**
     * 删除Page信息
     */
    @Override
    public void deletePageInfoExtra(String[] ids) {
        pageInfoExtraBusiness.deletePageInfoExtra(ids);
    }
    /**
     * 编辑Page信息信息
     */
    @Override
    public void editPageInfoExtra(PageInfoExtraData orderData) {
        pageInfoExtraBusiness.editPageInfoExtra(orderData);
    }
    /**
     * 根据条件获取对象信息
     */
    @Override
    public List<PageInfoExtraData> getAllPageInfoExtraInfo(PageRoll pageRoll, JSONObject json) {
        pageRoll = pageRoll.set(Page.SIZE_10, pageRoll);
        return pageInfoExtraBusiness.getAllPageInfoExtraInfo(pageRoll, json);
    }
    /**
     * 查询Page信息(分页显示)
     */
    @Override
    public List<PageInfoExtraData> getPageInfoExtraData(JSONObject json) {
        return pageInfoExtraBusiness.getPageInfoExtraData(json);
    }
    /**
     * 
     * 解绑域名
     * @author hy
     * @date 2014 2-21
     * @param pageId
     * @param pageInfoId
     */
    public  void dahuaPageInfoExtraInfo(String pageId){
    	pageInfoExtraBusiness.dahuaPageInfoExtraInfo(pageId);
    }
    /**
     * 绑定独立域名
     * @author 侯杨
     * @date 2014-2-21
     * @param pageId
     * @param domain
     */
    public String  boundPageInfoExtraInfo(String pageId,String domain){
    return	pageInfoExtraBusiness.boundPageInfoExtraInfo(pageId, domain);
    }
    
    @Override
    public PageInfoExtraData searchByPageInfoExtraData(PageInfoExtraData pageInfoExtraData) {
        return pageInfoExtraBusiness.searchByPageInfoExtraData(pageInfoExtraData);
    }
    /**
     * 连表获取page名称，page域名
     * @param json
     * @return
     */
	@Override
	public Map<String, String> getPageInfoExtra(JSONObject json) {
		// TODO Auto-generated method stub
		return pageInfoExtraBusiness.getPageInfoExtra(json);
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
     * @see   PageInfoExtraService#getPageInfoExtraDatasByUserId(String)
     * @since vmaque 2.0
     */
    public List<PageInfoExtraData> getPageInfoExtraDatasByUserId(String userId){
        return pageInfoExtraBusiness.getPageInfoExtraDatasByUserId(userId);
    }
}
