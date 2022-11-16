package Proyectil;

import javax.swing.JFrame;

import Logica.Fila;

public class HiloProyectil implements Runnable{
	//Atributos de instancia
	protected int segundos;
	protected Thread h1;
	protected int n;
	protected Proyectil proyectil;
	protected 
	//protected JFrame ventana;
	
	public HiloProyectil() {
		//this.ventana=ventana;
		segundos = 0;
		proyectil = p;
	}
	
	public void run () {
		while(proyectil.getActividad()) {
			try {
				Thread.sleep(1000);
				//this.ventana.getLabel().setText("Time "+segundos);
				//System.out.println("Time "+segundos);
				segundos++;
				proyectil.move();
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}
