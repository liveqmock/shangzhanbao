package com.mini.util.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;

@Results(value = { @Result(name = "oprating", location = "frame/key/oprating", type = "redirect"),
        @Result(name = "sp", location = "frame/key/sp", type = "redirect"),
        @Result(name = "sc", location = "frame/key/sc", type = "redirect") })
public class CheckUserAction extends FrmAction {

    public String index() {
        FrmUser frmUser = getFrmUser();
        // 后台管理员用户
        if (frmUser.roleType == 1) {
            return "oprating";
        }
        // 前台客户用户
        if (frmUser.roleType == 2) {
            return "sp";
        }

        if (frmUser.roleType == 3) {
            return "sc";
        }
        return "toLogin";
    }
}
