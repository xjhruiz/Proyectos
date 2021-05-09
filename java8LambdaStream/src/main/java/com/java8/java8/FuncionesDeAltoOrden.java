package com.java8.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 
 * HIGH ORDEN FUNCTION
 * Funciones de alto orden
 *
 */
public class FuncionesDeAltoOrden {

	// Declarar funciones de alto orden Function < Tipo dato Entrada , Tipo dato
	// Salida> nombre = lo que se quiere hacer EXPRESION LAMBDA
	// TIPO FUNCTION
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();

	// RECIBE COMO PARAMETRO UNA FUNCION Y EL VALOR QUE SE PASA
	public void imprimir(Function<String, String> funcion, String valor) {
		System.out.println(funcion.apply(valor));
	}

	// Funcion de alto orden que concatena su entrada con su salida
	public Function<String, String> mostrar(String mensaje) {
		return (String x) -> mensaje + x;
	}

	// PREDICATES AND CONSUMER

												//Consumidor -> Referencia a metodos una funcion
	public void filtrar(List<String> lista , Consumer<String> consumidor, int longitud , String contiene) {
//		lista.stream().filter(this.establecerLogicaComprobacion(longitud)).forEach(consumidor);
		lista.stream().filter(this.establecerLogicaComprobacion(contiene)).forEach(consumidor);
	}

	public Predicate<String> establecerLogicaComprobacion(int longitud) {
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaComprobacion(String contiene) {
		return texto -> texto.contains(contiene);
	}

	public static void main(String[] args) {

		FuncionesDeAltoOrden app = new FuncionesDeAltoOrden();
		app.imprimir(app.convertirMayusculas, "mito");
		app.imprimir(app.convertirMinusculas, "MITO");
		String resp = app.mostrar("Hola ").apply(" Que hace");
		System.out.println(resp);
		
		List<String> lista = new ArrayList<String>();
		lista.add("Leyenda");
		lista.add("Mito");
		lista.add("Aventura");
		lista.add("Historia");
		
		//mostrar de lista los elementos con una longitud menor a 5 
//		app.filtrar(lista, System.out::println, 5, null);
		app.filtrar(lista, System.out::println, 0, "en");

	}

}
