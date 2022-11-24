package Fila;

import java.util.LinkedList;

import Conversor.Conversor;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class ArregloFilas{
	protected Fila[] arreglo;
	Conversor conversor = Conversor.getConversor();
	
	public ArregloFilas() {
		arreglo = new Fila[6];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = new Fila();
		}
	}
	
	public Fila getFila (int i) {
		return arreglo[i];
	}
	
	public void setZombie(Zombie z) {
		int f = z.getPosicion().getY();
		arreglo[conversor.convertirFila(f)].setZombie(z);
	}
	
	public void setPlanta(Planta p) {
		int f = p.getPosicion().getY();
		arreglo[conversor.convertirFila(f)].setPlanta(p);
	}
	
	public void setProyectil(Proyectil p) {
		int f = p.getPosicion().getY();
		arreglo[conversor.convertirFila(f)].setProyectil(p);
	}
	
	public LinkedList <Planta> getTodasLasPlantas() {
		LinkedList <Planta> plantas = new LinkedList <Planta> ();
		for (int i = 0; i < arreglo.length; i++) {
			for (Planta p: arreglo[i].getPlantas()) {
				plantas.add(p);
			}
		}
		return plantas;
	}
	
	public LinkedList <Zombie> getTodosLosZombies() {
		LinkedList <Zombie> zombies = new LinkedList <Zombie> ();
		for (int i = 0; i < arreglo.length; i++) {
			for (Zombie z: arreglo[i].getZombies()) {
				zombies.add(z);
			}
		}
		return zombies;
	}

//Algoritmo 	
}
//Conversion modulo 6