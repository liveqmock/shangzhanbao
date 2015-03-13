var ColorHex = new Array('00', '33', '66', '99', 'CC', 'FF')
var SpColorHex = new Array('FF0000', '00FF00', '0000FF', 'FFFF00', '00FFFF',
		'FF00FF')
var current = null
/**
 * 初始化颜色选择控件
 * 
 * @param evt
 */
function initcolor(evt) {
	var colorTable = ''
	for (i = 0; i < 2; i++) {
		for (j = 0; j < 6; j++) {
			colorTable = colorTable + '<tr height=12>'
			colorTable = colorTable
					+ '<td width=12 style="background-color:#000000">'
			if (i == 0) {
				colorTable = colorTable
						+ '<td width=12 style="cursor:pointer;background-color:#'
						+ ColorHex[j] + ColorHex[j] + ColorHex[j]
						+ '" onclick="doclick(\'#' + ColorHex[j] + ColorHex[j]
						+ ColorHex[j] + '\')">'
			} else {
				colorTable = colorTable
						+ '<td width=12 style="cursor:pointer;background-color:#'
						+ SpColorHex[j] + '" onclick="doclick(\'#'
						+ SpColorHex[j] + '\')">'
			}
			colorTable = colorTable
					+ '<td width=12 style="background-color:#000000">'
			for (k = 0; k < 3; k++) {
				for (l = 0; l < 6; l++) {
					colorTable = colorTable
							+ '<td width=12 style="cursor:pointer;background-color:#'
							+ ColorHex[k + i * 3] + ColorHex[l] + ColorHex[j]
							+ '" onclick="doclick(\'#' + ColorHex[k + i * 3]
							+ ColorHex[l] + ColorHex[j] + '\')">'
				}
			}
		}
	}
	colorTable = '<table border="1" cellspacing="0" cellpadding="0" style="text-align:center;cursor:pointer;border-collapse:collapse" bordercolor="000000" >'
			+ '<tr><td colspan="21"><span style="float:right;margin-right:5px;cursor:pointer;" onclick="colorclose()">×</span></td></tr>'
			+ colorTable + '</table>';
	document.getElementById("colorpane").innerHTML = colorTable;
	var current_x = document.getElementById("inputcolor").offsetLeft;
	var current_y = document.getElementById("inputcolor").offsetTop;
	document.getElementById("colorpane").style.left = current_x + "px";
	document.getElementById("colorpane").style.top = current_y + "px";
	if($("#logoImagefont", parent.frames['frame_main'].document).length>0){
		var logoFont = $("#logoImagefont", parent.frames['frame_main'].document);
		var logoInput = $("#logoFont");
		logoInput.val(logoFont.text());
		logoInput.css("font-family",logoFont.css("font-family"));
		logoInput.css("font-weight",logoFont.css("font-weight"));
		logoInput.css("color",logoFont.css("color"));
		$("#fontselect").val(logoFont.css("font-family"));
		$("#color").val(logoFont.css("color"));
		$("#inputcolor").css("background",logoFont.css("color"));
	}
}
/**
 * 选择颜色事件
 * 
 * @param colorValue
 */
function doclick(colorValue) {
	$("#color").val(colorValue);
	$("#inputcolor").css("background", colorValue);
	$("#logoFont").css("color", colorValue);
	$("#colorpane").css("display", "none");
}
/**
 * 关闭颜色选择div
 */
function colorclose() {
	$("#colorpane").css("display", "none");
}
/**
 * 显示颜色选择div
 */
function coloropen() {
	$("#colorpane").css("display", "");
}
/**
 * 给文字Logo文本框赋值
 * 
 * @param fontinfo
 */
function changeFont(fontinfo) {
	$("#logoFont").css("fontFamily", fontinfo.value);
}
/**
 * 加粗文字
 */
function boldFont() {
	$("#logoFont").css("font-weight", "900");
}
/**
 * 限制输入文本长度
 * 
 * @param obj
 *            要限制的元素
 * @param lengthNum
 *            限制的长度
 */
function checklength(obj, lengthNum) {
	if (obj.value.length > lengthNum) {
		obj.value = obj.value.substring(0, lengthNum);
	}
}