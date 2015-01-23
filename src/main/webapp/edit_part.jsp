<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	window.UEDITOR_HOME_URL = "/WebDiary/js/ueditor/"
</script>
<script src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
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
<script src="js/main_edit.js"></script>
