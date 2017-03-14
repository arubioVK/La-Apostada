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
					nuevoForm.append('<input type="hidden" name='+$("meta[name='_csrf_header']").attr("content")+' value="' + $("meta[name='_csrf']").attr("content") + '">');


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
	
	// Añadir Resultado
	$('.anadir-resultado').click(function () {
		
		var wrapper = $(this).closest('.form-ajax');
		
		var nuevoForm = $('<form action="' + wrapper.data('action') + '" method="' + wrapper.data('method') + '"></form>');
		
		
			if (wrapper.find('[name="partido"]').length >= 1) {
				nuevoForm.append('<input type="text" name="partido" value="' + wrapper.find('[name="partido"]').eq(0).val() + '">');
				
				if (wrapper.find('[name="golLocal"]').eq(0).val() != "") {
					nuevoForm.append('<input type="text" name="golLocal" value="' + wrapper.find('[name="golLocal"]').eq(0).val() + '">');
					
					if (wrapper.find('[name="golVisitante"]').eq(0).val() != "") {
						nuevoForm.append('<input type="text" name="golVisitante" value="' + wrapper.find('[name="golVisitante"]').eq(0).val() + '">');
						nuevoForm.append('<input type="text" name="redirect" value="' + window.location.pathname + '">');
					
					
					$('body').append(nuevoForm);

					nuevoForm.submit();
					} else {
						$('#modal-default .modal-title').text("Error");
						$('#modal-default .modal-body').text("Introduce goles");
						$('#modal-default').modal('show');
					}
					} else {
					$('#modal-default .modal-title').text("Error");
					$('#modal-default .modal-body').text("Introduce goles");
					$('#modal-default').modal('show');
				}
			} else {
				$('#modal-default .modal-title').text("Error");
				$('#modal-default .modal-body').text("Introduce un partido");
				$('#modal-default').modal('show');
			}
	});
	
	
	// Fix
	$('[data-toggle="buttons"] a[href]').click(function (e) {
		e.stopPropagation();
	});

	// Websocket para cuotas
	var lastViewTimestamp = "2017-03-12 12:07:32";
	var connectionCuotas = new WebSocket('wss://127.0.0.1:8443/websocket/cuotas');
	connectionCuotas.onopen = function () {
		connectionCuotas.send('{last_view_timestamp: "' + lastViewTimestamp + '"}');
	};
	connectionCuotas.onerror = function (e) {
		console.log("WS error: " + e);
	};
	connectionCuotas.onmessage = function (msg) {
		/*
		Ejemplo de "msg":
			{
				type: 1, // tipo de cuota
				partido_id: 12, // id del partidos
				// atributo personalizado para cada cuota
				// ejemplo de cuota "type = 1"
				cuota: {
					local: 1.03
					empate: 2.12
					visitante: 6.32
				},
				last_view_timestamp: 2017-03-01 22:01:24
			}
		*/
	   
		console.log("WS recibido: ", msg.data);
	   
		var data;
		try {
			data = JSON.parse(msg.data);
		} catch (e) {
			return;
		}
		
		if (!data.type) return;
		
		if (data.type == 1) {
			// Actualizar cuota tipo clasica (1x2)
			$('[data-partido=' + data.partido_id + '][data-tipo="1"][data-cuota-attr="local"]').text(data.cuota.local);
			$('[data-partido=' + data.partido_id + '][data-tipo="1"][data-cuota-attr="empate"]').text(data.cuota.empate);
			$('[data-partido=' + data.partido_id + '][data-tipo="1"][data-cuota-attr="visitante"]').text(data.cuota.visitante);
			
			// Update timestamp
			lastViewTimestamp = data.last_view_timestamp;
		} else {
			console.log("Mensaje desconocido");
			return;
		}
	};

});
