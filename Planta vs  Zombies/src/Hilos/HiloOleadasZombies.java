package Hilos;

import Logica.Nivel;
import Zombies.Zombie;
import java.util.LinkedList;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloOleadasZombies implements Runnable {

  //Atributos de instancia
  public LinkedList<LinkedList<Zombie>> oleadas;
  protected Nivel nivel = Nivel.getNivel();
  protected boolean terminar;
  int dormir;

  public HiloOleadasZombies() {
    oleadas = nivel.getOleadas();
    dormir = 3000;
    terminar = nivel.getTerminar();
  }

  public void run() {
    while (!terminar && !oleadas.isEmpty()) {
      try {
    	nivel.setCantOleadas(oleadas.size());
        LinkedList<Zombie> oleada = oleadas.getFirst();
        while (!oleada.isEmpty()) {
          Zombie zombie = oleada.remove(); 
          nivel.setZombie(zombie);
          Thread.sleep(dormir);
        }
        oleadas.remove(oleadas.getFirst());
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
