<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/bootstrap-treeview.css" rel="stylesheet">


<h1>Bootstrap Tree View - DOM Tree</h1>
<br />
<div class="row">
	<div class="col-sm-6">
		<label for="treeview"></label>
		<div id="treeview" />
	</div>
</div>
<script src="js/bootstrap-treeview.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "api/diary/date/14",
			type : "GET",
			success : function(result) {
				console.log(result);
				var dates = eval(result);
				console.log(dates);
				var defaultData = dates;
				var options = {
					//bootstrap2 : false, // no use.
					showTags : false,
					levels : 3,
					data : defaultData,
					color : "#428bca",
					enableLinks : true
				};
				$('#treeview').treeview(options);
			},
			error : function() {
				alert('读取失败,请联系管理员');
			}
		});
	});
</script>