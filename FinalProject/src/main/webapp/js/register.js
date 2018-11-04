$("#userSend").click(function () {
    $.ajax({
        type: "POST",
        url: "processregister",
        data: {
            name:$("#inputUserName").val(),
            email:$("#userInputEmail").val(),
            password:$("#userInputPassword").val(),
            permission:"normal",
            address:$("#userInputAddress").val(),
            phone:$("#userInputPhone").val(),
            gender:$("input[name='inlineRadioOptions']:checked").val()
        },
        success: function (data) {

            $("#errorInputName").html("");
            $("#errorInputGender").html("");
            $("#errorInputEmail").html("");
            $("#errorInputPassword").html("");
            $("#errorInputPhone").html("");
            $("#errorInputAddress").html("");
            $("#errorInputData").html("");
             
             if(data=="name"){
                $("#errorInputName").html(data+"輸入錯誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if(data=="email"){
                $("#errorInputEmail").html(data+"輸入有誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if(data=="password"){
                $("#errorInputPassword").html(data+"輸入有誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if(data=="address"){
                $("#errorInputAddress").html(data+"輸入有誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if(data=="phone"){
                $("#errorInputPhone").html(data+"輸入有誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if(data=="gender"){
                $("#errorInputGender").html(data+"選擇有誤");
                $("#errorInputData").html("您輸入的"+data+"有誤!請檢查");
             }
             else if (data=="emailused"){
                $("#errorInputEmail").html("此email已註冊!");
                $("#errorInputData").html("您輸入的email已註冊!請重新輸入");
             }
            if(data==$("#userInputEmail").val()){
               window.location.href="http://localhost:8080/FinalProject/OnlyProcessLogin.html";
                }
        }
    });

})