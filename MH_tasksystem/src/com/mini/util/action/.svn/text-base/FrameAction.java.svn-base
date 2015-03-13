package com.mini.util.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ResouceUtil;
import com.itour.etip.pub.frame.FrmAction;

/**
 * 页面框架，使用ACTION跳转，不直接访问jsp
 * 
 * @author 何大勇
 * @date 2013-9-3
 */
@Results(value = {
        @Result(name = "index", location = "/view/pages/mini/back/index/mini_index.jsp"),
        @Result(name = "index2", location = "frame/key/oprating", type = "redirectAction"),
        // @Result(name="sc",location="/view/pages/ctn/sc/Service.html"),
        @Result(name = "sc", location = "data_statistic/key/showData", type = "redirectAction"),
        @Result(name = "sp", location = "/mini_index.jsp"), @Result(name = "top", location = "/mini_top.jsp"),
        @Result(name = "backtop", location = "/top.jsp"),
        @Result(name = "menu", location = "/view/pages/mini/back/index/left.jsp"),
        @Result(name = "portal", location = "/view/pages/ctn/portal/portal.jsp"),
        @Result(name = "spTop", location = "/view/pages/ctn/sp/index/top.jsp"),
        @Result(name = "spLeft", location = "/left.jsp"),
        @Result(name = "spContent", location = "/view/pages/ctn/sp/index/serviceProviderHome.jsp"),
        @Result(name = "targetURL", location = "${targetURL}", type = "redirect"),
        @Result(name = "about", location = "/view/pages/mini/commonality/About.jsp"),
        @Result(name = "help", location = "/view/pages/mini/commonality/Helpmini.jsp"),
        @Result(name = "productShop", location = "/view/pages/mini/front/app_view.jsp"),
        @Result(name = "client", location = "/view/pages/mini/commonality/Customer_Stories.jsp"),
        @Result(name = "methodL", location = "/view/pages/mini/front/methodology_Introduction.jsp"),
        @Result(name = "toIndex", location = "/view/pages/mini/commonality/index.jsp"),
        @Result(name = "toselectTemp", location = "/view/pages/mini/commonality/SelectTmplate.jsp"),
        @Result(name = "help1", location = "/view/pages/mini/commonality/Help_content_moreflow.jsp"),
        @Result(name = "help2", location = "/view/pages/mini/commonality/Help_content_talkchangepw.jsp"),
        @Result(name = "help3", location = "/view/pages/mini/commonality/Help_content_publishintroduce.jsp"),
        @Result(name = "help4", location = "/view/pages/mini/commonality/Help_content_publishupdate.jsp"),
        @Result(name = "help5", location = "/view/pages/mini/commonality/Help_content_talkdownload.jsp"),
        @Result(name = "redPackageIndex", location = "/view/pages/mini/commonality/searchAllRedPackage.jsp") })
public class FrameAction extends FrmAction {

    private String targetURL;

    public String index() {
        return "index";
    }

    public String top() {
        return "top";
    }

    public String menu() {
        return "menu";
    }

    public String portal() {
        return "portal";
    }

    public String oprating() {
        return "index";
    }

    public String sc() {
        String targetURL = (String) sessionMap.get("targetURL");
        if (targetURL != null) {
            this.targetURL = targetURL.replace(request.getContextPath(), "").substring(1);
            return "targetURL";
        }
        return "sc";
    }

    public String scLeft() {
        return "scTop";
    }

    public String scContent() {
        return "scContent";
    }

    public String scTop() {
        return "scTop";
    }

    public String sp() {
        return "sp";
    }

    public String spLeft() {
        return "spLeft";
    }

    public String spContent() {
        return "spContent";
    }

    public String spTop() {
        return "spTop";
    }

    public String getTargetURL() {
        return targetURL;
    }

    public String backtop() {
        return "backtop";
    }

    public String about() {
        request.setAttribute("param", "about");
        return "about";
    }

    public String help() {
        request.setAttribute("param", "help");
        return "help";
    }

    public String productShop() {
        return "productShop";
    }

    public String client() {
        return "client";
    }

    public String methodL() {
        request.setAttribute("param", "methodl");
        return "methodL";
    }

    // 首页
    public String toIndex() {
        request.setAttribute("param", "index");
        return "toIndex";
    }

    // 模板商店
    public String toselectTemp() {
        return "toselectTemp";
    }

    public String topHelp1() {
        request.setAttribute("help", 1);
        request.setAttribute("param", "help");
        return "help1";

    }

    public String topHelp2() {
        request.setAttribute("help", 2);
        request.setAttribute("param", "help");
        return "help2";

    }

    public String topHelp3() {
        request.setAttribute("help", 3);
        request.setAttribute("param", "help");
        return "help3";

    }

    public String topHelp4() {
        request.setAttribute("help", 4);
        request.setAttribute("param", "help");
        return "help4";

    }

    public String topHelp5() {
        request.setAttribute("help", 5);
        request.setAttribute("param", "help");
        return "help5";

    }

    public String redPackageIndex() {
        String fileName = "domain.properties";
        String redPackageListPath = ResouceUtil.getProperty(fileName, "redPackageListPath");// 读取红包系统的路径
        request.setAttribute("menuNum", 8);
        request.setAttribute("userId", getFrmUser().etipUserID);// 获取用户id
        request.setAttribute("path", redPackageListPath);
        return "redPackageIndex";
    }
}
