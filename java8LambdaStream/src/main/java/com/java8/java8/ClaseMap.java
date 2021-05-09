package com.java8.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
 
public class ClaseMap {

	private Map<Integer, String> map;

	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Leyenda");
		map.put(2, "Mito");
		map.put(3, "Aventura");
		map.put(4, "Historia");
	}

	public void imprimirv7() {
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println("LLAVE : " + e.getKey() + " VALOR  " + e.getValue());
		}
	}

	public void imprimirv8() {
//		map.forEach((k,v) -> System.out.println("LLAVE : " + k  + " VALOR  " + v ));
		//Con stream
		map.entrySet().stream().forEach(System.out::println);
	}

	public void recolectar() {
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter( e->e.getValue().contains("en"))
				.collect(Collectors.toMap(p -> p.getKey() , p-> p.getValue()));
		mapaRecolectado.forEach((k,v)-> System.out.println("LLAVE : " + k + " VALOR  " + v));

	}

	public void insertarSiAusente() {
		map.putIfAbsent(2, "Cuento");
	}

	public void operarSiPresente() {
		map.computeIfPresent(3, (k,v) -> k +v);
		System.out.println(map.get(3));
	}

	public void obtenerOrPredeterminado() {
		String valor = map.getOrDefault(5, "Por defecto");
		System.out.println(valor);
	}

	public static void main(String[] args) {

		ClaseMap app = new ClaseMap();
		app.poblar();
//		app.imprimirv7();
//		app.insertarSiAusente();
//		app.operarSiPresente();
		app.obtenerOrPredeterminado();
		app.recolectar();
		app.imprimirv8();
	}

}
