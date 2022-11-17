package Fila;

import java.util.LinkedList;

import Logica.Entidad;

import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class ArregloFilas{
	protected Fila[] arreglo;
	
	public ArregloFilas() {
		arreglo = new Fila[6];
	}
	public void setZombie(int f, Zombie e) {
		arreglo[f-1].setZombie(e);
	}
	public void setPlanta(int f, Planta e) {
		arreglo[f-1].setPlanta(e);
	}
	public void setProyectil(int f, Proyectil e) {
		arreglo[f-1].setProyectil(e);
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