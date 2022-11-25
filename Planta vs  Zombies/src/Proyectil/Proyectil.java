package Proyectil;

import Logica.Entidad;
import Logica.EntidadGrafica;
import Logica.Posicion;
import Visitores.Visitor;
import java.awt.Rectangle;

public class Proyectil extends Entidad {

  int ancho;
  protected int alto = ancho = 28;

  public Proyectil(Posicion pos, String i, int d) {
    posicion = pos;
    danio = d;
    imagen = i;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }

  public void atacar() {
    posicion.setX(posicion.getX() + 10);
    entidadGrafica.setPosicion(posicion.getX(), posicion.getY());
  }

  public Rectangle getBounds() {
    return new Rectangle(posicion.getX(), posicion.getY(), ancho, alto);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  @Override
  public void recibirDanio(int d) {
    // TODO Auto-generated method stub

  }
}
