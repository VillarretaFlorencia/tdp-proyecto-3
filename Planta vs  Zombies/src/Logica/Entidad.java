package Logica;

import java.awt.Rectangle;

public abstract class Entidad {

  protected Posicion posicion;
  protected int danio;
  protected EntidadGrafica entidadGrafica;
  protected String imagen;
  protected int ancho;
  protected int alto;

  public abstract Rectangle getBounds();

  public EntidadGrafica getEntidadGrafica() {
    return entidadGrafica;
  }

  public String getImagen() {
    return imagen;
  }

  public void setPosicion(Posicion p) {
    posicion = p;
  }

  public Posicion getPosicion() {
    return posicion;
  }

  public abstract void atacar();

  public int getDanio() {
    return danio;
  }

  public abstract void recibirDanio(int d);

  public void inicializarEntidadGrafica(String imagen, Posicion posicion) {
    entidadGrafica.setImagen(imagen);
    entidadGrafica.setPosicion(posicion.getX(), posicion.getY());
  }
}
