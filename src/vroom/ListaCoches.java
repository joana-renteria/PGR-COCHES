package vroom;

import java.util.ArrayList;
import java.util.Optional;

public class ListaCoches {
	
	private static ListaCoches miLista = new ListaCoches();
	private static ArrayList<Coche> coches;
	
	private ListaCoches() {
		coches = new ArrayList<Coche>();
	}
	
	public static ListaCoches getListaCoches() {
		return miLista;
	}
	
	public void addCoche(String pMatricula, String pMarca, String pModelo,
			String pColor, float pCc, int pCaballos, int pPrecio) {
		coches.add(new Coche(pMatricula, pMarca, pModelo,
				pColor,	pCc, pCaballos, pPrecio));
	}
	
	public Coche rmCoche(String pMatricula) {
		Optional<Coche> coche = coches.stream()
				.filter(p -> p.getMatricula().equals(pMatricula))
				.findFirst();
		coche.ifPresent(p -> coches.remove(p));
		return coche.get();
	}
	
	public Optional<Coche> buscarCoche(String pMatricula) {
		Optional<Coche> resultado = coches.stream()
				.filter(p -> p.getMatricula().equals(pMatricula))
				.findFirst();
		return resultado;
	}
	
	public void printCoches() {
		coches.stream()
			.forEach(Coche::printCoche);
	}
	
	public void listarPorMarca(String pMarca) {
		coches.stream()
			.filter(p -> p.getMarca().equals(pMarca))
			.forEach(Coche::printCoche);
	}

	public void listarPorColor(String pColor) {
		coches.stream()
			.filter(p -> p.getColor().equals(pColor))
			.forEach(Coche::printCoche);
	}
	
	public int countPorColor(String pColor) {
		int count = (int) coches.stream()
			.filter(p -> p.getColor().equals(pColor))
			.count();
		return count;
	}
	
	public double mediaCC() {
		double suma = coches.stream()
				.mapToDouble(Coche::getCc)
				.sum();
		int count = (int) coches.stream().count();
		return suma/count;
	}
	
	public void ordenarPorCaballos() {
		coches.stream()
			.sorted((p1, p2) -> p1.compareCaballos(p2))
			.forEach(Coche::printCoche);;
	}
	
	public double sumaPrecioTotal() {
		double resultado = coches.stream()
				.mapToDouble(Coche::getPrecio)
				.sum();
		return resultado;
	}
	
	public int countPorRangoPrecio(int min, int max) {
		int count = (int) coches.stream()
				.filter(p -> p.getPrecio() > min && p.getPrecio() < max)
				.count();
		return count;
	}
	
	public void listarMarcaModelo(String pMarca) {
		
	}
	
	public void listarPorMatriculaOrdenada() {
		coches.stream()
			.sorted((p1, p2) -> p1.comparePrecio(p2))
			.forEach(Coche::printCoche);
	}
	
}
