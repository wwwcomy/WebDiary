//@ sourceURL=view.js
void function($) {
	$.ajax({
		url : "api/diary/14",
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