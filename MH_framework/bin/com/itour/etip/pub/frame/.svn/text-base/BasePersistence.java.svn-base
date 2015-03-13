package com.itour.etip.pub.frame;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.kit.exception.ETIPException;

public abstract class BasePersistence<T extends IData> extends FrmPersistence implements
		IBasePersistence<T> {
	private Class<T> dataClass;
	/**
	 * 默认构造参数，确定dataClass的类型。
	 *
	 */
	public BasePersistence() {
		this.dataClass = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getDataClass() {
		return dataClass;
	}
	
	public void add(T data){
		((HibernateDao) DaoFactory.getDao("hibernate")).save(data);
	}
	
	public void update(T data) {
		((HibernateDao) DaoFactory.getDao("hibernate")).update(data);
	}
	public void updateWithOutNullProp(T data) {
		T data1 = retrieve(data.getId());
		 PropertyDescriptor[] props = null;   
	        try {   
	            props = Introspector.getBeanInfo(data.getClass(), Object.class)   
	                    .getPropertyDescriptors(); 
	            if(props!=null){
	            	for(int i=0;i<props.length;i++){
	            		String str = "id,version,isDelete";
	            		String name = props[i].getName();
	            		if(str.indexOf(name)>-1){
	            			continue;
	            		}
	            		Object object = props[i].getReadMethod().invoke(data);
	            		if(object!=null){
	            			props[i].getWriteMethod().invoke(data1, object);
	            		}
	            	}
	            }
	        } catch (IntrospectionException e) {   
	        } catch (IllegalArgumentException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IllegalAccessException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (InvocationTargetException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
		
		((HibernateDao) DaoFactory.getDao("hibernate")).update(data1);
		data = data1;
	}
	
	public void delete(T data) {
		((HibernateDao) DaoFactory.getDao("hibernate")).delete(data);
	}
	
	public void saveOrUpdate(T data) {
		((HibernateDao)DaoFactory.getDao("hibernate")).saveOrUpdate(data);
	}
	/**
	 * 通过id删除对象
	 * @param id
	 * 		需要删除的对象的主键id
	 * 
	 */
	public void delete(String id){
		T data = (T) ((HibernateDao) DaoFactory
				.getDao("hibernate")).load(getDataClass(), id);
		//当查询出的对象不为空时，才执行删除操作
		if(data != null) {
			delete(data);
		}
	}

	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			T data = (T)load(ids[i]);
			if(data != null) {
				delete(data);
			}
		}
	}

	public int updateBySQL_SQL(String sql, Object[] parameters){
		return ((HibernateDao) DaoFactory.getDao("hibernate")).updateBySQL_SQL(sql, parameters);
	}
	public int executeSQL(String sql, Object[] parameters){
		return ((HibernateDao) DaoFactory.getDao("hibernate")).executeSQL(sql, parameters);
	}

	public int executeSQL(String sql)  {
		return ((HibernateDao) DaoFactory.getDao("hibernate")).updateBySQL(sql);
	}

	public T load(String id)  {		
		return (T) ((HibernateDao) DaoFactory.getDao("hibernate"))
				.load(getDataClass(), id);
	}

	public T retrieve(String id)  {
		return (T) ((HibernateDao) DaoFactory.getDao("hibernate"))
				.retrieve(getDataClass(), id);
	}

	public List<T> search(PageRoll pageRoll)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll);
	}
	
	
	public PageRoll search(PageRoll pageRoll,Object[] objects)  {
		return ((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll,objects);
	}
	
	/**
	 * 使用条件集合查询翻页数据
	 * @param pageRoll 
	 * @param objects List对象
	 * @return
	 * @date 2012-12-6 上午11:11:59
	 * @author 何大勇
	 */
	public PageRoll search(PageRoll pageRoll,List<Object> objects)  {
		if(objects==null){
			return ((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll,new Object[]{});
		}
		Object[] objects2 = objects.toArray();
		return ((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll,objects2);
	}
	public PageRoll search111(PageRoll pageRoll,Object[] objects)  {
		return ((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll,objects);
	}

	
	@Override
	public List searchByField(PageRoll pageRoll,T t,Map<String,String> map, String order){
		String searchSQL = "";
		if(t==null){
			return new ArrayList();
		}
		searchSQL += " from "+ t.getClass().getSimpleName();
		List<Object> objects = new ArrayList<Object>();
		PropertyDescriptor[] props = null; 
		try {   
			props = Introspector.getBeanInfo(t.getClass(), Object.class)   
					.getPropertyDescriptors();  
			if(map!=null){
				for(int i=0;i<props.length;i++){
					if(map.containsKey(props[i].getName())){
						String operate = map.get(props[i].getName());
						Object object = props[i].getReadMethod().invoke(t);
						if(object!=null){
							searchSQL += " and "+props[i].getName()+" "+operate+" ? ";
							if(operate.equals("like") && object instanceof String){
								object = "%" +(String)object +"%";
							}
							objects.add(object);
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		searchSQL = searchSQL.replaceFirst("and", "where");
		
		if(order !=null && !order.equals("")){
			searchSQL += " order by " + order;
		}
		
		pageRoll.setSearchSQL(searchSQL);
		pageRoll.setCountSQL("select count(*) "+searchSQL);
		
		return search(pageRoll, objects).getList();
	}
	public String searchXml(PageRoll pageRoll)  {
		return (String)((HibernateDao) DaoFactory.getDao("hibernate")).searchXml(pageRoll);
	}
	public List<T> search(String hql)  {	
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql);
	}
	public List searchBySQL(String sql,Object[] parameters){
		return (List)((HibernateDao) DaoFactory.getDao("hibernate")).searchBySQLNew(sql,parameters);
	}
	public List searchBySQL(String sql){
		return (List)((HibernateDao) DaoFactory.getDao("hibernate")).search(sql);
	}

	public List<T> search(String hql, Object[] parameters)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql, parameters);
	}

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
	@SuppressWarnings("unchecked")
	public List<Object[]> searchAny(String hql, Object[] parameters) {
		return (List<Object[]>)((HibernateDao) DaoFactory.getDao("hibernate")).getHT().find(hql, parameters);
	}
	@SuppressWarnings("unchecked")
	public List<T> search(String hql, List<Object> parameters)  {
		Object[] objects = parameters.toArray();
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql, objects);
	}
	
	public void call(Object[] args){
		((HibernateDao) DaoFactory.getDao("hibernate")).call(args);
	}
	public void call(String param){
		((HibernateDao) DaoFactory.getDao("hibernate")).call(param);
	}
	/**
	 * @author Administrator
	 * @date 2009-9-29
	 * @param hql hibernate查询语句
	 * @param offset 起始行
	 * @param length 最大记录数
	 * @return 
	 */
	public List<T> search(final String hql,final int offset,
			final int length)  {	
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql,offset,length);
	}
	
	/**
	 * 取得总记录数
	 * @param countString count语句
	 * @return 返回总的记录数
	 */
	public List<T> getTotalRows(final String countString)  {	
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(countString);
	}
	
}
