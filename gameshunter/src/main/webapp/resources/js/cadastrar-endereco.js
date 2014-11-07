$("#cept").mask("99999-999")

$(document).ready(
		function() {
			$.get("pegaPaises", function(info) {
				var paises = info.paises;
				paises.forEach(function(pais) {

					$("#dpais").append(
							"<option value=" + pais.id + ">" + pais.nome
									+ "</option>")
				})
			})
		})

$("#dpais").change(
		function() {
			var pais = document.querySelector("#dpais");
			var pid = pais.options[pais.selectedIndex].value;
			if (pid == "Selecione um país") {
				$("#dpest").html(
						"<option selected='selected'>"
								+ "Selecione um estado</option>");
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
						"<option selected='selected'>"
								+ "Selecione um estado</option>")
				estados.forEach(function(estado) {
					$("#dpest").append(
							"<option value=" + estado.id + ">" + estado.nome
									+ "</option>")
				})
			})
		})

$("#dpest").change(
		function() {
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
		})

setTimeout(function() {
	var pid = parseInt($("#recP").val())
	if (pid > 0)
		$("#dpais").val(pid).trigger("change")
}, 100);

setTimeout(function() {
	var eid = parseInt($("#recE").val())
	if (eid > 0)
		$("#dpest").val(eid).trigger("change")
}, 200);

setTimeout(function() {
	var cid = parseInt($("#recC").val())
	if (cid > 0)
		$("#dpcid").val(cid)
}, 300);

$("#numt").keypress(function(event) {
	var regex = /[0-9]/;
	if (!regex.test(String.fromCharCode(event.keyCode)))
		event.preventDefault()
})