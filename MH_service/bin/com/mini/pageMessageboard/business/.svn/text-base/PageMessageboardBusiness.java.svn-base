package com.mini.pageMessageboard.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.data.PageMessageboardData;
import com.mini.pageMessageboard.persistence.IPageMessageboardPersistence;

/**
 * page留言板信息Business层
 * 
 * @author 左香勇 2014-3-31
 * @see PageMessageboardBusiness
 * @since
 */
@Component("pageMessageboardBusiness")
public class PageMessageboardBusiness extends FrmBusiness implements
		IPageMessageboardBusiness {

	@Resource(name = "pageMessageboardPersistence")
	private IPageMessageboardPersistence pageMessageboardPersistence;

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void addPageMessageboard(PageMessageboardData pageMessageBoardData) {
		pageMessageboardPersistence.addPageMessageboard(pageMessageBoardData);
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
		pageMessageboardPersistence.deletePageMessageboardByid(id);
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
		pageMessageboardPersistence.editPageMessageboard(pageMessageboardData);
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
		return pageMessageboardPersistence.getAllPageMessageboard(pageRoll,
				pageid, isread);
	}

	/**
	 * 根据id查询留言板信息
	 * 
	 * @param Id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id) {
		return pageMessageboardPersistence.getPageMessageboardByid(id);
	}

	/**
     * 
     * 根据pageid和是否已读查询留言信息
     * 
     * @author 左香勇 <br> 
     *         2014-7-8
     * @update 
     */
    public List<PageMessageboardData> getPageMessageboardBypageid(String pageid,int isread){
        return pageMessageboardPersistence.getPageMessageboardBypageid(pageid, isread);
    }
}
