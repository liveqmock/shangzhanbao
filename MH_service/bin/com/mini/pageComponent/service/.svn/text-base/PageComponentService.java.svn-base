package com.mini.pageComponent.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.pageComponent.business.IPageComponentBusiness;
import com.mini.pageComponent.data.PageComponentData;

/**
 * page与组件关系对象Service层
 * 
 * @author 左香勇
 * @see PageComponentService
 * @since
 */
@Component("pageComponentService")
public class PageComponentService extends FrmBusiness implements IPageComponentService {

	@Resource(name="pageComponentBusiness")
	private IPageComponentBusiness pageComponentBusiness;
	
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
	public void addPageComponent(PageComponentData data){
		pageComponentBusiness.addPageComponent(data);
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
		pageComponentBusiness.updateAll(data, rownum);
	}

	public int getTiaxs(String pageid,String compid1,String compid2){
		return pageComponentBusiness.getTiaxs(pageid, compid1, compid2);
	}
	
}
