<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style> 
  body {text: white; background-color: white;  text-align: center; }
   p {background-color: white;}
   h1{text:white; text-aligh-left;}
   </style>
<title>Login</title>
</head>
<body>
<!-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Online Shopping</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
						<li><a href="ListProducts">View Merchandises</a></li>
						<li><a href="register.html">Join Memebership</a></li>
						<li><a href="login.jsp">Login</a></li>
						<li><a href="ViewCart.jsp">View the Items in Cart</a></li>
      </ul>
    </div>
  </div>
</nav> -->
<jsp:include page="./menu.jsp"/>
<div class="container">
  <div class="jumbotron">
    <h1>Online Shopping store</h1>      
  </div>

	<form role="form" action = "Login" method = "post">
    <div class="form-group">
      <label for="loginname"></label>
      <input type="text" class="form-control" id="user" name="loginname" placeholder="Enter login name" name="loginname">
    </div>
<!--      <div class="form-group">
      <label for="address"></label>
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
    </div>
 -->
    <button type="submit" class="btn btn-default">Login</button>
    </form>       
   <h2><a href = "register.jsp" >Register for Membership</a></h2>
</div>
</body>
</html>