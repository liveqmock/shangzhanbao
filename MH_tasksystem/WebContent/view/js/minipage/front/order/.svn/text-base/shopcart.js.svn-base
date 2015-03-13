/**
 * 购物车公用的js
 * @author 林海鹏
 * @date 2014-3-11
 */
/******************************************************************************/

/**
 * 发布权限的服务去支付（暂时只是改变状态）
 */
function topayqx(i){
	
	var num = $("#amount"+i).val();//购买的发布权限的数量
	window.location.href = root+"/order/key/topayqx?amount="+num;
}
/**
 * 非发布权限的服务去支付（暂时只是改变状态）
 */
function topay(pageid){
	
	window.location.href=root+"/order/key/topay?orderProductData.pageId="+pageid;
	
}
/**
 * 全部支付（暂时只是改变状态）
 */
function topayAll(){
	alert("暂不支持该功能~\(≧▽≦)/~");
}

/**
 * 初始化购买发布权限
 */
var userid = "";
//function onload() {
//	var checked = $("input[name='checkother']:checked");// 判断复选框是否选中
//	// (判断最后一个table中是否有数据，，没有数据的话，则整个table隐藏)
//	if (checked.length != 0) {
//		$("#orderTable").show();
//	}
//	var url = root + "/shop_cart/key/shopPrivilege";
//	var data = getAsyncAjax(url, null);
//	var jsons = eval("(" + data + ")");
//	initToshopCart(data);
//	init();// 初始化设置
//}

$(function(){
/*	$(".deleteProduct").live("click",function(){
		var pid = $(this).attr("data1");
		var pageId = $(this).attr("data2");
		if(confirm("确认删除?")){
			goods = clearCookie(pid,pageId);
			$.cookie("shopcart", goods, {expires :10,path :'/'});
			var trnum = $(this).closest("table").find("tbody").find("tr").length;
			if(trnum == 1){
				$(this).closest(".bingordersDiv").remove(); 
			}
			var productPrice = $(this).closest("tr").find(".price").val();
			var orderPrice = $("#orderPriceNum").val();
			var newOrderPrice =  parseInt(orderPrice) - parseInt(productPrice);
			$("#bordermoney").html(newOrderPrice);
		}
		window.location.href=root+"/shop_cart/key/topShopCart";
	})*/
	
	//去支付按钮的点击事件，跳转到订单配置页面
//	$("#toPay").click(function(){
//		window.location.href = root + "/shopping_cart/key/toOrderConfig";
//	}
	
	 $(".deleteProduct").click(function(){
		 var pid = $(this).attr("data1");
			var pageId = $(this).attr("data2");
			 if(confirm('你确认要删除吗？')){
				$.ajax( {
				obj : $(this),
				type : "POST",
				url : root + '/shopping_cart/key/updateShoppingCartData',
				data : "shoppingCartData.pageId="+pageId+"&shoppingCartData.productId="+pid,
				success : function(data) {
					if(data==1){
					alert("删除成功！");
			
					var trnum = this.obj.closest("table").find("tbody").find("tr").length;
					if(trnum == 1){
						this.obj.closest(".bingordersDiv").remove(); 
						
					}else{
						 var price1 = this.obj.closest("tr").find(".productPrice").val();
						 var price2=$("#orderPriceNum").val();
						 var newOrderPrice =  parseInt(price2) - parseInt(price1);
						 $("#orderPriceNum").val(newOrderPrice);
						 $("#bordermoney").html("￥"+newOrderPrice+".0元");
						 this.obj.closest("tr").remove();
						
					}
					window.location.href=root+"/shopping_cart/key/getAll?sign=1";
					}else{
						alert("删除失败！")
					}
				}
			});
	 }
	 });
})

/**
 * 业务要求,初始化需加入购物车 的一条默认官方权限数据
 * 
 * @return
 */
