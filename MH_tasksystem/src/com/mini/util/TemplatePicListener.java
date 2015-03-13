package com.mini.util;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.HibernateDao;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateThumbnailData;

/**
 * 模板图片监听器 用于初始化将数据库的图片转成物理地址
 *
 * @author     文东
 * @see        TemplatePicListener
 * @since      
 */
public class TemplatePicListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent ServletContext) {
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public void contextInitialized(ServletContextEvent ServletContext) {
        // 定义HQL语句查询所有的模板的主预览图
        String searchTempPichql=" from TemplateThumbnailData td where 1=1 and td.templateId =? and td.type = 'main'";
        // 定义HQL查询 模板
        String searchTempHql = "from TemplateData where 1=1";
        HibernateDao hibernate = (HibernateDao) SpringContextHelper.getBean("hibernate");
        List<TemplateData> list = (List<TemplateData>) hibernate.search(searchTempHql);
        for (int i = 0; i < list.size(); i++) {
            TemplateThumbnailData templateThumbnailData = new TemplateThumbnailData();
            TemplateData data = new TemplateData();
            data = (TemplateData)list.get(i);
            List<TemplateThumbnailData> templateThumbnailDatas = ( List<TemplateThumbnailData>)hibernate.search(searchTempPichql, new Object[]{data.getId()});
            if(templateThumbnailDatas.size()>0){
                templateThumbnailData = templateThumbnailDatas.get(0);
            }
            // 图片保存的路径
            String filePath;
            filePath = ServletContext.getServletContext().getRealPath("/").replaceAll("\\"+File.separator, "/")+ResouceUtil.getProperty("domain.properties", "tmpImgPath");
            // 图片的名称
            String filename = "main_" + data.getId();
            String myPath = "";
            // 获取图片地址
            try {
                // 生成图片文件
                if(templateThumbnailData.getContent()!=null){
                    OutImgBlob.outImg(templateThumbnailData.getContent(), filePath, filename);
                }
                // 获取图片地址
                myPath = File.separator + "img" + File.separator + "edit" + File.separator + filename + ".jpg";
            } catch (Exception e) {
                myPath = File.separator + "img" + File.separator + "edit" + File.separator + "erro.jpg";
            }
            // 定义sql 更新数据
            JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
            String sql = "UPDATE MINI_TEMPLATE SET IMGPATH = '"+myPath+"' WHERE id = '"+data.getId()+"'";
            jdbcDao.executeSQL(sql);
        }
    }
    
}
