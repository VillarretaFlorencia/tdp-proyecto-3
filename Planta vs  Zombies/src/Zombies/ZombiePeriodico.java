package Zombies;

import Logica.EntidadGrafica;

public class ZombiePeriodico extends Zombie{
	
	public ZombiePeriodico() {
		vida = 5;
		velocidad = 5;
		imagenNormal = "/recursos/NewspaperAttack.gif";
		imagenAtacando = "/recursos/NewspaperAttack.gif";
		entidadGrafica = new EntidadGrafica(ancho, alto);
	}
}
