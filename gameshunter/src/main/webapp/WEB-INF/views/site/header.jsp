<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<header>
	<div class="header">

		<c:choose>
			<c:when test="${sessionScope['user'] == null}">
				<form action='<c:url value="/user/login" />' method="post">
					<div>
						<input type="hidden" name="path" id="path"> <label>E-mail</label><input
							type="text" name="email"> <label>Senha</label><input
							type="password" name="password"> <input type="submit">
						<form:errors path="login.email"></form:errors>
					</div>
					<a href="<c:url value="/user/signup" />">Cadastre-se</a>
				</form>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/user/account" />">Minha conta</a>
				<form action="<c:url value="/user/logout" />" method="post">
					<input type="submit" value="Logout">
				</form>
			</c:otherwise>
		</c:choose>

	</div>

	<nav class="navigation">
		<div class="container">
			<ul class="list-inline link-list">
				<li><a href="<c:url value="/" />"><span tabindex="2">
							<spring:message code="header.home" />
					</span></a></li>
				<li><a href="<c:url value="/how-it-works" />"><span>
							<spring:message code="header.how_it_works" />
					</span></a></li>
				<li><a href="<c:url value="/about" />"><span> <spring:message
								code="header.about" />
					</span></a></li>
				<li><a href="<c:url value="/contact" />"><span> <spring:message
								code="header.contact" />
					</span></a></li>
			</ul>
		</div>
	</nav>

</header>
</html>
