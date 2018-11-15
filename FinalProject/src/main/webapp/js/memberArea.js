var cookies = "";
var isUserInside ="";
$(document).ready(function(){
    cookies = document.cookie;
    isUserInside = cookies.split("email=")[1].split(";")[0]
     console.log('有沒有抓到cookie內的email呢??→'+isUserInside);
});

/*----------------------------------------------------------------測試用來給會員查詢自己的訂單紀錄用的----------------------------------------------------------------*/ 
$(".mouseOverChoosepointer").click(function(){
// alert('點擊我的訂單紀錄查詢的方訊 抓取滑鼠點到的值===>'+$(this).attr("value"));
// ==================================會員點選我的訂單查詢==================================
if($(this).attr("value")=="memberClickSelfOrderInfo"){//如果點選的是=====查詢訂單紀錄======
    // alert('進入會員==訂單查詢==的方訊');
$('#memberNowWhere').html('>'+' '+'我的訂單紀錄');

$('#thisdivShowMemberWishList').attr("style","display:none");//會員願望清單設定為隱藏
$('#thisdivShowMemberWishProInfoEmail').attr("style","display:none");//會員貨到通知設定為隱藏
$('#thisdivShowMemberInfoUpdate').attr("style","display:none");//會員資料設定為隱藏
$('#thisdivShowMemberPasswordUpdate').attr("style","display:none");//會員修改密碼設定隱藏
$('#thisdivShowMemberOrderList').attr("style","display:block");//會員訂單查詢設定為顯示
 
$.ajax({
        type: "POST",
        url: "processMemberQueryorderlist",
        data:{
            email: isUserInside ,      //=====記得要從cookie抓mail資訊======
        },
        success: function (data) {
            // alert('有沒有從查詢會員訂單的controller回傳資料');
            console.log(data);
            var orders=$.parseJSON(data);
            var txt="";
           for(i=0;i<orders.length;i++){
//            alert(orders[i].orderid);
//            alert(orders[i].memberBean.membername)
                txt+="<tr style='height:60px;line-height:60px;'><th scope='row'>"+(i+1)+"</th>";
                txt+="<td>"+orders[i].memberBean.membername+"</td>";
                txt+="<td>"+orders[i].dat+"</td>";
                txt+="<td>"+orders[i].total+"</td>";
                txt+="<td>"+orders[i].arrive+"</td>";
                txt+="<td><button data-toggle='modal' data-target='#fororderdetail' class='btn btn-dark' style='width:100%' value='"+orders[i].orderid+"' onclick='memberchoose("+orders[i].orderid+")'>查看細項</button></td></tr>"
            }
        $('#showOrderList').html(txt);
        }
    });

}
if($(this).attr("value")=="memberClickSelfInfo"){//如果點選的是=====會員修改=====
    // alert('進入會員==修改資料==的方訊');
    $('#memberNowWhere').html('>'+' '+'修改我的個人資料');

    $('#thisdivShowMemberOrderList').attr("style","display:none");//會員訂單設定為隱藏
    $('#thisdivShowMemberWishList').attr("style","display:none");//會員願望清單設定為隱藏
    $('#thisdivShowMemberWishProInfoEmail').attr("style","display:none");//會員貨到通知設定為隱藏
    $('#thisdivShowMemberPasswordUpdate').attr("style","display:none");//會員修改密碼設定隱藏
    $('#thisdivShowMemberInfoUpdate').attr("style","display:block");//會員訂單查詢設定為顯示

    $.post("showMemberInfo",{
        email:isUserInside      //=====記得要從cookie抓mail資訊======
    },function(data,status){
        if(status == "success"){
//            alert('資料從後端controller傳回來成功')
            var memberBeans = $.parseJSON(data);
//            alert(memberBeans.membername);
//            alert(memberBeans.phone);
//            alert(memberBeans.memberaddress);
            $('#onlyShowMemberEmail').html(memberBeans.email);
            
            $("#inputName").attr("placeholder",memberBeans.membername);

            if(memberBeans.phone=='facebook'){
                $("#inputPhone").attr("placeholder",'Login By Facebook');
            }
            else if(memberBeans.phone=='google'){
                $("#inputPhone").attr("placeholder",'Login By Google');
            }
            else {
                $("#inputPhone").attr("placeholder",memberBeans.phone);
            }
            if(memberBeans.memberaddress=='facebook'){
                $("#inputAddress").attr("placeholder",'Login By Facebook');
            }
            else if(memberBeans.memberaddress=='google'){
                $("#inputAddress").attr("placeholder",'Login By Google');
            }
            else{
                $("#inputAddress").attr("placeholder",memberBeans.memberaddress);
            }
            // $("#inputName").attr("placeholder",memberBeans.membername);
            // $("#inputPhone").attr("placeholder",memberBeans.phone);
            // $("#inputAddress").attr("placeholder",memberBeans.memberaddress);
            if(memberBeans.gender=="man"){
                $('#inlineRadio1').prop("checked",true);
                $('#inlineRadio2').prop("checked",false);
            }else{
                $('#inlineRadio1').prop("checked",false);
                $('#inlineRadio2').prop("checked",true);
            }
        }
    });
}
if($(this).attr("value")=="memberClickSelfWishInfo"){//如果點選的是=====願望清單=====
    $('#memberNowWhere').html('>'+' '+'我的願望清單');

    $('#thisdivShowMemberOrderList').attr("style","display:none");//會員訂單設定為隱藏
    $('#thisdivShowMemberInfoUpdate').attr("style","display:none");//會員資料設定為隱藏
    $('#thisdivShowMemberPasswordUpdate').attr("style","display:none");//會員修改密碼設定隱藏
    $('#thisdivShowMemberWishProInfoEmail').attr("style","display:none");//會員貨到通知設定為隱藏
    $('#thisdivShowMemberWishList').attr("style","display:block");//會員願望清單設定為顯示

    $.ajax({
        type: "POST",
        url: "processMemberSelectWishList",
        data: {
            email: isUserInside ,      //=====記得要從cookie抓mail資訊======
        },
        success: function (data) {
            console.log(data);
            var wishs = $.parseJSON(data);
            var txt = "";
            var a = 1;
            for(i=0;i<wishs.length;i++){
                if(wishs[i].tracked==1){
                txt+="<tr style='height:60px;line-height:60px;'><th scope='row'>"+a+"</th>";
                txt+="<td>"+wishs[i].productBean.model+"</td>";
                txt+="<td>"+wishs[i].productBean.categoryBean.category+"</td>";
                txt+="<td>"+wishs[i].productBean.brandBean.brand+"</td>";
                txt+="<td>"+wishs[i].productBean.price+"</td>";
                txt+="<td>"+"<img src='image/"+wishs[i].productBean.model+".jpg' style='width:60px;height:60px'>"+"</td></tr>"
                a++;
                }
            }
            $('#showWishList').html(txt);
        }
    });
}

if($(this).attr("value")=="memberClickSelfProInfo"){//如果點選的是=====貨到通知=====
    $('#memberNowWhere').html('>'+' '+'到貨通知我');

    $('#thisdivShowMemberOrderList').attr("style","display:none");//會員訂單設定為隱藏
    $('#thisdivShowMemberWishList').attr("style","display:none");//會員願望清單設定為隱藏
    $('#thisdivShowMemberInfoUpdate').attr("style","display:none");//會員資料設定為隱藏
    $('#thisdivShowMemberPasswordUpdate').attr("style","display:none");//會員修改密碼設定隱藏
    $('#thisdivShowMemberWishProInfoEmail').attr("style","display:block");//會員貨到通知設定為顯示
    $.ajax({
        type: "POST",
        url: "processMemberSelectEmailWish",
        data: {
            email: isUserInside ,      //=====記得要從cookie抓mail資訊======
        },
        dataType:"text",
        success: function (data) {
            console.log(data);
            var wishListJson=data.split("|")[0];
            var proStockJson=data.split("|")[1];
            var wishList = $.parseJSON(wishListJson);
            var proStock = $.parseJSON(proStockJson);

            var txt = "";
            var a = 1;
            for(i=0;i<wishList.length;i++){
                txt+="<tr style='height:60px;line-height:60px;'><th scope='row'>"+a+"</th>";//頭
                txt+="<td>"+wishList[i].productBean.model+"</td>";//型號
                txt+="<td>"+wishList[i].productBean.categoryBean.category+"</td>";//類別
                txt+="<td>"+wishList[i].productBean.brandBean.brand+"</td>";//品牌
                txt+="<td>"+wishList[i].productBean.price+"</td>";//價格
                if(proStock[i].amount==0){
                txt+="<td>"+"補貨中..."+"</td>";
                }else{
                   txt+="<td><button style='cursor:pointer' id='addtocart"+wishList[i].productBean.model+"' value='"+wishList[i].productBean.model+"' class='btn btn-danger forclickcart'>加入購物車</button></td>"
                    //購物車按鈕
                }
                // txt+="<td>"+proStock[i].amount+"</td>";//數量
                
                txt+="<td>"+"<img src='image/"+wishList[i].productBean.model+".jpg' style='width:60px;height:60px'>"+"</td></tr>"//圖片
                a++;
//                document.getElementById("addtocart"+wishList[i].productBean.model).addEventListener("click",addToCart); 
            }
            $('#showWishEmailList').html(txt);
            $(".forclickcart").click(addToCart);
        }
    });
}

if($(this).attr("value")=="memberClickSelfPassword"){
    $('#memberNowWhere').html('>'+' '+'修改我的密碼');

    $('#thisdivShowMemberOrderList').attr("style","display:none");//會員訂單設定為隱藏
    $('#thisdivShowMemberWishProInfoEmail').attr("style","display:none");//會員願望清單設定為隱藏
    $('#thisdivShowMemberInfoUpdate').attr("style","display:none");//會員資料設定為隱藏
    $('#thisdivShowMemberWishProInfoEmail').attr("style","display:none");//會員貨到通知設定為隱藏
    $('#thisdivShowMemberPasswordUpdate').attr("style","display:block");//會員修改密碼設定隱藏
}
});
//===============================================會員輸入完新的密碼後 要做的動作========================================

