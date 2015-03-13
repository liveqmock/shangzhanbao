package com.mini.back.tempmanage.facade;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.component.data.ComponentData;
import com.mini.component.service.IComponentService;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.service.ITempManageService;

/**
 * 后台模板管理facade
 * 
 * @author 文东
 * @see BackTempManageFacade
 * @since
 */
@Component("backTempManageFacade")
public class BackTempManageFacade extends FrmFacade {

    // 组件服务接口 容器注入
    @Resource(name = "componentService")
    private IComponentService componentService;

    // 模板管理服务接口 容器注入
    @Resource(name = "tempManageService")
    private ITempManageService tempManageService;

    /**
     * 
     * 查询所有可用组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param componentData 查询参数
     * @return List<ComponentData> 组件集合
     * @exception/throws
     * @see BackTempManageFacade#searchComponentAndPic(ComponentData)
     * @since
     */
    public List<ComponentData> searchComponentAndPic(ComponentData componentData) {

        return componentService.searchComponentAndPic(componentData);
    }

    /**
     * 
     * 查询所有模板<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param templateData 查询参数
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see BackTempManageFacade#searchTempFrame(TemplateData)
     * @since
     */
    public List<TemplateData> searchTempFrame(TemplateData templateData) {
        // 查询所有模板
        List<TemplateData> list = tempManageService.searchTemp(templateData);
        return list;
    }

    /**
     * 
     * 查询所有组件信息<br>
     * 
     * @author 文东 <br>
     *         2014-3-8
     * @update
     * @param componentData 条件查询参数
     * @return List<ComponentData> 组件集合
     * @exception/throws
     * @see BackTempManageFacade#searchComponent(ComponentData)
     * @since
     */
    public List<ComponentData> searchComponent(ComponentData componentData) {
        return componentService.searchComponent(componentData);
    }

    /**
     * 
     * 根据Id查询组件<br>
     * 
     * @author 文东 <br>
     *         2014-3-8
     * @update
     * @param id 组件主键id
     * @return ComponentData 组件对象
     * @exception/throws
     * @see BackTempManageFacade#searchComponentById(String)
     * @since
     */
    public ComponentData searchComponentById(String id) {
        
        return componentService.searchComponentById(id);
    }
    
    /**
     * 
     * 添加模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-20
     * @update
     * @param templateData 模板对象
     * @param fileMain 模板主浏览图
     * @param filePC 模板PC机浏览图
     * @param filePad 模板pad浏览图
     * @param filePhone 模板手机浏览图
     * @return
     * @exception/throws
     * @see BackTempManageFacade#addTemp(TemplateData, File, File, File, File)
     * @since
     */
    public void addTemp(TemplateData templateData, File fileMain, File filePC, File filePad, File filePhone) {
        // 添加模板
        tempManageService.addTemp(templateData, fileMain, filePad, filePC, filePhone);
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
    public List<ComponentData> ajaxSearchComponentByComponentType(ComponentData componentData) {
        return componentService.ajaxSearchComponentByComponentType(componentData);
    }

}
