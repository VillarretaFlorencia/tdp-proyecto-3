package Zombies;

import Estados.EstadoEntidad;
import Logica.Entidad;
import Visitores.*;

public abstract class Zombie extends Entidad{

	public abstract int getVida();
	public abstract int getVelocidad();
	public abstract int getDanio();
	public abstract double getMultiplicador();
	public abstract EstadoEntidad getEstado();
	public abstract void comer();
	public abstract void recibirDanio (int danio);
	public abstract void accept (Visitor v);
}
