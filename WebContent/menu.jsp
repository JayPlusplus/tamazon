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
<title>Burgers....</title>
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include> 
 <div class="w3-row w3-padding-64" id="menu">
    <div class="w3-col l6 w3-padding-large">
    <c:forEach var="product" items="${products}">
      <h1 class="w3-center">Our Menu</h1><br>
      <h4>${products.productname}</h4>
      <p class="w3-text-grey">${products.productdescription}  ${products.productprice} </p><br>
      <form action="AddProduct" method="post">
      <select name="quant" class="btn btn-primary">

						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
					</select>
                                <input type="submit" name="addToCart" value="Buy Now!">
                                <input type="hidden" name="productid" value="${product.productid}">
                                </form>
       </c:forEach>
      
    </div>
    
    <div class="w3-col l6 w3-padding-large">
      <img src="pics//burger3.jpg" class="w3-round w3-image w3-opacity-min" alt="Menu" width="500" height="750">
    </div>
  </div>
  
<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">Jay.css</a></p>
</footer>

</body>
</html>
</body>
</html>