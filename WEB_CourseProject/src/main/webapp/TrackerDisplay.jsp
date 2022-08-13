<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.String" %>
<%
	String sendingURL = (String) request.getHeader("referer");
	System.out.println(sendingURL);
	if (!(sendingURL.equalsIgnoreCase("http://localhost:8080/WEB_CourseProject/index.jsp") || 
			sendingURL.equalsIgnoreCase("http://localhost:8080/WEB_CourseProject/register.jsp") || 
			sendingURL.equalsIgnoreCase("http://localhost:8080/WEB_CourseProject/TrackerDisplay.jsp") ||
			sendingURL.equalsIgnoreCase("http://localhost:8080/WEB_CourseProject/stockControllerSignin"))) {
		System.out.println(sendingURL);
		response.sendRedirect("index.jsp");
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<link href="styles/style.css" rel="stylesheet" />
	<title>STOCK TRACKER Display</title>
</head>
<body>

	<%-- sendingURL.equalsIgnoreCase("http://localhost:8080/WEB_CourseProject/stockControllerSignin")    --%>
	
	<div class="container">
		<header class="main-header">
			<h1>STOCK TRACKER</h1>
		</header>
		<article>
			<p style='color:red'><i>${message}</i></p>
			<form action="stockControllerSignin" method="POST">
			
				<label for="user_firstName">First Name </label>
				<input type="text" name="user_firstName" value="${user_firstName}" required><br>
				
				<label for="user_lastName">Last Name </label>
				<input type="text" name="user_lastName" value="${user_lastName}" required><br>
			
				<label for="user_name">Email (Username) </label>
				<input type="text" name="user_name" value="${user_name}" required><br>

				<label for="user_password">Password </label>
				<input type="password" name="user_password" value="${user_password}" required id="password"><br>
				
				<label for="user_passwordComfirm">Re-type Password </label>
				<input type="password" name="user_passwordConfirm" required><br>

				<input type="hidden" name="action" value="userSignUp">
				<input type="submit" value="Sign up" class="signinButton"><br>

			</form>
		</article>
	</div>
</body>
</html>