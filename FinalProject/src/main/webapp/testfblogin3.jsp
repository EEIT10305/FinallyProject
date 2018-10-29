<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fb:login-button scope="public_profile,email" onlogin="checkLoginState();" ></fb:login-button>
	<!-- 點選登入時觸發checkLoginState()，此方法自定義 -->

	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '301951257305688',
				xfbml : true,
				version : 'v2.6' //facebook登入版本
			});
		};
		//非同步引入Facebook sdk.js
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		var fbToken;
		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}
		function statusChangeCallback(response) {
			if (response.status === 'connected') { //登陸狀態已連線
				fbToken = response.authResponse.accessToken;
				getUserInfo();
			} else if (response.status === 'not_authorized') { //未經授權
				console.log('facebook未經授權');
			} else {
				console.log('不是登陸到Facebook;不知道是否授權');
			}
		}
		//獲取使用者資訊
		function getUserInfo() {
			FB.api('/me',
					function(response) {
						//response.id / response.name
						alert(response.email)
						console.log('Successful login for: ' + response.name);
						//把使用者token資訊交給後臺
						self.location = 'TestFBLogin.do?accessToken='+ fbToken;
					});
		}
	</script>
</body>
</html>