function initToshopCart(data) {
	var jsons = eval("(" + data + ")");
	var goods = $.cookie("shopcart");// 获取购物车信息
	if (goods == null || "" == goods) {
		goods = "[]";
	}
	userid = jsons.userid;
	goods = eval("(" + goods + ")");
	var falg = false;

	for ( var i = 0; i < goods.length; i++) {
		if (jsons.userid == goods[i].userid && jsons.pid == goods[i].pid) {
			goods[i].num = parseFloat(goods[i].num);
			falg = true;
			break;// 只会有一条id信息,,所以跳出循环
		}
	}
	if (!falg) {
		goods.push({
			"pid" : "\"" + jsons.pid + "\"",
			"num" : "\"1\"",
			"pageid" : "\"\"",
			"userid" : "\"" + jsons.userid + "\""
		});
	}
	goods = toJson(goods);
	$.cookie("shopcart", goods, {
		expires : 10,
		path : '/'
	});// 存储一个带10天期限的 cookie
	reload();
}

/**
 * 初始化设置
 */
function init() {
	/**
	 * 初始化时计算其他服务的总金额,并赋值
	 */
	var countPrices = $("input[title^='uuprice']");
	var num = 0;
	for ( var i = 0; i < countPrices.length; i++) {
		num = parseInt(num) + parseInt(countPrices[i].value)
	}
	$("#otherTotalprice").html("￥: " + num + ".0元");

}

/**
 * 显示其他购物车
 * 
 * @return
 */
function otherOrder() {
	$("#otherOrder").slideToggle();
	$("#totalCount").slideToggle();
	$(".Order_BDiv").slideToggle();
}

/**
 * 将商品添加到购物车 任何商品
 * 
 * @param pid
 *            商品id
 * @param num
 *            购买数量
 * @param userid
 *            用户id
 * @return
 */
function addToShopingCart(pid, num, pageid) {
	var goods = $.cookie("shopcart");// 获取购物车信息
	if (goods == null || "" == goods) {
		goods = "[]";
	}
	goods = eval("(" + goods + ")");
	var falg = false;
	for ( var i = 0; i < goods.length; i++) {
		if (userid == goods[i].userid) {
			if (pid == goods[i].pid && pageid == goods[i].pageid) {
				goods[i].num = parseFloat(goods[i].num) + parseFloat(num);
				if (goods[i].num > 99) {
					goods[i].num = 99;
				}
				falg = true;
			}
		}
	}
	if (!falg) {// 不存在该产品,添加到购物车里面
		goods.push({
			"pid" : "\"" + pid + "\"",
			"num" : "\"" + num + "\"",
			"pageid" : "\"" + pageid + "\"",
			"userid" : "\"" + userid + "\""
		});
	}
	goods = toJson(goods);
	$.cookie("shopcart", goods, {
		expires : 10,
		path : '/'
	});
	alert('加入成功!');
}

/*
 * 更改cookie中服务产品数量
 */
function changeProductNum(pid, num, pageid) {
	var goods = $.cookie("shopcart");
	if (goods == null || goods == "") {
		goods = "[]";
	}
	goods = eval("(" + goods + ")");
	var i = 0;
	for (; i < goods.length; i++) {// 说明存在
		if (pid == goods[i].pid && pageid == goods[i].pageid) {
			if (pid == goods[i].pid) {
				goods[i].num = num;
				break;
			}
		}
	}
	goods = toJson(goods);
	$.cookie("shopcart", goods, {
		expires : 10,
		path : '/'
	});
}

/**
 * 根据id删除cookie中产品信息
 * 
 * @param pid
 * @param tableid
 * @param trid
 */
