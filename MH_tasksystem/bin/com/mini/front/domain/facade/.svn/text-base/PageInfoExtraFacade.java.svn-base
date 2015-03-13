package com.mini.front.domain.facade;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.domain.service.IPageInfoExtraService;

/**
 * 域名管理Facade
 * 
 * @author 林海鹏
 * @see PageInfoExtraFacade
 * @since
 */
@Component("pageInfoExtraFacade")
public class PageInfoExtraFacade extends FrmFacade {
    @Resource(name = "pageInfoExtraService")
    IPageInfoExtraService pageInfoExtraService;

    public void setPageService(IPageInfoExtraService pageInfoExtraService) {
        this.pageInfoExtraService = pageInfoExtraService;
    }

    /**
     * 新增Page信息
     */
    public void addPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        pageInfoExtraService.addPageInfoExtra(pageInfoExtraData);
    }

    /**
     * 删除Page信息
     */
    public void deletePageInfoExtra(String[] ids) {
        pageInfoExtraService.deletePageInfoExtra(ids);
    }

    /**
     * 编辑Page信息信息
     */
    public void editPageInfoExtra(PageInfoExtraData pageInfoExtraData) {
        pageInfoExtraService.editPageInfoExtra(pageInfoExtraData);
    }

    /**
     * 查询Page信息(分页显示)
     */
    public List<PageInfoExtraData> getAllPageInfoExtraInfo(PageRoll pageRoll, JSONObject json) {
        return pageInfoExtraService.getAllPageInfoExtraInfo(pageRoll, json);
    }

    /**
     * 根据条件获取对象信息
     */
    public List<PageInfoExtraData> getPageInfoExtraData(JSONObject json) {
        return pageInfoExtraService.getPageInfoExtraData(json);
    }

    /**
     * 
     * 根据PageId查询二级域名<br>
     * 
     * @author 文东 <br>
     *         2014年3月23日
     * @update
     * @param
     * @return PageInfoExtraData 域名实体对象
     * @exception/throws
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public PageInfoExtraData searchByPageId(PageInfoExtraData pageInfoExtraData) {
        return pageInfoExtraService.searchByPageInfoExtraData(pageInfoExtraData);
    }
    /**
     * 连表获取page名称，page域名
     * @param json
     * @return
     */
	public Map<String, String> getPageInfoExtra(JSONObject json) {
		// TODO Auto-generated method stub
		return pageInfoExtraService.getPageInfoExtra(json);
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
     * @see   PageInfoExtraFacade#getPageInfoExtraDatasByUserId(String)
     * @since vmaque 2.0
     */
    public List<PageInfoExtraData> getPageInfoExtraDatasByUserId(String userId){
        return pageInfoExtraService.getPageInfoExtraDatasByUserId(userId);
    }
}
