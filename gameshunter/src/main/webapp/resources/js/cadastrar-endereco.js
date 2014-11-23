function pegaCep() {
	var regex = /^([0-9]{5})-([0-9]{3})$/
	var cep = $(this).val()
	var cept = $(this)
	cept.removeClass()
	if (cep != "") {
		if (regex.test(cep)) {
			$.get("teste", {
				cep : cep
			}, function(data) {
				if (data.existe) {
					$(cept).addClass("feedSuccess")
					$("#logt").val(data.logradouro.logradouro)
					$("#estadot").val(data.logradouro.estado.nome)
					$("#cidadet").val(data.logradouro.cidade.nome)
					$("#bairrot").val(data.logradouro.bairro.nome)
				}
			})
		}
	} else {
		$("#logt").val("")
		$("#estadot").val("")
		$("#cidadet").val("")
		$("#bairrot").val("")
	}
}

$("#numt").keypress(function(event) {
	var regex = /[0-9]/;
	if (!regex.test(String.fromCharCode(event.keyCode)))
		event.preventDefault()
})

$(document).ready(function() {
	$("#cept").trigger("blur")
})

$("#cept").mask("99999-999")
$("#cept").blur(pegaCep)