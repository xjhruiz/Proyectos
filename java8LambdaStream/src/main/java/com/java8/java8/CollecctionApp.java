package com.java8.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollecctionApp {

	private List<String> lista;

	private void llenarLista() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Leyenda");
		lista.add("Cuento");
		lista.add("Historia");
		lista.add("Aventura");
	}

	public void usarForEach() {
		// IMPERATIVO
		/*
		 * for(String elemento : lista) { System.out.println(elemento); }
		 */

		// DECLARATIVO 1.8 lambdas y metodos de referencia
//		lista.forEach(x-> System.out.println(x));

		// REFERENCIA A METODOS el foreach crea una instancia de cada elemento del
		// objeto lista, por ello puedo acceder al metodo println
		lista.forEach(System.out::println);

	}

	public void usarRemoveIf() {

		// IMPERATIVO
		/*Iterator<String> it = lista.iterator();
//		 for(String elemento : lista){  No se puede modificar un elemento de una lista de esta forma es necesario un iterator
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase("Leyenda")) {
				it.remove();
			}
		}*/

		// DECLARATIVO Se puede USAR CON PREDICATE
		lista.removeIf(x -> x.equalsIgnoreCase("Leyenda"));
		 
	}

	public void usarSort() {

//		Collections.sort(lista);
		lista.sort( (x ,y) -> y.compareTo(x));
	}

	public static void main(String[] args) {
		CollecctionApp app = new CollecctionApp();
		app.llenarLista();
//		app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();
	}

}
