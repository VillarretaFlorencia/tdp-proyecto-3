package Cronometro;

import AudioMusic.AudioPlayer;
import Logica.Nivel;
import Zombies.HiloZombies;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public Thread hz;
	private Nivel nivel = Nivel.getNivel();
	private boolean terminar;
	
	public Cronometro () {
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