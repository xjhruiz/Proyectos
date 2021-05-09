package com.java8.java8;

public class Scopes {

	private static double atr1;
	private double atr2;

	private double probarLocalVariable() {
// LAS VARIABLES LOCALES NO PUEDEN SER MODIFICADAS, MAS SI SE PUEDEN COGER EL VALOR, LAS GLOBALES O ATRIBULOS DE CLASES, PUEDEN SER MODIFICADAS.
		double n3 = 3;
		Operacion op = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {

				return n3 + n1 + n2;
			}

		};
		// N3 no puede ser modificada es igual al alcance de una clase anonima
		Operacion operacion = (x, y) -> {
//			n3 = x +y; SOLO SE PUEDE USAR EL VALOR MAS NO MODIFICARLO
			return x + y + n3;
		};

		return op.calcular(1, 1);
	}

	private double probarAtributosStaticVariables() {
		// Se pueden modificar las variables globales estaticas en las expresiones
		// lambda

		// OBJETOS ANONIMOS
		Operacion op2 = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				atr1 = n1 + n2;
				atr2 = atr1;
				return atr2;
			}
		};

		Operacion op = (x, y) -> {
			atr1 = x + y;
			atr2 = atr1;
			return atr2;
		};
		return op2.calcular(3, 2);
	}

	public static void main(String[] args) {
		Scopes app = new Scopes();
//		System.out.println(app.probarLocalVariable());
		System.out.println(app.probarAtributosStaticVariables());
	}
}
