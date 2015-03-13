var contextName;
function getContexName(){
	var strFullPath=window.document.location.href;
	var strPath=window.document.location.pathname;
	var pos=strFullPath.indexOf(strPath);
	var prePath=strFullPath.substring(0,pos);
	if(parent.projectNamePath==undefined){
		contextName=prePath+'/MH_tasksystem';
	}else{
		contextName=parent.projectNamePath;
	}
}
getContexName();   
﻿ /**
	 * 为了提高速度，在系统初始化时，将datadic配置缓冲到index.jsp中，成为javascript对象。
	 * 这样在构造页面下拉框，或者将code转换为name时，可以无需调用ajax服务。
	 */
var dataCacheMap = new Map();
/**
 * 
 * 取得cache数组
 * 
 */
function getCacheToArr(cacheName){
    var map = new Map();
    var dataArr = parent.getCacheStoreByCacheName(cacheName).data.items;
    
    for(var i=0;i<dataArr.length;i++){
        map.put(parent.getCacheStoreByCacheName(cacheName).data.items[i].json[0],parent.getCacheStoreByCacheName(cacheName).data.items[i].json[1]);
    }
    var arr = mapToArr(map);
    return arr;
}
/**
 * 
 * 取得cache对应的值
 * 
 */
function getCacheValue(cacheName,value){
    var dataArr = parent.getCacheStoreByCacheName(cacheName).data.items;
    for(var i=0;i<dataArr.length;i++){
        if(dataArr[i].json[1] == value){
            return dataArr[i].json[0];
        }
    }
}


/**
 * 
 * 根据cacheName获得缓冲区存储对象，此处的问题是，数据加载方式有延时。
 * 为了解决延时加载的问题，此处需要在index.jsp加载时，默认加载datadic中的内容到页面上
 */
function getAllDataCaches(cacheNames) {
    // 调用jsp从后台缓冲到前台
    var cacheUrl = contextName+'/dataCacheStore.jsp';
    var cacheData;
    /*
	 * 以下是异步方案调用，获取代码。
	 */
    var requestConfig = {
        url : cacheUrl,
        params : {
            cacheNames: cacheNames
        },
        callback : function(options, success, response) {
            // 问题出在这里，返回值，最好是一个Map对象，而此处是一个字符串。
            try{
                // 此处需要拆分responseText
                // alert(response.responseText);
                
                cacheData = Ext.util.JSON.decode(response.responseText);
                for (var one in cacheData)  {
                    // alert(one);
                    var cacheName;
                    var cacheValues;
                    for(var key in cacheData[one]) {
                        cacheName = key;
                        cacheValues=cacheData[one][key];
                        
                    }
                    
                    var dataStore = new Ext.data.SimpleStore({
                        data : cacheValues,
                        fields : ['code', 'name']
                    });
                    
                    dataCacheMap.put(cacheName, dataStore);
                }
            }
            catch(ex){
                alert("解析data缓冲区错误:"+response.responseText);
            }
            
        }
    }
    Ext.Ajax.request(requestConfig);
    // return dataStore;
}


/**
 * 
 * 根据cacheName获得缓冲区存储对象，此处的问题是，数据加载方式有延时。
 * 为了解决延时加载的问题，此处需要在index.jsp加载时，默认加载datadic中的内容到页面上
 */
function getCacheStoreByCacheName(cacheName) {

    // 从缓冲区中获取data,然后用来构造DataStore
    var dataStore = dataCacheMap.get(cacheName);
    if (dataStore != null) {// 如果存在，那么直接返回
        return dataStore;
    }

    // 调用jsp从后台缓冲到前台
    var cacheUrl = contextName+'/dataCacheStore.jsp?cacheName=' + cacheName;
    var cacheData;
    /*
	 * 以下是异步方案调用，获取代码。
	 */
    var requestConfig = {
        url : cacheUrl,
        params : {
            cacheName : cacheName
        },
        callback : function(options, success, response) {
            // 问题出在这里，返回值，最好是一个Map对象，而此处是一个字符串。
            try{
                cacheData = Ext.util.JSON.decode(response.responseText);
                var dataStore = new Ext.data.SimpleStore({
                        data : cacheData,
                        fields : ['code', 'name']
                    });
            dataCacheMap.put(cacheName, dataStore);
            }
            catch(ex){
                alert("解析data缓冲区错误:"+response.responseText);
            }
            
        }
    }
    Ext.Ajax.request(requestConfig);
    return dataStore;
}

/**
 * 以下用于保存dbCache的缓冲区，供combobox选用。
 */
var dbCacheMap = new Map();
/**
 * 根据cacheName获得缓冲区存储对象，此处的问题是，数据加载方式有延时。
 * 为了解决延时加载的问题，此处需要在index.jsp加载时，默认加载datadic中的内容到页面上
 */
function getDBStoreByCacheName(dbCacheName) {

    // 从缓冲区中获取data,然后用来构造DataStore
    var dataStore = dbCacheMap.get(dbCacheName);
    if (dataStore != null) {// 如果存在，那么直接返回
        return dataStore;
    }
    
    // 调用jsp从后台缓冲到前台
    var cacheUrl = contextName+'/dataCacheStore.jsp?dbCacheName=' + dbCacheName;
    var cacheData;
    var requestConfig = {
        url : cacheUrl,
        params : {
            dbCacheName : dbCacheName
        },
        callback : function(options, success, response) {
            // 问题出在这里，返回值，最好是一个Map对象，而此处是一个字符串。
            try{
            cacheData = Ext.util.JSON.decode(response.responseText);
             dataStore = new Ext.data.SimpleStore({
                        data : cacheData,
                        fields : ['code', 'name']
                    });
            dbCacheMap.put(dbCacheName, dataStore);
            }catch(ex){
                alert("解析db缓冲区错误:"+response.responseText);
            }
        }
    }
    Ext.Ajax.request(requestConfig);
    return dataStore;
}

/**
 * 以下用于保存dbCache的缓冲区，供根据code取出value选用。
 */
/**
 * 根据cacheName获得缓冲区存储对象，此处的问题是，数据加载方式有延时。
 * 为了解决延时加载的问题，此处需要在index.jsp加载时，默认加载datadic中的内容到页面上
 */
function getDBMapByCacheName(dbCacheName) {

    // 从缓冲区中获取data,然后用来构造DataStore
    var dataStore = dbCacheMap.get(dbCacheName);
    if (dataStore != null) {// 如果存在，那么直接返回
        return dataStore;
    }
    // 调用jsp从后台缓冲到前台
    var cacheUrl = contextName+'/dataCacheStore.jsp?dbCacheName=' + dbCacheName;
    var conn = Ext.lib.Ajax.getConnectionObject().conn;   
    conn.open("GET", cacheUrl,false);   
    conn.send(null);   
    var cacheData = Ext.util.JSON.decode(conn.responseText);
    try{
        dataStore = new Map();
        for(var i = 0;i < cacheData.length;i++){
            dataStore.put(cacheData[i][0],cacheData[i][1]);
        }
        dbCacheMap.put(dbCacheName, dataStore);
    }catch(ex){
        alert("解析db缓冲区错误:"+response.responseText);
    }
    return dataStore;
}


/**
 * 以下用于保存数据库字典的缓冲区，供combobox选用。
 */
var dicCacheMap = new Map();
/**
 * 根据cacheName获得缓冲区存储对象，此处的问题是，数据加载方式有延时。
 * 为了解决延时加载的问题，此处需要在index.jsp加载时，默认加载datadic中的内容到页面上
 */
function getDicStoreByAttrCode(attrCode) {
    // alert("attrCode:"+attrCode);
    // 从缓冲区中获取data,然后用来构造DataStore
    var dataStore = dicCacheMap.get(attrCode);
    if (dataStore != null) {// 如果存在，那么直接返回
        return dataStore;
    }
    var cacheData;
    /*
	 * 以下是异步方案调用，获取代码。
	 */
/*
 * var requestConfig = { url : cacheUrl, params : { attrCode : attrCode },
 * 
 * callback : function(options, success, response) { //
 * 问题出在这里，返回值，最好是一个Map对象，而此处是一个字符串。 try{ cacheData =
 * Ext.util.JSON.decode(response.responseText); var dataStore = new
 * Ext.data.SimpleStore({ data : cacheData, fields : ['code', 'name'] });
 * dicCacheMap.put(attrCode, dataStore); }catch(ex){
 * alert("解析dic缓冲区错误:"+response.responseText); } } }
 * Ext.Ajax.request(requestConfig);
 */
    
    /**
	 * txc 同步调用
	 */
    var cacheUrl = contextName+'/dataCacheStore.jsp?attrCode=' + attrCode;
    var conn = Ext.lib.Ajax.getConnectionObject().conn;   
    conn.open("GET", cacheUrl,false);   
    conn.send(null);   
    var cacheData = Ext.util.JSON.decode(conn.responseText);
    var newDataStore = new Ext.data.SimpleStore({
                        data : cacheData,
                        fields : ['code', 'name']
                    });
    dicCacheMap.put(attrCode, newDataStore);
    return newDataStore;
}

