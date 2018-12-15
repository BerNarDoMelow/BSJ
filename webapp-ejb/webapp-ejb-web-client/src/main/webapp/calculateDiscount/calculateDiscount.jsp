<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<model" class="presentation.web.model.CalculateDiscountModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: calcular disconto</title>
</head>
<body>
<h2>Calcular Disconto</h2>
<form action="calculatedDiscount" method="post">
    <div class="mandatory_field">
    	<label for="saleid">ID Venda:</label> 
    	<input type="sale" name="saleid" min="0"/> 
    	<input type="submit">
    </div>
</form>
<c:if test="${model.hasMessages}">
	<h2>"${model.messages}"</h2>
	<p>Discount</p>
	<tr>
		<th>Id disconto</th>
		<th>descricao</th>
		<th>total</th>
	</tr><br>
	<tr>
		<td>${model.getDiscount(model.getSaleId()).getId()}</td>
		<td>${model.getDiscount(model.getSaleId()).getDescription()}</td>
		<td>"${model.getDiscount(model.getSaleId()).getTotal()}"</td>
	</tr>
</c:if>
</body>
</html>