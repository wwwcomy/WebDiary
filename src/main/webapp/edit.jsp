<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Starter Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="js/jquery-ui-1.11.2/jquery-ui.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">

<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.all.min.js">
</script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
	<script type="text/javascript">
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
		});
	</script>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div>
			当前时间:<input type="text" id="currentTime" />
		</div>
		<div>
			日记时间:<input type="text" id="diaryTime" />
		</div>
		<script id="editor" type="text/plain" style="height: 500px;"></script>
		<p align="right">
			<a id="addNew" class="btn btn-lg btn-success" role="button">Save</a>
		</p>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/jquery-ui-1.11.2/jquery-ui.js"></script>
</body>
</html>
