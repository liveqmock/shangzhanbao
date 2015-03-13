package com.mini.pageComponent.persistence;

import com.itour.etip.pub.base.IPersistence;
import com.mini.pageComponent.data.PageComponentData;

/**
 * page与组件关系对象持久化层接口
 * 
 * @author 左香勇
 * @see IPageComponentPersistence
 * @since
 */
public interface IPageComponentPersistence extends IPersistence {

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
	public void addPageComponent(PageComponentData data);

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
	public void updateAll(PageComponentData data, int rownum);

	public int getTiaxs(String pageid,String compid1,String compid2);
	
}
