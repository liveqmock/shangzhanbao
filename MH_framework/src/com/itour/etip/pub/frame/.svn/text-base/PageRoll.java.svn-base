/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/frame/PageRoll.java
  Description:  ��ҳ֧�ֶ���
  Author: TengXiaocong      Version:  1.0.0  Date: 2009.4.14
***********************************************************/
package com.itour.etip.pub.frame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页所需要的对象
 * @author Administrator
 *
 */
public class PageRoll {
	
	
	
	public PageRoll(int pageSize) {
		super();
		this.pageSize = pageSize;
	}
	private List<?> list;
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	/*查询HQL语句，需要自己拼写*/
	private String searchSQL = null;
	/*查询所有记录数的HQL语句，需要自己拼写*/
	private String countSQL = null;
	
	private Map<String,String> parameters = new HashMap<String,String>();
	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(String key,String value) {
		parameters.put(key, value);
	}
	private String sumSQL = null;
	
	public String getSumSQL() {
		return sumSQL;
	}

	public void setSumSQL(String sumSQL) {
		this.sumSQL = sumSQL;
	}

	public String getSearchSQL() {
		return searchSQL;
	}

	public void setSearchSQL(String searchSQL) {
		this.searchSQL = searchSQL;
	}

	public String getCountSQL() {
		return countSQL;
	}

	public void setCountSQL(String countSQL) {
		this.countSQL = countSQL;
	}
	/*当前页数*/
	private int currentPage = 0;
	/*每页记录数*/
	private int pageSize = 0;
	/*总记录数*/
	private int totalRows = 0;
	/*开始记录数*/
	private int startRow = 0;
	
	public PageRoll() {
		
	}

	private int totalPage = 0;


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.startRow = currentPage*pageSize;
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		if(totalPage<currentPage){
			currentPage=0;
		}
		this.totalPage = totalPage;
	}
	
	
	
	/**
	 * 统一设置PAGEROLL，页面向后台传送当前页的时候调用设置
	 * 何大勇
	 * @param pageSize
	 * @param pageRoll
	 * @return
	 * @date 2013-1-7 下午02:50:57
	 */
	public static PageRoll set(int pageSize,PageRoll pageRoll){
		if(pageRoll==null){
			pageRoll = new PageRoll();
		}
		pageRoll.setPageSize(pageSize);
		pageRoll.setStartRow(pageSize*pageRoll.getCurrentPage());
		return pageRoll;
	}
}
