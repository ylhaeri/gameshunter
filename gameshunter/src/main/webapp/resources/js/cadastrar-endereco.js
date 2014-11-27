$(document).ready(function() {

	function pegaCep() {
		var regex = /^([0-9]{5})-([0-9]{3})$/
		var cep = $(this).val()
		var cept = $(this)
		if (regex.test(cep)) {
			alert(cep)
			$("#ajaxjsonlink").trigger("click")
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

	$("#cept").blur(pegaCep)
	$("#cept").mask("99999-999")
})