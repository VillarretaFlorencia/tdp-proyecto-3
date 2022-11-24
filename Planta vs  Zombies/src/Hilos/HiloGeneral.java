package Hilos;

import Logica.Nivel;

public class HiloGeneral implements Runnable{
	//Atributos de instancia
	public Thread hz;
	private Nivel nivel = Nivel.getNivel();
	private boolean terminar;
	
	public HiloGeneral () {
		terminar = false;
	}
	
	public void run () {
		while(!terminar) {			
			
			terminar = nivel.moverZombies();
			if (!terminar) {
				nivel.moverProyectiles();
				nivel.activarDefensa();		
				nivel.checkColisiones();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}