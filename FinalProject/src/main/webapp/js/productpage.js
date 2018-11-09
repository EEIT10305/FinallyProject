$(document).ready(function () {
	sessionStorage.CartId=1

    //顯示從firstpage搜尋到的產品
    //顯示從上方搜尋到的產品

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
    proid = "";

    $.each(querydata, function (index, json) {
        model += json.model + ",";
        price += json.price + ",";
        proid += json.proid + ",";
    })

    model = "zero," + model;
    price = "zero," + price;
    proid = "zero," + proid;
    //             alert(model)
    modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
    priceNoEnd = price.substring(0, price.lastIndexOf(","))

    modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
    priceArray = price.substring(0, price.lastIndexOf(",")).split(",")
    proidArray = proid.substring(0, proid.lastIndexOf(",")).split(",")

    total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
    showamount = 4;              //一頁顯示幾筆
    page = Math.ceil(total / showamount);  //共幾頁

    a = 0;
    b = 0;
    c = 1;

    $("#pagebtn").empty()
    
    for (a = 1; a <= page; a++) {
        $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")
        for (b = c; b <= c + showamount - 1; b++) {
            if (b > total) {
                break;
            }

            $("#page" + a).append(
                "<div style='display:inline width: 100px;'>" +
                '<div class="card" style="width: 15rem; padding: 10px;">' +
                '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
                '<div class="card-body">' +
                '<a style="cursor:pointer" id="wish'+proidArray[b]+'" value="'+proidArray[b]+'">' +
                '<img src="image/heart.png" width="20px">' +
                '</a>' +               
                "<h5 class='card-title'>" + modelArray[b] + "</h5>" +
                "<h5  class='card-title' style='color:red' >$" + priceArray[b] + "</h5>" +
                '<button style="cursor:pointer" id="add'+proidArray[b]+'" value="'+proidArray[b]+'" class="btn btn-danger">加入購物車' +
                '<img src="image/shopping-cart (1).png" width="20px">' +
                '</button>' +
                '</div>' +
                '</div>' +                
                '</div>')
            document.getElementById("add"+proidArray[b]).addEventListener("click",addToCart);       
            document.getElementById("wish"+proidArray[b]).addEventListener("click",addToWish);       
                
        }

        c = b;

        $("#pagebtn").append(
            '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
        )
        $("#page" + a).hide();
        document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
    }

    $("#page1").show();
    $("#changepagebtn1").parent().attr("class", "page-item active");
    $("#changepagebtn1").attr("class", "mypage-link mypagestyle");
    
//    var cookies = document.cookie;//先取cookie
//    var isUserInside = cookies.split("email=")[1].split(";")[0];
    var cookies = document.cookie;//先取cookie
    var isUserInside = cookies.split("email=")[1].split(";")[0];
    $.each(proidArray,function(index,proid){
    	if(proid!="zero"){
    		//庫存沒貨   變貨到通知我
    		$.post("selectStock",{"proid":proid},function(amount,status){
    			if(amount=='0'){
    				$("#add"+proid).html("貨到通知我");
    				$("#add"+proid).attr("class","btn btn-secondary");
    				document.getElementById("add"+proid).removeEventListener("click",addToCart);
    				$("#add"+proid).click(unavailable);    				
    			}
    		})
    		//已加入願望清單的話  變紅愛心
    		$.post("processFirstMemberLoadWish",{"proId":proid,"email":isUserInside},function(data,status){      //beanyeeeeeeeeeeeeee  搜尋願望清單有沒有資料
    			
    			if(data!=null){
    				$("#wish"+proid).find("img").attr("src","image/like.png");  				
                    document.getElementById("wish"+proid).removeEventListener("click",addToWish); 
                } 
    		})
    		
    	}
    })

 function unavailable(){
    	//沒貨    商品加入願望清單controller    	
    	var proid = $(this).attr("value");
//    	alert(proid);
    	$.post("unavailableXXXXXXXX",{"proid":proid},function(data,status){     //beanyeeeeeeeeeeeeee    點貨到通知我 加入願望清單  愛心也變紅
    		$("#wish"+proid).find("img").attr("src","image/like.png");
    		alert("商品已加入願望清單，抵達時會將通知您！")    		
    	})    	
    }
    function addToWish(){                                                           //beanyeeeeeeeeeeeeee   點白愛心 加入願望清單
        var proid =$(this).attr("value"); 
        $("#wish"+proid).find("img").attr("src","image/like.png");
//    	alert("wish " + proid )                           
    }
    
    function addToCart(){
//         alert($(this).prev().prev().text())
         $.ajax({
             type: "post",
             url: "AddtToCartController",
             data: {"model":$(this).prev().prev().text(),
            	    "CartId":sessionStorage.CartId},             
             success: function (data) {
                 alert("加入購物車成功！")
//                 alert(data)
             }
         });
    }

    function turnpage(){
    	$("#pagebtn li").attr("class","page-item");
    	$("#pagebtn li a").attr("class","mypage-link");
    	$(this).parent().attr("class", "page-item active");
        $(this).attr("class", "mypage-link mypagestyle");
        $(".forcard").hide();      
        $("#page" + $(this).html()).show();
    }

}
)


