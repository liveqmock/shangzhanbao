package com.mini.helpManager.action;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.util.FileUtil;
import com.mini.helpManager.data.HelpArticleCateData;
import com.mini.helpManager.data.HelpArticleData;
import com.mini.helpManager.facade.HelpManagerFacade;
/**
 * 
 * 帮助与支持内容管理
 *
 * @author 冯鑫
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ResultPath("/")
@Results({
    @Result(name = "queryHelpArticleTypeNum", location = "/view/pages/mini/back/helpArticle/helpManager.jsp"),
    @Result(name = "queryListHelpArticle", location = "/view/pages/mini/back/helpArticle/helpManagerlist.jsp"),
    @Result(name = "turnAddHelpArticleJSP", location = "/view/pages/mini/back/helpArticle/addHelpArticle.jsp"),
    @Result(name = "turnFrontHelpHelpArticleJSP", location = "/view/pages/mini/back/helpArticle/helpManager_front.jsp"),
    @Result(name = "viewHelpArticleData", location = "/view/pages/mini/back/helpArticle/viewHelpManager_front.jsp"),
    @Result(name = "queryListHelpArticleByCate", location = "/view/pages/mini/back/helpArticle/helpManager_front.jsp"),
    @Result(name = "trunLeftHelpArticle", location = "/view/pages/mini/back/helpArticle/helpFrontLeft.jsp"),
    @Result(name="tohelpmini",location="/view/pages/mini/commonality/Helpmini.jsp"),
    @Result(name="tohelpmini1",location="/view/pages/mini/commonality/Helpmini1.jsp"),
    @Result(name="tohelpmini2",location="/view/pages/mini/commonality/Helpmini2.jsp"),
    @Result(name="mainHelp",location="/view/pages/mini/commonality/Helpmini.jsp")
    
})
public class HelpManagerAction extends FrmAction {
    @Resource(name = "helpManagerFacade")
    private HelpManagerFacade helpManagerFacade;
    
    @SuppressWarnings("unchecked")
    private TreeMap<Integer, String> helpArticleCate = CacheUtil.getInstance().getCacheMap("helpArticleCate");
    
    private HelpArticleData helpArticleData;
    
    private HelpArticleCateData helpArticleCateData;
    //已经显示文章集合
    private List<HelpArticleData> list_helpArticle = new ArrayList<HelpArticleData>(); 
    //页面上相关文章list集合
    private List<HelpArticleData> about_helpArticle = new ArrayList<HelpArticleData>(); 
    //未显示文章集合
    private List<HelpArticleCateData> list_helpArticleCate = new ArrayList<HelpArticleCateData>();
    //文章内容
    private String content;
    private String helpArticleCateSort;
    private String param;
    /**
     * 
     * 帮助页面入口方法<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-11
     * @update 
     */
    public String turnHelpPage(){
        helpArticleData = new HelpArticleData();
        helpArticleData.setHelparticlestate(1);
        helpArticleData.setHelparticlecate("7dd580f547afcf880147afd9a3020002");
        list_helpArticle = this.helpManagerFacade.queryListHelpArtcleByClickNum(helpArticleData,10);
        param="help";
        return "mainHelp";
    }
    /**
     * 
     * 查询所有数据<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     */
    public String queryListHelpArticle(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleTypeNum(helpArticleCateData);
        helpArticleCateData = list_helpArticleCate.get(0);
        list_helpArticle = helpArticleCateData.getList_helpArticle();
        return "queryListHelpArticle";
    }
    /**
     * 
     * 前台查询不同分类下的文章<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-7
     * @update 
     * @param [参数1]     [参数1说明]
     */
    public String queryListHelpArticleByCate(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleTypeNum(helpArticleCateData);
        helpArticleCateData = new HelpArticleCateData();
        helpArticleCateData.setId(helpArticleData.getHelparticlecate());
        helpArticleCateData = helpManagerFacade.findHelpArticleCateDataByID(helpArticleCateData);
        helpArticleData.setHelparticlestate(1);
        list_helpArticle = this.helpManagerFacade.queryListHelpArticle(helpArticleData);
        return "queryListHelpArticleByCate";
    }
    /**
     * 
     * 搜索功能方法<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-11
     * @update 
     */
    public String searchListHelpArticle(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleCate(helpArticleCateData);
        list_helpArticle = this.helpManagerFacade.queryListHelpArticle(helpArticleData);
        //此设置 无任何逻辑意义 只是为了页面所逻辑判断
        helpArticleData.setHelparticlecate("1");
        helpArticleCateData.setHelparticlecatename("搜索");
        return "queryListHelpArticleByCate";
    }
    /**
     * 
     * 根据文章分类查询每个分类下有多少文章<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-6
     * @update 
     */
    public String queryHelpArticleTypeNum(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleTypeNum(helpArticleCateData);
        return "queryHelpArticleTypeNum";
    }
    /**
     * 
     * 跳转到增加文章页面<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     */
    public String turnAddHelpArticleJSP(){
        helpArticleCateData = helpManagerFacade.findHelpArticleCateDataByID(helpArticleCateData);
        return "turnAddHelpArticleJSP";
    }
    /**
     * 
     * 跳转到前台帮助与支持分类页面<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-7
     * @update 
     */
    public String turnFrontHelpHelpArticleJSP(){
        helpArticleCateData = new HelpArticleCateData();
        helpArticleCateData.setHelparticlecatestate(1);
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleTypeNum(helpArticleCateData);
        return "turnFrontHelpHelpArticleJSP";
    }
    /**
     * 
     * 右侧页面<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-11
     * @update 
     */
    public String trunLeftHelpArticle(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleCate(helpArticleCateData);
        return "trunLeftHelpArticle";
    }
    
    /**
     * 
     * 增加文章数据和生成文件<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-6
     * @update 
     */
    public void addHelpArticleAndFile(){
        //获取文件保存路径
        String pagePath = "/helpArticle";
        String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);
        //设置文件保存路径
        helpArticleData.setHelparticlepath(realpath);
        helpManagerFacade.addHelpArticleAndFile(helpArticleData,content);
        json="1";
    }
    /**
     * 
     * 查看帮助文章<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-11
     * @update 
     */
    public String findHelpArticleData(){
        //获取文件保存路径
        String pagePath = "/helpArticle";
        String realpath = ServletActionContext.getServletContext().getRealPath(pagePath);
        helpArticleData = helpManagerFacade.findHelpArticleDataByID(helpArticleData);
        content = FileUtil.readFileByCode(realpath+"/"+helpArticleData.getHelparticlepath());
        if(!"".equals(content)&&null!=content){
            content = content.substring(content.indexOf("<body")+6, content.lastIndexOf("</body>")).replace('\"', '\'');
        }
        helpArticleCateData = new HelpArticleCateData();
        helpArticleCateData.setId(helpArticleData.getHelparticlecate());
        helpArticleCateData = helpManagerFacade.findHelpArticleCateDataByID(helpArticleCateData);
        return "turnAddHelpArticleJSP";
    }
    /**
     * 
     * 获取文章信息<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-11
     * @update 
     */
    public String viewHelpArticleData(){
        list_helpArticleCate = this.helpManagerFacade.queryHelpArticleTypeNum(helpArticleCateData);
        helpArticleData = helpManagerFacade.findHelpArticleDataByID(helpArticleData);
        helpArticleCateData.setId(helpArticleData.getHelparticlecate());
        helpArticleCateData = helpManagerFacade.findHelpArticleCateDataByID(helpArticleCateData);
        about_helpArticle = helpManagerFacade.queryListHelpArtcleByClickNum(helpArticleData, 3);
        return "viewHelpArticleData";
    }
    /**
     * 
     * 修改文章类别顺序<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-8
     * @update 
     */
    public void updateHelpArticleCateDataSort(){
        helpManagerFacade.updateHelpArticleCateDataSort(helpArticleCateData, helpArticleCateSort);
    }
    /**
     * 
     * 修改文章顺序<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-8-8
     * @update 
     */
    public void updateHelpArticleDataSort(){
        helpManagerFacade.updateHelpArticleDataSort(helpArticleData, helpArticleCateSort);
    }
    public void updateHelpArticleData(){
        helpManagerFacade.updateHelpArticle(helpArticleData);
    }
    /**
     * 
     * 修改文章类别对象<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-14
     * @update 
     */
    public void updateHelpArticleCate(){
        helpManagerFacade.updateHelpArticleCate(helpArticleCateData);
        json="1";
    }
    /**
     * 
     * 增加文章分类<br>
     * 
     * @author 冯鑫 <br> 
     *		   2014-8-14
     * @update 
     */
    public void addArticleCateData(){
        helpManagerFacade.addHelpArticleCate(helpArticleCateData);
    }
    /**
     * 
     * 帮组与支持跳转<br>
     * 
     * @author 侯杨 <br> 
     *         2014-10-15
     * @update 
     */
    public  String tohelpmini(){
        param="help";
        return "tohelpmini";
    }
    /**
     * 
     * 帮组与支持跳转<br>
     * 
     * @author 侯杨 <br> 
     *         2014-10-15
     * @update 
     */
    public  String tohelpmini1(){
        param="help";
        return "tohelpmini1";
    }
    /**
     * 
     * 帮组与支持跳转<br>
     * 
     * @author 侯杨 <br> 
     *         2014-10-15
     * @update 
     */
    public  String tohelpmini2(){
        param="help";
        return "tohelpmini2";
    }
    public void setHelpManagerFacade(HelpManagerFacade helpManagerFacade) {
        this.helpManagerFacade = helpManagerFacade;
    }

    public HelpArticleData getHelpArticleData() {
        return helpArticleData;
    }

    public void setHelpArticleData(HelpArticleData helpArticleData) {
        this.helpArticleData = helpArticleData;
    }

    public List<HelpArticleData> getList_helpArticle() {
        return list_helpArticle;
    }

    public void setList_helpArticle(List<HelpArticleData> list_helpArticle) {
        this.list_helpArticle = list_helpArticle;
    }
    public TreeMap<Integer, String> getHelpArticleCate() {
        return helpArticleCate;
    }
    public void setHelpArticleCate(TreeMap<Integer, String> helpArticleCate) {
        this.helpArticleCate = helpArticleCate;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public HelpArticleCateData getHelpArticleCateData() {
        return helpArticleCateData;
    }
    public void setHelpArticleCateData(HelpArticleCateData helpArticleCateData) {
        this.helpArticleCateData = helpArticleCateData;
    }
    public List<HelpArticleCateData> getList_helpArticleCate() {
        return list_helpArticleCate;
    }
    public void setList_helpArticleCate(List<HelpArticleCateData> list_helpArticleCate) {
        this.list_helpArticleCate = list_helpArticleCate;
    }
    public String getHelpArticleCateSort() {
        return helpArticleCateSort;
    }
    public void setHelpArticleCateSort(String helpArticleCateSort) {
        this.helpArticleCateSort = helpArticleCateSort;
    }
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }
    public List<HelpArticleData> getAbout_helpArticle() {
        return about_helpArticle;
    }
    public void setAbout_helpArticle(List<HelpArticleData> about_helpArticle) {
        this.about_helpArticle = about_helpArticle;
    }
}
