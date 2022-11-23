package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.*;

public class ZombieNormal extends Zombie{
	
	
	
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
	}
}
