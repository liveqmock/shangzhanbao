package com.mini.tempmanage.persistence;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.tempmanage.data.TemplateData;
import com.mini.tempmanage.data.TemplateHelpData;

/**
 * 模板管理持久化接口
 * 
 * @author 文东
 * @see ITempManagePersistence
 * @since
 */
public interface ITempManagePersistence extends IBasePersistence<TemplateData> {

    /**
     * 
     * 查询用户所拥有的模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update 冯鑫 
     *         在查询条件中增加域名为open条件
     *         
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象。存放条件查询的参数
     * @param userId 用户ID
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTempByUser(PageRoll, TemplateData, String)
     * @since [起始版本]
     */
    public List<TemplateData> searchAllTempByUser(PageRoll pageRoll, TemplateData templateData, String userId);

    /**
     * 
     * <br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update
     * @param userId 用户id
     * @return List<TemplateData> 推荐模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchRecommend(String)
     * @since
     */
    public List<TemplateData> searchRecommend(String userId);

    /**
     * 
     * 查询所有的模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-19
     * @update hy 2014-2-23 修改了统计
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateData> searchAllTemp(PageRoll pageRoll, TemplateData templateData);

    /**
     * 
     * 查看模板编码是否存在<br>
     * 
     * @author 文东 <br>
     *         2014-2-20
     * @update
     * @param tempSn 模板编码
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchSn(String)
     * @since
     */
    public List<TemplateData> searchSn(String tempSn);
    
    
    /**
     * 
     * 根据模板收喜欢的程度排序查询模板<br>
     * 
     * @author 文东 <br>
     *         2014-2-23
     * @update
     * @param pageRoll 分页参数
     * @param templateData 模板实体对象 用于存放条件查询的参数
     * @return List<TemplateData> 模板实体对象集合
     * @exception/throws
     * @see ITempManagePersistence#searchByLike(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateData> searchByLike(PageRoll pageRoll, TemplateData templateData);

    /**
     * 
     * p排序查询所有的模板<br>
     * 
     * @author侯杨 <br>
     *         2014-2-14
     *         左香勇
     *           2014-6-6 添加排序参数sort
     * @param pageRoll 分页参数
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see ITempManagePersistence#searchAllTemp(PageRoll, TemplateData)
     * @since
     */
    public List<TemplateHelpData> searchAllTempType(PageRoll pageRoll, TemplateData templateData,String Type, int sort);
    /**
     * 根据对象条件返回对象集合
     * @param templateData 模板对象
     * @return List<TemplateData> 模板集合
     * @exception/throws
     * @see 
     * @since
     */
    public List<TemplateData> searchTemplateData(JSONObject jObject);
    
    
}