/**
 * 创建字典缓冲区，所有引用到数据库字典都将在这里使用 以下字典用于构造树形结构选择。
 */
var dicMap = new Map();
/**
 * 从字典中获取对象
 * 
 * @param dicCode
 *            字典代码
 */
function getDicByCode(dicCode) {
    // 从缓冲区中获取data,然后用来构造DataStore
    var dic = dicMap.get(dicCode);
    // 如果存在，那么直接返回
    if (dic != null) {
        return dic;
    }
    // 调用jsp从后台缓冲到前台
    var dicUrl = contextName+'/dataCacheStore.jsp?dicCode='+ dicCode;
    var dicData;
    
    /*
	 * 以下是异步方案调用，获取代码。
	 */
    var requestConfig = {
        url : dicUrl,
        params : {
            dicCode : dicCode
        },
        callback : function(options, success, response) {
            // 问题出在这里，返回值，最好是一个Map对象，而此处是一个字符串。
            try{
            dicData = Ext.util.JSON.decode(response.responseText);
            dicMap.put(dicCode, dicData);
            }catch(ex){
                alert("解析dictree缓冲区错误:"+response.responseText);
            }
        }
    }
    Ext.Ajax.request(requestConfig);
    return dicData;
}


// txc add showDicMap
var showDicMap = new Map();
function getShowDicStoreByDicType(showDic){
    var dataStore = showDicMap.get(showDic);
    if (dataStore != null) {// 如果存在，那么直接返回
        return dataStore;
    }

    var cacheData;

    var cacheUrl = contextName+'/dataCacheStore.jsp?showDic=' + showDic;
    var conn = Ext.lib.Ajax.getConnectionObject().conn;   
    conn.open("GET", cacheUrl,false);   
    conn.send(null);   
    
    var cacheData = Ext.util.JSON.decode(conn.responseText);
    var newDataStore = new Ext.data.SimpleStore({
                        data : cacheData,
                        fields : ['code', 'name']
                    });
    showDicMap.put(showDic, newDataStore);
    return newDataStore;
}
// txc add showDicMap




/**
 * 以下定义ETip平台只能够自定义的Ext VType，目的是在输入校验时在所有页面中共享。
 */
function makeVType(){

Ext.apply(Ext.form.VTypes, {
    code: function(val, field) {     // 返回true，则验证通过，否则验证失败
        alert("validate code");
         if(field.code){
              if(val.length<6 || val.length>16)
                  return false;
              else 
                 return true;
          }
     },
     codeText: '字段长度应该在0到16位之间'
});

/*
 * Ext.apply(Ext.form.VTypes, { name: function(val, field) {
 * //返回true，则验证通过，否则验证失败 if(field.code){ if(val.length<0 || val.length>32)
 * return false; else return true; } }, nameText: '字段长度应该在0到32位之间' });
 * Ext.apply(Ext.form.VTypes, { address: function(val, field) {
 * //返回true，则验证通过，否则验证失败 if(field.code){ if(val.length<0 || val.length>128)
 * return false; else return true; } }, addressText: '字段长度应该在0到128位之间' });
 * 
 * Ext.apply(Ext.form.VTypes, { memo: function(val, field) {
 * //返回true，则验证通过，否则验证失败 if(field.code){ if(val.length<0 || val.length>255)
 * return false; else return true; } }, memoText: '字段长度应该在0到255位之间' });
 * Ext.apply(Ext.form.VTypes, { text: function(val, field) {
 * //返回true，则验证通过，否则验证失败 if(field.code){ if(val.length<0 || val.length>512)
 * return false; else return true; } }, textText: '字段长度应该在0到512位之间' });
 */
}
makeVType();
/**
 * 正则表达式定义，也是用于输入校验。
 */
var  regexMap = new Map();
function makeRegexMap(){
var Account= {name:'/^.{0,32}$/' ,text:'账号不合法,要求(允许最长50字节，允许字母数字下划线)'};
regexMap.put('Account',Account);
var Password= {name:'/^(\w){6,20}$/' ,text:'密码非法：只能输入6-20个字母、数字、下划线'};
regexMap.put('Password',Password);
var Number= {name:'/^[0-9]{1,20}$/' ,text:'应该全由数字组成'};
regexMap.put('Number',Number);
var ZeroPInt= {name:'/^\d+$/' ,text:'应该是大于等于0的整数'};　 
regexMap.put('ZeroPInt',ZeroPInt);
var PInt= {name:'/^[0-9]*[1-9][0-9]*$/' ,text:'应该是正整数'};
regexMap.put('PInt',PInt);
var ZeroNInt= {name:'/^((-\d+)|(0+))$/' ,text:'应该是小于等于0的整数）'};
regexMap.put('ZeroNInt',ZeroNInt);
var Int= {name:'/^-?\d+$/' ,text:'应该是整数'};
regexMap.put('Int',Int);
var ZeroPFloat= {name:'/^\d+(\.\d+)?$/' ,text:'应该是非负浮点数'};
regexMap.put('ZeroPFloat',ZeroPFloat);
var PFloat= {name:'/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/' ,text:'应该是正浮点数'};
regexMap.put('PFloat',PFloat);
var ZeroNFloat= {name:'/^((-\d+(\.\d+)?)|(0+(\.0+)?))$/' ,text:'应该是非正浮点数'};
regexMap.put('ZeroNFloat',ZeroNFloat);
var NFloat= {name:'/^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/' ,text:'应该是负浮点数'};
regexMap.put('NFloat',NFloat);
var Float= {name:'/^(-?\d+)(\.\d+)?$/' ,text:'应该是浮点数'}; 
regexMap.put('Float',Float);
var AZaz= {name:'/^[A-Za-z]+$/' ,text:'应该是由26个英文字母组成的字符串'}; 
regexMap.put('AZaz',AZaz);
var AZ= {name:'/^[A-Z]+$/' ,text:'应该由26个英文字母的大写组成的字符串'};
regexMap.put('AZ',AZ);
var az= {name:'/^[a-z]+$/' ,text:'应该由26个英文字母的小写组成的字符串'};
regexMap.put('az',az);
var AZaz09= {name:'/^[A-Za-z0-9]+$/' ,text:'应该由数字和26个英文字母组成的字符串'};
regexMap.put('AZaz09',AZaz09);
var Azaz09_= {name:'/^\w+$/' ,text:'应该由数字、26个英文字母或者下划线组成的字符串'};
regexMap.put('Azaz09_',Azaz09_);
var Chinese= {name:'/[\u4e00-\u9fa5]/' ,text:'应该是中文'};
regexMap.put('Chinese',Chinese);
var DoubleByte= {name:'/[^\x00-\xff]/' ,text:'应该是双字节字符'};
regexMap.put('DoubleByte',DoubleByte);
var Email= {name:'/^(.+)@(.+).(.+)$/' ,text:'email格式验证错误'};



regexMap.put('Email',Email);
var URL= {name:'/^[a-zA-z]+:(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$/' ,text:'应该是:http://xxx.xxx.xx格式'};
regexMap.put('URL',URL);
var yyyMMdd= {name:'/^(d{2}|d{4})-((0([1-9]{1}))|(1[1|2]))-(([0-2]([1-  9]{1}))|(3[0|1]))$/' ,text:'应该是年-月-日格式'};
regexMap.put('yyyMMdd',yyyMMdd);
var MMddyyyy= {name:'/^((0([1-9]{1}))|(1[1|2]))/(([0-2]([1-9]{1}))|(3[0|1]))/(d{2}|d{4})$/' ,text:'应该是月-日-年格式'};
regexMap.put('MMddyyyy',MMddyyyy);
var Phone= {name:'/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/' ,text:'电话/传真号码：可以+开头，除数字外，可含有-'};
regexMap.put('Phone',Phone);
var IP= {name:'/^(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5])$/' ,text:'IP地址不正确'};
regexMap.put('IP',IP);
var ChinesePhone= {name:'/(0\d{2}-|0\d{3}-)?(\d{8}|\d{7})?/' ,text:'电话号码不正确'};
regexMap.put('ChinesePhone',ChinesePhone);
var QQ= {name:'/^[1-9]*[1-9][0-9]*$/' ,text:'不正确的腾讯QQ号'};
regexMap.put('QQ',QQ);
var PersonID= {name:'/^(\d{18,18}|\d{15,15}|\d{17,17}x)$/',text:'不正确身份证格式'};
regexMap.put('PersonID',PersonID);
// 此处有问题，总是验证不通过
var Mobile= {name:'/^[0-9]{11}$/' ,text:'手机号码必须是11位数字'};
regexMap.put('Mobile',Mobile);
// 此处有问题，总是验证不通过
var SoreNumber= {name:'/^[-]{0,1}[0-9]{0,6}$/' ,text:'积分数只能输入数字,长度不能超过6位'};
regexMap.put('SoreNumber',SoreNumber);
// var Mobile= {name:'/^[0-9]{0,19}$/' ,text:'手机号码必须是20位之内的数字'};
// @"^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$";
// @”^[1]+[3,5]+\d{9}”);
// 号段判断长度
var CodeNumber= {name:'/^[0-9]{10}$/' ,text:'号段长度为10位数字'};
regexMap.put('CodeNumber',CodeNumber);
// 注册资本
var Fund= {name:'/^[0-9]{0,8}$/' ,text:'注册资本长度不能大于8位数字'};
regexMap.put('Fund',Fund);
// 银行卡号
var PayCardNO= {name:'/^[0-9]{1,64}$/' ,text:'银行卡号长度不能大64位数字'};
regexMap.put('PayCardNO',PayCardNO);
// 支付金额
var PayMoney= {name:'/^(?:[1-9][0-9]*|0)(?:\.[0-9]+)?$/' ,text:'只能输入整数或带小数点的数'};
regexMap.put('PayMoney',PayMoney);
// 号段判断长度
var StartNumber= {name:'/^[0-9]{0,10}$/' ,text:'号段长度为0~10位数字'};
regexMap.put('StartNumber',StartNumber);

var CheckPhone={name:'/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/',text:'电话号码不正确(格式:xxxx-xxxxxxx或xxxxxxxx)'};
regexMap.put('CheckPhone',CheckPhone);


var Postcode= {name:'/^[a-zA-Z0-9 ]{3,12}$/' ,text:'校验邮政编码错误'};
regexMap.put('Postcode',Postcode);
}





