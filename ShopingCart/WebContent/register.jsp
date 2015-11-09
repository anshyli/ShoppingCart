<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
		<form class="form-inline" action="Register" method="post">
			<h2>Welcome to join the Online Shopping Group</h1>
			<table class="table table-condensed">
				<tr>
					<td>
						<div class="form-group">
							<label class="sr-only" for="loginname">Login ID</label> <input type="text" class="form-control"
								id="loginname" placeholder="loginname" name="loginname" required="reguired">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Register</button>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</body>
</html>