//上排顯示資料庫有的類別

$(document).ready(function () {
    //            sessionStorage.category = "ini";
    //            sessionStorage.brand = "ini";
    //            sessionStorage.price = 0;
    //            sessionStorage.searchspace = "ini";


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
        sessionStorage.brand = "ini";
        sessionStorage.price = 0;

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
                window.location.href = "/FinalProject/ProductPage.html";
            }
        )
    })


})



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
            $("#leftcategorybtn").append("<option  value='leftcategorynochoose'>請選擇分類</option>");
            $.each(querydata, function (index, json) {
                $("#leftcategorybtn").append("<option  value='" + json.category + "'>" + json.category + "</option>")
            })
        }
    })
    //左邊 分類有改變時               
    $("#leftcategorybtn").change(function () {
    	if($("#leftcategorybtn").val()!="leftcategorynochoose"){
        sessionStorage.category = "ini";
        sessionStorage.brand = "ini";
        sessionStorage.price = 0;
        sessionStorage.searchspace = "ini";


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

                //   換頁
                var querydata = $.parseJSON(data);

                model = "";
                price = "";

                $.each(querydata, function (index, json) {
                    model += json.model + ",";
                    price += json.price + ",";
                })

                model = "zero," + model;
                price = "zero," + price;
                //                    alert(model)
                modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
                priceNoEnd = price.substring(0, price.lastIndexOf(","))

                modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
                priceArray = price.substring(0, price.lastIndexOf(",")).split(",")

                total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
                showamount = 4;              //一頁顯示幾筆
                page = Math.ceil(total / showamount);  //共幾頁

                a = 0;
                b = 0;
                c = 1;

                //把之前搜尋的商品及按鈕刪掉
                for (a = 1; a <= 20; a++) {
                    $("#page" + a).remove();
                    $("#changepagebtn" + a).remove();

                }

                $("#pagebtn").empty();
                
                for (a = 1; a <= page; a++) {
                    $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")

                    for (b = c; b <= c + showamount - 1; b++) {
                        if (b > total) {
                            break;
                        }
                        $("#page" + a).append(
                            "<div style='display:inline width: 100px;'>" +
                            '<div class="card" style="width: 15rem; padding: 10px;">' +
                            '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
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
                            '<a href="#" id="add'+b+'" class="btn btn-danger">加入購物車' +
                            '<img src="image/shopping-cart (1).png" width="20px">' +
                            '</a>' +
                            '</div>' +
                            '</div>' +
                            '</div>')
                            document.getElementById("add"+b).addEventListener("click",addToCart); 
                    }

                    c = b;

                    $("#pagebtn").append(
                        '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
                    )
                    $("#page" + a).hide();
                    document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
                }

                $("#page1").show();
                $("#changepagebtn1").parent().attr("class", "page-item active");
                $("#changepagebtn1").attr("class", "mypage-link mypagestyle");

                function addToCart(){
//                    alert($(this).prev().prev().text())
                    $.ajax({
                        type: "post",
                        url: "AddtToCartController",
                        data: {"model":$(this).prev().prev().text(),
                       	    "CartId":sessionStorage.CartId},             
                        success: function (data) {
                            alert("加入購物車成功！")
//                            alert(data)
                        }
                    });
               }
                
                function turnpage(){
                	$("#pagebtn li").attr("class","page-item");
                	$("#pagebtn li a").attr("class","mypage-link");
                	$(this).parent().attr("class", "page-item active");
                    $(this).attr("class", "mypage-link mypagestyle");
                    $(".forcard").hide();      
                    $("#page" + $(this).html()).show();
                }

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


                    //   換頁
                    var querydata = $.parseJSON(data);

                    model = "";
                    price = "";
                    //                                count = 1;

                    $.each(querydata, function (index, json) {
                        //                           	$("#div"+count).append("<div id='img'"+count+" class='hide'>"+josn.model+"..</div>")
                        //                        	   
                        //                        	   if(index % 4 ==0){
                        //                           		count++
                        //                           	}


                        model += json.model + ",";
                        price += json.price + ",";
                    })

                    model = "zero," + model;
                    price = "zero," + price;
                    //                            alert(model)
                    modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
                    priceNoEnd = price.substring(0, price.lastIndexOf(","))

                    modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
                    priceArray = price.substring(0, price.lastIndexOf(",")).split(",")

                    total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
                    showamount = 4;              //一頁顯示幾筆
                    page = Math.ceil(total / showamount);  //共幾頁

                    a = 0;
                    b = 0;
                    c = 1;

                    //把之前搜尋的商品及按鈕刪掉
                    for (a = 1; a <= 20; a++) {
                        $("#page" + a).remove();
                        $("#changepagebtn" + a).remove();

                    }
                    $("#pagebtn").empty();

                    for (a = 1; a <= page; a++) {
                        $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")

                        for (b = c; b <= c + showamount - 1; b++) {
                            if (b > total) {
                                break;
                            }
                            $("#page" + a).append(
                                "<div style='display:inline width: 100px;'>" +
                                '<div class="card" style="width: 15rem; padding: 10px;">' +
                                '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
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
                                '<a href="#" id="add'+b+'" class="btn btn-danger">加入購物車' +
                                '<img src="image/shopping-cart (1).png" width="20px">' +
                                '</a>' +
                                '</div>' +
                                '</div>' +
                                '</div>')
                                document.getElementById("add"+b).addEventListener("click",addToCart); 
                        }

                        c = b;

                        $("#pagebtn").append(
                            '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
                        )
                        $("#page" + a).hide();
                        document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
                    }

                    $("#page1").show();
                    $("#changepagebtn1").parent().attr("class", "page-item active");
                    $("#changepagebtn1").attr("class", "mypage-link mypagestyle");

                    function addToCart(){
//                        alert($(this).prev().prev().text())
                        $.ajax({
                            type: "post",
                            url: "AddtToCartController",
                            data: {"model":$(this).prev().prev().text(),
                           	    "CartId":sessionStorage.CartId},             
                            success: function (data) {
                                alert("加入購物車成功！")
//                                alert(data)
                            }
                        });
                   }
                    
                    function turnpage(){
                    	$("#pagebtn li").attr("class","page-item");
                    	$("#pagebtn li a").attr("class","mypage-link");
                    	$(this).parent().attr("class", "page-item active");
                        $(this).attr("class", "mypage-link mypagestyle");
                        $(".forcard").hide();      
                        $("#page" + $(this).html()).show();
                    }

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


                    //   換頁
                    var querydata = $.parseJSON(data);

                    model = "";
                    price = "";

                    $.each(querydata, function (index, json) {
                        model += json.model + ",";
                        price += json.price + ",";
                    })

                    model = "zero," + model;
                    price = "zero," + price;
                    //                            alert(model)
                    modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
                    priceNoEnd = price.substring(0, price.lastIndexOf(","))

                    modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
                    priceArray = price.substring(0, price.lastIndexOf(",")).split(",")

                    total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
                    showamount = 4;              //一頁顯示幾筆
                    page = Math.ceil(total / showamount);  //共幾頁

                    a = 0;
                    b = 0;
                    c = 1;

                    //把之前搜尋的商品及按鈕刪掉
                    for (a = 1; a <= 20; a++) {
                        $("#page" + a).remove();
                        $("#changepagebtn" + a).remove();

                    }
                    $("#pagebtn").empty();

                    for (a = 1; a <= page; a++) {
                        $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")

                        for (b = c; b <= c + showamount - 1; b++) {
                            if (b > total) {
                                break;
                            }
                            $("#page" + a).append(
                                "<div style='display:inline width: 100px;'>" +
                                '<div class="card" style="width: 15rem; padding: 10px;">' +
                                '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
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
                                '<a href="#" id="add'+b+'" class="btn btn-danger">加入購物車' +
                                '<img src="image/shopping-cart (1).png" width="20px">' +
                                '</a>' +
                                '</div>' +
                                '</div>' +
                                '</div>')
                                document.getElementById("add"+b).addEventListener("click",addToCart);
                        }

                        c = b;

                        $("#pagebtn").append(
                            '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
                        )
                        $("#page" + a).hide();
                        document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
                    }

                    $("#page1").show();
                    $("#changepagebtn1").parent().attr("class", "page-item active");
                    $("#changepagebtn1").attr("class", "mypage-link mypagestyle");

                    function addToCart(){
//                        alert($(this).prev().prev().text())
                        $.ajax({
                            type: "post",
                            url: "AddtToCartController",
                            data: {"model":$(this).prev().prev().text(),
                           	    "CartId":sessionStorage.CartId},             
                            success: function (data) {
                                alert("加入購物車成功！")
//                                alert(data)
                            }
                        });
                   }
                    function turnpage(){
                    	$("#pagebtn li").attr("class","page-item");
                    	$("#pagebtn li a").attr("class","mypage-link");
                    	$(this).parent().attr("class", "page-item active");
                        $(this).attr("class", "mypage-link mypagestyle");
                        $(".forcard").hide();      
                        $("#page" + $(this).html()).show();
                    }

                }
            });
        } // end of clickleftprice() 

    }

    })

})
//依照價格排列
$(document).ready(function(){
     $("#orderbyprice").click(function(){
    	 $.ajax({
             type: "post",
             url: "orderByPrice",
             data:  {
            	 "category": sessionStorage.category,
                 "brand": sessionStorage.brand,
                 "price": sessionStorage.price,
                 "searchspace": sessionStorage.searchspace,
                 "leftcategory": sessionStorage.leftcategory,
                 "leftbrand": sessionStorage.leftbrand,
                 "leftprice": sessionStorage.leftprice,
             },        
             success: function (data,status) {
                
                  if (data != "[]") {
                        var products = data.split("\"}},");  //把物件分開算數量
                        var amount = products.length;
                        $("#proamount").html("相關商品共有 " + amount + " 項")
                        $("#orderbywhat").show();
                    } else if (data == "[]") {
                        $("#proamount").html("抱歉！搜尋不到相關商品")
                        $("#orderbywhat").hide();
                    }


                    //   換頁
                    var querydata = $.parseJSON(data);

                    model = "";
                    price = "";

                    $.each(querydata, function (index, json) {
                        model += json.model + ",";
                        price += json.price + ",";
                    })

                    model = "zero," + model;
                    price = "zero," + price;
                    //                            alert(model)
                    modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
                    priceNoEnd = price.substring(0, price.lastIndexOf(","))

                    modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
                    priceArray = price.substring(0, price.lastIndexOf(",")).split(",")

                    total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
                    showamount = 4;              //一頁顯示幾筆
                    page = Math.ceil(total / showamount);  //共幾頁

                    a = 0;
                    b = 0;
                    c = 1;

                    //把之前搜尋的商品及按鈕刪掉
                    for (a = 1; a <= 20; a++) {
                        $("#page" + a).remove();
                        $("#changepagebtn" + a).remove();

                    }
                    $("#pagebtn").empty();

                    for (a = 1; a <= page; a++) {
                        $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")

                        for (b = c; b <= c + showamount - 1; b++) {
                            if (b > total) {
                                break;
                            }
                            $("#page" + a).append(
                                "<div style='display:inline width: 100px;'>" +
                                '<div class="card" style="width: 15rem; padding: 10px;">' +
                                '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
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
                                '<a href="#" id="add'+b+'" class="btn btn-danger">加入購物車' +
                                '<img src="image/shopping-cart (1).png" width="20px">' +
                                '</a>' +
                                '</div>' +
                                '</div>' +
                                '</div>')
                                document.getElementById("add"+b).addEventListener("click",addToCart); 
                        }

                        c = b;

                        $("#pagebtn").append(
                            '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
                        )
                        $("#page" + a).hide();
                        document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
                    }

                    $("#page1").show();
                    $("#changepagebtn1").parent().attr("class", "page-item active");
                    $("#changepagebtn1").attr("class", "mypage-link mypagestyle");

                    function addToCart(){
//                        alert($(this).prev().prev().text())
                        $.ajax({
                            type: "post",
                            url: "AddtToCartController",
                            data: {"model":$(this).prev().prev().text(),
                           	    "CartId":sessionStorage.CartId},             
                            success: function (data) {
                                alert("加入購物車成功！")
//                                alert(data)
                            }
                        });
                   }
                    function turnpage(){
                    	$("#pagebtn li").attr("class","page-item");
                    	$("#pagebtn li a").attr("class","mypage-link");
                    	$(this).parent().attr("class", "page-item active");
                        $(this).attr("class", "mypage-link mypagestyle");
                        $(".forcard").hide();      
                        $("#page" + $(this).html()).show();
                    }


                 
             }
         });
    	 
    	 
    	 
     })     
	
})
		



