<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Online Shopping Site</title>
	<jsp:include page="./header.jsp"/>
</head>
<body>
	<jsp:include page="./carousel.jsp"/>
	<jsp:include page="./menu.jsp"/>
	<div class="jumbotron">
		<form class="form-inline" action="CheckOut">
			<p>The Shopping Cart for ${myCart.aShopper.name}.</p>
			<table class="table table-bordered">
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th></th>
				</tr>
				<c:forEach items="${myCart}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.quantity}</td>
						<td><fmt:setLocale value="en_US" />
							<fmt:formatNumber value="${item.total}" type="currency" /></td>
						<td><a class="btn btn-default"
							href="RemoveFromCart?ProductId=${item.product.id};ShopperId=${item.shopper.id}" role="button">Add
								to Cart</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>