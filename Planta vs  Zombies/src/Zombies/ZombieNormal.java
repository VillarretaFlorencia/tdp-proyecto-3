package Zombies;

import javax.swing.ImageIcon;

import Estados.*;
import Logica.Posicion;
import Visitores.*;

public class ZombieNormal extends Zombie{
	
	protected int vida;
	protected int velocidad;
	protected int danio;
	protected Posicion posicion;
	protected EstadoZombie estado;
	protected Visitor visitor;
	protected boolean movimiento;
	
	public ZombieNormal() {
		vida = 5;
		velocidad = 1;
		danio = 1;
		estado = new EstadoZombieNormal(0);
		visitor = new VisitorZombie(this);
		movimiento = true;
		this.setIcon(new ImageIcon(estado.getImagen()));
	}
}
