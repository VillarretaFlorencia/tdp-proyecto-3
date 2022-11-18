package Cronometro;

import java.util.LinkedList;

import javax.swing.JLayeredPane;

import GUI.Gameplay;
import Logica.Nivel;
import Proyectil.Proyectil;
import Zombies.HiloZombies;
import Zombies.Zombie;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	public Thread h1;
	public int n;
	private Thread hiloZombies;
	private HiloZombies misZombies;
	private Nivel nivel;
	private Gameplay ventana;
	
	public Cronometro (Gameplay v) {
		segundos = 0;
		ventana = v;
		nivel = Nivel.getNivel();
	}
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				segundos++;
				hiloZombies.start();
				nivel.moverProyectiles();
				nivel.moverZombies();
				nivel.checkColisiones();
				if (segundos % 10000 == 0) {//cambia la imagen del girasol, aumenta los soles respecto a la cantidad de girasoles, descansa, se vuelve al girasol normal
					//ventana.girasolActivo();
					Thread.sleep(1000);
					//ventana.generarSol();
					//ventana.girasolNormal();
				}
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}