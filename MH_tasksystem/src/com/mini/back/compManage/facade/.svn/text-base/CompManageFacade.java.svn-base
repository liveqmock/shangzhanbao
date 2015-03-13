package com.mini.back.compManage.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.component.data.ComponentData;
import com.mini.component.service.IComponentService;

/**
 * 组件管理Facade
 * 
 * @author 文东
 * @see CompManageFacade
 * @since
 */
@Component("compManageFacade")
public class CompManageFacade extends FrmFacade {

    @Resource(name = "componentService")
    private IComponentService componentService;

    /**
     * 
     * 分页查询所有组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-13
     * @update
     * @param pageRoll 分页参数
     * @param componentData 条件查询组件对象
     * @return List<ComponentData> 组件集合
     * @exception/throws
     * @see CompManageFacade#searchComponent(PageRoll, ComponentData)
     * @since
     */
    public List<ComponentData> searchComponent(PageRoll pageRoll, ComponentData componentData) {

        return componentService.searchComponent(pageRoll, componentData);
    }

    /**
     * 
     * 添加组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-11
     * @update
     * @param componentData
     * @return void
     * @exception/throws
     * @see CompManageFacade#add(ComponentData)
     * @since
     */
    public String add(ComponentData componentData) {
         return componentService.addComponent(componentData);
    }
    
    /**
     * 组件删除
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public String deleteComponent(ComponentData componentData){
    	return componentService.deleteComponent(componentData);
    }
    /**
     * 根据id 查询组件 信息
     * @author 侯杨
     * date 2014-5-20
     * @param componentData
     * @return
     */
    public ComponentData getComponentByid(String id) {
    	return componentService.getComponentByid(id);
    }
    /**
     * 根据id  修改组件
     * @author 侯杨
     * @date 2014-5-20
     * @param data
     * @param filePC
     * @return
     */
	public String editComponent(ComponentData data) {
		return componentService.editComponentFile(data);
	}
}
