// $(document).ready(function(){
//     var cookies = document.cookie;//先取cookie
//     alert(cookies);
// })
$("#gmClickSearch").click(function(){
var date1 = $('#datepicker1').val();
var date2 = $('#datepicker2').val();
var status = $('#choosestatus').val();
alert(date1);
alert(date2);
alert(status)
$.ajax({
    type: "POST",
    url: "processGMQueryorderlist",
    data:{
        dateStart:$('#datepicker1').val(),
        dateEnd:$('#datepicker2').val(),
        statu:$('#choosestatus').val()
    },
    success: function (data) {
        console.log(data);
        var Orders=$.parseJSON(data);
        var x=1;
        var txt="";
       for(i=0;i<Orders.length;i++){
        console.log(Orders[i].orderid);
        console.log(Orders[i].memberBean.membername)
            txt+="<tr><th scope='row'>"+x+"</th>";
            txt+="<td>"+Orders[i].memberBean.membername+"</td>";
            txt+="<td>"+Orders[i].date+"</td>";
            txt+="<td>"+Orders[i].total+"</td>";
            txt+="<td><button data-toggle='modal' data-target='#fororderdetail' class='btn btn-info' style='width:100%' value='"+Orders[i].orderid+"' onclick='gmchoose("+Orders[i].orderid+")'>查看細項</button></td></tr>"
            x++;
        }
    $('#showOrderList').html(txt);
    }
});
});

function gmchoose(buttonValue){
console.log(buttonValue);
console.log(buttonValue);
$.ajax({
    type: "POST",
    url: "processGMClickOrderDetail",
    data: {
        orderId:buttonValue
    },
    success: function (data) {
        var orderDetail = $.parseJSON(data);
        var a = 1;
        var txt="";
        console.log(orderDetail);
        console.log(orderDetail);
        if(orderDetail.length===0){
            $('#gmchooseMemberOrderDetail').html('尚無資料'); 
        }else{
        for(i=0;i<orderDetail.length;i++){
            txt+="<tr><th scope='row'>"+a+"</th>";
            txt+="<td>"+orderDetail[i].model+"</td>";
            txt+="<td>"+orderDetail[i].category+"</td>";
            txt+="<td>"+orderDetail[i].brand+"</td>";
            txt+="<td>"+orderDetail[i].price+"</td>";
            txt+="<td>"+orderDetail[i].amount+"</td></tr>";
            a++;
        }
        $('#gmchooseMemberOrderDetail').html(txt);
    }
    }
});
}
