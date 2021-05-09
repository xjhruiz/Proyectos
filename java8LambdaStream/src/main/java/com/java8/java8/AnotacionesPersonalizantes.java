package com.java8.java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/***
 * 
 * ANOTACION PERSONALIZADAS @interface + nombreAnotacion
 * 
 * Utilidad para test que utilizan muchos framework basados en la api reflexion, ademas indican metadatos, añadir información adicional que un simple comentario
 *
 */
public class AnotacionesPersonalizantes {

	
	//scope  ambito-> por defecto es class pero cuando se ejecuta tiene que ser runtime
	//Se pone de la siguiente manera
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {
		Lenguaje[] value() default {};
	}

	//Tambien es necesario especificar que las anotaciones repetidas sean leidas por la jbm de la siguiente manera
	@Repeatable(value  = Lenguajes.class) //Tiene varios subtipos de Lenguaje por ello hay que ponerlo Lenguajes y si se comenta dará error 
	//No se acepta este tipo de anotacion si no esta marcada como repetible
	public @interface Lenguaje {
		String value(); //Metodo String las anotaciones son metodos que no presentan parametros
		String nombreUsuario() default "Mito";
	}
	
	//Elementos descriptivos que me indican los tipo de lenguajes 
	//1.7< 
	
	/*@Lenguajes({
		@Lenguaje("JAVA"),@Lenguaje("PHP")
	})
	*/
	//1.8> Solo se indican las anotaciones que se quieren repetir
	@Lenguaje("JAVA")
	@Lenguaje("PHP")
	public interface LenguajeProgramacion{
		
	}

	public static void main(String[] args) {

		//Forma de manipular las anotaciones creadas con Api reflexion basado en las clases
		//Se invoca al arreglo de anotaciones y el nombre de la interface.class y la anotacion de una clase en particular
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Tiene " + lenguajeArray.length +" Anotaciones en Lenguaje[]");
		
		Lenguajes lenguajes = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		for( Lenguaje lenguaje : lenguajes.value()) {
			System.out.println(lenguaje.value());
		}
		
		
	}
}
