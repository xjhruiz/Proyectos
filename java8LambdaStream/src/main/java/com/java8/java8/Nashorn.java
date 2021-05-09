package com.java8.java8;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 
 * Motor que ejecuta sentencias javascript y hacer referencia a codigo java
 * desde javascript
 *
 *
 *
 *
 *JSF Servicios SOAP PRIMEFACES OMNIFACES
 */
public class Nashorn {

	private ScriptEngineManager m;
	private ScriptEngine e;
	// Invoca funciones de javascript
	private Invocable invocador;

	public Nashorn() {
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador = (Invocable) e;
	}

	public void llamarFunciones() throws Exception {
//		e.eval("print('JS DESDE JAVA')");
		e.eval(new FileReader("src/main/java/com/java8/java8/archivo.js"));
		// Nombre de la funcion js que se invoca y los parametros
		double res = (double) invocador.invokeFunction("calcular", 3, 4);
		int resint = (int) (res);
//		invocador.invokeFunction("calcular", 3,4);
		System.out.println(res);
		System.out.println(resint);

	}

	// Implementar codigo java en javascript
	public void implementarInterfaz() throws Exception {
		e.eval(new FileReader("src/main/java/com/java8/java8/archivo.js"));

		Object implementacion = e.get("hiloImpl");
		// De esta forma se envita tener que crear una clase anonima
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		// Con clase anonima
		Runnable ru = new Runnable() {
			@Override
			public void run() {
				e.get("hiloImpl");
			}
		};

		Thread hilo1 = new Thread(r);
		hilo1.start();
		Thread hilo2 = new Thread(r);
		hilo2.start();

		// Con clase anonima
		Thread hilo3 = new Thread(ru);
		hilo3.start();
		Thread hilo4 = new Thread(ru);
		hilo4.start();

	}

	public static void main(String[] args) throws Exception {

		Nashorn app = new Nashorn();
//		app.llamarFunciones();
		app.implementarInterfaz();
	}

}
