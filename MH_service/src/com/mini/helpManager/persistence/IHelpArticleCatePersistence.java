package com.mini.helpManager.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.mini.helpManager.data.HelpArticleCateData;
/**
 * 
 * 文章类别<br> 
 *
 * @author 冯鑫
 */
public interface IHelpArticleCatePersistence extends IBasePersistence<HelpArticleCateData> {
    /**
     * 
     * 查询所有类别（不包括类别下的文章）<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public List<HelpArticleCateData> queryHelpArticleCateData(HelpArticleCateData helpArticleCateData);
}
