	$("#chartselect").next().next().click(function(){
			$.post("ChartSelect", function(data, status) {
				if (status == "success") {
					var datata = [];
					var ticks = [];
					var query = $.parseJSON(data)
					var count = 0;
					var str= '<table class="mytable table-striped">';
					str +='<thead><tr><th scope="col">#</th><th scope="col">商品型號</th><th scope="col">商品數量</th></tr></thead><tbody>'
					$.each(query, function(index, json) {
                        var ele = new Array(count, json.sum);
						datata[index] = ele;
						var ele2 = new Array(count, json.pro.model);
						ticks[index] = ele2
						str += '<tr><td>' + (count+1) + '</td><td>' + json.pro.model +'</td><td>' + json.sum +'</td></tr>'
						count++;
					})
                    str += '</tbody></table>'
                    
					var dataset = [ {
						label : "數量",
						data : datata,
						color : "grey"
					} ];
			var options = {
				series : {
					bars : {
						show : true
					}
				},
				bars : {
					align : "center",
					barWidth : 0.1
				},
				xaxis : {
					axisLabel : "商品型號",
					axisLabelUseCanvas : true,
					axisLabelFontSizePixels : 12,
					axisLabelFontFamily : '微軟正黑體',
					axisLabelPadding : 20,
					ticks : ticks
				},
				yaxis : {
					axisLabel : "數量",
					axisLabelUseCanvas : true,
					axisLabelFontSizePixels : 12,
					axisLabelFontFamily : '微軟正黑體',
					axisLabelPadding : 3,
					tickFormatter : function(v, axis) {
						return v + "個";
					}
				},
				legend : {
					noColumns : 0,
					labelBoxBorderColor : "#000000",
					position : "nw"
				},
				grid : {
					hoverable : true,
					borderWidth : 2,
					backgroundColor : {
						colors : [ "#ffffff", "#EDF5FF" ]
					}
				}
			};
			$.plot($("#flot-placeholder"), dataset, options);
			   $("#flot-placeholder").next().html(str)
			   $("#flot-placeholder").UseTooltip();
				
				}
			})


		});
		
		   
		   function gd(year, month, day) {
	            return new Date(year, month, day).getTime();
	        }
	 
	        var previousPoint = null, previousLabel = null;
	 
	        $.fn.UseTooltip = function () {
	            $(this).bind("plothover", function (event, pos, item) {
	                if (item) {
	                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
	                        previousPoint = item.dataIndex;
	                        previousLabel = item.series.label;
	                        $("#tooltip").remove();
	 
	                        var x = item.datapoint[0];
	                        var y = item.datapoint[1];
	 
	                        var color = item.series.color;
	 
	                        //console.log(item.series.xaxis.ticks[x].label);                
	 
	                        showTooltip(item.pageX,
	                        item.pageY,
	                        color,
	                        "<strong>" + item.series.label + "</strong><br>" + item.series.xaxis.ticks[x].label + " : <strong>" + y + "</strong> 個");
	                    }
	                } else {
	                    $("#tooltip").remove();
	                    previousPoint = null;
	                }
	            });
	        };
	 
	        function showTooltip(x, y, color, contents) {
	            $('<div id="tooltip">' + contents + '</div>').css({
	                position: 'absolute',
	                display: 'none',
	                top: y - 40,
	                left: x - 120,
	                border: '2px solid ' + color,
	                padding: '3px',
	                'font-size': '9px',
	                'border-radius': '5px',
	                'background-color': '#fff',
	                'font-family': '微軟正黑體',
	                opacity: 0.9
	            }).appendTo("body").fadeIn(200);
	        }