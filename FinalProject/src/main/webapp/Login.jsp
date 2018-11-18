<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
 <script>
        //获取时间函数
        function time1(){
            var today = new Date();
            var year = today.getFullYear();
            var month = today.getMonth()+1;
            var date = today.getDate();
            var day = today.getDay(); 
            var hour = today.getHours();
            var minute = today.getMinutes();
            var second = today.getSeconds();

            day    = checkDay(day)
            minute = checkTime(minute);
            second = checkTime(second);

            document.getElementById("time").innerHTML =
                year+"年"+month+"月"+date+"日 "+"星期"+day+" "+hour+":"+minute+":"+second;
            t = setTimeout("time1()",500);
        }
        //调整时间格式
        function checkTime(i) {
            if(i<10){
                i="0"+i;
            }
            return i;
        }
        function checkDay(i){
        	if(i==1){
        		i='一'
        	}
        	if(i==2){
        		i='二'
        	}
        	if(i==3){
        		i='三'
        	}
        	if(i==4){
        		i='四'
        	}
        	if(i==5){
        		i='五'
        	}
        	if(i==6){
        		i='六'
        	}
        	if(i==7){
        		i='日'
        	}
        	return i ;
        }
    </script>   
<link rel="stylesheet" href="css/skel.css" />
<link rel="stylesheet" href="css/styleForLogin.css" />
<title>大選電腦倉儲管理系統</title>
</head>
<body  class="landing">

<%-- <%@ include file="header.jsp"%> --%>
<section id="banner">
<%-- <h3>看看session有沒有被清除?${staffBean.permission} </h3> --%>
<%-- <h3>看看session${test} </h3> --%>
                <form action="staffLoginController" method="post">
                    <h2>大選電腦倉儲管理系統</h2>
                    <p>請登入帳號以及密碼</p>
                    <p><i style="color:red">${errors.loginError}</i></p>
                    <ul class="actions">
                        <li>
                                <label for="idEmail" style="color: #ffffff">員工電子信箱</label><i style="color:red">${errors.userIdError}</i>
                                <br/>
                                <input type="email" name="LoginEmail" required placeholder="請輸入帳號">
                        </li>
                        <li>
                                <label for="idPassword" style="color: #ffffff">密碼</label><i style="color:red">${errors.passwordError}</i>
                                <br/>
                                <input type="password" name="LoginPassword" id="idPassword" required placeholder="請輸入密碼">
                        </li>
                        </ul>
                        <br/>
                                <input type="submit" value="send">
                                <input type="reset" value="reset">
                           <p id="time" class="clock"><script>time1()</script></p><!-- 時鐘 -->
                  
                </form>
                </section>


<%-- <%@ include file="footer.jsp"%> --%>



</body>
</html>