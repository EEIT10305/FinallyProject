var cookies = "";
cookies = document.cookie;
var userEmail = cookies.split("email=")[1].split(";")[0];

$(document).ready(function(){
    $.ajax({
        type: "POST",
        url: "processOtherPageLogout",
        data: {
        email:userEmail
        },
        success: function (response) {
            console.log(response);
            var members = $.parseJSON(response);
            $.each(members,function(index,json){
                if(json.permission=="facebook"){
                    $('#originallogout').attr("style","display:none;width: 300px");
                    $('#googlelogout').attr("style","display:none;width: 300px");
                    $('#fblogout').attr("style","display:block;width: 300px");  
                }
                if(json.permission=="google"){
                    $('#originallogout').attr("style","display:none;width: 300px");
                    $('#googlelogout').attr("style","display:block;width: 300px");
                    $('#fblogout').attr("style","display:none;width: 300px");  
                }
                if(json.permission=="normal"){
                    $('#originallogout').attr("style","display:block;width: 300px");
                    $('#googlelogout').attr("style","display:none;width: 300px");
                    $('#fblogout').attr("style","display:none;width: 300px");  
                }
            })
        }
    });
});
//清除cookie
function clearAllCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if(keys) {
        for(var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
    }
    window.location.href = "/FinalProject/FirstPage.html";
}
