package Cronometro;

import GUI.GUI;

public class Cronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	public Thread h1;
	//protected GUI ventana;
	
	public Cronometro (GUI ventana) {
		//this.ventana=ventana;
		segundos=0;
	}
	
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				//this.ventana.getLabel().setText("Time "+segundos);
				//System.out.println("Time "+segundos);
				segundos++;
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}


}