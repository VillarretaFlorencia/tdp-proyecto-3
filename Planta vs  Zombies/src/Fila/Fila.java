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
	protected Planta [] plantas;
	protected LinkedList <Proyectil> listaProyectiles;
	
	public Fila () {
		listaZombies = new LinkedList<Zombie>();
		plantas = new Planta[9];// asumo que se crea con nulos
		listaProyectiles = new LinkedList<Proyectil>();
	}
	
	public void setZombie (Zombie z) {listaZombies.add(z);}
	
	public void setPlanta (Planta p) {
		plantas [p.getPosicion().getX()] = p;
	} // tengo plantas hasta en 9 posiciones dependiendo en la x que estoy, calculo el rango para disparar y colisiones 
	
	public void setProyectil (Proyectil p) {listaProyectiles.add(p);}
	
	public LinkedList <Zombie> getZombies() {return listaZombies;}
	
	public Planta[] getPlantas() {return plantas;}
	
	public LinkedList <Proyectil> getPrimerProyectil() {return listaProyectiles;}
	
	public void colision() {
		for (Zombie z: listaZombies) {
			Iterator<Proyectil> it = listaProyectiles.iterator();
			boolean colisionProyectil = false;
			boolean colisionPlanta = false;
			while (it.hasNext() && !colisionProyectil) {
				Proyectil p = it.next();
				if (z.getBounds().intersects(p.getBounds())) {
					colisionProyectil = true;
					p.accept(z.getVisitor());
					listaProyectiles.remove();					
				}
			}
			//pensar si visita todas las plantas  o hay un corte
			for (int i = plantas.length - 1; i >= 0 ; i--) {
				Planta p = plantas[i];
				if (p != null) {
					if (z.getBounds().intersects(p.getBounds())) {
						colisionPlanta = true;
						p.accept(z.getVisitor());					
					}
				}
			}// ya que todo se conoce con todo que el zombie solo sea el visitor y visite a los demas 
		}
	}//chequear choque de zombie planta
	//hilo planta (si en su rango aparece un zombie: crear un metodo en la clase planta que sea ataque y cree el proyectil y que vaya 
	//consultando si hay zombie en el rango que genere el proyectil), zombie, musica y general (este chequea a cada tick con chequearColisiones.
}