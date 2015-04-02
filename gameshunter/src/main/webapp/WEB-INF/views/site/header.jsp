<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<header>
	<div class="header">
		
		<div class="container-logo">
		<img alt="controle"
			src="<c:url value='/resources/img/site/controle.png'></c:url>"
			class="controle"> <img alt="controle"
			src="<c:url value='/resources/img/site/gh.png'></c:url>" class="gh">
		<a href="<c:url value="/"></c:url>" tabindex="-1"><img alt="circulo"
			src="<c:url value='/resources/img/site/circulo-logo.png'></c:url>"
			class="logo" tabindex="1"> </a>
		</div>
		
		<button class="open-menu">abrir menu</button>
		
		<form id="form-login" action="<c:url value="/user/login"></c:url>"
			method="post" class="login">
			<input id="path" type="hidden" name="path"> <label
				id="login-email-label" for="login-email-input"><spring:message code="id" />
			</label> <input id="login-email-input" type="email" name="email" tabindex="1"><label
				id="login-password-label" for="login-password-input"><spring:message
					code="password" /> </label> <input id="login-password-input"
				type="password" name="password" tabindex="1">
			<button type="submit">Login</button>
			<br />
			<form:errors path="login.email" htmlEscape="false" />
		</form>

		<c:choose>
			<c:when test="${sessionScope['usuario'] == null}">
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	
	</div>
	
	<nav class="navigation">
		<div class="container">
			<button class='close-menu'>fechar menu</button>
			<ul class="list-inline link-list">
				<li><a href="<c:url value="/" />"><div tabindex="2">
							<spring:message code="header.home" />
						</div></a></li>
				<li><a href="<c:url value="/how-it-works" />"><div>
							<spring:message code="header.how_it_works" />
						</div></a></li>
				<li><a href="<c:url value="/about" />"><div>
							<spring:message code="header.about" />
						</div></a></li>
				<li><a href="<c:url value="/contact" />"><div>
							<spring:message code="header.contact" />
						</div></a></li>
			</ul>
		</div>
	</nav>
		
</header>
</html>
