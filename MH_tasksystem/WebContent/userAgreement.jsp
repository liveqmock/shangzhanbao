<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/mini_top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<style type="text/css">
.tooltip-inner {
	text-indent: 0em;
}
</style>
<link rel="stylesheet" type="text/css" href="${root }/view/css/bombBox/bombBox.css"/>
<script type="text/javascript" src="${root }/view/js/bombBox/bombBoxUtil.js"></script>
<script type="text/javascript"
	src="${root}/view/easyUI/jquery1.7.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript"
	src="${root}/view/js/common/bootstrap-tooltip.js"></script>
	<script type="text/javascript">
	function colseAgreeMentjsp(){
		top.window.opener = top; 
		top.window.open('','_self',''); 
		top.window.close(); 
	}
	</script>
</head>

<body>
	<div class="content">
		<article class="loginSucessful">
		<h1 style="font-size: 16px;" align="center">用户协议</h1>
		<div id="login_Tab_L" style="margin-left: 180px;">
			<form id="myform" action="" method="post"
				onsubmit="return checkSub($(this))">
					
<p style="font-size: 14px;">在您购买和使用①产品名称（下文简称“本产品”）前，请认真阅读本协议。用户须同意本协议，方可购买和使用本产品。<br></p>
<p style="font-size: 14px;">1.服务内容<br></p>
<p style="font-size: 14px;">1.1本产品提供②服务内容服务，其中的部分服务为收费服务。<br></p>
<p style="font-size: 14px;">1.2在本产品使用过程中，可能会涉及与本产品整合的第三方产品。当涉及到的第三方产品展示了相应的产品说明时，您须要仔细阅读并认可后，才能使用这些第三方产品。本产品提供方对不受控制的产品不承担责任。<br></p>
<p style="font-size: 14px;">2.内容发布<br></p>
<p style="font-size: 14px;">2.1在使用本产品时，用户可以按其需求和喜好添加和发布内容。但所添加和发布的内容必须符合中华人民共和国法律法规的规定，并不侵害其他人的利益。用户对其在本产品中添加和发布的内容承担责任。<br></p>
<p style="font-size: 14px;">2.2产品提供方有权判断用户添加和发布的内容是否违反本条款，并对违反的相关部分或全部内容做删除或屏蔽处理。<br></p>
<p style="font-size: 14px;">3.素材版权<br></p>
<p style="font-size: 14px;">本产品为了方便用户使用而提供的图片、文字、模板等，其版权归于本站或本站的设计师、素材提供方。用户仅被授权在本产品中使用这些素材。在获得各自版权所有人的明确许可前，用户不得在本产品以外的地方使用这些素材。<br></p>
<p style="font-size: 14px;">4.免责声明<br></p>
<p style="font-size: 14px;">用户明确同意自行承担其使用本产品所存在的风险。在适用法律允许的最大范围内，对因使用或不能使用本产品所产生的损害及风险，包括但不限于直接或间接的个人损害、商业赢利的丧失、贸易中断、商业信息的丢失或任何其它经济损失，服务提供方不承担任何责任。<br></p>
<p style="font-size: 14px;">对于因电信系统或互联网网络故障、计算机故障或病毒、信息损坏或丢失、计算机系统问题或其它任何不可抗力原因而产生损失，服务提供方不承担任何责任。<br></p>
<p style="font-size: 14px;">用户违反本条款并对服务提供方造成损害的，服务提供方有权采取包括但不限于停止提供服务、限制使用、法律追究等措施。<br></p>
<p style="font-size: 14px;">如因系统维护或升级的需要而必须暂停网络服务，服务提供方将尽可能事先发布通告。<br></p>
<p style="font-size: 14px;">5.条款修改<br></p>
<p style="font-size: 14px;">服务提供方有权随时修改本条款的相关内容。如果用户不同意服务提供方对本条款相关内容所做的修改，有权停止使用本产品。如果用户继续使用本产品，则视为接受本条款相关内容所做的修改。本条款的更新修改及最终解释权归服务提供方所有。<br></p>
<!-- 	<input type="button" value="fengxin" onclick="colseAgreeMentjsp();"> -->
	<input type="button" value="阅读完成" onclick="colseAgreeMentjsp();" style="width: 240px;height: 30px;color:#FFFFFF;	border:1px solid #00a600;background:linear-gradient(to bottom, #00a600 0%,#008a00 100%); margin-left: 400px;">
			
				
			</form>
		</div>
		<div class="clear"></div>
		</article>
	</div>
	<%@include file="/mini_end.jsp"%>
</body>
</html>