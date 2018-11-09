<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>

</head>
<body>
Search Result

<form action = "/FinalProject/pages/transfer.controller">
<table border = "2px">
<caption>Transfer</caption>
<thead>

	<tr>
		<th>Branch Stock ID</th>
		<th>Branch Name</th>
		<th>Amount</th>
		<th>Product Brand</th>
		<th>Product Model</th>
		<th>Product ID</th>
		<th>Product Category</th>
		
		
		
		
</thead>
<tbody>
	<c:forEach var="row" items="${transfer}" >

		<tr>
			<td>${row.branch_stock_id}</td>
			<td>${row.branchBean.name}</td>
			<td>${row.amount}</td>
			<td>${row.productBean.brandBean.brand}</td>
			<td>${row.productBean.model}</td>
			<td>${row.proid}</td>
			<td>${row.productBean.categoryBean.category}</td>						
			<td><a href="/FinalProject/pages/transfer.controller?branchstockid=${row.branch_stock_id}&amount=${row.amount}&proid=${row.proid}&branchid=${row.branchid}">Transfer</a></td>			
			<!--/FinalProject/pages/transfer.controller?amount=${row.amount}&proid=${row.proid}&branchid=${row.branchid}-->
		</tr>
		
	</c:forEach>

</tbody>
</table>
</form>

</body>
</html>