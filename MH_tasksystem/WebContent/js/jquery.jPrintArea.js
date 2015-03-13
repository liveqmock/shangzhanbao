// 打印接口
jQuery.jPrintArea = function(el) {
	var iframe = document.createElement('IFRAME');
	var doc = null;
	$(iframe).attr('style',
			'position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
	document.body.appendChild(iframe);
	doc = iframe.contentWindow.document;
	var links = window.document.getElementsByTagName('link');
	for (var i = 0; i < links.length; i++)
		if (links[i].rel.toLowerCase() == 'stylesheet')
			doc.write('<link type="text/css" rel="stylesheet" href="'
					+ links[i].href + '"></link>');
	doc.write('<div class="' + $(el).attr("class") + '">' + $(el).html()
			+ '</div>');
	doc.close();
	iframe.contentWindow.focus();
	iframe.contentWindow.print();
	// alert('Printing...');
	document.body.removeChild(iframe);
}
// 传真
jQuery.jFaxArea = function(el,styleString) {
	var iframe = document.createElement('IFRAME');
	var doc = null;
	$(iframe).attr('style',
			'position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
	document.body.appendChild(iframe);

	doc = iframe.contentWindow.document;
	
	var links = window.document.getElementsByTagName('link');
	for (var i = 0; i < links.length; i++) {
		if (links[i].rel.toLowerCase() == 'stylesheet') {
			doc.write('<link type="text/css" rel="stylesheet" href="'
					+ links[i].href + '"></link>');
		}
	}
	doc.write('<div id="faxContent" class="' + $(el).attr("class") + '">' + $(el).html()
			+ '</div>');
	var html = window.document.getElementsByTagName('html');
	// 以下发送ajax请求到后台生成html图片,此处需要知道传真到那里？
	//alert($(html).html());
	$.ajax({
				type : "POST",
				url : parent.projectNamePath+"/process_create_order/key/faxOrder",
				data : "fax=" + $(el).html()+"&style="+styleString,
				async : false,
				success : function(msg) {
					var msg = $.evalJSON(msg);
					if (msg.success) {
						alert("发送传真成功");
					} else {
						alert("发送传真失败");
					}
				}
			});
	doc.close();
	document.body.removeChild(iframe);
}