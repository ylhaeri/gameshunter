<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Games Hunter</title>
<gameshunter:resources />
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/home.css"></c:url>">
</head>
<body>
	<div class="wrapper">
		<div id="hu3"></div>
		<gameshunter:header />

		<main class="container">
		<div>
			<h1>Em busca de novos jogos? Cadastre-se e confira!</h1>

			<a href="<c:url value="/usuario/cadastrado" />">Cadastrado-teste</a>

			<p>Coonteúdo para pessoas novas... (CONTEÚDO APENAS PARA
				PREENCHER O ESPAÇO EM BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO
				EM BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO EM BRANCO)</p>

			<h2>Precisamos definir o restante</h2>

		</div>
	</div>

	<gameshunter:footer />
</body>
</html>