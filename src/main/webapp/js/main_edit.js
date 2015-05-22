void function($) {
	UE.getEditor('editor', {
		onready : function() {
			this.on('showmessage', function(type, m) {
				if (m['content'] == '本地保存成功') {
					return true;
				}
			});
		}
	});
	var ue = UE.getEditor('editor');
	var currentTime = $("#currentTime").datepicker({
		dateFormat : 'yy-mm-dd',
		beforeShow : function(input) {
			$(input).css({
				position : 'relative',
				zIndex : '1000'
			});
		},
		disabled : true
	});
	var d = new Date();
	currentTime.datepicker("setDate", d);

	$("#diaryTime").datepicker({
		dateFormat : 'yy-mm-dd',
		beforeShow : function(input) {
			$(input).css({
				position : 'relative',
				zIndex : '1000'
			});
		}
	});
	$("#save").click(function() {
		var req = {
			"date" : $("#diaryTime").val(),
			"lastUpdateDate" : $("#currentTime").val(),
			"content" : UE.getEditor("editor").getContent()
		};

		// req = "{\"first\":\"A\",\"second\":\"B\"}";
		$.ajax({
			url : "diary/saveDiary.do",
			type : "POST",
			data : JSON.stringify(req),
			contentType : "application/json;",
			success : function(result) {
				if (eval(result)) {
					alert('保存成功');
				} else {
					alert('异常，请联系管理员');
				}
			}
		});
	});
}(window.jQuery);