package com.itour.etip.pub.kit.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

public class BeanNamesFactoryBean extends JdbcDaoSupport implements FactoryBean {

	private String beanNameQuery = null;

	private MappingSqlQuery beanNameMapping = null;

	public BeanNamesFactoryBean() {
		this.beanNameQuery = "select serviceaddress from serviceRegistry where serviceType='method'";
	}

	/**
	 * 去掉包名和方法名
	 */
	public Object getObject() {
		List<String> bList = new LinkedList<String>();
		try {
			List list = beanNameMapping.execute();
			
			for (Object obj : list) {
				String bName = obj.toString();
				int end = bName.lastIndexOf(".");
				int begin = bName.lastIndexOf(".", end - 2) + 1;
				if (end > 0 && begin > 0) {
					bList.add(bName.substring(begin, end));
				}
			}
		} catch (Exception ex) {
			System.out.println("ex:"+ex.getMessage());
		}
		/**
		 * beanNames 变量不能为空，至少要有一个。所以如果数据库中没有配置，则需要增加一个默认值， 否则系统不能正常启动。
		 */
		if (bList.size() == 0) {
			bList.add("EtipBeanNames");
		}
		return bList;
	}

	public Class getObjectType() {
		return java.util.List.class;
	}

	public boolean isSingleton() {
		return true;
	}

	
	protected void initDao() throws Exception {
		super.initDao();
		this.beanNameMapping = new BeanNameMapping(getDataSource());
	}

	private class BeanNameMapping extends MappingSqlQuery {
		protected BeanNameMapping(DataSource ds) {
			super(ds, beanNameQuery);
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			return rs.getString(1);
		}
	}

	public String getBeanNameQuery() {
		return beanNameQuery;
	}

	public void setBeanNameQuery(String beanNameQuery) {
		this.beanNameQuery = beanNameQuery;
	}

}
