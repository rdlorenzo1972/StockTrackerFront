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
			<p style='color:red'><i>${message}</i></p>
			<form action="stockControllerSignin" method="POST">
				<label for="user_name">Username </label>
				<input type="text" name="user_name" value="${user.name}" required><br>

				<label for="user_password">Password </label>
				<input type="password" name="user_password" value="${user.email}" required><br>

				<input type="hidden" name="action" value="userSignin">
				<input type="submit" value="Signin" class="signinButton"><br>
				<div class="signUpText">
					<label class="signintext" class="or_separator">or</label><br>
					<label class="signintext">Don't have an account? <a href="/register.jsp">Sign up now</a></label>
				</div>
			</form>
		</article>
	</div>
</body>
</html>