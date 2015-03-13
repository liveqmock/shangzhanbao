package com.mini.pageMessageboard.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.pageMessageboard.data.PageMessageboardData;

/**
 * page留言板信息持久化层
 * 
 * @author 左香勇 2014-3-31
 * @see PageMessageboardPersistence
 * @since
 */
@SuppressWarnings("unchecked")
@Component("pageMessageboardPersistence")
public class PageMessageboardPersistence extends
		BasePersistence<PageMessageboardData> implements
		IPageMessageboardPersistence {

	/**
	 * 添加留言板信息
	 * 
	 * @author 左香勇 2014-3-31
	 * @update
	 * @param pageMessageBoardData
	 * 
	 */
	public void addPageMessageboard(PageMessageboardData pageMessageBoardData) {
		this.add(pageMessageBoardData);
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
		this.delete(id);
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
		this.updateWithOutNullProp(pageMessageboardData);
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
		StringBuffer countSQL = new StringBuffer("SELECT COUNT(p.id) FROM PageMessageboardData p WHERE 1=1");
		StringBuffer querySQL = new StringBuffer("FROM PageMessageboardData p WHERE 1=1");
		
		StringBuffer whereSQL = new StringBuffer("");
		if(pageid != null && !"".equals(pageid)){
			whereSQL.append(" AND p.pageid = '").append(pageid).append("'");
		}
		if(isread != null){
			whereSQL.append(" AND p.isread = ").append(isread);
		}
		
		pageRoll.setCountSQL(countSQL.append(whereSQL).toString());
		pageRoll.setSearchSQL(querySQL.append(whereSQL).append(" ORDER BY p.isread,p.createtime desc").toString());
		List<PageMessageboardData> pageMessageboardDataList = search(pageRoll);
		
		return pageMessageboardDataList;
	}

	/**
	 * 根据id查询留言板信息
	 * 
	 * @param Id
	 * @return
	 */
	public PageMessageboardData getPageMessageboardByid(String id){
		return this.retrieve(id);
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
        
        StringBuffer querySQL = new StringBuffer("FROM PageMessageboardData p WHERE 1=1 ");
        querySQL.append("AND p.pageid = '").append(pageid).append("' ");
        querySQL.append("AND p.isread=").append(isread);
        
        List<PageMessageboardData> list = search(querySQL.toString());
        
        return list;
    }
}
