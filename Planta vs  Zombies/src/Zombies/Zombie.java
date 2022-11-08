package Zombies;

import java.awt.Rectangle;

import Estados.EstadoComiendo;
import Estados.EstadoEntidad;
import Estados.EstadoZombie;
import Logica.Entidad;
import Logica.Posicion;
import Visitores.*;

public abstract class Zombie extends Entidad{
	protected boolean movimiento;
	protected int vida;
	protected EstadoZombie estado;
	protected int danio;
	protected Posicion posicion;
	protected int velocidad;
	protected double multiplicador;

	public int getVida(){
		return vida;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion p) {
		posicion = p;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public int getDanio() {
		return danio;
	}
	public double getMultiplicador(){
		return multiplicador;
	}
	
	public EstadoEntidad getEstado() {
		return estado;
	}
	public void comer() {
		estado = new EstadoComiendo();	
	}
	public void recibirDanio (int danio) {
		vida -= danio;
		if (vida<=0) {
			//autoreMove
			//opcional que se haga desde el nivel
		} 
	}
	public void accept (Visitor v) {
		v.visit (this);
	}
	
	public void caminar () {
		movimiento = true;
	}
	public boolean enMovimiento() {
		return movimiento;
	}
	public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), 100, 200);
	}
}

