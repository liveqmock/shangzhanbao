package com.mini.pageMessageboard.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.data.PageMessageboardData;

/**
 * page留言板信息Business层接口
 * 
 * @author 左香勇
 * @see IPageMessageboardBusiness
 * @since
 */
public interface IPageMessageboardBusiness extends IBusiness {

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void addPageMessageboard(PageMessageboardData pageMessageBoardData);
	
	/**
	 * 根据id删除留言板信息
	 * 
	 * @author 左香勇 2014-4-11
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void deletePageMessageboardByid(String id);
	
	/**
	 * 
	 * 修改留言板信息
	 * 
	 * @author 左香勇 2014-4-9
	 * @update
	 * @param pageMessageboardData
	 */
	public void editPageMessageboard(PageMessageboardData pageMessageboardData);

	/**
	 * 查询留言板信息，分页
	 * 
	 * @param pageRoll
	 * @param pageid
	 * @param isread
	 * @return
	 */
	public List<PageMessageboardData> getAllPageMessageboard(PageRoll pageRoll,
			String pageid, Integer isread);

	/**
	 * 根据id查询留言板信息
	 * 
	 * @param id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id);
	
	/**
	 * 
	 * 根据pageid和是否已读查询留言信息
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-7-8
	 * @update 
	 */
	public List<PageMessageboardData> getPageMessageboardBypageid(String pageid,int isread);
	
}
