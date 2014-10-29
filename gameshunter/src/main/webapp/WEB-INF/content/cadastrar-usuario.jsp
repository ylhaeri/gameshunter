<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/gameshunter.css">
<link rel="stylesheet" href="resources/css/cadastrar-usuario.css">
<title>Cadastro - Games Hunter</title>
<script src="resources/js/jquery-2.1.1.js"></script>
<script>
	function crEst() {
		var pais = document.querySelector("#dpais");
		var pid = pais.options[pais.selectedIndex].value;
		$.post("carregaEstado", {
			idP : pid
		}, function() {
			$("#dpest").html(
					"<option selected='selected'>"
							+ "Selecione um estado</option>");
			<c:forEach var="estado" items="${estDP}">
			$("#dpest").append(
					"<option value=${estado.id}>${estado.nome}</option>");
			</c:forEach>
		})
	}

	function crCid() {
		var estado = document.querySelector("#dpest");
		var eid = estado.options[estado.selectedIndex].value;
		$.post("carregaCidade", {
			idE : eid
		}, function() {
			$("#dpcid").html(
					"<option selected='selected'>"
							+ "Selecione uma cidade</option>");
			<c:forEach var="cidade" items="${cidDP}">
			$("#dpcid").append(
					"<option value=${cidade.id}>${cidade.nome}</option>")
			</c:forEach>
		})
	}

	function testeEstado() {
		document.forms[0].action = "carregaEstado";
		document.forms[0].submit();
	}
</script>
</head>
<body class="container">
	<h1 id="titulo">Cadastre-se</h1>
	<form method="post" class="cadastro" action="novoUsuario">
		<label for="nome">Nome</label><input type="text" id="nome"
			name="usuario.nome">
		<br />
		<label for="ape">Apelido</label><input type="text"
			name="usuario.apelido" id="ape">
		<br />
		<label for="mail">E-mail</label><input type="text"
			name="usuario.email" id="mail">
		<br />
		<label for="senha">Senha</label><input type="password" id="senha">
		<br />
		<label for="confirmasenha">Confirme sua senha</label><input
			type="password" id="confirmasenha" name="usuario.senha">
		<br />
		<label for="cpf">CPF</label><input type="text" id="cpf"
			name="usuario.cpf">
		<br />
		<label for="tel">Telefone</label><input type="text" id="tel"
			name="usuario.telefone">
		<br />
		<label for="rg">RG</label><input type="text" id="rg" name="usuario.rg">
		<br />
		<label id="sexo" for="gndbx">Sexo</label><select name="usuario.sexo">
			<option selected="selected">---Selecione---</option>
			<c:forEach var="sexo" items="${sexo}">
				<option>${sexo}</option>
			</c:forEach>
		</select>
		<br />
		<label id="dtnasc" for="diabox">Data de Nascimento</label>
		<br />
		<select id="diabox" name="nascDia">
			<option selected="selected">Dia</option>
			<c:forEach var="dia" begin="1" end="31">
				<option>${dia}</option>
			</c:forEach>
		</select><select id="mesbox" name="nascMes">
			<option selected="selected">Mês</option>
			<c:forEach var="mes" items="${meses}">
				<option>${mes}</option>
			</c:forEach>
		</select><select id="anobox" name="nascAno">
			<option selected="selected">Ano</option>
			<c:forEach var="ano" items="${anos}">
				<option>${ano}</option>
			</c:forEach>
		</select>
		<br />
		<fieldset class="endereco">
			<h2 id="ende">Endereço</h2>
			<br />
			<s:include value="cadastrar-endereco.jsp"></s:include>
		</fieldset>
		<br />
		<input type="submit" value="Enviar" id="enviar">
	</form>
</body>
</html>
