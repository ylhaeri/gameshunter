<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Games Hunter</title>
<gameshunter:resources />
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/home.css"></c:url>">
</head>
<body>
	<div class="wrapper">
		<gameshunter:header />

		<main class="container">
		<div>
			<h1>Em busca de novos jogos? Cadastre-se e confira!</h1>

			<a href="<c:url value="/usuario/cadastrado" />">Cadastrado-teste</a>

			<p>Coonteúdo para pessoas novas... (CONTEÚDO APENAS PARA
				PREENCHER O ESPAÇO EM BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO
				EM BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO EM BRANCO)</p>

			<h2>Novidades</h2>
			<p>Conteúdo de novidades... (CONTEÚDO APENAS PARA PREENCHER O
				ESPAÇO EM BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO EM
				BRANCO-CONTEÚDO APENAS PARA PREENCHER O ESPAÇO EM BRANCO-CONTEÚDO
				APENAS PARA PREENCHER O ESPAÇO EM BRANCO)</p>

			<h2>Precisamos definir o restantes</h2>

		</div>

		Language : <a href="?language=en_US">English</a>| <a
			href="?language=pt_BR">Português</a>

		<h3>
			<c:set var="teste" value="${pageContext.response.locale}"></c:set>
			welcome.springmvc :
			<spring:message code="welcome.springmvc" text="default text" />
		</h3>

		Current Locale: ${pageContext.response.locale} </main>
	</div>

	<gameshunter:footer />
</body>
</html>