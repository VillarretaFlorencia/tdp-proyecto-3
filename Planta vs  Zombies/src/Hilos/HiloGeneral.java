package Hilos;

import Logica.Nivel;

public class HiloGeneral implements Runnable {
	
	  //Atributos de instancia
	  private Nivel nivel = Nivel.getNivel();
	  private boolean terminar;
	
	  public HiloGeneral() {
	    terminar = nivel.getTerminar();
	  }

	  public void run() {
		    while (!nivel.getTerminar()) {
		    	nivel.activarDefensa();
		    	nivel.moverZombies();
		    	if (!terminar) {
			        nivel.moverProyectiles();
			        nivel.checkColisiones();
			        nivel.superoNivel();
			    }
		      
		      try {
		        Thread.sleep(500);
		      } catch (InterruptedException e) {e.printStackTrace();}
		    }
	  }
}
