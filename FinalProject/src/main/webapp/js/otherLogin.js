//----------------------------------------------------------------------------------------------fb登入
// This is called with the results from from FB.getLoginStatus().
 //引入 facebook SDK
 (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
        return;
    js = d.createElement(s);
    js.id = id;
    js.src = "https://connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v3.2&appId=301951257305688&autoLogAppEvents=1";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
 
    window.fbAsyncInit = function() {
        FB.init({
            appId : '301951257305688',
            cookie : true, 
            xfbml : true, 
            version : 'v3.2'
        });
    function statusChangeCallback(response) {
        //可用于后台验证，但是前台调用SDK则会自动验证
        var accessToken=response.authResponse.accessToken;
        console.log(response.authResponse.accessToken);
        if (response.status === 'connected') {//sdk会自动保留accessToken，并且验证该请求是否来自我的应用
            FB.api('/me?fields=name,first_name,last_name,email', function(response) { 
                //将用户信息传回服务端
//     	        	window.location.href="TestFBLogin.do?userInfo="+JSON.stringify(response);

                 $.ajax({
                        type:"POST",
                        url:"processFacebookLogin",
                        data:{
                            userInfo:JSON.stringify(response)
                        },
                        dataType:"json",
                        async:false,
                        success:function(response){
                            alert("這裡是facebook的登入:"+response)
                            if(response=="userFBLonin"){
                                window.location.href="http://localhost:8090/FinalProject/git/repository/FinalProject/src/main/webapp/FirstPage.html";
                            }else{
                                // window.location.href="https://tw.yahoo.com/?p=us";
                            }
                        }
                    });
                // document.getElementById('status').innerHTML =
                //     'Thanks for logging in, ' + response.name + '!';
            });
            
        } else {
            // document.getElementById('status').innerHTML = 'Please log '
            // 		+ 'into this app.';
        }
    }
 
    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        }); 
    }
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    };

// google登入

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function() {
        console.log('User signed out.');
    });
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
alert("這裡是google的登入:"+profile.getEmail())
$.ajax({
type: "POST",
url: "processGoogleLogin",
data: {
    name:profile.getName(),
    email:profile.getEmail()
    },
success: function (data) {
    alert('是否有跑入這支方訊')
    alert(data)
}
});



}