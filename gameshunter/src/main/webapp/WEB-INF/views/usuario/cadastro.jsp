<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tr>
	<td class="td-label" id="td-nome-label"><label id="nome-label"
		class="control-label" for="nome-input">Nome completo</label></td>
	<td class="td-input" id="td-nome-input"><input id="nome-input"
		class="form-control" type="text" name="nome" value="${usuario.nome}">
		<br /></td>
</tr>
<tr>
	<td class="td-label" id="td-sexo-label"><label id="sexo-label"
		class="control-label" for="sexo-input">Sexo</label></td>
	<td><select name="sexo">
			<option value="---" selected="selected">Selecione</option>
			<c:forEach items="${sexoList}" var="sexo">
				<option>${sexo}</option>
			</c:forEach>
	</select></td>
</tr>
<tr>
	<td class="td-label" id="td-cpf-label"><label id="cpf-label"
		class="control-label" for="cpf-input">CPF</label></td>
	<td class="td-input" id="td-cpf-input"><input id="cpf-input"
		class="form-control" type="text" name="cpf" value="${usuario.cpf}">
		<br /></td>
</tr>
<tr>
	<td class="td-label" id="td-telefone-label"><label
		id="telefone-label" class="control-label" for="telefone-input">Telefone</label></td>
	<td class="td-input" id="td-telefone-input"><input
		id="telefone-input" class="form-control" type="text" name="telefone"
		value="${usuario.telefone}"> <br /></td>
</tr>
<tr>
	<td class="td-label" id="td-celular-label"><label
		id="celular-label" class="control-label" for="celular-input">Celular</label></td>
	<td class="td-input" id="td-celular-input"><input
		id="celular-input" class="form-control" type="text" name="celular"
		value="${usuario.celular}"> <br /></td>
</tr>
<tr>
	<td class="td-label" id="td-data-nascimento-label"><label
		id="data-nascimento-label" class="control-label"
		for="dia-nascimento-input">Data de nascimento</label></td>
	<td class="td-input" id="td-dia-nascimento-input"><input
		id="nascimento-input" class="form-control" type="text"
		name="nascimento"></td>
</tr>
<tr>
	<td class="td-label" id="td-email-label"><label id="email-label"
		class="control-label" for="email-input">E-mail</label></td>
	<td class="td-input" id="td-email-input"><input id="email-input"
		class="form-control" type="text" name="email" value="${usuario.email}">
		<br /></td>
</tr>
<tr>
	<td class="td-label" id="td-apelido-label"><label
		id="apelido-label" class="control-label" for="apelido-input">Apelido</label></td>
	<td class="td-input" id="td-apelido-input"><input
		id="apelido-input" class="form-control" type="text" name="apelido"
		value="${usuario.apelido}"> <br /></td>
</tr>
<tr>
	<td class="td-label" id="td-senha-label"><label id="senha-label"
		class="control-label" for="senha-input">Senha</label></td>
	<td class="td-input" id="td-senha-input"><input id="senha-input"
		class="form-control" type="password"><span id="senha-feed"></span>
		<br /> <span id="senha-describ"></span></td>
</tr>
<tr>
	<td class="td-label" id="td-confirma-senha-label"><label
		id="confirma-senha-label" class="control-label"
		for="confirma-senha-input">Confirme sua senha</label></td>
	<td class="td-input" id="td-confirma-senha-input"><input
		id="confirma-senha-input" class="form-control" type="password"
		name="senha"><span id="confirma-senha-feed"></span><br /> <span
		id="confirma-senha-describ"></span></td>
</tr>
<tr>
	<td><label class="control-label">Receber novidades por
			e-mail</label></td>
	<td><label class="radio-inline"><input type="radio">Sim</label>
		<label class="radio-inline"><input type="radio">Não</label></td>
</tr>