
//===============================首頁一載入時要做的判斷================================================

$(document).ready(function(){
   alert("近來網站之前有沒有先進來判斷cookie的方訊")
   var cookies = document.cookie;//先取cookie
  alert(cookies);

   if(cookies==null||cookies=="null"||cookies==""||typeof(cookies)=="undefined"||typeof(cookies)==undefined||typeof(cookies)=="false"||typeof(cookies)==false){//如果該使用者的cookie是空的
       alert('cookie是空的,秀出可登入圖示');    
    // $('#未登入的圖示').hide();//秀出登入圖示

   }else{//如果cookie不是空的
   alert('使用者cookie不是空的'); 
       if(cookies.indexOf("email=")!=-1){//    cookies.indexOf("email=");//-1是不存在
          alert('使用者有email的資訊,判斷是否為我們家的會員')
        var isUserInside = cookies.split("email=")[1].split(";")[0];
        alert('cookie內的email:'+isUserInside);//測試完刪除
           $.ajax({
               type: "POST",
               url: "processFirstUser",
               data: {email:isUserInside},
               success: function (data) {
                   
                //    alert(data);
                   
                   var returnData = $.parseJSON(data);
                   if(returnData.email==isUserInside){
                    alert('使用者的cookie內的mail資料是我們家的會員 隱藏登入按鈕!秀出會員按鈕');
                    //$('#已登入的圖示').hide();
                    $.ajax({
                        type: "POST",
                        url: "catchMemberCartId",
                        data: {
                            email: returnData.email, 
                        },
                        success: function (data) {
                            alert('有沒有抓到cartId??');
                            // alert(data);
                            sessionStorage.CartId=data;
                            alert('將cartId存入sessionStorage呢??：'+sessionStorage.CartId);
    
                            var Days = 30;//cookie設定30天
                            var exp = new Date();
                            exp.setTime(exp.getTime() + Days*24*60*60*1000);
                            document.cookie = "CartId=" + sessionStorage.CartId+";expires=" + exp.toGMTString();
                        }
                    });
                   }
                   else if(returnData.permission=="facebook"){
                        alert("已判斷使用者是facebook登入")
                        $.ajax({
                            type: "POST",
                            url: "catchMemberCartId",
                            data: {
                                email: returnData.email, 
                            },
                            success: function (data) {
                                alert('有沒有抓到cartId??');
                                // alert(data);
                                sessionStorage.CartId=data;
                                alert('將cartId存入sessionStorage呢??：'+sessionStorage.CartId);
        
                                var Days = 30;//cookie設定30天
                                var exp = new Date();
                                exp.setTime(exp.getTime() + Days*24*60*60*1000);
                                document.cookie = "CartId=" + sessionStorage.CartId+";expires=" + exp.toGMTString();
                            }
                        });
                        //$('#未登入的圖示').hide();
                   }
                   else if(returnData.permission=="google"){
                    alert("已判斷使用者是google登入")
                    $.ajax({
                        type: "POST",
                        url: "catchMemberCartId",
                        data: {
                            email: returnData.email, 
                        },
                        success: function (data) {
                            alert('有沒有抓到cartId??');
                            // alert(data);
                            sessionStorage.CartId=data;
                            alert('將cartId存入sessionStorage呢??：'+sessionStorage.CartId);
                            var Days = 30;//cookie設定30天
                            var exp = new Date();
                            exp.setTime(exp.getTime() + Days*24*60*60*1000);
                            document.cookie = "CartId=" + sessionStorage.CartId+";expires=" + exp.toGMTString();
                        }
                    });
                    //$('#未登入的圖示').hide();
                   }else if(data=="gmLogin"){
                    alert("已判斷使用者是GM登入")
                   }
                   else{
                       alert('此使用者的cookie內有mail的資訊,但不是我們家的會員 可秀出登入按鈕')
                    //$('#未登入的圖示').hide();
                   }
               }
           });
        }else {
            //判斷有沒有email資訊 
           alert('使用者有cookie,但沒有email的資訊,秀出可登入圖示');
            // $('#未登入的圖示').hide();
        }
    }
})
//===============================首頁登入================================================
$("#gogogsubmit").click(function () {
    $.ajax({
        type: "POST",
        url: "processlogin",
        data: {
            email: $("#memberInputEmail").val(),
            password: $("#memberInputPassword").val()
        },
        success: function (data) {
            alert(data)
            // var cartIdUseInfo= data ; 
            $("#memberLoginErrorEmail").html("");
            $("#memberLoginErrorPassword").html("");
            $("#memberBothErrorMsg").html("");

            if(data=="email"){
                $("#memberLoginErrorEmail").html(data+"不能為空");
            } else if (data=="password"){
                $("#memberLoginErrorPassword").html(data+"不能為空");
            }else if (data=="notFoundData"){
                $("#memberBothErrorMsg").html("←找不到您的資料!如未註冊請點選左邊加入我們!");
            }else if(data=="gmLogin"){
                alert(data+'登入者是GM 請導入GM畫面');
            }
            else{
                $.ajax({
                    type: "POST",
                    url: "catchMemberCartId",
                    data: {email: data },
                    success: function (data) {
                        alert('有沒有抓到cartId??');
                        alert(data);
                        sessionStorage.CartId=data;
                        // alert('將cartId存入sessionStorage呢??：'+sessionStorage.CartId);

                        var Days = 30;//cookie設定30天
                        var exp = new Date();
                        exp.setTime(exp.getTime() + Days*24*60*60*1000);
                        document.cookie = "CartId=" + sessionStorage.CartId+";expires=" + exp.toGMTString();
                    }
                });

                 var Days = 30;//cookie設定30天
                 var exp = new Date();
                 exp.setTime(exp.getTime() + Days*24*60*60*1000);
                 document.cookie = "email=" + data+";expires=" + exp.toGMTString();
                // alert('一般會員登入+把email塞到cookie裡面');
                 window.location.href = "http://localhost:8080/FinalProject/FirstPage.html";
            }
        }
    });

})