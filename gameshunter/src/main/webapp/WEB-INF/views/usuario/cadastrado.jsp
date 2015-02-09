<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/site/reset.css">
<link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet"
	href="../resources/css/site/gameshunter-bootstrap.css">
<link rel="stylesheet" href="../resources/css/site/gameshunter.css">
<link rel="stylesheet"
	href="../resources/css/usuario/cadastrar-usuario.css">
<title>Cadastro Efetuado</title>
</head>
<body>

	<c:import url="../site/cabecalho.jsp"></c:import>

	<main class="container">
	<h1>Bem vindo</h1>
	<p>Enviamos um email para ${usuario.email} ativar o seu cadastro.
		Verifique sua caixa de entrada.
	</main>

	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>