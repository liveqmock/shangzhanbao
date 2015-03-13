$(function(){
	
	indexRoot = $("#objectRoot").val();
	
	// 组件排序
	esc = 0;
	
	// 模板页面form表单的内容
	content = "";
	
	/**
	 * 重置
	 */
	$(".clearComp").live("click",function(){
		var id =  $(this).parent().attr("id");
		var selectComp = $(this).parent().find(".selectComp").detach();
		var clearComp = $(this).parent().find(".clearComp").detach();
		$("#"+id).empty();
		$("#"+id).append(selectComp);
		$("#"+id).append(clearComp);
		$("#"+id).css({"text-align":"center" ,"background-color":"red"}); 
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
//		   form.attr("action",root + "/back_temp_manage/key/ajaxAddTemp");
//		   form.method = "post";
//		   form.submit();
//		   window.location.href = root + "/temp_manage/key/searchAllToAdmin?templateData.status=1";
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
		var i = $("body").find(".wraper").length;
		var j = $("body").find(".container").length;
		$(this).closest("div").before("<div class='wraper'><div class='slide'><div id='div"+(i+1)+"' style='margin-top: 200px;background-color: red;text-align: center;height: 150px;'><button class='selectComp'>添加组件</button><button class='clearComp'>重置</button></div></div></div>");
	})
	
	/**
	 * 选择组件
	 */
	$(".selectComp").live("click",function(){
		var url = indexRoot + "/back_temp_manage/key/ajaxSearchComponent?componentData.type=2";
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
				 $("#div_compent").append("<div id='dlg' class='modal modal-mslmgmt hide' style='width: 400px; height: 270px;'>" +
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
})


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
				this.obj.append("<button class='selectComp'>添加组件</button><button class='clearComp'>重置</button>");
			}else if(this.multable=="Y"){
				this.obj.append("<button class='copyComp' onclick=\"copyComp('"+this.compId+"',this)\">添加组件</button><button class='clearComp'>重置</button>");
			}
			$("#div_compent").empty();
			$("#dlg").hide();
			this.obj.find("img").attr("src",indexRoot+"/view/model/images/zanwu.jpg");
			var product_id = this.obj.find(".update");  
			$.each(product_id,function(n,goods) {
				// 判断添加的组件的div内是否存在class属性名称为component的input控件是否存在
			    var id2 = $(goods).find(".component").val();  
			    if(id2 == "" || id2 == null){
			    	$(goods).append("<input type='hidden' class='component' name='' value='"+id3+"'/>");
			    }
			});
			var beginId;
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
}


function copyComp(compId,com){
	var num = $(com).prev().find(".update").length;
	var obj = $(com).prev().find(".update:eq(0)").clone(true);
	//修改id值
	$(obj).find("[id],[name]").each(function(){
		if(num != 0){
			if($(this).attr("id") != undefined && $(this).attr("id") != ""){
				$(this).attr("id",$(this).attr("id").replace(/[\d]/g,"")+(num+1));
			}else if($(this).attr("name") != undefined && $(this).attr("name") != ""){
				$(this).attr("name",$(this).attr("name").replace(/[\d]/g,"")+(num+1));
			}
		}
	});
	var content = getOuterHtml(obj);
	$(com).prev().find(".update").parent().append(content);
	parent.frames['frame_top'].document.location.reload();
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