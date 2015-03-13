package com.mini.component.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.component.data.ComponentData;

/**
 * 
 * 〈组件操作Persistence层接口〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IComponentPersistence extends IBasePersistence<ComponentData> {

	
	/**
	 * 
	 *〈添加组件信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-19
	 * @update 
	 * @param [ComponentData]     [组件实体信息]
	 * @return  [无返回值]
	 * @exception/throws 
	 * @see   
	 * @since [起始版本]
	 */
	public void addComponent(ComponentData data);
	
	/**
	 * 
	 *〈删除组件信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-19
	 * @update 
	 * @param [id]     [要删除的组件实体的id]
	 * @return  [无返回值]
	 * @exception/throws 
	 * @see   
	 * @since [起始版本]
	 */
	public void deleteComponent(String id);
	
	/**
	 * 
	 *〈编辑组件信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-19
	 * @update 
	 * @param [ComponentData]     [组件实体信息]
	 * @return  [无返回值]
	 * @exception/throws 
	 * @see   
	 * @since [起始版本]
	 */
	public void editComponent(ComponentData data);
	
	/**
	 * 
	 * 
	 *〈根据组件id查询组件信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-19
	 * @update 
	 * @param [id]     [要查询的组件实体的id]
	 * @return  [无返回值]
	 * @exception/throws 
	 * @see   
	 * @since [起始版本]
	 */
	public ComponentData getComponentByid(String id);
	
	/**
	 * 
	 * 〈根据pageid查询组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-10
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List getComponent(String pageid);

    /**
     * 
     * 根据组件编码查询组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-13
     * @update
     * @param tempSn 组件编码
     * @return List<TemplateData> 组件集合
     * @exception/throws
     * @see IComponentPersistence#searchBySn(String)
     * @since
     */
    public List<ComponentData> searchBySn(String tempSn);

}
