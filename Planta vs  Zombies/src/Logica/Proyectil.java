package Logica;

import java.awt.Rectangle;

public class Proyectil extends Entidad{
	private int danio;
	private Posicion pos;
	private Nivel juego;
	
	public Proyectil(Posicion pos) {
		this.pos = pos;
		danio = 0;
	}
	public void atacar() {
		
	}
	//public Posicion getPosicion(Posicion p) {}

	public void move() {
		while(this.colision()!=true) {
			pos.setX(pos.getX()+1);
		}
	}

	private boolean colision() {
		return juego.Zombie.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(pos.getX(), pos.getY(),50, 50);
	}
}
