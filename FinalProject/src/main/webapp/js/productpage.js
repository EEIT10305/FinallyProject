$(document).ready(function () {



            var querydata = $.parseJSON(sessionStorage.data);

            //   alert(sessionStorage.data)
            if (sessionStorage.data != "[]") {
                var products = sessionStorage.data.split("\"}},");  //把物件開算數量
                var amount = products.length;
                $("#proamount").html("相關商品共有 " + amount + " 項")

            } else if (sessionStorage.data == "[]") {
                $("#orderbywhat").hide();
            }
            //顯示現在位置
            if (sessionStorage.searchspace == "ini") {
                if (sessionStorage.brand == "ini" && sessionStorage.price == 0) {      //只搜類別      	
                    $("#wearehere").html("> " + sessionStorage.category)
                } else if (sessionStorage.brand != "ini" && sessionStorage.price == 0) {   //搜類別 品牌
                    $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand)
                } else if (sessionStorage.brand != "ini" && sessionStorage.price != 0) {  //搜類別 品牌 價格
                    if (sessionStorage.price == 1) {
                        $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand + " > $5000↓")
                    } else if (sessionStorage.price == 5000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand + " > $5000-$10000")
                    } else if (sessionStorage.price == 10000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand + " > $10000-$15000")
                    } else if (sessionStorage.price == 15000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand + " > $15000-$20000")
                    } else if (sessionStorage.price == 20000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > " + sessionStorage.brand + " > $20000↑")
                    }
                } else if (sessionStorage.brand == "ini" && sessionStorage.price != 0) {  //搜類別  價格
                    if (sessionStorage.price == 1) {
                        $("#wearehere").html("> " + sessionStorage.category + " > $5000↓")
                    } else if (sessionStorage.price == 5000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > $5000-$10000")
                    } else if (sessionStorage.price == 10000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > $10000-$15000")
                    } else if (sessionStorage.price == 15000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > $15000-$20000")
                    } else if (sessionStorage.price == 20000) {
                        $("#wearehere").html("> " + sessionStorage.category + " > $20000↑")
                    }
                }

            }

                 model = "";
                 price = "";

            $.each(querydata, function (index, json) {
            	model += json.model + ",";
                price += json.price + ",";
            })
            
            model = "zero," + model;
            price = "zero," + price;
