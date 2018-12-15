<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.VendedorToSaleModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: associar vendedor a venda</title>
</head>
<body>
<h2>Associar Vendedor a Venda</h2>
<form action="vendedorToSale" method="post">
    <div class="mandatory_field">
		<label for="saleid">Id da Venda</label> 
		<input type="number" name="saleid" value="${model.getSaleId()}"/> <br/>
    </div>
   <div class="mandatory_field">
   		<label for="saleid">Numero de Vendedor</label> 
		<input type="number" name="number" value="${model.getNumber()}"/> <br/>
   </div>
   <div>
   		<input type="submit">
   </div>
</form>
<c:if test="${model.hasMessages}">
	<p>Mensagens</p>
	<ul>
	<c:forEach var="mensagem" items="${model.messages}">
		<li>${mensagem} 
	</c:forEach>
	</ul>
</c:if>
</body>
</html>