$('#memberClickUpdatePassword').click(function(){
$.ajax({
    type: "POST",
    url: "processMemberUpdatePassword",
    data: {
        email: isUserInside ,  //=======目前寫死的 要記得從cookie內抓=====
        oldPassword:$('#memberInputOldPassword').val(),
        newPassword:$('#memberInputNewPassword').val(),
        checkPassword:$('#memberInputCheckPassword').val()
    },
    success: function (data) {
        $('#errorInputOldPassword').html("");
        $('#errorInputNewPassword').html("");
        $('#errorInputCheckPassword').html("");
        $('#errorInputOtherPassword').html("");
        
        if(data=="oldPasswordError"){
            $('#errorInputOldPassword').html("舊密碼不可為空!");
        }
        if(data=="oldPasswordInputError"){
            $('#errorInputOldPassword').html("舊密碼輸入錯誤!");
        }

        if(data=="newPasswordInputNull"){
            $('#errorInputNewPassword').html("新密碼不可為空!");
        }
        if(data=="newPasswordInputTypeError"){
            $('#errorInputNewPassword').html("密碼必須符合安全規定!");
        }
        if(data=="newEqualOld"){
            $('#errorInputNewPassword').html("新密碼不可和舊密碼相同!");
        }

        if(data=="checkPasswordNull"){
            $('#errorInputCheckPassword').html("尚未輸入確認密碼!");
        }
        if(data=="checkPasswordTypeError"){
            $('#errorInputCheckPassword').html("確認密碼輸入錯誤!");
        }
        if(data=="newAndCheckDifferent"){
            $('#errorInputCheckPassword').html("確認密碼和您設定的新密碼不相同!");
        }
        if(data=="updatePasswordSuccess"){
        alert('修改成功!即將將您導回首頁!重新登入您的新密碼')
        clearAllCookie();
        }
    }
});
});