makeRegexMap();




/**
 * 根据配置文件构造页面对象，使得应用程序所有控件的显示特征、输入验证、逻辑验证保持一致，而且也可以 简化页面应用程序的开发。
 * 以下定义对象基本配置，这些配置用于生成控件，包括用于解决输入校验和cache配置项的问题
 * 此处无需配置cache,而是ObjectCacheMap中取值，这样保持配置的一致性。
 */
var objectMap = new Map();
/**
 * 会员资源对象（系统会员） 会员账号
 */

function makeEtipAccountData(){
var EtipAccountData = new  Map();
objectMap.put('EtipAccount',EtipAccountData);
EtipAccountData.put('id',{widget:'textfield',fieldLabel:'账号唯一ID',allowBlank:false,regex:'',value:''});
EtipAccountData.put('etipUserId',{widget:'textfield',fieldLabel:'账号ID',allowBlank:false,regex:'',value:''});

EtipAccountData.put('accountType',{widget:'combo',fieldLabel:'账号类型',allowBlank:false,regex:'',cache:'AccountType',value:'0'});

EtipAccountData.put('account',{widget:'validatetrigger',fieldLabel:'账号',validateField:'EtipAccount.account',allowBlank:false,regex:''});
EtipAccountData.put('loginCard',{widget:'textfield',fieldLabel:'卡号',allowBlank:true,regex:'',value:''});
EtipAccountData.put('loginName',{widget:'textfield',fieldLabel:'登录账号',allowBlank:true,regex:''});
EtipAccountData.put('mobile',{widget:'textfield',fieldLabel:'手机',regex:'',value:''});
EtipAccountData.put('email',{widget:'textfield',fieldLabel:'邮箱',allowBlank:true,regex:'Email',value:''});

EtipAccountData.put('loginAccount',{widget:'validatetrigger',validateField:'EtipAccount.account',fieldLabel:'登录用户名',allowBlank:true,regex:'Account'});
EtipAccountData.put('loginAccountMobile',{widget:'validatetrigger',validateField:'EtipAccount.account',fieldLabel:'手机',allowBlank:true,regex:'Mobile'});
EtipAccountData.put('loginAccountEmail',{widget:'validatetrigger',allowBlank:true,validateField:'EtipAccount.account',fieldLabel:'邮箱',regex:'Email'});
EtipAccountData.put('cardNumber',{widget:'textfield',fieldLabel:'纵横卡号',allowBlank:true,regex:''});
EtipAccountData.put('oldCardNumber',{widget:'textfield',fieldLabel:'老纵横卡号',allowBlank:true,regex:''});

}
makeEtipAccountData();
/**
 * 会员资源对象（组织基础信息） 组织会员信息
 */

function makeGroupBaseData(){
var GroupBaseData = new  Map();
objectMap.put('GroupBase',GroupBaseData);
GroupBaseData.put('id',{widget:'textfield',fieldLabel:'系统唯一ID',allowBlank:false,regex:'',value:''});
GroupBaseData.put('chineseName',{widget:'validatetrigger',fieldLabel:'组织名称',allowBlank:false,validateField:'GroupBase.chineseName',regex:'',value:''});
GroupBaseData.put('englishName',{widget:'textfield',fieldLabel:'英文名称',regex:'',value:''});
GroupBaseData.put('status',{widget:'combo',fieldLabel:'状态',cache:'EtipUserStatus',value:'0'});
GroupBaseData.put('creator',{widget:'textfield',fieldLabel:'记录创建人员',regex:'',value:''});
GroupBaseData.put('createDate',{widget:'datefield',fieldLabel:'记录创建日期',allowBlank:false,regex:'',value:''});
GroupBaseData.put('lastUptUser',{widget:'textfield',fieldLabel:'最后更新人员',allowBlank:false,regex:'',value:''});
GroupBaseData.put('lastUptDate',{widget:'datefield',fieldLabel:'最后更新日期',allowBlank:false,regex:'',value:''});
GroupBaseData.put('bizAddress',{widget:'textfield',fieldLabel:'经营地址',regex:'',value:''});
// 以下配置指向数据字典，通过数据字典形成下拉框，而不是通过cache
// txc
GroupBaseData.put('country',{widget:'combo',fieldLabel:'国家',dic:'Country'});
GroupBaseData.put('province',{widget:'combo',fieldLabel:'省'});
GroupBaseData.put('city',{widget:'combo',fieldLabel:'市'});

GroupBaseData.put('brandCode',{widget:'textfield',fieldLabel:'品牌',regex:'',value:''});
GroupBaseData.put('brandName',{widget:'textfield',fieldLabel:'品牌',regex:'',value:''});
GroupBaseData.put('phone',{widget:'textfield',fieldLabel:'联系电话',regex:'CheckPhone',value:''});
// 无正则表达式校验
GroupBaseData.put('phone22',{widget:'textfield',fieldLabel:'联系电话',value:''});
GroupBaseData.put('email',{widget:'textfield',fieldLabel:'联系邮件',regex:'Email',value:''});
GroupBaseData.put('scale',{widget:'numberfield',fieldLabel:'组织人员规模(人)',regex:'',value:''});
GroupBaseData.put('industry',{widget:'combo',fieldLabel:'行业',cache:'Industry',value:'0'});
GroupBaseData.put('vtype',{widget:'combo',fieldLabel:'组织性质',cache:'GroupType',value:'0'});
GroupBaseData.put('contactWays',{widget:'textfield',fieldLabel:'联系方式',allowBlank:false,regex:'',value:''});
GroupBaseData.put('certificates',{widget:'textfield',fieldLabel:'证件',allowBlank:false,regex:'',value:''});
GroupBaseData.put('users',{widget:'textfield',fieldLabel:'用户',allowBlank:false,regex:'',value:''});
GroupBaseData.put('subGroups',{widget:'textfield',fieldLabel:'子机构',allowBlank:false,regex:'',value:''});
GroupBaseData.put('user',{widget:'textfield',fieldLabel:'关联用户账号',allowBlank:false,regex:'',value:''});
GroupBaseData.put('userExt',{widget:'textfield',fieldLabel:'扩展信息',allowBlank:false,regex:'',value:''});
GroupBaseData.put('roles',{widget:'textfield',fieldLabel:'角色',allowBlank:false,regex:'',value:''});
GroupBaseData.put('pictures',{widget:'textfield',fieldLabel:'图片',allowBlank:false,regex:'',value:''});
GroupBaseData.put('memo',{widget:'textarea',fieldLabel:'备注',allowBlank:false,regex:'',value:''});
}
makeGroupBaseData();

