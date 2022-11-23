package Cronometro;

import Logica.Nivel;
import Zombies.HiloZombies;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public Thread hz;
	private HiloZombies hiloZombies;
	private Nivel nivel = Nivel.getNivel();
	private boolean terminar;
	
	
	public Cronometro () {
		hiloZombies = new HiloZombies();
		hz = new Thread (hiloZombies);
		hz.start();
		terminar = false;
	}
	
	public void run () {
		while(!terminar) {			
			terminar = nivel.moverEntidades();
			if (!terminar) {
				nivel.activarDefensa();		
				nivel.checkColisiones();
			}
		}
	}
}