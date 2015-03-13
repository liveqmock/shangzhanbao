package com.mini.pageTemplateInfo.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.pageTemplateInfo.data.PageTemplateInfoData;
import com.mini.pageTemplateInfo.persistence.IPageTemplateInfoPersistence;


/**
 * 
 * 〈Page内容表操作Business层〉<br> 
 * 
 *
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("pageTemplateInfoBusiness")
public class PageTemplateInfoBusiness extends FrmBusiness implements IPageTemplateInfoBusiness {

	
	@Resource(name="pageTemplateInfoPersistence")
	private IPageTemplateInfoPersistence pageTemplateInfoPersistence;
	
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
		pageTemplateInfoPersistence.addPageTemplateInfo(data);
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
		pageTemplateInfoPersistence.deletePageTemplateInfo(id);
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
		pageTemplateInfoPersistence.editPageTemplateInfo(data);
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
		return pageTemplateInfoPersistence.getAllPageTemplateInfo();
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
		return pageTemplateInfoPersistence.getAllPageTemplateInfoByPageTemplateId(pageTemplateId);
	}
	
}
