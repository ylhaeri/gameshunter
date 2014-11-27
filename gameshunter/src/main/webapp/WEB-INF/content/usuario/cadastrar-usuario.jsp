<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet'>
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/gameshunter-bootstrap.css">
<link rel="stylesheet" href="../resources/css/gameshunter.css">
<link rel="stylesheet" href="../resources/css/cadastrar-usuario.css">
<script src="../resources/js/jquery-masked-input-1.4.0.js"></script>
<script src="../resources/js/cadastrar-endereco.js"></script>
<script src="../resources/js/cadastrar-usuario.js"></script>
<style>
.label {
	color: black
}
</style>
<title>Cadastro - Games Hunter</title>
</head>
<script>
	$(document).ready(function() {

		$.subscribe('handleJsonResult', function(event, data) {
			var info = event.originalEvent.data
		});
	});
</script>
<body>
	<s:include value="../cabecalho.jsp" />
	<main>
	<form id="form-cadastro" class="form-inline" method="post"
		action="novoUsuario" role="form">
		<div class="form-group has-feedback">
			<table id="table-cadastro" class="table">
				<tr>
					<td class="td-label" id="td-nome-label"><label id="nome-label"
						class="control-label" for="nome-input">Nome</label></td>
					<td class="td-input" id="td-nome-input"><input id="nome-input"
						class="form-control" type="text" name="usuario.nome"
						value="${usuario.nome}"> <br /> <s:fielderror
							fieldName="usuario.nome"></s:fielderror></td>
				</tr>
				<tr>
					<td class="td-label" id="td-apelido-label"><label
						id="apelido-label" class="control-label" for="apelido-input">Apelido</label></td>
					<td class="td-input" id="td-apelido-input"><input
						id="apelido-input" class="form-control" type="text"
						name="usuario.apelido" value="${usuario.apelido}"> <br />
						<s:fielderror fieldName="usuario.apelido"></s:fielderror></td>
				</tr>
				<tr>
					<td class="td-label" id="td-email-label"><label
						id="email-label" class="control-label" for="email-input">E-mail</label></td>
					<td class="td-input" id="td-email-input"><input
						id="email-input" class="form-control" type="text"
						name="usuario.email" value="${usuario.email}"> <br /> <s:fielderror
							fieldName="usuario.email"></s:fielderror></td>
				</tr>
				<s:password label="Senha" labelposition="left" labelSeparator=""
					cssClass="form-control" id="senha" />
				<s:password label="Confirme sua senha" labelposition="left"
					labelSeparator="" cssClass="form-control" id="confirmaSenha"
					name="login.senha" errorPosition="bottom" />
				<s:textfield label="CPF" labelposition="left" labelSeparator=""
					cssClass="form-control" id="cpf" name="usuario.cpf"
					value="%{usuario.cpf}" errorPosition="bottom" />
				<s:textfield label="Telefone" labelposition="left" labelSeparator=""
					cssClass="form-control" id="tel" name="usuario.telefone"
					value="%{usuario.telefone}" errorPosition="bottom" />
				<s:select label="Sexo" labelposition="left" labelSeparator=""
					cssClass="btn-default form-control" id="dpsexo"
					headerValue="Selecione" headerKey="Selecione" name="usuario.sexo"
					list="sexo" errorPosition="bottom" />
				<s:textfield label="Data de Nascimento" labelposition="left"
					labelSeparator="" cssClass="form-control" id="dataNasc"
					name="dataNasc" value="%{dataNasc}" errorPosition="bottom" />
				<s:include value="../endereco/cadastrar-endereco.jsp" />

				<s:submit id="cadastrar" class="btn btn-primary" value="Cadastrar" />
			</table>
		</div>
	</form>
	</main>
	<s:include value="../rodape.jsp" />
</body>
</html>