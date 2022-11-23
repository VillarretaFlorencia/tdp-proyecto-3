package Cronometro;

import Logica.Nivel;
import Zombies.HiloZombies;

public class Cronometro implements Runnable{
	//Atributos de instancia
	private HiloZombies hiloZombies;
	private Nivel nivel = Nivel.getNivel();
	private boolean terminar;
	
	
	public Cronometro () {
		hiloZombies = new HiloZombies();
		terminar = false;
	}
	
	public void run () {
		while(!terminar) {
			hiloZombies.run();
			terminar = nivel.moverZombies();
			if (!terminar) {
				nivel.activarDefensa();
				nivel.moverProyectiles();			
				nivel.checkColisiones();
			}
		}
	}
}