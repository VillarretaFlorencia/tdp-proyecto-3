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

		LinkedList <Zombie> copiaZombies = (LinkedList<Zombie>) listaZombies.clone();
		for (Zombie z: copiaZombies) {
			boolean colisionPlanta = false;

    		LinkedList <Proyectil> copiaProyectil = (LinkedList<Proyectil>) listaProyectiles.clone();
			for (Proyectil proyectil: copiaProyectil) {
				if (z.getBounds().intersects(proyectil.getBounds())) {
					proyectil.accept(z.getVisitor());
				}
			}
			LinkedList <Planta> copiaPlantas = (LinkedList<Planta>) listaPlantas.clone();
			Iterator<Planta> it = copiaPlantas.iterator();
			while (it.hasNext() && !colisionPlanta) {
				Planta planta = it.next();
				if (z.getBounds().intersects(planta.getBounds())) {
					colisionPlanta = true;
					planta.accept(z.getVisitor());
				}
				
			}
			// ya que todo se conoce con todo que el zombie solo sea el visitor y visite a los demas 
		}
	}//chequear choque de zombie planta
	//hilo planta (si en su rango aparece un zombie: crear un metodo en la clase planta que sea ataque y cree el proyectil y que vaya 
	//consultando si hay zombie en el rango que genere el proyectil), zombie, musica y general (este chequea a cada tick con chequearColisiones.
}