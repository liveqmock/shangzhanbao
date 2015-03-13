package com.mini.tempmanage.persistence;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板缩略图持久化层接口
 * 
 * @author     文东
 * @see        ITemplateThumbnailPersistence
 * @since      
 */
public interface ITemplateThumbnailPersistence extends IBasePersistence<TemplateThumbnailData>{
    
    /**
     * 
     * 添加模板缩略图<br>
     * 
     * @author 文东 <br> 
     *		   2014-2-20
     * @update 
     * @param thumbnailData 模板对象
     * @param files 文件流集合
     * @return  void
     * @exception/throws 
     * @see   ITemplateThumbnailPersistence#addThumbnail(TemplateThumbnailData, List)
     * @since 
     */
    public void addThumbnail(TemplateThumbnailData thumbnailData, Map<String, File> files);
   
}
