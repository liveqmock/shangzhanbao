package com.mini.front.tempmanage.facade;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.data.TemplateThumbnailData;
import com.mini.tempmanage.persistence.ITempManagePersistence;
import com.mini.tempmanage.service.ITempManageService;
import com.mini.tempmanage.service.ITemplateThumbnailService;

/**
 * 模板管理Facade
 * 
 * @author 文东
 * @see TempManageFacade
 * @since
 */
@Component("tempManageFacade")
public class TempManageFacade extends FrmFacade {

    // 模板管理服务接口 容器注入
    @Resource(name = "tempManageService")
    private ITempManageService tempManageService;

    // 模板缩略图服务接口 容器注入
    @Resource(name = "templateThumbnailService")
    private ITemplateThumbnailService templateThumbnailService;

    /**
     * 
     * 查询所有模板信息<br>
     * 
     * @author 文东 <br>
     *         2014-2-18
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象。存放条件查询的参数
     * @param userId 用户ID
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see TempManageFacade#searchAllTempByUser(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId) {
        // 查询用户所拥有的模板
        List<TemplateData> templateDatas = tempManageService.searchAllTempByUser(pageRoll, templateData, userId);
        return templateDatas;
    }

    /**
     * 
     * 获取推荐模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param userId 用户id
     * @return recommendTemplates 推荐模板集合
     * @exception/throws
     * @see TempManageFacade#searchRecommend(String)
     * @since [起始版本]
     */
    public List<TemplateData> searchRecommend(String userId) {
        // 查询推荐模板
        List<TemplateData> recommendTemplates = tempManageService.searchRecommend(userId);
        return recommendTemplates;
    }

    /**
     * 
     * 查询模板
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param pageRoll 分页查询参数
     * @param templateData 模板对象
     * @return List<TemplateData>查询到的模板集合
     * @exception/throws
     * @see TempManageFacade#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData, Integer size) {
        // 查询所有模板
        List<TemplateData> templateDatas = tempManageService.searchAllTemp(pageRoll, templateData, size);
        return templateDatas;
    }

    /**
     * 
     * 添加模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-20
     * @update
     * @param templateData 模板对象
     * @param fileMain 模板主浏览图
     * @param filePC 模板PC机浏览图
     * @param filePad 模板pad浏览图
     * @param filePhone 模板手机浏览图
     * @return
     * @exception/throws
     * @see TempManageFacade#addTemp(TemplateData, File, File, File, File)
     * @since
     */
    public void addTemp(TemplateData templateData, File fileMain, File filePC, File filePad, File filePhone) {
        // 添加模板
        tempManageService.addTemp(templateData, fileMain, filePad, filePC, filePhone);
    }

    /**
     * 
     * 根据模板id获取模板主预览缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param id 模板ID
     * @param type 模板缩略图类型
     * @return TemplateThumbnailData 模板缩略图
     * @exception/throws
     * @see TempManageFacade#getThumbnailData(TemplateData)
     * @since
     */
    public TemplateThumbnailData getThumbnailData(String id, String type) {
        // 根据ID查询模板缩略图
        TemplateThumbnailData data = templateThumbnailService.searchDataById(id, type);
        return data;
    }

    /**
     * 
     * 根据模板ID查询模板缩略图<br>
     * 
     * @author 文东 <br>
     *         2014-2-21
     * @update
     * @param templateData 模板对象 存放查询参数
     * @return List<TemplateThumbnailData> 该模板的缩略图集合
     * @exception/throws
     * @see TempManageFacade#searhTempImg(TemplateData)
     * @since
     */
    public List<TemplateThumbnailData> searhTempImg(TemplateData templateData) {
        // 查询模板缩略图
        List<TemplateThumbnailData> thumbnailDatas = templateThumbnailService.searhTempImg(templateData);
        return thumbnailDatas;
    }

    /**
     * 更具模板id查询模板信息 后台模板管理
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public TemplateData getTemplateData(String templateId) {
        return tempManageService.getTemplateData(templateId);
    }

    /**
     * page页面统计
     * 
     * @param templateId 模板id
     * @param state page状态
     * @return
     */
    public int statisticsTempPage(String templateId, String state) {
        return tempManageService.statisticsTempPage(templateId, state);
    }

    /**
     * 后台 模板管理 启用 停用操作
     * 
     * @author hy
     * @date 2014-2-22
     * @param tempId
     * @param state
     */
    public void updateTempState(String tempId, String state) {
        tempManageService.updateTempState(tempId, state);
    }

    /**
     * 后台模板管理 删除模板 假删
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     */

    public void delete(String tempId[]) {
        tempManageService.delete(tempId);
    }

    /**
     * 
     * 根据模板受喜欢程度排序查询模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-23
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see TempManageFacade#searchByLike()
     * @since
     */
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData) {
        // 根据模板受喜欢的程度排序查询模板
        List<TemplateData> templateDatas = tempManageService.searchByLike(pageRoll, templateData);
        return templateDatas;
    }

    /**
     * 后台模板管理 修改模板
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     * @param templateData
     */

    public void updateTemp(String tempId, TemplateData templateData) {
        tempManageService.updateTemp(tempId, templateData);
    }

    /**
     * 
     * p排序查询所有的模板<br>
     * 
     * @author侯杨 <br>
     *           2014-2-14
     *          左香勇
     *           2014-6-6 添加排序参数sort
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData, Integer size,
            String Type, int sort) {
        // 设置分页参数

        return tempManageService.searchAllTempType(pageRoll, templateData, Type, sort);
    }

    /**
     * 模板详情页面查看page列表
     * 
     * @author hy  update  侯杨
     * @date 2014-2-25   
     * @param pageRoll 分页
     * @param pageHelpData  帮组类 传值
     * @return
     */
	public List<PageData> countTempPage(PageRoll pageRoll,PageHelpData pageHelpData){
        return tempManageService.countTempPage(pageRoll,pageHelpData);
    }

    /**
     * 
     * 获取用户过期的模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-27
     * @update
     * @param userId 用户ID
     * @param templateData 模板查询的参数
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see TempManageFacade#searchLimit(String, TemplateData)
     * @since
     */
    public List<TemplateData> searchLimit(PageRoll pageRoll, String userId, TemplateData templateData) {
        // 表示查询的是过期模板
        templateData.setEsc("limit");
        return tempManageService.searchAllTempByUser(pageRoll, templateData, userId);
    }

    /**
     * 
     * 根据模板ID查询模板内容<br>
     * 
     * @author 文东 <br>
     *         2014-3-20
     * @update
     * @param tempId 模板ID
     * @return TemplateData 模板对象
     * @exception/throws
     * @see TempManageFacade#searchById(String)
     * @since
     */
    public TemplateData searchById(String tempId) {
        return tempManageService.searchById(tempId);
    }
}
