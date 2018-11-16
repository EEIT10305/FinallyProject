$('#oneKeyInput').click(function(){

    $('#inputUserName').val("");
    $('#userInputEmail').val("");
    $('#inlineRadio1').prop("checked",false);
    $('#inlineRadio2').prop("checked",false);
    $('#userInputPassword').val("");
    $('#userInputPhone').val("");
    $('#userInputAddress').val("");

    $('#inputUserName').val("王小明");
    $('#userInputEmail').val("gn01046294@hotmail.com");
    $('#inlineRadio1').prop("checked",true);
    $('#userInputPassword').val("Do!NG123");
    $('#userInputPhone').val("0978334455");
    $('#userInputAddress').val("台北市信義區信義路5段7號88樓");
});
$('#userReset').click(function(){
    $('#inputUserName').val("");
    $('#userInputEmail').val("");
    $('#inlineRadio1').prop("checked",false);
    $('#inlineRadio2').prop("checked",false);
    $('#userInputPassword').val("");
    $('#userInputPhone').val("");
    $('#userInputAddress').val("");
});