package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBalde extends Zombie{
	
		
	public ZombieBalde() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/BucketheadZombie.gif";
		imagenAtacando = "/recursos/BucketheadZombieAttack.gif";
	}
}