function deleteProduct(pid, tableid, trid, priceid, pageId) {
	if (confirm("确认删除?")) {
		goods = clearCookie(pid, pageId);
		$.cookie("shopcart", goods, {
			expires : 10,
			path : '/'
		});
		var table = document.getElementById(tableid);
		if (tableid == 'otable') {// 是否是其他服务
			var tr = document.getElementById(trid);// 获取table组件
			table.deleteRow(tr.rowIndex);// 删除对应的行
			var checked = $("input[name='other']:checked");// 判断复选框是否选中
			if (checked.length == 0) {// 如果table中无记录
				$("#orderTable").html("");
			}
			var countPrices = $("input[title^='uuprice']");
			var num = 0;
			for ( var i = 0; i < countPrices.length; i++) {
				num = parseInt(num) + parseInt(countPrices[i].value)
			}
			$("#otherTotalprice").html("￥: " + num + ".0元");
		} else {
			$("#" + trid + "").html("");// 将整个table清除
		}
		location.reload();
	}
}

/**
 * 显示添加二级域名的div
 * 
 * @return
 */
var divPageId = "";
function showtowDomainDiv(pageid) {
	$.ajax({
		type : 'POST',
		url : root+"/page_manage/key/ajaxSearchPicByPageId?pageId="+pageid,
		dataType : "text",
		success : function(data) {
			$("#pageImg").attr("src",data);
		}
	});
	divPageId = pageid;
	$('#divdomain').fadeToggle(500);
}

/**
 * 购物车里去设置二级域名
 * 
 * @return
 */
function saveTwoDomain() {
	$(".sur_submit_Btn").attr("disabled","disabled");
	var pageName = $("#pageName").val();
	var lastName = $("#lastName").val();
	var domainName = $("#domainName").text();

	var param = "{'domainName':'" + domainName + "','lastName':'" + lastName
			+ "'}";
	var json = getAsyncAjax(root + "/page/key/checktwoDomain?domainjson="
			+ encodeURIComponent(param), null);
	if (json == 1) {
		alert("该二级域名已存在！");
		return;
	}
	var value = "{'pageId':'" + divPageId + "','pageName':'" + pageName
			+ "','lastName':'" + lastName + "'}";
	var url = root + "/page/key/addTwoDomain?json=" + encodeURIComponent(value);
	$.ajax({
		type : 'POST',
		cache : false,
		url : url,
		dataType : "text",
		success : function(data) {
			var goods = $.cookie("shopcart");
			$.cookie("shopcart", goods, {
				expires : 10,
				path : '/'
			});
			window.location.href=root+"/shopping_cart/key/getAll?sign=1";
		}
	});
}

/**
 * 单机 + 时触发 （官方发布权限）
 * 
 * @param pid
 *            //商品id
 * @param i
 *            递增的变量
 * @return
 */
function addNum(pid, i, pageid) {
	var userid = $("#userid").val();
	var unitPrice = $("#unitPrice" + i).val();
	var amount = $("#amount" + i).val();
	var newamount = parseInt(amount) + 1;
	if (newamount > 99)
		newamount = 99;
	$("#amount" + i).val(newamount);

	$("#countPrice" + i).val(unitPrice * newamount + ".0");
	$("#ordermoney").html("￥: " + unitPrice * newamount + ".0 元");
	changeProductNum(pid, newamount, pageid);
}
/**
 * 单机 - 时触发 （官方发布权限）
 * 
 * @param pid
 *            //商品id
 * @param i
 *            递增的变量
 * @return
 */
function reduceNum(pid, i, pageid) {
	var userid = $("#userid").val();
	var unitPrice = $("#unitPrice" + i).val();
	var amount = $("#amount" + i).val();
	var newamount = parseInt(amount) - 1;
	if (newamount <= 0){
		newamount = 1;
	}
	$("#amount" + i).val(newamount);
	$("#countPrice" + i).val(unitPrice * newamount + ".0");
	$("#ordermoney").html("￥: " + unitPrice * newamount + ".0 元");
	changeProductNum(pid, newamount, pageid);
}
/**
 * 在购物车的数量，直接手动修改数量 （官方发布权限）
 * 
 * @return
 */
