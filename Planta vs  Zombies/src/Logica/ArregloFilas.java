package Logica;

import java.util.LinkedList;

public class ArregloFilas{
	protected Fila[] arreglo;
	
	public ArregloFilas() {
		arreglo = new Fila[6];
	}
	public void setZombie(int f, Entidad e) {
		arreglo[f-1].setZombie(e);
	}
	public void setPlanta(int f, Entidad e) {
		arreglo[f-1].setPlanta(e);
	}
	public void setProyectil(int f, Entidad e) {
		arreglo[f-1].setProyectil(e);
	}
	public LinkedList getZombie(int f){
		LinkedList filaZombie;
		filaZombie = arreglo[f-1].getZombie();
		return filaZombie;
	}
	public Entidad getPlanta(int f) {
		Entidad planta;
		planta = arreglo[f-1].getPlanta();
		return planta;
	}
	public Entidad getProyectil(int f) {
		Entidad proyectil;
		proyectil = arreglo[f-1].getProyectil();
		return proyectil;
	}
}