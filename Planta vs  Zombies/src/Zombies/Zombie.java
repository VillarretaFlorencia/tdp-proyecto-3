package Zombies;

import java.awt.Image;
import java.awt.Rectangle;

import Estados.EstadoComiendo;
import Estados.EstadoEntidad;
import Estados.EstadoZombie;
import Logica.Entidad;
import Logica.Posicion;
import Visitores.*;

public abstract class Zombie extends Entidad{
	//Atributos
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	
	//Setters & Getters
	public int getVida(){
		return vida;
	}
	public int getVelocidad(){
		return velocidad;
	}
	public int getDanio(){
		return danio;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion p) {
		posicion = p;
	}
	public EstadoEntidad getEstado() {
		return estado;
	}
	public void setEstado(EstadoZombie e) {
		estado = e;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setMovimiento(boolean mov) {
		movimiento = mov;
	}
	
	//Metodos propios
	public void recibirDanio (int danio) {
		vida -= danio;
	}
	public void move() {
		posicion.setX(posicion.getX()-1);
	}
	public void atacar() {
		estado = new EstadoAtacando();	
	}	
	public Rectangle getBounds() {
		return new Rectangle(getPosicion().getX(), getPosicion().getY(), 60, 60);
	}
	public boolean enMovimiento() {
		return movimiento;
	}
	
}

