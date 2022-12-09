package Fila;

import Conversor.Conversor;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;
import java.util.LinkedList;
/**
 * Esta clase define el comportamiento de las filas en conjunto dentro del nivel
 * 
 *
 */
public class ArregloFilas {

  protected Fila[] arregloFilas;
  Conversor conversor = Conversor.getConversor();

  public ArregloFilas() {
    arregloFilas = new Fila[6];
    for (int i = 0; i < arregloFilas.length; i++) {
      arregloFilas[i] = new Fila();
    }
  }
/**
 * Agrega una planta en la posicion brindada por la misma
 * @param planta
 */
  public void setPlanta(Planta planta) {
    int fila = planta.getPosicion().getY();
    arregloFilas[conversor.convertirFila(fila)].setPlanta(planta);
  }
  /**
   * Agrega un zombie en la posicion brindada por el mismo
   * @param Zombie
   */
  public void setZombie(Zombie zombie) {
    int fila = zombie.getPosicion().getY();
    arregloFilas[conversor.convertirFila(fila)].setZombie(zombie);
  }
  
  /**
   * Agrega un proyectil en la posicion brindada por el mismo
   * @param Proyectil
   */
  public void setProyectil(Proyectil proyectil) {
    int fila = proyectil.getPosicion().getY();
    arregloFilas[conversor.convertirFila(fila)].setProyectil(proyectil);
  }
  
  /**
   * Obtiene la fila de la posicion deseada
   * @param Posicion de la fila
   * @return Fila
   */
  public Fila getFila(int i) {
    return arregloFilas[i];
  }
  
  /**
   * Retorna una lista con todos los zombies pertenecientes a todas todas las filas
   * @return
   */
  public LinkedList<Zombie> getTodosLosZombies() {
    LinkedList<Zombie> zombies = new LinkedList<Zombie>();
    for (int i = 0; i < arregloFilas.length; i++) {
      for (Zombie zombie : arregloFilas[i].getZombies()) {
        zombies.add(zombie);
      }
    }
    return zombies;
  }
}
