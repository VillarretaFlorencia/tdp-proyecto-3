package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBalde extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	
	public ZombieBalde() {
		vida = 5;
		velocidad = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/BucketheadZombie.gif";
		imagenAtacando = "/recursos/BucketheadZombieAttack.gif";
	}
}
