package com.mini.tempmanage.service;

import java.io.File;
import java.util.List;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.page.data.PageData;
import com.mini.page.data.PageHelpData;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;
import com.mini.tempmanage.persistence.ITempManagePersistence;

/**
 * 模板管理服务接口
 * 
 * @author 文东
 * @see ITempManageService
 * @since
 */
public interface ITempManageService extends IService {

    /**
     * 
     * 查询用户所拥有的模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象。存放条件查询的参数
     * @param userId 用户ID
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManageService#searchAllTempByUser(PageRoll, TemplateData, userId)
     * @since
     */
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId);

    /**
     * 
     * 查询推荐模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param userId 用户id
     * @return List<TemplateData> 推荐模板集合
     * @exception/throws
     * @see ITempManageService#searchRecommend(String)
     * @since [起始版本]
     */
    public List<TemplateData> searchRecommend(String userId);

    /**
     * 
     * 查询所有模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManageService#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData, Integer size);

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
     * @return void 无返回值
     * @exception/throws
     * @see ITempManageService#addTemp(TemplateData, File, File, File, File)
     * @since
     */
    public void addTemp(TemplateData templateData, File fileMain, File filePad, File filePC, File filePhone);

    /**
     * 更具模板id查询模板信息 后台模板管理
     * 
     * @author hy
     * @date 2014-2-22
     * @param templateId 模板id
     * @return
     */
    public TemplateData getTemplateData(String templateId);

    /**
     * page页面统计
     * 
     * @param templateId 模板id
     * @param state page状态
     * @return
     */
    public int statisticsTempPage(String templateId, String state);

    /**
     * 后台 模板管理 启用 停用操作
     * 
     * @author hy
     * @date 2014-2-22
     * @param tempId
     * @param state
     */
    public void updateTempState(String tempId, String state);

    /**
     * 后台模板管理 删除模板 假删
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId[]
     */

    public void delete(String tempId[]);

    /**
     * 
     * 根据模板受喜欢程度排序查询模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-23
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象 存放查询条件参数
     * @return List<TemplateData>
     * @exception/throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData);

    /**
     * 后台模板管理 修改模板
     * 
     * @author hy
     * @date 2014-2-23
     * @param tempId
     * @param templateData
     */
    public void updateTemp(String tempId, TemplateData templateData);

    /**
     * 
     * p排序查询所有的模板<br>
     * 
     * @author侯杨 <br>
     *           2014-2-14
     *        左香勇
     *           2014-6-6 添加排序参数sort
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData, String Type, int sort);

    /**
     * 模板详情页面查看page列表
     * 
     * @author hy  update  侯杨
     * @date 2014-2-25   
     * @param pageRoll 分页
     * @param pageHelpData  帮组类 传值
     * @return
     */
    public List<PageData> countTempPage(PageRoll pageRoll,PageHelpData pageHelpData);

    /**
     * 
     * 查询所有模板<br>
     * 
     * @author 文东 <br>
     *         2014-3-5
     * @update
     * @param templateData
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManageService#searchTemp(TemplateData)
     * @since
     */
    public List<TemplateData> searchTemp(TemplateData templateData);

    /**
     * 
     * 根据模板ID查询模板<br>
     * 
     * @author 文东 <br>
     *         2014-3-20
     * @update
     * @param tempId 模板ID
     * @return TemplateData 模板对象
     * @exception/throws
     * @see ITempManageService#searchById(String)
     * @since
     */
    public TemplateData searchById(String tempId);
}
