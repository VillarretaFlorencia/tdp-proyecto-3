package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombiePuerta extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	
	public ZombiePuerta() {
		vida = 5;
		velocidad = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/DoorZombie.gif";
		imagenAtacando = "/recursos/DoorZombieAttack.gif";
		
	}
	
	/*public void atacar(){
		estado = new EstadoZombieComiendo(4);	
	}*/
}
