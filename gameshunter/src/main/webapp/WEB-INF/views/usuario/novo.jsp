<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/gameshunter-bootstrap.css">
<link rel="stylesheet" href="../resources/css/gameshunter.css">
<link rel="stylesheet" href="../resources/css/cadastrar-usuario.css">
<script src="../resources/js/jquery-2.1.1.js"></script>
<script src="../resources/js/jquery-masked-input-1.4.0.js"></script>
<script src="../resources/js/cadastrar-endereco.js"></script>
<script src="../resources/js/cadastrar-usuario.js"></script>
<title>Cadastro - Games Hunter</title>
</head>
<body>
	<c:import url="../site/cabecalho.jsp"></c:import>
	<main class="container">
		<form:form id="form-cadastro"
			class="form-inline" method="post">
			<div class="form-group">
				<table id="table-cadastro-usuario" class="table">
					<c:import url="cadastro.jsp"></c:import>
				</table>
			</div>
		</form:form>
	</main>
	<c:import url="../site/rodape.jsp"></c:import>
</body>
</html>