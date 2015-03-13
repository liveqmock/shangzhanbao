$(function(){
	/**
	 * 初始化隐藏添加组件的按钮
	 */
	$("[copy=copyComp]").each(function(){
		$(this).hide();
	});
	
	/**
	 * 加载蒙版的方法
	 */
	 if(window.top!=window.self){//存在父页面
		if (typeof(parent.frames['frame_top'].doEdit)!="undefined"){
			parent.frames['frame_top'].doEdit();
		}
		//临时隐藏在线客服的效果
		$('#doyoo_panel',parent.frames['frame_main'].document).remove();
		$('#talk99_message',parent.frames['frame_main'].document).remove();
		$('#doyoo_monitor',parent.frames['frame_main'].document).remove();
		$('#doyoo_share',parent.frames['frame_main'].document).remove();
	 }
	
	indexRoot = $("#objectRoot").val();
	
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
		//alert($(this).parent().parent().attr("dataWraperNum"));
		if($(this).parent().parent().attr("dataWraperNum")=='0'){
			//查询导航组件
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=2&componentData.cssType="+csstype;
		}else if($(this).parent().parent().attr("dataWraperNum")=='1'){
			//查询banner组件
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=3&componentData.cssType="+csstype;
		}else if($(this).parent().parent().attr("dataWraperNum")=='2'){
			//查询理由组件
			var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponentByComponentType?componentData.type=4&componentData.cssType="+csstype;
		}else{
			//查询普通组件
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
			$(this).val("100");
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
	})
});


/**
 * 设置锚点
 * @param id
 */
function getMaodian(id){
	    var scroll_offset = $("#" + id).offset();
	    
	    $("body,html").animate({
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
			var navAnchorID = "navAnchor"+navAnchorNum+"_navigate";
			var a_id = "navAnchor"+navAnchorNum;
			//alert(data);
			data = data.replace("<a><h2>","<a id='"+a_id+"'><h2 id='"+navAnchorID+"'>");
			$(".addComponent3").closest("div").before("<div class='wraper' dataWraperNum='"+wraperNum+"'>"+data+"<div id='div"+(j+1)+"' style='text-align: center;padding-top:200px'><button class='selectComp'>添加</button><button class='clearComp'>重置</button></div></div>");
			$("body").find("[class='navigate']").append("<li><a href=\"###\" onClick=\"getMaodian('"+a_id+"')\"><lable id=\""+navAnchorID+"\">导航锚点</lable></a></li>");
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
	//修改id值
	/*$(obj).find("[id]").each(function(){
		var name = $(this).attr("id").replace(/[\d]/g,"");
		var size = $(com).prev().parent().find(".update:eq("+(num-1)+")").find("[id]:eq(0)").attr("id").replace(/[^0-9]/ig,"");
		if(size == null){
			size = 0;
		} else {
			size = parseInt(size);
		}
		if($(this).attr("id") != undefined && $(this).attr("id") != ""){
			$(this).attr("id",$(this).attr("id").replace(/[\d]/g,"")+(size+1));
		}else if($(this).attr("name") != undefined && $(this).attr("name") != ""){
			var size = $($(com).prev().find(".update"))
			$(this).attr("name",$(this).attr("name").replace(/[\d]/g,"")+(size+1));
		}
	});*/
	var content = getOuterHtml(obj);
	var url = indexRoot + "/back_temp_manage/key/ajaxSearchUseComponentById?componentData.id="+compId;
	$.ajax({
		type : 'POST',
		url : url,
		dataType : "text",
		success : function(data) {
			if(num==0){
				$(com).prev(".update").after(data);
				
			}else{
				$(com).prev().parent().find(".update:last").after(data);
				
			}
			//创建page第二部中，添加理由 左部要添加理由输入框 要动态修改id
			if($(parent.frames['frame_left'].document)){
				var textateaId = data.substring(data.indexOf("reason_title"),data.indexOf("reason_title")+13+12);
				var onfocusinText = "jumpAnchor(\""+textateaId+"\")"
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("textarea").attr("id","step_"+textateaId);
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("textarea").attr("onfocusin",onfocusinText);
				$(parent.frames['frame_left'].document).find(".addReason").prev("div").find("a").attr("id","delete_"+textateaId);
				$("#step_"+textateaId,parent.frames['frame_left'].document).focus()
			}
			if (typeof(parent.frames['frame_top'].doEdit)!="undefined"){
				parent.frames['frame_top'].doEdit();
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
 * 规格点击事件
 * @param con
 */
		function commodityHtml(con){
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			var id=$(con).attr("data");
			var comid=$(con).attr("id");
			$(con).attr("class","span1"+sn);
			
			$(".rightDiv3"+sn).find("span").each(function(i){
				if($(this).attr("id")!=comid){
					$(this).attr("class","spantype"+sn);
				}
			})
			var price;
			var congigMarketPrice;
              if(id!=1){
            /*	  var pageId = $("#PageId").val();// pageId
          		$.ajax({
          			type:"POST",
          			url:indexRoot+"/commodity_config/key/getCommodityById?commodityConfigData.id="+id,
          			dataType : 'text',// 返回值类型 一般设置为json
          			success : function(data) {
          				if(data!=null){
          					var json=eval("(" + data + ")");
            				if(json.id!=""){
            					price=json.configPrice;
            					congigMarketPrice=json.congigMarketPrice;
            					$("#goodsPrice").html(price);
            					$("#goodsjiagePrice").html(congigMarketPrice);
            				}
          				}
          				
          			}
          		})*/
            	  	price=$(".goodsPrice_"+comid).val();
					congigMarketPrice=$(".goodsjiagePrice_"+comid).val();
					$("#goodsPrice").html(price);
					$("#goodsjiagePrice").html(congigMarketPrice);
              }else{
            	   price=$("#step_" + comid,parent.frames['frame_left'].document).next(".configPrice").val();
            	   congigMarketPrice=$("#step_" + comid,parent.frames['frame_left'].document).next().next(".congigMarketPrice").val();
            	   $("#goodsPrice").html(price);
   					$("#goodsjiagePrice").html(congigMarketPrice);
              }
			
			$("#step_" + comid).val();
			
				
				
			
	}
		
		/**
		 * 
		 * @param i
		 * 商品数量添加
		 */
		function addNum( i) {
			var num=$("#amount").val();
			if(num<100){
				num=parseInt(num)+1;
				$("#amount").val(num);
			}

		}
		/**
		 * 商品数量减少
		 * @param i
		 */
		function reduceNum(i) {
			var num=$("#amount").val();
			if(num>1){
				num=parseInt(num)-1;
				$("#amount").val(num);
			}
		}
