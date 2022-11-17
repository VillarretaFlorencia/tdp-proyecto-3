package Proyectil;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import Fila.*;
import Estados.EstadoEntidad;
import Logica.Entidad;
import Fila.Fila;
import Logica.Nivel;
import Logica.Posicion;
import Visitores.Visitor;

public class Proyectil extends Entidad{
	private int danio;
	private Posicion pos;
	private Nivel juego;
	private ArregloFilas arreglo;
	private String imagen;
	private boolean activo;
	
	public Proyectil(Posicion pos) {
		this.pos = pos;
		danio = 20;
		activo = true;
	}
	
	public void move() {
		while(activo!=true) {
			pos.setY(pos.getY()+1);
		}
	}

	/*private boolean colision() {
		Fila f = arreglo.getFila(pos.posX());
		return f.getZombies().getBounds().intersects(getBounds());
	}
	*/
	public int getDanio() {
		return danio;
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
	@Override
	public void accept(Visitor v) {
		
	}
}
