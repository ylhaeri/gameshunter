function crEst() {
	var pais = document.querySelector("#dpais");
	var pid = pais.options[pais.selectedIndex].value;
	if (pid == "Selecione um país") {
		$("#dpest").html(
				"<option selected='selected'>Selecione um estado</option>");
		$("#dpcid").html(
				"<option selected='selected'>"
						+ "Selecione uma cidade</option>");
		return;
	}
	$.get("pegaEstados", {
		idP : pid
	}, function(info) {
		var estados = info.estados;
		$("#dpest").html(
				"<option selected='selected'>Selecione um estado</option>")
		estados.forEach(function(estado) {
			$("#dpest").append(
					"<option value=" + estado.id + ">" + estado.nome
							+ "</option>")
		})
	})
}

function crCid() {
	var estado = document.querySelector("#dpest");
	var eid = estado.options[estado.selectedIndex].value;
	if (eid == "Selecione um estado") {
		$("#dpcid").html(
				"<option selected='selected'>"
						+ "Selecione uma cidade</option>");
		return;
	}
	$.get("carregaCidade", {
		idE : eid
	}, function(info) {
		var cidades = info.cidades
		$("#dpcid").html(
				"<option selected='selected'>"
						+ "Selecione uma cidade</option>");
		cidades.forEach(function(cidade) {
			$("#dpcid").append(
					"<option value=" + cidade.id + ">" + cidade.nome
							+ "</option>")
		})
	})
}