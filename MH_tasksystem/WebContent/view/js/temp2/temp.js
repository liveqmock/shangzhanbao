document.oncontextmenu = function() {//屏蔽鼠标右键 
	return false;
}
document.onkeydown = function() { 
  	if (event.ctrlKey && event.keyCode==67) { //屏蔽Ctrl + C 
	  	 return false;
	};
  	if (event.ctrlKey && event.keyCode==86) {//屏蔽 Ctrl+V
  		return false;
  	};   
} 
$(function(){
	//替换page名称
	if (window.location.pathname.indexOf("/pagehtml/") >= 0 && window.location.pathname.indexOf(".html") > 0) {
		var url = $("#objectRoot").val() + "/page/key/searchByPageInfoExtraData?pageInfoExtraData.domain=" + window.location.pathname.substring(window.location.pathname.lastIndexOf("/") + 1);
		$.ajax({
			type : 'POST',
			cache : false,
			url : url,
			dataType : "text",
			success : function(data) {
				if(data!="1"){
				 var json = eval('(' + data+ ')'); 
				document.title = json.name.trim();
				$("body").append("<input type=\"hidden\" id=\"pageId\" value='"+json.id.trim()+"' />");
				$("body").append("<input type=\"hidden\" id=\"userId\" value='"+json.userId.trim()+"' />");
				}
			}
		});
	}
	
	indexRoot = $("#objectRoot").val();
	//为所有编辑按钮绑定编辑事件
	$(document).on("click",".showline_Img",function(){
		toedit();
	});
	
	// 为所有class名称含有line的绑定离开事件
	$(document).on("blur","div[class^='line_'],div[class*=' line_']",function(){
		$(this).children("span").first().on("blur",function(){
				//是商品信息修改  保存数据
				  if($(this).attr("data")=="ajax"){
					//获取页面pageid
					var pageId = $("#id", parent.frames['frame_left'].document).val();// pageId
					  var name=$(this).attr("name");
					  var value=encodeURI(encodeURI($(this).html()));   
					  var  url=indexRoot+"/goods_info/key/addGoodsInfo?pageGoodsInfoData.pageId="+pageId+"&goodsInfoData.id="+$("#goodsInfoDataId").val()+"&"+name+"="+value;
					  $.ajax({
							type:"POST",
							object:$(this),
							url:url,
							dataType : 'text',// 返回值类型 一般设置为json
							success : function(data) {
								 if(data!="1"){
									 var json=eval("(" + data + ")");
									 $("#goodsInfoDataId").val(json.goodsInfoId);  //商品id
									 this.object.removeAttr("contenteditable");
									 this.object.css({outline:""});
								}
							}
						});
				  }else{
					  $(this).removeAttr("contenteditable")
		 				.css({outline:"", overflow: ""})
		 				.scrollTop(0);
				  }
 		});
	})
	
	//浏览器宽度低于538时，改变留言板的样式
	var pc_flag=document.body.offsetWidth;
	  if(pc_flag<538){
		$("#messageBoard").css("height","360px");
	 }

	/**
	 * 初始化隐藏添加组件的按钮
	 */
	$("[copy=copyComp]").each(function(){
		$(this).hide();
	});
	
	//当添加按钮隐藏  说明页面不是属于编辑状态 ，规格只切换价格  不编辑规格
	var display=$("#newaddGoodsconfig").is(":hidden");
	if(display==true){
		$(".goodsRight").hide();
	}
	
	
	// 组件排序
	esc = 0;
	
	// 模板页面form表单的内容
	content = "";
	
	
	/**
	 * 重置
	 */
	$(".clearComp").live("click",function(){
		var _navigateID= $(this).closest("div").find("[id$='_navigate']").attr('id');
		if(_navigateID){
			//如果组件包含导航则去掉！
			$("#"+_navigateID).closest("li").empty();
		}
		var id =  $(this).parent().attr("id");
		var selectComp = $(this).parent().find(".selectComp").detach();
		var clearComp = $(this).parent().find(".clearComp").detach();
		$("#"+id).empty();
		$("#"+id).append("<button class='selectComp'>添加</button>");
		$("#"+id).append(clearComp);
		$("#"+id).css({"text-align":"center"}); 
		$("#"+id).css({"padding-top":"200px"});
		$(".addComponent3").attr('disabled',"true");
	});
	
	/**
	 * 提交模板页面
	 */
	$(".submitTemp").live("click",function(){
		   $(this).unbind();
		   $("body").remove("#div_compent");
		   $("body").remove(".selectComp");
		   $("body").remove(".caozuo");
		   $("body").remove(".clearComp");
		   $(".clearComp").detach();
		   $(".selectComp").detach();
		   $(".addComponent3").detach();
		   $(".look").detach();
		   content = $("#addTemp").detach();
		   var conten = document.documentElement.outerHTML;
		   $("body").append(content);
		   var form = $("#templateComp");// 获取表单
		   form.append("<textarea type='hidden' name='templateData.stringContent'>"+conten+"</textarea>");
		   $("#templateComp").ajaxSubmit({
			url : indexRoot + "/back_temp_manage/key/ajaxAddTemp",
			type : "post",
			dataType : "text",
			success : function(data) {
				if(data == "success"){
					alert("模板创建成功");
					window.location.href = indexRoot + "/temp_manage/key/searchAllToAdmin?templateData.status=1";
				}else{
					alert("模板创建失败");
					window.location.href = indexRoot + "/temp_manage/key/searchAllToAdmin?templateData.status=1";
				}
			}
		});
	});
	
	/**
	 * 抓取定义好的模板页面
	 */
	$(".look").live("click",function(){
		   $("#addTemp").show();
	});
	
	/**
	 * 关闭表单提交的页面
	 */
	$(".exis").live("click",function(){
		   $("#addTemp").hide();
	});
	
	/**
	 * 添加组件集架构
	 */
	$(".addComponent3").live("click",function(){
		var wraperNum = $("body").find("[class^='wraper']").length;
		var j = $("body").find("div").length;
		//一个wraper为导航，一个wraper未banner组件，除了这两个组件都需要添加导航锚点。
		if(wraperNum>=2){
			if(confirm("是否为组件添加导航锚点？")){
				var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=6";
				$.ajax({
					type : 'POST',
					url : url,
					dataType : "text",
					success : function(data) {
						 $("#div_compent").empty();
						 data = eval("("+data+")");
						 $("#div_compent").append("<div id='dlg' class='modal modal-mslmgmt hide' style='width: 400px; height: auto;'>" +
									"<div class='modal-header modal-header-mslmgmt'><a class='close' onclick='javascript:closedlg()' data-dismiss='modal'>" +
									"<i class='icon-remove'>关闭</i></a></div><div><form action='' method='get'><table id='userComponent' class='table'><tr><td></td><td>组件编号</td>" +
									"<td>组件名称</td><td>组件预览图</td></tr></table><a href='###' onclick='javascript:addMaoDianComp();' class = 'btn'>确定</a></form></div></div>");
						 $.each(data.list,function(i,item){
							 $("#userComponent").append("<tr><td><input type='radio' name='radioComp' data4='"+item.id+"' data3='"+item.multable+"' data2='"+item.navId+"' data='"+item.cssId+"' value='"+item.id+"'/></td><td>"+item.sn+"</td><td>"+item.name+"</td><td></td></tr>");
						 });
						 $("#dlg").show();
					}
				});
			}else{
				$(this).closest("div").before("<div class='wraper' dataWraperNum='"+wraperNum+"'><div id='div"+(j+1)+"' style='text-align: center;padding-top:200px'><button class='selectComp'>添加组件</button><button class='clearComp'>重置</button></div></div>");
			}
		}else{
			$(this).closest("div").before("<div class='wraper' dataWraperNum='"+wraperNum+"'><div id='div"+(j+1)+"' style='text-align: center;padding-top:200px'><button class='selectComp'>添加组件</button><button class='clearComp'>重置</button></div></div>");
		}
		$(".addComponent3").attr('disabled',"true");
	})
	
	/**
	 * 选择组件
	 */
	$(".selectComp").live("click",function(){
		var csstype = $("#cssType").val();
		alert($(this).parent().parent().attr("dataWraperNum"));
		if($(this).parent().parent().attr("dataWraperNum")=='0'){
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=2&componentData.cssType="+csstype;
		}else if($(this).parent().parent().attr("dataWraperNum")=='1'){
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=3&componentData.cssType="+csstype;
		}else{
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=0&componentData.cssType="+csstype;
		}
		//var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentBycssType?componentData.type=2&componentData.cssType="+csstype;
		var id =  $(this).parent().attr("id");
		$.ajax({
			type : 'POST',
			url : url,
			id : id,
			dataType : "text",
			success : function(data) {
				var id2 = this.id;
				 $("#div_compent").empty();
					data = eval("("+data+")");
				 $("#div_compent").append("<div id='dlg' class='modal modal-mslmgmt hide' style='width: 400px; '>" +
							"<div class='modal-header modal-header-mslmgmt'><a class='close' onclick='javascript:closedlg()' data-dismiss='modal'>" +
							"<i class='icon-remove'>关闭</i></a></div><div><form action='' method='get'><table id='userComponent' class='table'><tr><td></td><td>组件编号</td>" +
							"<td>组件名称</td><td>组件预览图</td></tr></table><a href='###' onclick='javascript:addComp("+id2+")' class = 'btn'>确定</a></form></div></div>");
				 $.each(data.list,function(i,item){
					 $("#userComponent").append("<tr><td><input type='radio' name='radioComp' data4='"+item.id+"' data3='"+item.multable+"' data2='"+item.navId+"' data='"+item.cssId+"' value='"+item.id+"'/></td><td>"+item.sn+"</td><td>"+item.name+"</td><td></td></tr>");
				 });
				 $("#dlg").show();
			}
		});
	});
	
	
	/**
	 * 给某些元素添加省略样式，移动到元素上时弹出div
	 */
	$(".ellipsis").each(function(){
		$(this).hover(function(e){
			overDiv(this,"fortest",e);
		},function(e){
			outDiv("fortest",e);
		});
	});
	
	
	/**
	 * 商品数量手动修改事件
	 */
	$("#amount").blur(function(){
		if($(this).val()>=100){
			$(this).val("99");
		}
		if($(this).val()<=0){
			$(this).val("1");
		}
		if($(this).val()==""){
			$(this).val("1");
		}
		var patrn =  /^[0-9]*[1-9][0-9]*$/;
			if (!patrn.exec($(this).val())){
				$(this).val("1");
			}
	});
	if( parent.frames['frame_top']!=undefined){
		//顶部按钮可用
		$("[class=Btn_1]", parent.frames['frame_top'].document).each(function(){
			$(this).removeAttr("disabled");
		});
		$(".zancun", parent.frames['frame_top'].document).removeAttr("disabled");
		$(".turnFirstHtml", parent.frames['frame_top'].document).removeAttr("disabled");
	}
	
});


