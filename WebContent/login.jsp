<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>-- Please log in --</title>
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<br/>
<br/>
<br/>
<div align="center">
<h5>${message}</h5>


<form action = "ValidateServ" method="post">
Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username"><br/>
	Password:&nbsp;<input type="password" name="password"><br/>
	<input type="hidden" name="action" value="login">
	<input type="submit" value="Submit">
	<a href="signUp.jsp">Sign up</a>	
</form>
</div>
</body>
</html>