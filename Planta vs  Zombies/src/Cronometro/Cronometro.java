package Cronometro;

import AudioMusic.AudioPlayer;
import Logica.Nivel;
import Zombies.HiloZombies;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public Thread hz;
	private HiloZombies hiloZombies;
	private Nivel nivel = Nivel.getNivel();
	private boolean terminar;
	private AudioPlayer ap;
	private Thread audio;
	private long milisegundos;
	
	public Cronometro () {
		audioOn();
		hiloZombies = new HiloZombies();
		hz = new Thread (hiloZombies);
		hz.start();
		terminar = false;
		milisegundos=0;
	}
	
	public void run () {
		while(!terminar) {			
			terminar = nivel.moverEntidades();
			if(milisegundos % 88000==0)
				audio.start();
			if (!terminar) {
				nivel.activarDefensa();		
				nivel.checkColisiones();
			}
			milisegundos++;
		}
	}
	private void audioOn() {
		ap = new AudioPlayer("/Planta vs  Zombies/src/recursos/MusicaPlantas.mp3");
		audio = new Thread(ap);
		
	}
}