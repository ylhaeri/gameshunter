<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/site/reset.css">
<link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet"
	href="../resources/css/site/gameshunter-bootstrap.css">
<link rel="stylesheet" href="../resources/css/site/gameshunter.css">
<link rel="stylesheet"
	href="../resources/css/usuario/cadastrar-usuario.css">
<script src="../resources/js/jquery/jquery-2.1.1.js"></script>
<script src="../resources/js/jquery/jquery-masked-input-1.4.0.js"></script>
<script src="../resources/js/endereco/cadastrar-endereco.js"></script>
<script src="../resources/js/usuario/cadastrar-usuario.js"></script>
<title>Cadastro - Games Hunter</title>
</head>
<body>
	<c:import url="../site/cabecalho.jsp"></c:import>
	<main class="container"> <form:form id="form-cadastro"
		class="form-inline" method="post" action="cadastrado">
		<div class="form-group">
			<table id="table-cadastro-usuario" class="table">
				<c:import url="cadastro.jsp"></c:import>
				<c:import url="../endereco/cadastro.jsp"></c:import>
				<tr>
					<td><input type="submit" value="Botão"></td>
				</tr>
			</table>
		</div>

		<input type="submit" value="Cadastrar" />

	</form:form></main>

	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>
