package com.mini.helpManager.facade;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.util.FileUtil;
import com.mini.helpManager.data.HelpArticleCateData;
import com.mini.helpManager.data.HelpArticleData;
import com.mini.helpManager.service.IHelpManagerService;
import com.mini.util.OutClobFile;
/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("helpManagerFacade")
public class HelpManagerFacade extends FrmFacade {
    @Resource(name="helpManagerService")
    private IHelpManagerService helpManagerService;
    /**
     * 
     * 更具文章点击数查询文章列表 此方法只用在帮助与支持首页<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-13
     * @update 
     * @param HelpArticleData helpArticleData num：查询数据的条数
     * @return  List<HelpArticleData>
     */
    public List<HelpArticleData> queryListHelpArtcleByClickNum(HelpArticleData helpArticleData,int num){
        return this.helpManagerService.queryListHelpArtcleByClickNum(helpArticleData,num);
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
        return helpManagerService.queryListHelpArticle(helpArticleData);
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
        return helpManagerService.queryHelpArticleTypeNum(helpArticleCateData);
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
        return helpManagerService.queryHelpArticleCate(helpArticleCateData);
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
        return helpManagerService.findHelpArticleCateDataByID(helpArticleCateData);
    }
    /**
     * 
     * 增加文件 已经生成数据库表数据<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     * @param HelpArticleData helpArticleData ,String content
     */
    public void addHelpArticleAndFile(HelpArticleData helpArticleData ,String content){
        //获取文章模板内容
        String tempContent = FileUtil.readFile(helpArticleData.getHelparticlepath()+"/helpArticleTemp.jsp");
        //将模板内容和content拼接到一起
        tempContent = tempContent.substring(0, tempContent.lastIndexOf("</body>"));
        content = tempContent.concat(content).concat("</body></html>");
        //文件名称
        String fileName = String.valueOf(new Date().getTime()).concat(".jsp");
        //生成文件
        try {
            OutClobFile.generaFile(content, helpArticleData.getHelparticlepath(), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        helpArticleData.setHelparticlepath(fileName);
        //如果对象id属性不为空，则删除原来文件。
        if(!"".equals(helpArticleData.getId())&&null!=helpArticleData.getId()){
            HelpArticleData tempHelpArticleData = new HelpArticleData();
            tempHelpArticleData = helpManagerService.findHelpArticleDataByID(helpArticleData);
            FileUtil.delFile(tempHelpArticleData.getHelparticlepath());
            helpManagerService.updateHelpArticle(helpArticleData);
        }else{
            //文件已经生成 增加数据库数据
            helpManagerService.addHelpArticle(helpArticleData);
        }
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
        return helpManagerService.findHelpArticleDataByID(helpArticleData);
    }
    /**
     * 
     * 修改文章类别顺序<br>
     * 
     * @author fengxin <br> 
     *		   2014-8-8
     * @update 
     * @param helpArticleCateData helpArticleCateSort
     */
    public void updateHelpArticleCateDataSort(HelpArticleCateData helpArticleCateData,String helpArticleCateSort){
        helpManagerService.updateHelpArticleCateDataSort(helpArticleCateData,helpArticleCateSort);
    }
    /**
     * 
     * 修改文章顺序<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     * @param HelpArticleData helpArticleData,String helpArticleCateSort
     */
    public void updateHelpArticleDataSort(HelpArticleData helpArticleData,String helpArticleCateSort){
        helpManagerService.updateHelpArticleDataSort(helpArticleData, helpArticleCateSort);
    }
    /**
     * 
     * 修改文章类别对象<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-14
     * @update 
     * @param HelpArticleCateData helpArticleCateData
     */
    public void updateHelpArticleCate(HelpArticleCateData helpArticleCateData){
        helpManagerService.updateHelpArticleCate(helpArticleCateData);
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
        helpManagerService.addHelpArticleCate(helpArticleCateData);
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
        helpManagerService.updateHelpArticle(helpArticleData);
    }
    public void setHelpManagerService(IHelpManagerService helpManagerService) {
        this.helpManagerService = helpManagerService;
    }


}
