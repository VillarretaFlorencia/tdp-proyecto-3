package Proyectil;

import Posicion.Posicion;
import Visitores.Visitor;
import java.awt.Rectangle;

import Entidades.*;

public class Proyectil extends Entidad {
	int velocidad;
	
  public Proyectil(Posicion pos, String i, int d) {
	danio = d;
	velocidad = 15;
	alto = ancho = 28;
    posicion = pos;
    imagen = i;
    entidadGrafica = new EntidadGrafica(ancho, alto);
  }
  
  public void recibirDanio(int d) {}

  public void atacar() {
	posicion.setX(posicion.getX() + velocidad);
    entidadGrafica.setPosicion(posicion.getX(), posicion.getY());
  }

  public Rectangle getBounds() {
    return new Rectangle(posicion.getX(), posicion.getY(), ancho, alto);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  
  
}
