package com.mini.front.account.facade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmFacade;
import com.mini.account.data.AccountNumberData;
import com.mini.account.service.IAccountNumberService;

/**
 * 
 * 收款账号操作facade层<br> 
 *
 * @author 左香勇
 * 
 */
@Component("accountNumberFacade")
public class AccountNumberFacade extends FrmFacade {

    @Resource(name="accountNumberService")
    private IAccountNumberService accountNumberService;
    
    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 侯杨
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberFacade#addAccountNumberData(AccountNumberData)
     * @since vmaque1.9
     */
    public AccountNumberData addAccountNumberData(AccountNumberData accountNumberData) {
        return accountNumberService.addAccountNumberData(accountNumberData);
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
    public AccountNumberData queryAccountNumberDataByid(String id) {
        return accountNumberService.queryAccountNumberDataByid(id);
    }
    
    /**
     * 
     * 根据用户id查询收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param userId     用户id
     * @return List<AccountNumberData> 
     * @see   AccountNumberFacade#queryAccountNumberDataByuserId(userId)
     * @since vmaque1.9
     */
    public List<AccountNumberData> queryAccountNumberDataByuserId(String userId) {
        return accountNumberService.queryAccountNumberDataByuserId(userId);
    }
    
    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberFacade#deleteAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void deleteAccountNumberData(AccountNumberData accountNumberData) {
        accountNumberService.deleteAccountNumberData(accountNumberData);
    }
    
    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData     收款账号信息实体
     * @see   AccountNumberFacade#editAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public AccountNumberData editAccountNumberData(AccountNumberData accountNumberData) {
       return accountNumberService.editAccountNumberData(accountNumberData);
    }
    
}
