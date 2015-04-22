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

	<gameshunter:header />
	<main class="container">

	<div class="profile-banner">
		<img alt="foto-do-perfil" id="usuario-foto-label"
			src="<c:url value="/user/getPicture" />"
			class="img-circle img-thumbnail" /><br /> <input type="file"
			name="file">
		<form action='<c:url value="/user/setPicture" />' method="post"
			enctype="multipart/form-data">
			<input type="submit" style="color: black">
			<div id="progressNumber"></div>
		</form>

		<div class="profile-banner-content">
			<h1>${sessionScope['user'].nickname}</h1>
		</div>

	</div>

	<div class="profile">

		<table class="profile-table">
			<tr>
				<td><spring:message code="user.name" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.email" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.gender" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.bday" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.phone" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.mobile" /></td>
			</tr>
		</table>

		<table class="profile-table-information">
			<tr>
				<td>${requestScope['user'].firstName}
					${requestScope['user'].lastName}</td>
			</tr>
			<tr>
				<td>${requestScope['user'].nickname}</td>
			</tr>
			<tr>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td><spring:eval expression="${requestScope['user'].birthDay}" /></td>
			</tr>
			<tr>
				<td>${requestScope['user'].phone}</td>
			</tr>
			<tr>
				<td>${requestScope['user'].mobile}</td>
			</tr>
		</table>
	</div>
	</main>
	<gameshunter:footer />
</body>
</html>