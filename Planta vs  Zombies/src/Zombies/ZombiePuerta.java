package Zombies;

import Logica.EntidadGrafica;

public class ZombiePuerta extends Zombie{
	
	public ZombiePuerta() {
		vida = 5;
		velocidad = 5;
		danio = 1;
		imagenNormal = "/recursos/DoorZombie.gif";
		imagenAtacando = "/recursos/DoorZombieAttack.gif";
		entidadGrafica = new EntidadGrafica(ancho, alto);
	}
}
