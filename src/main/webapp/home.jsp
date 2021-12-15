<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<h1>Put Data Form</h1>
	<form action="addStudent">
		id:<input type="text" name="id"><br>
		name:<input type="text" name="name">
		<br>
		<input type="submit"><br>
	</form>
	
	<h1>Get Data Form</h1>
	<form action="getStudent">
		id:<input type="text" name="id"><br>
		<input type="submit"><br>
	</form>
	
	<h1>Show Data</h1>
	<ol>
		<c:forEach var="s" items="${students}">
		
			<li>${s.name}  with id   ${s.id}</li>
			<form action="delete/${s.id}"><Button type="submit">Delete</Button><br></form>
			<form action="update"><input style="display: none;" type="text" name="id" value=${s.id}><Button type="submit">Update</Button><br></form>
			
		</c:forEach>
	</ol>
	<!-- <img src="<c:url value="/images/701478.jpg"/>"/> -->
</body>
</html>