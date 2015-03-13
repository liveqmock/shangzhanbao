package com.itour.etip.pub.base;

import java.util.List;
import java.util.Map;

import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.base.IPersistence;
import com.itour.etip.pub.frame.PageRoll;

public interface IBasePersistence<T extends IData> extends IPersistence{
		/**
		 * 持久化一个新IData对象到数据库
		 * @param data
		 * 		IData类型的对象，之前未存在于数据库
		 * @throws ETIPException
		 * 		持久化中发生的异常
		 */
		public void add(T  data );
		
		/**
		 * 持久化一个新的IData对象道数据库或者更新一个IData对象的状态到数据库
		 * @param data
		 */
		public void saveOrUpdate(T data);
		/**
		 * 更新一个IData对象的状态到数据库
		 * @param data
		 * 		IData类型的对象，
		 * 
		 */
		public void update(T data);
		/**
		 * 更新一个IData对象的状态到数据库
		 * @param data
		 * 		IData类型的对象，
		 * 
		 */
		public void updateWithOutNullProp(T data);
		/**
		 * 从数据库中删除一个data对象对应的记录
		 * @param data
		 * 		需要删除的data对象
		 * @throws ETIPException
		 * 		删除时发生的异常
		 */
		public void delete(T  data);
		/**
		 * 根据id删除对应的数据库记录
		 * @param id
		 * 		数据库记录的id
		 * @throws ETIPException
		 * 		删除时发生的异常
		 */
		public void delete(String id);
		/**
		 * 根据多个id删除数据库中的多条记录
		 * @param ids
		 * 		字符串数组，对应多条数据库记录的id
		 * @throws ETIPException
		 * 		删除记录时发生的异常
		 */
		public void delete(String[] ids);
		
		public void call(Object[] args);
		public void call(String param);
		
		public T load(String id);
		
		/**
		 * 根据主键id返回data对象
		 * @param id
		 * 		对象的主键id
		 * @return
		 * 		从数据库获取的对应主键id的对象
		 * @throws ETIPException
		 * 		查询时发生的异常。
		 */
		public T retrieve(String id);
		
		/**
		 * 按分页信息查询记录
		 * @param pageRoll
		 * 		分页对象，包含查询的语句
		 * @return
		 * 		List对象，其中的每个对象为符合查询条件和分页条件的数据对象。
		 * @throws ETIPException
		 */
		public List<T> search(PageRoll pageRoll);
		
		/**
		 * 按分页信息查询记录
		 * @param pageRoll
		 * 		分页对象，包含查询的语句
		 * @return
		 * 		String对象，其中的每个对象为符合查询条件和分页条件的数据对象。
		 * @throws ETIPException
		 */
		public String searchXml(PageRoll pageRoll);
		
		/**
		 * 根据hql，查询出符合条件的data对象
		 * @param hql
		 * 		hql语句，需要根据该语句查询数据库
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws ETIPException
		 * 		查询时发生的异常。
		 */
		public List<T> search(String hql);
		
		/**
		 * 根据PageRoll，查询出符合条件的data对象
		 * @param PageRoll
		 * 		分页对象
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws SysException
		 * 		查询时发生的异常。
		 */
		public PageRoll search(PageRoll pageRoll,Object[] objects);
		/**
		 * 根据字段查询列表
		 * @param pageRoll
		 * @param t 实体对象，不可为空
		 * @param map 需要查询的字段集合，格式："字段名","操作符",如："id","="。支持的操作符：=、>、<、<>、>=、<=、like、not like，可为空
		 * @param order 排序字段，支持多字段，逗号分开
		 * @return
		 * @date 2013-3-20 下午12:54:32
		 */
		public List searchByField(PageRoll pageRoll,T t,Map<String, String>  map,String order);
		/**
		 * 根据hql和给出的参数，查询出符合条件的data对象
		 * @param hql
		 * 		hql语句，需要根据该语句查询数据库
		 * @param parameters
		 * 		hql语句中的参数。
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws ETIPException
		 * 		查询时发生的异常。
		 */
		public List<T> search(String hql, Object[] parameters) ;
		/**
		 * 根据hql和给出的参数，查询出符合条件的data对象
		 * @param hql
		 * 		hql语句，需要根据该语句查询数据库
		 * @param parameters
		 * 		hql语句中的参数。
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws ETIPException
		 * 		查询时发生的异常。
		 */
		public List<Object[]> searchAny(String hql, Object[] parameters) ;
		
		/**
		 * 执行sql语句
		 * @param sql
		 * 		sql语句，一般为增删改语句
		 * @return
		 * 		受sql影响的数据库记录行数
		 * @throws ETIPException
		 * 		执行sql时发生的一场
		 */
		public int executeSQL(String sql);	
		
		/**
		 * @author Administrator
		 * 
		 * @date 2009-9-29
		 * @param hql hibernate查询语句
		 * @param offset 起始记录
		 * @param length 最多记录数
		 * @return
		 */
		public List<T> search(final String hql,final int offset,
				final int length);
		
		public int updateBySQL_SQL(String sql, Object[] parameters);
		
		/**
		 * 
		 * hibernate执行标准sql
		 * @param sql 标准sql
		 * @param parameters 参数
		 * @return 执行结果
		 */
		public int executeSQL(String sql, Object[] parameters);

		public PageRoll search(PageRoll pageRoll,List<Object> objects);
		public List<T> search(String hql, List<Object> parameters);
		
		public List<T> searchBySQL(String sql,Object[] parameters);
		public List searchBySQL(String sql);


}
