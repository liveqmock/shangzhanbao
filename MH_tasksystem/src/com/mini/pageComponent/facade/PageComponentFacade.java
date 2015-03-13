package com.mini.pageComponent.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.pageComponent.data.PageComponentData;
import com.mini.pageComponent.service.IPageComponentService;
import com.mini.pageComponent.service.PageComponentService;

/**
 * page与组件关系对象Facade层
 * 
 * @author 左香勇
 * @see PageComponentService
 * @since
 */
@Component("pageComponentFacade")
public class PageComponentFacade extends FrmFacade {

	@Resource(name="pageComponentService")
	private IPageComponentService pageComponentService;
	
	/**
	 * 
	 * 〈添加page组件中间表信息〉<br>
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
	public void addPageComponent(PageComponentData data){
		pageComponentService.addPageComponent(data);
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
	public void updateAll(PageComponentData data, int rownum){
		pageComponentService.updateAll(data, rownum);
	}

	public int getTiaxs(String pageid,String compid1,String compid2){
		return pageComponentService.getTiaxs(pageid, compid1, compid2);
	}
}
