$("#selectbug2").change(function(){
		$.post("BugWebsiteCategory",{
			"origin":$("#selectbug2").val()
		},function(data,status){
			if(status == "success"){
				var query = $.parseJSON(data);
				var str = '<option>請選擇分類</option>'
				$.each(query,function(index, json){
					str += ' <option value="'+json.cateUrl+'">'+json.catagory+'</option>'    
				})
				$("#selectbug3").html(str);
			}
		})
	})
	
	$("#selectbug3").next().next().click(function(){
		var pic = '<div style="text-align:center;width:100%;"><img style="margin:300px auto;" src="image/loading.gif" width="200px"></div>'
		$("#bugpage").children(":first-child").html(pic);
		$.post("BugWebsite",{
			"orgin":$("#selectbug2").val(),
			"page":$("#selectbug3").val()
		},function(data, status){
			if(status == "success"){
				var query = $.parseJSON(data);
				var str = '<table class="mytable table-striped">';
				var count = 1;
             str += '<thead><tr><th scope="col">#</th><th scope="col">商品圖片</th><th scope="col">商品名稱</th><th scope="col">商品價格</th></tr></thead><tbody>'
				$.each(query,function(index, json){
					str += '<tr class="forhide"><th scope="row">' + (count++) + '</th><td><img src="http://www.gh3c.com.tw/' + json.picture +'" width="100px" ></td><td>' +json.proName +'</td><td>' + json.price + '</td></tr>' 
				})
				str += '</tbody></table>'
				$("#bugpage").children(":first-child").html(str);
			}
		})
	})
	
	$("#selectbug3").change(function(){
		$.post("ShowProductByCategory",{
			"category":$("#selectbug3").find("option:selected").text()
		},function(data, status){
			if(status == "success"){
				var quertData = $.parseJSON(data)
				var bugselect = "<option>請選擇型號</option>";
				$.each(quertData, function(index,json){
					bugselect += '<option value="'+json.price+'">' + json.model + '</option>' 
				})
				$("#selectbug1").html(bugselect)
			}
		})
	})
	
		$("#selectbug1").next().next().click(function(){
			var text ='<div class="card" style="width: 15rem; padding: 10px;">'+
			'<img class="card-img-top" src="image/'+$("#selectbug1").find("option:selected").text()+'.jpg" width="100px" height="220px" alt="Card image cap">'+
			'<div class="card-body">'+
			'<h5 class="card-title">'+$("#selectbug1").find("option:selected").text()+'</h5>'+
			'<h5 class="card-title" style="color: red">$'+$("#selectbug1").val()+'</h5>'+
            '</div></div>'
            $("#showpro").html(text);
            $(".forhide").hide();
            var tr_len = $(".mytable tr").length
            var choose = $("#selectbug1").find("option:selected").text().split(" ")
            var choose_len = choose.length;
            var show = ""
            var flag = false;
            $(".mytable tr").each(function(){          	
                var count = 0;
                for(var i = 0 ; i < choose_len ; i++){
                	if(($(this).children().eq(2).text().toLowerCase()).indexOf(choose[i].toLowerCase())!=-1){
                		show = $(this)
                		count++;
                		if(count == choose_len){
                			$(this).show();
                			flag = true;
                		}
                	}
                }
            })
            if(!flag){
            	$("#bugpage").children(":first-child").children(":first-child").append('<p class="forhide">商城無此項商品</p>');
            }
	})