//<![CDATA[
$(function(){
	$.datepicker.regional['zh-CN'] = {
	        prevText: '&#x3c;上月',
	        nextText: '下月&#x3e;',
	        monthNames: ['01','02','03','04','05','06',
	            '07','08','09','10','11','12'],
	        monthNamesShort: ['一','二','三','四','五','六',
	            '七','八','九','十','十一','十二'],
	        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
	        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
	        dayNamesMin: ['日','一','二','三','四','五','六'],
	        weekHeader: '周',
	        dateFormat: 'yy-mm-dd',
	        firstDay: 1,
	        isRTL: false,
	        showMonthAfterYear: true,
	        yearSuffix: '年'

	    };
	    $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
	$('input.datepicker').datetimepicker({
        dateFormat:"yy-MM-dd",
        showTime:false,
        showHour:false,
        showMinute:false,
        showSecond:false,
        closeText:"确定",
        addSliderAccess: false,
        sliderAccessArgs: { touchonly: false }
    });
});
//]]