/**
 * 会员资源对象（组织基础信息） 组织信息扩展
 */

function makeGroupBaseExtExtData(){
var GroupBaseExtExtData = new  Map();
objectMap.put('GroupBaseExtExt',GroupBaseExtExtData);
GroupBaseExtExtData.put('id',{widget:'textfield',fieldLabel:'系统唯一ID',allowBlank:false,regex:'',value:''});
GroupBaseExtExtData.put('groupId',{widget:'textfield',fieldLabel:'组织机构ID',allowBlank:false,regex:'',value:''});
GroupBaseExtExtData.put('legalPerson',{widget:'textfield',fieldLabel:'组织法人',regex:'',value:''});
GroupBaseExtExtData.put('fund',{widget:'textfield',fieldLabel:'注册资本(万元)',regex:'Fund',value:''});
GroupBaseExtExtData.put('fundDate',{widget:'datefield',fieldLabel:'成立时间',allowBlank:false,regex:'',value:''});
GroupBaseExtExtData.put('fundAddress',{widget:'textfield',fieldLabel:'注册地址',regex:'',value:''});
GroupBaseExtExtData.put('bizCycle',{widget:'combo',fieldLabel:'所属城市商圈',value:''});
GroupBaseExtExtData.put('economyCycle',{widget:'combo',fieldLabel:'所属经济圈',cache:"EconomyCycle",regex:'',value:'0'});
GroupBaseExtExtData.put('webAddress',{widget:'textfield',fieldLabel:'网址',regex:'',value:''});
GroupBaseExtExtData.put('bizAddress',{widget:'textfield',fieldLabel:'经营地址',regex:'',value:''});
GroupBaseExtExtData.put('bizScope',{widget:'textfield',fieldLabel:'经营范围',regex:'',value:''});
// GroupBaseExtExtData.put('country',{widget:'textfield',fieldLabel:'国家',allowBlank:false,regex:'',value:''});
// GroupBaseExtExtData.put('province',{widget:'textfield',fieldLabel:'省',allowBlank:false,regex:'',value:''});
// GroupBaseExtExtData.put('city',{widget:'textfield',fieldLabel:'市',allowBlank:false,regex:'',value:''});
GroupBaseExtExtData.put('dataChannel',{widget:'combo',fieldLabel:'数据来源渠道',cache:"DataChannel",regex:'',value:'0'});
GroupBaseExtExtData.put('itourChannel',{widget:'combo',fieldLabel:'从哪里知道itour',cache:"ItourChannel",regex:''});
}
makeGroupBaseExtExtData();

/**
 * 会员资源对象（组织基础信息） 组织机构
 */

function makeSubGroupData(){
var SubGroupData = new  Map();
objectMap.put('SubGroup',SubGroupData);
SubGroupData.put('groupType',{widget:'combo',fieldLabel:'关系类型',cache:'SubGroupType',regex:'',value:'0'});
SubGroupData.put('groupDuty',{widget:'textarea',fieldLabel:'关系描述',allowBlank:false,regex:'',value:''});
SubGroupData.put('parentGroupID',{widget:'textfield',fieldLabel:'父机构ID',allowBlank:false,regex:'',value:''});
SubGroupData.put('myGroupID',{widget:'textfield',fieldLabel:'当前机构ID',allowBlank:false,regex:'',value:''});
SubGroupData.put('parent',{widget:'textfield',fieldLabel:'父机构',allowBlank:false,regex:'',value:''});
SubGroupData.put('id',{widget:'textfield',fieldLabel:'组织结构主键',allowBlank:false,regex:'',value:''});
}
makeSubGroupData();
/**
 * 会员资源对象（候选会员） 候选个体会员
 */

function makeUserBaseTempData(){
var UserBaseTempData = new  Map();
objectMap.put('UserBaseTemp',UserBaseTempData);
UserBaseTempData.put('id',{widget:'textfield',fieldLabel:'系统唯一ID',value:''});
UserBaseTempData.put('status',{widget:'combo',fieldLabel:'状态',cache:"UserBaseTempStatus",regex:'',value:'0'});
UserBaseTempData.put('vstatus',{widget:'combo',fieldLabel:'状态',cache:"UserBaseTempStatus",regex:'',value:'0'});
UserBaseTempData.put('lastUptDate',{widget:'datefield',fieldLabel:'最后更新日期',format:'Y-m-d'});
UserBaseTempData.put('createDate',{widget:'datefield',fieldLabel:'记录创建日期',format:'Y-m-d'});

UserBaseTempData.put('creator',{widget:'textfield',fieldLabel:'记录创建人员',regex:'',value:''});
UserBaseTempData.put('creatorName',{widget:'textfield',fieldLabel:'记录创建人员',regex:'',value:''});
UserBaseTempData.put('vcreator',{widget:'textfield',fieldLabel:'记录创建人员',regex:'',value:''});
UserBaseTempData.put('lastUptUser',{widget:'textfield',fieldLabel:'最后更新人员',regex:'',value:''});
UserBaseTempData.put('updatorName',{widget:'textfield',fieldLabel:'最后更新人员',regex:'',value:''});
UserBaseTempData.put('vlastUptUser',{widget:'textfield',fieldLabel:'最后更新人员',regex:'',value:''});

UserBaseTempData.put('vlastUptDate',{widget:'datefield',fieldLabel:'最后更新日期',format:'Y-m-d'});
UserBaseTempData.put('vcreateDate',{widget:'datefield',fieldLabel:'记录创建日期',format:'Y-m-d'});


UserBaseTempData.put('chineseName',{widget:'textfield',validateField:'UserBaseTemp.chineseName',fieldLabel:'中文名',regex:'Chinese',allowBlank:false});
UserBaseTempData.put('englishFirstName',{widget:'textfield',fieldLabel:'英文姓',regex:'AZaz',value:'',allowBlank:true});
UserBaseTempData.put('englishSecondName',{widget:'textfield',fieldLabel:'英文名',regex:'AZaz',value:'',allowBlank:true});
UserBaseTempData.put('mobiles',{widget:'validatetrigger',fieldLabel:'联系手机',validateField:'UserBaseTemp.mobile',regex:'Mobile',value:''});
UserBaseTempData.put('mobile',{widget:'textfield',fieldLabel:'联系手机',regex:'Mobile',value:''});
UserBaseTempData.put('phone',{widget:'textfield',fieldLabel:'联系座机',regex:'ChinesePhone',value:''});
UserBaseTempData.put('emails',{widget:'validatetrigger',fieldLabel:'联系邮件',validateField:'UserBaseTemp.email',regex:'Email',value:'',allowBlank:false});
UserBaseTempData.put('email',{widget:'textfield',fieldLabel:'联系邮件',regex:'Email',value:''});
UserBaseTempData.put('gender',{widget:'combo',fieldLabel:'性别',value:'',cache:"Gender",value:'0'});
UserBaseTempData.put('birthday',{widget:'datefield',fieldLabel:'生日',format:'Y-m-d'});
UserBaseTempData.put('certificateName',{widget:'textfield',fieldLabel:'证件名称',regex:''});
UserBaseTempData.put('certificateType',{widget:'combo',fieldLabel:'证件类型',regex:'',value:'0',cache:'UserCertificateType'});
UserBaseTempData.put('certificateCode',{widget:'textfield',fieldLabel:'证件号码',regex:'',value:'',allowBlank:true});
UserBaseTempData.put('dataChannel',{widget:'combo',fieldLabel:'信息来源',regex:'',value:'0',cache:'UserBaseTempDataChannel'});
UserBaseTempData.put('dataChannels',{widget:'combo',fieldLabel:'信息来源',regex:'',value:'0',cache:'UserBaseTempDataChannel'});

UserBaseTempData.put('lastInviteData',{widget:'textfield',fieldLabel:'最后邀请时间',regex:'',value:''});
UserBaseTempData.put('sourceDescription',{widget:'textarea',fieldLabel:'信息来源描述',regex:'',value:''});
UserBaseTempData.put('otherCertificate',{widget:'textfield',fieldLabel:'其他证件名称',regex:'',value:''});
}
makeUserBaseTempData();

