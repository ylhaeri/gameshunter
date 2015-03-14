<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<header>
	<div class="header">

		<img alt="circulo"
			src="<c:url value='/resources/img/site/circulo-logo.png'></c:url>"
			class="logo">
			<img alt="controle"
			src="<c:url value='/resources/img/site/controle.png'></c:url>"
			class="controle">
			<img alt="controle"
			src="<c:url value='/resources/img/site/gh.png'></c:url>"
			class="gh">

		<form id="form-login" action="<c:url value="/usuario/login"></c:url>"
			method="post" class="login">
			<input id="path" type="hidden" name="path"> <label
				id="login-email-label" for="user"><spring:message code="id" /> </label> <input
				id="login-email-input" type="email" name="email"><label
				id="login-password-label" for="password"><spring:message code="password" /> </label> <input
				id="login-password-input" type="password" name="password">
			<button type="submit">Login</button>
			<br />
			<form:errors path="login.email" htmlEscape="false" />
		</form>

		<c:set var="locale" value="${pageContext.response.locale}"></c:set>



		<!--<div style="position: absolute; top: 0; right: 0;">
			<select id="arara">
				<option value="en_US" data-imagesrc="/gameshunter/usuario/ararinha2"
					<c:if test="${locale eq 'en_US'}">selected="selected"</c:if>>English</option>
				<option data-imagesrc="/gameshunter/usuario/ararinha"
					<c:if test="${locale eq 'pt_BR'}">selected="selected"</c:if>>Português</option>
			</select>
 		</div>  -->




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
				<li><a href="<c:url value="/" />"><div><spring:message code="header.home" /></div></a></li>
				<li><a href="<c:url value="/how-it-works" />"><div><spring:message code="header.how_it_works" /></div></a></li>
				<li><a href="<c:url value="/about" />"><div><spring:message code="header.about" /></div></a></li>
				<li><a href="<c:url value="/contact" />"><div><spring:message code="header.contact" /></div></a></li>
			</ul>
		</div>
	</nav>
</header>
</html>
