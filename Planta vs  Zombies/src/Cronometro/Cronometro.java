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
	//protected JFrame ventana;
	private Nivel miNivel;
	private Gameplay ventana;
	
	public Cronometro (Gameplay v) {
		segundos = 0;
		ventana = v;
		miNivel = ventana.getJardin().getNivel();
	}
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				//this.ventana.getLabel().setText("Time "+segundos);
				//System.out.println("Time "+segundos);
				segundos++;
				hiloZombies.start();
				miNivel.moverProyectiles();
				miNivel.moverZombies();
				miNivel.chequearColisiones();
				chequearColisiones();
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
	
	private boolean chequearColisiones() {	
		LinkedList<Proyectil> listaProyectiles;
		listaProyectiles= miNivel.getProyectilesEnPantalla();
		LinkedList<Zombie> listaZombies;
		listaZombies = miNivel.getZombiesEnPantalla();
		
	}
}