package Hilos;

import Logica.Nivel;
import Zombies.Zombie;
import java.util.LinkedList;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable {

  //Atributos de instancia
  public LinkedList<LinkedList<Zombie>> oleadas;
  protected Nivel nivel = Nivel.getNivel();
  protected boolean terminar;
  Thread hc;
  int dormir;

  public HiloZombies() {
    oleadas = nivel.getOleadas();
    dormir = 200;
    terminar = nivel.getTerminar();
  }

  public void run() {
    while (!terminar || !oleadas.isEmpty()) {
      try {
        LinkedList<Zombie> oleada = oleadas.getFirst();
        while (!oleada.isEmpty()) {
          System.out.println("oleada no vacia");
          System.out.println(oleada.size());
          Zombie zombie = oleada.remove(); // primer zombie de la lista
          nivel.setZombie(zombie);
          Thread.sleep(dormir);
        }

        oleadas.remove(oleadas.getFirst());
        Thread.sleep(60000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
