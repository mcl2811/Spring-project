<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration Form</title>
	<style> <%-- inline css --%>
		.error {color:red}
		
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #009dfa;
  border-radius: 4px;
}	

.button {
	box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	background:linear-gradient(to bottom, #79bbff 5%, #378de5 100%);
	background-color:#79bbff;
	border-radius:6px;
	border:1px solid #84bbf3;
	display:inline-block;
	cursor:pointer;
	width:130px;
	color:#ffffff;
	font-family:Verdana;
	font-size:13px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #528ecc;
}
	</style>
</head>
<body> <font face = "Verdana" size = "2">
	<i> Fill out the form. </i>
	<br> <br>
	<form:form action="processForm" modelAttribute="customer">
		<form:hidden path="id" />
		
		First Name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		
		<br> <br>
		Last name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br> <br>
		Email: <form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br> <br>
		<input class="button" type="submit" value="Submit" />
	</form:form>
	<br>
	<button class="button" onclick="history.back()">Go Back</button>
</body>
</html>