function changeNum(pid, i, pageid) {
	var unitPrice = $("#unitPrice" + i).val();
	var amount = $("#amount" + i).val();
	if (amount == "") {
		alert("数量不能为空");
		$("#amount" + i).val("1");
		amount = 1;
	}
	if (amount == "0") {
		$("#amount" + i).val("1");
		amount = 1;
	}
	if (amount.match(/\D/g, '')) {
		alert('请输入正整数！')
		$("#amount" + i).focus();
		$("#amount" + i).val("1");
		amount = 1;
	}
	if (amount > 99) {
		amount = 99;
		$("#amount" + i).val("99");
	}
	if (amount < 0) {
		amount = 1;
		$("#amount" + i).val("1");
	}
	$("#countPrice" + i).val(unitPrice * amount + ".0");
	$("#ordermoney").html("￥: " + unitPrice * amount + ".0 元");
	changeProductNum(pid, amount);
}

/**
 * 单机 + 时触发 （其他服务）
 * 
 * @param pid
 *            //商品id
 * @param i
 *            递增的变量
 * @return
 */
function addOtherNum(pid, i, pageid) {
	var unitPrice = $("#uunitPrice" + i).val();
	var amount = $("#uuamount" + i).val();
	var newamount = parseInt(amount) + parseInt(1);
	if (newamount > 99)
		newamount = 99;
	$("#uuamount" + i).val(newamount);
	$("#uuprice" + i)
			.html(
					"<input type='text' size='3' style='background: transparent; border: none; text-align: center;' value='"
							+ unitPrice
							* newamount
							+ ".0"
							+ "' name='orderData.price' title='uuprice"
							+ i
							+ "'>");// 小计
	var countPrices = $("input[title^='uuprice']");
	var num = 0;
	for ( var i = 0; i < countPrices.length; i++) {
		num = parseInt(num) + parseInt(countPrices[i].value)
	}
	$("#otherTotalprice").html("￥: " + num + ".0 元");
	changeProductNum(pid, newamount, pageid);
}

/**
 * 单机 - 时触发 （其他服务）
 * 
 * @param pid
 *            //商品id
 * @param i
 *            递增的变量
 * @return
 */
function reduceOtherNum(pid, i, pageid) {
	var unitPrice = $("#uunitPrice" + i).val();
	var amount = $("#uuamount" + i).val();
	var newamount = parseInt(amount) - parseInt(1);
	if (newamount < 0)
		newamount = 0;
	$("#uuamount" + i).val(newamount);
	$("#uuprice" + i)
			.html(
					"<input type='text' size='3' style='background: transparent; border: none; text-align: center;' value='"
							+ unitPrice
							* newamount
							+ ".0"
							+ "' name='orderData.price' title='uuprice"
							+ i
							+ "'>");// 小计
	var countPrices = $("input[title^='uuprice']");
	var num = 0;
	for ( var i = 0; i < countPrices.length; i++) {
		num = parseInt(num) + parseInt(countPrices[i].value)
	}
	$("#otherTotalprice").html("￥: " + num + ".0 元");
	changeProductNum(pid, newamount, pageid);
}

/**
 * 在购物车的数量，直接手动修改数量 可以后续选择使用在哪个Page上 （其他服务）
 * 
 * @return
 */
function changePageNum(pid, i, pageid) {
	var unitPrice = $("#uunitPrice" + i).val();
	var amount = $("#uuamount" + i).val();
	if (amount == "") {
		alert("数量不能为空");
	}
	if (amount.match(/\D/g, '')) {
		alert('请输入正整数！')
		$("#uamount" + i).focus();
		return false;
	}
	if (amount > 99)
		amount = 99;
	if (amount < 0)
		amount = 0;
	$("#uuamount" + i).val(amount);
	$("#uuprice" + i)
			.html(
					"<input type='text'  size='3' style='background: transparent; border: none; text-align: center;' value='"
							+ unitPrice
							* amount
							+ ".0"
							+ "' name='orderData.price' title='uuprice"
							+ i
							+ "'>");// 小计
	var countPrices = $("input[title^='uuprice']");
	var num = 0;
	for ( var i = 0; i < countPrices.length; i++) {
		num = parseInt(num) + parseInt(countPrices[i].value)
	}
	$("#otherTotalprice").html("￥: " + num + ".0 元");
	changeProductNum(pid, amount, pageid);
}

