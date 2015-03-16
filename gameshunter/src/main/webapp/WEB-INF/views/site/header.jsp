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
		<a href="<c:url value="/"></c:url>"><img alt="circulo"
			src="<c:url value='/resources/img/site/circulo-logo.png'></c:url>"
			class="logo"> </a>
		</div>
		
		
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

		<c:set var="locale" value="${pageContext.response.locale}"></c:set>

		<div style="position: absolute; top: 30px; right: 0;">
			<select id="language-selector">
				<option value="en_US" data-imagesrc="/gameshunter/user/ararinha2"
					<c:if test="${locale eq 'en_US'}">selected="selected"</c:if>>English</option>
				<option value="pt_BR" data-imagesrc="/gameshunter/user/ararinha"
					<c:if test="${locale eq 'pt_BR'}">selected="selected"</c:if>>Português</option>
			</select>
		</div>

		<c:choose>
			<c:when test="${sessionScope['usuario'] == null}">
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	
	</div>
	
	<nav class="navigation">
		<div class="container">
			<ul class="list-inline link-list">
				<li><a href="<c:url value="/" />"><div>
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
