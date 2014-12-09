$(function() {
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
		beforeShow : function(input) {
			$(input).css({
				position : 'relative',
				zIndex : '1000'
			});
		},
		disabled : true
	});
	var d = new Date();
	var day = d.getDate();
	var month = d.getMonth() + 1;
	var year = d.getFullYear();
	currentTime.datepicker("setDate", day + "/" + month + "/" + year);

	$("#diaryTime").datepicker({
		beforeShow : function(input) {
			$(input).css({
				position : 'relative',
				zIndex : '1000'
			});
		}
	});
	$("#save").click(function() {
		$.ajax({
			url : "saveDiary.do",
			type : "POST",
			data : {
				date : $("#diaryTime").val(),
				lastUpdateDate : $("#currentTime").val(),
				content : UE.getEditor("editor").getContent()
			},
			success : function(result) {
				if (eval(result)) {
					alert('保存成功');
				} else {
					alert('登录异常，请联系管理员');
				}
			}
		});
	});
});