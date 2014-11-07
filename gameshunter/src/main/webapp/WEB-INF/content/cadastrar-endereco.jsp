<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<table>
	<tr><td class="separadorGrande"></td></tr>
	<s:textfield label="CEP" labelposition="top" labelSeparator=""
		id="cept" name="endereco.cep" value="%{endereco.cep}"
		errorPosition="bottom" />
	<tr><td class="separador"></td></tr>
	<s:textfield label="Logradouro" labelposition="top" labelSeparator=""
		id="logt" name="endereco.logradouro" value="%{endereco.logradouro}"
		errorPosition="bottom" />
	<tr><td class="separador"></td></tr>
	<s:textfield label="Número" labelposition="top" labelSeparator=""
		id="numt" name="endereco.numero" value="%{endereco.numero}"
		errorPosition="bottom" maxLength="6" />
	<tr><td class="separador" id="numfeed"></td></tr>
	<s:textfield label="Complemento" labelposition="top" labelSeparator=""
		id="comt" name="endereco.complemento" value="%{endereco.complemento}"
		errorPosition="bottom" />
	<tr><td class="separador"></td></tr>
	<s:textfield label="Bairro" labelposition="top" labelSeparator=""
		id="bairrot" name="endereco.bairro" value="%{endereco.bairro}"
		errorPosition="bottom" />
	<tr><td class="separador"></td></tr>
</table>
<table>
	<tr>
		<td><label id="pais">País</label></td>
		<td><label id="estado">Estado</label></td>
		<td><label id="cidade">Cidade</label></td>
	</tr>
	<tr id="dpLocal">
		<td><select name="idPais" id="dpais">
				<option selected="selected">Selecione um país</option>
		</select></td>
		<td><select name="idEstado" id="dpest">
				<option selected="selected">Selecione um estado</option>
		</select></td>
		<td><select name="idCidade" id="dpcid">
				<option selected="selected">Selecione uma cidade</option>
		</select></td>
	</tr>
	<tr>
		<td><s:fielderror fieldName="idPais"></s:fielderror></td>
		<td><s:fielderror fieldName="idEstado"></s:fielderror></td>
		<td><s:fielderror fieldName="idCidade"></s:fielderror></td>
	</tr>
</table>
<input type="hidden" id="recP" value="${idPais}">
<input type="hidden" id="recE" value="${idEstado}">
<input type="hidden" id="recC" value="${idCidade}">
</html>