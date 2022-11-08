package Logica;


public class Sol {
	private Posicion pos;
	private String imagen;
	private int valor;
	
	public Sol(Posicion pos, String imagen, int valor) {
		this.pos = pos;
		this.imagen = imagen;
		this.valor = valor;
	}
	
	public Posicion getPosicion() {
		return pos;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public int getValor() {
		return valor;
	}
}
