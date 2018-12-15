<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.ListVendedoresModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: mostrar todos os Vendedores</title>
</head>
<body>
<h2>Mostrar Vendedores</h2>

Número de Vendas: <c:out value = "${model.getVendedores().size()}"></c:out>

<br><br><br>
<table id="clients" class="clientList">
    <tr>
		<th>Name</th>
		<th>Number NIF</th>
		<th>Telemovel</th>
		<th>Total de Comissões</th>
	</tr>
	<c:forEach var="vendedor" items="${model.getVendedores()}">
		<tr>
			<td align="center">${vendedor.getName()}</td>
			<td align="center">${vendedor.getNumber()}</td>
			<td align="center">${vendedor.getPhoneNumber()}</td>
			<td align="center">${vendedor.getTotalComission()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>