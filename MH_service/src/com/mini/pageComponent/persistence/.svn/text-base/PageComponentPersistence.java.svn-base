package com.mini.pageComponent.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.pageComponent.data.PageComponentData;

/**
 * page与组件关系对象持久化层
 * 
 * @author 左香勇
 * @see IPageComponentPersistence
 * @since
 */
@SuppressWarnings("unchecked")
@Component("pageComponentPersistence")
public class PageComponentPersistence extends BasePersistence<PageComponentData> implements IPageComponentPersistence {

	 /**
     * 
     *〈添加模板组件中间表信息〉<br>
     * 
     * @author 左香勇 <br> 
     *		   2014-3-13
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void addPageComponent(PageComponentData data){
    	add(data);
    }
	
    /**
     * 
     *〈修改所有符合条件的信息的tiaxs〉<br>
     * 
     * @author 左香勇 <br> 
     *		   2014-3-13
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
	public void updateAll(PageComponentData data, int rownum){
        String sql = "update mini_page_component m set m.taxis = (m.taxis+1) where m.id in(select id from (select t.id from mini_page_component t where t.pageid = ? order by t.taxis) where taxis >= ?)";
        
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        
        Object [] params = {
        	data.getPageid(),rownum
        };
        
        dao.executeSQL(sql,params);
        
    }
	
	public int getTiaxs(String pageid,String compid1,String compid2){

	        String sql = "select max(m.taxis)+1 num from mini_page_component m where m.pageid = ? and m.componentid in (?,?)";
	        
	        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
	        
	        Object [] params = {
	        		pageid,compid1,compid2
	        };
	        
	        List<ETIPResultSet> list =  dao.queryForList(sql, params);
	        
	        int tiaxsNum = 1;
	        
	        for(ETIPResultSet rs : list){
	        	tiaxsNum = rs.getInt("NUM");
	        }
	        
	        return tiaxsNum;
	}
	
}
