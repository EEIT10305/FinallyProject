<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Backstage Success</title>
</head>
<body>
Update Status Success
<c:forEach var="row3" items="${success}">

		<tr>									
			<td>${row3.improtid}</td>
			<td>${row3.orderdate}</td>
			<td>${row3.statu}</td>
			

		</tr>

	</c:forEach>



</body>
</html>