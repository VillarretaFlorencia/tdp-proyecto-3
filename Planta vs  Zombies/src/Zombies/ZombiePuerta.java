package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombiePuerta extends Zombie{
	
		
	public ZombiePuerta() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/DoorZombie.gif";
		imagenAtacando = "/recursos/DoorZombieAttack.gif";
	}
}
