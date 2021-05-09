package com.java8.java8;

import java.util.Optional;

/*
 * manejadores de NullPointerException
 * La clase Optional Consume mucho rendimiento
 */

public class OpcionalApp {

	public void probar(String valor) {
//		System.out.println(valor.contains("mito"));
		//envoltorio al que hay que especificar el tipo de dato
		
		try {
			Optional<String> op = Optional.empty();
			op.get();//Devuelve el tipo de dato que se ha especificado es necesario metelor en un bloque try catch por que se ha inicializado con empty()
		} catch (Exception e) {
			System.out.println("No hay elementos");
		}
		
	}

	public void orElse(String valor) {
		//of() ->INICIALIZADO CON EL VALOR QUE SE RECIBI COMO PARAMETRO
		//ofNullable()-> SI ACEPTA VALORES NULLOS
		Optional<String> op = Optional.ofNullable(valor);
		//orElse() -> determinada un valor por defecto
		String x = op.orElse("Por defecto");
		System.out.println(x);
	}
	
	
	public void orElseThrow(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		//orElseThrow () -> TENER LA OPCION DE LANZAR UNA EXCEPCION AUN TENIENDO VALOR NULL Y VALOR POR DEFECTO
		op.orElseThrow(NumberFormatException::new);
		System.out.println(op.get());
	}
	
	public void isPresent(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		//isPresent() -> 	SI EL VALOR HA SIDO INICIALIZADO O NO
		System.out.println(op.isPresent());
	}

	public static void main(String[] args) {
		OpcionalApp app = new OpcionalApp();
//		app.probar(null);
//		app.orElse("Leyenda");
//		app.orElseThrow(null);
		app.isPresent("Leyenda");
	}
}
