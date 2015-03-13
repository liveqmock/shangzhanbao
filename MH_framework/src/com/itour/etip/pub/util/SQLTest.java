package com.itour.etip.pub.util;

import java.lang.reflect.Method;
import java.util.Date;

import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.kit.tool.DateTool;

public class SQLTest {
	
	public static String makeSQL(String sql,IData data,String startDate,String endDate) {
		
		String propertyName = null;
		
		Object propertyValue = null;

		StringBuffer whereBuffer = new StringBuffer(" where 1>0 ");
		
		if(data != null){
			
			// 获得所有的get方法
			Method[] methods = data.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				// 返回get方法
				
				if (methods[i].getName().startsWith("get")) {
					// 遇到例外则忽略错误，进入下一个
					try {
						// 获得属性名称
						propertyName = methods[i].getName().substring(3);
						String firstChar = propertyName.charAt(0) + "";
						propertyName = firstChar.toLowerCase()
						+ propertyName.substring(1);
						// 属性名称的类型
						Class propertyType = methods[i].getReturnType();
						// 获得属性值
						propertyValue = methods[i].invoke(data, null);
						//未赋值不参与查询
						if(propertyValue==null){
							continue;
						}
						// 以下判断属性类型，自动组装where语句。
						String pTypeName = propertyType.getName();
						// 属性如果属于下列类型,必须拼写为查询条件
						if("int,double,long,float".indexOf(pTypeName) > -1){
							if((Integer)propertyValue == 0){
								continue;
							}
						}
						if ("boolean,java.lang.Boolean,byte,java.lang.Byte,short,java.lang.Short,int,java.lang.Integer,long,java.lang.Long,float,java.lang.Float,double,java.lang.Double"
								.indexOf(pTypeName) > -1) {
							whereBuffer.append(" and ");
							whereBuffer.append(propertyName);
							whereBuffer.append("=");
							whereBuffer.append(propertyValue);
							
						}
						if("java.util.Date".indexOf(pTypeName) > -1){
							String date = DateTool.format((Date)propertyValue, "yyyy-MM-dd");
							whereBuffer.append(" and ");
							whereBuffer.append(propertyName);
							whereBuffer.append("=");
							whereBuffer.append("to_date('"+date+"','yyyy-MM-dd')");
						}
						if ("java.lang.String".endsWith(pTypeName)) {
							//空串不参与查询
							String pStrValue = propertyValue.toString();
							if(pStrValue.trim().length()==0){
								continue;
							}
							whereBuffer.append(" and ");
							whereBuffer.append(propertyName);
							whereBuffer.append(" like ");
							whereBuffer.append("'%");
							whereBuffer.append(propertyValue);
							whereBuffer.append("%'");
							
							
						}
						else{
							//System.out.println("不自动支持此属性类型"+propertyName+":"+pTypeName+"，请自行拼SQL:");
						}
					} catch (Exception ex) {
						
					}
					
				}
			}
		}
		else if(startDate != null && startDate.trim().length()>0 && endDate != null && endDate.trim().length()>0){
			whereBuffer.append(" and ");
			whereBuffer.append(propertyName);
			whereBuffer.append(" between ");
			whereBuffer.append("to_date('");
			whereBuffer.append(startDate);
			whereBuffer.append("','yyyy-MM-dd') and to_date('");
			whereBuffer.append(endDate);
			whereBuffer.append("','yyyy-MM-dd')");
		}
		
		String where = sql+whereBuffer.toString();
		
		return where;
		
	}
	
	/**
	 * 拼Hql语句，注意Hql语句都是对象，要取别名，如：
	 * from MemberCardPlanHistoryData o where 1>0 and o.operatorDesc='aaa'
	 * 那么复杂判断必须手动拼写，治理只做等于判断
	 * @param sql
	 * 		from MemberCardPlanHistoryData
	 * @param data
	 * 		MemberCardPlanHistoryData的实例，并且operatorDesc属性为aaa，其他null
	 * @param startDate
	 * 		null，暂时无作用
	 * @param endDate
	 * 		null，暂时无作用
	 * @return
	 * 		from MemberCardPlanHistoryData o where 1>0 and o.operatorDesc='aaa'
	 */
	public static String makeHQL(String sql,IData data,String startDate,String endDate) {
		
		String propertyName = null;
		
		Object propertyValue = null;

		StringBuffer whereBuffer = new StringBuffer(" o where 1>0 ");
		
		if(data != null){
			
			// 获得所有的get方法
			Method[] methods = data.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				// 返回get方法
				
				if (methods[i].getName().startsWith("get")) {
					// 遇到例外则忽略错误，进入下一个
					try {
						// 获得属性名称
						propertyName = methods[i].getName().substring(3);
						String firstChar = propertyName.charAt(0) + "";
						propertyName = firstChar.toLowerCase()
						+ propertyName.substring(1);
						// 属性名称的类型
						Class propertyType = methods[i].getReturnType();
						// 获得属性值
						propertyValue = methods[i].invoke(data, null);
						//未赋值不参与查询
						if(propertyValue==null){
							continue;
						}
						// 以下判断属性类型，自动组装where语句。
						String pTypeName = propertyType.getName();
						// 属性如果属于下列类型,必须拼写为查询条件
						if("int,double,long,float".indexOf(pTypeName) > -1){
							if((Integer)propertyValue == 0){
								continue;
							}
						}
						if ("boolean,java.lang.Boolean,byte,java.lang.Byte,short,java.lang.Short,int,java.lang.Integer,long,java.lang.Long,float,java.lang.Float,double,java.lang.Double"
								.indexOf(pTypeName) > -1) {
							whereBuffer.append(" and o.");
							whereBuffer.append(propertyName);
							whereBuffer.append("=");
							whereBuffer.append(propertyValue);
							
						}
						if("java.util.Date".indexOf(pTypeName) > -1){
							String date = DateTool.format((Date)propertyValue, "yyyy-MM-dd");
							whereBuffer.append(" and o.");
							whereBuffer.append(propertyName);
							whereBuffer.append("=");
							whereBuffer.append("to_date('"+date+"','yyyy-MM-dd')");
						}
						if ("java.lang.String".endsWith(pTypeName)) {
							//空串不参与查询
							String pStrValue = propertyValue.toString();
							if(pStrValue.trim().length()==0){
								continue;
							}
							whereBuffer.append(" and o.");
							whereBuffer.append(propertyName);
							whereBuffer.append("=");
							whereBuffer.append("'");
							whereBuffer.append(propertyValue);
							whereBuffer.append("'");
							
							
						}
						else{
							//System.out.println("不自动支持此属性类型"+propertyName+":"+pTypeName+"，请自行拼SQL:");
						}
					} catch (Exception ex) {
						
					}
					
				}
			}
		}
		else if(startDate != null && startDate.trim().length()>0 && endDate != null && endDate.trim().length()>0){
			whereBuffer.append(" and o.");
			whereBuffer.append(propertyName);
			whereBuffer.append(" between ");
			whereBuffer.append("to_date('");
			whereBuffer.append(startDate);
			whereBuffer.append("','yyyy-MM-dd') and to_date('");
			whereBuffer.append(endDate);
			whereBuffer.append("','yyyy-MM-dd')");
		}
		
		String where = sql+whereBuffer.toString();
		
		return where;
		
	}
	
}