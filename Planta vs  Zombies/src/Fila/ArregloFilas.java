package Fila;

import java.util.LinkedList;

import Logica.Entidad;

import Fila.Fila;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class ArregloFilas{
	protected Fila[] arreglo;
	
	public ArregloFilas() {
		arreglo = new Fila[6];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = new Fila();
		}
	}
	
	public void setZombie(Zombie z) {
		int f = z.getPosicion().getY();
		arreglo[f].setZombie(z);
	}
	
	public void setPlanta(Planta p) {
		int f = p.getPosicion().getY();
		arreglo[f].setPlanta(p);
	}
	
	public void setProyectil(Proyectil p) {
		int f = p.getPosicion().getY();
		arreglo[f].setProyectil(p);
	}
	
	public Entidad getZombie(int f){
		Entidad zombie;
		zombie = arreglo[f-1].getPrimerZombie();
		return zombie;
	}
	
	public Entidad getPrimerPlanta(int f) {
		Entidad planta;
		planta = arreglo[f-1].getPrimerPlanta();
		return planta;
	}
	
	public Entidad getPrimerProyectil(int f) {
		Entidad proyectil;
		proyectil = arreglo[f-1].getPrimerProyectil();
		return proyectil;
	}
}