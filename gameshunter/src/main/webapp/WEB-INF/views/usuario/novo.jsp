<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Games Hunter</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/reset.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site-bootstrap.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/site/site.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/usuario/novo.css"></c:url>">
<script src="<c:url value="/resources/js/jquery/jquery.js"></c:url>"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery-masked-input.js"></c:url>"></script>
<script src="<c:url value="/resources/js/usuario/novo.js"></c:url>"></script>
</head>
<body>
	<div class="wrapper">
		<c:import url="../site/cabecalho.jsp"></c:import>

		<main class="container">
		<form id="form-cadastro" class="form-inline" method="post"
			action="cadastrado">

			<div class="form-group">
				<table id="table-cadastro-usuario" class="table">
					<c:import url="cadastro.jsp"></c:import>
					<tr>
						<td></td>
						<td><input type="submit" value="Botão"
							class="btn btn-primary btn-block"></td>
					</tr>
				</table>
			</div>
		</form>
		</main>
	</div>

	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>