/**
 * 支撑系统对象 服务注册表
 */
function makeServiceRegistryData(){
    var ServiceRegistryData = new  Map();
    objectMap.put('ServiceRegistry',ServiceRegistryData);
    ServiceRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ServiceRegistryData.put('parentID',{widget:'hidden',fieldLabel:'父编号'});
    ServiceRegistryData.put('serviceCode',{widget:'textfield',fieldLabel:'权限代码'});
    ServiceRegistryData.put('serviceType',{widget:'combo',fieldLabel:'权限类型',cache:'SystemServiceType',value:'0'});
    ServiceRegistryData.put('serviceAddress',{widget:'textfield',fieldLabel:'权限地址'});
    ServiceRegistryData.put('serviceName',{widget:'textfield',fieldLabel:'权限名称'});
    ServiceRegistryData.put('memo',{widget:'textarea',fieldLabel:'备注'});
}
makeServiceRegistryData();
/**
 * 支撑系统对象 权限表
 */

function makeCompetenceData(){
    var CompetenceData = new  Map();
    objectMap.put('Competence',CompetenceData);
    CompetenceData.put('id',{widget:'hidden',fieldLabel:'主键'});
    CompetenceData.put('parentID',{widget:'hidden',fieldLabel:'父编号'});
    CompetenceData.put('restype',{widget:'combo',fieldLabel:'菜单类型',cache:'SystemServiceType',value:'模块'});
    CompetenceData.put('url',{widget:'textfield',fieldLabel:'菜单地址'});
    CompetenceData.put('resname',{widget:'textfield',fieldLabel:'菜单名称',allowBlank:false});
    CompetenceData.put('memo',{widget:'textarea',fieldLabel:'备注'});
}
makeCompetenceData();

/**
 * 支撑系统对象 数据字典表
 */

function makeDictionaryData(){
    var DictionaryData = new  Map();
    objectMap.put('Dictionary',DictionaryData);
    DictionaryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    DictionaryData.put('parentID',{widget:'hidden',fieldLabel:'父编号'});
    DictionaryData.put('elementcode',{widget:'textfield',fieldLabel:'字典编号',allowBlank:false});
    DictionaryData.put('elementname',{widget:'textfield',fieldLabel:'字典名称',allowBlank:false});
    DictionaryData.put('remark',{widget:'textarea',fieldLabel:'备注'});
}
makeDictionaryData();

function makeProcessRegistryData(){
    var ProcessRegistryData = new  Map();
    objectMap.put('ProcessRegistry',ProcessRegistryData);
    ProcessRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ProcessRegistryData.put('processName',{widget:'textfield',fieldLabel:'流程名称'});
    ProcessRegistryData.put('processVersion',{widget:'textfield',fieldLabel:'流程版本'});
    ProcessRegistryData.put('jbpmClassName',{widget:'textfield',fieldLabel:'流程类'});
}
makeProcessRegistryData();

function makeProcessTaskRegistryData(){
    var ProcessTaskRegistryData = new  Map();
    objectMap.put('ProcessTaskRegistry',ProcessTaskRegistryData);
    ProcessTaskRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ProcessTaskRegistryData.put('processName',{widget:'textfield',fieldLabel:'流程名称',value:'0'});
    ProcessTaskRegistryData.put('processVersion',{widget:'textfield',fieldLabel:'流程名称'});
    ProcessTaskRegistryData.put('taskName',{widget:'textfield',fieldLabel:'任务名称'});
}
makeProcessTaskRegistryData();

function makeProcessTransitionRegistryData(){
    var ProcessTransitionRegistryData = new  Map();
    objectMap.put('ProcessTransitionRegistry',ProcessTransitionRegistryData);
    ProcessTransitionRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ProcessTransitionRegistryData.put('processName',{widget:'textfield',fieldLabel:'流程名称',value:'0'});
    ProcessTransitionRegistryData.put('taskName',{widget:'textfield',fieldLabel:'任务名称'});
    ProcessTransitionRegistryData.put('taskStatus',{widget:'textfield',fieldLabel:'当前状态'});
    ProcessTransitionRegistryData.put('transitionName',{widget:'textfield',fieldLabel:'迁移名称'});
    ProcessTransitionRegistryData.put('transitionStatus',{widget:'textfield',fieldLabel:'迁移后状态'});
    ProcessTransitionRegistryData.put('jbpmClassName',{widget:'combo',fieldLabel:'计划名称',cache:'JbpmClass',value:'0'});
}
makeProcessTransitionRegistryData();


    
function makeTaskData(){
    var TaskData = new  Map();
    objectMap.put('Task',TaskData);
    TaskData.put('taskId',{widget:'textfield',fieldLabel:'任务编号'});
    TaskData.put('taskName',{widget:'textfield',fieldLabel:'任务名称'});
    TaskData.put('processName',{widget:'textfield',fieldLabel:'流程名称',value:'0'});
    TaskData.put('processId',{widget:'textfield',fieldLabel:'流程编号'});
    TaskData.put('createDate',{widget:'datefield',fieldLabel:'提交日期'});
    TaskData.put('startDate',{widget:'datefield',fieldLabel:'开始日期'});
    TaskData.put('endDate',{widget:'datefield',fieldLabel:'结束日期'});
    TaskData.put('prviousActor',{widget:'textfield',fieldLabel:'上一任务角色'});
    TaskData.put('taskActors',{widget:'textfield',fieldLabel:'当前任务角色'});
    TaskData.put('leavingTransitions',{widget:'textfield',fieldLabel:'用户操作'});
    TaskData.put('jbpmClassName',{widget:'textfield',fieldLabel:'对象类名'});
    TaskData.put('jbpmObjectId',{widget:'textfield',fieldLabel:'对象实例Id'});
    TaskData.put('operateMemo',{widget:'textarea',fieldLabel:'意见'});
}
makeTaskData();




function makeProcessInstanceData(){
    var ProcessInstanceData = new  Map();
    objectMap.put('ProcessInstance',ProcessInstanceData);
    ProcessInstanceData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ProcessInstanceData.put('processName',{widget:'textfield',fieldLabel:'流程名称',value:'0'});
    ProcessInstanceData.put('jbpmClassName',{widget:'textfield',fieldLabel:'类名'});
    ProcessInstanceData.put('processVersion',{widget:'textfield',fieldLabel:'流程版本'});
    ProcessInstanceData.put('jbpmProcessID',{widget:'textfield',fieldLabel:'流程ID'});
    ProcessInstanceData.put('jbpmObjectID',{widget:'textfield',fieldLabel:'对象ID'});
}
makeProcessInstanceData();

/**
 * 常用凭证地址
 */
function makeUserVoucherAddressData(){
    var UserVoucherAddressData = new Map();
    objectMap.put("UserVoucherAddress",UserVoucherAddressData);
    UserVoucherAddressData.put("voucherType",{widget:"combo",fieldLabel:"地址用途类型",cache:"VoucherType",value:'0'});
    UserVoucherAddressData.put("province",{widget:"combo",fieldLabel:"省",dic:"China"});
    UserVoucherAddressData.put("city",{widget:"combo",fieldLabel:"市"});
    UserVoucherAddressData.put("address",{widget:"textfield",fieldLabel:"详细地址"});
    UserVoucherAddressData.put("postCode",{widget:"textfield",fieldLabel:"邮编",regex:'Postcode'});
    UserVoucherAddressData.put("phone",{widget:"textfield",fieldLabel:"联系电话",allowBlank:false});
    UserVoucherAddressData.put("person",{widget:"textfield",fieldLabel:"联系人",allowBlank:false});
    UserVoucherAddressData.put("lastUsedDate",{widget:"datefield",fieldLabel:"上次使用时间"});
}
makeUserVoucherAddressData();

/**
 * 支撑系统对象 服务注册表
 */

