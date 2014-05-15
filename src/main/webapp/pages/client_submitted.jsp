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
	<p>client ${cl2.id} ${cl2.nom} 
		<fmt:formatDate value="${cl2.dateInscription}" pattern="dd/MM/yyyy"/>
		${cl2.age} ${cl2.email} sauvé.
	</p>
	<a href="init.do"><button type="button">back</button></a>

</body>
</html>