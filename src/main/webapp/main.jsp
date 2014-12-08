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
<script src="js/ie-emulation-modes-warning.js"></script>

</head>

<body>

	<jsp:include page="top_nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="side_nav.jsp"></jsp:include>
			<div id="main" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- <h1 class="page-header">${loginUser.username}</h1>
				<h1 class="page-header">${loginUser.password}</h1>  -->
				<h1>Navbar example</h1>
		        <p>This example is a quick exercise to illustrate how the default, static navbar and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
		        <p align="center">
		          <a id="addNew" class="btn btn-lg btn-primary" role="button">Write a new one</a>
		        </p>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/docs.min.js"></script>
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/main.js"></script>
</body>
</html>