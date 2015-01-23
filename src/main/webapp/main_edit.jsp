<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Web Diary</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link href="js/jquery-ui-1.11.2/jquery-ui.css" rel="stylesheet">

<script src="js/ie-emulation-modes-warning.js"></script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
	<jsp:include page="include/top_nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="include/side_nav.jsp"></jsp:include>
			<div id="main"
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>
					当前时间:<input type="text" id="currentTime" />
				</div>
				<div>
					日记时间:<input type="text" id="diaryTime" />
				</div>
				<script id="editor" type="text/plain" style="height: 500px;"></script>
				<p align="right">
					<a id="save" class="btn btn-lg btn-success" role="button">Save</a>
				</p>
			</div>
		</div>
	</div>

	<script src="js/bootstrap.min.js"></script>
	<!-- <script src="js/docs.min.js"></script> -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/jquery-ui-1.11.2/jquery-ui.js"></script>
	<script src="js/main_edit.js"></script>
</body>
</html>