package Hilos;

import Logica.Nivel;

public class HiloGeneral implements Runnable {

  //Atributos de instancia
  public Thread hz;
  private Nivel nivel = Nivel.getNivel();
  private boolean terminar;

  public HiloGeneral() {
    terminar = nivel.getTerminar();
  }

  public void run() {
    while (!nivel.getTerminar()) {
      nivel.moverZombies();
      if (!terminar) {
        nivel.moverProyectiles();
        nivel.activarDefensa();
        nivel.checkColisiones();
        nivel.superoJuego();
      }
      
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
