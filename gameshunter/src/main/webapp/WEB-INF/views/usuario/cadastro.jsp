<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr>
	<td class="td-label" id="td-nome-label"><label id="nome-label"
		class="control-label" for="nome-input">Nome</label></td>
	<td class="td-input" id="td-nome-input"><input id="nome-input"
		class="form-control" type="text" name="usuario.nome"
		value="${usuario.nome}"> <br /> </td>
</tr>
<tr>
	<td class="td-label" id="td-apelido-label"><label
		id="apelido-label" class="control-label" for="apelido-input">Apelido</label></td>
	<td class="td-input" id="td-apelido-input"><input
		id="apelido-input" class="form-control" type="text"
		name="usuario.apelido" value="${usuario.apelido}"> <br /> </td>
</tr>
<tr>
	<td class="td-label" id="td-email-label"><label id="email-label"
		class="control-label" for="email-input">E-mail</label></td>
	<td class="td-input" id="td-email-input"><input id="email-input"
		class="form-control" type="text" name="usuario.email"
		value="${usuario.email}"> <br /> </td>
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
		name="login.senha"><span id="confirma-senha-feed"></span><br />
		<span id="confirma-senha-describ"></span> </td>
</tr>
<tr>
	<td class="td-label" id="td-cpf-label"><label id="cpf-label"
		class="control-label" for="cpf-input">CPF</label></td>
	<td class="td-input" id="td-cpf-input"><input id="cpf-input"
		class="form-control" type="text" name="usuario.cpf"
		value="${usuario.cpf}"> <br /></td>
</tr>
<tr>
	<td class="td-label" id="td-telefone-label"><label
		id="telefone-label" class="control-label" for="telefone-input">Telefone</label></td>
	<td class="td-input" id="td-telefone-input"><input
		id="telefone-input" class="form-control" type="text"
		name="usuario.telefone" value="${usuario.telefone}"> <br /> </td>
</tr>
<tr>
	<td class="td-label" id="td-sexo-label"><label id="sexo-label"
		class="control-label" for="sexo-input">Sexo</label></td>
	<td></td>
</tr>
<tr class="data-nascimento-tr">
	<td class="td-label" id="td-data-nascimento-label"><label
		id="data-nascimento-label" class="control-label"
		for="dia-nascimento-input">Data de Nascimento</label></td>
	<td class="td-input" id="td-dia-nascimento-input"> <br /> </td>
	<td class="td-input" id="td-mes-nascimento-input"> <br /> </td>
	<td class="td-input" id="td-ano-nascimento-input"> <br /> </td>
</tr>