function makeServiceRegistryData(){
    var ServiceRegistryData = new  Map();
    objectMap.put('ServiceRegistry',ServiceRegistryData);
    ServiceRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    ServiceRegistryData.put('parentID',{widget:'hidden',fieldLabel:'父编号'});
    ServiceRegistryData.put('serviceCode',{widget:'hidden',fieldLabel:'权限代码'});
    ServiceRegistryData.put('serviceType',{widget:'combo',fieldLabel:'权限类型',cache:'SystemServiceType'});
    ServiceRegistryData.put('serviceAddress',{widget:'textfield',fieldLabel:'权限地址'});
    ServiceRegistryData.put('serviceName',{widget:'textfield',fieldLabel:'权限名称'});
    ServiceRegistryData.put('memo',{widget:'textarea',fieldLabel:'备注'});
}
makeServiceRegistryData();

/**
 * 支撑系统对象 角色信息表
 */

function makeRoleRegistryData(){
    var RoleRegistryData = new Map();
    objectMap.put('RoleRegistry',RoleRegistryData);
    RoleRegistryData.put('id',{widget:'hidden',fieldLabel:'主键'});
    RoleRegistryData.put('roleCode',{widget:'hidden',fieldLabel:'岗位编号'});
    RoleRegistryData.put('roleClass',{widget:'combo',fieldLabel:'岗位类型',value:'0',cache:'RoleClass'});
    RoleRegistryData.put('roleName',{widget:'textfield',fieldLabel:'岗位名称'});
    RoleRegistryData.put('memo',{widget:'textarea',fieldLabel:'备注'});
}
/**
 * 支撑系统对象 岗位信息表
 */

function makePostData(){
    var PostData = new Map();
    objectMap.put('Post',PostData);
    PostData.put('id',{widget:'hidden',fieldLabel:'主键'});
    PostData.put('extend',{widget:'hidden',fieldLabel:'继承'});
    PostData.put('creator',{widget:'hidden',fieldLabel:'创建者'});
    PostData.put('createdate',{widget:'hidden',fieldLabel:'创建时间'});
    PostData.put('rolename',{widget:'textfield',fieldLabel:'岗位名称',allowBlank:false});
    PostData.put('description',{widget:'textarea',fieldLabel:'备注'});
}

makePostData();





function makeErrorMessageData() {
    var ErrorMessageData = new Map();
    objectMap.put('ErrorMessage', ErrorMessageData);
    ErrorMessageData.put('message', {widget : 'textfield',fieldLabel : '信息提示'});
    ErrorMessageData.put('errorCode', {widget : 'textfield',fieldLabel : '错误代码'});
    ErrorMessageData.put('errorName', {widget : 'textfield',fieldLabel : '错误名称'});
    ErrorMessageData.put('errorCause', {widget : 'textarea',fieldLabel : '错误原因' });
    ErrorMessageData.put('errorSolution', {widget : 'textarea',fieldLabel : '解决办法'});
    ErrorMessageData.put('errorRoot', {widget : 'textarea',fieldLabel : '错误根源'});
}
makeErrorMessageData();

function makePreferenceExlueRuleData() {
    var PreferenceExlueRuleData = new Map();
    objectMap.put("PreferenceExlueRule",PreferenceExlueRuleData);
    PreferenceExlueRuleData.put("productType",{widget:'combo',fieldLabel:"产品类型",cache:"PreferenceExlueRuleType",value:'0'});
    PreferenceExlueRuleData.put("startDate",{widget:'datefield',fieldLabel:"规则开始时间"});
    PreferenceExlueRuleData.put("endDate",{widget:'datefield',fieldLabel:"规则结束时间"});
    PreferenceExlueRuleData.put("status",{widget:'combo',fieldLabel:"发布状态",cache:"ScoreRuleStatus"});
}
makePreferenceExlueRuleData();

function makeCalenderEventData() {
    var CalenderEventData = new Map();
    objectMap.put("CalenderEvent",CalenderEventData);
    CalenderEventData.put("startTime",{widget:"datefield",fieldLabel:"生效开始时间"});
    CalenderEventData.put("endTime",{widget:"datefield",fieldLabel:"生效结束时间"});
    CalenderEventData.put("eventType",{widget:"combo",fieldLabel:"节日类型",cache:"CalenderEventType"});
    CalenderEventData.put("country",{widget:"combo",fieldLabel:"国家",dic:"Country"});
    CalenderEventData.put("province",{widget:"combo",fieldLabel:"省",dic:''});
    CalenderEventData.put("city",{widget:"combo",fieldLabel:"市",dic:''});
    CalenderEventData.put("title",{widget:"textfield",fieldLabel:"标题"});
    CalenderEventData.put("memo",{widget:"textarea",fieldLabel:"描述 "});
}
makeCalenderEventData();


function makeComplaintData() {
    var ComplaintData = new Map();
    objectMap.put("Complaint",ComplaintData);
    ComplaintData.put('id', {widget : 'hidden',fieldLabel : '主键'});
    ComplaintData.put("requesterID",{widget:"textfield",fieldLabel:"投诉人员编号"});
    ComplaintData.put("requesterName",{widget:"textfield",fieldLabel:"投诉人员姓名"});
    ComplaintData.put("requesterEmail",{widget:"textfield",fieldLabel:"投诉人员邮件"});
    ComplaintData.put("requesterPhone",{widget:"textfield",fieldLabel:"投诉人员电话"});
    ComplaintData.put("requesterDate",{widget:"datefield",fieldLabel:"投诉时间"});
    ComplaintData.put("requesterCause",{widget:"textarea",fieldLabel:"投诉原因"});
    ComplaintData.put("requestStatus",{widget:"combo",fieldLabel:"投诉状态",cache:"requestStatus"});
    ComplaintData.put("status",{widget:"combo",fieldLabel:"发布状态",cache:"ApprovalState"});
    ComplaintData.put("responsorID",{widget:"textfield",fieldLabel:"责任人"});
    ComplaintData.put("requestContent",{widget:"textarea",fieldLabel:"过程记录"});
    ComplaintData.put("solution",{widget:"textarea",fieldLabel:"结果建议"});
    ComplaintData.put("assignDate",{widget:"datefield",fieldLabel:"任务指派时间 "});
    ComplaintData.put("confirm",{widget:"textarea",fieldLabel:"客户反馈"});
    ComplaintData.put("assignorID",{widget:"textfield",fieldLabel:"任务指派人 "});
}
makeComplaintData();


function makeWorkItemData() {
      var WorkItemData = new Map();
      objectMap.put("WorkItem",WorkItemData);
      WorkItemData.put('id', {widget : 'hidden',fieldLabel : '主键'});
      WorkItemData.put('taskname',{widget:'textfield',fieldLabel:'任务名称',regex:''});
      WorkItemData.put('date',{widget:'datefield',fieldLabel:'任务创建时间',regex:''});
      WorkItemData.put('description',{widget:'textfield',fieldLabel:'流程描述',regex:''});
      WorkItemData.put('actorId',{widget:'textfield',fieldLabel:'当前处理人',regex:''});
      WorkItemData.put('tokenid',{widget:'textfield',fieldLabel:'当前节点',regex:''});
     
}
makeWorkItemData();
function makeEtipMsgRegistryData(){
      var EtipMsgRegistryData = new Map();
      objectMap.put("EtipMsgRegistryData",EtipMsgRegistryData);
      EtipMsgRegistryData.put('id', {widget : 'hidden',fieldLabel : '主键'});
      EtipMsgRegistryData.put('messageName', {widget : 'textfield',fieldLabel : '桌面消息名称'});
      EtipMsgRegistryData.put('triggerAction', {widget : 'textfield',fieldLabel : '触发请求'});
      EtipMsgRegistryData.put('triggerPoint', {widget : 'combo',fieldLabel : '触发点',cache:'TriggerPoint',value:'0'});
      EtipMsgRegistryData.put('msgTrigger', {widget : 'textfield',fieldLabel : '触发者'});// 暂时不需要
      EtipMsgRegistryData.put('handlerType', {widget : 'combo',fieldLabel : '消息处理者类型',cache:'HandlerType',value:'0'});
      EtipMsgRegistryData.put('synchronize', {widget : 'combo',fieldLabel : '同步还是异步处理',cache:'Synchronize',value:'0'});
      EtipMsgRegistryData.put('receivers', {widget:'trigger',allowBlank:true,fieldLabel : '消息接受者'});
      EtipMsgRegistryData.put('vreceivers', {widget:'textarea',allowBlank:true,fieldLabel : '消息接受者'});
      EtipMsgRegistryData.put('receiverType', {widget : 'combo',fieldLabel : '消息接受类型',cache:'ReceiverType'});
      EtipMsgRegistryData.put('vreceiverType', {widget : 'combo',fieldLabel : '消息接受类型',cache:'ReceiverType'});
}
makeEtipMsgRegistryData();

