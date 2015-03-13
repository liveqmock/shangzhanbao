package com.mini.templateStructure.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.templateStructure.data.TemplateStructureData;


/**
 * 
 * 
 *〈操作模板架构Persistence层〉<br>
 * 
 * @author 左香勇 <br> 
 *		   2014-2-24
 * @update 
 * @param [参数1]     [参数1说明]
 * @return  [返回类型说明]
 * @exception/throws [异常类型] [异常说明]
 * @see   [类、类#方法、类#成员]
 * @since [起始版本]
 */
@Component("templateStructurePersistence")
public class TemplateStructurePersistence extends
		BasePersistence<TemplateStructureData> implements
		ITemplateStructurePersistence {

	/**
	 * 
	 * 
	 *〈添加模板架构信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-24
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addTemplateStructure(TemplateStructureData data){
		add(data);
	}
	
	/**
	 * 
	 *〈根据用户id获取模板架构信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-25
	 * @update 
	 * @param [id]     [用户id]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List<TemplateStructureData> getTemplateStructureByUserid(String userid){
		
		StringBuffer sql = new StringBuffer("from com.mini.templateStructure.data.TemplateStructureData WHERE 1=1");
		sql.append(" AND userid = '").append(userid).append("'").append(" ORDER BY createdate DESC");
		
		
		return search(sql.toString());
	}
	

	/**
	 * 
	 *〈根据id获取模板架构信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-25
	 * @update 
	 * @param [id]     [用户id]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public TemplateStructureData getTemplateStructureById(String id){
		
		StringBuffer sql = new StringBuffer("from com.mini.templateStructure.data.TemplateStructureData WHERE 1=1");
		sql.append(" AND id = '").append(id).append("'");
		
		List<TemplateStructureData> list = search(sql.toString());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
}