/**
 * 设置锚点
 * @param id
 */
function getMaodian(id){
    var scroll_offset = $("#" + id).offset();
    $("body").stop();
    $("body").animate({
      scrollTop : scroll_offset.top - 135
    }, 1000);
}

/**
 * 关闭组件div
 */
function closedlg(){
	$("#dlg").hide();
}
/**
 * 如果组件需要增加导航锚点，则添加导航锚点
 */
function addMaoDianComp(){
	var wraperNum = $("body").find("[class='wraper']").length;
	var id = $("input[type='radio']:checked").val();
	var j = $("body").find("div").length;
	//页面所有的锚点数
	var navAnchorNum =$("body").find("[id^='navAnchor']").length;
	var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentById?componentData.id="+id;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			var navAnchorID = "navAnchor"+navAnchorNum;
			data = data.replace("<a><h2>","<a id='"+navAnchorID+"'><h2>");
			$(".addComponent3").closest("div").before("<div class='wraper' dataWraperNum='"+wraperNum+"'>"+data+"<div id='div"+(j+1)+"' style='text-align: center;padding-top:200px'><button class='selectComp'>添加</button><button class='clearComp'>重置</button></div></div>");
			$("body").find("[class='navigate']").append("<li><a href=\"###\" onClick=\"getMaodian('"+navAnchorID+"')\"><lable id=\"first_navigate\">导航锚点</lable></a></li>");
		}
	});
	$("#dlg").hide();
}

