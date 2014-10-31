<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<label for="cept">CEP</label><input type="text" name="endereco.cep" id="cept">
<br />
<label for="logt">Logradouro</label><input type="text" id="logt" 
name="endereco.logradouro">
<label id="num" for="numt">Nº</label><input type="text" id="numt" 
name="endereco.numero">
<br />
<label for="comt">Complemento</label><input type="text" id="comt" 
name="endereco.complemento">
<br />
<label for="bairrot">Bairro</label><input type="text" id="bairrot" name="endereco.bairro">
<br />
<label id="pais">País</label><select name="idPais" id="dpais">
	<option selected="selected">Selecione um país</option>
</select>
<label id="estado">Estado</label><select name="idEstado" id="dpest">
	<option selected="selected">Selecione um estado</option>
</select>
<label id="cidade">Cidade</label><select name="idCidade" id="dpcid">
	<option selected="selected">Selecione uma cidade</option>
</select>
 <input	type="hidden" id="recP" value="${idPais}">
 <input type="hidden" id="recE" value="${idEstado}">
 <input type="hidden" id="recC" value="${idCidade}">