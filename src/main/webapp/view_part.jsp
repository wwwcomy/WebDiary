<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/jquery.json-2.4.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
<div>
	<label for="currentTime" class="">当前时间:</label><input type="text"
		id="currentTime" name="currentTime" />
</div>
<div>
	<label for="diaryTime" class="">日记时间:</label><input type="text"
		id="diaryTime" name="diaryTime" />
</div>
<div>
	<label for="weather" class="">天气</label> <input id="weather"
		name="weather" />
</div>
<div>
	<label for="title" class="">标题</label> <input id="title" name="title" />
</div>
<div id="content"></div>
<script src="js/view.js"></script>
