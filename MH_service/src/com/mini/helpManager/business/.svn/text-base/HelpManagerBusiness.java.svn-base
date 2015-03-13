package com.mini.helpManager.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.helpManager.data.HelpArticleCateData;
import com.mini.helpManager.data.HelpArticleData;
import com.mini.helpManager.persistence.IHelpArticleCatePersistence;
import com.mini.helpManager.persistence.IHelpManagerPersistence;

/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Component("helpManagerBusiness")
public class HelpManagerBusiness extends FrmBusiness implements IHelpManagerBusiness {
    
    @Resource(name="helpManagerPersistence")
    private IHelpManagerPersistence helpManagerPersistence;
    
    @Resource(name="helpManagerCatePersistence")
    private IHelpArticleCatePersistence helpArticleCatePersistence;
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
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData , int num){
        return this.helpManagerPersistence.queryListHelpArtcleByClickNum(helpArticleData , num);
    }
    
    
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
    public List<HelpArticleData> queryListHelpArticle(HelpArticleData helpArticleData){
        return helpManagerPersistence.queryListHelpArticle(helpArticleData);
    }
    /**
     * 
     * 根据文章分类查询每个分类下有多少文章<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleCateData
     * @return  List<HelpArticleCateData>
     */
    public List<HelpArticleCateData> queryHelpArticleTypeNum(HelpArticleCateData helpArticleCateData){
       // return helpManagerPersistence.queryHelpArticleTypeNum(helpArticleData);
        List<HelpArticleCateData> list = this.helpArticleCatePersistence.queryHelpArticleCateData(helpArticleCateData);
        for (int i = 0; i < list.size(); i++) {
            HelpArticleData helpArticleData = new HelpArticleData();
            helpArticleData.setHelparticlecate(list.get(i).getId());
            list.get(i).setList_helpArticle(helpManagerPersistence.queryListHelpArticle(helpArticleData));
        }
        return list;
    }
    /**
     * 
     * 增加文章数据<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void addHelpArticle(HelpArticleData helpArticleData){
        helpManagerPersistence.add(helpArticleData);
    }
    /**
     * 
     * 修改对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-7
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void updateHelpArticle(HelpArticleData helpArticleData){
        helpManagerPersistence.update(helpArticleData);
    }
    /**
     * 
     * 更具id查询对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-7
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  HelpArticleData
     */
    public HelpArticleData findHelpArticleDataByID(HelpArticleData helpArticleData){
        return helpManagerPersistence.retrieve(helpArticleData.getId());
    }
    /**
     * 
     * 查询文章类别对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     * @param   HelpArticleCateData helpArticleCateData
     * @return  HelpArticleCateData
     */
    public HelpArticleCateData findHelpArticleCateDataByID(HelpArticleCateData helpArticleCateData){
        return helpArticleCatePersistence.retrieve(helpArticleCateData.getId());
    }
    /**
     * 
     * 只查询所有文章分类<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public List<HelpArticleCateData> queryHelpArticleCate(HelpArticleCateData helpArticleCateData){
        return this.helpArticleCatePersistence.queryHelpArticleCateData(helpArticleCateData);
    }
    /**
     * 
     * 修改对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     * @param [参数1]     [参数1说明]
     */
    public void updateHelpArticleCate(HelpArticleCateData helpArticleCateData){
        this.helpArticleCatePersistence.update(helpArticleCateData);
    }
    /**
     * 
     * 增加分类<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-14
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public void addHelpArticleCate(HelpArticleCateData helpArticleCateData){
        this.helpArticleCatePersistence.add(helpArticleCateData);
    }
    
    
    
    public void setHelpManagerPersistence(IHelpManagerPersistence helpManagerPersistence) {
        this.helpManagerPersistence = helpManagerPersistence;
    }
    public void setHelpArticleCatePersistence(IHelpArticleCatePersistence helpArticleCatePersistence) {
        this.helpArticleCatePersistence = helpArticleCatePersistence;
    }
    

}
