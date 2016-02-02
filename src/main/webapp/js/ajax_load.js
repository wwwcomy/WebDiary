void function(_) {
	var $workspace = _('#main');
	_('.ws-load').each(function() {
		$(this).loadingbar({
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
	});
}(window.jQuery);