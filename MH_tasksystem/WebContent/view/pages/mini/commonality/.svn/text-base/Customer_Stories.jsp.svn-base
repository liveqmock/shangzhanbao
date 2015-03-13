<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/baseHead.jsp"%>
    <%@include file="/mini_top.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商站宝</title>
<link href="${root }/view/css/frame.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/UserCenter.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/css.css" />
<link rel="stylesheet" type="text/css" href="${root}/view/css/mini/grid.css" />
</head>
<script src="${root}/view/js/minipage/common/jscharts.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidator-4.1.1.js"></script>
<script type="text/javascript" src="${root}/view/js/common/formValidatorRegex.js"></script>
<script type="text/javascript" src="${root}/view/js/common/validate.js"></script>
<script type="text/javascript" src="${root}/view/js/common/bootstrap-tooltip.js"></script>
<script type="text/javascript" src="${root}/view/js/register.js"></script>
</head>
<body>

<div class="content">
  <article class="Stories_bor">
    <figure><img src="${root}/view/images/index/img_people.png" class="Stories_img1"></figure>
    <article>
      <p>我的有机蔬菜不像普通网上销售，不适合在线交易。用MiniPage，我根据产品特点，选择了让用户在线咨询。现在按月订购的业务都是从这里来的我的有机蔬菜不像普通网上销售，不适合在线交易。用MiniPage，我根据产品特点，选择了让用户在线咨询。现在按月订购的业务都是从这里来的…… </p>
      <hgroup class="Stories_hguoup">
        <h1>毛豆豆有机生活网总裁</h1>
        <h2>夏燕兵<span>女士</span></h2>
      </hgroup>
    </article>
    <figure><a href="#"><img src="${root}/view/images/index/img_ban.png" class="Stories_img2"></a></figure>
  </article>
  <article class="CustomerCase">
    <h1>更多客户案例</h1>
    <figure><a href="#"><img src="${root}/view/images/index/img_case.png" class="Case_img"></a></figure>
  </article>
  <form id="myform" class="StoriesSearch" action="" method="post" onsubmit="return checkSub($(this))">
        <input name="userData.userType" type="hidden" class="input_bor" size="30" value="2"/>
        <input name="userData.userState" type="hidden" class="input_bor" size="30" value="1"/>
        <input name="userData.addType" type="hidden" class="input_bor" size="30" value="1"/>
      	<input id="loginMail" type="text" placeholder="请输入您的可用邮箱或手机号" size="40" max="50" min="6" notnull="请填写用户名" emailOrTel="邮箱或手机格式不正确" ajax="${root }/user/key/ajaxCheckUser,userData.loginMail,0,您输入的用户名已被占用" />
      	<input type="password" id="password" placeholder="请输入8位以上密码，包含特殊字符" size="40" min="8" notnull="请填写密码" notnum="不能是纯数字"  max="16" />
      	<input type="button" onclick="reg2(this)" class="btn_420" value="免费注册">
    </form>
</div>
<div class="clear"></div>
<div class="footer"></div>
</body>
</html>
