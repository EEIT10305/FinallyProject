 var removesrc="";
 var addid="";       
 var removepro="";  
 var amount ;//得到一開始的上架圖片數用
        $(function () {//iframe接受資訊並傳回對應訊息
            window.addEventListener('message', (event) => {
                if (event.data == "card") {//--------------------推薦商品
                    window.frames[0].postMessage("cardback", '*');
                    
                    $("#forremove2").show();
                    $("#forremove").hide();
                    $("#changemodel2").show();
                    $("#changemodel").hide();
                    $("#area1").text("首頁推薦商品");
                    $("#area2").text("上架商品");
            
                    //--------------------------------------------------------------------------------------------------------------------
                    $.post("HotController2",function(data, status) {//-----------------------推薦商品不要的
            			if (status == "success") {
            				var querydata = $.parseJSON(data);
                            var text = '';
                            var bugsel = '<option>---</option>';
            				$.each(querydata, function(index, json) {
            					text +='<li><table style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)" id = "'+json.proid+'"><tr><td><img src="image/'+json.model+'.jpg" width="30px" ></td><td>'+json.brandBean.brand+'</td><td>'+json.categoryBean.category+'</td><td>'+json.model+'</td><td>'+json.price+'</td></tr></table></li>';							
            				
            				})
            				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
            				
            				var flag3 = true;
            				$("#fordatainput2 li").dblclick(function (){//雙擊變色
            					flag1=false;//防止觸發mouseleave事件
            					removepro= $(this).children().attr("id");//給remove按鈕抓值用
            					if(flag3){
                					$(this).css("background","grey")  
                					flag3 = false;
            					}else{
                					$(this).css("background","whitesmoke")
                					flag3 = true;
            					}
            				})
           				 var flag1 = false;
        				 var change = "";
        				 amount = $('#fordatainput').children().length;
        				 alert("111: "+amount);
        				 $("#fordatainput2 li").mouseup(function(){
        					 flag1 = true;
        				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換商品順序
        					 if(flag1){
        						 flag1 = false;
        						 var str = $("#fordatainput li").eq(0).children().attr("id");
        						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
        					        str += "," + $("#fordatainput li").eq(i).children().attr("id");
        						 }
        						 $.post("ChangeHotController",{
        							 "str":str,
        							 "change":change,
        							 "amount":amount
        						 },function(){
        							 if (status == "success") {
        		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
        		            				amount = $('#fordatainput').children().length;
        		            				alert("222:"+amount);
        						     }
        						 })
        					     	 
        					 }
        				 });
            			    }
            			})
                    $.post("HotController",function(data, status) {//-----------------------推薦商品要的
            			if (status == "success") {
            				var querydata = $.parseJSON(data);
                            var text = '';
            				$.each(querydata, function(index, json) {
            					text +='<li><table style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)" id = "'+json.proid+'"><tr><td><img src="image/'+json.model+'.jpg" width="30px" ></td><td>'+json.brandBean.brand+'</td><td>'+json.categoryBean.category+'</td><td>'+json.model+'</td><td>'+json.price+'</td></tr></table></li>';							

            				})  
            				$("#fordatainput").html(text);//資料庫拉到的資料放到<ol>標籤
            				
            				var flag2 = true;
            				$("#fordatainput li").dblclick(function (){//雙擊變色
            					flag1=false;//防止觸發mouseleave事件
            					removesrc= $(this).children().attr("src");//給remove按鈕抓值用
            					if(flag2){
                					$(this).css("background","grey")  
                					flag2 = false;
            					}else{
                					$(this).css("background","whitesmoke")
                					flag2 = true;
            					}
            				})
            				


                             $("#fordatainput").sortable({//排序功能 
                            	 cursor: "move"//游標便十字
                             });
            				 $("#fordatainput2").sortable({//排序功能 
            					 connectWith: "#fordatainput"
                             });
                             $("#fordatainput2").sortable({//排序功能 
                            	 cursor: "move"//游標便十字
                             });
            				 $("#fordatainput").sortable({//排序功能 
            					 connectWith: "#fordatainput2"
                             });
            				 
            				 var flag1 = false;
            				 var change = "";
            				 amount = $('#fordatainput').children().length;
            				 $("#fordatainput li").mouseup(function(){
            					 flag1 = true;
            					 change = $(this).children().attr("id");
            				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換商品順序
            					 if(flag1){
            						 flag1 = false;
            						 var str = $("#fordatainput li").eq(0).children().attr("id");
            						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
            					        str += "," + $("#fordatainput li").eq(i).children().attr("id");
            						 }
            						 
            						 $.post("ChangeHotController",{
            							 "str":str,
            							 "change":change,
            							 "amount":amount
            						 },function(){
            							 if (status == "success") {
            		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
            		            				amount = $('#fordatainput').children().length;
            		            				alert("333:"+amount);
            						     }
            						 })
            					     	 
            					 }
            				 });
            				
            			}})
                    
                }else if(event.data == "wall"){//輪播牆區--------------------------------------------------------------
                    window.frames[0].postMessage("wallback", '*');
                    
                    $("#forremove").show();
                    $("#forremove2").hide();
                    $("#changemodel").show();
                    $("#changemodel2").hide();
                    $("#area1").text("首頁輪播牆");
                    $("#area2").text("暫存區");
                    
                    var amount = 0;//得到一開始的上架圖片數用
                    $.post("WallController2",function(data, status) {//-----------------------輪播牆不要的
            			if (status == "success") {
            				var querydata = $.parseJSON(data);
                            var text = '';
            				$.each(querydata, function(index, json) {
            					text +='<li style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)"><img src="'+json.photosrc+'" width="150px"></li>';							

            				})
            				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
            			    }
            			})
                    $.post("WallController",function(data, status) {//-----------------------輪播牆要的
            			if (status == "success") {
            				var querydata = $.parseJSON(data);
                            var text = '';
            				$.each(querydata, function(index, json) {
            					text +='<li style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)"><img src="'+json.photosrc+'" width="150px"></li>';							

            				})  
            				$("#fordatainput").html(text);//資料庫拉到的資料放到<ol>標籤
            				
            				var flag2 = true;
            				$("#fordatainput li").dblclick(function (){//雙擊變色
            					flag1=false;//防止觸發mouseleave事件
            					removesrc= $(this).children().attr("src");//給remove按鈕抓值用
            					if(flag2){
                					$(this).css("background","grey")  
                					flag2 = false;
            					}else{
                					$(this).css("background","whitesmoke")
                					flag1 = true;
            					}
            				})
            				
            				var flag3 = true;
            				$("#fordatainput2 li").dblclick(function (){//雙擊變色
            					flag1=false;//防止觸發mouseleave事件
            					removesrc= $(this).children().attr("src");//給remove按鈕抓值用
            					if(flag3){
                					$(this).css("background","grey")  
                					flag3 = false;
            					}else{
                					$(this).css("background","whitesmoke")
                					flag3 = true;
            					}
            				})

                             $("#fordatainput").sortable({//排序功能 
                            	 cursor: "move"//游標便十字
                             });
            				 $("#fordatainput2").sortable({//排序功能 
            					 connectWith: "#fordatainput"//游標便十字
                             });
                             $("#fordatainput2").sortable({//排序功能 
                            	 cursor: "move"//游標便十字
                             });
            				 $("#fordatainput").sortable({//排序功能 
            					 connectWith: "#fordatainput2"//游標便十字
                             });
            				 
            				 var flag1 = false;
            				 var change = "";
            				 amount = $('#fordatainput').children().length;
            				 $(".forinput li").mouseup(function(){
            					 flag1 = true;
            					 change = $(this).children().attr("src");
            				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換圖片順序
            					 if(flag1){
            						 var str = $("#fordatainput li").eq(0).children().attr("src");
            						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
            					        str += "," + $("#fordatainput li").eq(i).children().attr("src");
            						 }
            						 
            						 $.post("ChangePicController",{
            							 "str":str,
            							 "change":change,
            							 "amount": amount
            						 },function(){
            							 if (status == "success") {
            		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
            		            				amount = $('#fordatainput').children().length;
            						     }
            						 })
            					     flag1 = false;	 
            					 }
            				 });
            				
            			}})
			
                }
            });
        });
        
        
        
        var now=""
        function click1(id){
        	$(now).hide();//把前一個顯示的畫面隱藏
        	$(id).show();//秀新的畫面
        	now = $(id);
        }
        

        $(document).ready(function () {
        	//一開始畫面先藏起來後面有按上面的項目再顯示
            $("#pagestyle").hide();
            $("#bugpage").hide();
    
            var data=""
        	    $("#uploadfile").change(function (e) {
        	         var theFiles = document.getElementById("uploadfile").files;
        	         var theFilesLen = theFiles.length;

        	         for (var i = 0; i < theFilesLen; i++) {
        	             var theFile = theFiles[i];
        	             var reader = new FileReader();
        	             reader.addEventListener("load", function (e) {
        	             fileContent = e.target.result;
        	             var ingObj = document.createElement("img");
        	             ingObj.setAttribute("src",fileContent);
        	             ingObj.setAttribute("width","100px");
        	             document.getElementById("showphoto").appendChild(ingObj);
        	             });
        	         }
        	             reader.readAsDataURL(theFile);
        	         })
        	         
        	    $("#forremove").click(function(){
        	    	$.post("RemovePhoto",{
        	    		"removesrc":removesrc
        	    	},function(){
        				$.post("WallController2",function(data, status) {//-----------------------輪播牆不要的
                			if (status == "success") {
                				var querydata = $.parseJSON(data);
                                var text = '';
                				$.each(querydata, function(index, json) {
                					text +='<li style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)"><img src="'+json.photosrc+'" width="150px"></li>';							
                				})
                				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
                				flag3=true;
                				$("#fordatainput2 li").dblclick(function (){//雙擊變色
                					flag1=false;//防止觸發mouseleave事件
                					removesrc= $(this).children().attr("src");//給remove按鈕抓值用
                					if(flag3){
                    					$(this).css("background","grey")  
                    					flag3 = false;
                					}else{
                    					$(this).css("background","whitesmoke")
                    					flag3 = true;
                					}
                				})
                				
                				flag1=false;
                				amount = $('#fordatainput').children().length;
                  				 $(".forinput li").mouseup(function(){
               					 flag1 = true;
               					 change = $(this).children().attr("src");
               				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換圖片順序
               					 if(flag1){
               						 var str = $("#fordatainput li").eq(0).children().attr("src");
               						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
               					        str += "," + $("#fordatainput li").eq(i).children().attr("src");
               						 }
               						 
               						 $.post("ChangePicController",{
               							 "str":str,
               							 "change":change,
               							 "amount": amount
               						 },function(){
               							 if (status == "success") {
               		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
               		            				amount = $('#fordatainput').children().length;
               						     }
               						 })
               					     flag1 = false;	 
               					 }
               				 });
                			    }
        				
                			})
                			
        				})
        	    	})
        	    	
         $("#forremove2").click(function(){
        	    	$.post("RemoveProduct",{
        	    		"removepro":removepro
        	    	},function(){
        	    		$.post("HotController2",function(data, status) {//-----------------------輪播牆不要的
        	    			if (status == "success") {
                				var querydata = $.parseJSON(data);
                                var text = '';
                				$.each(querydata, function(index, json) {
                					text +='<li><table style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)" id = "'+json.proid+'"><tr><td><img src="image/'+json.model+'.jpg" width="30px" ></td><td>'+json.brandBean.brand+'</td><td>'+json.categoryBean.category+'</td><td>'+json.model+'</td><td>'+json.price+'</td></tr></table></li>';							
                				})
                				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
                			    
                				var flag3=true;
                				$("#fordatainput2 li").dblclick(function (){//雙擊變色
                					flag1=false;//防止觸發mouseleave事件
                					removepro= $(this).children().attr("id");//給remove按鈕抓值用
                					if(flag3){
                    					$(this).css("background","grey")  
                    					flag3 = false;
                					}else{
                    					$(this).css("background","whitesmoke")
                    					flag3 = true;
                					}
                				})
                				
                				var flag1=false;
                				amount = $('#fordatainput').children().length;
               				 $(".forinput li").mouseup(function(){
            					 flag1 = true;
            					 change = $(this).children().attr("id");
            				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換圖片順序
            					 if(flag1){
            						 var str = $("#fordatainput li").eq(0).children().attr("id");
            						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
            					        str += "," + $("#fordatainput li").eq(i).children().attr("id");
            						 }
            						 $.post("ChangeHotController",{
            							 "str":str,
            							 "change":change,
            							 "amount": amount
            						 },function(){
            							 if (status == "success") {
            		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
            		            				amount = $('#fordatainput').children().length;
            						     }
            						 })
            					     flag1 = false;	 
            					 }
            				 });
                			    }
                			})
        	    		
        	    	})
        	    	})
        	    
        	    
        	    $("#foraddbtn").click(function(){
        	    	$("#showphoto").html("");
        	    	$.post("AddPhoto",{
        	    		"upload_file":$("#uploadfile").val()
        	    	},function(){
        	    		$.post("WallController2",function(data, status) {//-----------------------輪播牆不要的
                			if (status == "success") {
                				var querydata = $.parseJSON(data);
                                var text = '';
                				$.each(querydata, function(index, json) {
                					text +='<li style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)"><img src="'+json.photosrc+'" width="150px"></li>';							
                				})
                				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
                				var flag3=true;
                				$("#fordatainput2 li").dblclick(function (){//雙擊變色
                					flag1=false;//防止觸發mouseleave事件
                					removesrc= $(this).children().attr("src");//給remove按鈕抓值用
                					if(flag3){
                    					$(this).css("background","grey")  
                    					flag3 = false;
                					}else{
                    					$(this).css("background","whitesmoke")
                    					flag3 = true;
                					}
                				})
               				 var flag1 = false;
               				 var change = "";
               				 amount = $('#fordatainput').children().length;
               				 $(".forinput li").mouseup(function(){
               					 flag1 = true;
               					 change = $(this).children().attr("src");
               				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換圖片順序
               					 if(flag1){
               						 var str = $("#fordatainput li").eq(0).children().attr("src");
               						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
               					        str += "," + $("#fordatainput li").eq(i).children().attr("src");
               						 }
               						 
               						 $.post("ChangePicController",{
               							 "str":str,
               							 "change":change,
               							 "amount": amount
               						 },function(){
               							 if (status == "success") {
               		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
               		            				amount = $('#fordatainput').children().length;
               						     }
               						 })
               					     flag1 = false;	 
               					 }
               				 });
                			    }
                			})
        	    		
        	    	})
        	    })
        	    
        	    
        	        $("#foraddbtn2").click(function(){
        	        	$("#showphoto2").html("");
        	    	$.post("AddProduct",{
        	    		"addid":addid
        	    	},function(){
        	    		$.post("HotController2",function(data, status) {//-----------------------輪播牆不要的
        	    			if (status == "success") {
                				var querydata = $.parseJSON(data);
                                var text = '';
                				$.each(querydata, function(index, json) {
                					text +='<li><table style="text-align:center;height:50px;border:1px solid rgb(63, 60, 60)" id = "'+json.proid+'"><tr><td><img src="image/'+json.model+'.jpg" width="30px" ></td><td>'+json.brandBean.brand+'</td><td>'+json.categoryBean.category+'</td><td>'+json.model+'</td><td>'+json.price+'</td></tr></table></li>';							
                				})
                				$("#fordatainput2").html(text);//資料庫拉到的資料放到<ol>標籤
                			    
                				var flag3=true;
                				$("#fordatainput2 li").dblclick(function (){//雙擊變色
                					flag1=false;//防止觸發mouseleave事件
                					removepro= $(this).children().attr("id");//給remove按鈕抓值用
                					if(flag3){
                    					$(this).css("background","grey")  
                    					flag3 = false;
                					}else{
                    					$(this).css("background","whitesmoke")
                    					flag3 = true;
                					}
                				})
               				 var flag1 = false;
               				 var change = "";
               				 amount = $('#fordatainput').children().length;
               				 $(".forinput li").mouseup(function(){
               					 flag1 = true;
               					 change = $(this).children().attr("id");
               				 }).mouseleave(function(){//滑鼠離開觸發進資料庫更換圖片順序
               					 if(flag1){
               						 var str = $("#fordatainput li").eq(0).children().attr("id");
               						 for(var i = 1 ; i < $('#fordatainput').children().length ; i ++){
               					        str += "," + $("#fordatainput li").eq(i).children().attr("id");
               						 }
               						 
               						 $.post("ChangeHotController",{
               							 "str":str,
               							 "change":change,
               							 "amount": amount
               						 },function(){
               							 if (status == "success") {
               		            				$('iframe')[0].contentWindow.location.reload(true);//成功之後重新整理
               		            				amount = $('#fordatainput').children().length;
               						     }
               						 })
               					     flag1 = false;	 
               					 }
               				 });
                			    }
                			})
        	    		
        	    	})
        	    })
        	    
        	    $("#changemodel2").click(function(){
                    $.post("GetUpProduct",function(data, status){       //產生欲上架的商品 
                    	if (status == "success") {
            				var querydata = $.parseJSON(data);
                            var text = '<option>---</option>';
            				$.each(querydata, function(index, json) {
            					text +='<option value="'+json.model+','+json.price+','+json.proid+'" >'+json.model+'</option>';							
            				})
            				
            				$("#select1").html(text);
            				$("#select1").change(function(){
            					var split = $("#select1").val().split(",");
            					addid = split[2]
            					text=""
            					text +='<div class="card" style="width: 18rem; padding: 10px;">'+
            					'<img class="card-img-top" src="image/'+split[0]+'.jpg" width="100px" alt="Card image cap">'+
            					'<div class="card-body">'+
            					'<a href="#"> <img src="image/heart.png" width="20px"></a>'+
            					'<h5 class="card-title">'+split[0]+'</h5>'+
            					'<h5 class="card-title" style="color: red">$'+split[1]+'</h5>'+
            					'<a href="#" class="btn btn-danger">加入購物車 <img src="image/shopping-cart (1).png" width="20px"></a>'+
            			         '</div></div>'			
 
            					$("#select1").parent().append(text);
            						
            					
            				})
            				
            			}
                    })
                    
        	    	
        	    })

        })
