package com.mini.back.accountManager.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.common.util.ReadWriteFile;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.accountManager.facade.AccountManagerFacade;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;

/**
 * 
 * 后台计费管理action层
 * 
 * @author 左香勇
 * @see
 * @since vmaque2.0
 */
@Results(value = { 
        @Result(name = "searchAllAccount", location = "view/pages/mini/back/AccountManager/showAllAccount.jsp") 
})
public class AccountManagerAction extends FrmAction {

    @Resource(name = "accountManagerFacade")
    private AccountManagerFacade accountManagerFacade;

    /**
     * 分页参数对象
     */
    private PageRoll pageRoll = new PageRoll();

    /**
     * 
     * 跳转到后台计费管理页面并查询说所有分页数据
     * 
     * @author 左香勇 2014-9-25
     * @update
     * @return String 跳转到指定页面
     * @since vmaque2.0
     */
    public String searchAllAccount() {
        
        String stateStr = request.getParameter("state");
        int state = 0;
        if(stateStr == null || "".equals(stateStr)){
            state = 2;
        } else {
            state = Integer.parseInt(stateStr);
        }
        
        String orderId = request.getParameter("orderId");
        String proportion = ReadWriteFile.readTxtFile(ServletActionContext.getServletContext().getRealPath("/configure") + "/yield.txt");
        
        //修改数据
        if(orderId != null && !"".equals(orderId)){
            ConSumerOrderData conSumerOrderData = new ConSumerOrderData(); 
            
            conSumerOrderData.setTransferPeople(getFrmUser().getUsername());
            conSumerOrderData.setTransferTime(new Date());
            conSumerOrderData.setTransferPrice(Double.parseDouble(proportion));
            conSumerOrderData.setId(orderId);
            conSumerOrderData.setState(state);
            
            accountManagerFacade.updateConsumerOrder(conSumerOrderData);
        }
        
        List<ConsumerOrderGoodsinfoData> accountList = accountManagerFacade.getAccountList(pageRoll, state);
        
        request.setAttribute("accountList", accountList);
        request.setAttribute("state", state);
        request.setAttribute("proportion", proportion);
        request.setAttribute("date",new Date().getTime());
        request.setAttribute("allPrice", accountManagerFacade.getSumAccount());        
        
        return "searchAllAccount";
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public void changeYieldContect() {
        String num = request.getParameter("num");// 手续费比例
        String dpath = ServletActionContext.getServletContext().getRealPath("/configure").replace("\\", "/");// 将路径 \\,改成 / 方式
        try {
            File file = new File(dpath + "/yield.txt");// 获取带盘符的标准文件路径
            if (file.isFile()) {
                file.delete();// 删除该文件
            }
            ReadWriteFile.creatTxtFile(dpath + "/yield.txt");// 创建.txt文件
            ReadWriteFile.writeTxtFile(num, dpath + "/yield.txt");// 写入txt
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
