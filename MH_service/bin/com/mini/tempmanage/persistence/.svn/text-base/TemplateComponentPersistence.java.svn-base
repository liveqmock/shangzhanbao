package com.mini.tempmanage.persistence;


import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.tempmanage.data.TemplateComponentData;

/**
 * 模板与组件持久化层接口实现类
 * 
 * @author 文东
 * @see TemplateComponentPersistence
 * @since
 */
@Component("templateComponentPersistence")
public class TemplateComponentPersistence extends BasePersistence<TemplateComponentData> implements ITemplateComponentPersistence{


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
    public void addTemplateComponent(TemplateComponentData data){
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
	public void updateAll(TemplateComponentData data, int rownum){
        String sql = "update mini_template_component m set m.taxis = (m.taxis+1) where m.id in(select id from (select t.id,rownum rn from mini_template_component t where t.templateid = ?) where rn >= ?)";
        
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
        
        Object [] params = {
        	data.getTemplateid(),rownum
        };
        
        dao.executeSQL(sql,params);
        
    }
	
	/**
	 * 
	 *〈根据templateid查询模板组件中间表信息〉<br>
	 * 
	 * @author lenovo <br> 
	 *		   2014-3-13
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List<TemplateComponentData> getTemplateComponentByTemplateid(String templateid){
		StringBuffer sql = new StringBuffer("FROM com.mini.tempmanage.data.TemplateComponentData t WHERE 1=1 ");
		sql.append("AND t.templateid = '").append(templateid).append("'");
		
		return search(sql.toString());
		
	}
	
	public int getTiaxs(String templateid,String compid1,String compid2){

	        String sql = "select max(m.taxis)+1 num from mini_template_component m where m.templateid = ? and m.componentid in (?,?)";
	        
	        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 执行sql语句进行数据库查询
	        
	        Object [] params = {
	        		templateid,compid1,compid2
	        };
	        
	        List<ETIPResultSet> list =  dao.queryForList(sql, params);
	        
	        int tiaxsNum = 1;
	        
	        for(ETIPResultSet rs : list){
	        	tiaxsNum = rs.getInt("NUM");
	        }
	        
	        return tiaxsNum;
	}
    
}
