package com.mini.helpManager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.helpManager.business.IHelpManagerBusiness;
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
@Component("helpManagerService")
public class HelpManagerService extends FrmService implements IHelpManagerService {
    
    @Resource(name="helpManagerBusiness")
    private IHelpManagerBusiness helpManagerBusiness;
    
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
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData, int num){
        return this.helpManagerBusiness.queryListHelpArtcleByClickNum(helpArticleData,num);
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
        return helpManagerBusiness.queryListHelpArticle(helpArticleData);
    }
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
    public List<HelpArticleCateData> queryHelpArticleTypeNum(HelpArticleCateData helpArticleCateData){
        return helpManagerBusiness.queryHelpArticleTypeNum(helpArticleCateData);
    }
    /**
     * 
     * 只查询出文章分类list<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  Map<String,String>
     */
    public List<HelpArticleCateData> queryHelpArticleCate(HelpArticleCateData helpArticleCateData){
        return helpManagerBusiness.queryHelpArticleCate(helpArticleCateData);
    }
    /**
     * 
     * 增加文章数据<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void addHelpArticle(HelpArticleData helpArticleData){
        helpManagerBusiness.addHelpArticle(helpArticleData);
    }
    /**
     * 
     * 修改对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-7
     * @update 
     * @param HelpArticleData helpArticleData
     */
    public void updateHelpArticle(HelpArticleData helpArticleData){
        HelpArticleData temphelpArticleData = helpManagerBusiness.findHelpArticleDataByID(helpArticleData);
        if(null!=helpArticleData.getHelparticlestate()&&!"".equals(helpArticleData.getHelparticlestate())){
            temphelpArticleData.setHelparticlestate(helpArticleData.getHelparticlestate());
        }
        if(null!=helpArticleData.getHelparticlename()&&!"".equals(helpArticleData.getHelparticlename())){
            temphelpArticleData.setHelparticlename(helpArticleData.getHelparticlename());
        }
        helpManagerBusiness.updateHelpArticle(temphelpArticleData);
    }
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
    public HelpArticleData findHelpArticleDataByID(HelpArticleData helpArticleData){
        //修改对象点击量
        helpArticleData = helpManagerBusiness.findHelpArticleDataByID(helpArticleData);
        if(null!=helpArticleData.getHelparticleclicknum()&&!"".equals(helpArticleData.getHelparticleclicknum())){
            helpArticleData.setHelparticleclicknum(helpArticleData.getHelparticleclicknum()+1);
        }else{
            helpArticleData.setHelparticleclicknum(1);
        }
        helpManagerBusiness.updateHelpArticle(helpArticleData);
        return helpArticleData;
    }
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
    public HelpArticleCateData findHelpArticleCateDataByID(HelpArticleCateData helpArticleCateData){
        return helpManagerBusiness.findHelpArticleCateDataByID(helpArticleCateData);
    }
    /**
     * 
     * 修改文章类别顺序<br> 
     * 
     * @author fengxin <br> 
     *         2014-8-8
     * @update 
     * @param helpArticleCateData helpArticleCateSort
     */
    public void updateHelpArticleCateDataSort(HelpArticleCateData helpArticleCateData,String helpArticleCateSort){
        
            String [] str =helpArticleCateSort.split(",");
            for (int i = 0; i < str.length; i++) {
                HelpArticleCateData temp_helpArticleCateData = new HelpArticleCateData();
                temp_helpArticleCateData.setId(str[i]);
                temp_helpArticleCateData = helpManagerBusiness.findHelpArticleCateDataByID(temp_helpArticleCateData);
                temp_helpArticleCateData.setHelparticlecatesort(i+1);
                this.helpManagerBusiness.updateHelpArticleCate(temp_helpArticleCateData);
             }
        
       
    }
    /**
     * 
     * 修改文章顺序<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     * @param HelpArticleData helpArticleData,String helpArticleCateSort
     */
    public void updateHelpArticleDataSort(HelpArticleData helpArticleData,String helpArticleCateSort){
            String [] str =helpArticleCateSort.split(",");
            for (int i = 0; i < str.length; i++) {
                HelpArticleData temp_helpArticleData = new HelpArticleData();
                temp_helpArticleData.setId(str[i]);
                temp_helpArticleData = helpManagerBusiness.findHelpArticleDataByID(temp_helpArticleData);
                temp_helpArticleData.setHelparticlesort(String.valueOf(i+1));
                this.helpManagerBusiness.updateHelpArticle(temp_helpArticleData);
             }
        
        
    }
    /**
     * 
     * 修改文章类别对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-14
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public void updateHelpArticleCate(HelpArticleCateData helpArticleCateData){
        HelpArticleCateData temp_helpArticleCateData = this.helpManagerBusiness.findHelpArticleCateDataByID(helpArticleCateData);
        if(null!=helpArticleCateData.getHelparticlecatestate()&&!"".equals(helpArticleCateData.getHelparticlecatestate())){
            temp_helpArticleCateData.setHelparticlecatestate(helpArticleCateData.getHelparticlecatestate());
        }
        if(null!=helpArticleCateData.getHelparticlecatename()&&!"".equals(helpArticleCateData.getHelparticlecatename())){
            temp_helpArticleCateData.setHelparticlecatename(helpArticleCateData.getHelparticlecatename());
        }
        helpManagerBusiness.updateHelpArticleCate(temp_helpArticleCateData);
    }
    public void setHelpManagerBusiness(IHelpManagerBusiness helpManagerBusiness) {
        this.helpManagerBusiness = helpManagerBusiness;
    }
    /**
     * 
     * 增加分类<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-14
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public void addHelpArticleCate(HelpArticleCateData helpArticleCateData){
        this.helpManagerBusiness.addHelpArticleCate(helpArticleCateData);
    }

}