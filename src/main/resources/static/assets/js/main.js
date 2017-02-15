$(function () {
	
	// Apostar
	$('.enviar-apuesta').click(function () {
		
		var wrapper = $(this).closest('.form-ajax');
		
		var nuevoForm = $('<form action="' + wrapper.data('action') + '" method="' + wrapper.data('method') + '"></form>');
		
		if (wrapper.find('.btn.active [name="resultado"]').length >= 1) {
			nuevoForm.append('<input type="text" name="resultado" value="' + wrapper.find('.btn.active [name="resultado"]').eq(0).val() + '">');
		
			if (wrapper.find('[name="partido"]').length >= 1) {
				nuevoForm.append('<input type="text" name="partido" value="' + wrapper.find('[name="partido"]').eq(0).val() + '">');
				
				if (wrapper.find('[name="cantidad"]').eq(0).val() != "") {
					nuevoForm.append('<input type="text" name="cantidad" value="' + wrapper.find('[name="cantidad"]').eq(0).val() + '">');
					nuevoForm.append('<input type="text" name="redirect" value="' + window.location.pathname + '">');
					
					$('body').append(nuevoForm);

					nuevoForm.submit();
				} else {
					$('#modal-default .modal-title').text("Error");
					$('#modal-default .modal-body').text("Introduce una cantidad");
					$('#modal-default').modal('show');
				}
			} else {
				$('#modal-default .modal-title').text("Error");
				$('#modal-default .modal-body').text("Introduce un partido");
				$('#modal-default').modal('show');
			}
		} else {
			$('#modal-default .modal-title').text("Error");
			$('#modal-default .modal-body').text("Elige un resultado");
			$('#modal-default').modal('show');
		}
		
	});
	
	// Fix
	$('[data-toggle="buttons"] a[href]').click(function (e) {
		e.stopPropagation();
	});
	
});
