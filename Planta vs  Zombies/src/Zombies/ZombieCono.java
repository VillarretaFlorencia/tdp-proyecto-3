package Zombies;

import Estados.EstadoComiendo;
import Estados.EstadoEntidad;
import Estados.EstadoZombieNormal;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieCono extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected double multiplicador;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	
	public ZombieCono() {
		vida = 8;
		velocidad = 1;
		danio = 2;
		multiplicador = 2;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		movimiento=false;
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
	
	public void caminar() {
		movimiento = true;
	}
	public boolean enMovimiento() {
		
		return movimiento;
	}
	
	
	public void accept (Visitor v) {
		v.visit (this);
	}

}
