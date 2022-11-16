package Cronometro;

import GUI.Gameplay;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	public Thread h1;
	public int n;
	//protected JFrame ventana;
	
	public Cronometro (Gameplay ventana) {
		//this.ventana=ventana;
		segundos = 0;
	}
	
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				//this.ventana.getLabel().setText("Time "+segundos);
				//System.out.println("Time "+segundos);
				segundos++;
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