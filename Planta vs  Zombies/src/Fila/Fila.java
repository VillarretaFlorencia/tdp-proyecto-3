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
	} 
	
	public boolean hayLugar (int x) {
		return plantas[x] == null;
	}

	public Planta plantaEnPos(int x) {return plantas[x];}
	
	public void setProyectil (Proyectil p) {listaProyectiles.add(p);}
	
	public LinkedList <Zombie> getZombies() {return listaZombies;}
	
	public LinkedList <Planta> getPlantas() {
		LinkedList <Planta> plan = new LinkedList <Planta>();
		for (int i = 0; i < plantas.length; i++) {
			Planta p = plantas[i];
			if (p != null) {
				plan.add(p);
			}
		}
		return plan;}
	
	public LinkedList <Proyectil> getProyectiles() {return listaProyectiles;}
	
	public void colisiones() {
		for (Zombie z: listaZombies) {
			Iterator<Proyectil> it = listaProyectiles.iterator();
			boolean colisionProyectil = false;
			boolean colisionPlanta = false;
			while (it.hasNext()) {
				Proyectil p = it.next();
				if (z.getBounds().intersects(p.getBounds())) {
					//colisionProyectil = true;
					//aca tiene que ir el accept!!
					listaProyectiles.remove();	//desde visitor
				}
			}
			for (int i = plantas.length - 1; i >= 0 && !colisionPlanta; i--) {
				Planta p = plantas[i];
				if (p != null) {
					if (z.getBounds().intersects(p.getBounds())) {
						colisionPlanta = true;
						z.getVisitor().visit (p);
						//aca iria el otro accept
						if (p.getVida() <= 0)
							plantas[i] = null;//esto llamarlo desde visitor t
					}
				}
			}// ya que todo se conoce con todo que el zombie solo sea el visitor y visite a los demas 
		}
	}//chequear choque de zombie planta
	//hilo planta (si en su rango aparece un zombie: crear un metodo en la clase planta que sea ataque y cree el proyectil y que vaya 
	//consultando si hay zombie en el rango que genere el proyectil), zombie, musica y general (este chequea a cada tick con chequearColisiones.
}