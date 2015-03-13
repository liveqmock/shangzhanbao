package com.mini.pageMessageboard.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.data.PageMessageboardData;

/**
 * page留言板信息Service层接口
 * 
 * @author 左香勇
 * @see IPageMessageboardService
 * @since
 */
public interface IPageMessageboardService extends IService {

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
	 * @param Id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id);

}
