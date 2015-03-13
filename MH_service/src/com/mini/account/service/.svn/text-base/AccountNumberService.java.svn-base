package com.mini.account.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmService;
import com.mini.account.business.IAccountNumberBusiness;
import com.mini.account.data.AccountNumberData;

/**
 * 
 * 收款账号操作service层接口实现类<br> 
 *
 * @author 左香勇
 * 
 */
@Component("accountNumberService")
public class AccountNumberService extends FrmService implements IAccountNumberService {

    @Resource(name="accountNumberBusiness")
    private IAccountNumberBusiness accountNumberBusiness;
    
    /**
     * 
     * 添加收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 侯杨
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberService#addAccountNumberData(AccountNumberData)
     * @since vmaque1.9
     */
    public AccountNumberData addAccountNumberData(AccountNumberData accountNumberData) {
        AccountNumberData data=accountNumberBusiness.getAccountNumberDataBytype(accountNumberData);
        if(data!=null){
            return null;
        }else{
            accountNumberData.setCreateTime(new Date());
            accountNumberData.setIsdelete(1);
            accountNumberBusiness.addAccountNumberData(accountNumberData);
            return accountNumberData;
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
     * @see   AccountNumberService#queryAccountNumberDataByid(id)
     * @since vmaque1.9
     */
    public AccountNumberData queryAccountNumberDataByid(String id) {
        return accountNumberBusiness.queryAccountNumberDataByid(id);
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
     * @see   AccountNumberService#queryAccountNumberDataByuserId(userId)
     * @since vmaque1.9
     */
    public List<AccountNumberData> queryAccountNumberDataByuserId(String userId) {
        return accountNumberBusiness.queryAccountNumberDataByuserId(userId);
    }
    
    /**
     * 删除收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData    收款账号实体信息
     * @see   AccountNumberService#deleteAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public void deleteAccountNumberData(AccountNumberData accountNumberData) {
        AccountNumberData data = queryAccountNumberDataByid(accountNumberData.getId());
        data.setIsdelete(0);
        data.setEditTime(new Date());
        accountNumberBusiness.editAccountNumberData(data);
    }
    
    /**
     * 
     * 修改收款账号信息<br>
     * 
     * @author 左香勇 <br> 
     *         2015年1月4日
     * @update 
     * @param accountNumberData     收款账号信息实体
     * @see   AccountNumberService#editAccountNumberData(accountNumberData)
     * @since vmaque1.9
     */
    public AccountNumberData editAccountNumberData(AccountNumberData accountNumberData) {
        AccountNumberData data1=accountNumberBusiness.getAccountNumberDataBytype(accountNumberData);
        AccountNumberData data = queryAccountNumberDataByid(accountNumberData.getId());
        if(accountNumberData.getAccountType().equals(data.getAccountType())){
            //如果修改当前数据 支付方式没有改变  不用判断
            if(accountNumberData.getAccountType()!=null) {
                data.setAccountType(accountNumberData.getAccountType());
            }
            if(accountNumberData.getReceivableAccount() != null && !"".equals(accountNumberData.getReceivableAccount())) {
                data.setReceivableAccount(accountNumberData.getReceivableAccount());
            }
            data.setEditTime(new Date());
            accountNumberBusiness.editAccountNumberData(data);
            return data;
        }else{
            if(data1!=null){
                return null;
            }else{
            
            if(accountNumberData.getAccountType()!=null) {
                data.setAccountType(accountNumberData.getAccountType());
            }
            if(accountNumberData.getReceivableAccount() != null && !"".equals(accountNumberData.getReceivableAccount())) {
                data.setReceivableAccount(accountNumberData.getReceivableAccount());
            }
            data.setEditTime(new Date());
            accountNumberBusiness.editAccountNumberData(data);
            return data;
            }
        }
    }
}