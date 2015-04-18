<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Games Hunter</title>
<gameshunter:resources />
<script
	src="<c:url value="/resources/js/jquery/masked-input.min.js"></c:url>"></script>
<script src="<c:url value="/resources/js/usuario/novo.js"></c:url>"></script>
</head>
<body>
	<gameshunter:header />

	<main class="container">
	<form id="cadastro-form" class="form-inline" method="post"
		action="registered">
		<div class="form-group">
			<h1 class="h1"
				style="display: inline; margin-right: 10px; margin-bottom: 20px;">
				<spring:message code="signup.title" />
			</h1>
			<span style="margin-left: 15px;"><span class="teste"></span> <spring:message
					code="form.field.required" /></span>
			<table id="table-cadastro-usuario" style="margin-top: 25px;"
				class="table">
				<c:import url="form.jsp"></c:import>
				<tr>
					<td class="td-label" id="td-novidades-label"><label
						class="control-label" id="novidades-label"><spring:message
								code="user.newsletter.email" /></label></td>
					<td class="td-input" id="td-novidades-email-input"><spring:message
							code="user.newsletter.email.true" var="newsletter_email_true" />
						<spring:message code="user.newsletter.email.false"
							var="newsletter_email_false" /> <form:radiobutton
							path="user.newsletterEmail" value="true"
							label="${newsletter_email_true}" id="novidades-email-sim" /> <form:radiobutton
							path="user.newsletterEmail" value="false"
							label="${newsletter_email_false}" id="novidades-email-false" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-termos-label"><label
						class="control-label" id="termos-label"><spring:message
								code="user.terms_of_service" /></label></td>
					<td class="td-input" id="td-termos-input"><div
							class="checkbox">
							<spring:message code="user.terms_of_service.message"
								var="user_terms_of_service" />
							<form:checkbox path="user.agreeTermsOfService"
								id="termos-servico-input" value="true"
								label="${user_terms_of_service}" />
							<br />
							<form:errors path="user.agreeTermsOfService"
								cssClass="text-danger" />
						</div></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" id="cadastro-enviar" value="Enviar"
						class="btn btn-primary"></td>
				</tr>
			</table>
		</div>
	</form>
	</main>
	<gameshunter:footer />
</body>
</html>
