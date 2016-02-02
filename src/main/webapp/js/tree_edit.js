//@ sourceURL=tree_edit.js
void function($) {
	var getTreeJson = function(data) {
		var treeJsonArray = new Array();
		var yearMap = new Object();
		yearMap.size = 0;
		for ( var date in data) {
			console.log(date + ":" + data[date]);
			var splits = date.split("-");
			var year = splits[0];
			var month = splits[1];
			var day = splits[2];
			if (yearMap[year] == null) {
				var i = yearMap.size;
				yearMap.size++;
				yearMap[year] = new Object();
				yearMap[year].index = 0;

				yearMap[year].size = 1;
				yearMap[year][month] = new Object();
				yearMap[year][month].index = 0;

				yearMap[year][month].size = 1;
				yearMap[year][month][day] = new Object();
				yearMap[year][month][day].index = 0;
				treeJsonArray[i] = new Object();
				var yearObj = treeJsonArray[i];
				yearObj.text = year;
				yearObj.nodes = new Array();
				yearObj.nodes[0] = new Object();
				var monthObj = yearObj.nodes[0];
				monthObj.text = month;
				monthObj.nodes = new Array();
				monthObj.nodes[0] = new Object();
				monthObj.nodes[0].text = day;
				monthObj.nodes[0].href = "#" + data[date];
			} else {
				var yearObj = treeJsonArray[yearMap[year].index];
				if (yearMap[year][month] == null) {
					var monthSize = yearMap[year].size;
					yearMap[year].size++;
					yearMap[year][month] = new Object();
					yearMap[year][month].index = monthSize;
					yearMap[year][month].size = 1;
					yearMap[year][month][day] = new Object();
					yearMap[year][month][day].index = 0;
					yearObj.nodes[monthSize] = new Object();
					yearObj.nodes[monthSize].text = month;
					yearObj.nodes[monthSize].nodes = new Array();
					yearObj.nodes[monthSize].nodes[0] = new Object();
					yearObj.nodes[monthSize].nodes[0].text = day;
					yearObj.nodes[monthSize].nodes[0].href = "#" + data[date];
				} else {
					if (yearMap[year][month][day] == null) {
						var daySize = yearMap[year][month].size;
						yearMap[year][month].size++;
						yearMap[year][month][day] = new Object();
						yearMap[year][month][day].index = daySize;
						yearObj.nodes[yearMap[year][month].index].nodes[daySize] = new Object();
						yearObj.nodes[yearMap[year][month].index].nodes[daySize].text = day;
						yearObj.nodes[yearMap[year][month].index].nodes[daySize].href = "#"
								+ data[date];
					} else {
						console.log("Two diaries in one day!")
					}
				}
			}
		}
		return treeJsonArray;
	}
	$.ajax({
		url : "api/diary/date/14",
		type : "GET",
		success : function(result) {
			var treeJson = getTreeJson(result);
			console.log(treeJson);
			var options = {
				showTags : false,
				levels : 3,
				data : treeJson,
				color : "#428bca",
				enableLinks : true
			};
			$('#treeview').treeview(options);
		},
		error : function() {
			alert('读取失败,请联系管理员');
		}
	});
}(window.jQuery);
