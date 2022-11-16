package Logica;


import java.util.LinkedList;
import java.util.PriorityQueue;

import Plantas.Planta;
import Zombies.Zombie;

public class Fila{
	protected LinkedList<Zombie> listaZombies;
	protected PriorityQueue <Planta> listaPlantas;
	protected PriorityQueue <Proyectil> listaProyectiles;
	
	public Fila () {
		listaZombies = new LinkedList<Zombie>();
		listaPlantas = new PriorityQueue(new Comparador<Planta>());
		listaProyectiles = new PriorityQueue(new Comparador<Proyectil>());
	}
	
	public void setZombie (Zombie z) {listaZombies.add(z);}
	
	public void setPlanta (Planta p) {listaPlantas.add(p);}
	
	public void setProyectil (Proyectil p) {listaProyectiles.add(p);}
	
	public LinkedList<Zombie> getZombies() {return listaZombies;}
	
	public Planta getPrimerPlanta() {
		Planta p = listaPlantas.remove();
		listaPlantas.add(p);
		return p;
	}
	
	public Proyectil getPrimerProyectil() {
		Proyectil p = listaProyectiles.remove();
		listaProyectiles.add(p);
		return p;
	}
}
