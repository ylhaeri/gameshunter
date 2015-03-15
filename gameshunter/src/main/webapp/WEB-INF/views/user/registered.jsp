<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<gameshunter:resources />
<title>Games Hunter</title>
</head>
<body>

	<div class="wrapper">
		<gameshunter:header />

		<main class="container">
		<h1>Bem vindo</h1>
		<p>Enviamos um email para ${sessionScope['user'].email} ativar o seu cadastro.
			Verifique sua caixa de entrada.
		</main>
	</div>

	<gameshunter:footer />
</body>
</html>