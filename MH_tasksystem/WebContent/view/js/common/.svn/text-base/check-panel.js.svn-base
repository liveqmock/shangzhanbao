!function($){
	var Select = function(element, options){
		this.init("select", element, options)
	}
	Select.prototype = {
		constructor: Select
		, init : function(type, element, options){
			this.type = type
		    this.$element = $(element)
		    this.options = this.getOptions(options)
		    this.enabled = true
		    var selectDiv = $('.select-div')
			this.modal = selectDiv;
			this.content = selectDiv.find(".select-content");
			this.selected = selectDiv.find(".selected");
			this.title = selectDiv.find(".select-title-text");
			this.show();
		}
		, getOptions : function(options){
			if(this.options == null){
				this.options = $.fn[this.type].defaults
			}
			if(options.url == null){
				throw new Error("URL exception")
			}
			if(options.width==null || options.width==""){
				options.width = this.$element.width()
				options.width += 12
				if(options.width<200){
					options.width = 600
				}
			}
			for(var prop in $.fn[this.type].defaults){
				if(this.options[prop] == null){
					this.options[prop] = $.fn[this.type].defaults[prop]
				}
			}
			
			
			return options
		}
		, setPlace : function(){
			var offset = this.$element.offset();
			var top = offset.top+this.$element.height()+10,
				left = offset.left;
			if(offset.top+400>$(window).height() && $(window).height()>400){
				if(offset.top<400){
					top=0;
				}else{
					top = offset.top-400+10;
				}
			}
			if(left+600>$(window).width()){
				left=offset.left-600+this.$element.width();
			}
			this.modal.css({"top":top+"px","left":left+"px"});
		}
		, show : function(e){
			this.modal.show()
			this.title.html(this.options.titleText)
			this.selected.empty()
			this.param = {
				url:this.options.url,
				data:this.options.data,
				type:"get",
				dataType:"text",
				success:$.proxy(this.showData,this)
			}
			$.ajax(this.param)
		}
		, showData : function(data){
			this.content.find(".loading").remove();
			this.content.find(".data-item").remove();
			data = eval("("+data+")");
			var pageRoll = data.pageRoll,
				list = data.list;
			if(list.length==null || list.length==0){
				this.content.append("<span class=data-item>没有找到数据</span>")
			}
			for(var i=0;i<list.length;i++){
				var dataItem = $('<label class=data-item style="margin:6px;float:left;padding:4px;border:1px solid #ddd;cursor:pointer;width:80px;"></label>'),
					input = $('<input type=checkbox value='+list[i].id+'>'),
					span = $('<span>'+list[i][this.options.showField]+'</span>');
				input.appendTo(dataItem);
				span.appendTo(dataItem);
				this.content.append(dataItem);
				this.attrFromData(dataItem,list[i],"data-");
				dataItem.find("input[type=checkbox]").change(function(){
					if(this.checked){
						var span = $('<span title=取消选中 data-id='+this.value+' class=selected_'+this.value+' style="margin:0 6px;float:left;padding:4px;border:1px solid #ddd;cursor:pointer;width:80px;text-align:left;">'+$(this).next().html()+' <a class=close>&times;</a></span>');
						$(this).closest(".modal").find(".selected").append(span);
						span.click(function(){
							$(this).closest(".modal").find("input[type=checkbox][value="+$(this).attr("data-id")+"]").removeAttr("checked");
							$(this).remove();
						});
					}else{
						$(".selected_"+this.value).remove();
					}
				});
				var selected = $("#"+this.$element.attr("id")+"Hidden").val();
				if(selected!=null && selected.indexOf(list[i].id)>-1){
					dataItem.click();
				}
			}
			this.showPageRoll(this.param,pageRoll);
		}
		, appendParameter: function(param,name,value){
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
		,attrFromData : function(obj,data,prefix){
			for ( var field in data) {
				if(typeof(data[field])=='object'){
					this.attrFromData(obj,data[field],prefix+field+"-");
				}else{
					obj.attr(prefix+field,data[field]);
				}
			}
		}
		,getData : function(param,page){
			param = this.appendParameter(param,"pageRoll.currentPage",page);
			this.hidePageRoll();
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
			this.showLoading();
			this.hidePageRoll();
			$.ajax(param);
		}

		,showLoading : function (){
			var loadings = this.modal.find(" .select-content .loading");
			if(loadings.length==0){
				var div = $("<div>");
				div.css("width","100%").css("text-align","center");
				div.addClass("loading");
				div.append("正在加载...");
				div.appendTo(this.content);
			}else{
				loadings.show();
			}
		}

		,hideLoading : function (){
			this.content.find(".loading").hide();
		}
		,showNoDataTips : function (tips){
			$("<span class='data-item'>"+tips+"</span>").appendTo(this.content);
		}
		,hidePageRoll : function (){
			var div = this.content.find(".pageRoll");
			if(div!=null){
				div.hide();
			}
		}

		,showPageRoll : function (param,pageRoll){

			var div = this.content.find(".pageRoll");
			if(div.length==0){
				div = $("<div class='pageRoll'>").appendTo(this.content);
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
					this.getData(param,currentPage-1);
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
					this.getData(param,currentPage+1);
				});
			}
			if(totalPage==1){
				div.hide();
			}
		}
	}

	$.fn.select = function(option){
	 return this.each(function () {
	      var $this = $(this)
	        , data = $this.data('select')
	        , options = typeof option == 'object' && option
	      if (!data) $this.data('select', (data = new Select(this, options)))
	      if (typeof option == 'string') data[option]()
	    })
	}
	$.fn.select.defaults = {
			titleText : "请选择"
				, type : "radio"
					, showField : "id"
	}
	$.fn.select.Constructor = Select;

}(jQuery)

$(function(){
	$('<div class="select-div modal" style="">'+
			'<div class="select-title modal-header" style="">'+
			'<a style="" class="close" href="javascript:;" onclick="$(this).closest(\'.select-div\').hide();">&times;</a>'+
			'<div class="select-title-text"></div>'+
			'</div>'+
			'<div class="modal-body" style="min-height:260px;">'+
			'<div class="search" style="height: 20px;">'+
			'<form action="" style="padding-right: 6px;">'+
			'<input type="text" style="width: 100px;"><input type=button value=搜索>'+
			'</form>'+
			'</div>'+
			'<div style="" class="select-content">'+
			'<div class="loading" style="text-align: center;height: 100%;line-height: 100%;font-size: 20px;font-family: 微软雅黑,黑体,宋体;">正在加载。。。</div>'+
			'</div>'+
			'<div class="pageRoll" style="font-size: 12px;text-align: left;padding: 4px 8px;"></div>'+
			'</div>'+
			'<div class="modal-footer" style="">'+
			'<div class="" style="float:left">已选择：</div><div class=selected style="float:left" ></div>'+
			'<a class="btn btn-primary " >确定</a>'+
			'</div>'+
	'</div>').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-modal.css" />').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-button.css" />').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/select-div.css" />').appendTo($(document.body));
});
