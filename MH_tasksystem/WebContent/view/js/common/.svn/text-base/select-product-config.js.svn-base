$.fn.extend({
	selectConfig:function(option){
		var url = root+"/product/key/ajaxGetAllProductConfig",
			data = {"productConfigData.productId":$(this).attr("data-productid")},
			showField = "configName",
			keyName = "productConfigData.configName",
			onSelect = option.onSelect;
		
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
		
		$(".config-dropdown").attr("for",$(this).attr("id"));
		$(".config-dropdown").css("top",(offset.top+$(this).height()+10)+"px");
		$(".config-dropdown").css("left",(offset.left)+"px");
		$(".config-dropdown").show();
		$(".config-dropdown").empty();
		$(".config-dropdown").append("<li class=data-item>正在加载。。。<li>");
		var param = {
				url:url,
				data:data,
				type:"post",
				dataType:"text",
				field:showField,
				onSelect:onSelect,
				success:function(data){
					$(".config-dropdown").empty();
//					$(".select-service-div .select-content .loading").remove();
//					$(".select-service-div .select-content .data-item").remove();
					data = eval("("+data+")");
					var list = data.list;
//					var pageRoll = data.pageRoll,
//						list = data.list;
//					if(list.length==null || list.length==0){
//						
//					}
//					var tr ;
					for(var i=0;i<list.length;i++){
						var dataItem = $('<a href=###>'+list[i][this.field]+'</a>');
						$(".config-dropdown").append(dataItem);
						dataItem.wrap('<li class=data-item>');
						attrFromData(dataItem,list[i],"data-");
						dataItem.click(function(){
							var obj = $("#"+$(".config-dropdown").attr("for"));
							obj.val($(this).html());
							$("#"+$(".config-dropdown").attr("for")+"Hidden").val($(this).attr("data-id"));
							if(onSelect != null && typeof(onSelect)=="function"){
								onSelect($(this));
							}
							$(".config-dropdown").hide();
							if(obj.attr("select")!=null){
								hideErr(obj);
							}
						});
					}
				}
			}
		$.ajax(param);
	}
});

$(function(){
	var dropdown = $('<ul class="dropdown-menu hide config-dropdown"></ul>');
	$(document.body).append(dropdown);
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-dropdown-menu.css" />').appendTo($(document.body));
});



function showLoading(){
//	var loadings = $(".select-service-div .select-content .loading");
//	if(loadings.length==0){
//		var div = $("<div>");
//		div.css("width","100%").css("text-align","center");
//		div.addClass("loading");
//		div.append("正在加载...");
//		div.appendTo($(".select-service-div .select-content"));
//	}else{
//		loadings.each(function(){
//			$(this).show();
//		});
//	}
}

function hideLoading(){
//	$(".select-service-div .select-content .loading").each(function(){
//		$(this).hide();
//	});
}
function showNoDataTips(tips){
//	$("<span class='data-item'>"+tips+"</span>").appendTo($(".select-service-div .select-content"));
}
function hidePageRoll(){
//	var div = $(".select-service-div .select-content .pageRoll");
//	if(div!=null){
//		div.hide();
//	}
}

//function showPageRoll(param,pageRoll){
//
//	var div = $(".select-service-div .pageRoll");
//	if(div.length==0){
//		div = $("<div class='pageRoll'>").appendTo($(".select-service-div"));
//	}
//	div.html("");
//	div.show();
//	var totalRows = eval(pageRoll.totalRows);
//	var pageSize = eval(pageRoll.pageSize);
//	var totalPage = parseInt(totalRows/pageSize);
//	if(pageSize*totalPage<totalRows || totalRows == 0){
//		totalPage++;
//	}
//	var currentPage =  eval(pageRoll.currentPage);
//	var prev = $('<a >上一页</a>').appendTo(div);
//	if(currentPage==0){
//		prev.attr("title","已经是第一页");
//		prev.css("color","#999")
//	}else{
//		prev.attr("href","javascript:;");
//		prev.click(function(){
//			getData(param,currentPage-1);
//		});
//	}
//	var page = "&nbsp;&nbsp;"+(currentPage+1)+"/"+totalPage+"&nbsp;&nbsp;";
//	div.append(page);
//	var next = $('<a >下一页</a>').appendTo(div);
//	if(currentPage==totalPage-1){
//		next.attr("title","已经是最后一页");
//		next.css("color","#999");
//	}else{
//		next.attr("href","javascript:;");
//		next.click(function(){
//			getData(param,currentPage+1);
//		});
//	}
//	if(totalPage==1){
//		div.hide();
//	}
//}


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
