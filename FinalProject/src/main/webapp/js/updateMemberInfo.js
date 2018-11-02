$("#memberClickSelfInfo").click(function (){
    alert('測試有無進入此方訊');
    // var isUserInside = cookies.split("email=")[1].split(";")[0]
    // alert('有沒有抓到cookie內的email呢??→'+isUserInside);
    $.post("processupdate",{
        email:"111@111" 
    },function(data,status){
        if(status=="success"){
//            $('#testname').html('QQQQQQQQQQQQQQQQQqq')
        	var query=$.parseJSON(data)
        	alert(query)
            alert('資料有沒有成功從controller傳回來?');
            window.location.href="https://tw.yahoo.com/?p=us";
        }
    })

    // $.ajax({
    //     type: "POST",
    //     url: "processupdate",
    //     data: {
    //         email:"111@111"
    //     },
    //     // dataType:"json",
    //     success: function (data) {
    //         alert('資料有沒有成功從controller傳回來?');
    //         alert(data);
    //         var jdata = $.parseJSON(data);
    //         // alert(jdata)
    //         alert(jdata[0].name);
    //     }
    // });
});
