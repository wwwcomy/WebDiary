//@ sourceURL=view.js
void function($) {
	$.ajax({
		url : "api/diary/14",
		type : "GET",
		success : function(result) {
			var diary = eval(result);
			if (diary != null) {
				$("#currentTime").val(new Date(diary.lastUpdateDate));
				$("#diaryTime").val(new Date(diary.date));
				$("#weather").val(diary.weather);
				$("#title").val(diary.title);
				$("#content").html(diary.content);
			}
		},
		error : function() {
			alert('读取失败,请联系管理员');
		}
	});
}(window.jQuery);