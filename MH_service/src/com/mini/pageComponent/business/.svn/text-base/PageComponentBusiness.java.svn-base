package com.mini.pageComponent.business;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.pageComponent.data.PageComponentData;
import com.mini.pageComponent.persistence.IPageComponentPersistence;

/**
 * page与组件关系对象Business层
 * 
 * @author 左香勇
 * @see PageComponentBusiness
 * @since
 */
@Component("pageComponentBusiness")
public class PageComponentBusiness extends FrmBusiness implements IPageComponentBusiness {

	@Resource(name="pageComponentPersistence")
	private IPageComponentPersistence pageComponentPersistence;
	
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
		pageComponentPersistence.addPageComponent(data);
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
		pageComponentPersistence.updateAll(data, rownum);
	}

	public int getTiaxs(String pageid,String compid1,String compid2){
		return pageComponentPersistence.getTiaxs(pageid, compid1, compid2);
	}
	
}
