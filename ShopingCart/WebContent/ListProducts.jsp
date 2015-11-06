<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Shopping Site</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>	
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
</head>
<body>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="img/Chrysan.jpg" alt="Chrysanthemum"
					style="width: 140px; height: 140px;">
				<div class="carousel-caption">
					<caption>Lovely Chrysanthemum</caption>
				</div>
			</div>
			<div class="item">
				<img src="img/Desert.jpg" alt="Desert"
					style="width: 140px; height: 140px;">
				<div class="carousel-caption">
					<caption>Hot Desert</caption>
				</div>
			</div>
			<div class="item">
				<img src="img/Hydrangeas.jpg" alt="Hydrangeas"
					style="width: 140px; height: 140px;">
				<div class="carousel-caption">
					<caption>Beautiful Hydrangeas</caption>
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Online Shopping Store</a>
			</div>
			<div>
 				<ul class="nav navbar-nav">
						<li><a href="ListProducts">View Merchandises</a></li>
							<li><a href="register.html">Join Membership</a></li>
							<li><a href="login.jsp">Login</a></li>
							<li><a href="ViewCart.jsp">View the Items in Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<form class="form-inline" action="ProductDetail">
<!-- 		${message} -->	
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Description/Image</th>
					<th>Unit Price</th>
					<th></th>
				</tr>
				<c:forEach items="${products}" var="prod">
					<tr>
						<td>${prod.name}</td>
						<td>${prod.description}<br>
						<img src="img/${prod.pic}" alt="HTML5 Icon" width="128"
							height="128"></td>
						<td><fmt:setLocale value="en_US" />
							<fmt:formatNumber value="${prod.unitprice}" type="currency" /></td>
						<td><a class="btn btn-default"
							href="AddToCart?ProductId=${prod.id}" role="button">Add
								to Cart</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>