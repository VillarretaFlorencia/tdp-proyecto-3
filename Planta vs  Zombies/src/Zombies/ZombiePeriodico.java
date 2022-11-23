package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombiePeriodico extends Zombie{
	
	
	
	public ZombiePeriodico() {
		vida = 5;
		velocidad = 2;
		imagenNormal = "/recursos/NewspaperAttack.gif";
		imagenAtacando = "/recursos/NewspaperAttack.gif";
	}
}
