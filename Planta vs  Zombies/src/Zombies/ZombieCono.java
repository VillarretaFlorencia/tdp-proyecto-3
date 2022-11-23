package Zombies;

import Estados.EstadoZombieNormal;
import Logica.Posicion;
import Estados.EstadoZombie;
import Visitores.Visitor;
import Visitores.VisitorZombie;

public class ZombieCono extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	protected String imagenNormal;
	protected String imagenAtacando;
	
	public ZombieCono() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		estado = new EstadoZombieNormal();
		visitor = new VisitorZombie(this);
		movimiento = true;
		imagenNormal = "/recursos/ConeheadZombie.gif";
		imagenAtacando = "/recursos/ConeheadZombieAttack.gif";
	}
	
	/*public void atacar(){
		estado = new EstadoZombieComiendo(2);	
	}*/
}
