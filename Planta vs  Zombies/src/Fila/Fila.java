package Fila;

import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Describe el comportamiento de la Fila dentro del nivel
 * 
 *
 */
public class Fila {

  protected LinkedList<Zombie> listaZombies;
  protected LinkedList<Planta> listaPlantas;
  protected Planta[] plantas;
  protected LinkedList<Proyectil> listaProyectiles;

  public Fila() {
    listaZombies = new LinkedList<Zombie>();
    listaPlantas = new LinkedList<Planta>();
    listaProyectiles = new LinkedList<Proyectil>();
  }
  /**
   * Agrega una planta en la posicion brindada por la misma
   * @param planta
   */
  public void setPlanta(Planta planta) {
    listaPlantas.add(planta);
  }
  
  /**
   * Agrega un zombie en la posicion brindada por el mismo
   * @param Zombie
   */
  public void setZombie(Zombie zombie) {
    listaZombies.add(zombie);
  }
  
  /**
   * Agrega un proyectil en la posicion brindada por el mismo
   * @param Proyectil
   */
  public void setProyectil(Proyectil planta) {
    listaProyectiles.add(planta);
  }

  /**
   * Obtiene todas las plantas pertenecientes a la fila
   * @return Lista de plantas
   */
  public LinkedList<Planta> getPlantas() {
    return listaPlantas;
  }
  
  /**
   * Obtiene todas los zombies pertenecientes a la fila
   * @return Lista de plantas
   */
  public LinkedList<Zombie> getZombies() {
    return listaZombies;
  }

  /**
   * Obtiene todas los proyectiles pertenecientes a la fila
   * @return Lista de plantas
   */
  public LinkedList<Proyectil> getProyectiles() {
    return listaProyectiles;
  }

  /**
   * Elimina a la planta de dentro de la fila
   * @param planta a eliminar
   */
  public void sacarPlanta(Planta planta) {	 
	  int indice = listaPlantas.indexOf(planta);
	  if (indice >= 0)
			listaPlantas.remove(listaPlantas.indexOf(planta));
  }

  /**
   * Elimina al zombie de dentro de la fila
   * @param zombie a eliminar
   */
  public void sacarZombie(Zombie zombie) {
	  int indice = listaZombies.indexOf(zombie);
	  if (indice >= 0)
			listaZombies.remove(indice);
  }

  /**
   * Elimina al proyectil de dentro de la fila
   * @param proyectil a eliminar
   */
  public void sacarProyectil(Proyectil proyectil) {
	int indice = listaProyectiles.indexOf(proyectil);
	if (indice >= 0)
		listaProyectiles.remove(indice);
  }
  
  /**
   * Retorna un valor booleano dependiendo si hay zombies en la fila
   * @return boolean -> zombies en fila
   */
  public boolean hayZombies() {
	  LinkedList<Zombie> copiaZombies = (LinkedList<Zombie>) listaZombies.clone();
	  return !copiaZombies.isEmpty();
  }
  
  /**
   * Verifica las coliciones de los zombies entre proyectiles y plantas
   */
  public void colisiones() {
	LinkedList<Planta> copiaPlantas = (LinkedList<Planta>) listaPlantas.clone();
    LinkedList<Zombie> copiaZombies = (LinkedList<Zombie>) listaZombies.clone();
    for (Zombie zombie : copiaZombies) {
      boolean colisionPlanta = false;
      
      LinkedList<Proyectil> copiaProyectil = (LinkedList<Proyectil>) listaProyectiles.clone();
      for (Proyectil proyectil : copiaProyectil) {
        if (zombie.getBounds().intersects(proyectil.getBounds())) {
          proyectil.accept(zombie.getVisitor());
        }
      }
      
      Iterator<Planta> it = copiaPlantas.iterator();
      while (it.hasNext() && !colisionPlanta) {
        Planta planta = it.next();
        if (zombie.getBounds().intersects(planta.getBounds())) {
          colisionPlanta = true;
          planta.accept(zombie.getVisitor());

          copiaPlantas.remove(copiaPlantas.indexOf(planta));
          it = copiaPlantas.iterator();
        }
      }
    }
  } 
  
  /**
   * Elimina todos los componentes de la fila
   */
  public void limpiarFila() {
    listaZombies.clear();
    listaPlantas.clear();
    listaProyectiles.clear();
  }
  
}
