package com.mini.pageMessageboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.business.IPageMessageboardBusiness;
import com.mini.pageMessageboard.data.PageMessageboardData;

/**
 * page留言板信息Service层
 * 
 * @author 左香勇 2014-3-31
 * @see PageMessageboardService
 * @since
 */
@Component("pageMessageboardService")
public class PageMessageboardService extends FrmService implements
		IPageMessageboardService {

	@Resource(name = "pageMessageboardBusiness")
	private IPageMessageboardBusiness pageMessageboardBusiness;

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void addPageMessageboard(PageMessageboardData pageMessageBoardData) {
		pageMessageboardBusiness.addPageMessageboard(pageMessageBoardData);
	}

	/**
	 * 根据id删除留言板信息
	 * 
	 * @author 左香勇 2014-4-11
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void deletePageMessageboardByid(String id){
		pageMessageboardBusiness.deletePageMessageboardByid(id);
	}
	
	/**
	 * 
	 * 修改留言板信息
	 * 
	 * @author 左香勇 2014-4-9
	 * @update
	 * @param pageMessageboardData
	 */
	public void editPageMessageboard(PageMessageboardData pageMessageboardData) {
		pageMessageboardBusiness.editPageMessageboard(pageMessageboardData);
	}

	/**
	 * 查询留言板信息，分页
	 * 
	 * @param pageRoll
	 * @param pageid
	 * @param isread
	 * @return
	 */
	public List<PageMessageboardData> getAllPageMessageboard(PageRoll pageRoll,
			String pageid, Integer isread) {
		pageRoll=PageRoll.set(Page.SIZE_10, pageRoll);
		return pageMessageboardBusiness.getAllPageMessageboard(pageRoll,
				pageid, isread);
	}

	/**
	 * 根据id查询留言板信息
	 * 
	 * @param Id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id) {
		return pageMessageboardBusiness.getPageMessageboardByid(id);
	}

}
