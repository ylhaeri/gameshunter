$("#cpf").mask("999.999.999-99")
$("#tel").mask("?(99)99999-9999")
$("#dataNasc").mask("99/99/9999")

setTimeout(function() {
	var sexo = $("#recS").val()
	if (sexo != "")
		$("#dpsexo").val(sexo)
}, 300)

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

$("#confirmasenha")
		.blur(
				function() {
					var senha1 = $("#senha").val()
					var senha2 = $("#confirmasenha").val()
					if ($("#senha1feed").val() == undefined)
						$("<span id='senha1feed'></span>")
								.insertAfter("#senha")
					if ($("#senha2feed").val() == undefined)
						$("<span id='senha2feed'></span>").insertAfter(
								"#confirmasenha")
					$("#sepSenha").html("")
					if (tamanhoSenha(senha1)) {
						$("#senha1feed").removeClass('sfail')
						$("#senha1feed").addClass('ssuc')
						$("#senha").css("border", "2px solid green")
						if (senhasIguais(senha1, senha2)) {
							$("#confirmasenha")
									.css("border", "2px solid green")
							$("#senha2feed").removeClass('sfail')
							$("#senha2feed").addClass('ssuc')
						} else {
							$("#confirmasenha").css("border", "2px solid red")
							$("#senha2feed").removeClass('ssuc')
							$("#senha2feed").addClass('sfail')
							$("#sepSenha")
									.html(
											"<span class='errorMessage'>Senhas não conferem</span>")
						}
					} else if (senha1.length > 0 && senha1.length < 6) {
						$("#senha").css("border", "2px solid red")
						$("#sepSenha").html(
								"<span class='errorMessage'>Mínimo de "
										+ "6 caracteres</span>")
						$("#senha1feed").removeClass('ssuc')
						$("#senha1feed").addClass('sfail')
						$("#confirmasenha").css("border", "1px solid black")
						$("#senha2feed").removeClass('ssuc')
						$("#senha2feed").removeClass('sfail')
					} else {
						$("#senha").css("border", "1px solid black")
						$("#confirmasenha").css("border", "1px solid black")
						$("#senha1feed").removeClass('ssuc')
						$("#senha1feed").removeClass('sfail')
						$("#senha2feed").removeClass('ssuc')
						$("#senha2feed").removeClass('sfail')
					}
				})

$("form").submit(function(event) {
	if (!senhaValida())
		event.preventDefault()
})

function tamanhoSenha(senha) {
	return senha.length >= 6;
}

function senhasIguais(senha1, senha2) {
	return $("#senha").val() == $("#confirmasenha").val()
}

function senhaValida() {
	var senha1 = $("#senha").val()
	var senha2 = $("#confirmasenha").val()
	return tamanhoSenha(senha1) && senhasIguais(senha1, senha2)
}