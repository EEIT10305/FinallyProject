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
			text-align: center;
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
				
				<a href="./Backstage_Import_Index.jsp" title="Beats">進貨作業</a>
			</div>
			<br>
			<br>
			<br>


		</header>
	</div>
	<div class="t10" align="center">


		<div class="t9" align="center">
			<table>
				<tr>
					新增進貨
					<td>
						<a href="./vipPassword.jsp" title="Beats">
							<img src="./images/account.png" width="100px">
						</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="t9" align="center">
			<table>
				<tr>
					查詢進貨
					<td>
						<a href="./Backstage_Search_Import.jsp" title="Beats">
							<img src="./images/account.png" width="100px">
						</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="t9" align="center">
			<table>
				<tr>
					修改資料
					<td>
						<a href="vipDelete.jsp" onclick="return(confirm('確定刪除?'))">
							<img src="./images/account.png" width="100px">
						</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="t9" align="center">
			<table>
				<tr>刪除資料
					<td>
						<a href="./VipOut.jsp" title="Beats">
							<img src="./images/account.png" width="100px">
						</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<br>

	<br>
	<h1>_________________＊＊交貨注意事項＊＊_________________</h1>
	<br>
	<p class="t3">＊收到訂單後請務必於三天內通知下單者交期，數量或價格等相關事項。</p>
	<p class="t3">交貨前若有更改亦請通知下單者或重新上傳(供應商) </p>
	<p class="t3">＊進貨日前一天下午03:00前，必須通知下單者進貨明細或填妥ASN並上傳，以利進貨作業。</p>
	<p class="t3">＊交貨趟數超過一次且非同一時間，請依交貨趟數通知下單者各趟進貨明細或填妥表格並上傳。</p>
	<p class="t3">＊當天臨時有急貨要交, 請於前晚10:00 前(當天上午 9:30 後到貨) 或當天10:00前(當天中午前到貨)</p>
	<p class="t3">提供進貨明細或填妥 表格 並上傳, 再通知庫房安排收貨, 請仍依各倉規定的交貨時段交貨。</p>

	</h2>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
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