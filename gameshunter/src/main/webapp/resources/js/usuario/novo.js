$(document).ready(function() {
	
	$("#cpf-input").mask("999.999.999-99")
	$("#telefone-input").mask("(99)9999-9999")
	$("#nascimento-input").mask("99/99/9999")
	$("#celular-input").mask("?(99)9999-99999")
	
	$("#mail").blur(function() {
		var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	})
	
	/*$("#form-cadastro").submit(function(event) {
		var form = $(this)
		if (!senhaValida()) {
			event.preventDefault()
		} else {
			form.find("input[type='image'],input[type='submit']").attr("disabled", "true");
		}
	})*/
})