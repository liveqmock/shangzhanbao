 /**
		* @updataVersion ZLB @date 2012-3-27 上午10:09:18 {
		* 	Description:  添加远程验证remoteValidator
		*}
	*/
$.extend($.fn.validatebox.defaults.rules, { 
	remoteValidator : {//远程,验证
		validator : function(value, params) { 
		//params[0]指url, params[1]是数组 参数 要与url中的对应url中前后添加'$'
		//eg:validType="remoteValidator'/task_info/key/validateTaskNameUnique?id=$taskInfo.parentoid$&taskName=',['taskInfo.parentoid']]" 
	
		    value = $.trim(value); //去空格 
		    var result = false;
		    var url  = params[0];
		    
		    if(params[1]){//替换url中的参数encodeURI()
		    	var param = params[1];
		    	for ( var int = 0; int < param.length; int++) {
					var key = param[int];
					url = url.replace( "$"+ key + "$" , $( "#" + key.replace(".","\\.") ).val() ) ;
				}
		    }
		    if (value.length > 0) {
		    	 $.ajax({// 后台验证,返回"true" 即通过
                     async : false,
                     type : 'post',   
                     url : root + encodeURI(url + value),
                     success : function(date) {
                         if (date == 'true' || true == date ) {  
                        	 result = true;   
                         }
                     }   
                 });   
		    }
		    
		    return result;
		}, 
		message : '已存在' 
	}
	,endTime : { // 判断时间是否大于指定时间
		//eg:<input id="taskInfo.endDate" name="taskInfo.endDate" validType="endTime('taskInfo.taskDate')" class="easyui-datebox" />
		
	    validator : function(value, param) { 
		
	       var startTimeObj = $( "#" + param.replace(".","\\.") )
	        , startTime = "";
	         
        	try {
        		 startTime = startTimeObj.datebox("getValue" );
			} catch (e) {
				try {
					startTime = startTimeObj.datetimebox("getValue" );
				} catch (e) {
					try {
						startTime = startTimeObj.timespinner("getValue" );
					} catch (e) {
						
					}
				}
			}
			
			if( undefined==startTime || "" == startTime ){return true; }
			
	        return  startTime <= value;
	    }, 
	    message : '结束时间不能比开始时间小' 
	}
	,startTime : { // 判断时间是否小于指定控件的时间
		//eg:<input id="taskInfo.endDate" name="taskInfo.endDate" validType="endTime('taskInfo.taskDate')" class="easyui-datebox" />
		
		validator : function(value, param ) { 
			var endTimeObj = $( "#" + param.replace(".","\\.") )
			, endTime = "";
			
        	try {
        		 endTime = endTimeObj.datebox("getValue" );
			} catch (e) {
				try {
					endTime = endTimeObj.datetimebox("getValue" );
				} catch (e) {
					try {
						endTime = endTimeObj.timespinner("getValue" );
					} catch (e) {}
				}
			}
			if( undefined==endTime || "" == endTime ){return true; }
			return  endTime >= value;
		}, 
		message : '开始时间要小于结束时间' 
	}
	,minLength : { // 判断最小长度 
        validator : function(value, param) { 
            value = $.trim(value); //去空格 
            return value.length >= param[0]; 
        }, 
        message : '最少输入 {0} 个字符。' 
    }, 
    maxLength : { // 判断最小长度 
        validator : function(value, param) { 
            value = $.trim(value); //去空格 
            return value.length <= param[0]; 
        }, 
        message : '最大输入 {0} 个字符。' 
    }, 
    length:{validator:function(value,param){ 
        var len=$.trim(value).length; 
            return len>=param[0]&&len<=param[1]; 
        }, 
            message:"输入内容长度必须介于{0}和{1}之间." 
        }, 
    phone : {// 验证电话号码 
        validator : function(value) { 
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
        }, 
        message : '格式错误'
    }, 
    mobile : {// 验证手机号码 
        validator : function(value) { 
            return /^(13|15|18)\d{9}$/i.test(value); 
        }, 
        message : '格式错误'
    }, 
    phoneOrMobile : {// 验证手机号码 或者电话
    	validator : function(value) { 
    		if( ! /^(13|15|18)\d{9}$/i.test(value) ){
    			return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value) 
    		}
    		return true; 
    	}, 
    message : '请填写正确的联系电话' 
    }, 
    idcard : {// 验证身份证 
        validator : function(value) { 
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value); 
        }, 
        message : '身份证号码格式不正确' 
    }, 
    intOrFloat : {// 验证整数或小数 
        validator : function(value) { 
            return /^\d+(\.\d+)?$/i.test(value); 
        }, 
        message : '请输入数字，并确保格式正确' 
    }, 
    currency : {// 验证货币 
        validator : function(value) { 
            return /^\d+(\.\d+)?$/i.test(value); 
        }, 
        message : '货币格式不正确' 
    }, 
    qq : {// 验证QQ,从10000开始 
        validator : function(value) { 
            return /^[1-9]\d{4,9}$/i.test(value); 
        }, 
        message : 'QQ号码格式不正确' 
    }, 
    integer : {// 验证整数 
        validator : function(value) { 
            return /^[+]?[1-9]+\d*$/i.test(value); 
        }, 
        message : '请输入整数' 
    }, 
    chinese : {// 验证中文 
        validator : function(value) { 
            return /^[\u0391-\uFFE5]+$/i.test(value); 
        }, 
        message : '请输入中文' 
    }, 
    english : {// 验证英语 
        validator : function(value) { 
            return /^[A-Za-z]+$/i.test(value); 
        }, 
        message : '请输入英文' 
    }, 
    unnormal : {// 验证是否包含空格和非法字符 
        validator : function(value) { 
            return /.+/i.test(value); 
        }, 
        message : '输入值不能为空和包含其他非法字符' 
    }, 
    username : {// 验证用户名 
        validator : function(value) { 
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value); 
        }, 
        message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）' 
    }, 
    faxno : {// 验证传真 
        validator : function(value) { 
//            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value); 
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
        }, 
        message : '传真号码不正确' 
    }, 
    zip : {// 验证邮政编码 
        validator : function(value) { 
            return /^[1-9]\d{5}$/i.test(value); 
        }, 
        message : '邮政编码格式不正确' 
    }, 
    ip : {// 验证IP地址 
        validator : function(value) { 
            return /d+.d+.d+.d+/i.test(value); 
        }, 
        message : 'IP地址格式不正确' 
    }, 
    name : {// 验证姓名，可以是中文或英文 
            validator : function(value) { 
                return /^[\u0391-\uFFE5]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value); 
            }, 
            message : '请输入姓名' 
    }, 
    carNo:{ 
        validator : function(value){ 
            return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value); 
        }, 
        message : '车牌号码无效（例：粤J12350）' 
    }, 
    carenergin:{ 
        validator : function(value){ 
            return /^[a-zA-Z0-9]{16}$/.test(value); 
        }, 
        message : '发动机型号无效(例：FG6H012345654584)' 
    }, 
    email:{ 
        validator : function(value){ 
        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
    }, 
    message : '格式错误'    
    }, 
    msn:{ 
        validator : function(value){ 
        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
    }, 
    message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)' 
    },same:{ 
        validator : function(value, param){ 
            if($("#"+param[0]).val() != "" && value != ""){ 
                return $("#"+param[0]).val() == value; 
            }else{ 
                return true; 
            } 
        }, 
        message : '两次输入的密码不一致！'    
    }
}); 


