<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>後台</title>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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

.excelTable {
	margin: 10px auto;
	border-collapse: collapse;
}

.excelTable tr td {
	border: 1px solid black;
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
					<a href="./Backstage_index.jsp" title="Beats">本月公告</a>
				</div>

				<div class="n1" id="s2">
					<a href="./Backstage_Transfer_Index.jsp" title="Beats">庫存管理</a>
				</div>
				<div class="n1" id="s3">
					<a href="./Backstage_Import_Index.jsp" title="Beats">進貨作業</a>
				</div>
				<c:if test="${staffBean.permission=='boss'}">
					<div class="n1" id="s4">
						<a href="./coat.jsp" title="Beats">員工管理</a>
					</div>
				</c:if>
				<div class="n2" id="s4">
					<a href="./shopping.jsp" title="Beats"></a>
				</div>
				<div class="n2" id="s5">
					<a href="./vip1.jsp" title="Beats"> <img
						src="./images/account.png" width="100px">
					</a>
				</div>
				<div class="n2" id="s6">
					<a href="./index.jsp" title="Beats"> </a>
					<p>
						<br>首頁
					</p>
				</div>
			</div>
			<br> <br>

			<div style="margin-right: 60%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${sessionScope.login} </span> <span>&nbsp;&nbsp;&nbsp;您好!!</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 當前位置： <a
					href="./Backstage_Import_Index.jsp" title="Beats">進貨作業</a> <span>/</span>
				<a href="./Backstage_Search_Import.jsp" title="Beats">查詢進貨</a> <span>/</span>
				報表輸出
			</div>
			<br> <br> <br>

		</header>
</div>
		<p class="d2">報表輸出</p>
		
    <div style="display:flex;flex-wrap:wrap;margin-top:20px;height:450px;">
			<div style="justify-content: center;line-height: 48px;width: 50%;text-align:center;padding-top:100px;">
				<span>西元</span> <input id="yyyy" type="text" maxlength="4" size="4"><span>年</span>
				<input id="MM" type="text" maxlength="2" size="2"><span>月</span>
				<input id="dd" type="text" maxlength="2" size="2"><span>日</span>
				<br> 請輸入天數<input id="d" type="text" maxlength="2" size="2">
				<button id="show" type="button">製作報表</button>
			</div>
			<div style="justify-content: center;width: 50%; height: 400px;overflow: auto;">
				<table class="excelTable">
					<tbody id="ShowReport">
					</tbody>
				</table>
			</div>
	</div>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#show").click(showexcel)

							function showexcel() {
								$
										.post(
												"ShowExcel",
												{
													"yyyy" : $("#yyyy").val(),
													"MM" : $("#MM").val(),
													"dd" : $("#dd").val(),
													"d" : parseInt($("#d")
															.val())
												},
												function(data, status) {
													if (status == "success") {
														$("#ShowReport")
																.html(
																		"<tr><th>產品編號</th><th>產品名稱</th><th>倉庫編號</th><th>數量</th><th>狀態</th></tr>")
														var querydata = $
																.parseJSON(data);
														$
																.each(
																		querydata,
																		function(
																				index,
																				json) {
																			$(
																					"#ShowReport")
																					.append(
																							"<tr><td>"
																									+ json.proid
																									+ "</td><td>"
																									+ json.productBean.model
																									+ "</td><td>"
																									+ json.branchid
																									+ "</td><td>"
																									+ json.amount
																									+ "</td><td>"
																									+ json.statu
																									+ "</td></tr>")
																		})
													}
												})
							}
						})
	</script>
</body>

<div>
	<footer>
		<div class="f0">

			<p>E-amil:aaa@gmail.com &nbsp; Tel:(02)2222-2222 &nbsp;</p>
			<p>台北市復興南路一段390號 &nbsp; &copy; 2018 All Rights Reserved Quality
				Art Technology CO.</p>

		</div>
	</footer>
	<br>
</div>

</body>
</html>