package com.mini.componentThumbnail.business;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.componentThumbnail.data.ComponentThumbnailData;
import com.mini.componentThumbnail.persistence.IComponentThumbnailPersistence;

/**
 * 
 * 〈组件缩略图标Business层〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("componentThumbnailBusiness")
public class ComponentThumbnailBusiness extends FrmBusiness implements IComponentThumbnailBusiness {
	
	@Resource(name="componentThumbnailPersistence")
	private IComponentThumbnailPersistence componentThumbnailPersistence;
	
	/**
	 * 
	 *〈添加组件缩略图信息〉<br>
	 * 
	 * @author 左香勇 <br> 
	 *		   2014-2-24
	 * @update 
	 * @param [参数1]     [参数1说明]
	 * @return  [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see   [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addThumbnail(ComponentThumbnailData thumbnailData, File files){
		
		componentThumbnailPersistence.addThumbnail(thumbnailData, files);
		
	}
	
}
