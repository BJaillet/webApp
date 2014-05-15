<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

</head>
<body>

	<form:form action="save.do" commandName="cl" method="POST">
		<form:hidden name="id" path="id"/>
		
		<form:label path="nom">Nom</form:label>
		<form:input name="nom" path="nom"/>
		<form:errors path="nom"/>
		
		<form:label path="age">Age</form:label>
		<form:input name="age" path="age"/>
		<form:errors path="age"/>
		
		<form:label path="email">Email</form:label>
		<form:input name="email" path="email"/>
		<form:errors path="email"/>
		
		<form:label path="dateInscription">Date inscription</form:label>
		<form:input name="dateInscription" path="dateInscription"/>
		<form:errors path="dateInscription"/>
		
		<input type="submit" value="valider"></input>
	</form:form>

</body>
</html>