package com.mini.helpManager.persistence;

import java.util.List;
import java.util.Map;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.helpManager.data.HelpArticleData;
/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IHelpManagerPersistence extends IBasePersistence<HelpArticleData> {
    /**
     * 
     * 更具文章点击数查询文章列表 此方法只用在帮助与支持首页<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-13
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  List<HelpArticleData>
     */
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData, int num);
    /**
     * 
     * 查询所有数据<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  List<HelpArticleData>
     */
    public List<HelpArticleData> queryListHelpArticle(HelpArticleData helpArticleData);
    /**
     * 
     * 根据文章分类查询每个分类下有多少文章<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  Map<String,String>
     */
    public Map<String,String> queryHelpArticleTypeNum(HelpArticleData helpArticleData);
}
