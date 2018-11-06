<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<body>
  
<hr>


    	<h1>Login Page</h1>

    	
    	<fb:login-button scope="public_profile,email"
    		onlogin="checkLoginState();"
    		auto_logout_link="true"
    		size="large"
    		show_faces="true">
    	</fb:login-button><!-- facebook 按钮 -->
    	<div id="status"></div><!-- 登录状态显示 -->
    	
    <script>
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
    	                    url:"processFacebookLogin",
    	                    data:{
    	                    	userInfo:JSON.stringify(response)
    	                    },
    	                    dataType:"json",
    	                    async:false,
    	                    success:function(data){
    	                    	window.location.href="https://tw.yahoo.com/?p=us";
    	                    }
    	                });
    	        	document.getElementById('status').innerHTML =
    			        'Thanks for logging in, ' + response.name + '!';
    	        });
    	        
    		} else {
    			document.getElementById('status').innerHTML = 'Please log '
    					+ 'into this app.';
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
    </script>
</body>
</html>