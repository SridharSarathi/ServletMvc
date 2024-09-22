<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
</head>
<body>
		<h5><a href="AddEmployee.jsp">ADD NEW EMPLOYEE<a></h5>
		<h1>EMPLOYEE LIST</h1>
		<table border="2px"  cellpadding=2>
				<tr>
						<th colspan=2>ID</th>
						<th colspan=2>NAME</th>
						<th colspan=2>PASSWORD</th>
						<th colspan=2>EMAIL</th>
						<th colspan=2>COUNTRY</th>
						<th colspan=2>EDIT</th>
						<th colspan=2>DELETE</th>
				</tr>
				
				<c:forEach items="${employeslist}" var="emp">
				<tr>
				    <td  colspan=2>${emp.id}</td>
				    <td  colspan=2>${emp.ename}</td>
				    <td  colspan=2>${emp.password}</td>
				    <td  colspan=2>${emp.email}</td>
				    <td  colspan=2>${emp.country}</td>
				    <td  colspan=2><a href="RegisterEmployee?action=edit&empid=${emp.id}">edit</a></td>
				    <td  colspan=2><a href="RegisterEmployee?action=delete&empid=${emp.id}">delete</a></td>
				    </tr>
		
				</c:forEach>
			
		</table>
</body>
</html>