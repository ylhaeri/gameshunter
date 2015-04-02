$(document).ready(function() {
	$("#path").val(window.location.pathname.replace("/gameshunter", ""));

	$('.open-menu').click(function() {
		$('.navigation').css({
			'left' : '0'
		});
	});

	$('.close-menu').click(function() {
		$('.navigation').css({
			'left' : '-90%'
		});
	});

});