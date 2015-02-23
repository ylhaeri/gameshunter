<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil</title>
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
<link rel="stylesheet"
	href="<c:url value="/resources/css/usuario/perfil.css"></c:url>">
<script src="<c:url value="/resources/js/jquery/jquery.js"></c:url>"></script>
</head>
<body>

	<div class="wrapper">
		<c:import url="../site/cabecalho.jsp"></c:import>
		<main class="container">

		<div class="profile-banner">
			<input type="file" id="teste" class="hidden"> <label
				id="usuario-foto-label" for="teste"> <img
				alt="foto-do-perfil" id="usuario-foto"
				src="<c:url value="/usuario/teste"></c:url>"
				class="img-circle img-thumbnail" />
			</label>


			<div class="profile-banner-content">
				<h1>${sessionScope['usuario'].apelido}</h1>
			</div>

		</div>

		<div class="profile">

			<table class="profile-table">
				<tr>
					<td>Nome</td>
				</tr>
				<tr>
					<td>Email</td>
				</tr>
				<tr>
					<td>Sexo</td>
				</tr>
				<tr>
					<td>Data de Nascimento</td>
				</tr>
				<tr>
					<td>Telefone</td>
				</tr>
				<tr>
					<td>Celular</td>
				</tr>
			</table>

			<table class="profile-table-information">
				<tr>
					<td>${sessionScope['usuario'].nome}</td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].email}</td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].sexo}</td>
				</tr>
				<tr>
					<td><spring:eval expression="usuario.dataNascimento" /></td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].telefone}</td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].celular}</td>
				</tr>
			</table>
		</div>
		</main>
	</div>
	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>