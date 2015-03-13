package com.itour.etip.pub.kit.cache;

import java.util.HashMap;
import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

public class IDMappingNameCache{
	
	
	public static HashMap<String,String> nameMap = new HashMap<String,String>();
	
	public static void init(){
		
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		
		String sbSql ="select e.id,e.name  from tb_sys_user e"; 
		
//		StringBuffer sbSql = new StringBuffer();
//		sbSql.append("select * from ( ");
//		sbSql.append("select e.id, g.chinesename ");
//		sbSql.append(" from etipuser e, etipoperator o, groupuser g ");
//		sbSql.append(" where e.memberid = o.id ");
//		sbSql.append(" and e.usertype = 3 ");
//		sbSql.append(" and g.etipoperator_id = o.id ");
//		sbSql.append(" union ");
//		sbSql.append("  select f.id, u.chinesename ");
//		sbSql.append(" from etipuser f, userbase u ");
//		sbSql.append(" where f.memberid = u.id ");
//		sbSql.append(" and f.usertype = 1 ");
//		sbSql.append(" union ");
//		sbSql.append(" select t.id,r.chinesename ");
//		sbSql.append(" from etipuser t, groupbase r ");
//		sbSql.append(" where t.memberid = r.id ");
//		sbSql.append(" and t.usertype = 2) ");
//		
		List<ETIPResultSet> result = jdbc.queryForList(sbSql.toString(),null);
		
		for(ETIPResultSet set:result){
			nameMap.put(set.getString("ID"), set.getString("NAME"));
		}
	}
}
