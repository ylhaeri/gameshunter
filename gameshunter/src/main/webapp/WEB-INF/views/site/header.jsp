<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<header class="header">

	<c:choose>
		<c:when test="${sessionScope['usuario'] == null}">
			<div class="login">
				<form action="<c:url value="/usuario/login"></c:url>" method="post"
					class="login-form pull-right" id="login-form">
					<input type="hidden" id="path" name="path">
					<div class="text-form-inline-header">Login</div>
					<input type="email" placeholder="exemplo@exemplo.com.br"
						id="email-input-login" class="edittext-form" name="email"
						value="${requestScope['login'].email}">
					<div class="text-form-inline-header">Senha</div>
					<input type="password" id="senha-input-login" class="edittext-form"
						name="senha"> <input type="submit" class="button-login"
						value="Login"><br />
					<form:errors path="login.email" id="mensagem-email"
						cssClass="text-danger" htmlEscape="false" />
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div class="userPanel" style="background-color: #222">
				<img style="max-width: 80px" alt="foto-padrão-do-perfil"
					src="<c:url value="/usuario/teste"></c:url>"
					class="img-circle img-thumbnail" />
				<div class="pull-right user-btn" style="margin-top: 1.5em">
					<a id="btn-perfil" href="<c:url value="/usuario/perfil"></c:url>">Perfil</a>
					<a id="btn-logout" class="btn btn-primary">Logout</a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<c:set var="locale" value="${pageContext.response.locale}"></c:set>
	<c:set var="pt" value="pt_BR"></c:set>
	<div style="position: absolute; top: 0; right: 0;">
		<select id="arara">
			<option value="en_US" data-imagesrc="/gameshunter/usuario/ararinha2"
				<c:if test="${locale eq 'en_US'}">selected="selected"</c:if>>English</option>
			<option data-imagesrc="/gameshunter/usuario/ararinha"
				<c:if test="${locale eq 'pt_BR'}">selected="selected"</c:if>>Português</option>
		</select>
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="nav-header">
				<a class="navbar-brand" href="<c:url value="/" />">Games Hunter</a>
			</div>
			<ul class="nav navbar-nav pull-right">
				<li class="navbar-link active"><a href='<c:url value="/" />'>Home</a></li>
				<li class="navbar-link"><a
					href="<c:url value="/usuario/novo" />">Cadastro</a></li>
				<li class="navbar-link"><a href="<c:url value="#" />">Como
						funciona</a></li>
				<li class="navbar-link"><a href="<c:url value="#" />">Sobre</a></li>
			</ul>
		</div>
	</nav>
</header>
</html>