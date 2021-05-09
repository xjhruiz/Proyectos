package com.java8.java8;

public class DefaultMethod implements PersonaA, PersonaB {

	//METODOS POR DEFECTO AQUELLOS QUE YA TIENEN LA IMPLEMENTACION HECHA, ES DECIR, NO HAY QUE SOBREESCRIBILOS
	@Override
	public void caminar() {
		System.out.println("HOLA SALUDOS");
	}

	@Override
	public void hablar() {
		// TODO Auto-generated method stub
//		PersonaB.super.hablar();
		System.out.println("SALUD");
	}

	public static void main(String[] args) {

		DefaultMethod app = new DefaultMethod();
		app.hablar();

	}

}
