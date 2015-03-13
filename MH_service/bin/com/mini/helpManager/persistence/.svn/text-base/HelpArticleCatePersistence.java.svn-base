package com.mini.helpManager.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.helpManager.data.HelpArticleCateData;
/**
 * 
 *  文章类别Persistence<br> 
 *
 * @author 冯鑫
 */
@SuppressWarnings("unchecked")
@Component("helpManagerCatePersistence")
public class HelpArticleCatePersistence extends BasePersistence<HelpArticleCateData> implements IHelpArticleCatePersistence {
    /**
     * 
     * 查询所有类别（不包括类别下的文章）<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public List<HelpArticleCateData> queryHelpArticleCateData(HelpArticleCateData helpArticleCateData){
        StringBuffer hql = new StringBuffer();
        hql.append(" from HelpArticleCateData t where t.isdelete=1 ");
        if(null!=helpArticleCateData){
            if(null!=helpArticleCateData.getHelparticlecatestate()&&!"".equals(helpArticleCateData.getHelparticlecatestate())){
                hql.append(" and t.helparticlecatestate="+helpArticleCateData.getHelparticlecatestate());
            }
            if(null!=helpArticleCateData.getId()&&!"".equals(helpArticleCateData.getId())){
                hql.append(" and t.id='"+helpArticleCateData.getId()+"'");
            }
        }
        hql.append(" order by t.helparticlecatesort");
        return this.search(hql.toString());
    }
}
