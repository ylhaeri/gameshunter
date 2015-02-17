$(document).ready(function() {

	function pegaCep() {
		var regex = /^([0-9]{5})-([0-9]{3})$/;
		var cep = $(this).val();
		var cept = $(this);
		$("#logradouro-input").val("");
		$("#estado-input").val("");
		$("#cidade-input").val("");
		$("#bairro-input").val("");
		$('#logradouro-input').attr('readonly', true);
		$('#bairro-input').attr('readonly', true);
		if (regex.test(cep)) {
			$.get("../endereco/cep/" + cep, function(data) {
				if (typeof data == "string")
					return;
				else if (data.bairro != undefined) {
					console.log("rua");
					$("#logradouro-input").val(data.logradouro);
					$("#bairro-input").val(data.bairro.nome);
					$("#cidade-input").val(data.cidade.nome);
					$("#estado-input").val(data.estado.nome);
					return;
				} else {
					console.log("cidade");
					$('#logradouro-input').attr('readonly', false);
					$('#bairro-input').attr('readonly', false);
					$("#cidade-input").val(data.nome);
					$("#estado-input").val(data.estado.nome);
					return;
				}
			})
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

	$("#cep-input").blur(pegaCep)
	$("#cep-input").mask("99999-999")
})