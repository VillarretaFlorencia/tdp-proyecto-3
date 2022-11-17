package Cronometro;

import javax.swing.JLayeredPane;

import GUI.Gameplay;
import Logica.Nivel;
import Zombies.HiloZombies;

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
				hiloZombies = new Thread(this.misZombies);
				hiloZombies.start();
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
	
	public boolean chequearColision() {
		
	}
	
	public void setNivel() {
		
	}


}