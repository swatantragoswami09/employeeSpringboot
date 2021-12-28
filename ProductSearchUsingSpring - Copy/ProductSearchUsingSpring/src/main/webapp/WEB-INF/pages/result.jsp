<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nagarro.model.Products"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login");
		}
	%>
	<div class="container mt-5" style="">
		<h1 class="text-center mt-2">Search Result</h1>
		<table class="table  mt-2"
			style="background-color: #d3f5f3;">
			<thead>
				<tr>
					<th align="center" scope="col">ID</th>
					<th align="center" scope="col">NAME</th>
					<th align="center" scope="col">COLOUR</th>
					<th align="center" scope="col">GENDER_RECOMMENDATION</th>
					<th align="center" scope="col">SIZE</th>
					<th align="center" scope="col">PRICE</th>
					<th align="center" scope="col">RATING</th>
					<th align="center" scope="col">AVAILABILITY</th>
				</tr>
			</thead>
<tbody>
				<%
					List<Products> result = (List<Products>) request.getAttribute("resultedproducts");
					if (result.size() > 0) {
						for (Products product : result) {
				%>
				<tr>
					<td align="center"><%=product.getId()%></td>
					<td align="center"><%=product.getName()%></td>
					<td align="center"><%=product.getColor()%></td>
					<td align="center"><%=product.getGender_rec()%></td>
					<td align="center"><%=product.getSize()%></td>
					<td align="center"><%=product.getPrice()%></td>
					<td align="center"><%=product.getRating()%></td>
					<td align="center"><%=product.getAvalability()%></td>
					
				</tr>
				<%
					}
					} else {
				%>
				<h1 class="text-center" style="color: red;">No result found!!!</h1>
				<%
					}
				%>
			</tbody>
						
			
			
		</table>
	</div>
	<div class="text-center mt-10">
		<form action="logout">
			<input type="submit" value="Logout" />
		</form>
		<a href="searchPage" class="btn">Go back to Search Page</a>
		
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
</html>