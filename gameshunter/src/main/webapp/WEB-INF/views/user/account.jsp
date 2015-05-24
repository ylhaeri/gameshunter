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
	<main class="main container">

	<div class="profile-banner">
		<img alt="foto-do-perfil" id="usuario-foto-label"
			src="<c:url value="/user/profile-picture" />"
			class="img-circle img-thumbnail" /><br />
		<form action='<c:url value="/user/profile-picture" />' method="post"
			enctype="multipart/form-data">
			<input type="file" name="file"> <input type="submit">
		</form>

		<div class="profile-banner-content">
			<h1>${requestScope['user'].nickname}</h1>
		</div>

	</div>

	<div class="profile">

		<table class="profile-table">
			<tr>
				<td><spring:message code="user.name" /></td>
				<td>${requestScope['user'].firstName}
					${requestScope['user'].lastName}</td>
			</tr>
			<tr>
				<td><spring:message code="user.email" /></td>
				<td>${requestScope['user'].email}</td>
			</tr>
			<tr>
				<td><spring:message code="user.gender" /></td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td><spring:message code="user.bday" /></td>
				<td><spring:eval expression="${requestScope['user'].birthDay}" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.phone" /></td>
				<td>${requestScope['user'].phone}</td>
			</tr>
			<tr>
				<td><spring:message code="user.mobile" /></td>
				<td>${requestScope['user'].mobile}</td>
			</tr>
		</table>
	</div>
	</main>
	<gameshunter:footer />
</body>
</html>