package com.java8.java8;

import java.util.Arrays;
import java.util.Comparator;

public class ReferencesMethod {

	public static void referenciarMetodoStatic() {
		System.out.println("Metodo Refenciado Statico");

	}

	public void referenciarMetodoInstanciaObjetoArbitrario() {
		String[] nombres = { "Leyenda", "Mito", "Historia", "Cuento" };

		// IMPERATIVO
//		Arrays.sort(nombres, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareToIgnoreCase(o2);
//			}
//		});

		// DECLARATIVO
		/*
		 * Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
		 * System.out.println(Arrays.toString(nombres));
		 */

		// AUN MAS ABREVIADO CON LA INVOCACION DEL METODO DE INSTANCIA
		// CLASE DEL METODO A REFERENCIAR :: Y METODO REFERENCIADO
		Arrays.sort(nombres, String::compareToIgnoreCase);
		// con array sort, se recorre todas las instancias de nombres y por ello, puedo
		// acceder a los metodos de la clase String con una referencia ::
		System.out.println(Arrays.toString(nombres));
	}

	public void referenciarMetodosInstanciaObjetoParticular() {
		System.out.println("Metodo Referenciado Instancia de Clase");
	}

	public void refenciarConstructor() {
		// IMPERATIVO
		/*
		 * IPersona iper = new IPersona() {
		 * 
		 * @Override public Persona crear(int id, String nombre) { return new
		 * Persona(id, nombre); }
		 * 
		 * }; iper.crear(1, "PEPE");
		 */

		// DECLARATIVO
		IPersona iper2 = (x, y) -> (new Persona(x, y));
		Persona per = iper2.crear(1, "PEPE");
		System.out.println(per.getId() + " " + per.getNombre());

		// MAS ABREVIADO
		IPersona iper3 = Persona::new;
		Persona per2 = iper3.crear(1, "PEPE2");
		System.out.println(per2.getId() + " " + per2.getNombre());
	}

	public void operar() {
		Operacion2 op = () -> ReferencesMethod.referenciarMetodoStatic();
		op.saludar();

		// REFERENCIA A METODOS NO SE PUEDEN PONER PARAMETROS -> currificacion

		Operacion2 op2 = ReferencesMethod::referenciarMetodoStatic;
		op2.saludar();
	}

	public static void main(String[] args) {
		ReferencesMethod app = new ReferencesMethod();
//		app.operar();
//		app.referenciarMetodoInstanciaObjetoArbitrario();
		// Implemento la referencia del metodo objetoParticular al metodo saludar, es
		// decir que implemento dicho metodo a op
//		Operacion2 op = app::referenciarMetodosInstanciaObjetoParticular;
//		op.saludar();
		app.refenciarConstructor();

	}
}