/**
 * 添加组件
 */
function addComp(obj){
	var id = $("input[type='radio']:checked").val();
	// 样式ID
	var cssId  = $("input[type='radio']:checked").attr("data");
	// 锚点ID
	var navId  = $("input[type='radio']:checked").attr("data2");
	// 是否可重用
	var multable  = $("input[type='radio']:checked").attr("data3");
	// 组件ID
	var compId = $("input[type='radio']:checked").attr("data4");
	if(id == null || id == ""){
		alert("请选择组件");
		return;
	}
	var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentById?componentData.id="+id;
	$.ajax({
		type : 'POST',
		url : url,
		id : id,
		compId : compId,
		multable :multable,
		cssid : cssId,
		navid : navId,
		obj : $(obj),
		dataType : "text",
		success : function(data) {
			
			$("#templateComp").append("<input type='hidden' name='templateData.templateComponentDatas["+esc+"].componentid' value='"+this.id+"'/>" +
					"<input type='hidden' name='templateData.templateComponentDatas["+esc+"].taxis' value='"+esc+"'/>");
			esc = esc+1;
			this.obj.attr("style","");
			if(this.cssid!=null && this.cssid!=""){
				this.obj.closest("div").attr("id",this.cssid);
			}
			// 拿到组件id
			var id3 = this.id;
			this.obj.find(".selectComp").remove();
			this.obj.find(".clearComp").remove();
			if(this.navid!=null && this.navid!=""){
				$("#nav").find("ul").append("<li class='"+this.navid+"'><a href='###'" +
						"onclick=\"getMaodian('"+this.navid+"')\"><lable id='' class='navName'>导航名称<lable</a></li>");
			}
			this.obj.append(data);
			if(this.multable=="N"){
				this.obj.append("<button class='clearComp'>重置</button>");
			}else if(this.multable=="Y"){
				this.obj.append("<button copy='copyComp' class='Btn_Td' onclick=\"copyComp('"+this.compId+"',this)\">添加</button><button class='clearComp'>重置</button>");
			}
			$("#div_compent").empty();
			$("#dlg").hide();
			this.obj.find("img").attr("src",indexRoot+"/view/model/images/zanwu.jpg");
			var product_id = this.obj.find(".update");  
			$.each(product_id,function(n,goods) {
				// 判断添加的组件的div内是否存在class属性名称为component的input控件是否存在
			    var id2 = $(goods).find(".component").val();  
			    if(id2 == "" || id2 == null){
			    	$(goods).append("<input type='hidden' id class='component' name='' value='"+id3+"'/>");
			    }
			});
			var beginId="";
			var ids = this.obj.closest('div').find("[id]");
			for ( var int = 0; int < ids.length; int++) {
				var ssId = ($(ids[int]).attr("id"));
				if(ssId.indexOf("_")){
					var arr = new Array();
					arr = ssId.split("_");
					beginId=arr[0];
				}
			}
			$("#nav").find("ul").find("."+this.navid).find(".navName").attr("id",beginId+"_navigate");
			this.obj.closest('div').find("h2").find("lable").attr("id",beginId+"_navigate");
			addUpAndDown(this.obj.closest(".wraper"));
		}
	});
	$(".addComponent3").removeAttr("disabled");
	
}


