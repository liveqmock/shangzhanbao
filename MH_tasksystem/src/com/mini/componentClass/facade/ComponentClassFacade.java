package com.mini.componentClass.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.component.data.ComponentData;
import com.mini.componentClass.data.ComponentClassData;
import com.mini.componentClass.service.IComponentClassService;
/**
 * 〈组件表样式facade层〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @date 2014-08-14
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component("componentClassFacade")
public class ComponentClassFacade extends FrmFacade{
    @Resource(name="componentClassService")
    private IComponentClassService componentClassService;
    /**
     * 
     *根据主键id查询主键样式表 查询<br>
     * 
     * @author 侯杨 <br> 
     *         2014-8-14
     * @update 
     * @param [data]     [主键实体]
     * @return  [返回主键样式集合]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public List<ComponentClassData> getAllCompId(ComponentData data){
        return  componentClassService.getAllCompId(data);
    }
    /**
     * 
     *classname 名称必须是唯一的，检查数据库是否存在<br>
     * 
     * @author 侯杨 <br> 
     *         2014-8-14
     * @update 
     * @param [ComponentClassData]     [组件实体]
     * @return  [返回1  表示此方法查询成功没有异常  返回0 有异常]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String ajaxFindComponentClassData(ComponentClassData data){
        return  componentClassService.ajaxFindComponentClassData(data);
    }
    /**
     * 
     *增加组件样式表<br>
     * 
     * @author 侯杨 <br> 
     *          2014-8-14
     * @update 
     * @param [ComponentClassData]     [组件实体]
     * @return  [返回1  表示此方法查询成功没有异常  返回0 有异常]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String componentClassDataAddUpdate(ComponentClassData data){

            return componentClassService.componentClassDataAddUpdate(data);
        
    }
    
    /**
     * 
     *删除组件样式表<br>
     * 
     * @author 侯杨 <br> 
     *          2014-8-18
     * @update 
     * @param [ComponentClassData]     [组件实体]
     * @return  [返回1  表示此方法查询成功没有异常  返回0 有异常]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String componentClassDatadelete(ComponentClassData data){
        return componentClassService.componentClassDatadelete(data);
    }
    
    /**
     * 
     *删除主键的时候，删除主键样式相关联的数据<br>
     * 
     * @author 侯杨 <br> 
     *         2014-8-18
     * @update 
     * @param [componentClassData]     [组件样式实体]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public String deleteCom(ComponentClassData data){
        return componentClassService.deleteCom(data);
    }
    
    /**
     * 
     *  根据主键查询信息<br>
     * 
     * @author 侯杨 <br> 
     *         2014-8-20
     * @update 
     * @param [data]     [主键样式实体]
     * @return  [实体]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public ComponentClassData getComponentClassDataById(ComponentClassData data){
        return componentClassService.getComponentClassDataById(data);
    }
    
    
}
