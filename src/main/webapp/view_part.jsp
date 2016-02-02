<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="./css/blog.css" rel="stylesheet">
<script src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
<div class="blog-post">
	<h2 class="blog-post-title" id="title">Blog post</h2>
	<p class="blog-post-meta" id="diaryTime"></p>
	<!-- <p class="blog-post-meta" id="currentTime"></p> -->
	<p id="content"></p>
</div>
<script src="js/view.js?id=<%=request.getParameter("id")%>" id="view"></script>