//             alert(model)
            modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
            priceNoEnd = price.substring(0, price.lastIndexOf(","))
            
            modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
            priceArray = price.substring(0, price.lastIndexOf(",")).split(",")
            
           total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
           showamount = 4;              //一頁顯示幾筆
           page = Math.ceil(total/showamount);  //共幾頁
           
           a = 0;
           b = 0;
           c = 1;
           
           for(a=1; a<=page; a++){
        	   $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")
        	   for(b=c; b<=c+showamount-1; b++){
        		   if(b>total){
        			   break;
        		   }
        		   
        		   $("#page" + a).append(
        				    "<div style='display:inline width: 100px;'>"+
        				      '<div class="card" style="width: 18rem;padding:10px;">' +
                           '<img class="card-img-top" src="image/298ACE9CE1-Gd-7845503.jpg" width="100px" alt="Card image cap">' +
                           '<div class="card-body">' +
                           '<a href="#">' +
                           '<img src="image/heart.png" width="20px">' +
                           '</a>' +
                           '<span>' +
                           '<a href="#">' +
                           '<img src="image/football-signal-of-a-game-announcement-of-one-team-vs-other.png" width="20px">' +
                           '</a>' +
                           '</span>' +
                           "<h5 class='card-title'>" + modelArray[b] + "</h5>" +
                           "<h5 class='card-title' style='color:red'>$" + priceArray[b] + "</h5>" +
                           '<a href="#" class="btn btn-danger">加入購物車' +
                           '<img src="image/shopping-cart (1).png" width="20px">' +
                           '</a>' +
                           '</div>' +
                           '</div>' +
                           '</div>'   )
                           
        	   }
        	  
        	   c=b;       
        	   
        	   $("#pagebtn").append(
        			   '<li class="page-item"><a  id="changepagebtn'+ a +'" class="mypage-link" href="#">'+ a +'</a></li>'	   
        	   )        	   
        	   $("#page"+a).hide();
           }
           
           $("#page1").show();
           $("#changepagebtn1").parent().attr("class", "page-item active");
           $("#changepagebtn1").attr("class", "mypage-link mypagestyle"); 
           

    
           
           
           
        	   $("#changepagebtn1").click(function(){
               	$(".forcard").hide();
               	$("#page1").show();
               	for(d=1;d<=10;d++){
             	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                  $("#changepagebtn"+d).attr("class", "mypage-link");               		
               	}
             	$(this).parent().attr("class", "page-item active");
               	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn2").click(function(){
               	$(".forcard").hide();
               	$("#page2").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
               	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn3").click(function(){
               	$(".forcard").hide();
               	$("#page3").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn4").click(function(){
               	$(".forcard").hide();
               	$("#page4").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn5").click(function(){
               	$(".forcard").hide();
               	$("#page5").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn6").click(function(){
               	$(".forcard").hide();
               	$("#page6").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn7").click(function(){
               	$(".forcard").hide();
               	$("#page7").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn8").click(function(){
               	$(".forcard").hide();
               	$("#page8").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn9").click(function(){
               	$(".forcard").hide();
               	$("#page9").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               $("#changepagebtn10").click(function(){
               	$(".forcard").hide();
               	$("#page10").show();
               	for(d=1;d<=10;d++){
               	  $("#changepagebtn"+d).parent().attr("class", "page-item");
                    $("#changepagebtn"+d).attr("class", "mypage-link");               		
                 	}
               	$(this).parent().attr("class", "page-item active");
                 	$(this).attr("class", "mypage-link mypagestyle");
               })
               
               
           
            
            
            sessionStorage.category = "ini";
            sessionStorage.brand = "ini";
            sessionStorage.price = 0;
            sessionStorage.searchspace = "ini";
        }
        )
        
        
        //hhhhhhhhhhhhhhhhhhhhhhhhhhhh
        
         $(document).ready(function () {
            sessionStorage.category = "ini";
            sessionStorage.brand = "ini";
            sessionStorage.price = 0;
            sessionStorage.searchspace = "ini";


            $.get("SelectByCategory", function (data, status) {
                if (status == "success") {
                    var querydata = $.parseJSON(data);
                    $.each(querydata, function (index, json) {
                        $("#categorybtn").append("<button id='category" + json.code + "' name='category' class='dropdown-item menuitemstyle' type='button' value='"
                            + json.category + "'>" + json.category + "</button>");

                        document.getElementById("category" + json.code).addEventListener("click", clickcategory);

                    })

                    $('button.menuitemstyle').click(function () {
                        $(this).parent().siblings(".btnwidth").text($(this).text());
                    })
                    $('button[name="becheckbtn"]').next().hide();
                    $('button[name="category"]').click(function () {
                        $('button[name="becheckbtn"]').hide();
                        $('button[name="becheckbtn"]').next().show();
                    })



                }
            })





            function clickcategory() {
                $('#brandtitle').text("廠牌");
                $('#pricetitle').text("價格");
                $('#brandbtn').empty();
                document.getElementById("pricebtn1").addEventListener("click", clickprice);
                document.getElementById("pricebtn2").addEventListener("click", clickprice);
                document.getElementById("pricebtn3").addEventListener("click", clickprice);
                document.getElementById("pricebtn4").addEventListener("click", clickprice);
                document.getElementById("pricebtn5").addEventListener("click", clickprice);

                sessionStorage.category = event.target.value;

                //      傳category給brand標籤去搜尋producttable
                $.post("SelectByBrand", { "category": sessionStorage.category }, function (data, status) {
                    if (status == "success") {
                        var querydata = $.parseJSON(data);
                        $.each(querydata, function (index, json) {
                            $("#brandbtn").append("<button id='" + json.brand + "'name='brand' class='dropdown-item menuitemstyle' type='button' value='"
                                + json.brand + "'>" + json.brand + "</button>");
                            document.getElementById("" + json.brand).addEventListener("click", clickbrand);


                        })
                        $('button.menuitemstyle').click(function () {
                            $(this).parent().siblings(".btnwidth").text($(this).text());
                        })


                    }
                })

                function clickbrand() {
                    sessionStorage.brand = event.target.value;
                }
                function clickprice() {
                    sessionStorage.price = event.target.value;
                }


            }
        })
        
        //dddddddddddddddddddddddd
        
         $(document).ready(function () {
            document.getElementById("searchspace").addEventListener("blur", storesearchspace);   //存
            document.getElementById("searchspace").addEventListener("focus", removesearchspace);  //清除

            function storesearchspace() {
                sessionStorage.searchspace = event.target.value;
                //          alert(sessionStorage.searchspace);
            }
            function removesearchspace() {
                sessionStorage.searchspace = "ini";
                //  alert(sessionStorage.searchspace);
            }


            $("#searchbtn").click(function () {
                $.post("userInput", {
                    "category": sessionStorage.category,
                    "brand": sessionStorage.brand,
                    "price": sessionStorage.price,
                    "searchspace": sessionStorage.searchspace
                },
                    function (data, status) {
                        sessionStorage.data = data
                        // 		                    	 alert("要跳了 " + sessionStorage.data);
                        window.location.href = "http://localhost:8081/FinalProject/ProductPage.html";
                    }
                )
            })


        })

        //kkkkkkkkkkkkkkkkkkkkkkkkkkkkk
        
        //左邊按鈕即時顯示商品
        $(document).ready(function () {

            sessionStorage.leftcategory = "ini";
            sessionStorage.leftbrand = "ini";
            sessionStorage.leftprice = 0;



            //取得分類的選項
            $.ajax({
                url: "SelectByCategory",
                type: "get",
                success: function (data) {
                    var querydata = $.parseJSON(data);
                    $.each(querydata, function (index, json) {
                        $("#leftcategorybtn").append("<option  value='" + json.category + "'>" + json.category + "</option>")
                    })
                }
            })
            //左邊 分類有改變時               
            $("#leftcategorybtn").change(function () {
                sessionStorage.leftbrand = "ini";
                sessionStorage.leftprice = 0;
                sessionStorage.leftcategory = event.target.value;
                sessionStorage.data = "ini";
                //      	alert("sessiion " + sessionStorage.leftcategory);
                $("#leftpricebtn").show();
                $("#wearehere").html("> " + sessionStorage.leftcategory)

                $.ajax({
                    url: "showProductByCategory",
                    type: "post",
                    data: { "leftcategory": event.target.value },
                    success: function (data) {

                        if (data != "[]") {
                            var products = data.split("\"}},");  //把物件開算數量
                            var amount = products.length;
                            $("#proamount").html("相關商品共有 " + amount + " 項")
                            $("#orderbywhat").show();
                        } else if (data == "[]") {
                            $("#proamount").html("抱歉！搜尋不到相關商品")
                            $("#orderbywhat").hide();
                        }





                        $("#proall").empty();
                        var querydata = $.parseJSON(data);
                        $.each(querydata, function (index, json) {
                            $("#proall").append(
                                '<div class="card" style="width: 18rem;padding:10px;">' +
                                '<img class="card-img-top" src="image/298ACE9CE1-Gd-7845503.jpg" width="100px" alt="Card image cap">' +
                                '<div class="card-body">' +
                                '<a href="#">' +
                                '<img src="image/heart.png" width="20px">' +
                                '</a>' +
                                '<span>' +
                                '<a href="#">' +
                                '<img src="image/football-signal-of-a-game-announcement-of-one-team-vs-other.png" width="20px">' +
                                '</a>' +
                                '</span>' +
                                "<h5 class='card-title'>" + json.model + "</h5>" +
                                "<h5 class='card-title' style='color:red'>$" + json.price + "</h5>" +
                                '<a href="#" class="btn btn-danger">加入購物車' +
                                '<img src="image/shopping-cart (1).png" width="20px">' +
                                '</a>' +
                                '</div>' +
                                '</div>'

                            );
                        })
                    }
                })
                //左邊分類改變時 顯示對應品牌按鈕
                $.ajax({
                    type: "post",
                    url: "SelectByBrand",
                    data: { "category": sessionStorage.leftcategory },
                    success: function (data) {
                        $("#leftbrandbtn").empty();
                        var querydata = $.parseJSON(data);
                        $("#leftbrandbtn").append("<h5>廠牌</h5>");
                        $.each(querydata, function (index, json) {
                            $("#leftbrandbtn").append(
                                "<button id='left" + json.brand + "' name='leftbrand' + value='" + json.brand + "' class='badge badge-secondary'>" + json.brand + "</button>"
                            )
                            document.getElementById("left" + json.brand).addEventListener("click", clickleftbrand);
                        })




                    }
                });
                //按下左邊品牌按鈕時 顯示對應商品
                function clickleftbrand() {
                    sessionStorage.leftprice = 0;
                    sessionStorage.leftbrand = event.target.value;
                    //           alert("leftbrand= " + sessionStorage.leftbrand)
                    $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand)

                    $.ajax({
                        type: "post",
                        url: "leftTag",
                        data: {
                            "leftcategory": sessionStorage.leftcategory,
                            "leftbrand": sessionStorage.leftbrand,
                            "leftprice": sessionStorage.leftprice
                        },
                        success: function (data) {
                            if (data != "[]") {
                                var products = data.split("\"}},");  //把物件開算數量
                                var amount = products.length;
                                $("#proamount").html("相關商品共有 " + amount + " 項")
                                $("#orderbywhat").show();
                            } else if (data == "[]") {
                                $("#proamount").html("抱歉！搜尋不到相關商品")
                                $("#orderbywhat").hide();
                            }

                            $("#proall").empty();
                            var querydata = $.parseJSON(data);
                            $.each(querydata, function (index, json) {
                                $("#proall").append(
                                    '<div class="card" style="width: 18rem;padding:10px;">' +
                                    '<img class="card-img-top" src="image/298ACE9CE1-Gd-7845503.jpg" width="100px" alt="Card image cap">' +
                                    '<div class="card-body">' +
                                    '<a href="#">' +
                                    '<img src="image/heart.png" width="20px">' +
                                    '</a>' +
                                    '<span>' +
                                    '<a href="#">' +
                                    '<img src="image/football-signal-of-a-game-announcement-of-one-team-vs-other.png" width="20px">' +
                                    '</a>' +
                                    '</span>' +
                                    "<h5 class='card-title'>" + json.model + "</h5>" +
                                    "<h5 class='card-title' style='color:red'>$" + json.price + "</h5>" +
                                    '<a href="#" class="btn btn-danger">加入購物車' +
                                    '<img src="image/shopping-cart (1).png" width="20px">' +
                                    '</a>' +
                                    '</div>' +
                                    '</div>'

                                );
                            })
                        }
                    });
                } //  end of clickleftbrand() 
                $("#leftpricebtn1").click(clickleftprice)
                $("#leftpricebtn2").click(clickleftprice)
                $("#leftpricebtn3").click(clickleftprice)
                $("#leftpricebtn4").click(clickleftprice)
                $("#leftpricebtn5").click(clickleftprice)

                function clickleftprice() {
                    //     	  alert("win !")
                    sessionStorage.leftprice = event.target.value;
                    //           alert("leftprice= " + sessionStorage.leftprice)
                    if (sessionStorage.leftbrand != "ini") {   //有按品牌
                        if (sessionStorage.leftprice == 1) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand + " > $5000↓")
                        } else if (sessionStorage.leftprice == 5000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand + " > $5000-$10000")
                        } else if (sessionStorage.leftprice == 10000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand + " > $10000-$15000")
                        } else if (sessionStorage.leftprice == 15000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand + " > $15000-$20000")
                        } else if (sessionStorage.leftprice == 20000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > " + sessionStorage.leftbrand + " > $20000↑")
                        }
                    } else if (sessionStorage.leftbrand == "ini") {   //沒按品牌
                        if (sessionStorage.leftprice == 1) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > $5000↓")
                        } else if (sessionStorage.leftprice == 5000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > $5000-$10000")
                        } else if (sessionStorage.leftprice == 10000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > $10000-$15000")
                        } else if (sessionStorage.leftprice == 15000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > $15000-$20000")
                        } else if (sessionStorage.leftprice == 20000) {
                            $("#wearehere").html("> " + sessionStorage.leftcategory + " > $20000↑")
                        }
                    }


                    $.ajax({
                        type: "post",
                        url: "leftTag",
                        data: {
                            "leftcategory": sessionStorage.leftcategory,
                            "leftbrand": sessionStorage.leftbrand,
                            "leftprice": sessionStorage.leftprice
                        },
                        success: function (data) {

                            if (data != "[]") {
                                var products = data.split("\"}},");  //把物件分開算數量
                                var amount = products.length;
                                $("#proamount").html("相關商品共有 " + amount + " 項")
                                $("#orderbywhat").show();
                            } else if (data == "[]") {
                                $("#proamount").html("抱歉！搜尋不到相關商品")
                                $("#orderbywhat").hide();
                            }

                            $("#proall").empty();
                            var querydata = $.parseJSON(data);
                            $.each(querydata, function (index, json) {
                                $("#proall").append(
                                    '<div class="card" style="width: 18rem;padding:10px;">' +
                                    '<img class="card-img-top" src="image/298ACE9CE1-Gd-7845503.jpg" width="100px" alt="Card image cap">' +
                                    '<div class="card-body">' +
                                    '<a href="#">' +
                                    '<img src="image/heart.png" width="20px">' +
                                    '</a>' +
                                    '<span>' +
                                    '<a href="#">' +
                                    '<img src="image/football-signal-of-a-game-announcement-of-one-team-vs-other.png" width="20px">' +
                                    '</a>' +
                                    '</span>' +
                                    "<h5 class='card-title'>" + json.model + "</h5>" +
                                    "<h5 class='card-title' style='color:red'>$" + json.price + "</h5>" +
                                    '<a href="#" class="btn btn-danger">加入購物車' +
                                    '<img src="image/shopping-cart (1).png" width="20px">' +
                                    '</a>' +
                                    '</div>' +
                                    '</div>'

                                );
                            })

                        }
                    });
                } // end of clickleftprice() 



            })

        })