package com.jhonatan.controlador;


import java.util.Scanner;

import com.jhonatan.modelo.Modelo;
import com.jhonatan.vista.Vista;

public class Controlador {
	Modelo modelo;
	Vista vista;
	
	public Controlador() {
		modelo = new Modelo();
		vista = new Vista();
	}
	
	public  int calcularArea(int base, int altura) {
		int area = base*altura;
		return area;
	}
	
	public  void ejecutarCalcularArea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Para calcular el área del triangulo necesito que: ");
		vista.pedirValor("Base");
		int altura= sc.nextInt();
		modelo.setAltura(altura);
		vista.pedirValor("Altura");
		int base= sc.nextInt();
		modelo.setBase(base);
		System.out.println( "**** " +vista.mostrarValor(calcularArea(altura,base))+" ******" );
		
	}
}
