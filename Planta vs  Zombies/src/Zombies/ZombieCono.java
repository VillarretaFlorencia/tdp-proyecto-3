package Zombies;

import Logica.EntidadGrafica;

public class ZombieCono extends Zombie{
	
	public ZombieCono() {
		vida = 5;
		velocidad = 5;
		imagenNormal = "/recursos/ConeheadZombie.gif";
		imagenAtacando = "/recursos/ConeheadZombieAttack.gif";
		entidadGrafica = new EntidadGrafica();
	}
}
