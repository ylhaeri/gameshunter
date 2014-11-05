<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<table>
	<s:textfield label="CEP" labelposition="top" labelSeparator=""
		id="cept" name="endereco.cep" value="%{endereco.cep}"
		errorPosition="bottom" />
	<tr>
		<td class="arara"></td>
	</tr>
	<s:textfield label="Logradouro" labelposition="top" labelSeparator=""
		id="logt" name="endereco.logradouro" value="%{endereco.logradouro}"
		errorPosition="bottom" />
	<tr>
		<td class="arara"></td>
	</tr>
	<s:textfield label="N.�" labelposition="top" labelSeparator=""
		id="numt" name="endereco.numero" value="%{endereco.numero}"
		errorPosition="bottom" />
	<tr>
		<td class="arara"></td>
	</tr>
	<s:textfield label="Complemento" labelposition="top" labelSeparator=""
		id="comt" name="endereco.complemento" value="%{endereco.complemento}"
		errorPosition="bottom" />
	<tr>
		<td class="arara"></td>
	</tr>
	<s:textfield label="Bairro" labelposition="top" labelSeparator=""
		id="bairrot" name="endereco.bairro" value="%{endereco.bairro}"
		errorPosition="bottom" />
	<tr>
		<td class="arara"></td>
	</tr>
	<tr>
		<td><label id="pais">Pa�s</label></td>
		<td><label id="estado">Estado</label></td>
		<td><label id="cidade">Cidade</label></td>
	</tr>
	<tr>
		<td><select name="idPais" id="dpais">
				<option selected="selected">Selecione um pa�s</option>
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
<br />
<input type="hidden" id="recP" value="${idPais}">
<input type="hidden" id="recE" value="${idEstado}">
<input type="hidden" id="recC" value="${idCidade}">
</html>