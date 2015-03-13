package com.itour.etip.pub.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itour.etip.pub.base.IDao;
import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.ETIPException;

public class JdbcDao extends JdbcDaoSupport implements IDao {

	private String driverName = "";

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void executeSQL(String sql) {
		try {
			this.getJdbcTemplate().execute(sql);
		} catch (DataAccessException ex) {
			throw new ETIPError("JdbcDao_executeSQL", ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeSQL(String sql, Object[] parameters)
			throws ETIPException {
		try {
			if (parameters == null) {
				this.getJdbcTemplate().execute(sql);
			} else {
				this.getJdbcTemplate().update(sql, parameters);
			}

		} catch (DataAccessException ex) {
			throw new ETIPError("JdbcDao_update", ex);
		}
	}

	public void executeUpdate(String sql, Object[] parameters)
			 {
		try {
			if (parameters == null) {
				this.getJdbcTemplate().update(sql);
			} else {
				this.getJdbcTemplate().update(sql, parameters);
			}

		} catch (DataAccessException ex) {
			throw new ETIPError("JdbcDao_update", ex);
		}
	}

	public List<ETIPResultSet> queryForList(String sql, Object[] parameters)
			throws ETIPException {
		try {
			List result = null;
			if (parameters == null) {
				result = this.getJdbcTemplate().queryForList(sql);
			} else {
				result = this.getJdbcTemplate().queryForList(sql, parameters);
			}
			List<ETIPResultSet> rv = new ArrayList();
			for (int i = 0; i < result.size(); i++) {
				ETIPResultSet newItem = new ETIPResultSet();
				newItem.putAll((Map) result.get(i));
				rv.add(newItem);
			}
			return rv;
		} catch (DataAccessException ex) {
			throw new ETIPError("JdbcDao_queryForList", ex);
		}
	}
	
	public List<IData> queryForObjectList(String sql, Object[] parameters,
			IResultSetMap queryMap) throws ETIPException {
		try {
			List result = null;
			if (parameters == null) {
				result = this.getJdbcTemplate().queryForList(sql);
			} else {
				result = this.getJdbcTemplate().queryForList(sql, parameters);
			}
			ETIPResultSet[] rv = new ETIPResultSet[result.size()];
			for (int i = 0; i < result.size(); i++) {
				rv[i] = new ETIPResultSet();
				Map resulti = (Map) result.get(i);
				Object[] keys = resulti.keySet().toArray();
				for(int j=0;j<keys.length;j++){
					rv[i].put(keys[j],resulti.get(keys[j]));
				}
			}

			List<IData> rvList = new ArrayList();
			for (int i = 0; i < rv.length; i++) {
				rvList.add((IData)queryMap.map(rv[i]));
			}
			return rvList;
		} catch (DataAccessException ex) {
			throw new ETIPError("JdbcDao_queryForObjectList", ex);
		}
	}
	
	public List<ETIPResultSet> search(PageRoll page) {
		page.setTotalRows(this.getJdbcTemplate().queryForInt(page.getCountSQL()));
		StringBuffer sql = new StringBuffer("select /*+ FIRST_ROWS */* from (select t.*, rownum num from (");
		sql.append(page.getSearchSQL());
		sql.append(") t where rownum <= ").append(page.getStartRow() + page.getPageSize()).append(") where num > ").append(page.getStartRow());
		List result = this.getJdbcTemplate().queryForList(sql.toString());
		List<ETIPResultSet> rv = new ArrayList<ETIPResultSet>();
		for (int i = 0; i < result.size(); i++) {
			ETIPResultSet newItem = new ETIPResultSet();
			newItem.putAll((Map) result.get(i));
			rv.add(newItem);
		}
		return rv;
	}
	
	/**
	 * 分页传参方法,支持sql条件是问号的
	 * @param page 分页对象
	 * @param parameters 参数
	 * @author 大勇 2013-8-22
	 * @return
	 */
	public List<ETIPResultSet> search(PageRoll page,Object[] parameters) {
		try {
			
			if(parameters.length>0){
				page.setTotalRows(this.getJdbcTemplate().queryForInt(page.getCountSQL(),parameters));
			}else{
				page.setTotalRows(this.getJdbcTemplate().queryForInt(page.getCountSQL()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sql = new StringBuffer("select /*+ FIRST_ROWS */* from (select t.*, rownum num from (");
		sql.append(page.getSearchSQL());
		sql.append(") t where rownum <= ").append(page.getStartRow() + page.getPageSize()).append(") where num > ").append(page.getStartRow());
		List result = new ArrayList();
		if(parameters.length>0){
			result = this.getJdbcTemplate().queryForList(sql.toString(),parameters);
		}else{
			result = this.getJdbcTemplate().queryForList(sql.toString());
		}
		if(result.size()==0&&page.getCurrentPage()!=0){
			page.setCurrentPage(0);
			return search( page, parameters);
		}
		List<ETIPResultSet> rv = new ArrayList<ETIPResultSet>();
		for (int i = 0; i < result.size(); i++) {
			ETIPResultSet newItem = new ETIPResultSet();
			newItem.putAll((Map) result.get(i));
			rv.add(newItem);
		}
		//数据汇总
		if(page.getSumSQL()!=null && page.getSumSQL().length()>0){
			List sumResult = this.addSumList(page, parameters);
			ETIPResultSet newItem = new ETIPResultSet();
			newItem.putAll((Map) sumResult.get(0));
			rv.add(newItem);
		}
		return rv;
	}
	
	/**
	 * 分页传参方法,支持sql条件是问号的
	 * @param page 分页对象
	 * @param parameters 参数
	 * @author 大勇 2013-8-22
	 * @return
	 */
	public List<ETIPResultSet> search(PageRoll page,List<Object> objects) {
		return search(page, objects.toArray());
	}
	/**
	 * 执行汇总sql
	 * @param page 分页对象
	 * @param parameters 参数
	 * @return
	 */
	public List addSumList(PageRoll page,Object[] parameters ){
		List sumResult = new ArrayList();
		if(parameters.length>0){
			sumResult = this.getJdbcTemplate().queryForList(page.getSumSQL(),parameters);
		}else{
			sumResult = this.getJdbcTemplate().queryForList(page.getSumSQL());
		}
		return sumResult;
	}
}