// ==================================會員輸入完 欲更改的資料 要做的動作==================================
$('#memberUpdateInfo').click(function(){
    $.ajax({
        type: "POST",
        url: "checkprocessupdate",
        data: {
            email: isUserInside ,      //=====記得要從cookie抓mail資訊======
            //var isUserInside = cookies.split("email=")[1].split(";")[0];
            name:$("#inputName").val(),
            gender:$("input[name='inlineRadioOptions']:checked").val(),
            phone:$("#inputPhone").val(),
            address:$("#inputAddress").val(),
        },
        success: function (data) {
            if(data=="updatesuccess"){
                alert('會員資料更新成功');
                window.location.href = "/FinalProject/Customer.html";
            }else{
                alert('會員資料更新失敗');
            }
        }
    });
    });





// ==================================會員點選我的訂單之後 點選訂單詳細內容==================================
   function memberchoose(buttonValue){
    console.log(buttonValue);
//    alert(buttonValue);
    $.ajax({
        type: "POST",
        url: "processMemberClickOrderDetail",
        data: {
            orderId:buttonValue
        },
        success: function (data) {
            var orderDetail = $.parseJSON(data);
            var txt="";
//            alert(orderDetail);
            console.log(orderDetail);
            if(orderDetail.length===0){
                $('#memberchooseMemberOrderDetail').html('尚無資料'); 
            }else{
            for(i=0;i<orderDetail.length;i++){
                txt+="<tr><th scope='row'>"+(i+1)+"</th>";
                txt+="<td>"+orderDetail[i].model+"</td>";
                txt+="<td>"+orderDetail[i].category+"</td>";
                txt+="<td>"+orderDetail[i].brand+"</td>";
                txt+="<td>"+orderDetail[i].price+"</td>";
                txt+="<td>"+orderDetail[i].amount+"</td></tr>";
            }
            $('#memberchooseMemberOrderDetail').html(txt);
        }
        }
    });
    }
   
   //======================購物車===================================================
   function addToCart(){
console.log($(this).val())
     $.ajax({
         type: "post",
         url: "AddtToCartController",
         data: {"model":$(this).val(),
        	    "CartId":sessionStorage.CartId},             
         success: function (data) {
             alert("加入購物車成功！")

         }
     });
}

//清除cookie
function clearAllCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if(keys) {
        for(var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
    }
    window.location.href = "/FinalProject/FirstPage.html";
}

   
   
   