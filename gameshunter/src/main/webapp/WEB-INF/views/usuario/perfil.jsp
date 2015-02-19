<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</head>
<body>


	<div class="wrapper">
		<c:import url="../site/cabecalho.jsp"></c:import>
		<main class="container">


		<div class="profile-banner">

			<div class="profile-banner-photo">
				<img alt="foto-padrão-do-perfil"
					src="<c:url value="/resources/img/photo-default.png"></c:url>"
					class="img-circle" />
			</div>

			<div class="profile-banner-content">
				<h1>Apelido</h1>
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
				<td>Celular</td>
				<tr>
				</tr>
			</table>

			<table class="profile-table-information">
				<tr>
					<td>${usuario.nome}</td>
				</tr>
				<tr>
					<td>${usuario.email}</td>
				</tr>
				<tr>
					<td>${usuario.sexo}</td>
				</tr>
				<tr>
					<td>${usuario.dataNascimento}</td>
				</tr>
				<tr>
					<td>${usuario.telefone}</td>
				</tr>
				<tr>
					<td>${usuario.celular}</td>
				</tr>
			</table>
		</div>
		</main>
	</div>
	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>