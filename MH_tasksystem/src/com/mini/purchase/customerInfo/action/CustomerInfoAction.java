package com.mini.purchase.customerInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.customerInfo.facade.CustomerInfoFacade;
/**
 * 
 * 消费者信息<br> 
 * 〈功能详细描述〉
 *
 * @author 冯鑫
 * @see [相关类/方法]
 * @since vmaque2.0
 */
public class CustomerInfoAction extends FrmAction {
    
    private ConSumerUserData conSumerUserData;
    
    private List<ConSumerUserData> list_conSumerUser = new ArrayList<ConSumerUserData>();
    
    @Resource(name = "customerInfoFacade")
    private CustomerInfoFacade customerInfoFacade;

    
    
    
    
    
    
    public ConSumerUserData getConSumerUserData() {
        return conSumerUserData;
    }

    public void setConSumerUserData(ConSumerUserData conSumerUserData) {
        this.conSumerUserData = conSumerUserData;
    }

    public List<ConSumerUserData> getList_conSumerUser() {
        return list_conSumerUser;
    }

    public void setList_conSumerUser(List<ConSumerUserData> list_conSumerUser) {
        this.list_conSumerUser = list_conSumerUser;
    }
}
