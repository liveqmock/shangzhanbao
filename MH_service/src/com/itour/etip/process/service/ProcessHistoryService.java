package com.itour.etip.process.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.support.data.ProcessHistoryData;
import com.itour.etip.support.persistence.IProcessHistoryPersistence;

public class ProcessHistoryService implements IProcessHistoryService {
	private IProcessHistoryPersistence processHistoryPersistence;
	/**
	 * 查询流程历史
	 * @return
	 */
	public List<ProcessHistoryData> searchProcessHistory(PageRoll pageRoll,
			JSONObject obj) {
		
		String jbpmClassName = obj.getString( "jbpmClassName" ) ;
		String taskName = "启动" ;
		String operatorID = FrmUser.getUser().etipOperatorId ;
		
		String searchSQL = "from ProcessHistoryData p where 1 = 1 " ;
		
		if( !"".equals(jbpmClassName) && !"0".equals(jbpmClassName) ) {
			searchSQL += " and p.jbpmClassName = '"+ jbpmClassName +"' " ;
		}
			searchSQL += " and p.taskName = '"+ taskName + "' " ;
			searchSQL += " and p.operatorID = '" + operatorID + "' " ;
		String countSQL = "select count (*) " + searchSQL ;
		pageRoll.setSearchSQL(searchSQL);
		pageRoll.setCountSQL(countSQL);
		
		List<ProcessHistoryData> histories = processHistoryPersistence.search(pageRoll);

		return histories;
	}
	/**
	 * 查询指定id计划的审批历史
	 * @param obj
	 * @return
	 */
	public List<ProcessHistoryData> detailHistory( JSONObject obj ) {
		String jbpmObjectID = obj.getString( "id" ) ;
		
		String searchSQL = " from ProcessHistoryData p where p.jbpmObjectID = '" + jbpmObjectID + "'";
		
		List<ProcessHistoryData> histories = processHistoryPersistence.search(searchSQL);
		
		return histories;
		
	}
	
	/**
	 * 将计划的id变为计划名称
	 *
	 */
	public String convertIDtoClass ( String planID , String className ) {
		
		String searchSQL = "select * from " + className + "  d where d.id = '" + planID + "'" ;
		
		JdbcDao jdbc = ( JdbcDao ) SpringContextHelper.getBean( "jdbc" ) ;
		
		List <ETIPResultSet> classList = jdbc.queryForList( searchSQL , null ) ;
		
		if ( classList.size() == 0 ) {
			
			return "" ;
		}
		ETIPResultSet result = classList.get(0) ;
		
		/*
		 * 将指定类下的计划名称或规则类型返回
		 */
		
		if( className.equals( "LinkCardPlan" ) || className.equals( "MemberCardPlan" ) || className.equals( "CouponPlan" ) ) {
			
			return result.getString( "COUPONTITLE" ) ;
			
		} else if ( className.equals( "EventAwardScoreRule" ) ) {
			
			return result.getString( "EVENTRULENAME" ) ;
			
		} else if ( className.equals( "EventReduceScoreRule" ) ) {
			
			return result.getString( "EVENTRULECODE" ) ;
			
		} else if ( className.equals( "ScoreExchangeRule" ) ) {
		
			return result.getString( "EXCHANGERULECODE" ) ;
		
		} else if ( className.equals( "MemberCreditRule" ) ) {
		
			return CacheUtil.getInstance().getCacheName( "CreditLevel" ,  result.getString( "CREDITLEVEL" ) ) ;
		
		}  else if ( className.equals( "MemberRankRule" ) ) {
		
			return CacheUtil.getInstance().getCacheName( "BizRoleRank" ,  result.getString( "RANK" ) ) ;
		
		} else if ( className.equals( "PreferenceExlueRule" ) ) {
			
			return CacheUtil.getInstance().getCacheName( "ProductType" ,  result.getString( "PRODUCTTYPE" ) ) ;
		}else if ( className.equals( "GroupBizContract" ) ) {
			
			return result.getString( "CONTRACTNAME" ) ;
			
		}
		
		return "" ;
		
	}
	public IProcessHistoryPersistence getProcessHistoryPersistence() {
		return processHistoryPersistence;
	}
	public void setProcessHistoryPersistence(
			IProcessHistoryPersistence processHistoryPersistence) {
		this.processHistoryPersistence = processHistoryPersistence;
	}

}
