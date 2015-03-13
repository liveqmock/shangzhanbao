package com.mini.templateStructure.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.templateStructure.data.TemplateStructureData;
import com.mini.templateStructure.persistence.ITemplateStructurePersistence;

/**
 * 
 * 
 *〈操作模板架构Business层〉<br>
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
@Component("templateStructureBusiness")
public class TemplateStructureBusiness extends FrmBusiness implements
		ITemplateStructureBusiness {
	
	
	@Resource(name="templateStructurePersistence")
	private ITemplateStructurePersistence templateStructurePersistence;
	
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
		templateStructurePersistence.addTemplateStructure(data);
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
		return templateStructurePersistence.getTemplateStructureByUserid(userid);
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
		return templateStructurePersistence.getTemplateStructureById(id);
	}
}
