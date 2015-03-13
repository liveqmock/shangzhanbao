package com.mini.tempmanage.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.tempmanage.data.TemplateComponentData;

/**
 * 模板与组件关系对象持久化层接口
 * 
 * @author 文东
 * @see ITemplateComponentPersistence
 * @since
 */
public interface ITemplateComponentPersistence extends
		IBasePersistence<TemplateComponentData> {

	/**
	 * 
	 * 〈添加模板组件中间表信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-13
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addTemplateComponent(TemplateComponentData data);

	/**
	 * 
	 * 〈修改所有符合条件的信息的tiaxs〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-13
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void updateAll(TemplateComponentData data, int rownum);

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
	public List<TemplateComponentData> getTemplateComponentByTemplateid(String templateid);
	
	public int getTiaxs(String templateid,String compid1,String compid2);
	
}