//依照相關性排列
$(document).ready(function(){
     $("#orderByRelation").click(function(){
    	 $.ajax({
             type: "post",
             url: "orderByRelation",
             data:  {
            	 "category": sessionStorage.category,
                 "brand": sessionStorage.brand,
                 "price": sessionStorage.price,
                 "searchspace": sessionStorage.searchspace,
                 "leftcategory": sessionStorage.leftcategory,
                 "leftbrand": sessionStorage.leftbrand,
                 "leftprice": sessionStorage.leftprice,
             },        
             success: function (data,status) {
                
                  if (data != "[]") {
                        var products = data.split("\"}},");  //把物件分開算數量
                        var amount = products.length;
                        $("#proamount").html("相關商品共有 " + amount + " 項")
                        $("#orderbywhat").show();
                    } else if (data == "[]") {
                        $("#proamount").html("抱歉！搜尋不到相關商品")
                        $("#orderbywhat").hide();
                    }


                    //   換頁
                    var querydata = $.parseJSON(data);

                    model = "";
                    price = "";

                    $.each(querydata, function (index, json) {
                        model += json.model + ",";
                        price += json.price + ",";
                    })

                    model = "zero," + model;
                    price = "zero," + price;
                    //                            alert(model)
                    modelNoEnd = model.substring(0, model.lastIndexOf(","))   //去尾巴逗號
                    priceNoEnd = price.substring(0, price.lastIndexOf(","))

                    modelArray = model.substring(0, model.lastIndexOf(",")).split(",")    //拆開加入陣列
                    priceArray = price.substring(0, price.lastIndexOf(",")).split(",")

                    total = modelArray.length - 1;   //商品總筆數   - "zero" 那筆
                    showamount = 4;              //一頁顯示幾筆
                    page = Math.ceil(total / showamount);  //共幾頁

                    a = 0;
                    b = 0;
                    c = 1;

                    //把之前搜尋的商品及按鈕刪掉
                    for (a = 1; a <= 20; a++) {
                        $("#page" + a).remove();
                        $("#changepagebtn" + a).remove();

                    }

                    $("#pagebtn").empty()

                    for (a = 1; a <= page; a++) {
                        $("article").append("<div id='page" + a + "' class='forcard' ;' ></div>")

                        for (b = c; b <= c + showamount - 1; b++) {
                            if (b > total) {
                                break;
                            }
                            $("#page" + a).append(
                                "<div style='display:inline width: 100px;'>" +
                                '<div class="card" style="width: 15rem; padding: 10px;">' +
                                '<img class="card-img-top" src="image/'+ modelArray[b] +'.jpg" width="100px"  height="220px"  alt="Card image cap">' +
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
                                '<a href="#" id="add'+b+'" class="btn btn-danger">加入購物車' +
                                '<img src="image/shopping-cart (1).png" width="20px">' +
                                '</a>' +
                                '</div>' +
                                '</div>' +
                                '</div>')
                                document.getElementById("add"+b).addEventListener("click",addToCart); 
                        }

                        c = b;

                        $("#pagebtn").append(
                            '<li class="page-item"><a  id="changepagebtn' + a + '" class="mypage-link" value="'+a+'" >' + a + '</a></li>'
                        )
                        $("#page" + a).hide();
                        document.getElementById("changepagebtn" + a).addEventListener("click",turnpage);
                    }

                    $("#page1").show();
                    $("#changepagebtn1").parent().attr("class", "page-item active");
                    $("#changepagebtn1").attr("class", "mypage-link mypagestyle");

                    function addToCart(){
//                        alert($(this).prev().prev().text())
                        $.ajax({
                            type: "post",
                            url: "AddtToCartController",
                            data: {"model":$(this).prev().prev().text(),
                           	    "CartId":sessionStorage.CartId},             
                            success: function (data) {
                                alert("加入購物車成功！")
//                                alert(data)
                            }
                        });
                   }
                    function turnpage(){
                    	$("#pagebtn li").attr("class","page-item");
                    	$("#pagebtn li a").attr("class","mypage-link");
                    	$(this).parent().attr("class", "page-item active");
                        $(this).attr("class", "mypage-link mypagestyle");
                        $(".forcard").hide();      
                        $("#page" + $(this).html()).show();
                    }



             
             }
         });
     })     
	
})