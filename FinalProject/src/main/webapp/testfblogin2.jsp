<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

fb test
<div class="fb-login-button" data-max-rows="1" data-size="medium" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div>



<script>
//初始化
window.fbAsyncInit = function() {
  FB.init({
    appId      : '301951257305688',
    cookie     : true,
    xfbml      : true,
    version    : 'v3.2'
  });
  //記錄用戶行為資料 可在後台查看用戶資訊
  FB.AppEvents.logPageView();   
};

 //嵌入臉書sdk
(function(d, s, id){
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) {return;}
   js = d.createElement(s); js.id = id;
   js.src = "https://connect.facebook.net/en_US/sdk.js";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));
 
$(function() {
    //點擊登入按鈕
    $("#login-").click(function() {
      //檢查臉書登入狀態
      FB.getLoginStatus(function(response) {
        //如果已經有授權過應用程式
        if (response.authResponse) {
          //呼叫FB.api()取得使用者資料
          FB.api('/me',{fields: 'id,name,email'}, function (response) {
              //這邊就可以判斷取得資料跟網站使用者資料是否一致
          });
          
        //沒授權過應用程式
        } else {
          //呼叫FB.login()請求使用者授權
          FB.login(function (response) {
            if (response.authResponse) {
              FB.api('/me',{fields: 'id,name,email'}, function (response) {
                //這邊就可以判斷取得資料跟網站使用者資料是否一致
              });
            }
          //FB.login()預設只會回傳基本的授權資料
          //如果想取得額外的授權資料需要另外設定在scope參數裡面
          //可以設定的授權資料可以參考官方文件          
          }, { scope: 'email,user_likes' });
        }
      });
    });
  });
FB.logout(function(response) {
    // user is now logged out
    alert('已成功登出!');
    window.location.reload();
});
</script>
</body>
</html>