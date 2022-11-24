package Conversor;

public class Conversor {
protected  int numerocuadrado;

public Conversor (int numeroCuadrado ) {
	numerocuadrado= numeroCuadrado;
}
public int  convertirFila (int num) {
	return (int) (Math.floor(num/63));
}
public int convertirPantalla ( int numero ) {
	return numero*63;
}
}

