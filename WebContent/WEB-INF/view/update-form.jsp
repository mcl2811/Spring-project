<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer update Form</title>
	<style> <%-- inline css --%>
		.error {color:red}
	</style>
</head>
<body>
	<i> Fill out the form. </i>
	<br> <br>
	<form:form action="updateForm" modelAttribute="customer">
		First Name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br> <br>
		Last name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br> <br>
		Email: <form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br> <br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>