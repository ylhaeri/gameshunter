<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<tr>
	<td class="td-label" id="td-cep-label"><label id="cep-label"
		class="control-label" for="cep-input">CEP</label></td>
	<td class="td-input" id="td-cep-input"><input id="cep-input"
		class="form-control" type="text" name="cep" value="${cep}" /> <br />
		<s:fielderror fieldName="cep"></s:fielderror></td>
</tr>
<tr>
	<td class="td-label" id="td-logradouro-label"><label
		id="logradouro-label" class="control-label" for="logradouro-input">Logradouro</label></td>
	<td class="td-input" id="td-logradouro-input"><input
		id="logradouro-input" class="form-control" type="text"
		readonly="readonly" /></td>
</tr>
<tr>
	<td class="td-label" id="td-numero-label"><label id="numero-label"
		class="control-label" for="numero-input">Número</label></td>
	<td class="td-input" id="td-numero-input"><input id="numero-input"
		class="form-control" type="text" name="endereco.numero"
		value="${endereco.numero}" maxlength="6" /><br /> <s:fielderror
			fieldName="endereco.numero"></s:fielderror></td>
</tr>
<tr>
	<td class="td-label" id="td-complemento-label"><label
		id="complemento-label" class="control-label" for="complemento-input">Complemento</label></td>
	<td class="td-input" id="td-complemento-input"><input
		id="complemento-input" class="form-control" type="text"
		name="endereco.complemento" value="${endereco.complemento}" /> <br />
		<s:fielderror fieldName="endereco.complemento"></s:fielderror></td>
</tr>
<tr>
	<td class="td-label" id="td-bairro-label"><label id="bairro-label"
		class="control-label" for="bairro-input">Bairro</label></td>
	<td class="td-input" id="td-bairro-input"><input id="bairro-input"
		class="form-control" type="text" readonly="readonly" /></td>
</tr>
<tr>
	<td class="td-label" id="td-cidade-label"><label id="cidade-label"
		class="control-label" for="cidade-input">Cidade</label></td>
	<td class="td-input" id="td-cidade-input"><input id="cidade-input"
		class="form-control" type="text" readonly="readonly" /></td>
</tr>
<tr>
	<td class="td-label" id="td-estado-label"><label id="estado-label"
		class="control-label" for="estado-input">Estado</label></td>
	<td class="td-input" id="td-estado-input"><input id="estado-input"
		class="form-control" type="text" readonly="readonly" /></td>
</tr>