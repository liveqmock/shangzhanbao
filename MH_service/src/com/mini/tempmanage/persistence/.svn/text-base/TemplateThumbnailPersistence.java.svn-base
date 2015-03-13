package com.mini.tempmanage.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板缩略图持久化层接口实现类
 * 
 * @author 文东
 * @see TemplateThumbnailPersistence
 * @since
 */
@Component("templateThumbnailPersistence")
public class TemplateThumbnailPersistence extends BasePersistence<TemplateThumbnailData> implements
        ITemplateThumbnailPersistence {

    @Override
    public void addThumbnail(TemplateThumbnailData thumbnailData, Map<String, File> files) {
        for (Map.Entry<String, File> entry : files.entrySet()) {
            TemplateThumbnailData data = new TemplateThumbnailData();
            String key = entry.getKey();// 获取键值对的名称
            data.setTemplateId(thumbnailData.getTemplateId());
            data.setType(key);
            data.setMemo(key);
            data.setName(key + "浏览图");
            File value = entry.getValue();// 获取键值对的值
            // 存储图片
            Blob img = null;
            FileInputStream inputStream = null;
            if (value != null) {
                // 将图片读入输入流
                try {
                    inputStream = new FileInputStream(value);
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
            data.setContent(img);
            this.add(data);
        }
    }

}
