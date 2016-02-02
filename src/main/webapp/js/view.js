//@ sourceURL=view.js
void function($) {
	var src = $("#view").attr("src");
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
				$("#currentTime").html(diary.lastUpdateDate);
				$("#diaryTime").html(diary.date + " " + diary.weather);
				// $("#weather").html(diary.weather);
				$("#title").html(diary.title);
				$("#content").html(diary.content);
			}
		},
		error : function() {
			alert('读取失败,请联系管理员');
		}
	});
}(window.jQuery);