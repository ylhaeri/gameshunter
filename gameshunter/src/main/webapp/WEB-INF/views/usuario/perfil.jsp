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
<title>Perfil</title>
<gameshunter:resources />
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/home.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/usuario/perfil.css"></c:url>">
</head>
<body>

	<div class="wrapper">
		<gameshunter:header />
		<main class="container">

		<div class="profile-banner">
			<form action='<c:url value="/usuario/setFoto"></c:url>' method="post"
				enctype="multipart/form-data">
				<img alt="foto-do-perfil" id="usuario-foto-label"
					src="<c:url value="/usuario/teste"></c:url>"
					class="img-circle img-thumbnail" /><br /> <input type="file"
					name="file"> <input type="submit" style="color: black">
				<div id="progressNumber"></div>
			</form>

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
					<td>${sessionScope['usuario'].gender}</td>
				</tr>
				<tr>
					<td><spring:eval expression="usuario.birthDay" /></td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].phone}</td>
				</tr>
				<tr>
					<td>${sessionScope['usuario'].mobile}</td>
				</tr>
			</table>
		</div>
		</main>
	</div>
	<gameshunter:footer />
</body>
</html>