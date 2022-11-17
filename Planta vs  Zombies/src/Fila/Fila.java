package Logica;


import java.util.LinkedList;
import java.util.PriorityQueue;

import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class Fila{
	protected PriorityQueue<Zombie> listaZombies;
	protected PriorityQueue <Planta> listaPlantas;
	protected PriorityQueue <Proyectil> listaProyectiles;
	
	public Fila () {
		listaZombies = new PriorityQueue<Zombie>(new Comparador<Zombie>());
		listaPlantas = new PriorityQueue<Planta>(new Comparador<Planta>());
		listaProyectiles = new PriorityQueue<Proyectil>(new Comparador<Proyectil>());
	}
	
	public void setZombie (Zombie z) {listaZombies.add(z);}
	
	public void setPlanta (Planta p) {listaPlantas.add(p);}
	
	public void setProyectil (Proyectil p) {listaProyectiles.add(p);}
	
	public Zombie getPrimerZombie() {
		Zombie z = listaZombies.remove();
		listaZombies.add(z);
		return z;
	}
	
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
	
	public boolean colision() {
		Proyectil p = this.getPrimerProyectil();
		Zombie z = this.getPrimerZombie();
		boolean res = z.getBounds().intersects(p.getBounds());
		if (res) {
			p.accept(z.getVisitor());
		}
		return res;
	}
}