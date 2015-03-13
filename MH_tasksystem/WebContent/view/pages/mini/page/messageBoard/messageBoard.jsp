<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/baseHead.jsp"%>
<html>
<head>
<style type="text/css">
body {
	margin:0;
	background: #626879;
}

.one_fifth {
	width: 100%;
	display: block;
}

.one_fifth p {
	line-height: 25px;
	font-size: 12px;
}

#footer {
	width: auto;
	background: #626879;
	border-top: 5px solid #bfd6e4;
	margin-top: 100px
}
.container{
width: 100%;
}
.one_fourth {
	width: 48%;
	margin-bottom: 4%;
	margin: 0 auto;
}

.Textfont {
	font-size: 12px;
	color: #fff;
	line-height: 25px;
	margin: 10px 0 0 0;
}

.one_fourth h4 {
	font-size: 1.2em;
	color: #bfd6e4;
	margin-bottom: 10px;
	width: 48%;
	margin: 0 auto;
	text-align: center;
}

placeholder {
	color: #ddd;
	font-size: 12px;
}

.contactForm {
	color: #414550
}

.formstyletwo {
	color: #FFF;
	font-size: 15px;
	width: 100px;
	height: 32px;
	float: left;
	line-height: 30px;
	text-align: center;
	background-color: #7c859f;
	margin: 10px 0 0 0;
	border: 0;
}

.formstyletwo:hover {
	cursor: pointer;
	background: #373e50;
}

.formstyle {
	border: 1px solid #ccc;
	color: #444;
	font-family: Lato, Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 100%;
	background-color: rgba(255, 255, 255, 1);
	background: #FFF;
	margin-bottom: 15px;
	opacity: 0.9;
	padding: 8px;
	-webkit-transition: all 0.4s ease-in-out;
	-moz-transition: all 0.4s ease-in-out;
	-o-transition: all 0.4s ease-in-out;
	-ms-transition: all 0.4s ease-in-out;
	transition: all 0.4s ease-in-out;
	border-radius: 2px;
	margin: 8px 0
}

textarea {
	border: 1px solid #ccc;
	color: #444;
	font-family: Lato, Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 20px;
	width: 90%;
	height: 120px;
	background-color: rgba(255, 255, 255, 1);
	background: #FFF;
	margin-bottom: 15px;
	border-radius: 2px;
	padding: 3px;
	opacity: 0.9;
	-webkit-transition: all 0.4s ease-in-out;
	-moz-transition: all 0.4s ease-in-out;
	-o-transition: all 0.4s ease-in-out;
	-ms-transition: all 0.4s ease-in-out;
	transition: all 0.4s ease-in-out;
}
/***联系我们*******************/
.one_seven {
	margin-top: 4%;
	width: 46%;
	margin-bottom: 4%;
	margin-left: 2%;
}

.one_seven h4 {
	font-size: 1.2em;
	color: #bfd6e4;
	margin-bottom: 10px;
}

.one_seven p {
	color: #f2f2f2;
	line-height: 25px;
	font-size: 12px;
}

.one_seven a {
	color: #f2f2f2;
	text-decoration: underline;
}

.one_seven a:hover {
	color: #f2f2f2;
	text-decoration: underline;
}
.clearfix:after {
	clear:both;
	content:' ';
	display:block;
	font-size:0;
	line-height:0;
	visibility:hidden;
	width:0;
	height:0;
}
@media (max-width: 480px){
body {
	margin: 0 auto;
}
.one_fourth {
	width: 95%;
	}
.container{
	width: 95%;
	margin: 0 auto;
}
.formstyletwo{
	float: none;
	margin-bottom: 50px;
	width: 100%;
}
.footerForPageLine{
margin-top: 10px;
}
}
</style>
<script type="text/javascript">
	//提交留言板信息
	function subMessageboard() {
		var boardName = trim($("#name").val());
		var boardEmail = trim($("#email").val());
		var boardDemand = trim($("#demand").val());
		//判断表单数据合法性
		//if(boardName ==""){
		//	alert("请填写姓名！");
		//	$("#name").focus();
		//	return;
		//} 
		if(checkEmail(boardEmail)){
			alert("请填写合法的email！");
			$("#email").focus();
			return;
		} 
		if(boardDemand ==""){
			alert("请填写详细需求！");
			$("#demand").focus();
			return;
		}
		ajaxSubmit(document.getElementById("pageMessageboardForm"), function(
				data) {
			alert("留言成功！");
			$("#name").val("");
			$("#email").val("");
			$("#demand").val("");
		});
	};

	//将form转为AJAX提交
	function ajaxSubmit(frm, fn) {
		var dataPara = getFormJson(frm);
		$.ajax({
			url : frm.action,
			type : frm.method,
			data : dataPara,
			success : fn
		});
	}

	/**
	 * 将form中的值转换为键值对。
	 */
	function getFormJson(frm) {
		var o = {};
		var a = $(frm).serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});

		return o;
	}
	/**
	 * 验证email是否合法
	 */
	function checkEmail(email){
		if(email==""){
			return true;
		}
	    var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    if (!filter.test(email)) {
	        return true;
	    }
	    return false;
	}
	//去除空格的方法
	function trim(str){   
	    str = str.replace(/^(\s|\u00A0)+/,'');   
	    for(var i=str.length-1; i>=0; i--){   
	        if(/\S/.test(str.charAt(i))){   
	            str = str.substring(0, i+1);   
	            break;   
	        }   
	    }   
	    return str;   
	}
</script>
</head>
<body>
	<div class="container"> 
		<!--留言板-->
		<div class="one_fourth">
			<h4>留言板</h4>
			<form action="${root }/page_messageboard/key/addPageMessageboard"
				id="pageMessageboardForm" method="post" class="contactForm">
				<input type="text" name="pageMessageboardData.pageid"
					value="${pageid }" style="display: none;" /> <input type="text" class="formstyle"
					id="name" name="pageMessageboardData.name" value="" placeholder="填写姓名" /><br />
				<input type="text" class="formstyle" id="email" name="pageMessageboardData.email"
					placeholder="电子邮箱" value="" /><br />
				<textarea name="pageMessageboardData.demand" id="demand"
					class="formstyle" placeholder="填写详细需求"></textarea>
				<br /> <input class="formstyletwo" type="button"
					onclick="subMessageboard()" value="发布" />
			</form>
		</div>
	</div>
	
	

	
	
	
	 
</body>
</html>