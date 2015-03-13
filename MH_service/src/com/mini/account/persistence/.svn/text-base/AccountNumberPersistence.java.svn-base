package com.mini.account.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.account.data.AccountNumberData;

/**
 * 
 * 收款账号操作persistence层接口实现类<br>
 * 
 * @author 左香勇
 * 
 */
@SuppressWarnings("unchecked")
@Component("accountNumberPersistence")
public class AccountNumberPersistence extends BasePersistence<AccountNumberData> implements IAccountNumberPersistence {

    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberPersistence#addAccountNumberData(AccountNumberData)
     * @since vmaque1.9
     */
    public void addAccountNumberData(AccountNumberData accountNumberData) {
        this.add(accountNumberData);
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
     * @see   AccountNumberPersistence#queryAccountNumberDataByid(id)
     * @since vmaque1.9
     */
    public AccountNumberData queryAccountNumberDataByid(String id) {
        return this.retrieve(id);
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
     * @see   AccountNumberPersistence#queryAccountNumberDataByuserId(userId)
     * @since vmaque1.9
     */
    public List<AccountNumberData> queryAccountNumberDataByuserId(String userId) {
        
        String hql ="from AccountNumberData where userId=? and isdelete=1";
        
        List<Object> params = new ArrayList<Object>();
        
        params.add(userId);
        
        return this.search(hql, params);
        
    }
    
    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberPersistence#deleteAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void deleteAccountNumberData(AccountNumberData accountNumberData) {
        this.delete(accountNumberData);
    }
    
    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData     收款账号信息实体
     * @see   AccountNumberPersistence#editAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void editAccountNumberData(AccountNumberData accountNumberData) {
        this.update(accountNumberData);
    }
    /**
     * 
     *根据用户id  和支付类型查询当前支付类型是否存在<br>
     * 
     * @author 侯杨 <br> 
     *		   2015年1月7日
     * @update 
     * @param  accountNumberData 支付实体
     * @return  accountNumberData 支付实体
     * @see   AccountNumberPersistence#getAccountNumberDataBytype(AccountNumberData)
     * @since vmaque2.0
     */
    public AccountNumberData getAccountNumberDataBytype(AccountNumberData accountNumberData){
        String hql="from AccountNumberData ac where ac.accountType = ? and ac.userId = ? and ac.isdelete=1";
        List<AccountNumberData> datas=search(hql, new Object[]{accountNumberData.getAccountType(),accountNumberData.getUserId()});
        if(datas.size()>0){
            return datas.get(0);
        }else{
            return null;
        }
    }
    
}
