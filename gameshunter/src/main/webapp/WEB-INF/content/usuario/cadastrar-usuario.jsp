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
<script src="../resources/js/jquery-2.1.1.js"></script>
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
<body>
	<s:include value="../cabecalho.jsp" />
	<s:url id="formAction" value="novo" />
	<main>
	<form id="form-cadastro" class="form-inline" method="post"
		action="${formAction}" role="form">
		<div class="form-group">
			<table id="table-cadastro" class="table">
				<tr>
					<td class="td-label" id="td-nome-label"><label id="nome-label"
						class="control-label" for="nome-input">Nome</label></td>
					<td class="td-input" id="td-nome-input"><input id="nome-input"
						class="form-control" type="text" name="usuario.nome"
						value="${usuario.nome}"> <br /> <s:fielderror
							fieldName="usuario.nome" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-apelido-label"><label
						id="apelido-label" class="control-label" for="apelido-input">Apelido</label></td>
					<td class="td-input" id="td-apelido-input"><input
						id="apelido-input" class="form-control" type="text"
						name="usuario.apelido" value="${usuario.apelido}"> <br />
						<s:fielderror fieldName="usuario.apelido" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-email-label"><label
						id="email-label" class="control-label" for="email-input">E-mail</label></td>
					<td class="td-input" id="td-email-input"><input
						id="email-input" class="form-control" type="text"
						name="usuario.email" value="${usuario.email}"> <br /> <s:fielderror
							fieldName="usuario.email" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-senha-label"><label
						id="senha-label" class="control-label" for="senha-input">Senha</label></td>
					<td class="td-input" id="td-senha-input"><input
						id="senha-input" class="form-control" type="password"><span
						id="senha-feed"></span> <br /> <span id="senha-describ"></span><br /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-confirma-senha-label"><label
						id="confirma-senha-label" class="control-label"
						for="confirma-senha-input">Confirme sua senha</label></td>
					<td class="td-input" id="td-confirma-senha-input"><input
						id="confirma-senha-input" class="form-control" type="password"
						name="login.senha"><span id="confirma-senha-feed"></span><br />
						<span id="confirma-senha-describ"></span><br /> <s:fielderror
							fieldName="login.senha" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-cpf-label"><label id="cpf-label"
						class="control-label" for="cpf-input">CPF</label></td>
					<td class="td-input" id="td-cpf-input"><input id="cpf-input"
						class="form-control" type="text" name="usuario.cpf"
						value="${usuario.cpf}"> <br /> <s:fielderror
							fieldName="usuario.cpf" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-telefone-label"><label
						id="telefone-label" class="control-label" for="telefone-input">Telefone</label></td>
					<td class="td-input" id="td-telefone-input"><input
						id="telefone-input" class="form-control" type="text"
						name="usuario.telefone" value="${usuario.telefone}"> <br />
						<s:fielderror fieldName="usuario.telefone" /></td>
				</tr>
				<tr>
					<td class="td-label" id="td-sexo-label"><label id="sexo-label"
						class="control-label" for="sexo-input">Sexo</label></td>
					<td><s:select id="sexo-input"
							cssClass="btn-default form-control" headerValue="Selecione"
							headerKey="Selecione" list="sexo" name="usuario.sexo"
							value="%{usuario.sexo}" theme="simple" /> <br /> <s:fielderror
							fieldName="usuario.sexo" /></td>
				</tr>
				<tr class="data-nascimento-tr">
					<td class="td-label" id="td-data-nascimento-label"><label
						id="data-nascimento-label" class="control-label"
						for="dia-nascimento-input">Data de Nascimento</label></td>
					<td class="td-input" id="td-dia-nascimento-input"><s:select
							id="dia-nascimento-input" cssClass="btn-default form-control"
							headerValue="Dia" headerKey="Dia" list="{1}" name="diaNascimento"
							value="%{diaNascimento}" theme="simple" /> <br /> <s:fielderror
							fieldName="diaNascimento" /></td>
					<td class="td-input" id="td-mes-nascimento-input"><s:select
							id="mes-nascimento-input" cssClass="btn-default form-control"
							headerValue="Mês" headerKey="Mês" list="{1}" name="mesNascimento"
							value="%{mesNascimento}" theme="simple" /> <br /> <s:fielderror
							fieldName="diaNascimento" /></td>
					<td class="td-input" id="td-ano-nascimento-input"><s:select
							id="ano-nascimento-input" cssClass="btn-default form-control"
							headerValue="Ano" headerKey="Ano" list="{1,2}"
							name="anoNascimento" value="%{anoNascimento}" theme="simple" />
						<br /> <s:fielderror fieldName="anoNascimento" /></td>
				</tr>
				<s:include value="../endereco/cadastrar-endereco.jsp" />

				<s:submit id="cadastrar" class="btn btn-primary" value="Cadastrar" />
			</table>
		</div>
	</form>
	</main>
	<s:include value="../rodape.jsp" />
</body>
</html>