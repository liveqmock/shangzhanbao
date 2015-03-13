package com.mini.front.tempmanage.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mini.front.tempmanage.facade.TempManageFacade;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.opensymphony.xwork2.ActionContext;


/**
 *〈一句话功能简述〉
 *〈功能详细描述〉
 * @author     [作者]（必须，使用汉语）
 * @see        [相关类/方法]（可选）
 * @since      [产品/模块版本] （可选）
 */
public class TempImgAction {
   
    // 模板管理Facade 容器注入
    @Resource(name = "tempManageFacade")
    private TempManageFacade tempManageFacade;
    
    // 模板缩略图对象
    private TemplateThumbnailData thumbnailData = new TemplateThumbnailData();
    
    // 模板缩略图对象集合
    private List<TemplateThumbnailData> thumbnailDatas = new ArrayList<TemplateThumbnailData>();
    
    /**
     * 
     * 模板商店显示图片<br>
     * 
     * @author 文东 <br> 
     *         2014-2-21
     * @update 
     * @param 
     * @return  
     * @exception/throws 
     * @see   TempImgAction#outImg()
     * @since 
     */
    public String outImg() {
        try {
            ActionContext ac = ActionContext.getContext();
            HttpServletRequest request =(HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
            HttpServletResponse response = ServletActionContext.getResponse();
            // 设置二进制输出流
            response.setContentType("multipart/form-data");
            // 获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.flush();
            // 获取模板id
            String id = request.getParameter("id");
            // 缩略图类型
            String type = request.getParameter("type");
            // 获取模板缩略图
            thumbnailData = tempManageFacade.getThumbnailData(id,type);
            // 实例化字节数组流，存储表中的照片字节
            InputStream inputStream = thumbnailData.getContent().getBinaryStream();
            byte[] buf = new byte[1024];
            while (inputStream.read(buf) != -1) {
                outputStream.write(buf);
            }
            
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public TempManageFacade getTempManageFacade() {
        return tempManageFacade;
    }



    public void setTempManageFacade(TempManageFacade tempManageFacade) {
        this.tempManageFacade = tempManageFacade;
    }



    public TemplateThumbnailData getThumbnailData() {
        return thumbnailData;
    }



    public void setThumbnailData(TemplateThumbnailData thumbnailData) {
        this.thumbnailData = thumbnailData;
    }



    public List<TemplateThumbnailData> getThumbnailDatas() {
        return thumbnailDatas;
    }



    public void setThumbnailDatas(List<TemplateThumbnailData> thumbnailDatas) {
        this.thumbnailDatas = thumbnailDatas;
    }
    
}
