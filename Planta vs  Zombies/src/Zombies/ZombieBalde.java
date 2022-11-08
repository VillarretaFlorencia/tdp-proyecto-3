package Zombies;

import Estados.*;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBalde extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected double multiplicador;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	
	public ZombieBalde() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		multiplicador = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		movimiento = false;
		
	}
}
