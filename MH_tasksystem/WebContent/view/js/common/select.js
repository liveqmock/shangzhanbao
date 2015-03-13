!function($){
	var Select = function(element, options){
		this.init("select", element, options)
	}
	Select.prototype = {
		constructor: Select
		, init : function(type, element, options){
			this.type = type
		    this.$element = $(element)
		    this.setId(this.$element)
		    this.$hidden = $('#'+this.$element.attr('id')+'Hidden')
		    this.options = this.getOptions(options)
		    this.enabled = true
			this.$element.on('focus',$.proxy(this.show,this));
			this.$element.on('keydown',$.proxy(function(event){
				if(event.keyCode==9 && $(event.srcElement).attr('id')==this.$element.attr('id')){
					this.distroyModal();
				}
			},this));
			this.$element.closest('body').on('click',$.proxy(function(event){
				if(!$(event.srcElement).hasClass('select-div')  &&  $(event.srcElement).closest('.select-div').length==0 && $(event.srcElement).attr('id')!=this.$element.attr('id') ){
					this.distroyModal();
				}
			},this));
			
			if(this.$hidden.length==0){
				var name = this.$element.attr('name');
				var hidden = $('<input type=hidden id='+this.$element.attr('id')+'Hidden />')
				this.$element.after(hidden);
				if(name != null){
					hidden.attr('name',name)
					this.$element.removeAttr('name')
				}
				hidden.val(this.$element.attr('data-init'))
				this.$hidden = hidden
			}
		}
		, initModal : function(){
			this.modal = $('<div class="select-div modal" style="">'+
					'<div class="select-title modal-header" style="">'+
					'<div class="select-title-text">请选择</div>'+
					'</div>'+
					'<div class="modal-body" style="">'+
					'<div class="search" style="">'+
					'<form action="" style="" onsubmit="return false">'+
					'<input type="text" style="width: 100px;" class=input_bor><input type=button value=搜索>'+
					'</form>'+
					'</div>'+
					'<div style="" class="select-content">'+
					'<div class="loading" style="">正在加载。。。</div>'+
					'</div>'+
					'<div class="clear" style=""></div>'+
					'<div class="pageRoll" style=""></div>'+
					'</div>'+
					'<div class="modal-footer" style="">'+
					'<div class="" style="float:left">已选择：</div><div class=selected style="float:left" ></div>'+
					'<a class="btn btn-primary " >确定</a>'+
					'<input type=hidden class=selected-ids /><input type=hidden class=selected-names>'+
					'</div>'+
			'</div>').appendTo($(document.body));
			this.modal.show()
			
			
			this.content = this.modal.find(".select-content");
			this.selected = this.modal.find(".selected");
			this.title = this.modal.find(".select-title-text");
			this.title.before($('<span style="" class="close" href="javascript:;" >&times;</span>').click($.proxy(function(){
				this.distroyModal()
			},this)))
			this.title.html(this.options.titleText)
			this.selected.empty()
			this.setPlace()
			this.modal.find('.btn-primary').unbind('click')
			this.modal.find('.btn-primary').click($.proxy(this.returnValue,this))
			
			this.modal.find('input[type=text]').unbind('keyup')
			this.modal.find('input[type=text]').on('keyup',$.proxy(function(e){
				if(e.keyCode==13){
					this.param = this.appendParameter(this.param, this.options.keyName, e.currentTarget.value)
					this.getData(this.param)
				}
			},this))
			this.modal.find('input[type=text]').on('change',$.proxy(function(e){
				this.param = this.appendParameter(this.param, this.options.keyName, e.currentTarget.value)
				this.getData(this.param)
			},this))
			this.param = {
				url:this.options.url,
				data:this.options.data,
				type:"get",
				dataType:"text",
				success:$.proxy(this.showData,this)
			}
			this.modal.find('input.selected-ids').val(this.$hidden.val())
			this.modal.find('input.selected-names').val(this.$element.val())
			if(this.$hidden.val()!=null){
				for ( var i = 0; i < this.$hidden.val().split(',').length-1; i++) {
					this.markSelect(this.$hidden.val().split(',')[i], this.$element.val().split(',')[i])
				}
			}
		}
		, getOptions : function(options){
			if(options == null){
				options = $.fn[this.type].defaults
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
				if(options[prop] == null){
					options[prop] = $.fn[this.type].defaults[prop]
				}
			}
			
			
			return options
		}
		, setPlace : function(){
			var offset = this.$element.offset();
			var top = offset.top+this.$element.height()+10,
				left = offset.left;
			var height = 290;
			
			if(this.options.max==1){
				height = 230;
				this.modal.find('.modal-footer').remove()
			}
			
			if(offset.top+height>$(window).height() && $(window).height()>height){
				if(offset.top<height){
					top=0;
				}else{
					top = offset.top-height+10;
				}
			}
			if(left+600>$(window).width()){
				left=offset.left-600+this.$element.width();
			}
			this.modal.css({"top":top+"px","left":left+"px"});
		}
		, show : function(e){
			if(this.modal!=null){
				return;
			}
			this.initModal()
			$.ajax(this.param)
			this.showLoading()
		}
		, showData : function(data){
			this.hideLoading()
			data = eval("("+data+")");
			var pageRoll = data.pageRoll,
				list = data.list;
			if(list.length==null || list.length==0){
				this.content.append("<span class=data-item>没有找到数据</span>")
			}
			for(var i=0;i<list.length;i++){
				var span = $('<span>'+this.getValueFromObj(list[i], this.options.showField)+'</span>');
				var template = this.options.template;
				if(template != $.fn[this.type].defaults.template){
					if(template.indexOf('${')>-1){
						for ( var j = 0; j < this.options.template.split('${').length; j++) {
							var key = this.options.template.split('${')[1].split('}')[0]
							,value = list[i][key]
							template = this.options.template.replace('${'+key+'}',value)
						}
					}
					span.hide();
				}

				var dataItem = $(template),
					input = $('<input type=checkbox value='+list[i].id+'>')
				span.appendTo(dataItem);
				this.content.append(dataItem);
				this.attrFromData(dataItem,list[i],"data-");
				if(this.options.max > 1){
					input.appendTo(dataItem);
					dataItem.find("input[type=checkbox]").change($.proxy(function(e){
						if(e.currentTarget.checked ){
							this.select(e.currentTarget.value,$(e.currentTarget).prev().html())
						}else {
							this.diselect(e.currentTarget.value,$(e.currentTarget).prev().html())
						}
					},this));
					var selected = this.modal.find('input.selected-ids').val();
					if(selected!=null && selected.indexOf(list[i].id)>-1){
						dataItem.find('input[type=checkbox]').attr('checked','checked');
					}
					
				}else{
					dataItem.append('<input type=hidden value='+list[i].id+' />');
					dataItem.click($.proxy(function(event){
						this.$hidden.val($(event.currentTarget).find('input[type=hidden]').val());
						this.$element.val($(event.currentTarget).find('span').html());
						if(this.options.beforeSelect){
							if(!this.options.beforeSelect(this.$element)){
								return;
							}
						}
						this.distroyModal()
						if(this.options.onSelect){
							this.options.onSelect($(event.currentTarget),this.$element);
						}
						if(this.$element.attr("select")!=null){
							hideErr(this.$element);
						}
					},this));
				}
			}
			this.showPageRoll(this.param,pageRoll);
		}
		, select : function (id,name){
			var  ids = this.modal.find('input.selected-ids')
			,names = this.modal.find('input.selected-names')
			ids.val(ids.val() + id + ',')
			names.val(names.val() + name + ',')
			
			
			this.markSelect(id,name)
		}
		, diselect : function(id,name){
			var  ids = this.modal.find('input.selected-ids')
			,names = this.modal.find('input.selected-names')
			ids.val(ids.val().replace(id + ',',''))
			names.val(names.val().replace(name + ',',''))
			
			
			$(".selected_"+id).remove();
		}
		, markSelect : function(id,name){
			var  ids = this.modal.find('input.selected-ids')
				,names = this.modal.find('input.selected-names')
			var span = $('<span title=取消选中 data-id='+id+' class=selected_'+id+' style=""><span >'+name+'</span> <a class=close>&times;</a></span>');
			this.modal.find(".selected").append(span);
			span.click($.proxy(function(e){
				this.modal.find("input[type=checkbox][value="+$(e.currentTarget).attr("data-id")+"]").removeAttr("checked");
				//延时删除对象
				setTimeout($.proxy(function(){
					this.select.diselect($(this.e.currentTarget).attr("data-id"), $(this.e.currentTarget).find('span').html())
				},{e:e,select:this}),100);
			},this));
		}
		, returnValue : function(){
			if(this.modal.find('input.selected-ids').val().split(',').length>this.options.max+1){
				alert('请您最多选择'+this.options.max+'条数据！');
				return;
			}
			this.$element.val(this.modal.find('input.selected-names').val());
			this.$hidden.val(this.modal.find('input.selected-ids').val());
//			if(this.$element.attr('select')!=null){
//				this.$element.validate('hide');
//			}
			if(this.options.beforeSelect){
				if(!this.options.beforeSelect(this.$element)){
					return;
				}
			}
			this.distroyModal()
			if(this.options.onSelect){
				this.options.onSelect(this.modal.find('input.selected-ids').val(),this.modal.find('input.selected-names').val());
			}

			if(this.$element.attr("select")!=null){
				hideErr(this.$element);
			}
		}
		, appendParameter: function(param,name,value){
			if(param == null){
				param = {}
			}
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
			this.content.find(".data-item").remove();
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

			var div = this.modal.find(".pageRoll");
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
				prev.click($.proxy(function(){
					this.getData(this.param,currentPage-1);
				},this));
			}
			var page = "&nbsp;&nbsp;"+(currentPage+1)+"/"+totalPage+"&nbsp;&nbsp;";
			div.append(page);
			var next = $('<a >下一页</a>').appendTo(div);
			if(currentPage==totalPage-1){
				next.attr("title","已经是最后一页");
				next.css("color","#999");
			}else{
				next.attr("href","javascript:;");
				next.click($.proxy(function(){
					this.getData(this.param,currentPage+1);
				},this));
			}
			if(totalPage==1){
				div.hide();
			}
		}
		, getValueFromObj : function(obj,field){
			if(obj==null || field==null) return "";
			if(field.indexOf('.')==-1) return obj[field]
			else{
				var field1 = field.substring(0,field.indexOf('.'))
					,field2 = field.substring(field.indexOf('.')+1,field.length)
				return this.getValueFromObj(obj[field1], field2)
			}
		}
		, setId : function(obj){
			var id = obj.attr("id");
			if(id==null){
				do{
					id = parseInt(Math.random()*1000000);
				}while($("#"+id).length!=0);
				obj.attr("id",id);
			}
		}
		, clear : function(){
			this.$element.val('')
			this.$hidden.val('')
		}
		, distroyModal : function(){
			if(this.modal!=null){
				this.modal.remove();
				this.modal=null;
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
			, max : 1
			, showField : "id"
			, onSelect : false
			, template : '<label class="data-item select-item" style=""></label>'
	}
	$.fn.select.Constructor = Select;

}(jQuery)

$(function(){
	
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-modal.css" />').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/bootstrap-button.css" />').appendTo($(document.body));
	$('<link rel="stylesheet"  type="text/css" href="'+root+'/view/css/select-div.css" />').appendTo($(document.body));
});
