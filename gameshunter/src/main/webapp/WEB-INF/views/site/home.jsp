<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Games Hunter</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/reset.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site-bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/home.css"></c:url>">
</head>
<body>
	<div class="wrapper">
		<c:import url="cabecalho.jsp"></c:import>

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


		</main>
	</div>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>