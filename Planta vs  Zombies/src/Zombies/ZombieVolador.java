package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieVolador extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	
	public ZombieVolador() {
		vida = 5;
		velocidad = 1;
		estado = new EstadoZombieNormal(this);
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
		imagen = imagenNormal;
	}
}
