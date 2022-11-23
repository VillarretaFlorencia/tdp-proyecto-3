package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieCono extends Zombie{
	
	
	public ZombieCono() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/ConeheadZombie.gif";
		imagenAtacando = "/recursos/ConeheadZombieAttack.gif";
	}
}
