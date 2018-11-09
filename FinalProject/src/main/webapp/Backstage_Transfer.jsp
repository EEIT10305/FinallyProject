<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer</title>
</head>
<body>

<a href = "/FinalProject/Backstage_Transfer_Search_Result.jsp">Back to Detail</a>
<br>
<br>
Transfer
<form action = "/FinalProject/pages/insert.transfer.controller">
<table>
<caption>Transfer From</caption>
	<tr>
		<td>Branch ID : </td>
		<td><input type="text" name="branchidin" value="${param.branchid}" maxlength = "3"></td>		
	</tr>
	
	
	<tr>
		<td>Product ID : </td>
		<td><input type="text" name="proidin" value="${param.proid}" maxlength = "6"></td>		
	</tr>


	<tr>
		<td>Amount :  </td>
		<td><input type="text" name="amountin" value="${param.amount}" maxlength = "8"></td>
	</tr>

	
	
</table>



<br>
<br>
<br>

<div>Transfer To

<%-- <c:set var = "branchidin" value = "${param.branchid}"/> --%>
			
				<select name = "branchidout" value = "${param.branchidout}">
					<option value = "1">台北1號總店</option>
					<option value = "2">台中2號分店</option>
					<option value = "3">桃園3號分店</option>
					<option value = "4">台南4號分店</option>
					<option value = "5">高雄5號分店</option>
				</select>
				
				<br>
				<br>
</div>

			<input type="submit" value="Transfer">


</form>

<c:if test = "${not empty transferRecord}">
<table border = "2px">
<caption>Import</caption>
<thead>

	<tr>
		<th>Transfer ID</th>
		<th>Amount transferred</th>
		<th>From</th>
		<th>To</th>
		<th>Transfer Date</th>
		<th>Product ID</th>		
</thead>
<tbody>
	<c:forEach var="row" items="${transferRecord}" >
	
		<tr>
			<td>${row.transferid}</td>				
			<td>${row.amount}</td>
			<td>${row.branchidin}</td>
			<td>${row.branchidout}</td>
			<td>${row.date}</td>
			<td>${row.proid}</td>
			
		</tr>
		
	</c:forEach>
</tbody>
</table>
</c:if>





</body>
</html>