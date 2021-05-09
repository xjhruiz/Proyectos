package com.java8.java8;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * 
 * Observer ? Programacion reactiva ?
 * 
 * RXjava -> manejo de procesamiento asincrono
 *
 */
public class Observador {

	private List<Integer> lista1;
	private List<Integer> lista2;

	public Observador() {
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llenarListas();
	}

	private void llenarListas() {
		for (int i = 0; i < 10; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}

	// Objetos observador -> definir la logica
	public void buscar() {

		
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		// Une dos observables para tener un unico resultado
		/*
		 * Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {

			@Override // Declaro la logica dentro del observador metodo call me devuelve los resultados de forma asincrona
			public void call(Integer numero) {
				if (numero == 1) {
					System.out.println(numero);
				}
			}
		});
		*/
		//Declarativo por que es una interfaz funcinal
//		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(System.out::println);
		//Mas aceta de esto https://www.youtube.com/watch?v=bM9wZvlpRwE
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(x->{
			if(x == 1) {
				System.out.println(x);
			}
		});
		Observable.merge(obs1, obs2).subscribe(x->{
			if(x == 2) {
				System.out.println(x);
			}
		});
	}

	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("Leyenda");
		lista.add("Mito");
		lista.add("Aventura");
		lista.add("Historia");

		Observable<String> obs = Observable.from(lista);
		// Se crea un observable con el tipo que se quiere,se pone de donde se observara
		// el elemento iterrable
		// Se crea un subscritor con una action1 que indica la llamada de cada elemento
		// y la logica que se aplicará a cada elemento
		obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				System.out.println(elemento);
			}
		});
		
		Observador obs2 = new Observador();
		obs2.buscar();
	}

}
