<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation Form</title>
<style>
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
<body>
<font face = "Verdana" size = "2">
The customer ${customer.firstName} ${customer.lastName} with email ${customer.email} has been added to the database
<br> <br>
<br> <br> 
<button class="button" onclick="history.go(-2)">Main Menu</button>
</body>
</html>