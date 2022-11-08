package Cronometro;

import javax.swing.JFrame;

import GUI.GUI;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	public Thread h1;
	public int n;
	//protected JFrame ventana;
	
	public Cronometro (JFrame ventana) {
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
				if (segundos % 30 == 0) {
					//aca este metodo le avisa a la GUI que debe generar un sol
					//ventana.generarSol();
				}
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}


}