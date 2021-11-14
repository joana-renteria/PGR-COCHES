package vroom;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static ListaCoches lista = ListaCoches.getListaCoches();

	public static void main(String[] args) {
		lista.addCoche("aaaa", "Subaru", "Impreza", "Azul", 200, 100, 60000);
		lista.addCoche("6666", "Subaru", "Impreza", "Rojo", 200, 100, 50000);
		lista.addCoche("miau", "Subaru", "Impreza", "Verde", 200, 100, 50000);
		lista.addCoche("asdf", "Mercedes", "Impreza", "Gris", 0, 500, 100000);
		lista.addCoche("abcd", "Audi", "A3", "Rojo", 300, 300, 80000);
		lista.addCoche("uwu6", "Lada", "VFTS", "Rosa", 100, 200, 70000);

		String opts[] = {"Introducir coches nuevos",
					"Listar todos los coches",
					"Listar coches de una marca",
					"Listar coches segun dos colores",
					"Calcular media CC",
					"Listar coches ordenados por sus caballos",
					"Suma del precio total",
					"Resumen por colores",
					"Borrar un coche",
					//"Mostrar coches segun cilindrada",
					"Resumen rango de precios",
					//"Listado de modelos de una marca y cantidad",
			"Mostrar coches ordenados segun su matricula",
			"Salir"};

		boolean continuar = true;
		while(continuar) {
			int opcion = opciones(opts);
			String input = null;
			switch (opcion) {
			case 1:
				addCoches();
				break;
			case 2:
				lista.printCoches();
				break;
			case 3:
				System.out.println("Introduce la marca:");
				input = sc.next();
				lista.listarPorMarca(input);
				break;
			case 4:
				System.out.println("Introduce un color:");
				input = sc.next();
				System.out.println("Introduce otro color:");
				String auxInput = sc.next();
				lista.listarPorColor(input);
				lista.listarPorColor(auxInput);
				break;
			case 5:
				System.out.println(lista.mediaCC());
				break;
			case 6:
				lista.ordenarPorCaballos();
				break;
			case 7:
				System.out.println(lista.sumaPrecioTotal());
				break;
			case 8:
				resumenColores();
				break;
			case 9:
				System.out.println("Introduce matricula del coche a borrar:");
				input = sc.next();
				lista.rmCoche(input);
				break;
			case 10:
				lista.countPorRangoPrecio(0, 1000);
				lista.countPorRangoPrecio(1001, 5000);
				lista.countPorRangoPrecio(5001, 10000);
				lista.countPorRangoPrecio(10000, Integer.MAX_VALUE);
				break;
			case 11:
				lista.listarPorMatriculaOrdenada();
				break;
			case 12:
				
			default:
				continuar = false;
				break;
			}
		}
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
			return (input);
		}
		return -1;
	}

	public static void addCoches() {
		boolean continuar = true;
		//bucle para introducir coches
		do {
			System.out.println("Introducir matricula: ");
			String input = sc.next();
			Optional<Coche> cochecito = lista.buscarCoche(input);
			if(!cochecito.isPresent()) {
				System.out.println("El coche no existe, añade uno:");
				//atribs
				System.out.println("Matricula: " + input);
				String matricula = input;
				System.out.println("Marca:");
				String marca = sc.next();
				System.out.println("Modelo:");
				String modelo = sc.next();
				System.out.println("Color:");
				String color = sc.next();
				System.out.println("CC:");
				float cc = sc.nextFloat();
				System.out.println("Caballos:");
				int caballos = sc.nextInt();
				System.out.println("Precio:");
				int precio = sc.nextInt();
				//añadir el coche con los atribs
				lista.addCoche(matricula, marca, modelo, color, cc, caballos, precio);
			} else {
				System.out.println("El coche ya existe!");
			}
			System.out.println("Desea añadir mas coches? (s/n)");
			input = sc.next();
			if(!input.equals("s"))
				continuar = false;
		}while(continuar);
	}

	private static void resumenColores() {
		String colores[] = {
				"Rojo",
				"Azul",
				"Verde",
				"Negro",
				"Blanco",
				"Gris",
				"Morado",
				"Turquesa",
				"Marron",
				"Rosa",
				"Amarillo",
				"Magenta",
				"Lima",
				"Crema",
		};
		for(String x : colores) {
			System.out.println("Coches del color " + x + ": "
								+ lista.countPorColor(x));
		}
	}

}
