package com.java8.java8;

import java.util.ArrayList;
import java.util.List;

/*
 * StreamParallel 
 * 
 */

public class StreamParallel {

	private List<Integer> numeros;

	public void llenar() {
		numeros = new ArrayList();
		for (int i = 0; i < 10; i++) {
			numeros.add(i);
		}
	}


	//DE FORMA SECUENCIAL
	public void probarStream() {
		numeros.stream().forEach(System.out::println);
	}
	
	/**
	 * 
	 */
	public void probarParalelo() {
		//Utiliza el framework Fork/Join procesamiento con hilos asincrono Mejora el rendimiento de las aplicaciones 
//		No hay que abusar su uso y menos en java web ee containers
		numeros.parallelStream().forEach(System.out::println);
	}


	public static void main(String[] args) {

		StreamParallel app = new StreamParallel();
		app.llenar();
//		app.probarStream();
		app.probarParalelo();
	}

}
