package Proyectil;

import java.awt.Rectangle;

import Fila.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;

public class Proyectil extends Entidad{
	private int danio;
	
	public Proyectil(Posicion pos, String i, int d) {
		posicion = pos;
		danio = d;
		imagen = i;
	}
	
	public void move() {
		posicion.setX(posicion.getX()+1);
	}
	
	/*private boolean colision() {
		Fila f = arreglo.getFila(pos.posX());
		return f.getZombies().getBounds().intersects(getBounds());
	}
	*/
	public int getDanio() {
		return danio;
	}
	
	public void recibirDanio (int d) {}
	
	
	public Rectangle getBounds() {
		return new Rectangle(posicion.getX(), posicion.getY(),50, 50);
	}
	
}
