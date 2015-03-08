<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<header>
	<div class="header">
		<c:set var="locale" value="${pageContext.response.locale}"></c:set>
		<div style="position: absolute; top: 0; right: 0;">
			<select id="arara">
				<option value="en_US" data-imagesrc="/gameshunter/usuario/ararinha2"
					<c:if test="${locale eq 'en_US'}">selected="selected"</c:if>>English</option>
				<option data-imagesrc="/gameshunter/usuario/ararinha"
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
				<li><a href="<c:url value="/" />">Home</a></li>
				<li><a href="#">Como funciona</a></li>
				<li><a href="#">Sobre</a></li>
				<li><a href="#">Fale conosco</a></li>
			</ul>
		</div>
	</nav>
</header>
</html>