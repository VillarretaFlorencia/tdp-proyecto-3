package Fila;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;



import Logica.Comparador;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;

public class Fila{
	protected LinkedList <Zombie> listaZombies;
	protected LinkedList <Planta> listaPlantas;
	protected Planta [] plantas;
	protected LinkedList <Proyectil> listaProyectiles;
	
	public Fila () {
		listaZombies = new LinkedList<Zombie>();
		listaPlantas = new LinkedList<Planta>();
		listaProyectiles = new LinkedList<Proyectil>();
	}
	
	public void setZombie (Zombie z) {listaZombies.add(z);}	
	
	public void setPlanta (Planta p) {
		listaPlantas.add (p);
	} 
	
	public void setProyectil (Proyectil p) {listaProyectiles.add(p);}
	
	
	public LinkedList <Zombie> getZombies() {return listaZombies;}
	
	public LinkedList <Planta> getPlantas() {return listaPlantas;}
	
	public LinkedList <Proyectil> getProyectiles() {return listaProyectiles;}
	
	public void sacarZombie (Zombie z) {
		listaZombies.remove(listaZombies.indexOf(z));
	}
	
	public void sacarPlanta(Planta p) {
		listaPlantas.remove(listaPlantas.indexOf(p));
	}
	
	public void sacarProyectil (Proyectil p) {
		listaProyectiles.remove(listaProyectiles.indexOf(p));
	}
	
	public void limpiarFila() {
		listaZombies.clear();
		listaPlantas.clear();
		listaProyectiles.clear();
	}
	
	public void colisiones() {
		for (Zombie z: listaZombies) {
			boolean colisionPlanta = false;
			for (Proyectil p: listaProyectiles) {
				if (z.getBounds().intersects(p.getBounds())) {
					p.accept(z.getVisitor());
					//listaProyectiles.remove();	//desde visitor
				}
			}
			
			Iterator<Planta> it = listaPlantas.iterator();
			while (it.hasNext() && !colisionPlanta) {
				Planta p = it.next();
				if (z.getBounds().intersects(p.getBounds())) {
					colisionPlanta = true;
					p.accept(z.getVisitor());
					//if (p.getVida() <= 0)
						//plantas[i] = null;//esto llamarlo desde visitor t
				}
				
			}
			// ya que todo se conoce con todo que el zombie solo sea el visitor y visite a los demas 
		}
	}//chequear choque de zombie planta
	//hilo planta (si en su rango aparece un zombie: crear un metodo en la clase planta que sea ataque y cree el proyectil y que vaya 
	//consultando si hay zombie en el rango que genere el proyectil), zombie, musica y general (este chequea a cada tick con chequearColisiones.
}