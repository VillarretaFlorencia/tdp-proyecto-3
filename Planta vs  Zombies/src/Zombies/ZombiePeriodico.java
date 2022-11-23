package Zombies;

import Estados.*;
import Logica.Posicion;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombiePeriodico extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	public ZombiePeriodico() {
		vida = 5;
		velocidad = 2;
		estado = new EstadoZombieNormal(this);
		visitor = new VisitorZombie(this);
		imagenNormal = "/recursos/NewspaperAttack.gif";
		imagenAtacando = "/recursos/NewspaperAttack.gif";
		imagen = imagenNormal;
	}
}