function makeBankAccountsData(){
	var BankAccountsData = new Map();
	objectMap.put("BankAccountsData",BankAccountsData);
	BankAccountsData.put('orgName', {widget : 'hidden',fieldLabel : '所属主体名称'});
	BankAccountsData.put('orgid', {widget : 'hidden',fieldLabel : '所属主体id'});
	BankAccountsData.put('id', {widget : 'hidden',fieldLabel : '主键'});
	BankAccountsData.put('accountCode', {widget : 'textfield', fieldLabel : '账号', allowBlank : false});
	BankAccountsData.put('currency', {widget:'combo',fieldLabel:'币种',allowBlank:false});
	BankAccountsData.put('accountName_cn',{widget:'textfield',fieldLabel:'账户名称',allowBlank:false});
	BankAccountsData.put('accountName_us',{widget:'textfield',fieldLabel:'账户名称(英文)'});
	BankAccountsData.put('bankName_cn',{widget:'textfield',fieldLabel:'开户行(中文)'});
	BankAccountsData.put('bankName_us',{widget:'textfield',fieldLabel:'开户行(英文)'});
	BankAccountsData.put('internet',{widget:'combo',fieldLabel:'是否网银',cache:'IsIndexShowType',value:'0'});
	BankAccountsData.put('buildDate',{widget:'datefield',fieldLabel:'开户日期',allowBlank:false});
	BankAccountsData.put('destroy',{widget:'textfield',fieldLabel:'销户日期'});
	BankAccountsData.put('stopDate',{widget:'textfield',fieldLabel:'停用日期'});
	BankAccountsData.put('bankPlace',{widget:'textfield',fieldLabel:'开户地'});
	BankAccountsData.put('signer',{widget:'textfield',fieldLabel:'有权签字人'});
	BankAccountsData.put('sign',{widget:'textfield',fieldLabel:'签字方式'});
	BankAccountsData.put('remark',{widget:'textarea',fieldLabel:'备注'});
	BankAccountsData.put('use',{widget:'textfield',fieldLabel:'用途'});
	BankAccountsData.put('defaultMoney',{widget:'textfield',fieldLabel:'期初余额',allowBlank:false});
	BankAccountsData.put('overdraft',{widget:'combo',fieldLabel:'是否透支',cache:'IsIndexShowType',value:'0',allowBlank:false});
	BankAccountsData.put('accountNameDefault',{widget:'textfield',fieldLabel:'账户名称'});
	BankAccountsData.put('status',{widget:'hidden',fieldLabel:'状态'});
	BankAccountsData.put('creater',{widget:'hidden',fieldLabel:'创建人'});
	BankAccountsData.put('creatorName',{widget:'hidden',fieldLabel:'创建人名称'});
	BankAccountsData.put('balance',{widget:'hidden',fieldLabel:'账户余额'});
	BankAccountsData.put('domain',{widget:'combo',fieldLabel:'账户境域',cache:'Domain',value:'0'});
	
	//getDBStoreByCacheName('CURRENCY');
}
makeBankAccountsData();


/**
 * 工作流测试类
 */
function makeWorkFlowTestData(){
    var workFlowTestData = new Map();
    objectMap.put("WorkFlowTest",workFlowTestData);
    workFlowTestData.put('id',{widget : 'hidden',fieldLabel : '主键'});
    workFlowTestData.put('status',{widget : 'hidden',cache:'WorkFlowTestStatus',fieldLabel : '计划状态'});
    workFlowTestData.put('planName',{widget : 'textfield',fieldLabel : '计划名称',regex:''});
    workFlowTestData.put('creators',{widget : 'textfield',fieldLabel : '创建人',regex:''});
}
makeWorkFlowTestData();

function makJMSDeskTop() {
    var JMSDeskTop = new Map();
    objectMap.put("JMSDeskTop", JMSDeskTop);
    JMSDeskTop.put("title", { widget : "textfield", fieldLabel : "标题" });
    JMSDeskTop.put("content", { widget : "textarea", fieldLabel : "详细内容" });
    JMSDeskTop.put("sender", { widget : 'textfield', fieldLabel : '发送者' });
    // 此处还需要重新查询userName,mobile,email，而不是用缓冲区校验
    JMSDeskTop.put("workerNO", { widget : 'trigger', fieldLabel : '工号'});
    // 此处容易重名 ，怎么办呢?
    JMSDeskTop.put("userName", {widget : 'trigger', fieldLabel : '名字' });
    JMSDeskTop.put("mobile", { widget : 'trigger', fieldLabel : '手机号', regex : 'email' });
    JMSDeskTop.put("email", { widget : 'trigger', fieldLabel : '邮箱', regex : 'email' });
    // 此处要支持多选
    JMSDeskTop.put("desktopChannel", { widget : 'checkbox', fieldLabel : '桌面消息' });
    JMSDeskTop.put("smsChannel", { widget : 'checkbox', fieldLabel : '短消息' });
    JMSDeskTop.put("mailChannel", { widget : 'checkbox', fieldLabel : '邮件' });
    JMSDeskTop.put("msgType", { widget : 'combo', fieldLabel : '信息类型', cache : 'MsgType', value : '1' });
    JMSDeskTop.put("orderNO", { widget : 'textfield', fieldLabel : '订单号' });
    JMSDeskTop.put("desktopTime", { widget : 'datefield', fieldLabel : '发送时间' });
}
makJMSDeskTop();