function copyComp(compId,com){
	var num = $(com).prev().parent().find(".update").length;
	var obj = null;
	if(num==0){
		obj = $(com).prev(".update").clone(true);
	}else if(num==1){
		obj = $(com).prev().parent().find(".update:eq(0)").clone(true);
	}else{
		if(num%2==0){
			obj = $(com).prev().parent().find(".update:eq(0)").clone(true);
		}else{
			obj = $(com).prev().parent().find(".update:eq(1)").clone(true);
		}
	}
	if(compId==""||compId==null){
		if(num%2==0){
			compId=$(com).prev().parent().find(".update:eq(0)").find("[type='hidden']").attr("value");
		}else{
			compId=$(com).prev().parent().find(".update:eq(1)").find("[type='hidden']").attr("value");
		}
	}
	var content = getOuterHtml(obj);
	var url = indexRoot + "/back_temp_manage/key/ajaxSearchUseComponentById?componentData.id="+compId;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			if(num==0){
				$(com).prev(".update").after(data);
				addLine($(com).closest(".wraper"));
			}else{
				$(com).prev().parent().find(".update:last").after(data);
				addLine($(com).closest(".wraper"));
			}
			if($(parent.frames['frame_left'].document)){
				var textateaId = data.substring(data.indexOf("reason_title"),data.indexOf("reason_title")+13+12);
				var onfocusinText = "jumpAnchor(\""+textateaId+"\")"
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("textarea").attr("id","step_"+textateaId);
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("textarea").attr("onfocusin",onfocusinText);
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("a").attr("id","delete_"+textateaId);
				$("#step_"+textateaId,parent.frames['frame_left'].document).focus()
			}
		}});
}

