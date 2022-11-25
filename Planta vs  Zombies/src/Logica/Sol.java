package Logica;

public class Sol {

  private Posicion pos;
  private String imagen;
  private int valor;

  public Sol(Posicion pos, String imagen) {
    this.pos = pos;
    this.imagen = imagen;
    this.valor = 50;
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
