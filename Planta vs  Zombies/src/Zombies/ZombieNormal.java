package Zombies;

import Logica.EntidadGrafica;

public class ZombieNormal extends Zombie{
		
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
		entidadGrafica = new EntidadGrafica(ancho, alto);
	}
}
