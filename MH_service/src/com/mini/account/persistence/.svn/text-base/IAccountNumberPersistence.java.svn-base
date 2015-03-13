package com.mini.account.persistence;

import java.util.List;

import com.mini.account.data.AccountNumberData;

/**
 * 
 * 收款账号操作persistence层接口<br> 
 *
 * @author 左香勇
 * 
 */
public interface IAccountNumberPersistence {

    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   IAccountNumberPersistence#addAccountNumberData(AccountNumberData)
     * @since vmaque1.9
     */
    public void addAccountNumberData(AccountNumberData accountNumberData);
    
    /**
     * 
     * 根据收款账号id查询收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param id     收款账号id
     * @return AccountNumberData
     * @see   IAccountNumberPersistence#queryAccountNumberDataByid(id)
     * @since vmaque1.9
     */
    public AccountNumberData queryAccountNumberDataByid(String id);
    
    /**
     * 
     * 根据用户id查询收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param userId     用户id
     * @return List<AccountNumberData> 
     * @see   IAccountNumberPersistence#queryAccountNumberDataByuserId(userId)
     * @since vmaque1.9
     */
    public List<AccountNumberData> queryAccountNumberDataByuserId(String userId);
    
    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   IAccountNumberPersistence#deleteAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void deleteAccountNumberData(AccountNumberData accountNumberData);
    
    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData     收款账号信息实体
     * @see   IAccountNumberPersistence#editAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void editAccountNumberData(AccountNumberData accountNumberData);
    /**
     * 
     *根据用户id  和支付类型查询当前支付类型是否存在<br>
     * 
     * @author 侯杨 <br> 
     *         2015年1月7日
     * @update 
     * @param  accountNumberData 支付实体
     * @return  accountNumberData 支付实体
     * @see   AccountNumberPersistence#getAccountNumberDataBytype(AccountNumberData)
     * @since vmaque2.0
     */
    public AccountNumberData getAccountNumberDataBytype(AccountNumberData accountNumberData);
        
    
    
}
