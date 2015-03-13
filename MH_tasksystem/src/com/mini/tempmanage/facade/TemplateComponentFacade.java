package com.mini.tempmanage.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.tempmanage.data.TemplateComponentData;
import com.mini.tempmanage.service.ITemplateComponentService;

/**
 * 
 * 〈模板与组件关系对象facade〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("templateComponentFacade")
public class TemplateComponentFacade extends FrmFacade {

	@Resource(name = "templateComponentService")
	private ITemplateComponentService templateComponentService;

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
	public void addTemplateComponent(TemplateComponentData data) {
		templateComponentService.addTemplateComponent(data);
	}

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
	public void updateAll(TemplateComponentData data, int rownum) {
		templateComponentService.updateAll(data, rownum);
	}
	
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
	public List<TemplateComponentData> getTemplateComponentByTemplateid(String templateid){
		return templateComponentService.getTemplateComponentByTemplateid(templateid);
	}

	public int getTiaxs(String templateid,String compid1,String compid2){
		return templateComponentService.getTiaxs(templateid, compid1, compid2);
	}
}
