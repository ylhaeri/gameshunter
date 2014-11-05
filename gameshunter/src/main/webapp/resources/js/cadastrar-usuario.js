$("#cpf").mask("999.999.999-99")
$("#tel").mask("?(99)99999-9999")

setTimeout(function() {
	for (i = 2004; i >= 1900; i--)
		$("#anobox").append("<option>" + i + "</option>")
}, 100)

setTimeout(function() {
	$.get("pegaMeses", function(info) {
		var meses = info.meses
		meses.forEach(function(mes, index) {
			index++;
			$("#mesbox").append(
					"<option value=" + index + ">" + mes + "</option>")
		})
	})
}, 100)

setTimeout(function() {
	$.get("getGender", function(info) {
		var sexos = info.sexo
		sexos.forEach(function(sexo) {

			$("#dpsexo").append("<option>" + sexo + "</option>")
		})
	})
}, 200)

setTimeout(function() {
	var sexo = $("#recS").val()
	if (sexo != "")
		$("#dpsexo").val(sexo)
}, 300)

setTimeout(function() {
	var dia = parseInt($("#recD").val())
	if (dia > 0)
		$("#diabox").val(dia)
}, 200)

setTimeout(function() {
	var mes = parseInt($("#recM").val())
	if (mes > 0)
		$("#mesbox").val(mes)
}, 200)

setTimeout(function() {
	var ano = parseInt($("#recA").val())
	if (ano > 0)
		$("#anobox").val(ano)
}, 200)

$("#mail")
		.blur(
				function() {
					var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
					var emailt = $("#mail")
					var email = emailt.val()
					if ($("#mailfeed").val() == undefined)
						$("<span id='mailfeed'></span>").insertAfter("#mail")
					if (email != "") {
						if (regex.test(email)) {
							$
									.get(
											"verificaEmail",
											{
												email : email
											},
											function(info) {

												$("#mailfeed").replaceWith(
														info.mensagem)
												if ($("#mailfeed")
														.attr("class") == "negativo") {
													return;
												}
											})
						} else
							$("#mailfeed")
									.replaceWith(
											"<span id='mailfeed' class='negativo'>E-mail inválido</span>")
					} else
						$("#mailfeed").replaceWith(
								"<span id='mailfeed'></span>")
				})

$("#confirmasenha").blur(function() {
	var senha1 = $("#senha").val()
	var senha2 = $("#confirmasenha").val()
	if (senha1.length >= 6) {
		if ($("#senhafeed").val() == undefined)
			$("<span id='senhafeed'></span>").insertAfter("#confirmasenha")
		if (senha1 == senha2) {
			$("#senhafeed").removeClass('sfail')
			$("#senhafeed").addClass('ssuc')
		} else {
			$("#senhafeed").removeClass('ssuc')
			$("#senhafeed").addClass('sfail')
		}
	}
})