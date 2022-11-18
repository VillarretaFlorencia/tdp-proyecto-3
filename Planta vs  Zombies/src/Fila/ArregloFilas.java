package Fila;

import java.util.LinkedList;

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
	
	public Fila getFila (int i) {
		return arreglo[i];
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
	
	public LinkedList <Planta> getTodasLasPlantas() {
		LinkedList <Planta> plantas = new LinkedList <Planta> ();
		for (int i = 0; i < arreglo.length; i++) {
			for (Planta p: arreglo[i].getPlantas()) {
				plantas.add(p);
			}
		}
		return plantas;
	}

	
	
}