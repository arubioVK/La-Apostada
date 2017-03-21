function getTimestamp() {
	return (new Date()).toISOString().substr(0, 19).replace('T', ' ');
}

var last_view_timestamp = getTimestamp();

$(function () {

	// Apostar
	$('.enviar-apuesta').click(function () {
		var wrapper = $(this).closest('.form-ajax');

		var nuevoForm = $('<form action="' + wrapper.data('action') + '" method="' + wrapper.data('method') + '"></form>');

		if (wrapper.find('.btn.active [name="resultado"]').length >= 1) {
			nuevoForm.append('<input type="text" name="cuota" value="' + parseFloat(wrapper.find('.btn.active').eq(0).text()) + '">');
			nuevoForm.append('<input type="text" name="resultado" value="' + wrapper.find('.btn.active [name="resultado"]').eq(0).val() + '">');

			if (wrapper.find('[name="partido"]').length >= 1) {
				nuevoForm.append('<input type="text" name="partido" value="' + wrapper.find('[name="partido"]').eq(0).val() + '">');
				
				if (wrapper.find('[name="cantidad"]').eq(0).val() != "") {
					nuevoForm.append('<input type="text" name="cantidad" value="' + wrapper.find('[name="cantidad"]').eq(0).val() + '">');
					nuevoForm.append('<input type="text" name="redirect" value="' + window.location.pathname + '">');
					nuevoForm.append('<input type="hidden" name="_csrf" value="' + wrapper.find('[name="_csrf"]').eq(0).val() + '">');

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
					nuevoForm.append('<input type="hidden" name="_csrf" value="' + wrapper.find('[name="_csrf"]').eq(0).val() + '">');

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

	function setupWebSocket() {
		// Websocket para cuotas
		var connectionCuotas = new WebSocket("wss://" + window.location.host + "/websocket/cuotas");
		var interval = null;

		connectionCuotas.onopen = function () {
			if (interval) clearInterval(interval);
			
			interval = setInterval(function () {
				connectionCuotas.send('{"last_view_timestamp": "' + last_view_timestamp + '"}');
			}, 5000);
		};
		connectionCuotas.onclose = function() {
			// Reopen
			clearInterval(interval)
			setTimeout(setupWebSocket, 1000);
		};
		connectionCuotas.onerror = function (e) {
			console.log("WS error: " + e);
		};
		connectionCuotas.onmessage = function (msg) {
			/*
			Ejemplo de "msg":
				{
					partido_id: 12, // id del partidos
					// atributo personalizado para cada cuota
					// ejemplo de cuota "type = 1"
					cuota: {
						local: 1.03
						empate: 2.12
						visitante: 6.32
					},
					fecha: "2017-03-01 22:01:24"
				}
			*/

			console.log("WS recibido: ", msg.data);

			var data;
			try {
				data = JSON.parse(msg.data);
			} catch (e) {
				return;
			}

			if (!data.fecha) return;

			// Check fecha es mayor que la mia
			if (data.fecha >= last_view_timestamp) {
				// Update timestamp
				last_view_timestamp = data.fecha;
			}

			// Actualizar cuota tipo clasica (1x2)
			$('[data-partido=' + data.partido_id + '][data-cuota-attr="local"]').text(data.cuota.local);
			$('[data-partido=' + data.partido_id + '][data-cuota-attr="empate"]').text(data.cuota.empate);
			$('[data-partido=' + data.partido_id + '][data-cuota-attr="visitante"]').text(data.cuota.visitante);
		};
	}
	
	setupWebSocket();

});
