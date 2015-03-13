package com.mini.tempmanage.service;

import java.util.List;

import com.itour.etip.pub.base.IService;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板缩略图服务接口
 * 
 * @author 文东
 * @see ITemplateThumbnailService
 * @since
 */
public interface ITemplateThumbnailService extends IService {

    /**
     * 
     * 根据模板缩略图ID查询模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param id 模板id
     * @param type 模板缩略图类型
     * @return TemplateThumbnailData 模板缩略图对象
     * @exception/throws
     * @see ITemplateThumbnailService#searchDataById(String)
     * @since
     */
    public TemplateThumbnailData searchDataById(String id,String type);

    /**
     * 
     * 根据模板查询模板缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param templateData 模板对象 存放查询参数
     * @return List<TemplateThumbnailData> 模板集合
     * @exception/throws
     * @see ITemplateThumbnailService#searhTempImg(TemplateData)
     * @since
     */
    public List<TemplateThumbnailData> searhTempImg(TemplateData templateData);

}
