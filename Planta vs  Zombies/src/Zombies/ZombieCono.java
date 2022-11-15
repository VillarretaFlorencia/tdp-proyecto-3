package Zombies;

import Estados.EstadoComiendo;
import Estados.EstadoEntidad;
import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieCono extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
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
}
