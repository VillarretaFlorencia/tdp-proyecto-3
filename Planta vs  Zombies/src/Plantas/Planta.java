package Plantas;

import Conversor.Conversor;
import Entidades.*;
import Logica.Nivel;
import Posicion.Posicion;
import Proyectil.Proyectil;
import Visitores.*;
import Zombies.Zombie;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Planta extends Entidad {

  protected int vida = 5;
  protected int danio = 0;
  protected int velocidad = 0;
  protected int alto = 72;
  protected int ancho = 70;
  protected int tiempoActual;
  protected int tiempoDeAtaque;
  protected String imagenProyectil;
  Conversor conversor = Conversor.getConversor();

  Nivel nivel = Nivel.getNivel();
  
  public int getVida() {return vida;}
  
  public void recibirDanio(int d) {
    vida = vida - d;
  }
  
  public void atacar() {
    if (hayZombiesEnRango()) {
      if (tiempoActual % tiempoDeAtaque == 0) {
    	Posicion posicionProyectil = new Posicion(posicion.getX()+40, posicion.getY()+10);
        Proyectil proyectil = new Proyectil(posicionProyectil, imagenProyectil, danio);
        proyectil.inicializarEntidadGrafica(imagenProyectil, posicionProyectil);
        nivel.setProyectil(proyectil);
      }
    }
    tiempoActual++;
  }
  
  public Rectangle getBounds() {
    return new Rectangle(getPosicion().getX(),getPosicion().getY(),ancho,alto);
  }
  
  public void accept(Visitor v) {
    v.visit(this);
  }
  
  public boolean hayZombiesEnRango() {
    int pos = conversor.convertirFila(posicion.getY());
    LinkedList<Zombie> copiaZombies = (LinkedList<Zombie>) nivel.getFilas().getFila(pos).getZombies().clone();
    Iterator<Zombie> it = copiaZombies.iterator();
    boolean hayEnRango = false;
    while (it.hasNext() && !hayEnRango) {
      Zombie zombie = it.next();
      hayEnRango = zombie.getPosicion().getX() >= (posicion.getX()) && zombie.getPosicion().getX() < nivel.getLimiteDerecho(); //esta en el rango
    }
    return hayEnRango;
  }
  
  

}
