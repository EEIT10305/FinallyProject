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
                document.getElementById("pricebtn1").addEventListener("click",clickprice);
                document.getElementById("pricebtn2").addEventListener("click",clickprice);
                document.getElementById("pricebtn3").addEventListener("click",clickprice);
                document.getElementById("pricebtn4").addEventListener("click",clickprice);
                document.getElementById("pricebtn5").addEventListener("click",clickprice);
                
                sessionStorage.category = event.target.value;
             
                //      傳category給brand標籤去搜尋producttable
                $.post("SelectByBrand", { "category": sessionStorage.category }, function (data, status) {
                    if (status == "success") {
                        var querydata = $.parseJSON(data);
                        $.each(querydata, function (index, json) {
                            $("#brandbtn").append("<button id='" + json.brand + "'name='brand' class='dropdown-item menuitemstyle' type='button' value='"
                                + json.brand + "'>" + json.brand + "</button>");
                            document.getElementById(""+json.brand).addEventListener("click",clickbrand);
                            
           
                        })
                        $('button.menuitemstyle').click(function () {
                            $(this).parent().siblings(".btnwidth").text($(this).text());
                        })

                       
                    }
                })
                
                function clickbrand(){
                	sessionStorage.brand = event.target.value;
                }
                function clickprice(){
             	    sessionStorage.price = event.target.value;
                }


            }
        })

$(document).ready(function(){
    document.getElementById("searchspace").addEventListener("blur", storesearchspace);   //存
	document.getElementById("searchspace").addEventListener("focus", removesearchspace);  //清除

     function storesearchspace(){
         sessionStorage.searchspace = event.target.value;
//          alert(sessionStorage.searchspace);
     }	
     function removesearchspace(){
        sessionStorage.searchspace = "ini";
       //  alert(sessionStorage.searchspace);
     }
	
	
$("#searchbtn").click(function(){
	$.post("userInput",{"category":sessionStorage.category,
		                     "brand":sessionStorage.brand,
		                     "price":sessionStorage.price,
		                     "searchspace":sessionStorage.searchspace},  
		                     function(data,status){
		                    	 sessionStorage.data = data
// 		                    	 alert("要跳了 " + sessionStorage.data);

 		                    	 window.location.href="/FinalProject/ProductPage.html";
		                     }
			)
})
	
	
})
