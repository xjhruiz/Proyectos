package com.java8.java8;

//INTERFACE FUNCIONAL SOLO UN UNICO METODO ABSTRACTO, PUEDE TENER MAS PERO SOLO UNO ABSTRACTO
//solamente un método abstracto, es decir puede implementar uno o más métodos default 
//deberá tener forzosamente un único método abstracto SE puede anotar en anotacion @FunctionalInterface
@FunctionalInterface
public interface Operacion {

//	double calcularPromedio (double n1, double n2);
	double calcular (double n1, double n2);
//	double calcular ();
//	double calcularPromedio ();
}
