package com.mini.front.account.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.ResultPath;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.account.data.AccountNumberData;
import com.mini.front.account.facade.AccountNumberFacade;

/**
 * 
 * 收款账号操作action层<br> 
 *
 * @author 左香勇
 * 
 */
@ResultPath("/")
public class AccountNumberAction extends FrmAction {
    
    @Resource(name="accountNumberFacade")
    private AccountNumberFacade accountNumberFacade;
    
    private AccountNumberData accountNumberData = new AccountNumberData();
    
    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @see   AccountNumberFacade#addAccountNumberData()
     * @since vmaque1.9
     */
    public void addAccountNumberData() {
        accountNumberData.setUserId(getFrmUser().etipUserID);
        accountNumberData= accountNumberFacade.addAccountNumberData(accountNumberData);
        if(accountNumberData!=null){
        JSONObject reJson = JSONObject.fromObject(accountNumberData);
            json = reJson.toString();
        }else{
            json="1";
        }
    }
    
    /**
     * 
     * 根据收款账号id查询收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param id     收款账号id
     * @return AccountNumberData
     * @see   AccountNumberFacade#queryAccountNumberDataByid(id)
     * @since vmaque1.9
     */
    public void queryAccountNumberDataByid() {
        String id=request.getParameter("id");
        accountNumberData = accountNumberFacade.queryAccountNumberDataByid(id);
        JSONObject reJson = JSONObject.fromObject(accountNumberData);
        json = reJson.toString();
    }
    
    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @see   AccountNumberFacade#deleteAccountNumberData()
     * @since vmaque1.9
     */
    public void deleteAccountNumberData() {
        accountNumberFacade.deleteAccountNumberData(accountNumberData);
    }
    
    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @see   AccountNumberFacade#editAccountNumberData()
     * @since vmaque1.9
     */
    public void editAccountNumberData() {
        accountNumberData.setUserId(getFrmUser().etipUserID);
       accountNumberData= accountNumberFacade.editAccountNumberData(accountNumberData);
       if(accountNumberData!=null){
            JSONObject reJson = JSONObject.fromObject(accountNumberData);
            json = reJson.toString();
       }else{
           json="1";
       }
    }

    public AccountNumberData getAccountNumberData() {
        return accountNumberData;
    }

    public void setAccountNumberData(AccountNumberData accountNumberData) {
        this.accountNumberData = accountNumberData;
    }
    
}
