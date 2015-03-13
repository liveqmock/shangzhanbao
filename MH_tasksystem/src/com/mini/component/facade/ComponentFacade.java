package com.mini.component.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.component.business.IComponentBusiness;
import com.mini.component.data.ComponentData;
import com.mini.component.service.IComponentService;

/**
 * 
 * 〈组件操作Facade层〉<br> 
 * 〈功能详细描述〉
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("componentFacade")
public class ComponentFacade extends FrmFacade {
    
    
    @Resource(name="componentService")
    public IComponentService componentService;
    
    
    

    /**
     * 
     * 
     *〈根据组件id查询组件信息〉<br>
     * 
     * @author 左香勇 <br> 
     *         2014-2-19
     * @update 
     * @param [id]     [要查询的组件实体的id]
     * @return  [无返回值]
     * @exception/throws 
     * @see   
     * @since [起始版本]
     */
    public ComponentData getComponentByid(String id){
        
        return componentService.getComponentByid(id);
        
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
    public List getComponent(String pageid){
        return componentService.getComponent(pageid);
    }
    /**
     * 
     * 增加模板中，查询所有组件和组件样式<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-22
     * @update 
     * @param ComponentData componentData
     * @return  List<ComponentData> 组件list包含组件样式list
     *//*
    public List<ComponentData> searchComponent_addTemp(ComponentData componentData){
        return componentService.searchComponent_addTemp(componentData);
    }*/
    
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
        return componentService.getComponentData(data);
    }
}
