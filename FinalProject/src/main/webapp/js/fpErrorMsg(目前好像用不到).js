$("#testuserlogin").click(
    function(){
    $.ajax({
             type: "POST",
             url: "processlogin",
             data:{
                 email:$("#userInputEmail").val(),
                 password:$("#userInputPassword").val()
                 },
             success: function (data) {
                alert(data)

                $("#errorEmail").html("");
                $("#errorPassword").html("");
                $("#errorBoth").html("");

                 if(data=="email"){
                     $("#errorEmail").html("請輸入email");
                 }else if(data=="password"){
                     $("#errorPassword").html("請輸入密碼");
                 }else if(data=="notFoundData"){
                    $("#errorBoth").html("←您尚未註冊,請按下確定開始註冊");
                    // alert('←您尚未註冊,請按下確定開始註冊');
                     window.location.href = "/FinalProject/Register.html";
                 }
                 else{
                    // document.cookie = "email=" + data;
                    window.location.href = "/FinalProject/FirstPage.html";
                 }
    }
});
    });