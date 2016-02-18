//@ sourceURL=edit_part.js
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

	var diaryTime = $("#diaryTime").datepicker({
		dateFormat : 'yy-mm-dd',
		beforeShow : function(input) {
			$(input).css({
				position : 'relative',
				zIndex : '1000'
			});
		}
	});

	var src = $("#edit_part").attr("src");
	var id = $.getUrlParam(src.substring(src.indexOf('?') + 1), "id");
	if (id == null) {
		return;
	}
	$.ajax({
		url : "api/diary/" + id,
		type : "GET",
		success : function(result) {
			var diary = eval(result);
			if (diary != null) {
				currentTime.datepicker("setDate", diary.lastUpdateDate);
				diaryTime.datepicker("setDate", diary.date);
				$("#weather").val(diary.weather);
				$("#title").val(diary.title);
				ue.ready(function() {
					ue.setContent(diary.content);
				});
			}
		},
		error : function() {
			alert('读取失败,请联系管理员');
		}
	});
	// After saving, jump to view page.
	var showView = function(id) {
		var mockAnchor = document.createElement("a")
		mockAnchor.href = "view_part.jsp?id=" + id;
		var $workspace = $('#main');
		$(mockAnchor).loadingbar({
			target : "#loadingbar-frame",
			replaceURL : false,
			direction : "right",
			/* Default Ajax Parameters. */
			async : true,
			complete : function(xhr, text) {
			},
			cache : true,
			error : function(xhr, text, e) {
			},
			global : true,
			headers : {},
			statusCode : {},
			success : function(data, text, xhr) {
				$workspace.html(data);
			},
			dataType : "html",
			done : function(data) {
			}
		});
		$(mockAnchor).click();
	}
	$("#save").click(function() {
		var req = {
			"date" : $("#diaryTime").val(),
			"weather" : $("#weather").val(),
			"title" : $("#title").val(),
			"content" : UE.getEditor("editor").getContent()
		};
		$.ajax({
			url : "api/diary",
			type : "PUT",
			data : JSON.stringify(req),
			contentType : "application/json;",
			success : function(result) {
				if (eval(result)) {
					alert('保存成功');
					showView(result.id);
				} else {
					alert('异常，请联系管理员');
				}
			},
			error : function() {
				alert('保存失败,请联系管理员error');
			}
		});
	});

}(window.jQuery);