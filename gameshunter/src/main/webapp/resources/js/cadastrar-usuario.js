$.getScript("resources/js/objetos.js")
setTimeout(function() {
	meses.forEach(function(mes) {
		$("#mesbox").append(
				"<option value=" + mes.id + ">" + mes.nome + "</option>")
	})
}, 100)

setTimeout(function() {
	for (i = 2004; i >= 1900; i--)
		$("#anobox").append("<option>" + i + "</option>")
}, 100)