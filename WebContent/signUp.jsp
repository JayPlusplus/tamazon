<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>-- Sign Up Page --</title>
</head>
<body>
<br/>
<br/>
<br/>
<div align="center">
<jsp:include page="navbar.jsp"></jsp:include>
<form action = "AddUser" method="post">
Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username"><br/>
	Password:&nbsp;<input type="password" name="password"><br/>
	Email:&nbsp;<input type="text" name="useremail"><br/>
	<input type="hidden" name="action" value="login">
	<input type="submit" name="submit" value="Submit" Align="right">
	
</form>
</div>
</body>
</html>