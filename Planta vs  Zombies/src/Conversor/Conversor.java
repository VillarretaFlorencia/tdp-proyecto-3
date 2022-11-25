package Conversor;

public class Conversor {

  //las dimensiones de cada cuadrado del jardin es 63 x 63
  protected static final int numerocuadrado = 63;
  private static Conversor conversor = new Conversor();

  public static Conversor getConversor() {
    return conversor;
  }

  public int convertirPantalla(int numero) {
    return numero * numerocuadrado;
  }

  public int convertirFila(int num) {
    return (int) (Math.floor(num / numerocuadrado));
  }
}