/**
 * 获取元素本身html
 * 
 */
function getOuterHtml(obj) {
    var box = $('<div></div>');
    for (var i = 0; i < obj.length; i ++) {
        box.append($(obj[i]).clone());
    }
    return box.html();
}


/*菜单显示隐藏*/
var nav = (function(){
	return;
	var menu, moveSize = 8;//手指滑动距离
	window.addEventListener("load",function(){
		menu = document.querySelector("#daohang .top");
		document.addEventListener("touchstart",function(e){
			var ev = e || window.event;
			var y = ev.touches[0].clientY;
			function move(e){
				var ev = e || window.event;
				var ny = ev.touches[0].clientY;
				if(ny < y - moveSize)
					hide();
				else if(ny > y + moveSize && y < 50)
					show();
			}

			function end(e){
				document.removeEventListener("touchmove",move,false);
				document.removeEventListener("touchend",end,false);
			}
			document.addEventListener("touchmove",move,false);
			document.addEventListener("touchend",end,false);
		},false);
	},false);

	function show(){
		//jquery animate
		//$(menu).stop(true);
		//$(menu).animate({top: "0px"});
		//html5 animate
		menu.style.top = "0px";
	}
	function hide(){
		//$(menu).stop(true);
		//$(menu).animate({top:(-menu.offsetHeight) + "px"});
		menu.style.top =  (-menu.offsetHeight) + "px";
	}
	return {
		hide: hide,
		show: show
	}
})();


/*菜单显示隐藏*/
var nav = (function(){
	var top, btn, daohang, moveSize = 8;//手指滑动距离
	window.addEventListener("load",function(){
		top = document.querySelector("#daohang .top");
		btn = document.querySelector("#menu_btn");
		_nav = document.querySelector("#daohang .nav");
		btn.addEventListener("click",function(){
			top.classList.contains("show") ? hide() : show();
		},false);
		_nav.addEventListener("touchstart",stopAndDef,false);
		_nav.addEventListener("mousedown",stopAndDef,false);
	},false);

	var time;
	function show(){
		clearTimeout(time);
		top.classList.add("show");
		top.addEventListener("touchstart", stopHide, false);
		top.addEventListener("mousedown", stopHide, false);
		window.addEventListener("scroll",hide,false);
	}
	function hide(){
		top.style.height = "100%";
		time = setTimeout(function(){
			top.removeAttribute("style");
		},500);//动画时间
		top.classList.remove("show");
		top.removeEventListener("touchstart", stopHide, false);
		top.removeEventListener("mousedown", stopHide, false);
		window.removeEventListener("scroll",hide,false);
	}

	function stopHide(e){
		hide();
		var ev = e || window.event;
		ev.stopPropagation();
		ev.preventDefault();
	}

	function stopScroll(){
		return false;
	}
	
	function stopAndDef(e){
		var ev = e || window.event;
		ev.stopPropagation();
		/*ev.preventDefault();*/
	}
	
	function stop(e){
		var ev = e || window.event;
		ev.stopPropagation();
	}
	return {
		hide: hide,
		show: show
	}
})();

/**
 * 鼠标移到元素事件
 **/
 function overDiv(divdoc,divid,e){
  	var div = document.getElementById(divid+"");
		if(divdoc.value == ''){
            div.style.display = 'none';
        }else{
			var leftpx = mousePos(e).x;
			var toppx = divdoc.offsetTop;
			if(getWidth()<mousePos(e).x+100){
				leftpx = mousePos(e).x - 100;
			}
			if(getHeight()<divdoc.offsetTop+100){
				toppx = divdoc.offsetTop-100;
			}
			if(div==null){
				return;
			}
			div.innerText = divdoc.innerText;
            div.style.width = '40%';
			div.style.background = '#FFFFFF';
            div.style.top = toppx+25+'px';
            div.style.left =leftpx+5+'px';
            div.style.display = 'block';
        }
 }
