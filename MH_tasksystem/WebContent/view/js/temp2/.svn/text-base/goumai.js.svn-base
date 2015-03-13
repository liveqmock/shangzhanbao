
$(function(){
	 $("#goodsConfigError").hide();
	indexRoot = $("#objectRoot").val();
	if($(".goodsRight").is(":hidden")){
		$("#addConfigType").hide();
	}
	//不是修改  或者编辑页面状态
	if( parent.frames['frame_top']==undefined){
		$(".goodsRight").hide();
		$("#addConfigType").hide();
	}
	attrprice();
})
/**
		 * 
		 * @param i
		 * 商品数量添加
		 */
		function addNum(i) {
			var num=$("#amount").val();
			if(num<100){
				num=parseInt(num)+1;
				$("#amount").val(num);
			}
			//购买确认订单页面
			if($("#order_paygoodsDiv").html()!=""){
				var order_goodsnum=$("#order_goodsnum").val();
				if(order_goodsnum<100){
					order_goodsnum=parseInt(order_goodsnum)+1;
					$("#order_goodsnum").val(order_goodsnum);//点击+，-过后的商品数量
					if(parseFloat($("#order_goodsprice").html())>0){
						if($("#changDis").val()!="false"){
							 //红包
							 var redPacakageprice=$("#changDis").val();
							 //减去红包过后的单价
							 var onePirce = parseFloat($("#order_goodsprice").attr("data"))-parseFloat(redPacakageprice);
							 
							 $("#order_goodsprice").html(changeTwoDecimal(onePirce*parseFloat(order_goodsnum)));
						 }else{
							 $("#order_goodsprice").html(changeTwoDecimal(parseFloat($("#order_goodsprice").attr("data"))*parseFloat(order_goodsnum)));	 
						 }
					}
				}
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
			//购买确认订单页面
			if($("#order_paygoodsDiv").html()!=""){
				var order_goodsnum=$("#order_goodsnum").val();
				if(order_goodsnum>1){
					order_goodsnum=parseInt(order_goodsnum)-1;
					$("#order_goodsnum").val(order_goodsnum);
					if(parseFloat($("#order_goodsprice").html())>0){
						 if($("#changDis").val()!="false"){
							 //红包
							 var redPacakageprice=$("#changDis").val();
							 //减去红包过后的单价
							 var onePirce = parseFloat($("#order_goodsprice").attr("data"))-parseFloat(redPacakageprice);
							 
							 $("#order_goodsprice").html(changeTwoDecimal(onePirce*parseFloat(order_goodsnum)));
						 }else{
							 $("#order_goodsprice").html(changeTwoDecimal(parseFloat($("#order_goodsprice").attr("data"))*parseFloat(order_goodsnum)));	 
						 }
					}
				}
			}
		}
		function changeNum(){
			var amount = $("#order_goodsnum").val();
			var num;
			if (amount == "") {
				num = 1;
				$("#order_goodsnum").val(num)
			}
			if (amount == "0") {
				num = 1;
				$("#order_goodsnum").val(num)
			}
			if (amount.match(/\D/g, '')) {
				num = 1;
				$("#order_goodsnum").val(num)
			}
			if (amount > 99) {
				num = 99;
				$("#order_goodsnum").val(num)
			}
			if (amount < 0) {
				num = 1;
				$("#order_goodsnum").val(num)
			}
			//购买确认订单页面
			if($("#order_paygoodsDiv").html()!=""){
				if($("#changDis").val()!="false"){
					 //红包
					 var redPacakageprice=$("#changDis").val();
					 //减去红包过后的单价
					 var onePirce = parseFloat($("#order_goodsprice").attr("data"))-parseFloat(redPacakageprice);
					
					 $("#order_goodsprice").html(changeTwoDecimal(onePirce*parseFloat($("#order_goodsnum").val())));
				}else{
					 $("#order_goodsprice").html(changeTwoDecimal(parseFloat($("#order_goodsprice").attr("data"))*parseFloat(order_goodsnum)));	 
				}
			}
		}
		/**
		 * 规格页面编辑事件
		 */
		function editGoods(){
			//获取页面  添加按钮元素
			var displaygoodsRight=$(".goodsRight").is(":hidden");
			if(displaygoodsRight==true){
				$("#addConfigType").show(); //添加类型按钮显示
				//获取品类个数
				var configTypeNum=$("#type_spanNum").find("span");
				//当页面没有时  点击修改默认添加一个
				if(configTypeNum.length==0){
					addConfigType();
				}
				attrprice();
				//没有品类文字提示隐藏
				$("#configTypeError").hide();
				$(".goodsRight").show();
			}else{
				$(".rightDiv3_Sn1254 ").css("border-bottom-style","dashed");  
				$("#addConfigType").hide();
				$(".goodsRight").hide();
		}
			
	}
		/**
		 * 添加规格品类
		 */
		function addConfigTypesum(){
			clearForm();  //清除表单数据
			$("#configTypeError").hide();
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			var span1="span1"+sn;
			var spantype="spantype"+sn;
			//获取品类个数
			var configTypeNum=$("#type_spanNum").find("span").length;
			//清除下面的规格
			$("#configInput").find("p").remove();
			$("#spanNum").find("span").remove();
			//商品现价 品类清空
			$("#price").val("");
			$("#name").val("");
			if(configTypeNum!=5){
				addConfig(); //添加默认规格
				//添加当前类型id
				var typeId="configType_"+createRandom(1, 1, 999);
				addClassConType(typeId,spantype);
				//为商品类型id赋值
				$("#configTypeIdHhidden").val(typeId);
				var html="<span class='"+span1+"'  id='"+typeId+"'  configTypeId=\"\" onclick='clickConfigType("+typeId+")'></span>" +
						"<input type=\"hidden\" value=\"\"  />"
				$("#addConfigType").before(html);
			}else{
				//最多只能添加5个商品类型
				$("#addConfigType").attr("disabled","disabled");
				addConfigError(configTypeNum);
			}
			
		}
		/**
		 * 成功添加品类
		 */
		function addConfigType(){
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var configTypeid=$("#type_spanNum").find("."+span1).attr("id");
			//获取品类个数
			var configTypeNum=$("#type_spanNum").find("span").length;
			if(configTypeNum>0){
					if($("#"+configTypeid).attr("configTypeId")==""){
						 $("#goodsConfigError").html("当前品类未保存！");
						 $("#goodsConfigError").show();
					}else{
						addConfigTypesum();
					}
				}else{
				addConfigTypesum();
			}
		}
		/**
		 * 添加规格
		 */
		function addConfigHtml(configTypeNum){
			clearForm(); //清除表单数据
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			var span1="span1"+sn;  //选择样式
			var spantype="spantype"+sn;  //未选中样式
			//商品现价清空
			$("#price").val("");
			if(configTypeNum!=10){
				//添加当前规格id
				var id=createRandom(1, 1, 999);
				var configId="config_"+id;  //规格spanid
				var configinputId="configinput_"+id;  //规格inputid
				var configTypeIdHhidden=$("#configTypeIdHhidden").val();
				addClass(configId,spantype);
				$("#price").attr("configId",configId);
				var html_input=" <p><input type=\"text\" value=\"\" class=\"inputClass_guige\"" +
						" onblur='configonblur("+configId+","+configinputId+")'" +
						" onfocus='configonfocus("+configId+")' id='"+configinputId+"'></p>";
				var html_span="<span class='"+span1+"' configinputId='"+configinputId+"'" +
						" onclick='clickConfig("+configId+")' id='"+configId+"' data=\"\" >" +
						"</span><input type=\"hidden\" value=\"\"  />"
				$("#addGoodsconfig").before(html_input);
				$("#addConfighidden").before(html_span);
			}else{
				//最多只能添加10个规格
				$("#addGoodsconfig").attr("disabled","disabled");
				addConfigError(configTypeNum);
			}
		}
		/**
		 * 添加规格成功
		 */
		function addConfig(){
			 //当数据还没有保存，不让添加下一个
			 var sn= "_"+$("#compSn").val();
				//选择样式
				var span1="span1"+sn;  
				var configid=$("#spanNum").find("."+span1).attr("id");
			//获取规格个数
			var configTypeNum=$("#configInput").find("p").length;
			 if(configTypeNum>0){
				 if($("#"+configid).attr("data")!=""){
					 addConfigHtml(configTypeNum);
				 }else{
					 $("#goodsConfigError").html("当前规格未保存！");
					 $("#goodsConfigError").show();
				 }
			 }else{
				 //在添加默认第一个不要判断
				 addConfigHtml(configTypeNum);
			 }
		}
		/**
		 * 判断 规格和品类最多能添加多少 
		 * @param len
		 */
		function addConfigError(len){
			// 定义弹出提示层
			var goodsInfoER = "<div id=\"goodsInfoER\" style=\"position:fixed;z-index:1010;top:30%;right:30%;" +
					"width: 520px;height: 165;background-color: gray;\">" +
					"<div style=\"padding-top: 73px;text-align: center;\">" +
					"<span style=\"font-family:'微软雅黑Regular','微软雅黑';font-size: 16px;color: #FFF;\">" +
					"最多只能添加'"+len+"'个！</span><br>" +
					"</div></div>";
			$("body").append(goodsInfoER);
			var h=parent.document.documentElement.clientHeight;
			var w=parent.document.documentElement.clientWidth;
			var div="<div  id=\"goodsInfoERBeackage\" style='background-color: rgba(0,0,70,.1);position:fixed;border:0px solid;z-index:4;left:0;top:0;width:"+w+"px;height:"+h+"px;'></div>";
			$("body",parent.document).append(div);
			setTimeout(function(){
		      $("#goodsInfoER").remove();
		      $("#goodsInfoERBeackage",parent.document).remove();
		    },1000);
		}
		/*
		num 要产生多少个随机数
		from 产生随机数的最小值
		to 产生随机数的最大值
		*/
		function createRandom(num ,from ,to )
		{
		    var arr=[];
		    for(var i=from;i<=to;i++)
		        arr.push(i);
		    arr.sort(function(){
		        return 0.5-Math.random();
		    });
		    arr.length=num;
		    return arr;
		}
		/**
		 * 规格添加默认样式
		 * @param id
		 */
		function addClass(id,spantype){
			$("#spanNum").find("span").each(function(i){
				  if($(this).attr("id")!=id){
					$(this).attr("class",spantype);   //添加未被 选择样式
					}
				})
		}
		/**
		 * 类型添加默认样式
		 * @param id
		 */
		function addClassConType(id,spantype){
		$("#type_spanNum").find("span").each(function(i){
			  if($(this).attr("id")!=id){
				$(this).attr("class",spantype);   //添加未被 选择样式
				}
			})
		}
		/**
		 * 规格获取焦点
		 * @param configId
		 */
		function configonfocus(configId){
			var id=$(configId).attr("id");
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			var span1="span1"+sn;  //选择样式
			var spantype="spantype"+sn;  
			$("#"+id).attr("class",span1);
			$("#price").val($("#"+id).next("input").val());
			addClass(id,spantype);
			$("#goodsPrice").html($("#"+id).next("input").val());
		}
		/**
		 * 规格失去焦点
		 * @param configId
		 */
		function configonblur(configId,configinputId){
			var id=$(configId).attr("id");  //规格spanid
			var inputId=$(configinputId).attr("id");//规格inputid
			$("#"+id).html($("#"+inputId).val());
			$("#"+id).attr("title",$("#"+inputId).val());
		}
		
	
		/**
		 * 品类 价格失去焦点
		 * @param configId
		 */
		function configTypeonblur(con){
		var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var id=$("#type_spanNum").find("."+span1).attr("id");
			var configid=$("#spanNum").find("."+span1).attr("id");
			if($(con).attr("id")!="price"){
				//品类
				$("#"+id).html($(con).val());
				$("#"+id).attr("title",$(con).val());
			}else{
				//价格
				if(Verificationprice($(con).val())!=false){
					$("#goodsPrice").html($(con).val())
				}
				//为规格span下面的隐藏域赋值
				$("#"+configid).next("input").val($(con).val());
			}
		}
		/**
		 * 商品信息和规格信息的检查
		 * @param configTypeName
		 * @param configName
		 * @param configPrice
		 * @returns {Boolean}
		 */
		function  checkGoods(configTypeName,configPrice,configName){
			var fl=true;
			//获取规格个数
			var configTypeNum=$("#configInput").find("p").length;
			if(configTypeNum>0){
				fl=Verificationprice(configPrice);
				 if(configName==""){
					 $("#goodsConfigError").html("规格名称不能为空！");
					 fl=false;
				 }else{
					 if(lengthOf(configName)>=40){
						 $("#goodsConfigError").html("规格最多输入20个字符！");
						 fl=false;
					 }
				 }
			}	 
				 if(configTypeName==""){
					 $("#goodsConfigError").html("品类名称不能为空！");
					 fl=false;
				 }else{
					 if(lengthOf(configTypeName)>=20){
						 $("#goodsConfigError").html("品类最多输入20个字符！");
						 fl=false;
					 }
				 }
			 return fl;
		}
		/**
		 * 判断字符串长度
		 * @param str
		 * @returns {Number}
		 */
		function lengthOf(str){
				  var len = 0;
		          for (var i = 0; i < str.length; i++) {
		              if (str[i].match(/[^\x00-\xff]/ig) != null) //全角 
		                  len += 2; //如果是全角，占用两个字节
		              else
		                  len += 1; //半角占用一个字节
		          }
		          return len;
	       }    
		/**
		 * 完成按钮
		 */
		function submitGoods(){
			attrForm();  
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var configTypeName=$("#configTypeName").val();
			var configPrice=$("#price").val()
			var configName=$("#configName").val();
			var bl=checkGoods(configTypeName, configPrice, configName);
			if(bl==true){
				//获取页面pageid
				var pageId = $("#id", parent.frames['frame_left'].document).val();// pageId
			var url=$("#objectRoot").val()+"/goods_info/key/addGoodsInfo?pageGoodsInfoData.pageId="+pageId+"&goodsInfoData.id="+$("#goodsInfoDataId").val();
				$.ajax({
					type:"POST",
					url:url,
					dataType : 'text',// 返回值类型 一般设置为json
					data:$("#addGoodsCofigForm").serialize(),
					success : function(data) {
					if(data!="1"){
						var json=eval("(" + data + ")");
						var configid=$("#spanNum").find("."+span1).attr("id");
						var configTypeid=$("#type_spanNum").find("."+span1).attr("id");
						$("#"+configTypeid).attr("configTypeid",json.parentId)
						$("#"+configid).attr("data",json.id)
						$("#goodsInfoDataId").val(json.goodsInfoId);  //商品id
						$("#goodsConfigError").hide();
						clearForm();
						}
					}
				})
			}else{
				 $("#goodsConfigError").show();
				 $("#goodsPrice").html("");
			}
		}
		/**
		 * 商品规格 品类删除
		 */
		function deleteConfig(){
			   $("#goodsConfigError").hide();
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			//获取规格个数
			var configTypeNum=$("#spanNum").find("span").length;
			if(configTypeNum>0){
				var configid=$("#spanNum").find("."+span1).attr("id");
				var configinputId=$("#"+configid).attr("configinputId");
				if($("#"+configid).attr("data")!=""){  //id不为空走数据删除
					deleteConfigById($("#"+configid).attr("data"));
				}
					deleteClass(configid,2);
					//删除规格
					$("#"+configid).next("input").remove();
					$("#"+configid).remove();
					$("#"+configinputId).parent("p").remove();
					$("#"+configinputId).remove();
			}else{
				//删除品类
				var configTypeid=$("#type_spanNum").find("."+span1).attr("id");
				//id不为空走数据删除
				if($("#"+configTypeid).attr("configTypeid")!=""){
					deleteConfigById($("#"+configTypeid).attr("configTypeid"));
				}
					deleteClass(configTypeid,1);
					$("#"+configTypeid).next("input").remove();
					$("#"+configTypeid).remove();
			}
		}
		/**
		 * 规格切换
		 * @param configId
		 */
		function clickConfig(configId){
			//当前规格id
			var id=$(configId).attr("id");
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var spantype="spantype"+sn;  
			$("#"+id).attr("class",span1);
			addClass(id,spantype);
			$("#goodsPrice").html($("#"+id).next("input").val());
			$("#price").val($("#"+id).next("input").val());
		}
		/**
		 * 商品品类切换
		 * @param con
		 */
		function clickConfigType(con){
			var id=$(con).attr("id");
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var spantype="spantype"+sn;  
			$("#"+id).attr("class",span1);
			addClassConType(id, spantype);
			//切换品类查询数据
			clickConfigTypeSelect($("#"+id).attr("configTypeId"));
		}
		/**
		 * 删除规格 品类的选中和未选中的样式切换
		 * @param con
		 */
		function deleteClass(con,type){
			//购买主键编号
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;
			//获取品类个数
			var configTypeNum=$("#type_spanNum").find("span").length;
			 if ($("#"+con).prev("input").prev("span").length > 0){ 
				 //当删除前一个存在
				 $("#"+con).prev("input").prev("span").attr("class","span1"+sn); ;//添加被 选择样式
				 $("#goodsPrice").html($("#"+con).prev("input").val());  //商品现价改变值
				 $("#price").html($("#"+con).prev("input").val());  //商品input现价改变值
				 //当删除类型后，把下一个类型的规格查询出来
				 if(type==1){
					 if(configTypeNum>1){
					 clickConfigTypeSelect($("#"+con).prev("input").prev("span").attr("configTypeid"));
					 }else{
						 $("#configTypeError").show();
						 $("#price").val("");
						 $("#name").val("");
						 $(".goodsRight").hide();
						 $("#addConfigType").hide();
					 }
				 }
			 }else{
				 //上一个不存在  寻找下一个
				 $("#"+con).next("input").next("span").attr("class","span1"+sn); ;//添加被 选择样式
				 $("#goodsPrice").html($("#"+con).next("input").next("span").next("input").val());
				 $("#price").html($("#"+con).next("input").next("span").next("input").val());  //商品input现价改变值
				 //当删除类型后，把下一个类型的规格查询出来
				 if(type==1){
					 if(configTypeNum>1){
					 clickConfigTypeSelect($("#"+con).next("input").next("span").attr("configTypeid"));
					 }else{
						 $("#configTypeError").show();
						 $("#price").val("");
						 $("#name").val("");
						 $(".goodsRight").hide();
						 $("#addConfigType").hide();
					 }
				 }
			 }
		}
		/**
		 * 获取选择的值  赋值给from表单
		 */
		function attrForm(){
			var sn= "_"+$("#compSn").val();
			//选择样式
			var span1="span1"+sn;  
			var configid=$("#spanNum").find("."+span1).attr("id");
			var configTypeid=$("#type_spanNum").find("."+span1).attr("id");
			//规格赋值
			$("#configName").val($("#"+configid).html());  //规格名称
			$("#configParentId").val($("#"+configTypeid).attr("configTypeid"));  //品类id
			$("#configId").val($("#"+configid).attr("data"));  //规格id
			$("#configPrice").val($("#"+configid).next("input").val());  //现价
			
			//品类赋值
			$("#configTypeName").val($("#"+configTypeid).html());   //品类名称	
			$("#configTypeId").val($("#"+configTypeid).attr("configTypeId")); //品类id
		}
		/**
		 * 数据添加成功，清空form表单
		 */
		function clearForm(){
			//规格赋值
			$("#configName").val("");  //规格名称
			$("#configParentId").val("");  //品类id
			$("#configId").val("");  //规格id
			$("#configPrice").val("");  //现价
			
			//品类赋值
			$("#configTypeName").val("");   //品类名称	
			$("#configTypeId").val(""); //品类id
		}
		/**
		 * 删除规格品类数据库已存在的数据 
		 * @param id
		 */	
	   function deleteConfigById(id){
			$.ajax({
				type:"POST",
				url:indexRoot+"/commodity_config/key/deletecommod?commodityConfigData.id="+id,
				dataType : 'text',// 返回值类型 一般设置为json
				success : function(data) {
				}
			})
	   }
	   /**
	    * 切换品类查询数据
	    * @param id
	    */
	   function clickConfigTypeSelect(id){
		   $("#goodsConfigError").hide();
		 //购买主键编号
			var sn= "_"+$("#compSn").val();
			var span1="span1"+sn;  //选择样式
			var spantype="spantype"+sn;  //未选中样式
		   $.ajax({
				type:"POST",
				url:indexRoot+"/commodity_config/key/getAllByParentId?commodityConfigData.parentId="+id,
				dataType : 'text',// 返回值类型 一般设置为json
				success : function(data) {
					var html_span="";
					var html_input="";
					if(data!="1"){
						var list = eval("(" + data + ")");
						 if(list.length>0){
							 for(var i in list){ 
								//添加当前规格id
								var id=createRandom(1, 1, 999);
								var configId="config_"+id;  //规格spanid
								var configinputId="configinput_"+id;  //规格inputid
							if(i==0){
								 html_span +="<span class='"+span1+"' configinputId='"+configinputId+"'" +
								" onclick='clickConfig("+configId+")' title='"+list[i].configName+"' id='"+configId+"' data='"+list[i].id+"' type=\"2\">" 
								+list[i].configName+
								"</span><input type=\"hidden\" value='"+list[i].configPrice+"'  />"
							}else{
								html_span +="<span class='"+spantype+"' configinputId='"+configinputId+"'" +
								" onclick='clickConfig("+configId+")'  title='"+list[i].configName+"' id='"+configId+"' data='"+list[i].id+"' type=\"2\">" 
								+list[i].configName+
								"</span><input type=\"hidden\" value='"+list[i].configPrice+"'  />"
							}
							html_input +=" <p><input type=\"text\" value='"+list[i].configName+"' class=\"inputClass_guige\"" +
							" onblur='configonblur("+configId+","+configinputId+")'" +
							" onfocus='configonfocus("+configId+")' id='"+configinputId+"'></p>";
							$("#goodsPrice").html(list[0].configPrice)
							$("#price").val(list[0].configPrice);
						}
					}else{
						
					}
						html_span=html_span+" <a href=\"###\"  style=\"display:none ;\" id=\"addConfighidden\" ></a>"
						html_input=html_input+"<a href=\"###\" class=\"newaddGoodsconfig_Sn1254\"  id=\"addGoodsconfig\" onclick=\"addConfig()\" ></a>"
				$("#spanNum").html(html_span);
				$("#configInput").html(html_input);
					}else{
						//修改  或者编辑页面状态  没有数据 默认增加一个
						if( parent.frames['frame_top']!=undefined){
							//添加当前规格id
							var id=createRandom(1, 1, 999);
							var configId="config_"+id;  //规格spanid
							var configinputId="configinput_"+id;  //规格inputid
							var configTypeIdHhidden=$("#configTypeIdHhidden").val();
							addClass(configId,spantype);
							$("#price").attr("configId",configId);
							html_input=" <p><input type=\"text\" value=\"\" class=\"inputClass_guige\"" +
									" onblur='configonblur("+configId+","+configinputId+")'" +
									" onfocus='configonfocus("+configId+")' id='"+configinputId+"'></p>";
							html_span="<span class='"+span1+"' configinputId='"+configinputId+"'" +
									" onclick='clickConfig("+configId+")' id='"+configId+"' data=\"\" >" +
									"</span><input type=\"hidden\" value=\"\"  />"
						}
						$(".goodsPriceClass").html();
						$("#spanNum").html(html_span+"<a href=\"###\"  style=\"display:none ;\" id=\"addConfighidden\" ></a>");
						$("#configInput").html(html_input+"<a href=\"###\" class=\"newaddGoodsconfig_Sn1254\"  id=\"addGoodsconfig\" onclick=\"addConfig()\" ></a>");
					}
				}
			})
	   }
	   /**
	    * 刷新页面  价格 等赋值
	    */
	function attrprice(){
		var sn= "_"+$("#compSn").val();
		//选择样式
		var span1="span1"+sn;  
		var configid=$("#spanNum").find("."+span1).attr("id");
		var configTypeid=$("#type_spanNum").find("."+span1).attr("id");
		$("#price").val($("#"+configid).next("input").val());
		$("#name").val($("#"+configTypeid).html());
		$("#goodsPrice").html($("#"+configid).next("input").val());
	}
	/**
	 * 价格验证
	 * @param configPrice
	 * @returns {Boolean}
	 */
	function Verificationprice(configPrice){
		var fl=true;
		if(configPrice==""){
			 $("#goodsConfigError").html("规格价格不能为空！");
			 fl=false;
		 }else{
			 var patrn=/^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/; 
				if (!patrn.exec(configPrice)){
					 $("#goodsConfigError").html("价格格式不正确");
					 $("#goodsConfigError").show();
					fl=false;
				}else{
					if(parseFloat(configPrice)<0){
						 $("#goodsConfigError").html("价格格式不正确");
						 $("#goodsConfigError").show();
							fl=false;
					}
				}
		 }
		return fl;
	}