<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

</head>
<body>

	<table border="1">
		<tr>
			<th>Nom</th>
			<th>Age</th>
			<th>Email</th>
			<th>Date inscription</th>
			<th>Actions</th>
		</tr>
	
		<tr>
			<c:forEach var="client" items="${clients}">
				<tr>
					<td>${client.nom}</td>
					<td>${client.age}</td>
					<td>${client.email}</td>
					<td>${client.dateInscription}</td>
					<td colspan="2"><a href="delete.do?id=${client.id}">Delete</a>
						<a href="init.do?id=${client.id}">Update</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>