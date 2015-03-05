<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
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
<script src="<c:url value="/resources/js/jquery/jquery.js"></c:url>"></script>
<title>Games Hunter</title>
</head>
<body>

	<div class="wrapper">
		<gameshunter:header />

		<main class="container">
		<h1>Bem vindo</h1>
		<p>Enviamos um email para ${usuario.email} ativar o seu cadastro.
			Verifique sua caixa de entrada.
		</main>
	</div>

		<gameshunter:footer />
</body>
</html>