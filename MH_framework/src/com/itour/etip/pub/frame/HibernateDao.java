/********************************************************
 Copyright (C), 2009-2010, gomai.
 File name:    com/itour/etip/frame/HibernateDao.java
 Description:  数据访问对象的Hibernate实现
 Author: txc      Version:  1.0.0  Date: 2009.4.8
 ***********************************************************/
package com.itour.etip.pub.frame;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.list.TreeList;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itour.etip.pub.base.IDao;
import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.kit.exception.BaseException;
import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.exception.SysException;
import com.itour.etip.pub.util.XmlUtils;

public class HibernateDao extends HibernateDaoSupport implements IDao {
	
	public HibernateTemplate getHT(){
		HibernateTemplate rv = super.getHibernateTemplate();
		rv.setCacheQueries(true);
		return rv;
	}
	
	/**
	 * 不带分页的sql语句查询，此处必须是SqlQuery配置项
	 * 
	 * @param sqlName
	 *            sqlQuery名称
	 * @param entities
	 *            sql语句执行完成后，结果集对象类型。
	 * @param parameters
	 *            sql语句中的参数映射表，要求每个参数采用name,value方式放入到map中，而且value必须是对象类型。
	 * @return 返回值列表，列表的每个元素是IData数组。
	 * @throws ETIPError
	 *             hibernate_search_sql_page 查询时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public List searchBySQL(String sqlName, Map parameters) {
		Session session = null;
		List list = null;

		try {
			session = getHT().getSessionFactory().getCurrentSession();
			// res=session.().createStatement().execute(sql);
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			SQLQuery sqlQuery = (SQLQuery) query;
			list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			throw new SysException("90003",null, e);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			/*session.flush();
			session.close();*/
		}
	}
	
	public List searchBySQLNew(final String sql,final Object[] parameters) {
		Session session = null;
		List list = new ArrayList();
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			//Query query = session.createQuery(sql);
			SQLQuery query = session.createSQLQuery(sql); // LMH  解决框架中 不能使用原生态SQL 查询问题 2012-04-26
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
			
			list = query.list();
			/*list = getHT().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(sql);
					for(int i=0;i<parameters.length;i++){
						query.setParameter(i, parameters[i]);
					}
					
					return query.list();
				}
			});*/
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public void call(Object[] args){
		Connection conn =null;
		Session session = null;
		CallableStatement call =null;
		try{
			conn = getHT().getSessionFactory().getCurrentSession().connection();
			call = conn.prepareCall(args[0].toString());
			call.setString(1, args[1].toString());
			call.execute();
			session.getTransaction().commit();
		}catch (HibernateException e) {
			throw new SysException("90003",null, e);
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			session.flush();
			/*session.close();*/
		}
	}
	
	public void call(String sql){
		Session session = null;
		try{
			session = getHT().getSessionFactory().getCurrentSession();
			Query q = session.createSQLQuery(sql);
			String res = (String)q.uniqueResult();
			//System.out.println(res);
		}catch (HibernateException e) {
			throw new SysException("90003",null, e);
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			session.flush();
			/*session.close();*/
		}
	}
	
	
	/**
	 * 调用存储过程
	 * @param pName
	 * @param args
	 * @param outIndex
	 * add by smh
	 */
	@SuppressWarnings("deprecation")
	public void callParam(String pName, Object[] args, int[] outIndex) {
		Connection conn = null;
		CallableStatement call = null;

		int len = args.length;

		StringBuffer statement = new StringBuffer("{ call " + pName + "(");

		for (int i = 0; i < len; i++) {
			if (i == len - 1) {
				statement.append("?)}");
			} else {
				statement.append("?,");
			}
		}

		try {
			conn = getHT().getSessionFactory().getCurrentSession().connection();
			call = conn.prepareCall(statement.toString());
			if (outIndex != null) {
				for (int i = 0; i < outIndex.length; i++) {
					call.registerOutParameter(outIndex[i], Types.VARCHAR);
				}
			}

			for (int i = 0; i < len; i++) {
				if (args[i] == null)
					call.setNull(i + 1, Types.VARCHAR);
				else
					call.setObject(i + 1, args[i]);
			}

			call.execute();

			if (outIndex != null) {
				for (int i = 0; i < outIndex.length; i++) {
					args[outIndex[i] - 1] = call.getString(outIndex[i]);
				}
			}

			conn.commit();
			
		} catch (HibernateException e) {
			throw new SysException("90004",null, e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	

	/**
	 * 带分页的sql语句查询，此处必须是SqlQuery配置项
	 * 
	 * @param sqlName
	 *            sqlQuery名称
	 * @param entities
	 *            sql语句执行完成后，结果集对象。
	 * @param parameters
	 *            sql语句中的参数映射表，要求每个参数采用name,value方式放入到map中，而且value必须是对象类型。
	 * @param offset
	 *            开始查询的记录数。
	 * @param length
	 *            查询的记录长度
	 * @return 返回值列表，列表的每个元素是IData数组。
	 * @throws ETIPError
	 *             hibernate_search_sql_page 查询时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public List searchBySQLWithPage(String sqlName, Map parameters, int offset,
			int length) {
		Session session = null;
		List list = null;
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			query.setFirstResult(offset);
			query.setMaxResults(length);
			SQLQuery sqlQuery = (SQLQuery) query;
			list = sqlQuery.list();
			return list;
		} catch (HibernateException e) {
			throw new SysException("90003",null, e);
		} finally {
			/*session.flush();
			session.close();*/
		}

	}

	/**
	 * 调用配置文件中的sql语句，用于更新
	 * 
	 * @param sqlName
	 *            hibernate配置文件中sql名字，可以使Query和sqlQuery配置。
	 * @param parameters
	 *            sql语句中的参数，要求使用name,value放置到map中，并且所有的value类型都必须是Object。
	 * @return 更新影响的的记录数
	 * @throws ETIPError
	 *             hibernate_search_sql_update 更新时由于Hibernate
	 *             API抛出的错误，可能是数据库系统错误或Hibernate报错
	 */
	public int updateBySQL(String sqlName, Map parameters) {
		Session session = null;
		int result = 0;
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			Query query = session.getNamedQuery(sqlName);
			Object[] keys = parameters.keySet().toArray();
			for (Object key : keys) {
				query.setParameter((String) key, parameters.get(key));
			}
			return result;
		} catch (HibernateException e) {
			throw new SysException("90003",null, e);
		} finally {
			session.flush();
			/*session.close();*/
		}
	}
	
	public int updateBySQL_SQL(String sql, Object[] parameters) {
		Session session = null;
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			Query query = session.createQuery(sql);
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
			return query.executeUpdate();
		} catch (HibernateException e) {
			throw new SysException("90003",null, e);
		} finally {
			session.flush();
			/*session.close();*/
		}
	}
	
	public int executeSQL(String sql, Object[] parameters) {
		//final Type[] types={Hibernate.STRING,Hibernate.STRING}; 
		Session session = null; 
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			Query query = session.createSQLQuery(sql);
//			for(int i=0;i<parameters.length;i++){
//				query.setParameter(i, parameters[i]);
//			}
//			if(parameters!=null&&parameters.length>0){
//				//query.setParameters( parameters,paramType);
//				/*if(parameters.length!=paramType.length){//两个参数长度不一致则退出
//					throw new SysException("参数与参数类型不匹配",null);
//				}
//				for(int i=0;i<parameters.length;i++){
//					if(paramType[i].equals(Hibernate.STRING)){
//						query.setString(i,(String)parameters[i]);
//					}else if(paramType[i].equals(Hibernate.INTEGER)){
//						query.setInteger(i,(Integer)parameters[i]);
//					}
//					
//				}*/
//				for(int i=0;i<parameters.length;i++){
//					query.setParameter(i, parameters[i]);
//				}
//			}
//			System.out.println("----"+query.getQueryString());
			return query.executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new SysException("90003",null, e);
		} finally {
			session.flush();
			/*session.close();*/
		}
	}

	/**
	 * 暂时保留，用于更新字段,2009-4-22
	 */
	public int updateBySQL(final String sql) {
		return (Integer)getHT().execute(new HibernateCallback(){
			public Object doInHibernate(Session session){
				int i=0;
				try {
					i = session.createSQLQuery(sql).executeUpdate();
				} catch (HibernateException e) {
					
					e.printStackTrace();
				}finally{
					session.flush();
					/*session.close();*/
				}
				return i;
			}
			
		});
		/*Session session = null;
		int result = 0;
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			result = session.createSQLQuery(sql).executeUpdate();
			return result;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			throw new ETIPError("hibernate_search_sql_update", e);
		} finally {
			session.flush();
			session.close();
		}*/
	}
	
	/**
	 * hibernate分页查询
	 * @author Administrator
	 * @date 2009-9-29
	 * @param hql 查询语句
	 * @param offset 起始行
	 * @param length 最多记录数
	 * @return 集合
	 */
	public List<? extends IData> search(final String hql,final int offset,
			final int length) {
		
		try {
			return getHT().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
						query.setFirstResult(offset);
						query.setMaxResults(length);
					return query.list();
				}
			});
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
	}

	public void delete(IData data) {
		
		try {
			getHT().delete(data);
		} catch (DataAccessException e) {
			//此处封装自定义异常，重新编码
			throw new SysException("90005",null, e);
		}finally{
			getHT().flush();
			/*session.close();*/
		}

	}

	/**
	 * 使用指定的id,加载对象
	 * 
	 * @param cls
	 *            类
	 * @param id
	 *            主键
	 * @return 记录对象
	 */
	public IData load(Class cls, Object id) {
		Session session = null;
		try {
			session = getHT().getSessionFactory().getCurrentSession();
			Object rtnObj = session.load(cls, (Serializable) id);
			// 未取得对象，就直接返回null
			if (rtnObj == null) {
				return null;
			}
			/*
			 * 如果返回值中存在set或list，而且方法名为get开头的，那么就加载一次，这是为了主动进行懒加载
			 * 以下代码存在效率浪费，将所有属性遍历一次挺花时间的，如果需要提高效率，最好将这段代码独立出来
			 * 人工主动调用。
			 * 
			 */
			Method[] methods = rtnObj.getClass().getMethods();
			String rvType = null;
			for (int j = 0; j < methods.length; j++) {
				rvType = methods[j].getReturnType().getName().toLowerCase();
				if ((rvType.equals("java.util.set")
						|| rvType.equals("java.util.list") && methods[j].getName().startsWith("get"))) {
					try {
						Hibernate.initialize(methods[j].invoke(rtnObj, null));
					} catch (Exception e) {
						throw new SysException("90006",null, e);
					}
				}
			}

			return (IData) rtnObj;
		} catch (BaseException e) {
			throw e;
		} finally {
			/*try {
				session.flush();
			} catch (HibernateException e2) {
				e2.printStackTrace();
				throw new ETIPError("HibernateHelper_load", e2);
			}
			try {
				session.close();
			} catch (HibernateException e3) {
				throw new ETIPError("HibernateHelper_load", e3);
			}*/
		}

	}

	public List<IData> loadAll(Class entityClass) {
		
		try {
			return getHT().loadAll(entityClass);
		} catch (DataAccessException e) {
			throw new SysException("90006",null, e);
		}
	}

	public void save(IData data) {
		
		try {
			getHT().save(data);

		} catch (DataAccessException e) {
			throw new SysException("90007",null, e);
		}finally{
			getHT().flush();
			/*session.close();*/
		}
	}
	
	public Object saveR(IData data) {
		
		try {
			Object ID = getHT().save(data);
			return ID;
		} catch (DataAccessException e) {
			throw new SysException("90007",null, e);
		}finally{
			getHT().flush();
			/*session.close();*/
		}
	}

	public List<? extends IData> search(String hql) {
		
		try {
			
			return getHT().find(hql);
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
	}

	public List<? extends IData> search(String hql, Object[] parameters) {
		
		try {
			return getHT().find(hql, parameters);
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
	}

	public List<? extends IData> search(final PageRoll pageRoll) {
		
		try {
			return getHT().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					String countSQL = pageRoll.getCountSQL();
					Query query = session.createQuery(countSQL);
					query.setCacheable(true);//设置使用缓存
					long count = ((Long) query.list().get(0)).longValue();
					pageRoll.setTotalRows((int) count);
					if (count == 0) {
						return new TreeList();
					}
					String searchSQL = pageRoll.getSearchSQL();
					query = session.createQuery(searchSQL);
					if (pageRoll.getPageSize() > 0) {
						query.setFirstResult(pageRoll.getStartRow());
						query.setMaxResults(pageRoll.getPageSize());
					}

					return query.list();

				}
			});
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
	}
	
	/**
	 * 分页传参方法,支持hql条件是问号的
	 * @param pageRoll 分页对象
	 * @param objects 参数
	 * @return
	 */
	public PageRoll search(final PageRoll pageRoll,final Object[] objects ) {
		
		List list = new ArrayList();
		try {
			list = getHT().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					String countSQL = pageRoll.getCountSQL();
					Query query = session.createQuery(countSQL);
					for(int i=0;i<objects.length;i++){
						query.setParameter(i, objects[i]);
					}
					long count = ((Long) query.list().get(0)).longValue();
					pageRoll.setTotalRows((int) count);
					String searchSQL = pageRoll.getSearchSQL();
					query = session.createQuery(searchSQL);
					for(int i=0;i<objects.length;i++){
						query.setParameter(i, objects[i]);
					}
					if (pageRoll.getPageSize() > 0) {
						query.setFirstResult(pageRoll.getStartRow());
						query.setMaxResults(pageRoll.getPageSize());
					}
					List pageList = query.list();
					List sumList = new ArrayList();
					//数据汇总
//					if(pageRoll.getSumSQL()!=null && pageRoll.getSumSQL().length()>0){
//						List sumResult = new ArrayList();
//						query = session.createQuery(pageRoll.getSumSQL());
//						for(int i=0;i<objects.length;i++){
//							query.setParameter(i, objects[i]);
//						}
//						sumList = query.list();
//					}
					if(!sumList.isEmpty()){
						pageList.add(sumList.get(0));
					}
					return pageList;

				}
			});
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
		pageRoll.setList(list);
		/*List<ETIPResultSet> rv = new ArrayList<ETIPResultSet>();
		for (int i = 0; i < list.size(); i++) {
			ETIPResultSet newItem = new ETIPResultSet();
			newItem.putAll((Map) list.get(i));
			rv.add(newItem);
		}*/
		return pageRoll;
	}
	
	public String searchXml(final PageRoll pageRoll) {
		try {
			return XmlUtils.beanListToXml(getHT().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session) throws HibernateException, SQLException {
					String countSQL = pageRoll.getCountSQL();
					Query query = session.createQuery(countSQL);
					query.setCacheable(true);//设置使用缓存
					long count = ((Long) query.list().get(0)).longValue();
					pageRoll.setTotalRows((int) count);
					if (count == 0) {
						return new TreeList();
					}
					String searchSQL = pageRoll.getSearchSQL();
					query = session.createQuery(searchSQL);
					if (pageRoll.getPageSize() > 0) {
						query.setFirstResult(pageRoll.getStartRow());
						query.setMaxResults(pageRoll.getPageSize());
					}
					return query.list();
				}
			}), pageRoll.getTotalRows()+"");
		} catch (DataAccessException e) {
			throw new SysException("90003",null, e);
		}
	}

	public void update(IData data) {
		

		Session session = null;
		try {
			//session = getHT().getSessionFactory().getCurrentSession();
			// Object loadObj =
			// session.load(data.getClass(),(Serializable)data.getId());
			// java.lang.reflect.Field[] fields = data.getClass().getFields();
			// //String typeName = null;
			// for (int i = 0; i < fields.length; i++) {
			// String typeName = fields[i].getType().getName();
			// //子表属性
			// if
			// (typeName.equals("java.util.list")||typeName.equals("java.util.List"))
			// {
			// //现有的子表属性
			// java.util.List targetSet =
			// (java.util.List)fields[i].get(loadObj);
			// //新对象子表属性。
			// java.util.List sourceSet = (java.util.List)fields[i].get(data);
			// //清除已有的子表
			// targetSet.clear();
			// //添加新子表
			// java.util.Iterator iters = sourceSet.iterator();
			// while (iters.hasNext()) {
			// targetSet.add(iters.next());
			// }
			// }
			// //其它属性直接设置
			// else if (
			// typeName.equals("int")
			// || typeName.equals("long")
			// || typeName.equals("float")
			// || typeName.equals("double")
			// || typeName.equals("boolean")
			// || typeName.equals("java.lang.Float")
			// || typeName.equals("java.lang.Integer")
			// || typeName.equals("java.lang.Double")
			// || typeName.equals("java.sql.Date")
			// || typeName.equals("java.sql.Timestamp")
			// || typeName.equals("java.util.Date")
			// || typeName.equals("java.lang.Long")
			// || typeName.equals("java.lang.String")) {
			// fields[i].set(loadObj, fields[i].get(data));
			// }
			// }
			// 更新对象
//			 if(session.get(data.getClass(), data.getId())!=null)
//					session.clear();
//			session.clear();
//			getHibernateTemplate().update(data);
			getHibernateTemplate().merge(data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SysException("90008",null, e);
		} finally {
			getHT().flush();
			/*try {
				session.flush();
			} catch (HibernateException e2) {
				e2.printStackTrace();
				throw new ETIPError("Hibernate_update", e2);
			}
			try {
				session.close();
			} catch (HibernateException e3) {
				e3.printStackTrace();
				throw new ETIPError("Hibernate_update", e3);
			}*/
		}

	}

	public IData retrieve(Class cls, Serializable id) throws BaseException {
		try {
			return (IData) getHT().get(cls, id);
		} catch (DataAccessException e) {
			throw new SysException("90009",null, e);
		}
	}

	public void saveOrUpdate(IData data) {
		try {
			getHT().saveOrUpdate(data);
		} catch (DataAccessException e) {
			throw new SysException("90009",null, e);
		}finally{
			getHT().flush();
			/*session.close();*/
		}
	}

	public void saveOrUpdateAll(Collection<IData> datas) {
		try {
			getHT().saveOrUpdateAll(datas);
		} catch (DataAccessException e) {
			throw new SysException("90009",null, e);
		}finally{
			getHT().flush();
			/*session.close();*/
		}
	}

	

}
