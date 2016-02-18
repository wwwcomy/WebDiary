//@ sourceURL=view_part.js
void function($) {
	var src = $("#view_part").attr("src");
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
				$("#currentTime").html(
						"Last Update Time:" + diary.lastUpdateDate);
				$("#diaryTime").html(diary.date + " " + diary.weather);
				$("#title").html(diary.title);
				$("#content").html(diary.content);
			}
		},
		error : function() {
			alert('读取失败,请联系管理员');
		}
	});
	var $workspace = $('#main');
	$("#editBtn").loadingbar({
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
}(window.jQuery);