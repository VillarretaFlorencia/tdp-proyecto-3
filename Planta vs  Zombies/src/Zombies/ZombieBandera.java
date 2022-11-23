package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBandera extends Zombie{

	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	
	public ZombieBandera() {
		vida = 5;
		velocidad = 3;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/FlagZombie.gif";
		imagenAtacando = "/recursos/FlagZombieAttack.gif";
	}
}
