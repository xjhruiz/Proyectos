package com.java8.java8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaApp {

	public double calcular() {
		/*
		 * Operacion operacio = new Operacion() { //IMPERATIVO QUE
		 * 
		 * @Override public double calcularPromedio(double n1, double n2) { return
		 * (n1+n2)/2; } }; System.out.println(operacio.calcularPromedio(2, 3));
		 */

		// DECLARATIVO 
//		Operacion operacion = (double x , double y) -> (x+y)/2;
//		Mas abreviado cuando son del mismo tipo se puede omitir el tipo de la variable
		Operacion operacion = ( x , y) -> (x+y)/2;
		// DIFERENTE SINTAXIS PARA DEFINIR MAS DE UNA LINEA NO RECOMENDABLE TENER VARIAS
		// LINEAS EN EXPRESION LAMBDA
//		Operacion operacion = ( double x , double y) -> { return (x+y)/2;};
//		Operacion operacionMasLinea = (double x, double y) -> {
//			double a = 2.0;
//			System.out.println(a);
//			return (x + y) / 2 + a;
//		};
//		Operacion operacion = () -> 2;
//		Operacion operacion = () -> {
//			
//			int x = 2;
//			int y = 3;
//			return x + y;
//		};
//		System.out.println(operacion.calcularPromedio(2, 3));
//		return operacionMasLinea.calcularPromedio(4, 4);
		return operacion.calcular( 4,3);
//		return operacion.calcularPromedio( );
	}

	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Leyenda");
		lista.add("Historia");
		lista.add("Aventura");

//		Collections.sort(lista, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		// PROGRAMACION DECLARATIVA SORT LAMBDA
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

		for (String e : lista) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		app.ordenar();
		System.out.println(app.calcular());
	}
}
