package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.*;

public class ZombieNormal extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imageNormal;
	protected String imageAtacando;
	
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		imageNormal = "/recursos/ZombieAttack.gif";
		imageAtacando = "/recursos/ZombieAttack.gif";
	}
	
	/*public void atacar(){
		estado = new EstadoZombieComiendo(0);	
	}*/
}
