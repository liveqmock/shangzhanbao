package com.mini.pageComponent.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.pageComponent.data.PageComponentData;
import com.mini.pageComponent.facade.PageComponentFacade;

/**
 * 
 * 〈page与组件关系对象action〉<br> 
 * 〈功能详细描述〉
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ResultPath("/")
@Results({
	
})
public class PageComponentAction extends FrmAction {

	@Resource(name="pageComponentFacade")
	private PageComponentFacade pageComponentFacade;
	
	private PageComponentData data = new PageComponentData();
	
	/**
     * 
     *〈添加模板组件中间表信息〉<br>
     * 
     * @author 左香勇 <br> 
     *		   2014-3-13
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void addPageComponent(){
    	String id1 = request.getParameter("id1");
    	String id2 = request.getParameter("id2");
    	
    	int rownum = pageComponentFacade.getTiaxs(data.getPageid(), id1, id2);
    	data.setTaxis(rownum);
    	pageComponentFacade.addPageComponent(data);
    }
	
    /**
     * 
     *〈修改所有符合条件的信息的tiaxs〉<br>
     * 
     * @author 左香勇 <br> 
     *		   2014-3-13
     * @update 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void updateAll(){
    	
    	String id1 = request.getParameter("id1");
    	String id2 = request.getParameter("id2");
    	
    	int rownum = pageComponentFacade.getTiaxs(data.getPageid(), id1, id2);
    	
    	pageComponentFacade.updateAll(data, rownum);
    }

	public PageComponentData getData() {
		return data;
	}

	public void setData(PageComponentData data) {
		this.data = data;
	}
    
}
