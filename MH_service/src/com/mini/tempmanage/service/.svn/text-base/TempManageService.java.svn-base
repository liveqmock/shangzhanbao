package com.mini.tempmanage.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.tempmanage.business.ITempManageBusiness;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.persistence.ITempManagePersistence;

/**
 * 模板管理服务接口实现类
 * 
 * @author 文东
 * @see TempManageService
 * @since
 */
@Component("tempManageService")
public class TempManageService extends FrmService implements ITempManageService {

    // 模板管理业务接口 容器注入
    @Resource(name = "tempManageBusiness")
    private ITempManageBusiness tempManageBusiness;

    @Override
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId) {
        // 设置分页参数
        pageRoll = PageRoll.set(Page.SIZE_5, pageRoll);
        // 查询用户所拥有的模板
        List<TemplateData> templateDatas = tempManageBusiness.searchAllTempByUser(pageRoll, templateData, userId);
        return templateDatas;
    }

    @Override
    public List<TemplateData> searchRecommend(String userId) {
        // 查询推荐模板
        List<TemplateData> recommendTemplates = tempManageBusiness.searchRecommend(userId);
        return recommendTemplates;
    }

    @Override
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData, Integer size) {
        // 设置分页参数
        if (size == 0 || size == null) {
            pageRoll = PageRoll.set(4, pageRoll);
        } else {
            pageRoll = PageRoll.set(size, pageRoll);
        }
        // 查询所有的模板
        List<TemplateData> templateDatas = tempManageBusiness.searchAllTemp(pageRoll, templateData);
        return templateDatas;
    }

    @Override
    public void addTemp(TemplateData templateData, File fileMain, File filePad, File filePC, File filePhone) {
        // 获取模板HTML内容
        String content = templateData.getStringContent();
        // 处理模板内容
        Integer begin = content.toUpperCase().indexOf("<meta charset=".toUpperCase());
        String newContent = "<%@ page language='java' pageEncoding='utf-8'%><html><head>"
                + content.substring(begin, content.length());
        templateData.setStringContent(newContent);
        // 添加模板
        tempManageBusiness.addTemp(templateData, fileMain, filePad, filePC, filePhone);
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
        return tempManageBusiness.getTemplateData(templateId);
    }

    /**
     * page页面统计
     * 
     * @param templateId 模板id
     * @param state page状态
     * @return
     */
    @Override
    public int statisticsTempPage(String templateId, String state) {
        return tempManageBusiness.statisticsTempPage(templateId, state);
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
        tempManageBusiness.updateTempState(tempId, state);
    }

    /**
     * 后台模板管理 删除模板 假删
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     */
    @Override
    public void delete(String tempId[]) {
        if (tempId.length > 0) { // 数组长度大于0的时候
            for (int i = 0; i < tempId.length; i++) {
                tempManageBusiness.delete(tempId[i]);
            }
        }
    }

    @Override
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData) {
        // 设置分页参数
        pageRoll = PageRoll.set(4, pageRoll);
        // 根据模板受喜欢的程度排序查询模板
        List<TemplateData> templateDatas = tempManageBusiness.searchByLike(pageRoll, templateData);
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
    @Override
    public void updateTemp(String tempId, TemplateData templateData) {
        tempManageBusiness.updateTemp(tempId, templateData);
    }

    /**
     * 
     * p排序查询所有的模板<br>
     * 
     * @author侯杨 <br>
     *           2014-2-14
     * 左香勇
     *           2014-6-6 添加排序参数sort
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData, String Type, int sort) {
        // 设置分页参数
        pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
        return tempManageBusiness.searchAllTempType(pageRoll, templateData, Type, sort);
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
    @SuppressWarnings("static-access")
	public List<PageData> countTempPage(PageRoll pageRoll,PageHelpData pageHelpData){
    	pageRoll=pageRoll.set(Page.SIZE_10, pageRoll);
        return tempManageBusiness.countTempPage(pageRoll,pageHelpData);
    }

    @Override
    public List<TemplateData> searchTemp(TemplateData templateData) {
        // 查询所有模板
        List<TemplateData> datas = tempManageBusiness.searchTemp(templateData);
        return datas;
    }

    @Override
    public TemplateData searchById(String tempId) {
        return tempManageBusiness.searchById(tempId);
    }
}
