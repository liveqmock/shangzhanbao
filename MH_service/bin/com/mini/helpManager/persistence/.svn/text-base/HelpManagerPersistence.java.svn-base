package com.mini.helpManager.persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.mini.helpManager.data.HelpArticleData;
/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SuppressWarnings("unchecked")
@Component("helpManagerPersistence")
public class HelpManagerPersistence extends BasePersistence<HelpArticleData> implements IHelpManagerPersistence {
    
    /**
     * 
     * 更具文章点击数查询文章列表 此方法只用在帮助与支持首页<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-13
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  List<HelpArticleData>
     */
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData,int num){
        StringBuffer hql =  new StringBuffer();
        hql.append(" from HelpArticleData t where 1=1 ");
        if(null!=helpArticleData&&!"".equals(helpArticleData)){
            if(null!=helpArticleData.getHelparticlecate()&&!"".equals(helpArticleData.getHelparticlecate())){
                hql.append(" and t.helparticlecate='"+helpArticleData.getHelparticlecate()+"'");
            }
            if(null!=helpArticleData.getHelparticlestate()&&!"".equals(helpArticleData.getHelparticlestate())){
                hql.append(" and t.helparticlestate="+helpArticleData.getHelparticlestate());
            }
        }
        hql.append(" order by t.helparticleclicknum desc");
        return this.search(hql.toString(), 0, num);
    }
    /**
     * 
     * 查询所有数据<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  List<HelpArticleData>
     */
    public List<HelpArticleData> queryListHelpArticle(HelpArticleData helpArticleData){
        StringBuffer hql = new StringBuffer();
        hql.append("from HelpArticleData h where h.isdelete=1 ");
        if(null!=helpArticleData&&!"".equals(helpArticleData)){
            if(null!=helpArticleData.getHelparticlecate()&&!"".equals(helpArticleData.getHelparticlecate())){
                hql.append(" and h.helparticlecate='"+helpArticleData.getHelparticlecate()+"'");
            }
            if(null!=helpArticleData.getHelparticlestate()&&!"".equals(helpArticleData.getHelparticlestate())){
                hql.append(" and h.helparticlestate="+helpArticleData.getHelparticlestate());
            }
            if(null!=helpArticleData.getHelparticlename()&&!"".equals(helpArticleData.getHelparticlename())){
                hql.append(" and h.helparticlename like '"+helpArticleData.getHelparticlename()+"%'");
            }
        }
        hql.append(" order by helparticlesort");
        return this.search(hql.toString());
    }
    /**
     * 
     * 根据文章分类查询每个分类下有多少文章<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData
     * @return  Map<String,String>
     */
    public Map<String,String> queryHelpArticleTypeNum(HelpArticleData helpArticleData){
        //帮助文章类别字典值
        TreeMap<Integer, String> helpArticleCate = CacheUtil.getInstance().getCacheMap("helpArticleCate");
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as num from mini_help_article t where 1=1 ");
        if(null!=helpArticleData.getHelparticlestate()&&!"".equals(helpArticleData.getHelparticlestate())){
            sql.append("and t.helparticlestate="+helpArticleData.getHelparticlestate());
        }
        Map<String,String> HelpArticleTypeNumMap = new HashMap<String,String>();
        JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        Iterator it = helpArticleCate.keySet().iterator();
        while (it.hasNext()) {  
            String key = String.valueOf(it.next());
            List<ETIPResultSet> list = dao.queryForList(sql.toString()+" and t.helparticlecate="+key, null);
            if (list != null && list.size() > 0) {
                HelpArticleTypeNumMap.put(key, list.get(0).getString("NUM"));
            }
        }  
        return HelpArticleTypeNumMap;
    }


}
