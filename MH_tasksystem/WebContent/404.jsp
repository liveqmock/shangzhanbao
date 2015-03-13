<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>404</title>
<style type="text/css">
	body{
		background-image:url(/img/bg_404.jpg);
	}
	.maindiv{
		position:absolute; left:100px; top:130px;
	}
	.btn{
		width:200px; height:40px; background-image:url(/img/rectangle_u4_404.png); font-size:13px; color:#FFFFFF; border: none; cursor:pointer;
	}
	.title{
		font-size:28px; color:#0099CC;
	}
	.content{
		font-size:20px; color:#0099CC;
	}
</style>
<script type="text/javascript">
	function backIndexJsp(){
		location.href="/frame/key/toIndex";
	}
</script>
</head>
<body>
<div class="maindiv">
  <p class="title">404！</p>
  <p class="content">呃... 你访问的页面不存在或者链接地址错误</p>
  <p>
    <input type="button" class="btn" value="返回商站宝" onclick="backIndexJsp();"/>
  </p>
</div>
</body>
</html>
