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
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card-2" style="letter-spacing:4px;">
    <a href="tamazon.jsp" class="w3-bar-item w3-button">Gourmet Dave's Catering</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
    
      <a href="login.jsp" class="w3-bar-item w3-button">Log in</a>
      <a href="signUp.jsp" class="w3-bar-item w3-button">Sign Up</a>
      <a href="about.jsp" class="w3-bar-item w3-button">About</a>
      <a href="contactSection.jsp" class="w3-bar-item w3-button">Contact</a>
    </div>
  </div>
</div>

<br/>
<br/>
<br/>
<div align="center">
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