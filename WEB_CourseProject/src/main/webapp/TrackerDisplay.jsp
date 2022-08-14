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
	<link href="styles/trackStyle.css" rel="stylesheet" />
	<title>STOCK TRACKER Display</title>
</head>
<body>

	<div class="grid-container">
		<header class="main-header">
			<h1>STOCK TRACKER</h1>
			
			<nav>
			<a href="index.jsp">Logout need fix</a>
			</nav>
		</header>
		
		<aside class="aside-item">
			<label>Stock Code</label><br>
			<input type="text" name="stockSymbol" size="10">
			<button>Click me!</button>
			The button above is not tied to form, intent is JS listener that will do input validation then update graph and news.
		</aside>
		
		<article class="stockGraph">
			This section will display the stock graph (1-year for stock symbol).
		</article>
		
		<footer class="footer-item">
		Will put news here 
		</footer>
	</div>
</body>
</html>