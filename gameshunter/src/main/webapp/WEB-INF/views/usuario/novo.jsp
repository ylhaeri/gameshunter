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
<link rel="stylesheet"
	href="<c:url value="/resources/css/usuario/novo.css"></c:url>">
<script
	src="<c:url value="/resources/js/jquery/jquery-masked-input.js"></c:url>"></script>
<script src="<c:url value="/resources/js/usuario/novo.js"></c:url>"></script>
<style type="text/css">
.asterisk_input:after {
	content: "*";
	color: #e32;
	position: absolute;
	margin-top: -5px;
	margin-left: -20px;
	font-size: xx-large;
}

.teste:after {
	content: "*";
	color: #e32;
	font-size: xx-large;
	position: absolute;
	padding-top: 11px;
	margin-left: -15px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<gameshunter:header />

		<main class="container">
		<form id="cadastro-form" class="form-inline" method="post"
			action="cadastrado">
			<div class="form-group">
				<h1 class="h1"
					style="display: inline; margin-right: 10px; margin-bottom: 20px;">Cadastre-se</h1>
				<span style="margin-left: 15px;"><span class="teste"></span>Campos
					obrigatórios</span>
				<table id="table-cadastro-usuario" style="margin-top: 25px;"
					class="table">
					<c:import url="cadastro.jsp"></c:import>
					<tr>
						<td class="td-label" id="td-novidades-label"><label
							class="control-label" id="novidades-label">Receber
								novidades por e-mail</label></td>
						<td class="td-input" id="td-novidades-email-input"><form:radiobutton
								path="usuario.newsLetterEmail" value="true" label="Sim"
								id="novidades-email-sim" /> <form:radiobutton
								path="usuario.newsLetterEmail" value="false" label="Não"
								id="novidades-email-nao" /></td>
					</tr>
					<tr>
						<td class="td-label" id="td-termos-label"><label
							class="control-label" id="termos-label">Termos de uso</label></td>
						<td class="td-input" id="td-termos-input"><div
								class="checkbox">
								<form:checkbox path="usuario.agreeTermsOfService" value="true"
									label="Eu li e concordo com os Termos de uso e a Política de privacidade." />
								<br />
								<form:errors path="usuario.agreeTermsOfService"
									cssClass="text-danger" />
							</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Enviar"
							class="btn btn-primary"></td>
					</tr>
				</table>
			</div>
		</form>
		</main>
	</div>
	<gameshunter:footer />
</body>
</html>
