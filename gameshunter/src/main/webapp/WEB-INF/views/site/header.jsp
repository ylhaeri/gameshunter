<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<header class="header">

	<shiro:guest>
		<div class="account-content">
			<a href="<c:url value="/user/login" />">Login</a>
		</div>
	</shiro:guest>
	<shiro:user>
		<div class="account-content">
			<a href="<c:url value="/user/account" />">Minha conta</a>
			<form action="<c:url value="/user/logout" />" method="post">
				<input type="submit" value="Logout">
			</form>
		</div>
	</shiro:user>

	<div class="menu-img"></div>
	<nav class="nav">
		<div class="close-menu"></div>
		<div class="container">

			<ul class="link-list">
				<li><a href="<c:url value="/" />" class="menu-link"> <spring:message
							code="header.home" />
				</a></li>
				<li><a href="<c:url value="/how-it-works" />" class="menu-link">
						<spring:message code="header.how_it_works" />
				</a></li>
				<li><a href="<c:url value="/about" />" class="menu-link"> <spring:message
							code="header.about" />
				</a></li>
				<li><a href="<c:url value="/contact" />" class="menu-link">
						<spring:message code="header.contact" />
				</a></li>
			</ul>
		</div>
	</nav>

</header>