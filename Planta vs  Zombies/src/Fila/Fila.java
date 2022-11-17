package Fila;

import java.util.LinkedList;
import java.util.PriorityQueue;

import Logica.Comparador;
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
			listaProyectiles.remove();
		}
		return res;
	}//chequear choque de zombie planta
	//hilo planta (si en su rango aparece un zombie: crear un metodo en la clase planta que sea ataque y cree el proyectil y que vaya 
	//consultando si hay zombie en el rango que genere el proyectil), zombie, musica y general (este chequea a cada tick con chequearColisiones.
}