/**
 * 购物车结算前三种结算入口 批量结算方法 formid :表单的id checkedid ：复选框的id amountid :数量id
 * 
 * @author linhp
 * @return
 *//*
function privilegeOrder(formid, checkedid, amountid) {
	alert($("#ordermoney").html());
	var checked = $("input[name^='" + checkedid + "']:checked");// 判断复选框是否选中
	if (checked.length == 0) {
		alert("至少选择一条记录!");
		return;
	} else {
		if (checkZero(amountid)) {// 验证购物车订单为空
			alert("购物车商品数量为0，请添加商品！");
		} else {
			if (confirm("确认结算?")) {
				var ids = new Array();
				var pageIds = new Array();
				for ( var i = 0; i < checked.length; i++) {
					ids.push(checked[i].value);
					pageIds.push($(checked[i]).attr("data"))
				}
				ids = ids.join(",")
				$.ajax({
					type : 'post',
					url : root + "/shop_cart/key/sumPrice?ids=" + id,
					data : $("#" + formid).serialize(),
					dataType : "text",
					success : function(data) {
						var goods;
						for ( var i = 0; i < ids.length; i++) {// 批量清理cookie
							goods = clearCookie(ids[i], pageIds[i]);
							$.cookie("shopcart", goods, {
								expires : 10,
								path : '/'
							});// cookie 清除完毕后要提交
						}
						alert("操作成功,请查看[订单管理] 未付款订单!");
						$.cookie("shopcart", goods, {
							expires : 10,
							path : '/'
						});
						$('<form method=post></form>')
								.append(
										$('<input type=hidden name=goods >')
												.val(goods)).attr("action",
										root + "/order/key/orderList")
								.appendTo($(document.body)).submit();
					}
				});
			}
		}
	}
}*/
/**
 * 其他服务结算
 * 
 * @return
 */
/*function otherOrderSubmit() {
	var checked = $("input[name^='other']:checked");// 判断复选框是否选中
	if (checked.length == 0) {
		alert("至少选择一条记录!");
		return;
	} else {
		if (checkZero("uuamount")) {// 验证购物车订单为空
			alert("购物车商品数量为0，请添加商品！");
		} else {
			if (confirm("确认结算?")) {
				var ids = new Array();// id
				var uproductname = new Array();// 服务名称
				var uproductconfigname = new Array();// 规格
				var unitprice = new Array();// 单价
				var uamount = new Array();// 数量
				var uprice = new Array();// 小计
				// 循环取值
				checked
						.each(function(i, item) {
							ids.push($(item).attr("value"));// 订单的id
							var i = $(item).attr("date");//
							uproductname.push($("#uproductname" + i).val());
							uproductconfigname
									.push($("#uproductconfigname" + i).val());
							unitprice.push($("#uunitPrice" + i).val());
							uprice.push($("#orderprice" + i).val());
							uamount.push($("#uuamount" + i).val());
						});
				ids = ids.join(",")
				uproductname = uproductname.join(",")
				uproductconfigname = uproductconfigname.join(",")
				unitprice = unitprice.join(",")
				uamount = uamount.join(",")
				uprice = uprice.join(",")
				var value = "ids=" + ids + "&productName=" + uproductname
						+ "&productConfigName=" + uproductconfigname
						+ "&unitPrice=" + unitprice + "&amount=" + uamount
						+ "&price=" + uprice
				var url = root + '/shop_cart/key/otherOrderSubmit?'
						+ encodeURIComponent(value);
				var json = getAsyncAjax(url, value);
				var pids = ids.split(",");
				var goods;
				for ( var i = 0; i < pids.length; i++) {// 批量清理cookie
					goods = clearCookie(pids[i], "")
					$.cookie("shopcart", goods, {
						expires : 10,
						path : '/'
					});// cookie 清除完毕后要提交
				}
				alert("操作成功,请查看[订单管理] 未付款订单!");
				$('<form method=post></form>').append(
						$('<input type=hidden name=goods >').val(goods)).attr(
						"action", root + "/order/key/orderList").appendTo(
						$(document.body)).submit();
			}
		}
	}
}
*/
/**
 * 验证购物车订单为空
 * 
 * @return
 */
