<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<header>
	<div class="menu-img">
		<div class="img"></div>
	</div>
	<shiro:guest>
		<form action='<c:url value="/user/login" />' method="post">
			<div>
				<label>E-mail</label><input type="text" name="email"> <label>Senha</label><input
					type="password" name="password"> <input type="hidden"
					name="rememberMe" value="true"> <input type="submit"
					value="login">
				<form:errors path="login.email"></form:errors>
			</div>
			<a href="<c:url value="/user/signup" />">Cadastre-se</a>
		</form>
	</shiro:guest>
	<shiro:user>
		<a href="<c:url value="/user/account" />">Minha conta</a>
		<form action="<c:url value="/user/logout" />" method="post">
			<input type="submit" value="Logout">
		</form>
	</shiro:user>


	<nav class="navigation">
		<div class="container">

			<div class="menu-close">
				<img alt="close-menu"
					src="<c:url value="/resources/img/cross-icon.svg" />">
			</div>

			<ul class="list-inline link-list">
				<li><a href="<c:url value="/" />"><div class="menu">
							<spring:message code="header.home" />
						</div></a></li>
				<li><a href="<c:url value="/how-it-works" />"><div
							class="menu">
							<spring:message code="header.how_it_works" />
						</div></a></li>
				<li><a href="<c:url value="/about" />"><div class="menu">
							<spring:message code="header.about" />
						</div></a></li>
				<li><a href="<c:url value="/contact" />"><div class="menu">
							<spring:message code="header.contact" />
						</div></a></li>
			</ul>
		</div>
	</nav>

</header>
</html>
