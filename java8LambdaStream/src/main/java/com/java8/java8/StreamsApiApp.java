package com.java8.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamsApiApp {

	/*
	 * 
	 * METODOS DE STREAM MAS USADOS
	 * 
	 */
	private List<String> lista;
	private List<String> numeros;

	public StreamsApiApp() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Leyenda");
		lista.add("Cuento");
		lista.add("Historia");
		lista.add("Aventura");

		numeros = new ArrayList<>();
		numeros.add("5");
		numeros.add("4");
		numeros.add("1");
		numeros.add("8");

	}

	private void filtrar() {
		lista.stream().filter(x -> x.startsWith("C")).forEach(x -> System.out.println(x));
		lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);
	}

	public void ordernar() {
		lista.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
	}

	public void transformar() {
		// Transforma cada elemento de la lista con una expresion indicada
		// Puedo hacer referencia a sus metodos ejer ReferencesMethod

		lista.stream().map(String::toUpperCase).forEach(System.out::println);

		// Transformacion imperativa y suma de un valor
		for (String e : numeros) {
			int num = Integer.parseInt(e) + 1;
			System.out.println(num);
		}
		// Transformacion declarativa y suma de un valor
		System.out.println("Declarativa");
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
		// SI SOLO QUISIERA TRANSFORMAR CADA INSTANCIA DEL ELEMENTO PODEMOS PONER
		// Integer::parseInt, pero como vamos a sumarle 1, no se puede
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);

	}

	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
	}

	public void contar() {
		Long x = lista.stream().count();
		System.out.println(x);
	}

	public static void main(String[] args) {
		StreamsApiApp app = new StreamsApiApp();
//		app.filtrar();
//		System.out.println("*");
//		app.ordernar();
//		app.transformar();
//		app.limitar();
		app.contar();
	}

}
