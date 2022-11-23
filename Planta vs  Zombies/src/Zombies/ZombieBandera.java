package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieBandera extends Zombie{
	
	public ZombieBandera() {
		vida = 5;
		velocidad = 3;
		imagenNormal = "/recursos/FlagZombie.gif";
		imagenAtacando = "/recursos/FlagZombieAttack.gif";
	}
}