/**
 * 鼠标移出元素事件
 **/
 function outDiv(divid,e){
        var div = document.getElementById(divid+"");
		div.innerText = "";
        div.style.display = 'none';
 }
/**
 * 获取鼠标坐标事件
 **/
function mousePos(e){
	var x,y;
	var e = e||window.event;
	return {
		x:e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft,
		y:e.clientY+document.body.scrollTop+document.documentElement.scrollTop
	};
};

/**
 * 获取窗口宽度
 */
function getWidth() {
	var winWidth = 0;
	// 获取窗口宽度
	if (window.innerWidth) {
		winWidth = window.innerWidth;
	} else if ((document.body) && (document.body.clientWidth)) {
		winWidth = document.body.clientWidth;
	}
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientWidth) {
		winWidth = document.documentElement.clientWidth;
	}
	return winWidth;
}
/**
 * 获取窗口高度
 */
function getHeight() {
	var winHeight = 0;
	// 获取窗口高度
	if (window.innerHeight) {
		winHeight = window.innerHeight;
	} else if ((document.body) && (document.body.clientHeight)) {
		winHeight = document.body.clientHeight;
	}
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientHeight) {
		winHeight = document.documentElement.clientHeight;
	}
	return winHeight;
}
	
		/**
		 * 给页面动态添加蒙版 删除蒙板 添加编辑虚线框 移除编辑虚线框
		 */
		function addCoverPlate(num) {
			cc($('#daohang'));
			$('.wraper').each(function() {
				if(num == 1){ // 表示为创建page第一步
					if($(this).find('[id^=banner_]').length==0){
						if($(this).find(".createCoverPlate").length == 0){
							cc($(this));
						}
					}else{
						$(this).find(".createCoverPlate").remove();// 移除遮挡层
						removeLine($(this));
						addLine($(this));// 添加虚线边框和图标
					}
				}else if(num == 2){// 表示为创建page第二步
					if($(this).find('[id^=reason_]').length==0){
						// 动态添加遮挡层
						if($(this).find(".createCoverPlate").length == 0){
							cc($(this));
						}
						removeLine($(this));// 移除虚线边框和图标
					}else{
						$(this).find(".createCoverPlate").remove();// 移除遮挡层
						var scroll_offset = $(this).offset();
					    $("body,html").stop();
					    $("body,html").animate({
					      scrollTop : scroll_offset.top - 125
					    }, 1000);
					    removeLine($(this));
						addLine($(this));// 添加虚线边框和图标
						$(this).find("[copy=copyComp]").show();
					}
				}else if(num ==3){// 表示为创建page第三步
					if($(this).find('[id^=reason_]').length==0){
						// 动态添加遮挡层
						if($(this).find(".createCoverPlate").length == 0){
							cc($(this));
						}
						removeLine($(this));// 移除虚线边框和图标
					}else{
						$(this).find(".createCoverPlate").remove();// 移除遮挡层
					    removeLine($(this));
						addLine($(this));// 添加虚线边框和图标
						$(this).find("[copy=copyComp]").show();
					}
				}else if(num ==4){// 表示为编辑page详情
					removeLine($(this));
					$(this).find(".createCoverPlate").remove();// 移除遮挡层
					addLine($(this));// 添加虚线边框和图标
					$('#daohang').find(".createCoverPlate").remove();
					$("[copy=copyComp]").each(function(){
						$(this).show();
					});
				}
			});
		}
		
		// 为组件域动态添加蒙板
		var cc = function($this) {
			if($($this).closest(".wraper").find("#daohang").length == 0){
				$($this).css({
					position : 'relative'
				});
			}
			var toTop = $($this).offset().top;
			if($($this).parents("#daohang").css("position") == "fixed"){
				toTop = $($this).css("margin-top");
			}
			var bg;
			bg = $('<div class="createCoverPlate"></div>').css({
				position : 'absolute',
				top : 0,
				backgroundColor : 'rgba(0,0,70,.1)',
				height : '100%',
				width : '100%',
				zindex : '999',
				webkitTransition : 'all 1s ease',
			});
			if($this.find(".createCoverPlate").length == 0){
				$this.append(bg);
			}
		};
		
		// 点击编辑图标产生的事件
		function toedit(){
			if($(this).closest("div").children("span").length > 0){
				var $span = $(this).closest("div").children("span").first();
				var contenteditable = $span.attr("contenteditable");
				$span.attr("contenteditable","true");
				$span.css({outline:"2px solid #A9A9A9", overflow: 'auto'});
				$span.focus();
			}else if($(this).closest("div").find("img").length > 1){
				var click_btu = $("<input>").attr("type", "hidden").attr("id",$(this).closest("div").find("img").attr("id")+"_click");
				$(this).after(click_btu);
				$(click_btu).click(cutBox($(click_btu).attr("id"),$(this).closest("div").find("img").attr("id")));
				$(click_btu).click();
				$(click_btu).remove();
			}else if($(this).closest("div").children("span").length == 0){ //当时修改商品规格信息时
				if($(this).closest("div").attr("data")=="goodsInfo"){
					editGoods();
					
				}
			}
		}
		
		// 为banner添加虚线编辑框
		var addLine = function(thisinfo){
			$(thisinfo).find("div[class^='line_'],div[class*=' line_']").each(function(){
				$(this).css({
					border : '2px dashed rgb(74,104,131)',
					position : 'relative'
				});
				var width = $(this).closest("div").width()
				var height = $(this).closest("div").height()
				var lineData = $(this).attr("line-data");
				var toTop = $(this).offset().top;
				var banner_vis = $('<div class="showline_banner"></div>').text(lineData).css({
					position : 'absolute',
					top : -2,
					left : -22,
					width : '20px',
					zindex : '10',
					backgroundColor : 'rgb(74,104,131)',
					fontSize: '13px',
					color: '#FFFFFF',
					textAlign: 'center',
					lineHeight:'25px'
				});
				var btn_edit = $('<img class="showline_Img" src="/view/images/edit/edit.jpg"></img>').css({
					position : 'absolute',
					top : 0,
					right : 0,
					height: '25px',
					width : '22px',
					zindex : '10',
					cursor: 'pointer',
					padding : '0px',
					transition: "all .5s"
				}).attr({
					title: '编辑'
				}).on({
					click: toedit
				});
				if($(this).find(".showline_banner").length==0){
					$(this).append(banner_vis);
				}
				if($(this).find(".showline_Img").length==0){
					$(this).append(btn_edit);
				}
			});
			addUpAndDown($(thisinfo));
		}
		
		// 移除虚线框
		var removeLine = function(thisinfo){
			$(thisinfo).find("div[class^='line_'],div[class*=' line_']").each(function(){
				$(this).find(".showline_Img").remove();
				$(this).find(".showline_banner").remove();
				$(this).css({
					border : '0px'
				});
			});
		}
		
		// 添加组件上移，下移，删除的虚线边框
		var addUpAndDown = function(thisinfo){
			$(thisinfo).find(".up_update").remove();
			$(thisinfo).find(".down_update").remove();
			$(thisinfo).find(".del_update").remove();
			$(thisinfo).find("div[class*=' update']").each(function(){
				if($(thisinfo).find('[id^="banner_"]').length == 0){
					$(this).css({
						border : '2px solid rgb(74,104,131)',
						position : 'relative',
						marginTop: '20px',
					});
					// 上移按钮
					btn_up = $('<img class="up_update" src="/view/images/edit/up.jpg"></img>').css({
						position : 'absolute',
						top : '30px',
						right : '-20px',
						width : '15px',
						height: '20px',
						zindex : '10',
						cursor: 'pointer'
					}).attr({
						title: '上移'
					}).on({
						click: upComponent
					});
					// 下移按钮
					btn_down = $('<img class="down_update" src="/view/images/edit/down.jpg"></img>').css({
						position : 'absolute',
						top : 0,
						right : '-20px',
						width : '15px',
						height: '20px',
						zindex : '10',
						cursor: 'pointer'
					}).attr({
						title: '下移'
					}).on({
						click: downComponent
					});
					// 删除按钮
					btn_delete = $('<img class="del_update" src="/view/images/edit/del.jpg"></img>').css({
						position : 'absolute',
						top : 0,
						right : '-20px',
						width : '15px',
						height: '20px',
						zindex : '10',
						cursor: 'pointer'
					}).attr({
						title: '删除'
					}).on({
						click: deleteComponent
					});
					if($(this).find("[id^=logo],[id^=slogan]").length == 0 && $(this).closest(".update").attr("id") != "phone"){
						if($(this).find(".del_update").length == 0){
							$(this).append(btn_delete);
						}
						if($(this).find(".up_update").length == 0){
							//判断是否添加上移按钮
							if($(this).prev().length != 0 && $(this).prev().hasClass("update")){
								$(this).append(btn_up);
								btn_down.css({
									top : '60px'
								});
							}else{
								btn_down.css({
									top : '30px'
								});
							}
						}
						if($(this).find(".down_update").length == 0){
							//判断是否添加下移按钮
							if($(this).next().length != 0 && $(this).next().hasClass("update")){
								$(this).append(btn_down);
							}
						}
					}
				
				}
			});
		}

		/**
		 * 点击上移按钮
		 */
		function upComponent(){
			var comInfo = $(this).parents(".update").clone(true);// 复制组件信息
			var wrapinfo = $(this).closest(".wraper");
			wrapinfo.find(".del_update").remove();
			wrapinfo.find(".down_update").remove();
			$(this).parents(".update").prev().before(comInfo);//把组件信息复制到节点后
			$(this).parents(".update").remove();//删除组件信息
			wrapinfo.find(".up_update").remove();
			addUpAndDown(wrapinfo);
		}

		/**
		 * 点击下移按钮
		 */
		function downComponent(){
			var comInfo = $(this).parents(".update").clone(true);// 复制组件信息
			var wrapinfo = $(this).closest(".wraper");
			wrapinfo.find(".del_update").remove();
			wrapinfo.find(".up_update").remove();
			$(this).parents(".update").next().after(comInfo);//把组件信息复制到节点后
			$(this).parents(".update").remove();//删除组件信息
			wrapinfo.find(".del_update").remove();
			addUpAndDown(wrapinfo)
		}

		/**
		 * 点击删除按钮
		 */
		function deleteComponent(){
			var comInfo = $(this).parents(".update");// 组件信息
			var warper = $(this).closest(".wraper");
			/*
			 * 修改人:文东
			 * 修改时间：20140714 10:22
			 * 修改内容：删除最后一个组建是隐藏该域的导航
			 */
			var updateNum = comInfo.closest(".wraper").find(".update").length;//确定wraper域中还有多少组件
			if(confirm("确定删除吗？")){
				if(updateNum==1){// 若需要删除的是wraper域的最后一个组件 则将整个wraper和导航所对应的数据隐藏
					var navId = comInfo.closest(".wraper").find("[id$='_navigate']").attr("id");// 获取组件域的导航id
					//将navid存放到页面左侧
					$("#navId",parent.frames['frame_left'].document).val(navId);
					// 将所对应的整个wraper域隐藏
					comInfo.closest(".wraper").hide();
					// 将模板页面的头部导航隐藏
					$("#"+navId,parent.frames['frame_main'].document).closest("li").find("lable").hide();
					parent.frames['frame_left'].location.reload(true);
				}else{
					comInfo.remove();
				}
			}
			addUpAndDown(warper);
		}
		/**
		 * 取消删除组件
		 */
		function canceldeleteComponent(){
			var navId = $("#navId",parent.frames['frame_left'].document).val();
			$("#edit_"+navId,parent.frames['frame_left'].document).closest("h3").css("background","url(../../../../../images/mini/templateShop/images/left_list.png) no-repeat left top");
			//删除提示框
			$(".show_div",parent.frames['frame_left'].document).css("display","none");
			//将页面上的导航和组件恢复
			$("[id="+navId+"]",parent.frames['frame_main'].document).each(function(){
				$(this).closest("li").css('display','block'); 
				$(this).parent().closest(".wraper").css('display','block'); 
				addUpAndDown($(this).parent().closest(".wraper"));
			});
		}
		/**
		 * 确认删除组件
		 */
		function turedeleteComponent(){
			var navId = $("#navId",parent.frames['frame_left'].document).val();
			$("#edit_"+navId,parent.frames['frame_left'].document).closest("h3").css("display","none");
			//删除提示框
			$(".show_div",parent.frames['frame_left'].document).css("display","none");
			//删除导航条上的导航锚点
			$("#"+navId,parent.frames['frame_main'].document).closest("li").css("display","none");
			addUpAndDown($(this).parent().closest(".wraper"));
			
		}
		