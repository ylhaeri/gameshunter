<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/reset.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site-bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site.css"></c:url>">
<title>Games Hunter</title>
</head>
<body>

	<div class="wrapper">
		<c:import url="../site/cabecalho.jsp"></c:import>

		<main class="container">
		<h1>Bem vindo</h1>
		<p>Enviamos um email para ${usuario.email} ativar o seu cadastro.
			Verifique sua caixa de entrada.
		</main>
	</div>

	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>