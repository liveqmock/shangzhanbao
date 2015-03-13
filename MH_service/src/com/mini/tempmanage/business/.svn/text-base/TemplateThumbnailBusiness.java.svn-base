package com.mini.tempmanage.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.persistence.ITemplateThumbnailPersistence;

/**
 * 模板缩略图业务接口实现类
 * 
 * @author 文东
 * @see TemplateThumbnailBusiness
 * @since
 */
@Component("templateThumbnailBusiness")
public class TemplateThumbnailBusiness extends FrmBusiness implements ITemplateThumbnailBusiness {

    // 模板缩略图持久化层接口 容器注入
    @Resource(name = "templateThumbnailPersistence")
    private ITemplateThumbnailPersistence templateThumbnailPersistence;

    @Override
    public TemplateThumbnailData searchDataById(String id, String type) {
        // 定义查询hql语句
        StringBuffer hql = new StringBuffer("from TemplateThumbnailData where 1=1 and type=?");
        // 定义参数集合
        if(id!=null || !"".equals(id)){
            hql.append(" and templateId=? ");
        }
        if ("".equals(type) || type == null) {
            type = "main";
        }
        // 查询主缩略图
        List<TemplateThumbnailData> datas = templateThumbnailPersistence.search(hql.toString(),
                new Object[] {type,id });
        if (datas.size() > 0) {
            return datas.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<TemplateThumbnailData> searhTempImg(TemplateData templateData) {
        // 定义查询hql语句
        StringBuffer hql = new StringBuffer("from TemplateThumbnailData where 1=1 and templateId=?");
        // 返回查询结果
        return templateThumbnailPersistence.search(hql.toString(), new Object[] { templateData.getId() });
    }

}
