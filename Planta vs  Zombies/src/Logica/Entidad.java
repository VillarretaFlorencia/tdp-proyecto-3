package Logica;

import Estados.EstadoEntidad;
import Visitores.Visitor;

public abstract class Entidad {
	public abstract int getVida();
	public abstract int getVelocidad();
	public abstract int getDanio();
	public abstract double getMultiplicador();
	public abstract EstadoEntidad getEstado();
	public abstract void recibirDanio (int danio);
	public abstract void accept (Visitor v);
}
