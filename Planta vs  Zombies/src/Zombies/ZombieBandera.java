package Zombies;

import Logica.EntidadGrafica;

public class ZombieBandera extends Zombie{
	
	public ZombieBandera() {
		vida = 5;
		velocidad = 5;
		danio = 1;
		imagenNormal = "/recursos/FlagZombie.gif";
		imagenAtacando = "/recursos/FlagZombieAttack.gif";
		entidadGrafica = new EntidadGrafica(ancho, alto);
	}
}