/* 密码由字母和数字组成，至少6位 */
var safePassword = function (value) {
    return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
}

var idCard = function (value) {
    if (value.length == 18 && 18 != value.length) return false;
    var number = value.toLowerCase();
    var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
    if (re == null || a.indexOf(re[1]) < 0) return false;
    if (re[2].length == 9) {
        number = number.substr(0, 6) + '19' + number.substr(6);
        d = ['19' + re[4], re[5], re[6]].join('-');
    } else d = [re[9], re[10], re[11]].join('-');
    if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;
    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
}

var isDateTime = function (format, reObj) {
    format = format || 'yyyy-MM-dd';
    var input = this, o = {}, d = new Date();
    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
    var len = f1.length, len1 = f3.length;
    if (len != f2.length || len1 != f4.length) return false;
    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
    o.dd = s(o.dd, o.d, d.getDate(), 31);
    o.hh = s(o.hh, o.h, d.getHours(), 24);
    o.mm = s(o.mm, o.m, d.getMinutes());
    o.ss = s(o.ss, o.s, d.getSeconds());
    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
    d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
    var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
    return reVal && reObj ? d : reVal;
    function s(s1, s2, s3, s4, s5) {
        s4 = s4 || 60, s5 = s5 || 2;
        var reVal = s3;
        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
        if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
        return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
    }
};
