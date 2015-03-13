package com.mini.component.service;

import java.io.File;
import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.component.business.IComponentBusiness;
import com.mini.component.data.ComponentData;

/**
 * 
 * 〈组件操作Service层〉<br>
 * 
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IComponentService extends IService {
    /**
     * 
     * 
     * 〈根据组件id查询组件信息〉<br>
     * 
     * @author 左香勇 <br>
     *         2014-2-19
     * @update
     * @param [id] [要查询的组件实体的id]
     * @return [无返回值]
     * @exception/throws
     * @see
     * @since [起始版本]
     */
    public ComponentData getComponentByid(String id);

    /**
     * 
     * 查询所有可用组件和组件缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param componentData 查询参数
     * @return List<ComponentData> 可用组件集合
     * @exception/throws
     * @see IComponentService#searchComponentAndPic()
     * @since
     */
    public List<ComponentData> searchComponentAndPic(ComponentData componentData);

    /**
     * 
     * 查询所有可用组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param componentData 查询参数
     * @return List<ComponentData> 可用组件集合
     * @exception/throws
     * @see IComponentService#searchComponent()
     * @since
     */
    public List<ComponentData> searchComponent(ComponentData componentData);

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
     * 根据id查询组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-8
     * @update
     * @param id 组件主键id
     * @return ComponentData 组件对象
     * @exception/throws
     * @see IComponentService#searchComponentById(String)
     * @since
     */
    public ComponentData searchComponentById(String id);

    /**
     * 
     * 添加组件和组件图片<br>
     * 
     * @author 文东 <br>
     *         2014-3-12
     * @update
     * @param componentData 组件对象
     * @return void
     * @exception/throws
     * @see IComponentService#addComponent(ComponentData)
     * @since
     */
    public String addComponent(ComponentData componentData);

    /**
     * 
     * 查询所有组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-13
     * @update
     * @param pageRoll 分页参数
     * @param componentData 组件对象 用于存放条件查询的参数
     * @return List<ComponentData> 组件集合
     * @exception/throws
     * @see IComponentService#searchComponent(PageRoll, ComponentData)
     * @since
     */
    public List<ComponentData> searchComponent(PageRoll pageRoll, ComponentData componentData);
    /**
     * 组件删除
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public String deleteComponent(ComponentData componentData);
    /**
    * 根据id  修改组件
    * @author 侯杨
    * @date 2014-5-20
    * @param data
    * @param filePC
    * @return
    */
	public String editComponentFile(ComponentData data);
	/**
     * 
     * 更具组件的四种类型分别过滤组件<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-26
     * @update 
     * @param 
     * @return  
     */
    public List<ComponentData> ajaxSearchComponentByComponentType(ComponentData componentData);
    /**
     * 
     *根据主键类型查询主键信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-19
     * @update 
     * @see   IComponentBusiness#getComponentData
     * @since vmaque1.6
     */
    public ComponentData getComponentData(ComponentData data);
}
