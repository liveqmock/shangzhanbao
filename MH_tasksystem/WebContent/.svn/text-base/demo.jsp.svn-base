<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<%@include file="/baseHead.jsp"%>
<title>jQuery formValidator表单验证插件 </title>
<script type="text/javascript" src="${root}/view/js/jquery.scrollTo.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.min.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/view/css/ctn.css" />
<script type="text/javascript">
$(document).ready(function(){
	$.formValidator.initConfig({theme:"126",submitOnce:true,formID:"form1",
		onError:function(msg){alert(msg);},
	});
	
	$("#email").formValidator({onShowFixText:"6~18个字符，包括字母、数字、下划线，以字母开头，字母或数字结尾",onShow:"请输入邮箱",onFocus:"邮箱6-100个字符,输入正确了才能离开焦点",onCorrect:"恭喜你,你输对了",defaultValue:"@"}).inputValidator({min:6,max:100,onError:"你输入的邮箱长度非法,请确认"}).regexValidator({regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",onError:"你输入的邮箱格式不正确"});
	$("#password1").formValidator().inputValidator().passwordValidator({ContinueChar:false,SameChar:false,compareID:"us"});
	$("#tel").formValidator({onShowFixText:"密码遗忘或被盗时，可通过手机短信取回密码",onShow:"请输入手机号码",onFocus:"手机的长度必须是11位",onCorrect:"手机合法"}).inputValidator({min:11,max:11,onError:"手机号码必须为11位,请确认"}).regexValidator({regExp:"mobile",dataType:"enum",onError:"手机的格式不正确"});
    $("#ms").formValidator({onShowFixText:"",onShowText:"这家伙很懒，什么都没有留下。",ajax:true,onShow:"请输入你的描述",onFocus:"描述至少要输入10个汉字或20个字符",onCorrect:"恭喜你,你输对了",defaultValue:"这家伙很懒，什么都没有留下。"}).inputValidator({min:20,onError:"你输入的描述长度不正确,请确认"});
});
</script>
<style type="text/css">
tr{height:30px;}
.STYLE1 {
	font-size: 12px;
	font-weight: bold;
}
</style>
</head>

<body>
<h3>jQuery formValidator表单验证插件示例</h3>
<form action="" method="post" name="form1" id="form1">
  <table border="0px" style="font-size:12px" width="630px">
    <tr> 
      <td align="right">* 用户名:</td>
      <td><input type="text" id="us" name="us" style="width:120px" value="maodong" /></td>
      <td><div id="usTip" style="width:280px"></div></td>
    </tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td colspan="2" valign="top"><div id="usFixTip">6~12个字符，包括字母、数字、下划线，以字母开头，字母或数字结尾</div></td>
    </tr>
    <tr> 
      <td align="right">* 密码:</td>
      <td><input type="password" id="password1" name="password1" style="width:120px" /></td>
      <td><div id="password1Tip" style="width:280px"></div></td>
    </tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td colspan="2" valign="top"><div id="password1FixTip">6~16个字符，包括字母、数字、特殊符号，区分大小写</div></td>
    </tr>
    <tr>
      <td align="right">* 确认密码</td>
      <td><input type="password" id="password2" integer="只能为整数" name="password2" style="width:120px" /></td>
      <td><div id="password2Tip" style="width:280px"></div></td>
    </tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td colspan="2" valign="top"><div id="password2FixTip">请再次输入密码</div></td>
    </tr>
    <tr> 
      <td align="right">* 邮件地址:</td>
      <td><input type="text" id="email" name="email" style="width:120px" /></td>
      <td><div id="emailTip" style="width:280px"></div></td>
    </tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td colspan="2" valign="top"><div id="emailFixTip">6~18个字符，包括字母、数字、下划线，以字母开头，字母或数字结尾</div></td>
    </tr>
    <tr> 
      <td align="right">手机号码:</td>
      <td><input type="text" id="tel" name="tel" style="width:120px" /></td>
      <td><div id="telTip" style="width:280px"></div></td>
    </tr>
    <tr>
      <td align="right" valign="top">&nbsp;</td>
      <td colspan="2" valign="top"><div id="telFixTip">密码遗忘或被盗时，可通过手机短信取回密码</div></td>
    </tr>
    <tr> 
      <td align="right" valign="top">你的描述:</td>
      <td colspan="2" valign="top"> <textarea id="ms" name="ms" cols="50" rows="5">这里是十个中文字符哦</textarea>      </td>
    </tr>
    <tr> 
      <td colspan="3"><div id="msTip" style="width:280px"></div></td>
    </tr>
  </table>
  
</form>
</html>
