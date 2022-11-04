package Zombies;

import Estados.*;
import Visitores.*;

public class ZombieNormal extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected double multiplicador;
	protected EstadoZombie estado;
	protected Visitor visitor;
	
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		multiplicador = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
	}
	
	public int getVida() {return vida;}
	public int getVelocidad() {return velocidad;}
	public int getDanio() {return danio;}
	public double getMultiplicador() {return multiplicador;}
	public EstadoEntidad getEstado() {return estado;}
	public void comer () {estado = new EstadoComiendo();}
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
}
