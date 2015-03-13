$(function() {

	$("#div_component").hide();
	
	/**
	 * 提交模板
	 */
	$(".submitTemp").click(
			function() {
				// 定义提交模板的后台路径
				var url = root + "/temp_manage/key/addTemp"
				if (!checkSub($("#addTemp"))) {
					return;
				}
				var flag = 1;
				$(".fileJPG").each(function() {
					if ($(this) == null || $(this).val() == "") {
						flag = 2;
						return;
					}
					if (!$(this).val().match(/.jpg|.gif|.png|.bmp/i)) {
						flag = 3;
						return;
					}
				});
				if (flag == 2) {
					alert("请选择模板缩略图并上传");
					return;
				}
				if (flag == 3) {
					alert("请上传文件格式为jsp,gif,png,bmp的图片格式的文件");
					return;
				}
				$("#addTemp").ajaxSubmit(
						{
							url : url,
							type : "post",
							dataType : "text",
							success : function(data) {
								alert("上传成功");
								window.location.href = root
										+ "/temp_manage/key/searchAllToAdmin";
							},
						});
			});

	/**
	 * 添加模板组件内容
	 */
	$(".addComponent").live("click", function() {
		var url = root + "/back_temp_manage/key/ajaxSearchComponent?componentData.type=1";
		$.ajax({
			type : 'POST',
			url : url,
			dataType : "text",
			success : function(data) {
				data = eval("(" + data + ")");
				$.each(data.list, function(i, item) {
					$("#select_component").append("<option value="+item.id+">"+item.type+"</option>")
					$("#div_component").show();
				});
			}
		});
	});
});