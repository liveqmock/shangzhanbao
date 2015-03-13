package com.mini.tempmanage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.tempmanage.business.ITemplateThumbnailBusiness;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板缩略图服务接口实现类
 * 
 * @author 文东
 * @see TemplateThumbnailService
 * @since
 */
@Component("templateThumbnailService")
public class TemplateThumbnailService extends FrmService implements ITemplateThumbnailService {

    // 模板缩略图业务接口  容器注入
    @Resource(name = "templateThumbnailBusiness")
    private ITemplateThumbnailBusiness templateThumbnailBusiness;

    @Override
    public TemplateThumbnailData searchDataById(String id,String type) {

        return templateThumbnailBusiness.searchDataById(id,type);
    }

    @Override
    public List<TemplateThumbnailData> searhTempImg(TemplateData templateData) {
        List<TemplateThumbnailData> datas = templateThumbnailBusiness.searhTempImg(templateData);
        return datas;
    }

}
