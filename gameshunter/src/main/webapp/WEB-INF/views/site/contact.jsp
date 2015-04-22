<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contato</title>
<gameshunter:resources />
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/contact.css"></c:url>">
</head>
<body>
	<gameshunter:header />
	<main class="container">

	<fieldset class="form-box">
		<form class="form-description">
			<label for="nome">Nome:</label> <input id="nome" type="text"
				name="nome" placeholder="Digite seu nome"> <label
				for="email">E-mail:</label> <input id="email" type="email"
				name="email" placeholder="Digite seu e-mail"> <label
				for="mensagem">Mensagem:</label>
			<textarea id="mensagem" rows="5" cols="10"
				placeholder="Digite sua mensagem" name="mensagem"></textarea>
			<button type="submit">Enviar</button>

		</form>
	</fieldset>

	</main>

	<gameshunter:footer />
</body>
</html>