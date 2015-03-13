package com.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

/**
 * 生成订单编号 工具
 * @author 何大勇
 * @date 2013-8-19
 */
public class OrderCodeSetter {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	private static int SERIALIZE_NUM = -1;
	private static String DAY = simpleDateFormat.format(new Date());
	
	public static void setDay(){
		DAY = simpleDateFormat.format(new Date());
		initSerializeNum(); 
//		SERIALIZE_NUM=0;
	}
	
	
	/**
	 * 初始化序列号
	 * @author
	 * @date 2013-8-19
	 * @update
	 */
	public static void initSerializeNum(){
		if(SERIALIZE_NUM==-1){
			JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
			String sql = " select max(code) NUM from CTN_ORDER where code like ? or code like ? group by code ";
//			List<ETIPResultSet> etipResultSets = jdbcDao.queryForList(sql, new Object[]{"X"+DAY +"%","S"+DAY +"%"});
			List<ETIPResultSet> etipResultSets = jdbcDao.queryForList(sql, new Object[]{DAY +"%",DAY +"%"});
			String code = null;
			if(etipResultSets.size()>0){
				code = etipResultSets.get(0).getString("NUM");
				SERIALIZE_NUM = new Integer(code.substring(9));
			}else{
				SERIALIZE_NUM = 0;
			}
		}
	}
	
	public static String getCode(){
		SERIALIZE_NUM ++;
		String str = SERIALIZE_NUM+"";
		if(SERIALIZE_NUM<1000000){
			str = "0000000".substring(str.length())+str;
		}else{
			//TODO 未确定最大序列数  暂定1000000
		}
		return DAY+str;
	}
	
}
