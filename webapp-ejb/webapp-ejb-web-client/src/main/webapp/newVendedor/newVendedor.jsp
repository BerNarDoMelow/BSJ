<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.NewVendedorModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: adicionar cliente</title>
</head>
<body>
<h2>Adicionar Cliente</h2>
<form action="createVendedor" method="post">
    <div class="mandatory_field">
		<label for="Nome">Nome de Vendedor:</label> 
		<input type="text" name="name" value="1"/> <br/>
    </div>
    <div class="mandatory_field">
    	<label for="telephone">Telefone:</label> 
    	<input type="text" name="phonenumber" value="1"/> 
    </div>
    <div class="mandatory_field">
		<label for="number">Numero de Vendedor:</label> 
		<input type="number" name="number" value="1"/> <br/>
    </div>
   <div class="button" align="right">
   		<input type="submit" value="Criar Vendedor">
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