package Proyectil;

import java.awt.Rectangle;

import Fila.*;
import Logica.Entidad;
<<<<<<< HEAD
=======
import Fila.Fila;
>>>>>>> 257f9905b165b9a706678fcf0f0d85175a67cadf
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
<<<<<<< HEAD
		while(activo != true) {
			pos.setY(pos.getY()+1);
=======
		if(activo==true) {
			pos.setX(pos.getX()+1);
>>>>>>> 1377349d5a3092cf5c4da15351c6be2ff835257a
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
	@Override
	public void accept(Visitor v) {
		
	}
}