function checkZero(amountid) {
	var pricesAmount = $("input[id^='" + amountid + "']");
	var sumPricesAmount = 0;
	for ( var i = 0; i < pricesAmount.length; i++) {
		sumPricesAmount = sumPricesAmount + parseInt(pricesAmount[i].value);
	}
	return sumPricesAmount == 0;
}

/**
 * 根据pid 清理对应的商品记录,不弹窗
 * 
 * @return
 */
function clearCookie(pid, pageid) {
	var goods = $.cookie("shopcart");
	if (goods == null || goods == "") {
		goods = "[]";
	}
	goods = eval("(" + goods + ")");
	var i = 0;
	for (; i < goods.length; i++) {
		// 说明存在
		if (pid == goods[i].pid && pageid == goods[i].pageid) {
			goods[i] = null;
		}
	}
	goods = toJson(goods);
	return goods;
}
/**
 * 刷新头部数量
 * 
 * @return
 *//*
function reload() {
	var url = root + "/shop_cart/key/getCookie";
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		success : function(msg) {
			$("#goodsnum").html(msg);
		}
	})
};*/

/*
 * 获取异步AJAX
 */
function getAsyncAjax(url, data) {
	var json;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(msg) {
			json = msg;
		}
	});
	return json;
}
/*
 * 转换成json对象
 */
function toJson(obj) {
	if (obj.length == null) {
		return objToJson(obj);
	} else {
		return arrayToJson(obj);
	}
}
/*
 * 将单个object对象转成json对象
 */
function objToJson(obj) {
	var json = "{";
	for ( var field in obj) {
		json += field + ":";
		if (typeof (obj[field]) == "object") {
			json += toJson(obj[field]);
		} else if (typeof (obj[field]) == "string") {
			if (obj[field].indexOf("\"") > -1) {
				json += obj[field];
			} else {
				json += "\"" + obj[field] + "\"";
			}
		} else {
			json += obj[field];

		}
		json += ",";
	}
	json = json.substring(0, json.length - 1);
	json += "}";
	return json;

}
/*
 * 将数组转成json对象
 */
function arrayToJson(obj) {
	var json = "[";
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i] != null) {
			json += toJson(obj[i]);
			json += ",";
		}
	}
	json = json.substring(0, json.length - 1);
	if (json.length > 1) {
		json += "]";
	}
	return json;
}



function shoppingCartDiv(pageId){
	
	var divId="as_"+pageId;
	var checked = $("input[name='bings']:checked");//判断复选框是否选中
	if(checked.length==0){
		alert("至少选择一条记录!");
		return;
	}else{
		$("#as_"+pageId).show();
		  $("#href_"+pageId).bind("click", Eat); 
	}
}
function shoppingCartDivClosed(pageId){
	$("#as_"+pageId).hide();
}
//官方发布权限
var Eat = function() {  
   
}  
function shoppingCartDivPage(){


	var checked = $("input[name='productorder']:checked");//判断复选框是否选中
	if(checked.length==0){
		alert("至少选择一条记录!");
		return;
	}else{				
				$("#shoppingCartDivPage").show();				
				  $("#hrefshop").bind("click", Eat); 
	}
}
function shoppingCartDivPageClosed(){
	$("#shoppingCartDivPage").hide();
}

function shoppingCartDivClosedAll(){
	$("#shoppAll").hide();
}

function shoppingCartDivAll(){
		$('input[type=checkbox]').attr('checked', 'checked'); 
		 $("#shoppAll").show();				
		 $("#hrefshopAll").bind("click", Eat); 
	
}