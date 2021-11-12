package vroom;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ListaCoches lista = ListaCoches.getListaCoches();
		lista.addCoche("aaaa", "subaru", "impreza", "azul", 100, 100, 100);
		
		int opt = opciones({"Introducir coches nuevos",
			"Listar todos los coches",
			"Listar coches de una marca",
			"Listar coches segun dos colores",
			"Calcular media CC",
			"Listar coches ordenados por sus caballos",
			"Suma del precio total",
			"Resumen por colores",
			"Borrar un coche",
			"Mostrar coches segun cilindrada",
			"Resumen rango de precios",
			"Listado de modelos de una marca y cantidad",
			"Mostrar coches ordenados segun su matricula"});
	}

	public static int opciones(String[] s) {
		// List<String> l = new List<String>();
		List<String> l = Arrays.asList(s);
		for(int i = 0; i < l.size(); i++) {
			System.out.println((i+1) + ") " + l.get(i));
		}
		System.out.println("Qué desea hacer?");
		int input = sc.nextInt();
		if(input >= 1 && input <= l.size()) {
			System.out.println(input);
			return (input - 1);
		}
		return -1;
	}


}
