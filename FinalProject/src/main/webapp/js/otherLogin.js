//---------------------------------------------------------------------------------------------fb登入3
     //應用程式編號，進入 https://developers.facebook.com/apps/ 即可看到
     let FB_appID = "301951257305688";
        
     //FB Login 官方文件：https://developers.facebook.com/docs/facebook-login/web

     // Load the Facebook Javascript SDK asynchronously
     (function (d, s, id) {
         var js, fjs = d.getElementsByTagName(s)[0];
         if (d.getElementById(id)) return;
         js = d.createElement(s); js.id = id;
         js.src = "https://connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v3.2";
         fjs.parentNode.insertBefore(js, fjs);
     }(document, 'script', 'facebook-jssdk'));

     window.fbAsyncInit = function () {
         FB.init({
             appId: "301951257305688",//FB appID
             // cookie: true,  // enable cookies to allow the server to access the session
             xfbml: true,  // parse social plugins on this page
             version: 'v3.2' // use graph api version
         });

     };

     //使用自己客製化的按鈕來登入
     function FBLogin() {
         
         FB.login(function (response) {
             FB.api('/me?fields=name,first_name,last_name,email', function(response) {
                 // alert('fb登入') 
     //将用户信息传回服务端
//     	        	window.location.href="TestFBLogin.do?userInfo="+JSON.stringify(response);

      $.ajax({
             type:"POST",
             url:"processFacebookLogin",
             data:{
                 userInfo:JSON.stringify(response)
             },
             success:function(data){
                 alert("這裡是facebook的登入:"+data)
                 
                     var Days = 30;//cookie設定30天
                     var exp = new Date();
                     exp.setTime(exp.getTime() + Days*24*60*60*1000);
                     document.cookie = "email=" + data+";expires=" + exp.toGMTString();
                     alert('facebook登入+把email塞到cookie裡面');
                     window.location.href = "http://localhost:8080/FinalProject/FirstPage.html";
                 
             }
         });
     // document.getElementById('status').innerHTML =
     //     'Thanks for logging in, ' + response.name + '!';
 });
         }, { scope: 'public_profile,email' });

     }


function fblogout(){     // facebook 登出
FB.getLoginStatus(
function (response){
if(response.status === 'connected'){
FB.logout(function(response){    //使用者已成功登出
alert("成功登出。");
// localStorage.clear();
// //再 refresh 一次，讓登入登出按鈕能正常顯示
// location.replace( "放欲導回網站的URL" );
});
} 
});
}
// =============================================================================================google登入

function signOut() {
   var auth2 = gapi.auth2.getAuthInstance();
   auth2.signOut().then(function() {
       console.log('User signed out.');
   });
   alert("google登出")
}

// 		function onSignIn(googleUser) {
// 			//跳转到http://gntina.iok.la/sendRedirect(获取用户信息)
// 			alert(profile.getEmail())
//              location.href = "www.google.com";
// 			//获取用户基本信息，但是此id不能给后台用，不安全，改用id_token
// 			/*从这往下的代码都不需要，因为是在后台验证，后台获取用户信息  */
//             var profile = googleUser.getBasicProfile();
// 			console.log('google自己封装好的获取用户信息');
// 			console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
// 			console.log('Name: ' + profile.getName());
// 			console.log('Image URL: ' + profile.getImageUrl());
// 			console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
   
// 			//将id_token发送给后台进行验证
// 			/*var id_token = googleUser.getAuthResponse().id_token;
// 			var xhr = new XMLHttpRequest();
// 			xhr.open('POST', 'http://gntina.iok.la/idToken');
// 			xhr.setRequestHeader('Content-Type',
// 					'application/x-www-form-urlencoded');
// 			xhr.onload = function() {
// 				console.log('Signed in as: ' + xhr.responseText);
// 			};
// 			xhr.send('idtoken=' + id_token);
//                        */
//                 }

    

function onSignIn(googleUser) {

var profile = googleUser.getBasicProfile();
console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
console.log('Name: ' + profile.getName());
console.log('Image URL: ' + profile.getImageUrl());
console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
//測試有無進入google登入的方訊
alert("這裡是google的登入:"+profile.getEmail())

$.ajax({
type: "POST",
url: "processGoogleLogin",
data: {
   name:profile.getName(),
   email:profile.getEmail()
   },
success: function (data) {
   alert('這裡是google的登入成功後的方訊 :'+data);
   var Days = 30;//cookie設定30天
   var exp = new Date();
   exp.setTime(exp.getTime() + Days*24*60*60*1000);
   document.cookie = "email=" + data+";expires=" + exp.toGMTString();
   alert('google登入+把email塞到cookie裡面');
   window.location.href = "http://localhost:8080/FinalProject/FirstPage.html";
}
});
}
