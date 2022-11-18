package Zombies;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBandera extends Zombie{

	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	protected int identificacion;
	
	public ZombieBandera() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		estado = new EstadoZombieNormal(6);
		visitor = new VisitorZombie(this);
		movimiento = true;
		identificacion = 6;
	}
	/*public void atacar(){
		estado = new EstadoZombieComiendo(6);	
	}*/
}
