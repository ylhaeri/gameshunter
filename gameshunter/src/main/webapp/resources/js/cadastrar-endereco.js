$("#cept").mask("99999-999")

$("#cept").blur(function() {
	var regex = /^([0-9]{5})-([0-9]{3})$/
	var cep = $(this).val()
	if (regex.test(cep)) {
		$.get("teste", function(data) {
			alert(data.nome)
			// FIXME
		})
	}
})

$("#numt").keypress(function(event) {
	var regex = /[0-9]/;
	if (!regex.test(String.fromCharCode(event.keyCode)))
		event.preventDefault()
})