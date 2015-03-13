$(function(){
	$.datepicker.regional['zh-CN'] = {
	    prevText: '&#x3c;',
	    nextText: '&#x3e;',
	    monthNames: ['01','02','03','04','05','06',
	        '07','08','09','10','11','12'],
	    monthNamesShort: ['一','二','三','四','五','六',
	        '七','八','九','十','十一','十二'],
	    dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
	    dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
	    dayNamesMin: ['日','一','二','三','四','五','六'],
	    weekHeader: '周',
	    dateFormat: 'yy-mm-dd',
	    isRTL: false,
	    showMonthAfterYear: true
	};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
	$('input.datepicker').datepicker({
		changeYear:true,
		changeMonth:true,
		startDate:new Date()
	});
	$('<link rel="stylesheet" type="text/css" href="'+root+'/view/css/jquery-ui-timepicker.css" />').appendTo($(document.body));
});
