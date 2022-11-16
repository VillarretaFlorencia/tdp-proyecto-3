package Proyectil;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import Estados.EstadoEntidad;
import Logica.Entidad;
import Logica.Fila;
import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Proyectil extends Entidad{
	private int danio;
	private Posicion pos;
	private Nivel juego;
	private Map map;
	private String imagen;
	private boolean estado;
	
	public Proyectil(Posicion pos) {
		this.pos = pos;
		danio = 0;
		move();
	}
	
	public void atacar() {
		
	}
	//public Posicion getPosicion(Posicion p) {}

	public void move() {
		while(this.colision()!=true) {
			pos.setY(pos.getY()+1);
		}
	}

	private boolean colision() {
		Fila f = map.getFila(pos.posX());
		return f.getZombies().getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(pos.getX(), pos.getY(),50, 50);
	}

	public boolean getActividad() {
		return estado;
	}
}
