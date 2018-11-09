<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>後台</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
	<style>
		* {
			margin: 0;
			padding: 0;
		}

		/*頁首格式*/

		.n0 {
			width: 100%;
			height: 180px;
			margin: auto;
			overflow: auto;
			background-color: rgba(146, 151, 153, 0.986);
			font-weight: bold;
			font-family: 微軟正黑體;

		}

		/*頁尾格式*/

		.f0 {
			width: 100%;
			overflow: auto;
			background-color: rgba(146, 151, 153, 0.986);
			line-height: 2.5em;
			text-align: center;
			color: #ffffff;
			height: 60%;
			position: relative;

		}

		/*頁首文字*/

		.n1 {
			/* border:1px solid red; */
			width: 150px;
			margin: 25px;
			/* line-height:10px; */
			font-family: 'Roboto Condensed', sans-serif;
			font-size: 30px;
			color: aliceblue;
			text-align: center;
			float: left;
		}

		.n_1 {
			width: 50px;
			height: 50px;
			margin: 0 auto;
			float: left;
		}

		#Footer {
			height: 100px;
			position: relative;
			margin-top: -100px;
		}

		/*頁首區塊*/

		.n_2 {
			width: 120px;
			margin: 0 auto;
		}



		.n2 {
			/* border:1px solid red; */
			width: 100px;
			margin: 25px;
			/* line-height:10px; */
			font-family: 'Roboto Condensed', sans-serif;
			font-size: 20px;
			color: aliceblue;
			text-align: center;
			float: right;
		}

		.t9 {
			height: 150px;
			/* 高度 120 */
			width: 150px;
			/* 寬度 120*/
			border: 2px dashed #003366;
			/* 虛線邊框 2 像素 深藍色*/
			margin: 50px;
			/* 四周邊界 20 像素 */
			font-size: 30px;
			color: rgb(15, 152, 170);
			float: left;
		}

		.t8 {
			height: 150px;
			/* 高度 120 */
			width: 150px;
			/* 寬度 120*/
			/*border: 2px dashed; /* 虛線邊框 2 像素 */
			margin: 50px;
			/* 四周邊界 20 像素 */
			font-size: 30px;
			color: rgb(15, 152, 170);
			float: left;
		}


		.t3 {
			font-size: 20px;
			font-family: 微軟正黑體;
			
		}

		.t2 {
			font-size: 40px;
			font-family: 微軟正黑體;
			
		}
		
		.t4 {
			font-size: 30px;
			font-family: 微軟正黑體;
			
		}

		.t10 {
			font-family: 微軟正黑體;
			text-align: center;
		}
	</style>


</head>

<body>
	<div>
		<header>
			<div class="n0">
				<div class="n_1" id="s0">

					<img src="./pic/unnamed.png" width="200px">
				</div>

				<div class="n1" id="s1">
					<a href="./Backstage_index.jsp" title="Beats">
						<p>
							<br>本月公告</p>
				</div>
				<div class="n1" id="s2">
					<a href="./Backstage_Transfer_Index.jsp" title="Beats">
						<p>
							<br>庫存管理</p>
				</div>
				<div class="n1" id="s3">
					<a href="./Backstage_Import_Index.jsp" title="Beats">
						<p>
							<br>進貨作業</p>
				</div>
				<c:if test="${staffBean.permission=='boss'}">
				<div class="n1" id="s4">
					<a href="./coat.jsp" title="Beats">
						<p>
							<br>員工管理</p>
				</div>
				</c:if>
				<div class="n2" id="s4">
					<a href="./shopping.jsp" title="Beats">
						<p>

						</p>
				</div>
				<div class="n2" id="s5">
					<a href="./vip1.jsp" title="Beats">
						<br>

						<img src="./images/account.png" width="100px">
					</a>

				</div>
				
				<div class="n2" id="s6">
					<a href="staffLogoutController"><p><br>登出</p></a>
				</div>
			</div>
			<br>
			<br>

			<div style="margin-right:60%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${sessionScope.login}
				</span>
				<span>&nbsp;&nbsp;&nbsp;您好!!</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 當前位置：
				<a href="./Backstage_index.jsp">本月公告</a>

			</div>
			<br>

		</header>
	</div>
	<div class="t10" align="center">

		<body >
			<div align="left" style="margin:20px" >
				<p class="t2" >&nbsp;&nbsp;大選數位股份有限公司&nbsp;&nbsp;</p>
				<br>
				<p class="t4">一、全勤津貼和獎金發放時間於每月5日。</p>
				<p class="t4">二、薪資制度:</p>
				<br>
				<p class="t3">1. 全體同仁薪資應於翌月五日發給，如遇例假日則提前一日發放。</p>
				<p class="t3">2. 行政人員自到職日起薪，未滿七日自動離職者不予支薪。(行政單位)</p>
				<p class="t3">3. 業務人員自到職日起算，滿30天得己發放油資和全勤。(業務單位)</p>
				<p class="t3">4. 業務人員請事假、病假合計超過五日(含)以上者不發放全勤油資津貼。</p>
				<p class="t3">5. 每月遲到三次以上或每月遲到時間累計逾15分鐘以上者，不發放全勤。</p>
				<p class="t3">6. 如需請調假者需事前告知主管，且填寫請調假單；上班時間9點過後未電話告知以曠職論；</p>
				<p class="t3">假滿未經續假而擅自不到職者為，如未經同意自行修假者，以曠職論處，曠職者且扣三日津貼。 (業務單位)</p>
				<p class="t3">7. 無正當理由連續曠職三日，即予免職。</p>
				<p class="t3">8. 本公司員工上下班以打卡記錄為準。</p>
				<p class="t3">9.　忘打卡者需在三日內請主管簽章並寫明理由，否則一律視同放棄全勤，不得異意。</p>
				<p class="t3">10.　因特殊原因晚到公司，需事先告知主管，上班日還是以打卡為主，不論什麼時間到達公司還是認打卡鐘印；
				<p class="t3">並加上主管簽章寫明理由，缺一者一律視同放棄全勤；嚴禁同仁之間代打卡。</p>
				<p class="t3">◎本公司員工每日工作時間以八小時為原則，得視業務上需要調整</p>
				<p class="t3">◎同仁實領薪資（津貼）之所得稅部份，以每年年底一次申報</p>
				<p class="t3">◎離職後一律視同放棄享有任何有關公司福利及獎金</p>
				
			</div>
		</body>


		<footer>
			<div>
				<footer>
					<div class="f0">

						<p>E-amil:aaa@gmail.com &nbsp; Tel:(02)2222-2222 &nbsp;</p>
						<p>台北市復興南路一段390號 &nbsp; &copy; 2018 All Rights Reserved Quality Art Technology CO.</p>

					</div>
				</footer>

			</div>
		</footer>

</body>

</html>