function makePayment(){
	var PaymentData = new Map();
	objectMap.put("Payment", PaymentData);
	PaymentData.put("id",{widget : 'hidden',fieldLabel:'付款账号',allowBlank:false});
	PaymentData.put("sourceaccount",{widget : 'combo',fieldLabel:'付款账号',allowBlank:false,editable:true,filter:true});
	PaymentData.put("sourcename",{widget : 'textfield',fieldLabel:'付款账户名称'});
	PaymentData.put("sourcebank",{widget : 'textfield',fieldLabel:'付款账户开户行'});
	PaymentData.put("sourcecurrency",{widget : 'textfield',fieldLabel:'开户币种'});
	PaymentData.put("transactionsobject",{widget : 'combo',fieldLabel:'现金流统计对象',allowBlank:false});
	PaymentData.put("transactionscurrency",{widget : 'combo',fieldLabel:'付款币种',allowBlank:false});
	PaymentData.put("transactionsmoney",{widget : 'textfield',fieldLabel:'付款金额',allowBlank:false});
	PaymentData.put("transactionsexchange",{widget : 'textfield',fieldLabel:'汇率(美元)',allowBlank:false});
	PaymentData.put("transactionsdate",{widget : 'datefield',fieldLabel:'付款日期',allowBlank:false});
	PaymentData.put("transactionstype",{widget : 'combo',fieldLabel:'交易类型',allowBlank:false});
	PaymentData.put("changemoney",{widget : 'textfield',fieldLabel:'折算金额'});
	PaymentData.put("targetaccount",{widget : 'combo',fieldLabel:'收款账号',allowBlank:false,editable:true,filter:true});
	PaymentData.put("targetname",{widget : 'textfield',fieldLabel:'收款账户名称'});
	PaymentData.put("targetbank",{widget : 'textfield',fieldLabel:'收款账户开户行'});
	PaymentData.put("notescode",{widget : 'textfield',fieldLabel:'发票编号'});
	PaymentData.put("createdate",{widget : 'hidden',fieldLabel:'制单日期'});
	PaymentData.put("createorgid",{widget : 'hidden',fieldLabel:'制单机构'});
	PaymentData.put("specialtype",{widget : 'textfield',fieldLabel:'转款类型'});
	PaymentData.put("sourceisfinancial",{widget : 'combo',fieldLabel:'是否占用资金计划',cache:'IsIndexShowType',value:'0'});
	PaymentData.put("sourcefinancialele",{widget : 'textfield',fieldLabel:'计划要素'});
	PaymentData.put("sourcebudgetname",{widget : 'combo',fieldLabel:'预算名称'});
	PaymentData.put("status",{widget : 'hidden',fieldLabel:'单据状态'});
	PaymentData.put("sourceisfinancial2",{widget : 'textfield',fieldLabel:'是否占用资金计划'});
	PaymentData.put("targetfinancialele",{widget : 'textfield',fieldLabel:'计划要素'});
	PaymentData.put("targetbudgetname",{widget : 'textfield',fieldLabel:'预算名称'});
	PaymentData.put("nature",{widget : 'hidden',fieldLabel:'单据性质'});
	PaymentData.put("creater",{widget : 'hidden',fieldLabel:'制单人名称'});
	PaymentData.put("createid",{widget : 'hidden',fieldLabel:'制单人'});
	PaymentData.put("remark",{widget : 'textarea',fieldLabel:'备注'});
	PaymentData.put("targetcurrency",{widget : 'textfield',fieldLabel:'开户币种'});
	PaymentData.put("settlementtype",{widget : 'hidden',fieldLabel:'单据类型'});
	PaymentData.put("planTotal",{widget : 'textfield',fieldLabel:'计划额度'});
	PaymentData.put("planOver",{widget : 'textfield',fieldLabel:'计划余额'});
	PaymentData.put("budgetTotal",{widget : 'textfield',fieldLabel:'预算额度'});
	PaymentData.put("budgetOver",{widget : 'textfield',fieldLabel:'预算余额'});
	PaymentData.put("servicescode",{widget : 'textfield',fieldLabel:'单据编号',allowBlank:false});
	PaymentData.put("paymentmode",{widget : 'combo',fieldLabel:'付款方式',cache:'PaymentMode',value:'TT'});
}
makePayment();
function makeTransfer(){
	var TransferData = new Map();
	objectMap.put("Transfer", TransferData);
	TransferData.put("id",{widget : 'hidden',fieldLabel:'付款账号',allowBlank:false});
	TransferData.put("sourceaccount",{widget : 'combo',fieldLabel:'付款账号',allowBlank:false,editable:true,filter:true});
	TransferData.put("sourcename",{widget : 'textfield',fieldLabel:'付款账户名称'});
	TransferData.put("sourcebank",{widget : 'textfield',fieldLabel:'付款账户开户行'});
	TransferData.put("sourcecurrency",{widget : 'textfield',fieldLabel:'开户币种'});
	TransferData.put("transactionsobject",{widget : 'combo',fieldLabel:'现金流统计对象',allowBlank:false});
	TransferData.put("transactionscurrency",{widget : 'combo',fieldLabel:'付款币种',allowBlank:false});
	TransferData.put("transactionsmoney",{widget : 'textfield',fieldLabel:'付款金额',allowBlank:false});
	TransferData.put("transactionsexchange",{widget : 'textfield',fieldLabel:'汇率',allowBlank:false});
	TransferData.put("transactionsdate",{widget : 'datefield',fieldLabel:'付款日期',allowBlank:false});
	TransferData.put("transactionstype",{widget : 'combo',fieldLabel:'交易类型',allowBlank:false});
	TransferData.put("changemoney",{widget : 'textfield',fieldLabel:'折算金额'});
	TransferData.put("targetaccount",{widget : 'combo',fieldLabel:'收款账号',allowBlank:false,editable:true,filter:true});
	TransferData.put("targetname",{widget : 'textfield',fieldLabel:'收款账户名称'});
	TransferData.put("targetbank",{widget : 'textfield',fieldLabel:'收款账户开户行'});
	TransferData.put("notescode",{widget : 'textfield',fieldLabel:'发票编号'});
	TransferData.put("createdate",{widget : 'hidden',fieldLabel:'制单日期'});
	TransferData.put("createorgid",{widget : 'hidden',fieldLabel:'制单机构'});
	TransferData.put("specialtype",{widget : 'textfield',fieldLabel:'转款类型'});
	TransferData.put("sourceisfinancial",{widget : 'combo',fieldLabel:'是否占用资金计划',cache:'IsIndexShowType',value:'0'});
	TransferData.put("sourcefinancialele",{widget : 'textfield',fieldLabel:'计划要素'});
	TransferData.put("sourcebudgetname",{widget : 'combo',fieldLabel:'预算名称'});
	TransferData.put("status",{widget : 'hidden',fieldLabel:'单据状态'});
	TransferData.put("sourceisfinancial2",{widget : 'combo',fieldLabel:'是否占用资金计划',cache:'IsIndexShowType',value:'0'});
	TransferData.put("targetfinancialele",{widget : 'textfield',fieldLabel:'计划要素'});
	TransferData.put("targetbudgetname",{widget : 'textfield',fieldLabel:'预算名称'});
	TransferData.put("nature",{widget : 'hidden',fieldLabel:'单据性质'});
	TransferData.put("creater",{widget : 'hidden',fieldLabel:'制单人名称'});
	TransferData.put("createid",{widget : 'hidden',fieldLabel:'制单人'});
	TransferData.put("remark",{widget : 'textarea',fieldLabel:'备注'});
	TransferData.put("targetcurrency",{widget : 'textfield',fieldLabel:'开户币种'});
	TransferData.put("settlementtype",{widget : 'hidden',fieldLabel:'单据类型'});
	TransferData.put("targetdate",{widget : 'datefield',fieldLabel:'收款日期'});
	TransferData.put("servicescode",{widget : 'textfield',fieldLabel:'单据编号',allowBlank:false});
	TransferData.put("planTotal",{widget : 'textfield',fieldLabel:'计划额度'});
	TransferData.put("planOver",{widget : 'textfield',fieldLabel:'计划余额'});
	TransferData.put("targetTotal",{widget : 'textfield',fieldLabel:'计划额度'});
	TransferData.put("targetOver",{widget : 'textfield',fieldLabel:'计划余额'});
	TransferData.put("paymentmode",{widget : 'combo',fieldLabel:'付款方式',cache:'PaymentMode',value:'TT'});
}
makeTransfer();
function makeSettlementSearch(){
	var SettlementSearchData = new Map();
	objectMap.put("SettlementSearch", SettlementSearchData);
	SettlementSearchData.put("sourceaccount",{widget : 'combo',fieldLabel:'付款账号',editable:true,filter:true});
	SettlementSearchData.put("sourcename",{widget : 'combo',fieldLabel:'付款账户名称',editable:true,filter:true});
	SettlementSearchData.put("currency",{widget : 'combo',fieldLabel:'开户币种'});
	SettlementSearchData.put("targetname",{widget : 'combo',fieldLabel:'收款账户名称',editable:true,filter:true});
	SettlementSearchData.put("status",{widget : 'combo',fieldLabel:'单据状态', cache:'PaymentStatus'});
	SettlementSearchData.put("transfernature",{widget : 'combo',fieldLabel:'单据性质', cache:'TransferNature'});
	SettlementSearchData.put("paymentnature",{widget : 'combo',fieldLabel:'单据性质', cache:'PaymentNature'});
	SettlementSearchData.put("datastart",{widget : 'datefield',fieldLabel:'交易日期起'});
	SettlementSearchData.put("datastop",{widget : 'datefield',fieldLabel:'交易日期止'});
	SettlementSearchData.put("notescode",{widget : 'textfield',fieldLabel:'发票编号'});
}
makeSettlementSearch();
function makeSettlementQuery(){
	var SettlementQueryData = new Map();
	objectMap.put("SettlementQuery", SettlementQueryData);
	SettlementQueryData.put("sourceaccount",{widget : 'combo',fieldLabel:'账号'});
	SettlementQueryData.put("sourcename",{widget : 'combo',fieldLabel:'账户名称'});
//	SettlementQueryData.put("currency",{widget : 'combo',fieldLabel:'开户币种', dbcache:'CURRENCY'});
	SettlementQueryData.put("targetname",{widget : 'combo',fieldLabel:'收款账户名称'});
	SettlementQueryData.put("status",{widget : 'combo',fieldLabel:'单据状态', cache:'QueryStatus'});
	SettlementQueryData.put("transfernature",{widget : 'combo',fieldLabel:'单据性质', cache:'QueryNature'});
	SettlementQueryData.put("datastart",{widget : 'datefield',fieldLabel:'交易日期起'});
	SettlementQueryData.put("datastop",{widget : 'datefield',fieldLabel:'交易日期止'});
	SettlementQueryData.put("notescode",{widget : 'textfield',fieldLabel:'发票编号'});
	SettlementQueryData.put("transactionstype",{widget : 'combo',fieldLabel:'交易类型'});
	SettlementQueryData.put("transactionsobject",{widget : 'combo',fieldLabel:'现金流统计对象'});
	SettlementQueryData.put("querytype",{widget : 'combo',fieldLabel:'单据类型', cache:'QueryType'});
	SettlementQueryData.put("querysettlementstatus",{widget : 'combo',fieldLabel:'单据状态', cache:'QuerySettlementStatus'});
}
makeSettlementQuery();