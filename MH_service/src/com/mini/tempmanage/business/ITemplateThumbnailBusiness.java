package com.mini.tempmanage.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板缩略图业务接口
 * 
 * @author 文东
 * @see ITemplateThumbnailBusiness
 * @since
 */
public interface ITemplateThumbnailBusiness extends IBusiness {

    /**
     * 
     * 根据模板id查询模板主预览缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param id 模板ID
     * @param type 模板缩略图类型
     * @return TemplateThumbnailData 缩略图对象
     * @exception/throws
     * @see ITemplateThumbnailBusiness#searchDataById(String)
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
     * @return List<TemplateThumbnailData> 模板缩略图集合
     * @exception/throws
     * @see ITemplateThumbnailBusiness#searhTempImg(TemplateData)
     * @since
     */
    public List<TemplateThumbnailData> searhTempImg(TemplateData templateData);

}
