<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		.d1 {
			height: 550px;
			/* 高度 120 */
			width: 550px;
			/* 寬度 120*/
			border: 2px #003366;
			/* 虛線邊框 2 像素 深藍色*/
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

		.d2 {
			font-family: 微軟正黑體;
			text-align: center;
			font-size: 50px;
		}



		.t3 {
			font-size: 20px;
			font-family: 微軟正黑體;
			text-align: center;
		}

		.t10 {
			font-family: 微軟正黑體;
			text-align: center;
		}

		.t8 {
			font-family: 微軟正黑體;
			font-size: 24px;
			color: rgb(2, 17, 19);
		}

		.tid {
			width: 100px;
			margin: 25px;
			color: #0a0503;
			font-size: 30px;


		}

		.sut1 {
			width: 450px;
			margin: 20px;
			;


		}
		td{
		   width:100px;
		
		}
	</style>


</head>

<body>
	<div>
		<header>
			<div class="n0">
				<div class="n_1" id="s0">

				</div>
				<div class="n1" id="s1">
					<a href="/FinalProject/Backstage_index.jsp" title="Beats">
						<p>
							<br>本月公告</p></a>
				</div>

				<div class="n1" id="s2">
					<a href="/FinalProject/Backstage_Transfer_Index.jsp" title="Beats">
						<p>
							<br>庫存管理</p></a>
				</div>
				<div class="n1" id="s3">
					<a href="/FinalProject/Backstage_Import_Index.jsp" title="Beats">
						<p>
							<br>進貨作業</p></a>
				</div>
				<c:if test="${staffBean.permission=='boss'}">
				<div class="n1" id="s4">
					<a href="./coat.jsp" title="Beats">
						<p>
							<br>員工管理</p></a>
				</div>
				</c:if>
				<div class="n2" id="s4">
					<a href="./shopping.jsp" title="Beats"></a>
				</div>
				<div class="n2" id="s5">
						<br>
						<img src="./images/account.png" width="100px">
				</div>
				<div class="n2" id="s6">
					<a href="./index.jsp" title="Beats"> </a>
					<p>
						<a href="staffLogoutController"><p><br>登出</p></a>
					</p>
				</div>
			</div>
			<br>
			<br>

			<div style="margin-right:60%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${sessionScope.login}
				
				<span>&nbsp;&nbsp;&nbsp;您好!!</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 當前位置：

				<a href="/FinalProject/Backstage_Transfer_Index.jsp" title="Beats">庫存管理</a>
				<span>/</span>
				
			</div>
			<br>
			<br>
			<br>


		</header>
	</div>

<body>
<body>

<form class="tid2" action="/FinalProject/pages/search.transfer.controller">

				<div class="sut1">
				
				<div class="sut1">
						<label class="tid"> 產品型號:</label>
						<input type="text" name="promodel" value = "${param.model}" >
					</div>

					<br>
					<br>

					<div class="sut" style="margin-left:40px">						
						<input type="submit" value="送出" style="width:120px;height:40px;font-size:20px;">
					</div>
					
			</div>
			</form>




</body>
</html>