<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Import Detail</title>
</head>
<body>
	Import Detail
<table>
<thead>
	<tr>
		<th>Import ID</th>
		<th>Amount</th>
		<th>Product ID</th>
		<th>Brand</th>
		<th>Category</th>
		<th>Model</th>
		<th>Picture</th>
		<th>Price</th>
		
</thead>

<tbody>
	<c:forEach var="row2" items="${detail}">

		<tr>
			<td>${row2.improtid}</td>
			<td>${row2.amount}</td>
			<td>${row2.proid}</td>
			<td>${row2.productBean.brandBean.brand}</td>
			<td>${row2.productBean.categoryBean.category}</td>
			<td>${row2.productBean.model}</td>
			<td>${row2.productBean.picture}</td>			
			<td>${row2.productBean.price}</td>
		</tr>
	</c:forEach>
</tbody>
</table>	

</body>
</html>