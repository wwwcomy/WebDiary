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

		var defaultData = [ {
			text : 'Parent 1',
			href : 'http://www.baidu.com',
			tags : [ '4' ],
			nodes : [ {
				text : 'Child 1',
				tags : [ '2' ],
				nodes : [ {
					text : 'Grandchild 1',
					href : '#grandchild1',
					tags : [ '0' ]
				}, {
					text : 'Grandchild 2',
					href : '#grandchild2',
					tags : [ '0' ]
				} ]
			}, {
				text : 'Child 2',
				href : '#child2',
				tags : [ '0' ]
			} ]
		}, {
			text : 'Parent 2',
			href : '#parent2',
			tags : [ '0' ]
		} ];

		var options = {
			//bootstrap2 : false, // no use.
			showTags : false,
			levels : 3,
			data : defaultData,
			color : "#428bca",
			enableLinks : true
		};

		$('#treeview').treeview(options);

	});
</script>