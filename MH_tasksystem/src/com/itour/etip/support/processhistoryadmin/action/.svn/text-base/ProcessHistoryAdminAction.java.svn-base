package com.itour.etip.support.processhistoryadmin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.tool.DateTool;
import com.itour.etip.support.data.ProcessHistoryData;
import com.itour.etip.support.processhistoryadmin.facade.ProcessHistoryAdminFacade;

/**
 * @author Administrator
 *
 */
public class ProcessHistoryAdminAction extends FrmAction {
	private ProcessHistoryAdminFacade processHistoryAdminFacade;
	/**
	 * 查询流程历史
	 * @return
	 */
	public String searchProcessHistory () {
		JSONObject json = ( JSONObject ) this.getJson() ;
		PageRoll pageRoll = new PageRoll() ;
		String start = request.getParameter( "start" ) ;
		String limit = request.getParameter( "limit" );
		pageRoll.setStartRow( Integer.valueOf ( start ) ) ;
		pageRoll.setPageSize( Integer.valueOf( limit ) ) ;
	    
	    List<ProcessHistoryData> histories = processHistoryAdminFacade.searchProcessHistory( pageRoll , json ) ;
	    
	    JSONArray arr =  DateTool.getJSONArray( histories , "yyyy-MM-dd" );
	    
	    /*将jsonArray中的计划id转化为名称或编号*/
	    
	    String planID = null ;
	    String className = null ;
	    
	    for ( int i = 0 ; i < arr.size() ; i ++ ) {
	    	JSONObject ji = arr.getJSONObject( i ) ; 
	    	planID = ji . getString( "jbpmObjectID" ) ;
	    	className = ji . getString( "jbpmClassName" ) ;
	    	ji.put( "taskName" , this.convertIDtoClass(planID, className) ) ;
	    } 
	    
	    StringBuffer s = new StringBuffer() ;
	    s.append( " { " ) ;
	    s.append( " results : " ) ;
	    s.append( pageRoll.getTotalRows() ) ;
	    s.append( " , " ) ;
	    s.append( " items : " ) ;
	    s.append( arr.toString() ) ;
	    s.append( " } " ) ;
	    
		this.setJson( s.toString() ) ;
		
		return null;
	}
	/**
	 * 查询指定id计划的审批历史
	 * @return
	 */
	public String detailHistory () {
		
		JSONObject json = ( JSONObject ) this.getJson() ;
		
		List<ProcessHistoryData> histories = processHistoryAdminFacade.detailHistory( json ) ;
		for(ProcessHistoryData p: histories){
			if(p.getOperatorID()!=null){
				String sql = "select chinesename from groupuser where id = (select groupuserid from etipoperator where id='"+p.getOperatorID()+"')";
				JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
				List<ETIPResultSet> rs =jdbc.queryForList(sql, null);
				if(rs!=null && rs.size()>0){
					p.setCreatorName(rs.get(0).getString("CHINESENAME"));
				}
			}
			
		}
		    
		JSONArray arr =  DateTool.getJSONArray( histories , "yyyy-MM-dd" );
		 
		this.setJson( arr.toString() ) ;
		 
		return null;
	}
	/**
	 * 将计划的id变为计划名称
	 *
	 */
	private String convertIDtoClass ( String planID , String className ) {
		
		return processHistoryAdminFacade.convertIDtoClass( planID , className ) ;
	}
	public ProcessHistoryAdminFacade getProcessHistoryAdminFacade() {
		return processHistoryAdminFacade;
	}
	public void setProcessHistoryAdminFacade(
			ProcessHistoryAdminFacade processHistoryAdminFacade) {
		this.processHistoryAdminFacade = processHistoryAdminFacade;
	}
	
	
}
