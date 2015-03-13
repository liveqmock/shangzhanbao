package com.mini.helpManager.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.mini.helpManager.data.HelpArticleCateData;
import com.mini.helpManager.data.HelpArticleData;

/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IHelpManagerBusiness extends IBusiness {
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
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData , int num);
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
    public List<HelpArticleCateData> queryHelpArticleTypeNum(HelpArticleCateData helpArticleCateData);
    /**
     * 
     * 增加文章数据<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void addHelpArticle(HelpArticleData helpArticleData);
    /**
     * 
     * 修改对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-7
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void updateHelpArticle(HelpArticleData helpArticleData);
    /**
     * 
     * 更具id查询对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-7
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  HelpArticleData
     */
    public HelpArticleData findHelpArticleDataByID(HelpArticleData helpArticleData);
    /**
     * 
     * 查询文章类别对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     * @param   HelpArticleCateData helpArticleCateData
     * @return  HelpArticleCateData
     */
    public HelpArticleCateData findHelpArticleCateDataByID(HelpArticleCateData helpArticleCateData);
    /**
     * 
     *〈一句话功能简述〉<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public List<HelpArticleCateData> queryHelpArticleCate(HelpArticleCateData helpArticleCateData);
    /**
     * 
     * 修改对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     * @param [参数1]     [参数1说明]
     */
    public void updateHelpArticleCate(HelpArticleCateData helpArticleCateData);
    /**
     * 
     * 增加分类<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-14
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public void addHelpArticleCate(HelpArticleCateData helpArticleCateData);
}
