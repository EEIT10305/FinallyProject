//清除cookie
function clearAllCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if(keys) {
        for(var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
    }
    window.location.reload(true);
}
//----------------------------------------------------------------------------------------------fb登入4
window.fbAsyncInit = function () {
    // FB JavaScript SDK configuration and setup
    FB.init({   
        appId: '301951257305688', // FB App ID
        cookie: false,  // enable cookies to allow the server to access the session
        xfbml: true,  // parse social plugins on this page
        version: 'v3.2' // use graph api version 2.8
    });

    // Check whether the user already logged in
    FB.getLoginStatus(function (response) {
        if (response.status === 'connected') {
            //display user data
            getFbUserData();
        }
    });
};

// Load the JavaScript SDK asynchronously
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// Facebook login with JavaScript SDK
function fbLogin() {
    FB.login(function (response) {
        if (response.authResponse) {
            // Get and display the user profile data
            getFbUserData();
        } 
    }, { scope: 'email' });
}

// Fetch the user profile data from facebook
function getFbUserData() {
    FB.api('/me?fields=name,first_name,last_name,email',
        function (response) {
           console.log('臉書登入登入登入登入登入登入登入');
            $('#originallogout').attr("style","display:none;width: 300px");
            $('#googlelogout').attr("style","display:none;width: 300px");
            $('#fblogout').attr("style","display:block;width: 300px");
$.ajax({
     type:"POST",
     url:"processFacebookLogin",
     data:{
         userInfo:JSON.stringify(response)
     },
     success:function(data){
         console.log("這裡是facebook的登入:"+data)
         
             var Days = 30;//cookie設定30天
             var exp = new Date();
             exp.setTime(exp.getTime() + Days*24*60*60*1000);
             document.cookie = "email=" + data+";expires=" + exp.toGMTString();
             console.log('facebook登入+把email塞到cookie裡面');
             if($('#exampleModalCenter').is(':hidden')){
            }else{
             $('#exampleModalCenter').hide();
             window.location.reload(true);
            }
     }
 });

        });
}

// Logout from facebook
function fbLogout() {
    FB.logout(function () {
        clearAllCookie();
        console.log('臉書登出登出登出登出登出登出登出登出');
    });
}
// =============================================================================================google登入

function signOut() {
   var auth2 = gapi.auth2.getAuthInstance();
   auth2.signOut().then(function() {
       console.log('User signed out.');
   });
   console.log("google登出");
   clearAllCookie();
}

var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '104571294251-h62qr1fa8502dmuolcrt6tmfa3brto1f.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('customBtn'));
    });
  };

  function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
        //   document.getElementById('name').innerText = "Signed in: "+googleUser.getBasicProfile().getName();

        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        
        //測試有無進入google登入的方訊
        console.log("這裡是google的登入:"+profile.getEmail())
        $('#originallogout').attr("style","display:none;width: 300px");
        $('#fblogout').attr("style","display:none;width: 300px");
        $('#googlelogout').attr("style","display:block;width: 300px");
        
        
        $.ajax({
        type: "POST",
        url: "processGoogleLogin",
        data: {
           name:profile.getName(),
           email:profile.getEmail()
           },
        success: function (data) {
           console.log('這裡是google的登入成功後的方訊 :'+data);
           var Days = 30;//cookie設定30天
           var exp = new Date();
           exp.setTime(exp.getTime() + Days*24*60*60*1000);
           document.cookie = "email=" + data+";expires=" + exp.toGMTString();
           if($('#exampleModalCenter').is(':hidden')){
           }else{
            $('#exampleModalCenter').hide();
            window.location.reload(true);
           }
        }
        });
        }, function(error) {
        //   alert(JSON.stringify(error, undefined, 2));
          console.log(JSON.stringify(error, undefined, 2))
        });
  }    


