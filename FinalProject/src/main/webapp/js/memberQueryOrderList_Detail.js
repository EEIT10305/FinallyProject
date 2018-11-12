/*----------------------------------------------------------------測試用來給會員查詢自己的訂單紀錄用的----------------------------------------------------------------*/ 
$("#memberClickSearch").click(function(){
    var date1 = $('#datepicker1').val();
    var date2 = $('#datepicker2').val();
    var status = $('#choosestatus').val();
    alert(date1);
    alert(date2);
    alert(status)
    $.ajax({
        type: "POST",
        url: "processMemberQueryorderlist",
        data:{
            email:"123@gmail.com",      //=====記得要從cookie抓mail資訊======
            dateStart:$('#datepicker1').val(),
            dateEnd:$('#datepicker2').val(),
            statu:$('#choosestatus').val()
        },
        success: function (data) {
            console.log(data);
            var orders=$.parseJSON(data);
            var x=1;
            var txt="";
           for(i=0;i<orders.length;i++){
            alert(orders[i].orderid);
            alert(orders[i].memberBean.membername)
                txt+="<tr><th scope='row'>"+x+"</th>";
                txt+="<td>"+orders[i].memberBean.membername+"</td>";
                txt+="<td>"+orders[i].date+"</td>";
                txt+="<td>"+orders[i].total+"</td>";
                txt+="<td><button data-toggle='modal' data-target='#fororderdetail' class='btn btn-info' style='width:100%' value='"+orders[i].orderid+"' onclick='memberchoose("+orders[i].orderid+")'>查看細項</button></td></tr>"
                x++;
            }
        $('#showOrderList').html(txt);
        }
    });
    });

    function memberchoose(buttonValue){
        console.log(buttonValue);
        alert(buttonValue);
        $.ajax({
            type: "POST",
            url: "processMemberClickOrderDetail",
            data: {
                orderId:buttonValue
            },
            success: function (data) {
                var orderDetail = $.parseJSON(data);
                var a = 1;
                var txt="";
                alert(orderDetail);
                console.log(orderDetail);
                if(orderDetail.length===0){
                    $('#memberchooseMemberOrderDetail').html('尚無資料'); 
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
                $('#memberchooseMemberOrderDetail').html(txt);
            }
            }
        });
        }