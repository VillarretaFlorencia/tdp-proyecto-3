package Zombies;

import Logica.EntidadGrafica;

public class ZombieVolador extends Zombie{
	
	public ZombieVolador() {
		vida = 5;
		velocidad = 5;
		danio = 1;
		imagenNormal = "/recursos/Zombie.gif";
		imagenAtacando = "/recursos/ZombieAttack.gif";
		entidadGrafica = new EntidadGrafica(ancho, alto);
	}
}
