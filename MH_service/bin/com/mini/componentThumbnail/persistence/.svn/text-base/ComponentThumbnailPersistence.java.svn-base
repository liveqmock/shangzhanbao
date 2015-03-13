package com.mini.componentThumbnail.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.componentThumbnail.data.ComponentThumbnailData;

/**
 * 
 * 〈组件缩略图标Persistence层〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SuppressWarnings("unchecked")
@Component("componentThumbnailPersistence")
public class ComponentThumbnailPersistence extends	BasePersistence<ComponentThumbnailData> implements	IComponentThumbnailPersistence {

	/**
	 * 
	 * 〈添加组件缩略图信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-24
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public void addThumbnail(ComponentThumbnailData thumbnailData, File files) {
		// 存储图片
		Blob img = null;
		FileInputStream inputStream = null;
		if (files != null) {
			// 将图片读入输入流
			try {
				inputStream = new FileInputStream(files);
			} catch (FileNotFoundException e) {
				// 文件流异常
				e.printStackTrace();
			}
		}
		try {
			img = Hibernate.createBlob(inputStream);
		} catch (IOException e) {
			// IO流异常
			e.printStackTrace();
		}
		thumbnailData.setContent(img);
		this.add(thumbnailData);
	}
	
}
