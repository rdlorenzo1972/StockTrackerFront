<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<link href="styles/style.css" rel="stylesheet" />
	<title>STOCK TRACKER</title>
</head>
<body>
	<div class="container">
		<header class="main-header">
			<h1>STOCK TRACKER</h1>
		</header>
		<article>
			<form action="stockControllerSignin" method="GET">
			
				<table>
					<tr>
						<td><label for="user_name">Username </label></td>
						<td><input type="text" name="user_name" value="${user.name} required></td>
					</tr>
					<tr>
						<td><label for="user_password">Password </label></td>
						<td><input type="password" name="user_password" value="${user.email}" required></td>
					</tr>
					<tr>
						<td><input type="hidden" name="action" value="userSignin"></td>
						<td><input type="submit" value="Signin" class="signinButton"></td>
					</tr>
					<tr>
						<td><label class="or_separator">or</label><br></td>
					</tr>
					<tr>
					
					</tr>
					<tr>
						<td></td>
						<td>Don't have an account? <a href="/register.jsp">Sign up now</a></td>
					</tr>

				</table>
			</form>
		</article>
	</div>
	
</body>
</html>