var cookies = document.cookie;
//帶出會員資料
$("#memberClickSelfInfo").click(function (){
    alert('測試有無進入此方訊');
    var isUserInside = cookies.split("email=")[1].split(";")[0]
    alert('有沒有抓到cookie內的email呢??→'+isUserInside);
    $.post("processupdate",{
        email:isUserInside
    },function(data,status){
        if(status == "success"){
            alert('資料從後端controller傳回來成功')
            var memberBeans = $.parseJSON(data);
            $("#inputName").attr("placeholder",memberBeans.name);
            $("#inputPhone").attr("placeholder",memberBeans.phone);
            $("#inputAddress").attr("placeholder",memberBeans.address);
            if(memberBeans.gender=="man"){
                $('#inlineRadio1').prop("checked",true);
                $('#inlineRadio2').prop("checked",false);
            }else{
                $('#inlineRadio1').prop("checked",false);
                $('#inlineRadio2').prop("checked",true);
            }
        }
    })
});

$('#memberUpdateInfo').click(function(){
$.ajax({
    type: "POST",
    url: "checkprocessupdate",
    data: {
        email:cookies.split("email=")[1].split(";")[0],
        //var isUserInside = cookies.split("email=")[1].split(";")[0];
        name:$("#inputName").val(),
        gender:$("input[name='inlineRadioOptions']:checked").val(),
        phone:$("#inputPhone").val(),
        address:$("#inputAddress").val(),
    },
    success: function (data) {
        if(data=="updatesuccess"){
            alert('會員資料更新成功')
        }else{
            alert('會員資料更新失敗')
        }
    }
});


    
});