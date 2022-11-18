package Zombies;

import javax.swing.ImageIcon;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Estados.EstadoZombieComiendo;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieCono extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	
	public ZombieCono() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		estado = new EstadoZombieNormal(2);
		visitor = new VisitorZombie(this);
		movimiento = true;
	}
	
	public void atacar(){
		estado = new EstadoZombieComiendo(2);	
	}
}
