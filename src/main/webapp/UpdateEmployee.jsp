<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Update Page</title>
</head>
<body>
<h1>Upadate Employee</h1>
<form action="UpdateServlet" method="post">
	<table>
	     <c:forEach items="${employeebyid}" var="emp">
		<tr>
			<th></th>
			<th><input type="number" value="${emp.id}"  hidden="true" name="txtId" /><th>
		<tr>
			<th>NAME:</th>
			<th><input type="text" value="${emp.ename}" name="txtName"/><th>
		</tr>
		
		<tr>
			<th>PASSWORD:</th>
			<th><input type="password" value="${emp.password}" name="txtPassword"/><th>
		</tr>
		
		<tr>
			<th>EMAIL:</th>
			<th><input type="text" value="${emp.email}" name="txtEmail"/><th>
		</tr>
		
		<tr>
			<th>COUNTRY:</th>
			<th><input type="text" value="${emp.country}" name="txtCountry"/><th>
		</tr>	
		<tr>
			<th><button type="sumbit" value="update">EDIT&SAVE</button></th>
			
		</tr>
		<!--  -<tr>
			<th><a href="RegisterEmployee?action=view">View All Employee</th>
		</tr-->
	</c:forEach>
	</table>	
	</form>

</body>
</html>