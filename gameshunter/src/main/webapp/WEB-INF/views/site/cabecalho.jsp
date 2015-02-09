<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<header class="header">


	<div class="login">
		<form action="#" class="login-form">
			<div class="text-form-inline-header">Login</div>
			<input type="email" placeholder="exemplo@exemplo.com.br" id="email"
				class="edittext-form">
			<div class="text-form-inline-header">Senha</div>
			<input type="password" id="senha" class="edittext-form"> <input
				type="submit" class="button-login" value="Login">
		</form>
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
				<li class="navbar-link"><a href="<c:url value="#" />">Como funciona</a></li>
				<li class="navbar-link"><a href="<c:url value="#" />">Sobre</a></li>
			</ul>
		</div>
	</nav>
</header>
</html>