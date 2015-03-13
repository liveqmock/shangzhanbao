package com.mini.pageMessageboard.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.data.PageMessageboardData;
import com.mini.pageMessageboard.service.IPageMessageboardService;

/**
 * page留言板信息Facade层
 * 
 * @author 左香勇 2014-3-31
 * @see PageMessageboardFacade
 * @since
 */
@Component("pageMessageboardFacade")
public class PageMessageboardFacade extends FrmFacade {

	@Resource(name = "pageMessageboardService")
	private IPageMessageboardService pageMessageboardService;

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void addPageMessageboard(PageMessageboardData pageMessageBoardData) {
		pageMessageboardService.addPageMessageboard(pageMessageBoardData);
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
		pageMessageboardService.deletePageMessageboardByid(id);
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
		pageMessageboardService.editPageMessageboard(pageMessageboardData);
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
		return pageMessageboardService.getAllPageMessageboard(pageRoll, pageid,
				isread);
	}

	/**
	 * 根据id查询留言板信息
	 * 
	 * @param Id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id) {
		return pageMessageboardService.getPageMessageboardByid(id);
	}

}
