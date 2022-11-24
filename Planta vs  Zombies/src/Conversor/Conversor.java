package Conversor;

public class Conversor {
	//las dimensiones de cada cuadrado del jardin es 63 x 63
	protected static final int numerocuadrado=63;
	static private Conversor conversor = new Conversor();
	
	static public Conversor getConversor () {return conversor;}
	
	public int  convertirFila (int num) {
		return (int) (Math.floor(num/numerocuadrado));
	}
	public int convertirPantalla ( int numero ) {
		return numero*numerocuadrado;
	}
}

