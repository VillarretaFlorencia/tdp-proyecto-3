package Cronometro;

import java.util.LinkedList;

import javax.swing.JLayeredPane;

import GUI.Gameplay;
import Logica.Nivel;
import Plantas.HiloPlantas;
import Proyectil.Proyectil;
import Zombies.HiloZombies;
import Zombies.Zombie;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	public Thread h1;
	public int n;
	private HiloZombies hiloZombies;
	private Nivel nivel = Nivel.getNivel();
	
	
	public Cronometro () {
		segundos = 0;
		hiloZombies = new HiloZombies();
	}
	
	public void run () {
		while(true) {
			try {
<<<<<<< HEAD
				Thread.sleep(1000);
				segundos++;
				hiloZombies.run();
=======
				hiloZombies.run(); 
>>>>>>> aed03a22f8574e7d8c3d3d924184931434ce3fc1
				nivel.activarDefensa();
				nivel.moverProyectiles();
				nivel.moverZombies();
				nivel.checkColisiones();
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}