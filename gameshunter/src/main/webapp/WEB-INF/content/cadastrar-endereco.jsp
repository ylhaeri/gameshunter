<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<table>
	<tr>
		<td class="separadorGrande"></td>
	</tr>
	<s:textfield label="CEP" labelposition="top" labelSeparator=""
		id="cept" name="cep" value="%{cep}" errorPosition="bottom" />
	<tr>
		<td class="separador"></td>
	</tr>
	<s:textfield label="Logradouro" labelposition="top" labelSeparator=""
		id="logt" errorPosition="bottom" disabled="true" />
	<tr>
		<td class="separador"></td>
	</tr>
	<s:textfield label="Número" labelposition="top" labelSeparator=""
		id="numt" name="endereco.numero" value="%{endereco.numero}"
		errorPosition="bottom" maxLength="6" />
	<tr>
		<td class="separador" id="numfeed"></td>
	</tr>
	<s:textfield label="Complemento" labelposition="top" labelSeparator=""
		id="comt" name="endereco.complemento" value="%{endereco.complemento}"
		errorPosition="bottom" />
	<tr>
		<td class="separador"></td>
	</tr>
	<s:textfield label="Bairro" labelposition="top" labelSeparator=""
		id="bairrot" errorPosition="bottom" disabled="true" />
	<tr>
		<td class="separador"></td>
	</tr>
	<s:textfield label="Cidade" labelposition="top" labelSeparator=""
		id="cidadet" errorPosition="bottom" disabled="true"></s:textfield>
	<tr>
		<td class="separador"></td>
	</tr>
	<s:textfield label="Estado" labelposition="top" labelSeparator=""
		id="estadot" errorPosition="bottom" disabled="true"></s:textfield>
</table>
</html>