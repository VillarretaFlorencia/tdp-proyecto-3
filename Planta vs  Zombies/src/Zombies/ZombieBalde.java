package Zombies;

import Logica.EntidadGrafica;

public class ZombieBalde extends Zombie{
		
	public ZombieBalde() {
		vida = 5;
		velocidad = 1;
		imagenNormal = "/recursos/BucketheadZombie.gif";
		imagenAtacando = "/recursos/BucketheadZombieAttack.gif";
		entidadGrafica = new EntidadGrafica();
	}
}
