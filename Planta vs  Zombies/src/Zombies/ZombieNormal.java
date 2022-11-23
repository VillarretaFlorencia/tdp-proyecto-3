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
	protected String imagenNormal;
	protected String imagenAtacando;
	
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		estado = new EstadoZombieNormal(this);
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
		imagen = imagenNormal;
	}
}
