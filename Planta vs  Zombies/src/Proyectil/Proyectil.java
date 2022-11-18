package Proyectil;

import java.awt.Rectangle;

import Fila.*;
import Logica.Entidad;
import Logica.Nivel;
import Logica.Posicion;

public class Proyectil extends Entidad{
	private int vida;
	private int danio;
	private Posicion pos;
	
	public Proyectil(Posicion pos, String i) {
		this.pos = pos;
		danio = 20;
		activo = true;
		imagen = i;
	}
	
	public void move() {
		pos.setY(pos.getX()+1);
	}
	
	/*private boolean colision() {
		Fila f = arreglo.getFila(pos.posX());
		return f.getZombies().getBounds().intersects(getBounds());
	}
	*/
	public int getDanio() {
		return danio;
	}
	
	public Posicion getPosicion () {
		return pos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(pos.getX(), pos.getY(),50, 50);
	}
	public void setActivo(boolean est) {
		activo = est;
	}
	public boolean getActivo() {
		return activo;
	}
}
