package com.mini.pageTemplateInfo.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.pageTemplateInfo.data.PageTemplateInfoData;
import com.mini.pageTemplateInfo.service.IPageTemplateInfoService;

/**
 * 
 * 〈Page内容Facade层〉<br> 
 * 〈功能详细描述〉
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("pageTemplateInfoFacade")
public class PageTemplateInfoFacade extends FrmFacade {
	
	@Resource(name="pageTemplateInfoService")
	private IPageTemplateInfoService pageTemplateInfoService;
	

	/**
	 * 
	 *〈添加Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-20
	 * @update 
	 * @param [data]     [page内容实体信息]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addPageTemplateInfo(PageTemplateInfoData data){
		pageTemplateInfoService.addPageTemplateInfo(data);
	}
	
	
	/**
	 * 
	 *〈删除Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-20
	 * @update 
	 * @param [id]     [page内容实体id]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void deletePageTemplateInfo(String id){
		pageTemplateInfoService.deletePageTemplateInfo(id);
	}
	
	
	/**
	 * 
	 *〈修改Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-20
	 * @update 
	 * @param [data]     [page内容实体信息]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void editPageTemplateInfo(PageTemplateInfoData data){
		pageTemplateInfoService.editPageTemplateInfo(data);
	}
	
	
	/**
	 * 
	 *〈查询所有page内容信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-20
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List<PageTemplateInfoData> getAllPageTemplateInfo(){
		return pageTemplateInfoService.getAllPageTemplateInfo();
	}
	
	
	/**
	 * 
	 *〈根据模板id查询Page内容信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-20
	 * @update 
	 * @param [pageTemplateId]     [模板id]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List<PageTemplateInfoData> getAllPageTemplateInfoByPageTemplateId(String pageTemplateId){
		return pageTemplateInfoService.getAllPageTemplateInfoByPageTemplateId(pageTemplateId);
	}
	
}
