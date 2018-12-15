<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.ListSalesModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: mostrar todos as Vendas</title>
</head>
<body>
<h2>Mostrar Vendas</h2>

Número de Vendas: <c:out value = "${model.getSales().size()}"></c:out>

<br><br><br>
<table id="clients" class="clientList">
    <tr>
    	<th>Id</th>
		<th>Customer VAT Number</th>
		<th>Aberta</th>
		<th>Vendedor</th>
		<th>Comissão</th>
	</tr>
	<c:forEach var="sale" items="${model.getSales()}">
		<tr>
			<td align="center">${sale.getId() }</td>
			<td align="center">${sale.getCustomer().getVATNumber()}</td>
			<td align="center">${sale.isOpen()}</td>
			<td align="center">${sale.getVendedor().getName()}</td>
			<td align="center">${sale.getComission()}</td>
		</tr>
		<c:forEach var="saleproduct" items="${model.getSaleProducts(sale.getId())}">
			<td align="center">${saleproduct.getDescription()}</td>
			<td align="center">${saleproduct.getQty()}</td>
		</c:forEach>
	</c:forEach>
</table>


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