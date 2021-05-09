print('Hola desde archivo js');

function calcular(numero1, numero2) {
	return numero1 + numero2
}


//Funcionalidad de un hilo
var hiloImpl = {
	run: function() {
		for (var i = 0; i < 20; i++) {
			print("imprimiendo " + i);
		}
	}
}

