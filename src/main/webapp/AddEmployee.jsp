<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Register Page</title>
</head>
<body>
	<form action="RegisterEmployee" method="post">
	<table>
		<tr>
			<th>ID</th>
			<th><input type="number" placeholder="Enter the id" name="txtId"/><th>
		<tr>
			<th>NAME</th>
			<th><input type="text" placeholder="Name" name="txtName"/><th>
		</tr>
		
		<tr>
			<th>PASSWORD</th>
			<th><input type="password" placeholder="password" name="txtPassword"/><th>
		</tr>
		
		<tr>
			<th>EMAIL</th>
			<th><input type="text" placeholder="abc@gmail.com" name="txtEmail"/><th>
		</tr>
		
		<tr>
			<th>COUNTRY</th>
			<th><input type="text" placeholder="country" name="txtCountry"/><th>
		</tr>	
		<tr>
			<th><button type="sumbit" value="register">REGISTER</button></th>
			<th><button type="reset">CLEAR</button></th>
		</tr>
		<tr>
			<th><a href="RegisterEmployee?action=view">View All Employee</th>
		</tr>
	</table>	
	</form>

</body>
</html>