$(function () {
	
	// [AJAX] Coutas
	$('.enviar-apuesta').click(function () {
		
		var nuevoForm = $('<form action="" method="POST"></form>');
		nuevoForm.append('<input type="text" name="resultado" value="1">');
		nuevoForm.append('<input type="text" name="partido" value="12">');
		nuevoForm.submit();
		
	});
	
});
