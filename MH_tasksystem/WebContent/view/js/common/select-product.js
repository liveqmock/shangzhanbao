$.fn.extend({
	selectService:function(option){
		var url = root+"/product/key/aJaxGetAllProduct",
			data = option.data,
			showField = "productName",
			keyName = "productData.productName",
			onSelect = option.onSelect;
		if(url==null || url==""){
			throw new Error("URL exception;");
		}
		if(showField==null || showField==""){
			showField = "id";
		}
		
		
		
		if($("#"+$(this).attr("id")+"Hidden").length==0){
			var id = $(this).attr("id");
			var name = $(this).attr("name");
			if(id==null || id ==""){
				do{
					id = parseInt(Math.random()*1000000);
				}while($("#"+id).length!=0);
				$(this).attr("id",id);
			}
			var input;
			if(name==null || name==""){
				input = $('<input type=hidden id="'+id+'Hidden" >' );
			}else{
				input = $('<input type=hidden id="'+id+'Hidden" name='+name+' >' );
				$(this).removeAttr("name");
			}
			$(this).after(input);
		}
		
		
		
		var offset = $(this).offset();
		$(".select-service-div").css("top",(offset.top+$(this).height()+10)+"px");
		$(".select-service-div").css("left",(offset.left)+"px");
		
		
		
		$(".select-service-div .select-content table").empty();
		$(".select-service-div").show();
		
		
		$(".select-service-div").attr("for",$(this).attr("id"));
		var param = {
				url:url,
				data:data,
				type:"get",
				dataType:"text",
				field:showField,
				onSelect:onSelect,
				success:function(data){
					$(".select-service-div .select-content .loading").remove();
					$(".select-service-div .select-content .data-item").remove();
					data = eval("("+data+")");
					var pageRoll = data.pageRoll,
						list = data.list;
					if(list.length==null || list.length==0){
						
					}
					var tr ;
					for(var i=0;i<list.length;i++){
						if(i%4==0){
							tr = $("<tr >").appendTo($(".select-service-div .select-content table"));
						}
						var dataItem = $('<span class="btn data-item" >'+list[i][this.field]+'</span>');
						tr.append(dataItem);
						attrFromData(dataItem,list[i],"data-");
						dataItem.wrap("<td width=25%>");
						dataItem.click(function(){
							if(onSelect != null && typeof(onSelect)=="function"){
								var obj = $("#"+$(".select-service-div").attr("for"));
								obj.val($(this).html());
								$("#"+$(".select-service-div").attr("for")+"Hidden").val($(this).attr("data-id"));
								
								onSelect($(this));
								
								$(".select-service-div").hide();
								if(obj.attr("select")!=null){
									hideErr(obj);
								}
							}
						});
					}
					showPageRoll(param,pageRoll);
				}
			}

		param = appendParameter(param,"productData.isDelete","1");
		param = appendParameter(param,"productData.productstate","2");
		getData(param);
		
		
		$(".select-service-div .search input").unbind("keyup");
		$(".select-service-div .search input").bind("keyup",function(){
			param = appendParameter(param,keyName,$(".select-service-div .search input").val());
			getData(param);
		});
	}
});

$(function(){
	var selectDiv = '<div class="select-service-div modal hide" style="margin-left:auto;display: none;position:absolute;">'+
						'<div class="select-title modal-header" >'+
							'<a style="float: right;text-decoration: none;font-size: 18px;" href="javascript:;" onclick="$(this).closest(\'.select-service-div\').hide();">&times;</a>'+
							'<div class="select-title-text">请选择服务</div>'+
						'</div>'+
						'<div class=" modal-body">'+
						'<div class="search">'+
							'<form action="" style="float:right;padding-right: 6px;">'+
								'关键字：<input type="text" style="width: 100px;">'+
							'</form>'+
						'</div>'+
						'<div style="clear:both">'+
						'</div>'+
						'<div style="" class="select-content">'+
							'<table style="width:100%">'+
							'</table>'+
							'<div class="loading" style="text-align: center;height: 100%;line-height: 100%;font-size: 20px;font-family: 微软雅黑,黑体,宋体;">正在加载。。。</div>'+
						'</div>'+
						'<div class="pageRoll" style="font-size: 12px;text-align: left;padding: 4px 8px;"></div>'+
					'</div>'+
					'</div>';
	$(document.body).append(selectDiv);
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-modal.css" />').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-button.css" />').appendTo($(document.body));
});



function getData(param,page){
	param = appendParameter(param,"pageRoll.currentPage",page);
	hidePageRoll();
	param.dataType="text";
	param.type="get";
	if(param.noDataTip==null){
		param.noDataTip = "没有找到请求的数据……";
	}
	if(param.error==null){
		param.error=function(data){
			/*alert(data);*/
		}
	}
	showLoading();
	hidePageRoll();
	$.ajax(param);
};

function showLoading(){
	var loadings = $(".select-service-div .select-content .loading");
	if(loadings.length==0){
		var div = $("<div>");
		div.css("width","100%").css("text-align","center");
		div.addClass("loading");
		div.append("正在加载...");
		div.appendTo($(".select-service-div .select-content"));
	}else{
		loadings.each(function(){
			$(this).show();
		});
	}
}

function hideLoading(){
	$(".select-service-div .select-content .loading").each(function(){
		$(this).hide();
	});
}
function showNoDataTips(tips){
	$("<span class='data-item'>"+tips+"</span>").appendTo($(".select-service-div .select-content"));
}
function hidePageRoll(){
	var div = $(".select-service-div .select-content .pageRoll");
	if(div!=null){
		div.hide();
	}
}

function showPageRoll(param,pageRoll){

	var div = $(".select-service-div .pageRoll");
	if(div.length==0){
		div = $("<div class='pageRoll'>").appendTo($(".select-service-div"));
	}
	div.html("");
	div.show();
	var totalRows = eval(pageRoll.totalRows);
	var pageSize = eval(pageRoll.pageSize);
	var totalPage = parseInt(totalRows/pageSize);
	if(pageSize*totalPage<totalRows || totalRows == 0){
		totalPage++;
	}
	var currentPage =  eval(pageRoll.currentPage);
	var prev = $('<a >上一页</a>').appendTo(div);
	if(currentPage==0){
		prev.attr("title","已经是第一页");
		prev.css("color","#999")
	}else{
		prev.attr("href","javascript:;");
		prev.click(function(){
			getData(param,currentPage-1);
		});
	}
	var page = "&nbsp;&nbsp;"+(currentPage+1)+"/"+totalPage+"&nbsp;&nbsp;";
	div.append(page);
	var next = $('<a >下一页</a>').appendTo(div);
	if(currentPage==totalPage-1){
		next.attr("title","已经是最后一页");
		next.css("color","#999");
	}else{
		next.attr("href","javascript:;");
		next.click(function(){
			getData(param,currentPage+1);
		});
	}
	if(totalPage==1){
		div.hide();
	}
}


function attrFromData(obj,data,prefix){
	for ( var field in data) {
		if(typeof(data[field])=='object'){
			attrFromData(obj,data[field],prefix+field+"-");
		}else{
			obj.attr(prefix+field,data[field]);
		}
	}
}


function appendParameter(param,name,value){
	if(param!=null){
		if(param.data!=null){
			if(typeof(param.data)=="object"){
				param.data[name] = value;
			}else{
				param.data = param.data.replace(name,"lastPage");
				param.data += "&"+name+"="+value;
			}
		}else{
			param.data = {};
			param.data[name] = value;
		}
	}
	return param;
	
}
