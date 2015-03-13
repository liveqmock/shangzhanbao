package com.mini.component.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.StringUtil;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.component.business.IComponentBusiness;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.business.IComponentClassBusiness;
import com.mini.componentClass.data.ComponentClassData;


/**
 * 
 * 〈组件操作Service层〉<br> 
 * 〈功能详细描述〉
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("componentService")
public class ComponentService extends FrmService implements IComponentService {


	@Resource(name="componentBusiness")
	private IComponentBusiness componentBusiness;
	@Resource(name="componentClassBusiness")
    private IComponentClassBusiness componentClassBusiness;
	
	
	
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
	public ComponentData getComponentByid(String id){
		
	    ComponentData data=componentBusiness.getComponentByid(id);
	    if(data.getClob()!=null){
            List<String> strings=StringUtil.returnList(data.getClob());
            data.setClassNameList(strings);
	    }
        return data;
		
	}
	
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
	@SuppressWarnings("rawtypes")
	public List getComponent(String pageid){
		return componentBusiness.getComponent(pageid);
	}


    @Override
    public List<ComponentData> searchComponentAndPic(ComponentData componentData) {
        return componentBusiness.searchComponentAndPic(componentData);
    }


    @Override
    public List<ComponentData> searchComponent(ComponentData componentData) {
        return componentBusiness.searchComponent(componentData);
    }


    @Override
    public ComponentData searchComponentById(String id) {
       
        return componentBusiness.searchComponentById(id);
    }


    @Override
    public String addComponent(ComponentData componentData) {
        
       return componentBusiness.addComponent(componentData);
    }


    @Override
    public List<ComponentData> searchComponent(PageRoll pageRoll, ComponentData componentData) {
        pageRoll = PageRoll.set(10, pageRoll);
        List<ComponentData> list=componentBusiness.searchComponent(pageRoll,componentData);
           if(list!=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                List<ComponentClassData> classDatas=new ArrayList<ComponentClassData>();
                classDatas =componentClassBusiness.getAllCompId(list.get(i));
                list.get(i).setClassDatas(classDatas);
                
            }
           }
        return list;
    }
    /**
     * 组件删除
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public String deleteComponent(ComponentData componentData){
    	return componentBusiness.deleteComponent(componentData);
    }
    /**
     * 根据id  修改组件
     * @author 侯杨
     * @date 2014-5-20
     * @param data
     * @param filePC
     * @return
     */
 	public String editComponentFile(ComponentData data){
 		return componentBusiness.editComponentFile(data);
 	}
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
    public List<ComponentData> ajaxSearchComponentByComponentType(ComponentData componentData){
        return componentBusiness.ajaxSearchComponentByComponentType(componentData);
    }
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
    public ComponentData getComponentData(ComponentData data){
        return componentBusiness.getComponentData(data);
    }
}
