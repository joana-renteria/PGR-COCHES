package vroom;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private float cc;
	private int caballos;
	private int precio;
	
	public Coche(String pMatricula) {
		setMatricula(pMatricula);
	}
	
	public Coche(String pMatricula, String pMarca, String pModelo,
			String pColor, float pCc, int pCaballos, int pPrecio) {
		setMatricula(pMatricula);
		setMarca(pMarca);
		setModelo(pModelo);
		setColor(pColor);
		setCc(pCc);
		setCaballos(pCaballos);
		setPrecio(pPrecio);
	}
	
	public void printCoche() {
		System.out.println(matricula);
		System.out.println(marca);
		System.out.println(modelo);
		System.out.println(color);
		System.out.println(cc);
		System.out.println(caballos);
		System.out.println(precio);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String pMatricula) {
		this.matricula = pMatricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String pMarca) {
		this.marca = pMarca;
	}

	public String getModelo() {
		return marca;
	}

	public void setModelo(String pModelo) {
		this.modelo = pModelo;
	}

	public float getCc() {
		return cc;
	}

	public void setCc(float pCc) {
		this.cc = pCc;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String pColor) {
		this.color = pColor;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int pCaballos) {
		this.caballos = pCaballos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int pPrecio) {
		this.precio = pPrecio;
	}
	
	public int compareCaballos(Coche pCoche) {
		return (this.caballos - pCoche.getCaballos());
	}

	public int comparePrecio(Coche pCoche) {
		return (this.precio - pCoche.getPrecio());
	}

}
