<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		.t12 {
			font-family: 微軟正黑體;
			font-size: 20px;
			color: rgb(185, 31, 31);
			border: 2px solid #003366;
			width: 450px;
			margin: 20px;

		}

		.t13 {
			color: #0f0d0d;
		}

		.t14 {
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
					<a href="./Backstage_storehouse.jsp" title="Beats">
						<p>
							<br>庫存管理</p>
				</div>
				<div class="n1" id="s3">
					<a href="./Backstage_Purchase.jsp" title="Beats">
						<p>
							<br>進貨作業</p>
				</div>
				<div class="n1" id="s4">
					<a href="./coat.jsp" title="Beats">
						<p>
							<br>員工管理</p>
				</div>
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
					</a>

				</div>
				<div class="n2" id="s6">
					<a href="./index.jsp" title="Beats"> </a>
					<p>
						<br>首頁</p>
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

				<a href="./Backstage_Purchase.jsp" title="Beats">進貨作業</a>
				<span>/</span>
				<a href="./Backstage_Purchase_01.jsp" title="Beats">查詢進貨</a>
			</div>
			<br>
			<br>
			<br>


		</header>
	</div>

	<body align="center">
		<div align="center">
			<table class="t12">
				<br>
				<br>
				<div class="d2">進貨資料</div>
				<br>
				
				<tr class="t14">
					<td>訂單號碼</td>
					<td>訂購日期</td>
					<td>商品名稱</td>
					<td>單價</td>
					<td>數量</td>
					<td>總金額</td>
				</tr>
				<tr class="t13">
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
				</tr>
				<tr class="t13">
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
				</tr>
				<tr class="t13"></tr>
				<td>123</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>

				</tr>
			</table>
		</div>
		<br>
		<br>





	</body>
	<div>
		<footer>
			<div class="f0">

				<p>E-amil:aaa@gmail.com &nbsp; Tel:(02)2222-2222 &nbsp;</p>
				<p>台北市復興南路一段390號 &nbsp; &copy; 2018 All Rights Reserved Quality Art Technology CO.</p>

			</div>
		</footer>
		<br>
	</div>
</body>


</html>