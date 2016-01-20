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
<div class="row">
	<div class="col-sm-6">
		<label for="treeview2"></label>
		<div id="treeview2" />
	</div>
</div>
<script src="js/jquery-1.9.1.js"></script>
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
		}, {
			text : 'Parent 3',
			href : '#parent3',
			tags : [ '0' ]
		}, {
			text : 'Parent 4',
			href : '#parent4',
			tags : [ '0' ]
		}, {
			text : 'Parent 5',
			href : '#parent5',
			tags : [ '0' ]
		} ];

		var options = {
			//bootstrap2 : false, // no use.
			showTags : false,
			levels : 5,
			data : defaultData,
			color : "#428bca",
			enableLinks : true
		};

		$('#treeview').treeview(options);

		json = '[' + '{' + '"text": "Parent 1",' + '"nodes": [' + '{'
				+ '"text": "Child 1",' + '"nodes": [' + '{'
				+ '"text": "Grandchild 1"' + '},' + '{'
				+ '"text": "Grandchild 2"' + '}' + ']' + '},' + '{'
				+ '"text": "Child 2"' + '}' + ']' + '},' + '{'
				+ '"text": "Parent 2"' + '},' + '{' + '"text": "Parent 3"'
				+ '},' + '{' + '"text": "Parent 4"' + '},' + '{'
				+ '"text": "Parent 5"' + '}' + ']';

		json2 = [ {
			"text" : "p1",
			"nodes" : [ {
				"text" : "Child 1",
				"nodes" : [ {
					"text" : "Grandchild 1"
				}, {
					"text" : "Grandchild 2"
				} ]
			} ]
		}, {
			"text" : "p2"
		} ];

		var options2 = {
			//bootstrap2 : false, // no use.
			showTags : false,
			levels : 5,
			data : json2
		};

		$('#treeview2').treeview(options2);
	});
</script>