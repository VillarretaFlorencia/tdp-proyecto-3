package Conversor;

public class Conversor {
	//las dimensiones de cada cuadrado del jardin es 63 x 63
	protected static final int numerocuadrado = 63;
	static private Conversor conversor = new Conversor();
	
	static public Conversor getConversor () {return conversor;}
	
	/*public int  convertirFila (int num) {
		int fila = 0;
		if (num > 63 && num < 126) {
			fila = 1;
		}
		if (num > 126 && num < 189) {
			fila = 2;
		} 
		if (num > 189 && num < 252) {
			fila = 3;
		} 
		if (num >252 && num < 315) {
			fila = 4;
		} 
		if (num > 315 && num < 378) {
			fila = 5;
		} 
			
		return fila;
		
	}*/
	
	public int convertirPantalla ( int numero ) {
		return numero*numerocuadrado;
	}
	
	public int  convertirFila (int num) {
		return (int) (Math.floor(num/numerocuadrado));
	}
}

