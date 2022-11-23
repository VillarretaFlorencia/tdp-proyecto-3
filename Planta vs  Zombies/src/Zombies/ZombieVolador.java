package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieVolador extends Zombie{
	

	
	public ZombieVolador() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
	}
}
