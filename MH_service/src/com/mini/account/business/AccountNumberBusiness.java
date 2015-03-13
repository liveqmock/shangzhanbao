package com.mini.account.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.mini.account.data.AccountNumberData;
import com.mini.account.persistence.IAccountNumberPersistence;

/**
 * 
 * 收款账号操作business层接口实现类<br>
 * 
 * @author 左香勇
 * 
 */
@Component("accountNumberBusiness")
public class AccountNumberBusiness extends FrmBusiness implements IAccountNumberBusiness {

    @Resource(name = "accountNumberPersistence")
    private IAccountNumberPersistence accountNumberPersistence;

    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br>
     *         2015年1月4日
     * @update
     * @param accountNumberData 收款账号实体信息
     * @see AccountNumberBusiness#addAccountNumberData(AccountNumberData)
     * @since vmaque1.9
     */
    public void addAccountNumberData(AccountNumberData accountNumberData) {
        accountNumberPersistence.addAccountNumberData(accountNumberData);
    }

    /**
     * 
     * 根据收款账号id查询收款账号信息<br>
     * 
     * @author 左香勇 <br>
     *         2015年1月4日
     * @update
     * @param id 收款账号id
     * @return AccountNumberData
     * @see AccountNumberBusiness#queryAccountNumberDataByid(id)
     * @since vmaque1.9
     */
    public AccountNumberData queryAccountNumberDataByid(String id) {
        return accountNumberPersistence.queryAccountNumberDataByid(id);
    }

    /**
     * 
     * 根据用户id查询收款账号信息<br>
     * 
     * @author 左香勇 <br>
     *         2015年1月4日
     * @update
     * @param userId 用户id
     * @return List<AccountNumberData>
     * @see AccountNumberBusiness#queryAccountNumberDataByuserId(userId)
     * @since vmaque1.9
     */
    public List<AccountNumberData> queryAccountNumberDataByuserId(String userId) {
        return accountNumberPersistence.queryAccountNumberDataByuserId(userId);
    }

    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br>
     *         2015年1月4日
     * @update
     * @param accountNumberData 收款账号实体信息
     * @see AccountNumberBusiness#deleteAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void deleteAccountNumberData(AccountNumberData accountNumberData) {
        accountNumberPersistence.deleteAccountNumberData(accountNumberData);
    }

    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br>
     *         2015年1月4日
     * @update
     * @param accountNumberData 收款账号信息实体
     * @see AccountNumberBusiness#editAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void editAccountNumberData(AccountNumberData accountNumberData) {
        accountNumberPersistence.editAccountNumberData(accountNumberData);
    }
    
    /**
     * 
     *根据用户id  和支付类型查询当前支付类型是否存在<br>
     * 
     * @author 侯杨 <br> 
     *         2015年1月7日
     * @update 
     * @param  accountNumberData 支付实体
     * @return  accountNumberData 支付实体
     * @see   AccountNumberBusiness#getAccountNumberDataBytype(AccountNumberData)
     * @since vmaque2.0
     */
    public AccountNumberData getAccountNumberDataBytype(AccountNumberData accountNumberData){
        return accountNumberPersistence.getAccountNumberDataBytype(accountNumberData);
    }
}
