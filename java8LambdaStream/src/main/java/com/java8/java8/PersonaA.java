package com.java8.java8;

public interface PersonaA {
	
	public void caminar();
	
	//METODO POR DEFAULT AQUEL QUE ESTA IMPLEMANTADO EN UNA INTERFAZ PARA QUE CUALQUIERA CLASE QUE IMPLEMENTE ESTA INTERFAZ YA TENGA DEFINIDO DICHO METODO
	default public void hablar() {
		System.out.println("Muchos saludos de PersonaA");
	}

}
